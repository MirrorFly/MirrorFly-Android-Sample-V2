package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import com.contusfly.R
import com.contusfly.views.CustomTextView

/**
 * The Class contact view for displaying the sent contact in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class ContactSentViewHolder(val mainView: View) : BaseContactViewHolder(mainView) {

    var contactActionText: CustomTextView = mainView.findViewById(R.id.text_contact_action)

    var contactSeparator: View? = mainView.findViewById(R.id.view_contact_separator)

    /**
     * The image view for the sender status
     */
    val imgSenderStatus: ImageView = mainView.findViewById(R.id.image_audio_status)

    /**
     * forward Contact received
     */
    var imgForwardContact: ImageView? = mainView.findViewById(R.id.send_img_forward)

    val viewDiver: View? = mainView.findViewById(R.id.view_divider)

}