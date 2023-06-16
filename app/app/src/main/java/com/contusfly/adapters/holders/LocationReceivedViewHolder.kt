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
class LocationReceivedViewHolder(val mainView: View) : SenderNameHolder(mainView) {

    /**
     * Receiver Location of the chat
     */
    val imageReceiveLocation: ImageView = mainView.findViewById(R.id.image_loc_rev)
    /**
     * Gets {@see #imgStarredReceived}
     *
     * @return [.imgStarredReceived]
     */
    /**
     * Deliver status of the chat
     */
    val imgStarredReceived: ImageView = mainView.findViewById(R.id.ic_star_rv)

    /**
     * Chat view
     */
    val viewReceiver: View = mainView.findViewById(R.id.view_chat_rev_loc)

    /**
     * Over all view
     */
    val viewRowItem: RelativeLayout = mainView.findViewById(R.id.row_chat_location)

    /**
     * Time of the chat
     */
    val txtRevTime: AppCompatTextView = mainView.findViewById(R.id.text_loc_rev_time)

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