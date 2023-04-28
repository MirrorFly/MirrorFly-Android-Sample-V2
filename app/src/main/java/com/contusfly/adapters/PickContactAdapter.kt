package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.mirrorflysdk.models.Contact

/**
 * Which used to display the contacts to pick it for the contact share from the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class PickContactAdapter(private val context: Context) : RecyclerView.Adapter<PickContactAdapter.ContactViewHolder>() {
    /**
     * The rosters list for the recycler view.
     */
    private var contacts: List<Contact>? = null

    /**
     * Sets the contact data.
     *
     * @param contacts List of contact
     */
    fun setContacts(contacts: List<Contact>?) {
        this.contacts = contacts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return ContactViewHolder(inflater.inflate(R.layout.row_pick_contact, parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contacts!![position]
        holder.txtNumber.text = item.contactNos

        // Check number of contacts to show select option
        if (contacts!!.size == 1) {
            holder.checkBox.visibility = View.GONE
            holder.noDivider.visibility = View.GONE
        } else {
            holder.noDivider.visibility = View.VISIBLE
            holder.checkBox.isChecked = item.selected == 1
        }
        holder.viewRow.setOnClickListener { v: View? ->
            if (contacts!!.size > 1) {
                val selection = if (item.selected == 1) 0 else 1
                item.selected = selection
                holder.checkBox.isChecked = selection == 1
            }
        }
    }

    override fun getItemCount(): Int {
        return contacts!!.size
    }

    /**
     * The Class ContactSentViewHolder for the properties in the contact view
     */
    inner class ContactViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        /**
         * The txt number of the user.
         */
        val txtNumber: TextView

        /**
         * The check box to choose the contact.
         */
        val checkBox: CheckBox

        /**
         * The view row of the contact
         */
        val viewRow: View
        var noDivider: View

        /**
         * Instantiates a new view holder.
         *
         * @param view Instance of the view
         */
        init {
            txtNumber = view.findViewById(R.id.text_number)
            checkBox = view.findViewById(R.id.checkbox_user)
            viewRow = view.findViewById(R.id.view_number)
            noDivider = view.findViewById(R.id.no_divider)
        }
    }
}