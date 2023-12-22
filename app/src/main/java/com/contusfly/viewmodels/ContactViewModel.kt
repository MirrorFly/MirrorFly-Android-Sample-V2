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
import java.util.concurrent.atomic.AtomicBoolean
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

    var isGetContactListInProgress = AtomicBoolean(false)

    fun getContactList(fromGroupInfo: Boolean, groupId: String?) {
        viewModelScope.launch {
            LogMessage.i(TAG, "#NewContacts getContactList fromGroupInfo:$fromGroupInfo groupId:$groupId")
            if(isGetContactListInProgress.compareAndSet(false,true)){
                val contusContacts = ContusContactUtils.getContusContacts()
                if (fromGroupInfo && !groupId.isNullOrEmpty()) {
                    getGroupContactList(contusContacts, groupId)
                } else {
                    getContactList(contusContacts)
                }
            }else{
                LogMessage.i(TAG, "#NewContacts getContactList already in progress")
            }
        }
    }

    @Synchronized
    private fun  getContactList(contusContacts: ArrayList<ProfileDetails>){
        LogMessage.i(TAG, "#NewContacts getContactList Contacts: ${contusContacts.size}")
        FlyCore.getRegisteredUsers(false) { isSuccess, _, data ->
            if (isSuccess) {

                val profileDetails = data[SDK_DATA] as MutableList<ProfileDetails>
                LogMessage.i(TAG, "#NewContacts getContactList getRegisteredUsers profileDetails: ${profileDetails.size}")
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
                LogMessage.d(TAG, "#NewContacts getContactList  profileDetails size to be set${profileDetails.size}")
                contactDetailsList.value = updateProfiles(profileDetails)
                getContactDiffResult()
            }
        }
    }

    private fun getGroupContactList(contusContacts: java.util.ArrayList<ProfileDetails>, groupId: String) {
        val profileDetailsList = GroupManager.getUsersListToAddMembersInOldGroup(groupId).toMutableList()
        LogMessage.d(TAG, "#NewContacts getGroupContactList InitialSize:${profileDetailsList.size}")
        val groupMemberDetailsList = ArrayList<ProfileDetails>()
        GroupManager.getGroupMembersList(false, groupId) { isSuccess, _, data ->
            if (isSuccess) {
                LogMessage.d(TAG, "#NewContacts getGroupContactList getGroupMembersList isSuccess")
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
                    if (contact.isItSavedContact)
                        contusContacts.removeAt(index)
                    else
                        profileDetailsList.remove(contact)
                }
            }
            profileDetailsList.addAll(contusContacts)
            LogMessage.d(FlyCore.TAG, "#NewContactsget #profile GroupContactList: profileDetailsList:${profileDetailsList.size}")
            contactDetailsList.value = updateProfiles(profileDetailsList)
            getContactDiffResult()
        }
    }


    private fun updateProfiles(profileDetails: List<ProfileDetails>): List<ProfileDetails> {
        LogMessage.i(TAG, "#NewContacts updateProfiles profileDetails: ${profileDetails.size}")
        val filteredProfiles = mutableListOf<ProfileDetails>()
        val profiles = ProfileDetailsUtils.sortProfileList(profileDetails)
        profiles.forEach { profileDetail ->
            if (!profileDetail.isAdminBlocked) filteredProfiles.add(profileDetail)
        }
        LogMessage.d(FlyCore.TAG, "#NewContacts updateProfiles: filteredProfiles: ${filteredProfiles.size}")
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

    fun getContactDiffResult() {
        viewModelScope.launch {
            LogMessage.i(TAG, "#NewContacts getContactList getContactDiffResult : ")
            val diffResult = getDiffUtilResult(ProfileDiffCallback(contactListAdapter, contactDetailsList.value!!))
            contactListAdapter.clear()
            contactListAdapter.addAll(contactDetailsList.value!!)
            contactDiffResult.value = diffResult
            isGetContactListInProgress.set(false)
            LogMessage.i(TAG, "#NewContacts getContactList getContactDiffResult isGetContactListInProgress: ${isGetContactListInProgress.get()}")
        }
    }

    private suspend fun getDiffUtilResult(diffUtilCallback: DiffUtil.Callback): DiffUtil.DiffResult = withContext(Dispatchers.IO) {
        DiffUtil.calculateDiff(diffUtilCallback)
    }

    fun checkContactsUpdate() {
        LogMessage.i(TAG, "#contact sync checkContactsUpdate")
        viewModelScope.launch {
            mContactCount = SharedPreferenceManager.getInt(ContactUtils.CONTACTS_COUNT)
            val currentCount = ContactUtils.getContactCount(ChatManager.applicationContext)
            if (currentCount < mContactCount || currentCount > mContactCount) {
                updateContacts(currentCount)
            } else {
                LogMessage.i(TAG, "#contact sync contact sync not needed")
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
            LogMessage.d(TAG, "#contact sync Contact syncing due to phone book changes")
            contactSyncNeeded.value = true
            SharedPreferenceManager.setInt(ContactUtils.CONTACTS_COUNT, contactCount)
        } else {
            LogMessage.d(TAG, "#contact sync Contact syncing is already in progress")
        }
    }

    fun onContactSyncFinished(success: Boolean) {
        LogMessage.d(TAG, "#contact sync Contact sync success: $success")
        viewModelScope.launch {
            isRefreshing = false
            contactSyncNeeded.value = false
            val currentContactCount = ContactUtils.getContactCount(ChatManager.applicationContext)
            SharedPreferenceManager.setInt(ContactUtils.CONTACTS_COUNT, currentContactCount)
        }
    }

}