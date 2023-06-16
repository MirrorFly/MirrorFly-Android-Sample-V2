package com.contusfly.mediapicker.ui.adapter

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.contusfly.mediapicker.R
import com.contusfly.mediapicker.`interface`.FolderListClickListener
import com.contusfly.mediapicker.`interface`.MediaFolderType
import com.contusfly.mediapicker.databinding.FolderListItemBinding
import com.contusfly.mediapicker.model.FolderDetail
import com.contusfly.mediapicker.utils.PickerConstants

class FolderListAdapter(
    private val context: Context,
    private val folderList: ArrayList<FolderDetail>,
    private val folderListClickListener: FolderListClickListener
) : RecyclerView.Adapter<FolderListAdapter.FolderListViewHolder>() {

    val options: RequestOptions = RequestOptions()
        .placeholder(ColorDrawable(ContextCompat.getColor(context, R.color.placeholder_color)))
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .dontAnimate()
        .priority(Priority.HIGH)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderListViewHolder {
        val binding =
            FolderListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FolderListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FolderListViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty() || payloads[0] !is Bundle)
            onBindViewHolder(holder, position)
        else {
            val item = folderList[position]
            val bundle = payloads[0] as Bundle
            handlePayloads(bundle, holder, item)
        }
    }

    private fun handlePayloads(
        bundle: Bundle,
        holder: FolderListViewHolder,
        folderDetail: FolderDetail
    ) {
        for (key in bundle.keySet()) {
            when (key) {
                PickerConstants.NOTIFY_FOLDER_NAME -> {
                    setFolderName(folderDetail, holder)
                }
                PickerConstants.NOTIFY_FIRST_IMAGE -> {
                    setFolderFirstImage(folderDetail, holder)
                }
                PickerConstants.NOTIFY_FOLDER_COUNT -> {
                    setFolderCount(folderDetail, holder)
                }
                PickerConstants.NOTIFY_FOLDER_TYPE -> {
                    setFolderType(folderDetail, holder)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: FolderListViewHolder, position: Int) {
        val folderDetail = folderList[position]
        setFolderName(folderDetail, holder)
        setFolderCount(folderDetail, holder)
        setFolderFirstImage(folderDetail, holder)
        setFolderType(folderDetail, holder)

        holder.viewBinding.folderLayout.setOnClickListener {
            folderListClickListener.onItemClicked(folderDetail, position)
        }
    }

    private fun setFolderType(
        folderDetail: FolderDetail,
        holder: FolderListViewHolder
    ) {
        when (folderDetail.mediaFolderType) {
            MediaFolderType.CAMERA ->
                holder.viewBinding.folderImage.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_camera_folder
                    )
                )
            MediaFolderType.ALL_VIDEO ->
                holder.viewBinding.folderImage.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_video_folder
                    )
                )
            else ->
                holder.viewBinding.folderImage.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_folder
                    )
                )
        }
    }

    private fun setFolderFirstImage(
        folderDetail: FolderDetail,
        holder: FolderListViewHolder
    ) {
        Glide.with(context)
            .load(folderDetail.firstImagePath)
            .apply(options)
            .into(holder.viewBinding.firstImage)
    }

    private fun setFolderCount(
        folderDetail: FolderDetail,
        holder: FolderListViewHolder
    ) {
        if (folderDetail.contentCount > 0)
            holder.viewBinding.folderContentsCount.text = folderDetail.contentCount.toString()
        else {
            folderDetail.contentCount = folderDetail.images.size
            holder.viewBinding.folderContentsCount.text = folderDetail.contentCount.toString()
        }
    }

    private fun setFolderName(
        folderDetail: FolderDetail,
        holder: FolderListViewHolder
    ) {
        holder.viewBinding.folderName.text = folderDetail.folderName
    }

    override fun getItemCount(): Int {
        return folderList.size
    }

    class FolderListViewHolder(var viewBinding: FolderListItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}