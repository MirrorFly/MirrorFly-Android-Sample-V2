package com.contusfly.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.adapters.holders.MediaDocsViewHolder
import com.contusfly.adapters.holders.MediaHeaderViewHolder
import com.contusfly.models.GroupedMedia
import com.mirrorflysdk.api.models.ChatMessage

class ViewAllDocsAdapter(private val groupedDocsList:List<GroupedMedia>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            HEADER -> MediaHeaderViewHolder.create(parent)
            else -> MediaDocsViewHolder.create(parent, onDocsClicked)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MediaHeaderViewHolder -> {
                holder.bindValues(groupedDocsList[position] as GroupedMedia.Header, position, false)
            }
            is MediaDocsViewHolder -> {
                holder.bindValues(groupedDocsList[position] as GroupedMedia.MessageItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return groupedDocsList.size
    }

    override fun getItemViewType(position: Int) = when (groupedDocsList[position]) {
        is GroupedMedia.Header -> HEADER
        is GroupedMedia.MessageItem -> DOCS_ITEM
    }

    fun onDocsCallback(fn: (ChatMessage) -> Unit) {
        onDocsClicked = fn
    }

    companion object {
        const val HEADER = 0
        const val DOCS_ITEM = 1

        lateinit var onDocsClicked: (ChatMessage) -> Unit
    }
}