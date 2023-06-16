package com.contusfly.adapters.holders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.*
import com.contusfly.databinding.GridMediaItemBinding
import com.contusfly.models.GroupedMedia
import com.contusfly.utils.ImageUtils
import com.mirrorflysdk.api.models.ChatMessage
import com.jakewharton.rxbinding3.view.clicks
import java.util.concurrent.TimeUnit

class MediaGridViewHolder(val context: Context, var viewBinding: GridMediaItemBinding, val onMediaIconClicked: (ChatMessage) -> Unit) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindValues(messageItem: GroupedMedia.MessageItem) {
        viewBinding.imgPlay.visibility = if (messageItem.chatMessage.isVideoMessage()) View.VISIBLE else View.GONE
        var placeHolder = 0

        // Check the message type to set the place holder
        if (messageItem.chatMessage.getMessageType() == MessageType.AUDIO) {
            placeHolder = R.color.color_translate_bar
            viewBinding.imgAudioIcon.setImageResource(if (messageItem.chatMessage.getMediaChatMessage().isAudioRecorded()) R.drawable.ic_media_record else R.drawable.ic_media_music)
            viewBinding.imgAudioIcon.show()
        } else
            viewBinding.imgAudioIcon.gone()
        ImageUtils.loadVideoThumbnail(context, messageItem.chatMessage.getMediaChatMessage().getMediaLocalStoragePath(), viewBinding.rowImgItem, placeHolder)
        viewBinding.mediaViewItem.clicks().throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe {
            onMediaIconClicked(messageItem.chatMessage)
        }
    }

    companion object {
        fun create(parent: ViewGroup, onMediaIconClicked: (ChatMessage) -> Unit): MediaGridViewHolder {
            val binding = GridMediaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MediaGridViewHolder(parent.context, binding, onMediaIconClicked)
        }
    }
}