package com.contusfly.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.TAG
import com.contusfly.diffCallBacks.ProfileDiffCallback
import com.contusfly.isValidIndex
import com.contusfly.utils.Constants.Companion.SDK_DATA
import com.contusfly.utils.ContactUtils
import com.contusfly.utils.ContusContactUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ContactViewModel @Inject constructor() : ViewModel() {

    // = = = = = = = = Contact Data = = = = = = = =
    val contactDetailsList = MutableLiveData<List<ProfileDetails>>()
    val contactListAdapter: ArrayList<ProfileDetails> by lazy { ArrayList() }
    val contactDiffResult = MutableLiveData<DiffUtil.DiffResult>()

    /**
     * contacts count from preference
     */
    var mContactCount: Int = 0

    /**
     * contact refreshing status
     */
    private var isRefreshing: Boolean = false

    val contactSyncNeeded = MutableLiveData<Boolean>()
    val isContactSyncSuccess = MutableLiveData<Boolean>()

    var selectedUsersJid = ArrayList<String>()

    fun getContactList(fromGroupInfo: Boolean, groupId: String?) {
        viewModelScope.launch {
            val contusContacts = ContusContactUtils.getContusContacts()
            if (fromGroupInfo && !groupId.isNullOrEmpty()) {
                getGroupContactList(contusContacts, groupId)
            } else {
                getContactList(contusContacts)
            }
        }
    }

    private fun getContactList(contusContacts: ArrayList<ProfileDetails>){
        FlyCore.getRegisteredUsers(false) { isSuccess, _, data ->
            if (isSuccess) {
                val profileDetails = data[SDK_DATA] as MutableList<ProfileDetails>
                profileDetails.forEach { contact ->
                    val index = contusContacts.indexOfFirst { it.jid == contact.jid }
                    if (index.isValidIndex())
                        contusContacts.removeAt(index)
                }
                profileDetails.addAll(contusContacts)
                selectedUsersJid.iterator().forEach { jid ->
                    val index = profileDetails.indexOfFirst { it.jid == jid }
                    if (index.isValidIndex())
                        profileDetails[index].isSelected = true
                    else
                        selectedUsersJid.remove(jid)
                }
                contactDetailsList.value = updateProfiles(profileDetails)
                getContactDiffResult()
            }
        }
    }

    private fun getGroupContactList(contusContacts: java.util.ArrayList<ProfileDetails>, groupId: String) {
        val profileDetailsList = GroupManager.getUsersListToAddMembersInOldGroup(groupId).toMutableList()
        LogMessage.e(TAG, "checkContactPermission isSuccess: size2:${profileDetailsList.size}")
        val groupMemberDetailsList = ArrayList<ProfileDetails>()
        GroupManager.getGroupMembersList(false, groupId) { isSuccess, _, data ->
            if (isSuccess) {
                val groupMemberList = data[SDK_DATA] as MutableList<ProfileDetails>
                groupMemberDetailsList.addAll(groupMemberList)
            }
            groupMemberDetailsList.forEach { contact ->
                val index = contusContacts.indexOfFirst { it.jid == contact.jid }
                if (index.isValidIndex())
                    contusContacts.removeAt(index)
            }
            profileDetailsList.forEach { contact ->
                val index = contusContacts.indexOfFirst { it.jid == contact.jid }
                if (index.isValidIndex()) {
                    if (contact.isItSavedContact())
                        contusContacts.removeAt(index)
                    else
                        profileDetailsList.remove(contact)
                }
            }
            profileDetailsList.addAll(contusContacts)
            LogMessage.d(FlyCore.TAG, "#profile getFriendsList size1:${profileDetailsList.size}")
            contactDetailsList.value = updateProfiles(profileDetailsList)
            getContactDiffResult()
        }
    }


    private fun updateProfiles(profileDetails: List<ProfileDetails>): List<ProfileDetails> {
        val filteredProfiles = mutableListOf<ProfileDetails>()
        val profiles = ProfileDetailsUtils.sortProfileList(profileDetails)
        profiles.forEach { profileDetail ->
            if (!profileDetail.isAdminBlocked) filteredProfiles.add(profileDetail)
        }
        return filteredProfiles
    }



    fun getUpdatedContactList(fromGroupInfo: Boolean, groupId: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (fromGroupInfo && !groupId.isNullOrEmpty()) {
                val profileDetails = GroupManager.getUsersListToAddMembersInOldGroup(groupId)
                viewModelScope.launch(Dispatchers.Main) {
                    contactDetailsList.value = ProfileDetailsUtils.removeAdminBlockedProfiles(profileDetails, true)
                    getContactDiffResult()
                }
            } else {
                FlyCore.getRegisteredUsers(true) { isSuccess, _, data ->
                    if (isSuccess) {
                        val profileDetails = data[SDK_DATA] as MutableList<ProfileDetails>
                        viewModelScope.launch(Dispatchers.Main) {
                            contactDetailsList.value = ProfileDetailsUtils.removeAdminBlockedProfiles(profileDetails, true)
                            getContactDiffResult()
                        }
                    }
                }
            }
        }
    }

    private fun getContactDiffResult() {
        viewModelScope.launch {
            val diffResult = getDiffUtilResult(ProfileDiffCallback(contactListAdapter, contactDetailsList.value!!))
            contactListAdapter.clear()
            contactListAdapter.addAll(contactDetailsList.value!!)
            contactDiffResult.value = diffResult
        }
    }

    private suspend fun getDiffUtilResult(diffUtilCallback: DiffUtil.Callback): DiffUtil.DiffResult = withContext(Dispatchers.IO) {
        DiffUtil.calculateDiff(diffUtilCallback)
    }

    fun checkContactsUpdate() {
        LogMessage.i(TAG, "[Contact Sync] checkContactsUpdate")
        viewModelScope.launch {
            mContactCount = SharedPreferenceManager.getInt(ContactUtils.CONTACTS_COUNT)
            val currentCount = ContactUtils.getContactCount(ChatManager.applicationContext)
            if (currentCount < mContactCount || currentCount > mContactCount) {
                updateContacts(currentCount)
            } else {
                LogMessage.i(TAG, "[Contact Sync] contact sync not needed")
            }
        }
    }

    /**
     * sync contact whenever its updated
     *
     * @param contactCount current contact count
     */
    private fun updateContacts(contactCount: Int) {
        if (!isRefreshing) {
            isRefreshing = true
            LogMessage.d(TAG, "[Contact Sync] Contact syncing due to phone book changes")
            contactSyncNeeded.value = true
            SharedPreferenceManager.setInt(ContactUtils.CONTACTS_COUNT, contactCount)
        } else {
            LogMessage.d(TAG, "[Contact Sync] Contact syncing is already in progress")
        }
    }

    fun onContactSyncFinished(success: Boolean) {
        LogMessage.d(TAG, "[Contact Sync] Contact sync success: $success")
        viewModelScope.launch {
            isRefreshing = false
            contactSyncNeeded.value = false
            val currentContactCount = ContactUtils.getContactCount(ChatManager.applicationContext)
            SharedPreferenceManager.setInt(ContactUtils.CONTACTS_COUNT, currentContactCount)
        }
    }

}