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
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.emoji.widget.EmojiAppCompatTextView
import com.contusfly.R

/**
 * View holder class for the Chat message view to prepare the recycler view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class MeetReceivedViewHolder(mainView: View) : SenderNameHolder(mainView) {
    /**
     * returns the receiver view
     */
    /**
     * Receiver Chat view
     */
    val viewReceiver: View = mainView.findViewById(R.id.view_chat_rev_meet)

    /**
     * Sender Chat view divider line
     */
    val viewDiver: View? = mainView.findViewById(R.id.view_divider)


    val imgForwardMeet: ImageView? = mainView.findViewById(R.id.send_img_forward)

    /**
     * schedule meet view and logo
     */
    val scheduleMeetLinkView: LinearLayout = mainView.findViewById(R.id.schedule_meet_link_view)

    val scheduleMeetLinkLogo: ImageView = mainView.findViewById(R.id.schedule_meet_link_logo)

    val scheduleDateAndTime: AppCompatTextView = mainView.findViewById(R.id.scheduled_date_time_txt_view)

    /**
     * returns the receiver view row item
     */
    /**
     * Over all chat view
     */
    val viewRowItem: RelativeLayout = mainView.findViewById(R.id.row_chat_meet)
    /**
     * returns the chat textview
     */
    /**
     * Text message of the chat
     */
    val txtChatReceiver: TextView = mainView.findViewById(R.id.text_rev_chat)

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

    val txtEdited:AppCompatTextView = mainView.findViewById(R.id.edit_txt_id)


    val meetLinkTextLayout: LinearLayout = mainView.findViewById(R.id.meet_link_txt_view_ll)

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
    val receiverTextView: LinearLayout? = mainView.findViewById(R.id.ll_chat_receiver_view)

    /**
     * to set the margin programtically
     */
    fun setMarginLeft(v: View, bottom: Int) {
        val params = v.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, bottom)
    }

}