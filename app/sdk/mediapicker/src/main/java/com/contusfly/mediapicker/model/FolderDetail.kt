package com.contusfly.mediapicker.model

import com.contusfly.mediapicker.`interface`.MediaFolderType

data class FolderDetail(var folderName: String, var firstImagePath: String, var contentCount: Int, @MediaFolderType val mediaFolderType: String){
    var images: MutableList<Image> = mutableListOf()
}
