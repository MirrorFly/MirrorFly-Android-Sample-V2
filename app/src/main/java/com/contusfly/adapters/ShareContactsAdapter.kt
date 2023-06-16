package com.contusfly.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.models.ContactShareModel
import com.contusfly.views.CustomRecyclerView
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.utils.Utils
import java.util.*

/**
 * Which used to display the contacts to pick it for the contact share from the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class ShareContactsAdapter(private val context: Context, cm: ArrayList<ContactShareModel>) : RecyclerView.Adapter<ShareContactsAdapter.ContactViewHolder>() {
    /**
     * The rosters list for the recycler view.
     */
    private var contacts: List<ContactShareModel>

    /**
     * Sets the contact data.
     *
     * @param contacts List of contact
     */
    fun setContacts(contacts: List<ContactShareModel>) {
        this.contacts = contacts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return ContactViewHolder(inflater.inflate(R.layout.share_contacts_row_item, parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contacts[position]
        holder.txtName.text = item.name
        val pickContactAdapter = PickContactAdapter(holder.itemView.context)
        pickContactAdapter.setContacts(item.contactArrayList)
        holder.phoneNumbersRecyclerView.adapter = pickContactAdapter
        Log.d("onBindViewHolder", Utils.getGSONInstance().toJson(item))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    /**
     * The Class ContactSentViewHolder for the properties in the contact view
     */
    inner class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /**
         * The txt name of the user.
         */
        var txtName: CustomTextView

        /**
         * The RecyclerView which holds list of phone numbers
         */
        var phoneNumbersRecyclerView: CustomRecyclerView

        /**
         * Instantiates a new view holder.
         *
         * @param view Instance of the view
         */
        init {
            txtName = view.findViewById(R.id.text_name)
            phoneNumbersRecyclerView = view.findViewById(R.id.view_list_numbers)
        }
    }

    /**
     * Instantiates a new adapter contacts.
     *
     * @param context Instance of the startupActivityContext
     */
    init {
        contacts = cm
    }
}