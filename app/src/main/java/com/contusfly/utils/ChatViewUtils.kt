package com.contusfly.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.contusfly.AppLifecycleListener
import com.contusfly.R
import com.contusfly.bindView
import com.contusfly.gone
import com.contusfly.show
import com.mirrorflysdk.api.ChatManager
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

    /**
     * Starts an intent to add the contact number in the contacts app.
     *
     * @param activity      The calling activity.
     * @param contactNumber The contact number to be added.
     */
    fun addContact(activity: Activity, contactNumber: String?) {
        val intent = Intent(Intent.ACTION_INSERT)
        with(intent) {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.PHONE, contactNumber)
            activity.startActivityForResult(this, INSERT_CONTACT)
        }
        /* setting isActivityStartedForResult to true to avoid xmpp disconnection */
        ChatManager.isActivityStartedForResult = true
        AppLifecycleListener.deviceContactCount = 0
    }

    /**
     * Determine whether user have granted the permission to read and write the contacts.
     *
     * @param context The parent startupActivityContext.
     * @return True if app has the permission or false if not.
     */
    fun isContactPermissionAvailable(context: Context?): Boolean {
        return (MediaPermissions.isPermissionAllowed(context, Manifest.permission.READ_CONTACTS)
                && MediaPermissions.isWriteContactPermissionAllowed(context))
    }

    companion object {

        /**
         * The request code for adding the unknown participant into the contacts app.
         */
        const val INSERT_CONTACT = 1001
    }
}
