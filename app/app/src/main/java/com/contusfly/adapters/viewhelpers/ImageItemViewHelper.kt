/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.viewhelpers

import android.content.Context
import android.text.SpannableStringBuilder
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.contusfly.*
import com.contusfly.adapters.holders.ImageReceivedViewHolder
import com.contusfly.adapters.holders.ImageSentViewHolder
import com.contusfly.chat.AndroidUtils
import com.contusfly.chat.MessageUtils
import com.contusfly.groupmention.MentionUtils
import com.contusfly.interfaces.MessageItemListener
import com.contusfly.utils.*
import com.mirrorflysdk.api.models.ChatMessage
import kotlin.math.ceil
import com.contusfly.models.MediaStatus


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
    fun senderImageItemView(messageItem: ChatMessage, imgViewHolder: ImageSentViewHolder, filePath: String?, time: String?,
                            base64Img: String?, searchEnabled: Boolean = false, searchKey: String = emptyString()) {
        with(imgViewHolder) {
            handleImageLoading(imgViewHolder, filePath, base64Img)

            /*
              Check if the image item contain caption to show
             */
            handleImageWithCaption(messageItem, imgViewHolder, time, searchEnabled, searchKey)
            setImageSenderMediaStatus(this, messageItem)
            handleSenderImageItemProgressUpdate(messageItem, this)
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
                val mediaStatus = MediaStatus(txtRetryView, viewSentCarbonDownload, progressSender, fileStatus, messageItem, null,
                    cancelUpload, imgSentForward, viewUploadProgress)
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
                if (messageItem.mentionedUsersIds != null && messageItem.mentionedUsersIds.size > 0 ) {
                    val mentionText = MentionUtils.formatMentionText(context, messageItem,false)
                    val mentionUserNames=MentionUtils.getMentionedUserId(context,messageItem,false)
                    handleSenderImageCaptionSearchExceptMention(mentionText, imgViewHolder, searchEnabled, searchKey,mentionUserNames)
                } else {
                    handleSenderImageCaptionSearch(getSpannedText(messageItem.getMediaChatMessage().getMediaCaptionText()), imgViewHolder, searchEnabled, searchKey)
                }
            } else {
                showViews(txtSendTime, imgSenderStatus)
                viewSendImageCaption.gone()
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

    private fun handleSenderImageCaptionSearch(htmlText: CharSequence, holder: ImageSentViewHolder,
                                               searchEnabled: Boolean, searchKey: String) {
        if (searchEnabled && searchKey.isNotEmpty() && htmlText.toString().startsWithTextInWords(searchKey)) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setMediaTextHighLightSearched(context, holder.txtChatSentCaption, htmlText.toString(), startIndex, stopIndex)
        } else {
            holder.txtChatSentCaption.setBackgroundColor(context.color(android.R.color.transparent))
            holder.txtChatSentCaption.setTextKeepState(htmlText)
        }
    }
    private fun handleSenderImageCaptionSearchExceptMention(htmlText: CharSequence, holder: ImageSentViewHolder,
                                               searchEnabled: Boolean, searchKey: String,mentionedUserName: SpannableStringBuilder
    ) {
        if (searchEnabled && searchKey.isNotEmpty()) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setMediaTextHighLightSearchedForMention(context, holder.txtChatSentCaption,
                htmlText.toString(), startIndex, stopIndex, mentionedUserName)
        } else {
            holder.txtChatSentCaption.setBackgroundColor(context.color(android.R.color.transparent))
            holder.txtChatSentCaption.setTextKeepState(htmlText)
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
            val progressPercentage = Utils.returnZeroIfStringEmpty(Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaProgressStatus()))
            if ((fileUploadStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADING || fileUploadStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING)
                && progressPercentage > 0 && progressPercentage < 100) {
                progressSender.show()
                progressSenderRotation.gone()
                progressSender.max = 100
                progressSender.progress = progressPercentage
            } else if ((fileUploadStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADING || fileUploadStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING)
                && (progressPercentage < 1 || progressPercentage >= 100)) {
                progressSender.gone()
                progressSenderRotation.show()
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
    fun receiverImageViewItem(messageItem: ChatMessage, imgViewHolder: ImageReceivedViewHolder, filePath: String?, time: String?,
                              base64Img: String?, searchEnabled: Boolean = false, searchKey: String = emptyString()) {
        with(imgViewHolder) {
            setImageReceiverMediaStatus(this, messageItem)
            /*
             Check if the image item contain caption to show
            */
            if (Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaCaptionText()).isNotEmpty()) {
                viewRevImageCaption.show()
                txtRevChatCaption.maxWidth = ceil((AndroidUtils.getDensity(context) * 250).toDouble()).toInt()
                txtRevTime.gone()
                imgStarred.gone()
                txtRevCaptionTime.text = time
                imgStarred.gone()
                viewRevImageBalloon.gone()
                messageItemListener.setStarredCaptionStatus(messageItem.isMessageStarred(), txtRevCaptionStar)
                if (messageItem.mentionedUsersIds != null && messageItem.mentionedUsersIds.size > 0 ) {
                    val mentionText = MentionUtils.formatMentionText(context, messageItem,false)
                    val mentionUserNames=MentionUtils.getMentionedUserId(context,messageItem,false)
                    handleReceiverImageCaptionSearchExceptMention(mentionText, imgViewHolder, searchEnabled,searchKey,mentionUserNames)
                } else {
                    handleReceiverImageCaptionSearch(getSpannedText(messageItem.getMediaChatMessage().getMediaCaptionText()), imgViewHolder, searchEnabled, searchKey)
                }
            } else {
                viewRevImageCaption.gone()
                txtRevTime.show()
                txtRevTime.text = time
                txtRevCaptionStar.gone()
                viewRevImageBalloon.show()
                messageItemListener.setStaredStatus(messageItem.isMessageStarred(), imgStarred)
            }
            handleReceiverImageLoading(this, filePath, base64Img)
            handleReceiverImageItemProgressUpdate(messageItem, this)
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

            val fileStatus = if (messageItem.isMessageSentByMe()) Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaUploadStatus().toString())
            else Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaDownloadStatus().toString())
            if (fileStatus.isNotEmpty()){
                val mediaStatus = MediaStatus(txtRetryView, viewDownload, progressRev,
                    MessageUtils.getMediaStatus(fileStatus, filePath, false),
                    messageItem, null, cancelDownload,  receivedImageForward,viewDownloadProgress)
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
            if (fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING && progressPercentage in 1..99) {
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

    private fun handleReceiverImageCaptionSearch(
        htmlText: CharSequence, holder: ImageReceivedViewHolder,
        searchEnabled: Boolean, searchKey: String
    ) {
        if (searchEnabled && searchKey.isNotEmpty() && htmlText.toString()
                .startsWithTextInWords(searchKey)
        ) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setMediaTextHighLightSearched(context, holder.txtRevChatCaption, htmlText.toString(), startIndex, stopIndex)
        } else {
            holder.txtRevChatCaption.setBackgroundColor(context.color(android.R.color.transparent))
            holder.txtRevChatCaption.setTextKeepState(htmlText)
        }
    }

    private fun handleReceiverImageCaptionSearchExceptMention(
        htmlText: CharSequence, holder: ImageReceivedViewHolder,
        searchEnabled: Boolean, searchKey: String,mentionedUserName: SpannableStringBuilder
    ) {
        if (searchEnabled && searchKey.isNotEmpty()) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setMediaTextHighLightSearchedForMention(context, holder.txtRevChatCaption,
                htmlText.toString(), startIndex, stopIndex,mentionedUserName)
        } else {
            holder.txtRevChatCaption.setBackgroundColor(context.color(android.R.color.transparent))
            holder.txtRevChatCaption.setTextKeepState(htmlText)
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