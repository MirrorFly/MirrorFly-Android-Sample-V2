package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.databinding.RowContactSelectedPreviewBinding
import com.contusfly.loadUserProfileImage
import com.contusfly.models.DeviceContactModel

class ContactSelectionPreviewAdapter(private val context: Context, private val selectedContactList: List<DeviceContactModel>) : RecyclerView.Adapter<ContactSelectionPreviewAdapter.ContactSelectedPreviewHolder>()  {


    class ContactSelectedPreviewHolder(var rowContactSelectedPreviewBinding: RowContactSelectedPreviewBinding) : RecyclerView.ViewHolder(rowContactSelectedPreviewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactSelectedPreviewHolder {
        val binding = RowContactSelectedPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactSelectedPreviewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactSelectedPreviewHolder, position: Int) {
        val contactModel = selectedContactList[position]
        setProfileDetails(holder, contactModel)

        holder.rowContactSelectedPreviewBinding.removeContactIcon.setOnClickListener {
            onContactRemoved(contactModel)
        }
    }

    private fun setProfileDetails(holder: ContactSelectedPreviewHolder, contactModel: DeviceContactModel) {
        holder.rowContactSelectedPreviewBinding.textContactName.text = contactModel.name
        holder.rowContactSelectedPreviewBinding.imageProfilePicture.setImageDrawable(null)
        if (contactModel.profileDetails == null)
            holder.rowContactSelectedPreviewBinding.imageProfilePicture.setImageResource(R.drawable.ic_profile)
        else
            holder.rowContactSelectedPreviewBinding.imageProfilePicture.loadUserProfileImage(context, contactModel.profileDetails!!)

    }

    override fun getItemCount(): Int {
        return selectedContactList.size
    }

    fun onContactRemoved(fn: (DeviceContactModel) -> Unit) {
        onContactRemoved = fn
    }

    companion object{
        lateinit var onContactRemoved:(DeviceContactModel) -> Unit
    }

}