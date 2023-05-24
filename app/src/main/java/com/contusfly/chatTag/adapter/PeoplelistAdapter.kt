package com.contusfly.chatTag.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.*
import com.contusfly.chatTag.interfaces.ChatTagClickListener
import com.contusfly.databinding.AddPeopleRecentChatItemLayoutBinding
import com.contusfly.utils.*
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.RecentChat
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class PeoplelistAdapter(
    val context: Context,
    val clicklistener: ChatTagClickListener,
    val recentChatList: ArrayList<RecentChat>
) : RecyclerView.Adapter<PeoplelistAdapter.ViewHolder>(), Filterable {

    var filterlist=recentChatList

    private var userblockedMe = false

    private val chatTimeOperations = ChatTimeOperations(Calendar.getInstance())

    private lateinit var binding: AddPeopleRecentChatItemLayoutBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            AddPeopleRecentChatItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(filterlist[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return filterlist?.size ?: 0
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun setData(item: RecentChat) {
            binding.chatTagImageChatPicture.setImageDrawable(null)
            setChatTagUserView(item, binding)
            setChatTagMessageView(item, binding)
            setChatTagPinnedIcon(item, binding)
            switchChatTagBetweenMuteUnmute(item, binding)
            chatTagSelection(item, binding)
            chatTagonClick(item, binding,absoluteAdapterPosition)
        }

    }


    private fun setChatTagUserView(recent: RecentChat, holder: AddPeopleRecentChatItemLayoutBinding) {
        setPeopleChatImage(holder, recent)
    }

    private fun setPeopleChatImage(holder: AddPeopleRecentChatItemLayoutBinding, data: RecentChat) {
        if (!data.isGroup)
            userblockedMe = data.isBlockedMe
        if(data.isGroup) {
            val isnewlyCreated = SharedPreferenceManager.getBoolean(Constants.NEWLY_CREATED_GROUP)
            val newlyCreatedJID = SharedPreferenceManager.getString(Constants.NEW_GROUP_JID)
            val imageBitmapdata = SharedPreferenceManager.getString(Constants.NEW_GROUP_IMAGE)
            if (!data.isAdminBlocked && data.profileImage.isNotEmpty() && newlyCreatedJID.isNotEmpty() && imageBitmapdata.isNotEmpty() && isnewlyCreated && data.jid.equals(newlyCreatedJID)) {
                holder.chatTagImageChatPicture.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_grp_bg
                    )!!
                )
                try {
                    val imageAsBytes: ByteArray =
                        android.util.Base64.decode(imageBitmapdata, android.util.Base64.DEFAULT)
                    val image =
                        BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
                    holder.chatTagImageChatPicture.setImageBitmap(image)
                    val drawable: Drawable = BitmapDrawable(context.resources, image)
                    holder.chatTagImageChatPicture.setImageDrawable(drawable)
                    MediaUtils.loadImage(
                        context,
                        data.profileImage,
                        holder.chatTagImageChatPicture,
                        drawable
                    )
                } catch (e: IOException) {
                    LogMessage.e("ProfileDialogFragment", e)
                }
            } else
                holder.chatTagImageChatPicture.loadUserProfileImage(context, data)
        } else{
            holder.chatTagImageChatPicture.loadUserProfileImage(context, data)
        }
        holder.chatTagTextChatName.text = data.profileName
    }

    private fun setChatTagMessageView(recent: RecentChat, holder: AddPeopleRecentChatItemLayoutBinding) {
        if (!recent.lastMessageId.isNullOrBlank() && isChatTagValidMessage(recent.lastMessageId)) {
            try {
                val chatMessage: ChatMessage = FlyMessenger.getMessageOfId(recent.lastMessageId)!!
                setChatTagMessageData(holder, chatMessage)
            } catch (e: Exception) {
                LogMessage.d(TAG, "Exception occurred from DB: ${e.message}")
            }
        } else {
            if(recent.isConversationUnRead)
            // when user cleared chat there will be no associated message object for recent
            holder.chatTagTextChatPerson.text = ""
            holder.chatTagTextChatMessage.text = ""
            holder.chatTagTextChatTime.text = ""
            holder.chatTagImageChatStatus.gone()
            holder.chatTagImageMediaType.gone()
            holder.chatTagTextUnseenCount.text = ""
            if(!recent.isConversationUnRead)
                holder.chatTagTextUnseenCount.gone()
            holder.chatTagTextChatPerson.gone()
        }
    }

    private fun isChatTagValidMessage(lastMessageId: String): Boolean {
        val message = FlyMessenger.getMessageOfId(lastMessageId)
        return message != null && !message.isMessageDeleted()
    }

    private fun setChatTagMessageData(holder: AddPeopleRecentChatItemLayoutBinding, chatMessage: ChatMessage?) {
        val time = chatTimeOperations.getRecentChatTime(context, chatMessage!!.messageSentTime)
        holder.chatTagTextChatTime.text = time
    }

    private fun setChatTagPinnedIcon(item: RecentChat, holder: AddPeopleRecentChatItemLayoutBinding) {
        if (item.isChatPinned && context.javaClass.simpleName != "groupmentionMessageActivity")
            holder.pin.show()
        else holder.pin.gone()
    }

    private fun switchChatTagBetweenMuteUnmute(recent: RecentChat, holder: AddPeopleRecentChatItemLayoutBinding) {
        if (recent.isMuted && FlyCore.isUserUnArchived(recent.jid)) holder.mute.show() else holder.mute.gone()
    }

    private fun chatTagSelection(recent: RecentChat, binding: AddPeopleRecentChatItemLayoutBinding){
        if(recent.isSelected){
            binding.selectIcon.setImageResource(R.drawable.ic_selected_tick)
        } else {
            binding.selectIcon.setImageResource(R.drawable.circle_unselect_bg)
        }
    }

    private fun chatTagonClick(
        recent: RecentChat,
        binding: AddPeopleRecentChatItemLayoutBinding,
        absoluteAdapterPosition: Int){

        binding.parentView.setOnClickListener {
            clicklistener.selectUnselectChat(absoluteAdapterPosition,recent,false)
        }

        binding.chatTagImageChatPicture.setOnClickListener {
            clicklistener.selectUnselectChat(absoluteAdapterPosition,recent,false)
        }

    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun publishResults(charSequence: CharSequence?, filterResults: Filter.FilterResults) {

                try {

                    filterlist = filterResults.values as ArrayList<RecentChat>
                    notifyDataSetChanged()
                    clicklistener.filterListUpdated(filterlist)

                } catch(e:Exception) {

                    println("Error--"+e.toString())
                }

            }

            override fun performFiltering(charSequence: CharSequence?): Filter.FilterResults {
                val queryString = charSequence?.toString()?.lowercase()

                val filterResults = Filter.FilterResults()


                filterResults.values = if (queryString==null || queryString.isEmpty()){

                    filterlist=recentChatList

                } else {

                    var filteredlist=ArrayList<RecentChat>()

                    for(i in 0 until recentChatList!!.size) {

                        val recentModel=recentChatList[i]

                        var name=recentModel.nickName.lowercase()

                        if(name.contains(queryString)){

                            filteredlist.add(recentModel)
                        }
                    }

                    filterlist=filteredlist
                }

                filterResults.values=filterlist

                return filterResults
            }
        }
    }

}
