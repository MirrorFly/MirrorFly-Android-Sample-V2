package com.contusfly.mediapicker.ui.adapter

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.contusfly.mediapicker.R
import com.contusfly.mediapicker.`interface`.ImageListClickListener
import com.contusfly.mediapicker.databinding.ImageListItemBinding
import com.contusfly.mediapicker.model.Image

class ImageListViewHolder(private val viewBinding: ImageListItemBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {
    private var image: Image? = null

    var options: RequestOptions? = null

    fun bind(
        context: Context,
        image: Image?,
        selectedImageList: HashMap<Image, Int>,
        imageListClickListener: ImageListClickListener,
        position:Int
    ) {
        val gridLayoutParams = viewBinding.folderLayout.layoutParams as StaggeredGridLayoutManager.LayoutParams
        gridLayoutParams.isFullSpan = false
        viewBinding.folderLayout.layoutParams = gridLayoutParams
        this.image = image
        image?.let {
            options = RequestOptions().frame(1000)
                .placeholder(
                    ColorDrawable(
                        ContextCompat.getColor(
                            context,
                            R.color.placeholder_color
                        )
                    )
                )
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .priority(Priority.HIGH)
            Glide.with(context)
                .load(image.path)
                .apply(options!!)
                .into(viewBinding.imageView)

            viewBinding.imageType.visibility =
                if (image.isVideo) View.VISIBLE else View.GONE

            setSelected(viewBinding, image, selectedImageList)

            viewBinding.folderLayout.setOnClickListener {
                imageListClickListener.onItemClicked(image, position)
                setSelected(viewBinding, image, selectedImageList)
            }

            viewBinding.folderLayout.setOnLongClickListener {
                imageListClickListener.onItemLongClicked(image, position)
                setSelected(viewBinding, image, selectedImageList)
                true
            }
        }
    }

    private fun setSelected(
        viewBinding: ImageListItemBinding,
        imageDetail: Image,
        selectedImageList: HashMap<Image, Int>
    ) {
        viewBinding.imageSelected.visibility =
            if (selectedImageList.contains(imageDetail)) View.VISIBLE else View.GONE
    }


    companion object {
        fun create(parent: ViewGroup): ImageListViewHolder {
            val binding =
                ImageListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ImageListViewHolder(binding)
        }
    }

}