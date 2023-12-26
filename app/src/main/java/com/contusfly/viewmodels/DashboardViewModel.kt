package com.contusfly.viewmodels

import android.Manifest
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
import com.contusfly.utils.ContactUtils
import com.contusfly.utils.ContusContactUtils
import com.contusfly.utils.MediaPermissions
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
    val privateChatStatus = MutableLiveData<Boolean>()
    val archivedSettingsStatus = MutableLiveData<Boolean>()
    val busySettingsStatus = MutableLiveData<Boolean>()
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
     * contacts count from preference
     */
    var mContactCount: Int = 0
    /**
     * Recent Chat Adapter Value
     */
    val chatAdapter by lazy { LinkedList<RecentChat>() }
    val recentChatAdapter: LinkedList<RecentChat> by lazy { LinkedList<RecentChat>() }
    val filterArchivedChatList = MutableLiveData<List<RecentChat>>()

    /* = = = = = = = = Profile Data = = = = = = = = */
    val contactSyncNeeded = MutableLiveData<Boolean>()
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
    val filterContactProfileList = MutableLiveData<List<ProfileDetails>>()
    val filterProfileList = MutableLiveData<List<ProfileDetailsShareModel>>()
    private var searchList = mutableListOf<ProfileDetailsShareModel>()


    val isUserBlockedUnblockedMe = MutableLiveData<Pair<String, Boolean>>()
    val isUserBlockedByAdmin = MutableLiveData<Pair<String, Boolean>>()

    /**
     * contact refreshing status
     */
    private var isRefreshing: Boolean = false

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

    /*
   * Get Recent Chats list */
    fun getRecentChats() {
        LogMessage.d(TAG, "#dashboard #recent getRecentChats() called to update the UI")
        viewModelScope.launch(Dispatchers.Main.immediate) {
            if (recentChatList.value == null && !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.PIN_SCREEN)) {
                LogMessage.d(TAG, "#dashboard #recent getRecentChats initial")
                recentChatList.value = LinkedList(FlyCore.getRecentChatList())
                recentChatList.value!!.add(0, RecentChat()) // Private Chat Header
                recentChatList.value!!.add(1, RecentChat()) // Recent Chat Header
                recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer
                recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader
                recentChatAdapter.clear()
                LogMessage.d(TAG, "#dashboard #recent getRecentChats() size:${recentChatList.value!!.size}")
                recentChatAdapter.addAll(recentChatList.value!!)
                recentChatDiffResult.value = null
            } else {
                LogMessage.d(TAG, "#dashboard #recent getRecentChats data present!!")
                FlyCore.getRecentChatList { isSuccess, _, data ->
                    if (isSuccess) {
                        recentChatList.value = LinkedList(data[SDK_DATA] as MutableList<RecentChat>)
                        recentChatList.value!!.add(0, RecentChat()) // Private Chat Header
                        recentChatList.value!!.add(1, RecentChat()) // Recent Chat Header
                        recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer
                        recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader
                        getRecentChatDiffResult()
                    }
                }
            }
        }
    }

    fun getRestartActivitygetrecentChatList() {

        restartactivityRecentChatListlivedata.value=true
    }

    fun chatHistoryMigration() {
        var fetchedPageNumber=
            com.mirrorflysdk.flycommons.SharedPreferenceManager.instance.getInt(RECENT_CHAT_FETCHED_PAGE_NUMBER)
        if(recentChatAdapter.size == 0 && fetchedPageNumber == 0) {
            getInitialChatList()
        }
    }


    private fun setSwipeLoader(isShowStatus:Boolean){
        CoroutineScope(Dispatchers.Main).launch {
            swipeRefreshLoader.value = isShowStatus
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
        LogMessage.d(TAG, "#dashboard #recent getInitialChatList() called to update the UI")
        setSwipeLoader(true)
        setRecentChatListFetching(true)
        val isChatHistoryEnabled = ChatManager.getAvailableFeatures().isChatHistoryEnabled && ChatManager.chatHistoryEnabled()
        val fetchedPageNumber = com.mirrorflysdk.flycommons.SharedPreferenceManager.instance.getInt(RECENT_CHAT_FETCHED_PAGE_NUMBER)
        viewModelScope.launch(if (isChatHistoryEnabled && fetchedPageNumber == 0) IO else Main.immediate) {
            try {
                recentChatListParams = RecentChatListParams().apply { limit = recentChatLimit }
                recentChatListBuilder = RecentChatListBuilder(recentChatListParams)
                recentChatListBuilder.loadRecentChatList { isSuccess, _, data ->
                    if (isSuccess) {
                        LogMessage.d(TAG, "#recent #dashboard getInitialChatList loadRecentChatList success ")
                        if (recentChatList.value == null && !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.PIN_SCREEN)) {
                            LogMessage.d(TAG, "#recent #dashboard getInitialChatList PIN_SCREEN not enabled ")
                            recentChatList.value =
                                LinkedList(data[SDK_DATA] as MutableList<RecentChat>)
                            recentChatList.value!!.add(0, RecentChat()) // Private Chat Header
                            recentChatList.value!!.add(1, RecentChat()) // Recent Chat Header
                            recentChatList.value!!.add(
                                recentChatList.value!!.size,
                                RecentChat()
                            ) // Recent Chat Footer
                            recentChatList.value!!.add(
                                recentChatList.value!!.size,
                                RecentChat()
                            ) // Recent Chat Pagination Loader
                            recentChatAdapter.clear()
                            recentChatAdapter.addAll(recentChatList.value!!)
                            recentChatDiffResult.value = null
                        } else {
                            LogMessage.d(TAG, "#recent #dashboard loadRecentChatList failed ")
                            recentChatList.value =
                                LinkedList(data[SDK_DATA] as MutableList<RecentChat>)
                            recentChatList.value!!.add(0, RecentChat()) // Private Chat Header
                            recentChatList.value!!.add(1, RecentChat()) // Recent Chat Header
                            recentChatList.value!!.add(
                                recentChatList.value!!.size,
                                RecentChat()
                            ) // Recent Chat Footer
                            recentChatList.value!!.add(
                                recentChatList.value!!.size,
                                RecentChat()
                            ) // Recent Chat Pagination Loader
                            getRecentChatDiffResult()
                        }
                        checkArchiveChatStatus()
                    } else {
                        LogMessage.d(TAG, "#recent #dashboard getInitialChatList loadRecentChatList failed!!")
                        failureDataHandle(data)
                    }
                    setRecentChatListFetching(false)
                    setSwipeLoader(false)
                }
            } catch (e: Exception) {
                LogMessage.e(
                    TAG,
                    "#dashboard #reccent Recent Chat List loading issue in nextSetOfRecentChatList() ==> Exception: ${e.message}"
                )
                setRecentChatListFetching(false)
                setSwipeLoader(false)
            }
        }
    }

    private fun failureDataHandle(data: HashMap<String, Any>) {
        try {
            viewModelScope.launch(Main.immediate){
                if (data.getHttpStatusCode() == 800) {
                    fetchingError.value = true
                }
            }
        } catch(e:Exception) {
            com.contusfly.utils.LogMessage.e(TAG,e.toString())
        }

    }

    private fun checkArchiveChatStatus(){
        if(ChatManager.getAvailableFeatures().isChatHistoryEnabled && ChatManager.chatHistoryEnabled())
            getArchivedChatStatus()
    }

    fun refreshFetchedRecentChat() {
        LogMessage.d(TAG, "#dashboard #recent refreshFetchedRecentChat() called to update the UI")
        var prefetchedRecentChats = recentChatAdapter.size - 4 // calculate recent chat has prefetched data by skipping header and footer and loader
        if (prefetchedRecentChats < Constants.RECENT_CHAT_LIST_LIMIT)
            prefetchedRecentChats = Constants.RECENT_CHAT_LIST_LIMIT
        getInitialChatList(prefetchedRecentChats)
    }

    fun getChatTagData() {
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
            recentChatList.value!!.add(0, RecentChat()) // Private Chat Header
            recentChatList.value!!.add(1, RecentChat()) // Recent Chat Header
            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer
            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader item
            recentChatAdapter.clear()
            recentChatAdapter.addAll(recentChatList.value!!)
            recentChatDiffResult.value = null
        }
    }


    fun nextSetOfRecentChatList() {
        LogMessage.d(TAG, "#recent nextSetOfRecentChatList() called to update the UI with next set of list---${getRecentChatListFetching()}")
        paginationLoaderShowHide(true)
        setRecentChatListFetching(true)
        var isChatHistoryEnabled=ChatManager.getAvailableFeatures().isChatHistoryEnabled
        viewModelScope.launch(if(isChatHistoryEnabled) IO else Main.immediate) {
            try {
                recentChatListBuilder.nextSetOfData { isSuccess, _, data ->
                    if (isSuccess) {
                        try {
                            LogMessage.d(TAG, "#recent nextSetOfData isSuccess")
                            updateRecentChats(data)
                        } catch (e: Exception) {
                            LogMessage.e(TAG, "#recent Recent Chat List loading issue in nextSetOfRecentChatList() ==> Exception: ${e.message}")
                        }
                    } else {
                        LogMessage.d(TAG, "#recent nextSetOfData failureDataHandle")
                        failureDataHandle(data)
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

    private fun updateRecentChats(data: HashMap<String, Any>) {
        LogMessage.d(TAG, "#recent updateRecentChats")
        val recentChats = data[SDK_DATA] as MutableList<RecentChat>
        if(recentChats.size > 0){
            LogMessage.d(TAG, "#recent recentChats not empty!! ${recentChats.size}")
            LogMessage.d(TAG, "#recent recentChatAdapter  ${recentChatAdapter.size}")
            val recentChatSize = recentChatAdapter.size
            recentChatList.value!!.removeAt(recentChatList.value!!.size - 1) // Recent Chat Footer item removed
            recentChatAdapter.removeAt(recentChatAdapter.size - 1) // Recent Chat Footer item removed
            recentChatList.value!!.removeAt(recentChatList.value!!.size - 1) // Recent Chat Pagination item removed
            recentChatAdapter.removeAt(recentChatAdapter.size - 1) // Recent Chat Pagination item removed
            notifyRecentChatRemoved.postValue(recentChatAdapter.size)
            recentChatList.value!!.addAll(LinkedList(recentChats))
            recentChatAdapter.addAll(recentChats)
            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Footer item adding
            recentChatAdapter.add(recentChatAdapter.size, RecentChat()) // Recent Chat Footer item adding
            recentChatList.value!!.add(recentChatList.value!!.size, RecentChat()) // Recent Chat Pagination item adding
            recentChatAdapter.add(recentChatAdapter.size, RecentChat()) // Recent Chat Pagination item adding
            notifyRecentChatInserted.postValue(Pair(recentChatSize, recentChats.size))
            getArchivedChatStatus()
        }
    }

    private fun paginationLoaderShowHide(isShow:Boolean) {
        viewModelScope.launch(Main) {
            paginationLoader.value = isShow
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
        LogMessage.d(TAG, "#dashboard #recent  getRecentChatDiffResult: ")
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

    fun filterDeviceContactsList(searchKey: String, jidList: java.util.ArrayList<String>) {
        viewModelScope.launch {
            val contusContacts = ContusContactUtils.getContusContacts()
            FlyCore.getRegisteredUsers(false) { isSuccess, _, data ->
                if (isSuccess) {
                    val profileDetails = data[SDK_DATA] as MutableList<ProfileDetails>
                    profileDetails.forEach { contact ->
                        val index = contusContacts.indexOfFirst { it.jid == contact.jid }
                        if (index.isValidIndex())
                            contusContacts.removeAt(index)
                    }
                    profileDetails.addAll(contusContacts)
                    filterContactProfileList.value = profileDetails.filter { !jidList.contains(it.jid) && !it.isAdminBlocked && it.getDisplayName().contains(searchKey, true) }.sortedBy { it.getDisplayName() }
                }
            }
        }
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
                LogMessage.d(TAG, "#dashboard #recent  getRecentChatOfUser: $jid")
                val recent = FlyCore.getRecentChatOf(jid)
                if (recent != null && !recent.isChatArchived && !recent.isChatLocked && recent.lastMessageTime>0) {
                    //update view model list
                    val index = recentChatAdapter.indexOfFirst { it.jid == recent.jid }
                    val positionToAdd = getRecentPosition(recent.jid, recent, event)
                    LogMessage.d(TAG, "#dashboard #recent  getRecentChatOfUser: isChatArchived  isChatLocked not")
                    LogMessage.d(TAG, "#dashboard #recent  index: $index")
                    LogMessage.d(TAG, "#dashboard #recent  positionToAdd: $positionToAdd")
                    if (index.isValidIndex()) {
                        LogMessage.d(TAG, "#dashboard #recent  validIndex!!")
                        recentChatList.value!!.removeAt(index)
                        recentChatList.value!!.add(positionToAdd, recent)
                        recentChatAdapter.removeAt(index)
                        recentChatAdapter.add(positionToAdd, recent)
                    } else {
                        LogMessage.d(TAG, "#dashboard #recent  notValid positionToAdd:$positionToAdd")
                        recentChatList.value!!.add(positionToAdd, recent)
                        recentChatAdapter.add(positionToAdd, recent)
                    }
                    recentChat.value = Triple(event, index, positionToAdd)
                } else {
                    //update view model list
                    val index = recentChatAdapter.indexOfFirst { it.jid == jid }
                    LogMessage.d(TAG, "#dashboard #recent  getRecentChatOfUser: else index: $index")
                    if (index.isValidIndex()) {
                        recentChatList.value!!.removeAt(index)
                        recentChatAdapter.removeAt(index)
                        recentDeleteChatPosition.value = index
                        LogMessage.d(TAG, "#dashboard #recent  getRecentChatOfUser: removed!!")
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
        recentPinnedCount = FlyCore.recentChatPinnedCount()
        return if (event == RecentChatEvent.MESSAGE_RECEIVED) {
            if (recent.isChatPinned) {
                val index = this.recentChatAdapter.indexOfFirst { it.jid == jid }
                if (index.isValidIndex()) index else 2 //Recent Chat private chat position 0 and Header position 1
            } else
                recentPinnedCount + 2 //Recent Chat header will be always 0
        } else if (event == RecentChatEvent.ARCHIVE_EVENT) {
            getArchiveRecentPosition(recent)
        } else {
            val index = this.recentChatAdapter.indexOfFirst { it.jid == jid }
            if (index.isValidIndex()) index else 2 //Recent Chat private chat position 0 and Header position 1
        }
    }

    private fun getArchiveRecentPosition(recent: RecentChat): Int {
        val index = this.recentChatAdapter.indexOfFirst { !it.jid.isNullOrBlank() && it.lastMessageTime <= recent.lastMessageTime }
        return if (index.isValidIndex()) index else 2 //Recent Chat private chat position 0 and Header position 1
    }

    fun filterRecentChatList(searchKey: String) {
        viewModelScope.launch {
            val recentChatList = mutableListOf<RecentChat>()
            val recentChatListWithArchived = FlyCore.getRecentChatListIncludingArchived()
            for (recentChat in recentChatListWithArchived) {
                if (BuildConfig.CONTACT_SYNC_ENABLED) {
                    when {
                        isSavedContact(recentChat, searchKey) -> {
                            recentChatList.add(recentChat)
                        }
                        isEmailContact(recentChat, searchKey) -> {
                            recentChatList.add(recentChat)
                        }
                    }
                } else {
                    if (recentChat.getDisplayName().contains(searchKey, true))
                        recentChatList.add(recentChat)
                }
            }
            filterRecentChatList.value = recentChatList
        }
    }

    private fun isEmailContact(recentChat: RecentChat, searchKey: String): Boolean {
        val profileDetails = ProfileDetailsUtils.getProfileDetails(recentChat.jid, true)
        return recentChat.isEmailContact() && profileDetails != null && profileDetails.getDisplayName().contains(searchKey, true)
    }

    private fun isSavedContact(recentChat: RecentChat, searchKey: String): Boolean {
        return !recentChat.isUnknownContact() && !recentChat.isDeletedContact() && recentChat.getDisplayName().contains(searchKey, true)
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
            if (position - 2 >= recentPinnedCount) // check, is non pinned item
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


    /**
     * Updating db once the recent private chat is read
     */
    fun markAsReadPrivateChats(context: Context) {
        val jidList = ArrayList<String>()
        for (selectedRecentChat in selectedChats) {
            jidList.add(selectedRecentChat.jid)
        }
        FlyCore.markConversationAsRead(jidList)
        jidList.clear()
        for (selectedRecentChat in selectedChats) {
            AppNotificationManager.clearConversationOnNotification(context, selectedRecentChat.jid)
            val recentListPosition = chatList.value!!.indexOfFirst { it.jid == selectedRecentChat.jid }
            val recent = FlyCore.getRecentChatOf(selectedRecentChat.jid)
            if (recent != null) {
                chatList.value!![recentListPosition] = recent
                chatAdapter[recentListPosition] = recent
                _changedReadUnReadPosition.value = recentListPosition
            }
        }

        if (selectedChats.size == 1) _showMessage.value = "Chat marked as read"
        else if (selectedChats.size > 1) _showMessage.value = "Chats marked as read"
    }

    fun markAsUnreadPrivateChats() {
        val jidList = ArrayList<String>()
        for (selectedRecentChat in selectedChats) {
            jidList.add(selectedRecentChat.jid)
        }
        FlyCore.markConversationAsUnread(jidList)
        jidList.clear()
        for (selectedRecentChat in selectedChats) {
            val recentListPosition = chatList.value!!.indexOfFirst { it.jid == selectedRecentChat.jid }
            val recent = FlyCore.getRecentChatOf(selectedRecentChat.jid)
            if (recent != null) {
                chatList.value!![recentListPosition] = recent
                chatAdapter[recentListPosition] = recent
                _changedReadUnReadPosition.value = recentListPosition
            }
        }

        if (selectedChats.size == 1) _showMessage.value = "Chat marked as unread"
        else if (selectedChats.size > 1) _showMessage.value = "Chats marked as unread"
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
        LogMessage.d(TAG, "#dashboard #recent  updateUnReadChatCount")
        viewModelScope.launch {
            unreadChatCountLiveData.value = FlyMessenger.getUnreadMessagesCount()
        }
    }

    fun setReceivedMsg(msg: ChatMessage?) {
        LogMessage.d(TAG, "#dashboard #recent  onMessageReceived: $msg")
        getRecentChatOfUser(msg!!.chatUserJid, RecentChatEvent.MESSAGE_RECEIVED)
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
        LogMessage.d(TAG, "#dashboard getAllChats() called to update the UI")
        viewModelScope.launch(Main.immediate) {
            FlyCore.getArchivedChatList(FlyCallback { isSuccess, _, data ->
                if (isSuccess) {
                    chatList.value = LinkedList(data["data"] as MutableList<RecentChat>)
                    chatList.value!!.add(0, RecentChat()) // Private Chat Header
                    chatList.value!!.add(1, RecentChat()) // Recent Chat Header
                    chatList.value!!.add(chatList.value!!.size, RecentChat()) // Recent Chat Footer
                    chatList.value!!.add(chatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader
                    LogMessage.v(TAG, "#dashboard #chat #group getArchivedChatList ${chatList.value!!.size}")
                    getChatDiffResult()
                }
            })
        }
    }


    fun getPrivateChatOfUser(jid: String, @RecentChatEvent event: String) {
        try {
            viewModelScope.launch {
                val recent = FlyCore.getRecentChatOf(jid)
                if (recent != null && recent.isChatLocked) {
                    //update view model list
                    val index = chatList.value!!.indexOfFirst { it.jid == recent.jid }
                    val positionToAdd = getPrivateChatPosition(recent.jid, event)
                    if (index.isValidIndex()) {
                        validPrivateChatUser(index,positionToAdd,recent)
                    } else {
                        inValidPrivateChatUser(positionToAdd, recent)
                    }
                    chats.value = Triple(event, index, positionToAdd)
                }
            }
        } catch (indexOutOfBound:ArrayIndexOutOfBoundsException) {
            LogMessage.e(indexOutOfBound)
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    private fun validPrivateChatUser(index: Int, positionToAdd: Int, recent: RecentChat) {
        chatAdapter.removeAt(index)
        chatAdapter.add(positionToAdd, recent)
        chatList.value!!.removeAt(index)
        chatList.value!!.add(positionToAdd, recent)
    }

    private fun inValidPrivateChatUser(positionToAdd: Int, recent: RecentChat) {
        chatList.value!!.add(positionToAdd, recent)
        chatAdapter.add(positionToAdd, recent)
    }

    /**
     * This method will return the position of chat
     */
    private fun getPrivateChatPosition(jid: String, @RecentChatEvent event: String): Int {
        return if (event == RecentChatEvent.MESSAGE_RECEIVED) {
            2 // Private chat and Archive chat position already added so i will start position 2
        } else {
            val index = this.chatAdapter.indexOfFirst { it.jid == jid }
            if (index.isValidIndex()) index else 2 //Private chat and Archive chat position already added so i will start position 2
        }
    }


    fun getArchiveChatOfUser(jid: String, @RecentChatEvent event: String) {
        try {
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
        } catch (indexOutOfBound:ArrayIndexOutOfBoundsException) {
            LogMessage.e(indexOutOfBound)
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * This method will return the position of chat
     */
    private fun getArchivePosition(jid: String, @RecentChatEvent event: String): Int {
        return if (event == RecentChatEvent.MESSAGE_RECEIVED) {
            2 //Recent Chat header will be always 0
        } else {
            val index = this.chatAdapter.indexOfFirst { it.jid == jid }
            if (index.isValidIndex()) index else 2 //Recent Chat header will be always 0
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
                if (archivedChat.getDisplayName() != null && archivedChat.getDisplayName().contains(searchKey, true))
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
        LogMessage.d(TAG, "#dashboard #recent  getArchivedChatStatus!!")
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

    fun getPrivateChatStatus() {
        viewModelScope.launch(IO) {
            ChatManager.getPrivateChatList { isSuccess, _, data ->
                if (isSuccess) {
                    val privateChats = data["data"] as MutableList<RecentChat>
                    LogMessage.d(TAG, "#dashboard #privateChat  getPrivateChatList isSuccess ${privateChats.size}")
                    if (privateChats.isNotEmpty()) {
                        privateChatStatus.postValue(true)
                    } else {
                        privateChatStatus.postValue(false)
                    }
                }
            }
        }
    }

    fun getPrivateChats() {
        LogMessage.d(TAG, "getAllChats() called to update the UI")
        viewModelScope.launch(Main.immediate) {
            ChatManager.getPrivateChatList(FlyCallback { isSuccess, _, data ->
                if (isSuccess) {
                    chatList.value = LinkedList(data["data"] as MutableList<RecentChat>)
                    chatList.value!!.add(0, RecentChat()) // Private Chat Header
                    chatList.value!!.add(1, RecentChat()) // Recent Chat Header
                    chatList.value!!.add(chatList.value!!.size, RecentChat()) // Recent Chat Footer
                    chatList.value!!.add(chatList.value!!.size, RecentChat()) // Recent Chat Pagination Loader
                    getChatDiffResult()
                }
            })
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
    fun getBusySettingsStatus(status: Boolean) {
        viewModelScope.launch {
            busySettingsStatus.value = status
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

    fun checkAndUpdateContacts() {
        viewModelScope.launch {
            if (!SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.INITIAL_CONTACT_SYNC_DONE)){
                FlyCore.getRegisteredUsers(true) { _, _, _ -> }
            }
        }
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
        LogMessage.d(TAG, "#contact sync success: $success")
        viewModelScope.launch {
            isRefreshing = false
            contactSyncNeeded.value = false
            if (MediaPermissions.isPermissionAllowed(ChatManager.applicationContext, Manifest.permission.READ_CONTACTS)){
                val currentContactCount = ContactUtils.getContactCount(ChatManager.applicationContext)
                SharedPreferenceManager.setInt(ContactUtils.CONTACTS_COUNT, currentContactCount)
            }
        }
    }
}