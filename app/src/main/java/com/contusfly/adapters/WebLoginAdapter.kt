package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.views.CircularImageView
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.flydatabase.model.WebLogin
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class WebLoginAdapter(context: Context) : RecyclerView.Adapter<WebLoginAdapter.RecyclerViewHolder>() {

    /**
     * * The inflater for inflating the views.
     */
    private var layoutInflater: LayoutInflater? = null

    /**
     * The login list
     */
    private var dataProvider: List<WebLogin>? = null

    /**
     * The startupActivityContext of the user activity.
     */
    private var context: Context? = null

    /**
     * Instantiates
     *
     * @param context
     */
    init {
        this.context = context
    }

    /**
     * Initiate the Adapter class
     *
     * @param context      pass this activity startupActivityContext
     * @param dataProvider pass the list object
     */
    fun setAdapterData(dataProvider: List<WebLogin>?) {
        this.dataProvider = dataProvider
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View = layoutInflater!!.inflate(R.layout.row_web_login_entry, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.browserNameTextView.text = dataProvider!![position].webBrowserName
        holder.osVersionTextView.text = dataProvider!![position].lastLoginTime
        val bName = dataProvider!![position].webBrowserName.lowercase()
        when {
            bName.contains("chrome") -> {
                holder.circularImageView.setImageResource(R.drawable.ic_chrome)
            }
            bName.contains("edge") -> {
                holder.circularImageView.setImageResource(R.drawable.ic_edge_browser)
            }
            bName.contains("firefox") -> {
                holder.circularImageView.setImageResource(R.drawable.ic_mozilla)
            }
            bName.contains("safari") -> {
                holder.circularImageView.setImageResource(R.drawable.ic_safari)
            }
            bName.contains("ie") -> {
                holder.circularImageView.setImageResource(R.drawable.ic_ie)
            }
            bName.contains("opera") -> {
                holder.circularImageView.setImageResource(R.drawable.ic_opera)
            }
            bName.contains("uc") -> {
                holder.circularImageView.setImageResource(R.drawable.ic_uc)
            }
            else -> {
                holder.circularImageView.setImageResource(R.drawable.ic_default_browser)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataProvider!!.size
    }

    /**
     * The Class media view holder contains the browsername, OS version and imageview...
     */
    class RecyclerViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /**
         * CustomTextView display the BrowserName
         */
        val browserNameTextView: CustomTextView

        /**
         * CustomTextView display the osversion
         */
        val osVersionTextView: CustomTextView

        /**
         * CircularImageView display the image
         */
        val circularImageView: CircularImageView

        /**
         * Recycler View Holder
         *
         * @param itemView itemview
         */
        init {
            browserNameTextView = itemView.findViewById(R.id.text_browser_name)
            osVersionTextView = itemView.findViewById(R.id.text_os_version_name)
            circularImageView = itemView.findViewById(R.id.image_browser_icon)
        }
    }
}