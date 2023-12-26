package com.contusfly.adapters.viewhelpers

import android.content.Context
import android.text.SpannableStringBuilder
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.contusfly.*
import com.contusfly.adapters.holders.VideoReceivedViewHolder
import com.contusfly.adapters.holders.VideoSentViewHolder
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


/**
 * Image sent/received item view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class VideoItemViewHelper(private val context: Context, private val messageItemListener: MessageItemListener) {

    /**
     * Sender image item view
     *
     * @param videoSenderViewHolder Video item view holder
     * @param messageItem   Message item
     */
    fun setImageWidthAndHeight(videoSenderViewHolder: VideoSentViewHolder, messageItem: ChatMessage){
        with(videoSenderViewHolder) {
            val calculatedDimension = ChatUtils.getMobileWidthAndHeight(messageItem.getMediaChatMessage().getMediaFileWidth(), messageItem.getMediaChatMessage().getMediaFileHeight())
            imageSenderLayout?.setWidthAndHeight(calculatedDimension.second, calculatedDimension.first)
        }
    }

    /**
     * Sender image item view
     *
     * @param messageItem           Message item
     * @param videoSenderViewHolder Video item view holder
     * @param filePath              File local path
     * @param time                  Time of message sent
     * @param base64Img             Thumb image
     */
    fun senderVideoItemView(
        videoSenderViewHolder: VideoSentViewHolder,
        model: ChatItemRowModel
    ) {
        with(videoSenderViewHolder) {
                val fileUploadStatus = Utils.returnEmptyStringIfNull(model.messageItem.getMediaChatMessage().getMediaUploadStatus().toString())
                handleVideoLoading(model.messageItem, this, fileUploadStatus, model.filePath, model.base64Img)


            /*
              Check if the image item contain caption to show
             */
            handleVideoWithCaption(model.messageItem, videoSenderViewHolder, model.time, model.searchEnabled, model.searchKey)
            setVideoSenderMediaStatus(videoSenderViewHolder, model.messageItem)
            handleSenderVideoItemProgressUpdate(model.messageItem, this)
        }
    }

    fun handleVideoLoading(messageItem: ChatMessage, videoSenderViewHolder: VideoSentViewHolder,
                           fileUploadStatus: String, filePath: String?, base64Img: String?) {
            with(videoSenderViewHolder) {
                if (messageItem.isVideoMessage() && (fileUploadStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADING
                            || fileUploadStatus.toInt() == MediaUploadStatus.MEDIA_NOT_UPLOADED)) {
                    if (imageSenderImg.drawable != null) {
                        ImageUtils.loadImageInView(
                            context, filePath ?: "", imageSenderImg,
                            base64Img ?: ""
                        )
                    }
                    else ImageUtils.loadImageInView(context, filePath ?: "", imageSenderImg,
                        base64Img ?: "")
                } else ImageUtils.loadImageInView(context, filePath ?: "", imageSenderImg,
                    base64Img ?: "")
            }
    }

    fun setVideoSenderMediaStatus(videoSenderViewHolder: VideoSentViewHolder, messageItem: ChatMessage) {
        val fileUploadStatus = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaUploadStatus().toString())
        val fileDownloadStatus = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaDownloadStatus().toString())
        val filePath = com.mirrorflysdk.utils.Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaLocalStoragePath())


        with(videoSenderViewHolder) {
            val fileSize =
                Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaFileSize())
            val fileStatus = if (messageItem.isItCarbonMessage()) fileDownloadStatus.toInt()
            else MessageUtils.getMediaStatus(fileUploadStatus, filePath, true)
            fileUploadStatus.isNotEmpty().let {
                if(fileStatus == MediaUploadStatus.MEDIA_UPLOADED || fileStatus == MediaDownloadStatus.MEDIA_DOWNLOADED) {
                    progressSenderRotation.gone()
                }
                val mediaStatus = MediaStatus(txtRetryView, viewSentCarbonDownload, progressSender, fileStatus, messageItem, imgSendPlay, cancelUpload, imgSentForward, viewUploadProgress, progressSenderRotation)
                messageItemListener.setMediaStatus(mediaStatus)
                if (messageItem.isItCarbonMessage())
                    messageItemListener.setImageViewSize(fileSize, viewSentCarbonDownload, txtCarbonImgSize)
                messageItemListener.setMediaDuration(txtSendDuration, fileStatus, messageItem, imgSendChatType)
            }
        }
    }

    private fun handleVideoWithCaption(messageItem: ChatMessage, videoSenderViewHolder: VideoSentViewHolder,
                                       time: String?, searchEnabled: Boolean, searchKey: String) {
        with(videoSenderViewHolder) {
            if (Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaCaptionText()).isNotEmpty()) {
                viewSendImageCaption.show()
                txtChatSentCaption.maxWidth = ceil((AndroidUtils.getDensity(context) * messageItem.getMediaChatMessage().getMediaFileWidth()).toDouble()).toInt()
                makeViewsGone(imgSenderStatus, txtSendTime, imgSentStarred, imgSentBalloon)
                txtSentCaptionTime.text = time
                messageItemListener.setRecentChatStatus(imgSentImageCaptionStatus, messageItem.getMessageStatus())
                messageItemListener.setStarredCaptionStatus(messageItem.isMessageStarred(), imgSentCaptionStar)
                imgSentStarred.gone()
                imgSentBalloon.gone()
                if(messageItem.mentionedUsersIds != null && messageItem.mentionedUsersIds.size > 0) {
                    val mentionText =  MentionUtils.formatMentionText(context, messageItem,false)
                    val mentionUserNames=MentionUtils.getMentionedUserId(context,messageItem,false)
                    val caption= MediaCaption(mentionText,videoSenderViewHolder.txtChatSentCaption,searchEnabled,searchKey,mentionUserNames,messageItem)
                    messageItemListener.setMediaCaption(caption)
                } else {
                    val caption=MediaCaption(getSpannedText(messageItem.getMediaChatMessage().getMediaCaptionText()),videoSenderViewHolder.txtChatSentCaption,searchEnabled,searchKey,SpannableStringBuilder(),messageItem)
                    messageItemListener.setMediaCaption(caption)
                }
            } else {
                viewSendImageCaption.gone()
                showViews(txtSendTime, imgSenderStatus)
                txtSendTime.text = time
                messageItemListener.setChatStatus(messageItem, imgSenderStatus)
                imgSentCaptionStar.gone()
                messageItemListener.setStaredStatus(messageItem.isMessageStarred(), imgSentStarred)
            }
            imgSentForward?.let {
                if ((messageItem.isMessageAcknowledged() || messageItem.isMessageDelivered()
                            || messageItem.isMessageSeen()) && MessageUtils.isMediaExists(messageItem.getMediaChatMessage().getMediaLocalStoragePath()))
                    imgSentForward.show() else imgSentForward.gone()
            }
        }
    }

    /**
     * Handle Sender video uploading progress based on file upload status
     *
     * @param messageItem      Message item
     * @param videoViewHolder  The view holding the child items.
     */
    fun handleSenderVideoItemProgressUpdate(messageItem: ChatMessage, videoViewHolder: VideoSentViewHolder) {
        var fileUploadStatus = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaUploadStatus().toString())
        val fileDownloadStatus = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaDownloadStatus().toString())
        if (messageItem.isItCarbonMessage())
            fileUploadStatus = fileDownloadStatus
        uploadImgProgressView(messageItem, videoViewHolder, fileUploadStatus)
    }

    /**
     * Sender image uploading progress bar view based on file upload status
     *
     * @param messageItem      Message item
     * @param videoViewHolder  The view holding the child items.
     * @param fileUploadStatus Response code for file upload status
     */
    private fun uploadImgProgressView(messageItem: ChatMessage, videoViewHolder: VideoSentViewHolder, fileUploadStatus: String) {
        with(videoViewHolder) {
            val videoProgressPercentage = Utils.returnZeroIfStringEmpty(Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaProgressStatus()))
            if ((fileUploadStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADING || fileUploadStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING)
                && videoProgressPercentage > 0 && videoProgressPercentage < 100) {
                progressSender.show()
                progressSenderRotation.gone()
                progressSender.max = 100
                progressSender.progress = videoProgressPercentage
            } else if ((fileUploadStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADING || fileUploadStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING)
                && (videoProgressPercentage < 1 || videoProgressPercentage >= 100)) {
                progressSender.progress = 0
                progressSender.gone()
                progressSenderRotation.show()
            }
        }
    }

    /**
     * Receiver image item view
     *
     * @param videoReceiverViewHolder Video item view holder
     * @param messageItem   Message item
     */
    fun setImageWidthAndHeight(videoReceiverViewHolder: VideoReceivedViewHolder, messageItem: ChatMessage){
        with(videoReceiverViewHolder) {
            val calculatedDimension = ChatUtils.getMobileWidthAndHeight(messageItem.getMediaChatMessage().getMediaFileWidth(), messageItem.getMediaChatMessage().getMediaFileHeight())
            imageRevLayout?.setWidthAndHeight(calculatedDimension.second, calculatedDimension.first)
        }
    }

    /**
     * Receiver image item view
     *
     * @param messageItem             Message item
     * @param videoReceiverViewHolder Image item view holder
     * @param filePath                File local path
     * @param time                    Time of message sent
     * @param base64Img               Thumb image
     */
    fun receiverVideoViewItem(videoReceiverViewHolder: VideoReceivedViewHolder, model:ChatItemRowModel) {
        with(videoReceiverViewHolder) {
            setVideoReceiverMediaStatus(videoReceiverViewHolder, model.messageItem)
            /*
              Check if the image item contain caption to show
             */
            if (Utils.returnEmptyStringIfNull(model.messageItem.getMediaChatMessage().getMediaCaptionText()).isNotEmpty()) {
                viewRevImageCaption.show()
                txtRevChatCaption.maxWidth = ceil((AndroidUtils.getDensity(context) * model.messageItem.getMediaChatMessage().getMediaFileWidth()).toDouble()).toInt()
                txtRevTime.gone()
                imgStarred.gone()
                txtRevCaptionTime.text = model.time
                imgStarred.gone()
                viewRevImageBalloon.gone()
                messageItemListener.setStarredCaptionStatus(model.messageItem.isMessageStarred(), txtRevCaptionStar)
                if(model.messageItem.mentionedUsersIds != null && model.messageItem.mentionedUsersIds.size > 0) {
                    val videoMentionText =  MentionUtils.formatMentionText(context, model.messageItem,false)
                    val mentionUserNames=MentionUtils.getMentionedUserId(context,model.messageItem,false)
                    val caption=MediaCaption(videoMentionText,videoReceiverViewHolder.txtRevChatCaption,model.searchEnabled,model.searchKey,mentionUserNames,model.messageItem)
                    messageItemListener.setMediaCaption(caption)
                } else {
                    val caption=MediaCaption(getSpannedText(model.messageItem.getMediaChatMessage().getMediaCaptionText()),videoReceiverViewHolder.txtRevChatCaption,model.searchEnabled,model.searchKey,SpannableStringBuilder(),model.messageItem)
                    messageItemListener.setMediaCaption(caption)
                }
            } else {
                viewRevImageCaption.gone()
                txtRevTime.show()
                txtRevTime.text = model.time
                txtRevCaptionStar.gone()
                viewRevImageBalloon.show()
                messageItemListener.setStaredStatus(model.messageItem.isMessageStarred(), imgStarred)
            }
            handleReceiverVideoLoading(this, model.filePath, model.base64Img)
            handleReceiverVideoItemProgressUpdate(model.messageItem, this)
        }
    }

    fun handleReceiverVideoLoading(videoReceiverViewHolder: VideoReceivedViewHolder, filePath: String?, base64Img: String?){
        with(videoReceiverViewHolder) {
            ImageUtils.loadReceiverVideoImageInView(context, imgRevImage,
                base64Img ?: "")
        }
    }

    fun setVideoReceiverMediaStatus(videoReceiverViewHolder: VideoReceivedViewHolder, messageItem: ChatMessage){
        val filePath = com.mirrorflysdk.utils.Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaLocalStoragePath())

        with(videoReceiverViewHolder) {
            val fileStatus = if (messageItem.isMessageSentByMe()) Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaUploadStatus().toString())
            else Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaDownloadStatus().toString())
            if (fileStatus.isNotEmpty()) {
                val status = MessageUtils.getMediaStatus(fileStatus, filePath, false)
                val mediaStatus = MediaStatus(txtRetryView, viewDownload, progressRev, status,
                    messageItem, imgRevPlay, cancelDownload, receivedImageForward, viewDownloadProgress,downloadProgressBuffer)
                messageItemListener.setMediaStatus(mediaStatus)
                messageItemListener.setMediaDuration(txtRevDuration, status, messageItem, imgRevChatType)
            }
            val fileSize = Utils.returnEmptyStringIfNull(messageItem.getMediaChatMessage().getMediaFileSize())
            messageItemListener.setImageViewSize(fileSize, viewDownload, txtImgSize)
        }
    }

    fun handleReceiverVideoItemProgressUpdate(
        messageItem: ChatMessage,
        videoReceivedViewHolder: VideoReceivedViewHolder
    ) {

        with(videoReceivedViewHolder) {
            val fileStatus = if (messageItem.isMessageSentByMe()) Utils.returnEmptyStringIfNull(
                messageItem.getMediaChatMessage().getMediaUploadStatus().toString()
            )
            else Utils.returnEmptyStringIfNull(
                messageItem.getMediaChatMessage().getMediaDownloadStatus().toString()
            )
            val progressPercentage = Utils.returnZeroIfStringEmpty(
                Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaProgressStatus()
                )
            )


            if (fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING && progressPercentage in 1..99) {
                progressRev.show()
                downloadProgressBuffer.gone()
                progressRev.max = 100
                progressRev.progress = progressPercentage
            } else {
                downloadProgressBuffer.show()
                progressRev.gone()
            }
        }
    }

    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in FrameLayout
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