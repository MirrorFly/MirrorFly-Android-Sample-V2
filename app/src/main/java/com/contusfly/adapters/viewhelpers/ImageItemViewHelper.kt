/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.viewhelpers

import android.content.Context
import android.text.SpannableStringBuilder
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.contusfly.*
import com.contusfly.adapters.holders.ImageReceivedViewHolder
import com.contusfly.adapters.holders.ImageSentViewHolder
import com.contusfly.chat.AndroidUtils
import com.contusfly.chat.MessageUtils
import com.contusfly.groupmention.MentionUtils
import com.contusfly.interfaces.MessageItemListener
import com.contusfly.models.ChatItemRowModel
import com.contusfly.models.MediaCaption
import com.contusfly.utils.*
import com.mirrorflysdk.api.models.ChatMessage
import kotlin.math.ceil
import com.contusfly.models.MediaStatus
import com.contusfly.utils.ChatUtils.txtEditedVisibility


/**
 * Image sent/received item view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ImageItemViewHelper(private val context: Context, private val messageItemListener: MessageItemListener) {

    /**
     * Sender image item view
     *
     * @param imgViewHolder Image item view holder
     * @param messageItem   Message item
     */
    fun setImageWidthAndHeight(imgViewHolder: ImageSentViewHolder, messageItem: ChatMessage) {
        with(imgViewHolder) {
            val calculatedDimension = ChatUtils.getMobileWidthAndHeight(messageItem.getMediaChatMessage().getMediaFileWidth(), messageItem.getMediaChatMessage().getMediaFileHeight())
            imageSenderLayout?.setWidthAndHeight(calculatedDimension.second, calculatedDimension.first)
        }
    }

    /**
     * Sender image item view
     *
     * @param messageItem   Message item
     * @param imgViewHolder Image item view holder
     * @param filePath      File local path
     * @param time          Time of message sent
     * @param base64Img     Thumb image
     */
    fun senderImageItemView(imgViewHolder: ImageSentViewHolder, model: ChatItemRowModel) {
        with(imgViewHolder) {
            handleImageLoading(imgViewHolder, model.filePath, model.base64Img)

            /*
              Check if the image item contain caption to show
             */
            handleImageWithCaption(model.messageItem, imgViewHolder, model.time, model.searchEnabled, model.searchKey)
            setImageSenderMediaStatus(this, model.messageItem)
            handleSenderImageItemProgressUpdate(model.messageItem, this)
        }
    }

    fun setImageSenderMediaStatus(imgViewHolder: ImageSentViewHolder, messageItem: ChatMessage) {
        val fileUploadStatus = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaUploadStatus().toString())
        val fileDownloadStatus = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaDownloadStatus().toString())
        val filePath = com.mirrorflysdk.utils.Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaLocalStoragePath())

        with(imgViewHolder) {
            val fileSize = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaFileSize())
            val fileStatus = if (messageItem.isItCarbonMessage()) fileDownloadStatus.toInt()
            else MessageUtils.getMediaStatus(fileUploadStatus, filePath, true)
            fileUploadStatus.isNotEmpty().let {
                if(fileStatus == MediaUploadStatus.MEDIA_UPLOADED || fileStatus == MediaDownloadStatus.MEDIA_DOWNLOADED){
                    progressSenderRotation.gone()
                }
                val mediaStatus = MediaStatus(txtRetryView, viewSentCarbonDownload, progressSender, fileStatus, messageItem, null,
                    cancelUpload, imgSentForward, viewUploadProgress,progressSenderRotation)
                messageItemListener.setMediaStatus(mediaStatus)
                if (messageItem.isItCarbonMessage())
                    messageItemListener.setImageViewSize(fileSize, viewSentCarbonDownload, txtCarbonImgSize)
            }
        }
    }

    fun handleImageLoading(imgViewHolder: ImageSentViewHolder, filePath: String?, base64Img: String?) {
            with(imgViewHolder) {
                ImageUtils.loadImageInView(context, filePath ?: "", imageSenderImg, base64Img ?: "")
            }
    }

    private fun handleImageWithCaption(messageItem: ChatMessage, imgViewHolder: ImageSentViewHolder,
                                       time: String?, searchEnabled: Boolean, searchKey: String) {
        with(imgViewHolder) {
            if (Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaCaptionText()).isNotEmpty()) {
                viewSendImageCaption.show()
                txtChatSentCaption.maxWidth = ceil((AndroidUtils.getDensity(context) * 250).toDouble()).toInt()
                checkCaption(this)
                txtSentCaptionTime.text = time
                messageItemListener.setRecentChatStatus(imgSentImageCaptionStatus, messageItem.getMessageStatus())
                messageItemListener.setStarredCaptionStatus(messageItem.isMessageStarred(), imgSentCaptionStar)
                imgSentStarred.gone()
                imgSentBalloon.gone()
                txtEditedVisibility(messageItem.isEdited,txtEdited)
                if (messageItem.mentionedUsersIds != null && messageItem.mentionedUsersIds.size > 0 ) {
                    val mentionText = MentionUtils.formatMentionText(context, messageItem,false)
                    val mentionUserNames=MentionUtils.getMentionedUserId(context,messageItem,false)
                    val caption=MediaCaption(mentionText,imgViewHolder.txtChatSentCaption,searchEnabled,searchKey,mentionUserNames,messageItem)
                    messageItemListener.setMediaCaption(caption)
                } else {
                    val caption=MediaCaption(getSpannedText(messageItem.mediaChatMessage.mediaCaptionText),imgViewHolder.txtChatSentCaption,searchEnabled,searchKey,SpannableStringBuilder(),messageItem)
                    messageItemListener.setMediaCaption(caption)
                }
            } else {
                showViews(txtSendTime, imgSenderStatus)
                viewSendImageCaption.gone()
                txtEdited.gone()
                txtSendTime.text = time
                messageItemListener.setChatStatus(messageItem, imgSenderStatus)
                imgSentCaptionStar.gone()
                messageItemListener.setStaredStatus(messageItem.isMessageStarred(), imgSentStarred)
            }
            imgSentForward?.let {
                if ((messageItem.isMessageAcknowledged() || messageItem.isMessageDelivered()
                            || messageItem.isMessageSeen()) && MessageUtils.isMediaExists(messageItem.getMediaChatMessage().getMediaLocalStoragePath()))
                    it.show() else it.gone()
            }
        }
    }


    /**
     * Check if the image item contain caption to show
     *
     * @param imgViewHolder Image item view holder
     */
    private fun checkCaption(imgViewHolder: ImageSentViewHolder) {
        with(imgViewHolder) {
            if (txtChatSentCaption != null) {
                imgSenderStatus.gone()
                txtSendTime.gone()
                imgSentStarred.gone()
                imgSentBalloon.gone()
            } else
                bg?.setBackgroundResource(R.drawable.ic_baloon)
        }
    }

    /**
     * Sender image uploading progress based on file upload status
     *
     * @param messageItem      Message item
     * @param imageSentViewHolder    Image item view holder
     */
    fun handleSenderImageItemProgressUpdate(
        messageItem: ChatMessage,
        imageSentViewHolder: ImageSentViewHolder
    ) {
        var fileUploadStatus = Utils.returnEmptyStringIfNull(
            messageItem.getMediaChatMessage().getMediaUploadStatus().toString()
        )
        val fileDownloadStatus = Utils.returnEmptyStringIfNull(
            messageItem.getMediaChatMessage().getMediaUploadStatus().toString()
        )

        if (messageItem.isItCarbonMessage())
            fileUploadStatus = fileDownloadStatus
        uploadImgProgressView(messageItem, imageSentViewHolder, fileUploadStatus)
    }

    /**
     * Sender image uploading progress bar view based on file upload status
     *
     * @param messageItem      Message item
     * @param imgViewHolder    Image item view holder
     * @param fileUploadStatus Response code for fileuploadstatus
     */
    private fun uploadImgProgressView(
        messageItem: ChatMessage,
        imgViewHolder: ImageSentViewHolder,
        fileUploadStatus: String
    ) {
        with(imgViewHolder) {
            val progressPercentage = Utils.returnZeroIfStringEmpty(
                Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaProgressStatus()
                )
            )
            when(fileUploadStatus.toInt()) {
                 MediaUploadStatus.MEDIA_UPLOADED,
                 MediaDownloadStatus.MEDIA_DOWNLOADED -> {
                    if (messageItem.mediaChatMessage.mediaLocalStoragePath != null && messageItem.mediaChatMessage.mediaLocalStoragePath != "" && ChatMessageUtils.isMediaExists(
                            messageItem.mediaChatMessage.mediaLocalStoragePath
                        )
                    ) {
                        viewUploadProgress.gone()
                        progressSender.gone()
                        progressSenderRotation.gone()
                    }
                }
                MediaUploadStatus.MEDIA_UPLOADING,
                MediaDownloadStatus.MEDIA_DOWNLOADING -> {
                    if (progressPercentage in 1..99) {
                        progressSender.show()
                        progressSenderRotation.gone()
                        progressSender.max = 100
                        progressSender.progress = progressPercentage
                    } else if (progressPercentage < 1 || progressPercentage >= 100) {
                        progressSender.gone()
                        progressSenderRotation.show()
                    }
                }
            }
        }
    }

    /**
     * Receiver image item view
     *
     * @param imgViewHolder Image item view holder
     * @param messageItem   Message item
     */
    fun setImageWidthAndHeight(imgViewHolder: ImageReceivedViewHolder, messageItem: ChatMessage) {
        with(imgViewHolder) {
            val calculatedDimension = ChatUtils.getMobileWidthAndHeight(messageItem.getMediaChatMessage().getMediaFileWidth(), messageItem.getMediaChatMessage().getMediaFileHeight())
            imageRevLayout?.setWidthAndHeight(calculatedDimension.second, calculatedDimension.first)
        }
    }

    /**
     * Receiver image item view
     *
     * @param messageItem   Message item
     * @param imgViewHolder Image item view holder
     * @param filePath      File local path
     * @param time          Time of message sent
     * @param base64Img     Thumb image
     */
    fun receiverImageViewItem(imgViewHolder: ImageReceivedViewHolder, model:ChatItemRowModel) {
        with(imgViewHolder) {
            setImageReceiverMediaStatus(this, model.messageItem)
            /*
             Check if the image item contain caption to show
            */
            if (Utils.returnEmptyStringIfNull(model.messageItem.getMediaChatMessage().getMediaCaptionText()).isNotEmpty()) {
                viewRevImageCaption.show()
                txtRevChatCaption.maxWidth = ceil((AndroidUtils.getDensity(context) * 250).toDouble()).toInt()
                txtRevTime.gone()
                imgStarred.gone()
                txtRevCaptionTime.text = model.time
                imgStarred.gone()
                viewRevImageBalloon.gone()
                txtEditedVisibility(model.messageItem.isEdited, txtEdited)
                messageItemListener.setStarredCaptionStatus(model.messageItem.isMessageStarred(), txtRevCaptionStar)
                if (model.messageItem.mentionedUsersIds != null && model.messageItem.mentionedUsersIds.size > 0 ) {
                    val mentionText = MentionUtils.formatMentionText(context, model.messageItem,false)
                    val mentionUserNames=MentionUtils.getMentionedUserId(context,model.messageItem,false)
                    val caption=MediaCaption(mentionText,imgViewHolder.txtRevChatCaption,model.searchEnabled,model.searchKey,mentionUserNames,model.messageItem)
                    messageItemListener.setMediaCaption(caption)
                } else {
                    val caption=MediaCaption(getSpannedText(model.messageItem.mediaChatMessage.mediaCaptionText),imgViewHolder.txtRevChatCaption,model.searchEnabled,model.searchKey,SpannableStringBuilder(),model.messageItem)
                    messageItemListener.setMediaCaption(caption)
                }

            } else {
                viewRevImageCaption.gone()
                txtRevTime.show()
                txtEdited.gone()
                txtRevTime.text = model.time
                txtRevCaptionStar.gone()
                viewRevImageBalloon.show()
                messageItemListener.setStaredStatus(model.messageItem.isMessageStarred(), imgStarred)
            }
            handleReceiverImageLoading(this, model.filePath, model.base64Img)
            handleReceiverImageItemProgressUpdate(model.messageItem, this)
        }
    }

    fun handleReceiverImageLoading(imgViewHolder: ImageReceivedViewHolder, filePath: String?, base64Img: String?){
        with(imgViewHolder) {
            ImageUtils.loadImageInView(context, filePath ?: "", imgRevImage, base64Img ?: "")
        }
    }

    fun setImageReceiverMediaStatus(imageReceivedViewHolder: ImageReceivedViewHolder, messageItem: ChatMessage){
        with(imageReceivedViewHolder) {
            val filePath = com.mirrorflysdk.utils.Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaLocalStoragePath())

            val fileStatus = if (messageItem.isMessageSentByMe()) Utils.returnEmptyStringIfNull(
                messageItem.getMediaChatMessage().getMediaUploadStatus().toString()
            )
            else Utils.returnEmptyStringIfNull(
                messageItem.getMediaChatMessage().getMediaDownloadStatus().toString()
            )
            if (fileStatus.isNotEmpty()) {
                val mediaStatus = MediaStatus(txtRetryView, viewDownload, progressRev,
                    MessageUtils.getMediaStatus(fileStatus, filePath, false),
                    messageItem, null, cancelDownload,  receivedImageForward,viewDownloadProgress,downloadProgressBuffer)
                messageItemListener.setMediaStatus(mediaStatus)
            }
            val fileSize = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaFileSize())
            messageItemListener.setImageViewSize(fileSize, imageReceivedViewHolder.viewDownload, imageReceivedViewHolder.txtImgSize)
        }
    }

    fun handleReceiverImageItemProgressUpdate(
        messageItem: ChatMessage,
        imageReceivedViewHolder: ImageReceivedViewHolder
    ) {
        with(imageReceivedViewHolder) {
            val progressPercentage = Utils.returnZeroIfStringEmpty(
                Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaProgressStatus()
                )
            )
            val fileStatus = if (messageItem.isMessageSentByMe()) Utils.returnEmptyStringIfNull(
                messageItem.getMediaChatMessage().getMediaUploadStatus().toString()
            )
            else Utils.returnEmptyStringIfNull(
                messageItem.getMediaChatMessage().getMediaDownloadStatus().toString()
            )
            if (fileStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADED || fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADED) {
                if (messageItem.mediaChatMessage.mediaLocalStoragePath != null && messageItem.mediaChatMessage.mediaLocalStoragePath != "" && ChatMessageUtils.isMediaExists(
                        messageItem.mediaChatMessage.mediaLocalStoragePath
                    )
                ) {
                    viewDownloadProgress.gone()
                    downloadProgressBuffer.gone()
                    progressRev.gone()
                }
            }else if (fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING && progressPercentage in 1..99) {
                downloadProgressBuffer.gone()
                progressRev.show()
                progressRev.max = 100
                progressRev.progress = progressPercentage
            } else {
                downloadProgressBuffer.show()
                progressRev.gone()
            }
        }
    }


    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in
     * FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private fun getHtmlChatMessageText(message: String): String {
        val text = context.getString(R.string.chat_text)
        return message + text + text
    }

    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private fun getSpannedText(message: String?): String {
        return getHtmlChatMessageText(message!!)
    }

}