package com.contusfly.interfaces

import com.mirrorflysdk.api.models.MessageStatusDetail

fun interface GetMessageStatusCallback {
    fun onGetMessageStatusLoaded(deliveredStatus: List<MessageStatusDetail>, readByStatus: List<MessageStatusDetail>)
}