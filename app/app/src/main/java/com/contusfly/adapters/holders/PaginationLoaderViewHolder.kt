package com.contusfly.adapters.holders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.databinding.RowLayoutLoaderBinding
import com.contusfly.gone
import com.contusfly.show

class PaginationLoaderViewHolder(var viewBinding: RowLayoutLoaderBinding, val context: Context) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindValues(isLoading:Boolean) {
        if(isLoading){
            viewBinding.loaderLayout.show()
            viewBinding.viewSpace.show()
        } else {
            viewBinding.loaderLayout.gone()
            viewBinding.viewSpace.gone()
        }
    }

}