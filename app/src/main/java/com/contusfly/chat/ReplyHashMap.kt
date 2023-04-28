package com.contusfly.chat

import com.contusfly.utils.Constants

object ReplyHashMap {

    private val hashMap: HashMap<String, String> = HashMap()

    fun saveReplyId(user: String, replyId: String) {
        hashMap[user] = replyId
    }

    fun getReplyId(user: String): String {
        return hashMap[user] ?: Constants.EMPTY_STRING
    }

}