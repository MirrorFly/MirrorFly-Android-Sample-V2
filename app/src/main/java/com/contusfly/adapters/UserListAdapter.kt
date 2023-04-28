package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.*
import com.contusfly.adapters.holders.ProgressViewHolder
import com.contusfly.databinding.RowContactItemBinding
import com.contusfly.databinding.RowProgressBarBinding
import com.contusfly.interfaces.ContactHelperListener
import com.contusfly.utils.*
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import java.util.*
import kotlin.collections.ArrayList


class UserListAdapter(val context: Context, private val commonAlertDialog: CommonAlertDialog, private val isMultiSelection: Boolean,
                      private val isMakeCall: Boolean, val listener: ContactHelperListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ContactsViewHolder(var contactViewBinding: RowContactItemBinding) : BaseViewHolder(contactViewBinding.root)

    private var profilesList: ArrayList<ProfileDetails> = arrayListOf()

    private var groupCallMembersCount = 0
    private var searchKey = Constants.EMPTY_STRING

    private var isLoadingAdded = false
    private var loaderPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == AppConstants.ITEM) {
            val contactsViewHolder = RowContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ContactsViewHolder(contactsViewHolder)
        } else {
            val progressViewHolder = RowProgressBarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ProgressViewHolder(progressViewHolder)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (profilesList[position].jid.isNullOrBlank()) AppConstants.LOADING else AppConstants.ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ContactsViewHolder -> {
                bindContactData(holder, profilesList[position], position)
            }
            is ProgressViewHolder -> {
                holder.progressViewBinding.loadMoreProgress.show()
            }
        }
    }

    override fun getItemCount(): Int {
        return profilesList.size
    }

    private fun bindContactData(
        holder: ContactsViewHolder,
        item: ProfileDetails,
        position: Int
    ) {
        holder.contactViewBinding.textChatName.viewTreeObserver?.addOnGlobalLayoutListener { ChatMessageUtils.fixEmojiAfterEllipses(holder.contactViewBinding.textChatName) }
        holder.contactViewBinding.textUserStatus.viewTreeObserver?.addOnGlobalLayoutListener { ChatMessageUtils.fixEmojiAfterEllipses(holder.contactViewBinding.textUserStatus) }

        setUserInfo(holder, item)
        holder.contactViewBinding.contactView.setBackgroundResource(R.drawable.recycleritem_ripple)
        holder.contactViewBinding.checkSelection.isChecked = listener.isSelected(item.jid)
        holder.contactViewBinding.checkSelection.isVisible = (isMultiSelection && !item.isBlockedMe)
        val onClickListener = View.OnClickListener { handleContactSelection(item, holder) }
        holder.contactViewBinding.checkSelection.setOnClickListener(onClickListener)
        holder.contactViewBinding.contactView.setOnClickListener(onClickListener)
        if (item.isBlocked)
            holder.contactViewBinding.checkSelection.isClickable = false
        if (!isMultiSelection) {
            holder.contactViewBinding.imageChatPicture.setOnClickListener {
                listener.onItemClicked(true, item)
            }
        }
        if (position == profilesList.size - 1) {
            holder.contactViewBinding.viewDivider.visibility = View.GONE
        }else{
            holder.contactViewBinding.viewDivider.visibility = View.VISIBLE
        }
        if (isMultiSelection && item.isBlocked) {
            holder.contactViewBinding.contactView.alpha = 0.5f
            holder.contactViewBinding.contactView.background = null
        } else {
            holder.contactViewBinding.contactView.alpha = 1.0f
            holder.contactViewBinding.contactView.setBackgroundResource(R.drawable.recycleritem_ripple)
        }
    }

    /**
     * Set the user info of the user from the Roster
     *
     * @param holder View holder of recycler view
     * @param profile   ProfileDetails of the user
     */
    private fun setUserInfo(holder: ContactsViewHolder, profile: ProfileDetails) {
        setUserName(holder, profile)
        holder.contactViewBinding.textUserStatus.gone()
        holder.contactViewBinding.imageChatPicture.loadUserProfileImage(context, profile)

        val status = Utils.returnEmptyStringIfNull(profile.status)

        // Set status if status not empty
        if (status.isNotEmpty() && !profile.isBlockedMe) {
            // Emoji utils Which has the emoji related common methods
            holder.contactViewBinding.textUserStatus.show()
            // Set user status content
            holder.contactViewBinding.textUserStatus.text = status
        }
    }

    private fun setUserName(holder: ContactsViewHolder, profile: ProfileDetails) {
        if(searchKey.isNotBlank()) {
            val startIndex = profile.getDisplayName()!!.toLowerCase(Locale.getDefault()).indexOf(searchKey.toLowerCase(Locale.getDefault()))
            if (startIndex.isValidIndex()) {
                val stopIndex = startIndex + searchKey.length
                EmojiUtils.setEmojiTextAndHighLightSearchContact(context, holder.contactViewBinding.textChatName, profile.getDisplayName(), startIndex, stopIndex)
            } else
                holder.contactViewBinding.textChatName.text = profile.getDisplayName()
        } else {
            LogMessage.d(TAG, "UserListAdapter profileDetails: ${profile.name}, ${profile.nickName}, ${profile.getDisplayName()}")
            holder.contactViewBinding.textChatName.text = profile.getDisplayName()
        }
    }

    private fun handleContactSelection(item: ProfileDetails, holder: ContactsViewHolder) {
        if (isMultiSelection) {
            if (isMakeCall) {
                makeCall(item, holder)
            } else {
                if (item.isBlocked) {
                    showUserUnBlockPopup(item)
                } else {
                    holder.contactViewBinding.checkSelection.isChecked = !listener.isSelected(item.jid)
                }
            }
        }
        listener.onItemClicked(false, item)
    }

    private fun makeCall(item: ProfileDetails, holder: ContactsViewHolder) {
        if (item.isBlocked) {
            showUserUnBlockPopup(item)
        } else {
            when {
                (groupCallMembersCount + 1) < CallManager.getMaxCallUsersCount() -> {
                    if (!listener.isSelected(item.jid))
                        groupCallMembersCount++
                    else
                        groupCallMembersCount--
                    holder.contactViewBinding.checkSelection.isChecked = !listener.isSelected(item.jid)
                }
                listener.isSelected(item.jid) -> {
                    groupCallMembersCount--
                    holder.contactViewBinding.checkSelection.isChecked = !listener.isSelected(item.jid)
                }
                else -> {
                    holder.contactViewBinding.checkSelection.isChecked = false
                }
            }
        }
    }

    private fun showUserUnBlockPopup(item: ProfileDetails) {
        commonAlertDialog.showAlertDialog(String.format(context.getString(R.string.unblock_message_label), item.name),
            context.getString(R.string.yes_label), context.getString(R.string.no_label),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, true, dialogListener = object : CommonAlertDialog.CommonDialogClosedListener{
                override fun onDialogClosed(
                    dialogType: CommonAlertDialog.DIALOGTYPE?,
                    isSuccess: Boolean
                ) {
                    if (isSuccess) {
                        if (AppUtils.isNetConnected(context)) {
                            FlyCore.unblockUser(item.jid) { success, _, _ ->
                                if (success) {
                                    item.isBlocked = false
                                } else {
                                    CustomToast.show(context, Constants.ERROR_SERVER)
                                }
                            }
                        } else {
                            CustomToast.show(context, context.getString(R.string.msg_no_internet))
                        }
                    }
                }

                override fun listOptionSelected(position: Int) {
                    //Not Needed
                }

            })
    }


    fun addLoadingFooter() {
        if (!isLoadingAdded) {
            isLoadingAdded = true
            profilesList.add(ProfileDetails())
            loaderPosition = profilesList.size - 1
            notifyItemInserted(loaderPosition)
        }
    }

    fun removeLoadingFooter() {
        if (isLoadingAdded) {
            isLoadingAdded = false
            if (loaderPosition.isValidIndex() && profilesList.size > loaderPosition) {
                profilesList.removeAt(loaderPosition)
                notifyItemRemoved(loaderPosition)
                loaderPosition = -1
            }
        }
    }

    fun addProfileList(userList : List<ProfileDetails>) {
        val startIndex = profilesList.size
        profilesList.addAll(userList)
        notifyItemRangeInserted(startIndex, userList.size)
    }

    fun resetSearch() {
        loaderPosition = -1
        profilesList.clear()
        notifyDataSetChanged()
    }

    fun setSearchKey(searchKey: String) {
        this.searchKey = searchKey
    }

    fun getSearchKey() : String {
        return this.searchKey
    }

    fun updateUserProfileInfo(jid: String) {
        try {
            val userIndex = profilesList.indexOfFirst { profile -> profile.jid == jid }
            if (userIndex.isValidIndex()) {
                val updatedProfile = ProfileDetailsUtils.getProfileDetails(jid)!!
                profilesList[userIndex] = updatedProfile
                notifyItemChanged(userIndex)
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    fun removeUserProfile(jid: String) {
        try {
            val userIndex = profilesList.indexOfFirst { profile -> profile.jid == jid }
            if (userIndex.isValidIndex()) {
                profilesList.removeAt(userIndex)
                notifyItemRemoved(userIndex)
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }
}