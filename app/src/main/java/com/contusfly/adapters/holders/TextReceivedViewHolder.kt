/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.holders

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.emoji.widget.EmojiAppCompatTextView
import com.contusfly.R
import io.github.rockerhieu.emojicon.EmojiconTextView

/**
 * View holder class for the Chat message view to prepare the recycler view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class TextReceivedViewHolder(mainView: View) : SenderNameHolder(mainView) {
    /**
     * returns the receiver view
     */
    /**
     * Receiver Chat view
     */
    val viewReceiver: View = mainView.findViewById(R.id.ll_chat_txt_received_view)

    /**
     * Sender Chat view divider line
     */
    val viewDiver: View? = mainView.findViewById(R.id.view_divider)

    /*
     * Join Link Meeting View */
    val receiverJoinLinkView: LinearLayout = mainView.findViewById(R.id.row_join_link_view)

    /*
     * Join Link Meeting Logo */
    val receiverJoinLinkLogo: ImageView = mainView.findViewById(R.id.join_link_logo)

    /**
     * returns the receiver view row item
     */
    /**
     * Over all chat view
     */
    val viewRowItem: LinearLayout = mainView.findViewById(R.id.row_chat_text)
    /**
     * returns the chat textview
     */
    /**
     * Text message of the chat
     */
    val txtChatReceiver: EmojiconTextView = mainView.findViewById(R.id.text_rev_chat)

    val translatedlinearlayout: LinearLayout? = mainView.findViewById(R.id.translated_layout)

    /**
     * Text translatedmessage of the chat
     */
    val receiverTextTranslated: EmojiAppCompatTextView? = mainView.findViewById(R.id.text_rev_chat_translated)

    /**
     * returns the time
     */
    /**
     * Time of the chat
     */
    val txtChatRevTime: AppCompatTextView = mainView.findViewById(R.id.text_rev_text_time)
    /**
     * returns the received star message
     */
    /**
     * Image starring the text received from the other user.
     */
    val imgReceivedStar: ImageView = mainView.findViewById(R.id.ic_star_received)
    /**
     * returns the recall image
     */
    /**
     * Image stating the received message recall.
     */
    val receivedRecallImage: ImageView = mainView.findViewById(R.id.image_received_recall)
    /**
     * returns the space
     */
    /**
     * Space to add when the previous message is different
     */
    val space: View = mainView.findViewById(R.id.space_view)
    /**
     * returns the Linearlayout
     */
    /**
     * To display receiver side message
     */
    val receiverTextView: LinearLayout? = mainView.findViewById(R.id.ll_chat_reciver_view)

    /**
     * to set the margin programtically
     */
    fun setMarginLeft(v: View, bottom: Int) {
        val params = v.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, bottom)
    }

}