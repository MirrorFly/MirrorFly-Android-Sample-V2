package com.contusfly.adapters.holders

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.databinding.RowLayoutArchivedBinding
import com.contusfly.gone
import com.contusfly.show
import com.contusfly.utils.Constants

class ArchiveChatViewHolder(var viewBinding: RowLayoutArchivedBinding, val context: Context) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindValues(archiveStatus: Triple<Boolean, Boolean, Int>, position:Int) {
        if (archiveStatus.first) {
            bindArchiveChatStatus(archiveStatus.second, archiveStatus.third, position)
        } else {
            hideView()
        }
    }

    private fun bindArchiveChatStatus(isArchiveSettingsEnabled: Boolean, unreadArchiveChatCount: Int, position: Int) {
        if (isArchiveSettingsEnabled) {
            if (position == 0) {
                viewBinding.rootLayout.show()
                viewBinding.viewSpace.gone()
                viewBinding.textUnreadChatCount.text = if (unreadArchiveChatCount > 0) unreadArchiveChatCount.toString() else Constants.EMPTY_STRING
            } else {
                hideView()
                viewBinding.viewSpace.show()
            }
        } else {
            if (position == 0)
                hideView()
            else {
                viewBinding.viewSpace.show()
                viewBinding.rootLayout.show()
                viewBinding.textUnreadChatCount.setTextColor(ContextCompat.getColor(context, R.color.color_chat_list_time))
                viewBinding.textUnreadChatCount.text = unreadArchiveChatCount.toString()
            }
        }
    }

    fun hideView() {
        viewBinding.rootLayout.gone()
        viewBinding.viewSpace.gone()
    }
}