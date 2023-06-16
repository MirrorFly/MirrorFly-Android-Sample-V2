package com.contusfly.viewmodels

import android.content.Context
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.contusfly.*
import com.mirrorflysdk.flycall.call.database.model.CallLog
import com.mirrorflysdk.flycommons.*
import com.contusfly.diffCallBacks.ProfileDiffCallback
import com.contusfly.diffCallBacks.RecentChatDiffCallback
import com.contusfly.interfaces.RecentChatEvent
import com.contusfly.models.ProfileDetailsShareModel
import com.contusfly.notification.AppNotificationManager
import com.contusfly.utils.AppChatShortCuts.dynamicAppShortcuts
import com.contusfly.utils.Constants.Companion.SDK_DATA
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.RecentChatListBuilder
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.flycommons.SharedPreferenceManager.Companion.RECENT_CHAT_FETCHED_PAGE_NUMBER
import com.mirrorflysdk.flydatabase.model.ChatTagModel
import com.mirrorflysdk.models.RecentChatListParams
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class DashboardViewModel @Inject
constructor() : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception ${TAG}:  ${exception.printStackTrace()}")
    }

    /**
     * List to add position of the clicked chats for pinning
     */
    val pinnedListPosition = ArrayList<Int>()
    private var recentPinnedCount = 0
    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String>
        get() = _showMessage

    private var isSearchFetching = false
    private var currentSearchPage = 0
    private var totalSearchPage = 1
    private var resultPerPage = 10
    private var isPaginate:Boolean=false
    private var isFetching = false

    val restartactivityRecentChatListlivedata = MutableLiveData<Boolean>()
    val chatTagDataPinUnpinLoad= MutableLiveData<Boolean>()
    val chatList = MutableLiveData<LinkedList<RecentChat>>()
    val chatTagList = MutableLiveData<ArrayList<ChatTagModel>>()
    val recentChatList = MutableLiveData<LinkedList<RecentChat>>()
    val notifyRecentChatRemoved = MutableLiveData<Int>()
    val notifyRecentChatInserted = MutableLiveData<Pair<Int, Int>>()
    val chats = MutableLiveData<Triple<String, Int, Int>>()
    val recentChat = MutableLiveData<Triple<String, Int, Int>>()
    val unreadChatCountLiveData = MutableLiveData<Int>()
    val searchKeyLiveData = MutableLiveData<String>()
    val profileUpdatedLiveData = MutableLiveData<String>()
    val blockedProfilesLiveData = MutableLiveData<List<String>>()
    val clearChatList = MutableLiveData<ArrayList<String>>()
    val recentDeleteChatPosition = MutableLiveData<Int>()
    val archiveChatStatus = MutableLiveData<Triple<Boolean, Boolean, Int>>()
    val archivedSettingsStatus = MutableLiveData<Boolean>()
    val archiveChatUpdated = MutableLiveData<Pair<String, Boolean>>()
    val selectedArchiveChats = MutableLiveData<MutableList<String>>()
    val addSearchLoader = MutableLiveData<Boolean>()
    val removeSearchLoader = MutableLiveData<Boolean>()
    val fetchingError = MutableLiveData<Boolean>()
    val onTypingStatusGoneUpdate = MutableLiveData<String>()
    val availableFeatureLiveData=MutableLiveData<Features>()
    val clearallCallLog = MutableLiveData<Boolean>()
    val paginationLoader = MutableLiveData<Boolean>()
    val swipeRefreshLoader = MutableLiveData<Boolean>()

    //Define the Recent Chat List Builder class
    private lateinit var recentChatListParams : RecentChatListParams
    private lateinit var recentChatListBuilder: RecentChatListBuilder

    /**
     * Selected recent chats when long press
     */
    val selectedChats by lazy { ArrayList<RecentChat>() }
    val selectedRecentChats: ArrayList<RecentChat> by lazy { ArrayList<RecentChat>() }

    /**
     * Recent Chat Adapter Value
     */
    val chatAdapter by lazy { LinkedList<RecentChat>() }
    val recentChatAdapter: LinkedList<RecentChat> by lazy { LinkedList<RecentChat>() }
    val filterArchivedChatList = MutableLiveData<List<RecentChat>>()

    /* = = = = = = = = Profile Data = = = = = = = = */
    val profileDetailsList = MutableLiveData<List<ProfileDetails>>()
    val profileListAdapter: ArrayList<ProfileDetails> by lazy { ArrayList<ProfileDetails>() }
    val profileDiffResult = MutableLiveData<DiffUtil.DiffResult>()
    val isContactSyncSuccess = MutableLiveData<Boolean>()
    val callsSearchKey = MutableLiveData<String>()

    val typingAndGoneStatus by lazy { ArrayList<Triple<String, String, Boolean>>() }

    /**
     * Recent Chat [DiffUtil.DiffResult]
     */
    val chatDiffResult = MutableLiveData<DiffUtil.DiffResult>()
    val recentChatDiffResult = MutableLiveData<DiffUtil.DiffResult>()

    // = = = = = = = = RecentChat Data = = = = = = = =
    val updateMessageStatus = MutableLiveData<String>()
    val groupCreatedLiveData = MutableLiveData<String>()
    val groupUpdatedLiveData = MutableLiveData<String>()
    val groupNewUserAddedLiveData = MutableLiveData<String>()
    val groupUserRemovedLiveData = MutableLiveData<String>()
    val groupAdminChangedLiveData = MutableLiveData<String>()
    val refreshTheRecentChatList = MutableLiveData<Boolean>()

    // = = = = = = = = Search Data = = = = = = = =
    val filterRecentChatList = MutableLiveData<List<RecentChat>>()
    val messageList = MutableLiveData<Pair<Int, List<com.contusfly.models.RecentSearch>>>()
    val filterProfileList = MutableLiveData<List<ProfileDetailsShareModel>>()
    private var searchList = mutableListOf<ProfileDetailsShareModel>()


    val isUserBlockedUnblockedMe = MutableLiveData<Pair<String, Boolean>>()
    val isUserBlockedByAdmin = MutableLiveData<Pair<String, Boolean>>()

    init {
        viewModelScope.launch {
            recentPinnedCount = 0
        }

    }

    private val _changedReadUnReadPosition = MutableLiveData<Int>()
    val changedReadUnReadPosition: LiveData<Int>
        get() = _changedReadUnReadPosition

    private val _changedPinPosition = MutableLiveData<Int>()
    val changedPinPosition: LiveData<Int>
        get() = _changedPinPosition

    fun setBlockUnBlockJID(jid: String, isBlocked: Boolean) {
        isUserBlockedUnblockedMe.value = Pair(jid, isBlocked)
    }

    fun setAdminBlockedStatus(jid: String, isAdminBlocked: Boolean) {
        isUserBlockedByAdmin.value = Pair(jid, isAdminBlocked)
    }

    // = = = = = = = = CallLogs Data = = = = = = = =
    val callLogList = MutableLiveData<List<CallLog>>()
    val callLogListAdapter: ArrayList<CallLog> by lazy { ArrayList() }
    val selectedCallLogs: ArrayList<String> by lazy { ArrayList() }
    val callLogDiffResult = MutableLiveData<DiffUtil.DiffResult>()

    // = = = = = = = = Language Data = = = = = = = =
    val updateLanguageSearch = MutableLiveData<String>()

    /*
    * Get Profile List */
    fun getProfileDetailsList() {
        viewModelScope.launch {
            FlyCore.getRegisteredUsers(false, FlyCallback { isSuccess, _, data ->
                if (isSuccess) {
                    val profileDetails = data[SDK_DATA] as MutableList<ProfileDetails>
                    profileDetailsList.value = sortProfileList(profileDetails)
                    getProfileDiffResult()
                }
            })
        }
    }

    fun getRestartActivitygetrecentChatList(){

        restartactivityRecentChatListlivedata.value=true
    }


    fun getRecentChatHistoryList(pageNo: Int = 1) {
        LogMessage.d(TAG, "getInitialChatList() called to update the UI")
        setSwipeLoader(true)
        setRecentChatListFetching(true)
        viewModelScope.launch(IO) {
            try {
                FlyCore.getRecentChatHistory(pageNo) { isSuccess, _, data ->
                    if (isSuccess) {
                        LogMessage.e("KSV_LOG_SUCCESS","SUCCESS")
                        if (recentChatList.value == null && !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.PIN_SCREEN)) {
                            recentChatList.value = LinkedList(data[SDK_DATA] as MutableList<RecentChat>)
                            recentChatList.value!!.add(0, RecentChat()) // Recent Chat Header
                            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer
                            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader
                            recentChatAdapter.clear()
                            recentChatAdapter.addAll(recentChatList.value!!)
                            recentChatDiffResult.value = null
                        } else {
                            recentChatList.value = LinkedList(data[SDK_DATA] as MutableList<RecentChat>)
                            recentChatList.value!!.add(0, RecentChat()) // Recent Chat Header
                            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer
                            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader
                            getRecentChatDiffResult()
                        }
                        getArchivedChatStatus()
                    }
                    setRecentChatListFetching(false)
                    setSwipeLoader(false)
                }
            } catch(e:Exception) {
                LogMessage.e(TAG, "Recent Chat List loading issue in nextSetOfRecentChatList() ==> Exception: ${e.message}")
                setRecentChatListFetching(false)
                setSwipeLoader(false)
            }

        }
    }

    private fun setSwipeLoader(isShowStatus:Boolean){
        CoroutineScope(Dispatchers.Main).launch {
            if(isShowStatus) {
                swipeRefreshLoader.value=true
            } else {
                swipeRefreshLoader.value=false
            }
        }
    }

    private fun setRecentChatListFetching(isfetching: Boolean) {
        CoroutineScope(Dispatchers.Main).launch {
           isFetching = isfetching
        }
    }

    fun getRecentChatListFetching(): Boolean {
        return isFetching
    }

    fun getInitialChatList(recentChatLimit: Int = Constants.RECENT_CHAT_LIST_LIMIT) {
        LogMessage.d(TAG, "getInitialChatList() called to update the UI")
        setRecentChatListFetching(true)
        if (ChatManager.getAvailableFeatures().isChatHistoryEnabled) {
            var fetchedPageNumber=
                com.mirrorflysdk.flycommons.SharedPreferenceManager.instance.getInt(RECENT_CHAT_FETCHED_PAGE_NUMBER)
            if(fetchedPageNumber == 0) {
                getRecentChatHistoryList()
            } else {
                getInitialRecentChatList(recentChatLimit)
            }
        } else {
            getInitialRecentChatList(recentChatLimit)
        }
    }

    private fun getInitialRecentChatList(recentChatLimit: Int){

        viewModelScope.launch(Main.immediate) {
            recentChatListParams = RecentChatListParams().apply { limit = recentChatLimit }
            recentChatListBuilder = RecentChatListBuilder(recentChatListParams)
            recentChatListBuilder.loadRecentChatList { isSuccess, _, data ->
                if (isSuccess) {
                    if (recentChatList.value == null && !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.PIN_SCREEN)) {
                        recentChatList.value = LinkedList(data[SDK_DATA] as MutableList<RecentChat>)
                        recentChatList.value!!.add(0, RecentChat()) // Recent Chat Header
                        recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer
                        recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader
                        recentChatAdapter.clear()
                        recentChatAdapter.addAll(recentChatList.value!!)
                        recentChatDiffResult.value = null
                    } else {
                        recentChatList.value = LinkedList(data[SDK_DATA] as MutableList<RecentChat>)
                        recentChatList.value!!.add(0, RecentChat()) // Recent Chat Header
                        recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer
                        recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader
                        getRecentChatDiffResult()
                    }
                }
                setRecentChatListFetching(false)
            }
        }
    }

    fun refreshFetchedRecentChat() {
        LogMessage.d(TAG, "refreshFetchedRecentChat() called to update the UI")
        var prefetchedRecentChats = recentChatAdapter.size - 3 // calculate recent chat has prefetched data by skipping header and footer and loader
        if (prefetchedRecentChats < Constants.RECENT_CHAT_LIST_LIMIT)
            prefetchedRecentChats = Constants.RECENT_CHAT_LIST_LIMIT
        getInitialChatList(prefetchedRecentChats)
    }

    fun getChatTagData(){
        ChatManager.getChatTagdata(object:FlyCallback {
            override fun flyResponse(
                isSuccess: Boolean,
                throwable: Throwable?,
                data: HashMap<String, Any>) {
                try{
                    if(isSuccess){
                        viewModelScope.launch(Dispatchers.Main.immediate) {
                            var chatTagnamelist=ArrayList<ChatTagModel>()
                            try{
                                 chatTagnamelist= data.getData() as ArrayList<ChatTagModel>
                            }catch(e:Exception){
                                LogMessage.e(TAG,e.toString())
                            }
                            chatTagList.value=chatTagnamelist
                        }
                    }
                }catch(e:Exception){
                    LogMessage.e(TAG,e.toString())
                }
            }
        },true)
    }

    fun getRecentChatListBasedOnTagData(jidList:ArrayList<String>) {
        viewModelScope.launch(Dispatchers.Main.immediate) {
            recentChatList.value = LinkedList(FlyCore.getRecentChatListByChatTag(jidList))
            recentChatList.value!!.add(0, RecentChat()) // Recent Chat Header
            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer
            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader item
            recentChatAdapter.clear()
            recentChatAdapter.addAll(recentChatList.value!!)
            recentChatDiffResult.value = null
        }
    }

    fun nextSetOfRecentChatList() {
        LogMessage.d(TAG, "nextSetOfRecentChatList() called to update the UI with next set of list---${getRecentChatListFetching()}")
        paginationLoaderShowHide(true)
        setRecentChatListFetching(true)
        if (ChatManager.getAvailableFeatures().isChatHistoryEnabled) {
            nextSetOfRecentChatListFromServer()
        } else {
            nextSetOfRecentChatListFromDB()
        }

    }

    private fun nextSetOfRecentChatListFromServer(){

        var pageNo=
            com.mirrorflysdk.flycommons.SharedPreferenceManager.instance.getInt(RECENT_CHAT_FETCHED_PAGE_NUMBER)
        var currentPageNo=pageNo+1
        LogMessage.d(TAG, "nextSetOfRecentChatList()---PAGENO--${currentPageNo}")
        viewModelScope.launch(IO) {
            try {
                FlyCore.getRecentChatHistory(currentPageNo) { isSuccess, _, data ->
                    if (isSuccess) {
                        try {
                            updateRecentChats(data)
                        } catch (e: Exception) {
                            LogMessage.e(TAG, "Recent Chat List loading issue in nextSetOfRecentChatList() ==> Exception: ${e.message}")
                        }
                    }
                    setRecentChatListFetching(false)
                    paginationLoaderShowHide(false)
                }
            } catch(e:Exception) {
                LogMessage.e(TAG, "Recent Chat List loading issue in nextSetOfRecentChatList() ==> Exception: ${e.message}")
                setRecentChatListFetching(false)
                paginationLoaderShowHide(false)
            }

        }
    }

    private fun nextSetOfRecentChatListFromDB(){

        viewModelScope.launch(Main.immediate) {
            recentChatListBuilder.nextSetOfData { isSuccess, _, data ->
                if (isSuccess) {
                    try {
                        updateRecentChats(data)
                    } catch (e: Exception) {
                        LogMessage.e(TAG, "Recent Chat List loading issue in nextSetOfRecentChatList() ==> Exception: ${e.message}")
                    }
                }
                setRecentChatListFetching(false)
                paginationLoaderShowHide(false)
            }
        }
    }

    private fun updateRecentChats(data: HashMap<String, Any>) {
        val recentChats = data[SDK_DATA] as MutableList<RecentChat>
        if(recentChats.size > 0){
            val recentChatSize = recentChatAdapter.size
            recentChatList.value!!.removeAt(recentChatList.value!!.size - 1) // Recent Chat Footer item removed
            recentChatAdapter.removeAt(recentChatAdapter.size - 1) // Recent Chat Footer item removed
            notifyRecentChatRemoved.postValue(recentChatAdapter.size)
            recentChatList.value!!.addAll(LinkedList(recentChats))
            recentChatAdapter.addAll(recentChats)
            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer item adding
            recentChatAdapter.add(recentChatAdapter.size, RecentChat()) // Recent Chat Footer item adding
            notifyRecentChatInserted.postValue(Pair(recentChatSize, recentChats.size))
            getArchivedChatStatus()
        }
    }

    private fun paginationLoaderShowHide(isShow:Boolean) {
        viewModelScope.launch(Main) {
            if(isShow) {
                paginationLoader.value=true
            } else {
                paginationLoader.value=false
            }
        }
    }

    fun setTypingStatus(typingStatus: Triple<String, String, Boolean>) {
        if (typingStatus.third) {
            val index = typingAndGoneStatus.indexOfFirst { it.first == typingStatus.first && it.second == typingStatus.second }
            if (index == -1)
                typingAndGoneStatus.add(0,typingStatus)
        } else {
            val index = typingAndGoneStatus.indexOfFirst { it.first == typingStatus.first && it.second == typingStatus.second }
            if (index.isValidIndex())
                typingAndGoneStatus.removeAt(index)
        }
    }

    private fun getProfileDiffResult() {
        viewModelScope.launch {
            val diffResult = getDiffUtilResult(ProfileDiffCallback(profileListAdapter, profileDetailsList.value!!))
            profileListAdapter.clear()
            profileListAdapter.addAll(profileDetailsList.value!!)
            profileDiffResult.value = diffResult
        }
    }

    fun getChatDiffResult() {
        viewModelScope.launch {
            val diffResult = getDiffUtilResult(RecentChatDiffCallback(chatAdapter, chatList.value!!))
            chatAdapter.clear()
            chatAdapter.addAll(chatList.value!!)
            chatDiffResult.value = diffResult
        }
    }

    private fun getRecentChatDiffResult() {
        viewModelScope.launch {
            val diffResult = DiffUtil.calculateDiff(RecentChatDiffCallback(recentChatAdapter, recentChatList.value!!))
            recentChatAdapter.clear()
            recentChatAdapter.addAll(recentChatList.value!!)
            recentChatDiffResult.value = diffResult
        }
    }

    private suspend fun getDiffUtilResult(diffUtilCallback: DiffUtil.Callback): DiffUtil.DiffResult = withContext(IO) {
        DiffUtil.calculateDiff(diffUtilCallback)
    }

    fun filterContactsList(searchKey: String, jidList: ArrayList<String>) {
        if (searchLastPageFetched()) {
            setIsPaginate(false)
            return
        }
        addSearchLoader.postValue(true)
        fetchingError.value = false
        viewModelScope.launch(IO) {
            currentSearchPage += 1
            setSearchUserListFetching(true)
            FlyCore.getUserList(currentSearchPage, resultPerPage, searchKey) { isSuccess, _, data ->
                if (isSuccess) {
                    val profileDetails = data[SDK_DATA] as MutableList<ProfileDetails>
                    totalSearchPage = data[com.contusfly.utils.Constants.TOTAL_PAGES] as Int
                    val searchListResult = ProfileDetailsUtils.removeAdminBlockedProfiles(profileDetails, false)
                    val searchListShareModel = filterSearchList(jidList,searchListResult as MutableList<ProfileDetails>)
                    viewModelScope.launch(Main) {
                        removeSearchLoader.postValue(true)
                        searchList.addAll(searchListShareModel)
                        filterProfileList.value = searchListShareModel

                    }
                }else {
                    currentSearchPage -= 1
                    viewModelScope.launch(Main) {
                        removeSearchLoader.postValue(true)
                        fetchingError.value = true
                    }
                }
                updatePaginate()
                setSearchUserListFetching(false)
            }
        }
    }

    private fun updatePaginate(){
        if(currentSearchPage>1)
            setIsPaginate(true)
        else
            setIsPaginate(false)
    }

    private fun filterSearchList(jidList: ArrayList<String>,userListResult: MutableList<ProfileDetails>): List<ProfileDetailsShareModel> {
        val profileShareModelList = mutableListOf<ProfileDetailsShareModel>()
        jidList.forEach { jid ->
            val index = userListResult.indexOfFirst {
                it.jid== jid }
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

    fun searchLastPageFetched() = currentSearchPage >= totalSearchPage

     fun resetSearch() {
        currentSearchPage = 0
        totalSearchPage = 1
        setSearchUserListFetching(false)
        removeSearchLoader.postValue(true)
    }

    fun setSearchUserListFetching(isSearchFetching: Boolean) {
        this.isSearchFetching = isSearchFetching
    }
    fun getSearchUserListFetching(): Boolean {
        return isSearchFetching
    }

    fun setIsPaginate(isPaginate:Boolean){
        this.isPaginate=isPaginate
    }

    fun getPaginateBoolean():Boolean{
        return isPaginate
    }

    fun getRecentChatOfUser(jid: String, @RecentChatEvent event: String) {
        viewModelScope.launch {
            try {
                val recent = FlyCore.getRecentChatOf(jid)
                if (recent != null && !recent.isChatArchived) {
                    //update view model list
                    val index = recentChatAdapter.indexOfFirst { it.jid == recent.jid }
                    val positionToAdd = getRecentPosition(recent.jid, recent, event)
                    if (index.isValidIndex()) {
                        recentChatList.value!!.removeAt(index)
                        recentChatList.value!!.add(positionToAdd, recent)
                        recentChatAdapter.removeAt(index)
                        recentChatAdapter.add(positionToAdd, recent)
                    } else {
                        recentChatList.value!!.add(positionToAdd, recent)
                        recentChatAdapter.add(positionToAdd, recent)
                    }
                    recentChat.value = Triple(event, index, positionToAdd)
                } else {
                    //update view model list
                    val index = recentChatAdapter.indexOfFirst { it.jid == jid }
                    if (index.isValidIndex()) {
                        recentChatList.value!!.removeAt(index)
                        recentChatAdapter.removeAt(index)
                        recentDeleteChatPosition.value = index
                    }
                }

            } catch(e:Exception) {
                LogMessage.e(TAG,e.toString())
            }

        }
    }

    /**
     * This method will return the position of chat
     */
    private fun getRecentPosition(jid: String, recent: RecentChat, @RecentChatEvent event: String): Int {
        return if (event == RecentChatEvent.MESSAGE_RECEIVED) {
            if (recent.isChatPinned) {
                val index = this.recentChatAdapter.indexOfFirst { it.jid == jid }
                if (index.isValidIndex()) index else 1 //Recent Chat header will be always 0
            } else
                recentPinnedCount + 1 //Recent Chat header will be always 0
        } else if (event == RecentChatEvent.ARCHIVE_EVENT) {
            getArchiveRecentPosition(recent)
        } else {
            val index = this.recentChatAdapter.indexOfFirst { it.jid == jid }
            if (index.isValidIndex() && recent.isChatPinned) index else 1 //Recent Chat header will be always 0
        }
    }

    private fun getArchiveRecentPosition(recent: RecentChat): Int {
        val index = this.recentChatAdapter.indexOfFirst { !it.jid.isNullOrBlank() && it.lastMessageTime <= recent.lastMessageTime }
        return if (index.isValidIndex()) index else 1 //Recent Chat header will be always 0
    }

    fun filterRecentChatList(searchKey: String) {
        viewModelScope.launch {
            val recentChatList = mutableListOf<RecentChat>()
            val recentChatListWithArchived = FlyCore.getRecentChatListIncludingArchived()
            for (recentChat in recentChatListWithArchived)
                if (recentChat.profileName != null && recentChat.profileName.contains(searchKey, true))
                    recentChatList.add(recentChat)
            filterRecentChatList.value = recentChatList
        }
    }

    /**
     * Validating the selected chat count and updating db
     */
    fun updatePinnedRecentChats(): Boolean {
        recentPinnedCount = FlyCore.recentChatPinnedCount()
        var currentPinnedCount = 0

        if (isSelectedPositionsValidForPin()) {
            for (position in pinnedListPosition) {
                val selectedChat: RecentChat = recentChatAdapter[position]
                if (!selectedChat.isChatPinned) {
                    FlyCore.updateRecentChatPinStatus(selectedChat.jid, true)
                    // _changedPinPosition.value = position
                    recentPinnedCount++
                    currentPinnedCount++
                } else {
                    LogMessage.d(TAG, "selected chat is already pinned")
                }
            }
        } else {
            _showMessage.value = "You can only pin upto 3 chats"
            return false
        }
        if (currentPinnedCount == 1) _showMessage.value = "Chat pinned"
        else if (currentPinnedCount in 2..3) _showMessage.value = "Chats pinned"
        //Reset the recent items
        recentChatList.value = null
        chatTagDataPinUnpinLoad.value=true
        pinnedListPosition.clear()
        return true
    }

    private fun isSelectedPositionsValidForPin(): Boolean {
        if ((recentPinnedCount + pinnedListPosition.size) <= 3) {
            return true
        }
        var validPositions = 0 //selected non pinned items
        for (position in pinnedListPosition) {
            if (position >= recentPinnedCount) // check, is non pinned item
                validPositions++
        }
        if ((recentPinnedCount + validPositions) <= 3) {
            return true
        }
        return false
    }

    /**
     * Updating db once the pinned chat is unpinned
     */
    fun updateUnPinnedRecentChats() {
        for (position in pinnedListPosition) {
            val selectedChats: RecentChat = recentChatList.value!![position]
            FlyCore.updateRecentChatPinStatus(selectedChats.jid, false)
            //  _changedPinPosition.value = position
        }
        if (pinnedListPosition.size == 1) _showMessage.value = "Chat unpinned"
        else if (pinnedListPosition.size <= 3) _showMessage.value = "Chats unpinned"
        //Reset the recent items
        recentChatList.value = null
        chatTagDataPinUnpinLoad.value = true
        pinnedListPosition.clear()
    }

    /**
     * Updating db once the recent chat is read
     */
    fun markAsReadRecentChats(context: Context) {
        val jidList = ArrayList<String>()
        for (selectedRecentChat in selectedRecentChats) {
            jidList.add(selectedRecentChat.jid)
        }
        FlyCore.markConversationAsRead(jidList)
        jidList.clear()
        for (selectedRecentChat in selectedRecentChats) {
            AppNotificationManager.clearConversationOnNotification(context, selectedRecentChat.jid)
            val recentListPosition = recentChatList.value!!.indexOfFirst { it.jid == selectedRecentChat.jid }
            val recent = FlyCore.getRecentChatOf(selectedRecentChat.jid)
            if (recent != null) {
                recentChatList.value!![recentListPosition] = recent
                recentChatAdapter[recentListPosition] = recent
                _changedReadUnReadPosition.value = recentListPosition
            }
        }
        //update unread count in tab
        updateUnReadChatCount()
        if (selectedRecentChats.size == 1) _showMessage.value = "Chat marked as read"
        else if (selectedRecentChats.size > 1) _showMessage.value = "Chats marked as read"
    }

    fun markAsUnreadRecentChats() {
        val jidList = ArrayList<String>()
        for (selectedRecentChat in selectedRecentChats) {
            jidList.add(selectedRecentChat.jid)
        }
        FlyCore.markConversationAsUnread(jidList)
        jidList.clear()
        for (selectedRecentChat in selectedRecentChats) {
            val recentListPosition = recentChatList.value!!.indexOfFirst { it.jid == selectedRecentChat.jid }
            val recent = FlyCore.getRecentChatOf(selectedRecentChat.jid)
            if (recent != null) {
                recentChatList.value!![recentListPosition] = recent
                recentChatAdapter[recentListPosition] = recent
                _changedReadUnReadPosition.value = recentListPosition
            }
        }
        //update unread count in tab
        updateUnReadChatCount()
        if (selectedRecentChats.size == 1) _showMessage.value = "Chat marked as unread"
        else if (selectedRecentChats.size > 1) _showMessage.value = "Chats marked as unread"
    }

    fun filterMessageList(searchKey: String) {
        viewModelScope.launch {
            FlyCore.searchConversation(searchKey, Constants.EMPTY_STRING, true) { isSuccess, _, data ->
                if (isSuccess) {
                    val mRecentSearchList = ArrayList<com.contusfly.models.RecentSearch>()
                    val result = data[SDK_DATA] as ArrayList<ChatMessage>
                    var i = 0
                    result.forEach { message ->
                        val searchMessageItem = com.contusfly.models.RecentSearch(message.getChatUserJid(), message.getMessageId(),
                                Constants.TYPE_SEARCH_MESSAGE, message.getMessageChatType().toString(), true,ProfileDetails())
                        mRecentSearchList.add(0, searchMessageItem)
                        i++
                    }
                    messageList.value = Pair(i, mRecentSearchList)

                }
            }
        }
    }

    fun updateUnReadChatCount() {
        viewModelScope.launch {
            unreadChatCountLiveData.value = FlyMessenger.getUnreadMessagesCount()
        }
    }

    fun setReceivedMsg(msg: ChatMessage?) {
        getRecentChatOfUser(msg!!.getChatUserJid(), RecentChatEvent.MESSAGE_RECEIVED)
        updateUnReadChatCount()
        getArchivedChatStatus()
    }

    fun setMessageStatus(messageId: String) {
        updateMessageStatus.value = messageId
    }

    fun setClearedMessagesView(jid: String?) {
        getRecentChatOfJid(jid!!, RecentChatEvent.MESSAGE_RECEIVED)
        updateUnReadChatCount()
    }

    fun getRecentChatOfJid(jid: String, @RecentChatEvent event: String) {
        viewModelScope.launch {
            val recent = FlyCore.getRecentChatOf(jid)
            if (recent != null) {
                //update view model list
                val index = recentChatAdapter.indexOfFirst { it.jid == recent.jid }
                if (index.isValidIndex()) {
                    recentChatList.value!![index] = recent
                    recentChatAdapter[index] = recent
                }
            } else refreshTheRecentChatList.value = true
        }
    }

    fun getLiveDataForBlockedContacts(jidList: List<String>) {
        viewModelScope.launch {
            blockedProfilesLiveData.value = jidList
        }
    }

    fun updateRecentMessage(messageIds: ArrayList<String>?) {
        if (messageIds != null)
            for (mid in messageIds) {
                val index = recentChatAdapter.indexOfFirst { it.lastMessageId == mid }
                if (index.isValidIndex()) {
                    val recent = recentChatAdapter[index]
                    getRecentChatOfUser(recent.jid, RecentChatEvent.MESSAGE_UPDATED)
                    setMessageStatus(recent.lastMessageId)
                }
            }
    }

    fun clearTypingStatusList() {
        typingAndGoneStatus.clear()
    }

    fun updateMuteNotification(type: String) {
        for (i in selectedRecentChats.indices) {
            val recentChat = selectedRecentChats[i]
            try {
                if (!recentChat.isBroadCast) {
                    FlyCore.updateChatMuteStatus(recentChat.jid, type == Constants.MUTE_NOTIFY)
                }
            } catch (e: Exception) {
                LogMessage.e(Constants.TAG, e)
            }
        }
    }

    fun createPinShortcutForRecentChat(context: Context) {
        for (i in selectedRecentChats.indices)
            if (!selectedRecentChats[i].isBroadCast) {
                dynamicAppShortcuts(context, selectedRecentChats[i].jid, selectedRecentChats[i].getChatType())
            }
    }

    fun getArchivedChats() {
        LogMessage.d(TAG, "getAllChats() called to update the UI")
        viewModelScope.launch(Main.immediate) {
            FlyCore.getArchivedChatList(FlyCallback { isSuccess, _, data ->
                if (isSuccess) {
                    chatList.value = LinkedList(data["data"] as MutableList<RecentChat>)
                    chatList.value!!.add(0, RecentChat()) // Recent Chat Header
                    chatList.value!!.add(chatList.value!!.size, RecentChat()) // Recent Chat Footer
                    chatList.value!!.add(chatList.value!!.size, RecentChat()) // Recent Chat Footer
                    getChatDiffResult()
                }
            })
        }
    }

    fun getArchiveChatOfUser(jid: String, @RecentChatEvent event: String) {
        viewModelScope.launch {
            val recent = FlyCore.getRecentChatOf(jid)
            if (recent != null && recent.isChatArchived) {
                //update view model list
                val index = chatList.value!!.indexOfFirst { it.jid == recent.jid }
                val positionToAdd = getArchivePosition(recent.jid, event)
                if (index.isValidIndex()) {
                    chatAdapter.removeAt(index)
                    chatAdapter.add(positionToAdd, recent)
                    chatList.value!!.removeAt(index)
                    chatList.value!!.add(positionToAdd, recent)
                } else {
                    chatList.value!!.add(positionToAdd, recent)
                    chatAdapter.add(positionToAdd, recent)
                }

                chats.value = Triple(event, index, positionToAdd)
            }
        }
    }

    /**
     * This method will return the position of chat
     */
    private fun getArchivePosition(jid: String, @RecentChatEvent event: String): Int {
        return if (event == RecentChatEvent.MESSAGE_RECEIVED) {
            1 //Recent Chat header will be always 0
        } else {
            val index = this.chatAdapter.indexOfFirst { it.jid == jid }
            if (index.isValidIndex()) index else 1 //Recent Chat header will be always 0
        }
    }

    fun updateArchivedMuteNotification(type: String) {
        for (i in selectedChats.indices) {
            try {
                val recentChat = selectedChats[i]
                if (!recentChat.isBroadCast) {
                    FlyCore.updateChatMuteStatus(recentChat.jid, type == Constants.MUTE_NOTIFY)
                }
            } catch (e: Exception) {
                LogMessage.e(Constants.TAG, e)
            }
        }
    }

    /**
     * Updating archived chats when search key updated
     */
    fun filterArchivedChatList(searchKey: String) {
        viewModelScope.launch {
            val archivedChatList = mutableListOf<RecentChat>()
            for (archivedChat in chatAdapter)
                if (archivedChat.profileName != null && archivedChat.profileName.contains(searchKey, true))
                    archivedChatList.add(archivedChat)
            filterArchivedChatList.value = archivedChatList
        }
    }

    fun clearUnreadCount(item: RecentChat, itemPos: Int) {
        viewModelScope.launch(IO) {
            if (item.isConversationUnRead) {
                item.unreadMessageCount = 0
                item.isConversationUnRead = false
                recentChatList.value!![itemPos] = item

                android.os.Handler(Looper.getMainLooper()).postDelayed({
                    getRecentChatDiffResult() }, 100)
            }
        }
    }


    fun getArchivedChatStatus() {
        viewModelScope.launch(IO) {
            FlyCore.getArchivedChatList { isSuccess, _, data ->
                if (isSuccess) {
                    val archiveChats = data["data"] as MutableList<RecentChat>
                    if (archiveChats.isNotEmpty()) {
                        val isArchiveSettingsEnable = FlyCore.isArchivedSettingsEnabled()
                        archiveChatStatus.postValue(Triple(first = true, second = isArchiveSettingsEnable, third = getArchivedChatCount(archiveChats, isArchiveSettingsEnable)))
                    } else {
                        archiveChatStatus.postValue(Triple(first = false, second = false, third = 0))
                    }
                }
            }
        }
    }

    private fun getArchivedChatCount(archiveChats: MutableList<RecentChat>, isArchiveSettingsEnable: Boolean): Int {
        var unreadCount = 0
        if (isArchiveSettingsEnable)
            archiveChats.forEach { if (it.isConversationUnRead) unreadCount++ }
        else
            unreadCount = archiveChats.size
        return unreadCount
    }

    fun getArchivedSettingsStatus(status: Boolean) {
        viewModelScope.launch {
            archivedSettingsStatus.value = status
        }
    }

    fun updateArchiveChatsStatus(toUser: String, archiveStatus: Boolean) {
        archiveChatUpdated.value = Pair(toUser, archiveStatus)
    }

    fun updateArchiveChatsList(selectedJids: MutableList<String>) {
        selectedArchiveChats.value = selectedJids
    }

    fun updateSearchLanguage(searchKey: String) {
        updateLanguageSearch.postValue(searchKey)
    }

    fun updateFeatureRestriction(feature:Features){
        availableFeatureLiveData.postValue(feature)
    }

    fun updateClearAllCallLogMenu() {
        clearallCallLog.postValue(true)
    }
}