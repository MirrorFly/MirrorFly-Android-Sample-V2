package com.contusfly.adapters.viewhelpers

import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.contusfly.R
import com.contusfly.adapters.holders.AudioReceivedViewHolder
import com.contusfly.adapters.holders.AudioSentViewHolder
import com.contusfly.chat.AudioHandler
import com.contusfly.chat.MessageUtils
import com.contusfly.gone
import com.contusfly.interfaces.MessageItemListener
import com.contusfly.makeViewsGone
import com.contusfly.show
import com.contusfly.utils.Utils
import com.mirrorflysdk.api.models.ChatMessage


/**
 * Audio sent/received item view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class AudioItemView(private val messageItemListener: MessageItemListener) {

    /**
     * Sender audio item view
     *
     * @param message            Message item
     * @param audioViewHolder Audio item view holder
     * @param time            Time of message sent
     */
    fun audioSenderItemView(audioViewHolder: AudioSentViewHolder, time: String?, message: ChatMessage) {
        with(audioViewHolder) {
            txtSendTime.text = time
            messageItemListener.setStatus(message, imgSenderStatus)
            setAudioSenderMediaStatus(this, message)
            handleSenderAudioItemProgressUpdate(message, this)
            if (message.mediaChatMessage.isAudioRecorded) {
                audioViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_recorded_icon)
            } else {
                audioViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_music_icon)
            }
        }
    }

    fun setAudioSenderMediaStatus(audioViewHolder: AudioSentViewHolder, message: ChatMessage){
        with(audioViewHolder) {
            val fileUploadStatus = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaUploadStatus().toString())
            val fileDownloadStatus = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaDownloadStatus().toString())
            val fileStatus = if (message.isItCarbonMessage()) fileDownloadStatus else fileUploadStatus

            if (fileStatus.isNotEmpty()) {
                AudioHandler.setAudioStatus(if (message.isItCarbonMessage()) viewCarbonRetry else viewRetry, progressSender, fileStatus.toInt(), imgAudioPlay, message.messageId, sentAudioForwardImage, progressUploadDownloadLayout)
                messageItemListener.setMediaDuration(txtAudioDuration, fileStatus.toInt(), message, null)
            }
        }
    }

    /**
     * Sender audio uploading progress based on file upload status
     *
     * @param message      Message item
     * @param audioSentViewHolder    Audio item view holder
     */
    fun handleSenderAudioItemProgressUpdate(
        message: ChatMessage,
        audioSentViewHolder: AudioSentViewHolder
    ) {
        val fileUploadStatus = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaUploadStatus().toString())
        val fileDownloadStatus = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaDownloadStatus().toString())
        val fileStatus = if (message.isItCarbonMessage()) fileDownloadStatus else fileUploadStatus

        val progressPercentage = Utils.returnZeroIfStringEmpty(Utils.returnEmptyStringIfNull(message.mediaChatMessage.mediaProgressStatus))
        with(audioSentViewHolder) {
            if ((fileStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADING || fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING) && progressPercentage > 0 && progressPercentage < 100) {
                progressSender.show()
                progressUploadDownloadBuffer.gone()
                progressSender.max = 100
                progressSender.progress = progressPercentage
            } else if ((fileStatus.toInt() == MediaUploadStatus.MEDIA_UPLOADING || fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING) && (progressPercentage < 1 || progressPercentage >= 100)) {
                progressSender.gone()
                progressUploadDownloadBuffer.show()
            }
        }
    }

    /**
     * Receiver audio item view
     *
     * @param message                    Message item
     * @param audioReceiverViewHolder Audio item view holder
     * @param time                    Time of message sent
     */
    fun audioReceiverItemView(audioReceiverViewHolder: AudioReceivedViewHolder, time: String?, message: ChatMessage) {
        with(audioReceiverViewHolder) {
            txtSendTime.text = time
            setAudioReceiverMediaStatus(audioReceiverViewHolder, message)
            handleReceiverAudioItemProgressUpdate(message, this)
            if (message.mediaChatMessage.isAudioRecorded) {
                audioReceiverViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_recorded_icon)
            } else {
                audioReceiverViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_music_icon)
            }
        }
    }

    fun setAudioReceiverMediaStatus(audioReceiverViewHolder: AudioReceivedViewHolder, message: ChatMessage){
        with(audioReceiverViewHolder) {
            val fileStatus =
                if (message.isMessageSentByMe) Utils.returnEmptyStringIfNull(message.mediaChatMessage.mediaUploadStatus.toString())
                else Utils.returnEmptyStringIfNull(message.mediaChatMessage.mediaDownloadStatus.toString())
            if (fileStatus.isNotEmpty()) {
                val filePath = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaLocalStoragePath())
                AudioHandler.setAudioStatus(viewRetry, progressSender, MessageUtils.getMediaStatus(fileStatus, filePath, false), imgAudioPlay, message.messageId, sentAudioForwardImage, progressUploadDownloadLayout)
                messageItemListener.setMediaDuration(txtAudioDuration, fileStatus.toInt(), message, null)
            }
        }
    }

    /**
     * Receiver audio downloading progress based on file upload status
     *
     * @param message      Message item
     * @param audioReceiverViewHolder    Audio item view holder
     */
    fun handleReceiverAudioItemProgressUpdate(message: ChatMessage, audioReceiverViewHolder: AudioReceivedViewHolder){

        val progressPercentage = Utils.returnZeroIfStringEmpty(Utils.returnEmptyStringIfNull(message.mediaChatMessage.mediaProgressStatus))

        val fileStatus = if (message.isMessageSentByMe) Utils.returnEmptyStringIfNull(message.mediaChatMessage.mediaUploadStatus.toString())
        else Utils.returnEmptyStringIfNull(message.mediaChatMessage.mediaDownloadStatus.toString())

        with(audioReceiverViewHolder) {
            if (fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING && progressPercentage > 0 && progressPercentage < 100) {
                progressSender.show()
                progressUploadDownloadBuffer.gone()
                progressSender.max = 100
                progressSender.progress = progressPercentage
            } else if (fileStatus.toInt() == MediaDownloadStatus.MEDIA_DOWNLOADING && (progressPercentage < 1 || progressPercentage >= 100)) {
                progressSender.gone()
                progressUploadDownloadBuffer.show()
            }
        }
    }

    /**
     * Disable the unwanted views in the chat view
     *
     * @param audioViewHolder Holder of the audio view
     */
    fun disableSenderAudioViews(audioViewHolder: AudioSentViewHolder, fromStarred: Boolean = false) {
        with(audioViewHolder) {
            makeViewsGone(progressSender, progressUploadDownloadBuffer, imgAudioPlay, viewRetry)
            if (!fromStarred)
                audSentStarred.gone()
        }
    }

    /**
     * Disable the unwanted views in the chat view
     *
     * @param audioReceiverViewHolder Holder of the audio view
     */
    fun disableReceiverAudioViews(audioReceiverViewHolder: AudioReceivedViewHolder, fromStarred: Boolean = false) {
        with(audioReceiverViewHolder) {
            makeViewsGone(progressSender, progressUploadDownloadBuffer, imgAudioPlay, viewRetry)
            if (!fromStarred)
                audRevStarred.gone()
        }
    }

}