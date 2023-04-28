package com.contusfly.diffCallBacks

import androidx.recyclerview.widget.DiffUtil
import com.contusfly.models.DeviceContactModel

class DeviceContactDiffCallback(private val oldList: List<DeviceContactModel>, private val newList: List<DeviceContactModel>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return try {
            oldList.size > oldItemPosition && newList.size > newItemPosition && oldList[oldItemPosition].contactId == newList[newItemPosition].contactId
        } catch (e :Exception) {
            true
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return try {
            if (oldList.size <= oldItemPosition || newList.size <= newItemPosition)
                return false
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            return isContactObjEqual(oldItem, newItem)
        } catch (e :Exception) {
            true
        }
    }

    private fun isContactObjEqual(oldItem: DeviceContactModel, newItem: DeviceContactModel): Boolean {
        return oldItem.contactId == newItem.contactId && oldItem.mobileNumbers == newItem.mobileNumbers
                && oldItem.name == newItem.name
    }
}