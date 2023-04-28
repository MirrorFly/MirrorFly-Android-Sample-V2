package com.contusfly.chat.reply

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.adapters.holders.*
import com.contusfly.chat.AndroidUtils
import kotlin.math.abs

class MessageSwipeController(private val context: Context, private val swipeControllerActions: SwipeControllerActions) :
        ItemTouchHelper.Callback() {

    private lateinit var imageDrawable: Drawable
    private lateinit var shareRound: Drawable

    private var currentItemViewHolder: RecyclerView.ViewHolder? = null
    private lateinit var mView: View
    private var dX = 0f

    private var replyButtonProgress: Float = 0.toFloat()
    private var lastReplyButtonAnimationTime: Long = 0
    private var swipeBack = false
    private var isVibrate = false
    private var startTracking = false

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        mView = viewHolder.itemView
        imageDrawable = ContextCompat.getDrawable(context, R.drawable.swipe_reply_icon)!!
        shareRound = ContextCompat.getDrawable(context, R.drawable.swipe_rounded_background_black)!!
        return makeMovementFlags(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.RIGHT)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                        target: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        /*
        * Method not implemented
        */
    }

    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
        if (swipeBack) {
            swipeBack = false
            return 0
        }
        return super.convertToAbsoluteDirection(flags, layoutDirection)
    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                             dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        when (viewHolder) {
            is NotificationViewHolder -> {
                if (viewHolder.notificationView.visibility == View.VISIBLE)
                    return
            }
            is TextSentViewHolder -> {
                if (!viewHolder.isSentMessage)
                    return
                if (viewHolder.isRecallMessage)
                    return
            }
            is TextReceivedViewHolder -> {
                if (viewHolder.isRecallMessage)
                    return
            }
            is ImageSentViewHolder, is VideoSentViewHolder, is LocationSentViewHolder,
            is AudioSentViewHolder, is FileSentViewHolder, is ContactSentViewHolder -> {
                if (!(viewHolder as SenderNameHolder).isSentMessage)
                    return
            }
        }

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            setTouchListener(recyclerView, viewHolder)
            currentItemViewHolder = viewHolder
            drawReplyButton(c)

        }

        if (mView.translationX < convertToDp(70) || dX < this.dX) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            this.dX = dX
            startTracking = true
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setTouchListener(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        recyclerView.setOnTouchListener { _, event ->
            swipeBack = event.action == MotionEvent.ACTION_CANCEL || event.action == MotionEvent.ACTION_UP
            if (swipeBack && abs(mView.translationX) >= this@MessageSwipeController.convertToDp(70))
                swipeControllerActions.showSwipeInReplyUI(viewHolder.layoutPosition)
            false
        }
    }

    private fun drawReplyButton(canvas: Canvas) {
        if (currentItemViewHolder == null) {
            return
        }
        val translationX = mView.translationX
        val newTime = System.currentTimeMillis()
        val dt = Math.min(17, newTime - lastReplyButtonAnimationTime)
        lastReplyButtonAnimationTime = newTime
        val showing = translationX >= convertToDp(30)
        handleReplybtnprogress(showing, translationX, dt)
        val alpha: Int
        val scale: Float
        if (showing) {
            scale = if (replyButtonProgress <= 0.8f) {
                1.2f * (replyButtonProgress / 0.8f)
            } else {
                1.2f - 0.2f * ((replyButtonProgress - 0.8f) / 0.2f)
            }
            alpha = Math.min(255f, 255 * (replyButtonProgress / 0.8f)).toInt()
        } else {
            scale = replyButtonProgress
            alpha = Math.min(255f, 255 * replyButtonProgress).toInt()
        }
        shareRound.alpha = alpha

        imageDrawable.alpha = alpha
        if (startTracking && !isVibrate && mView.translationX >= convertToDp(70)) {
            //mView.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING)
            isVibrate = true
        }

        val x: Int = if (mView.translationX > convertToDp(100)) {
            convertToDp(130) / 2
        } else {
            (mView.translationX / 2).toInt()
        }

        val y = (mView.top + mView.measuredHeight / 2).toFloat()
        shareRound.colorFilter =
                PorterDuffColorFilter(ContextCompat.getColor(context, R.color.text_black_light), PorterDuff.Mode.MULTIPLY)

        shareRound.setBounds((x - convertToDp(18) * scale).toInt(),
                (y - convertToDp(18) * scale).toInt(),
                (x + convertToDp(18) * scale).toInt(),
                (y + convertToDp(18) * scale).toInt())
        shareRound.draw(canvas)
        imageDrawable.setBounds((x - convertToDp(12) * scale).toInt(),
                (y - convertToDp(11) * scale).toInt(),
                (x + convertToDp(12) * scale).toInt(),
                (y + convertToDp(10) * scale).toInt())
        imageDrawable.draw(canvas)
        shareRound.alpha = 255
        imageDrawable.alpha = 255
    }

    private fun handleReplybtnprogress(showing: Boolean, translationX: Float, dt: Long) {
        if (showing) {
            if (replyButtonProgress < 1.0f) {
                replyButtonProgress += dt / 180.0f
                if (replyButtonProgress > 1.0f) {
                    replyButtonProgress = 1.0f
                } else {
                    mView.invalidate()
                }
            }
        } else if (translationX <= 0.0f) {
            replyButtonProgress = 0f
            startTracking = false
            isVibrate = false
        } else {
            if (replyButtonProgress > 0.0f) {
                replyButtonProgress -= dt / 180.0f
                if (replyButtonProgress < 0.1f) {
                    replyButtonProgress = 0f
                } else {
                    mView.invalidate()
                }
            }
        }
    }

    private fun convertToDp(pixel: Int): Int {
        return AndroidUtils.dp(pixel.toFloat(), context)
    }

    interface SwipeControllerActions {
        fun showSwipeInReplyUI(position: Int)
    }

}