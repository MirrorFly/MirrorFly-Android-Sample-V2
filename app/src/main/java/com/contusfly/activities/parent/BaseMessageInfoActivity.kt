package com.contusfly.activities.parent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.view.View
import android.view.ViewStub
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.models.MessageType
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.activities.BaseActivity
import com.contusfly.activities.ChatActivity
import com.contusfly.activities.ImageViewActivity
import com.contusfly.chat.ImageFileUtils
import com.contusfly.chat.MapUtils.getMapImageUri
import com.contusfly.chat.MediaController
import com.contusfly.groupmention.MentionUtils
import com.contusfly.utils.*
import com.contusfly.utils.ChatUtils.setReplyViewMessageFormat
import com.contusfly.utils.MediaDetailUtils.getMediaDuration
import com.contusfly.utils.MediaDetailUtils.getMediaDurationInSecs
import com.contusfly.utils.MediaUtils.loadImageWithGlide
import com.contusfly.views.*
import com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener
import com.contusfly.views.CommonAlertDialog.DIALOGTYPE
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyMessenger.getMessageOfId
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.ContactChatMessage
import com.mirrorflysdk.utils.InviteContactUtils
import com.mirrorflysdk.utils.Utils
import java.util.*

/**
 * The class BaseMessageInfoActivity shows single/group chat message in common.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@SuppressLint("Registered")
open class BaseMessageInfoActivity : BaseActivity(), CommonDialogClosedListener {
    /**
     * Display the receipt status of the message, it may be clock, delivered, ack or seen
     */
    var imgChatStatus: ImageView? = null

    var imgFav: ImageView? = null

    var captionStar: ImageView? = null

    /**
     * Message id to load the message info
     */
    var msgId: String? = null

    /**
     * for audion seeker  position
     */
    var seekerPos = 0

    /**
     * Instance of the Message which info is displayed in this activity
     */
    var message: ChatMessage? = null

    /**
     * Instance of the chat utils class that contains the common chat methods
     */
    private var chatClickUtils: ChatClickUtils? = null

    /**
     * The media controller which used to play the audio in the chat view
     */
    private var mMediaController: MediaController? = null
    private var decodeUtils: DecodeImageUtils? = null

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private var commonAlertDialog: CommonAlertDialog? = null

    /**
     * contact msg for invite
     */
    private var selectedContactMessage: ContactChatMessage? = null

    var groupJid: String? = null
    var userJid:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chatClickUtils = ChatClickUtils()
        mMediaController = MediaController(this)
        decodeUtils = DecodeImageUtils()
        commonAlertDialog = CommonAlertDialog(this)
        commonAlertDialog!!.setOnDialogCloseListener(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        msgId = intent?.getStringExtra(com.contusfly.utils.Constants.MESSAGE_ID)
        groupJid = intent?.getStringExtra(com.contusfly.utils.Constants.GROUP_JID)
        userJid = intent?.getStringExtra(com.contusfly.utils.Constants.USER_JID)
        message = getMessageOfId(msgId!!)
        loadMessageView(message)
    }

    override fun onDialogClosed(dialogType: DIALOGTYPE?, isSuccess: Boolean) {
        //do nothing
    }

    override fun listOptionSelected(position: Int) {
        //invite user
        if (commonAlertDialog!!.dialogAction === CommonAlertDialog.DialogAction.INVITE && selectedContactMessage != null) InviteContactUtils().handleSelectedOptions(position, this, null, selectedContactMessage!!.getContactPhoneNumbers()[0])
    }

    /**
     * Load the message based on the message type in the view
     *
     * @param message Message of the loading item
     */
    private fun loadMessageView(message: ChatMessage?) {

        //  Get the message type
        when (val messageType = message!!.getMessageType()) {
            MessageType.TEXT -> loadTextItem(message)
            MessageType.LOCATION -> loadLocation(message)
            MessageType.CONTACT -> loadContactItem(message)
            MessageType.MEET -> loadMeetItem(message)
            else -> loadMediaMessageView(message, messageType)
        }
    }

    /**
     * Display the text message on the view
     *
     * @param message       Message instance of the info message
     */
    private fun loadTextItem(message: ChatMessage?) {
        val stub = findViewById<ViewStub>(R.id.text_item)
        val view = stub.inflate()
        val txtTime = view.findViewById<TextView>(R.id.txt_send_txt_time)
        imgChatStatus = view.findViewById(R.id.img_txt_status)
        imgFav = view.findViewById(R.id.ic_star)
        val txtMessage = view.findViewById<TextView>(R.id.txt_send_chat)
        val replyLayout = view.findViewById<View>(R.id.view_text_sent_reply)
        val txtUsername: CustomTextView = replyLayout.findViewById(R.id.text_reply_user_name)
        val imgIcon: AppCompatImageView = replyLayout.findViewById(R.id.msg_item_icon)
        val txtChat: MessageTextView = replyLayout.findViewById(R.id.text_reply_chat)
        val imgImageVideo: AppCompatImageView = replyLayout.findViewById(R.id.msg_image_video)
        ChatMessageUtils.setFavouriteStatus(imgFav, message!!.isMessageStarred())
        if (message.isThisAReplyMessage())
            replyView(replyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
        else
            replyLayout.gone()
        loadMessageTime(message, txtTime)
        ChatMessageUtils.setChatStatus(imgChatStatus, message.getMessageStatus())
        txtMessage.maxWidth = SharedPreferenceManager.getInt(com.contusfly.utils.Constants.DEVICE_WIDTH)
        if(message.mentionedUsersIds != null && message.mentionedUsersIds.size > 0) {
            val mentionText = MentionUtils.formatMentionText(context!!, message,  false)
            txtMessage.text = mentionText
        } else {
            txtMessage.text = getSpannedText(message.getMessageTextContent())
        }

    }

    private fun loadMeetItem(message: ChatMessage?) {
        val stub = findViewById<ViewStub>(R.id.meet_item)
        val view = stub.inflate()
        val txtTime = view.findViewById<TextView>(R.id.txt_send_txt_time)
        imgChatStatus = view.findViewById(R.id.img_txt_status)
        imgFav = view.findViewById(R.id.ic_star)
        val scheduleLinkView = view.findViewById<LinearLayout>(R.id.schedule_meet_link_view)
        val scheduleMeetLogo = view.findViewById<ImageView>(R.id.schedule_meet_link_logo)
        val scheduledDateTextView = view.findViewById<AppCompatTextView>(R.id.scheduled_date_time_txt_view)
        val meetTxtMessage = view.findViewById<TextView>(R.id.txt_send_chat)
        val meetReplyLayout = view.findViewById<View>(R.id.view_text_sent_reply)
        val txtUsername: CustomTextView = meetReplyLayout.findViewById(R.id.text_reply_user_name)
        val imgIcon: AppCompatImageView = meetReplyLayout.findViewById(R.id.msg_item_icon)
        val txtChat: MessageTextView = meetReplyLayout.findViewById(R.id.text_reply_chat)
        val imgImageVideo: AppCompatImageView = meetReplyLayout.findViewById(R.id.msg_image_video)
        ChatMessageUtils.setFavouriteStatus(imgFav, message!!.isMessageStarred)
        if (message.isThisAReplyMessage)
            replyView(meetReplyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
        else
            meetReplyLayout.gone()
        loadMessageTime(message, txtTime)
        ChatMessageUtils.setChatStatus(imgChatStatus, message.messageStatus)
        meetTxtMessage.maxWidth =
            SharedPreferenceManager.getInt(com.contusfly.utils.Constants.DEVICE_WIDTH)
        meetTxtMessage.text = getSpannedText(message.meetingChatMessage.link)
        meetTxtMessage.setTextColor(ContextCompat.getColor(this, R.color.light_blue))
        meetTxtMessage.setLinkTextColor(ContextCompat.getColor(this, R.color.light_blue))
        scheduledDateTextView.text = ChatUserTimeUtils.scheduledDateTimeFormat(message.meetingChatMessage.scheduledDateTime.toLong())
        val screenWidth = SharedPreferenceManager.getInt(com.contusfly.utils.Constants.DEVICE_WIDTH)
        val lp = LinearLayout.LayoutParams(
            (screenWidth + 20),
            LinearLayout.LayoutParams.WRAP_CONTENT
        ) //20 is nothing but text message margin Start and End value in XML
        scheduleLinkView.layoutParams = lp
        scheduleMeetLogo.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.mirrorfly_icon)!!)

    }

    /**
     * Display the location message on the view
     *
     * @param message       Message instance of the info message
     */
    private fun loadLocation(message: ChatMessage?) {
        val stub = findViewById<ViewStub>(R.id.location_item)
        val view = stub.inflate()
        val txtTime: AppCompatTextView = view.findViewById(R.id.text_send_loc_time)
        imgChatStatus = view.findViewById(R.id.image_loc_send_status)
        val imageSendLocation = view.findViewById<ImageView>(R.id.image_location_send)
        val locationView = view.findViewById<View>(R.id.view_chat_send_loc)
        imgFav = view.findViewById(R.id.ic_star)
        val replyLayout = view.findViewById<View>(R.id.view_reply_content)
        val txtUsername: CustomTextView = replyLayout.findViewById(R.id.text_reply_user_name)
        val imgIcon: AppCompatImageView = replyLayout.findViewById(R.id.msg_item_icon)
        val txtChat: MessageTextView = replyLayout.findViewById(R.id.text_reply_chat)
        val imgImageVideo: AppCompatImageView = replyLayout.findViewById(R.id.msg_image_video)
        ChatMessageUtils.setFavouriteStatus(imgFav, message!!.isMessageStarred())
        checkAndEnableReplyView(replyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
        loadMessageTime(message, txtTime)
        ChatMessageUtils.setChatStatus(imgChatStatus, message.getMessageStatus())
        val locationMessage = message.getLocationChatMessage()
        val url = getMapImageUri(locationMessage.getLatitude(), locationMessage.getLongitude())
        loadImageWithGlide(this, url, imageSendLocation, R.drawable.ic_map_placeholder)
        doOnClick(locationView, message, view)
    }

    /**
     * Display the contact message on the view
     *
     * @param message       Message instance of the info message
     */
    private fun loadContactItem(message: ChatMessage?) {
        val stub = findViewById<ViewStub>(R.id.contact_item)
        val view = stub.inflate()
        val txtTime = view.findViewById<TextView>(R.id.txt_contact_send_time)
        imgChatStatus = view.findViewById(R.id.img_contact_status)
        val txtSendName = view.findViewById<TextView>(R.id.text_contact_send_name)
        val imgContact = view.findViewById<CircularImageView>(R.id.image_contact_picture)
        val contactView = view.findViewById<View>(R.id.view_send_contact)
        imgFav = view.findViewById(R.id.ic_star)
        val txtContactAction: CustomTextView = view.findViewById(R.id.text_contact_action)
        val seperatorLine: View = view.findViewById(R.id.view_contact_separator)
        val replyLayout = view.findViewById<View>(R.id.view_reply_content)
        val txtUsername: CustomTextView = replyLayout.findViewById(R.id.text_reply_user_name)
        val imgIcon: AppCompatImageView = replyLayout.findViewById(R.id.msg_item_icon)
        val txtChat: MessageTextView = replyLayout.findViewById(R.id.text_reply_chat)
        val imgImageVideo: AppCompatImageView = replyLayout.findViewById(R.id.msg_image_video)
        ChatMessageUtils.setFavouriteStatus(imgFav, message!!.isMessageStarred())
        checkAndEnableReplyView(replyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
        if (BuildConfig.CONTACT_SYNC_ENABLED) {
            val registeredJid = getJidFromSharedContact(message.getContactChatMessage())
            if (!registeredJid.isNullOrBlank()) {
                txtContactAction.text = resources.getString(R.string.message)
                txtContactAction.show()
                seperatorLine.show()
                txtContactAction.setOnClickListener { handleContactClick(message, registeredJid) }
                FlyCore.getUserProfile(registeredJid)?.let {
                    imgContact.loadUserProfileImage(this, it)
                }
            } else {
                txtContactAction.text = resources.getString(R.string.invite)
                txtContactAction.show()
                seperatorLine.show()
                setInviteClickListener(txtContactAction, message.getContactChatMessage())
                imgContact.setImageResource(R.drawable.ic_profile)
            }
        } else {
            txtContactAction.gone()
            seperatorLine.gone()
        }
        loadMessageTime(message, txtTime)
        ChatMessageUtils.setChatStatus(imgChatStatus, message.getMessageStatus())
        val contactMessage = message.getContactChatMessage()
        val contactName = contactMessage.getContactName()
        txtSendName.text = contactName
        doOnClick(contactView, message, view)
    }

    /**
     * Handle contact message item click
     *
     * @param clickedMessage Message of the item in view
     */
    private fun handleContactClick(clickedMessage: ChatMessage?, registeredJid: String) {
        startActivity(Intent(this, ChatActivity::class.java)
                .putExtra(LibConstants.JID, registeredJid)
                .putExtra(LibConstants.MESSAGE_ID, clickedMessage!!.getMessageId())
                .putExtra(com.contusfly.utils.Constants.CHAT_TYPE, ChatType.TYPE_CHAT))
    }

    /**
     * handle contact invite click
     * @param view
     * @param contactMessage
     */
    private fun setInviteClickListener(view: View, contactMessage: ContactChatMessage) {
        view.setOnClickListener { inviteUserDialog(contactMessage) }
    }

    private fun inviteUserDialog(contactMessage: ContactChatMessage) {
        selectedContactMessage = contactMessage
        commonAlertDialog!!.dialogAction = CommonAlertDialog.DialogAction.INVITE
        commonAlertDialog!!.showListDialog(getString(R.string.title_invite_friend), resources.getStringArray(R.array.array_invite_contact))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Stop the audio media player
        mMediaController!!.stopPlayer()
    }

    public override fun onPause() {
        super.onPause()
        // Stop the audio media player
        mMediaController!!.stopPlayer()
    }

    private fun getJidFromSharedContact(contactMessage: ContactChatMessage): String? {
        var registeredJid: String? = null
        registeredJid = Constants.EMPTY_STRING
        for (i in contactMessage.getIsChatAppUser().indices) {
            if (java.lang.Boolean.TRUE == contactMessage.getIsChatAppUser()[i]) {
                val countryCode = SharedPreferenceManager.getString(com.contusfly.utils.Constants.COUNTRY_CODE)
                registeredJid = Utils.getJidFromPhoneNumber(this, contactMessage.getContactPhoneNumbers()[i], if (countryCode.isEmpty()) "IN" else countryCode)
                break
            }
        }
        return registeredJid
    }

    /**
     * Load the media message based on the message type in the view
     *
     * @param message       Displaying message
     * @param messageType   Type of the message
     */
    private fun loadMediaMessageView(message: ChatMessage?, messageType: MessageType) {
        when (messageType) {
            MessageType.IMAGE -> loadImageItem(message)
            MessageType.VIDEO -> loadVideoItem(message)
            MessageType.AUDIO -> loadAudioItem(message)
            MessageType.DOCUMENT -> loadFileItem(message)
            else -> {
                /*No Implementation needed*/
            }
        }
    }

    /**
     * Display the Time of message on the view
     *
     * @param message Message item contains message data
     * @param txtTime Time of the message
     */
    private fun loadMessageTime(message: ChatMessage?, txtTime: TextView) {
        val time = ChatMsgTime(Calendar.getInstance()).getDaySentMsg(this, message!!.getMessageSentTime())
        txtTime.text = time
    }

    /**
     * The handler to perform the click event.
     *
     * @param view          the view which receives the click event.
     * @param message       the message object to be processed for the click event.
     * @param itemView      the child item inside the view.
     */
    private fun doOnClick(view: View, message: ChatMessage?, itemView: View) {
        if (MessageType.AUDIO == message!!.getMessageType()) {
            val filePath = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaLocalStoragePath())
            audioPlayClick(filePath, message.getMediaChatMessage().getMediaDuration(), itemView.findViewById(R.id.image_audio_action),
                    itemView.findViewById(R.id.seek_audio_progress),
                    itemView.findViewById(R.id.text_audio_duration), message.isMessageSentByMe())
        } else view.setOnClickListener { chatClickUtils!!.handleOnListClick(message, this) }
    }

    /**
     * Display the image message on the view
     *
     * @param message       Message instance of the info message
     */
    private fun loadImageItem(message: ChatMessage?) {
        try {
            val stub = findViewById<ViewStub>(R.id.image_item)
            val view = stub.inflate()
            val txtTime = view.findViewById<TextView>(R.id.txt_send_img_time)
            imgChatStatus = view.findViewById(R.id.img_send_status)
            val imageSenderImg = view.findViewById<RoundRectCornerImageView>(R.id.img_send_imgitem)
            val layoutSenderImg = view.findViewById<RelativeLayout>(R.id.view_chat_send_img_lay)
            val imageView = view.findViewById<View>(R.id.view_chat_send_img)
            imgFav = view.findViewById<ImageView>(R.id.ic_star)
            val balloon = view.findViewById<View>(R.id.balloon)
            val captionContent = view.findViewById<View>(R.id.view_sent_image_caption)
            val caption = captionContent.findViewById<TextView>(R.id.txt_caption_sent_chat)
            captionStar = captionContent.findViewById<ImageView>(R.id.ic_star)
            val imgStatus = captionContent.findViewById<ImageView>(R.id.caption_image_send_status)
            val txtCaptionTime: AppCompatTextView = captionContent.findViewById(R.id.caption_text_send_image_time)
            val replyLayout = view.findViewById<View>(R.id.view_reply_content)
            val txtUsername: CustomTextView = replyLayout.findViewById(R.id.text_reply_user_name)
            val imgIcon: AppCompatImageView = replyLayout.findViewById(R.id.msg_item_icon)
            val txtChat: MessageTextView = replyLayout.findViewById(R.id.text_reply_chat)
            val imgImageVideo: AppCompatImageView = replyLayout.findViewById(R.id.msg_image_video)
            val calculatedDimension = ChatUtils.getMobileWidthAndHeight(message!!.getMediaChatMessage().getMediaFileWidth(), message.getMediaChatMessage().getMediaFileHeight())
            layoutSenderImg.setWidthAndHeight(calculatedDimension.second, calculatedDimension.first)
            if (message.isThisAReplyMessage()) {
                replyView(replyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
            } else
                replyLayout.gone()
            if (message.getMediaChatMessage().getMediaCaptionText() != null && message.getMediaChatMessage().getMediaCaptionText().isNotEmpty()) {
                ChatMessageUtils.setFavouriteStatus(imgFav, false)
                balloon.gone()
                captionContent.show()
                ChatMessageUtils.setChatStatus(imgStatus, message.getMessageStatus())
                loadMessageTime(message, txtCaptionTime)
                val filePath = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaLocalStoragePath())
                val base64Img = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaThumbImage())
                val decodeImageUtils = DecodeImageUtils()
                decodeImageUtils.loadImageInView(imageSenderImg, filePath, base64Img,
                        this, R.drawable.ic_image_placeholder)
                if(message.mentionedUsersIds != null && message.mentionedUsersIds.size > 0) {
                    val mentionText = MentionUtils.formatMentionText(context!!, message,  false)
                    caption.text = mentionText
                } else {
                    caption.text = getSpannedText(message.getMediaChatMessage().getMediaCaptionText())
                }

            } else {
                ChatMessageUtils.setFavouriteStatus(imgFav, message.isMessageStarred())
                balloon.show()
                captionContent.gone()
                loadMessageTime(message, txtTime)
                ChatMessageUtils.setChatStatus(imgChatStatus, message.getMessageStatus())
                val filePath = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaLocalStoragePath())
                val base64Img = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaThumbImage())
                val decodeImageUtils = DecodeImageUtils()
                decodeImageUtils.loadImageInView(imageSenderImg, filePath, base64Img,
                        this, R.drawable.ic_image_placeholder)
            }
            doOnImageClick(imageView, message)
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Display the video message on the view
     *
     * @param message       Message instance of the info message
     */
    private fun loadVideoItem(message: ChatMessage?) {
        val stub = findViewById<ViewStub>(R.id.video_item)
        val view = stub.inflate()
        val txtTime: AppCompatTextView = view.findViewById(R.id.text_message_time)
        imgChatStatus = view.findViewById(R.id.image_message_status)
        val durationTxt: AppCompatTextView = view.findViewById(R.id.text_video_send_duration)
        val imgSendChatType = view.findViewById<ImageView>(R.id.image_sent_chat_type)
        imgFav = view.findViewById<ImageView>(R.id.ic_star)
        val captionContent = view.findViewById<View>(R.id.view_sent_image_caption)
        val layoutSenderVideo = view.findViewById<RelativeLayout>(R.id.view_chat_img_lay)
        val captionText=captionContent.findViewById<TextView>(R.id.txt_caption_sent_chat)
        captionStar = captionContent.findViewById<ImageView>(R.id.ic_star)
        val captionStatus = captionContent.findViewById<ImageView>(R.id.caption_image_send_status)
        val captionTime: AppCompatTextView = captionContent.findViewById(R.id.caption_text_send_image_time)
        val replyLayout = view.findViewById<View>(R.id.view_reply_content)
        val txtUsername: CustomTextView = replyLayout.findViewById(R.id.text_reply_user_name)
        val imgIcon: AppCompatImageView = replyLayout.findViewById(R.id.msg_item_icon)
        val txtChat: MessageTextView = replyLayout.findViewById(R.id.text_reply_chat)
        val imgImageVideo: AppCompatImageView = replyLayout.findViewById(R.id.msg_image_video)
        val calculatedDimension = ChatUtils.getMobileWidthAndHeight(message!!.getMediaChatMessage().getMediaFileWidth(), message.getMediaChatMessage().getMediaFileHeight())
        layoutSenderVideo.setWidthAndHeight(calculatedDimension.second, calculatedDimension.first)
        if (message.isThisAReplyMessage()) {
            replyView(replyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
        } else
            replyLayout.gone()
        if (message.getMediaChatMessage().getMediaCaptionText() != null && message.getMediaChatMessage().getMediaCaptionText().isNotEmpty()) {
            txtTime.gone()
            imgChatStatus?.gone()
            ChatMessageUtils.setFavouriteStatus(imgFav, false)
            captionContent.show()
            ChatMessageUtils.setChatStatus(captionStatus, message.getMessageStatus())
            loadMessageTime(message, captionTime)
            ChatMessageUtils.setFavouriteStatus(captionStar, message.isMessageStarred())
            if(message.mentionedUsersIds != null && message.mentionedUsersIds.size > 0) {
                val mentionText = MentionUtils.formatMentionText(context!!, message,  false)
                captionText.text = mentionText
            } else {
               captionText.text = getSpannedText(message.getMediaChatMessage().getMediaCaptionText())
            }
        } else {
            txtTime.show()
            imgChatStatus?.show()
            captionContent.gone()
            ChatMessageUtils.setChatStatus(imgChatStatus, message.getMessageStatus())
            loadMessageTime(message, txtTime)
            ChatMessageUtils.setFavouriteStatus(imgFav, message.isMessageStarred())
        }
        val fileDownloadStatus = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaDownloadStatus().toString())
        MediaDetailUtils.setMediaView(this, durationTxt, fileDownloadStatus.toInt(), message, imgSendChatType)
        val videoSenderImg = view.findViewById<RoundRectCornerImageView>(R.id.image_send_item)
        val filePath = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaLocalStoragePath())
        val base64Img = Utils.returnEmptyStringIfNull(message.getMediaChatMessage().getMediaThumbImage())
        val decodeImageUtils = DecodeImageUtils()
        decodeImageUtils.loadImageInView(videoSenderImg, filePath, base64Img,
            this, R.drawable.ic_image_placeholder)
        doOnClick(layoutSenderVideo, message, view)
    }

    /**
     * Display the audio message on the view
     *
     * @param message Message instance of the info message
     */
    private fun loadAudioItem(message: ChatMessage?) {
        val stub = findViewById<ViewStub>(R.id.audio_item)
        val view = stub.inflate()
        val txtTime: AppCompatTextView = view.findViewById(R.id.text_audio_time)
        imgChatStatus = view.findViewById(R.id.image_audio_status)
        val imgPlay = view.findViewById<ImageView>(R.id.image_audio_action)
        val audioRetryLayout = view.findViewById<View>(R.id.audio_retry_layout)
        val downloadProgressLayout = view.findViewById<View>(R.id.download_progress_layout)
        imgPlay.visibility = View.VISIBLE
        audioRetryLayout.visibility = View.GONE
        downloadProgressLayout.visibility = View.GONE
        loadMessageTime(message, txtTime)
        ChatMessageUtils.setChatStatus(imgChatStatus, message!!.getMessageStatus())
        val replyLayout = view.findViewById<View>(R.id.view_text_sent_reply)
        val textSentReplyLayout: ConstraintLayout? = view.findViewById(R.id.view_text_sent_reply_layout)
        val txtUsername: CustomTextView = replyLayout.findViewById(R.id.text_reply_user_name)
        val imgIcon: AppCompatImageView = replyLayout.findViewById(R.id.msg_item_icon)
        val txtChat: MessageTextView = replyLayout.findViewById(R.id.text_reply_chat)
        val imgImageVideo: AppCompatImageView = replyLayout.findViewById(R.id.msg_image_video)
        if (message.isThisAReplyMessage()) {
            textSentReplyLayout?.show()
            replyView(replyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
        } else {
            textSentReplyLayout?.gone()
            replyLayout.gone()
        }
        imgFav = view.findViewById<ImageView>(R.id.image_audio_favorite)
        ChatMessageUtils.setFavouriteStatus(imgFav, message.isMessageStarred())
        val txtDuration: AppCompatTextView = view.findViewById(R.id.text_audio_duration)
        val imgAudioType: AppCompatImageView = view.findViewById(R.id.image_audio_type)
        if (seekerPos > 0) {
            val maxSeekbar = getMediaDurationInSecs(message.getMediaChatMessage().getMediaDuration())
            val sbProgress = view.findViewById<MirrorFlySeekBar>(R.id.seek_audio_progress)
            sbProgress.max = maxSeekbar
            sbProgress.progress = seekerPos
            txtDuration.text = ChatMessageUtils.getFormattedTime(seekerPos)
        } else {
            txtDuration.text = getMediaDuration(this, message.getMediaChatMessage().getMediaDuration())
        }
        if (message.mediaChatMessage.isAudioRecorded) {
            imgAudioType.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_audio_recorded_icon))
        } else {
            imgAudioType.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_audio_music_icon))
        }
        doOnClick(imgPlay, message, view)
    }

    /**
     * Display the file message on the view
     *
     * @param message Message instance of the info message
     */
    private fun loadFileItem(message: ChatMessage?) {
        val stub = findViewById<ViewStub>(R.id.file_item)
        val view = stub.inflate()
        val txtTime = view.findViewById<TextView>(R.id.txt_send_file_time)
        imgChatStatus = view.findViewById(R.id.file_send_status)
        val txtFileName = view.findViewById<TextView>(R.id.txt_send_file_name)
        val fileImage = view.findViewById<ImageView>(R.id.img_send_doc)
        val fileView = view.findViewById<View>(R.id.view_send_file)
        imgFav = view.findViewById<ImageView>(R.id.ic_star)
        val txtFileSize = view.findViewById<TextView>(R.id.text_file_size)
        ChatMessageUtils.setFavouriteStatus(imgFav, message!!.isMessageStarred())
        val replyLayout = view.findViewById<View>(R.id.view_reply_content)
        val txtUsername: CustomTextView = replyLayout.findViewById(R.id.text_reply_user_name)
        val imgIcon: AppCompatImageView = replyLayout.findViewById(R.id.msg_item_icon)
        val txtChat: MessageTextView = replyLayout.findViewById(R.id.text_reply_chat)
        val imgImageVideo: AppCompatImageView = replyLayout.findViewById(R.id.msg_image_video)
        checkAndEnableReplyView(replyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
        val fileName = if (message.getMediaChatMessage().getMediaFileName() != null) message.getMediaChatMessage().getMediaFileName() else Uri.parse(message.getMediaChatMessage().getMediaLocalStoragePath()).lastPathSegment!!
        txtFileName.text = fileName
        ImageFileUtils.setFileImage(fileImage, fileName)
        loadMessageTime(message, txtTime)
        ChatMessageUtils.setChatStatus(imgChatStatus, message.getMessageStatus())
        txtFileSize.text = Utils.getFileSizeText(message.getMediaChatMessage().getMediaFileSize().toString())
        doOnClick(fileView, message, view)
    }

    /**
     * The handler to perform the click event.
     *
     * @param view          the view which receives the click event.
     * @param message       the message object to be processed for the click event.
     */
    private fun doOnImageClick(view: View, message: ChatMessage?) {
        view.setOnClickListener {
            // Checks if any media content available in message
            message?.let {
                if (MediaChecker.isMediaAvailable(message)) {
                    startActivity(Intent(this, ImageViewActivity::class.java).putExtra(Constants.GROUP_ID, groupJid).putExtra(Constants.USER_JID, userJid)
                        .putExtra(Constants.MEDIA_URL, message.getMediaChatMessage().getMediaLocalStoragePath()))

                }
            }
        }
    }

    /**
     * Handle the audio play click
     *
     * @param filePath        Local path of the audio
     * @param duration        Local file duration
     * @param playImage       Play button of the audio view
     * @param seekBar         Seek bar of the audio
     * @param durationView    Duration text view
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    private fun audioPlayClick(filePath: String, duration: Long, playImage: ImageView, seekBar: SeekBar,
                               durationView: AppCompatTextView, doesSentMessage: Boolean) {
        playImage.setOnClickListener {
            mMediaController!!.setMediaResource(filePath, duration, playImage, doesSentMessage)
            mMediaController!!.setMediaSeekBar(seekBar)
            mMediaController!!.setMediaTimer(durationView)
            mMediaController!!.handlePlayer(doesSentMessage)
        }
    }

    private fun replyView(layout: View, txtUsername: CustomTextView,
                          imgIcon: AppCompatImageView,
                          txtChat: MessageTextView,
                          imgImageVideo: AppCompatImageView,
                          replyChatMessage: ChatMessage) {
        try {
            val replyMessage = replyChatMessage.getReplyParentChatMessage()
            txtUsername.setTextColor(replyMessage.getSenderName().getColourCode())
            txtUsername.text = replyMessage.getSenderName()
            if (replyMessage.isMessageRecalled() || replyMessage.isMessageDeleted()) {
                txtChat.text = getString(R.string.recalled_message_not_available)
            } else {
                when (replyMessage.getMessageType()) {
                    MessageType.TEXT -> {
                        txtChat.maxWidth = SharedPreferenceManager.getInt(com.contusfly.utils.Constants.DEVICE_WIDTH)
                        replyChatMessage?.let { setReplyViewMessageFormat(it,context!!,txtChat!!,"",false) }
                        imgImageVideo.gone()
                        layout.show()
                    }
                    MessageType.LOCATION -> {
                        txtChat.text = getString(R.string.action_location)
                        imgIcon.setImageResource(R.drawable.ic_map_reply)
                        imgIcon.show()
                        imgImageVideo.show()
                        val url = getMapImageUri(
                            replyMessage.getLocationChatMessage().getLatitude(),
                            replyMessage.getLocationChatMessage().getLongitude()
                        )
                        loadImageWithGlide(this,
                            url, imgImageVideo, R.drawable.ic_map_placeholder)
                        layout.show()
                    }
                    MessageType.CONTACT -> {
                        val contactMessage = (getString(R.string.action_contact) + " : "
                                + replyMessage.getContactChatMessage().getContactName())
                        txtChat.text = contactMessage
                        imgIcon.setImageResource(R.drawable.ic_contact_reply)
                        imgIcon.show()
                        layout.show()
                    }
                    MessageType.DOCUMENT -> {
                        val fileMessage = if (replyMessage.getMediaChatMessage().getMediaFileName().isEmpty()) this.getString(R.string.title_file) else replyMessage.getMediaChatMessage().getMediaFileName()
                        EmojiUtils.setMessageTextWithEllipsis(txtChat, fileMessage)
                        imgIcon.show()
                        imgImageVideo.gone()
                        imgIcon.setImageResource(R.drawable.ic_file_reply)
                        layout.show()
                    }
                    else -> mediaReplyView(layout, imgIcon, txtChat, imgImageVideo, replyChatMessage)
                }
            }
        } catch(e:NullPointerException) {
            LogMessage.e("Error",e.toString())
        } catch(e:Exception) {
            LogMessage.e("Error",e.toString())
        }

    }

    private fun mediaReplyView(layout: View,
                               imgIcon: AppCompatImageView,
                               txtChat: MessageTextView,
                               imgImageVideo: AppCompatImageView,
                               replyChatMessage: ChatMessage) {
        val replyMessage = replyChatMessage.getReplyParentChatMessage()
        when (replyMessage.getMessageType()) {
            MessageType.IMAGE, MessageType.VIDEO -> {
                val mediaDetail = replyMessage.getMediaChatMessage()
                val messageCaption: String
                if (replyMessage.getMessageType() == MessageType.IMAGE) {
                    messageCaption = if (TextUtils.isEmpty(mediaDetail.getMediaCaptionText())) getString(R.string.title_image) else mediaDetail.getMediaCaptionText()
                    imgIcon.setImageResource(R.drawable.ic_camera_reply)
                } else {
                    messageCaption = if (TextUtils.isEmpty(mediaDetail.getMediaCaptionText())) getString(R.string.title_video) else mediaDetail.getMediaCaptionText()
                    imgIcon.setImageResource(R.drawable.ic_video_reply)
                }
                replyChatMessage.let { setReplyViewMessageFormat(it,context!!,txtChat,messageCaption,true) }

                imgIcon.show()
                imgImageVideo.show()
                decodeUtils!!.loadImageInView(
                        imgImageVideo,
                        mediaDetail.getMediaLocalStoragePath(),
                        mediaDetail.getMediaThumbImage(),
                        this,
                        R.drawable.ic_image_placeholder
                )
                layout.show()
            }
            MessageType.AUDIO -> {
                txtChat.text = getMediaDuration(this, replyMessage.getMediaChatMessage().getMediaDuration())
                imgIcon.gone()
                imgImageVideo.show()
                imgImageVideo.setImageResource(if (replyMessage.getMediaChatMessage().isAudioRecorded()) R.drawable.ic_record_audio_reply else R.drawable.ic_music_audio_reply)
                layout.show()
            }
            else -> {
                /*No Implementation needed*/
            }
        }
    }

    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private fun getSpannedText(message: String?): Spanned {
        val htmlText: Spanned
        val chatMessage = getHtmlChatMessageText(message!!).replace("\n", "<br>").replace("  ", "&nbsp;&nbsp;")
        htmlText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Html.fromHtml(getHtmlChatMessageText(chatMessage), Html.FROM_HTML_MODE_LEGACY)
        else
            Html.fromHtml(getHtmlChatMessageText(chatMessage))

        return if (htmlText.isEmpty() && chatMessage != "")
            SpannableStringBuilder(getHtmlChatMessageText(chatMessage))
        else
            htmlText
    }

    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in
     * FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private fun getHtmlChatMessageText(message: String): String {
        val text = getString(R.string.chat_text)
        return message + text
    }

    private fun checkAndEnableReplyView(replyLayout: View, txtUsername: CustomTextView, imgIcon: AppCompatImageView, txtChat: MessageTextView, imgImageVideo: AppCompatImageView, message: ChatMessage) {
        if (message.isThisAReplyMessage())
            replyView(replyLayout, txtUsername, imgIcon, txtChat, imgImageVideo, message)
        else
            replyLayout.gone()
    }
}