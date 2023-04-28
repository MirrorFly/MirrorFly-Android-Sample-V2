package com.contusfly.models

import com.mirrorflysdk.api.models.ChatMessage

sealed class GroupedMedia{
    abstract val id : Long
    data class MessageItem(val chatMessage: ChatMessage, var linkMap:Map<String, String> = mapOf()) : GroupedMedia(){
        override val id: Long
            get() = Long.MIN_VALUE
    }
    data class Header(val titleName: String) : GroupedMedia(){
        override val id: Long
            get() = Long.MIN_VALUE +1
    }
}