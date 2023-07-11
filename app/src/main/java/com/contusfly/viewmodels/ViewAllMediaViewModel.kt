package com.contusfly.viewmodels

import androidx.lifecycle.*
import com.contusfly.*
import com.contusfly.chat.MessageUtils
import com.contusfly.models.GroupedMedia
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import java.text.DateFormatSymbols
import java.util.*

class ViewAllMediaViewModel : ViewModel() {

    val mediaListData = mutableListOf<GroupedMedia>()
    val docsListData = mutableListOf<GroupedMedia>()
    val linkListData = mutableListOf<GroupedMedia>()
    val mediaListLoaded = MutableLiveData<Boolean>()
    val docsListLoaded = MutableLiveData<Boolean>()
    val linkListLoaded = MutableLiveData<Boolean>()
    var jid = ""

    val profileDetail = MutableLiveData<ProfileDetails>()

    fun getMediaList(jid: String) {
        this.jid = jid
        viewModelScope.launch(Dispatchers.IO) {
            notifyViewAllMediaFragment(getGroupedMediaList(ChatManager.getMediaMessages(jid), true))
        }
    }

    private fun notifyViewAllMediaFragment(groupedMediaList: List<GroupedMedia>) {
        viewModelScope.launch {
            mediaListData.clear()
            mediaListData.addAll(groupedMediaList)
            mediaListLoaded.postValue(true)
        }
    }

    fun getDocsList(jid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            notifyViewAllDocsFragment(getGroupedMediaList(ChatManager.getDocsMessages(jid), false))
        }
    }

    private fun notifyViewAllDocsFragment(groupedDocsList: List<GroupedMedia>) {
        viewModelScope.launch {
            docsListData.clear()
            docsListData.addAll(groupedDocsList)
            docsListLoaded.postValue(true)
        }
    }

    fun getLinksList(jid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            notifyViewAllLinksFragment(getGroupedMediaList(ChatManager.getLinkMessages(jid), false, true))
        }
    }

    private fun notifyViewAllLinksFragment(groupedLinkList: List<GroupedMedia>) {
        viewModelScope.launch {
            linkListData.clear()
            linkListData.addAll(groupedLinkList)
            linkListLoaded.postValue(true)
        }
    }

    private fun getGroupedMediaList(mediaMessages: List<ChatMessage>, isMedia:Boolean, isLinkMedia:Boolean = false) : List<GroupedMedia> {
        val calendarInstance = Calendar.getInstance()
        val currentYear = calendarInstance[Calendar.YEAR]
        val currentMonth = calendarInstance[Calendar.MONTH]
        val currentDay = calendarInstance[Calendar.DAY_OF_MONTH]
        val calendar: Calendar = GregorianCalendar()
        val dateSymbols = DateFormatSymbols().months
        var year: Int
        var month: Int
        var day: Int
        val viewAllMediaList = mutableListOf<GroupedMedia>()
        var previousCategoryType = 10
        mediaMessages.forEach { chatMessage ->
            val date = Date(chatMessage.getMessageSentTime()/1000)
            calendar.time = date
            year = calendar[Calendar.YEAR]
            month = calendar[Calendar.MONTH]
            day = calendar[Calendar.DAY_OF_MONTH]

            val category = getCategoryName(dateSymbols, currentDay, currentMonth, currentYear, day, month, year)

            if (isLinkMedia) {
                if (previousCategoryType != category.first)
                    viewAllMediaList.add(GroupedMedia.Header(category.second))
                previousCategoryType = category.first
                getMessageWithURLList(chatMessage).forEach { viewAllMediaList.add(it) }
            } else {
                if (!chatMessage.isMessageRecalled() && (chatMessage.isMediaDownloaded() || chatMessage.isMediaUploaded())
                    && isMediaAvailable(chatMessage, isMedia)) {
                    if (previousCategoryType != category.first)
                        viewAllMediaList.add(GroupedMedia.Header(category.second))
                    previousCategoryType = category.first
                    viewAllMediaList.add(GroupedMedia.MessageItem(chatMessage))
                }
            }
        }
        return viewAllMediaList
    }


    private fun isMediaAvailable(chatMessage: ChatMessage, isMedia: Boolean): Boolean {
        return (!isMedia || MessageUtils.isMediaExists(chatMessage.getMediaChatMessage().getMediaLocalStoragePath()))
    }

    private fun getCategoryName(dateSymbols: Array<String>, currentDay: Int, currentMonth: Int, currentYear: Int,
                                day: Int, month: Int, year: Int): Pair<Int, String> {
        return when {
            (currentYear - year) == 1 -> {
                if (currentMonth < month) {
                    Pair(4, dateSymbols[month])
                } else {
                    Pair(5, year.toString())
                }
            }
            currentYear > year -> {
                Pair(5, year.toString())
            }
            (currentMonth - month) == 1 -> {
                if (day > currentDay)
                    Pair(3, "Last Month")
                else
                    Pair(4, dateSymbols[month])
            }
            currentMonth > month -> Pair(4, dateSymbols[month])
            (currentDay - day) > 7 -> {
                Pair(2, "Last Month")
            }
            (currentDay - day) > 2 -> {
                Pair(1, "Last Week")
            }
            else -> Pair(0, "Recent")
        }
    }

    private fun getMessageWithURLList(message: ChatMessage): MutableList<GroupedMedia> {
        val messageList = mutableListOf<GroupedMedia>()
        val textContent = when {
            message.isTextMessage() -> {
                message.getMessageTextContent()
            }
            message.isImageMessage() || message.isVideoMessage() -> {
                message.getMediaChatMessage().getMediaCaptionText()
            }
            else -> Constants.EMPTY_STRING
        }
        if (textContent.isNotBlank()) {
            getUrlAndHostList(textContent).forEach {
                val map = hashMapOf<String, String>()
                map[Constants.HOST] = it.first
                map[Constants.URL] = it.second
                messageList.add(GroupedMedia.MessageItem(message, map))
            }
        }
        return messageList
    }

    private fun getUrlAndHostList(text: String): ArrayList<Pair<String, String>> {
        val urls = ArrayList<Pair<String, String>>()
        val splitString = text.split("\\s+".toRegex())
        for (string in splitString) {
            try {
                val item = URL(string)
                urls.add(Pair(item.host, item.toString()))
            } catch (ignored: Exception) {
                //No Implementation needed
            }
        }
        return urls
    }

    fun getProfileDetails(jid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            profileDetail.postValue(ProfileDetailsUtils.getProfileDetails(jid))
        }
    }
}