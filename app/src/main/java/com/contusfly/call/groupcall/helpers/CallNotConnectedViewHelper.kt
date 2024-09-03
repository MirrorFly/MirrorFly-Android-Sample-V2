package com.contusfly.call.groupcall.helpers

import android.content.Context
import com.contus.call.CallConstants.CALL_UI
import com.contus.call.CallConstants.JOIN_CALL
import com.contusfly.TAG
import com.contusfly.call.groupcall.getEndCallerJid
import com.contusfly.call.groupcall.getOnGoingCallStatus
import com.contusfly.call.groupcall.isAudioCall
import com.contusfly.call.groupcall.isCallNotConnected
import com.contusfly.call.groupcall.isOutgoingCall
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.LayoutCallNotConnectedBinding
import com.contusfly.getDisplayName
import com.contusfly.gone
import com.contusfly.loadUserProfileImage
import com.contusfly.show
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.Utils

class CallNotConnectedViewHelper(
    private val context: Context,
    private val binding: LayoutCallNotConnectedBinding
) {

    fun updateCallStatus() {
        binding.textCallStatus.text = CallManager.getOnGoingCallStatus(context)
    }

    private fun showCallStatus() {
        binding.textCallStatus.show()
    }

    /*
    * Set up call details before user attend the call
    * */
    fun setUpCallUI() {
        val isCallNotConnected = CallManager.isCallNotConnected()
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallNotConnectedViewHelper setUpCallUI() isCallNotConnected: $isCallNotConnected")
        if (isCallNotConnected) {
            binding.layoutCallNotConnected.show()
            showCallStatus()
            updateCallStatus()
            updateCallMemberDetails(CallManager.getCallUsersList())
            showCallerImage()
            CallUtils.setIsListViewAnimated(false)
        } else
            binding.layoutCallNotConnected.gone()
    }

    private fun showCallerImage() {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallNotConnectedViewHelper showCallerImage:")
        if (CallManager.isOneToOneCall() || CallManager.getGroupID().isNotBlank()) {
            binding.layoutGroupCallMembersImage.layoutMembersImage.gone()
            if (CallManager.isOutgoingCall() && CallManager.isAudioCall()) {
                binding.layoutOutgoingProfile.show()
                binding.rippleBg.startRippleAnimation()
                binding.callerProfileImage.gone()
            } else {
                binding.layoutOutgoingProfile.gone()
                binding.callerProfileImage.gone()
            }
            if (CallManager.getGroupID().isNotBlank() && !CallManager.isOneToOneCall())
                binding.textParticipantsName.show()
            else
                binding.textParticipantsName.gone()
        } else {
            binding.textParticipantsName.gone()
            binding.layoutOutgoingProfile.gone()
            binding.callerProfileImage.gone()
            binding.layoutGroupCallMembersImage.layoutMembersImage.show()
        }
    }

    fun showRetryLayout() {
        if (CallManager.isOneToOneCall())
            binding.rippleBg.stopRippleAnimation()
        updateCallStatus()
    }

    fun hideRetryLayout() {
        if (CallManager.isOneToOneCall())
            binding.rippleBg.startRippleAnimation()
        updateCallStatus()
    }

    /**
     * This method is getting the caller name and profile picture
     *
     * @param callUsers list of Users in Call
     */
    fun updateCallMemberDetails(callUsers: ArrayList<String>) {
        LogMessage.d(TAG, "$CALL_UI CallNotConnectedViewHelper getProfile $callUsers")
        showCallerImage()
        if (CallManager.isOneToOneCall()) {
            val profileDetails = if (CallManager.getEndCallerJid().contains("@"))
                ProfileDetailsUtils.getProfileDetails(CallManager.getEndCallerJid())
            else null
            updateUserDetails(profileDetails)
        } else if (CallManager.getGroupID().isNotBlank()) {
            updateGroupMemberDetails(callUsers)
            updateGroupDetailsForGroupCall(callUsers)
        } else {
            updateGroupMemberDetails(callUsers)
        }
    }

    private fun updateGroupDetailsForGroupCall(callUsers: ArrayList<String>){
        LogMessage.d(TAG, "$CALL_UI CallNotConnectedViewHelper updateGroupDetailsForGroupCall $callUsers")
        updateGroupMemberDetails(callUsers)
        updateUserDetails(ProfileDetailsUtils.getProfileDetails(GroupCallUtils.getGroupId()))
    }

    private fun updateUserDetails(profileDetails: ProfileDetails?) {
        profileDetails?.let {
            binding.callerProfileImage.loadUserProfileImage(context, profileDetails)
            binding.receiverProfileImage.loadUserProfileImage(context, profileDetails)
            val name = Utils.returnEmptyStringIfNull(profileDetails.getDisplayName())
            LogMessage.d(TAG, "$CALL_UI getProfile name: $name")
            binding.textCallerName.text = name
        }
    }

    private fun updateGroupMemberDetails(callUsers: java.util.ArrayList<String>) {
        val membersName = CallUtils.setGroupMemberProfile(
            context,
            callUsers,
            binding.layoutGroupCallMembersImage.imageCallMember1,
            binding.layoutGroupCallMembersImage.imageCallMember2,
            binding.layoutGroupCallMembersImage.imageCallMember3,
            binding.layoutGroupCallMembersImage.imageCallMember4
        )
        binding.textCallerName.text = membersName.toString()
        binding.textParticipantsName.text = membersName.toString()
    }
}