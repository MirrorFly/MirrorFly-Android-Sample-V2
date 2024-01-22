package com.contusfly.models

import android.os.Parcelable
import com.mirrorflysdk.flycommons.models.MessageType
import kotlinx.android.parcel.Parcelize


@Parcelize
data class EditMessageParams(
    var messageType: MessageType,
    var messageId: String,
    var editedText: String,
    var mentionedUsersIds: List<String> = listOf(),
) : Parcelable
