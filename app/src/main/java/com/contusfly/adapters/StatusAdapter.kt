package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.api.models.BusyStatus
import com.mirrorflysdk.utils.Utils

/**
 * This class is used to display the status in the status list view. get status list and display in
 * the list.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class StatusAdapter(context: Context) : BaseAdapter() {
    /**
     * The inflater for inflating the views.
     */
    private val inflater: LayoutInflater

    /**
     * The status list.
     */
    private var statusList: List<BusyStatus>? = null

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
    fun setStatus(status: List<BusyStatus>?, defaultStatus: String?) {
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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view:View? = convertView
        if (view == null) view = inflater.inflate(R.layout.row_status, parent, false)
        val txtView: CustomTextView = view!!.findViewById(R.id.rowTextView)
        try {
            var status = statusList!![position].status
            /*
              Check the status change to show/hide view
             */txtView.isEnabled = defaultStatus == status
            if(txtView.isEnabled)
                txtView.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_green_tick,0)
            else
                txtView.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            status = Utils.getUtfDecodedText(status)
            txtView.text = status
        } catch (e: Exception) {
            LogMessage.e(e)
        }
        return view!!
    }

    /**
     * Instantiates a new adapter status.
     *
     * @param context Instance of the context
     */
    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}
