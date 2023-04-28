package com.contusfly.chat

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.*
import com.contusfly.utils.*
import com.contusfly.viewmodels.ChatParentViewModel
import com.contusfly.views.CustomTextView
import com.contusfly.views.MessageTextView
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.utils.Utils


/**
 * Presenter class for the reply related operation
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ReplyViewHandler(val context: Context, replyLayout: View) {

    private val messageContent: MessageTextView = replyLayout.findViewById(R.id.text_reply_chat)
    private val messageSenderName: CustomTextView = replyLayout.findViewById(R.id.text_reply_user_name)
    private val messageTypeIcon: AppCompatImageView = replyLayout.findViewById(R.id.msg_item_icon)
    private val messageImageOrVideoThumb: AppCompatImageView = replyLayout.findViewById(R.id.msg_image_video)

    /**
     * Show sender reply message in the message item
     *
     * @param messageId Reply message id
     */
    fun showReplyMessageToSend(messageId: String, parentViewmodel: ChatParentViewModel, suggestionLayout: LinearLayout, jid: String) {
        try {
            messageTypeIcon.gone()
            messageImageOrVideoThumb.gone()
            val replyMessage = FlyMessenger.getMessageOfId(messageId)
            replyMessage?.let {
                suggestionLayout.gone()
                parentViewmodel.addMessage(replyMessage, jid)
                when (replyMessage.messageType) {
                    MessageType.TEXT ->
                        showReplyTextMessage(replyMessage)
                    MessageType.IMAGE, MessageType.VIDEO ->
                        showReplyImageVideoMessage(replyMessage)
                    MessageType.LOCATION -> showReplyLocationMessage(replyMessage)
                    MessageType.AUDIO -> showReplyAudioMessage(replyMessage)
                    MessageType.DOCUMENT -> showSentReplyFileMessage(replyMessage)
                    MessageType.CONTACT -> showReplyContactMessage(replyMessage)
                    else -> {
                        /*
                        * No Implementation Needed
                        */
                    }
                }
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Show reply message for send
     *
     * @param replyMessage       Reply message item
     */
    private fun showReplyTextMessage(replyMessage: ChatMessage) {
        if(replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted())
            showRecalledReplyMessage(replyMessage)
        else {
            messageContent.text = ChatUtils.getSpannedText(context,replyMessage.getMessageTextContent())
            messageSenderName.text = replyMessage.getSenderName()
            val msg = ChatUtils.getSpannedText(context,replyMessage.getMessageTextContent())
            messageContent.text = msg
        }
    }

    /**
     * Show sent reply image/video message
     *
     * @param replyMessage Reply message item
     */
    private fun showReplyImageVideoMessage(replyMessage: ChatMessage) {
        if(replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted())
            showRecalledReplyMessage(replyMessage)
        else {
            messageTypeIcon.show()
            messageImageOrVideoThumb.show()
            if (replyMessage.isVideoMessage())
                messageTypeIcon.setImageResource(R.drawable.ic_video_reply)
            else
                messageTypeIcon.setImageResource(R.drawable.ic_camera_reply)
            if (replyMessage.isImageMessage())
                messageContent.text = context.getString(R.string.title_image)
            else
                messageContent.text = context.getString(R.string.title_video)
            if(Utils.returnEmptyStringIfNull(replyMessage.mediaChatMessage.getMediaCaptionText()).isNotEmpty())
                messageContent.text = replyMessage.mediaChatMessage.getMediaCaptionText()
            messageSenderName.text = replyMessage.getSenderName()
            ImageUtils.loadImageInView(context, replyMessage.mediaChatMessage.getMediaLocalStoragePath(), messageImageOrVideoThumb,
                    replyMessage.mediaChatMessage.getMediaThumbImage(), R.drawable.ic_image_placeholder)
            messageSenderName.text = replyMessage.getSenderName()
        }
    }

    /**
     * Show sent reply contact message
     *
     * @param replyMessage       Reply message item
     */
    private fun showReplyContactMessage(replyMessage: ChatMessage) {
        if(replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted())
            showRecalledReplyMessage(replyMessage)
        else {
            messageTypeIcon.show()
            messageTypeIcon.setImageResource(R.drawable.ic_contact_reply)
            val titleContact = context.getString(R.string.action_contact) + " : " + replyMessage.contactChatMessage.contactName
            messageContent.text = titleContact
            messageSenderName.text = replyMessage.getSenderName()
        }
    }

    /**
     * Show sent reply location message
     *
     * @param replyMessage       Reply message item
     */
    private fun showReplyLocationMessage(replyMessage: ChatMessage) {
        if(replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted())
            showRecalledReplyMessage(replyMessage)
        else {
            messageTypeIcon.show()
            messageImageOrVideoThumb.show()
            messageTypeIcon.setImageResource(R.drawable.ic_map_reply)
            messageContent.text = context.getString(R.string.action_location)
            val url = MapUtils.getMapImageUri(replyMessage.getLocationChatMessage().getLatitude(), replyMessage.getLocationChatMessage().getLongitude())
            MediaUtils.loadImageWithGlide(context, url, messageImageOrVideoThumb, R.drawable.ic_map_placeholder)
            messageSenderName.text = replyMessage.getSenderName()
        }
    }

    /**
     * Show sent reply audio message
     *
     * @param replyMessage Reply message item
     */
    private fun showReplyAudioMessage(replyMessage: ChatMessage) {
        if(replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted())
            showRecalledReplyMessage(replyMessage)
        else {
            messageTypeIcon.show()
            if (replyMessage.mediaChatMessage.isAudioRecorded){
                messageTypeIcon.setImageResource(R.drawable.ic_record_reply_preview)
            } else {
                messageTypeIcon.setImageResource(R.drawable.ic_audio_reply_preview)
            }
            val audioContent = MediaDetailUtils.getMediaDuration(context, replyMessage.mediaChatMessage.getMediaDuration()) + " "+context.getString(R.string.title_audio)
            messageContent.text = audioContent
            messageSenderName.text = replyMessage.getSenderName()
        }
    }

    /**
     * Show sent reply file message
     *
     * @param replyMessage Reply message item
     */
    private fun showSentReplyFileMessage(replyMessage: ChatMessage) {
        if(replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted())
            showRecalledReplyMessage(replyMessage)
        else {
            messageTypeIcon.show()
            messageTypeIcon.setImageResource(R.drawable.ic_file_reply)
            messageContent.text = replyMessage.mediaChatMessage.mediaFileName
            messageSenderName.text = replyMessage.getSenderName()
        }
    }

    /**
     * Show recalled reply messages
     *
     * @param replyMessage Reply message item
     */
    private fun showRecalledReplyMessage(replyMessage: ChatMessage){
        messageContent.text= context.getString(R.string.recalled_message_not_available)
        messageSenderName.text = replyMessage.getSenderName()
    }

}