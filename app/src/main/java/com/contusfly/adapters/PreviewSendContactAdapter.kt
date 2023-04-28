package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.databinding.RowPreviewSendContactBinding
import com.contusfly.loadUserProfileImage
import com.contusfly.models.DeviceContactModel

class PreviewSendContactAdapter(private val context: Context, private val contactList:List<DeviceContactModel>) : RecyclerView.Adapter<PreviewSendContactAdapter.PreviewSendContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewSendContactViewHolder {
        val binding = RowPreviewSendContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PreviewSendContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PreviewSendContactViewHolder, position: Int) {
        val contact = contactList[position]
        setProfileDetails(holder, contact)
        setMobileNumber(holder, contact)
    }

    private fun setMobileNumber(holder: PreviewSendContactViewHolder, contact: DeviceContactModel) {
        holder.rowPreviewSendContactBinding.recyclerviewPhoneNumber.apply {
            adapter = PreviewPhoneNumberAdapter(contact.mobileNumbers)
        }
    }

    private fun setProfileDetails(holder: PreviewSendContactViewHolder, contactModel: DeviceContactModel) {
        holder.rowPreviewSendContactBinding.textContactName.text = contactModel.name
        holder.rowPreviewSendContactBinding.imageProfilePicture.setImageDrawable(null)
        if (contactModel.profileDetails == null)
            holder.rowPreviewSendContactBinding.imageProfilePicture.setImageResource(R.drawable.ic_profile)
        else
            holder.rowPreviewSendContactBinding.imageProfilePicture.loadUserProfileImage(context, contactModel.profileDetails!!)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class PreviewSendContactViewHolder(var rowPreviewSendContactBinding: RowPreviewSendContactBinding) : RecyclerView.ViewHolder(rowPreviewSendContactBinding.root)

}