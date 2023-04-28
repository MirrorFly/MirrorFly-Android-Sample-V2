package com.contusfly.utils

import android.content.Context
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.contusfly.R
import com.contusfly.bindView
import com.contusfly.gone
import com.contusfly.show
import java.text.SimpleDateFormat
import java.util.*

/**
 * This Class is used for time related operation in Chat.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ChatViewUtils {

    /**
     * Get the date from the timestamp with the dd/MM/yyyy format
     *
     * @param timeStamp Time stamp of the message
     * @return String Formatted date
     */
    fun getDateFromTimestamp(timeStamp: Long): String {
        val now = Date(timeStamp / 1000)
        val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
        return dateFormat.format(now.time)
    }

    /**
     * Displays the presence status of the chat user in the [android.app.ActionBar]
     * of the current activity. Shows online if the user presence is available,
     * otherwise displays the user's last seen time.
     *
     * @param activity The startupActivityContext of the current activity.
     * @param status   The status of the chat user to be displayed.
     */
    fun setUserPresenceStatus(activity: AppCompatActivity, status: String?) {
        val textStatus by activity.bindView<TextView>(R.id.text_last_seen)
        with(textStatus) {
            if (status!!.isNotEmpty()) {
                text = status
                show()
            } else
                gone()
            isSelected = true
        }
    }

    /**
     * Redirect to show selected images preview
     *
     * @param toUser  Selected user
     * @param context Instance of the activity
     * @param intent  Intent data
     */
    fun showSelectedImages(toUser: String?, context: Context, intent: Intent?) {
        /* No Implementation Needed */
    }
}
