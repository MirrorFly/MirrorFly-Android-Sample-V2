package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.contusfly.R

/**
 * The Class Image View Holder for display the image view in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class VideoSentViewHolder(private val mainView: View) : BaseSentViewHolder(mainView) {

    /**
     * Play button in the chat
     */
    val imgSendPlay: ImageView = mainView.findViewById(R.id.image_send_play)

    /**
     * Chat type of the view
     */
    val imgSendChatType: ImageView = mainView.findViewById(R.id.image_sent_chat_type)

    /**
     * Sender Text view for duration
     */
    val txtSendDuration: AppCompatTextView = mainView.findViewById(R.id.text_video_send_duration)

    /**
     * Sender Chat view divider line
     */
    val viewDiver: View? = mainView.findViewById(R.id.view_divider)

}