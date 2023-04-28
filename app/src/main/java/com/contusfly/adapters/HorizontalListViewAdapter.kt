package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.adapters.HorizontalListViewAdapter.HorizontalViewHolder
import com.contusfly.utils.MediaUtils.loadImageWithGlide
import com.mirrorflysdk.models.MultipleImages

/**
 * Recycler adapter which used to viewlist the images horizontally
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class HorizontalListViewAdapter(
        private val context: Context,
        private val imagesList: MutableList<MultipleImages>,
        private var imagePosition: Int) : RecyclerView.Adapter<HorizontalViewHolder>() {
    /**
     * Image item click listener
     */
    private var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        return HorizontalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_image_item, parent, false))
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        loadImageWithGlide(context, imagesList[position].imagePath,
                holder.imageItem, R.drawable.ic_image_placeholder)

        //Set video type indicatior
        holder.videoItem.visibility = if (imagesList[position].isImage) View.GONE else View.VISIBLE

        // Change the background of the selected item
        holder.imageItemBorder.visibility = if (position == imagePosition) View.VISIBLE else View.GONE
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
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return imagesList
     */
    override fun getItemCount(): Int {
        return imagesList.size
    }

    /**
     * Sets on item click listener.
     *
     * @param mItemClickListener the m item click listener
     */
    fun setOnItemClickListener(mItemClickListener: OnItemClickListener?) {
        onItemClickListener = mItemClickListener
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

    /**
     * The type View holder.
     */
    inner class HorizontalViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        /**
         * The Iv product images.
         */
        val imageItem: ImageView = itemView.findViewById(R.id.image_item)
        val imageItemBorder: ImageView = itemView.findViewById(R.id.image_item_border)
        val videoItem: ImageView = itemView.findViewById(R.id.video_item)

        /**
         * Interface definition for a callback to be invoked when a view is clicked
         *
         * @param v
         */
        override fun onClick(v: View) {
            if (onItemClickListener != null) {
                onItemClickListener!!.onItemClick(v, layoutPosition)
            }
        }

        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        init {
            imageItem.setOnClickListener(this)
        }
    }
}