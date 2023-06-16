/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contusfly.adapters

import android.Manifest
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.emoji.widget.EmojiAppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.*
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.*
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.adapters.holders.*
import com.contusfly.adapters.viewhelpers.AudioItemView
import com.contusfly.adapters.viewhelpers.FileItemView
import com.contusfly.adapters.viewhelpers.ImageItemViewHelper
import com.contusfly.adapters.viewhelpers.VideoItemViewHelper
import com.contusfly.chat.MapUtils
import com.contusfly.chat.MediaController
import com.contusfly.chat.MessageUtils
import com.contusfly.chat.reply.ReplyViewUtils
import com.contusfly.checkInternetAndExecute
import com.contusfly.groupmention.MentionUtils
import com.contusfly.interfaces.MessageItemListener
import com.contusfly.interfaces.OnChatItemClickListener
import com.contusfly.models.MediaStatus
import com.contusfly.utils.*
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CustomTextView
import com.contusfly.views.MirrorFlySeekBar
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.MessageStatus
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.ContactChatMessage
import com.mirrorflysdk.utils.Utils
import com.location.googletranslation.GoogleTranslation
import java.util.*
import kotlin.collections.ArrayList


/**
 * Recycler adapter which used to list the chat view using recycler view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */

class ChatAdapter(
    private val mainlist: ArrayList<ChatMessage>,
    private var selectedMessages: ArrayList<String>,
    private val chatType: String,
    val activity: Context,
    val userJid: String)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), MessageItemListener {

    var isLinkLongclick: Boolean = false


    /**
     * The listener instance of OnChatItemClickListener
     */
    private var listener: OnChatItemClickListener? = null

    /**
     * The startupActivityContext of the list view activity
     */
    private val context: Context = activity

    /**
     * The chat msg time which used to display the chat received and send time
     */
    private val chatMsgTime: ChatMsgTime

    /**
     * Helper for the Adapter
     */
    private val chatAdapterHelper: ChatAdapterHelper

    /**
     * Image item view helper
     */
    private val imageItemViewHelper: ImageItemViewHelper

    /**
     * Video item view helper
     */
    private val videoItemViewHelper: VideoItemViewHelper

    /**
     * Audio item view
     */
    private val audioItemView: AudioItemView

    /**
     * Audio item view
     */
    private val fileItemView: FileItemView

    /**
     * The media controller which used to play the audio in the chat view
     */
    private val mediaController: MediaController = MediaController(context)

    /**
     * Selected translated language
     */
    private val selectedLanguage: String

    /**
     * google translation key
     */
    private val googleTranslatedKey: String

    private val doublePRESSINTERVAL: Long

    private var lastPressTime: Long = 0L

    /**
     * This boolean help to identify the translation field was enable or not
     */
    private val isTranslationChecked: Boolean


    /**
     * This is a kotlin ReplyView utils class
     */
    private val replyViewUtils: ReplyViewUtils

    /**
     * Sets the on download click listener.
     *
     * @param listener The listener when the chat item download clicked
     */
    fun setOnDownloadClickListener(listener: OnChatItemClickListener?) {
        this.listener = listener
    }

    private var searchEnabled = false
    private var searchKey = emptyString()

    fun setSearch(isSearchEnabled: Boolean, searchKey: String) {
        this.searchEnabled = isSearchEnabled
        this.searchKey = searchKey
    }

    /**
     * This method calls to create a new [RecyclerView.ViewHolder] and initializes some
     * private fields to be used by RecyclerView.
     *
     * @see .onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return chatAdapterHelper.getItemViewHolder(parent, viewType)!!
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty() || payloads[0] !is Bundle)
            onBindViewHolder(holder, position)
        else {
            val item = mainlist[position]
            val bundle = payloads[0] as Bundle
            handlePayloads(bundle, holder, item, position)
        }
    }

    private fun handlePayloads(
        bundle: Bundle,
        holder: RecyclerView.ViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        for (key in bundle.keySet()) {
            with(holder) {
                when (this) {
                    is TextSentViewHolder -> {
                        handlePayloadsTextSender(key, this, item, position)
                    }
                    is TextReceivedViewHolder -> {
                        handlePayloadsTextReceived(key, this, item, position)
                    }
                    is LocationSentViewHolder -> {
                        handlePayloadsLocationSent(key, this, item, position)
                    }
                    is LocationReceivedViewHolder -> {
                        handlePayloadsLocationReceived(key, this, item, position)
                    }
                    is FileSentViewHolder -> {
                        handlePayloadsFileSent(key, this, item, position)
                    }
                    is FileReceivedViewHolder -> {
                        handlePayloadsFileReceived(key, this, item, position)
                    }
                    is AudioSentViewHolder -> {
                        handlePayloadsAudioSent(key, this, item, position)
                    }
                    is AudioReceivedViewHolder -> {
                        handlePayloadsAudioReceived(key, this, item, position)
                    }
                    is ImageSentViewHolder -> {
                        handlePayloadsImageSent(key, this, item, position)
                    }
                    is ImageReceivedViewHolder -> {
                        handlePayloadsImageReceived(key, this, item, position)
                    }
                    is VideoSentViewHolder -> {
                        handlePayloadsVideoSent(key, this, item, position)
                    }
                    is VideoReceivedViewHolder -> {
                        handlePayloadsVideoReceived(key, this, item, position)
                    }
                    is ContactSentViewHolder -> {
                        handlePayloadsContactSent(key, this, item, position)
                    }
                    is ContactReceivedViewHolder -> {
                        handlePayloadsContactReceived(key, this, item, position)
                    }
                }
            }
        }
    }

    private fun handlePayloadsTextSender(
        key: String,
        textSentViewHolder: TextSentViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(textSentViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    bindSenderTextView(this, item, position)
                else {
                    isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                    setStatus(item, imgChatStatus)
                    replyViewUtils.markFavoriteItem(this, item)
                }
            }
        }
    }

    private fun handlePayloadsTextReceived(
        key: String,
        textReceivedViewHolder: TextReceivedViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(textReceivedViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    bindReceiverTextView(this, item, position)
                else {
                    replyViewUtils.markFavoriteItem(this, item)
                }
            }
        }
    }

    private fun handlePayloadsLocationSent(
        key: String,
        locationSentViewHolder: LocationSentViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(locationSentViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    bindSenderLocationView(this, item, position)
                else {
                    isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                    setStatus(item, imgSenderStatus)
                    replyViewUtils.showSenderReplyWindow(this, item, context)
                    if(item.isMessageAcknowledged() || item.isMessageDelivered() || item.isMessageSeen())
                        imgForwardLocation?.show()
                    imgForwardLocation?.setOnClickListener { listener?.onSenderMediaForward(item, layoutPosition) }
                }
            }
        }
    }

    private fun handlePayloadsLocationReceived(
        key: String,
        locationReceivedViewHolder: LocationReceivedViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(locationReceivedViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    bindReceiverLocationView(this, item, position)
                else {
                    replyViewUtils.showReceiverReplyWindow(this, item, context)
                }
            }
        }
    }

    private fun handlePayloadsFileSent(
        key: String,
        fileSentViewHolder: FileSentViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(fileSentViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    fileSentViewLayout,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED)
                fileItemView.handleSenderFileItemProgressUpdate(item, this)
            else if (key == Constants.NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED)
                setFileMediaStatusSenderView(this, item)
            else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    getFileView(this, item, position)
                else {
                    isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                    setStatus(item, fileStatusImage)
                    setStaredStatus(item.isMessageStarred(), fileFavoriteImage)
                }
            }
        }
    }

    private fun handlePayloadsFileReceived(
        key: String,
        fileReceivedViewHolder: FileReceivedViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(fileReceivedViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    fileReceivedViewLayout,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED)
                fileItemView.handleReceiverFileItemProgressUpdate(item, this)
            else if (key == Constants.NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED)
                setFileMediaStatusReceiverView(this, item)
            else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    getFileView(this, item, position)
                else {
                    replyViewUtils.markFavoriteItem(this, item)
                }
            }
        }
    }

    private fun handlePayloadsAudioSent(
        key: String,
        audioSentViewHolder: AudioSentViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(audioSentViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED)
                audioItemView.handleSenderAudioItemProgressUpdate(item, this)
            else if (key == Constants.NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED) {
                audioItemView.setAudioSenderMediaStatus(this, item)
                if (item.isMediaDownloaded())
                    audioPlayClick(
                        item,
                        this,
                        imgAudioPlay,
                        audioMirrorFlySeekBar,
                        txtAudioDuration,
                        true
                    )
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    getAudioView(this, item, position)
                else {
                    isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                    setStatus(item, imgSenderStatus)
                    replyViewUtils.showSenderReplyWindow(this, item, context)
                }
            }
        }
    }

    private fun handlePayloadsAudioReceived(
        key: String,
        audioReceiverViewHolder: AudioReceivedViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(audioReceiverViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED)
                audioItemView.handleReceiverAudioItemProgressUpdate(item, this)
            else if (key == Constants.NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED) {
                audioItemView.setAudioReceiverMediaStatus(this, item)
                if (item.isMediaDownloaded())
                    audioPlayClick(
                        item,
                        this,
                        imgAudioPlay,
                        audioMirrorFlySeekBar,
                        txtAudioDuration,
                        false
                    )
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    getAudioView(this, item, position)
                else {
                    setStaredStatus(item.isMessageStarred(), audRevStarred)
                }
            }
        }
    }

    private fun handlePayloadsImageSent(
        key: String,
        imageSentViewHolder: ImageSentViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(imageSentViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED)
                imageItemViewHelper.handleSenderImageItemProgressUpdate(item, this)
            else if (key == Constants.NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED) {
                handleImageMediaStatusChanged(this, item)
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    bindSenderImageView(this, item, position)
                else {
                    isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                    setStatus(item, getStatusIcon(item, imgSenderStatus, imgSentImageCaptionStatus))
                    setStaredStatus(
                        item.isMessageStarred(),
                        getStarIcon(item, imgSentStarred, imgSentCaptionStar)
                    )
                }
            }
        }
    }

    private fun handleImageMediaStatusChanged(
        imageSentViewHolder: ImageSentViewHolder,
        item: ChatMessage
    ) {
        with(imageSentViewHolder) {
            if (item.isMediaDownloaded() || item.isMediaUploaded())
                imageItemViewHelper.handleImageLoading(
                    this,
                    Utils.returnEmptyStringIfNull(
                        item.getMediaChatMessage().getMediaLocalStoragePath()
                    ),
                    Utils.returnEmptyStringIfNull(item.getMediaChatMessage().getMediaThumbImage())
                )
            imageItemViewHelper.setImageSenderMediaStatus(this, item)
        }
    }

    private fun handlePayloadsImageReceived(
        key: String,
        imageReceivedViewHolder: ImageReceivedViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(imageReceivedViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED)
                imageItemViewHelper.handleReceiverImageItemProgressUpdate(item, this)
            else if (key == Constants.NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED) {
                if (item.isMediaDownloaded())
                    imageItemViewHelper.handleReceiverImageLoading(
                        this,
                        Utils.returnEmptyStringIfNull(
                            item.getMediaChatMessage().getMediaLocalStoragePath()
                        ),
                        Utils.returnEmptyStringIfNull(
                            item.getMediaChatMessage().getMediaThumbImage()
                        )
                    )
                imageItemViewHelper.setImageReceiverMediaStatus(this, item)
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    bindReceiverImageView(this, item, position)
                else {
                    setStaredStatus(
                        item.isMessageStarred(),
                        getStarIcon(item, imgStarred, txtRevCaptionStar)
                    )
                }
            }
        }
    }

    private fun handlePayloadsVideoSent(
        key: String,
        videoSentViewHolder: VideoSentViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(videoSentViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED)
                videoItemViewHelper.handleSenderVideoItemProgressUpdate(item, videoSentViewHolder)
            else if (key == Constants.NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED) {
                handleVideoMediaStatusChanged(this, item)
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    bindSenderVideoView(this, item, position)
                else {
                    isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                    setStatus(item, getStatusIcon(item, imgSenderStatus, imgSentImageCaptionStatus))
                    setStaredStatus(
                        item.isMessageStarred(),
                        getStarIcon(item, imgSentStarred, imgSentCaptionStar)
                    )
                }
            }
        }
    }

    private fun handleVideoMediaStatusChanged(
        videoSentViewHolder: VideoSentViewHolder,
        item: ChatMessage
    ) {
        with(videoSentViewHolder) {
            if (item.isMediaDownloaded() || item.isMediaUploaded())
                videoItemViewHelper.handleVideoLoading(
                    item,
                    this,
                    Utils.returnEmptyStringIfNull(
                        item.getMediaChatMessage().getMediaUploadStatus().toString()
                    ),
                    Utils.returnEmptyStringIfNull(
                        item.getMediaChatMessage().getMediaLocalStoragePath()
                    ),
                    Utils.returnEmptyStringIfNull(item.getMediaChatMessage().getMediaThumbImage())
                )
            videoItemViewHelper.setVideoSenderMediaStatus(this, item)
        }
    }

    private fun handlePayloadsVideoReceived(
        key: String,
        videoReceivedViewHolder: VideoReceivedViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(videoReceivedViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED)
                videoItemViewHelper.handleReceiverVideoItemProgressUpdate(
                    item,
                    videoReceivedViewHolder
                )
            else if (key == Constants.NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED) {
                if (item.isMediaDownloaded())
                    videoItemViewHelper.handleReceiverVideoLoading(
                        this,
                        Utils.returnEmptyStringIfNull(
                            item.getMediaChatMessage().getMediaLocalStoragePath()
                        ),
                        Utils.returnEmptyStringIfNull(
                            item.getMediaChatMessage().getMediaThumbImage()
                        )
                    )
                videoItemViewHelper.setVideoReceiverMediaStatus(this, item)
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    bindReceiverVideoView(this, item, position)
                else {
                    setStaredStatus(
                        item.isMessageStarred(),
                        getStarIcon(item, imgStarred, txtRevCaptionStar)
                    )
                }
            }
        }
    }


    private fun handlePayloadsContactSent(
        key: String,
        contactSentViewHolder: ContactSentViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(contactSentViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    getContactView(this, item, position)
                else {
                    isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                    setStatus(item, imgSenderStatus)
                    setStaredStatus(item.isMessageStarred(), starredSentImage)
                }
            }
        }
    }

    private fun handlePayloadsContactReceived(
        key: String,
        contactReceivedViewHolder: ContactReceivedViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        with(contactReceivedViewHolder) {
            if (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || key == Constants.NOTIFY_MESSAGE_UNHIGHLIGHT) {
                val isHighLighted =
                    (key == Constants.NOTIFY_MESSAGE_HIGHLIGHT || selectedMessages.contains(item.messageId))
                ChatUtils.setSelectedChatItem(
                    viewRowItem,
                    isHighLighted,
                    context
                )
            } else if (key == Constants.NOTIFY_MESSAGE_STATUS_CHANGED) {
                if (item.isMessageRecalled())
                    getContactView(this, item, position)
                else {
                    setStaredStatus(item.isMessageStarred(), starredSentImage)
                }
            }
        }
    }

    private fun getStatusIcon(
        item: ChatMessage,
        imgStatus: ImageView,
        imgStatusCaption: ImageView
    ): ImageView {
        return if (Utils.returnEmptyStringIfNull(item.getMediaChatMessage().getMediaCaptionText())
                .isNotEmpty()
        ) {
            imgStatus.gone()
            imgStatusCaption
        } else {
            imgStatusCaption.gone()
            imgStatus
        }

    }

    private fun getStarIcon(
        item: ChatMessage,
        imgStarred: ImageView,
        imgStarredCaption: ImageView
    ): ImageView {
        return if (Utils.returnEmptyStringIfNull(item.getMediaChatMessage().getMediaCaptionText())
                .isNotEmpty()
        ) {
            imgStarred.gone()
            imgStarredCaption
        } else {
            imgStarredCaption.gone()
            imgStarred
        }

    }

    /**
     * This method internally calls [.onBindViewHolder] to
     * update the [RecyclerView.ViewHolder] contents with the item at the given position and
     * also sets up some private fields to be used by RecyclerView.
     *
     * @see .onBindViewHolder
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            Log.d(
                "$TAG onBindViewHolder ",
                "${mainlist[position].messageId} ${mainlist[position].messageType}"
            )
            chatAdapterHelper.showHideDateHeader(holder as DateViewHolder)
            val item = mainlist[position]
            when (holder.getItemViewType()) {
                TYPE_TEXT_SENDER -> bindSenderTextView(holder, item, position)
                TYPE_TEXT_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, item, position)
                    bindReceiverTextView(holder, item, position)
                }
                TYPE_LOCATION_SENDER -> bindSenderLocationView(holder, item, position)
                TYPE_LOCATION_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, item, position)
                    bindReceiverLocationView(holder, item, position)
                }
                TYPE_FILE_SENDER -> getFileView(holder, item, position)
                TYPE_FILE_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, item, position)
                    getFileView(holder, item, position)
                }
                TYPE_CONTACT_SENDER -> getContactView(holder, item, position)
                TYPE_CONTACT_RECEIVER -> {
                    showSenderNameIfGroupChat(holder, item, position)
                    getContactView(holder, item, position)
                }
                TYPE_MSG_NOTIFICATION -> getNotificationView(holder, item)
                else -> bindMediaViews(holder, item, position)
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Return the view type of the item at `position` for the purposes of view
     * recycling.
     *
     *
     *
     * The default implementation of this method returns 0, making the assumption of
     * a single view type for the adapter. Unlike ListView adapters, types need not be contiguous.
     * Consider using id resources to uniquely identify item view types.
     *
     * @param position position to query
     * @return integer value identifying the type of the view needed to represent the item at
     * `position`. Type codes need not be contiguous.
     */
    override fun getItemViewType(position: Int): Int {
        return chatAdapterHelper.getItemViewType(mainlist[position])
    }

    /**
     * Return the stable ID for the item at `position`. If [.hasStableIds] would
     * return false this method should return -1. The default implementation of this method returns
     * -1.
     *
     * @param position Adapter position to query
     * @return the stable ID of the item at position
     */
    override fun getItemId(position: Int): Long {
        return mainlist[position].getMessageId().hashCode().toLong()
    }

    /**
     * Returns the total number of items in the data set held by the adapter. Added Null handling so
     * as to prevent null pointer exception
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount() = mainlist.size

    /**
     * Show/Hides sender name if the chat is group chat
     *
     * @param holder   view holder of the item
     * @param item     message item of the view
     * @param position position of the item
     */
    private fun showSenderNameIfGroupChat(
        holder: RecyclerView.ViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        if (ChatType.TYPE_GROUP_CHAT == chatType)
            showHideSenderName(holder, item, position)
    }

    /**
     * This method will bind the data to the sender text view.
     *
     * @param holder   Holder of the text view
     * @param item     Instance of the Message
     * @param position Position of the list item
     */
    private fun bindSenderTextView(
        holder: RecyclerView.ViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        /* View holder for the text view */
        val txtSenderViewHolder = holder as TextSentViewHolder
        with(txtSenderViewHolder) {
            val time: String?
            try {
                adjustPadding(space, position, mainlist)
                time = chatMsgTime.getDaySentMsg(context, item.getMessageSentTime())
                with(txtChatTime) {
                    text = time
                    setTextColor(ContextCompat.getColor(context, R.color.color_sent_message_time))
                    show()
                }
                txtChatSender.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
                txtChatSender.setTextColor(ContextCompat.getColor(context, R.color.color_black))
                txtSenderViewHolder.isSentMessage =
                    item.isMessageSentByMe && !item.isMessageSent()
                if (item.isMessageRecalled) {
                    txtSenderViewHolder.isRecallMessage = true
                    displayRecallInfoForSender(txtSenderViewHolder)
                    viewSender.isEnabled = true
                    senderItemClick(this, txtSenderViewHolder.viewSender, item)
                } else {
                    txtSenderViewHolder.isRecallMessage = false
                    viewSender.isEnabled = true
                    senderItemClick(this, viewSender, item)
                    imgChatStatus.show()
                    sentRecallImage.gone()
                    joinLinkView.gone()
                    setStatus(item, imgChatStatus)
                    replyViewUtils.showSenderReplyWindow(this, item, context)
                    setSenderText(item, txtChatSender,txtSenderViewHolder,position)
                }
                replyViewUtils.markFavoriteItem(this, item)
                ChatUtils.setSelectedChatItem(viewRowItem, item, selectedMessages, context)
                setListenersForSenderTextMessages(this, item)
            } catch (e: Exception) {
                LogMessage.e(e)
            }
        }
    }

    private fun setSenderText(item: ChatMessage,txtChatSender:TextView,holder: TextSentViewHolder,position: Int){
        val msg = item.messageTextContent
        with(txtChatSender) {
            setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
            if (item.mentionedUsersIds != null && item.mentionedUsersIds.size > 0) {
                val mentionText = MentionUtils.formatMentionText(context, item, false)
                val mentionUserNames = MentionUtils.getMentionedUserId(context, item, false)
                handleSenderTextSearchMention(mentionText, holder, mentionUserNames)
            } else {
                setTextKeepState(getSpannedText(msg))
                handleSenderTextSearch(getSpannedText(msg), holder)
            }
            if (msg.contains(BuildConfig.WEB_CHAT_LOGIN))
                setJoinLinkView(
                    item.chatUserJid,
                    txtChatSender,
                    holder.joinLinkView,
                    holder.joinLinkLogo
                )
            var movelink = ModifiedlinkMovementMethod(
                context,
                item.chatUserJid,
                selectedMessages,
                isLinkLongclick
            )
            movelink.setOnclicklistener(
                txtChatSender,
                longClickListener,
                item,
                position,
                linkClickListener,
                linkbuttonclickstatusListener
            )
            movementMethod = movelink
            isClickable = false
            isLongClickable = false
        }
    }

    private fun setJoinLinkView(
        userJid: String,
        txtChat: TextView,
        joinLinkView: LinearLayout,
        joinLinkLogo: ImageView
    ) {
        val screenWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
        txtChat.setTextColor(ContextCompat.getColor(context, R.color.light_blue))
        txtChat.setLinkTextColor(ContextCompat.getColor(context, R.color.light_blue))
        joinLinkView.show()
        joinLinkView.setOnClickListener {
            ChatUtils.navigateToOnGoingCallPreviewScreen(
                context,
                userJid,
                txtChat.text.toString().trim()
            )
            com.contusfly.utils.LogMessage.d(TAG, "Join Call via Link Clicked")
        }
        val lp = LinearLayout.LayoutParams(
            (screenWidth + 20),
            LinearLayout.LayoutParams.WRAP_CONTENT
        ) //20 is nothing but text message margin Start and End value in XML
        joinLinkView.layoutParams = lp
        joinLinkLogo.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_launcher)!!)
    }

    private fun handleSenderTextSearch(htmlText: CharSequence, holder: TextSentViewHolder) {
        if (searchEnabled && searchKey.isNotEmpty() && htmlText.toString()
                .startsWithTextInWords(searchKey)
        ) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setEmojiTextAndHighLightSearchText(
                context,
                holder.txtChatSender,
                htmlText.toString(),
                startIndex,
                stopIndex
            )
        } else {
            holder.txtChatSender.setBackgroundColor(context.color(android.R.color.transparent))
            holder.txtChatSender.setTextKeepState(htmlText)
        }
    }

    private fun handleSenderTextSearchMention(htmlText: CharSequence, holder: TextSentViewHolder, mentionedUserName:SpannableStringBuilder) {
        if (searchEnabled && searchKey.isNotEmpty()) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setEmojiTextAndHighLightSearchTextForMention(
                context,
                holder.txtChatSender,
                htmlText.toString(),
                startIndex,
                stopIndex,mentionedUserName)
        } else {
            holder.txtChatSender.setBackgroundColor(context.color(android.R.color.transparent))
            holder.txtChatSender.setTextKeepState(htmlText)
        }
    }

    private fun handleFileTextSearch(htmlText: CharSequence?, txtSendName: AppCompatTextView) {
        if (searchEnabled && searchKey.isNotEmpty() && htmlText.toString()
                .startsWithTextInWords(searchKey)
        ) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setMediaTextHighLightSearched(
                context,
                txtSendName,
                htmlText.toString(),
                startIndex,
                stopIndex
            )
        } else {
            txtSendName.setBackgroundColor(context.color(android.R.color.transparent))
            txtSendName.setTextKeepState(htmlText)
        }
    }

    private fun setSearchContactText(txtSendName: CustomTextView, fromHtml: Spanned) {
        if (searchEnabled && searchKey.isNotEmpty() && fromHtml.toString()
                .startsWithTextInWords(searchKey)
        ) {
            val startIndex = fromHtml.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setMediaTextHighLightSearched(
                context,
                txtSendName,
                fromHtml.toString(),
                startIndex,
                stopIndex
            )
        } else {
            txtSendName.setBackgroundColor(context.color(android.R.color.transparent))
            txtSendName.setTextKeepState(fromHtml)
        }
    }

    /**
     * This method will bind the data to receiver text view.
     *
     * @param holder   Holder of the text view
     * @param item     Instance of the ChatMessage
     * @param position Position of the list item
     */
    private fun bindReceiverTextView(
        holder: RecyclerView.ViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        /* View holder for the text view */
        val txtReceiverViewHolder = holder as TextReceivedViewHolder
        with(txtReceiverViewHolder) {
            viewReceiver.contentDescription = "Receiver_Text"
            val time: String?
            try {
                adjustPadding(txtReceiverViewHolder.space, position, mainlist)
                time = chatMsgTime.getDaySentMsg(context, item.getMessageSentTime())
                txtChatRevTime.text = time
                txtChatRevTime.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_chat_msg_received_time
                    )
                )
                txtChatReceiver.maxWidth = SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
                txtChatReceiver.setTextColor(ContextCompat.getColor(context, R.color.color_black))
                receiverTextTranslated?.maxWidth =
                    SharedPreferenceManager.getInt(Constants.DEVICE_WIDTH)
                if (isTranslationChecked && mainlist[position].messageCustomField != null && mainlist[position].messageCustomField[Constants.IS_MESSAGE_TRANSLATED] != null
                    && mainlist[position].messageCustomField[Constants.IS_MESSAGE_TRANSLATED].equals(
                        "true"
                    ) && ChatManager.getAvailableFeatures().isTranslationEnabled
                ) {
                    translatedlinearlayout?.show()
                    receiverTextTranslated?.show()
                    receiverTextTranslated?.text =
                        mainlist[position].messageCustomField[Constants.TRANSLATED_MESSAGE_CONTENT]
                } else {
                    receiverTextTranslated?.gone()
                    translatedlinearlayout?.gone()
                }
                receiverTextTranslation(mainlist, txtReceiverViewHolder)
                handleRecallForReceivedTextMessage(item, this)
                replyViewUtils.markFavoriteItem(this, item)
                ChatUtils.setSelectedChatItem(viewRowItem, item, selectedMessages, context)
                setListenersForReceiverTextMessages(txtReceiverViewHolder, item)
            } catch (e: Exception) {
                LogMessage.e(e)
            }
        }
    }

    private fun receiverTextTranslation(
        mainlist: ArrayList<ChatMessage>,
        txtReceiverViewHolder: TextReceivedViewHolder
    ) {
        with(txtReceiverViewHolder) {
            receiverTextView?.setOnClickListener {
                checkAndTranslateMessage(
                    this,
                    txtChatReceiver,
                    receiverTextTranslated,
                    translatedlinearlayout
                )
            }

            receiverTextView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(mainlist[layoutPosition], layoutPosition)
                true
            }
        }
    }

    private fun handleRecallForReceivedTextMessage(
        item: ChatMessage,
        textViewHolder: TextReceivedViewHolder
    ) {
        val msg = item.getMessageTextContent()
        with(textViewHolder) {
            if (item.isMessageRecalled()) {
                textViewHolder.isRecallMessage = true
                displayRecallInfoForReceiver(this)
                receiverItemClick(this, viewReceiver, item)
            } else {
                textViewHolder.isRecallMessage = false
                receiverItemClick(this, viewReceiver, item)
                receivedRecallImage.gone()
                receiverJoinLinkView.gone()
                replyViewUtils.showReceiverReplyWindow(this, item, context)
                with(txtChatReceiver) {
                    setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
                    if(item.mentionedUsersIds != null && item.mentionedUsersIds.size > 0) {
                        val mentionText = MentionUtils.formatMentionText(context, item,false)
                        val mentionUserNames=MentionUtils.getMentionedUserId(context,item,false)
                        handleReceiverTextSearchMention(mentionText,textViewHolder,mentionUserNames)
                    } else {
                        setTextKeepState(getSpannedText(msg))
                        handleReceiverTextSearch(getSpannedText(msg), textViewHolder)
                    }

                    if (msg.contains(BuildConfig.WEB_CHAT_LOGIN))
                        setJoinLinkView(
                            item.chatUserJid,
                            txtChatReceiver,
                            receiverJoinLinkView,
                            receiverJoinLinkLogo
                        )
                    var movelink = ModifiedlinkMovementMethod(
                        context,
                        item.chatUserJid,
                        selectedMessages,
                        isLinkLongclick
                    )
                    movelink.setOnclicklistener(
                        txtChatReceiver,
                        longClickListener,
                        item,
                        absoluteAdapterPosition,
                        linkClickListener,
                        linkbuttonclickstatusListener
                    )
                    movementMethod = movelink
                    isClickable = false
                    isLongClickable = false
                }
            }
        }
    }

    private fun handleReceiverTextSearchMention(htmlText: CharSequence, holder: TextReceivedViewHolder, mentionedUserName:SpannableStringBuilder) {
        if (searchEnabled && searchKey.isNotEmpty()) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setEmojiTextAndHighLightSearchTextForMention(
                context,
                holder.txtChatReceiver,
                htmlText.toString(),
                startIndex,
                stopIndex,mentionedUserName)
        } else {
            holder.txtChatReceiver.setBackgroundColor(context.color(android.R.color.transparent))
            holder.txtChatReceiver.setTextKeepState(htmlText)
        }
    }

    private fun handleReceiverTextSearch(htmlText: CharSequence, holder: TextReceivedViewHolder) {
        if (searchEnabled && searchKey.isNotEmpty() && htmlText.toString()
                .startsWithTextInWords(searchKey)
        ) {
            val startIndex = htmlText.toString().checkIndexes(searchKey)
            val stopIndex = startIndex + searchKey.length
            EmojiUtils.setEmojiTextAndHighLightSearchText(
                context,
                holder.txtChatReceiver,
                htmlText.toString(),
                startIndex,
                stopIndex
            )
        } else {
            holder.txtChatReceiver.setBackgroundColor(context.color(android.R.color.transparent))
            holder.txtChatReceiver.setTextKeepState(htmlText)
        }
    }


    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private fun getSpannedText(message: String?): String {
        return getHtmlChatMessageText(message!!)
    }

    /**
     * Displays the recall information when the message was deleted.
     *
     * @param txtReceiverViewHolder A ViewHolder which describes the text item view.
     */
    private fun displayRecallInfoForReceiver(txtReceiverViewHolder: TextReceivedViewHolder) {
        with(txtReceiverViewHolder) {
            replyMessageReceivedView?.gone()
            receivedRecallImage.show()
            receiverJoinLinkView.gone()
            txtChatReceiver.setTextColor(ContextCompat.getColor(context, R.color.color_dark_gray))
            txtChatReceiver.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC)
            txtChatReceiver.setTextKeepState(
                Html.fromHtml(
                    getHtmlChatMessageText(
                        context.getString(
                            R.string.single_chat_receiver_recall
                        )
                    )
                )
            )
        }
    }

    /**
     * Displays the recall information when the message was deleted.
     *
     * @param txtSenderViewHolder A ViewHolder which describes the text item view.
     */
    private fun displayRecallInfoForSender(txtSenderViewHolder: TextSentViewHolder) {
        with(txtSenderViewHolder) {
            imgChatStatus.gone()
            replyMessageSentView?.gone()
            sentRecallImage.show()
            joinLinkView.gone()
            txtChatSender.setTextColor(ContextCompat.getColor(context, R.color.color_black))
            txtChatSender.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC)
            txtChatSender.setTextKeepState(Html.fromHtml(getHtmlChatMessageText(context.getString(R.string.single_chat_sender_recall))))
        }
    }

    /**
     * This method will bind the data to the sender Image view.
     *
     * @param holder      Holder of the recycler view
     * @param messageItem ChatMessage item contains message data
     * @param position    List item position
     */
    private fun bindSenderImageView(
        holder: RecyclerView.ViewHolder,
        messageItem: ChatMessage,
        position: Int
    ) {
        try {
            val imgViewHolder = holder as ImageSentViewHolder
            with(imgViewHolder) {
                imageItemViewHelper.setImageWidthAndHeight(this, messageItem)
                imgViewHolder.isSentMessage =
                    messageItem.isMessageSentByMe() && !messageItem.isMessageSent()
                viewSender.contentDescription = "Sender_Image"
                adjustPadding(space, position, mainlist)
                val time = chatMsgTime.getDaySentMsg(context, messageItem.getMessageSentTime())
                val base64Img = Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaThumbImage()
                )
                val filePath = Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaLocalStoragePath()
                )
                imageItemViewHelper.senderImageItemView(
                    messageItem,
                    this,
                    filePath,
                    time,
                    base64Img,
                    searchEnabled,
                    searchKey
                )
                replyViewUtils.showSenderReplyWindow(this, messageItem, context)
                ChatUtils.setSelectedChatItem(viewRowItem, messageItem, selectedMessages, context)
                setListenersForSenderImageMessages(this, messageItem)
                senderItemClick(this, imageSenderImg, messageItem)
                senderDownloadClick(txtRetryView, cancelUpload, messageItem, viewSentCarbonDownload)
                imgSentForward?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        messageItem,
                        position
                    )
                }
            }

        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * This method will bind the data to the receiver text view.
     *
     * @param holder      Holder of the recycler view
     * @param messageItem ChatMessage item contains message data
     * @param position    List item position
     */
    private fun bindReceiverImageView(
        holder: RecyclerView.ViewHolder,
        messageItem: ChatMessage,
        position: Int
    ) {
        try {
            val imgViewHolder = holder as ImageReceivedViewHolder
            with(imgViewHolder) {
                imageItemViewHelper.setImageWidthAndHeight(this, messageItem)
                viewReceiver.contentDescription = "Receiver_Image"
                adjustPadding(space, position, mainlist)
                val time = chatMsgTime.getDaySentMsg(context, messageItem.getMessageSentTime())
                if (isTranslationChecked && mainlist[position].messageCustomField != null
                    && mainlist[position].messageCustomField[Constants.IS_MESSAGE_TRANSLATED] != null
                    && mainlist[position].messageCustomField[Constants.IS_MESSAGE_TRANSLATED].equals(
                        "true"
                    )
                ) {
                    txtTranslatedText.show()
                    txtTranslatedText.text =
                        mainlist[position].messageCustomField[Constants.TRANSLATED_MESSAGE_CONTENT]
                }
                val base64Img = Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaThumbImage()
                )
                val filePath = Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaLocalStoragePath()
                )
                imageItemViewHelper.receiverImageViewItem(
                    messageItem, this, filePath, time,
                    base64Img, searchEnabled, searchKey
                )
                replyViewUtils.showReceiverReplyWindow(this, messageItem, context)
                ChatUtils.setSelectedChatItem(viewRowItem, messageItem, selectedMessages, context)
                setListenersForReceiverImageMessages(this, messageItem)
                receivedImageForward?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        messageItem,
                        position
                    )
                }
                receiverItemClick(this, imgRevImage, messageItem)
                receiverDownloadClick(viewDownload, txtRetryView, cancelDownload, messageItem)
                receiverItemTranslate(mainlist, position, imgViewHolder)
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * This method will bind the data to the sender Image view.
     *
     * @param holder      Holder of the recycler view
     * @param messageItem ChatMessage item contains message data
     * @param position    List item position
     */
    private fun bindSenderVideoView(
        holder: RecyclerView.ViewHolder,
        messageItem: ChatMessage,
        position: Int
    ) {
        LogMessage.d(TAG, "Sender Video view")
        try {
            val videoSenderViewHolder = holder as VideoSentViewHolder
            with(videoSenderViewHolder) {
                videoItemViewHelper.setImageWidthAndHeight(this, messageItem)
                videoSenderViewHolder.isSentMessage =
                    messageItem.isMessageSentByMe() && !messageItem.isMessageSent()
                viewSender.contentDescription = "Sender_Video"
                adjustPadding(space, position, mainlist)
                val time = chatMsgTime.getDaySentMsg(context, messageItem.getMessageSentTime())
                val base64Img = Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaThumbImage()
                )
                val filePath = Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaLocalStoragePath()
                )
                videoItemViewHelper.senderVideoItemView(
                    messageItem, this, filePath, time,
                    base64Img, searchEnabled, searchKey
                )
                replyViewUtils.showSenderReplyWindow(this, messageItem, context)
                ChatUtils.setSelectedChatItem(viewRowItem, messageItem, selectedMessages, context)
                setListenersForSenderVideoMessages(this, messageItem)
                senderItemClick(this, imageSenderImg, messageItem)
                senderDownloadClick(txtRetryView, cancelUpload, messageItem, viewSentCarbonDownload)
                imgSentForward?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        messageItem,
                        position
                    )
                }

                handleVideoMediaStatusChanged(this, messageItem)
            }
        } catch (e: Exception) {
            LogMessage.e(com.mirrorflysdk.flycommons.Constants.TAG, e)
        }
    }

    /**
     * This method will bind the data to the receiver text view.
     *
     * @param holder      Holder of the recycler view
     * @param messageItem ChatMessage item contains message data
     * @param position    List item position
     */
    private fun bindReceiverVideoView(
        holder: RecyclerView.ViewHolder,
        messageItem: ChatMessage,
        position: Int
    ) {
        try {
            val videoReceiverViewHolder = holder as VideoReceivedViewHolder
            with(videoReceiverViewHolder) {
                videoItemViewHelper.setImageWidthAndHeight(this, messageItem)
                viewReceiver.contentDescription = "Receiver_Video"
                adjustPadding(space, position, mainlist)
                val time = chatMsgTime.getDaySentMsg(context, messageItem.getMessageSentTime())
                val base64Img = Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaThumbImage()
                )
                val filePath = Utils.returnEmptyStringIfNull(
                    messageItem.getMediaChatMessage().getMediaLocalStoragePath()
                )
                videoItemViewHelper.receiverVideoViewItem(
                    messageItem, this, filePath, time,
                    base64Img, searchEnabled, searchKey
                )
                replyViewUtils.showReceiverReplyWindow(this, messageItem, context)
                ChatUtils.setSelectedChatItem(viewRowItem, messageItem, selectedMessages, context)
                setListenersForReceiverVideoMessages(this, messageItem)
                receiverItemClick(this, imgRevImage, messageItem)
                receiverDownloadClick(viewDownload, txtRetryView, cancelDownload, messageItem)
                receivedImageForward?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        messageItem,
                        position
                    )
                }
                receiverItemTranslate(mainlist, position, videoReceiverViewHolder)
            }
        } catch (e: Exception) {
            LogMessage.e(com.mirrorflysdk.flycommons.Constants.TAG, e)
        }
    }


    private fun receiverItemTranslate(
        mainlist: ArrayList<ChatMessage>,
        position: Int,
        receiverViewHolder: BaseReceivedViewHolder
    ) {
        with(receiverViewHolder) {
            if (isTranslationChecked && mainlist[position].messageCustomField != null
                && mainlist[position].messageCustomField[Constants.IS_MESSAGE_TRANSLATED] != null
                && mainlist[position].messageCustomField[Constants.IS_MESSAGE_TRANSLATED].equals("true")
            ) {
                txtTranslatedText.show()
                translatedlinearlayout?.show()
                txtTranslatedText.text =
                    mainlist[position].messageCustomField[Constants.TRANSLATED_MESSAGE_CONTENT]
            } else {
                translatedlinearlayout?.gone()
            }
            layoutTranslatedText.setOnClickListener {
                checkAndTranslateMessage(
                    this,
                    txtRevChatCaption,
                    txtTranslatedText,
                    translatedlinearlayout
                )
            }

            txtRevChatCaption.setOnClickListener {
                checkAndTranslateMessage(
                    this,
                    txtRevChatCaption,
                    txtTranslatedText,
                    translatedlinearlayout
                )
            }

            txtRevChatCaption.setOnClickListener {
                checkAndTranslateMessage(
                    this,
                    txtRevChatCaption,
                    txtTranslatedText,
                    translatedlinearlayout
                )
            }

            layoutTranslatedText.setOnLongClickListener {
                listener?.onSenderItemLongClick(mainlist[layoutPosition], layoutPosition)
                true
            }
        }
    }

    private fun checkAndTranslateMessage(
        holder: RecyclerView.ViewHolder,
        txtRevChatCaption: TextView,
        txtTranslatedText: EmojiAppCompatTextView?,
        translatedLinearLayout: LinearLayout?
    ) {
        with(holder) {
            if (!mainlist[layoutPosition].isMessageRecalled)
                if (selectedMessages.isNotEmpty()) {
                    listener?.onSenderItemClicked(mainlist[layoutPosition], layoutPosition)
                } else if (!ChatManager.getAvailableFeatures().isTranslationEnabled) {
                    return
                } else if (isTranslationChecked && (mainlist[layoutPosition].messageCustomField == null
                            || mainlist[layoutPosition].messageCustomField[Constants.IS_MESSAGE_TRANSLATED] == null
                            || mainlist[layoutPosition].messageCustomField[Constants.IS_MESSAGE_TRANSLATED].equals(
                        "false"
                    )
                            || !mainlist[layoutPosition].messageCustomField[Constants.TRANSLATED_LANGUAGE].equals(
                        selectedLanguage
                    ))
                ) {

                    val pressTime = System.currentTimeMillis()
                    if (pressTime - lastPressTime <= doublePRESSINTERVAL) {
                        activity.checkInternetAndExecute(true) {
                            com.contusfly.utils.LogMessage.d(TAG, "#translate Initiated")
                            GoogleTranslation.getInstance().getTranslatedText(context,
                                txtRevChatCaption.text.toString(),
                                selectedLanguage,
                                googleTranslatedKey,
                                object : GoogleTranslation.GoogleTranslationListener {
                                    override fun onSuccess(s: String) {
                                        com.contusfly.utils.LogMessage.d(TAG, "#translate Success")
                                        FlyMessenger.setCustomValue(
                                            mainlist[layoutPosition].messageId,
                                            Constants.TRANSLATED_MESSAGE_CONTENT,
                                            s
                                        )
                                        FlyMessenger.setCustomValue(
                                            mainlist[layoutPosition].messageId,
                                            Constants.IS_MESSAGE_TRANSLATED,
                                            "true"
                                        )
                                        FlyMessenger.setCustomValue(
                                            mainlist[layoutPosition].messageId,
                                            Constants.TRANSLATED_LANGUAGE,
                                            selectedLanguage
                                        )
                                        txtTranslatedText?.show()
                                        translatedLinearLayout?.show()
                                        txtTranslatedText?.text = s
                                        val hashMap = hashMapOf<String, String>()
                                        hashMap[Constants.TRANSLATED_MESSAGE_CONTENT] = s
                                        hashMap[Constants.IS_MESSAGE_TRANSLATED] = "true"
                                        hashMap[Constants.TRANSLATED_LANGUAGE] = selectedLanguage
                                        mainlist[layoutPosition].messageCustomField = hashMap
                                    }

                                    override fun onFailed(s: String) {
                                        com.contusfly.utils.LogMessage.d(TAG, "#translate Failed")
                                        txtTranslatedText?.gone()
                                        translatedLinearLayout?.gone()
                                        Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
                                        FlyMessenger.setCustomValue(
                                            mainlist[layoutPosition].messageId,
                                            Constants.IS_MESSAGE_TRANSLATED,
                                            "false"
                                        )
                                    }
                                })
                        }
                    }
                    lastPressTime = pressTime
                }
        }
    }

    /**
     * Create the audio view based on the Message data
     *
     * @param holder   Holder of the recycler view
     * @param item     ChatMessage item contains message data
     * @param position List item position
     */
    private fun getAudioView(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        val time = chatMsgTime.getDaySentMsg(context, item.getMessageSentTime())
        if (item.isMessageSentByMe()) {
            val audioViewHolder = holder as AudioSentViewHolder
            with(audioViewHolder) {
                audioViewHolder.isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                viewRowItem.contentDescription = "Sender_Audio"
                adjustPadding(space, position, mainlist)
                audioItemView.disableSenderAudioViews(this)
                audioItemView.audioSenderItemView(this, time, item)
                audioPlayClick(
                    item,
                    this,
                    imgAudioPlay,
                    audioMirrorFlySeekBar,
                    txtAudioDuration,
                    true
                )
                mediaController.checkStateOfPlayer(
                    imgAudioPlay,
                    audioMirrorFlySeekBar,
                    txtAudioDuration,
                    layoutPosition
                )
                replyViewUtils.showSenderReplyWindow(this, item, context)
                /*new AudioReplyViewUtils().showSenderReplyWindow(audioViewHolder, item, context, messageDetail);*/
                setSelectedChatItem(viewRowItem, item)
                setListenersForAudioMessages(this, item)
                uploadClick(viewRetry, viewCarbonRetry, progressUploadDownloadLayout, item)
                audioMirrorFlySeekBar.isEnabled = selectedMessages.isEmpty()
                sentAudioForwardImage?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        item,
                        layoutPosition
                    )
                }
                if (item.mediaChatMessage.isAudioRecorded) {
                    audioViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_recorded_icon)
                } else {
                    audioViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_music_icon)
                }
            }
        } else {
            val audioReceiverViewHolder = holder as AudioReceivedViewHolder
            with(audioReceiverViewHolder) {
                viewRowItem.contentDescription = "Receiver_Audio"
                adjustPadding(space, position, mainlist)
                audioItemView.disableReceiverAudioViews(this)
                audioItemView.audioReceiverItemView(this, time, item)
                audioPlayClick(
                    item,
                    this,
                    imgAudioPlay,
                    audioMirrorFlySeekBar,
                    txtAudioDuration,
                    false
                )
                mediaController.checkStateOfPlayer(
                    imgAudioPlay,
                    audioMirrorFlySeekBar,
                    txtAudioDuration,
                    layoutPosition
                )
                audRevStarred.visibility = if (item.isMessageStarred()) View.VISIBLE else View.GONE
                replyViewUtils.showReceiverReplyWindow(this, item, context)
                /*new AudioReplyViewUtils().showReceiverReplyWindow(audioReceiverViewHolder, item, context);*/
                setSelectedChatItem(viewRowItem, item)
                setListenersForReceiverAudioMessages(this, item)
                downloadClick(viewRetry, progressUploadDownloadLayout, item)
                audioMirrorFlySeekBar.isEnabled = selectedMessages.isEmpty()
                sentAudioForwardImage?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        item,
                        layoutPosition
                    )
                }
                if (item.mediaChatMessage.isAudioRecorded) {
                    audioReceiverViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_recorded_icon)
                } else {
                    audioReceiverViewHolder.imgAudioType.setImageResource(R.drawable.ic_audio_music_icon)
                }
            }
        }
    }

    /**
     * Gets the location view to display the map
     *
     * @param holder        Holder of the recycler view
     * @param item          ChatMessage item contains message data
     * @param position      List item position
     */
    private fun bindSenderLocationView(
        holder: RecyclerView.ViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        try {
            val locationSenderViewHolder = holder as LocationSentViewHolder
            with(locationSenderViewHolder) {
                locationSenderViewHolder.isSentMessage =
                    item.isMessageSentByMe() && !item.isMessageSent()
                imageSendLocation.contentDescription = "Sender_Location"
                adjustPadding(space, position, mainlist)
                val time = chatMsgTime.getDaySentMsg(context, item.getMessageSentTime())
                val locationMessage = item.getLocationChatMessage()
                val url =
                    MapUtils.getMapImageUri(locationMessage.latitude, locationMessage.longitude)
                txtSendTime.text = time
                ImageUtils.loadMapWithGlide(
                    context,
                    url,
                    imageSendLocation,
                    R.drawable.ic_map_placeholder
                )
                LogMessage.v("loadMapWithGlide", url)
                setChatStatus(item, imgSenderStatus)
                replyViewUtils.showSenderReplyWindow(this, item, context)
                ChatUtils.setSelectedChatItem(viewRowItem, item, selectedMessages, context)
                setListenersForSenderLocationMessages(this, item)
                senderItemClick(this, imageSendLocation, item)
                if (item.isMessageAcknowledged() || item.isMessageDelivered() || item.isMessageSeen())
                    imgForwardLocation?.show()
                imgForwardLocation?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        item,
                        layoutPosition
                    )
                }
            }
        } catch (e: Exception) {
            LogMessage.e(com.mirrorflysdk.flycommons.Constants.TAG, e)
        }
    }

    /**
     * Gets the receiver location view to display the map
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private fun bindReceiverLocationView(
        holder: RecyclerView.ViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        try {
            val locationReceiverViewHolder = holder as LocationReceivedViewHolder
            with(locationReceiverViewHolder) {
                imageReceiveLocation.contentDescription = "Receiver_Location"
                adjustPadding(space, position, mainlist)
                val time = chatMsgTime.getDaySentMsg(context, item.getMessageSentTime())
                val locationMessage = item.getLocationChatMessage()
                val url = MapUtils.getMapImageUri(
                    locationMessage.getLatitude(),
                    locationMessage.getLongitude()
                )
                ImageUtils.loadMapWithGlide(
                    context,
                    url,
                    imageReceiveLocation,
                    R.drawable.ic_map_placeholder
                )
                txtRevTime.text = time
                replyViewUtils.showReceiverReplyWindow(this, item, context)
                ChatUtils.setSelectedChatItem(viewRowItem, item, selectedMessages, context)
                setListenersForReceiverLocationMessages(this, item)
                receiverItemClick(this, imageReceiveLocation, item)
                imgForwardLocation?.show()
                imgForwardLocation?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        item,
                        layoutPosition
                    )
                }
            }
        } catch (e: Exception) {
            LogMessage.e(com.mirrorflysdk.flycommons.Constants.TAG, e)
        }
    }


    /**
     * Sets the background color for the selected message from the multi select in chat window
     *
     * @param view             Recycler view row item
     * @param message          ChatMessage instance
     */
    private fun setSelectedChatItem(view: View, message: ChatMessage) {
        if (selectedMessages.contains(message.getMessageId()))
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.color_selected_item))
        else
            view.background = null
    }


    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param retry        The retry view placed in the ViewHolder.
     * @param cancelUpload The cancel upload view placed in the ViewHolder.
     * @param messageItem  The message object which possess the data rendered in the
     * ViewHolder.
     */
    private fun uploadClick(
        retry: View,
        carbonRetry: View?,
        cancelUpload: View,
        messageItem: ChatMessage
    ) {
        retry.setOnClickListener { listener?.onRetryClicked(messageItem) }
        carbonRetry?.setOnClickListener { listener?.onDownloadClicked(messageItem) }
        cancelUpload.setOnClickListener { listener?.onCancelUploadClicked(messageItem) }
    }

    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param download       The download view placed in the ViewHolder.
     * @param cancelDownload The cancel download view placed in the ViewHolder.
     * @param messageItem    The message object which possess the data rendered in the
     * ViewHolder.
     */
    private fun downloadClick(download: View, cancelDownload: View, messageItem: ChatMessage) {
        download.setOnClickListener { listener?.onDownloadClicked(messageItem) }
        cancelDownload.setOnClickListener { listener?.onCancelDownloadClicked(messageItem) }
    }

    /**
     * Handle the file view to display the file on sender view or receiver view with type of
     * file in the chat view.
     *
     * @param holder   Holder of the recycler view
     * @param item     ChatMessage item contains message data
     * @param position List item position
     */
    private fun getFileView(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        try {
            val time = chatMsgTime.getDaySentMsg(context, item.getMessageSentTime())
            if (item.isMessageSentByMe()) {
                val fileViewHolder = holder as FileSentViewHolder
                with(fileViewHolder) {
                    fileViewHolder.isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
                    fileSentViewLayout.contentDescription = "Sender_File"
                    adjustPadding(spaceView, position, mainlist)
                    setFileSenderView(this, item, time)
                    handleFileTextSearch(
                        item.mediaChatMessage.mediaFileName,
                        fileViewHolder.fileNameText
                    )
                    setSelectedChatItem(fileSentViewLayout, item)
                    setListenersForSentFileMessages(this, item)
                    senderItemClick(this, fileSentViewLayout, item)
                    uploadClick(
                        fileUploadViewLayout,
                        fileCarbonDownloadView,
                        fileUploadCancelLayout,
                        item
                    )
                    imgFileForward?.setOnClickListener {
                        listener?.onSenderMediaForward(
                            item,
                            layoutPosition
                        )
                    }
                }
            } else {
                val viewHolder = holder as FileReceivedViewHolder
                with(viewHolder) {
                    fileReceivedViewLayout.contentDescription = "Receiver_File"
                    adjustPadding(spaceView, position, mainlist)
                    fileItemView.fileReceiverItemView(this, time, item)
                    setFileMediaStatusReceiverView(this, item)
                    replyViewUtils.markFavoriteItem(this, item)
                    replyViewUtils.showReceiverReplyWindow(this, item, context)
                    handleFileTextSearch(
                        item.mediaChatMessage.mediaFileName,
                        viewHolder.fileNameText
                    )
                    ChatUtils.setSelectedChatItem(
                        fileReceivedViewLayout,
                        item,
                        selectedMessages,
                        context
                    )
                    setListenersForReceivedFileMessages(this, item)
                    receiverItemClick(this, fileReceivedViewLayout, item)
                    downloadClick(fileDownloadLayout, fileCancelLayout, item)
                    imgFileForward?.setOnClickListener {
                        listener?.onSenderMediaForward(
                            item,
                            layoutPosition
                        )
                    }
                }
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    private fun setFileMediaStatusReceiverView(
        viewHolder: FileReceivedViewHolder,
        item: ChatMessage
    ) {
        with(viewHolder) {
            val fileStatus = Utils.returnEmptyStringIfNull(
                item.getMediaChatMessage().getMediaDownloadStatus().toString()
            )
            if (fileStatus.isNotEmpty()) {
                val filePath = Utils.returnEmptyStringIfNull(
                    item.getMediaChatMessage().getMediaLocalStoragePath()
                )
                chatAdapterHelper.presentFileTypeView(
                    fileCancelLayout,
                    fileDownloadProgress,
                    fileDownloadProgressBuffer,
                    item.getMessageId(),
                    MessageUtils.getMediaStatus(fileStatus, filePath, false),
                    imgFileForward,
                    fileDownloadLayout
                )
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
    private fun setFileSenderView(
        fileViewHolder: FileSentViewHolder,
        item: ChatMessage,
        time: String?
    ) {
        with(fileViewHolder) {
            fileItemView.fileSenderItemView(this, time, item)
            setFileMediaStatusSenderView(this, item)
            replyViewUtils.showSenderReplyWindow(this, item, context)
        }
    }

    private fun setFileMediaStatusSenderView(
        fileViewHolder: FileSentViewHolder,
        item: ChatMessage
    ) {
        with(fileViewHolder) {
            val fileUploadStatus = Utils.returnEmptyStringIfNull(
                item.getMediaChatMessage().getMediaUploadStatus().toString()
            )
            val fileDownloadStatus = Utils.returnEmptyStringIfNull(
                item.getMediaChatMessage().getMediaDownloadStatus().toString()
            )
            val fileStatus = if (item.isItCarbonMessage()) fileDownloadStatus else fileUploadStatus
            fileStatus.isNotEmpty().let {
                fileCarbonDownloadView?.gone()
                fileUploadViewLayout.gone()
                chatAdapterHelper.presentFileTypeView(
                    fileUploadCancelLayout, fileUploadProgress, fileUploadProgressBuffer,
                    item.getMessageId(), fileStatus.toInt(), imgFileForward,
                    if (item.isItCarbonMessage()) fileCarbonDownloadView else fileUploadViewLayout
                )
            }
        }
    }


    /**
     * Create the contact view based on the Message data
     *
     * @param holder        Holder of the recycler view
     * @param item          ChatMessage item contains message data
     * @param position      List item position
     */
    private fun getContactView(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        val contactMessage = item.getContactChatMessage()
        val contactName = contactMessage.getContactName()
        val registeredJid = getJidFromSharedContact(contactMessage)
        val time = chatMsgTime.getDaySentMsg(context, item.getMessageSentTime())
        if (item.isMessageSentByMe()) {
            contactSentView(holder, item, position, contactName, registeredJid, time)
        } else {
            val contactReceiverViewHolder = holder as ContactReceivedViewHolder
            with(contactReceiverViewHolder) {
                viewRowItem.contentDescription = "Receiver_Contact"
                adjustPadding(space, position, mainlist)
                txtSendTime.text = time
                txtSendName.text = contactName
                checkUserFromReceiver(holder)
                starredSentImage.visibility =
                    if (item.isMessageStarred()) View.VISIBLE else View.GONE
                replyViewUtils.showReceiverReplyWindow(this, item, context)
                setSelectedChatItem(viewRowItem, item)
                setSearchContactText(txtSendName, SpannableStringBuilder(contactName))
                setListenersForReceivedContactMessages(this, item, registeredJid)
                receiverItemClick(this, viewRowItem, item)
                if (item.isMessageAcknowledged() || item.isMessageDelivered() || item.isMessageSeen())
                    imgForwardContact?.show()
                imgForwardContact?.setOnClickListener {
                    listener?.onSenderMediaForward(
                        item,
                        layoutPosition
                    )
                }
            }
        }
    }

    private fun contactSentView(
        holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int, contactName: String,
        registeredJid: String?, time: String?
    ) {
        val contactHolder = holder as ContactSentViewHolder
        with(contactHolder) {
            contactHolder.isSentMessage = item.isMessageSentByMe() && !item.isMessageSent()
            viewRowItem.contentDescription = "Sender_Contact"
            adjustPadding(space, position, mainlist)
            txtSendName.text = contactName
            txtSendTime.text = time
            checkUserFromSender(holder)
            setStatus(item, imgSenderStatus)
            if (registeredJid == item.chatUserJid) {
                contactActionText.gone()
            }
            starredSentImage.visibility = if (item.isMessageStarred()) View.VISIBLE else View.GONE
            replyViewUtils.showSenderReplyWindow(this, item, context)
            setSearchContactText(txtSendName, SpannableStringBuilder(contactName))
            setSelectedChatItem(viewRowItem, item)
            setListenersForContactMessages(this, item, registeredJid)
            senderItemClick(this, viewRowItem, item)
            if (item.isMessageAcknowledged() || item.isMessageDelivered() || item.isMessageSeen())
                imgForwardContact?.show()
            imgForwardContact?.setOnClickListener {
                listener?.onSenderMediaForward(
                    item,
                    layoutPosition
                )
            }
        }
    }

    /**
     * Checking user to send contact from receiver side
     *
     * @param holder Holder of the recycler view
     */
    private fun checkUserFromReceiver(holder: RecyclerView.ViewHolder) {
        val contactReceiverViewHolder = holder as ContactReceivedViewHolder
        with(contactReceiverViewHolder) {
            contactActionText.gone()
        }
    }

    /**
     * Checking user to send contact from sender side
     *
     * @param holder        Holder of the recycler view
     */
    private fun checkUserFromSender(holder: RecyclerView.ViewHolder) {
        val contactHolder = holder as ContactSentViewHolder
        with(contactHolder) {
            contactActionText.gone()
            contactSeparator?.hide()
        }
    }

    /**
     * Determines the jid of the shared contact if the number is registered with the application.
     *
     * @param contactMessage The contact message shared in the chat conversation window.
     * @return The jabber id of the shared phone number if it's registered with the application.
     */
    private fun getJidFromSharedContact(contactMessage: ContactChatMessage): String? {
        var registeredJid: String? = null
        for (i in contactMessage.getIsChatAppUser().indices)
            if (contactMessage.getIsChatAppUser()[i].isTrue()) {
                registeredJid = Utils.getJidFromPhoneNumber(
                    context,
                    contactMessage.getContactPhoneNumbers()[i],
                    SharedPreferenceManager.getString(Constants.COUNTRY_CODE)
                )
                break
            }
        return registeredJid
    }


    /**
     * @param holder   view holder instance
     * @param item     message instance
     * @param position row position
     */
    private fun bindMediaViews(holder: RecyclerView.ViewHolder, item: ChatMessage, position: Int) {
        when (holder.itemViewType) {
            TYPE_IMAGE_SENDER -> bindSenderImageView(holder, item, position)
            TYPE_IMAGE_RECEIVER -> {
                showSenderNameIfGroupChat(holder, item, position)
                bindReceiverImageView(holder, item, position)
            }
            TYPE_VIDEO_SENDER -> bindSenderVideoView(holder, item, position)
            TYPE_VIDEO_RECEIVER -> {
                showSenderNameIfGroupChat(holder, item, position)
                bindReceiverVideoView(holder, item, position)
            }
            TYPE_AUDIO_SENDER -> getAudioView(holder, item, position)
            TYPE_AUDIO_RECEIVER -> {
                showSenderNameIfGroupChat(holder, item, position)
                getAudioView(holder, item, position)
            }
        }
    }

    /**
     * Show/Hides sender name in group chat based on the chat sender.
     *
     * @param holder   view holder of the item
     * @param item     message item of the view
     * @param position position of the item
     */
    private fun showHideSenderName(
        holder: RecyclerView.ViewHolder,
        item: ChatMessage,
        position: Int
    ) {
        val senderNameHolder = holder as SenderNameHolder
        if (!item.isMessageSentByMe)
            chatAdapterHelper.showHideSenderName(senderNameHolder, mainlist, position)
    }

    /**
     * Adjust the view space by show/hiding space view
     *
     * @param space    Space to adjust by show/hiding
     * @param position Current position
     */
    private fun adjustPadding(space: View, position: Int, messageList: List<ChatMessage>?) {
        chatAdapterHelper.showHideSpace(space, position, messageList!!)
    }

    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in
     * FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private fun getHtmlChatMessageText(message: String): String {
        val text = context.getString(R.string.chat_text)
        return message + text + text
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param txtSenderViewHolder The view holding the child items.
     * @param item                The data set used to render the content of child views.
     */
    private fun setListenersForSenderTextMessages(
        txtSenderViewHolder: TextSentViewHolder,
        item: ChatMessage
    ) {
        with(txtSenderViewHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param txtReceiverViewHolder The view holding the child items.
     * @param item                  The data set used to render the content of child views.
     */
    private fun setListenersForReceiverTextMessages(
        txtReceiverViewHolder: TextReceivedViewHolder,
        item: ChatMessage
    ) {
        with(txtReceiverViewHolder) {
            replyMessageReceivedView?.setOnClickListener {
                onReplyViewClicked(
                    item,
                    layoutPosition
                )
            }
            replyMessageReceivedView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param imgViewHolder The view holding the child items.
     * @param item          The data set used to render the content of child views.
     */
    private fun setListenersForSenderImageMessages(
        imgViewHolder: ImageSentViewHolder,
        item: ChatMessage
    ) {
        with(imgViewHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param imgViewHolder The view holding the child items.
     * @param item          The data set used to render the content of child views.
     */
    private fun setListenersForReceiverImageMessages(
        imgViewHolder: ImageReceivedViewHolder,
        item: ChatMessage
    ) {
        with(imgViewHolder) {
            replyMessageReceivedView?.setOnClickListener {
                onReplyViewClicked(
                    item,
                    layoutPosition
                )
            }
            replyMessageReceivedView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param videoSenderViewHolder The view holding the child items.
     * @param item                  The data set used to render the content of child views.
     */
    private fun setListenersForSenderVideoMessages(
        videoSenderViewHolder: VideoSentViewHolder,
        item: ChatMessage
    ) {
        with(videoSenderViewHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param videoReceiverViewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     */
    private fun setListenersForReceiverVideoMessages(
        videoReceiverViewHolder: VideoReceivedViewHolder,
        item: ChatMessage
    ) {
        with(videoReceiverViewHolder) {
            replyMessageReceivedView?.setOnClickListener {
                onReplyViewClicked(
                    item,
                    layoutPosition
                )
            }
            replyMessageReceivedView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }


    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param holder    View holder of current view in adapter
     * @param senderItem  The view which renders the contents of the item.
     * @param messageItem The message object which possess the data rendered in the ViewHolder.
     */
    private fun senderItemClick(
        holder: RecyclerView.ViewHolder,
        senderItem: View,
        messageItem: ChatMessage
    ) {
        with(holder) {
            senderItem.setOnClickListener {
                if (!messageItem.isMessageRecalled) listener?.onSenderItemClicked(
                    messageItem,
                    layoutPosition
                )
            }
            senderItem.setOnLongClickListener {
                listener?.onSenderItemLongClick(messageItem, layoutPosition)
                true
            }
        }
    }

    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param holder    View holder of current view in adapter
     * @param receiverItem The view which renders the contents of the item.
     * @param messageItem  The message object which possess the data rendered in the ViewHolder.
     */
    private fun receiverItemClick(
        holder: RecyclerView.ViewHolder,
        receiverItem: View,
        messageItem: ChatMessage
    ) {
        with(holder) {
            receiverItem.setOnClickListener {
                if (!messageItem.isMessageRecalled) listener?.onReceiverItemClicked(
                    messageItem,
                    layoutPosition
                )
            }
            receiverItem.setOnLongClickListener {
                listener?.onReceiverItemLongClick(messageItem, layoutPosition)
                true
            }
        }
    }

    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable,
     * it becomes clickable.
     *
     * @param retry              The retry view placed in the ViewHolder.
     * @param cancelUpload       The cancel upload view placed in the ViewHolder.
     * @param messageItem        The message object which possess the data rendered in the
     * ViewHolder.
     * @param carbonDownloadView The carbon download view placed in the ViewHolder.
     */
    private fun senderDownloadClick(
        retry: View,
        cancelUpload: View,
        messageItem: ChatMessage,
        carbonDownloadView: View
    ) {
        carbonDownloadView.setOnClickListener { listener?.onDownloadClicked(messageItem) }
        cancelUpload.setOnClickListener { listener?.onCancelUploadClicked(messageItem) }
        retry.setOnClickListener { listener?.onRetryClicked(messageItem) }
    }

    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param download       The download view placed in the ViewHolder.
     * @param retry          The retry view placed in the ViewHolder.
     * @param cancelDownload The cancel download view placed in the ViewHolder.
     * @param messageItem    The message object which possess the data rendered in the ViewHolder.
     */
    private fun receiverDownloadClick(
        download: View,
        retry: View,
        cancelDownload: View,
        messageItem: ChatMessage
    ) {
        download.setOnClickListener { listener?.onDownloadClicked(messageItem) }
        cancelDownload.setOnClickListener { listener?.onCancelDownloadClicked(messageItem) }
        retry.setOnClickListener { listener?.onDownloadClicked(messageItem) }
    }


    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param locationHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     */
    private fun setListenersForSenderLocationMessages(
        locationHolder: LocationSentViewHolder,
        item: ChatMessage
    ) {
        with(locationHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param locationHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     */
    private fun setListenersForReceiverLocationMessages(
        locationHolder: LocationReceivedViewHolder,
        item: ChatMessage
    ) {
        with(locationHolder) {
            replyMessageReceivedView?.setOnClickListener {
                onReplyViewClicked(
                    item,
                    layoutPosition
                )
            }
            replyMessageReceivedView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * Handle the audio play click
     *
     * @param item            Message Item data
     * @param holder          View holder of current view in adapter
     * @param playImage       Play button of the audio view
     * @param mirrorFlySeekBar         Seek bar of the audio
     * @param durationView    Duration text view
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    private fun audioPlayClick(
        item: ChatMessage,
        holder: RecyclerView.ViewHolder,
        playImage: ImageView,
        mirrorFlySeekBar: MirrorFlySeekBar,
        durationView: TextView,
        doesSentMessage: Boolean
    ) {
        with(holder) {
            val media = item.getMediaChatMessage()
            playImage.setOnClickListener {
                if (ChatUtils.checkWritePermission(
                        context,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                ) {
                    with(mediaController) {
                        if (currentAudioPosition != -1 && layoutPosition != currentAudioPosition)
                            resetAudioPlayer(false)
                        setMediaResource(
                            media.getMediaLocalStoragePath(),
                            media.getMediaDuration(),
                            playImage,
                            doesSentMessage
                        )
                        setMediaSeekBar(mirrorFlySeekBar)
                        setMediaTimer(durationView)
                        currentAudioPosition = layoutPosition
                        handlePlayer(doesSentMessage)
                        listener?.onAudioPlayed()
                    }
                } else {
                    listener?.mediaPermissionCheck()
                }
            }

            setAudioSeekBarListener(item, this, playImage, mirrorFlySeekBar, durationView)
        }
    }

    /**
     * Handle the audio seekbar click
     *
     * @param item            Message Item data
     * @param holder          View holder of current view in adapter
     * @param playImage       Play button of the audio view
     * @param mirrorFlySeekBar         Seek bar of the audio
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    private fun setAudioSeekBarListener(
        item: ChatMessage,
        holder: RecyclerView.ViewHolder,
        playImage: ImageView,
        mirrorFlySeekBar: MirrorFlySeekBar,
        durationView: TextView
    ) {
        with(holder) {
            val media = item.getMediaChatMessage()
            mirrorFlySeekBar.setOnSeekBarChangeListener((object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (selectedMessages.isEmpty()) {

                        mediaController.updateSeekbarChanges(
                            progress, layoutPosition,
                            media.getMediaLocalStoragePath(), fromUser, durationView,
                            mirrorFlySeekBar, playImage
                        )

                    } else {
                        mirrorFlySeekBar.progress = 0
                        listener?.onSenderItemLongClick(item, layoutPosition)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    /*No Implementation Needed*/
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    mediaController.onStopTrackingTouch(seekBar, media.getMediaLocalStoragePath())
                }
            }))

            mirrorFlySeekBar.setLongClickListener(object : MirrorFlySeekBar.LongClickListener {
                override fun onLongClick() {
                    listener?.onSenderItemLongClick(item, layoutPosition)
                }
            })
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param audioViewHolder The view holding the child items.
     * @param item            The data set used to render the content of child views.
     */
    private fun setListenersForAudioMessages(
        audioViewHolder: AudioSentViewHolder,
        item: ChatMessage
    ) {
        with(audioViewHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
        with(audioViewHolder.audioMirrorFlySeekBar) {
            this.setOnTouchListener { v, _ ->
                v!!.parent.requestDisallowInterceptTouchEvent(true)
                false
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param audioReceiverViewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     */
    private fun setListenersForReceiverAudioMessages(
        audioReceiverViewHolder: AudioReceivedViewHolder,
        item: ChatMessage
    ) {
        with(audioReceiverViewHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
        with(audioReceiverViewHolder.audioMirrorFlySeekBar) {
            this.setOnTouchListener { v, _ ->
                v!!.parent.requestDisallowInterceptTouchEvent(true)
                false
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param fileViewHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     */
    private fun setListenersForSentFileMessages(
        fileViewHolder: FileSentViewHolder,
        item: ChatMessage
    ) {
        with(fileViewHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param fileViewHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     */
    private fun setListenersForReceivedFileMessages(
        fileViewHolder: FileReceivedViewHolder,
        item: ChatMessage
    ) {
        with(fileViewHolder) {
            replyMessageReceivedView?.setOnClickListener {
                onReplyViewClicked(
                    item,
                    layoutPosition
                )
            }
            replyMessageReceivedView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
        }
    }

    /**
     * when user click reply view this method get called
     *
     * @param item     Message object
     * @param position of the item clicked
     */
    private fun onReplyViewClicked(item: ChatMessage, position: Int) {
        // During Multi-select, when user click reply msg view (in both sender & receiver side),
        // should not navigate to corresponding msg, instead it should behave like item click.
        listener?.let {
            listener!!.onReplyMessageClick(item.getMessageId())
            LogMessage.e("TAG", position.toString())
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param contactHolder  The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param registeredJid  The jid of the shared contact to open the particular chat window
     */
    private fun setListenersForContactMessages(
        contactHolder: ContactSentViewHolder, item: ChatMessage,
        registeredJid: String?
    ) {
        with(contactHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
            contactActionText.setOnClickListener {
                if (!item.isMessageRecalled())
                    listener?.onContactClick(item, layoutPosition, registeredJid)
            }
        }
    }

    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param contactHolder The view holding the child items.
     * @param item          The data set used to render the content of child views.
     * @param registeredJid  Register jid of the received contact
     * if the message button is clicked.
     */
    private fun setListenersForReceivedContactMessages(
        contactHolder: ContactReceivedViewHolder,
        item: ChatMessage,
        registeredJid: String?
    ) {
        with(contactHolder) {
            replyMessageSentView?.setOnClickListener { onReplyViewClicked(item, layoutPosition) }
            replyMessageSentView?.setOnLongClickListener {
                listener?.onSenderItemLongClick(item, layoutPosition)
                true
            }
            contactActionText.setOnClickListener {
                listener!!.onContactClick(
                    item,
                    layoutPosition,
                    registeredJid
                )
            }
        }
    }

    /**
     * Gets the group notification view
     *
     * @param holder        View holder of the item
     * @param message       Instance of Message
     */
    private fun getNotificationView(holder: RecyclerView.ViewHolder, message: ChatMessage?) {
        val notificationViewHolder = holder as NotificationViewHolder
        notificationViewHolder.notificationView.text = message?.getMessageTextContent()
    }

    /**
     * Hides the media upload/download option.
     *
     * @param txtRetry Text view to display the retry
     * @param download The download view of the media
     */
    private fun hideMediaOption(txtRetry: TextView?, download: View?) {
        txtRetry?.gone()
        download?.gone()
    }

    /**
     * Gets the chat messages.
     *
     * @return List<ChatMessage> List of messages
    </ChatMessage> */
    val messages: List<ChatMessage> get() = mainlist

    /**
     * Stop the player of the Media player.
     */
    fun stopMediaPlayer() {
        mediaController.mediaPlayer?.let {
            if (it.isPlaying)
                mediaController.stopPlayer()
        }
    }

    /**
     * Stop the player of the Media player.
     */
    fun pauseMediaPlayer() {
        mediaController.mediaPlayer?.let {
            if (it.isPlaying)
                mediaController.pausePlayer()
        }
    }

    fun refreshMessageAtPosition(position: Int, message: ChatMessage) {
        if (message.isMessageDeleted() && mainlist.size > position) {
            mainlist.removeAt(position)
            notifyItemRemoved(position)
        } else {
            notifyItemChanged(validateMessagePosition(position, message, true))
        }
    }

    private fun validateMessagePosition(
        position: Int,
        message: ChatMessage,
        findAgain: Boolean
    ): Int {
        if (mainlist.size > position && mainlist[position].getMessageId() == message.getMessageId()) {
            mainlist[position] = message
            return position
        } else if (findAgain) {
            val messagePosition = getMessagePosition(message.messageId)
            if (messagePosition != -1)
                validateMessagePosition(messagePosition, message, false)
        }
        return -1
    }

    fun refreshMessage(position: Int, message: ChatMessage) {
        validateMessagePosition(position, message, true)
    }

    fun validateAndRefreshMessagePosition(
        position: Int,
        messageId: String,
        findAgain: Boolean
    ): Int {
        if (mainlist.size > position && mainlist[position].getMessageId() == messageId) {
            val message = FlyMessenger.getMessageOfId(messageId)
            message?.let {
                mainlist[position] = it
            }
            return position
        } else if (findAgain) {
            val messagePosition = getMessagePosition(messageId)
            if (messagePosition != -1)
                validateAndRefreshMessagePosition(messagePosition, messageId, false)
        }
        return -1
    }

    override fun setChatStatus(item: ChatMessage?, viewHolder: ImageView?) {
        ChatMessageUtils.setChatStatus(viewHolder!!, item!!.getMessageStatus())
    }

    override fun setRecentChatStatus(viewHolder: ImageView?, status: MessageStatus?) {
        ChatMessageUtils.setChatStatus(viewHolder, status)
    }

    override fun setStaredStatus(isStarred: Boolean, imageView: ImageView) {
        if (isStarred) imageView.show() else imageView.gone()
    }

    override fun setStarredCaptionStatus(isStarred: Boolean, imageView: ImageView) {
        if (isStarred) imageView.show() else imageView.gone()
    }

    /**
     * Sets the media status related to the media messages.
     *
     * @param mediaStatus        Media status of the message
     */
    override fun setMediaStatus(mediaStatus: MediaStatus) {
        if (mediaStatus.item!!.messageType == MessageType.VIDEO)
            mediaStatus.imgPlay?.gone()
        when (mediaStatus.status) {
            MediaDownloadStatus.MEDIA_DOWNLOADED, MediaUploadStatus.MEDIA_UPLOADED -> {
                chatAdapterHelper.mediaUploadView(
                    mediaStatus.progressBar,
                    mediaStatus.cancelImageview,
                    mediaStatus.viewProgress
                )
                if (mediaStatus.item!!.messageType == MessageType.VIDEO)
                    mediaStatus.imgPlay?.show()
                hideMediaOption(mediaStatus.txtRetry, mediaStatus.download)
                mediaStatus.forwardImageview?.show()
            }
            MediaDownloadStatus.MEDIA_DOWNLOADING, MediaUploadStatus.MEDIA_UPLOADING -> {
                mediaStatus.progressBar?.show()
                mediaStatus.cancelImageview?.show()
                mediaStatus.viewProgress?.show()
                mediaStatus.forwardImageview?.hide()
                hideMediaOption(mediaStatus.txtRetry, mediaStatus.download)
            }
            MediaDownloadStatus.MEDIA_NOT_DOWNLOADED -> {
                chatAdapterHelper.mediaUploadView(
                    mediaStatus.progressBar,
                    mediaStatus.cancelImageview,
                    mediaStatus.viewProgress
                )
                mediaStatus.download?.show()
                mediaStatus.txtRetry?.hide()
                mediaStatus.forwardImageview?.hide()

            }
            MediaUploadStatus.MEDIA_NOT_UPLOADED -> {
                mediaStatus.txtRetry?.show()
                mediaStatus.download?.hide()
                mediaStatus.forwardImageview?.hide()
                chatAdapterHelper.mediaUploadView(
                    mediaStatus.progressBar,
                    mediaStatus.cancelImageview,
                    mediaStatus.viewProgress
                )
            }
            MediaDownloadStatus.MEDIA_DOWNLOADED_NOT_AVAILABLE -> {
                chatAdapterHelper.mediaUploadView(
                    mediaStatus.progressBar,
                    mediaStatus.cancelImageview,
                    mediaStatus.viewProgress
                )
                mediaStatus.forwardImageview?.hide()
                mediaStatus.download?.show()
                mediaStatus.txtRetry?.hide()
            }
            MediaUploadStatus.MEDIA_UPLOADED_NOT_AVAILABLE -> {
                chatAdapterHelper.mediaUploadView(
                    mediaStatus.progressBar,
                    mediaStatus.cancelImageview,
                    mediaStatus.viewProgress
                )
                mediaStatus.forwardImageview?.hide()
            }
        }
    }

    /**
     * Set the media duration for downloaded/uploaded video/audio file
     *
     * @param txtSendDuration Duration of an audio/video file
     * @param fileStatus      Status of file
     * @param messageItem     Details of the message
     * @param imgChatType     Chat type image for video
     */
    override fun setMediaDuration(
        txtSendDuration: TextView?, fileStatus: Int,
        messageItem: ChatMessage?, imgChatType: ImageView?
    ) {
        MediaDetailUtils.setMediaView(
            context,
            txtSendDuration,
            fileStatus,
            messageItem,
            imgChatType
        )
    }

    /**
     * setImageViewSize Set the image view size KB or MB in size
     *
     * @param fileSize     File size
     * @param downloadView View of download item
     * @param fileSizeView Text view to show file size
     */
    override fun setImageViewSize(fileSize: String?, downloadView: View?, fileSizeView: TextView?) {
        if (!fileSize.isNullOrEmpty() && downloadView?.visibility == View.VISIBLE) {
            var size = 0
            val txtSize = context.getString(R.string.title_kb)
            if (!fileSize.equals(Constants.COUNT_ZERO.toString(), ignoreCase = true))
                size = fileSize.toInt() / Constants.ONE_KB
            if (size >= Constants.ONE_KB) {
                fileSizeView?.text = ChatUtils.getFileSizeText(fileSize)
            } else {
                fileSizeView?.text = "$size $txtSize"
            }
        }
    }

    /**
     * Sets the status of the particular message item.
     *
     * @param item          Message item contains message data
     * @param imgChatStatus Image view status
     */
    override fun setStatus(item: ChatMessage?, imgChatStatus: ImageView?) {
        imgChatStatus?.show()
        ChatMessageUtils.setChatStatus(imgChatStatus!!, item!!.getMessageStatus())
    }

    private fun getMessagePosition(messageId: String) =
        mainlist.reversed().indexOfFirst { it.messageId == messageId }

    companion object {
        /**
         * Type of Text chat sender
         */
        const val TYPE_TEXT_SENDER = 1

        /**
         * Type of Text chat Receiver
         */
        const val TYPE_TEXT_RECEIVER = 10

        /**
         * The type image and video sender.
         */
        const val TYPE_IMAGE_SENDER = 2

        /**
         * The type image and video receiver.
         */
        const val TYPE_IMAGE_RECEIVER = 20

        /**
         * The type image and video sender.
         */
        const val TYPE_VIDEO_SENDER = 3

        /**
         * The type image and video receiver.
         */
        const val TYPE_VIDEO_RECEIVER = 30

        /**
         * Type of location chat sender
         */
        const val TYPE_LOCATION_SENDER = 4

        /**
         * Type of location chat receiver
         */
        const val TYPE_LOCATION_RECEIVER = 40

        /**
         * Type of audio chat sender
         */
        const val TYPE_AUDIO_SENDER = 5

        /**
         * Type of audio chat receiver
         */
        const val TYPE_AUDIO_RECEIVER = 50

        /**
         * Type of contact chat sender
         */
        const val TYPE_CONTACT_SENDER = 6

        /**
         * Type of contact chat receiver
         */
        const val TYPE_CONTACT_RECEIVER = 60

        /**
         * Type of file chat sender
         */
        const val TYPE_FILE_SENDER = 7

        /**
         * Type of file chat receiver
         */
        const val TYPE_FILE_RECEIVER = 70

        /**
         * Type of the message date
         */
        const val TYPE_MSG_NOTIFICATION = 8

    }

    fun getMediaController(): MediaController {
        return mediaController
    }


    private val longClickListener: ModifiedlinkMovementMethod.OnLinkLongClickListener =
        object : ModifiedlinkMovementMethod.OnLinkLongClickListener {

            override fun onLongClick(
                textView: TextView?,
                url: String?,
                view: ChatMessage,
                position: Int,
                onclickLinkStatus: Boolean
            ): Boolean {
                isLinkLongclick = onclickLinkStatus
                listener?.onSenderItemLongClick(view, position)
                return true
            }
        }

    private val linkClickListener: ModifiedlinkMovementMethod.OnLinkClickListener =
        object : ModifiedlinkMovementMethod.OnLinkClickListener {

            override fun onClick(
                textView: TextView?,
                url: String?,
                view: ChatMessage,
                position: Int
            ): Boolean {
                listener?.onSenderItemClicked(view, position)
                return true
            }
        }

    private val linkbuttonclickstatusListener: ModifiedlinkMovementMethod.OnLinkClickStatusListener =
        object : ModifiedlinkMovementMethod.OnLinkClickStatusListener {
            override fun onLinkClickStatus(onclickLinkStatus: Boolean): Boolean {
                isLinkLongclick = onclickLinkStatus
                return true
            }
        }

    /**
     * Instantiates a new adapter chat data.
     */
    init {
        /*The inflater which used to inflate the chat view*/
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        chatAdapterHelper = ChatAdapterHelper(inflater)
        chatMsgTime = ChatMsgTime(Calendar.getInstance())
        imageItemViewHelper = ImageItemViewHelper(context, this)
        videoItemViewHelper = VideoItemViewHelper(context, this)
        audioItemView = AudioItemView(this)
        fileItemView = FileItemView(this)
        replyViewUtils = ReplyViewUtils()
        selectedLanguage =
            SharedPreferenceManager.getString(Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE)
        isTranslationChecked =
            SharedPreferenceManager.getBoolean(Constants.GOOGLE_TRANSLATION_CHECKED)
        googleTranslatedKey = BuildConfig.GOOGLE_TRANSLATE_KEY
        doublePRESSINTERVAL = 500 // in millis
    }

}