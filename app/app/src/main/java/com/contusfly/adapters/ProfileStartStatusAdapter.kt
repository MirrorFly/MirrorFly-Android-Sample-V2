package com.contusfly.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.databinding.RowStatusBinding
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.api.models.ProfileStatus
import com.mirrorflysdk.utils.Utils

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ProfileStartStatusAdapter(context: Context) : BaseAdapter() {

    /**
     * The status list.
     */
    private var statusList: MutableList<ProfileStatus>? = mutableListOf()

    /**
     * Default status for the application user
     */
    private var defaultStatus: String? = null

    /**
     * Set the status list list to set in the list view
     *
     * @param status        List of available status
     * @param defaultStatus Default status
     */
    fun setStatus(status: MutableList<ProfileStatus>, defaultStatus: String?) {
        statusList = status
        this.defaultStatus = defaultStatus
    }

    /**
     * List of Status
     *
     * @return size of status list
     */
    override fun getCount(): Int {
        return statusList!!.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = RowStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val txtView: CustomTextView = binding.rowTextView
        try {
            var status = statusList!![position].status
            /*
              Check the status change to show/hide view
             */
            txtView.isEnabled = defaultStatus == status
            status = Utils.getUtfDecodedText(status)
            txtView.text = status

            if (defaultStatus == status) {
                txtView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_green_tick, 0);
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
        return binding.root
    }
}