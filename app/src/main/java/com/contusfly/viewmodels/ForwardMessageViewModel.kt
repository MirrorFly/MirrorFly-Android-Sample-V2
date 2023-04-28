package com.contusfly.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirrorflysdk.flycommons.ChatType
import com.contusfly.getChatType
import com.contusfly.getDisplayName
import com.contusfly.isDeletedContact
import com.contusfly.isValidIndex
import com.contusfly.models.ProfileDetailsShareModel
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.RecentChat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

class ForwardMessageViewModel @Inject constructor() : ViewModel() {

    private var groupList: MutableList<ProfileDetails>? = null
    private var recentList: MutableList<ProfileDetails>? = null
    val shareModelListLiveData = MutableLiveData<List<ProfileDetailsShareModel>>()
    private var shareModelList = mutableListOf<ProfileDetailsShareModel>()
    val updatedProfile = MutableLiveData<Pair<Int, ProfileDetailsShareModel>>()

    private var isFetching = false
    private var currentPage = 0
    private var resultPerPage = 20
    private var totalPage = 1
    val addLoader = MutableLiveData<Boolean>()
    val removeLoader = MutableLiveData<Boolean>()
    val userList = MutableLiveData<List<ProfileDetailsShareModel>>()

    val searchListLiveData = MutableLiveData<List<ProfileDetailsShareModel>>()
    private var searchList = mutableListOf<ProfileDetailsShareModel>()
    val addSearchLoader = MutableLiveData<Boolean>()
    val removeSearchLoader = MutableLiveData<Boolean>()
    val fetchingError = MutableLiveData<Boolean>()
    private var isSearchFetching = false
    private var currentSearchPage = 0
    private var totalSearchPage = 1
    val searchUserList = MutableLiveData<List<ProfileDetailsShareModel>>()

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

    fun loadForwardChatList(jid: String?) {

        GroupManager.getAllGroups(false) { isSuccess, _, data ->
            groupList = mutableListOf()
            if (isSuccess) {
                groupList!!.addAll(ProfileDetailsUtils.sortProfileList(data[Constants.SDK_DATA] as ArrayList<ProfileDetails>))
            }
            isForwardChatListLoaded(jid)
        }

        FlyCore.getRecentChatList { isSuccess, _, data ->
            recentList = mutableListOf()
            if (isSuccess) {
                val recentChatList = data[Constants.SDK_DATA] as MutableList<RecentChat>
                recentChatList.filter { !it.isDeletedContact() }.take(3).forEach {
                    val profileDetails = ProfileDetailsUtils.getProfileDetails(it.jid)
                    profileDetails?.let {
                        recentList!!.add(it)
                    }
                }
            }
            isForwardChatListLoaded(jid)
        }
        if (!jid.isNullOrBlank())
            loadUserList()
    }

    fun loadUserList() {
        if (lastPageFetched())
            return
        fetchingError.value = false
        viewModelScope.launch(Dispatchers.IO) {
            currentPage += 1
            setUserListFetching(true)
            FlyCore.getUserList(currentPage, resultPerPage) { isSuccess, _, data ->
                if (isSuccess) {
                    val profileList = data[Constants.SDK_DATA] as MutableList<ProfileDetails>
                    totalPage = data[Constants.TOTAL_PAGES] as Int
                    val userListResult = ProfileDetailsUtils.removeAdminBlockedProfiles(profileList, false)
                    val profileListShareModel = filterUserList(userListResult as MutableList<ProfileDetails>)
                    viewModelScope.launch(Dispatchers.Main) {
                        removeLoader.postValue(true)
                        shareModelList.addAll(profileListShareModel)
                        userList.value = profileListShareModel
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

    fun lastPageFetched() = currentPage >= totalPage

    private fun isForwardChatListLoaded(jid: String?) {
        if (groupList != null && recentList != null) {
            loadProfileDetailsShareModel(jid)
            loadUserList()
        }
    }

    private fun loadProfileDetailsShareModel(jid: String?) {
        shareModelList = mutableListOf()
        recentList!!.forEach { profileDetail ->
            val profileDetailsShareModel = ProfileDetailsShareModel("recentChat", profileDetail)
            if (!profileDetail.isAdminBlocked) shareModelList.add(profileDetailsShareModel)
            val groupIndex = groupList!!.indexOfFirst { it.jid == profileDetail.jid }
            if (groupIndex.isValidIndex())
                groupList!!.removeAt(groupIndex)
        }

        groupList!!.forEach { profileDetail ->
            val profileDetailsShareModel = ProfileDetailsShareModel(profileDetail.getChatType(), profileDetail)
            if (!profileDetail.isAdminBlocked) shareModelList.add(profileDetailsShareModel)
        }

        if (jid == null) {
            val shareModelListTemp = mutableListOf<ProfileDetailsShareModel>()
            shareModelListTemp.addAll(shareModelList)
            addLoader.postValue(true)
            shareModelListTemp.add(ProfileDetailsShareModel(ChatType.TYPE_CHAT, ProfileDetails()))
            shareModelListLiveData.postValue(shareModelListTemp)
        } else {
            val index = shareModelList.indexOfFirst { it.profileDetails.jid == jid }
            if (index.isValidIndex())
                updatedProfile.postValue(Pair(index, shareModelList[index]))
        }
    }

    private fun filterUserList(userListResult: MutableList<ProfileDetails>): List<ProfileDetailsShareModel> {
        val profileShareModelList = mutableListOf<ProfileDetailsShareModel>()
        recentList!!.forEach { profileDetail ->
            val index = userListResult.indexOfFirst { it.jid == profileDetail.jid }
            if (index.isValidIndex())
                userListResult.removeAt(index)
        }

        userListResult.forEach { profileDetail ->
            val profileDetailsShareModel = ProfileDetailsShareModel(profileDetail.getChatType(), profileDetail)
            if (!profileDetail.isAdminBlocked) profileShareModelList.add(profileDetailsShareModel)
        }

        return profileShareModelList
    }

    private fun filterSearchList(userListResult: MutableList<ProfileDetails>): List<ProfileDetailsShareModel> {
        val profileShareModelList = mutableListOf<ProfileDetailsShareModel>()
        searchList.forEach { profileDetail ->
            val index = userListResult.indexOfFirst { it.jid == profileDetail.profileDetails.jid }
            if (index.isValidIndex())
                userListResult.removeAt(index)
        }

        userListResult.forEach { profileDetail ->
            val profileDetailsShareModel =
                ProfileDetailsShareModel(profileDetail.getChatType(), profileDetail)
            if (!profileDetail.isAdminBlocked) profileShareModelList.add(profileDetailsShareModel)
        }

        return profileShareModelList
    }

    fun getPositionOfProfile(jid: String): Int {
        shareModelList.forEachIndexed { index, item ->
            if (item.profileDetails.jid!!.equals(jid, ignoreCase = true))
                return index
        }
        return -1
    }

    fun removeProfileDetails(userId: String) {
        val index = getPositionOfProfile(userId)
        if (index.isValidIndex())
            shareModelList.removeAt(index)
    }

    fun removeSearchProfileDetails(userId: String) {
        val index = searchList.indexOfFirst { it.profileDetails.jid == userId }
        if (index.isValidIndex())
            searchList.removeAt(index)
    }

    fun searchProfileList(searchString: String) {
        resetSearch()
        searchList.clear()
        searchList.addAll(shareModelList.filter { it.type != ChatType.TYPE_CHAT && it.profileDetails.getDisplayName().contains(searchString, ignoreCase = true) })

        val searchListTemp = mutableListOf<ProfileDetailsShareModel>()
        searchListTemp.addAll(searchList)

        searchListLiveData.postValue(searchListTemp)
        searchUserList(searchString)
    }

    fun searchUserList(searchString: String) {
        if (searchLastPageFetched())
            return
        addSearchLoader.postValue(true)
        fetchingError.value = false
        viewModelScope.launch(Dispatchers.IO) {
            currentSearchPage += 1
            setSearchUserListFetching(true)
            FlyCore.getUserList(currentSearchPage, resultPerPage, searchString) { isSuccess, _, data ->
                if (isSuccess) {
                    val profileList = data[Constants.SDK_DATA] as MutableList<ProfileDetails>
                    totalSearchPage = data[Constants.TOTAL_PAGES] as Int
                    val searchListResult = ProfileDetailsUtils.removeAdminBlockedProfiles(profileList, false)
                    val searchListShareModel = filterSearchList(searchListResult as MutableList<ProfileDetails>)
                    viewModelScope.launch(Dispatchers.Main) {
                        removeSearchLoader.postValue(true)
                        searchList.addAll(searchListShareModel)
                        searchUserList.value = searchListShareModel
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

    fun searchLastPageFetched() = currentSearchPage >= totalSearchPage

    private fun resetSearch() {
        currentSearchPage = 0
        totalSearchPage = 1
        setSearchUserListFetching(false)
        removeSearchLoader.postValue(true)
    }
}