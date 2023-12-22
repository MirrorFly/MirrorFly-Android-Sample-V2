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
 * This class handles the sent reply message related operations
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ReplyMessageUtils : SentReplyTextUtils() {
    /**
     * Displays the reply view for the marked message which has to be replied.
     *
     * @param context                the parent startupActivityContext.
     * @param replyMessageViewHolder the view used to inflate the reply content.
     * @param replyMessage           the Message of the respective message object which is marked
     * for the reply action.
     */
    fun showReplyMessage(context: Context?, replyMessageViewHolder: ReplyMessageViewHolder,
                         replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        replyMessageViewHolder.imgSenderImageVideoPreview?.gone()
        replyMessageViewHolder.imgSenderMessageType?.gone()
        when (replyMessage.getMessageType()) {
            MessageType.TEXT ,MessageType.AUTO_TEXT-> showSenderReplyTextView(context, replyMessageViewHolder, replyMessage, isGroupMessage)
            MessageType.IMAGE -> showSenderReplyImageVideoView(context!!, replyMessageViewHolder, replyMessage, isGroupMessage)
            else -> {
                /*No Implementation Needed*/
            }
        }
    }
}