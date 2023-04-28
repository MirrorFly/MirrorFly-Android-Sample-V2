package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.databinding.RowImageItemBinding
import com.contusfly.models.MediaPreviewModel
import com.contusfly.utils.MediaUtils

class MediaPreviewAdapter(
    private val context: Context,
    private val imagesList: MutableList<MediaPreviewModel>,
    private var imagePosition: Int,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MediaPreviewAdapter.MediaPreviewHolder>() {

    class MediaPreviewHolder(val viewBinding: RowImageItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaPreviewHolder {
        val binding =
            RowImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MediaPreviewHolder(binding)
    }

    override fun onBindViewHolder(holder: MediaPreviewHolder, position: Int) {
        MediaUtils.loadImageWithGlide(
            context, imagesList[position].path,
            holder.viewBinding.imageItem, R.drawable.ic_image_placeholder
        )
        //Set video type indicator
        holder.viewBinding.videoItem.visibility =
            if (imagesList[position].isImage) View.GONE else View.VISIBLE

        // Change the background of the selected item
        holder.viewBinding.imageItemBorder.visibility =
            if (position == imagePosition) View.VISIBLE else View.GONE

        holder.viewBinding.imageItem.setOnClickListener { v ->
            onItemClickListener.onItemClick(
                v,
                position
            )
        }
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    /**
     * Set the position of the selected image item.
     *
     * @param itemPosition Selected image position
     */
    fun setPosition(itemPosition: Int) {
        imagePosition = itemPosition
    }

    /**
     * The interface On item click listener.
     */
    fun interface OnItemClickListener {
        /**
         * On item click.
         *
         * @param view     the view
         * @param position the position
         */
        fun onItemClick(view: View?, position: Int)
    }
}