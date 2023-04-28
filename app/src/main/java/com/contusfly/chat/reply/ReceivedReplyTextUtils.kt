/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.chat.reply

import android.content.Context
import android.text.TextUtils
import android.view.View
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.R
import com.contusfly.adapters.holders.ReplyMessageViewHolder
import com.contusfly.getColourCode
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.models.ReplyParentChatMessage

/**
 * This class handles the received reply message related operations
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
open class ReceivedReplyTextUtils : ReceivedReplyContactUtils(){
    /**
     * Displays the reply view, when the text message replied
     * from the sender is received.
     *
     * @param replyMessageViewHolder the view used to inflate the reply content.
     * @param replyMessage           the message object possessing the reply information.
     */
    fun showReceivedReplyTextView(context: Context?, replyMessageViewHolder: ReplyMessageViewHolder, replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        val groupNewUser = if (replyMessage.isMessageSentByMe()) Constants.YOU else replyMessage.getSenderUserName()
        if (groupNewUser != Constants.YOU && isGroupMessage) {
            replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(groupNewUser.getColourCode())
        } else {
            replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
        }
        replyMessageViewHolder.txtChatReceivedReply?.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
        replyMessageViewHolder.txtChatReceivedReply?.text = replyMessage.getMessageTextContent()
        replyMessageViewHolder.txtChatReceivedReplyUserName?.text = groupNewUser
    }

    /**
     * Displays the reply view, when either the image or the video message replied
     * from the sender is received.
     *
     * @param context                the parent startupActivityContext.
     * @param replyMessageViewHolder the view used to inflate the reply content.
     * @param replyMessage           the message object possessing the reply information.
     */
    fun showReceivedReplyImageVideoView(context: Context?, replyMessageViewHolder: ReplyMessageViewHolder, replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        val mediaDetail = replyMessage.getMediaChatMessage()
        replyMessageViewHolder.imgReceivedReplyMessageType?.visibility = View.VISIBLE
        replyMessageViewHolder.imgReceivedReplyMessageType?.setImageResource(R.drawable.ic_camera_receiver_reply)
        val userName = if (replyMessage.isMessageSentByMe()) Constants.YOU else replyMessage.getSenderUserName()
        val message = if (replyMessage.getMessageType() == MessageType.IMAGE) if (TextUtils.isEmpty(replyMessage.getMediaChatMessage().getMediaCaptionText())) context
                ?.getString(R.string.title_image) else replyMessage.getMediaChatMessage().getMediaCaptionText() else if (TextUtils.isEmpty(replyMessage.getMediaChatMessage().getMediaCaptionText())) context
                ?.getString(R.string.title_video) else replyMessage.getMediaChatMessage().getMediaCaptionText()
        replyMessageViewHolder.txtChatReceivedReply?.text = message
        if (userName != Constants.YOU && isGroupMessage) replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(userName.getColourCode()) else replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
        replyMessageViewHolder.txtChatReceivedReplyUserName?.text = userName
        replyMessageViewHolder.imgReceivedReplyImageVideoPreview?.visibility = View.VISIBLE
        if (replyMessage.getMessageType() == MessageType.IMAGE || replyMessage.getMessageType() == MessageType.VIDEO) {
            MediaUtils.loadImageInView(replyMessageViewHolder.imgReceivedReplyImageVideoPreview!!,
                    mediaDetail.getMediaLocalStoragePath(), mediaDetail.getMediaThumbImage(), context!!,
                    R.drawable.ic_image_placeholder)
        }
    }
}