package com.contusfly.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserListViewModel @Inject constructor() : ViewModel() {

    val userList = MutableLiveData<List<ProfileDetails>>()
    val addLoader = MutableLiveData<Boolean>()
    val removeLoader = MutableLiveData<Boolean>()

    private var isFetching = false
    private var currentPage = 0
    private var resultPerPage = 20
    private var totalPage = 1

    val searchUserList = MutableLiveData<List<ProfileDetails>>()
    val addSearchLoader = MutableLiveData<Boolean>()
    val removeSearchLoader = MutableLiveData<Boolean>()
    val fetchingError = MutableLiveData<Boolean>()
    private var isSearchFetching = false
    var resetSearchResult = MutableLiveData<Boolean>()
    private var currentSearchPage = 0
    private var totalSearchPage = 1

    private fun setUserListFetching(isFetching: Boolean) {
        this.isFetching = isFetching
    }

    fun getUserListFetching(): Boolean {
        return isFetching
    }

    private fun setSearchUserListFetching(isSearchFetching: Boolean) {
        this.isSearchFetching = isSearchFetching
    }

    fun getSearchUserListFetching(): Boolean {
        return isSearchFetching
    }

    fun loadUserList(fromGroupInfo: Boolean, groupId: String?) {
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
                    totalPage = data[Constants.TOTAL_PAGES] as Int
                    var userListResult = ProfileDetailsUtils.removeAdminBlockedProfiles(profileList, false)
                    if (fromGroupInfo && !groupId.isNullOrEmpty()) {
                        userListResult = userListResult.filter { ChatManager.getAvailableFeatures().isGroupChatEnabled && !GroupManager.isMemberOfGroup(groupId, it.jid) }
                    }
                    viewModelScope.launch(Dispatchers.Main) {
                        removeLoader.postValue(true)
                        userList.value = userListResult
                        updateLoaderStatus()
                    }
                } else {
                    currentPage -= 1
                    viewModelScope.launch(Dispatchers.Main) {
                        removeLoader.postValue(true)
                        fetchingError.value = true
                    }
                }
                setUserListFetching(false)
            }
        }
    }

    private fun updateLoaderStatus() {
        if (lastPageFetched())
            removeLoader.postValue(true)
        else
            addLoader.postValue(true)
    }

    fun addLoaderToTheList() {
        addLoader.postValue(true)
    }

    fun lastPageFetched() = currentPage >= totalPage

    fun searchUserList(searchString: String, fromGroupInfo: Boolean, groupId: String?) {
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
                    totalSearchPage = data[Constants.TOTAL_PAGES] as Int
                    var userListResult = ProfileDetailsUtils.removeAdminBlockedProfiles(profileList, false)
                    if (fromGroupInfo && !groupId.isNullOrEmpty()) {
                        userListResult = userListResult.filter { ChatManager.getAvailableFeatures().isGroupChatEnabled && !GroupManager.isMemberOfGroup(groupId, it.jid) }
                    }
                    viewModelScope.launch(Dispatchers.Main) {
                        removeSearchLoader.postValue(true)
                        resetSearchResult.value = currentSearchPage == 1
                        searchUserList.value = userListResult
                        updateSearchLoaderStatus()
                    }
                } else {
                    currentSearchPage -= 1
                    viewModelScope.launch(Dispatchers.Main) {
                        removeSearchLoader.postValue(true)
                        fetchingError.value = true
                    }
                }
                setSearchUserListFetching(false)
            }
        }
    }

    private fun updateSearchLoaderStatus() {
        if (searchLastPageFetched())
            removeSearchLoader.postValue(true)
        else
            addSearchLoader.postValue(true)
    }

    fun addSearchLoaderToTheList() {
        addSearchLoader.value = true
    }

    fun searchLastPageFetched() = currentSearchPage >= totalSearchPage

    fun resetSearch() {
        currentSearchPage = 0
        totalSearchPage = 1
        setSearchUserListFetching(false)
        removeSearchLoader.postValue(true)
    }

}