package com.contusfly.chat.reply

import android.content.Context
import android.text.TextUtils
import android.view.View
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.Constants
import com.contusfly.R
import com.contusfly.adapters.holders.ReplyMessageViewHolder
import com.contusfly.getColourCode
import com.contusfly.utils.MediaDetailUtils.getMediaDuration
import com.mirrorflysdk.api.models.ReplyParentChatMessage

/**
 * This class handles the received reply message related operations
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
open class ReceivedReplyMediaUtils {
    /**
     * Show received reply audio message
     *
     * @param replyMessageViewHolder Holder of the text view
     * @param context                Instance of the application
     * @param replyMessage           Reply message item
     */
    fun showReceivedReplyAudioMessage(replyMessageViewHolder: ReplyMessageViewHolder,
                                      context: Context?, replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        replyMessageViewHolder.imgReceivedReplyMessageType!!.visibility = View.VISIBLE
        replyMessageViewHolder.imgReceivedReplyMessageType.setImageResource(R.drawable.ic_record)
        val userName = if (replyMessage.isMessageSentByMe()) Constants.YOU else replyMessage.getSenderUserName()
        val audioContent = context?.getString(R.string.title_audio) + " (" +
                getMediaDuration(context, replyMessage.getMediaChatMessage().getMediaDuration()) + ")"
        replyMessageViewHolder.txtChatReceivedReply!!.text = audioContent
        if (userName != com.contusfly.utils.Constants.YOU && isGroupMessage) replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(userName.getColourCode()) else replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(
            ContextCompat.getColor(context!!, R.color.color_black))

        replyMessageViewHolder.txtChatReceivedReplyUserName?.text = userName
    }

    /**
     * Show received reply file message
     *
     * @param replyMessageViewHolder Holder of the text view
     * @param context                Instance of the application
     * @param replyMessage           Reply message item
     */
    fun showReceivedReplyFileMessage(replyMessageViewHolder: ReplyMessageViewHolder,
                                     context: Context?, replyMessage: ReplyParentChatMessage, isGroupMessage: Boolean) {
        replyMessageViewHolder.imgReceivedReplyMessageType!!.visibility = View.VISIBLE
        replyMessageViewHolder.imgReceivedReplyMessageType.setImageResource(R.drawable.ic_file_receiver_reply)
        val userName = if (replyMessage.isMessageSentByMe()) Constants.YOU else replyMessage.getSenderUserName()
        val message = if (TextUtils.isEmpty(replyMessage.getMediaChatMessage().getMediaFileName())) context?.getString(R.string.title_file) else replyMessage.getMediaChatMessage().getMediaFileName()
        replyMessageViewHolder.txtChatReceivedReply!!.text = message
        replyMessageViewHolder.txtChatReceivedReplyUserName!!.setTextColor(userName.getColourCode())
        replyMessageViewHolder.txtChatReceivedReplyUserName.text = userName
        if (userName != com.contusfly.utils.Constants.YOU && isGroupMessage) replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(userName.getColourCode()) else replyMessageViewHolder.txtChatReceivedReplyUserName?.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
        replyMessageViewHolder.txtChatReceivedReplyUserName?.text = userName
    }
}