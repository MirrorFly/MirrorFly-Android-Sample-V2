package com.contusfly.call.calllog

import androidx.recyclerview.widget.DiffUtil
import com.mirrorflysdk.flycall.call.database.model.CallLog

class CallLogDiffCallback(private val oldList: List<CallLog>, private val newList: List<CallLog>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].roomId == newList[newItemPosition].roomId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return isCallLogObjEqual(oldItem, newItem)
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    private fun isCallLogObjEqual(oldItem: CallLog, newItem: CallLog): Boolean {
        return oldItem.rowId == newItem.rowId && oldItem.roomId == newItem.roomId && oldItem.callType == newItem.callType
                && oldItem.callerDevice == newItem.callerDevice && oldItem.fromUser == newItem.fromUser
                && oldItem.toUser == newItem.toUser
                && oldItem.startTime == newItem.startTime && oldItem.endTime == newItem.endTime
                && oldItem.callState == newItem.callState && oldItem.callTime == newItem.callTime
                && oldItem.isSync == newItem.isSync
    }
}