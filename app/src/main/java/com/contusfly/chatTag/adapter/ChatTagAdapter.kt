package com.contusfly.chatTag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.chatTag.interfaces.ListItemClickListener
import com.contusfly.databinding.ChatTagListItemLayoutBinding
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.flydatabase.model.ChatTagModel

class ChatTagAdapter(
    val mContext: Context,
    val itemtagclick: ListItemClickListener,
    var chatTagnamelist: ArrayList<ChatTagModel>
) : RecyclerView.Adapter<ChatTagAdapter.ViewHolder>() {

    private lateinit var binding: ChatTagListItemLayoutBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            ChatTagListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setTagData(chatTagnamelist[position],position)
        holder.itemView.setOnClickListener {
            if (!chatTagnamelist[position].getisRecomendedTag()) {
                itemtagclick.itemEditClickListener(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return chatTagnamelist.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun setTagData(item: ChatTagModel,position:Int) {

            binding.chatTagNameTv.text = ""
            binding.chatTagInformationTv.text = ""

            if (item.getisRecomendedTag()) {
                binding.chatTagNameTv.text = item.tagname
                binding.chatTagInformationTv.text=item.taginfo
                binding.chatTagNameTv.setTextColor(ContextCompat.getColor(mContext, R.color.blue))
                binding.addView.visibility = View.VISIBLE
                binding.rightArrowIcon.visibility = View.GONE
            } else {
                binding.chatTagNameTv.text = item.tagname
                binding.chatTagInformationTv.text = FlyCore.getChatTagSummary(item.memberIdlist)
                binding.chatTagNameTv.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.text_black_dark))
                binding.addView.visibility = View.GONE
                binding.rightArrowIcon.visibility = View.VISIBLE
            }

            binding.addView.setOnClickListener {

                itemtagclick.itemclicklistener(position)
            }

        }

    }

}



