package com.contusfly.adapters

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.contusfly.*

import androidx.recyclerview.widget.RecyclerView
import com.contusfly.adapters.holders.ArchiveChatViewHolder
import com.contusfly.adapters.holders.PaginationLoaderViewHolder
import com.contusfly.databinding.RowLayoutArchivedBinding
import com.contusfly.databinding.RowLayoutLoaderBinding
import com.contusfly.databinding.RowRecentChatItemBinding
import com.contusfly.utils.*
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.utils.Utils
import com.jakewharton.rxbinding3.view.clicks
import com.mirrorflysdk.api.contacts.ContactManager
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import java.util.concurrent.TimeUnit

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class RecentChatListAdapter(val context: Context, val mainlist: LinkedList<RecentChat>, private val selectedChats: List<RecentChat>,
                            private val typingAndGoneStatus: ArrayList<Triple<String, String, Boolean>>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var userBlockedMe = false

    private var messageContent: String? = null

    private var msgType: String? = null

    private var archiveChatStatus: Triple<Boolean, Boolean, Int>? = null

    private var isLoading:Boolean=false


    inner class RecentChatViewHolder(var viewBinding : RowRecentChatItemBinding) : RecyclerView.ViewHolder(viewBinding.root){
        val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

        init {
            val disposabe = viewBinding.imageChatPicture.clicks().throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe {
                if (layoutPosition >= 0 && (mainlist[layoutPosition].profileStatus == null
                            || mainlist[layoutPosition].profileStatus
                            != context.getString(R.string.offline_group_status)))
                    onProfileIconClicked(layoutPosition)
            }
            compositeDisposable.add(disposabe)
        }
    }

    lateinit var onProfileIconClicked: (Int) -> Unit

    fun onProfileClickedCallback(fn: (Int) -> Unit) {
        onProfileIconClicked = fn
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER, TYPE_FOOTER  -> {
                val binding = RowLayoutArchivedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ArchiveChatViewHolder(binding, parent.context)
            }
            TYPE_LOADER  -> {
                val binding = RowLayoutLoaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PaginationLoaderViewHolder(binding, parent.context)
            }
            else -> {
                val binding = RowRecentChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecentChatViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            mainlist.size - 2 -> TYPE_FOOTER
            mainlist.size - 1 -> TYPE_LOADER
            else -> TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
          if (holder is ArchiveChatViewHolder) {
            if (archiveChatStatus == null) {
                holder.hideView()
            } else {
                holder.bindValues(archiveChatStatus!!, position)
            }
        } else if(holder is PaginationLoaderViewHolder){
            holder.bindValues(isLoading)
        } else {
              val binding = holder as RecentChatViewHolder
              val item = mainlist[position]
              setUserView(item, binding.viewBinding)
              setMessageView(item, binding.viewBinding, position)
              setSelected(binding.itemView, item)
              setPinnedIcon(item, binding.viewBinding)
              switchBetweenMuteUnmute(item, binding.viewBinding)
              if (position == mainlist.size - 1) {
                  holder.viewBinding.viewDivider.visibility = View.GONE
              } else {
                  holder.viewBinding.viewDivider.visibility = View.VISIBLE
              }
          }
    }

    private fun setPinnedIcon(item: RecentChat, holder: RowRecentChatItemBinding) {
        if (item.isChatPinned && context.javaClass.simpleName != "ForwardMessageActivity")
            holder.pin.show()
        else holder.pin.gone()
    }

    private fun setUnreadIcon(recent: RecentChat, holder: RowRecentChatItemBinding) {
        holder.run {
            val unSeenCount = recent.unreadMessageCount
            /* Check unseen messages for single user/group to show/hide unseen message count. */
            if (unSeenCount != 0) {
                holder.textChatTime.setTextColor(ContextCompat.getColor(context, R.color.colorSecondary))
                holder.textUnseenCount.show()

                //changes text size
                holder.textUnseenCount.textSize = 9f
                holder.textUnseenCount.text = returnFormattedCount(unSeenCount)
            } else {
                holder.textChatTime.setTextColor(ContextCompat.getColor(context, R.color.color_chat_list_time))
                holder.textUnseenCount.text = ""
                holder.textUnseenCount.visibility = if (recent.isConversationUnRead) View.VISIBLE else View.GONE
            }
        }
    }

    fun setArchiveStatus(archiveChatStatus: Triple<Boolean, Boolean, Int>){
        this.archiveChatStatus = archiveChatStatus
        notifyItemChanged(0)
        notifyItemChanged(mainlist.size - 2)
    }

    fun setLoader(isLoading:Boolean){
        this.isLoading = isLoading
        notifyItemChanged(mainlist.size - 1)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty())
            onBindViewHolder(holder, position)
        else {
            if (holder is RecentChatViewHolder) {
                val item = mainlist[position]
                val bundle = payloads[0] as Bundle
                handlePayloads(bundle, holder, item, position)
            }
        }
    }

    private fun handlePayloads(bundle: Bundle, holder: RecentChatViewHolder, item: RecentChat, position: Int) {
        for (key in bundle.keySet()) {
            if (key == Constants.NOTIFY_MESSAGE || key == Constants.NOTIFY_MSG_TYPING
                    || key == Constants.NOTIFY_MESSAGE_UPDATE) {
                setMessageView(item, holder.viewBinding, position)
            } else if (key == Constants.NOTIFY_USER_NAME) {
                updateName(item, holder)
            } else if (key == Constants.NOTIFY_PROFILE_ICON) {
                setUserView(item, holder.viewBinding)
            } else if (key == Constants.NOTIFY_SELECTION) {
                setSelected(holder.itemView, item)
            } else if (key == Constants.NOTIFY_PINNED_ICON) {
                setPinnedIcon(item, holder.viewBinding)
            } else if (key == Constants.NOTIFY_MUTE_UNMUTE) {
                switchBetweenMuteUnmute(item, holder.viewBinding)
                setSelected(holder.itemView, item)
            } else if (key == Constants.NOTIFY_UNREAD_ICON) {
                setUnreadIcon(item, holder.viewBinding)
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return when (position) {
            0 -> "header".hashCode().toLong()
            mainlist.size - 2 -> "footer".hashCode().toLong()
            mainlist.size - 1 -> "loader".hashCode().toLong()
            else -> getitemId(position)
        }
    }

    private fun getitemId(position: Int) : Long {
        var item:Long=-1
        if(mainlist[position].jid != null){
            item= mainlist[position].jid.hashCode().toLong()
        }
        return item
    }

    override fun getItemCount(): Int {
        return mainlist.size
    }

    /**
     * Selected view when long press it
     *
     * @param view Instance of the view
     * @param item Recent chat item
     */
    private fun setSelected(view: View, item: RecentChat) {
        var backGroundColor = android.R.color.transparent
        if (selectedChats.any { it.jid == item.jid })
            backGroundColor = R.color.color_transparent_bg
        view.setBackgroundColor(ContextCompat.getColor(context, backGroundColor))
    }

    /**
     * Format the number count for 100 plus
     *
     * @param count Count
     * @return String Formatted number count for 100 plus
     */
    private fun returnFormattedCount(count: Int): String {
        return if (count > 99) "99+" else count.toString()
    }

    /**
     * Set the user view for the recent chat items Set the user information or users from the normal users.
     *
     * @param recent Instance of RecentChat
     * @param holder Instance of the view holder
     */
    private fun setUserView(recent: RecentChat, holder: RowRecentChatItemBinding) {
        setRecentChatImage(holder, recent)
        holder.emailContactIcon.gone()
    }

    private fun updateName(recent: RecentChat?, holder: RecentChatViewHolder) {
        recent?.let {
            holder.viewBinding.textChatName.text = it.profileName
        }
    }

    /**
     * Set the message view of the recent chat users. get the message object and display based on text or Message type
     *
     * @param recent Instance of RecentChat
     * @param holder Instance of the holder view
     */
    private fun setMessageView(recent: RecentChat, holder: RowRecentChatItemBinding, position: Int) {
        if (!recent.lastMessageId.isNullOrBlank() && isValidMessage(recent.lastMessageId)) {
            val chatMessage: ChatMessage = FlyMessenger.getMessageOfId(recent.lastMessageId)!!
            setMessageData(holder, chatMessage, recent, position)
        } else {
            if(recent.isConversationUnRead)
                setUnreadIcon(recent,holder)
            // when user cleared chat there will be no associated message object for recent
            holder.textChatPerson.text = ""
            holder.textChatMessage.text = ""
            holder.textChatTime.text = ""
            holder.imageChatStatus.gone()
            holder.imageMediaType.gone()
            holder.textUnseenCount.text = ""
            if(!recent.isConversationUnRead)
                holder.textUnseenCount.gone()
            holder.textChatPerson.gone()
        }
    }

    private fun isValidMessage(lastMessageId: String): Boolean {
        val message = FlyMessenger.getMessageOfId(lastMessageId)
        return message != null && !message.isMessageDeleted()
    }

    /**
     * Set the message data from the message view
     *
     * @param holder  Holder of the view
     * @param chatMessage Message object
     * @param recent  Instance of RecentChat
     */
    private fun setMessageData(holder: RowRecentChatItemBinding, chatMessage: ChatMessage?, recent: RecentChat, position: Int) {
        val isFromSender = chatMessage!!.isMessageSentByMe
        val isRecall = chatMessage.isMessageRecalled
        val chatTimeOperations = ChatTimeOperations(Calendar.getInstance())
        val time = chatTimeOperations.getRecentChatTime(context, chatMessage.getMessageSentTime())
        holder.textChatTime.text = time
        setUnreadIcon(recent, holder)
        try {
            setUserTypingList(holder, chatMessage, isFromSender, isRecall, position, recent)
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Set message type on recent chat view...
     *
     * @param holder       Recent view holder
     * @param chatMessage      Message content for recent view
     * @param isFromSender Sender message or receiver message
     * @param isRecall     Does recall is applicable
     */
    private fun setUserTypingList(holder: RowRecentChatItemBinding, chatMessage: ChatMessage?,
                                  isFromSender: Boolean, isRecall: Boolean, position: Int, recent: RecentChat) {
        try {
            if (isRecall) {
                msgType = Constants.MSG_TYPE_TEXT
                messageContent = setRecalledMessageText(holder, isFromSender)
            } else {
                messageContent = recent.lastMessageContent
                if (chatMessage!!.messageChatType.name == Constants.GROUP_CHAT && !isFromSender && recent.profileName != chatMessage.senderUserName &&
                        !recent.lastMessageType.equals(Constants.MSG_TYPE_NOTIFICATION, ignoreCase = true)) {
                    setGroupMessageSenderName(holder, chatMessage)
                } else holder.textChatPerson.visibility = View.GONE
                msgType = chatMessage.messageType.name
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }

        val item = mainlist[position]
        val isTypingStatusAvailable = typingAndGoneStatus.indexOfFirst { it.first == item.jid }
        if (isTypingStatusAvailable.isValidIndex()) {
            setUserTypingStatus(holder, item, isTypingStatusAvailable)
            holder.imageChatStatus.gone()
            holder.imageMediaType.gone()
        } else if (recent.isGroupInOfflineMode) {
            holder.textChatMessage.text = context.resources.getString(R.string.offline_group_status)
            holder.imageChatStatus.gone()
            holder.imageMediaType.gone()
        } else if (!msgType.isNullOrBlank()) {
            when {
                Constants.MSG_TYPE_TEXT.equals(msgType, ignoreCase = true) -> {
                    holder.imageMediaType.gone()
                    setDataForTextMessage(chatMessage,holder,isRecall)
                }
                Constants.MSG_TYPE_NOTIFICATION.equals(msgType, ignoreCase = true) -> {
                    holder.textChatMessage.text = messageContent
                    holder.imageMediaType.gone()
                }
                else -> {
                    holder.imageMediaType.show()
                    setImageStatus(holder, msgType!!.toLowerCase(Locale.getDefault()), messageContent, chatMessage,chatMessage?.mediaChatMessage?.isAudioRecorded() ?: false)
                }
            }
            setChatStatus(holder, chatMessage, isFromSender, isRecall)
        }
    }

    private fun setDataForTextMessage(chatMessage: ChatMessage?,holder: RowRecentChatItemBinding, isRecall: Boolean){
        if(chatMessage?.mentionedUsersIds != null && chatMessage.mentionedUsersIds.size > 0 && !isRecall)
            holder.textChatMessage.text =ChatUtils.setMentionFormattedTextForRecentChat(context, chatMessage)
        else  holder.textChatMessage.setTextKeepState(getSpannedText(messageContent))
    }

    private fun setGroupMessageSenderName(
        holder: RowRecentChatItemBinding,
        chatMessage: ChatMessage
    ) {
        holder.textChatPerson.visibility = View.VISIBLE
        if((Utils.returnEmptyStringIfNull(chatMessage.senderUserName)).split(" ").size ==1)
            holder.textChatPerson.text = Utils.returnEmptyStringIfNull(chatMessage.senderUserName) + ":"
        else{
            val userName = Utils.returnEmptyStringIfNull(chatMessage.senderUserName).split(" ")[0] +" "+
                    Utils.returnEmptyStringIfNull(chatMessage.senderUserName).split(" ")[1]
            holder.textChatPerson.text = Utils.returnEmptyStringIfNull(userName) + ":"
        }
    }

    private fun setChatStatus(holder: RowRecentChatItemBinding, chatMessage:ChatMessage?, isFromSender: Boolean, isRecall: Boolean) {
        if (isFromSender && !isRecall && !Constants.MSG_TYPE_NOTIFICATION.equals(msgType, ignoreCase = true)) {
            holder.imageChatStatus.show()
            ChatMessageUtils.setChatStatus(holder.imageChatStatus, chatMessage!!.messageStatus.status)
        } else {
            holder.imageChatStatus.gone()
        }
    }

    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private fun getSpannedText(message: String?): Spanned {
        val chatMessage = (message)?.replace("\n", "<br>")?.replace(" ", "&nbsp;") ?: emptyString()
        val htmlText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Html.fromHtml((chatMessage), Html.FROM_HTML_MODE_LEGACY)
        else Html.fromHtml((chatMessage))

        return if (htmlText.isEmpty() && chatMessage != "")
            SpannableStringBuilder((chatMessage)) else htmlText
    }

    /**
     * Set the typing status in recent chat while the users typing
     *
     * @param holder The holder for the recent chat view
     * @param recent Instance of RecentChat
     */
    private fun setUserTypingStatus(holder: RowRecentChatItemBinding, recent: RecentChat, indexOfTypingStatus: Int) {
        holder.textChatPerson.visibility = View.GONE
        if (recent.isGroup) {
            val typingUser = ProfileDetailsUtils.getProfileDetails(typingAndGoneStatus[indexOfTypingStatus].second)
            val userName = if((Utils.returnEmptyStringIfNull(typingUser?.getDisplayName())).split(" ").size ==1)
                Utils.returnEmptyStringIfNull(typingUser?.getDisplayName()) + ":"
            else{
                Utils.returnEmptyStringIfNull(typingUser?.getDisplayName()).split(" ")[0] +" "+
                        Utils.returnEmptyStringIfNull(typingUser?.getDisplayName()).split(" ")[1]

            }
            val typingText = (userName + " " + context.resources.getString(R.string.msg_typing))

            holder.textChatMessage.text = typingText
        } else holder.textChatMessage.text = context.resources.getString(R.string.msg_typing)
    }

    /**
     * Sets the text to be displayed.
     *
     * @param holder       The view holding the child items.
     * @param isFromSender Boolean stating whether the recall is either from sender or receiver.
     * @return The information about the recalled message.
     */
    private fun setRecalledMessageText(holder: RowRecentChatItemBinding, isFromSender: Boolean): String {
        return if (isFromSender) {
            holder.imageChatStatus.gone()
            holder.imageMediaType.gone()
            context.resources.getString(R.string.single_chat_sender_recall)
        } else context.resources.getString(R.string.single_chat_receiver_recall)
    }

    /**
     * Set the image view of the recent chat for user, broadcast, group chat
     *
     * @param holder Instance of the RecentViewHolder
     * @param recent Instance of the RecentChat
     */
    private fun setRecentChatImage(holder: RowRecentChatItemBinding, recent: RecentChat) {
        if (!recent.isGroup)
            userBlockedMe = recent.isBlockedMe
        holder.imageChatPicture.loadUserProfileImage(context, recent)
        var profile=ContactManager.getProfileDetails(recent.jid)
        LogMessage.e("Error","${profile!!.contactType}")
        holder.textChatName.text = recent.profileName
    }

    /**
     * Sets the image status of the chat type => Image
     *
     * @param holder  The holder for the recent chat view
     * @param msgType Message type
     */
    private fun setImageStatus(holder: RowRecentChatItemBinding, msgType: String, messageContent: String?,chatMessage: ChatMessage?,audioRecorded: Boolean) {
        when (msgType) {
             Constants.MSG_TYPE_AUDIO -> {
                holder.imageMediaType.setImageResource(if (audioRecorded) R.drawable.ls_ic_record else R.drawable.ls_ic_music)
                holder.textChatMessage.text = context.getString(R.string.title_audio)
            }
            Constants.MSG_TYPE_VIDEO -> {
                holder.imageMediaType.setImageResource(R.drawable.ls_ic_video)
                setCaptionForImageAndVideo(chatMessage,holder,messageContent,context.getString(R.string.title_video))
            }
            Constants.MSG_TYPE_IMAGE -> {
                holder.imageMediaType.setImageResource(R.drawable.ls_ic_camera)
                setCaptionForImageAndVideo(chatMessage,holder,messageContent,context.getString(R.string.title_image))
            }
            Constants.MSG_TYPE_LOCATION -> {
                holder.imageMediaType.setImageResource(R.drawable.ls_ic_location)
                holder.textChatMessage.text = context.getString(R.string.action_location)
            }
            Constants.MSG_TYPE_CONTACT -> {
                holder.imageMediaType.setImageResource(R.drawable.ls_ic_contact)
                holder.textChatMessage.text = context.getString(R.string.action_contact)
            }
            Constants.MSG_TYPE_FILE -> {
                holder.imageMediaType.setImageResource(R.drawable.ls_ic_file)
                holder.textChatMessage.text = context.getString(R.string.title_document)
            }
            else -> holder.imageMediaType.gone()
        }
    }

    private fun setCaptionForImageAndVideo(chatMessage: ChatMessage?,holder:RowRecentChatItemBinding,
                                           messageContent:String?,mediaType: String){
        if (messageContent!!.isNotEmpty())
            if(chatMessage?.mentionedUsersIds != null && chatMessage.mentionedUsersIds.size > 0)
                holder.textChatMessage.text = ChatUtils.setMentionFormattedTextForRecentChat(context,chatMessage)
            else
                holder.textChatMessage.text = messageContent
        else holder.textChatMessage.text = mediaType
    }

    /**
     * Mute status Icon Showing Recent chat
     *
     * @param recent Instance of RecentChat
     * @param holder Instance of the view holder
     */
    private fun switchBetweenMuteUnmute(recent: RecentChat, holder: RowRecentChatItemBinding) {
        if (recent.isMuted && FlyCore.isUserUnArchived(recent.jid)) holder.mute.show() else holder.mute.gone()
    }

    companion object{
        private const val TYPE_HEADER = 0
        private const val TYPE_FOOTER = 1
        private const val TYPE_ITEM = 2
        private const val TYPE_LOADER = 3

    }
}