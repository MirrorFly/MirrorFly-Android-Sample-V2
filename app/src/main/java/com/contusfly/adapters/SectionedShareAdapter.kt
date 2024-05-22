package com.contusfly.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.emoji.widget.EmojiAppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.*
import com.contusfly.databinding.RowProgressBarBinding
import com.contusfly.databinding.RowShareItemBinding
import com.contusfly.interfaces.GetGroupUsersNameCallback
import com.contusfly.interfaces.RecyclerViewItemClick
import com.contusfly.models.ProfileDetailsShareModel
import com.contusfly.utils.Constants
import com.contusfly.utils.EmojiUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import java.util.*


/**
 * Display the contact list in the Activity from the list of ProfileDetails.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class SectionedShareAdapter(private val context: Context, private val commonAlertDialog: CommonAlertDialog, private val onItemClickListener: RecyclerViewItemClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    /**
     * The ProfileDetails list to display in the recycler view.
     */
    private var profileDetailsList: MutableList<ProfileDetailsShareModel> = mutableListOf()

    private var searchKey = Constants.EMPTY_STRING

    private var isLoadingAdded = false


    fun getSearchKey() : String {
        return searchKey
    }
    /**
     * Sets the list data to ProfileDetails list clear the temp data and refresh the view
     *
     * @param profileDetailsList the new data
     */
    fun setProfileDetails(profileDetailsList: List<ProfileDetailsShareModel>) {
        this.profileDetailsList.clear()
        this.profileDetailsList.addAll(profileDetailsList)
    }

    /**
     * Set the updated data to ProfileDetails list and refresh the view
     *
     * @param profileDetails the new data
     */
    fun updateProfileDetails(profileDetails: ProfileDetails?) {
        profileDetails?.let {
            val position = profileDetailsList.indexOfFirst { it.profileDetails.jid == profileDetails.jid }
            if (position.isValidIndex()) {
                profileDetailsList[position].profileDetails = profileDetails
                runOnUiThread(Runnable {
                    notifyItemChanged(position)
                })
            }
        }
    }

    /**
     * Set the updated data to ProfileDetails list and refresh the view
     *
     * @param shareModel the new data
     */
    fun addProfileDetails(position: Int, shareModel: ProfileDetailsShareModel?) {
        shareModel?.let {
            if (this.profileDetailsList.none { it.profileDetails.jid == shareModel.profileDetails.jid}) {
                this.profileDetailsList.add(position, shareModel)
                notifyItemInserted(position)
            }
        }
    }

    fun addProfileList(userList : List<ProfileDetailsShareModel>) {
        val startIndex = profileDetailsList.size
        profileDetailsList.addAll(userList)
        notifyItemRangeInserted(startIndex, userList.size)
    }

    fun addLoadingFooter() {
        if (!isLoadingAdded) {
            isLoadingAdded = true
            profileDetailsList.add(ProfileDetailsShareModel(ChatType.TYPE_CHAT, ProfileDetails()))
            notifyItemInserted(profileDetailsList.size - 1)
        }
    }

    fun removeLoadingFooter() {
        if (isLoadingAdded) {
            isLoadingAdded = false
            val loaderPosition = profileDetailsList.indexOfFirst { it.profileDetails.jid.isNullOrBlank() }
            if (loaderPosition.isValidIndex()) {
                profileDetailsList.removeAt(loaderPosition)
                notifyItemRemoved(loaderPosition)
            }
        }
    }

    /**
     * Remove the profile details from the adapter
     *
     * @param userId of the user
     */
    fun removeProfileDetails(userId: String) {
        val index = profileDetailsList.indexOfFirst { it.profileDetails.jid == userId }
        if (index.isValidIndex()) {
            profileDetailsList.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM) {
            val binding = RowShareItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ShareViewHolder(binding)
        } else {
            val progressViewHolder = RowProgressBarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ProgressViewHolder(progressViewHolder)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (profileDetailsList[position].profileDetails.jid.isNullOrBlank()) LOADING else ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ShareViewHolder -> {
                try {
                    enableHeader(holder.viewBinding.viewSectionHeader, holder.viewBinding.headerSectionTextView, position)
                    viewContactsAndGroups(holder, position)
                } catch (e: Exception) {
                    LogMessage.e(e)
                }
            }
            is ProgressViewHolder -> {
                enableHeader(holder.progressViewBinding.viewSectionHeader, holder.progressViewBinding.headerSectionTextView, position)
                holder.progressViewBinding.loadMoreProgress.show()
            }
        }
    }

    /**
     * Display the searched message view item
     *
     * @param holder   Holder of the Chat item
     * @param position Position of the selected item
     */
    private fun viewContactsAndGroups(holder: ShareViewHolder, position: Int) {
        try {
            val item = profileDetailsList[position]
            setUserInfo(holder, item)
            val onClickListener = View.OnClickListener { handleContactSelection(item, holder, position) }
            holder.viewBinding.viewSectionHeader.setOnClickListener {
                //do nothing.
            }
            holder.viewBinding.centerLayout.setOnClickListener(onClickListener)
            holder.viewBinding.contactItem.setOnClickListener(onClickListener)
            holder.viewBinding.checkSelection.setOnClickListener(onClickListener)
            holder.viewBinding.checkSelection.isChecked = onItemClickListener.isSelected(item.profileDetails.jid)
            if (item.profileDetails.isBlocked)
                holder.viewBinding.checkSelection.isClickable = false
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Handle group contact selection
     *
     * @param item   Selected contact item
     * @param position position of the item
     */
    private fun handleContactSelection(item: ProfileDetailsShareModel, holder: ShareViewHolder, position: Int) {
        if (item.profileDetails.isGroupProfile && ChatManager.getAvailableFeatures().isGroupChatEnabled && !GroupManager.isMemberOfGroup(item.profileDetails.jid, SharedPreferenceManager.getCurrentUserJid())) {
            holder.viewBinding.checkSelection.isChecked = false
            CustomToast.show(context, context.getString(R.string.user_no_longer_error_message))
            return
        }
        if (!(item.profileDetails.isGroupProfile && item.profileDetails.isGroupInOfflineMode) && !item.profileDetails.isBlocked) {
            onItemClickListener.onItemClicked(position, item.profileDetails)
            holder.viewBinding.checkSelection.isChecked = onItemClickListener.isSelected(item.profileDetails.jid)
        } else if (item.profileDetails.isBlocked) {
            commonAlertDialog.showAlertDialog(String.format(context.getString(R.string.unblock_message_label), item.profileDetails.getDisplayName()),
                context.getString(R.string.yes_label), context.getString(R.string.no_label),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, true, dialogListener = object : CommonAlertDialog.CommonDialogClosedListener {
                    override fun onDialogClosed(
                        dialogType: CommonAlertDialog.DIALOGTYPE?,
                        isSuccess: Boolean
                    ) {
                        if (isSuccess) {
                            unblockUser(item)
                        }
                    }

                    override fun listOptionSelected(position: Int) {
                        //Do nothing
                    }
                })
        }
    }

    private fun unblockUser(item: ProfileDetailsShareModel) {
        if (AppUtils.isNetConnected(context)) {
            FlyCore.unblockUser(item.profileDetails.jid) { success, _, _ ->
                if (success) {
                    updateProfileDetails(ProfileDetailsUtils.getProfileDetails(item.profileDetails.jid))
                } else {
                    CustomToast.show(context, Constants.ERROR_SERVER)
                }
            }
        } else {
            CustomToast.show(context, context.getString(R.string.msg_no_internet))
        }
    }

    /**
     * Set the user info of the user from the ProfileDetails
     *
     * @param holder View holder of recycler view
     * @param item   ProfileDetails of the user
     */
    private fun setUserInfo(holder: ShareViewHolder, item: ProfileDetailsShareModel) {
        val profileDetails = item.profileDetails
        setRosterImage(holder, profileDetails)
        handleStatus(holder.viewBinding.textUserStatus, profileDetails.getChatType(), profileDetails)
        if (profileDetails.isGroupInOfflineMode || profileDetails.isBlocked) {
            holder.viewBinding.contactView.alpha = 0.5f
            holder.viewBinding.contactView.background = null
        } else {
            holder.viewBinding.contactView.alpha = 1.0f
            holder.viewBinding.contactView.setBackgroundResource(R.drawable.recycleritem_ripple)
        }
    }

    /**
     * Set the image view of the recent chat for user, broadcast, group chat
     *
     * @param holder Instance of the RecentViewHolder
     * @param profileDetails Instance of the ProfileDetails
     */
    private fun setRosterImage(holder: ShareViewHolder, profileDetails: ProfileDetails) {
        if(searchKey.isNotBlank()){
            val startIndex = profileDetails.getDisplayName()!!.toLowerCase(Locale.getDefault()).indexOf(searchKey.toLowerCase(Locale.getDefault()))
            if (startIndex.isValidIndex()) {
                val stopIndex = startIndex + searchKey.length
                EmojiUtils.setEmojiTextAndHighLightSearchContact(context, holder.viewBinding.textChatName, profileDetails.getDisplayName(), startIndex, stopIndex)
            } else
                holder.viewBinding.textChatName.text = profileDetails.getDisplayName()
        } else {
            holder.viewBinding.textChatName.text = profileDetails.getDisplayName()
        }
        holder.viewBinding.imageChatPicture.loadUserProfileImage(context, profileDetails)
    }

    override fun getItemCount(): Int {
        return profileDetailsList.size
    }

    /**
     * Set the search key to highlight search results
     *
     * @param filterKey The search filter key
     */
    fun setSearchKey(filterKey: String) {
        searchKey = filterKey
    }

    /**
     * Enable the header, that might be Chats or MessagesModel or Contacts.
     *
     * @param viewSectionHeader   Linear layout of the header
     * @param headerSectionTextView   Text view of the header
     * @param position Position of the List
     */
    private fun enableHeader(viewSectionHeader: LinearLayout, headerSectionTextView: CustomTextView, position: Int) {
        /**
         * Enable header if position is zero or previous item is different
         */
        if (position == 0 || canEnableHeader(position)) {
            viewSectionHeader.visibility = View.VISIBLE
            setSearchHeader(headerSectionTextView, position)
        } else {
            viewSectionHeader.visibility = View.GONE
        }
    }


    /**
     * Set the search header in the chat item, which is the Search type
     *
     * @param headerSectionTextView  Text view of the header
     * @param position           Position of the list item
     */
    private fun setSearchHeader(headerSectionTextView: CustomTextView, position: Int) {
        val profileDetailsItem = profileDetailsList[position]
        when {
            profileDetailsItem.type.equals(ChatType.TYPE_GROUP_CHAT, true) -> {
                headerSectionTextView.text = context.getString(R.string.groups)
            }
            profileDetailsItem.type.equals(ChatType.TYPE_CHAT, true) -> {
                headerSectionTextView.text = context.getString(R.string.contacts)
            }
            else -> {
                headerSectionTextView.text = context.getString(R.string.recent_chat)
            }
        }
    }

    /**
     * Check the header is needed for the chat item. Search type of the current item and previous
     * item is different then return true
     *
     * @param position Position of the list item
     * @return boolean True if the header need to enable
     */
    private fun canEnableHeader(position: Int): Boolean {
        return profileDetailsList[position].type != profileDetailsList[position - 1].type
    }

    private fun handleStatus(statusTextView: EmojiAppCompatTextView, type: String, profileDetails: ProfileDetails) {
        Log.d("handleStatus", type)
        if (type.equals(ChatType.TYPE_CHAT, true)) {
            setStatusForChatUsers(statusTextView, profileDetails)
        } else {
            setStatusForGroupAndBroadcastUsers(statusTextView, profileDetails)
        }
    }

    private fun setStatusForChatUsers(statusTextView: EmojiAppCompatTextView, profileDetails: ProfileDetails) {
        val status = Utils.returnEmptyStringIfNull(profileDetails.status)
        /**
         * Set status if status not empty
         */
        if (status.isNotEmpty() && !profileDetails.isBlockedMe) {
            /**
             * Show user status
             */
            statusTextView.visibility = View.VISIBLE
            EmojiUtils.setEllipsisText(statusTextView, status)
        } else {
            statusTextView.visibility = View.GONE
        }
    }

    private fun setStatusForGroupAndBroadcastUsers(statusTextView: EmojiAppCompatTextView, profileDetails: ProfileDetails) {
        ProfileDetailsUtils.getGroupUsersNames(profileDetails.jid, object : GetGroupUsersNameCallback {
            override fun onGroupUsersNamePrepared(names: String) {
                Log.d("STATUS_GNB", names)
                statusTextView.visibility = View.VISIBLE
                EmojiUtils.setEmojiText(statusTextView, names)
            }
        })
    }

    /**
     * This class containing the view of the contact items
     */
    class ShareViewHolder(val viewBinding: RowShareItemBinding) : RecyclerView.ViewHolder(viewBinding.root)
    class ProgressViewHolder(var progressViewBinding: RowProgressBarBinding) : RecyclerView.ViewHolder(progressViewBinding.root)

    companion object {
        private const val LOADING = 0
        private const val ITEM = 1
    }
}