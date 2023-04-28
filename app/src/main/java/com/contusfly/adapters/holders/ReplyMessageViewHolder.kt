/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.gone
import com.contusfly.show
import com.contusfly.views.CustomTextView
import com.contusfly.views.MessageTextView

/**
 * Reply message view holder contains the fields of the reply message view in chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
open class ReplyMessageViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
    /**
     * View for the reply sent message
     */
    val replyMessageSentView: View? = view.findViewById(R.id.view_text_sent_reply)

    val replyMessageSentLayout: ConstraintLayout? = view.findViewById(R.id.view_text_sent_reply_layout)

    /**
     * View for the reply received message
     */
    val replyMessageReceivedView: View? = view.findViewById(R.id.view_text_received_reply)

    /**
     * Text message of the chat
     */
    val txtChatReply: MessageTextView? = view.findViewById(R.id.text_reply_chat)

    /**
     * Text message of the chat
     */
    val txtChatReceivedReply: MessageTextView? = view.findViewById(R.id.text_reply_received_chat)

    /**
     * Text message of the chat
     */
    val txtChatReplyUserName: CustomTextView? = view.findViewById(R.id.text_reply_user_name)

    /**
     * Text message of the chat
     */
    val txtChatReceivedReplyUserName: CustomTextView? = view.findViewById(R.id.text_received_reply_user_name)

    /**
     * Text message of the chat
     */
    val imgSenderMessageType: ImageView? = view.findViewById(R.id.msg_item_icon)

    /**
     * Text message of the chat
     */
    val imgSenderImageVideoPreview: ImageView? = view.findViewById(R.id.msg_image_video)

    /**
     * Text message of the chat
     */
    val imgReceivedReplyMessageType: ImageView? = view.findViewById(R.id.msg_received_item_icon)

    /**
     * Text message of the chat
     */
    val imgReceivedReplyImageVideoPreview: ImageView? = view.findViewById(R.id.msg_received_image_video)

    /**
     * Show sent reply view
     */
    fun showSentReplyView() {
        if (replyMessageSentView != null) replyMessageSentView.visibility = View.VISIBLE
        replyMessageSentLayout?.show()
    }

    /**
     * Hide sent reply view
     */
    fun hideSentReplyView() {
        if (replyMessageSentView != null) replyMessageSentView.visibility = View.GONE
        replyMessageSentLayout?.gone()
    }

    /**
     * Show received reply view
     */
    fun showReceivedReplyView() {
        if (replyMessageReceivedView != null) replyMessageReceivedView.visibility = View.VISIBLE
    }

    /**
     * Hide received reply view
     */
    fun hideReceivedReplyView() {
        if (replyMessageReceivedView != null) replyMessageReceivedView.visibility = View.GONE
    }

}