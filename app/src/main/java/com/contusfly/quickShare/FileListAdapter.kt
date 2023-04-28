package com.contusfly.quickShare

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.contusfly.R
import com.contusfly.chat.FileMimeType.Companion.APPLICATION
import com.contusfly.chat.FileMimeType.Companion.AUDIO
import com.contusfly.chat.FileMimeType.Companion.IMAGE
import com.contusfly.chat.FileMimeType.Companion.UNSUPPORTED_FORMAT
import com.contusfly.chat.FileMimeType.Companion.VIDEO
import com.contusfly.databinding.RowFilesItemBinding
import com.contusfly.models.FileObject
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class FileListAdapter(context: Context) : RecyclerView.Adapter<FileListAdapter.FileShareViewHolder>() {

    /**
     * List of countries for the list view
     */
    private var mainList: MutableList<FileObject>? = mutableListOf()

    private var context: Context? = null

    /**
     * Instantiates
     *
     * @param context
     */
    init {
        this.context = context
    }

    fun setDataList(fileObjects: ArrayList<FileObject>?) {
        this.mainList = fileObjects!!.toMutableList()
    }

    class FileShareViewHolder(var viewBinding: RowFilesItemBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileShareViewHolder {
        val adapterBinding = RowFilesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FileShareViewHolder(adapterBinding)
    }

    override fun onBindViewHolder(holder: FileShareViewHolder, position: Int) {
        validateType(mainList!![position], holder)
    }

    private fun validateType(fileObject: FileObject, holder: FileShareViewHolder) {
        holder.viewBinding.fileName.text = fileObject.name
        holder.viewBinding.fileSize.text = fileObject.readableSize
        holder.viewBinding.fileType.text = fileObject.fileExtension
        handleMimeType(fileObject, holder)
        setColorAndMessageForUnsupportedInfo(holder, fileObject)
    }

    private fun setColorAndMessageForUnsupportedInfo(holder: FileShareViewHolder, fileObject: FileObject) {
        var invalidTextMessage = ""
        if (!fileObject.fileValidation!![FileValidation.SIZE]!!) {
            val errorMessage = context!!.getString(R.string.file_size_error_message)
            holder.viewBinding.fileSize.setTextColor(ContextCompat.getColor(context!!, R.color.invalid_red))
            invalidTextMessage = errorMessage + " " + getFileMimeTypeMessage(fileObject.fileMimeType)
        } else holder.viewBinding.fileSize.setTextColor(ContextCompat.getColor(context!!, R.color.color_black))

        if (!fileObject.fileValidation!![FileValidation.DURATION]!!) {
            holder.viewBinding.fileDuration.setTextColor(ContextCompat.getColor(context!!, R.color.invalid_red))
            invalidTextMessage = "File duration exceeds maximum limit."
        } else holder.viewBinding.fileDuration.setTextColor(ContextCompat.getColor(context!!,R.color.color_black))

        if (!fileObject.fileValidation!![FileValidation.TYPE]!!) {
            holder.viewBinding.fileType.setTextColor(ContextCompat.getColor(context!!,R.color.invalid_red))
            invalidTextMessage = when (fileObject.fileMimeType) {
                AUDIO -> context!!.getString(R.string.audio_file_not_supported)
                APPLICATION -> context!!.getString(R.string.document_file_not_supported)
                else -> context!!.getString(R.string.file_not_supported)
            }
        } else holder.viewBinding.fileType.setTextColor(ContextCompat.getColor(context!!,R.color.color_black))

        holder.viewBinding.invalidText.text = invalidTextMessage
    }

    private fun getFileMimeTypeMessage(fileMimeType: String): String {
        return if (fileMimeType == IMAGE) "10MB" else if (fileMimeType == VIDEO || fileMimeType == AUDIO) "30MB" else "20MB"
    }

    private fun handleMimeType(fileObject: FileObject, holder: FileShareViewHolder) {
        when (fileObject.fileMimeType) {
            IMAGE -> Glide.with(context!!).load(fileObject.uri.toString())
                .apply(RequestOptions.bitmapTransform(RoundedCorners(8)).diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(holder.viewBinding.fileTypeImage)
            AUDIO -> {
                holder.viewBinding.fileDuration.text = fileObject.readableDuration
                holder.viewBinding.fileTypeImage.setImageResource(R.drawable.share_audio)
            }
            VIDEO -> {
                holder.viewBinding.fileDuration.text = fileObject.readableDuration
                Glide.with(context!!).load(fileObject.uri.toString())
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(8)).diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(holder.viewBinding.fileTypeImage)
            }
            APPLICATION -> {
                val fileExtension: String = fileObject.fileExtension
                if (fileExtension.contains("xls")) {
                    holder.viewBinding.fileTypeImage.setImageResource(R.drawable.ic_xls)
                } else if (fileExtension.contains("doc")) {
                    holder.viewBinding.fileTypeImage.setImageResource(R.drawable.ic_doc)
                } else if (fileExtension.contains("pdf")) {
                    holder.viewBinding.fileTypeImage.setImageResource(R.drawable.ic_pdf)
                } else if (fileExtension.contains("ppt")) {
                    holder.viewBinding.fileTypeImage.setImageResource(R.drawable.ic_ppt)
                } else {
                    holder.viewBinding.fileTypeImage.setImageResource(R.drawable.share_file)
                }
            }
            UNSUPPORTED_FORMAT -> holder.viewBinding.fileTypeImage.setImageResource(R.drawable.share_file)
            else -> holder.viewBinding.fileTypeImage.setImageResource(R.drawable.share_file)
        }
    }

    override fun getItemCount(): Int {
        return mainList!!.size
    }

    fun removeItem(position: Int) {
        mainList!!.removeAt(position)
        notifyItemRemoved(position)
    }
}