package com.contusfly.models

import com.mirrorflysdk.flycommons.ChatType
import javax.inject.Singleton

@Singleton
class Chat(var chatType: String = ChatType.TYPE_CHAT, var toUser: String)