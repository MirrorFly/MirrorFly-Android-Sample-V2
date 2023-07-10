/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.adapters.BlockedContactsAdapter.BlockedContactsViewHolder
import com.contusfly.databinding.RowContactItemBinding
import com.contusfly.getDisplayName
import com.contusfly.loadUserProfileImage
import com.contusfly.utils.ChatMessageUtils.fixEmojiAfterEllipses
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.Utils
import java.util.*

/**
 * This adapter used to showing the blocked users in recyclerview
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class BlockedContactsAdapter(private val context: Context, val listener: (profile: ProfileDetails) -> Unit) : RecyclerView.Adapter<BlockedContactsViewHolder>() {
    /**
     * The temporary data of the list to reuse the list.
     */
    private var mTempData: ArrayList<ProfileDetails>? = null

    /**
     * Sets the list data to rosters list clear the temp data and refresh the view
     *
     * @param profileDetails the new data
     */
    fun setBlockedProfiles(profileDetails: ArrayList<ProfileDetails>?) {
        if (mTempData != null) mTempData!!.clear()
        mTempData = profileDetails
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BlockedContactsViewHolder {
        val binding = RowContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlockedContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlockedContactsViewHolder,
                                  position: Int) {
        try {
            val item = mTempData!![position]
            setUserInfo(holder, item)
            if (position == mTempData!!.size - 1) {
                holder.viewBinding.viewDivider.setVisibility(View.GONE);
            }else{
                holder.viewBinding.viewDivider.setVisibility(View.VISIBLE);
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Set the user info of the user from the Roster
     *
     * @param holder View holder of recycler view
     * @param item   Roster of the user
     */
    private fun setUserInfo(holder: BlockedContactsViewHolder, item: ProfileDetails) {
        holder.viewBinding.textChatName.viewTreeObserver.addOnGlobalLayoutListener { fixEmojiAfterEllipses(holder.viewBinding.textChatName) }
        if (item.getDisplayName().isNotEmpty()) {
            holder.viewBinding.textChatName.text = item.getDisplayName()
        }
        holder.viewBinding.imageChatPicture.loadUserProfileImage(context, item)
        holder.viewBinding.textUserStatus.visibility = View.VISIBLE
        holder.viewBinding.textUserStatus.text = Utils.getFormattedPhoneNumber(Utils.returnEmptyStringIfNull(item.mobileNumber))
        holder.viewBinding.contactItem.setOnClickListener {
            listener(item)
        }
    }

    override fun getItemCount(): Int {
        return mTempData?.size ?: 0
    }

    /**
     * This class containing the view of the contact items
     */
    class BlockedContactsViewHolder(var viewBinding: RowContactItemBinding) : BaseViewHolder(viewBinding.root)
}