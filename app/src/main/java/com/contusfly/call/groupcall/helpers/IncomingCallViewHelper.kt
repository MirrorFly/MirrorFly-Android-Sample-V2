package com.contusfly.call.groupcall.helpers

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.contus.call.CallConstants.CALL_UI
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.call.groupcall.isCallNotConnected
import com.contusfly.call.groupcall.isInComingCall
import com.contusfly.call.groupcall.isVideoCall
import com.contusfly.call.groupcall.listeners.ActivityOnClickListener
import com.contusfly.call.groupcall.utils.AnimationsHelper
import com.contusfly.databinding.LayoutIncomingCallBinding
import com.contusfly.gone
import com.contusfly.show

/*
* This class contains the incoming call accept or reject functionalities and animations
* */
class IncomingCallViewHelper(
    private val context: Context,
    private val binding: LayoutIncomingCallBinding,
    private val activityOnClickListener: ActivityOnClickListener
) : View.OnClickListener {

    init {
        binding.imageCallReject.setOnClickListener(this)
        binding.imageCallAnswer.setOnClickListener(this)
    }

    fun setUpCallUI() {
        if (CallManager.isCallNotConnected() && CallManager.isInComingCall())
            setUpIncomingCall()
        else
            hideIncomingCallLayout()
    }

    /*
    * Set up method for incoming call
    * */
    @SuppressLint("ClickableViewAccessibility")
    fun setUpIncomingCall() {
        LogMessage.d(TAG, "$CALL_UI setUpCallSwipeButton()")
        binding.layoutCallIncoming.show()
        if (CallManager.isVideoCall())
            binding.btnCallSwipe.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_group_call_swipe_button
                )
            )

        binding.rippleBg.startRippleAnimation()
        /* start animating arrows */
        AnimationsHelper.animateArrows(
            binding.imageCallUpArrow1,
            binding.imageCallUpArrow2,
            binding.imageCallDownArrow1,
            binding.imageCallDownArrow2
        )
        binding.rippleBg.setOnTouchListener { view: View, motionEvent: MotionEvent ->
            val curY: Float
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.imageCallUpArrow1.gone()
                    binding.imageCallUpArrow2.gone()
                    binding.imageCallDownArrow1.gone()
                    binding.imageCallDownArrow2.gone()
                    answerY = motionEvent.y
                    begin = true
                    oldMove = 0f
                }
                MotionEvent.ACTION_MOVE -> {
                    curY = motionEvent.y
                    view.scrollBy(view.scrollX, (answerY - curY).toInt())
                    oldMove -= answerY - curY
                    answerY = curY
                    if (oldMove < -100 || oldMove > 100) begin = false
                    if (curY.toInt() - binding.imageCallAnswer.bottom < 100) {
                        binding.btnCallSwipe.drawable.colorFilter =
                            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                                Color.GREEN,
                                BlendModeCompat.SRC_ATOP
                            )
                    } else if ((binding.imageCallReject.top - curY.toInt()) < 100) {
                        binding.btnCallSwipe.drawable.colorFilter =
                            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                                Color.RED,
                                BlendModeCompat.SRC_ATOP
                            )
                    }
                    actionClick(curY)
                }
                MotionEvent.ACTION_UP -> {
                    binding.btnCallSwipe.drawable.clearColorFilter()
                    view.scrollTo(view.scrollX, 0)
                    binding.imageCallUpArrow1.show()
                    binding.imageCallUpArrow2.show()
                    binding.imageCallDownArrow1.show()
                    binding.imageCallDownArrow2.show()
                }
            }
            true
        }
    }

    /**
     * This function is used to perform the click operation on [.binding.imageCallAnswer] or
     * [.activityBinding.imageCallReject] when the [.binding.btnCallSwipe] is near those buttons.
     *
     * @param curY call swipe button [.binding.btnCallSwipe] y position
     */
    private fun actionClick(curY: Float) {
        LogMessage.d(TAG, "$CALL_UI actionClick() curY:${curY}")
        if (curY <= binding.imageCallAnswer.bottom && !begin) {
            /* we shouldn't perform click operation when view is disabled */
            if (binding.imageCallAnswer.isEnabled) {
                binding.imageCallAnswer.performClick()
            }
        } else if (curY >= binding.imageCallReject.top && !begin) {
            /* we shouldn't perform click operation when view is disabled */
            if (binding.imageCallReject.isEnabled) binding.imageCallReject.performClick() else LogMessage.i(
                TAG,
                "$CALL_UI Hangup button disabled,so skipping performClick"
            )
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.image_call_reject -> {
                LogMessage.d(TAG, "$CALL_UI toggleReject()")
                binding.imageCallReject.isEnabled = false
                CallManager.declineCall()
            }
            R.id.image_call_answer -> {
                LogMessage.d(TAG, "$CALL_UI toggleAnswer()")
                binding.imageCallAnswer.isEnabled = false
                binding.imageCallReject.isEnabled = false
                /* check permissions */
                if (CallManager.getCallType() == CallType.AUDIO_CALL && CallManager.isNotificationPermissionsGranted() && CallManager.isAudioCallPermissionsGranted(skipBlueToothPermission = false) || CallManager.getCallType() == CallType.VIDEO_CALL && CallManager.isVideoCallPermissionsGranted(skipBlueToothPermission = false) && CallManager.isNotificationPermissionsGranted())
                    activityOnClickListener.answer()
                else {
                    CallManager.declineCall()
                    Toast.makeText(
                        context,
                        context.getString(R.string.call_permission_denied),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun hideIncomingCallLayout() {
        binding.layoutCallIncoming.gone()
    }

    companion object {
        /**
         * This flag indicates whether the call button motion started or not
         */
        var begin = false
        var answerY = 0f
        var oldMove = 0f
    }

}