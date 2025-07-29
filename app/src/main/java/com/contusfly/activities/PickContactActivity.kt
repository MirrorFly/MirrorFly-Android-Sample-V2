package com.contusfly.activities

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.contusfly.AppLifecycleListener
import com.contusfly.R
import com.contusfly.adapters.PickContactAdapter
import com.contusfly.adapters.ShareContactsAdapter
import com.contusfly.chat.MessagingClient
import com.contusfly.chat.ShareMessagesController
import com.contusfly.models.ContactShareModel
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.UserInterfaceUtils
import com.contusfly.views.CustomRecyclerView
import com.contusfly.views.ShareDialog
import com.contusfly.views.WrapContentLayoutManager
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.models.Contact
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import dagger.android.AndroidInjection
import javax.inject.Inject

class PickContactActivity : BaseActivity() {
    /**
     * List of contactsList to set in the recycler view
     */
    private var contactsList: List<Contact>? = null
    private var shareContactList: ArrayList<ContactShareModel>? = null
    private var userIdList: ArrayList<String>? = null
    private var phoneNumbers: MutableList<String?>? = null
    private var isFromQuickShare = false
    @Inject
    lateinit var shareMessagesController: ShareMessagesController
    private var shareDialog: ShareDialog? = null

    /**
     * creating the layout
     *
     * @param savedInstanceState instance
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_contact)
    }

    override fun onResume() {
        super.onResume()
        AppLifecycleListener.isFromQuickShareForBioMetric = true
        AppLifecycleListener.isFromQuickShareForPin = true
    }

    /**
     * creating the views
     *
     * @param savedInstanceState instance
     */
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        isFromQuickShare = intent.getBooleanExtra("QUICK_SHARE", false)
        if (isFromQuickShare) {
            shareDialog = ShareDialog(this)
        }
        UserInterfaceUtils.setUpToolBar(this, toolbar, supportActionBar, "Share Contacts")
        val isList = intent.getBooleanExtra("LIST", false)
        val contactListRV = findViewById<CustomRecyclerView>(R.id.contacts_list)
        if (isList) {
            shareContactList = intent.getParcelableArrayListExtra("CONTACTS")
            userIdList = intent.getStringArrayListExtra("USERS")
            findViewById<View>(R.id.single_card).visibility = View.GONE
            val shareContactsAdapter = ShareContactsAdapter(this, shareContactList!!)
            contactListRV.adapter = shareContactsAdapter
        } else {
            val txtName = findViewById<TextView>(R.id.text_name)
            val listNumber = findViewById<CustomRecyclerView>(R.id.view_list_numbers)
            listNumber.layoutManager = WrapContentLayoutManager(this)
            val intent = intent
            contactsList = intent.getParcelableArrayListExtra(Constants.USERNAME)
            shareContactList = intent.getParcelableArrayListExtra("CONTACTS")
            var name = Utils.returnEmptyStringIfNull(contactsList!![0].contactName)
            if (name.isEmpty()) name = getString(R.string.title_unknown)
            txtName.text = name
            val pickContactAdapter = PickContactAdapter(this)
            pickContactAdapter.setContacts(contactsList)
            listNumber.adapter = pickContactAdapter
        }
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to .
     *
     * @param menu menu
     * @return menu
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (isFromQuickShare) {
            menuInflater.inflate(R.menu.menu_quick_share, menu)
        } else {
            menuInflater.inflate(R.menu.menu_edit, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }



    /**
     * Prepare the Screen's standard options menu to be displayed.  This is
     * called right before the menu is shown, every time it is shown.
     *
     * @param menu The options menu as last shown or first initialized by onCreateOptionsMenu().
     * @return You must return true for the menu to be displayed; if you return false it will not be shown.
     */
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        if (isFromQuickShare) {
            menu.findItem(R.id.action_share_delete).isVisible = false
        } else {
            val item = menu.findItem(R.id.action_edit)
            item.setIcon(R.drawable.ic_action_ok)
            item.title = getString(R.string.action_done)
            //Setting the color black
            for (i in 0 until menu.size()) {
                val currentItem = menu.getItem(i)
                if (currentItem.icon != null) {
                    currentItem?.icon?.setColorFilter(ContextCompat.getColor(this, R.color.text_color_black),
                            PorterDuff.Mode.MULTIPLY)
                }
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }



    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
     * @see .onCreateOptionsMenu
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (isFromQuickShare) {
            when (item.itemId) {
                R.id.action_share_share -> {
                    prepareAndSendContactMessage()
                    return true
                }
                R.id.action_share_cancel, android.R.id.home -> {
                    finishQuickShare()
                    return true
                }
            }
        } else {
            if (item.itemId == R.id.action_edit) validateSelection()
            if (item.itemId == android.R.id.home) CustomToast.show(this,"9090909090")
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Validate  the contact selection And send back to the chat view to send the contact to the
     * receiver.
     */
    private fun validateSelection() {
        val isSelected = isContactSelected
        if (isSelected) {
            readPhoneNumberActiveType()
            val intent = Intent()
            intent.putExtra(Constants.USERNAME, contactsList!![0].contactName)
            intent.putStringArrayListExtra(MessagingClient.INTENT_PHONE_NUMBERS, phoneNumbers as ArrayList<String?>?)
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else CustomToast.show(this, getString(com.contus.call.R.string.error_select_atleast_one))
    }

    /**
     * Get the contact is selected in the list
     *
     * @return boolean True if the contact is selected
     */
    private val isContactSelected: Boolean
        get() {
            var isSelected = false
            for (item in contactsList!!) {
                isSelected = item.selected == 1
                if (isSelected) break
            }
            return isSelected
        }

    /**
     * Reads the information about the active type of the phone numbers selected to be shared
     * in the chat window, whether the number is registered with the application or not.
     * Status of 1 represents that the number is registered with the application and vice-versa.
     */
    private fun readPhoneNumberActiveType() {
        phoneNumbers = ArrayList()
        for (i in contactsList!!.indices) {
            if (contactsList!![i].selected == 1) {
                phoneNumbers!!.add(contactsList!![i].contactNos)
            }
        }
    }

    private fun prepareAndSendContactMessage() {
        for (contactShareModel in shareContactList!!) {
            val finalContactList = ArrayList<Contact>()
            for (contact in contactShareModel.contactArrayList) {
                if (contact.selected == 1) finalContactList.add(contact)
            }
            contactShareModel.contactArrayList = finalContactList
        }
        val csmList = ArrayList<ContactShareModel>()
        for (csm in shareContactList!!) {
            if (csm.contactArrayList.isNotEmpty()) {
                csmList.add(csm)
            }
        }
        sendContacts(csmList)
    }

    private fun sendContacts(contactList: ArrayList<ContactShareModel>) {
        if (AppUtils.isNetConnected(this)) {
            shareDialog!!.initializeAndShowShareDialog("Quick Share", "Sending contacts...")
            shareMessagesController.sendContactMessage(contactList, userIdList!!) {
                shareDialog!!.dismissShareDialog()
                navigateToAppropriateScreen()
                finish()
            }
        } else {
            shareDialog!!.dismissShareDialog()
            CustomToast.show(this, getString(R.string.msg_no_internet))
        }
    }

    /**
     * If single user/group, then navigate to it's chat
     * if multiple then navigate to Dashboard screen
     */
    private fun navigateToAppropriateScreen() {
        if (userIdList!!.size == 1) {
            val userId = userIdList!![0]
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra(LibConstants.JID, userId)
            intent.putExtra(Constants.CHAT_TYPE, ProfileDetailsUtils.getProfileDetails(userId))
            startActivity(intent)
        } else if (userIdList!!.size > 1) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    private fun finishQuickShare() {
        AppLifecycleListener.isFromQuickShareForBioMetric = false
        AppLifecycleListener.isFromQuickShareForPin = false
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask()
        } else {
            finish()
        }
    }

    override fun onBackPressed() {
        if (isFromQuickShare) {
            finishQuickShare()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        AppLifecycleListener.isFromQuickShareForBioMetric = false
        AppLifecycleListener.isFromQuickShareForPin = false
    }
}