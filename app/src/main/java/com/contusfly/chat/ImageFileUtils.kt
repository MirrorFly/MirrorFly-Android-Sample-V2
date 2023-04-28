package com.contusfly.chat

import android.text.TextUtils
import android.widget.ImageView
import com.contusfly.R
import java.util.*

/**
 * This class contains the all chat related common methods
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
object ImageFileUtils {
    /**
     * Set the image in the chat view based on the message type
     *
     * @param fileViewHolder Instance of the ImageView
     * @param fileName       Name of the File
     */
    fun setFileImage(fileViewHolder: ImageView, fileName: String) {
        if (TextUtils.isEmpty(fileName) || !fileName.contains(".")) return
        when (fileName.toLowerCase(Locale.getDefault()).substring(fileName.lastIndexOf(".")+1)) {
            "csv" -> fileViewHolder.setImageResource(R.drawable.ic_media_csv)
            "pdf" -> fileViewHolder.setImageResource(R.drawable.ic_media_pdf)
            "doc" -> fileViewHolder.setImageResource(R.drawable.ic_media_doc)
            "docx" -> fileViewHolder.setImageResource(R.drawable.ic_media_docx)
            "txt" -> fileViewHolder.setImageResource(R.drawable.ic_media_txt)
            "xls" -> fileViewHolder.setImageResource(R.drawable.ic_media_xls)
            "xlsx" -> fileViewHolder.setImageResource(R.drawable.ic_media_xlsx)
            "ppt" -> fileViewHolder.setImageResource(R.drawable.ic_media_ppt)
            "pptx" -> fileViewHolder.setImageResource(R.drawable.ic_media_pptx)
            "zip" -> fileViewHolder.setImageResource(R.drawable.ic_media_zip)
            "rar" -> fileViewHolder.setImageResource(R.drawable.ic_media_rar)
        }
    }

    /**
     * Set the image in the reply view based on the message type
     *
     * @param fileViewHolder Instance of the ImageView
     * @param fileName       Name of the File
     */
    fun setSenderFileImage(fileViewHolder: ImageView, fileName: String) {
        if (TextUtils.isEmpty(fileName) || !fileName.contains(".")) return
        when (fileName.toLowerCase(Locale.getDefault()).substring(fileName.lastIndexOf(".")+1)) {
            "csv" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_csv)
            "pdf" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_pdf)
            "doc" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_doc)
            "docx" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_docx)
            "txt" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_txt)
            "xls" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_xls)
            "xlsx" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_xlsx)
            "ppt" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_ppt)
            "pptx" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_pptx)
            "zip" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_zip)
            "rar" -> fileViewHolder.setImageResource(R.drawable.ic_sender_reply_rar)
        }
    }

    /**
     * Set the image in the reply view based on the message type
     *
     * @param fileViewHolder Instance of the ImageView
     * @param fileName       Name of the File
     */
    fun setReceiverFileImage(fileViewHolder: ImageView, fileName: String) {
        if (TextUtils.isEmpty(fileName) || !fileName.contains(".")) return
        when (fileName.toLowerCase(Locale.getDefault()).substring(fileName.lastIndexOf(".")+1)) {
            "csv" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_csv)
            "pdf" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_pdf)
            "doc" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_doc)
            "docx" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_docx)
            "txt" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_txt)
            "xls" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_xls)
            "xlsx" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_xlsx)
            "ppt" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_ppt)
            "pptx" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_pptx)
            "zip" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_zip)
            "rar" -> fileViewHolder.setImageResource(R.drawable.ic_receiver_reply_rar)
        }
    }
}