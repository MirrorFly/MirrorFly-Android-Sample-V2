package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.*
import com.contusfly.databinding.SelectContactMessageItemBinding
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.Utils

class SelectContactMessageAdapter(private val context: Context, private var list: ArrayList<ContactSelectionModel>, private val clickListener: ContactChatOnClickListener) : RecyclerView.Adapter<SelectContactMessageAdapter.SelectContactMessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectContactMessageViewHolder {
        val binding = SelectContactMessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectContactMessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectContactMessageViewHolder, position: Int) {
        val contactData = list[position]
        holder.viewBinding.textContactName.text = Utils.returnEmptyStringIfNull(contactData.contactName)
        holder.viewBinding.mobileNumber.text = Utils.returnEmptyStringIfNull(contactData.contactNumber)

        holder.viewBinding.imageProfilePicture.setImageDrawable(null)
        if (contactData.profileDetails == null) {
            holder.viewBinding.imageProfilePicture.setImageResource(R.drawable.ic_profile)
            holder.viewBinding.phoneIcon.setImageResource(R.drawable.ic_phone_call_icon)
            holder.viewBinding.textInviteContact.show()
            holder.viewBinding.textAddContact.show()
            holder.viewBinding.imageVideoCall.gone()
            holder.viewBinding.imageAudioCall.gone()
        } else {
            if (isOwnJid(contactData.profileDetails.jid)) {
                MediaUtils.loadImageWithGlideSecure(context, SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
                    holder.viewBinding.imageProfilePicture, ContextCompat.getDrawable(context, R.drawable.ic_contact_img))
                holder.viewBinding.phoneIcon.setImageResource(R.drawable.ic_phone_call_icon)
                holder.viewBinding.textInviteContact.gone()
                holder.viewBinding.textAddContact.gone()
                holder.viewBinding.imageVideoCall.gone()
                holder.viewBinding.imageAudioCall.gone()
            } else {
                if (contactData.isAppUser) {
                    holder.viewBinding.imageProfilePicture.loadUserProfileImage(context, contactData.profileDetails)
                    holder.viewBinding.phoneIcon.setImageResource(R.drawable.ic_contact_message)
                    holder.viewBinding.textInviteContact.gone()
                    holder.viewBinding.imageVideoCall.show()
                    holder.viewBinding.imageAudioCall.show()

                    holder.viewBinding.imageVideoCall.setOnClickListener { clickListener.onVideoCallClick(contactData) }
                    holder.viewBinding.imageAudioCall.setOnClickListener { clickListener.onAudioCallClick(contactData) }
                    holder.viewBinding.phoneIcon.setOnClickListener { clickListener.onMessageClick(contactData) }
                    holder.viewBinding.mobileNumberLayout.setOnClickListener { clickListener.onMessageClick(contactData) }

                } else {
                    holder.viewBinding.imageProfilePicture.setImageResource(R.drawable.ic_profile)
                    holder.viewBinding.phoneIcon.setImageResource(R.drawable.ic_phone_call_icon)
                    holder.viewBinding.textInviteContact.show()
                    holder.viewBinding.imageVideoCall.gone()
                    holder.viewBinding.imageAudioCall.gone()
                }
                if (!contactData.profileDetails.isItSavedContact() || contactData.profileDetails.isEmailContact()) {
                    holder.viewBinding.textAddContact.show()
                } else {
                    holder.viewBinding.textAddContact.gone()
                }
            }
        }

        holder.viewBinding.textInviteContact.setOnClickListener { clickListener.onInviteButtonClick(contactData) }
        holder.viewBinding.textAddContact.setOnClickListener { clickListener.onSaveButtonClick(contactData) }

    }

    private fun isOwnJid(jid: String) = jid == SharedPreferenceManager.getCurrentUserJid()

    override fun getItemCount() = list.size

    class SelectContactMessageViewHolder(var viewBinding: SelectContactMessageItemBinding) : BaseViewHolder(viewBinding.root)
}

data class ContactSelectionModel(var contactName: String?, var contactNumber: String?, var isAppUser: Boolean, val profileDetails: ProfileDetails?)

interface ContactChatOnClickListener {
    fun onSaveButtonClick(contactData: ContactSelectionModel)
    fun onInviteButtonClick(contactData: ContactSelectionModel)
    fun onVideoCallClick(contactData: ContactSelectionModel)
    fun onAudioCallClick(contactData: ContactSelectionModel)
    fun onMessageClick(contactData: ContactSelectionModel)
}



