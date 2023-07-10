package com.contusfly.models

import com.contusfly.emptyString
import com.mirrorflysdk.api.models.ChatMessage

class ChatItemRowModel(var messageItem: ChatMessage, var filePath: String?, var time: String?,
                       var base64Img: String?, var searchEnabled: Boolean = false, var searchKey: String = emptyString())