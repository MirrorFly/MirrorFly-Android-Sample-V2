package com.contusfly.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contusfly.*
import com.mirrorflysdk.flycommons.ChatType
import com.contusfly.models.ProfileDetailsShareModel
import com.contusfly.utils.Constants
import com.contusfly.utils.ContusContactUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.flycommons.LogMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForwardMessageViewModel @Inject constructor() : ViewModel() {

    private var groupList: MutableList<ProfileDetails>? = null
    private var recentList: MutableList<ProfileDetails>? = null
    private var friendsList: MutableList<ProfileDetails>? = null
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
        return BuildConfig.CONTACT_SYNC_ENABLED || isFetching
    }

    private fun setSearchUserListFetching(isSearchFetching: Boolean) {
        this.isSearchFetching = isSearchFetching
    }

    fun getSearchUserListFetching(): Boolean {
        return BuildConfig.CONTACT_SYNC_ENABLED || isSearchFetching
    }

    fun loadForwardChatList(jid: String?, privateChatPair : Pair<Boolean,String> = Pair(false,Constants.EMPTY_STRING)) {
        LogMessage.d(TAG, "#ForwardMessage loadForwardChatList()")
        viewModelScope.launch(Dispatchers.IO) {
            GroupManager.getAllGroups(false) { isSuccess, _, data ->
                groupList = mutableListOf()
                if (isSuccess) {
                    LogMessage.d(TAG, "#ForwardMessage loadForwardChatList() getAllGroups isSuccess")
                    var groupFilterList=loadPrivateChatGroupList(data[Constants.SDK_DATA] as MutableList<ProfileDetails>,privateChatPair)
                    groupList!!.addAll(ProfileDetailsUtils.sortProfileList(groupFilterList))

                   // groupList!!.addAll(ProfileDetailsUtils.sortProfileList(data[Constants.SDK_DATA] as ArrayList<ProfileDetails>))
                }
                isForwardChatListLoaded(jid)
            }

            FlyCore.getRecentChatList { isSuccess, _, data ->
                recentList = mutableListOf()
                if (isSuccess) {
                    val recentChatList = data[Constants.SDK_DATA] as MutableList<RecentChat>
                    loadrecentChatList(recentChatList,privateChatPair)
                }
                isForwardChatListLoaded(jid)
            }
            checkAndLoadUserList(jid)
        }
    }

    private fun loadPrivateChatGroupList(
        groupList: MutableList<ProfileDetails>,
        privateChatPair: Pair<Boolean, String>
    ): MutableList<ProfileDetails> {

        for (i in groupList.indices.reversed()) {
            var profile=groupList.get(i)
            var isPrivateChat = ChatManager.isPrivateChat(profile.jid)
            if(!privateChatPair.first && isPrivateChat) {
                groupList.removeAt(i)
            }

        }

        return groupList!!
    }

    private fun loadPrivateChatList(senderJid: String): MutableList<ProfileDetails> {
         recentList = mutableListOf()
        var privateChatList=ChatManager.getPrivateChatList()
        privateChatList.forEach { recentChat ->
            if(senderJid != recentChat.jid){
                val profileDetails = ProfileDetailsUtils.getProfileDetails(recentChat.jid)
                profileDetails?.let {
                    recentList!!.add(it)
                }
            }
        }

        return recentList!!
    }


    private fun loadrecentChatList(
        recentChatList: MutableList<RecentChat>,
        privateChatPair: Pair<Boolean, String>
    ): MutableList<ProfileDetails> {

        if(privateChatPair.first.isTrue()) recentList=loadPrivateChatList(privateChatPair.second)

        if(recentList!!.size < 3) {
            recentChatList.filter { !it.isDeletedContact() }.take(3 - this.recentList!!.size).forEach { recentChat ->
                val profileDetails = ProfileDetailsUtils.getProfileDetails(recentChat.jid)
                profileDetails?.let {
                    this.recentList!!.add(it)
                }
            }
        } else {
            recentList=recentList!!.take(3) as MutableList<ProfileDetails>
        }

        return recentList!!
    }


    private suspend fun checkAndLoadUserList(jid: String?) {
        LogMessage.d(TAG, "#ForwardMessage checkAndLoadUserList()")
        if (BuildConfig.CONTACT_SYNC_ENABLED) {
            val contusContacts = ContusContactUtils.getContusContacts()
            FlyCore.getRegisteredUsers(false) { isSuccess, _, data ->
                friendsList = mutableListOf()
                if (isSuccess) {
                    LogMessage.d(TAG, "#ForwardMessage checkAndLoadUserList() getRegisteredUsers isSuccess")
                    val profileDetails = data[Constants.SDK_DATA] as MutableList<ProfileDetails>
                    profileDetails.forEach { contact ->
                        val index = contusContacts.indexOfFirst { it.jid == contact.jid }
                        if (index.isValidIndex())
                            contusContacts.removeAt(index)
                    }
                    profileDetails.addAll(contusContacts)
                    friendsList!!.addAll(ProfileDetailsUtils.sortProfileList(profileDetails))
                }
                isForwardChatListLoaded(jid)
            }
        } else {
            if (!jid.isNullOrBlank())
                loadUserList()
        }
    }

    fun loadUserList() {
        LogMessage.d(TAG, "#ForwardMessage loadUserList() ")
        if (lastPageFetched())
            return
        fetchingError.postValue(false)
        viewModelScope.launch(Dispatchers.IO) {
            currentPage += 1
            setUserListFetching(true)
            FlyCore.getUserList(currentPage, resultPerPage) { isSuccess, _, data ->
                if (isSuccess) {
                    LogMessage.d(TAG, "#ForwardMessage getUserList isSuccess")
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
        LogMessage.d(TAG, "#ForwardMessage isForwardChatListLoaded() ")
        if (groupList != null && recentList != null && (!BuildConfig.CONTACT_SYNC_ENABLED || friendsList != null)) {
            loadProfileDetailsShareModel(jid)
            if (!BuildConfig.CONTACT_SYNC_ENABLED)
                loadUserList()
        }
    }

    private fun loadProfileDetailsShareModel(jid: String?) {
        LogMessage.d(TAG, "#ForwardMessage loadProfileDetailsShareModel() ")
        shareModelList = mutableListOf()
        recentList!!.forEach { profileDetail ->
            val profileDetailsShareModel = ProfileDetailsShareModel("recentChat", profileDetail)
            if (!profileDetail.isAdminBlocked) shareModelList.add(profileDetailsShareModel)
            friendsList?.let {
                val index = friendsList!!.indexOfFirst { it.jid == profileDetail.jid }
                if (index.isValidIndex())
                    friendsList!!.removeAt(index)
            }
            val groupIndex = groupList!!.indexOfFirst { it.jid == profileDetail.jid }
            if (groupIndex.isValidIndex())
                groupList!!.removeAt(groupIndex)
        }

        friendsList?.forEach { profileDetail ->
            val profileDetailsShareModel = ProfileDetailsShareModel(profileDetail.getChatType(), profileDetail)
            if (!profileDetail.isAdminBlocked) shareModelList.add(profileDetailsShareModel)
        }
        groupList!!.forEach { profileDetail ->
            val profileDetailsShareModel = ProfileDetailsShareModel(profileDetail.getChatType(), profileDetail)
            if (!profileDetail.isAdminBlocked) shareModelList.add(profileDetailsShareModel)
        }
        LogMessage.d(TAG, "#ForwardMessage loadProfileDetailsShareModel() shareModelList${shareModelList.size}")
        notifyResults(jid, shareModelList)
    }

    private fun notifyResults(jid: String?, shareModelList: MutableList<ProfileDetailsShareModel>) {
        LogMessage.d(TAG, "#ForwardMessage  notifyResults")
        if (jid == null) {
            if (BuildConfig.CONTACT_SYNC_ENABLED){
                shareModelListLiveData.postValue(shareModelList)
            } else {
                val shareModelListTemp = mutableListOf<ProfileDetailsShareModel>()
                shareModelListTemp.addAll(shareModelList)
                addLoader.postValue(true)
                shareModelListTemp.add(ProfileDetailsShareModel(ChatType.TYPE_CHAT, ProfileDetails()))
                shareModelListLiveData.postValue(shareModelListTemp)
            }
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
        LogMessage.d(TAG, "#ForwardMessage  filterUserList")
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
        LogMessage.d(TAG, "#ForwardMessage  filterSearchList")
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
        LogMessage.d(TAG, "#ForwardMessage  removeProfileDetails userId:$userId")
        val index = getPositionOfProfile(userId)
        if (index.isValidIndex())
            shareModelList.removeAt(index)
    }

    fun removeSearchProfileDetails(userId: String) {
        LogMessage.d(TAG, "#ForwardMessage  removeSearchProfileDetails userId:$userId")
        val index = searchList.indexOfFirst { it.profileDetails.jid == userId }
        if (index.isValidIndex())
            searchList.removeAt(index)
    }

    fun searchProfileList(searchString: String) {
        LogMessage.d(TAG, "#ForwardMessage  searchProfileList searchString:$searchString")
        if (BuildConfig.CONTACT_SYNC_ENABLED){
            searchList.clear()
            searchList.addAll(shareModelList.filter {
                !it.profileDetails.isUnknownContact() &&!it.profileDetails.isDeletedContact() && it.profileDetails.getDisplayName().contains(searchString, true)
            })

            val searchListTemp = mutableListOf<ProfileDetailsShareModel>()
            searchListTemp.addAll(searchList)

            searchListLiveData.postValue(searchListTemp)
        } else {
            resetSearch()
            searchList.clear()
            searchList.addAll(shareModelList.filter {
                it.type != ChatType.TYPE_CHAT && it.profileDetails.getDisplayName().contains(searchString, ignoreCase = true)
            })

            val searchListTemp = mutableListOf<ProfileDetailsShareModel>()
            searchListTemp.addAll(searchList)

            searchListLiveData.postValue(searchListTemp)
            searchUserList(searchString)
        }
    }

    fun searchUserList(searchString: String) {
        LogMessage.d(TAG, "#ForwardMessage  searchProfileList searchString:$searchString")
        if (searchLastPageFetched())
            return
        addSearchLoader.postValue(true)
        fetchingError.value = false
        viewModelScope.launch(Dispatchers.IO) {
            currentSearchPage += 1
            setSearchUserListFetching(true)
            FlyCore.getUserList(currentSearchPage, resultPerPage, searchString) { isSuccess, _, data ->
                if (isSuccess) {
                    LogMessage.d(TAG, "#ForwardMessage  searchProfileList getUserList: isSuccess")
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
        LogMessage.d(TAG, "#ForwardMessage  resetSearch")
        currentSearchPage = 0
        totalSearchPage = 1
        setSearchUserListFetching(false)
        removeSearchLoader.postValue(true)
    }
}