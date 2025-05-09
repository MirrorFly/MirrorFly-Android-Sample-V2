package com.contusfly.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.*
import com.contusfly.databinding.RowProgressBarBinding
import com.contusfly.databinding.RowSearchContactMessageBinding
import com.contusfly.groupmention.MentionUtils
import com.contusfly.utils.*
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.models.RecentSearch
import com.mirrorflysdk.utils.Utils
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class RecentChatSearchAdapter(val context: Context, private var recentSearchList: ArrayList<com.contusfly.models.RecentSearch>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Search string key
     */
    private lateinit var searchKey: String

    /**
     * Recent Message count
     */
    private var recentMessageCount: Int = 0

    /**
     * Recent contact count
     */
    private var recentContactCount: Int = 0

    /**
     * Recent chat count
     */
    private var recentChatCount: Int = 0

    private var isLoadingAdded = false

    /**
     * Is called from recent chat or not
     */
    private var isRecentChat: Boolean = true

    private var isPaginate:Boolean=false


    private lateinit var onSearchItemClicked: (Int) -> Unit

    fun searchItemClickedCallback(fn: (Int) -> Unit) {
        onSearchItemClicked = fn
    }

    companion object {
        private const val LOADING = 0
        private const val ITEM = 1
    }
    /**
     * Sets the recent search item and search key in the chat list view.
     *
     * @param recentChats Recent chat data
     * @param searchKey   Key to search
     */
    fun setRecentSearch(recentChats: ArrayList<com.contusfly.models.RecentSearch>, searchKey: String) {
        this.recentSearchList = recentChats
        this.searchKey = searchKey
    }

    fun setRecentChatCount(recentChatCount: Int) {
        this.recentChatCount = recentChatCount
    }

    fun setRecentContactCount(recentContactCount: Int,isPaginate:Boolean) {
        this.recentContactCount = recentContactCount
        this.isPaginate=isPaginate
    }

    fun setRecentMessageCount(recentMessageCount: Int) {
        this.recentMessageCount = recentMessageCount
    }

    fun setIsRecentChat(isRecentChat: Boolean) {
        this.isRecentChat = isRecentChat
    }

    class RecentChatSearchViewHolder(var viewBinding: RowSearchContactMessageBinding) : RecyclerView.ViewHolder(viewBinding.root)
    class ProgressViewHolder(var progressViewBinding: RowProgressBarBinding) : RecyclerView.ViewHolder(progressViewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM) {
            val binding = RowSearchContactMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            RecentChatSearchViewHolder(binding)
        }else{
            val progressViewHolder = RowProgressBarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ProgressViewHolder(progressViewHolder)
        }

    }

    override fun getItemCount(): Int {
        return this.recentSearchList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (recentSearchList[position].jid.isBlank())LOADING else ITEM
    }

    @Suppress("NAME_SHADOWING")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is RecentChatSearchViewHolder->{
                val item = ProfileDetailsUtils.getProfileDetails(this.recentSearchList[position].jid)
                enableHeader(holder.viewBinding, position)
                holder.viewBinding.searchRecentItem.setBackgroundResource(R.drawable.recycleritem_ripple)
                val recent = this.recentSearchList[position]
                val item3: ProfileDetails?=this.recentSearchList[position].profileDetails
                when (recent.searchType) {
                    Constants.TYPE_SEARCH_RECENT -> item?.let { viewRecentChatItem(holder.viewBinding, position, it) }
                    Constants.TYPE_SEARCH_CONTACT -> item3?.let { viewContactItem(holder.viewBinding, position, it) }
                    Constants.TYPE_SEARCH_MESSAGE -> item?.let { viewMessageItem(holder.viewBinding, position, it) }
                    else -> LogMessage.d(TAG, "Default block")
                }
                holder.viewBinding.searchRecentItem.setOnClickListener {
                    if (position < recentSearchList.size) {
                       recentSearchItemOnclick(position)
                    }
                }
            }
            is ProgressViewHolder -> {
                holder.progressViewBinding.loadMoreProgress.show()
            }
        }

    }

    private fun recentSearchItemOnclick(position: Int){
        if (recentSearchList[position].searchType == Constants.TYPE_SEARCH_CONTACT) {
            ContactManager.insertProfile(recentSearchList[position].profileDetails)
            ProfileDetailsUtils.addContact(recentSearchList[position].profileDetails)
        }
        if (position >= 0 && (recentSearchList[position].searchType != Constants.TYPE_SEARCH_RECENT))
            onSearchItemClicked(position)
        else {
            val recent = FlyCore.getRecentChatOf(recentSearchList[position].jid)
            if (!recent!!.isGroupInOfflineMode)
                onSearchItemClicked(position)
        }
    }

    /**
     * Display the searched message view item
     *
     * @param viewBinding    Holder of the Chat item
     * @param position  Position of the selected item
     * @param profileDetail    Instance of ProfileDetail
     */
    private fun viewMessageItem(viewBinding: RowSearchContactMessageBinding, position: Int, profileDetail: ProfileDetails) {
        try {
            with(viewBinding) {
                searchRecentItem.alpha = 1.0f
                searchTextChatPerson.text = profileDetail.getDisplayName()
                searchTextRecentChatmsg.show()
                setAdapterIcon(profileDetail, this)
                setMessageView(this@RecentChatSearchAdapter.recentSearchList[position].mid, this)
                makeViewsGone(emailContactIcon)
                val recent = FlyCore.getRecentChatOf(profileDetail.jid)
                setArchivedAndPinLabel(recent, this)
                switchBetweenMuteUnmute(recent, this)

            }
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(e)
        }
    }

    /**
     * Set the message view of the recent chat users. get the message ov]bject and display based on ext or Message type
     *
     * @param msgId  Message id
     * @param viewBinding Holder for the view
     */
    private fun setMessageView(msgId: String, viewBinding: RowSearchContactMessageBinding) {
        try {
            val message = FlyMessenger.getMessageOfId(msgId)
            if (message != null && !message.isMessageDeleted())
                setMessageData(viewBinding, message)
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(e)
        }
    }

    private fun setTextAndHighLightSearchTextForMention(context: Context?, textView: CustomTextView,
                                                        text: String?, startIndex: Int, stopIndex: Int, mentionedUserName: SpannableStringBuilder
    ) {
        try {
            val deliMeter="@"
            val userText = Utils.getUtfDecodedText(text)
            val textToHighlight: Spannable = SpannableString(userText)

            val mentionedUserStringArray = mentionedUserName.split("[\\n$deliMeter]".toRegex()).toTypedArray()

            for (i in 1 until  mentionedUserStringArray.size){
                val indexElement = mentionedUserStringArray[i]
                val index = textToHighlight.indexOf(indexElement)
                textToHighlight.setSpan(ForegroundColorSpan(ContextCompat.getColor(context!!, R.color.color_blue)),
                    index-1, index+indexElement.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            if (startIndex != -1 && stopIndex != -1) textToHighlight.setSpan(
                ForegroundColorSpan(Color.BLUE),
                startIndex,
                stopIndex,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            textView.text = SpannableStringBuilder.valueOf(textToHighlight)
        } catch (e: java.lang.Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(e)
        }
    }

    private fun setSearchTextHighlightExceptionMention(
        txtChat: CustomTextView,
        fromHtml: Spanned?, mentionedUserName:SpannableStringBuilder
    ) {
        if (searchKey.isNotEmpty() && fromHtml.toString().startsWithTextInWords(searchKey)) {
            var startIndex = fromHtml.toString().checkIndexes(searchKey)
            if (startIndex < 0) startIndex = fromHtml.toString().indexOf(searchKey)
            val stopIndex = startIndex + searchKey.length
            setTextAndHighLightSearchTextForMention(context, txtChat,fromHtml.toString(), startIndex, stopIndex,mentionedUserName)
        } else {
            txtChat.setBackgroundColor(context!!.color(android.R.color.transparent))
            txtChat.text=fromHtml
        }
    }

    private fun msgContentMeetAndTextMessage(message: ChatMessage): String {
        return if (MessageType.MEET == message.messageType)
            Utils.getUtfDecodedText(message.meetingChatMessage.link)
        else
            Utils.getUtfDecodedText(message.messageTextContent)
    }

    /**
     * Set the message data from the message view
     *
     * @param viewBinding  Holder of the view
     * @param message Instance of the Message
     */
    private fun setMessageData(viewBinding: RowSearchContactMessageBinding, message: ChatMessage) {
        val chatTimeOperations = ChatTimeOperations(Calendar.getInstance())
        val time = chatTimeOperations.getRecentChatTime(context, message.getMessageSentTime())
        viewBinding.searchTextRecentchatTime.show()
        viewBinding.searchTextRecentchatTime.text = time
        val msgType = message.messageType
        try {
            when {
                MessageType.TEXT == msgType || MessageType.MEET == msgType -> {
                    val messageContent = if (message.isMessageRecalled) setRecalledMessageText(
                        viewBinding,
                        message.isMessageSentByMe
                    )
                    else {
                        msgContentMeetAndTextMessage(message)
                    }
                    if(message.mentionedUsersIds!=null && message.mentionedUsersIds.size>0){
                        val mentionText = MentionUtils.formatMentionText(context, message,false)
                        val mentionUserNames= MentionUtils.getMentionedUserId(context,message,false)
                        setSearchTextHighlightExceptionMention(viewBinding.searchTextRecentChatmsg,mentionText,mentionUserNames)
                    }else{
                        val textToHighlight = SpannableString(messageContent)
                        val startIndex = messageContent!!.toLowerCase(Locale.getDefault()).indexOf(searchKey.toLowerCase(Locale.getDefault()))
                        if (startIndex.isValidIndex() && !message.isMessageRecalled()) {
                            val stopIndex = startIndex + searchKey.length
                            textToHighlight.setSpan(ForegroundColorSpan(Color.BLUE), startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        viewBinding.searchTextRecentChatmsg.text = textToHighlight
                    }

                }
                MessageType.NOTIFICATION == msgType -> viewBinding.searchTextRecentChatmsg.text = Utils.getUtfDecodedText(message.getMessageTextContent())
                else -> {
                    viewBinding.searchImageRecentChatType.show()
                    setImageStatus(viewBinding, msgType, message)
                }
            }
            setMessageStatus(message, viewBinding.searchImageRecentChatStatus)
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(e)
        }
    }

    private fun imageCaptionHighlight(viewBinding: RowSearchContactMessageBinding,message: ChatMessage){
        if(message.mentionedUsersIds!=null && message.mentionedUsersIds.size>0){
            val mentionText = MentionUtils.formatMentionText(context, message,false)
            val mentionUserNames= MentionUtils.getMentionedUserId(context,message,false)
            setSearchTextHighlightExceptionMention(viewBinding.searchTextRecentChatmsg,mentionText,mentionUserNames)
        }else {
            viewBinding.searchTextRecentChatmsg.text = message.mediaChatMessage.mediaCaptionText
        }
    }

    /**
     * Sets the image status of the chat type => Audio => Video => Image => LocationMessage => Contact
     *
     * @param viewBinding  Holder of the view
     * @param msgType Type of the message
     */
    private fun setImageStatus(viewBinding: RowSearchContactMessageBinding, msgType: MessageType?, message: ChatMessage) {
        when (msgType) {
            MessageType.AUDIO -> {
                viewBinding.searchImageRecentChatType.setImageResource(if (message.getMediaChatMessage().isAudioRecorded()) R.drawable.ls_ic_record else R.drawable.ls_ic_music)
                viewBinding.searchTextRecentChatmsg.text = context.getString(R.string.title_audio)
            }
            MessageType.IMAGE -> {
                viewBinding.searchImageRecentChatType.setImageResource(R.drawable.ls_ic_camera)
                if (message.mediaChatMessage.mediaCaptionText.isNotEmpty()) {
                    imageCaptionHighlight(viewBinding, message)
                }
                else viewBinding.searchTextRecentChatmsg.text = context.getString(R.string.title_image)
            }
            MessageType.VIDEO -> {
                viewBinding.searchImageRecentChatType.setImageResource(R.drawable.ls_ic_video)
                if (message.mediaChatMessage.mediaCaptionText.isNotEmpty()) {
                    if(message.mentionedUsersIds!=null && message.mentionedUsersIds.size>0) {
                        val mentionText = MentionUtils.formatMentionText(context, message, false)
                        val mentionUserNames =
                            MentionUtils.getMentionedUserId(context, message, false)
                        setSearchTextHighlightExceptionMention(
                            viewBinding.searchTextRecentChatmsg,
                            mentionText,
                            mentionUserNames
                        )
                    }else
                    viewBinding.searchTextRecentChatmsg.text = message.mediaChatMessage.mediaCaptionText
                }
                else viewBinding.searchTextRecentChatmsg.text = context.getString(R.string.title_video)
            }
            MessageType.LOCATION -> {
                viewBinding.searchImageRecentChatType.setImageResource(R.drawable.ls_ic_location)
                viewBinding.searchTextRecentChatmsg.text = context.getString(R.string.action_location)
            }
            MessageType.CONTACT -> {
                viewBinding.searchImageRecentChatType.setImageResource(R.drawable.ls_ic_contact)
                viewBinding.searchTextRecentChatmsg.text = context.getString(R.string.action_contact)
            }
            MessageType.DOCUMENT -> {
                viewBinding.searchImageRecentChatType.setImageResource(R.drawable.ls_ic_file)
                viewBinding.searchTextRecentChatmsg.text = context.getString(R.string.title_document)
            }
            else -> viewBinding.searchImageRecentChatType.visibility = View.GONE
        }
    }

    /**
     * Set the message status of the message and enable the status(Single,Double and Seen tick)
     *
     * @param message                Instance of the Message
     * @param messageStatusImageView Image view to display the status
     */
    private fun setMessageStatus(message: ChatMessage, messageStatusImageView: ImageView) {
        if (message.isMessageSentByMe && !message.isMessageRecalled && !checkEqualString(Constants.MSG_TYPE_NOTIFICATION,message.messageType.name)) {
            messageStatusImageView.show()
            ChatMessageUtils.setChatStatus(messageStatusImageView, message.messageStatus)
        } else messageStatusImageView.gone()
    }

    /**
     * Sets the text to be displayed.
     *
     * @param viewBinding       The view holding the child items.
     * @param isFromSender Boolean stating whether the recall is either from sender or receiver.
     * @return The information about the recalled message.
     */
    private fun setRecalledMessageText(viewBinding: RowSearchContactMessageBinding, isFromSender: Boolean): String? {
        return if (isFromSender) {
            viewBinding.searchImageRecentChatStatus.gone()
            context.resources.getString(R.string.single_chat_sender_recall)
        } else context.resources.getString(R.string.single_chat_receiver_recall)
    }

    private fun setAdapterIcon(profileDetail: ProfileDetails, viewBinding: RowSearchContactMessageBinding) {
        if (profileDetail.getDisplayName().isNotEmpty())
            viewBinding.searchImageContact.loadUserProfileImage(context, profileDetail)
        else profileDetail.isGroupProfile.ifElse({
            viewBinding.searchImageContact.setImageResource(R.drawable.icon_grp)
        }, { viewBinding.searchImageContact.setImageResource(R.drawable.profile_img) })
    }

    fun addLoadingFooter() {
        if (!isLoadingAdded) {
            isLoadingAdded = true
            recentSearchList.add(com.contusfly.models.RecentSearch("","","","",false,ProfileDetails()))
            notifyItemInserted(recentSearchList.size - 1)
        }
    }

    fun removeLoadingFooter() {
        if (isLoadingAdded) {
            isLoadingAdded = false
            val loaderPosition = recentSearchList.indexOfFirst { it.jid.isNullOrBlank()  }
            if (loaderPosition.isValidIndex()) {
                recentSearchList.removeAt(loaderPosition)
                notifyItemRemoved(loaderPosition)
            }
        }
    }

    /**
     * Display the searched contact item
     *
     * @param holder    Holder of the Chat item
     * @param position  Position of the selected item
     * @param profileDetail    Instance of ProfileDetail
     */
    private fun viewContactItem(viewBinding: RowSearchContactMessageBinding, position: Int, profileDetail: ProfileDetails) {
        try {
            with(viewBinding) {
                searchRecentItem.alpha = 1.0f
                viewBinding.searchTextRecentchatTime.gone()
                if (emptyList<RecentSearch>() != this@RecentChatSearchAdapter.recentSearchList
                        && this@RecentChatSearchAdapter.recentSearchList[position].search!!) {
                    val startIndex = profileDetail.getDisplayName().toLowerCase(Locale.getDefault()).indexOf(searchKey.toLowerCase(Locale.getDefault()))
                    val stopIndex = startIndex + searchKey.length
                    EmojiUtils.setEmojiTextAndHighLightSearchText(searchTextChatPerson, profileDetail.getDisplayName(), startIndex, stopIndex)
                } else EmojiUtils.setEmojiText(searchTextChatPerson, profileDetail.getDisplayName().toString())
                makeViewsGone(searchTextRecentChatmsg, searchTextArchive, searchImageRecentChatStatus, searchTextUnseenCount, searchPin, mute)
                setAdapterIcon(profileDetail, this)
                val status = Utils.returnEmptyStringIfNull(profileDetail.status)
                /**
                 * Set status if status not empty
                 */
                if (status.isNotEmpty()) {
                    searchTextRecentChatmsg.show()
                    EmojiUtils.setEmojiText(searchTextRecentChatmsg, status)
                }
                emailContactIcon.gone()
            }
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(e)
        }
    }

    /**
     * Display the searched recent chat item
     *
     * @param holder   Holder of the Chat item
     * @param position Position of the selected item
     */
    private fun viewRecentChatItem(viewBinding: RowSearchContactMessageBinding, position: Int, profileDetail: ProfileDetails) {
        val item = this.recentSearchList[position]
        val recent = FlyCore.getRecentChatOf(item.jid)
        setUserView(viewBinding, position, profileDetail)
        if (item.mid != null)
            setMessageView(item.mid, viewBinding)

        val unSeenCount = recent!!.unreadMessageCount
        if (unSeenCount > 0) {
            viewBinding.searchTextUnseenCount.show()
            viewBinding.searchTextUnseenCount.text = returnFormattedCount(unSeenCount)
        } else viewBinding.searchTextUnseenCount.gone()

        viewBinding.emailContactIcon.gone()

        if (profileDetail.isGroupInOfflineMode) {
            viewBinding.searchRecentItem.alpha = 0.5f
            viewBinding.searchRecentItem.background = null
        } else {
            viewBinding.searchRecentItem.alpha = 1.0f
            viewBinding.searchRecentItem.setBackgroundResource(R.drawable.recycleritem_ripple)
        }
        setArchivedAndPinLabel(recent, viewBinding)
        switchBetweenMuteUnmute(recent, viewBinding)
    }

    /**
     * Set Archived and Pin label for the chat.
     *
     * @param recent  RecentChat of the User/Group
     * @param viewBinding Holder of the view
     */
    private fun setArchivedAndPinLabel(recent: RecentChat?, viewBinding: RowSearchContactMessageBinding) {
        recent?.let {
            if (recent.isChatArchived) viewBinding.searchTextArchive.show() else viewBinding.searchTextArchive.gone()
            if (recent.isChatPinned) viewBinding.searchPin.show() else viewBinding.searchPin.gone()
        }

    }

    /**

     * Mute status Icon Showing Recent chat

     *

     * @param recent Instance of RecentChat

     * @param holder Instance of the view holder

     */

    private fun switchBetweenMuteUnmute(recent: RecentChat?, holder: RowSearchContactMessageBinding) {
        if (recent!!.isMuted && FlyCore.isUserUnArchived(recent.jid)) holder.mute.show() else holder.mute.gone()
    }

    /**
     * Set the user view for the recent chat items Set the user information or users from the normal users.
     *
     * @param viewBinding       Holder of the view
     * @param position     Position of the list item
     * @param profileDetail       Instance of ProfileDetail
     */
    private fun setUserView(viewBinding: RowSearchContactMessageBinding, position: Int, profileDetail: ProfileDetails) {
        try {
            if (emptyList<RecentSearch>() != this.recentSearchList && this.recentSearchList[position].search!!) {
                Log.e("setUserView:searchAd ", "vcard is always not null")
                val startIndex = profileDetail.getDisplayName().toLowerCase(Locale.getDefault()).indexOf(searchKey.toLowerCase(Locale.getDefault()))
                val stopIndex = startIndex + searchKey.length
                EmojiUtils.setEmojiTextAndHighLightSearchText(viewBinding.searchTextChatPerson, profileDetail.getDisplayName(), startIndex, stopIndex)
                setAdapterIcon(profileDetail, viewBinding)
            }
        } catch (e: Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(e)
        }
    }

    /**
     * Enable the header, that might be Chats or Messages or Contacts.
     *
     * @param viewBinding   View holder of the Chat view
     * @param position Position of the List
     */
    private fun enableHeader(viewBinding: RowSearchContactMessageBinding, position: Int) {
        /**
         * Enable header if position is zero or previous item is different and not from Archived chats screen
         */
        if ((position == 0 || canEnableHeader(position)) && isRecentChat) {
            viewBinding.viewSearchHeader.show()
            if (Build.VERSION.SDK_INT > 26)
                viewBinding.viewSearchHeader.focusable = View.NOT_FOCUSABLE
            viewBinding.viewSearchHeader.isFocusable = false
            viewBinding.viewSearchHeader.isClickable = false
            viewBinding.viewSearchHeader.isEnabled = false
            setSearchHeader(viewBinding.headerSearchRecent, position)
        } else if(isPaginate){
            viewBinding.viewSearchHeader.gone()
            setSearchHeader(viewBinding.headerSearchRecent, position)
        }else viewBinding.viewSearchHeader.gone()
    }

    /**
     * Check the header is needed for the chat item. Search type of the current item and previous item is different then return true
     *
     * @param position Position of the list item
     * @return boolean True if the header need to enable
     */
    private fun canEnableHeader(position: Int): Boolean {
        return this.recentSearchList[position].searchType != this.recentSearchList[position - 1].searchType
    }

    /**
     * Set the search header in the chat item, which is the Search type
     *
     * @param headerSearchRecent TextView to display the chat item
     * @param position           Position of the list item
     */
    private fun setSearchHeader(headerSearchRecent: CustomTextView, position: Int) {
        val builder = SpannableStringBuilder()

        /**
         * Set the red color text
         */
        val searchItem = this.recentSearchList[position]

        val searchType = searchItem.searchType
        val contactCount = "$searchType ($recentContactCount)"
        val messageCount = "$searchType ($recentMessageCount)"
        val chatCount = "$searchType ($recentChatCount)"

        /**
         * Set the search count to bold and black color
         */
        val bold = StyleSpan(Typeface.BOLD)

        /**
         * Set search header according to the search type
         */
        when (searchType) {
            Constants.TYPE_SEARCH_CONTACT -> {
                val contactSpannable = SpannableString(contactCount)
                contactSpannable.setSpan(ForegroundColorSpan(Color.BLACK), searchType.length, contactCount.length, 0)
                contactSpannable.setSpan(bold, searchType.length, contactCount.length, 0)
                builder.append(contactSpannable)
                headerSearchRecent.text = contactSpannable
            }
            Constants.TYPE_SEARCH_MESSAGE -> {
                val messageSpannable = SpannableString(messageCount)
                messageSpannable.setSpan(ForegroundColorSpan(Color.BLACK), searchType.length, messageCount.length, 0)
                messageSpannable.setSpan(bold, searchType.length, messageCount.length, 0)
                builder.append(messageSpannable)
                headerSearchRecent.text = messageSpannable
            }
            else -> {
                val chatSpannable = SpannableString(chatCount)
                chatSpannable.setSpan(ForegroundColorSpan(Color.BLACK), searchType.length, chatCount.length, 0)
                chatSpannable.setSpan(bold, searchType.length, chatCount.length, 0)
                builder.append(chatSpannable)
                headerSearchRecent.text = chatSpannable
            }
        }
    }

    /**
     * Return formatted unread count for the Recent chat.
     *
     * @param count Count of Unread message
     * @return String Converted string count
     */
    private fun returnFormattedCount(count: Int): String {
        return if (count > 99) "99+" else count.toString()
    }
}