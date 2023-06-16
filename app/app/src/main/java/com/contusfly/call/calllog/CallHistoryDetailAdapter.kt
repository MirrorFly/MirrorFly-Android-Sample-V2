package com.contusfly.call.calllog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.emoji.widget.EmojiAppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.Constants
import com.contusfly.R
import com.contusfly.getDisplayName
import com.contusfly.gone
import com.contusfly.loadUserProfileImage
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CircularImageView
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.utils.Utils
import java.util.*

class CallHistoryDetailAdapter(val context: Context, private var userList: ArrayList<String>)
    : RecyclerView.Adapter<CallHistoryDetailAdapter.CallHistoryDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallHistoryDetailViewHolder {
        return CallHistoryDetailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_detail_call_logs, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: CallHistoryDetailViewHolder, position: Int) {
        if (userList[position] == SharedPreferenceManager.getCurrentUserJid()) {
            holder.txtChatPersonName.text = Constants.YOU
            holder.emailContactIcon.gone()
            val image = SharedPreferenceManager.getString(com.contusfly.utils.Constants.USER_PROFILE_IMAGE)

            val userName = Utils.returnEmptyStringIfNull(SharedPreferenceManager
                    .getString(com.contusfly.utils.Constants.USER_PROFILE_NAME))
            val setDrawable = SetDrawable(context)
            val icon = setDrawable.setDrawableForProfile(userName)
            MediaUtils.loadImageWithGlideSecure(context, image,
                    holder.imgRoster, icon)
        } else {
            val roster = ProfileDetailsUtils.getProfileDetails(userList[position])
            roster?.let {
                holder.imgRoster.loadUserProfileImage(context, it)
                holder.txtChatPersonName.text = it.getDisplayName()
                holder.emailContactIcon.gone()
            }
        }
    }

    inner class CallHistoryDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /**
         * The image view of the Roster.
         */
        val imgRoster = itemView.findViewById<CircularImageView>(R.id.image_chat_picture)

        /**
         * Email icon view for email contacts.
         */
        var emailContactIcon = itemView.findViewById<CircularImageView>(R.id.email_contact_icon)

        /**
         * The name of the Roster.
         */
        val txtChatPersonName = itemView.findViewById<EmojiAppCompatTextView>(R.id.text_chat_name)
    }
}