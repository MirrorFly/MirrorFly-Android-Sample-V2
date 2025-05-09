package com.contusfly.call.groupcall.helpers

import android.Manifest
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.contus.call.CallConstants.CALL_UI
import com.contus.call.CallConstants.JOIN_CALL
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.call.groupcall.AudioDeviceAdapter
import com.contusfly.call.groupcall.isInPIPMode
import com.contusfly.call.groupcall.isOutgoingCall
import com.contusfly.call.groupcall.isVideoCall
import com.contusfly.call.groupcall.listeners.ActivityOnClickListener
import com.contusfly.call.groupcall.listeners.BaseViewOnClickListener
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.LayoutCallOptionsBinding
import com.contusfly.gone
import com.contusfly.show
import com.contusfly.utils.MediaPermissions
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.AudioDevice
import com.mirrorflysdk.flycall.webrtc.CallAudioManager
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallActionListener
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.exception.FlyException

class CallOptionsViewHelper(
    private val activity: AppCompatActivity,
    private val binding: LayoutCallOptionsBinding,
    private val activityOnClickListener: ActivityOnClickListener,
    private val baseViewOnClickListener: BaseViewOnClickListener
) : View.OnClickListener {
    var isCameraButtonClick: Boolean = false
    var isAnimationStarted: Boolean = false
    init {
        binding.imageMuteAudio.setOnClickListener(this)
        binding.imageMuteVideo.setOnClickListener(this)
        binding.imageSwitchCamera.setOnClickListener(this)
        binding.imgSpeaker.setOnClickListener(this)
        binding.imageEndCall.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.image_mute_audio -> toggleMic()
            R.id.image_switch_camera -> {
                if (CallManager.isCallOnHold())
                    return
                switchCamera(v)
            }

            R.id.image_mute_video -> {
                LogMessage.d(
                    TAG,
                    "$CALL_UI $JOIN_CALL CallOptionsViewHelper toggleVideoMute() clicked"
                )
                if (CallManager.isCallOnHold())
                    return
                if (MediaPermissions.isPermissionAllowed(activity, Manifest.permission.CAMERA)) {
                    toggleVideoMute()
                } else {
                    activityOnClickListener.requestCameraPermission()
                }
            }

            R.id.img_speaker -> showSelection()
            R.id.image_end_call -> {
                LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallOptionsViewHelper toggleEnd()")
                enableOrDisableSwitchCamera(false)
                CallManager.disconnectCall()
            }
        }
    }

    /**
     * This method is used to set the Audio mute icons and also send a mute message
     */
    private fun toggleMic() {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper toggleMic()")
        if (CallManager.isCallOnHold())
            return
        binding.imageMuteAudio.isActivated =
            !binding.imageMuteAudio.isActivated
        CallManager.muteAudio(binding.imageMuteAudio.isActivated)
        baseViewOnClickListener.ownAudioMuteStatusUpdated()
    }

    /**
     * handles the swap camera functionality and animations
     *
     */
     private fun switchCamera(v: View) {
        if (!isCameraButtonClick) {
            isCameraButtonClick = true
            v.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.alpha))
            swapCamera()
            Handler(Looper.getMainLooper()).postDelayed({ isCameraButtonClick = false }, 1000)
        }

    }


    fun conversionRequestAcceptSwapVideo() {
        switchCamera(binding.imageSwitchCamera)
    }

    /**
     * handles the swap camera functionality and animations
     *
     */
    private fun swapCamera() {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper swapCamera()")
        CallManager.switchCamera()
        baseViewOnClickListener.onSwapVideo()
        binding.imageSwitchCamera.isActivated = !binding.imageSwitchCamera.isActivated
    }

    /**
     * This method is used to set the video mute icons and also send a mute message
     */
    fun toggleVideoMute() {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper toggleVideoMute()")
        if (!GroupCallUtils.isCallLinkBehaviourMeet() && CallManager.isOneToOneCall()) {
            muteVideoForOneToOneCall()
        } else {
            muteVideoForGroupCall()
        }
    }

    /**
     * This method shows the audio device selection UI
     */
    private fun showSelection() {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper toggleSpeaker()")
        val audioDevices = CallManager.getAudioDevices()
        LogMessage.i(
            TAG,
            "$CALL_UI  CallOptionsViewHelper handleSpeaker#audioDevices:$audioDevices"
        )
        var devices = audioDevices.toTypedArray()
        if (devices.size <= 2) {
            if (devices.size <= 1) {
                return
            }
            val selectedDevice =
                if (CallAudioManager.getInstance(activity).selectedAudioDevice == devices[0]) devices[1] else devices[0]
            setAudioDeviceIcon(
                selectedDevice
            )
            LogMessage.d(
                TAG,
                "$CALL_UI CallOptionsViewHelper handleSpeaker#choosendevice:$selectedDevice"
            )
            CallAudioManager.getInstance(activity).selectAudioDevice(selectedDevice)
            return
        }
        var selectedDevice = CallAudioManager.getInstance(activity).selectedAudioDevice
        val adapter = AudioDeviceAdapter(activity, devices, selectedDevice)
        val builder = AlertDialog.Builder(activity)
        builder.setAdapter(adapter) { _, which ->
            val audioDevices = CallManager.getAudioDevices()
            devices = audioDevices.toTypedArray()
            if (which < 0 || which >= devices.size) {
                LogMessage.e(TAG, "$CALL_UI CallOptionsViewHelper popup show handleSpeaker#invalidIndex:$which")
                return@setAdapter  // Exit if the index is invalid
            }
            val selectedDevice = devices[which]
            setAudioDeviceIcon(selectedDevice)
            LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper popup show handleSpeaker#choosendevice:$selectedDevice")
            CallManager.setAudioDevice(selectedDevice)

            // Update selection in the adapter
            adapter.updateSelection(selectedDevice)
        }
        val audioDevicesDialog = builder.create()
        if (audioDevicesDialog.window != null) audioDevicesDialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        audioDevicesDialog.show()
    }

    fun setUpCallUI(isCallOptionAnimation:Boolean) {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper setUpCallUI")
        setAudioDeviceIcon(CallAudioManager.getInstance(activity).selectedAudioDevice)

        if(CallManager.isCallConnected()) {
            binding.imageMuteVideo.setImageResource(com.contus.call.R.drawable.selector_call_video_state)
        } else {
            binding.imageMuteVideo.setImageResource(com.contus.call.R.drawable.selector_before_connect_video_state)
        }


        checkAndUpdateCameraView()

        if (CallManager.isOutgoingCall() || CallManager.isCallAnswered()) {
            showCallOptions()
            if(isCallOptionAnimation) baseViewOnClickListener.animateListViewWithCallOptions()
        } else
            hideCallOptions()
    }

    fun showCallOptions() {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper showCallOptions")
        binding.layoutCallOptions.show()
        binding.imageMuteAudio.isActivated = CallManager.isAudioMuted()
    }

    fun hideCallOptions() {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper hideCallOptions")
        binding.layoutCallOptions.gone()
    }

    /**
     * sets icon for the audio device image view based on the selected audio device
     *
     * @param device          selected audio device
     */
    fun setAudioDeviceIcon(@AudioDevice device: String?) {
        when (device) {
            AudioDevice.BLUETOOTH -> binding.imgSpeaker.setImageResource(R.drawable.ic_device_bluetooth)
            AudioDevice.EARPIECE -> {
                binding.imgSpeaker.setImageResource(R.drawable.ic_speaker_inactive)
                binding.imgSpeaker.isActivated = false
            }

            AudioDevice.SPEAKER_PHONE -> {
                binding.imgSpeaker.setImageResource(R.drawable.ic_speaker_active)
                binding.imgSpeaker.isActivated = true
            }

            AudioDevice.WIRED_HEADSET -> binding.imgSpeaker.setImageResource(R.drawable.ic_device_headset)
        }
    }

    fun checkAndUpdateCameraView() {
        LogMessage.d(
            TAG,
            "$CALL_UI CallOptionsViewHelper checkAndUpdateCameraView isVideoMuted:${CallManager.isVideoMuted()}"
        )
        if (CallManager.isVideoMuted()) {
            binding.imageSwitchCamera.gone()
            binding.imageSwitchCamera.isActivated = false
            binding.imageSwitchCamera.isEnabled = false
            if (CallManager.isOneToOneCall() && CallManager.isOutgoingCallConversionRequestAvailable()) {
                binding.imageMuteVideo.isActivated = true
                binding.imageMuteVideo.isEnabled = CallManager.isCallConnected()
            } else {
                binding.imageMuteVideo.isActivated = false
                binding.imageMuteVideo.isEnabled =
                    CallManager.isCallConnected() || GroupCallUtils.isCallLinkBehaviourMeet()
            }

        } else {
            binding.imageSwitchCamera.show()
            binding.imageSwitchCamera.isActivated = !CallUtils.getIsBackCameraCapturing()
            binding.imageSwitchCamera.isEnabled = true
            binding.imageMuteVideo.isActivated = true
            binding.imageMuteVideo.isEnabled = CallManager.isCallConnected()
        }
    }

    /**
     * This method animates the call options layout with given animation
     *
     * @param animation             animation id
     * @param callOptionsVisibility visibility to be changed for callOptions view
     * @param arrowVisibility       visibility to be changed for arrow view
     */
    fun animateCallOptions(animation: Int, callOptionsVisibility: Int, arrowVisibility: Int) {
        LogMessage.d(
            TAG,
            "CallOptionsViewHelper animateCallOptions callOptionsVisibility: $callOptionsVisibility"
        )
        if (activity.isInPIPMode() || !CallManager.isCallConnected() || CallUtils.isAddUsersToTheCall())
            return
        val isCallOptionNotVisible = binding.layoutCallOptions.visibility != View.VISIBLE

        if (!CallUtils.getIsGridViewEnabled() && callOptionsVisibility == View.VISIBLE && isCallOptionNotVisible) { //List view animation with call options not needed for grid view
            baseViewOnClickListener.onCallOptionsVisible()
        }

        animated(animation,callOptionsVisibility,arrowVisibility)
    }

    private fun animated(animation: Int, callOptionsVisibility: Int, arrowVisibility: Int){
        val slideDownAnimation = AnimationUtils.loadAnimation(activity, animation)
        binding.layoutCallOptions.startAnimation(slideDownAnimation)
        slideDownAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                isAnimationStarted = true
                if (arrowVisibility == View.GONE)
                    baseViewOnClickListener.checkOptionArrowVisibility(arrowVisibility)
            }

            override fun onAnimationEnd(animation: Animation) {
                isAnimationStarted = false
                if (CallUtils.getIsGridViewEnabled() || !CallManager.isOneToOneCall() || CallManager.isVideoCall()) {
                    binding.layoutCallOptions.visibility = callOptionsVisibility
                    baseViewOnClickListener.checkOptionArrowVisibility(arrowVisibility)
                }
                if(!CallUtils.getIsGridViewEnabled() && callOptionsVisibility == View.GONE) {
                    baseViewOnClickListener.onCallOptionsHidden()
                }

            }

            override fun onAnimationRepeat(animation: Animation) {
                /* not needed */
            }
        })
    }

    fun showOrHideSwitchCamera(showCamera: Boolean) {
        LogMessage.d(
            TAG,
            "$CALL_UI CallOptionsViewHelper showOrHideSwitchCamera showCamera:$showCamera"
        )
        if (showCamera)
            binding.imageSwitchCamera.show()
        else
            binding.imageSwitchCamera.gone()
    }

    fun enableOrDisableSwitchCamera(isEnabled: Boolean) {
        binding.imageSwitchCamera.isEnabled = isEnabled
    }

    private fun muteVideoForOneToOneCall() {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper muteVideoForOneToOneCall ")
        if (CallManager.isCallConnected() && CallManager.getCallType() == CallType.AUDIO_CALL) {
            if (GroupCallUtils.isOnVideoCall()) {
                LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper AUDIO_CALL ")
                binding.imageMuteVideo.isActivated =
                    !binding.imageMuteVideo.isActivated
                enableOrDisableSwitchCamera(binding.imageMuteVideo.isActivated)
                showOrHideSwitchCamera(binding.imageMuteVideo.isActivated)
                CallManager.muteVideo(!binding.imageMuteVideo.isActivated)
                baseViewOnClickListener.ownVideoMuteStatusUpdated()
            } else {
                LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper hangVideoCall ")
                activityOnClickListener.hangVideoCall()
            }
        } else {
            LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper video call ")
            binding.imageMuteVideo.isActivated =
                !binding.imageMuteVideo.isActivated
            enableOrDisableSwitchCamera(binding.imageMuteVideo.isActivated)
            showOrHideSwitchCamera(binding.imageMuteVideo.isActivated)
            CallManager.muteVideo(!binding.imageMuteVideo.isActivated)
            baseViewOnClickListener.ownVideoMuteStatusUpdated()
        }
    }

    private fun muteVideoForGroupCall() {
        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper muteVideoForGroupCall ")
        binding.imageMuteVideo.isActivated = !binding.imageMuteVideo.isActivated
        if (GroupCallUtils.isSingleUserInCall() || GroupCallUtils.isCallLinkBehaviourMeet()) {
            LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper isSingleUserInCall setVideoMuted ")
            GroupCallUtils.setVideoMuted(!binding.imageMuteVideo.isActivated)
        }
        CallManager.muteVideo(!binding.imageMuteVideo.isActivated,
            object : CallActionListener {
                override fun onResponse(isSuccess: Boolean, flyException: FlyException?) {

                    LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper muteVideo onResponse()")
                    if (binding.imageMuteVideo.isActivated) {
                        LogMessage.d(
                            TAG,
                            "$CALL_UI CallOptionsViewHelper imageMuteVideo isActivated"
                        )
                        showOrHideSwitchCamera(true)
                        enableOrDisableSwitchCamera(true)
                        binding.imageSwitchCamera.isActivated =
                            !CallUtils.getIsBackCameraCapturing()
                        baseViewOnClickListener.ownVideoMuteStatusUpdated()
                    } else {
                        LogMessage.d(TAG, "$CALL_UI CallOptionsViewHelper imageMuteVideo ")
                        showOrHideSwitchCamera(false)
                        enableOrDisableSwitchCamera(false)
                        binding.imageSwitchCamera.isActivated = false
                        baseViewOnClickListener.ownVideoMuteStatusUpdated()
                    }
                }
            })
    }
}