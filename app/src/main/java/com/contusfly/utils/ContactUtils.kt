package com.contusfly.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.provider.ContactsContract
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.activities.PickContactActivity
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.models.Contact
import com.mirrorflysdk.views.CustomToast
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
object ContactUtils {

    /**
     * SharedPreference key for contacts count
     */
    val CONTACTS_COUNT = "contacts_count"

    /**
     * This method returns the contacts count
     *
     * @param activity startupActivityContext
     * @return contacts count
     */
    fun getContactCount(activity: Context): Int {
        var cursor: Cursor? = null
        try {
            cursor = activity.contentResolver.query(
                    ContactsContract.Contacts.CONTENT_URI, null, null, null,
                    null)
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
    private fun getContactsFromCursor(pCur: Cursor, name: String): List<Contact>? {
        val contacts: MutableList<Contact> = ArrayList()
        try {
            while (pCur.moveToNext()) {
                val item = Contact()
                val number = pCur.getString(
                        pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                        .replace("-", Constants.EMPTY_STRING).replace("\\s".toRegex(), Constants.EMPTY_STRING)
                if (checkContact(contacts, number)) {
                    item.contactName = name
                    item.contactNos = number
                    item.selected = 1
                    contacts.add(item)
                }
            }
            pCur.close()
        } catch (e: java.lang.Exception) {
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
            if (contact.contactNos.contains(number)) return false
        }
        return true
    }

    /**
     * Handle onActivityResult callback Handle contact selection.
     *
     * @param context context of the activity
     * @param data    Intent
     */
    fun handleContactSelection(context: Context, data: Intent) {
        try {
            val cr = context.contentResolver
            val contactData = data.data
            val cursor = cr.query(contactData!!, null, null, null, null)
            var contacts: List<Contact> = ArrayList()
            if (cursor != null) {
                cursor.moveToFirst()
                val id = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                val hasPhone = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                if ("1".equals(hasPhone, ignoreCase = true)) {
                    val pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", arrayOf(id), null)
                    contacts = pCur?.let { getContactsFromCursor(it, name) } ?: contacts
                } else CustomToast.show(context, context.getString(R.string.error_no_mobile_nos))
                cursor.close()
            }
            if (contacts.isNotEmpty()) {
                val activity = context as Activity
                activity.startActivityForResult(Intent(context, PickContactActivity::class.java)
                        .putParcelableArrayListExtra(Constants.USERNAME, contacts as ArrayList<Contact>),
                        Constants.SELECT_CONTACT_REQ_CODE)
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    fun checkEmailContactForBlockAndUnblockUser(jid: String, status: Boolean) {
        if (ContusContactUtils.isContusContact(jid)) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(jid)
            if (profileDetails != null) {
                profileDetails.isBlocked = status
                ContusContactUtils.insertContusContact(profileDetails)
            }
        }
    }

    fun checkEmailContactForProfileUpdate(jid: String, profileDetails: ProfileDetails) {
        if (ContusContactUtils.isContusContact(jid)) {
            val profileDetail = ProfileDetailsUtils.getProfileDetails(jid)
            if (profileDetail != null) {
                if (profileDetails.name.isNotEmpty()) profileDetail.name = profileDetails.name
                profileDetail.nickName = profileDetails.nickName
                profileDetail.image = profileDetails.image
                profileDetail.email = profileDetails.email
                profileDetail.status = profileDetails.status
                profileDetail.mobileNUmberPrivacyFlag = profileDetails.mobileNUmberPrivacyFlag
                profileDetail.mobileNumber = profileDetails.mobileNumber
                profileDetail.lastSeenPrivacyFlag = profileDetails.lastSeenPrivacyFlag
                profileDetail.isBlocked = profileDetails.isBlocked
                profileDetail.isBlockedMe = profileDetails.isBlockedMe
                profileDetail.isAdminBlocked = profileDetails.isAdminBlocked
                ContusContactUtils.insertContusContact(profileDetail)
            }
        }
    }

}