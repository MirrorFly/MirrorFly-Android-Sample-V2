package com.contusfly.utils

import android.annotation.SuppressLint
import android.content.Context
import android.text.format.DateFormat
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ChatTimeOperations constructor(val calendar: Calendar) {

    /**
     * Recent chat DateFormat
     */
    private var recentChatDateFormat: SimpleDateFormat? = null

    /**
     * Recent chat DateFormat
     */
    private var callDateFormat: SimpleDateFormat? = null

    /**
     * Common DateFormat
     */
    private var commonDateFormat: SimpleDateFormat? = null

    /**
     * chatMsg instance
     */
    private val chatMsgTime: ChatMsgTime = ChatMsgTime(calendar)

    /**
     * date object
     */
    private val messageDate = Date()

    /**
     * Calculates the duration of call.
     *
     * @param startTime call start time
     * @param endTime   call end time
     * @return return the duration
     */
    @SuppressLint("DefaultLocale")
    fun getCallDurationTime(startTime: Long, endTime: Long): String {
        return if (startTime == 0L || endTime == 0L) {
            com.contusfly.utils.Constants.EMPTY_TIME
        } else {
            val millis = endTime - startTime
            getFormattedCallDurationTime(millis)
        }
    }

    /**
     * Returns message time in milli seconds removing time.
     *
     * @param timeStamp Timestamp
     * @return long Message date in milli without time
     */
    fun getDateInMilli(timeStamp: Long): Long {
        calendar.timeInMillis = timeStamp / 1000
        calendar[Calendar.HOUR_OF_DAY] = 0
        calendar[Calendar.MINUTE] = 0
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MILLISECOND] = 0
        return calendar.timeInMillis
    }

    /**
     * This function formats the the duration of call.
     *
     * @param timeInMilliseconds call duration in milliseconds
     * @return return the  formatted duration
     */
    @SuppressLint("DefaultLocale")
    fun getFormattedCallDurationTime(timeInMilliseconds: Long): String {
        return if (timeInMilliseconds < 1000) {
            com.contusfly.utils.Constants.EMPTY_TIME
        } else {
            /* if call duration greater than one hour change duration format */
            if (timeInMilliseconds >= 3600 * 1000) {
                String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(timeInMilliseconds),
                        TimeUnit.MILLISECONDS.toMinutes(timeInMilliseconds) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeInMilliseconds)),
                        TimeUnit.MILLISECONDS.toSeconds(timeInMilliseconds) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeInMilliseconds)))
            } else {
                String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(timeInMilliseconds) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeInMilliseconds)),
                        TimeUnit.MILLISECONDS.toSeconds(timeInMilliseconds) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeInMilliseconds)))
            }
        }
    }

    /**
     * Get the recent chat time in the recent chat view. It will display today time or YESTERDAY or
     * Date of the chat.
     *
     * @param context   Activity startupActivityContext
     * @param epochTime Timestamp of the chat
     * @return String Formatted date
     */
    fun getRecentChatTime(context: Context?, epochTime: Long): String {
        val cal = Calendar.getInstance()
        if (epochTime == 0L) return Constants.EMPTY_STRING
        val convertedTime = epochTime / 1000
        messageDate.time = convertedTime
        val hourTime = manipulateMessageTime(context!!, messageDate)
        val currentYear = cal[Calendar.YEAR]
        cal.time = messageDate
        val time: String = if (currentYear == cal[Calendar.YEAR]) {
            getRecentChatDateFormat()!!.format(messageDate.time)
        } else {
            getCommonDateFormat()!!.format(messageDate.time)
        }
        return if (equalsWithYesterday(messageDate, Constants.TODAY)) hourTime else if (equalsWithYesterday(messageDate, Constants.YESTERDAY)) Constants.YESTERDAY_UPPER else time
    }

    /**
     * Manipulates the message time related operations.
     *
     * @param context     the parent startupActivityContext.
     * @param messageDate the date of the message.
     */
    private fun manipulateMessageTime(context: Context, messageDate: Date): String {
        val format = if (DateFormat.is24HourFormat(context)) 24 else 12
        val cal = Calendar.getInstance()
        val hours = cal[Calendar.HOUR]
        cal.time = messageDate
        val dateHourFormat = chatMsgTime.setDateHourFormat(format, hours)
        return dateHourFormat.format(messageDate.time)
    }

    /**
     * Check the time is equal with today or yesterday in the chat view.
     *
     * @param srcDate Date of the chat
     * @param day     Today or yesterday
     * @return boolean True if equals with the day
     */
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    private fun equalsWithYesterday(srcDate: Date, day: String): Boolean {
        // Time part has
        // discarded
        if (day == Constants.YESTERDAY) calendar.add(Calendar.DATE, -1)
        /*
          Get yesterday's Date without time part
         */
        val yesterday: Date
        try {
            yesterday = getCommonDateFormat()!!.parse(getCommonDateFormat()!!.format(calendar.timeInMillis))
            val srcDateWithoutTime = getCommonDateFormat()!!.parse(getCommonDateFormat()?.format(srcDate))
            /*
              Checks src date equals yesterday.
             */return yesterday == srcDateWithoutTime
        } catch (e: ParseException) {
            LogMessage.e(e)
        }
        return false
    }

    /**
     * Set the call log date and time if the epoch time is current time its return today and time
     * in hour.
     *
     * @param context   startupActivityContext of the activity
     * @param epochTime call time in millisecond
     * @return return the date and time format
     */
    fun getCallTime(context: Context, epochTime: Long): String {
        messageDate.time = epochTime
        val hourTime: String = manipulateMessageTime(context, messageDate)
        /* The time stamp. */
        val date = getCallDateFormat()!!.format(messageDate.time)
        return if (equalsWithYesterday(messageDate, Constants.TODAY)) Constants.TODAY + ", " + hourTime
        else if (equalsWithYesterday(messageDate, Constants.YESTERDAY)) Constants.YESTERDAY + ", " + hourTime
        else "$date, $hourTime"
    }

    private fun getRecentChatDateFormat(): SimpleDateFormat? {
        if (recentChatDateFormat == null) {
            recentChatDateFormat = SimpleDateFormat("dd-MMM", Locale
                    .getDefault())
        }
        return recentChatDateFormat
    }

    private fun getCallDateFormat(): SimpleDateFormat? {
        if (callDateFormat == null) {
            callDateFormat = SimpleDateFormat(" dd MMM", Locale.getDefault())
        }
        return callDateFormat
    }

    private fun getCommonDateFormat(): SimpleDateFormat? {
        if (commonDateFormat == null) {
            commonDateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
        }
        return commonDateFormat
    }
}