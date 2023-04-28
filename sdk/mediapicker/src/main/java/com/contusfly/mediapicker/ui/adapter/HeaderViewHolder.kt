package com.contusfly.mediapicker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.contusfly.mediapicker.databinding.MediaHeaderListBinding
import com.contusfly.mediapicker.model.CategorizedMedia

class HeaderViewHolder(private val viewBinding: MediaHeaderListBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(title: CategorizedMedia.Header) {
        val gridLayoutParams = viewBinding.rootLayout.layoutParams as StaggeredGridLayoutManager.LayoutParams
        gridLayoutParams.isFullSpan = true
        viewBinding.rootLayout.layoutParams = gridLayoutParams
        viewBinding.headerName.text = title.titleName
    }

    companion object {
        fun create(parent: ViewGroup): HeaderViewHolder {
            val binding =
                MediaHeaderListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HeaderViewHolder(binding)
        }
    }

}