package com.contusfly.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.R
import com.contusfly.*
import com.contusfly.databinding.RowContactItemBinding
import com.contusfly.utils.ChatMessageUtils
import com.contusfly.utils.Constants
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.Utils
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ContactsAdapter(val context: Context, private val commonAlertDialog: CommonAlertDialog, private val isMultiSelection: Boolean,
                      private var profilesList: ArrayList<ProfileDetails>, private val isMakeCall: Boolean,
                      val listener: (position: Int, profileClicked: Boolean, profile: ProfileDetails) -> Unit) :
        GenericSearchAdapter<ProfileDetails, ContactsAdapter.ContactsViewHolder>(profilesList) {

    class ContactsViewHolder(var viewBinding: RowContactItemBinding) : BaseViewHolder(viewBinding.root)

    var groupCallMembersCount = 0

    var blockedUser: String = emptyString()

    override fun setViewHolder(parent: ViewGroup): ContactsViewHolder {
        val binding = RowContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactsViewHolder(binding)
    }

    override fun onBindData(holder: ContactsViewHolder, item: ProfileDetails, position: Int) {
        holder.viewBinding.textChatName.viewTreeObserver?.addOnGlobalLayoutListener { ChatMessageUtils.fixEmojiAfterEllipses(holder.viewBinding.textChatName) }
        holder.viewBinding.textUserStatus.viewTreeObserver?.addOnGlobalLayoutListener { ChatMessageUtils.fixEmojiAfterEllipses(holder.viewBinding.textUserStatus) }

        setUserInfo(holder, item)
        holder.viewBinding.contactView.setBackgroundResource(R.drawable.recycleritem_ripple)
        holder.viewBinding.checkSelection.isChecked = item.isSelected
        holder.viewBinding.checkSelection.isVisible = (isMultiSelection && !item.isBlockedMe)
        val onClickListener = View.OnClickListener { handleContactSelection(item, holder, position) }
        holder.viewBinding.checkSelection.setOnClickListener(onClickListener)
        holder.viewBinding.contactView.setOnClickListener(onClickListener)
        if (item.isBlocked)
            holder.viewBinding.checkSelection.isClickable = false
        if (!isMultiSelection) {
            holder.viewBinding.imageChatPicture.setOnClickListener {
                listener(position, true, item)
            }
        }
        if (position == profilesList.size - 1) {
            holder.viewBinding.viewDivider.visibility = View.GONE
        }else{
            holder.viewBinding.viewDivider.visibility = View.VISIBLE
        }
        if (isMultiSelection && item.isBlocked) {
            holder.viewBinding.contactView.alpha = 0.5f
            holder.viewBinding.contactView.background = null
        } else {
            holder.viewBinding.contactView.alpha = 1.0f
            holder.viewBinding.contactView.setBackgroundResource(R.drawable.recycleritem_ripple)
        }
    }

    private fun handleContactSelection(item: ProfileDetails, holder: ContactsViewHolder, position: Int) {
        if (isMultiSelection) {
            if (isMakeCall) {
                makeCall(item, holder)
            } else {
                if (item.isBlocked) {
                    showUserUnBlockPopup(item)
                } else {
                    item.isSelected = !item.isSelected
                    holder.viewBinding.checkSelection.isChecked = item.isSelected
                }
            }
        }
        listener(position, false, item)
    }

    private fun makeCall(item: ProfileDetails, holder: ContactsViewHolder) {
        if (item.isBlocked) {
            showUserUnBlockPopup(item)
        } else {
            when {
                (groupCallMembersCount + 1) < CallManager.getMaxCallUsersCount() -> {
                    if (!item.isSelected)
                        groupCallMembersCount++
                    else
                        groupCallMembersCount--
                    item.isSelected = !item.isSelected
                    holder.viewBinding.checkSelection.isChecked = item.isSelected
                }
                item.isSelected -> {
                    groupCallMembersCount--
                    item.isSelected = !item.isSelected
                    holder.viewBinding.checkSelection.isChecked = item.isSelected
                }
                else -> {
                    holder.viewBinding.checkSelection.isChecked = false
                }
            }
        }
    }

    private fun showUserUnBlockPopup(item: ProfileDetails) {
        blockedUser = item.jid
        commonAlertDialog.showAlertDialog(String.format(context.getString(R.string.unblock_message_label), item.getDisplayName()),
            context.getString(R.string.yes_label), context.getString(R.string.no_label),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, true)
    }

    override fun onBindData(holder: ContactsViewHolder, item: ProfileDetails, position: Int, payloads: MutableList<Any>) {
        val bundle = payloads[0] as Bundle
        handlePayloads(bundle, holder, item)
    }

    private fun handlePayloads(bundle: Bundle, holder: ContactsViewHolder, profile: ProfileDetails) {
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
        try{
            return if (profilesList.size > position)
                profilesList[position].jid.hashCode().toLong()
            else
                if(profilesList.isNotEmpty()) profilesList[0].jid.hashCode().toLong() else 0
        }catch(e:ArrayIndexOutOfBoundsException){
            com.contusfly.utils.LogMessage.e(TAG,e.toString())
        }catch(e:Exception){
            com.contusfly.utils.LogMessage.e(TAG,e.toString())
        }
        return 0

    }

    /**
     * Set the user info of the user from the Roster
     *
     * @param holder View holder of recycler view
     * @param profile   ProfileDetails of the user
     */
    private fun setUserInfo(holder: ContactsViewHolder, profile: ProfileDetails) {
        holder.viewBinding.textChatName.text = profile.getDisplayName()
        holder.viewBinding.textUserStatus.gone()
        holder.viewBinding.imageChatPicture.loadUserProfileImage(context, profile)

        val status = Utils.returnEmptyStringIfNull(profile.status)

        // Set status if status not empty
        if (status.isNotEmpty() && !profile.isBlockedMe) {
            // Emoji utils Which has the emoji related common methods
            holder.viewBinding.textUserStatus.show()
            // Set user status content
            holder.viewBinding.textUserStatus.text = status
        }
    }

    override fun hasSearchKey(item: ProfileDetails, filterKey: String): Boolean {
        return item.getDisplayName().lowercase(Locale.getDefault()).contains(filterKey.lowercase(
            Locale.getDefault()
        ))
    }
}