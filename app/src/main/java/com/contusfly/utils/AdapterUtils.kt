package com.contusfly.utils

import android.content.Context
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.contusfly.R
import com.contusfly.TAG
import com.mirrorflysdk.flycommons.LogMessage

object AdapterUtils {

    private fun indexOfDelimiter(originalMsg: String, delimiter: String): Int {
        var indexOfDelimiter = -1
        if (originalMsg.contains(delimiter)) {
            indexOfDelimiter = originalMsg.indexOf(delimiter, 1)
        }
        LogMessage.d(
            TAG,
            "Join Call via Link delimiter:$delimiter indexOfDelimiter: $indexOfDelimiter"
        )
        return indexOfDelimiter
    }

    private fun findIndexOfFirstOccurringDelimiter(
        indexOfFirstDelimiter: Int,
        indexOfNextDelimiter: Int
    ): Int {
        LogMessage.d(
            TAG,
            "Join Call via Link indexOfFirstDelimiter:$indexOfFirstDelimiter indexOfNextDelimiter: $indexOfNextDelimiter"
        )
        return when {
            indexOfFirstDelimiter == -1 && indexOfNextDelimiter == -1 -> {
                indexOfFirstDelimiter
            }

            indexOfFirstDelimiter == -1 && indexOfNextDelimiter != -1 -> {
                indexOfNextDelimiter
            }

            indexOfFirstDelimiter != -1 && indexOfNextDelimiter != -1 -> {
                minOf(indexOfFirstDelimiter, indexOfNextDelimiter)
            }

            else -> indexOfFirstDelimiter
        }
    }

    fun checkIndexOfNewMessageAfterLink(originalMsg: String): Int {

        val indexOfSpace: Int = indexOfDelimiter(originalMsg, " ")
        val indexOfNewLine: Int = indexOfDelimiter(originalMsg, "\n")
        val indexOfTab: Int = indexOfDelimiter(originalMsg, "\t")
        var indexOfNewMsgAfterLink: Int = -1

        indexOfNewMsgAfterLink =
            findIndexOfFirstOccurringDelimiter(indexOfNewMsgAfterLink, indexOfSpace)
        LogMessage.d(TAG, "Join Call via Link indexOfNewMsgAfterLink: $indexOfNewMsgAfterLink")
        indexOfNewMsgAfterLink =
            findIndexOfFirstOccurringDelimiter(indexOfNewMsgAfterLink, indexOfNewLine)
        LogMessage.d(TAG, "Join Call via Link indexOfNewMsgAfterLink: $indexOfNewMsgAfterLink")
        indexOfNewMsgAfterLink =
            findIndexOfFirstOccurringDelimiter(indexOfNewMsgAfterLink, indexOfTab)
        LogMessage.d(TAG, "Join Call via Link indexOfNewMsgAfterLink: $indexOfNewMsgAfterLink")
        return indexOfNewMsgAfterLink
    }


    /**
     * When we receive call link with space we separate the text based on first space.
     * separated text after first space we show in text black color .
     */
    fun setTextForCallLink(txtChat: TextView, indexOfNewMessageAfterLink: Int, context: Context) {
        val meetLinkText = txtChat.text

        LogMessage.d(
            TAG,
            "Join Call via Link length indexOfNewMessageAfterLink: $indexOfNewMessageAfterLink"
        )
        val builder = SpannableStringBuilder()
        val additionalText = meetLinkText.substring(indexOfNewMessageAfterLink, meetLinkText.length)
        LogMessage.d(TAG, "Join Call via Link length additionalText: $additionalText")

        val primaryMeetLinkText =
            SpannableString(meetLinkText.substring(0, indexOfNewMessageAfterLink))
        primaryMeetLinkText.setSpan(
            ForegroundColorSpan(
                ContextCompat.getColor(
                    context,
                    R.color.light_blue
                )
            ), 0, primaryMeetLinkText.length, 0
        )
        builder.append(primaryMeetLinkText)
        LogMessage.d(TAG, "Join Call via Link length primaryMeetLinkText: $primaryMeetLinkText")
        val additionalTextInMeetLink =
            SpannableString(meetLinkText.substring(indexOfNewMessageAfterLink))
        additionalTextInMeetLink.setSpan(
            ForegroundColorSpan(
                ContextCompat.getColor(
                    context,
                    R.color.text_color_black
                )
            ), 0, additionalTextInMeetLink.length, 0
        )
        builder.append(additionalTextInMeetLink)
        LogMessage.d(
            TAG,
            "Join Call via Link length additionalTextInMeetLink: $additionalTextInMeetLink"
        )
        txtChat.text = builder.toString()
        txtChat.setLinkTextColor(ContextCompat.getColor(context, R.color.light_blue))
    }
}