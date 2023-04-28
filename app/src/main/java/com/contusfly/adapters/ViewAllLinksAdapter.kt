package com.contusfly.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.adapters.holders.MediaHeaderViewHolder
import com.contusfly.adapters.holders.MediaLinksViewHolder
import com.contusfly.models.GroupedMedia
import com.mirrorflysdk.api.models.ChatMessage

class ViewAllLinksAdapter(private val groupedDocsList:List<GroupedMedia>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            HEADER -> MediaHeaderViewHolder.create(parent)
            else -> MediaLinksViewHolder.create(parent, onLinkClicked, onLinkMessageClicked)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MediaHeaderViewHolder -> {
                holder.bindValues(groupedDocsList[position] as GroupedMedia.Header, position, false)
            }
            is MediaLinksViewHolder -> {
                holder.bindValues(groupedDocsList[position] as GroupedMedia.MessageItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return groupedDocsList.size
    }

    override fun getItemViewType(position: Int) = when (groupedDocsList[position]) {
        is GroupedMedia.Header -> HEADER
        is GroupedMedia.MessageItem -> LINKS_ITEM
    }

    fun onLinkMessageClickedCallback(fn: (ChatMessage) -> Unit) {
        onLinkMessageClicked = fn
    }

    fun onLinkClickedCallback(fn: (ChatMessage) -> Unit) {
        onLinkClicked = fn
    }

    companion object {
        const val HEADER = 0
        const val LINKS_ITEM = 1

        lateinit var onLinkMessageClicked: (ChatMessage) -> Unit
        lateinit var onLinkClicked: (ChatMessage) -> Unit
    }
}