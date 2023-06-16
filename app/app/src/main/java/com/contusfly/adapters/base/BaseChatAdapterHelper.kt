/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.base

import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.adapters.ChatAdapter
import com.contusfly.adapters.holders.DateViewHolder
import com.contusfly.chat.MessageUtils
import com.contusfly.gone
import com.contusfly.show
import com.mirrorflysdk.api.FlyMessenger.cancelMediaUploadOrDownload
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.media.MediaUploadDownloadManager

/**
 * Helper class for Chat view Adapter
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
abstract class BaseChatAdapterHelper {
    /**
     * Show or Hides the header view based on position
     *
     * @param dateViewHolder Date view holder
     */
    fun showHideDateHeader(dateViewHolder: DateViewHolder) {
        dateViewHolder.hideDateView()
    }

    /**
     * Returns message dates are equal or not by validating previous message is date message
     *
     * @param position Position of the item
     * @return boolean True if dates are equal, false if not
     */
    protected fun isMessageDateEqual(messageList: List<ChatMessage>, position: Int): Boolean {
        val previousMessage = getPreviousMessage(messageList, position)
        return previousMessage != null && MessageUtils.checkIsNotNotification(previousMessage)
    }

    /**
     * Returns previous message related to position if exist
     *
     * @param position Current position
     * @return Message Previous message related to position
     */
    private fun getPreviousMessage(messageList: List<ChatMessage>, position: Int): ChatMessage? {
        return if (position > 0) {
            messageList[position - 1]
        } else null
    }

    /**
     * Get the view type based on the type of the message
     *
     * @param messageItem message object
     * @return int Type of the chat
     */
    fun getItemViewType(messageItem: ChatMessage?): Int {
        if (messageItem != null) {
            var msgType = messageItem.getMessageType()
            if (messageItem.isMessageRecalled()) {
                msgType = MessageType.TEXT
            }
            return when (msgType) {
                MessageType.TEXT -> getType(messageItem, ChatAdapter.TYPE_TEXT_SENDER, ChatAdapter.TYPE_TEXT_RECEIVER)
                MessageType.LOCATION -> getType(messageItem, ChatAdapter.TYPE_LOCATION_SENDER, ChatAdapter.TYPE_LOCATION_RECEIVER)
                MessageType.CONTACT -> getType(messageItem, ChatAdapter.TYPE_CONTACT_SENDER, ChatAdapter.TYPE_CONTACT_RECEIVER)
                MessageType.NOTIFICATION -> ChatAdapter.TYPE_MSG_NOTIFICATION
                else -> getType(messageItem, getMediaItemTypeSender(msgType), getMediaItemTypeReceiver(msgType))
            }
        }
        return -1
    }

    /**
     * @param messageItem  message instance
     * @param typeSender   sender layout type
     * @param typeReceiver sender layout type
     * @return sender or receiver type for given messageItem
     */
    private fun getType(messageItem: ChatMessage, typeSender: Int, typeReceiver: Int): Int {
        return if (messageItem.isMessageSentByMe()) {
            typeSender
        } else typeReceiver
    }

    /**
     * Get the media type for the list item to display
     *
     * @param messageType Type of the message
     * @return int View of the chat item
     */
    private fun getMediaItemTypeSender(messageType: MessageType): Int {
        return when (messageType) {
            MessageType.AUDIO -> ChatAdapter.TYPE_AUDIO_SENDER
            MessageType.IMAGE -> ChatAdapter.TYPE_IMAGE_SENDER
            MessageType.VIDEO -> ChatAdapter.TYPE_VIDEO_SENDER
            MessageType.DOCUMENT -> ChatAdapter.TYPE_FILE_SENDER
            else -> 0
        }
    }

    /**
     * Get the media type for the list item to display
     *
     * @param messageType Type of the message
     * @return int View of the chat item
     */
    private fun getMediaItemTypeReceiver(messageType: MessageType): Int {
        return when (messageType) {
            MessageType.AUDIO -> ChatAdapter.TYPE_AUDIO_RECEIVER
            MessageType.IMAGE -> ChatAdapter.TYPE_IMAGE_RECEIVER
            MessageType.VIDEO -> ChatAdapter.TYPE_VIDEO_RECEIVER
            MessageType.DOCUMENT -> ChatAdapter.TYPE_FILE_RECEIVER
            else -> 0
        }
    }

    /**
     * Enable the views and make the cancel click listener
     *
     * @param progressBar Progressing
     * @param cancel      Cancel view
     * @param viewProgress  Progress view
     */
    fun mediaUploadView(progressBar: View?, cancel: View?, viewProgress: View?) {
        progressBar?.gone()
        cancel?.gone()
        cancel?.setOnClickListener(null)
        viewProgress?.gone()
    }


    /**
     * Set the file status for uploading or downloading status
     *
     * @param uploadOrDownloadLayout    Upload or Download action layout
     * @param progressBar Progress bar of the media view
     * @param progressBarBuffer Progress buffer of the media view
     * @param status      Status of the image
     * @param mid         Message id of the message
     * @param cancelLayout  Cancel the media Upload or Download layout
     */
    fun handleProcessing(uploadOrDownloadLayout: RelativeLayout?, progressBar: ProgressBar, progressBarBuffer: ProgressBar?,
                         status: Int, mid: String?, cancelLayout: RelativeLayout?) {
        when {
            MediaUploadDownloadManager.getMediaOperationsMap().containsKey(mid) -> {
                if (progressBarBuffer == null || progressBarBuffer.visibility != View.VISIBLE) progressBar.visibility = View.VISIBLE
                uploadOrDownloadLayout?.gone()
                if (cancelLayout != null) {
                    cancelLayout.visibility = View.VISIBLE
                    enableMediaCancel(mid, cancelLayout)
                }

            }
            status == MediaDownloadStatus.MEDIA_DOWNLOADING || status == MediaUploadStatus.MEDIA_UPLOADING-> {
                cancelLayout?.show()
                if (progressBarBuffer == null || progressBarBuffer.visibility != View.VISIBLE) progressBar.visibility = View.VISIBLE
                uploadOrDownloadLayout?.gone()
            }
        }
    }


    /**
     * Enable the media cancel in the chat view
     *
     * @param mid    Message id of the message
     * @param cancel Cancel image view
     */
    open fun enableMediaCancel(mid: String?, cancel: RelativeLayout) {
        cancel.setOnClickListener { cancelMediaUploadOrDownload(mid!!) }
    }
}