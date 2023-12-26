/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.chat.reply

import android.content.Context
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.adapters.holders.ReplyMessageViewHolder
import com.contusfly.gone
import com.mirrorflysdk.api.models.ReplyParentChatMessage

/**
 * This class handles the received reply message related operations. This class holds the
 * viewholder for the message types of text, image, video, location type, audio, file
 * and contacts. It handles the viewholder for received reply content from the
 * sender.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ReplyReceivedMessageUtils : ReceivedReplyTextUtils() {
    /**
     * Displays the reply view for the received messages if it contains the replied content.
     *
     * @param context                the parent startupActivityContext.
     * @param replyMessageViewHolder the view used to inflate the reply content.
     * @param replyMessage              the id of the respective message object which contains
     * reply information.
     */
    fun showReceivedReplyMessage(context: Context?, replyMessageViewHolder: ReplyMessageViewHolder,
                                 replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        replyMessageViewHolder.imgReceivedReplyImageVideoPreview?.gone()
        replyMessageViewHolder.imgReceivedReplyMessageType?.gone()
        when (replyMessage.getMessageType()) {
            MessageType.TEXT,MessageType.AUTO_TEXT -> showReceivedReplyTextView(context, replyMessageViewHolder, replyMessage, isGroupMessage)
            MessageType.IMAGE, MessageType.VIDEO -> showReceivedReplyImageVideoView(context, replyMessageViewHolder, replyMessage, isGroupMessage)
            MessageType.LOCATION -> showReceivedReplyLocationMessage(replyMessageViewHolder, context, replyMessage, isGroupMessage)
            MessageType.AUDIO -> showReceivedReplyAudioMessage(replyMessageViewHolder, context, replyMessage, isGroupMessage)
            MessageType.DOCUMENT -> showReceivedReplyFileMessage(replyMessageViewHolder, context, replyMessage, isGroupMessage)
            MessageType.CONTACT -> showReceivedReplyContactMessage(replyMessageViewHolder, context, replyMessage, isGroupMessage)
            else -> {
                /*No Implementation Needed*/
            }
        }
    }
}