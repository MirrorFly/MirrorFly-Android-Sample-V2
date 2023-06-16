/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.adapters.holders

import android.view.View
import android.view.ViewStub
import androidx.appcompat.widget.AppCompatTextView
import com.contusfly.R
import com.contusfly.utils.ChatViewUtils
import com.mirrorflysdk.api.models.ChatMessage
import java.text.DateFormatSymbols
import java.util.*

/**
 * Date view holder contains the fields of the Date view in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
open class DateViewHolder internal constructor(itemView: View) : ReplyMessageViewHolder(itemView) {
    /**
     * Date view between the chats
     */
    private var dateView: AppCompatTextView? = null

    /**
     * View stub to avoid unwanted rendering of views. Its used to render view whenever it is
     * necessary
     */
    private val dateViewStub: ViewStub? = itemView.findViewById(R.id.view_message_date)

    /**
     * Hides date view header if it is already rendered
     */
    fun hideDateView() {
        if (dateView != null) {
            dateView!!.visibility = View.GONE
        }
    }

    /**
     * Shows the date view and shows text based on item position
     *
     * @param item Position of the view
     */
    fun showDateView(item: ChatMessage) {
        val date: String
        val messageDate = ChatViewUtils()
                .getDateFromTimestamp(item.getMessageSentTime())
        val calendar = Calendar.getInstance()
        val monthNumber = calendar[Calendar.MONTH]
        val month = getMonthForInt(monthNumber)
        val yesterdaydate = calendar[Calendar.DATE] - 1
        val today = month + " " + checkTwoDigitsForDate(calendar[Calendar.DATE]) + "," + " " + +calendar[Calendar.YEAR]
        val yesterday = month + " " + checkTwoDigitsForDate(yesterdaydate) + "," + " " + +calendar[Calendar.YEAR]
        if (messageDate.compareTo(today) == 0) {
            date = "Today"
            showDateView(date)
        } else if (messageDate.compareTo(yesterday) == 0) {
            date = "Yesterday"
            showDateView(date)
        } else {
            if (!messageDate.contains("1970")) showDateView(messageDate)
        }
    }

    /**
     * Shows date view and sets text
     *
     * @param text Text to show
     */
    private fun showDateView(text: String) {
        if (dateView == null) renderDateView()
        dateView!!.visibility = View.VISIBLE
        dateView!!.text = text
    }

    /**
     * Renders the view from ViewStub
     */
    private fun renderDateView() {
        val view = dateViewStub?.inflate()
        dateView = view?.findViewById(R.id.text_chat_date)
    }

    private fun getMonthForInt(num: Int): String {
        var month = ""
        val dateFormatSymbols = DateFormatSymbols()
        val months = dateFormatSymbols.months
        if (num in 0..11) {
            month = months[num]
        }
        return month
    }

    private fun checkTwoDigitsForDate(date: Int): String {
        val formatDate: String
        return if (date.toString().length != 2) {
            formatDate = "0$date"
            formatDate
        } else {
            date.toString()
        }
    }

}