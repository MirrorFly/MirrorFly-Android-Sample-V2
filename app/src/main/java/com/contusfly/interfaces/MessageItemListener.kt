/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.interfaces

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.contusfly.models.MediaCaption
import com.contusfly.models.MediaStatus
import com.mirrorflysdk.api.MessageStatus
import com.mirrorflysdk.api.models.ChatMessage


/**
 * Listener for message item view like image, audio
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
interface MessageItemListener {
    /**
     * Set the chat status of the message => Ack => Delivered => Seen
     *
     * @param item       Message item contains message data
     * @param viewHolder Image view status
     */
    fun setChatStatus(item: ChatMessage?, viewHolder: ImageView?)

    /**
     * Set the chat status of the message => Ack => Delivered => Seen
     *
     * @param status     Status of message
     * @param viewHolder Image view status
     */
    fun setRecentChatStatus(viewHolder: ImageView?, status: MessageStatus?)

    /**
     * Set the starred status of the message
     *
     * @param isStarred       True if the Message is starred
     * @param imageView       Image view starred
     */
    fun setStaredStatus(isStarred: Boolean, imageView: ImageView)

    /**
     * Set the starred status of the message
     *
     * @param isStarred       True if the Message is starred
     * @param imageView       Image view starred
     */
    fun setStarredCaptionStatus(isStarred: Boolean, imageView: ImageView)

    /**
     * Sets the media status. Action should be
     *
     *
     * => MEDIA_DOWNLOADED => MEDIA_UPLOADED => MEDIA_DOWNLOADING => MEDIA_UPLOADING =>
     * MEDIA_NOT_DOWNLOADED => MEDIA_NOT_UPLOADED
     *
     * @param txtRetry        Text view to display the retry
     * @param download        The download view of the media
     * @param progressBar     The progress bar for displaying media status
     * @param status          The status of the media
     * @param item            The instance of the message
     * @param imgPlay         The image view for the cancel download or upload
     * @param cancelImageview Cancelling upload/download option
     */
    fun setMediaStatus(mediStatus: MediaStatus)

    /**
     * Sets the media caption
     * @param htmlText           Caption Text
     * @param captionView        Caption TextView
     * @param searchEnabled      Search Enabled Status
     * @param searchKey          Search Key value
     * @param mentionedUserName  Mention UserName
     */
    fun setMediaCaption(mediStatus: MediaCaption)

    /**
     * Set the media duration for downloaded/uploaded video/audio file
     *
     * @param txtSendDuration Duration of an audio/video file
     * @param fileStatus      Status of file
     * @param messageItem     Details of the message
     * @param imgChatType     Chat type image for video
     */
    fun setMediaDuration(txtSendDuration: TextView?, fileStatus: Int, messageItem: ChatMessage?, imgChatType: ImageView?)

    /**
     * setImageViewSize Set the image view size KB or MB in size
     *
     * @param fileSize     File size
     * @param downloadView View of download item
     * @param fileSizeView Text view to show file size
     */
    fun setImageViewSize(fileSize: String?, downloadView: View?, fileSizeView: TextView?)

    /**
     * Set the chat status of the chat item.
     *
     * @param item          Message item contains message data
     * @param imgChatStatus Image view status
     */
    fun setStatus(item: ChatMessage?, imgChatStatus: ImageView?)

}