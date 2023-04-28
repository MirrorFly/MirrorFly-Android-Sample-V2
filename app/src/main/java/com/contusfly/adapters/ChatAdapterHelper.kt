/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.contusfly.*
import com.contusfly.adapters.base.BaseChatAdapterHelper
import com.contusfly.adapters.holders.*
import com.contusfly.utils.Constants
import com.mirrorflysdk.api.models.ChatMessage


/**
 * Helper class for Chat view Adapter
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ChatAdapterHelper internal constructor(private var inflater: LayoutInflater?) : BaseChatAdapterHelper() {

    /**
     * Show or Hides the sender name view based on position
     *
     * @param senderNameHolder Sender name view holder
     * @param messageList      messages list
     * @param position         Position of the view
     */
    fun showHideSenderName(senderNameHolder: SenderNameHolder, messageList: List<ChatMessage>, position: Int) {
        with(senderNameHolder) {
            if (position == 0 || isSenderChanged(messageList, position) || !isMessageDateEqual(messageList, position))
                showSenderNameView(messageList[position].getSenderUserJid())
            else
                hideSendNameView()
        }
    }

    /**
     * Checks the current header id with previous header id
     *
     * @param position Position of the current item
     * @return boolean True if header changed, else false
     */
    private fun isSenderChanged(messageList: List<ChatMessage>, position: Int): Boolean {
        val currentMessage = messageList[position]
        val previousMessage = messageList[position - 1]
        if (currentMessage.isMessageSentByMe != previousMessage.isMessageSentByMe ||
            previousMessage.messageType.name.equals(Constants.MSG_TYPE_NOTIFICATION, true) ||
            (currentMessage.messageChatType.name == Constants.GROUP_CHAT && currentMessage.isThisAReplyMessage)) {
            return true
        }
        var currentSenderJid = currentMessage.getSenderUserJid()
        currentSenderJid = currentSenderJid ?: ""
        var previousSenderJid = previousMessage.getSenderUserJid()
        previousSenderJid = previousSenderJid ?: ""
        return previousSenderJid != currentSenderJid
    }

    /**
     * Show or Hides the space view based on position
     *
     * @param space       Space view
     * @param position    Position of the view
     * @param messageList messages list
     */
    fun showHideSpace(space: View, position: Int, messageList: List<ChatMessage>) {
        space.visibility = if (position == 0 || isSenderChanged(messageList, position)
                || !isMessageDateEqual(messageList, position)) View.VISIBLE else View.GONE
    }

    /**
     * Get the View holder of the chat view.
     *
     * @param parent   Parent view group
     * @param viewType Type of the view
     * @return RecyclerView.HorizontalViewHolder Holder for the view
     */
    fun getItemViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        val holder: RecyclerView.ViewHolder?
        val view: View
        when (viewType) {
            ChatAdapter.TYPE_TEXT_SENDER -> {
                view = inflater!!.inflate(R.layout.row_chat_txt_sender_item, parent, false)
                holder = TextSentViewHolder(view)
            }
            ChatAdapter.TYPE_TEXT_RECEIVER -> {
                view = inflater!!.inflate(R.layout.row_chat_txt_receiver_item, parent, false)
                holder = TextReceivedViewHolder(view)
            }
            ChatAdapter.TYPE_LOCATION_SENDER -> {
                view = inflater!!.inflate(R.layout.row_chat_location_sender_item, parent, false)
                holder = LocationSentViewHolder(view)
            }
            ChatAdapter.TYPE_LOCATION_RECEIVER -> {
                view = inflater!!.inflate(R.layout.row_chat_location_receiver_item, parent, false)
                holder = LocationReceivedViewHolder(view)
            }
            ChatAdapter.TYPE_FILE_SENDER -> {
                view = inflater!!.inflate(R.layout.list_chat_file_sent_item, parent, false)
                holder = FileSentViewHolder(view)
            }
            ChatAdapter.TYPE_FILE_RECEIVER -> {
                view = inflater!!.inflate(R.layout.list_chat_file_received_item, parent, false)
                holder = FileReceivedViewHolder(view)
            }
            ChatAdapter.TYPE_CONTACT_SENDER -> {
                view = inflater!!.inflate(R.layout.list_chat_contact_sent_item, parent, false)
                holder = ContactSentViewHolder(view)
            }
            ChatAdapter.TYPE_CONTACT_RECEIVER -> {
                view = inflater!!.inflate(R.layout.list_chat_contact_received_item, parent, false)
                holder = ContactReceivedViewHolder(view)
            }
            ChatAdapter.TYPE_MSG_NOTIFICATION -> {
                view = inflater!!.inflate(R.layout.row_chat_notification_item, parent, false)
                holder = NotificationViewHolder(view)
            }
            else -> holder = getMediaItemViewHolder(parent, viewType)
        }
        return holder
    }

    /**
     * Handle view holders for the views based on the type
     *
     * @param parent   Parent view
     * @param viewType Type of the view
     * @return RecyclerView.HorizontalViewHolder Holder for the view
     */
    private fun getMediaItemViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        var holder: RecyclerView.ViewHolder? = null
        val view: View
        when (viewType) {
            ChatAdapter.TYPE_IMAGE_SENDER -> {
                view = inflater!!.inflate(R.layout.row_chat_img_sender_item, parent, false)
                holder = ImageSentViewHolder(view)
            }
            ChatAdapter.TYPE_IMAGE_RECEIVER -> {
                view = inflater!!.inflate(R.layout.row_chat_img_receiver_item, parent, false)
                holder = ImageReceivedViewHolder(view)
            }
            ChatAdapter.TYPE_VIDEO_SENDER -> {
                view = inflater!!.inflate(R.layout.row_chat_video_sender_item, parent, false)
                holder = VideoSentViewHolder(view)
            }
            ChatAdapter.TYPE_VIDEO_RECEIVER -> {
                view = inflater!!.inflate(R.layout.row_chat_video_receiver_item, parent, false)
                holder = VideoReceivedViewHolder(view)
            }
            ChatAdapter.TYPE_AUDIO_SENDER -> {
                view = inflater!!.inflate(R.layout.list_chat_audio_sent_item, parent, false)
                holder = AudioSentViewHolder(view)
            }
            ChatAdapter.TYPE_AUDIO_RECEIVER -> {
                view = inflater!!.inflate(R.layout.list_chat_audio_received_item, parent, false)
                holder = AudioReceivedViewHolder(view)
            }
        }
        return holder
    }

    /**
     * Sets the file status. The action contains
     *
     *
     * => MEDIA_DOWNLOADED => MEDIA_UPLOADED => MEDIA_DOWNLOADING => MEDIA_UPLOADING =>
     * MEDIA_NOT_DOWNLOADED => MEDIA_NOT_UPLOADED
     *
     * @param cancelLayout  Cancel the media Upload or Download layout
     * @param progressBar       Progress bar of the image view
     * @param status            Status of the message
     * @param viewUploadOrDownload  Upload or Download action layout
     * @param messageId         Message id of the message
     */
    fun presentFileTypeView(cancelLayout: RelativeLayout,
                            progressBar: ProgressBar, progressBarBuffer: ProgressBar?, messageId: String?,
                            status: Int, forwardImage: ImageView?, viewUploadOrDownload: RelativeLayout?) {
        when (status) {
            MediaDownloadStatus.MEDIA_DOWNLOADED, MediaUploadStatus.MEDIA_UPLOADED  -> {
                mediaUploadView(progressBar, cancelLayout, viewUploadOrDownload)
                forwardImage?.show()
                progressBarBuffer?.hide()
            }
            MediaDownloadStatus.MEDIA_DOWNLOADING, MediaUploadStatus.MEDIA_UPLOADING ->{
                forwardImage?.hide()
                handleProcessing(viewUploadOrDownload, progressBar, progressBarBuffer, status, messageId, cancelLayout)
            }

            MediaDownloadStatus.MEDIA_NOT_DOWNLOADED, MediaDownloadStatus.MEDIA_DOWNLOADED_NOT_AVAILABLE, MediaUploadStatus.MEDIA_NOT_UPLOADED -> {
                makeViewsGone(progressBar, cancelLayout)
                forwardImage?.hide()
                viewUploadOrDownload?.show()
                progressBarBuffer?.hide()
            }
        }
    }

}