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
class VideoReceivedViewHolder(private val mainView: View) : BaseReceivedViewHolder(mainView) {

    /**
     * Play button in the view
     */
    val imgRevPlay: ImageView = mainView.findViewById(R.id.image_receive_play)

    /**
     * Chat type of the view
     */
    val imgRevChatType: ImageView = mainView.findViewById(R.id.image_receive_chat_type)

    /**
     * Receiver Text view for duration
     */
    val txtRevDuration: AppCompatTextView = mainView.findViewById(R.id.text_video_receive_duration)

    val viewDiver: View? = mainView.findViewById(R.id.view_divider)

}