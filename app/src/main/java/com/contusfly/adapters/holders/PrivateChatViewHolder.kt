package com.contusfly.adapters.holders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.databinding.PrivateChatListItemLayoutBinding
import com.contusfly.gone
import com.contusfly.show

class PrivateChatViewHolder(var viewBinding: PrivateChatListItemLayoutBinding, val context: Context) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindValues(isShow:Boolean) {
        if(isShow){
            viewBinding.containerLayout.show()
        } else {
            viewBinding.containerLayout.gone()
        }
    }
}