/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.activities

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.mirrorflysdk.flycommons.MediaDownloadStatus
import com.mirrorflysdk.flycommons.MediaUploadStatus
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.R
import com.contusfly.adapters.MediaSliderAdapter
import com.contusfly.utils.Constants
import com.contusfly.utils.UserInterfaceUtils.Companion.setUpToolBar
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.ChatManager.getMediaMessages
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage
import java.util.*
import kotlin.collections.ArrayList

/**
 * Which used to display the media files between users or group in slider
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class MediaSlideActivity : BaseActivity() {

    private var messageData=ArrayList<ChatMessage>()
    private lateinit var msgType: MessageType
    private var mediaMessages: MutableList<ChatMessage> = ArrayList()
    private var pos = 0
    private lateinit var mediaSliderAdapter: MediaSliderAdapter
    private var viewPager: ViewPager? = null
    private var rosterId: String? = null
    private var messageId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_slide)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setUpToolBar(this, toolbar, supportActionBar, Constants.EMPTY_STRING)
        hideSoftKeyboard(this)
        viewPager = findViewById(R.id.media_scroll)
        rosterId = intent.getStringExtra(Constants.USER_JID)
        messageId = intent.getStringExtra(Constants.MESSAGE_ID)
        var feature=ChatManager.getAvailableFeatures()
        if(feature.isViewAllMediaEnabled){
            var list=rosterId?.let { getMediaMessages(it).reversed() }
            messageData=ArrayList()
            list?.let { messageData.addAll(it) }
        } else {
            var chatmessage=messageId?.let { FlyMessenger.getMessageOfId(it) }
            messageData=ArrayList()
            chatmessage?.let { messageData.add(it) }
        }

        /**
         * Assign the position of selected media
         */
        for (message in messageData) {
            msgType = message.getMessageType()
            /**
             * Validate the message type and show only media content in slide
             */
            if ((msgType == MessageType.VIDEO || msgType == MessageType.AUDIO || msgType == MessageType.IMAGE) && isMediaLoaded(
                    message
                )
            ) {
                mediaMessages.add(message)
                if (message.getMessageId() == messageId) pos = mediaMessages.size - 1
            }
            if (message.isMessageRecalled()) mediaMessages.remove(message)
        }
        setToolbar(mediaMessages[pos].isMessageSentByMe(), toolbar)
        /**
         * Adapter for the media list
         */
        mediaSliderAdapter = MediaSliderAdapter(supportFragmentManager, mediaMessages)
        /**
         * Set the adapter in the view pager for the swiping view
         */
        viewPager?.adapter = mediaSliderAdapter
        /**
         * Set the starting media
         */
        viewPager?.currentItem = pos
        viewPager?.addOnPageChangeListener(object : OnPageChangeListener {
            /**
             * Handle media message pageScrollStateChange
             *
             * @param state Position of the item in view
             */
            override fun onPageScrollStateChanged(state: Int) {
                //Do nothing
            }

            /**
             * Handle media message pageSelected
             *
             * @param position Position of the item in view
             * @param positionOffset Position of the item Offset
             * @param positionOffsetPixels Position of the item setPixels
             */
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //Do nothing
            }

            /**
             * Handle media message pageSelected
             *
             * @param position Position of the item in view
             */
            override fun onPageSelected(position: Int) {
                setToolbar(mediaMessages[position].isMessageSentByMe(), toolbar)
            }
        })
    }

    override fun onMessageStatusUpdated(msgId: String) {
        super.onMessageStatusUpdated(msgId)
        for (message in messageData) {
            msgType = message.getMessageType()
            if (msgType == MessageType.VIDEO ||
                msgType == MessageType.IMAGE && message.messageId == msgId
            ) {
                val replyMsg = FlyMessenger.getMessageOfId(msgId)?.isMessageRecalled
                if (replyMsg == true) {
                    mediaMessages.remove(message)
                    if (mediaMessages.size > 0) {
                        viewPager?.adapter?.notifyDataSetChanged()
                    } else {
                        finish()
                    }
                }
            }

        }
    }

    /**
     * Handle Toolbar Title
     *
     * @param isSender LayoutView
     * @param toolbar  Toolbar
     */
    private fun setToolbar(isSender: Boolean, toolbar: Toolbar) {
        if (isSender) toolbar.setTitle(R.string.title_sent_media) else toolbar.setTitle(R.string.title_received_media)
    }

    /**
     * Checks whether media content downloaded/uploaded
     *
     * @param message Message item
     * @return boolean Returns true if media content downloaded/uploaded
     */
    private fun isMediaLoaded(message: ChatMessage): Boolean {
        var isLoaded = false
        if (message.getMediaChatMessage()
                .getMediaDownloadStatus() == MediaDownloadStatus.MEDIA_DOWNLOADED
            || message.getMediaChatMessage()
                .getMediaUploadStatus() == MediaUploadStatus.MEDIA_UPLOADED
        ) {
            isLoaded = true
        }
        return isLoaded
    }
}