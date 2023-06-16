package com.contusfly.adapters.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.chat.ImageFileUtils
import com.contusfly.databinding.RowMediaDocsItemBinding
import com.contusfly.models.GroupedMedia
import com.contusfly.utils.ChatMessageUtils
import com.contusfly.utils.ChatUtils
import com.mirrorflysdk.api.models.ChatMessage
import com.jakewharton.rxbinding3.view.clicks
import java.util.concurrent.TimeUnit

class MediaDocsViewHolder(var viewBinding: RowMediaDocsItemBinding, val onDocsClicked: (ChatMessage) -> Unit) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindValues(messageItem: GroupedMedia.MessageItem) {
        viewBinding.textDocsName.text = messageItem.chatMessage.getMediaChatMessage().getMediaFileName()
        viewBinding.textDocsSize.text = ChatUtils.getFileSizeText(com.contusfly.utils.Utils.returnEmptyStringIfNull(messageItem.chatMessage.getMediaChatMessage().getMediaFileSize()))
        viewBinding.textDocsDate.text =  ChatMessageUtils.getDateFromTimestamp(messageItem.chatMessage.getMessageSentTime(), "d/MM/yy")
        ImageFileUtils.setFileImage(viewBinding.imageDocsType,  messageItem.chatMessage.getMediaChatMessage().getMediaFileName())
        viewBinding.mediaViewItem.clicks().throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe {
            onDocsClicked(messageItem.chatMessage)
        }
    }

    companion object {
        fun create(parent: ViewGroup, onDocsClicked: (ChatMessage) -> Unit): MediaDocsViewHolder {
            val binding = RowMediaDocsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MediaDocsViewHolder(binding, onDocsClicked)
        }
    }
}