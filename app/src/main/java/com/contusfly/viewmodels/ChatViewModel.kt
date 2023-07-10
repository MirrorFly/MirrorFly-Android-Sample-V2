package com.contusfly.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contusfly.TAG
import com.contusfly.repository.MessageRepository
import com.contusfly.utils.ContactUtils
import com.contusfly.utils.LogMessage
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatViewModel @Inject
constructor(private val messageRepository: MessageRepository) : ViewModel() {

    val userRoster: MutableLiveData<ProfileDetails> = MutableLiveData()

    /**
     * contact refreshing status
     */
    private var isRefreshing: Boolean = false

    private lateinit var toUserJid: String

    /**
     * contacts count from preference
     */
    var mContactCount: Int = 0

    val isContactSyncSuccess = MutableLiveData<Boolean>()

    fun setUserJid(jid: String) {
        toUserJid = jid
    }

    fun getProfileDetails() {
        userRoster.value = ProfileDetailsUtils.getProfileDetails(toUserJid)
    }

    fun getMessage(messageId: String): ChatMessage? = FlyMessenger.getMessageOfId(messageId)

    fun deleteUnreadMessageSeparator(jid: String) = messageRepository.deleteUnreadMessageSeparator(jid)


    fun onContactSyncFinished(success: Boolean) {
        LogMessage.d(TAG, "[Contact Sync] Contact sync success: $success")
        viewModelScope.launch {
            isRefreshing = false
            val currentContactCount = ContactUtils.getContactCount(ChatManager.applicationContext)
            com.contusfly.utils.SharedPreferenceManager.setInt(ContactUtils.CONTACTS_COUNT, currentContactCount)
        }
    }
}