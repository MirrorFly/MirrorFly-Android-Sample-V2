package com.contusfly.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.databinding.RowPreviewMobileNumberBinding
import com.contusfly.gone
import com.contusfly.models.PhoneNumber
import com.contusfly.show

class PreviewPhoneNumberAdapter(private val mobileNumbers:List<PhoneNumber>) : RecyclerView.Adapter<PreviewPhoneNumberAdapter.PreviewPhoneNumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewPhoneNumberViewHolder {
        val binding = RowPreviewMobileNumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PreviewPhoneNumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PreviewPhoneNumberViewHolder, position: Int) {
        val number = mobileNumbers[position]
        holder.rowPreviewMobileNumberBinding.mobileNumber.text = number.phoneNumber
        holder.rowPreviewMobileNumberBinding.numberType.text = number.numberType

        holder.rowPreviewMobileNumberBinding.checkSelection.isChecked = number.isSelected

        if (itemCount == 1) {
            holder.rowPreviewMobileNumberBinding.checkSelection.gone()
        } else {
            holder.rowPreviewMobileNumberBinding.checkSelection.show()
            val onClickListener = View.OnClickListener { handleNumberSelection(number, holder) }
            holder.rowPreviewMobileNumberBinding.checkSelection.setOnClickListener(onClickListener)
            holder.rowPreviewMobileNumberBinding.rootLayout.setOnClickListener(onClickListener)
        }
    }

    private fun handleNumberSelection(number: PhoneNumber, holder: PreviewPhoneNumberViewHolder) {
        number.isSelected = !number.isSelected
        holder.rowPreviewMobileNumberBinding.checkSelection.isChecked = number.isSelected
    }

    override fun getItemCount(): Int {
        return mobileNumbers.size
    }

    class PreviewPhoneNumberViewHolder(var rowPreviewMobileNumberBinding: RowPreviewMobileNumberBinding) : RecyclerView.ViewHolder(rowPreviewMobileNumberBinding.root)

}