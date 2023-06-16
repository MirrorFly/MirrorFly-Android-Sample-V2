package com.contusfly.utils

import android.content.Context
import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ChatMsgTime constructor(val calendar: Calendar) {

    /**
     * hh:mm aa DateFormat
     */
    private var hhmmaaDateFormat: SimpleDateFormat = SimpleDateFormat("hh:mm aa", Locale.getDefault())

    /**
     * h:mm aa DateFormat
     */
    private var hmmaaDateFormat: SimpleDateFormat = SimpleDateFormat("h:mm aa", Locale.getDefault())

    /**
     * hh:mm DateFormat
     */
    private var hhmmDateFormat: SimpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    /**
     * h:mm DateFormat
     */
    private var hmmDateFormat: SimpleDateFormat = SimpleDateFormat("H:mm", Locale.getDefault())

    /**
     * Gets the day sent msg. The epoche time getting timestamp using date object getting the
     * current time using date format get the time format 12 or 24 getting the date format and
     * dateHourFormat using simpleDate format getting today time using calendar instance
     *
     * @param context    Instance of the startupActivityContext
     * @param epocheTime Timestamp of the Message
     * @return String Formatted date
     */
    fun getDaySentMsg(context: Context?, epocheTime: Long): String? {
        val dateHourFormat: SimpleDateFormat
        val timeLong = epocheTime / 1000
        val now = Date(timeLong)
        calendar.time = now
        val hours = calendar[Calendar.HOUR_OF_DAY]
        val format = if (DateFormat.is24HourFormat(context)) 24 else 12
        dateHourFormat = setDateHourFormat(format, hours)
        return dateHourFormat.format(timeLong)
    }

    /**
     * Set the date and time format
     *
     * @param format Hour format value
     * @param hours  Hour of the day
     * @return SimpleDateFormat Formatted date
     */
    fun setDateHourFormat(format: Int, hours: Int): SimpleDateFormat {
        val dateHourFormat: SimpleDateFormat = if (format == 12) {
            if (hours < 10) getHhmmaaDateFormat() else getHmmaaDateFormat()
        } else {
            if (hours < 10) getHhmmDateFormat() else getHmmDateFormat()
        }
        return dateHourFormat
    }

    private fun getHhmmaaDateFormat(): SimpleDateFormat {
        return hhmmaaDateFormat
    }

    private fun getHmmaaDateFormat(): SimpleDateFormat {
        return hmmaaDateFormat
    }

    private fun getHhmmDateFormat(): SimpleDateFormat {
        return hhmmDateFormat
    }

    private fun getHmmDateFormat(): SimpleDateFormat {
        return hmmDateFormat
    }
}