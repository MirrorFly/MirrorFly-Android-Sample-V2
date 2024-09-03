package com.contusfly.viewmodels

import androidx.lifecycle.*
import com.contusfly.TAG
import com.contusfly.activities.parent.ChatParent
import com.contusfly.getData
import com.contusfly.getDisplayName
import com.contusfly.getMessage
import com.contusfly.isTextMessage
import com.contusfly.isValidIndex
import com.contusfly.models.MeetMessageParams
import com.contusfly.repository.MessageRepository
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CustomToast
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseTextMessage
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.chat.FetchMessageListParams
import com.mirrorflysdk.api.chat.FetchMessageListQuery
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class ChatParentViewModel @Inject
constructor(private val messageRepository: MessageRepository) : ViewModel() {

    /**
     * random generate string for user differentiation
     */
    private val remoteUserId = UUID.randomUUID().toString()

    /**
     * list of smart reply suggestion
     */
    private val suggestions = MediatorLiveData<List<SmartReplySuggestion>>()

    /**
     * input list of message provided to the ML smart reply model
     */
    private val suggestionMessageList = MutableLiveData<List<ChatMessage>>()

    private lateinit var messageListParams : FetchMessageListParams
    private lateinit var messageListQuery : FetchMessageListQuery
    private val paginationMessageList = arrayListOf<ChatMessage>()
    val initialMessageList = MutableLiveData<ArrayList<ChatMessage>>()
    val previousMessageList = MutableLiveData<ArrayList<ChatMessage>>()
    val nextMessageList = MutableLiveData<ArrayList<ChatMessage>>()
    val replynextMessageList = MutableLiveData<ArrayList<ChatMessage>>()
    val replyprevMessageList = MutableLiveData<ArrayList<ChatMessage>>()
    val loadSuggestion = MutableLiveData<Boolean>()
    val removeTempDateHeader = MutableLiveData<Boolean>()
    val searchKeyData = MutableLiveData<String>()
    val swipeRefreshLoader = MutableLiveData<Boolean>()
    val meetMessageData = MutableLiveData<MeetMessageParams>()
    val unReadMessageAvailable = MutableLiveData<ArrayList<ChatMessage>>()

    private var toUser: String? = null

    val groupParticipantsName = MutableLiveData<String>()

    /**
     * get the message given to the smart reply
     *
     * @return
     */
    val messages: LiveData<List<ChatMessage>>
        get() = suggestionMessageList

    /**
     * constructor for the class
     *
     *
     * This class is to initiate suggestion generator
     */
    init {
        initSuggestionsGenerator()
    }

    companion object {
        private const val SMART_REPLY_EXCEPTION = "Not running smart reply!"
    }

    /**
     * get the suggestion from the ML smart reply api
     *
     * @return
     */
    fun getSuggestions(): LiveData<List<SmartReplySuggestion>> {
        return suggestions
    }

    /**
     * add message to the Ml model
     *
     * @param message add the received and sent messages
     */
    fun addMessage(message: ChatMessage?, toUser: String) {
        this.toUser = toUser
        var list: MutableList<ChatMessage>? = suggestionMessageList.value as MutableList<ChatMessage>?
        if (list == null)
            list = ArrayList()
        if (message != null) {
            list.add(message)
            suggestionMessageList.postValue(list)
        }
    }

    /**
     * clear the suggestions
     */
    fun clearSuggestions() {
        suggestions.postValue(ArrayList())
    }

    fun removeMessages() {
        paginationMessageList.clear()
        suggestionMessageList.postValue(ArrayList())
    }

    /**
     * initialise the suggestion generator
     */
    private fun initSuggestionsGenerator() {
        suggestions.addSource(suggestionMessageList) { list ->
            if (list.isNotEmpty())
                generateReplies(list).addOnSuccessListener { result ->
                    suggestions.postValue(result)
                }
        }
    }

    /**
     * task for generating the suggestions
     *
     * @param messages list of messages given to the ml kit
     * @return reply suggestions
     */
    private fun generateReplies(messages: List<ChatMessage>?): Task<List<SmartReplySuggestion>> {
        if (messages != null && messages.isNotEmpty()) {
            LogMessage.d("TAG", messages.size.toString())
            val lastMessage = messages[messages.size - 1]
            if (lastMessage.isMessageSentByMe
                    || !lastMessage.isTextMessage()
                    || lastMessage.isMessageRecalled
            ) {
                LogMessage.d("smartReply", SMART_REPLY_EXCEPTION)
                return Tasks.forException(Exception(SMART_REPLY_EXCEPTION))
            } else if (lastMessage.chatUserJid != null && lastMessage.chatUserJid == toUser) {
                return createSmartReply(lastMessage)
            }
        }
        return Tasks.forException(Exception(SMART_REPLY_EXCEPTION))
    }

    private fun createSmartReply(lastMessage: ChatMessage): Task<List<SmartReplySuggestion>> {
        val chatHistory = ArrayList<FirebaseTextMessage>()
        if (lastMessage.chatUserJid == SharedPreferenceManager.getCurrentUserJid() && lastMessage.isMessageSentByMe)
            chatHistory.add(FirebaseTextMessage.createForLocalUser(lastMessage.messageTextContent, System.currentTimeMillis()))
        else
            chatHistory.add(FirebaseTextMessage.createForRemoteUser(lastMessage.messageTextContent, System.currentTimeMillis(), remoteUserId))
        return FirebaseNaturalLanguage.getInstance().smartReply
            .suggestReplies(chatHistory).continueWith { task -> task.result!!.suggestions }
    }

    private lateinit var toUserJid: String

    fun setUnSentMessageForAnUser(jid: String, unsentMessage: String) = FlyMessenger
            .saveUnsentMessage(jid, unsentMessage)

    fun getUnSentMessageForAnUser(jid: String) = FlyMessenger.getUnsentMessageOfAJid(jid)


    fun handleActionMenuVisibility(messageIds: ArrayList<String>): HashMap<String, Boolean> = messageRepository
            .handleActionMenuVisibilityValidation(messageIds)

    fun setUserJid(jid: String) {
        toUserJid = jid
    }

    fun getMessagesAfterThisMessage(jid: String, time: Long, messageList: ArrayList<ChatMessage>): List<ChatMessage> {
        return messageRepository.getMessagesAfter(jid, time, messageList)
    }

    fun hasUserStarredAnyMessage(jid: String) = messageRepository.hasUserStarredAnyMessage(jid)

    fun isMessagesCanBeRecalled(messageIds: ArrayList<String>) = messageRepository.isRecallAvailableForGivenMessages(messageIds)
    fun isMessagesCanBeEdited(messageIds: String) = messageRepository.isEditAvailableForGivenMessages(messageIds)

    fun getMessageForId(jid: String) = messageRepository.getMessageForId(jid)

    fun getMessageForReply(jid: String) = messageRepository.getMessageForReply(jid)

    fun getRecalledMessageForThisUser(jid: String): List<String> = messageRepository.getRecalledMessageOfAnUser(jid)

    fun deleteUnreadMessageSeparator(jid: String) = messageRepository.deleteUnreadMessageSeparator(jid)

    fun getProfileDetails(jid: String): ProfileDetails? = ProfileDetailsUtils.getProfileDetails(jid)

    fun isGroupUserExist(groupId: String, jid: String): Boolean = ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupId, jid)

    fun getParticipantsNameAsCsv(jid: String) {
        LogMessage.d("CHAT_ACTIVITY","participate fetching..")
            GroupManager.getGroupMembersList(false, jid) { isSuccess, _, data ->
                if (isSuccess) {
                    CoroutineScope(Dispatchers.IO).launch {
                        val participantsNameList: MutableList<String> = ArrayList()
                        var groupsMembersProfileList: MutableList<ProfileDetails> = data[Constants.SDK_DATA] as MutableList<ProfileDetails>
                        groupsMembersProfileList = ProfileDetailsUtils.sortGroupProfileList(groupsMembersProfileList)
                        groupsMembersProfileList.forEach {
                            if(!it.jid.equals(SharedPreferenceManager.getCurrentUserJid()))
                                participantsNameList.add(it.getDisplayName())
                        }
                        groupParticipantsName.postValue(participantsNameList.sorted().joinToString(","))
                    }
                }
            }

    }

    fun clearChat() {
        initialMessageList.value?.clear()
    }

    private fun setSwipeLoader(isShowStatus:Boolean){
        CoroutineScope(Dispatchers.Main).launch {
            swipeRefreshLoader.value = isShowStatus
        }
    }

    fun constructMeetMessageData(mScheduledDateTime: Long, mMeetLink: String) {
        val meetMessageParams = MeetMessageParams(link = mMeetLink, scheduleMeetDateTime =  mScheduledDateTime )
        meetMessageData.postValue(meetMessageParams)
    }

    fun loadInitialData(loadFromMessageId: String) {

        LogMessage.d("TAG","#chat #fetchmsg loadInitialData loadFromMessageId:$loadFromMessageId toUserJid:$toUserJid")

        setSwipeLoader(true)
        viewModelScope.launch {
            messageListParams = FetchMessageListParams().apply {
                chatJid = toUserJid
                limit = Constants.MESSAGE_LOAD_LIMIT
                messageId = if(ChatParent.isFromStarredMessages) loadFromMessageId else Constants.EMPTY_STRING
                inclusive = true
                ascendingOrder = false
            }
            messageListQuery = FetchMessageListQuery(messageListParams)
            messageListQuery.loadMessages { isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    LogMessage.d("TAG","#chat #fetchmsg loadInitialData loadMessages isSuccess")
                    LogMessage.d("TAG","#chat #fetchmsg loadInitialData loadMessages messageList size:${messageList.size}")
                    paginationMessageList.clear()
                    paginationMessageList.addAll(messageRepository.getMessageListWithDate(messageList))
                    initialMessageList.postValue(paginationMessageList)
                    sendSeenReceipt()
                    if (ChatParent.isFromStarredMessages) {
                        loadNextMessage(Constants.EMPTY_STRING, false)
                    } else {
                        loadPreviousMessage()
                    }
                    loadSuggestion.postValue(!isLoadNextAvailable())
                } else {
                    messageGettingFailure(data)
                }
                setSwipeLoader(false)
            }
        }
    }

    private fun loadprevORnextMessagesLoad(isReplyMessage:Boolean) {
        if(messageListParams.ascendingOrder) {
            loadPreviousMessage()
        } else {
            loadNextMessage(Constants.EMPTY_STRING,isReplyMessage)
        }
    }

    private fun messageGettingFailure(data: HashMap<String, Any>) {
        LogMessage.d("TAG","#chat loadInitialData loadMessages messageGettingFailure")
        CoroutineScope(Dispatchers.Main).launch {
            if(data.getMessage() != null && ChatManager.getAvailableFeatures().isChatHistoryEnabled) {
                CustomToast.show(ChatManager.applicationContext, data.getMessage())
            }
        }
    }

    fun loadReplyParentMessages(loadFromMessageId: String){

        LogMessage.d("TAG","#chat loadInitialMessages loadFromMessageId :$loadFromMessageId")

        if(messageListQuery.isFetchingInProgress()){
            return
        }
        if(messageListParams != null) {
            messageListParams.messageId=loadFromMessageId
        }

        viewModelScope.launch {
            messageListQuery.loadMessages { isSuccess, _, data ->
                if (isSuccess) {
                    LogMessage.d("TAG","#chat loadInitialMessages loadLocalMessages isSuccess loadFromMessageId:$loadFromMessageId")
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    paginationMessageList.clear()
                    paginationMessageList.addAll(messageRepository.getMessageListWithDate(messageList))
                    initialMessageList.postValue(paginationMessageList)
                    sendSeenReceipt()
                    if (loadFromMessageId.isNotBlank())
                        loadprevORnextMessagesLoad(true)
                    loadSuggestion.postValue(!isLoadNextAvailable())
                }
            }
        }
    }


    fun loadReplyParentPrevMessages(replyParentMessageId: String){
        if(messageListQuery.isFetchingInProgress()){
            return
        }
        setSwipeLoader(true)
        viewModelScope.launch {
            messageListQuery.loadPreviousMessages { isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    if (messageList.isNotEmpty()) {
                        val previousHeaderId: Long = messageRepository.getDateID(messageList.last())
                        val currentHeaderId: Long = messageRepository.getDateID(paginationMessageList.first())
                        removeTempDateHeader.postValue(currentHeaderId == previousHeaderId)
                        val previousMessages=replyParentPrevMessageadd(messageList)
                        replyprevMessageList.postValue(previousMessages)
                    }
                    isReachedReplyParentMessage(replyParentMessageId)
                } else {
                    setSwipeLoader(false)
                }
            }
        }
    }

    private fun replyParentPrevMessageadd(messageList: ArrayList<ChatMessage>): ArrayList<ChatMessage> {
        val previousMessages = messageRepository.getMessageListWithDate(messageList)
        paginationMessageList.addAll(0, previousMessages)
        return previousMessages
    }

    private fun isReachedReplyParentMessage(loadFromMessageId: String) {
        var messageIDList=ArrayList<String>()
        messageIDList.add(loadFromMessageId)
        var messageList = FlyMessenger.getMessagesUsingIds(messageIDList)
        if(messageList.size > 0) {
            setSwipeLoader(false)
        } else {
            loadReplyParentPrevMessages(loadFromMessageId)
        }
    }

    fun loadInitialMessages(loadFromMessageId: String) {

        LogMessage.d("TAG","#chat loadInitialMessages loadFromMessageId :$loadFromMessageId")

        if(messageListQuery.isFetchingInProgress()){
            return
        }

        viewModelScope.launch {
            messageListQuery.loadMessages { isSuccess, _, data ->
                if (isSuccess) {
                    LogMessage.d("TAG","#chat loadInitialMessages loadLocalMessages isSuccess loadFromMessageId:$loadFromMessageId")

                    val messageList = data.getData() as ArrayList<ChatMessage>
                    paginationMessageList.clear()
                    paginationMessageList.addAll(messageRepository.getMessageListWithDate(messageList))
                    initialMessageList.postValue(paginationMessageList)
                    sendSeenReceipt()
                    if (loadFromMessageId.isNotBlank())
                        loadPreviousData()
                    loadSuggestion.postValue(!isLoadNextAvailable())
                }
            }
        }
    }

    fun loadNextMessage(searchedText: String="",isReplyMessage:Boolean = false) {

        LogMessage.d("TAG","#chat #fetchmsg loadNextMessage  searchedText:$searchedText")

        if(messageListQuery.isFetchingInProgress()){
            return
        }

        viewModelScope.launch {
            messageListQuery.loadNextMessages { isSuccess, _, data ->
                if (isSuccess) {
                    handleNextMessages(data.getData() as ArrayList<ChatMessage>, searchedText, isReplyMessage)
                }
            }
        }
    }

    private fun handleNextMessages(
        messageList: ArrayList<ChatMessage>? = null,
        searchedText: String,
        isReplyMessage: Boolean
    ) {
        LogMessage.d("TAG", "#chat #fetchmsg loadNextMessages  isSuccess")
        if(messageList!=null) {
            val nextMsgList = getNextMessageList(messageList)
            if (nextMsgList.isNotEmpty()) {
                sendSeenReceipt()
                processNextMessages(nextMsgList, isReplyMessage)
                searchDataShare(searchedText, Constants.NEXT_LOAD)
            } else {
                searchDataShare(searchedText, Constants.NO_DATA)
            }
        }
    }

    private fun getNextMessageList(messageList: ArrayList<ChatMessage>): ArrayList<ChatMessage> {
        val nextMsgList = ArrayList<ChatMessage>()
        if (paginationMessageList.isNotEmpty()) {
            val idSet = paginationMessageList.map { it.messageId }.toHashSet()
            for (item in messageList) {
                if (!idSet.contains(item.messageId)) {
                    nextMsgList.add(item)
                } else {
                    LogMessage.d("Message_Pagination", "loadNextMessages  Duplication Found..")
                }
            }
            LogMessage.d("Message_Pagination", "nextmsgList size ${nextMsgList.size}")
            if (nextMsgList.isEmpty()) return nextMsgList
            checkAndUpdateMessageList(nextMsgList)
            return nextMsgList
        } else {
            return messageList
        }
    }

    private fun processNextMessages(nextMsgList: ArrayList<ChatMessage>, isReplyMessage: Boolean) {
        val skipFirstMessage = paginationMessageList.isNotEmpty()
        val nextMessages = messageRepository.getMessageListWithDate(nextMsgList, skipFirstMessage)
        paginationMessageList.addAll(nextMessages)
        postNextValue(isReplyMessage, nextMessages)
    }


    private fun postNextValue(isReplyMessage: Boolean, nextMessages: ArrayList<ChatMessage>){
        if(isReplyMessage) {
            replynextMessageList.postValue(nextMessages)
        } else {
            nextMessageList.postValue(nextMessages)
        }
    }

    fun loadPreviousMessage(searchedText: String="") {

        LogMessage.d("TAG","#chat #fetchmsg loadPreviousMessage  searchedText:$searchedText")

        if(messageListQuery.isFetchingInProgress()){
            return
        }

        setSwipeLoader(true)
        viewModelScope.launch {
            messageListQuery.loadPreviousMessages{ isSuccess, _, data ->
                if (isSuccess) {
                    try {
                        val messageList = data.getData() as ArrayList<ChatMessage>
                        if (messageList.isNotEmpty()) {
                            val currentHeaderId: Long = messageRepository.getDateID(paginationMessageList.first())
                            val previousHeaderId: Long = messageRepository.getDateID(messageList.last())
                            removeTempDateHeader.postValue(currentHeaderId == previousHeaderId)
                            val previousMessages = messageRepository.getMessageListWithDate(messageList)
                            paginationMessageList.addAll(0, previousMessages)
                            previousMessageList.postValue(previousMessages)
                            sendSeenReceipt()
                            unReadMessageAvailable.postValue(messageList)
                            searchDataShare(searchedText,Constants.PREV_LOAD)
                        } else {
                            searchDataShare(searchedText,Constants.NO_DATA)
                        }
                    } catch(e:Exception) {
                        LogMessage.d(TAG,e.toString())
                    }
                }
                setSwipeLoader(false)
            }
        }
    }

    fun loadPreviousData(searchedText: String="") {

        LogMessage.d("TAG","#chat #fetchmsg loadPreviousData  searchedText:$searchedText")

        if(messageListQuery.isFetchingInProgress()){
            return
        }

        viewModelScope.launch {
            messageListQuery.loadPreviousMessages { isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    if (messageList.isNotEmpty()) {

                        LogMessage.d("TAG","#chat #fetchmsg loadLocalPreviousMessages  messageList:${messageList.size}")

                        val currentHeaderId: Long = messageRepository.getDateID(paginationMessageList.first())
                        val previousHeaderId: Long = messageRepository.getDateID(messageList.last())
                        removeTempDateHeader.postValue(currentHeaderId == previousHeaderId)
                        val previousMessages = messageRepository.getMessageListWithDate(messageList)
                        paginationMessageList.addAll(0, previousMessages)
                        previousMessageList.postValue(previousMessages)
                        searchDataShare(searchedText,Constants.PREV_LOAD)
                    } else {
                        searchDataShare(searchedText,Constants.NO_DATA)
                    }
                }
            }
        }
    }

    private fun searchDataShare(searchedText:String,event:String){
        if(searchedText.isNotEmpty())
        searchKeyData.postValue(event)
    }

    fun loadNextData(searchedText: String="",isFetchProgressCheck:Boolean = true) {

        LogMessage.d("TAG","#chat #fetchmsg loadNextData  searchedText:$searchedText")

        if(messageListQuery.isFetchingInProgress() && isFetchProgressCheck) {
            LogMessage.d("TAG","#chat #fetchmsg loadNextData  fetch_inprogress so SKIP..")
            return
        }

        viewModelScope.launch {
            messageListQuery.loadNextMessages { isSuccess, _, data ->
                if (isSuccess) {

                    LogMessage.d("TAG","#chat #fetchmsg loadLocalNextMessages  ")

                    val messageList = data.getData() as ArrayList<ChatMessage>

                    LogMessage.d(TAG,"#chat #fetchmsg loadnextdata size--->"+messageList.size)

                    if (messageList.isNotEmpty()) {
                        sendSeenReceipt()
                        var skipFirstMessage = false
                        if (paginationMessageList.isNotEmpty()) {
                            checkAndUpdateMessageList(messageList)
                            skipFirstMessage = true
                        }
                        val nextMessages = messageRepository.getMessageListWithDate(messageList, skipFirstMessage)
                        paginationMessageList.addAll(nextMessages)
                        nextMessageList.postValue(nextMessages)
                        searchDataShare(searchedText,Constants.NEXT_LOAD)
                    } else {
                        searchDataShare(searchedText,Constants.NO_DATA)
                    }
                }
            }
        }
    }

    private fun sendSeenReceipt(){
        if (ChatManager.getOnGoingChatUser().equals(toUserJid, ignoreCase = true)) {
            ChatManager.markAsRead(toUserJid)
        }
    }

    fun addSentMessage(message: ChatMessage) { //If Sent message time is less than last received message time then it will add to the message list and shown in UI
        paginationMessageList.addAll(arrayListOf(message))
        nextMessageList.postValue(arrayListOf(message))
    }

    private fun checkAndUpdateMessageList(messageList: java.util.ArrayList<ChatMessage>) {
        if (messageList.first().messageId == paginationMessageList.last().messageId) // for group sending message received from server again to handle that removing duplicate message
            messageList.removeAt(0)
        messageList.add(0, paginationMessageList.last())
    }

    fun getMessageAndPosition(messageId: String): Pair<Int, ChatMessage?> {
        val messageIndex = paginationMessageList.indexOfFirst { it.messageId == messageId }
        return if (messageIndex.isValidIndex()) {
            val message = paginationMessageList[messageIndex]
            Pair(messageIndex, message)
        } else Pair(messageIndex, null)
    }

    fun isLoadPreviousAvailable() = messageListQuery.hasPreviousMessages()

    fun isLoadNextAvailable() = messageListQuery.hasNextMessages()

    fun getFetchingIsInProgress() = messageListQuery.isFetchingInProgress()

    fun isLastPageFetched() = messageListQuery.getLastPageFetched()

}