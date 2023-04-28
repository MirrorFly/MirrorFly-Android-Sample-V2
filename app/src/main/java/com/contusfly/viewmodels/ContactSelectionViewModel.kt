package com.contusfly.viewmodels

import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone.getTypeLabel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.contusfly.diffCallBacks.DeviceContactDiffCallback
import com.contusfly.models.DeviceContactModel
import com.contusfly.models.PhoneNumber
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactSelectionViewModel : ViewModel() {

    val contactsList = mutableListOf<DeviceContactModel>()
    val selectedContactList = mutableListOf<DeviceContactModel>()
    val selectedList = MutableLiveData<MutableList<DeviceContactModel>>()
    val contactDiffResult = MutableLiveData<DiffUtil.DiffResult>()
    private val deviceContactsList = linkedMapOf<String, DeviceContactModel>()
    val contactsListLoaded = MutableLiveData<Boolean>()
    val contactsSelectionReachedMaximum = MutableLiveData<Boolean>()

    private fun getAllDeviceContacts(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val projection = arrayOf(
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.TYPE,
                ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER
            )

            var cursor: Cursor? = null
            try {
                cursor = context.contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, null, null,    "UPPER(" + ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + ") ASC")
            } catch (e: SecurityException) {
                //SecurityException can be thrown if we don't have the right permissions
            }

            if (cursor != null) {
                try {
                    val normalizedNumbersAlreadyFound: HashSet<String> = HashSet()
                    val indexOfNormalizedNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER)
                    val indexOfDisplayName = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                    val indexOfDisplayNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                    val indexOfLabel = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE)
                    val indexOfContactId = cursor.getColumnIndex( ContactsContract.CommonDataKinds.Phone.CONTACT_ID)

                    while (cursor.moveToNext()) {
                        val normalizedNumber = cursor.getString(indexOfNormalizedNumber)
                        if (normalizedNumbersAlreadyFound.add(normalizedNumber)) {
                            val displayName = cursor.getString(indexOfDisplayName)
                            val displayNumber = cursor.getString(indexOfDisplayNumber)
                            val contactId = cursor.getString(indexOfContactId)
                            val label = getTypeLabel(context.resources, cursor.getInt(indexOfLabel), Constants.EMPTY_STRING)
                            checkAndAddContact(displayName, displayNumber, contactId, label)
                        }
                    }
                } finally {
                    contactsList.addAll(deviceContactsList.values)
                    contactsListLoaded.postValue(true)
                    cursor.close()
                }
            }
        }
    }

    private fun checkAndAddContact(displayName: String, displayNumber: String, contactId: String, label: CharSequence) {
        val deviceContactModel = if (deviceContactsList.containsKey(contactId)) deviceContactsList[contactId] else DeviceContactModel(contactId, displayName)
        deviceContactModel!!.mobileNumbers.add(PhoneNumber(displayNumber, label.toString(), true))
        deviceContactsList[contactId] = deviceContactModel
    }

    fun getLocalContactUserProfiles(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            getAllDeviceContacts(context)
            selectedList.postValue(mutableListOf())
        }
    }

    fun onContactItemClicked(item: DeviceContactModel) {
        if (selectedList.value!!.contains(item))
            selectedList.value!!.remove(item)
        else {
            if (selectedContactList.size >= Constants.MAX_CONTACT_SELECTION_COUNT) {
                contactsSelectionReachedMaximum.postValue(true)
                return
            }
            selectedList.value!!.add(item)
        }

        getContactDiffResult()
    }

    private fun getContactDiffResult() {
        viewModelScope.launch {
            val diffResult = getDiffUtilResult(DeviceContactDiffCallback(selectedContactList, selectedList.value!!))
            selectedContactList.clear()
            selectedContactList.addAll(selectedList.value!!)
            contactDiffResult.value = diffResult
        }
    }

    private suspend fun getDiffUtilResult(diffUtilCallback: DiffUtil.Callback): DiffUtil.DiffResult = withContext(Dispatchers.IO) {
        DiffUtil.calculateDiff(diffUtilCallback)
    }
}