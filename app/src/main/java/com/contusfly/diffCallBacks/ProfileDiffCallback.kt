package com.contusfly.diffCallBacks

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.contusfly.utils.Constants
import com.mirrorflysdk.api.contacts.ProfileDetails

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ProfileDiffCallback(private val oldList: List<ProfileDetails>, private val newList: List<ProfileDetails>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return try {
            oldList.size > oldItemPosition && newList.size > newItemPosition && oldList[oldItemPosition].jid == newList[newItemPosition].jid
        } catch (e : Exception){
            false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if (oldList.size <= oldItemPosition || newList.size <= newItemPosition)
            return false
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return isProfileObjEqual(oldItem, newItem)
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        if (oldList.size > oldItemPosition && newList.size > newItemPosition) {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            val bundle = Bundle()

            if (oldItem.isBlockedMe != newItem.isBlockedMe || oldItem.getImage() != newItem.getImage()) {
                bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 1)
                return bundle
            }
        }
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

}

fun isProfileObjEqual(oldItem: ProfileDetails?, newItem: ProfileDetails?): Boolean {
    return oldItem?.let {
        newItem?.let {
            oldItem.isMuted == newItem.isMuted && oldItem.jid == newItem.jid
                    && oldItem.isBlocked == newItem.isBlocked && oldItem.isBlockedMe == newItem.isBlockedMe
                    && oldItem.jid == newItem.jid && oldItem.isGroupInOfflineMode && newItem.isGroupInOfflineMode
                    && oldItem.isGroupProfile == newItem.isGroupProfile && oldItem.contactType == newItem.contactType
                    && oldItem.isGroupAdmin && newItem.isGroupAdmin && oldItem.name == newItem.name
                    && oldItem.email == newItem.email && oldItem.groupCreatedTime == newItem.groupCreatedTime
                    && oldItem.image == newItem.image && oldItem.imagePrivacyFlag == newItem.imagePrivacyFlag
                    && oldItem.lastSeenPrivacyFlag == newItem.lastSeenPrivacyFlag
                    && oldItem.mobileNumber == newItem.mobileNumber && oldItem.mobileNUmberPrivacyFlag == newItem.mobileNUmberPrivacyFlag
                    && oldItem.status == newItem.status && oldItem.statusPrivacyFlag == newItem.statusPrivacyFlag
                    && oldItem.nickName == newItem.nickName && oldItem.contactType == newItem.contactType
        } ?: false
    } ?: newItem?.let { false } ?: true
}