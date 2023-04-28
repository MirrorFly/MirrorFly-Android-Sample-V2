package com.contusfly.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.adapters.holders.MediaGridViewHolder
import com.contusfly.adapters.holders.MediaHeaderViewHolder
import com.contusfly.models.GroupedMedia
import com.mirrorflysdk.api.models.ChatMessage

class ViewAllMediaAdapter(private val groupedMediaList:List<GroupedMedia>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            HEADER -> MediaHeaderViewHolder.create(parent)
            else -> MediaGridViewHolder.create(parent, onMediaIconClicked)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MediaHeaderViewHolder -> {
                holder.bindValues(groupedMediaList[position] as GroupedMedia.Header, position, true)
            }
            is MediaGridViewHolder -> {
                holder.bindValues(groupedMediaList[position] as GroupedMedia.MessageItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return groupedMediaList.size
    }

    override fun getItemViewType(position: Int) = when (groupedMediaList[position]) {
        is GroupedMedia.Header -> HEADER
        is GroupedMedia.MessageItem -> MEDIA_ITEM
    }

    fun onMediaClickedCallback(fn: (ChatMessage) -> Unit) {
        onMediaIconClicked = fn
    }

    companion object {
        const val HEADER = 0
        const val MEDIA_ITEM = 1

        lateinit var onMediaIconClicked: (ChatMessage) -> Unit
    }
}