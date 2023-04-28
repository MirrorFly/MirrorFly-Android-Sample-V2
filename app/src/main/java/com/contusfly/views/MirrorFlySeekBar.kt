package com.contusfly.views

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatSeekBar
import kotlin.math.abs

class MirrorFlySeekBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatSeekBar(
    context!!, attrs, defStyleAttr
) {
    private var downTime: Long = 0
    private var longClickListener: LongClickListener? = null
    private val timeDiff = 1000
    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (msg.what == 1 && !hasLongTouch && isEnabled) {
                hasLongTouch = true
                possibleLongTouch = false
                if (longClickListener != null) longClickListener!!.onLongClick()
            }
        }
    }
    private var lastY = 0f
    private var lastX = 0f
    private var hasLongTouch = false
    private var possibleLongTouch = true
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val y = event.y
        val x = event.x
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                hasLongTouch = false // Initialization has been implemented too long
                possibleLongTouch = true
                lastY = y
                lastX = x
                downTime = System.currentTimeMillis() // Remove the time
                if (!handler.hasMessages(1)) { // If there is already a message in the message queue, it is not rescheduled.
                    handler.sendEmptyMessageDelayed(1, timeDiff.toLong())
                }
                return super.onTouchEvent(event)
            }
            MotionEvent.ACTION_MOVE -> {
                // When moving if x | y slides a distance, it is impossible to press the event to be set to False.
                if (lastX != 0f && lastY != 0f && (abs(y - lastY) > 5 || abs(x - lastX) > 5)) {
                    possibleLongTouch = false
                    handler.removeMessages(1)
                    return super.onTouchEvent(event)
                }
                lastY = y
                lastX = x
            }
            MotionEvent.ACTION_UP -> {
                lastX = 0f
                lastY = 0f
                handler.removeMessages(1)
                if (isPossibleLongTouch()) return true
                return super.onTouchEvent(event)
            }
            MotionEvent.ACTION_CANCEL -> {
                handler.removeMessages(1)
                lastX = 0f
                lastY = 0f
                return super.onTouchEvent(event)
            }
        }
        return false
    }

    private fun isPossibleLongTouch(): Boolean {
        if (System.currentTimeMillis() - downTime > timeDiff && possibleLongTouch) {
            if (!hasLongTouch) { // If you have already executed, you don't need to execute again.
                hasLongTouch = true
                if (isEnabled) {
                    longClickListener?.onLongClick()
                }
            }
            possibleLongTouch = false
            return true
        }
        return false
    }

    fun setLongClickListener(longClickListener: LongClickListener?) {
        this.longClickListener = longClickListener
    }

    interface LongClickListener {
        fun onLongClick()
    }
}