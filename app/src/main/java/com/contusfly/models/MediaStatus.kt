package com.contusfly.models

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import com.mirrorflysdk.api.models.ChatMessage

class MediaStatus(var txtRetry: TextView?, var download: View?, var progressBar: ProgressBar?, var status: Int,
                  var item: ChatMessage?, var imgPlay: ImageView?,var cancelImageview: ImageView?, var forwardImageview: ImageView?,var viewProgress: RelativeLayout?, var progressbuffer: ProgressBar?) {

}