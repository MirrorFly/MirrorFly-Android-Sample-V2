package com.contusfly.chatTag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.chatTag.interfaces.ListItemClickListener
import com.contusfly.databinding.RecentChatTagHeaderListItemLayoutBinding
import com.mirrorflysdk.flydatabase.model.ChatTagModel

class RecentChatTagAdapter(
    val mContext: Context,
    val itemclick: ListItemClickListener,
    var chatTagnamelist: ArrayList<ChatTagModel>) : RecyclerView.Adapter<RecentChatTagAdapter.ViewHolder>() {

    var selectedPosition:Int=0
    private lateinit var binding: RecentChatTagHeaderListItemLayoutBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentChatTagAdapter.ViewHolder {
        binding =
            RecentChatTagHeaderListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: RecentChatTagAdapter.ViewHolder, position: Int) {

        holder.setData(chatTagnamelist[position],position)
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return chatTagnamelist.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun setData(item: ChatTagModel, position:Int) {

            binding.chatTagView.setText(item.tagname)

            if(selectedPosition==position) {

                binding.chatTagLayout.background= ContextCompat.getDrawable(mContext, R.drawable.chat_tag_selected_bg)

            } else {

                binding.chatTagLayout.background= ContextCompat.getDrawable(mContext, R.drawable.chat_tag_unselected_bg)
            }

            binding.chatTagLayout.setOnClickListener {

                itemclick.itemclicklistener(absoluteAdapterPosition)
            }
        }

    }

    fun updatelist(list: ArrayList<ChatTagModel>, position: Int){
        chatTagnamelist=list
        selectedPosition=position
        notifyDataSetChanged()
    }

    fun updateSelectedPosition(position:Int){
        selectedPosition=position
        notifyDataSetChanged()
    }

}