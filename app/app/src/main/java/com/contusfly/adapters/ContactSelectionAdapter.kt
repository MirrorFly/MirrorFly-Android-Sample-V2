package com.contusfly.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.contusfly.*
import com.contusfly.databinding.RowContactSelectionItemBinding
import com.contusfly.models.DeviceContactModel
import com.contusfly.utils.Constants
import com.jakewharton.rxbinding3.view.clicks
import java.util.concurrent.TimeUnit

class ContactSelectionAdapter(private val context: Context, private val contactList: List<DeviceContactModel>, private val selectedList: MutableList<DeviceContactModel>)
    : GenericSearchAdapter<DeviceContactModel, ContactSelectionAdapter.ContactSelectionViewHolder>(contactList) {

    override fun setViewHolder(parent: ViewGroup): ContactSelectionViewHolder {
        val binding = RowContactSelectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactSelectionViewHolder(binding)
    }

    override fun onBindData(holder: ContactSelectionViewHolder, item: DeviceContactModel, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty())
            onBindViewHolder(holder, position)
        else {
            val bundle = payloads[0] as Bundle
            handlePayloads(bundle, holder, item)
        }
    }

    private fun handlePayloads(bundle: Bundle, holder: ContactSelectionViewHolder, item: DeviceContactModel) {
        for (key in bundle.keySet()) {
            if (key == Constants.NOTIFY_SELECTION){
                setSelectedIcon(holder, selectedList, item)
            }
        }
    }

    override fun onBindData(holder: ContactSelectionViewHolder, item: DeviceContactModel, position: Int) {
        setProfileDetails(holder, item)
        setSelectedIcon(holder, selectedList, item)

        holder.contactListItemBinding.rootLayout.clicks().throttleFirst(300, TimeUnit.MILLISECONDS).subscribe {
                val selected = if (selectedList.contains(item)) {
                    holder.contactListItemBinding.selectContactIcon.gone()
                    false
                } else {
                    if (selectedList.size >= Constants.MAX_CONTACT_SELECTION_COUNT) {
                        onContactMaxLimitReached(true)
                        false
                    } else {
                        holder.contactListItemBinding.selectContactIcon.show()
                        true
                    }
                }
                onContactItemClicked(item, selected)
            }
    }

    private fun setProfileDetails(holder: ContactSelectionViewHolder, contactModel: DeviceContactModel) {
        holder.contactListItemBinding.textContactName.text = contactModel.name
        holder.contactListItemBinding.imageProfilePicture.setImageDrawable(null)
        if (contactModel.profileDetails == null)
            holder.contactListItemBinding.imageProfilePicture.setImageResource(R.drawable.ic_profile)
        else
            holder.contactListItemBinding.imageProfilePicture.loadUserProfileImage(context, contactModel.profileDetails!!)

    }

    private fun setSelectedIcon(holder: ContactSelectionViewHolder, selectedList: MutableList<DeviceContactModel>, contactModel: DeviceContactModel) {
        if (selectedList.contains(contactModel))
            holder.contactListItemBinding.selectContactIcon.show()
        else
            holder.contactListItemBinding.selectContactIcon.gone()
    }

    fun onContactItemClicked(fn: (DeviceContactModel, Boolean) -> Unit) {
        onContactItemClicked = fn
    }

    fun onContactMaxLimitReached(fn: (Boolean) -> Unit) {
        onContactMaxLimitReached = fn
    }

    fun onContactRemoved(item: DeviceContactModel) {
        val index = contactList.indexOfFirst { it.contactId == item.contactId }
        if (index.isValidIndex()) {
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_SELECTION, 1)
            notifyItemChanged(index)
        }
    }

    class ContactSelectionViewHolder(var contactListItemBinding: RowContactSelectionItemBinding) : BaseViewHolder(contactListItemBinding.root)

    companion object {
        lateinit var onContactItemClicked: (DeviceContactModel, Boolean) -> Unit
        lateinit var onContactMaxLimitReached: (Boolean) -> Unit
    }

    override fun hasSearchKey(item: DeviceContactModel, filterKey: String): Boolean {
        return item.name.contains(filterKey, true)
    }
}