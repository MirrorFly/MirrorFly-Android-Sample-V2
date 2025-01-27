package com.contusfly.call

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.contus.call.CallConstants
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.adapters.BaseViewHolder
import com.contusfly.call.groupcall.isNull
import com.contusfly.databinding.RowParticipantsListItemBinding
import com.contusfly.getDisplayName
import com.contusfly.isValidIndex
import com.contusfly.loadUserProfileImage
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.flycall.webrtc.CallStatus
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.ChatUtils
import com.mirrorflysdk.utils.Utils
import java.util.ArrayList

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ParticipantsListAdapter(private val context: Context) : RecyclerView.Adapter<ParticipantsListAdapter.ParticipantsListViewHolder>(){

    /**
     * This class containing the view of the participants items
     */
    class ParticipantsListViewHolder(var viewBinding: RowParticipantsListItemBinding) : BaseViewHolder(viewBinding.root)

    private var profilesUserList: ArrayList<String>? = null

    fun setParticipantsProfiles(callConnectedUserList: ArrayList<String>?) {
        this.profilesUserList = callConnectedUserList
    }

    fun updateParticipantsDetails(jid: String) {
        val userIndex = profilesUserList!!.indexOfFirst { userJid -> userJid == jid }
        if (userIndex.isValidIndex()) {
            jid.let {
                this.profilesUserList!![userIndex] = jid
                notifyItemChanged(userIndex)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantsListViewHolder {
        val binding = RowParticipantsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParticipantsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParticipantsListViewHolder, position: Int) {
        val profileJid = profilesUserList!![position]
        val profile = ProfileDetailsUtils.getProfileDetails(profileJid)
        val userName = profile?.getDisplayName() ?: Utils.getFormattedPhoneNumber(ChatUtils.getUserFromJid(profileJid))
        //Set User Name
        holder.viewBinding.textUserName.text = userName
        //Load Profile Pic
        if (profile != null)
            holder.viewBinding.imageChatPicture.loadUserProfileImage(context, profile)
        else
            holder.viewBinding.imageChatPicture.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_profile))
        setUserMuteAndUnMuteStatus(profileJid, holder.viewBinding)
    }

    /*
* Set Audio, Video Mute/UnMute Status*/
    @SuppressWarnings("kotlin:S1125")
    private fun setUserMuteAndUnMuteStatus(profileJid: String, viewBinding: RowParticipantsListItemBinding) {
        val currentStatus = CallManager.getCallStatus(profileJid)
        val isAudioMuted = CallManager.isRemoteAudioMuted(profileJid)
        val isVideoMuted = CallManager.isRemoteVideoMuted(profileJid) || CallManager.isRemoteVideoPaused(profileJid)
                || CallManager.getRemoteProxyVideoSink(profileJid).isNull()

        LogMessage.d(TAG, "${CallConstants.CALL_UI} participantListFragment profileJid:$profileJid currentStatus: $currentStatus isAudioMuted: $isAudioMuted")
        if(currentStatus.equals(CallStatus.CONNECTED) || currentStatus.equals(CallStatus.RECONNECTING) || currentStatus.equals(
                CallStatus.RECONNECTED)){
            viewBinding.imageMuteAudio.isActivated =  if (profileJid == SharedPreferenceManager.getCurrentUserJid()) CallManager.isAudioMuted() else isAudioMuted
        }else{
            viewBinding.imageMuteAudio.isActivated =  if (profileJid == SharedPreferenceManager.getCurrentUserJid()) CallManager.isAudioMuted() else true
        }

        viewBinding.imageMuteVideo.isActivated =
            if (profileJid == SharedPreferenceManager.getCurrentUserJid()) CallManager.isVideoMuted() else isVideoMuted

    }

    override fun getItemCount(): Int {
        return profilesUserList!!.size
    }
}