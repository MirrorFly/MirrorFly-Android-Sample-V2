package com.contusfly.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.contusfly.repository.MessageRepository
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import javax.inject.Inject

class ChatViewModel @Inject
constructor(private val messageRepository: MessageRepository) : ViewModel() {

    val userRoster: MutableLiveData<ProfileDetails> = MutableLiveData()

    /**
     * contact refreshing status
     */
    private var isRefreshing: Boolean = false

    private lateinit var toUserJid: String

    fun setUserJid(jid: String) {
        toUserJid = jid
    }

    fun getProfileDetails() {
        userRoster.value = ProfileDetailsUtils.getProfileDetails(toUserJid)
    }

    fun getMessage(messageId: String): ChatMessage? = FlyMessenger.getMessageOfId(messageId)

    fun deleteUnreadMessageSeparator(jid: String) = messageRepository.deleteUnreadMessageSeparator(jid)

}