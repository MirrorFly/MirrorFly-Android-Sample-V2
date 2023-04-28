package com.contusfly.chat

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.provider.ContactsContract
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.utils.Constants
import com.mirrorflysdk.models.Contact
import java.util.ArrayList


/**
 * Handles the contact selection from the chat and return back to the chat view and send it to
 * the receiver.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
object ContactUtils {
    /**
     * SharedPreference key for contacts count
     */
    const val CONTACTS_COUNT = "contacts_count"

    /**
     * This method returns the contacts count
     *
     * @param activity startupActivityContext
     * @return contacts count
     */
    fun getContactCount(activity: Context): Int {
        var cursor: Cursor? = null
        try {
            cursor = activity.contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                    null, null, null, null)
            return cursor?.count ?: 0
        } catch (e: Exception) {
            LogMessage.e(e)
        } finally {
            cursor?.close()
        }
        return 0
    }

    /**
     * Get the contact list from the cursor
     *
     * @param pCur Cursor from the contact
     * @param name Name of the contact
     * @return List<Contact> List of contacts
    </Contact> */
    private fun getContactsFromCursor(pCur: Cursor, name: String): List<Contact> {
        val contacts: MutableList<Contact> = ArrayList()
        try {
            while (pCur.moveToNext()) {
                val item = Contact()
                val number = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                        .replace("-", Constants.EMPTY_STRING).replace("\\s".toRegex(), Constants.EMPTY_STRING)
                if (checkContact(contacts, number)) {
                    item.contactName = name
                    item.contactNos = number
                    item.selected = 1
                    contacts.add(item)
                }
            }
            pCur.close()
        } catch (e: Exception) {
            LogMessage.e(e)
        }
        return contacts
    }

    /**
     * Check the contact is available or not contact.
     *
     * @param contacts List of contacts
     * @param number   The number
     * @return boolean True if successful
     */
    private fun checkContact(contacts: List<Contact>, number: String): Boolean {
        for (contact in contacts) {
            if (contact.contactNos.contains(number))
                return false
        }
        return true
    }

}