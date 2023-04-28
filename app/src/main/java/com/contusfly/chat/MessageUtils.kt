package com.contusfly.chat

import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.mirrorflysdk.flycommons.models.MessageType
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage
import java.io.File
import java.util.ArrayList

object MessageUtils {

    fun filterRecalledMessages(messageIds: ArrayList<String>): List<String> {
        val forwardMediaMessage = FlyMessenger.getMessagesUsingIds(messageIds)
        val filteredList = arrayListOf<String>()
        forwardMediaMessage.forEach {
            if (it.isMessageRecalled()){
                filteredList.add(it.getMessageId())
            }
        }
        return filteredList

    }

    /**
     * Return the status of media with respect to availability
     *
     * @param fileStatus upload / download status
     * @param filePath local path of the media
     * @param isUpload is uploading
     * @return status of the media
     */
    fun getMediaStatus(fileStatus: String, filePath: String?, isUpload: Boolean): Int {
        return if (isUpload)
            if (fileStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADED && !isMediaExists(filePath))
                MediaUploadStatus.MEDIA_UPLOADED_NOT_AVAILABLE else fileStatus.toInt()
        else
            if (fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADED && !isMediaExists(filePath))
                MediaDownloadStatus.MEDIA_DOWNLOADED_NOT_AVAILABLE else fileStatus.toInt()
    }

    fun isMediaExists(filePath: String?): Boolean {
        return if (filePath != null) {
            val file = File(filePath)
            file.exists()
        } else false
    }

    /**
     * Get the view type based on the type of the message
     *
     * @param messageItem message object
     * @return int Type of the chat
     */
    fun checkIsNotNotification(messageItem: ChatMessage?): Boolean {
        if (messageItem != null) {
            val msgType = messageItem.getMessageType()
            return msgType != MessageType.NOTIFICATION
        }
        return true
    }
}