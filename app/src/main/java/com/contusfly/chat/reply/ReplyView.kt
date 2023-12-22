package com.contusfly.chat.reply

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.*
import com.contusfly.adapters.holders.ReplyMessageViewHolder
import com.contusfly.chat.ImageFileUtils
import com.contusfly.chat.MapUtils
import com.contusfly.utils.*
import com.contusfly.utils.ChatUtils.setReplyViewMessageFormat
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.api.*
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.ReplyParentChatMessage


class ReplyView {

    /**
     * Displays the reply view for the marked message which has to be replied.
     *
     * @param context                   the parent startupActivityContext.
     * @param replyMessageViewHolder    the view used to inflate the reply content.
     * @param replyMessage              the reply message object of specific message that possessing the reply information.
     */
    fun showSenderReplyView(context: Context, replyMessageViewHolder: ReplyMessageViewHolder, replyMessage: ReplyParentChatMessage?, isGroupMessage: Boolean) {

        with(replyMessageViewHolder) {
            showViews(imgSenderMessageType!!)
            makeViewsGone(imgSenderImageVideoPreview!!)
            msgMeetReplyLayout?.visibility = View.GONE
            if (replyMessage == null)
                makeViewsGone(txtChatReplyUserName!!)
            else {
                txtChatReplyUserName?.show()
                setSenderNameColor(context, txtChatReplyUserName, isGroupMessage, replyMessage)
                txtChatReplyUserName?.text = replyMessage.getSenderName()
            }
        }

         val replyMsg = if (replyMessage == null) null else FlyMessenger.getMessageOfId(replyMessage.messageId)

        if (replyMessage == null || replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted() || replyMsg?.isMessageRecalled == true || replyMsg?.isMessageDeleted == true)
            with(replyMessageViewHolder) {
                txtChatReply?.text = context.getString(R.string.recalled_message_not_available)
                makeViewsGone(imgSenderImageVideoPreview!!, imgSenderMessageType!!)
            }
        else {
            when (replyMessage.messageType) {
                MessageType.TEXT,MessageType.AUTO_TEXT -> {
                    with(replyMessageViewHolder) {
                        txtChatReply?.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
                        replyMsg?.let { setReplyViewMessageFormat(it,context,txtChatReply!!,"",false) }
                        makeViewsGone(imgSenderImageVideoPreview!!, imgSenderMessageType!!)
                    }
                }
                MessageType.IMAGE, MessageType.VIDEO -> {
                    val decodeImageUtils by lazy { DecodeImageUtils() }
                    val mediaDetail = replyMessage.getMediaChatMessage()
                    with(replyMessageViewHolder) {
                        replyMsg?.let { setReplyViewMessageFormat(it,context,txtChatReply!!,"",true) }
                        imgSenderMessageType?.setImageResource(if (replyMessage.isImageMessage()) R.drawable.ic_camera_reply
                        else R.drawable.ic_video_reply)
                        imgSenderImageVideoPreview?.show()
                        decodeImageUtils.loadImageInView(imgSenderImageVideoPreview, mediaDetail.getMediaLocalStoragePath(),
                                mediaDetail.getMediaThumbImage(), context, R.drawable.ic_image_placeholder)
                    }
                }
                MessageType.LOCATION -> {
                    with(replyMessageViewHolder) {
                        txtChatReply?.text = context.getString(R.string.action_location)
                        imgSenderMessageType?.setImageResource(R.drawable.ic_map_reply)
                        imgSenderImageVideoPreview?.show()
                        val url = MapUtils.getMapImageUri(replyMessage.getLocationChatMessage().getLatitude(), replyMessage.getLocationChatMessage().getLongitude())
                        MediaUtils.loadImageWithGlide(context, url, imgSenderImageVideoPreview!!, R.drawable.ic_map_placeholder)
                    }
                }
                MessageType.CONTACT -> {
                    with(replyMessageViewHolder) {
                        val contactMessage = context.getString(R.string.action_contact) + " : " + replyMessage.getContactChatMessage().getContactName()
                        txtChatReply?.text = contactMessage
                        imgSenderMessageType?.setImageResource(R.drawable.ic_contact_reply)
                    }
                }
                MessageType.AUDIO -> {
                    with(replyMessageViewHolder) {
                        txtChatReply?.text = MediaDetailUtils.getMediaDuration(context, replyMessage.getMediaChatMessage().getMediaDuration())
                        imgSenderMessageType?.gone()
                        imgSenderImageVideoPreview?.show()
                        imgSenderImageVideoPreview?.setImageResource(getAudioResource(replyMessage))
                    }
                }
                MessageType.DOCUMENT -> {
                    with(replyMessageViewHolder) {
                        EmojiUtils.setMessageTextWithEllipsis(txtChatReply!!, replyMessage.getMediaFileName(context))
                        imgSenderMessageType?.setImageResource(R.drawable.ic_file_reply)
                        imgSenderImageVideoPreview?.let {
                            imgSenderImageVideoPreview.show()
                            ImageFileUtils.setSenderFileImage(imgSenderImageVideoPreview, replyMessage.getMediaFileName(context))
                        }
                    }
                }
                MessageType.MEET -> {
                    with(replyMessageViewHolder) {
                        val meetMessage = ChatUserTimeUtils.scheduledDateTimeFormat(replyMessage.meetingChatMessage.scheduledDateTime.toLong())
                        txtChatReply?.text = meetMessage
                        imgSenderMessageType?.setImageResource(R.drawable.ic_reply_meet)
                        imgSenderImageVideoPreview?.gone()
                        msgMeetReplyLayout?.show()
                        msgImageMeet?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.mirrorfly_icon)!!)

                    }
                }
                else -> {
                /*No Implementation needed*/
                }
            }
        }
    }

    private fun setSenderNameColor(context: Context, txtChatReplyUserName: CustomTextView?, isGroupMessage: Boolean, replyMessage: ReplyParentChatMessage) {
        if (replyMessage.getSenderName() != com.mirrorflysdk.flycommons.Constants.YOU && isGroupMessage)
            txtChatReplyUserName?.setTextColor(replyMessage.getSenderName().getColourCode())
        else
            txtChatReplyUserName?.setTextColor(ContextCompat.getColor(context, R.color.color_black))

    }

    private fun getAudioResource(replyMessage: ReplyParentChatMessage): Int {
        return  if (replyMessage.getMediaChatMessage().isAudioRecorded()) R.drawable.ic_record_audio_reply else R.drawable.ic_music_audio_reply
    }

    /**
     * Displays the reply view, when the text message replied from the sender is received.
     *
     * @param context                   the parent startupActivityContext.
     * @param replyMessageViewHolder    the view used to inflate the reply content.
     * @param replyMessage              the reply message object of specific message that possessing the reply information.
     */
    fun showReceiverReplyView(context: Context, replyMessageViewHolder: ReplyMessageViewHolder, messageItem: ChatMessage, isGroupMessage: Boolean) {
        val replyMessage = messageItem.getReplyParentChatMessage()
        with(replyMessageViewHolder) {
            showViews(imgReceivedReplyMessageType!!)
            makeViewsGone(imgReceivedReplyImageVideoPreview!!)
            msgMeetReplyLayout?.visibility = View.GONE
            if (replyMessage == null)
                makeViewsGone(txtChatReceivedReplyUserName!!)
            else {
                txtChatReceivedReplyUserName?.show()
                setSenderNameColor(context, txtChatReceivedReplyUserName, isGroupMessage, replyMessage)
                txtChatReceivedReplyUserName?.text = replyMessage.getSenderName()
            }
        }
        val replyMsg = if (replyMessage == null) null else FlyMessenger.getMessageOfId(replyMessage.messageId)
        if (replyMessage == null || replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted() || replyMsg?.isMessageRecalled() == true || replyMsg?.isMessageDeleted() == true)
            with(replyMessageViewHolder) {
                txtChatReceivedReply?.text = context.getString(R.string.recalled_message_not_available)
                makeViewsGone(imgReceivedReplyImageVideoPreview!!, imgReceivedReplyMessageType!!)
            }
        else {
            when (replyMessage.getMessageType()) {
                MessageType.TEXT,MessageType.AUTO_TEXT -> {
                    with(replyMessageViewHolder) {
                        txtChatReceivedReply?.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
                        replyMsg?.let { setReplyViewMessageFormat(it,context,txtChatReceivedReply!!,"",false) }
                        makeViewsGone(imgReceivedReplyImageVideoPreview!!, imgReceivedReplyMessageType!!)
                    }
                }
                MessageType.IMAGE, MessageType.VIDEO -> {
                    val decodeImageUtils by lazy { DecodeImageUtils() }
                    val mediaDetail = replyMessage.getMediaChatMessage()
                    with(replyMessageViewHolder) {
                        replyMsg?.let { setReplyViewMessageFormat(it,context,txtChatReceivedReply!!,"",true) }
                        imgReceivedReplyMessageType?.setImageResource(if (replyMessage.isImageMessage()) R.drawable.ic_camera_reply
                        else R.drawable.ic_video_receiver_reply)
                        imgReceivedReplyImageVideoPreview?.show()
                        decodeImageUtils.loadImageInView(imgReceivedReplyImageVideoPreview, mediaDetail.getMediaLocalStoragePath(),
                                mediaDetail.getMediaThumbImage(),  context, R.drawable.ic_image_placeholder)
                    }
                }
                MessageType.LOCATION -> {
                    with(replyMessageViewHolder) {
                        txtChatReceivedReply?.text = context.getString(R.string.action_location)
                        imgReceivedReplyMessageType?.setImageResource(R.drawable.ic_map_receiver_reply)
                        imgReceivedReplyImageVideoPreview?.show()
                        val url = MapUtils.getMapImageUri(replyMessage.getLocationChatMessage().getLatitude(), replyMessage.getLocationChatMessage().getLongitude())
                        MediaUtils.loadImageWithGlide(context, url, imgReceivedReplyImageVideoPreview!!, R.drawable.ic_map_placeholder)
                    }
                }
                MessageType.CONTACT -> {
                    with(replyMessageViewHolder) {
                        val contactMessage = context.getString(R.string.action_contact) + " : " + replyMessage.getContactChatMessage().getContactName()
                        txtChatReceivedReply?.text = contactMessage
                        imgReceivedReplyMessageType?.setImageResource(R.drawable.ic_contact_receiver_reply)
                    }
                }
                MessageType.AUDIO -> {
                    with(replyMessageViewHolder) {
                        txtChatReceivedReply?.text = MediaDetailUtils.getMediaDuration(context, replyMessage.getMediaChatMessage().getMediaDuration())
                        imgReceivedReplyMessageType?.gone()
                        imgReceivedReplyImageVideoPreview?.show()
                        imgReceivedReplyImageVideoPreview?.setImageResource(getAudioResource(replyMessage))
                    }
                }
                MessageType.DOCUMENT -> {
                    with(replyMessageViewHolder) {
                        EmojiUtils.setMessageTextWithEllipsis(txtChatReceivedReply!!, replyMessage.getMediaFileName(context))
                        imgReceivedReplyMessageType?.setImageResource(R.drawable.ic_file_receiver_reply)
                        imgReceivedReplyImageVideoPreview?.let {
                            imgReceivedReplyImageVideoPreview.show()
                            ImageFileUtils.setReceiverFileImage(imgReceivedReplyImageVideoPreview, replyMessage.getMediaFileName(context))
                        }
                    }
                }
                MessageType.MEET -> {
                    with(replyMessageViewHolder) {
                        val meetMessage = ChatUserTimeUtils.scheduledDateTimeFormat(replyMessage.meetingChatMessage.scheduledDateTime.toLong())
                        txtChatReceivedReply?.text = meetMessage
                        imgReceivedReplyMessageType?.setImageResource(R.drawable.ic_reply_meet)
                        val tintColor = ContextCompat.getColor(context, R.color.meet_reply_receiver_tint_color)
                        imgReceivedReplyMessageType?.setColorFilter(tintColor)
                        imgReceivedReplyImageVideoPreview?.gone()
                        msgMeetReplyLayout?.show()
                        msgImageMeet?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.mirrorfly_icon)!!)

                    }
                }
                else -> {
                    /*No Implementation needed*/
                }
            }
        }
    }

}