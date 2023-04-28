package com.contusfly.adapters.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.contusfly.databinding.ViewAllMediaHeaderListBinding
import com.contusfly.models.GroupedMedia

class MediaHeaderViewHolder(var viewBinding: ViewAllMediaHeaderListBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindValues(groupedMedia: GroupedMedia.Header, position: Int, isMediaTab:Boolean) {
        if (isMediaTab) {
            val gridLayoutParams = viewBinding.rootLayout.layoutParams as StaggeredGridLayoutManager.LayoutParams
            gridLayoutParams.isFullSpan = true
            viewBinding.rootLayout.layoutParams = gridLayoutParams
            viewBinding.headerSeparator.visibility = if (position != 0) View.VISIBLE else View.GONE
        } else
            viewBinding.headerSeparator.visibility = View.GONE
        viewBinding.headerName.text = groupedMedia.titleName
    }

    companion object {
        fun create(parent: ViewGroup): MediaHeaderViewHolder {
            val binding = ViewAllMediaHeaderListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MediaHeaderViewHolder(binding)
        }
    }
}