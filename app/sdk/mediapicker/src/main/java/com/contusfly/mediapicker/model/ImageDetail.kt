package com.contusfly.mediapicker.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class ImageDetail(val id: Long, var path: String, var isVideo:Boolean) : Parcelable {
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
        var result = id.hashCode()
        result = 31 * result + path.hashCode()
        result = 31 * result + isVideo.hashCode()
        return result
    }

}