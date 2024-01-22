package com.contusfly.diffCallBacks

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.models.RecentChat

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class RecentChatDiffCallback(private val oldList: List<RecentChat>, private val newList: List<RecentChat>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return try {
            (oldList.size > oldItemPosition && newList.size > newItemPosition && isJidEqual(oldList[oldItemPosition], newList[newItemPosition])
                    && !SharedPreferenceManager.getBoolean(Constants.IS_TIME_FORMAT_CHANGED)) //Update recent chat row if device time format changes
        }catch (e:NullPointerException){
            false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if (oldList.size <= oldItemPosition || newList.size <= newItemPosition)
            return false
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return isRecentObjEqual(oldItem, newItem)
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        if (oldList.size > oldItemPosition && newList.size > newItemPosition) {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            val bundle = getChangePayloadAsBundle(oldItem, newItem)

            if (bundle.keySet().isNotEmpty())
                return bundle
        }
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    private fun getChangePayloadAsBundle(oldItem: RecentChat, newItem: RecentChat): Bundle {
        val bundle = Bundle()
        if (oldItem.lastMessageId != newItem.lastMessageId || oldItem.lastMessageTime != newItem.lastMessageTime
            || SharedPreferenceManager.getBoolean(Constants.IS_TIME_FORMAT_CHANGED)) //Update recent chat row if device time format changes
            bundle.putInt(Constants.NOTIFY_MESSAGE_UPDATE, 1)
        if (oldItem.profileName != newItem.profileName)
            bundle.putInt(Constants.NOTIFY_USER_NAME, 1)
        if (oldItem.isBlockedMe != newItem.isBlockedMe || oldItem.profileImage != newItem.profileImage)
            bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 1)
        if (oldItem.unreadMessageCount != newItem.unreadMessageCount)
            bundle.putInt(Constants.NOTIFY_UNREAD_ICON, 1)
        if (oldItem.isMuted != newItem.isMuted)
            bundle.putInt(Constants.NOTIFY_MUTE_UNMUTE, 1)
        if (oldItem.isChatPinned != newItem.isChatPinned)
            bundle.putInt(Constants.NOTIFY_PINNED_ICON, 1)

        return bundle
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

}

fun isRecentObjEqual(oldItem: RecentChat, newItem: RecentChat): Boolean {
    return isJidEqual(oldItem, newItem) && oldItem.nickName == newItem.nickName
            && oldItem.profileName == newItem.profileName && oldItem.profileImage == newItem.profileImage
            && oldItem.isGroup == newItem.isGroup && oldItem.isBroadCast == newItem.isBroadCast
            && oldItem.unreadMessageCount == newItem.unreadMessageCount && oldItem.isChatArchived == newItem.isChatArchived
            && oldItem.lastMessageId == newItem.lastMessageId && oldItem.lastMessageStatus == newItem.lastMessageStatus
            && oldItem.lastMessageContent == newItem.lastMessageContent && oldItem.lastMessageTime == newItem.lastMessageTime
            && oldItem.lastMessageType == newItem.lastMessageType && oldItem.isLastMessageSentByMe == newItem.isLastMessageSentByMe
            && oldItem.isLastMessageRecalledByUser == newItem.isLastMessageRecalledByUser && oldItem.isMuted == newItem.isMuted
            && oldItem.isBlocked == newItem.isBlocked && oldItem.isBlockedMe == newItem.isBlockedMe
            && oldItem.isChatPinned == newItem.isChatPinned && oldItem.isGroupInOfflineMode == newItem.isGroupInOfflineMode
            && oldItem.contactType == newItem.contactType
            && oldItem.isLastMessageEdited ==newItem.isLastMessageEdited
}

private fun isJidEqual(oldRecentChat: RecentChat, newRecentChat: RecentChat): Boolean {
    return oldRecentChat.jid != null && newRecentChat.jid != null && oldRecentChat.jid == newRecentChat.jid
}