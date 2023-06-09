package com.contusfly.chatTag.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.chatTag.interfaces.ChatTagClickListener
import com.contusfly.databinding.PeopleSelectionListItemLayoutBinding
import com.contusfly.databinding.PeopleViewListItemLayoutBinding
import com.contusfly.loadUserProfileImage
import com.contusfly.utils.*
import com.contusfly.views.CircularImageView
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.models.RecentChat
import java.io.IOException

class PeopleSelectionListAdapter(
    val context: Context,
    val clicklistener: ChatTagClickListener,
    val isCreateTagPage: Boolean,
    var chatSelectedList: ArrayList<RecentChat>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: PeopleSelectionListItemLayoutBinding
    private lateinit var viewbinding: PeopleViewListItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            TYPE_CREATE_TAG -> {
                viewbinding = PeopleViewListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PeopleViewHolder()
            }
            else -> {
                binding = PeopleSelectionListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PeopleSelectionViewHolder()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is PeopleSelectionViewHolder) {
            holder.setData(chatSelectedList[position])
            holder.setIsRecyclable(false)

        } else {

            var v=holder as PeopleViewHolder
            v.setData(chatSelectedList[position])
            v.setIsRecyclable(false)
        }

    }

    override fun getItemCount(): Int {
        return chatSelectedList.size
    }

    override fun getItemViewType(position: Int): Int {
        if(isCreateTagPage){

            return TYPE_CREATE_TAG

        } else{

            return TYPE_SELECTION_TAG
        }
    }

    inner class PeopleSelectionViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun setData(item: RecentChat) {

            setRecentChatImage(binding.imageChatPicture, item)

            binding.imageChatPicture.setOnClickListener {

                clicklistener.selectUnselectChat(absoluteAdapterPosition, item, true)
            }
            binding.closeIcon.setOnClickListener {

                clicklistener.selectUnselectChat(absoluteAdapterPosition, item, true)

            }

        }

    }

    inner class PeopleViewHolder : RecyclerView.ViewHolder(viewbinding.root) {

        fun setData(item: RecentChat) {

            setRecentChatImage(viewbinding.imageChatPicture, item)
            setUsername(viewbinding,item)
            setTagInfo(viewbinding,item)

            viewbinding.parentView.setOnClickListener {

                clicklistener.selectUnselectChat(absoluteAdapterPosition, item, true)
            }

            viewbinding.imageChatPicture.setOnClickListener {
                clicklistener.selectUnselectChat(absoluteAdapterPosition, item, true)
            }

        }

    }

    private fun setRecentChatImage(imageChatPicture: CircularImageView, recent: RecentChat) {
        if (recent.jid.isNullOrEmpty()) return
        when {
            recent.isGroup -> {
                val isNewlyCreated = SharedPreferenceManager.getBoolean(Constants.NEWLY_CREATED_GROUP)
                val newlyCreatedJid = SharedPreferenceManager.getString(Constants.NEW_GROUP_JID)
                val imageBitmap = SharedPreferenceManager.getString(Constants.NEW_GROUP_IMAGE)
                if (!recent.isAdminBlocked && recent.profileImage.isNotEmpty() && newlyCreatedJid.isNotEmpty() && imageBitmap.isNotEmpty() && isNewlyCreated && recent.jid.equals(newlyCreatedJid)) {
                    imageChatPicture.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_grp_bg)!!)
                    try {
                        val imageAsBytes: ByteArray = android.util.Base64.decode(imageBitmap, android.util.Base64.DEFAULT)
                        val image = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
                        imageChatPicture.setImageBitmap(image)
                        val drawable: Drawable = BitmapDrawable(context.resources, image)
                        imageChatPicture.setImageDrawable(drawable)
                        MediaUtils.loadImage(context, recent.profileImage, imageChatPicture, drawable)
                    } catch (e: IOException) {
                        LogMessage.e("ProfileDialogFragment", e)
                    }
                } else
                    imageChatPicture.loadUserProfileImage(context, recent)
            }
            else -> {

                imageChatPicture.loadUserProfileImage(context, recent)
            }
        }
    }

    private fun setUsername(holder: PeopleViewListItemLayoutBinding, recent: RecentChat) {

        if (recent.jid.isNullOrEmpty()) return

        when {

            recent.isGroup -> {
                holder.textChatName.text = recent.nickName
            }
            else -> {
                holder.textChatName.text = recent.profileName
                holder.imageChatPicture.loadUserProfileImage(context, recent)
            }
        }
    }

    private fun setTagInfo(binding: PeopleViewListItemLayoutBinding, recent: RecentChat){

        try {
            if(recent.isGroup){
                binding.textChatPerson.visibility= View.VISIBLE
                var membersCount=  GroupManager.getMembersCountOfGroup(recent.jid)
                binding.textChatPerson.text=membersCount.toString()+" "+context.resources.getString(R.string.members)
            } else {
                binding.textChatPerson.visibility= View.GONE
            }
        } catch(e:Exception) {
            LogMessage.e(TAG,e.toString())
        }
    }

    fun getItemPosition(item: RecentChat):Int{
        return chatSelectedList.indexOf(item)
    }

    fun clear(){
        chatSelectedList.clear()
        notifyDataSetChanged()
    }
    fun updateList(
        list: ArrayList<RecentChat>,
        updatedPosition: Int,
        clickedCheckBox: Boolean,
        itemSelected: Boolean,
    ) {
        try {
            chatSelectedList = list
            if (!clickedCheckBox) {
                notifyDataSetChanged()
            } else {
                if (itemSelected) {
                    notifyItemChanged(chatSelectedList.size - 1)
                } else {
                    notifyItemRemoved(updatedPosition)
                }
            }
        }catch (e:Exception){
            LogMessage.e(TAG,e.toString())
        }
    }

    companion object{
        private const val TYPE_CREATE_TAG = 0
        private const val TYPE_SELECTION_TAG = 1
    }
}