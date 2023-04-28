package com.contusfly.models

import com.contusfly.utils.Constants
import java.io.File

data class MessageObject(var toJid: String,
                         var messageType: String,
                         var textMessage: String,
                         var replyMessageId: String,
                         var latitude: Double,
                         var longitude: Double,
                         var contactName: String,
                         var contactNumbers: List<String>,
                         var file: File?,
                         var fileName: String,
                         var caption: String,
                         var base64Thumbnail: String,
                         var audioDuration: Long,
                         var isAudioRecorded: Boolean) {
    /**
     * Text Message Constructor
     */
    constructor(toJid: String,
                messageType: String,
                textMessage: String,
                replyMessageId: String) :
            this(toJid, messageType, textMessage, replyMessageId, 0.0, 0.0,
                    Constants.EMPTY_STRING, listOf(), null, Constants.EMPTY_STRING, Constants.EMPTY_STRING,
                    Constants.EMPTY_STRING, 0,false)

    /**
     * Location Message Constructor
     */
    constructor(toJid: String,
                messageType: String,
                latitude: Double,
                longitude: Double,
                replyMessageId: String) :
            this(toJid, messageType, Constants.EMPTY_STRING, replyMessageId, latitude, longitude,
                    Constants.EMPTY_STRING, listOf(), null, Constants.EMPTY_STRING, Constants.EMPTY_STRING,
                    Constants.EMPTY_STRING, 0, false)

    /**
     * Contact Message Constructor
     */
    constructor(toJid: String,
                messageType: String,
                contactName: String,
                contactNumbers: List<String>,
                replyMessageId: String) :
            this(toJid, messageType, Constants.EMPTY_STRING, replyMessageId, 0.0, 0.0,
                    contactName, contactNumbers, null, Constants.EMPTY_STRING, Constants.EMPTY_STRING,
                    Constants.EMPTY_STRING, 0,false)

    /**
     * Document Message Constructor
     */
    constructor(toJid: String,
                messageType: String,
                file: File?,
                fileName: String,
                replyMessageId: String) :
            this(toJid, messageType, Constants.EMPTY_STRING, replyMessageId, 0.0, 0.0,
                    Constants.EMPTY_STRING, listOf(), file, fileName, Constants.EMPTY_STRING,
                    Constants.EMPTY_STRING, 0,false)

    /**
     * Image Message Constructor
     */
    constructor(toJid: String,
                messageType: String,
                imageCaption: String,
                base64Thumbnail: String,
                file: File?,
                replyMessageId: String) :
            this(toJid, messageType, Constants.EMPTY_STRING, replyMessageId, 0.0, 0.0,
                    Constants.EMPTY_STRING, listOf(), file, Constants.EMPTY_STRING, imageCaption, base64Thumbnail, 0,false)

    /**
     * Audio Message Constructor
     */
    constructor(toJid: String,
                messageType: String,
                file: File?,
                audioDuration: Long,
                isAudioRecorded: Boolean,
                replyMessageId: String) :
            this(toJid, messageType, Constants.EMPTY_STRING, replyMessageId, 0.0, 0.0,
                    Constants.EMPTY_STRING, listOf(), file, Constants.EMPTY_STRING, Constants.EMPTY_STRING,
                    Constants.EMPTY_STRING, audioDuration,isAudioRecorded)

    /**
     * Video Message Constructor
     */
    constructor(toJid: String,
                messageType: String,
                videoCaption: String,
                file: File?,
                replyMessageId: String) :
            this(toJid, messageType, Constants.EMPTY_STRING, replyMessageId, 0.0, 0.0,
                    Constants.EMPTY_STRING, listOf(), file, Constants.EMPTY_STRING, videoCaption,
                    Constants.EMPTY_STRING, 0,false)
}