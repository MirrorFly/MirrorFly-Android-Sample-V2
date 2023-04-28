package com.contusfly.chat.reply

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.Constants
import com.contusfly.R
import com.contusfly.adapters.holders.ReplyMessageViewHolder
import com.contusfly.chat.MapUtils.getMapImageUri
import com.contusfly.getColourCode
import com.contusfly.utils.MediaUtils.loadImageWithGlide
import com.mirrorflysdk.api.models.ReplyParentChatMessage

/**
 * This class handles the received reply message related operations
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
open class ReceivedReplyContactUtils : ReceivedReplyMediaUtils() {
    /**
     * Show received reply contact message
     *
     * @param replyMessageViewHolder Holder of the text view
     * @param context                Instance of the application
     * @param replyMessage           Reply message item
     */
    fun showReceivedReplyContactMessage(replyMessageViewHolder: ReplyMessageViewHolder,
                                        context: Context?, replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        replyMessageViewHolder.imgReceivedReplyMessageType!!.visibility = View.VISIBLE
        replyMessageViewHolder.imgReceivedReplyMessageType.setImageResource(R.drawable.ic_contact_receiver_reply)
        val userName = if (replyMessage.isMessageSentByMe()) Constants.YOU else replyMessage.getSenderUserName()
        val contactMessage = replyMessage.getContactChatMessage()
        val titleContact = context?.getString(R.string.action_contact) + " : " + contactMessage
                .getContactName()
        replyMessageViewHolder.txtChatReceivedReply!!.text = titleContact
        if (userName != com.contusfly.utils.Constants.YOU && isGroupMessage) replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(userName.getColourCode()) else replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(
            ContextCompat.getColor(context!!, R.color.color_black))
        replyMessageViewHolder.txtChatReceivedReplyUserName?.text = userName
    }

    /**
     * Show received reply location message
     *
     * @param replyMessageViewHolder Holder of the text view
     * @param context                Instance of the application
     * @param replyMessage           Reply message item
     */
    fun showReceivedReplyLocationMessage(replyMessageViewHolder: ReplyMessageViewHolder,
                                         context: Context?, replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        replyMessageViewHolder.imgReceivedReplyMessageType!!.visibility = View.VISIBLE
        replyMessageViewHolder.imgReceivedReplyMessageType.setImageResource(R.drawable.ic_map_reply)
        val userName = if (replyMessage.isMessageSentByMe()) Constants.YOU else replyMessage.getSenderUserName()
        replyMessageViewHolder.txtChatReceivedReply!!.text = context?.getString(R.string.action_location)

        if (userName != com.contusfly.utils.Constants.YOU && isGroupMessage) replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(userName.getColourCode()) else replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
        replyMessageViewHolder.txtChatReceivedReplyUserName?.text = userName
        replyMessageViewHolder.imgReceivedReplyImageVideoPreview!!.visibility = View.VISIBLE
        val url = getMapImageUri(replyMessage.getLocationChatMessage().getLatitude(),
                replyMessage.getLocationChatMessage().getLongitude())
        loadImageWithGlide(context, url, replyMessageViewHolder
                .imgReceivedReplyImageVideoPreview, R.drawable.ic_map_placeholder)
    }
}