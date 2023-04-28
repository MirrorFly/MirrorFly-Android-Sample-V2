package com.contusfly.mediapicker.`interface`

import com.contusfly.mediapicker.model.FolderDetail

interface FolderListClickListener {
    fun onItemClicked(folderDetail: FolderDetail, position:Int)
}