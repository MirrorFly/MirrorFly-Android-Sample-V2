package com.contusfly.chatTag.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.TAG
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.models.RecentChat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class ChatTagViewModel @Inject constructor() : ViewModel()  {

    val recentChatList = MutableLiveData<ArrayList<RecentChat>>()
    val recentChatAdapter: LinkedList<RecentChat> by lazy { LinkedList<RecentChat>() }
    val recentChatDiffResult = MutableLiveData<DiffUtil.DiffResult>()
    val chatTagRecentItems = MutableLiveData<ArrayList<RecentChat>>()

    fun getRecentChats() {
        LogMessage.d(TAG, "getRecentChats() called to update the UI")
        viewModelScope.launch(Dispatchers.Main.immediate) {
                recentChatList.value = ArrayList(FlyCore.getRecentChatList())
        }
    }

    fun getRecentChatBasedOnChatTag(jidList:ArrayList<String>){
        LogMessage.d(TAG, "getChatTag Items")
        viewModelScope.launch(Dispatchers.Main.immediate) {
            chatTagRecentItems.value = ArrayList(FlyCore.getChatTagList(jidList))
        }
    }


}