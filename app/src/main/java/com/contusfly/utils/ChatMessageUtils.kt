package com.contusfly.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.contusfly.R
import com.contusfly.adapters.holders.BaseReceivedViewHolder
import com.contusfly.adapters.holders.BaseSentViewHolder
import com.contusfly.chat.reply.ReplyMessageUtils
import com.contusfly.chat.reply.ReplyReceivedMessageUtils
import com.contusfly.gone
import com.contusfly.isGroupMessage
import com.contusfly.show
import com.mirrorflysdk.api.ChatManager.applicationContext
import com.mirrorflysdk.api.MessageStatus
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.helpers.ResourceHelper
import java.io.File
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
object ChatMessageUtils {

    /**
     * Sets the chat status of the user It might be Tick(Single,Double,Double Blue).
     *
     * @param imageView Instance of the image view
     * @param status    The status of the message
     */
    fun setChatStatus(imageView: ImageView, status: String?) {
        when (status) {
            Constants.MSG_ACK -> {
                imageView.setImageResource(R.drawable.ic_message_acknowledged)
                imageView.contentDescription = ResourceHelper.getString(R.string.acknowledge_content_description)
            }
            Constants.MSG_DELIVERED -> {
                imageView.setImageResource(R.drawable.ic_message_delivered)
                imageView.contentDescription = ResourceHelper.getString(R.string.delivered_content_description)
            }
            Constants.MSG_SEEN -> {
                imageView.setImageResource(R.drawable.ic_message_seen)
                imageView.contentDescription = ResourceHelper.getString(R.string.seen_content_description)
            }
            else -> {
                imageView.setImageResource(R.drawable.ic_message_unsent)
                imageView.contentDescription = ResourceHelper.getString(R.string.NotAcknowledge_content_description)
            }
        }
    }

    /**
     * Sets the chat status of the user It might be Tick(Single,Double,Double Blue).
     *
     * @param imageView Instance of the image view
     * @param status    The status of the message
     */
    fun setChatStatus(imageView: ImageView?, status: MessageStatus?) {
        if (imageView == null)
            return
        when (status) {
            MessageStatus.ACKNOWLEDGED -> {
                imageView.setImageResource(R.drawable.ic_message_acknowledged)
                imageView.contentDescription = ResourceHelper.getString(R.string.acknowledge_content_description)
            }
            MessageStatus.DELIVERED -> {
                imageView.setImageResource(R.drawable.ic_message_delivered)
                imageView.contentDescription = ResourceHelper.getString(R.string.delivered_content_description)
            }
            MessageStatus.SEEN -> {
                imageView.setImageResource(R.drawable.ic_message_seen)
                imageView.contentDescription = ResourceHelper.getString(R.string.seen_content_description)
            }
            else -> {
                imageView.setImageResource(R.drawable.ic_message_unsent)
                imageView.contentDescription = ResourceHelper.getString(R.string.NotAcknowledge_content_description)
            }
        }
    }

    fun setFavouriteStatus(imgFav: ImageView?, isFav: Boolean) {
        if (isFav) imgFav!!.show() else imgFav!!.gone()
    }

    fun isMediaExists(filePath: String): Boolean {
        val file = File(filePath)
        return file.exists()
    }

    /**
     * Show/hide the reply window for the sent image.
     *
     * @param imgViewHolder The view holding the child items.
     * @param messageItem   The data set used to render the content of child views.
     * @param context       The startupActivityContext
     */
    fun senderReplyWindow(imgViewHolder: BaseSentViewHolder, messageItem: ChatMessage,
                          context: Context?) {
        if (messageItem.isThisAReplyMessage()) {
            imgViewHolder.showSentReplyView()
            ReplyMessageUtils().showReplyMessage(context, imgViewHolder, messageItem.getReplyParentChatMessage(), messageItem.isGroupMessage())
        } else imgViewHolder.hideSentReplyView()
        if (messageItem.isMessageStarred()) imgViewHolder.imgSentStarred.visibility = View.VISIBLE else imgViewHolder.imgSentStarred.visibility = View.GONE
    }

    /**
     * Show/hide the reply window for the received image.
     *
     * @param imgViewHolder The view holding the child items.
     * @param messageItem   The data set used to render the content of child views.
     * @param context       The startupActivityContext
     */
    fun receiverReplyWindow(imgViewHolder: BaseReceivedViewHolder, messageItem: ChatMessage, context: Context?) {
        if (messageItem.isThisAReplyMessage()) {
            val replyMessage = messageItem.getReplyParentChatMessage()
            if (replyMessage != null) {
                imgViewHolder.replyMessageReceivedView?.show()
                ReplyReceivedMessageUtils().showReceivedReplyMessage(context, imgViewHolder, replyMessage, messageItem.isGroupMessage())
            } else imgViewHolder.replyMessageReceivedView?.gone()
        } else imgViewHolder.replyMessageReceivedView?.gone()
        if (messageItem.isMessageStarred()) imgViewHolder.imgStarred.visibility = View.VISIBLE else imgViewHolder.imgStarred.visibility = View.GONE
    }

    /**
     * To change the long emoji text to elllipse at end
     *
     * Listen to Globallayoutlistener of textview
     * textView?.viewTreeObserver?.addOnGlobalLayoutListener()
     */
    @JvmStatic
    fun fixEmojiAfterEllipses(textView: TextView?) {
        if (textView == null || textView.layout == null) return
        val characterToEllipsis = textView.layout.getEllipsisCount(0)
        if (characterToEllipsis > 0) textView.text = textView.text.toString().substring(0, textView.text.length - characterToEllipsis) + "..."
    }

    /**
     * Gets the formatted time.
     *
     * @param timeConsume Timestamp
     * @return String The formatted time
     */
    fun getFormattedTime(timeConsume: Int): String {
        return if (timeConsume < 60) {
                if (timeConsume < 10) "00:0$timeConsume" else "00:$timeConsume"
            } else {
                val sec = timeConsume % 60
                val min = timeConsume / 60
                if (min < 10 && sec < 10) "0$min:0$sec" else if (min < 10 && sec >= 10) "0$min:$sec" else if (min >= 10 && sec < 10) "$min:0$sec" else "$min:$sec"
            }
    }

    /**
     * Sets the formatted duration in the text view with the chat format
     *
     * @param totalDuration Total duration for formatter
     * @param textTimer     View to display
     */
    fun setFormattedTimeTextView(totalDuration: Int, textTimer: TextView) {
        val formatted: String = if (totalDuration < 60) {
            if (totalDuration < 10) "00:0$totalDuration" else "00:$totalDuration"
        } else {
            val sec = totalDuration % 60
            val min = totalDuration / 60
            if (min < 10 && sec < 10) "0$min:0$sec" else if (min < 10 && sec >= 10) "0$min:$sec" else if (min >= 10 && sec < 10) "$min:0$sec" else "$min:$sec"
        }
        textTimer.text = formatted
    }

    fun getFileSizeText(fileSizeInBytes: String): String {
        val fileSizeBuilder = StringBuilder()
        val fileSize = fileSizeInBytes.toLong().toDouble()
        when {
            fileSize > 1.073741824E9 -> {
                fileSizeBuilder.append(getRoundedFileSize(fileSize / 1.073741824E9)).append(" ").append(applicationContext.resources.getString(R.string.fly_file_size_convention_gb))
            }
            fileSize > 1048576.0 -> {
                fileSizeBuilder.append(getRoundedFileSize(fileSize / 1048576.0)).append(" ").append(applicationContext.resources.getString(R.string.fly_file_size_convention_mb))
            }
            fileSize > 1024.0 -> {
                fileSizeBuilder.append(getRoundedFileSize(fileSize / 1024.0)).append(" ").append(applicationContext.resources.getString(R.string.fly_file_size_convention_kb))
            }
            else -> {
                fileSizeBuilder.append(fileSizeInBytes).append(" ").append(applicationContext.resources.getString(R.string.fly_file_size_convention_b))
            }
        }
        return fileSizeBuilder.toString()
    }

    private fun getRoundedFileSize(unscaledValue: Double): Double {
        return BigDecimal.valueOf(unscaledValue).setScale(2, RoundingMode.HALF_UP).toDouble()
    }

    /**
     * Get the date from the timestamp with the dd/MM/yyyy format
     *
     * @param timeStamp Time stamp of the message
     * @return String Formatted date
     */
    fun getDateFromTimestamp(timeStamp: Long, pattern:String = "MMMM dd, yyyy"): String? {
        val now = Date(timeStamp / 1000)
        val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        return dateFormat.format(now.time)
    }
}