package com.contusfly.adapters.holders

import android.view.View
import android.view.ViewStub
import android.widget.RelativeLayout
import android.widget.TextView
import com.mirrorflysdk.flycommons.exception.FlyException
import com.contusfly.R
import com.contusfly.getColourCode
import com.contusfly.getDisplayName
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.api.contacts.ProfileDetails

/**
 * Sender Name view holder contains the fields of the sender name view in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
open class SenderNameHolder(itemView: View) : DateViewHolder(itemView) {
    /**
     * Sender name view to show sender of the message for group chat
     */
    private var sendNameView: TextView? = null

    /**
     * View stub to avoid unwanted rendering of views. Its used to render view whenever it is
     * necessary
     */
    private val sendNameViewStub: ViewStub? = itemView.findViewById(R.id.view_sender_name)

    /**
     * Favourite list user name view
     */
    private val favouriteMessageNameView: RelativeLayout? = null

    /**
     * Favourite list sender name
     */
    private val favouriteSenderName: CustomTextView? = null

    /**
     * Favourite list receiver name
     */
    private val favouriteReceiverName: CustomTextView? = null

    /**
     * Separator view between favourite messages
     */
    private val viewFavouriteMessages: View? = null

    /**
     * Favourite message date
     */
    private val favouriteMessageData: CustomTextView? = null

    /**
     * Status For message deleted
     */
    var isRecallMessage = false

    /**
     * Status For message sent
     */
    var isSentMessage = false

    /**
     * Hides date view header if it is already rendered
     */
    fun hideSendNameView() {
        if (sendNameView != null) {
            sendNameView!!.visibility = View.GONE
        }
    }

    /**
     * Shows the date view and shows text based on item position
     *
     * @param sendJid jid of the message sender
     */
    fun showSenderNameView(sendJid: String) {
        try {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(sendJid)
            var name = Constants.EMPTY_STRING
            if (profileDetails != null) {
                name = profileDetails.getDisplayName()
            }
            showSenderName(name, profileDetails)
        } catch (e: FlyException) {
            e.printStackTrace()
        }
    }

    /**
     * Show favourite message name view
     */
    fun showFavouriteNameView() {
        if (favouriteMessageNameView != null) {
            favouriteMessageNameView.visibility = View.VISIBLE
            viewFavouriteMessages!!.visibility = View.VISIBLE
        }
    }

    /**
     * Set favourite message sender and receiver name
     *
     * @param senderName   Sender name
     * @param receiverName Receiver name
     * @param messageData  Message date
     */
    fun favouriteSenderReceiverName(senderName: String?, receiverName: String?, messageData: String?) {
        if (favouriteSenderName != null) favouriteSenderName.text = senderName
        if (favouriteReceiverName != null) favouriteReceiverName.text = receiverName
        if (favouriteMessageData != null) {
            favouriteMessageData.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            favouriteMessageData.text = messageData
        }
    }

    /**
     * Shows date view and sets text
     *
     * @param text Text to show
     */
    private fun showSenderName(text: String, profileDetails: ProfileDetails?) {
        if (sendNameView == null) renderSendNameView()
        if(profileDetails!=null) {
            sendNameView!!.setTextColor(profileDetails!!.name.getColourCode())
            sendNameView!!.visibility = View.VISIBLE
            sendNameView!!.text = text
        } else {
            sendNameView!!.visibility = View.GONE
        }
    }

    /**
     * Renders the view from ViewStub
     */
    private fun renderSendNameView() {
        if (sendNameViewStub != null) {
            val view = sendNameViewStub.inflate()
            sendNameView = view.findViewById(R.id.text_chat_sender)
        }
    }

}