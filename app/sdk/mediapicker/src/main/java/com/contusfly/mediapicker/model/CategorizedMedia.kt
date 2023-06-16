package com.contusfly.mediapicker.model

sealed class CategorizedMedia {
    abstract val id : Long
    data class ImageItem(val image: Image) : CategorizedMedia(){
        override val id: Long
            get() = Long.MIN_VALUE
    }
    data class Header(val titleName: String) : CategorizedMedia(){
        override val id: Long
            get() = Long.MIN_VALUE +1
    }
}