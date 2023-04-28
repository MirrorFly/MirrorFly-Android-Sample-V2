package com.contusfly.call.groupcall.helpers

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.contus.call.CallConstants.CALL_UI
import com.contus.call.SpeakingIndicatorListener
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycall.webrtc.CallStatus
import com.contusfly.*
import com.contusfly.call.groupcall.isNull
import com.contusfly.call.groupcall.isReconnecting
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.LayoutPipModeBinding
import com.contusfly.utils.*
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.ChatUtils
import com.mirrorflysdk.utils.Utils
import org.webrtc.RendererCommon

class PIPViewHelper(private val context: Context, private val binding: LayoutPipModeBinding) {

    private var lastUserJid = Constants.EMPTY_STRING

    fun hidePIPLayout() {
        binding.layoutPipMode.gone()
        binding.userVideoSurface.gone()
        binding.userVideoSurface1.gone()
    }

    fun showPIPLayout() {
        binding.layoutPipMode.show()

        if (!CallUtils.getIsVideoViewInitialized()) {
            // For Local view initialization
            binding.userVideoSurface.init(CallManager.getRootEglBase()?.eglBaseContext, null)
            binding.userVideoSurface.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL)
            // For Remote view initialization
            binding.userVideoSurface1.init(CallManager.getRootEglBase()?.eglBaseContext, null)
            binding.userVideoSurface1.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL)
            CallUtils.setVideoViewInitialization(true)
        }

        setLocalUserView()

        val callConnectedUserList = CallManager.getCallUsersList()

        LogMessage.e(TAG, "$CALL_UI Call Available Users == ${callConnectedUserList.size}")
        LogMessage.d(TAG, "$CALL_UI Call type: ${CallManager.getCallType()}")

        if (callConnectedUserList.contains(SharedPreferenceManager.getCurrentUserJid()))
            callConnectedUserList.remove(SharedPreferenceManager.getCurrentUserJid())

        if (callConnectedUserList.size > 1) {
            binding.participantsCount.show()
            binding.participantsCount.text = String.format(context.getString(R.string.call_member_count), callConnectedUserList.size - 1)
        } else
            binding.participantsCount.gone()

        if (callConnectedUserList.isNotEmpty()) setRemoteUserView(callConnectedUserList[0])
    }

    /*
     * Set Local User Profile details
     */
    private fun setLocalUserView() {
        binding.userProfileName.text = Constants.YOU
        binding.viewSpeakingIndicator.onUserStoppedSpeaking(null)
        if (CallManager.isVideoMuted()) {
            binding.userProfilePic.show()
            binding.userVideoSurface.gone()
            val userName = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME))
            val userImgUrl = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE))
            if (userImgUrl.isNotEmpty())
                MediaUtils.loadImage(context, userImgUrl, binding.userProfilePic, AppCompatResources.getDrawable(context, R.drawable.profile_img))
            else binding.userProfilePic.setImageDrawable(SetDrawable(context).setDrawableForProfile(userName))
        } else {
            binding.userVideoSurface.show()
            binding.userProfilePic.gone()
            binding.userVideoSurface.setMirror(!CallUtils.getIsBackCameraCapturing())
            CallManager.getLocalProxyVideoSink()?.setTarget(binding.userVideoSurface)
        }
        if (CallManager.isCallOnHold()) {
            binding.callerStatusLayout.show()
            binding.callerStatusTextView.text = CallStatus.ON_HOLD
        } else if(CallManager.isReconnecting()) {
            binding.callerStatusLayout.show()
            binding.callerStatusTextView.text = CallStatus.RECONNECTING
        } else {
            binding.callerStatusLayout.gone()
        }
    }

    fun onVideoTrackAdded(userJid: String) {
        LogMessage.i(TAG, "$CALL_UI onVideoTrackAdded userJid: $userJid")
        if (lastUserJid == userJid)
            setRemoteUserView(userJid)
    }

    private fun setRemoteUserView(userJid: String) {
        if (lastUserJid != userJid)
            CallManager.getRemoteProxyVideoSink(lastUserJid)?.setTarget(null)
        lastUserJid = userJid
        val profileDetails = ProfileDetailsUtils.getProfileDetails(userJid)
        val name = getProfileName(profileDetails, userJid)
        binding.userProfileName1.text = name
        binding.viewSpeakingIndicator1.onUserStoppedSpeaking(null)

        if (CallManager.isRemoteVideoMuted(userJid)
            || CallManager.isRemoteVideoPaused(userJid)
            || CallManager.getRemoteProxyVideoSink(userJid).isNull()) {
            setRemoteVideoMuted(profileDetails)
        } else {
            binding.userVideoSurface1.show()
            binding.userProfilePic1.gone()
            CallManager.getRemoteProxyVideoSink(userJid)?.setTarget(binding.userVideoSurface1)
        }

        if (CallManager.getCallStatus(userJid) in arrayOf(CallStatus.ON_HOLD, CallStatus.RECONNECTING)) {
            binding.participantStatusLayout.show()
            binding.participantStatusTextView.text = CallManager.getCallStatus(userJid)
        } else {
            binding.participantStatusLayout.gone()
        }
    }

    /*
     * Get User Profile Name
     */
    private fun getProfileName(profileDetails: ProfileDetails?, userJid: String): CharSequence {
        return if (profileDetails != null) {
            LogMessage.d(TAG, "$CALL_UI getProfileName: userJid:${userJid}")
            com.contusfly.utils.Utils.returnEmptyStringIfNull(profileDetails.getDisplayName())
        } else Utils.getFormattedPhoneNumber(ChatUtils.getUserFromJid(userJid)) ?: Constants.EMPTY_STRING
    }

    /*
     * Set User Profile Pic
     */
    private fun setRemoteVideoMuted(profileDetails: ProfileDetails?) {
        binding.userProfilePic1.show()
        binding.userVideoSurface1.gone()
        var drawable = ContextCompat.getDrawable(context, R.drawable.ic_pip_default_profile)
        if (profileDetails != null) {
            if (!profileDetails.isBlockedMe)
                drawable = SetDrawable(context, profileDetails).setDrawable(profileDetails.getDisplayName())

            var imageUrl = profileDetails.image ?: Constants.EMPTY_STRING
            if (profileDetails.isBlockedMe)
                imageUrl = Constants.EMPTY_STRING

            MediaUtils.loadImage(context, imageUrl, binding.userProfilePic1, drawable)
        } else
            binding.userProfilePic1.setImageDrawable(drawable)
    }

    fun onUserSpeaking(userJid: String, audioLevel: Int) {
        if (userJid == CallManager.getCurrentUserId())
            binding.viewSpeakingIndicator.onUserSpeaking(audioLevel)
        else {
            if (!CallManager.isOneToOneCall() && CallUtils.isSpeakingUserCanBeShownOnTop(userJid, audioLevel)) {
                setRemoteUserView(userJid)
                binding.viewSpeakingIndicator1.onUserSpeaking(audioLevel)
            } else if (userJid == CallUtils.getPinnedUserJid()) {
                binding.viewSpeakingIndicator1.onUserSpeaking(audioLevel)
            }
        }
    }

    fun onUserStoppedSpeaking(userJid: String) {
        if (userJid == CallManager.getCurrentUserId())
            binding.viewSpeakingIndicator.onUserStoppedSpeaking(null)
        else if (lastUserJid == userJid)
            binding.viewSpeakingIndicator1.onUserStoppedSpeaking(object : SpeakingIndicatorListener {
                override fun onSpeakingIndicatorHidden() {
                    CallUtils.clearPeakSpeakingUser(userJid)
                }
            })
    }
}