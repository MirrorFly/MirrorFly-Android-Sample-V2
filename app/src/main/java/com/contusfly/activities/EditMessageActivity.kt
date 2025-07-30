package com.contusfly.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.contusfly.R
import com.contusfly.activities.parent.EditChatParent
import com.contusfly.adapters.ChatAdapter
import com.contusfly.adapters.GroupTagAdapter
import com.contusfly.databinding.ActivityEditMessageBinding
import com.contusfly.emptyString
import com.contusfly.getDisplayName
import com.contusfly.gone
import com.contusfly.groupmention.MentionUser
import com.contusfly.groupmention.MentionUtils
import com.contusfly.interfaces.OnChatItemClickListener
import com.contusfly.isGroupChat
import com.contusfly.models.Chat
import com.contusfly.models.EditMessageParams
import com.contusfly.showSoftKeyboard
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.utils.Utils
import com.contusfly.views.CustomItemDecoration
import com.contusfly.views.KeyboardHeightProvider
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycommons.models.MessageType
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import dagger.android.AndroidInjection
import io.github.rockerhieu.emojicon.EmojiconGridFragment
import io.github.rockerhieu.emojicon.EmojiconsFragment
import io.github.rockerhieu.emojicon.emoji.Emojicon

class EditMessageActivity : EditChatParent(), View.OnTouchListener,
    EmojiconsFragment.OnEmojiconBackspaceClickedListener,
    EmojiconGridFragment.OnEmojiconClickedListener, GroupTagAdapter.UserTagClickListener,
    View.OnClickListener,
    OnChatItemClickListener {

    private var keyboardHeightProvider: KeyboardHeightProvider? = null
    private val TAG = EditMessageActivity::class.java.simpleName
    private var mentionFilterKey: String = emptyString()
    private var handler: Handler? = null
    private var unSentMentionedUserIdList=ArrayList<ProfileDetails>()
    private var sendTextMessageWithMentionFormat = Constants.EMPTY_STRING
    private var mentionedUsersIds: MutableList<String> = mutableListOf()
    private val NOT_YET_IMPLEMENTED_MESSAGE = "Not yet implemented"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = ActivityEditMessageBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_edit_message)
        keyboardHeightProvider = KeyboardHeightProvider(this)
        keyboardHeightProvider?.addKeyboardListener(getKeyboardListener())
        handler = Handler(Looper.getMainLooper())
        intent()
        initViews()
        initClickListeners()
        initEditMessageGroupTag()
        initEditMessageAdapter()
    }

    private fun intent(){
        val mainIntent = intent
        toUser = mainIntent.getStringExtra(LibConstants.JID) ?: Constants.EMPTY_STRING
        chatType = mainIntent.getStringExtra(Constants.CHAT_TYPE) ?: Constants.EMPTY_STRING
        messageId = mainIntent.getStringExtra(Constants.MESSAGE_ID)?:Constants.EMPTY_STRING
        chat = Chat(chatType, toUser)
    }

    private fun initEditMessageAdapter() {
        val message = getMessage()
        if (message != null) {
            mainList.add(message)
            chatAdapter = ChatAdapter(mainList, arrayListOf(), chat.chatType, this, toUser,true, listChats)
            chatAdapter.hasStableIds()
            listChats.adapter = chatAdapter
            setMessageInEditText(message)
            handler?.postDelayed({
                handleCursorAndKeyboardVisibility()

            }, 500)
        }
    }

    private fun setMessageInEditText(message: ChatMessage) {
        when (message.messageType) {
            MessageType.TEXT,MessageType.AUTO_TEXT -> {
                setTextTypeContent(message)
            }

            MessageType.IMAGE, MessageType.VIDEO -> {
                setMediaTypeContent(message)
            }
            else -> {
                // do nothing
            }
        }
    }

    private fun setTextTypeContent(message: ChatMessage){
        val txtMessage = message.messageTextContent
        if (message.mentionedUsersIds!=null && message.mentionedUsersIds.size > 0) {
            val text = MentionUtils.formatUnSentMentionText(
                message.mentionedUsersIds as java.util.ArrayList<ProfileDetails?>,
                txtMessage,
                this,
                chatMessageEditText
            )
            originalMessage = TextUtils.concat(text.trim(), " ").toString()
            chatMessageEditText.setText(TextUtils.concat(text.trim(), " "))
        }else{
            originalMessage = txtMessage
            chatMessageEditText.setText(txtMessage)
        }
    }

    private fun setMediaTypeContent(message: ChatMessage){
        val txtMessage =message.mediaChatMessage.mediaCaptionText
        if (message.mentionedUsersIds!=null && message.mentionedUsersIds.size > 0) {
            val text = MentionUtils.formatUnSentMentionText(
                message.mentionedUsersIds as java.util.ArrayList<ProfileDetails?>,
                txtMessage,
                this,
                chatMessageEditText
            )
            originalMessage = TextUtils.concat(text.trim(), " ").toString()
            chatMessageEditText.setText(TextUtils.concat(text.trim(), " "))
        }else{
            originalMessage = txtMessage
            chatMessageEditText.setText(txtMessage)
        }
    }

    private fun sendEditedContent(){
        val mentionedUsersIds = ChatUtils.setSelectedUserIdForMention(
            chatMessageEditText.mentionedUsers,
            mentionedUsersIds
        )
        sendTextMessageWithMentionFormat = if (mentionedUsersIds.isNotEmpty()) {
            chatMessageEditText.mentionedTemplate.toString()
        } else {
            chatMessageEditText.text.toString().trim()
        }
        if (isValidToSendEditedMessage()) {
            val editedMessage = EditMessageParams(
                mainList[0].messageType,
                mainList[0].messageId,
                sendTextMessageWithMentionFormat.trim(), mentionedUsersIds
            )
            val resultIntent = Intent().apply {
                putExtra(Constants.EDITED_RESULT_DATA, editedMessage)
            }
            setResult(Activity.RESULT_OK,resultIntent)
        }
        finish()
    }

    private fun isValidToSendEditedMessage(): Boolean { // if chatEditBox content and original message are same, no need to sendEditedMessage
        val message = getMessage()
        if (message != null && !message.isMessageRecalled) {
            return chatMessageEditText.text.toString().trim() != originalMessage.trim()
        }
        return false
    }

    private fun initClickListeners(){
        imgSend.setOnClickListener(this)
        back.setOnClickListener(this)
        emojiHandler.attachKeyboardListeners(chatMessageEditText)
        emojiHandler.setIconImageView(smiley)
        emojiHandler.setHandledFrom(TAG)
        chatMessageEditText.setOnClickListener(this)
        smiley.setOnClickListener(this)
        chatMessageEditText.setOnLongClickListener {
            if(emojiHandler.isEmojiShowing) {
                emojiHandler.hideEmoji()
                chatMessageEditText.requestFocus()
                chatMessageEditText.showSoftKeyboard()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
                showChatKeyboard = false
            }
            false
        }

    }

    private fun handleCursorAndKeyboardVisibility() {
        if (showChatKeyboard) {
            chatMessageEditText.requestFocus()
            showSoftKeyboard(this)
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        } else {
            chatMessageEditText.requestFocus()
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        }
        if(chatMessageEditText.text!=null && chatMessageEditText.text!!.length>0){
            chatMessageEditText.setSelection(chatMessageEditText.text!!.length)
        }
        chatMessageEditText.requestFocus()
        showSoftKeyboard(this)
        chatMessageEditText.showSoftKeyboard()
    }

    private fun initEditMessageGroupTag() {
        if (chat.isGroupChat()) {
            Log.e(TAG, "#chat initGroupTag: group chat")
            mentionViewModelEditMessage.setUserJid(chat.toUser)
            mentionViewModelEditMessage.getParticipantsHashMap(chat.toUser)
            groupTagAdapter = GroupTagAdapter(this, this)
            groupTagRecycler.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            groupTagRecycler.addItemDecoration(CustomItemDecoration(this))
            groupTagRecycler.adapter = groupTagAdapter
            bindUserMention(userMentionConfig) { text  ->
                if(chat.isGroupChat() && text != null && isSoftKeyboardShown) {
                    isMentionTriggered = true
                    mentionFilterKey = text.toString()
                    filterGroupListTag(text)
                } else {
                    hideGroupMentionMembersList()
                }
            }
        }
        mentionViewModelEditMessage.groupUsers.observe(this) {
            groupTagAdapter.submitList(it)
            setMentionPopupBackground()
        }
        mentionViewModelEditMessage.getSelectedRecipient().observe(this) { profile ->
            unSentMentionedUserIdList.add(profile)
            FlyMessenger.saveUnsentMentionedUserId(chat.toUser,
                ChatUtils.toUserList(unSentMentionedUserIdList)!!
            )
            val name = Utils.returnEmptyStringIfNull(profile.getDisplayName())
            val userId = getUserFromJid(profile.jid)
            val mentionUser  = MentionUser(userId)
            chatMessageEditText.replaceText(name,mentionUser)
        }
    }

    private fun filterGroupListTag(text: CharSequence){
        if (mentionFilterKey.isNotEmpty()) {
            groupTagAdapter.filter.filter(mentionFilterKey
            ) { filteredResult ->
                if (filteredResult == 0 && isGroupMemberListShowing) {
                    hideGroupMentionMembersList()
                }else if(filteredResult!=0 && isSoftKeyboardShown){
                    setMentionPopupBackground()
                }
            }
        } else {
            if ((text.length >= 1 && text.substring(0).contains("")))
                hideGroupMentionMembersList()
            else
                mentionViewModelEditMessage.getParticipantsHashMap(chat.toUser)
        }
    }

    private fun setMentionPopupBackground(){
        if( groupTagAdapter.itemCount > 0 && isSoftKeyboardShown && isMentionTriggered) {
            viewChat.background = ContextCompat.getDrawable(
                this@EditMessageActivity,
                R.drawable.bg_chat_footer_shape_mention
            )
            viewChildLayout.background =
                ContextCompat.getDrawable(this@EditMessageActivity, R.drawable.bg_shadow)
            chatFooterDivider.visibility = View.GONE
            groupUserTagLayout.visibility = View.VISIBLE
            isGroupMemberListShowing=true
        } else {
            hideGroupMentionMembersList()
        }
    }

    fun getUserFromJid(jid: String): String {
        var user =com.mirrorflysdk.flycommons.Constants.EMPTY_STRING
        val endIndex = jid.lastIndexOf('@')
        if (endIndex != -1) {
            user = jid.substring(0, endIndex)
        }
        return user
    }

    private fun hideGroupMentionMembersList(){
        groupTagAdapter.clearList()
        isMentionTriggered = false
        isGroupMemberListShowing=false
        viewChat.background = ContextCompat.getDrawable(
            this@EditMessageActivity,
            R.drawable.bg_chat_footer_shape
        )
        viewChildLayout.background = null
        groupUserTagLayout.visibility = View.GONE
        chatFooterDivider.visibility = View.VISIBLE
    }



    private fun getKeyboardListener() = KeyboardHeightProvider.KeyboardListener { height -> softKeyboardHeight = height }

    private fun getMessage(): ChatMessage? {
        return if (!messageId.isNullOrEmpty()) FlyMessenger.getMessageOfId(messageId) else null
    }

    override fun onBackPressed() {
        if (emojiHandler.isEmojiShowing && !isBackPressed) {
            emojiHandler.hideEmoji()
        } else {
          finish()
        }
    }

    override fun onTouch(v: View, event: MotionEvent?): Boolean {
        if (v.id == R.id.edit_chat_msg && MotionEvent.ACTION_UP == event!!.action && emojiHandler.isEmojiShowing)
            emojiHandler.hideEmoji()
        return false
    }

    override fun onEmojiconBackspaceClicked(v: View?) {
        EmojiconsFragment.backspace(chatMessageEditText)
    }

    override fun onEmojiconClicked(emojicon: Emojicon?) {
        EmojiconsFragment.input(chatMessageEditText, emojicon)
    }

    override fun usersIBlockedListFetched(jidList: List<String>) {
        super.usersIBlockedListFetched(jidList)
        if (jidList.isNotEmpty() && chat.toUser == jidList[0])
            finish()
    }

    override fun onMemberRemovedFromGroup(
        groupJid: String,
        removedMemberJid: String,
        removedByMemberJid: String,
    ) {
        super.onMemberRemovedFromGroup(groupJid, removedMemberJid, removedByMemberJid)
        if (removedMemberJid == SharedPreferenceManager.getCurrentUserJid())
            finish()
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        if (chat.toUser == jid && status)
            finish()
    }
    override fun onUserTagClicked(profileDetails: ProfileDetails) {
        groupTagRecycler.layoutManager = LinearLayoutManager(this)
        groupTagRecycler.adapter = groupTagAdapter
        groupTagRecycler.itemAnimator = null
        groupUserTagLayout.gone()
        chatFooterDivider.visibility = View.VISIBLE
        mentionViewModelEditMessage.onSelectionChange(profileDetails)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.image_chat_send -> {
                sendEditedContent()
            }
            R.id.image_chat_smiley -> {
                hideKeyboard()
                emojiHandler.setKeypad(chatMessageEditText)
            }
            R.id.back ->{
                onBackPressed()
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDownloadClicked(item: ChatMessage) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onCancelDownloadClicked(messageItem: ChatMessage) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onCancelUploadClicked(messageItem: ChatMessage) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onRetryClicked(item: ChatMessage?) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onSenderItemClicked(item: ChatMessage?, position: Int) {
        // do nothing
    }

    override fun onHandleStarredItemMediaClickToAction(item: ChatMessage?, position: Int) {
        // do nothing
    }

    override fun onReceiverItemClicked(item: ChatMessage?, position: Int) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onSenderItemLongClick(item: ChatMessage?, position: Int) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onReceiverItemLongClick(item: ChatMessage?, position: Int) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onReplyMessageClick(messageId: String) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onSenderMediaForward(item: ChatMessage, position: Int) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onContactClick(
        item: ChatMessage,
        position: Int,
        registeredJid: String?,
        isSavedContact: Boolean,
    ) {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun onAudioPlayed() {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }

    override fun mediaPermissionCheck() {
        TODO(NOT_YET_IMPLEMENTED_MESSAGE)
    }


}