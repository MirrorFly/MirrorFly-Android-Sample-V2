package com.contusfly.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MediaPreviewModel(var path: String, var caption: String, var thumbString: String, var isImage:Boolean) : Parcelable {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other == null || javaClass != other.javaClass -> return false
            else -> {
                true
            }
        }
    }

    override fun hashCode(): Int {
        var result = path.hashCode()
        result = 31 * result + caption.hashCode()
        result = 31 * result + thumbString.hashCode()
        result = 31 * result + isImage.hashCode()
        return result
    }

}