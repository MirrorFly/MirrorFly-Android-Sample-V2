package com.contusfly.call.groupcall

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contusfly.call.calllog.CallLogRepository
import com.contusfly.getDisplayName
import com.contusfly.sortProfileList
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CallViewModel @Inject
constructor(private val callLogRepository: CallLogRepository) : ViewModel() {

    val profileUpdatedLiveData = MutableLiveData<String>()

    val inviteUserList = MutableLiveData<List<ProfileDetails>>()

    val callUserList = MutableLiveData<List<ProfileDetails>>()
    val addLoadUserLoader = MutableLiveData<Boolean>()
    val removeLoadUserLoader = MutableLiveData<Boolean>()

    private var isUserFetching = false
    private var currentPage = 0
    private var resultPerPage = 20
    private var totalUserPage = 1

    val searchCallUserList = MutableLiveData<List<ProfileDetails>>()
    val addUserSearchLoader = MutableLiveData<Boolean>()
    val removeUserSearchLoader = MutableLiveData<Boolean>()
    val fetchingError = MutableLiveData<Boolean>()
    private var isSearchUserFetching = false
    var resetSearchResult = MutableLiveData<Boolean>()
    private var currentSearchPage = 0
    private var totalUserSearchPage = 1

    private fun setUserListFetching(isFetching: Boolean) {
        this.isUserFetching = isFetching
    }

    fun getUserListFetching(): Boolean {
        return isUserFetching
    }

    private fun setSearchUserListFetching(isSearchFetching: Boolean) {
        this.isSearchUserFetching = isSearchFetching
    }

    fun getSearchUserListFetching(): Boolean {
        return isSearchUserFetching
    }

    fun addLoaderToTheList() {
        addLoadUserLoader.value = true
    }

    fun loadUserList(callConnectedUserList: ArrayList<String>?) {
        if (lastPageFetched())
            return
        updateLoaderStatus()
        fetchingError.value = false
        viewModelScope.launch(Dispatchers.IO) {
            currentPage += 1
            setUserListFetching(true)
            FlyCore.getUserList(currentPage, resultPerPage) { isSuccess, _, data ->
                if (isSuccess) {
                    val profileList = data[Constants.SDK_DATA] as MutableList<ProfileDetails>
                    totalUserPage = data[Constants.TOTAL_PAGES] as Int
                    var userListResult = ProfileDetailsUtils.removeAdminBlockedProfiles(profileList, false)
                    userListResult = getFilteredList(callConnectedUserList, userListResult.toMutableList())
                    viewModelScope.launch(Dispatchers.Main) {
                        removeLoadUserLoader.postValue(true)
                        callUserList.value = userListResult
                        updateLoaderStatus()
                    }
                } else {
                    currentPage -= 1
                    viewModelScope.launch(Dispatchers.Main) {
                        removeLoadUserLoader.postValue(true)
                        fetchingError.value = true
                    }
                }
                setUserListFetching(false)
            }
        }
    }

    private fun updateLoaderStatus() {
        if (lastPageFetched())
            removeLoadUserLoader.postValue(true)
        else
            addLoadUserLoader.postValue(true)
    }

    fun lastPageFetched() = currentPage >= totalUserPage

    fun searchUserList(searchString: String, callConnectedUserList: ArrayList<String>?) {
        if (searchLastPageFetched())
            return
        updateSearchLoaderStatus()
        fetchingError.value = false
        viewModelScope.launch(Dispatchers.IO) {
            currentSearchPage += 1
            setSearchUserListFetching(true)
            FlyCore.getUserList(currentSearchPage, resultPerPage, searchString) { isSuccess, _, data ->
                if (isSuccess) {
                    val profileList = data[Constants.SDK_DATA] as MutableList<ProfileDetails>
                    totalUserSearchPage = data[Constants.TOTAL_PAGES] as Int
                    var userListResult = ProfileDetailsUtils.removeAdminBlockedProfiles(profileList, false)
                    userListResult = getFilteredList(callConnectedUserList, userListResult.toMutableList())
                    viewModelScope.launch(Dispatchers.Main) {
                        removeUserSearchLoader.postValue(true)
                        resetSearchResult.value = currentSearchPage == 1
                        searchCallUserList.value = userListResult
                        updateSearchLoaderStatus()
                    }
                } else {
                    currentSearchPage -= 1
                    viewModelScope.launch(Dispatchers.Main) {
                        removeUserSearchLoader.postValue(true)
                        fetchingError.value = true
                    }
                }
                setSearchUserListFetching(false)
            }
        }
    }

    private fun updateSearchLoaderStatus() {
        if (searchLastPageFetched())
            removeUserSearchLoader.postValue(true)
        else
            addUserSearchLoader.postValue(true)
    }

    fun addSearchLoaderToTheList() {
        addUserSearchLoader.value = true
    }

    fun searchLastPageFetched() = currentSearchPage >= totalUserSearchPage

    fun resetSearch() {
        currentSearchPage = 0
        totalUserSearchPage = 1
        setSearchUserListFetching(false)
        removeUserSearchLoader.postValue(true)
    }


    fun getInviteUserList(callConnectedUserList: ArrayList<String>?) {
        viewModelScope.launch(Dispatchers.Main.immediate) {
            val userProfilesList = getProfileDetailsWithoutCallMembers(callConnectedUserList)
            inviteUserList.value = getUpdatedProfiles(userProfilesList)
        }
    }

    private fun getUpdatedProfiles(userProfilesList: List<ProfileDetails>): List<ProfileDetails>? {
        val filteredProfiles = mutableListOf<ProfileDetails>()
        userProfilesList.forEach { profileDetail ->
            if (!profileDetail.isAdminBlocked) filteredProfiles.add(profileDetail)
        }
        return filteredProfiles.sortedBy { it.getDisplayName().toLowerCase() }
    }

    fun getInviteUserListForGroup(groupId: String, callConnectedUserList: ArrayList<String>?) {
        viewModelScope.launch(Dispatchers.Main.immediate) {
            var profileDetails: List<ProfileDetails>? = null
            GroupManager.getGroupMembersList(false, groupId) { isSuccess, throwable, data ->
                if (isSuccess) profileDetails = data["data"] as ArrayList<ProfileDetails>
                val groupWithOutCallMembers: MutableList<ProfileDetails> =
                    profileDetails!!.toMutableList()
                inviteUserList.value = getUpdatedProfiles(getFilteredList(callConnectedUserList, groupWithOutCallMembers))
            }
        }
    }

    fun getProfileDetailsWithoutCallMembers(callConnectedUserList: ArrayList<String>?): List<ProfileDetails> {
        val profileDetails = FlyCore.getRegisteredUsers()
        val withOutCallMembers: MutableList<ProfileDetails> = profileDetails.toMutableList()
        return sortProfileList(getFilteredList(callConnectedUserList, getSingleProfiles(withOutCallMembers)))
    }

    private fun getFilteredList(
        callConnectedUserList: ArrayList<String>?,
        profileDetails: MutableList<ProfileDetails>
    ): List<ProfileDetails> {
        return profileDetails.filter {
            !callConnectedUserList!!.contains(it.jid) &&
                    it.jid != SharedPreferenceManager.getCurrentUserJid()
        }
    }

    private fun getSingleProfiles(profiles: MutableList<ProfileDetails>): MutableList<ProfileDetails> {
        val profileList: MutableList<ProfileDetails> = mutableListOf()
        for (profile in profiles) {
            if (!profile.isGroupProfile)
                profileList.add(profile)
        }
        return profileList
    }
}