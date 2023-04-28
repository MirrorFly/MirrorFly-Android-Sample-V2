/*
 * @category ContusFly
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.utils

import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.mirrorflysdk.flycommons.models.MessageType
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.utils.Utils

/**
 * This class used to check the availability of the media
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
object MediaChecker {

    /**
     * Check whether the media file exists
     *
     * @param msgType Type of the message
     * @param message Instance of the message
     * @return boolean True if media available
     */
    fun isMediaFileAvailable(msgType: MessageType, message: ChatMessage): Boolean {
        var mediaExist = false
        if (msgType == MessageType.AUDIO || msgType == MessageType.VIDEO || msgType == MessageType.IMAGE || msgType == MessageType.DOCUMENT) {
            val downloadedMediaValue = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaDownloadStatus().toString())
            val uploadedMediaValue = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaUploadStatus().toString())
            if (MediaDownloadStatus.MEDIA_DOWNLOADED.toString() == downloadedMediaValue || MediaUploadStatus.MEDIA_UPLOADED.toString() == uploadedMediaValue) mediaExist = true
        }
        return mediaExist
    }

    /**
     * Check whether the media is downloaded or uploaded
     *
     * @param message Message item
     * @return boolean True if media available
     */
    fun isMediaAvailable(message: ChatMessage): Boolean {
        return (message.getMediaChatMessage().getMediaDownloadStatus() == MediaDownloadStatus.MEDIA_DOWNLOADED
                || message.getMediaChatMessage().getMediaUploadStatus() == MediaUploadStatus.MEDIA_UPLOADED)
    }

    /**
     * Check the type is media
     *
     * @param msgType Type of the message
     * @return boolean True if it is media
     */
    fun isMediaType(msgType: MessageType): Boolean {
        return msgType == MessageType.IMAGE || msgType == MessageType.VIDEO || msgType == MessageType.AUDIO || msgType == MessageType.DOCUMENT
    }
}