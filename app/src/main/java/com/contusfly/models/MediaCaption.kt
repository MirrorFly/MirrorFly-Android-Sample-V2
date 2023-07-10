package com.contusfly.models


import android.text.SpannableStringBuilder
import android.widget.TextView
import com.mirrorflysdk.api.models.ChatMessage

class MediaCaption(
    var htmlText: CharSequence,
    var captionView: TextView,
    var searchEnabled: Boolean,
    var searchKey: String,
    var mentionedUserName: SpannableStringBuilder,
    var messageItem: ChatMessage
)