package com.contusfly.backup

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.contusfly.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt

object TimeAgo {


    /**
     * Get the System Current Data
     *
     * @return Date today
     */
    private fun currentDate(): Date {
        val calendar: Calendar = Calendar.getInstance()
        return calendar.time
    }

    /**
     *  Given the date as a Relative Human Readable String
     *
     * @param dateInLong Long date in milliseconds
     * @param ctx Context android Context
     * @return String relative time
     */
    fun getTimeAgo(dateInLong: Long, ctx: Context): String {
        val curDate = currentDate()
        val now = curDate.time
        val dim = getTimeDistanceInMinutes(dateInLong)
        Log.d("TimeAgo ", "$dateInLong $now $dim")
        var isMoreThanDay=false
        val timeAgo: String?
        timeAgo = when (dim) {
            0 -> {
                return ctx.resources.getString(R.string.date_util_just_now)
            }
            1 -> {
                "1 " + ctx.resources.getString(R.string.date_util_unit_minute)
            }
            in 2..59 -> {
                dim.toString() + " " + ctx.resources.getString(R.string.date_util_unit_minutes)
            }
            in 60..119 -> {
                val min = dim % 60
                "1 " + ctx.resources.getString(R.string.date_util_unit_hour) + " ${if (min == 1) " $min minute " else " $min minutes"} "
            }
            in 120..1439 -> {
                val min = dim % 60
                (dim / 60.toFloat()).roundToInt().toString() + " " + ctx.resources.getString(R.string.date_util_unit_hours) + " ${if (min == 1) " $min minute " else " $min minutes"} "
            }
            in 1440..2519 -> {
                isMoreThanDay=true
                "Yesterday | " + yesterDay(dateInLong)
            }
            else -> {
                isMoreThanDay=true
                lastBackupTimeInfo(dateInLong)
            }
        }
        return if(isMoreThanDay) timeAgo else timeAgo + " " + ctx.resources.getString(R.string.date_util_suffix)
    }

    /**
     * Returns the rounded difference between the current system time and given time in long
     *
     * @param time Long for which difference we need
     * @return Int difference between the time
     */
    private fun getTimeDistanceInMinutes(time: Long): Int {
        val timeDistance = currentDate().time - time
        return (abs(timeDistance) / 1000 / 60.toFloat()).roundToInt()
    }

    @SuppressLint("SimpleDateFormat")
     fun lastBackupTimeInfo(timestamp: Long): String {
        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        input.timeZone = TimeZone.getTimeZone("UTC")
        val output = SimpleDateFormat("dd MMM yyyy | hh.mm aa")
        output.timeZone = TimeZone.getDefault()
        val finalTime: String
        try {
            val date = Date(timestamp)
            finalTime = output.format(date)
            return finalTime
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return ""
    }

    private fun yesterDay(timestamp: Long): String{
        val yesterday = SimpleDateFormat("hh:mm a", Locale.US)
        yesterday.timeZone=TimeZone.getDefault()
        val date = Date(timestamp)
        return yesterday.format(date)

    }


}