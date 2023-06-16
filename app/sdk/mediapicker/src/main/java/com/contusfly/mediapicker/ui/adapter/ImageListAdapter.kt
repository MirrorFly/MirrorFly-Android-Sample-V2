package com.contusfly.mediapicker.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.mediapicker.`interface`.ImageListClickListener
import com.contusfly.mediapicker.model.CategorizedMedia
import com.contusfly.mediapicker.model.Image


class ImageListAdapter(
    private val context: Context,
    private val selectedImageList: HashMap<Image, Int>,
    private val imageListClickListener: ImageListClickListener
) : PagingDataAdapter<CategorizedMedia, RecyclerView.ViewHolder>(IMAGE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> HeaderViewHolder.create(parent)
            IMAGE_ITEM -> ImageListViewHolder.create(parent)
            else -> ImageListViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val categorizedMedia = getItem(position)
        when (holder) {
            is ImageListViewHolder -> {
                holder.bind(
                    context,
                    (categorizedMedia as CategorizedMedia.ImageItem).image,
                    selectedImageList,
                    imageListClickListener,
                    position
                )
            }
            is HeaderViewHolder -> holder.bind(categorizedMedia as CategorizedMedia.Header)
        }
    }

    override fun getItemViewType(position: Int) = when (getItem(position)) {
        is CategorizedMedia.Header -> HEADER
        is CategorizedMedia.ImageItem -> IMAGE_ITEM
        else -> IMAGE_ITEM
    }

    fun getItemType(position: Int): CategorizedMedia? {
        return getItem(position)
    }

    companion object {
        const val HEADER = 0
        const val IMAGE_ITEM = 1

        private val IMAGE_COMPARATOR = object : DiffUtil.ItemCallback<CategorizedMedia>() {
            override fun areItemsTheSame(
                oldItem: CategorizedMedia,
                newItem: CategorizedMedia
            ): Boolean =
                true

            override fun areContentsTheSame(
                oldItem: CategorizedMedia,
                newItem: CategorizedMedia
            ): Boolean =
                true
        }
    }
}