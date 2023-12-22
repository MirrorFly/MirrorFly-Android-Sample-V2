/*
 * @category ContusFly
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.chat


import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import android.net.Uri
import com.contusfly.interfaces.MessageListener
import com.contusfly.models.ContactShareModel
import com.contusfly.models.MeetMessageParams
import com.contusfly.models.MessageObject
import com.contusfly.utils.*
import com.mirrorflysdk.api.*
import com.mirrorflysdk.api.chat.ContactMessageParams
import com.mirrorflysdk.api.chat.FileMessage
import com.mirrorflysdk.api.chat.FileMessageParams
import com.mirrorflysdk.api.chat.LocationMessageParams
import com.mirrorflysdk.api.chat.MeetMessage
import com.mirrorflysdk.api.chat.TextMessage
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycommons.models.MessageType
import kotlinx.coroutines.*
import java.io.File
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.math.abs

/**
 * This class is used for performing all the chat related functionality like send message , send seen status
 * and set last availability time.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@SuppressLint("DefaultLocale")
class MessagingClient @Inject
constructor(val application: Application) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    val TAG = MessagingClient::class.simpleName

    /**
     * Creates a new text message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param textMessage text content which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    fun composeTextMessage(
        toJid: String,
        textMessage: String,
        replyMessageId: String = Constants.EMPTY_STRING,
        mentionedUsersIds: List<String> = listOf()
    ): MessageObject {
        return MessageObject(
            toJid,
            Constants.MSG_TYPE_TEXT,
            textMessage,
            replyMessageId,
            mentionedUsersIds
        )
    }

    fun sendMessage(messageObject: MessageObject, messageListener: MessageListener?) {
        when (messageObject.messageType) {
            Constants.MSG_TYPE_TEXT -> sendTextMessage(messageObject, messageListener)
            Constants.MSG_TYPE_LOCATION -> sendLocationMessage(messageObject, messageListener)
            Constants.MSG_TYPE_CONTACT -> sendContactMessage(messageObject, messageListener)
            Constants.MSG_TYPE_FILE -> sendDocumentMessage(messageObject, messageListener)
            Constants.MSG_TYPE_IMAGE -> sendImageMessage(messageObject, messageListener)
            Constants.MSG_TYPE_AUDIO -> sendAudioMessage(messageObject, messageListener)
            Constants.MSG_TYPE_VIDEO -> sendVideoMessage(messageObject, messageListener)
            Constants.MSG_TYPE_MEET -> sendMeetMessage(messageObject, messageListener)
        }
    }

    private fun sendTextMessage(messageObject: MessageObject, messageListener: MessageListener?) {
        try {
            val sendMessageParams = TextMessage().apply {
                toId = messageObject.toJid
                messageText = messageObject.textMessage
                replyMessageId = messageObject.replyMessageId
                mentionedUsersIds = messageObject.mentionedUsersIds
            }
            FlyMessenger.sendTextMessage(sendMessageParams, object : SendMessageCallback {
                override fun onResponse(
                    isSuccess: Boolean,
                    error: Throwable?,
                    chatMessage: ChatMessage?
                ) {
                    if (isSuccess && chatMessage != null && messageListener != null)
                        messageListener.onSendMessageSuccess(chatMessage)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sendLocationMessage(
        messageObject: MessageObject,
        messageListener: MessageListener?
    ) {
        try {
            val sendMessageParams = FileMessage().apply {
                toId = messageObject.toJid
                replyMessageId = messageObject.replyMessageId
                messageType = MessageType.LOCATION
                locationMessage = LocationMessageParams().apply {
                    latitude = messageObject.latitude
                    longitude = messageObject.longitude
                }
            }

            FlyMessenger.sendFileMessage(sendMessageParams, object : SendMessageCallback {
                override fun onResponse(
                    isSuccess: Boolean,
                    error: Throwable?,
                    chatMessage: ChatMessage?
                ) {
                    if (isSuccess && chatMessage != null && messageListener != null)
                        messageListener.onSendMessageSuccess(chatMessage)
                }
            })
        } catch (e: NoSuchMethodError) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sendContactMessage(
        messageObject: MessageObject,
        messageListener: MessageListener?
    ) {
        try {
            val sendMessageParams = FileMessage().apply {
                toId = messageObject.toJid
                messageType = MessageType.CONTACT
                replyMessageId = messageObject.replyMessageId
                contactMessage = ContactMessageParams().apply {
                    name = messageObject.contactName
                    numbers = messageObject.contactNumbers
                }
            }

            FlyMessenger.sendFileMessage(sendMessageParams, object : SendMessageCallback {
                override fun onResponse(
                    isSuccess: Boolean,
                    error: Throwable?,
                    chatMessage: ChatMessage?
                ) {
                    if (isSuccess && chatMessage != null && messageListener != null)
                        messageListener.onSendMessageSuccess(chatMessage)
                }
            })
        } catch (e: NoSuchMethodError) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sendDocumentMessage(
        messageObject: MessageObject,
        messageListener: MessageListener?
    ) {
        try {
            messageObject.file?.let {
                val sendMessageParams = FileMessage().apply {
                    toId = messageObject.toJid
                    messageType = MessageType.DOCUMENT
                    replyMessageId = messageObject.replyMessageId
                    fileMessage = FileMessageParams().apply {
                        file = it
                    }
                }
                FlyMessenger.sendFileMessage(sendMessageParams, object : SendMessageCallback {
                    override fun onResponse(
                        isSuccess: Boolean,
                        error: Throwable?,
                        chatMessage: ChatMessage?
                    ) {
                        if (isSuccess && chatMessage != null && messageListener != null)
                            messageListener.onSendMessageSuccess(chatMessage)
                    }
                })
            }
        } catch (e: NoSuchMethodError) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sendImageMessage(messageObject: MessageObject, messageListener: MessageListener?) {
        try {
            messageObject.file?.let {
                val sendMessageParams = FileMessage().apply {
                    toId = messageObject.toJid
                    messageType = MessageType.IMAGE
                    replyMessageId = messageObject.replyMessageId
                    mentionedUsersIds = messageObject.mentionedUsersIds
                    fileMessage = FileMessageParams().apply {
                        file = it
                        caption = messageObject.caption
                    }
                }

                FlyMessenger.sendFileMessage(sendMessageParams, object : SendMessageCallback {
                    override fun onResponse(
                        isSuccess: Boolean,
                        error: Throwable?,
                        chatMessage: ChatMessage?
                    ) {
                        if (isSuccess && chatMessage != null && messageListener != null)
                            messageListener.onSendMessageSuccess(chatMessage)
                    }
                })
            }
        } catch (e: NoSuchMethodError) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sendAudioMessage(messageObject: MessageObject, messageListener: MessageListener?) {
        try {
            messageObject.file?.let {
                val sendMessageParams = FileMessage().apply {
                    toId = messageObject.toJid
                    messageType =
                        if (messageObject.isAudioRecorded) MessageType.AUDIO_RECORDED else MessageType.AUDIO
                    replyMessageId = messageObject.replyMessageId
                    fileMessage = FileMessageParams().apply {
                        file = it
                    }
                }
                FlyMessenger.sendFileMessage(sendMessageParams, object : SendMessageCallback {
                    override fun onResponse(
                        isSuccess: Boolean,
                        error: Throwable?,
                        chatMessage: ChatMessage?
                    ) {
                        if (isSuccess && chatMessage != null && messageListener != null)
                            messageListener.onSendMessageSuccess(chatMessage)
                    }
                })
            }
        } catch (e: NoSuchMethodError) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sendVideoMessage(messageObject: MessageObject, messageListener: MessageListener?) {
        try {
            messageObject.file?.let {
                val sendMessageParams = FileMessage().apply {
                    toId = messageObject.toJid
                    messageType = MessageType.VIDEO
                    replyMessageId = messageObject.replyMessageId
                    mentionedUsersIds = messageObject.mentionedUsersIds
                    fileMessage = FileMessageParams().apply {
                        file = it
                        caption = messageObject.caption
                    }
                }
                FlyMessenger.sendFileMessage(sendMessageParams, object : SendMessageCallback {
                    override fun onResponse(
                        isSuccess: Boolean,
                        error: Throwable?,
                        chatMessage: ChatMessage?
                    ) {
                        if (isSuccess && chatMessage != null && messageListener != null)
                            messageListener.onSendMessageSuccess(chatMessage)
                    }

                })
            }
        } catch (e: NoSuchMethodError) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sendMeetMessage(messageObject: MessageObject, messageListener: MessageListener?) {
        try {
            val sendMeetMessageParams = MeetMessage().apply {
                toId = messageObject.toJid
                replyMessageId = messageObject.replyMessageId
                mentionedUsersIds = messageObject.mentionedUsersIds
                title = messageObject.meetMessageParams?.title
                link = messageObject.meetMessageParams?.link
                scheduledDateTime = messageObject.meetMessageParams?.scheduleMeetDateTime
            }
            FlyMessenger.sendMeetMessage(sendMeetMessageParams, object : SendMessageCallback {
                override fun onResponse(
                    isSuccess: Boolean,
                    error: Throwable?,
                    chatMessage: ChatMessage?
                ) {
                    if (isSuccess && chatMessage != null && messageListener != null)
                        messageListener.onSendMessageSuccess(chatMessage)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Creates a new contact message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param data contact data which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    fun composeContactMessage(
        toJid: String,
        data: Intent,
        replyMessageId: String = Constants.EMPTY_STRING
    ): MessageObject {

        val contactName = data.getStringExtra(Constants.USERNAME)
        val contactNumbers: List<String> = data.getStringArrayListExtra(INTENT_PHONE_NUMBERS)!!

        return MessageObject(
            toJid, Constants.MSG_TYPE_CONTACT, contactName
                ?: Constants.EMPTY_STRING, contactNumbers, replyMessageId
        )
    }

    /**
     * Creates a new contact message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param contactName name of the contact
     * @param contactNumbers selected numbers for the contact
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    fun composeContactMessage(
        toJid: String,
        contactName: String,
        contactNumbers: List<String>,
        replyMessageId: String = Constants.EMPTY_STRING
    ): MessageObject {
        return MessageObject(
            toJid,
            Constants.MSG_TYPE_CONTACT,
            contactName,
            contactNumbers,
            replyMessageId
        )
    }

    /**
     * Creates a new contact message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param contactShareModel contact data which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    fun composeContactMessage(
        toJid: String,
        contactShareModel: ContactShareModel,
        replyMessageId: String = Constants.EMPTY_STRING
    ): MessageObject {

        val contactName = contactShareModel.name
        val contactNumbers = arrayListOf<String>()
        for (contact in contactShareModel.contactArrayList) {
            contactNumbers.add(contact.contactNos)
        }

        return MessageObject(
            toJid, Constants.MSG_TYPE_CONTACT, contactName
                ?: Constants.EMPTY_STRING, contactNumbers, replyMessageId
        )
    }

    /**
     * Creates a new location message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param data location data which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object in a [Pair]. [Pair.first] indicates the success status
     */
    fun composeLocationMessage(
        toJid: String,
        data: Intent,
        replyMessageId: String = Constants.EMPTY_STRING
    )
            : Pair<Boolean, MessageObject?> {
        return try { // Check if the latitude and longitude are valid data
            if (abs(data.getDoubleExtra(Constants.LATITUDE, 0.0)) > 0.0000001
                && abs(data.getDoubleExtra(Constants.LONGITUDE, 0.0)) > 0.0000001
            ) {

                val message = MessageObject(
                    toJid,
                    Constants.MSG_TYPE_LOCATION,
                    data.getDoubleExtra(Constants.LATITUDE, 0.0),
                    data.getDoubleExtra(Constants.LONGITUDE, 0.0),
                    replyMessageId
                )

                Pair(true, message)
            } else {
                Pair(false, null)
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
            Pair(false, null)
        }
    }

    /**
     * Creates a new Image message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param imageFilePath image file path which needs to be sent
     * @param imageCaption image caption which needs to be attached with image
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    fun composeImageMessage(
        toJid: String, imageFilePath: String, imageCaption: String = Constants.EMPTY_STRING,
        replyMessageId: String = Constants.EMPTY_STRING, mentionedUsersIds: List<String>
    ): MessageObject {
        return MessageObject(
            toJid,
            Constants.MSG_TYPE_IMAGE,
            imageCaption,
            ImageUtils.getImageThumbImage(imageFilePath),
            File(imageFilePath),
            replyMessageId,
            mentionedUsersIds
        )
    }

    /**
     * Creates a new Document message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param mediaFilePath file path of document which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object in a [Triple.third]
     * [Triple.first] indicates isValidDocumentsType
     * [Triple.second] indicates isValidDocumentsSize
     */
    fun composeDocumentsMessage(
        toJid: String,
        mediaFilePath: String,
        replyMessageId: String = Constants.EMPTY_STRING
    )
            : Triple<Boolean, Boolean, MessageObject?> {

        var isValidDocumentsType = true
        var isValidDocumentsSize = true

        if (!PickFileUtils.isValidFileType(mediaFilePath)) {
            isValidDocumentsType = false
            return Triple(isValidDocumentsType, isValidDocumentsSize, null)
        }

        if (!PickFileUtils.checkFileSize(mediaFilePath, Constants.MAX_DOCUMENT_UPLOAD_SIZE)) {
            isValidDocumentsSize = false
            return Triple(isValidDocumentsType, isValidDocumentsSize, null)
        }

        val mediaFileName = Uri.parse(mediaFilePath).lastPathSegment

        val message = MessageObject(
            toJid, Constants.MSG_TYPE_FILE, File(mediaFilePath), mediaFileName
                ?: Constants.EMPTY_STRING, replyMessageId
        )

        return Triple(isValidDocumentsType, isValidDocumentsSize, message)
    }

    /**
     * Creates a new Audio message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param mediaFilePath file path of audio file which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object in a [Triple.third].
     * [Triple.first] indicates isValidAudioType
     * [Triple.second] indicates isAudioSizeUnderLimit
     */
    fun composeAudioMessage(
        toJid: String,
        isAudioRecorded: Boolean,
        mediaFilePath: String,
        replyMessageId: String = Constants.EMPTY_STRING
    )
            : Triple<Boolean, Boolean, MessageObject?> {
        val fileExtension = mediaFilePath.substring(mediaFilePath.lastIndexOf('.')).toLowerCase()

        var isValidAudioType = true
        var isAudioSizeUnderLimit = true

        if (!(fileExtension == ".mp3" || fileExtension == ".wav" || fileExtension == ".aac" || fileExtension == ".mp4")) {
            isValidAudioType = false
            return Triple(isValidAudioType, isAudioSizeUnderLimit, null)
        }

        if (!PickFileUtils.checkFileSize(mediaFilePath, Constants.MAX_AUDIO_SIZE_LIMIT)) {
            isAudioSizeUnderLimit = false
            return Triple(isValidAudioType, isAudioSizeUnderLimit, null)
        }

        val messageObject = MessageObject(
            toJid, Constants.MSG_TYPE_AUDIO, File(mediaFilePath),
            MediaDetailUtils.getMediaDuration(mediaFilePath), isAudioRecorded, replyMessageId
        )

        return Triple(isValidAudioType, isAudioSizeUnderLimit, messageObject)
    }

    /**
     * Creates a new Video message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param videoFilePath file path of video which needs to be sent
     * @param videoCaption caption for the video
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object in a [Pair.second]. [Pair.first] indicates whether video size
     * exceeds the limit or not.
     */
    fun composeVideoMessage(
        toJid: String, videoFilePath: String, videoCaption: String = Constants.EMPTY_STRING,
        replyMessageId: String = Constants.EMPTY_STRING, mentionedUsersIds: List<String>
    ): Pair<Boolean, MessageObject?> {

        val isVideoDurationUnderLimit = true

        val messageObject = MessageObject(
            toJid,
            Constants.MSG_TYPE_VIDEO,
            videoCaption,
            File(videoFilePath),
            replyMessageId,
            mentionedUsersIds
        )

        return Pair(isVideoDurationUnderLimit, messageObject)
    }


    fun composeMeetMessage(
        toJid: String,
        replyMessageId: String = Constants.EMPTY_STRING,
        mentionedUsersIds: List<String>,
        meetMessageParams: MeetMessageParams
    ): MessageObject {
        return MessageObject(
            toJid,
            Constants.MSG_TYPE_MEET,
            replyMessageId,
            mentionedUsersIds,
            meetMessageParams
        )
    }


    companion object {
        const val INTENT_PHONE_NUMBERS = "INTENT_PHONE_NUMBERS"
    }
}