package com.contusfly.starredMessages.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.isValidIndex
import com.contusfly.starredMessages.StarredMessageDiffCallback
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage
import javax.inject.Inject

class StarredMessageViewModel @Inject constructor(): ViewModel() {
    var starredMessagesListValues= MutableLiveData<List<ChatMessage>>()

    val starredMessageDiffResult = MutableLiveData<DiffUtil.DiffResult>()

    val starredMessageFetched=MutableLiveData<Boolean>()

    val starredMessageUpdated=MutableLiveData<Int>()

    /**
     * The List of chat messages to display in the adapter
     */
     var starredMessagesList: MutableList<ChatMessage> = mutableListOf()

    /**
     * The List of chat messages to display in the adapter
     */
     var searchedStarredMessageList: MutableList<ChatMessage> = mutableListOf()

    fun getStarredMessageList(){
        starredMessagesListValues.value= FlyMessenger.getFavouriteMessages()
    }

    fun fetchStarredMessageData(it: MutableList<ChatMessage>, searchEnabled:Boolean ) {
        if (starredMessagesList.size > 0 && !searchEnabled) {
            val diffResult = DiffUtil.calculateDiff(StarredMessageDiffCallback(starredMessagesList, it))
            messageListAddClear(it)
            starredMessageDiffResult.value=diffResult
        } else {
            messageListAddClear(it)
            starredMessageFetched.value=true
        }
    }

    private fun messageListAddClear(it: MutableList<ChatMessage>){
        searchedStarredMessageList.clear()
        starredMessagesList.clear()
        starredMessagesList.addAll(it)
    }

    fun updateStarredMessageData(messageId: String) {
        val messagePosition = getStarredMessagePosition(messageId)
        if (messagePosition.isValidIndex()) {
            val messageData = FlyMessenger.getMessageOfId(messageId)
            starredMessagesList[messagePosition] = messageData!!
            starredMessageUpdated.value = messagePosition
        }
    }

    private fun getStarredMessagePosition(messageId: String) = starredMessagesList.indexOfFirst {
        it.messageId == messageId
    }

    fun updateStarredMessageDataByJid(userJid: String){
        for (i in starredMessagesList){
            if(i.senderUserJid==userJid)
                updateStarredMessageData(i.messageId)
        }
    }





}