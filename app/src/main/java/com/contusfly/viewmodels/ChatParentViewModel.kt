package com.contusfly.viewmodels

import androidx.lifecycle.*
import com.contusfly.getData
import com.contusfly.isTextMessage
import com.contusfly.isValidIndex
import com.contusfly.repository.MessageRepository
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.chat.FetchMessageListParams
import com.mirrorflysdk.api.chat.FetchMessageListQuery
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseTextMessage
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion
import com.mirrorflysdk.flycommons.ChatType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class ChatParentViewModel @Inject
constructor(private val messageRepository: MessageRepository) : ViewModel() {

    /**
     * random generate string for user differntiation
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
    val loadSuggestion = MutableLiveData<Boolean>()
    val removeTempDateHeader = MutableLiveData<Boolean>()
    val searchkeydata = MutableLiveData<String>()
    val swipeRefreshLoader = MutableLiveData<Boolean>()

    private var toUser: String? = null

    private var participantChatType: String? = null

    val groupParticipantsName = MutableLiveData<String>()


    fun setParticpantDetails(chatType:String) {
        if(chatType == ChatType.TYPE_GROUP_CHAT) {
            participantChatType=com.mirrorflysdk.flycommons.Constants.MESSAGE_HISTORY_GROUP_CHAT
        } else {
            participantChatType=com.mirrorflysdk.flycommons.Constants.MESSAGE_HISTORY_SINGLE_CHAT
        }
    }

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
        private val SMART_REPLY_EXCEPTION = "Not running smart reply!"
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
            if (lastMessage.isMessageSentByMe()
                    || !lastMessage.isTextMessage()
                    || lastMessage.isMessageRecalled()) {
                LogMessage.d("smartReply", SMART_REPLY_EXCEPTION)
                return Tasks.forException(Exception(SMART_REPLY_EXCEPTION))
            } else if (lastMessage.getChatUserJid() != null && lastMessage.getChatUserJid() == toUser) {
                return createSmartReply(lastMessage)
            }
        }
        return Tasks.forException(Exception(SMART_REPLY_EXCEPTION))
    }

    private fun createSmartReply(lastMessage: ChatMessage): Task<List<SmartReplySuggestion>> {
        val chatHistory = ArrayList<FirebaseTextMessage>()
        if (lastMessage.getChatUserJid() == SharedPreferenceManager.getCurrentUserJid() && lastMessage.isMessageSentByMe())
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

    fun getMessageForId(jid: String) = messageRepository.getMessageForId(jid)

    fun getMessageForReply(jid: String) = messageRepository.getMessageForReply(jid)

    fun getRecalledMessageForThisUser(jid: String): List<String> = messageRepository.getRecalledMessageOfAnUser(jid)

    fun deleteUnreadMessageSeparator(jid: String) = messageRepository.deleteUnreadMessageSeparator(jid)

    fun getProfileDetails(jid: String): ProfileDetails? = ProfileDetailsUtils.getProfileDetails(jid)

    fun isGroupUserExist(groupId: String, jid: String): Boolean = ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupId, jid)

    fun getParticipantsNameAsCsv(jid: String) {
        GroupManager.getGroupMembersList(false, jid) { isSuccess, _, data ->
            if (isSuccess) {
                val participantsNameList: MutableList<String> = ArrayList()
                var groupsMembersProfileList: MutableList<ProfileDetails> = data[Constants.SDK_DATA] as MutableList<ProfileDetails>
                groupsMembersProfileList = ProfileDetailsUtils.sortGroupProfileList(groupsMembersProfileList)
                groupsMembersProfileList.forEach {
                    if(!it.jid.equals(SharedPreferenceManager.getCurrentUserJid()))
                        participantsNameList.add(it.name)
                }
                groupParticipantsName.value = participantsNameList.sorted().joinToString(",")
            }
        }
    }

    fun clearChat() {
        initialMessageList.value?.clear()
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

    fun loadInitialData(loadFromMessageId: String) {
        setSwipeLoader(true)
        viewModelScope.launch {
            messageListParams = FetchMessageListParams().apply {
                chatJid = toUserJid
                limit = 30
                messageId = loadFromMessageId
                inclusive = true
                chatType= participantChatType!!
                direction=Constants.LOAD_PREV_MESSAGE
            }
            messageListQuery = FetchMessageListQuery(messageListParams)

            messageListQuery.loadMessages { isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    paginationMessageList.clear()
                    paginationMessageList.addAll(messageRepository.getMessageListWithDate(messageList))
                    initialMessageList.postValue(paginationMessageList)
                    if (loadFromMessageId.isNotBlank() && messageListQuery.isValidMessageId(loadFromMessageId) && ChatManager.getAvailableFeatures().isChatHistoryEnabled){
                        loadPreviousMessage()
                    } else {
                        loadPreviousData()
                    }
                    loadSuggestion.postValue(!isLoadNextAvailable())
                }

                setSwipeLoader(false)

            }
        }
    }

    fun loadInitialMessages(loadFromMessageId: String) {
        if(messageListQuery.isFetchingInProgress()){
            return
        }
        viewModelScope.launch {
            messageListQuery.loadLocalMessages { isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    paginationMessageList.clear()
                    paginationMessageList.addAll(messageRepository.getMessageListWithDate(messageList))
                    initialMessageList.postValue(paginationMessageList)
                    if (loadFromMessageId.isNotBlank())
                        loadPreviousData()
                    loadSuggestion.postValue(!isLoadNextAvailable())
                }
            }
        }
    }

    fun loadNextMessage(searchedText: String="") {
        if(messageListQuery.isFetchingInProgress()){
            return
        }
        viewModelScope.launch {
            messageListQuery.loadNextMessages { isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    if (messageList.isNotEmpty()) {
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

    fun loadPreviousMessage(searchedText: String="") {
        if(messageListQuery.isFetchingInProgress()){
            return
        }
        setSwipeLoader(true)
        viewModelScope.launch {
            messageListQuery.loadPreviousMessages{ isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    if (messageList.isNotEmpty()) {
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
                setSwipeLoader(false)
            }
        }
    }


    fun loadPreviousData(searchedText: String="") {
        if(messageListQuery.isFetchingInProgress()){
            return
        }
        viewModelScope.launch {
            messageListQuery.loadLocalPreviousMessages { isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    if (messageList.isNotEmpty()) {
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
        searchkeydata.postValue(event)
    }

    fun loadNextData(searchedText: String="") {
        if(messageListQuery.isFetchingInProgress()) {
            return
        }
        viewModelScope.launch {
            messageListQuery.loadLocalNextMessages { isSuccess, _, data ->
                if (isSuccess) {
                    val messageList = data.getData() as ArrayList<ChatMessage>
                    if (messageList.isNotEmpty()) {
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