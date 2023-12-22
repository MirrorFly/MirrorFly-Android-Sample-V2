package com.contusfly.starredMessages.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.*
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.*
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_AUDIO_RECEIVER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_AUDIO_SENDER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_CONTACT_RECEIVER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_CONTACT_SENDER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_FILE_RECEIVER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_FILE_SENDER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_IMAGE_RECEIVER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_IMAGE_SENDER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_LOCATION_RECEIVER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_LOCATION_SENDER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_MEET_RECEIVER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_MEET_SENDER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_TEXT_RECEIVER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_TEXT_SENDER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_VIDEO_RECEIVER
import com.contusfly.adapters.ChatAdapter.Companion.TYPE_VIDEO_SENDER
import com.contusfly.adapters.ChatAdapterHelper
import com.contusfly.adapters.holders.*
import com.contusfly.adapters.viewhelpers.AudioItemView
import com.contusfly.adapters.viewhelpers.FileItemView
import com.contusfly.adapters.viewhelpers.ImageItemViewHelper
import com.contusfly.adapters.viewhelpers.VideoItemViewHelper
import com.contusfly.chat.MapUtils
import com.contusfly.chat.MediaController
import com.contusfly.chat.reply.ReplyMessageUtils
import com.contusfly.chat.reply.ReplyViewUtils
import com.contusfly.groupmention.MentionUtils
import com.contusfly.interfaces.MessageItemListener
import com.contusfly.interfaces.OnChatItemClickListener
import com.contusfly.models.ChatItemRowModel
import com.contusfly.models.MediaCaption
import com.contusfly.models.MediaStatus
import com.contusfly.utils.*
import com.contusfly.utils.ChatUtils.setSelectedChatItem
import com.contusfly.utils.Constants
import com.contusfly.utils.ImageUtils.loadMapWithGlide
import com.contusfly.utils.LogMessage
import com.contusfly.utils.MediaUtils.loadImageWithGlideSecure
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.api.ChatManager.getUserProfileName
import com.mirrorflysdk.api.FlyMessenger.cancelMediaUploadOrDownload
import com.mirrorflysdk.api.MessageStatus
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.ContactChatMessage
import com.mirrorflysdk.utils.Utils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class StarredMessagesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(), MessageItemListener {

    private val SENDER_HEADER = 1

    private val RECEIVER_HEADER = 2

    /**
     * Text reply view utils
     */
    private var replyViewUtils: ReplyViewUtils? = null

    /**
     * object holds file view item details
     */
    private var fileItemView: FileItemView? = null

    /**
     * The listener instance of OnChatItemClickListener
     */
    private var listener: OnChatItemClickListener? = null

    /**
     * The list of chat data
     */
    private var starredMessageData= mutableListOf<ChatMessage>()

    /**
     * The media controller which used to play the audio in the chat view
     */
    private var mMediaController: MediaController? = null

    /**
     * The startupActivityContext of the list view activity
     */
    private var context: Context? = null

    /**
     * Chat message common methods will be available here
     */
    private var chatStarredMessageUtils: ChatMessageUtils? = null

    /**
     * Store the selected messages in the long press
     */
    private var starredMessageMessages: List<String>? = null

    private var chatAdapterHelper: ChatAdapterHelper? = null

    /**
     * Media details
     */
    private var mediaDetailUtils: MediaDetailUtils? = null

    /**
     * Image item view
     */
    private var starredImageItemViewHelper: ImageItemViewHelper? = null

    /**
     * Helper class for video item view
     */
    private var starredVideoItemViewHelper: VideoItemViewHelper? = null

    /**
     * Audio item view
     */
    private var starredAudioItemView: AudioItemView? = null

    private var inflater: LayoutInflater? = null

    private var setDrawable: SetDrawable? = null

    /**
     * Instantiates a new adapter chat data.
     *
     * @param context The startupActivityContext of the activity
     */
    fun setAdapterData(context: Context) {
        this.context = context
        mMediaController = MediaController(context)
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        chatAdapterHelper = ChatAdapterHelper(inflater)
        replyViewUtils = ReplyViewUtils()
        mediaDetailUtils = MediaDetailUtils
        fileItemView = FileItemView(this)
        starredVideoItemViewHelper = VideoItemViewHelper(context, this)
        starredImageItemViewHelper = ImageItemViewHelper(context, this)
        chatStarredMessageUtils = ChatMessageUtils
        starredAudioItemView = AudioItemView(this)
        setDrawable = SetDrawable(context)
    }

    private var searchEnabled = false
    private var searchKey = emptyString()

    fun setSearch(isSearchEnabled: Boolean, searchKey: String) {
        this.searchEnabled = isSearchEnabled
        this.searchKey = searchKey
    }

    /**
     * Sets the on download click listener.
     *
     * @param listener The listener when the chat item download clicked
     */
    fun setOnStarredMessageDownloadClickListener(listener: OnChatItemClickListener?) {
        this.listener = listener
    }

    /**
     * Sets the Chat Messages in the adapter.
     *
     * @param starredMessages List of chat messages
     */
    fun setStarredMessages(starredMessages: List<ChatMessage>) {
        starredMessageData = starredMessages as MutableList<ChatMessage>
    }

    /**
     * Set the selected messages from the chat view for displaying the different color
     *
     * @param starredMessageMessages Selected message list
     */
    fun setStarredMessageMessages(starredMessageMessages: List<String>?) {
        this.starredMessageMessages = starredMessageMessages
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return chatAdapterHelper!!.getItemViewHolder(parent, viewType)!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            val item = starredMessageData[position]
            when (holder.itemViewType) {
                TYPE_TEXT_SENDER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredTextViewSender(holder, item, position)
                }
                TYPE_TEXT_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredTextViewReceiver(holder, item, position)
                }

                TYPE_MEET_SENDER->{
                    showSenderNameIfGroupChat(holder, position)
                    getStarredMeetViewSender(holder, item, position)

                }
                TYPE_MEET_RECEIVER->{
                    showSenderNameIfGroupChat(holder, position)
                    getStarredMeetViewReceiver(holder, item, position)

                }

                TYPE_IMAGE_SENDER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredImageViewSender(holder, item, position)
                }
                TYPE_IMAGE_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredImageViewReceiver(holder, item, position)
                }
                TYPE_VIDEO_SENDER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredVideoViewSender(holder, item, position)
                }
                TYPE_VIDEO_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredVideoViewReceiver(holder, item, position)
                }
                TYPE_LOCATION_SENDER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredLocationViewSender(holder, item, position)
                }
                TYPE_LOCATION_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredLocationViewReceiver(holder, item, position)
                }
                TYPE_AUDIO_SENDER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredAudioViewSender(holder, item, position)
                }
                TYPE_AUDIO_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredAudioViewReceiver(holder, item, position)
                }
                TYPE_FILE_SENDER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredFileViewSender(holder, item, position)
                }
                TYPE_FILE_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredFileViewReceiver(holder, item, position)
                }
                TYPE_CONTACT_SENDER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredContactViewSender(holder, item, position)
                }
                TYPE_CONTACT_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, position)
                    getStarredContactViewReceiver(holder, item, position)
                }
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return chatAdapterHelper!!.getItemViewType(starredMessageData[position])
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItemCount(): Int {
        return starredMessageData.size
    }

    /**
     * Show/Hides sender name if the chat is group chat
     *
     * @param holder   view holder of the item
     * @param position position of the item
     */
    private fun showSenderNameIfGroupChat(holder: RecyclerView.ViewHolder, position: Int) {
        val senderNameHolder = holder as SenderNameHolder
        showHideSenderName(senderNameHolder, starredMessageData[position])
    }

    fun showHideSenderName(senderNameHolder: SenderNameHolder, messageItem: ChatMessage) {
        senderNameHolder.showFavouriteNameView()
        var messageDate: String = ChatUserTimeUtils.getDateFromTimestamp(messageItem.messageSentTime)!!
        if (messageDate.contains("1970")) messageDate = Constants.EMPTY_STRING
        if (messageItem.messageChatType == ChatTypeEnum.groupchat) {
            if (messageItem.isMessageSentByMe) {
                val toUser = ProfileDetailsUtils.getDisplayName(messageItem.chatUserJid)
                senderNameHolder.favouriteSenderReceiverName(Constants.YOU, toUser, messageDate)
            } else {
                val fromUser = ProfileDetailsUtils.getDisplayName(messageItem.chatUserJid)
                senderNameHolder.favouriteSenderReceiverName(fromUser, messageItem.senderUserName, messageDate)
            }
        } else if (messageItem.isMessageSentByMe) {
            senderNameHolder.favouriteSenderReceiverName(Constants.YOU, messageItem.senderUserName, messageDate)
        } else {
            senderNameHolder.favouriteSenderReceiverName(messageItem.senderUserName, Constants.YOU, messageDate)
        }
    }

    /**
     * Gets the text view.
     *
     * @param holder   Holder of the text view
     * @param item     Instance of the Message
     * @param position Position of the list item
     */
    private fun getStarredTextViewSender(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            val starredTxtSenderViewHolder: TextSentViewHolder = holder as TextSentViewHolder
            setHeader(holder, SENDER_HEADER, item)
            val time: String = getChatMsgTime(item)!!
            starredTxtSenderViewHolder.txtChatTime.text = time
            starredTxtSenderViewHolder.txtChatTime
                    .setTextColor(ContextCompat.getColor(context!!, R.color.color_sent_message_time))
            starredTxtSenderViewHolder.txtChatTime.visibility = View.VISIBLE
            val msg = item.messageTextContent
            Linkify.addLinks(starredTxtSenderViewHolder.txtChatSender, Linkify.ALL)
            starredTxtSenderViewHolder.txtChatSender.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
            starredTxtSenderViewHolder.txtChatSender.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
            setStatus(item, starredTxtSenderViewHolder.imgChatStatus)
            starredItemClick(starredTxtSenderViewHolder.viewRowItem, item, position)
            setListenersForSenderTextMessages(starredTxtSenderViewHolder, item, position)
            senderItemClick(starredTxtSenderViewHolder.viewRowItem, item, position)
            replyViewUtils!!.showSenderReplyWindow(starredTxtSenderViewHolder, item, context!!)
            setSelectedChatItem(starredTxtSenderViewHolder.itemView, item, starredMessageMessages, context)
            with(starredTxtSenderViewHolder.txtChatSender) {
                if(item.mentionedUsersIds != null && item.mentionedUsersIds.size > 0) {
                    isClickable = false
                    isLongClickable = false
                    val mentionText = MentionUtils.formatMentionText(context, item,false)
                    val mentionUserNames=MentionUtils.getMentionedUserId(context,item,false)
                    LogMessage.e(TAG, "Sender side--->mentioned User names::$mentionUserNames")
                    setSearchTextHighlightMention(starredTxtSenderViewHolder.txtChatSender,mentionText,mentionUserNames)
                } else {
                    setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
                    setTextKeepState(getSpannedText(msg))
                    if (msg.contains(BuildConfig.WEB_CHAT_LOGIN))
                        setJoinLinkView(
                            starredTxtSenderViewHolder.txtChatSender,
                            starredTxtSenderViewHolder.joinLinkView,
                            starredTxtSenderViewHolder.joinLinkLogo,
                            msg
                        )
                    isClickable = false
                    isLongClickable = false
                    setSearchTextHighlight(starredTxtSenderViewHolder.txtChatSender, getSpannedText(msg))
                }
            }
            starredTxtSenderViewHolder.imageStar.visibility = View.VISIBLE
            if (position == starredMessageData.size - 1) {
                starredTxtSenderViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredTxtSenderViewHolder.viewDiver?.visibility = View.VISIBLE
            }
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun getStarredMeetViewSender(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            val starredMeetSentViewHolder: MeetSentViewHolder = holder as MeetSentViewHolder
            setHeader(holder, SENDER_HEADER, item)
            val time: String = getChatMsgTime(item)!!
            starredMeetSentViewHolder.txtChatTime.text = time
            starredMeetSentViewHolder.txtChatTime
                .setTextColor(ContextCompat.getColor(context!!, R.color.color_sent_message_time))
            starredMeetSentViewHolder.txtChatTime.visibility = View.VISIBLE
            val msg = item.meetingChatMessage.link
            Linkify.addLinks(starredMeetSentViewHolder.txtChatSender, Linkify.ALL)
            starredMeetSentViewHolder.txtChatSender.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
            starredMeetSentViewHolder.txtChatSender.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
            setStatus(item, starredMeetSentViewHolder.imgChatStatus)
            starredItemClick(starredMeetSentViewHolder.viewRowItem, item, position)
            setListenersForSenderTextMessages(starredMeetSentViewHolder, item, position)
            senderItemClick(starredMeetSentViewHolder.viewRowItem, item, position)
            replyViewUtils!!.showSenderReplyWindow(starredMeetSentViewHolder, item, context!!)
            setSelectedChatItem(starredMeetSentViewHolder.itemView, item, starredMessageMessages, context)
            with(starredMeetSentViewHolder.txtChatSender) {
                setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
                setTextKeepState(getSpannedText(msg))
                setMeetLinkView(
                    starredMeetSentViewHolder.txtChatSender,
                    starredMeetSentViewHolder.scheduleMeetLinkView,
                    starredMeetSentViewHolder.scheduleMeetLinkLogo,
                )
                isClickable = false
                isLongClickable = false
                setSearchTextHighlight(starredMeetSentViewHolder.txtChatSender, getSpannedText(msg))
                holder.scheduleDateAndTime.text = ChatUserTimeUtils.scheduledDateTimeFormat(item.meetingChatMessage.scheduledDateTime.toLong())

            }
            starredMeetSentViewHolder.imageStar.visibility = View.VISIBLE
            if (position == starredMessageData.size - 1) {
                starredMeetSentViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredMeetSentViewHolder.viewDiver?.visibility = View.VISIBLE
            }
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun setMeetLinkView(txtChat: TextView, scheduledMeetLinkView: LinearLayout, scheduledMeetLinkLogo: ImageView) {
        txtChat.autoLinkMask = Linkify.ALL
        txtChat.linksClickable = false
        val screenWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
        val meetLinkText = txtChat.text
        LogMessage.d(TAG, "Scheduled meet Link length sampleLink: $meetLinkText")

        txtChat.setTextColor(ContextCompat.getColor(context!!, R.color.light_blue))
        txtChat.setLinkTextColor(ContextCompat.getColor(context!!, R.color.light_blue))
        scheduledMeetLinkView.show()
        val lp = LinearLayout.LayoutParams(
            (screenWidth + 20),
            LinearLayout.LayoutParams.WRAP_CONTENT
        ) //20 is nothing but text message margin Start and End value in XML
        scheduledMeetLinkView.layoutParams = lp
        scheduledMeetLinkLogo.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.mirrorfly_icon)!!)
    }


    private fun setJoinLinkView(txtChat: TextView, joinLinkView: LinearLayout, joinLinkLogo: ImageView,originalMsg: String) {
        txtChat.autoLinkMask = Linkify.ALL
        txtChat.linksClickable = false

        val screenWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
        //https://webchat-uikit-qa.contus.us/mnf-qjtf-fbr
        val sampleLink = "https://webchat-uikit-qa.contus.us/mnf-qjtf-fbr"
        val meetLinkText = txtChat.text
        LogMessage.d(TAG, "Join Call via Link length sampleLink: ${sampleLink.length}")
        LogMessage.d(TAG, "Join Call via Link length userPastedLink: $meetLinkText")
        LogMessage.d(TAG, "Join Call via Link length userPastedLink: ${meetLinkText.length}")
        val indexOfNewMessageAfterLink = AdapterUtils.checkIndexOfNewMessageAfterLink(originalMsg)
        com.mirrorflysdk.flycommons.LogMessage.d(TAG, "Join Call via Link  indexOfNewMessageAfterLink: $indexOfNewMessageAfterLink")
        if (indexOfNewMessageAfterLink !=-1) {
            AdapterUtils.setTextForCallLink(txtChat,indexOfNewMessageAfterLink,context!!)
        } else{
            txtChat.setTextColor(ContextCompat.getColor(context!!, R.color.light_blue))
            txtChat.setLinkTextColor(ContextCompat.getColor(context!!, R.color.light_blue))
        }

        joinLinkView.show()
        val lp = LinearLayout.LayoutParams(
            (screenWidth + 20),
            LinearLayout.LayoutParams.WRAP_CONTENT
        ) //20 is nothing but text message margin Start and End value in XML
        joinLinkView.layoutParams = lp
        joinLinkLogo.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.mirrorfly_icon)!!)
    }

    /**
     * starred textview for receiver side
     *
     * @param holder   adapter view holder object
     * @param item     object which hold item data
     * @param position of the item
     */
    private fun getStarredTextViewReceiver(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        // View holder for the text view
        val starredTxtReceiverViewHolder = holder as TextReceivedViewHolder
        setHeader(holder, RECEIVER_HEADER, item)
        val time: String = getChatMsgTime(item)!!
        starredTxtReceiverViewHolder.txtChatRevTime.text = time
        starredTxtReceiverViewHolder.txtChatRevTime
                .setTextColor(ContextCompat.getColor(context!!, R.color.color_chat_msg_received_time))
        val msg = item.messageTextContent
        starredTxtReceiverViewHolder.txtChatReceiver.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
        starredTxtReceiverViewHolder.txtChatReceiver.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
        Linkify.addLinks(starredTxtReceiverViewHolder.txtChatReceiver, Linkify.ALL)
        replyViewUtils!!.showReceiverReplyWindow(starredTxtReceiverViewHolder, item, context!!)
        starredItemClick(starredTxtReceiverViewHolder.txtChatReceiver, item, position)
        setListenersForReceiverTextMessages(starredTxtReceiverViewHolder, item, position)
        receiverItemClick(starredTxtReceiverViewHolder.viewRowItem, item, position)
        setSelectedChatItem(starredTxtReceiverViewHolder.itemView, item, starredMessageMessages, context)
        with(starredTxtReceiverViewHolder.txtChatReceiver) {
            if(item.mentionedUsersIds != null && item.mentionedUsersIds.size > 0) {
                setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
                isClickable = false
                isLongClickable = false
                val mentionText = MentionUtils.formatMentionText(context, item,false)
                val mentionUserNames=MentionUtils.getMentionedUserId(context,item,false)
                LogMessage.e(TAG, "Receiver side--->mentioned User names::$mentionUserNames")
                setSearchTextHighlightMention(starredTxtReceiverViewHolder.txtChatReceiver,mentionText,mentionUserNames)
            } else {
                setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
                setTextKeepState(getSpannedText(msg))
                if (msg.contains(BuildConfig.WEB_CHAT_LOGIN))
                    setJoinLinkView(
                        starredTxtReceiverViewHolder.txtChatReceiver,
                        starredTxtReceiverViewHolder.receiverJoinLinkView,
                        starredTxtReceiverViewHolder.receiverJoinLinkLogo,
                        msg
                    )
                isClickable = false
                isLongClickable = false
                setSearchTextHighlight(starredTxtReceiverViewHolder.txtChatReceiver, getSpannedText(msg))
            }
        }
        starredTxtReceiverViewHolder.imgReceivedStar.visibility = View.VISIBLE
        if (position == starredMessageData.size - 1) {
            starredTxtReceiverViewHolder.viewDiver?.visibility = View.GONE
        }else{
            starredTxtReceiverViewHolder.viewDiver?.visibility = View.VISIBLE
        }
    }


    private fun getStarredMeetViewReceiver(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        val meetReceiverViewHolder = holder as MeetReceivedViewHolder
        setHeader(holder, RECEIVER_HEADER, item)
        val time: String = getChatMsgTime(item)!!
        meetReceiverViewHolder.txtChatRevTime.text = time
        meetReceiverViewHolder.txtChatRevTime
            .setTextColor(ContextCompat.getColor(context!!, R.color.color_chat_msg_received_time))
        val msg = item.meetingChatMessage.link
        meetReceiverViewHolder.txtChatReceiver.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
        meetReceiverViewHolder.txtChatReceiver.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))
        Linkify.addLinks(meetReceiverViewHolder.txtChatReceiver, Linkify.ALL)
        replyViewUtils!!.showReceiverReplyWindow(meetReceiverViewHolder, item, context!!)
        starredItemClick(meetReceiverViewHolder.txtChatReceiver, item, position)
        setListenersForReceiverTextMessages(meetReceiverViewHolder, item, position)
        receiverItemClick(meetReceiverViewHolder.viewRowItem, item, position)
        setSelectedChatItem(meetReceiverViewHolder.itemView, item, starredMessageMessages, context)
        with(meetReceiverViewHolder.txtChatReceiver) {
            setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
            setTextKeepState(getSpannedText(msg))
            setMeetLinkView(
                meetReceiverViewHolder.txtChatReceiver,
                meetReceiverViewHolder.scheduleMeetLinkView,
                meetReceiverViewHolder.scheduleMeetLinkLogo,
            )
            isClickable = false
            isLongClickable = false
            setSearchTextHighlight(meetReceiverViewHolder.txtChatReceiver, getSpannedText(msg))
            holder.scheduleDateAndTime.text = ChatUserTimeUtils.scheduledDateTimeFormat(item.meetingChatMessage.scheduledDateTime.toLong())
        }
        meetReceiverViewHolder.imgReceivedStar.visibility = View.VISIBLE
        meetReceiverViewHolder.imgForwardMeet?.visibility=View.GONE

        if (position == starredMessageData.size - 1) {
            meetReceiverViewHolder.viewDiver?.visibility = View.GONE
        }else{
            meetReceiverViewHolder.viewDiver?.visibility = View.VISIBLE
        }
    }

    /*
   * This method is used to set the Text Highlight color for Searched keyword */
    private fun setSearchTextHighlight(
        txtChat: TextView,
        fromHtml: Spanned?
    ) {
        if (searchEnabled && searchKey.isNotEmpty() && fromHtml.toString().startsWithTextInWords(searchKey)) {
            var startIndex = fromHtml.toString().checkIndexes(searchKey)
            if (startIndex < 0) startIndex = fromHtml.toString().indexOf(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setEmojiTextAndHighLightSearchText(context, txtChat, fromHtml.toString(), startIndex, stopIndex)
        } else {
            txtChat.setBackgroundColor(context!!.color(android.R.color.transparent))
            txtChat.setTextKeepState(fromHtml)
        }
    }

    private fun setSearchTextHighlightMention(
        txtChat: TextView,
        fromHtml: Spanned?,mentionedUserName:SpannableStringBuilder
    ) {
        if (searchEnabled && searchKey.isNotEmpty()) {
            var startIndex = fromHtml.toString().checkIndexes(searchKey)
            if (startIndex < 0) startIndex = fromHtml.toString().indexOf(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setEmojiTextAndHighLightSearchTextForMention(context, txtChat,fromHtml.toString(), startIndex, stopIndex,mentionedUserName)
        } else {
            txtChat.setBackgroundColor(context!!.color(android.R.color.transparent))
            txtChat.text=fromHtml
        }
    }

    /**
     * Get the image view for the adapter
     *
     * @param holder      Holder of the recycler view
     * @param messageItem Message item contains message data
     * @param position    List item position
     */
    private fun getStarredImageViewSender(holder: RecyclerView.ViewHolder, messageItem: ChatMessage, position: Int) {
        setHeader(holder, SENDER_HEADER, messageItem)
        val starredImgSenderViewHolder = holder as ImageSentViewHolder
        starredImageItemViewHelper!!.setImageWidthAndHeight(starredImgSenderViewHolder, messageItem)
        val time: String = getChatMsgTime(messageItem)!!
        val base64Img = Utils.returnEmptyStringIfNull(messageItem.mediaChatMessage.mediaThumbImage)
        val filePath = Utils.returnEmptyStringIfNull(messageItem.mediaChatMessage.mediaLocalStoragePath)
        val chatItemRowModel=
            ChatItemRowModel(messageItem,filePath,time,base64Img,searchEnabled,searchKey)
        starredImageItemViewHelper!!.senderImageItemView(starredImgSenderViewHolder,chatItemRowModel)
        replyViewUtils!!.showSenderReplyWindow(starredImgSenderViewHolder, messageItem, context!!)
        setListenersForSenderImageMessages(starredImgSenderViewHolder, messageItem, position)
        senderItemClick(starredImgSenderViewHolder.viewRowItem, messageItem, position,starredImgSenderViewHolder.viewSender)
        senderDownloadClick(starredImgSenderViewHolder.txtRetryView, starredImgSenderViewHolder.cancelUpload,
                messageItem, starredImgSenderViewHolder.viewSentCarbonDownload)
        setSelectedChatItem(starredImgSenderViewHolder.itemView, messageItem, starredMessageMessages, context)
        if (position == starredMessageData.size - 1) {
            starredImgSenderViewHolder.viewDiver?.visibility = View.GONE
        }else{
            starredImgSenderViewHolder.viewDiver?.visibility = View.VISIBLE
        }
        starredImgSenderViewHolder.imgSentForward?.visibility=View.GONE

    }

    /**
     * starred imageview for receiver side
     *
     * @param holder      adapter view holder object
     * @param messageItem object which hold item data
     * @param position    of the item
     */
    private fun getStarredImageViewReceiver(holder: RecyclerView.ViewHolder, messageItem: ChatMessage, position: Int) {
        try {
            setHeader(holder, RECEIVER_HEADER, messageItem)
            val starredImgReceiverViewHolder: ImageReceivedViewHolder = holder as ImageReceivedViewHolder
            starredImageItemViewHelper!!.setImageWidthAndHeight(starredImgReceiverViewHolder, messageItem)
            val base64Img = Utils.returnEmptyStringIfNull(messageItem.mediaChatMessage.mediaThumbImage)
            val filePath = Utils.returnEmptyStringIfNull(messageItem.mediaChatMessage.mediaLocalStoragePath)
            val time: String = getChatMsgTime(messageItem)!!
            val chatItemRowModel=ChatItemRowModel(messageItem,filePath,time,base64Img,searchEnabled,searchKey)
            starredImageItemViewHelper!!.receiverImageViewItem(starredImgReceiverViewHolder,chatItemRowModel)
            replyViewUtils!!.showReceiverReplyWindow(starredImgReceiverViewHolder, messageItem, context!!)
            setListenersForReceiverImageMessages(starredImgReceiverViewHolder, messageItem, position)
            receiverItemClick(starredImgReceiverViewHolder.viewRowItem, messageItem, position,starredImgReceiverViewHolder.viewReceiver)
            receiverDownloadClick(starredImgReceiverViewHolder.viewDownload, starredImgReceiverViewHolder.txtRetryView,
                    starredImgReceiverViewHolder.cancelDownload, messageItem, starredImgReceiverViewHolder.txtImgSize)
            setSelectedChatItem(starredImgReceiverViewHolder.itemView,
                    messageItem, starredMessageMessages, context)
            if (position == starredMessageData.size - 1) {
                starredImgReceiverViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredImgReceiverViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredImgReceiverViewHolder.receivedImageForward?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * starred video view for sender side
     *
     * @param holder      adapter view holder object
     * @param messageItem object which hold item data
     * @param position    of the item
     */
    private fun getStarredVideoViewSender(holder: RecyclerView.ViewHolder, messageItem: ChatMessage, position: Int) {
        try {
            setHeader(holder, SENDER_HEADER, messageItem)
            val starredVideoSenderViewHolder: VideoSentViewHolder = holder as VideoSentViewHolder
            starredVideoItemViewHelper!!.setImageWidthAndHeight(starredVideoSenderViewHolder, messageItem)
            val filePath = Utils.returnEmptyStringIfNull(messageItem.mediaChatMessage.mediaLocalStoragePath)
            val time: String = getChatMsgTime(messageItem)!!
            val base64Img = Utils.returnEmptyStringIfNull(messageItem.mediaChatMessage.mediaThumbImage)
            val chatItemRowModel=ChatItemRowModel(messageItem,filePath,time,base64Img,searchEnabled,searchKey)
            starredVideoItemViewHelper!!.senderVideoItemView(starredVideoSenderViewHolder,chatItemRowModel)
            replyViewUtils!!.showSenderReplyWindow(starredVideoSenderViewHolder, messageItem, context!!)
            setListenersForSenderVideoMessages(starredVideoSenderViewHolder, messageItem, position)
            senderItemClick(starredVideoSenderViewHolder.viewRowItem, messageItem, position,starredVideoSenderViewHolder.viewSender)
            senderDownloadClick(starredVideoSenderViewHolder.txtRetryView, starredVideoSenderViewHolder.cancelUpload,
                    messageItem, starredVideoSenderViewHolder.viewSentCarbonDownload)
            setSelectedChatItem(starredVideoSenderViewHolder.itemView,
                    messageItem, starredMessageMessages, context)
            if (position == starredMessageData.size - 1) {
                starredVideoSenderViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredVideoSenderViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredVideoSenderViewHolder.imgSentForward?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * starred video view for receiver side
     *
     * @param holder      adapter view holder object
     * @param messageItem object which hold item data
     * @param position    of the item
     */
    private fun getStarredVideoViewReceiver(holder: RecyclerView.ViewHolder, messageItem: ChatMessage, position: Int) {
        try {
            setHeader(holder, RECEIVER_HEADER, messageItem)
            val starredVideoReceiverViewHolder = holder as VideoReceivedViewHolder
            starredVideoItemViewHelper!!.setImageWidthAndHeight(starredVideoReceiverViewHolder, messageItem)
            val filePath = Utils.returnEmptyStringIfNull(messageItem.mediaChatMessage.mediaLocalStoragePath)
            val time: String = getChatMsgTime(messageItem)!!
            val base64Img = Utils.returnEmptyStringIfNull(messageItem.mediaChatMessage.mediaThumbImage)
            val chatItemRowModel=ChatItemRowModel(messageItem,filePath,time,base64Img,searchEnabled,searchKey)
            starredVideoItemViewHelper!!.receiverVideoViewItem(starredVideoReceiverViewHolder,chatItemRowModel)
            replyViewUtils!!.showReceiverReplyWindow(starredVideoReceiverViewHolder, messageItem, context!!)
            setListenersForReceiverVideoMessages(starredVideoReceiverViewHolder, messageItem, position)
            receiverItemClick(starredVideoReceiverViewHolder.viewRowItem, messageItem, position, starredVideoReceiverViewHolder.viewReceiver)
            receiverDownloadClick(starredVideoReceiverViewHolder.viewDownload, starredVideoReceiverViewHolder.txtRetryView,
                    starredVideoReceiverViewHolder.cancelDownload, messageItem, starredVideoReceiverViewHolder.txtImgSize)
            setSelectedChatItem(starredVideoReceiverViewHolder.itemView,
                    messageItem, starredMessageMessages, context)
            if (position == starredMessageData.size - 1) {
                starredVideoReceiverViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredVideoReceiverViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredVideoReceiverViewHolder.receivedImageForward?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Gets the location view to display the map
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private fun getStarredLocationViewSender(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            setHeader(holder, SENDER_HEADER, item)
            val starredLocationSenderViewHolder = holder as LocationSentViewHolder
            val locationMessage = item.locationChatMessage
            val time: String = getChatMsgTime(item)!!
            val url: String = MapUtils.getMapImageUri(locationMessage.latitude, locationMessage.longitude)
            starredLocationSenderViewHolder.txtSendTime.text = time
            replyViewUtils!!.showSenderReplyWindow(starredLocationSenderViewHolder, item, context!!)
            loadMapWithGlide(context, url,
                    starredLocationSenderViewHolder.imageSendLocation, R.drawable.ic_map_placeholder)
            LogMessage.v("loadMapWithGlide", url)
            starredLocationSenderViewHolder.txtSendTime.text = time
            setChatStatus(item, starredLocationSenderViewHolder.imgSenderStatus)
            replyViewUtils!!.showSenderReplyWindow(starredLocationSenderViewHolder, item, context!!)
            setListenersForSenderLocationMessages(starredLocationSenderViewHolder, item, position)
            senderItemClick(starredLocationSenderViewHolder.viewRowItem, item, position,starredLocationSenderViewHolder.imageSendLocation)
            setSelectedChatItem(starredLocationSenderViewHolder.itemView, item, starredMessageMessages, context)
            if (position == starredMessageData.size - 1) {
                starredLocationSenderViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredLocationSenderViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredLocationSenderViewHolder.imgForwardLocation?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Gets the location view to display the map in receiver side
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private fun getStarredLocationViewReceiver(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            setHeader(holder, RECEIVER_HEADER, item)
            val starredLocationReceiverViewHolder = holder as LocationReceivedViewHolder
            val locationMessage = item.locationChatMessage
            val time: String = getChatMsgTime(item)!!
            val url = MapUtils.getMapImageUri(locationMessage.latitude, locationMessage.longitude)
            loadMapWithGlide(context, url,
                    starredLocationReceiverViewHolder.imageReceiveLocation, R.drawable.ic_map_placeholder)
            starredLocationReceiverViewHolder.txtRevTime.text = time
            replyViewUtils!!.showReceiverReplyWindow(starredLocationReceiverViewHolder, item, context!!)
            replyViewUtils!!.showReceiverReplyWindow(starredLocationReceiverViewHolder, item, context!!)
            setListenersForReceiverLocationMessages(starredLocationReceiverViewHolder, item, position)
            receiverItemClick(starredLocationReceiverViewHolder.viewRowItem, item, position, starredLocationReceiverViewHolder.imageReceiveLocation)
            setSelectedChatItem(starredLocationReceiverViewHolder.itemView, item, starredMessageMessages, context)
            if (position == starredMessageData.size - 1) {
                starredLocationReceiverViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredLocationReceiverViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredLocationReceiverViewHolder.imgForwardLocation?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Create the audio view based on the Message data
     *
     * @param holder   Holder of the recycler view
     * @param item     Message item contains message data
     * @param position List item position
     */
    private fun getStarredAudioViewSender(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            val time: String = getChatMsgTime(item)!!
            setHeader(holder, SENDER_HEADER, item)
            val starredAudioSenderViewHolder = holder as AudioSentViewHolder
            starredAudioItemView!!.disableSenderAudioViews(starredAudioSenderViewHolder, true)
            starredAudioItemView!!.audioSenderItemView(starredAudioSenderViewHolder, time, item)
            starredAudioPlayClick(item,holder,position, starredAudioSenderViewHolder.imgAudioPlay,
                starredAudioSenderViewHolder.audioMirrorFlySeekBar,
                starredAudioSenderViewHolder.txtAudioDuration, true)
            replyViewUtils!!.showSenderReplyWindow(starredAudioSenderViewHolder, item, context!!)
            mMediaController!!.checkStateOfPlayer(starredAudioSenderViewHolder.imgAudioPlay,
                    starredAudioSenderViewHolder.audioMirrorFlySeekBar,
                    starredAudioSenderViewHolder.txtAudioDuration, position)
            setListenersForAudioMessages(starredAudioSenderViewHolder, item, position)
            senderItemClick(starredAudioSenderViewHolder.viewRowItem, item, position)
            uploadClick(starredAudioSenderViewHolder.viewRetry, starredAudioSenderViewHolder.viewCarbonRetry, starredAudioSenderViewHolder.progressUploadDownloadLayout, item)
            setSelectedChatItem(starredAudioSenderViewHolder.itemView, item, starredMessageMessages, context)
            if (position == starredMessageData.size - 1) {
                starredAudioSenderViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredAudioSenderViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            if (item.mediaChatMessage.isAudioRecorded){
                starredAudioSenderViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_recorded_icon)
            }else{
                starredAudioSenderViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_music_icon)
            }
            starredAudioSenderViewHolder.sentAudioForwardImage?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Create the audio view based on the Message data in receiver side
     *
     * @param holder   Holder of the recycler view
     * @param item     Message item contains message data
     * @param position List item position
     */
    private fun getStarredAudioViewReceiver(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            val time: String = getChatMsgTime(item)!!
            setHeader(holder, RECEIVER_HEADER, item)
            val starredAudioReceiverViewHolder = holder as AudioReceivedViewHolder
            starredAudioItemView!!.disableReceiverAudioViews(starredAudioReceiverViewHolder, true)
            starredAudioItemView!!.audioReceiverItemView(starredAudioReceiverViewHolder, time, item)
            starredAudioPlayClick(item,holder,position, starredAudioReceiverViewHolder.imgAudioPlay,
                starredAudioReceiverViewHolder.audioMirrorFlySeekBar,
                starredAudioReceiverViewHolder.txtAudioDuration, false)
            mMediaController!!.checkStateOfPlayer(starredAudioReceiverViewHolder.imgAudioPlay,
                    starredAudioReceiverViewHolder.audioMirrorFlySeekBar,
                    starredAudioReceiverViewHolder.txtAudioDuration, position)
            replyViewUtils!!.showReceiverReplyWindow(starredAudioReceiverViewHolder, item, context!!)
            setListenersForReceiverAudioMessages(starredAudioReceiverViewHolder, item, position)
            receiverItemClick(starredAudioReceiverViewHolder.viewRowItem, item, position)
            downloadClick(starredAudioReceiverViewHolder.viewRetry, starredAudioReceiverViewHolder.progressUploadDownloadLayout, item)
            setSelectedChatItem(starredAudioReceiverViewHolder.itemView, item, starredMessageMessages, context)
            if (item.mediaChatMessage.isAudioRecorded) {
                starredAudioReceiverViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_recorded_icon)
            } else {
                starredAudioReceiverViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_music_icon)
            }
            if (position == starredMessageData.size - 1) {
                starredAudioReceiverViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredAudioReceiverViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredAudioReceiverViewHolder.sentAudioForwardImage?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Handle the file view to display the file on sender view or receiver view with type of file in the chat view.
     *
     * @param holder   Holder of the recycler view
     * @param item     Message item contains message data
     * @param position List item position
     */
    private fun getStarredFileViewSender(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            setHeader(holder, SENDER_HEADER, item)
            val starredFileSentViewHolder = holder as FileSentViewHolder
            val time: String = getChatMsgTime(item)!!
            setFileSenderView(starredFileSentViewHolder, item, time)
            replyViewUtils!!.showSenderReplyWindow(holder, item, context!!)
            starredFileSentViewHolder.fileFavoriteImage.visibility = View.VISIBLE
            setListenersForSentFileMessages(starredFileSentViewHolder, item, position)
            senderItemClick(starredFileSentViewHolder.fileSentViewLayout, item, position, starredFileSentViewHolder.openFileSentViewLayout)
            uploadClick(starredFileSentViewHolder.fileUploadViewLayout, starredFileSentViewHolder.fileCarbonDownloadView, starredFileSentViewHolder.fileUploadCancelLayout, item)
            setSelectedChatItem(starredFileSentViewHolder.itemView, item, starredMessageMessages, context)
            setSearchHighlightAppCompatTextView(starredFileSentViewHolder.fileNameText,  SpannableStringBuilder(item.mediaChatMessage.mediaFileName))
            if (position == starredMessageData.size - 1) {
                starredFileSentViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredFileSentViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredFileSentViewHolder.imgFileForward?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Handle the file view to display the file on receiver view with type of file in the chat view.
     *
     * @param holder   Holder of the recycler view
     * @param item     Message item contains message data
     * @param position List item position
     */
    private fun getStarredFileViewReceiver(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            setHeader(holder, RECEIVER_HEADER, item)
            val starredFileReceivedViewHolder = holder as FileReceivedViewHolder
            val time: String = getChatMsgTime(item)!!
            val fileStatus = Utils.returnEmptyStringIfNull(item.mediaChatMessage.getMediaDownloadStatus().toString())
            FileItemView(this).fileReceiverItemView(starredFileReceivedViewHolder, time, item)
            starredFileReceivedViewHolder.fileFavoriteImage.visibility = View.VISIBLE
            if (fileStatus.isNotEmpty())
                chatAdapterHelper!!.presentFileTypeView(starredFileReceivedViewHolder.fileCancelLayout,
                    starredFileReceivedViewHolder.fileDownloadProgress,
                    starredFileReceivedViewHolder.fileDownloadProgressBuffer, item.messageId, fileStatus.toInt(),
                    null, starredFileReceivedViewHolder.fileDownloadLayout)
            replyViewUtils!!.showReceiverReplyWindow(starredFileReceivedViewHolder, item, context!!)
            setListenersForReceivedFileMessages(starredFileReceivedViewHolder, item, position)
            receiverItemClick(starredFileReceivedViewHolder.fileReceivedViewLayout, item, position,starredFileReceivedViewHolder.openFileReceivedViewLayout)
            downloadClick(starredFileReceivedViewHolder.fileDownloadLayout,
                    starredFileReceivedViewHolder.fileCancelLayout, item)
            setSelectedChatItem(starredFileReceivedViewHolder.itemView,
                    item, starredMessageMessages, context)
            setSearchHighlightAppCompatTextView(starredFileReceivedViewHolder.fileNameText,  SpannableStringBuilder(item.mediaChatMessage.mediaFileName))
            if (position == starredMessageData.size - 1) {
                starredFileReceivedViewHolder.viewDiver?.visibility = View.GONE
            }else{
                starredFileReceivedViewHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredFileReceivedViewHolder.imgFileForward?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Create the contact view based on the Message data
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private fun getStarredContactViewSender(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            setHeader(holder, SENDER_HEADER, item)
            val starredContactSentHolder = holder as ContactSentViewHolder
            val contactMessage = item.contactChatMessage
            val contactName = contactMessage.contactName
            val time: String = getChatMsgTime(item)!!
            starredContactSentHolder.txtSendName.text = contactName
            starredContactSentHolder.txtSendTime.text = time
            setSentStarredContactActions(starredContactSentHolder, item, position)
            replyViewUtils!!.showSenderReplyWindow(starredContactSentHolder, item, context!!)
            starredContactSentHolder.starredSentImage.visibility = View.VISIBLE
            setStatus(item, starredContactSentHolder.imgSenderStatus)
            starredItemClick(starredContactSentHolder.viewRowItem, item, position)
            senderItemClick(starredContactSentHolder.viewRowItem, item, position)
            setSelectedChatItem(starredContactSentHolder.itemView, item, starredMessageMessages, context)
            setSearchHighlightAppCompatTextView(starredContactSentHolder.txtSendName, SpannableStringBuilder(contactName))

            if (position == starredMessageData.size - 1) {
                starredContactSentHolder.viewDiver?.visibility = View.GONE
            }else{
                starredContactSentHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredContactSentHolder.imgForwardContact?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun setSentStarredContactActions(
        starredContactSentHolder: ContactSentViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        if (BuildConfig.CONTACT_SYNC_ENABLED){
            val contactMessage = item.contactChatMessage
            val registeredJid = getJidFromSharedContact(contactMessage)
            if (registeredJid != null) {
                if(registeredJid == SharedPreferenceManager.getCurrentUserJid() || registeredJid == item.chatUserJid) {
                    starredContactSentHolder.contactActionText.gone()
                    starredContactSentHolder. contactSeparator?.gone()
                    setLoginUserContactProfilePicture(starredContactSentHolder.txtSendImg,true)
                } else {
                    starredContactSentHolder.contactActionText.show()
                    starredContactSentHolder. contactSeparator?.show()
                    starredContactSentHolder.contactActionText.text = context!!.resources.getString(R.string.message)
                    ProfileDetailsUtils.getProfileDetails(registeredJid)?.let {
                        starredContactSentHolder.txtSendImg.loadUserProfileImage(context!!, it)
                    }
                }
            } else {
                starredContactSentHolder.contactActionText.text = context!!.resources.getString(R.string.invite)
                starredContactSentHolder.txtSendImg.setImageResource(R.drawable.ic_profile)
                setInviteClickListener(starredContactSentHolder.contactActionText, item, position, item.chatUserJid)
            }
        } else {
            starredContactSentHolder.contactActionText.gone()
            starredContactSentHolder.contactSeparator?.hide()
        }
    }

    private fun getJidFromSharedContact(contactMessage: ContactChatMessage): String? {
        var registeredJid: String? = null
        for (i in contactMessage.isChatAppUser.indices) {
            if (contactMessage.isChatAppUser[i] == java.lang.Boolean.TRUE) {
                val countryCode = SharedPreferenceManager.getString(Constants.COUNTRY_CODE)
                registeredJid = Utils.getJidFromPhoneNumber(context, contactMessage.contactPhoneNumbers[i], if (countryCode.isEmpty()) "IN" else countryCode)
                break
            }
        }
        return registeredJid
    }

    /**
     * Method used to set the contact profile picture for logged in user
     *
     * @param txtSendImg The contact profile image view.
     * @param isSender  boolean value to identify sender or receiver
     */
    private fun setLoginUserContactProfilePicture(txtSendImg: ImageView,isSender: Boolean) {

        if(SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE).isNotEmpty()) {
            if(isSender) {
                loadImageWithGlideSecure(
                    context, SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
                    txtSendImg, ContextCompat.getDrawable(context!!, R.drawable.ic_profile)
                )
            } else {
                loadImageWithGlideSecure(
                    context, SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
                    txtSendImg, ContextCompat.getDrawable(context!!, R.drawable.ic_contact_img)
                )
            }
        } else {
            txtSendImg.setImageDrawable(setDrawable?.setDrawableForProfile(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME)))
        }
    }

    private fun setInviteClickListener(view: View, message: ChatMessage, position: Int, jid: String) {
        view.setOnClickListener {
            if (listener != null) {
                listener!!.onContactClick(message, position, jid, true)
            }
        }
    }

    private fun setSearchHighlightAppCompatTextView(txtSendName: AppCompatTextView, fromHtml: Spanned) {
        if (searchEnabled && searchKey.isNotEmpty() && fromHtml.toString().startsWithTextInWords(searchKey)) {
            var startIndex = fromHtml.toString().checkIndexes(searchKey)
            if (startIndex < 0) startIndex = fromHtml.toString().indexOf(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setMediaTextHighLightSearched(context,txtSendName, fromHtml.toString(), startIndex, stopIndex)
        } else {
            txtSendName.setBackgroundColor(context!!.color(android.R.color.transparent))
            txtSendName.setTextKeepState(fromHtml)
        }
    }

    /**
     * Create the contact view based on the Message data in receiver side.
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private fun getStarredContactViewReceiver(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            val starredContactReceivedHolder = holder as ContactReceivedViewHolder
            setHeader(holder, RECEIVER_HEADER, item)
            val contactMessage = item.contactChatMessage
            val contactName = contactMessage.contactName
            val time: String = getChatMsgTime(item)!!
            starredContactReceivedHolder.txtSendTime.text = time
            starredContactReceivedHolder.starredSentImage.visibility = View.VISIBLE
            starredContactReceivedHolder.txtSendName.text = contactName
            checkUserFromReceiver(holder, item)
            setInviteClickListener(starredContactReceivedHolder.contactActionText, item, position, item.chatUserJid)
            replyViewUtils!!.showReceiverReplyWindow(starredContactReceivedHolder, item, context!!)
            receiverItemClick(starredContactReceivedHolder.viewRowItem, item, position)
            setSelectedChatItem(starredContactReceivedHolder.itemView, item, starredMessageMessages, context)
            setSearchHighlightAppCompatTextView(starredContactReceivedHolder.txtSendName, SpannableStringBuilder(contactName))

            if (position == starredMessageData.size - 1) {
                starredContactReceivedHolder.viewDiver?.visibility = View.GONE
            }else{
                starredContactReceivedHolder.viewDiver?.visibility = View.VISIBLE
            }
            starredContactReceivedHolder.imgForwardContact?.visibility=View.GONE
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Checking user to send contact from receiver side
     *
     * @param holder Holder of the recycler view
     * @param item
     */
    private fun checkUserFromReceiver(holder: RecyclerView.ViewHolder, item: ChatMessage) {
        val chatUserNumber = Utils.getFormattedPhoneNumber(ChatUtils.getUserFromJid(SharedPreferenceManager.getCurrentUserJid())).replace(" ".toRegex(), "")
        val number = chatUserNumber.replace(" ".toRegex(), "")
        val contactMessage = item.contactChatMessage
        val contactReceiverViewHolder = holder as ContactReceivedViewHolder
        val registeredJid = getJidFromSharedContact(contactMessage)
        with(contactReceiverViewHolder) {
            if (registeredJid != null)
                handleContactView(this, registeredJid)
            else {
                contactActionText.text = context?.resources?.getString(R.string.invite)
                contactActionText.show()
                txtSendImg.setImageResource(R.drawable.ic_contact_img)
            }
            for (num in contactMessage.contactPhoneNumbers) {
                val receivedNumber = num.replace(" ".toRegex(), "")
                if (number.contains(receivedNumber)) {
                    contactActionText.gone()
                    viewSeperator.hide()
                } else {
                    fetchProfileDetailOfReceivedNumber(holder,receivedNumber)
                }
            }
        }
    }

    private fun fetchProfileDetailOfReceivedNumber(holder: RecyclerView.ViewHolder, receivedNumber: String){
        val contactReceiverViewHolder = holder as ContactReceivedViewHolder
        with(contactReceiverViewHolder) {
            viewSeperator.show()
            val countryCode = SharedPreferenceManager.getString(Constants.COUNTRY_CODE)
            val userJid = Utils.getJidFromPhoneNumber(
                context,
                receivedNumber,
                if (countryCode.isEmpty()) "IN" else countryCode
            ) ?: Constants.EMPTY_STRING
            val profileDetail = ProfileDetailsUtils.getProfileDetails(userJid)
            if (profileDetail == null || !profileDetail.isItSavedContact || profileDetail.isEmailContact()) {
                if (contactActionText.text.toString() == context!!.resources.getString(R.string.message))
                    contactActionText.text = context!!.resources.getString(R.string.message_or_save_contact)
                else if (contactActionText.text.toString() == context!!.resources.getString(R.string.invite))
                    contactActionText.text = context!!.resources.getString(R.string.invite_or_save_contact)
            }
        }
    }


    private fun handleContactView(contactReceiverViewHolder: ContactReceivedViewHolder, jID: String) {
        with(contactReceiverViewHolder) {
            if (jID == SharedPreferenceManager.getCurrentUserJid()) {
                contactActionText.gone()
                viewSeperator.hide()
                setLoginUserContactProfilePicture(txtSendImg,false)
            } else {
                contactActionText.text = context?.resources?.getString(R.string.message)
                contactActionText.show()
                ProfileDetailsUtils.getProfileDetails(jID)?.let {
                    txtSendImg.loadUserProfileImage(context!!, it)
                }
            }
        }
    }

    /**
     * This sets the header view for the starred message
     *
     * @param holder item holder
     * @param type   sender or receiver
     * @param item   message item
     */
    private fun setHeader(holder: RecyclerView.ViewHolder, type: Int, item: ChatMessage) {
        val profileDetails = ProfileDetailsUtils.getProfileDetails(item.chatUserJid)
        if (type == SENDER_HEADER) {
            val userName = getUserProfileName()
            val setDrawable = SetDrawable(context!!, profileDetails)
            val icon = setDrawable.setDrawableForProfile(userName)
            val relativeLayoutHeader = holder.itemView.findViewById<View>(R.id.rl_header_sender)
            relativeLayoutHeader.visibility = View.VISIBLE
            val senderHeader = holder.itemView.findViewById<View>(R.id.header_starred_message_receiver)
            val senderDateTextView: AppCompatTextView = holder.itemView.findViewById(R.id.text_chat_date)
            val msgDate: String = getMessageDate(item)!!
            if (!msgDate.contains("1970")) senderDateTextView.text = msgDate
            senderHeader.visibility = View.VISIBLE
            val starredSenderTextView: AppCompatTextView = senderHeader.findViewById(R.id.text_participant_name)
            val receiverName: String = Utils.returnEmptyStringIfNull(profileDetails!!.getDisplayName())
            val userDpName = "You --> $receiverName"
            starredSenderTextView.text = userDpName
            starredSenderTextView.isSelected = true
            loadImageWithGlideSecure(context, SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
                    senderHeader.findViewById(R.id.image_participant_picture), icon)
        } else setupReceiverHeader(holder, item, profileDetails!!)
    }

    private fun setupReceiverHeader(holder: RecyclerView.ViewHolder, item: ChatMessage, profileDetails: ProfileDetails) {
        val receiverHeader = holder.itemView.findViewById<View>(R.id.header_starred_message_sender)
        val relativeLayoutHeader = holder.itemView.findViewById<View>(R.id.rl_header_receiver)
        relativeLayoutHeader.visibility = View.VISIBLE
        val receiverDateTextView: AppCompatTextView = holder.itemView.findViewById(R.id.text_chat_date)
        val msgDate: String = getMessageDate(item)!!
        if (!msgDate.contains("1970")) receiverDateTextView.text = msgDate
        receiverHeader.visibility = View.VISIBLE
        val starredReceiverTextView: AppCompatTextView = receiverHeader.findViewById(R.id.text_participant_name)
        val profileNickName: String
        var groupUser = Constants.EMPTY_STRING
        val setDrawable: SetDrawable
        if (item.messageChatType == ChatTypeEnum.groupchat) {
            val profileGroupUser = ProfileDetailsUtils.getProfileDetails(item.senderUserJid)
            groupUser = profileGroupUser!!.getDisplayName()
            profileNickName = profileGroupUser.getDisplayName()
            setDrawable = SetDrawable(context!!, profileGroupUser)
            loadUserProfileImage(context!!, profileGroupUser, receiverHeader.findViewById(R.id.image_participant_picture), setDrawable.setDrawable(profileNickName)!!)
        } else {
            profileNickName = profileDetails.getDisplayName()
            setDrawable = SetDrawable(context!!, profileDetails)
            loadUserProfileImage(context!!, profileDetails, receiverHeader.findViewById(R.id.image_participant_picture), setDrawable.setDrawable(profileNickName)!!)
        }
        val receiverName: String = profileDetails.getDisplayName()
        val userDpName = if (item.messageChatType == ChatTypeEnum.groupchat) "$groupUser --> $receiverName" else "$receiverName --> You"
        starredReceiverTextView.text = userDpName
        starredReceiverTextView.isSelected = true
        check(holder)
    }

    private fun loadUserProfileImage(context: Context, profileDetails: ProfileDetails, imgView: ImageView, errorImg: Drawable) {
        var errorProfileImage: Drawable? = errorImg
        var imageUrl = if (!profileDetails.thumbImage.isNullOrEmpty()) {
            profileDetails.thumbImage
        } else profileDetails.image
        if (profileDetails.isAdminBlocked || profileDetails.isBlockedMe || profileDetails.isDeletedContact()) {
            imageUrl = Constants.EMPTY_STRING
            errorProfileImage = ProfilePicUtil.getDefaultDrawable(context, ChatType.TYPE_CHAT)
        }
        MediaUtils.loadImage(context, imageUrl, imgView, errorProfileImage)
    }

    /**
     * Checking the contact type to make email icon visible and invisible
     *
     * @param holder     item holder
     */
    private fun check(holder: RecyclerView.ViewHolder) {
        holder.itemView.findViewById<View>(R.id.header_starred_message_sender)
                .findViewById<View>(R.id.email_contact_icon).visibility = View.GONE
    }

    /**
     * This method is used to get the message sent time
     *
     * @param item message item
     * @return time
     */
    private fun getChatMsgTime(item: ChatMessage): String? {
        return ChatMsgTime(Calendar.getInstance()).getDaySentMsg(context, item.messageSentTime)
    }

    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private fun getHtmlStarredMessageText(message: String): String {
        val text = context?.getString(R.string.chat_text)
        return message + text
    }


    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private fun getSpannedText(message: String?): Spanned {
        val htmlText: Spanned
        val chatMessage = getHtmlStarredMessageText(message!!).replace("\n", "<br>").replace("  ", "&nbsp;&nbsp;")
        htmlText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Html.fromHtml(getHtmlStarredMessageText(chatMessage), Html.FROM_HTML_MODE_LEGACY)
        else
            Html.fromHtml(getHtmlStarredMessageText(chatMessage))

        return if (htmlText.isEmpty() && chatMessage != "")
            SpannableStringBuilder(getHtmlStarredMessageText(chatMessage))
        else
            htmlText
    }

    /**
     * Starred message item click handler
     *
     * @param receiverItem Receiver item view
     * @param messageItem  Received message Item
     * @param position     Position of message
     */
    private fun starredItemClick(receiverItem: View, messageItem: ChatMessage, position: Int) {
        receiverItem.setOnLongClickListener { _: View? ->
            if (listener != null) listener!!.onReceiverItemLongClick(messageItem, position)
            false
        }
        receiverItem.setOnClickListener { _: View? -> if (listener != null) listener!!.onReceiverItemClicked(messageItem, position) }
    }

    /**
     * set Listeners For Sender Side TextView
     *
     * @param txtSenderViewHolder holder object
     * @param item                object which hold data to display
     * @param position            list item position
     */
    private fun setListenersForSenderTextMessages(txtSenderViewHolder: TextSentViewHolder, item: ChatMessage, position: Int) {
        txtSenderViewHolder.replyMessageSentView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        txtSenderViewHolder.replyMessageSentView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }
    private fun setListenersForSenderTextMessages(meetSendViewHolder: MeetSentViewHolder, item: ChatMessage, position: Int) {
        meetSendViewHolder.replyMessageSentView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        meetSendViewHolder.replyMessageSentView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * set single & long click Listeners For Sender Side conversation
     *
     * @param senderItem  sender view in conversation
     * @param messageItem object which hold data to display
     * @param position    list item position
     */
    private fun senderItemClick(senderItem: View, messageItem: ChatMessage, position: Int, mediaClickView: View?=null) {
        mediaClickView?.setOnClickListener {
            if (listener != null) listener!!.onHandleStarredItemMediaClickToAction(messageItem, position)
        }
        mediaClickView?.setOnLongClickListener { _: View? ->
            if (listener != null) listener!!.onSenderItemLongClick(messageItem, position)
            false
        }
        senderItem.setOnClickListener { _: View? ->
            if (listener != null) listener!!.onSenderItemClicked(
                messageItem,
                position
            )
        }
        senderItem.setOnLongClickListener { _: View? ->
            if (listener != null) listener!!.onSenderItemLongClick(messageItem, position)
            false
        }
    }

    /**
     * set Listeners For Receiver Side TextView
     *
     * @param txtReceiverViewHolder holder object
     * @param item                  object which hold data to display
     * @param position              list item position
     */
    private fun setListenersForReceiverTextMessages(txtReceiverViewHolder: TextReceivedViewHolder, item: ChatMessage, position: Int) {
        txtReceiverViewHolder.replyMessageReceivedView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        txtReceiverViewHolder.replyMessageReceivedView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }
    private fun setListenersForReceiverTextMessages(meetReceivedViewHolder: MeetReceivedViewHolder, item: ChatMessage, position: Int) {
        meetReceivedViewHolder.replyMessageReceivedView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        meetReceivedViewHolder.replyMessageReceivedView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * set single & long click Listeners For Receiver Side conversation
     *
     * @param receiverItem sender view in conversation
     * @param messageItem  object which hold data to display
     * @param position     list item position
     */
    private fun receiverItemClick(receiverItem: View, messageItem: ChatMessage, position: Int, mediaClickView: View?=null) {
        mediaClickView?.setOnClickListener {
            if (listener != null) listener!!.onHandleStarredItemMediaClickToAction(messageItem, position)
        }
        mediaClickView?.setOnLongClickListener { _: View? ->
            if (listener != null) listener!!.onSenderItemLongClick(messageItem, position)
            false
        }
        receiverItem.setOnClickListener { _: View? -> if (listener != null) listener!!.onReceiverItemClicked(messageItem, position) }
        receiverItem.setOnLongClickListener { _: View? ->
            if (listener != null) listener!!.onReceiverItemLongClick(messageItem, position)
            false
        }
    }

    /**
     * Handle the audio play click
     *
     * @param chatMessage        chatMessage
     * @param holder            holder of the chat message
     * @param position        Position of the chat item
     * @param playImage       Play button of the audio view
     * @param seekBar         Seek bar of the audio
     * @param durationView    Duration text view
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the chat activity.
     */
    private fun starredAudioPlayClick(chatMessage: ChatMessage, holder: RecyclerView.ViewHolder, position: Int, playImage: ImageView,
                                      seekBar: SeekBar, durationView: TextView, doesSentMessage: Boolean) {
        playImage.setOnClickListener { _: View? ->
            val filePath = Utils.returnEmptyStringIfNull(chatMessage.mediaChatMessage.mediaLocalStoragePath)
            if (mMediaController!!.currentAudioPosition != -1 && position != mMediaController!!.currentAudioPosition) mMediaController!!.resetAudioPlayer(false)
            mMediaController!!.setMediaResource(filePath, chatMessage.mediaChatMessage.mediaDuration, playImage, doesSentMessage)
            mMediaController!!.setMediaSeekBar(seekBar)
            mMediaController!!.setMediaTimer(durationView)
            mMediaController!!.currentAudioPosition = position
            mMediaController!!.handlePlayer(doesSentMessage)
        }
        setAudioSeekBarListener(chatMessage, holder, playImage, seekBar, durationView)
    }

    /**
     * Handle the audio seekbar click
     *
     * @param chatMessage            Message Item data
     * @param holder          View holder of current view in adapter
     * @param playImage       Play button of the audio view
     * @param starredMsgSeekBar         Seek bar of the audio
     * @param durationView to set  duration in the audio
     */
    private fun setAudioSeekBarListener(chatMessage: ChatMessage, holder: RecyclerView.ViewHolder, playImage: ImageView, starredMsgSeekBar: SeekBar,
                                        durationView: TextView) {
        with(holder) {
            val media = chatMessage.mediaChatMessage
            starredMsgSeekBar.setOnSeekBarChangeListener((object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                        mMediaController?.updateSeekbarChangesForStarredMsg(progress,layoutPosition,
                            media.mediaLocalStoragePath,fromUser,durationView,
                            starredMsgSeekBar, playImage)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    /*No Implementation Needed*/
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    mMediaController?.onStopTrackingTouch(seekBar,media.mediaLocalStoragePath)
                }
            }))

        }
    }


    override fun setChatStatus(item: ChatMessage?, viewHolder: ImageView?) {
        chatStarredMessageUtils!!.setChatStatus(viewHolder, item!!.messageStatus)
    }

    override fun setRecentChatStatus(viewHolder: ImageView?, status: MessageStatus?) {
        chatStarredMessageUtils!!.setChatStatus(viewHolder, status)
    }

    override fun setMediaStatus(mediaStatus: MediaStatus) {
        when (mediaStatus.status) {
            MediaDownloadStatus.MEDIA_DOWNLOADED, MediaUploadStatus.MEDIA_UPLOADED -> {
                chatAdapterHelper!!.mediaUploadView(mediaStatus.progressBar!!, mediaStatus.cancelImageview!!, mediaStatus.viewProgress)
                if (mediaStatus.item!!.messageType == MessageType.VIDEO) mediaStatus.imgPlay!!.visibility = View.VISIBLE
                mediaStatus.txtRetry!!.visibility = View.GONE
                mediaStatus.progressbuffer!!.visibility = View.GONE
                if (mediaStatus.download != null) mediaStatus.download!!.visibility = View.GONE
            }
            MediaDownloadStatus.MEDIA_DOWNLOADING, MediaUploadStatus.MEDIA_UPLOADING -> {

                if (mediaStatus.viewProgress != null) mediaStatus.viewProgress!!.visibility = View.VISIBLE
                mediaStatus.progressBar!!.visibility = View.GONE
                mediaStatus.progressbuffer!!.visibility = View.VISIBLE

                mediaStatus.cancelImageview!!.visibility = View.VISIBLE
                mediaStatus.txtRetry!!.visibility = View.GONE
                mediaStatus.download!!.visibility = View.GONE
                mediaStatus.imgPlay!!.visibility = View.GONE
            }
            MediaDownloadStatus.MEDIA_NOT_DOWNLOADED, MediaDownloadStatus.STORAGE_NOT_ENOUGH -> {
                chatAdapterHelper!!.mediaUploadView(mediaStatus.progressBar!!, mediaStatus.cancelImageview!!, mediaStatus.viewProgress)
                mediaStatus.download!!.visibility = View.VISIBLE
                mediaStatus.txtRetry!!.visibility = View.GONE
                mediaStatus.imgPlay!!.visibility = View.GONE
                mediaStatus.progressbuffer!!.visibility = View.GONE
            }
            MediaUploadStatus.MEDIA_NOT_UPLOADED -> {
                mediaStatus.txtRetry!!.visibility = View.VISIBLE
                mediaStatus.imgPlay!!.visibility = View.GONE
                mediaStatus.download!!.visibility = View.GONE
                mediaStatus.progressbuffer!!.visibility = View.GONE
                chatAdapterHelper!!.mediaUploadView(mediaStatus.progressBar!!, mediaStatus.cancelImageview!!, mediaStatus.viewProgress)
            }
        }
    }

    override fun setMediaCaption(mediStatus: MediaCaption) {
        try {
            if (mediStatus.searchEnabled && mediStatus.searchKey.isNotEmpty()) {
                val startIndex = mediStatus.htmlText.toString().checkIndexes(mediStatus.searchKey)
                val stopIndex = startIndex + mediStatus.searchKey.length
                EmojiUtils.setMediaTextHighLightSearchedForMention(
                    context,
                    mediStatus.captionView,
                    mediStatus.htmlText.toString(),
                    startIndex,
                    stopIndex,
                    mediStatus.mentionedUserName
                )
            } else {
                mediStatus.captionView.setBackgroundColor(context!!.color(android.R.color.transparent))
                mediStatus.captionView.setTextKeepState(mediStatus.htmlText)
            }

        } catch (e: Exception) {
            LogMessage.e("Error", e.toString())
        }
    }

    override fun setMediaDuration(txtSendDuration: TextView?, fileStatus: Int, starredMessageItem: ChatMessage?, imgChatType: ImageView?) {
        mediaDetailUtils!!.setMediaView(context, txtSendDuration, fileStatus, starredMessageItem, imgChatType)
    }

    override fun setImageViewSize(starredFileSize: String?, downloadView: View?, starredFileSizeView: TextView?) {
        if (starredFileSize!!.isNotEmpty() && downloadView!!.visibility == View.VISIBLE) {
            var size = 0
            val txtSize = context?.getString(R.string.title_kb)
            if (!starredFileSize.equals(Constants.COUNT_ZERO.toString(), ignoreCase = true))
                size = starredFileSize.toInt() / Constants.ONE_KB
            if (size >= Constants.ONE_KB) {
                starredFileSizeView?.text = ChatUtils.getFileSizeText(starredFileSize)
            } else{
                starredFileSizeView?.text = "$size $txtSize"
            }
        }
    }

    override fun setStatus(item: ChatMessage?, imgChatStatus: ImageView?) {
        chatStarredMessageUtils!!.setChatStatus(imgChatStatus, item!!.messageStatus)
    }

    /**
     * Gets the chat messages.
     *
     * @return List<Message> List of messages
    </Message> */
    fun getMessages(): List<ChatMessage?>? {
        return starredMessageData
    }

    /**
     * This function is used to manipulate the message date
     *
     * @param item message item
     * @return formatted date as string
     */
    @SuppressLint("SimpleDateFormat")
    private fun getMessageDate(item: ChatMessage): String? {
        val formatter = SimpleDateFormat("dd-MMM-yyy", Locale.getDefault())
        val formatter1 = SimpleDateFormat("MMM dd,yyyy", Locale.getDefault())
        var messageDate: String? = null
        try {
            messageDate = ChatUserTimeUtils.getDateFromTimestamp(item.messageSentTime)?.let { dateFromTimeStamp ->
                formatter1.parse(dateFromTimeStamp)
                    ?.let { formatter.format(it) }
            }
        } catch (e: ParseException) {
            LogMessage.e(TAG, e)
        }
        return messageDate
    }

    private fun setListenersForSenderImageMessages(imgViewHolder: ImageSentViewHolder, item: ChatMessage, position: Int) {
        imgViewHolder.replyMessageSentView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        imgViewHolder.replyMessageSentView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param imgViewHolder The view holding the child items.
     * @param item          The data set used to render the content of child views.
     * @param position      The position of the item within the adapter's data set.
     */
    private fun setListenersForReceiverImageMessages(imgViewHolder: ImageReceivedViewHolder, item: ChatMessage, position: Int) {
        imgViewHolder.replyMessageReceivedView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        imgViewHolder.replyMessageReceivedView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
     *
     * @param download       The download view placed in the ViewHolder.
     * @param retry          The retry view placed in the ViewHolder.
     * @param cancelDownload The cancel download view placed in the ViewHolder.
     * @param messageItem    The message object which possess the data rendered in the ViewHolder.
     */
    private fun receiverDownloadClick(download: View, retry: View, cancelDownload: View,
                                      messageItem: ChatMessage, txtSize: View?) {
        download.setOnClickListener { _: View? ->
            if (listener != null) {
                if (txtSize != null && txtSize.visibility == View.VISIBLE) txtSize.visibility = View.GONE
                listener!!.onDownloadClicked(messageItem)
            }
        }
        cancelDownload.setOnClickListener { _: View? ->
            if (listener != null) {
                if (txtSize != null) {
                    txtSize.visibility = View.VISIBLE
                    download.visibility = View.VISIBLE
                }
                cancelMediaUploadOrDownload(messageItem.messageId)
                listener!!.onCancelDownloadClicked(messageItem)
            }
        }
        retry.setOnClickListener { _: View? ->
            if (listener != null && txtSize != null && txtSize.visibility == View.VISIBLE) {
                txtSize.visibility = View.GONE
                download.visibility = View.GONE
            }
            listener!!.onDownloadClicked(messageItem)
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param videoSenderViewHolder The view holding the child items.
     * @param item                  The data set used to render the content of child views.
     * @param position              The position of the item within the adapter's data set.
     */
    private fun setListenersForSenderVideoMessages(videoSenderViewHolder: VideoSentViewHolder, item: ChatMessage, position: Int) {
        videoSenderViewHolder.replyMessageSentView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        videoSenderViewHolder.replyMessageSentView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
     *
     * @param retry              The retry view placed in the ViewHolder.
     * @param cancelUpload       The cancel upload view placed in the ViewHolder.
     * @param messageItem        The message object which possess the data rendered in the
     * ViewHolder.
     * @param carbonDownloadView The carbon download view placed in the ViewHolder.
     */
    private fun senderDownloadClick(retry: View, cancelUpload: View, messageItem: ChatMessage, carbonDownloadView: View) {
        carbonDownloadView.setOnClickListener { _: View? -> if (listener != null) listener!!.onDownloadClicked(messageItem) }
        cancelUpload.setOnClickListener { _: View? ->
            if (listener != null) {
                cancelMediaUploadOrDownload(messageItem.messageId)
                listener!!.onCancelUploadClicked(messageItem)
            }
        }
        retry.setOnClickListener { _: View? -> if (listener != null) listener!!.onRetryClicked(messageItem) }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param videoReceiverViewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     * @param position                The position of the item within the adapter's data set.
     */
    private fun setListenersForReceiverVideoMessages(videoReceiverViewHolder: VideoReceivedViewHolder, item: ChatMessage, position: Int) {
        videoReceiverViewHolder.replyMessageReceivedView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        videoReceiverViewHolder.replyMessageReceivedView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param locationHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param position       The position of the item within the adapter's data set.
     */
    private fun setListenersForReceiverLocationMessages(locationHolder: LocationReceivedViewHolder, item: ChatMessage, position: Int) {
        locationHolder.replyMessageReceivedView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        locationHolder.replyMessageReceivedView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param locationHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param position       The position of the item within the adapter's data set.
     */
    private fun setListenersForSenderLocationMessages(locationHolder: LocationSentViewHolder, item: ChatMessage, position: Int) {
        locationHolder.replyMessageSentView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        locationHolder.replyMessageSentView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param audioViewHolder The view holding the child items.
     * @param item            The data set used to render the content of child views.
     * @param position        The position of the item within the adapter's data set.
     */
    private fun setListenersForAudioMessages(audioViewHolder: AudioSentViewHolder, item: ChatMessage, position: Int) {
        audioViewHolder.replyMessageSentView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        audioViewHolder.replyMessageSentView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
     *
     * @param retry        The retry view placed in the ViewHolder.
     * @param cancelUpload The cancel upload view placed in the ViewHolder.
     * @param messageItem  The message object which possess the data rendered in the ViewHolder.
     */
    private fun uploadClick(retry: View, carbonRetry: View?, cancelUpload: View, messageItem: ChatMessage) {
        retry.setOnClickListener { _: View? -> if (listener != null) listener!!.onRetryClicked(messageItem) }
        carbonRetry?.setOnClickListener { _: View? -> if (listener != null) listener!!.onDownloadClicked(messageItem) }
        cancelUpload.setOnClickListener { _: View? ->
            if (listener != null) {
                cancelMediaUploadOrDownload(messageItem.messageId)
                listener!!.onCancelUploadClicked(messageItem)
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param audioReceiverViewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     * @param position                The position of the item within the adapter's data set.
     */
    private fun setListenersForReceiverAudioMessages(audioReceiverViewHolder: AudioReceivedViewHolder, item: ChatMessage, position: Int) {
        audioReceiverViewHolder.replyMessageSentView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        audioReceiverViewHolder.replyMessageSentView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
     *
     * @param download       The download view placed in the ViewHolder.
     * @param cancelDownload The cancel download view placed in the ViewHolder.
     * @param messageItem    The message object which possess the data rendered in the ViewHolder.
     */
    private fun downloadClick(download: View, cancelDownload: View, messageItem: ChatMessage) {
        download.setOnClickListener { _: View? -> if (listener != null) listener!!.onDownloadClicked(messageItem) }
        cancelDownload.setOnClickListener { _: View? ->
            if (listener != null) {
                cancelMediaUploadOrDownload(messageItem.messageId)
                listener!!.onCancelDownloadClicked(messageItem)
            }
        }
    }

    /**
     * Sets the sender view for the file type chat messages.
     *
     * @param fileViewHolder the holder containing the view item.
     * @param item           the message object comprising the file information.
     * @param time           the time at which the message has been sent.
     */
    private fun setFileSenderView(fileViewHolder: FileSentViewHolder, item: ChatMessage, time: String) {
        fileItemView!!.fileSenderItemView(fileViewHolder, time, item)
        val fileStatus = Utils.returnEmptyStringIfNull(item.mediaChatMessage.getMediaUploadStatus().toString())
        val fileDownloadStatus = Utils.returnEmptyStringIfNull(item.mediaChatMessage.getMediaDownloadStatus().toString())
        fileViewHolder.fileCarbonDownloadView?.gone()
        fileViewHolder.fileUploadViewLayout.gone()
        chatAdapterHelper!!.presentFileTypeView(fileViewHolder.fileUploadCancelLayout, fileViewHolder.fileUploadProgress,
            fileViewHolder.fileUploadProgressBuffer, item.messageId,  if (item.isItCarbonMessage) fileDownloadStatus.toInt() else fileStatus.toInt(),
            null, if (item.isItCarbonMessage) fileViewHolder.fileCarbonDownloadView else fileViewHolder.fileUploadViewLayout)
        if (item.isThisAReplyMessage) {
            fileViewHolder.showSentReplyView()
            ReplyMessageUtils().showReplyMessage(context, fileViewHolder, item.replyParentChatMessage, item.isGroupMessage())
        } else fileViewHolder.hideSentReplyView()
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param fileViewHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param position       The position of the item within the adapter's data set.
     */
    private fun setListenersForSentFileMessages(fileViewHolder: FileSentViewHolder, item: ChatMessage, position: Int) {
        fileViewHolder.replyMessageSentView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        fileViewHolder.replyMessageSentView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param fileViewHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param position       The position of the item within the adapter's data set.
     */
    private fun setListenersForReceivedFileMessages(fileViewHolder: FileReceivedViewHolder, item: ChatMessage, position: Int) {
        fileViewHolder.replyMessageReceivedView?.setOnClickListener { _ -> if (listener != null) listener!!.onReplyMessageClick(item.messageId) }
        fileViewHolder.replyMessageReceivedView?.setOnLongClickListener { _ ->
            if (listener != null) listener!!.onSenderItemLongClick(item, position)
            false
        }
    }

    override fun setStaredStatus(isStarred: Boolean, imageView: ImageView) {
        if (isStarred) imageView.show() else imageView.gone()
    }

    override fun setStarredCaptionStatus(isStarred: Boolean, imageView: ImageView) {
        if (isStarred) imageView.show() else imageView.gone()
    }
}