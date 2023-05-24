package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.contusfly.databinding.ListGroupUserTagItemBinding
import com.contusfly.loadUserProfileImage
import com.mirrorflysdk.api.contacts.ProfileDetails
import java.util.Locale

class GroupTagAdapter(private val context: Context, val userTagClickListener: UserTagClickListener) :
    GenericSearchAdapter<ProfileDetails,GroupTagAdapter.GroupTagViewHolder>(mutableListOf()) {
    fun submitList(list: List<ProfileDetails>) {
        setItems(list)
    }

    fun clearList(){
        clearData()
    }
    override fun onBindData(
        holder: GroupTagViewHolder,
        item: ProfileDetails,
        position: Int,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }
    override fun onBindData(holder: GroupTagViewHolder, item: ProfileDetails, position: Int) {
        holder.bind(item)
    }
    override fun hasSearchKey(item: ProfileDetails, filterKey: String): Boolean {
        return item.name.toLowerCase(Locale.getDefault()).contains(filterKey.toLowerCase(Locale.getDefault()))
    }
    override fun setViewHolder(parent: ViewGroup): GroupTagViewHolder {
        var adapterBinding =
            ListGroupUserTagItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupTagViewHolder(adapterBinding)
    }
    inner class GroupTagViewHolder(var viewBinding: ListGroupUserTagItemBinding):BaseViewHolder(viewBinding.root){
        fun bind(profileDetails: ProfileDetails) {
            val name = profileDetails.name
            viewBinding.userChatName.text = name
            viewBinding.imageChatPicture.loadUserProfileImage(context,profileDetails)
            viewBinding.root.setOnClickListener { userTagClickListener.onUserTagClicked(profileDetails) }
        }
    }
    fun interface UserTagClickListener {
        fun onUserTagClicked(profileDetails: ProfileDetails)
    }
}