package com.contusfly.utils

import com.mirrorflysdk.flycommons.FlyCallback
import com.contusfly.interfaces.GetMessageStatusCallback
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.models.MessageStatusDetail

object GroupUtils {

    @JvmStatic
    fun getMessageStatus(messageId: String, getMessageStatusCallback: GetMessageStatusCallback) {
        var deliveredStatus: List<MessageStatusDetail>? = null
        var readStatus: List<MessageStatusDetail>? = null
        GroupManager.getGroupMessageDeliveredToList(messageId, FlyCallback { isSuccess, _, data ->
            if (isSuccess) {
                deliveredStatus = (data[Constants.SDK_DATA] as? ArrayList<*>)?.filterIsInstance<MessageStatusDetail>().orEmpty()
                if (readStatus != null)
                    getMessageStatusCallback.onGetMessageStatusLoaded(deliveredStatus!!, readStatus!!)
            } else
                deliveredStatus = listOf()
        })

        GroupManager.getGroupMessageReadByList(messageId, FlyCallback { isSuccess, _, data ->
            if (isSuccess) {
                readStatus = (data[Constants.SDK_DATA] as? ArrayList<*>)?.filterIsInstance<MessageStatusDetail>().orEmpty()
                if (deliveredStatus != null)
                    getMessageStatusCallback.onGetMessageStatusLoaded(deliveredStatus!!, readStatus!!)
            } else
                readStatus = listOf()
        })
    }
}