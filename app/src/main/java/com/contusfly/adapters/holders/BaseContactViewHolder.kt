package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.contusfly.R
import com.contusfly.views.CircularImageView
import com.contusfly.views.CustomTextView

open class BaseContactViewHolder(view: View) : SenderNameHolder(view) {
    /**
     * The view sender.
     */
    val viewSender: View? = null

    /**
     * The view receiver
     */
    val viewReceiver: View? = null

    /**
     * The view row item
     */
    val viewRowItem: RelativeLayout = view.findViewById(R.id.row_chat_contact)

    /**
     * The text view for sender time
     */
    val txtSendTime: AppCompatTextView = view.findViewById(R.id.text_audio_time)

    /**
     * The text view for receiver time
     */
    val txtRevTime: CustomTextView? = null

    /**
     * The text view sender name
     */
    val txtSendName: CustomTextView = view.findViewById(R.id.text_contact_name)

    /**
     * The text receiver contact
     */
    val txtRevContact: TextView? = null

    /**
     * The text view for the receiver image
     */
    val txtRevImg: TextView? = null

    /**
     * The text view for the sender image
     */
    val txtSendImg: CircularImageView = view.findViewById(R.id.image_contact_picture)

    /**
     * Space to add when the previous message is different
     */
    val space: View = view.findViewById(R.id.space_view)

    /**
     * Image starring the contact sent from the current user.
     */
    val starredSentImage: ImageView = view.findViewById(R.id.image_audio_favorite)

    /**
     * Image starring the contact received from the other user.
     */
    val starredReceivedImage: ImageView? = null

}