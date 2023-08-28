package com.contusfly.call.groupcall.helpers

import android.Manifest
import android.content.DialogInterface
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.contus.call.CallConstants.CALL_UI
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.AudioDevice
import com.mirrorflysdk.flycall.webrtc.CallAudioManager
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallActionListener
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.contusfly.R
import com.contusfly.TAG
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

class CallOptionsViewHelper(
    private val activity: AppCompatActivity,
    private val binding: LayoutCallOptionsBinding,
    private val activityOnClickListener: ActivityOnClickListener,
    private val baseViewOnClickListener: BaseViewOnClickListener
) : View.OnClickListener {
    var isCameraButtonClick:Boolean=false
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
                LogMessage.d(TAG, "$CALL_UI toggleEnd()")
                enableOrDisableSwitchCamera(false)
                CallManager.disconnectCall()
            }
        }
    }

    /**
     * This method is used to set the Audio mute icons and also send a mute message
     */
    private fun toggleMic() {
        LogMessage.d(TAG, "$CALL_UI toggleMic()")
        if (CallManager.isCallOnHold())
            return
        binding.imageMuteAudio.isActivated =
            !binding.imageMuteAudio.isActivated
        CallManager.muteAudio(binding.imageMuteAudio.isActivated)
        baseViewOnClickListener.ownAudioMuteStatusUpdated()
    }

    private fun switchCamera(v: View) {

        if(!isCameraButtonClick){

            isCameraButtonClick=true

            v.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.alpha))

            swapCamera()

            Handler(Looper.getMainLooper()).postDelayed(object:Runnable{

                override fun run() {

                    isCameraButtonClick=false

                }

            },1000)

        }

    }

    /**
     * handles the swap camera functionality and animations
     *
     */
    private fun swapCamera() {
        LogMessage.d(TAG, "$CALL_UI swapCamera()")
        CallManager.switchCamera()
        baseViewOnClickListener.onSwapVideo()
        binding.imageSwitchCamera.isActivated = !binding.imageSwitchCamera.isActivated
    }

    /**
     * This method is used to set the video mute icons and also send a mute message
     */
    fun toggleVideoMute() {
        LogMessage.d(TAG, "$CALL_UI toggleVideoMute()")
        if (CallManager.isOneToOneCall()) {
            muteVideoForOneToOneCall()
        } else {
            muteVideoForGroupCall()
        }
    }

    /**
     * This method shows the audio device selection UI
     */
    private fun showSelection() {
        LogMessage.d(TAG, "$CALL_UI toggleSpeaker()")
        val audioDevices = CallManager.getAudioDevices()
        LogMessage.i(TAG, "$CALL_UI handleSpeaker#audioDevices:$audioDevices")
        val devices = audioDevices.toTypedArray()
        if (devices.size <= 2) {
            if (devices.size <= 1) {
                return
            }
            val selectedDevice =
                if (CallAudioManager.getInstance(activity).selectedAudioDevice == devices[0]) devices[1] else devices[0]
            setAudioDeviceIcon(
                selectedDevice
            )
            LogMessage.d(TAG, "$CALL_UI handleSpeaker#choosendevice:$selectedDevice")
            CallAudioManager.getInstance(activity).selectAudioDevice(selectedDevice)
            return
        }

        val builder = AlertDialog.Builder(activity, R.style.AudioDevicesDialogStyle)
        builder.setItems(devices) { _: DialogInterface?, which: Int ->
            @AudioDevice val device = devices[which]
            setAudioDeviceIcon(device)
            LogMessage.d(TAG, "$CALL_UI handleSpeaker#choosendevice:$device")
            CallManager.setAudioDevice(device)
        }
        val audioDevicesDialog = builder.create()
        if (audioDevicesDialog.window != null) audioDevicesDialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        audioDevicesDialog.show()
    }

    fun setUpCallUI() {
        setAudioDeviceIcon(CallAudioManager.getInstance(activity).selectedAudioDevice)

        checkAndUpdateCameraView()

        if (CallManager.isOutgoingCall() || CallManager.isCallAnswered()) {
            showCallOptions()
            baseViewOnClickListener.animateListViewWithCallOptions()
        } else
            hideCallOptions()
    }

    fun showCallOptions() {
        binding.layoutCallOptions.show()
        binding.imageMuteAudio.isActivated = CallManager.isAudioMuted()
    }

    fun hideCallOptions() {
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
        if (CallManager.isVideoMuted()) {
            binding.imageSwitchCamera.gone()
            binding.imageSwitchCamera.isActivated = false
            binding.imageSwitchCamera.isEnabled = false
            binding.imageMuteVideo.isActivated = false
            binding.imageMuteVideo.isEnabled = CallManager.isCallConnected()
        } else {
            binding.imageSwitchCamera.show()
            binding.imageSwitchCamera.isActivated = !CallUtils.getIsBackCameraCapturing()
            binding.imageSwitchCamera.isEnabled = true
            binding.imageMuteVideo.isActivated = true
            binding.imageMuteVideo.isEnabled = true
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
            "animateCallOptions callOptionsVisibility: $callOptionsVisibility"
        )
        if (activity.isInPIPMode() || !CallManager.isCallConnected() || CallUtils.isAddUsersToTheCall())
            return
        val isCallOptionNotVisible = binding.layoutCallOptions.visibility != View.VISIBLE
        val slideDownAnimation = AnimationUtils.loadAnimation(activity, animation)
        binding.layoutCallOptions.startAnimation(slideDownAnimation)
        slideDownAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                if (arrowVisibility == View.GONE)
                    baseViewOnClickListener.checkOptionArrowVisibility(arrowVisibility)
            }

            override fun onAnimationEnd(animation: Animation) {
                if (CallUtils.getIsGridViewEnabled() || !CallManager.isOneToOneCall() || CallManager.isVideoCall()) {
                    binding.layoutCallOptions.visibility = callOptionsVisibility
                    baseViewOnClickListener.checkOptionArrowVisibility(arrowVisibility)
                }
            }

            override fun onAnimationRepeat(animation: Animation) {
                /* not needed */
            }
        })
        if (!CallUtils.getIsGridViewEnabled()) { //List view animation with call options not needed for grid view
            if (callOptionsVisibility == View.VISIBLE) {
                if (isCallOptionNotVisible) baseViewOnClickListener.onCallOptionsVisible()
            } else
                if (!isCallOptionNotVisible) baseViewOnClickListener.onCallOptionsHidden()
        }
    }

    fun showOrHideSwitchCamera(showCamera: Boolean) {
        if (showCamera)
            binding.imageSwitchCamera.show()
        else
            binding.imageSwitchCamera.gone()
    }

    fun enableOrDisableSwitchCamera(isEnabled: Boolean) {
        binding.imageSwitchCamera.isEnabled = isEnabled
    }

    private fun muteVideoForOneToOneCall() {
        if (CallManager.isCallConnected() && CallManager.getCallType() == CallType.AUDIO_CALL) {
            if (GroupCallUtils.isOnVideoCall()) {
                binding.imageMuteVideo.isActivated =
                    !binding.imageMuteVideo.isActivated
                enableOrDisableSwitchCamera(binding.imageMuteVideo.isActivated)
                showOrHideSwitchCamera(binding.imageMuteVideo.isActivated)
                CallManager.muteVideo(!binding.imageMuteVideo.isActivated)
                baseViewOnClickListener.ownVideoMuteStatusUpdated()
            } else {
                activityOnClickListener.hangVideoCall()
            }
        } else {
            binding.imageMuteVideo.isActivated =
                !binding.imageMuteVideo.isActivated
            enableOrDisableSwitchCamera(binding.imageMuteVideo.isActivated)
            showOrHideSwitchCamera(binding.imageMuteVideo.isActivated)
            CallManager.muteVideo(!binding.imageMuteVideo.isActivated)
            baseViewOnClickListener.ownVideoMuteStatusUpdated()
        }
    }

    private fun muteVideoForGroupCall() {
        binding.imageMuteVideo.isActivated = !binding.imageMuteVideo.isActivated
        CallManager.muteVideo(!binding.imageMuteVideo.isActivated,
            object : CallActionListener {
                override fun onResponse(isSuccess: Boolean, message: String) {
                    LogMessage.d(TAG, "$CALL_UI muteVideo onResponse()")
                    if (binding.imageMuteVideo.isActivated) {
                        showOrHideSwitchCamera(true)
                        enableOrDisableSwitchCamera(true)
                        binding.imageSwitchCamera.isActivated = !CallUtils.getIsBackCameraCapturing()
                        baseViewOnClickListener.ownVideoMuteStatusUpdated()
                    } else {
                        showOrHideSwitchCamera(false)
                        enableOrDisableSwitchCamera(false)
                        binding.imageSwitchCamera.isActivated = false
                        baseViewOnClickListener.ownVideoMuteStatusUpdated()
                    }
                }
            })
    }
}