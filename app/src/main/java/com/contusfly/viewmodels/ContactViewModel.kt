package com.contusfly.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.contusfly.diffCallBacks.ProfileDiffCallback
import com.contusfly.utils.Constants.Companion.SDK_DATA
import com.contusfly.utils.ProfileDetailsUtils
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

    fun getContactList(fromGroupInfo: Boolean, groupId: String?) {
        viewModelScope.launch {
            if (fromGroupInfo && !groupId.isNullOrEmpty()) {
                val profileDetails = GroupManager.getUsersListToAddMembersInOldGroup(groupId)
                contactDetailsList.value = ProfileDetailsUtils.removeAdminBlockedProfiles(profileDetails, true)
                getContactDiffResult()
            } else {
                FlyCore.getRegisteredUsers(false) { isSuccess, _, data ->
                    if (isSuccess) {
                        val profileDetails = data[SDK_DATA] as MutableList<ProfileDetails>
                        contactDetailsList.value = ProfileDetailsUtils.removeAdminBlockedProfiles(profileDetails, true)
                        getContactDiffResult()
                    }
                }
            }
        }
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

}