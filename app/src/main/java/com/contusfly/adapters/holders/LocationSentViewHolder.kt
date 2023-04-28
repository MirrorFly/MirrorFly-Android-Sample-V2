package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import com.contusfly.R

/**
 * The Class LocationViewHolder to display the map view in chat
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class LocationSentViewHolder(val mainView: View) : SenderNameHolder(mainView) {

    /**
     * Sender Location view of the chat
     */
    val imageSendLocation: ImageView = mainView.findViewById(R.id.image_location_send)

    /**
     * Chat view
     */
    val viewSender: View = mainView.findViewById(R.id.view_chat_send_loc)

    /**
     * Time of the chat
     */
    val txtSendTime: AppCompatTextView = mainView.findViewById(R.id.text_send_loc_time)

    /**
     * Deliver status of the chat
     */
    val imgSenderStatus: ImageView = mainView.findViewById(R.id.image_loc_send_status)
    /**
     * Gets {@see #imgSentStarred}
     *
     * @return [.imgSentStarred]
     */
    /**
     * Receiver Location of the chat
     */
    val imgSentStarred: ImageView = mainView.findViewById(R.id.ic_star)

    /**
     * Over all view
     */
    val viewRowItem: RelativeLayout = mainView.findViewById(R.id.row_chat_location)

    /**
     * Space to add when the previous message is different
     */
    val space: View = mainView.findViewById(R.id.space_view)

    /**
     * forward Location received
     */
    val imgForwardLocation: ImageView? = mainView.findViewById(R.id.send_img_forward)

    val viewDiver: View? = mainView.findViewById(R.id.view_divider)

}