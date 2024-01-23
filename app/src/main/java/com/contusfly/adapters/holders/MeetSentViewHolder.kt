/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
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
class MeetSentViewHolder(mainView: View) : SenderNameHolder(mainView) {

    /**
     * Sender Chat view
     */
    val viewSender: View = mainView.findViewById(R.id.view_chat_sender_txt)

    /**
     * Sender Chat view divider line
     */
    val viewDiver: View? = mainView.findViewById(R.id.view_divider)

    /**
     * Name of the chat
     */
    val txtChatSender: TextView = mainView.findViewById(R.id.text_send_chat)

    val txtEdited:AppCompatTextView = mainView.findViewById(R.id.edit_txt_id)


    val meetLinkTextLayout: LinearLayout = mainView.findViewById(R.id.meet_link_txt_view_ll)

    /**
     * Time of the chat
     */
    val txtChatTime: AppCompatTextView = mainView.findViewById(R.id.text_message_sent_time)

    /**
     * Over all chat view
     */
    val viewRowItem: RelativeLayout = mainView.findViewById(R.id.row_chat_meet)

    /**
     * Deliver status of the chat
     */
    val imgChatStatus: ImageView = mainView.findViewById(R.id.image_message_status)

    /**
     * Image starred
     */
    private val imgStar: ImageView = mainView.findViewById(R.id.ic_star)

    /**
     * Image stating the sent message recall.
     */
    val sentRecallImage: ImageView = mainView.findViewById(R.id.image_sent_recall)

    /**
     * schedule meet view and logo
     */
    val scheduleMeetLinkView: LinearLayout = mainView.findViewById(R.id.schedule_meet_link_view)

    val scheduleMeetLinkLogo: ImageView = mainView.findViewById(R.id.schedule_meet_link_logo)

    val scheduleDateAndTime: AppCompatTextView = mainView.findViewById(R.id.scheduled_date_time_txt_view)

    val imgForwardMeet: ImageView? = mainView.findViewById(R.id.send_img_forward)

    /**
     * Space to add when the previous message is different
     */
    val space: View = mainView.findViewById(R.id.space_view)
    val imageStar: View
        get() = imgStar

}