package com.contusfly.starredMessages

import androidx.recyclerview.widget.DiffUtil
import com.mirrorflysdk.api.models.ChatMessage

class StarredMessageDiffCallback(
    private val oldList: List<ChatMessage>,
    private val newList: List<ChatMessage>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return try {
            oldList.size > oldItemPosition && newList.size > newItemPosition && oldList[oldItemPosition].messageId == newList[newItemPosition].messageId
        } catch (e: Exception) {
            true
        }
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return try {
            if (oldList.size <= oldItemPosition || newList.size <= newItemPosition)
                return false
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            return isStarredMessageObjEqual(oldItem, newItem)
        } catch (e: Exception) {
            true
        }
    }

    private fun isStarredMessageObjEqual(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
        return oldItem.messageId == newItem.messageId && oldItem.messageStatus == newItem.messageStatus &&
                oldItem.senderUserName == newItem.senderUserName && oldItem.messageSentTime == newItem.messageSentTime &&
                oldItem.senderProfileImage == newItem.senderProfileImage
    }
}