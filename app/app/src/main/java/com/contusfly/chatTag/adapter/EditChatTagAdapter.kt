package com.contusfly.chatTag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.chatTag.interfaces.ItemTouchHelperAdapter
import com.contusfly.chatTag.interfaces.ListItemClickListener
import com.contusfly.databinding.EditChatTagListItemLayoutBinding
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.flydatabase.model.ChatTagModel

class EditChatTagAdapter (
    val mContext: Context,
    val itemclick: ListItemClickListener,
    var chatTagnamelist: MutableList<ChatTagModel>, var reorderList: ReorderList
) : RecyclerView.Adapter<EditChatTagAdapter.ViewHolder>(),ItemTouchHelperAdapter {

    private lateinit var binding: EditChatTagListItemLayoutBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            EditChatTagListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(chatTagnamelist[position])
    }

    override fun getItemCount(): Int {
        return chatTagnamelist.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun setData(item: ChatTagModel) {

            binding.editChatTagNameTv.text = ""
            binding.editChatTagInformationTv.text = ""

            if (item.isRecomendedTag) {
                binding.editChatTagNameTv.text = item.tagname
                binding.editChatTagInformationTv.text=item.taginfo
                binding.editChatTagNameTv.setTextColor(ContextCompat.getColor(mContext, R.color.blue))
            } else {
                binding.editChatTagNameTv.text = item.tagname
                binding.editChatTagInformationTv.text = FlyCore.getChatTagSummary(item.memberidlist!!)
                binding.editChatTagNameTv.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.text_black_dark))
            }


            binding.editChatTagRemoveIcon.setOnClickListener {

                itemclick.itemclicklistener(absoluteAdapterPosition)
            }

        }

    }

    fun updateList(selectedPosition:Int){

        try {
            chatTagnamelist.removeAt(selectedPosition)
            notifyItemRemoved(selectedPosition)
        } catch(e:IndexOutOfBoundsException) {
            LogMessage.e("Error",e.toString())
        } catch(e:Exception) {
            LogMessage.e("Error",e.toString())
        }

    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        reorderList.onItemMoved(fromPosition,toPosition)
    }

    override fun onItemDismiss(position: Int) {
        TODO("Not yet implemented")
    }

}

interface ReorderList {
    public fun onItemMoved(fromPosition: Int, toPosition: Int)

}