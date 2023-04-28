package com.contusfly.mediapicker.utils

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.contusfly.mediapicker.model.FolderDetail

class FolderListDiffCallback(
    private val oldList: List<FolderDetail>,
    private val newList: List<FolderDetail>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem.firstImagePath == newItem.firstImagePath &&
                oldItem.folderName == newItem.folderName &&
                oldItem.mediaFolderType == newItem.mediaFolderType
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        if (oldList.size > oldItemPosition && newList.size > newItemPosition) {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            val bundle = Bundle()

            if (oldItem.folderName != newItem.folderName) {
                bundle.putInt(PickerConstants.NOTIFY_FOLDER_NAME, 1)
            }
            if (oldItem.firstImagePath != newItem.firstImagePath){
                bundle.putInt(PickerConstants.NOTIFY_FIRST_IMAGE, 1)
                bundle.putInt(PickerConstants.NOTIFY_FOLDER_COUNT, 1)
            }
            if (oldItem.mediaFolderType != newItem.mediaFolderType) {
                bundle.putInt(PickerConstants.NOTIFY_FOLDER_TYPE, 1)
            }
            if (!bundle.isEmpty)
                return bundle
        }
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}