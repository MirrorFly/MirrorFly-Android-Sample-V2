package com.contusfly.call.groupcall

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.*
import com.contusfly.adapters.BaseViewHolder
import com.contusfly.call.groupcall.listeners.RecyclerViewUserItemClick
import com.contusfly.databinding.RowProgressBarBinding
import com.contusfly.utils.Constants
import com.contusfly.utils.EmojiUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.views.CircularImageView
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import java.util.Locale
import kotlin.collections.ArrayList

class UserSelectionAdapter(val context: Context, private val isAddUserInCall: Boolean, private val commonAlertDialog: CommonAlertDialog, private val onItemClickListener: RecyclerViewUserItemClick) : RecyclerView.Adapter<RecyclerView.ViewHolder >() {

    /**
     * The ProfileDetails list to display in the recycler view.
     */
    var profileDetailsList: ArrayList<ProfileDetails> = arrayListOf()

    private var searchKey = Constants.EMPTY_STRING

    private var isLoadingAdded = false
    private var loaderPosition = -1
    /**
     * Sets the list data to rosters list clear the temp data and refresh the view
     *
     * @param profileDetailsList the new data
     */
    fun setProfileDetails(profileDetailsList: List<ProfileDetails>) {
        this.profileDetailsList = java.util.ArrayList()
        this.profileDetailsList.addAll(profileDetailsList)
    }

    /**
     * Set the updated data to ProfileDetails list and refresh the view
     *
     * @param profileDetails the new data
     */
    fun updateProfileDetails(profileDetails: ProfileDetails?) {
        val userIndex = profileDetailsList.indexOfFirst { profile -> profile.jid == profileDetails!!.jid }
        if (userIndex.isValidIndex()) {
            profileDetails?.let {
                this.profileDetailsList[userIndex] = profileDetails
                notifyItemChanged(userIndex)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder  {
        return if (viewType == ITEM) {
            UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_select_contact_item, parent, false))
        } else {
            val progressViewHolder = RowProgressBarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ProgressViewHolder(progressViewHolder)
        }
    }

    override fun getItemCount(): Int {
        return profileDetailsList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> {
                val item: ProfileDetails = profileDetailsList[position]
                Log.d(TAG, "$TAG ${item.jid}")
                holder.emailContactIcon.visibility = View.GONE
                setUserInfo(holder, item)
                holder.contactView.setBackgroundResource(R.drawable.recycleritem_ripple)
                holder.header.setOnClickListener(null)

                holder.checkBox.visibility = View.VISIBLE
                val onClickListener = View.OnClickListener { handleContactSelection(item, position, holder) }
                holder.contactView.setOnClickListener(onClickListener)
                holder.checkBox.setOnClickListener(onClickListener)

                enableCheckbox(holder, item)
            }
            is ProgressViewHolder -> {
                holder.progressViewBinding.loadMoreProgress.show()
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (profileDetailsList[position].jid.isNullOrBlank()) LOADING else ITEM
    }

    fun removeUser(jid: String) {
        val index = profileDetailsList.indexOfFirst { it.jid == jid }
        if (index.isValidIndex()) {
            profileDetailsList.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    /**
     * Enable the checkbox based on the selected list.
     */
    private fun enableCheckbox(holder: UserSelectionAdapter.UserViewHolder, item: ProfileDetails) {
        holder.checkBox.isChecked = onItemClickListener.isSelected(item.jid)
    }

    /**
     * Handle group contact selection
     *
     * @param item      Selected contact item
     * @param holder    View holder of recycler view
     */
    private fun handleContactSelection(item: ProfileDetails, position: Int, holder: UserSelectionAdapter.UserViewHolder) {
        if (item.isBlocked) {
            holder.checkBox.isChecked = false
            if (isAddUserInCall) {
                showBlockedUserPopUp(item)
            } else
                onItemClickListener.onSelectBlockedUser(item)
        } else {
            onItemClickListener.onItemClicked(position, item)
            holder.checkBox.isChecked = onItemClickListener.isSelected(item.jid)
        }
    }

    private fun showBlockedUserPopUp(item: ProfileDetails) {
        commonAlertDialog.showAlertDialog(String.format(
            context.getString(R.string.unblock_message_label),
            ProfileDetailsUtils.getDisplayName(item.jid)
        ),
            context.getString(R.string.yes_label),
            context.getString(R.string.no_label),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
            true,
            dialogListener = object : CommonAlertDialog.CommonDialogClosedListener {
                override fun onDialogClosed(
                    dialogType: CommonAlertDialog.DIALOGTYPE?,
                    isSuccess: Boolean
                ) {
                    if (isSuccess) {
                        if (AppUtils.isNetConnected(context)) {
                            FlyCore.unblockUser(item.jid) { success, _, _ ->
                                if (success) {
                                    updateProfileDetails(
                                        ProfileDetailsUtils.getProfileDetails(
                                            item.jid
                                        )
                                    )
                                } else {
                                    CustomToast.show(
                                        context,
                                        Constants.ERROR_SERVER
                                    )
                                }
                            }
                        } else {
                            CustomToast.show(
                                context,
                                context.getString(R.string.msg_no_internet)
                            )
                        }
                    }
                }

                override fun listOptionSelected(position: Int) {
                    //Do Nothing
                }

            })
    }

    /**
     * Set the user info of the user from the Roster
     *
     * @param holder View holder of recycler view
     * @param profileDetails   Roster of the user
     */
    private fun setUserInfo(holder: UserSelectionAdapter.UserViewHolder, profileDetails: ProfileDetails) {
        setUserName(holder, profileDetails)
        holder.txtStatus.visibility = View.GONE
        holder.contactLayout.alpha = if (profileDetails.isBlocked) 0.5f else 1.0f
        holder.imgRoster.loadUserProfileImage(context, profileDetails)
        val status = Utils.returnEmptyStringIfNull(profileDetails.status)

        // Set status if status not empty
        if (status.isNotEmpty() && !profileDetails.isBlockedMe) {

            // Emoji utils Which has the emoji related common methods
            holder.txtStatus.visibility = View.VISIBLE

            // Show user status
            EmojiUtils.setEmojiText(holder.txtStatus, status)
        }
    }

    private fun setUserName(holder: UserSelectionAdapter.UserViewHolder, profileDetails: ProfileDetails) {
        if(searchKey.isNotBlank()) {
            val startIndex = profileDetails.getDisplayName()!!.toLowerCase(Locale.getDefault()).indexOf(searchKey.toLowerCase(
                Locale.getDefault()))
            if (startIndex.isValidIndex()) {
                val stopIndex = startIndex + searchKey.length
                EmojiUtils.setEmojiTextAndHighLightSearchContact(context, holder.txtName, profileDetails.getDisplayName(), startIndex, stopIndex)
            } else
                holder.txtName.text = profileDetails.getDisplayName()
        } else {
            LogMessage.d(TAG, "Ongoing call contact list profileDetails: ${profileDetails.name}, ${profileDetails.nickName}, ${profileDetails.getDisplayName()}")
            holder.txtName.text = profileDetails.getDisplayName()
        }
    }


    fun addLoadingFooter() {
        if (!isLoadingAdded) {
            isLoadingAdded = true
            profileDetailsList.add(ProfileDetails())
            loaderPosition = profileDetailsList.size - 1
            notifyItemInserted(loaderPosition)
        }
    }

    fun removeLoadingFooter() {
        if (isLoadingAdded) {
            isLoadingAdded = false
            if (loaderPosition.isValidIndex() && profileDetailsList.size > loaderPosition) {
                profileDetailsList.removeAt(loaderPosition)
                notifyItemRemoved(loaderPosition)
                loaderPosition = -1
            }
        }
    }

    fun addProfileList(userList : List<ProfileDetails>) {
        val startIndex = profileDetailsList.size
        profileDetailsList.addAll(userList)
        notifyItemRangeInserted(startIndex, userList.size)
    }

    fun resetSearch() {
        loaderPosition = -1
        profileDetailsList.clear()
        notifyDataSetChanged()
    }

    fun setSearchKey(searchKey: String) {
        this.searchKey = searchKey
    }

    fun getSearchKey() : String {
        return this.searchKey
    }

    fun updateRoster(userJid: String) {
        val index = profileDetailsList.indexOfFirst { it.jid == userJid }
        if (index >= 0) {
            notifyItemChanged(index)
        }
    }


    inner class UserViewHolder(view: View) : BaseViewHolder(view) {
        /**
         * The name of the Roster.
         */
        var txtName: TextView = view.findViewById(R.id.text_chat_name)

        /**
         * The Layout of the Contact.
         */
        var contactLayout: LinearLayout = view.findViewById(R.id.contact_item)

        /**
         * The status of the Roster
         */
        var txtStatus: CustomTextView = view.findViewById(R.id.text_user_status)

        /**
         * The image view of the Roster.
         */
        var imgRoster: CircularImageView = view.findViewById(R.id.image_chat_picture)

        var emailContactIcon: CircularImageView = view.findViewById(R.id.email_contact_icon)

        /**
         * Enable the check box for multi select.
         */
        var checkBox: CheckBox = view.findViewById(R.id.check_selection)

        var header: LinearLayout = view.findViewById(R.id.header)

        var contactView: LinearLayout = view.findViewById(R.id.contact_view)
    }

    class ProgressViewHolder(var progressViewBinding: RowProgressBarBinding) : BaseViewHolder(progressViewBinding.root)

    companion object {
        private const val LOADING = 0
        private const val ITEM = 1
    }
}