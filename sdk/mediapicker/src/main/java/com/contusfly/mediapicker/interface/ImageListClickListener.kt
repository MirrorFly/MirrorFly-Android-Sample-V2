package com.contusfly.mediapicker.`interface`

import com.contusfly.mediapicker.model.Image
import com.contusfly.mediapicker.model.ImageDetail

interface ImageListClickListener {
    fun onItemClicked(imageDetail: Image, position: Int)

    fun onItemLongClicked(imageDetail: Image, position: Int)
}