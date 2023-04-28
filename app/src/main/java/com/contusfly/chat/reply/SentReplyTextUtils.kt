/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.chat.reply

import android.content.Context
import android.text.TextUtils
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.R
import com.contusfly.adapters.holders.ReplyMessageViewHolder
import com.contusfly.getColourCode
import com.contusfly.show
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.models.ReplyParentChatMessage

/**
 * This class handles the sent reply message related operations
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
open class SentReplyTextUtils {
    /**
     * Displays the reply view, when the text message
     * is marked for the reply action.
     *
     * @param replyMessageViewHolder the view used to inflate the reply content.
     * @param replyMessage           the message object possessing the reply information.
     */
    fun showSenderReplyTextView(context: Context?, replyMessageViewHolder: ReplyMessageViewHolder, replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        val groupNewUser = if (replyMessage.isMessageSentByMe()) Constants.YOU else replyMessage.getSenderUserName()
        replyMessageViewHolder.txtChatReply?.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
        replyMessageViewHolder.txtChatReply?.text = replyMessage.getMessageTextContent()
        if (groupNewUser != Constants.YOU && isGroupMessage) {
            replyMessageViewHolder.txtChatReplyUserName?.setTextColor(groupNewUser.getColourCode())
        } else {
            replyMessageViewHolder.txtChatReplyUserName?.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
        }
        replyMessageViewHolder.txtChatReplyUserName?.text = groupNewUser
    }

    /**
     * Displays the reply view, when either the image or the video message
     * is marked for the reply action.
     *
     * @param context                the parent startupActivityContext.
     * @param replyMessageViewHolder the view used to inflate the reply content.
     * @param replyMessage           the message object possessing the reply information.
     */
    fun showSenderReplyImageVideoView(context: Context, replyMessageViewHolder: ReplyMessageViewHolder, replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        val mediaDetail = replyMessage.getMediaChatMessage()
        replyMessageViewHolder.imgSenderMessageType?.show()
        replyMessageViewHolder.imgSenderMessageType?.setImageResource(R.drawable.ic_camera_reply)
        val userName = if (replyMessage.isMessageSentByMe()) Constants.YOU else replyMessage.getSenderUserName()
        val message = if (replyMessage.getMessageType() == MessageType.IMAGE) if (TextUtils.isEmpty(mediaDetail.getMediaCaptionText())) context
                .getString(R.string.title_image) else mediaDetail.getMediaCaptionText() else if (TextUtils.isEmpty(mediaDetail.getMediaCaptionText())) context
                .getString(R.string.title_video) else mediaDetail.getMediaCaptionText()
        replyMessageViewHolder.txtChatReply?.text = message
        if (userName != Constants.YOU && isGroupMessage) replyMessageViewHolder.txtChatReplyUserName?.setTextColor(userName.getColourCode()) else replyMessageViewHolder.txtChatReplyUserName?.setTextColor(ContextCompat.getColor(context, R.color.color_black))
        replyMessageViewHolder.txtChatReplyUserName?.text = userName
        replyMessageViewHolder.imgSenderImageVideoPreview?.show()
        if (replyMessage.getMessageType() == MessageType.IMAGE || replyMessage.getMessageType() == MessageType.VIDEO) {
            MediaUtils.loadImageInView(replyMessageViewHolder.imgSenderImageVideoPreview!!, mediaDetail.getMediaLocalStoragePath(),
                    mediaDetail.getMediaThumbImage(), context, R.drawable.ic_image_placeholder)
        }
    }
}