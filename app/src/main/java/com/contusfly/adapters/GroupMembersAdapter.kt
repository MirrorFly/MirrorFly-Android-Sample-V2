package com.contusfly.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.contusfly.*
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.databinding.ListParticipantsItemBinding
import com.contusfly.utils.ChatMessageUtils
import com.contusfly.utils.Constants
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.Utils
import com.jakewharton.rxbinding3.view.clicks
import java.util.*
import java.util.concurrent.TimeUnit

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class GroupMembersAdapter(val context: Context, private var profilesList: ArrayList<ProfileDetails>,
                          val listener: (position: Int, profile: ProfileDetails) -> Unit) :
        GenericSearchAdapter<ProfileDetails, GroupMembersAdapter.GroupMemberViewHolder>(profilesList) {

    lateinit var onParticipantClicked: (Int,ProfileDetails) -> Unit

    fun onProfileClickedCallback(fn: (Int,ProfileDetails) -> Unit) {
        onParticipantClicked = fn
    }


    inner class GroupMemberViewHolder(var viewBinding: ListParticipantsItemBinding) : BaseViewHolder(viewBinding.root){
        init{
            viewBinding.contentView.clicks().throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe {
                onParticipantClicked(layoutPosition, profilesList[layoutPosition])
            }
        }
    }

    override fun setViewHolder(parent: ViewGroup): GroupMemberViewHolder {
        val binding = ListParticipantsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupMemberViewHolder(binding)
    }

    private fun handlePayloads(bundle: Bundle, holder: GroupMemberViewHolder, profile: ProfileDetails) {
        for (key in bundle.keySet()) {
            when (key) {
                Constants.NOTIFY_PROFILE_ICON -> {
                    setUserInfo(holder, profile)
                }
                else -> {
                    LogMessage.e("ContactsAdapter", "Do Nothing")
                }
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return if (profilesList.size > position)
            profilesList[position].jid.hashCode().toLong()
        else
            profilesList[0].jid.hashCode().toLong()

    }

    /**
     * Set the user info of the user from the Roster
     *
     * @param holder View holder of recycler view
     * @param item   Roster of the user
     */
    private fun setUserInfo(holder: GroupMemberViewHolder, profile: ProfileDetails) {
        holder.viewBinding.imageParticipantPicture.loadUserProfileImage(context, profile)
        holder.viewBinding.textParticipantName.text = profile.getDisplayName()

        val status = Utils.returnEmptyStringIfNull(profile.status)

        // Set status if status not empty
        if (status.isNotEmpty() && !profile.isBlockedMe) {
            // Emoji utils Which has the emoji related common methods
            holder.viewBinding.textParticipantStatus.show()
            // Set user status content
            holder.viewBinding.textParticipantStatus.text = status
        } else {
            holder.viewBinding.textParticipantStatus.gone()
        }
    }

    override fun hasSearchKey(item: ProfileDetails, filterKey: String): Boolean {
        return item.getDisplayName().lowercase(Locale.getDefault()).contains(filterKey.lowercase(
            Locale.getDefault()
        ))
    }

    override fun onBindData(holder: GroupMemberViewHolder, item: ProfileDetails, position: Int, payloads: MutableList<Any>) {
        val bundle = payloads[0] as Bundle
        handlePayloads(bundle, holder, item)
    }

    override fun onBindData(holder: GroupMemberViewHolder, item: ProfileDetails, position: Int) {
        holder.viewBinding.textParticipantName.viewTreeObserver.addOnGlobalLayoutListener { ChatMessageUtils.fixEmojiAfterEllipses(holder.viewBinding.textParticipantName) }
        holder.viewBinding.textParticipantStatus.viewTreeObserver.addOnGlobalLayoutListener { ChatMessageUtils.fixEmojiAfterEllipses(holder.viewBinding.textParticipantStatus) }
        setUserInfo(holder, item)
        holder.viewBinding.textAdmin.isVisible = item.isGroupAdmin
        if (position == profilesList.size - 1) {
            holder.viewBinding.viewDivider.setVisibility(View.GONE);
        }else{
            holder.viewBinding.viewDivider.setVisibility(View.VISIBLE);
        }
    }
}