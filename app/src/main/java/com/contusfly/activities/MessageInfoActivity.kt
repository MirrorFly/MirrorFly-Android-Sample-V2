package com.contusfly.activities

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.widget.Toolbar
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.R
import com.contusfly.activities.parent.BaseMessageInfoActivity
import com.contusfly.databinding.ActivityMessageInfoBinding
import com.contusfly.utils.ChatMessageUtils
import com.contusfly.utils.ChatMsgTime
import com.contusfly.utils.UserInterfaceUtils
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.ChatMessageStatusDetail
import dagger.android.AndroidInjection
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * The class MessageInfoActivity show single chat message info. when the message delivered to user,
 * when the message read by user.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class MessageInfoActivity : BaseMessageInfoActivity() {

    private lateinit var messageInfoBinding: ActivityMessageInfoBinding

    /**
     * Display the chat Message time
     */
    private var mChatMsgTime: ChatMsgTime? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        messageInfoBinding = ActivityMessageInfoBinding.inflate(layoutInflater)
        setContentView(messageInfoBinding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        UserInterfaceUtils.setUpToolBar(this, toolbar, supportActionBar, getString(R.string.msg_info))
        mChatMsgTime = ChatMsgTime(Calendar.getInstance())
        setReceiptView(message!!)
    }

    /**
     * Set the time of the received and seen receipts in the view
     *
     * @param message Message item contains message data
     */
    private fun setReceiptView(message: ChatMessage) {
        var messageDate: String? = null
        val formatter = SimpleDateFormat("dd-MMM-yyy", Locale.getDefault())
        val formatter1 = SimpleDateFormat("MMM dd,yyyy", Locale.getDefault())
        val messageStatus = FlyMessenger.getMessageStatusOfASingleChatMessage(message.getMessageId())
        setMessageStatus(messageStatus, formatter, formatter1)
        try {
            messageDate = formatter.format(formatter1.parse(ChatMessageUtils.getDateFromTimestamp(message.getMessageSentTime())))
        } catch (e: ParseException) {
            LogMessage.e(e)
        }
        if (messageDate != null && !messageDate.contains("1970")) {
            messageInfoBinding.textDate.text = messageDate
        }
    }

    /**
     * Set the time of the received and seen receipts in the view
     *
     * @param messageStatus   Message delivered ans seen time
     * @param formatter       date format
     * @param formatter1      date format
     */
    private fun setMessageStatus(messageStatus: ChatMessageStatusDetail?, formatter: SimpleDateFormat, formatter1: SimpleDateFormat) {
        if (messageStatus != null) {
            val deliveredTime = messageStatus.deliveredTime
            val seenTime = messageStatus.seenTime
            try {
                if (!TextUtils.isEmpty(deliveredTime)) {
                    val chatDate = formatter.format(formatter1.parse(ChatMessageUtils.getDateFromTimestamp(deliveredTime.toLong())))
                    if (TextUtils.isDigitsOnly(deliveredTime)) {
                        val chat = chatDate + " " + "at " + mChatMsgTime!!.getDaySentMsg(this, deliveredTime.toLong())
                        messageInfoBinding.textDeliveredTime.text = chat
                    }
                } else {
                    messageInfoBinding.textDeliveredTime.setText(R.string.no_message)
                }
                handleReceiptView(seenTime, formatter, formatter1)
            } catch (e: ParseException) {
                LogMessage.e(e)
            }
        }
    }

    /**
     * Set the time of the received and seen receipts in the view
     *
     * @param seenTime   Message seentime
     * @param formatter  date format
     * @param formatter1 date format
     * @throws ParseException checked Exception
     */
    @Throws(ParseException::class)
    private fun handleReceiptView(seenTime: String, formatter: SimpleDateFormat, formatter1: SimpleDateFormat) {
        if (!TextUtils.isEmpty(seenTime)) {
            val chatDate = formatter.format(formatter1.parse(ChatMessageUtils.getDateFromTimestamp(seenTime.toLong())))
            if (seenTime.isNotEmpty() && TextUtils.isDigitsOnly(seenTime)) {
                val chatData: String = chatDate + " " + "at " + mChatMsgTime!!.getDaySentMsg(context, seenTime.toLong())
                messageInfoBinding.textReadTime.text = chatData
            }
        } else {
            messageInfoBinding.textReadTime.setText(R.string.no_message_read)
        }
    }

    /**
     * Message Status Updated
     *
     * @param messageId Message item contains message data
     */
    override fun onMessageStatusUpdated(messageId: String) {
        if (messageId.equals(message!!.getMessageId(), ignoreCase = true)) {
            message = FlyMessenger.getMessageOfId(messageId)
            ChatMessageUtils.setChatStatus(imgChatStatus, message!!.getMessageStatus())
            setReceiptView(message!!)
        }
    }

    override fun onUpdateUnStarAllMessages() {
        super.onUpdateUnStarAllMessages()
        if (!message!!.getMessageId().isNullOrEmpty()) {
            message = FlyMessenger.getMessageOfId(message!!.getMessageId())
            if ((message!!.messageType == MessageType.IMAGE || message!!.messageType == MessageType.VIDEO)
                && message!!.getMediaChatMessage().getMediaCaptionText() != null
                && message!!.getMediaChatMessage().getMediaCaptionText().isNotEmpty())
                ChatMessageUtils.setFavouriteStatus(captionStar, message!!.isMessageStarred())
            else ChatMessageUtils.setFavouriteStatus(imgFav, message!!.isMessageStarred())
        }
    }
}