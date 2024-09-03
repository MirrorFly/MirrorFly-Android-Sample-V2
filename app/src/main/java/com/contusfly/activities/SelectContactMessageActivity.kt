package com.contusfly.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.R
import com.contusfly.adapters.ContactChatOnClickListener
import com.contusfly.adapters.ContactSelectionModel
import com.contusfly.adapters.SelectContactMessageAdapter
import com.contusfly.applySrcInColorFilter
import com.contusfly.call.CallPermissionUtils
import com.contusfly.chat.InviteContactUtils
import com.contusfly.databinding.ActivitySelectContactMessageBinding
import com.contusfly.utils.*
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.contusfly.libPhone.PhoneNumberUtil

class SelectContactMessageActivity : BaseActivity(), ContactChatOnClickListener,
    CommonAlertDialog.CommonDialogClosedListener {
    private lateinit var binding: ActivitySelectContactMessageBinding
    private lateinit var emptyView: TextView
    private var contactsList = ArrayList<ContactSelectionModel>()
    private val commonAlertDialog: CommonAlertDialog by lazy { CommonAlertDialog(this) }
    private var selectedContactNumber: String? = null

    private lateinit var profileDetails: ProfileDetails

    private lateinit var messageId: String

    private val phoneNumberUtil: PhoneNumberUtil by lazy { PhoneNumberUtil.createInstance(this) }

    private val videoCallPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        if (!permissions.containsValue(false))
            CallPermissionUtils(this, profileDetails.isBlocked, profileDetails.isAdminBlocked, arrayListOf(profileDetails.jid), "", false).videoCall()
    }

    private val audioCallPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        if (!permissions.containsValue(false))
            CallPermissionUtils(this, profileDetails.isBlocked, profileDetails.isAdminBlocked, arrayListOf(profileDetails.jid), "", false).audioCall()
    }

    private val permissionAlertDialog : PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectContactMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        messageId = intent.getStringExtra(Constants.MESSAGE_ID) ?: Constants.EMPTY_STRING

        getMessageData(messageId)
        initViews()
        setUpListeners()
    }

    private fun getMessageData(messageId: String) {
        contactsList.clear()
        FlyMessenger.getMessageOfId(messageId)?.let {
            val contactData = it.contactChatMessage
            for (i in it.contactChatMessage.contactPhoneNumbers.indices) {
                val userJid = ChatUtils.getJidFromPhoneNumber(phoneNumberUtil, contactData.contactPhoneNumbers[i], if (countryCode.isEmpty()) "IN" else countryCode) ?: Constants.EMPTY_STRING
                contactsList.add(ContactSelectionModel(contactData.contactName, contactData.contactPhoneNumbers[i], contactData.isChatAppUser[i], ProfileDetailsUtils.getProfileDetails(userJid)))
            }
        }
    }

    private fun initToolBar() {
        setSupportActionBar(binding.toolBar.toolbar)
        supportActionBar?.title = getString(R.string.view_contacts)
        UserInterfaceUtils.setUpToolBar(this, binding.toolBar.toolbar, supportActionBar, getString(R.string.view_contacts))
        binding.toolBar.toolbar.navigationIcon?.applySrcInColorFilter(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color))
    }

    private fun initViews() {
        initToolBar()

        emptyView = binding.noContactsMessage
        binding.recyclerView.apply {
            adapter = SelectContactMessageAdapter(this@SelectContactMessageActivity, contactsList, this@SelectContactMessageActivity)
            setEmptyView(emptyView)
        }
    }

    private fun setUpListeners() {
        commonAlertDialog.setOnDialogCloseListener(this)
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        //No Implementation needed
    }

    override fun listOptionSelected(position: Int) {
        if (commonAlertDialog.dialogAction == CommonAlertDialog.DialogAction.INVITE) {
            InviteContactUtils.handleSelectedOptions(position, this, null, selectedContactNumber)
            selectedContactNumber = ""
        }
    }

    companion object {
        val countryCode = SharedPreferenceManager.getString(Constants.COUNTRY_CODE)
    }

    override fun onSaveButtonClick(contactData: ContactSelectionModel) {
        CommonUtils.addContactInMobile(this, contactData.contactNumber!!, contactData.contactName.toString())
    }

    override fun onInviteButtonClick(contactData: ContactSelectionModel) {
        selectedContactNumber = contactData.contactNumber
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.INVITE
        commonAlertDialog.showListDialog(this.getString(R.string.title_invite_friend), this.resources.getStringArray(R.array.array_invite_contact))
    }

    override fun onVideoCallClick(contactData: ContactSelectionModel) {
        if (CallManager.isVideoCallPermissionsGranted(skipBlueToothPermission = false)) {
            CallPermissionUtils(this, contactData.profileDetails?.isBlocked ?: false,
                contactData.profileDetails?.isAdminBlocked ?: false, arrayListOf(contactData.profileDetails?.jid ?: ""), "", false).videoCall()
        } else {
            profileDetails = contactData.profileDetails!!
            MediaPermissions.requestVideoCallPermissions((activity as Activity), permissionAlertDialog, videoCallPermissionLauncher)
        }
    }

    override fun onAudioCallClick(contactData: ContactSelectionModel) {
        if (CallManager.isAudioCallPermissionsGranted(skipBlueToothPermission = false)) {
            CallPermissionUtils(this, contactData.profileDetails?.isBlocked ?: false,
                contactData.profileDetails?.isAdminBlocked ?: false, arrayListOf(contactData.profileDetails?.jid ?: ""), "", false).audioCall()
        } else {
            profileDetails = contactData.profileDetails!!
            MediaPermissions.requestAudioCallPermissions((activity as Activity), permissionAlertDialog, audioCallPermissionLauncher)
        }
    }

    override fun onMessageClick(contactData: ContactSelectionModel) {
        finish()
        startActivity(Intent(this, ChatActivity::class.java).putExtra(LibConstants.JID, contactData.profileDetails?.jid).putExtra(Constants.CHAT_TYPE, ChatType.TYPE_CHAT))
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        if (isSuccess){
            getMessageData(messageId)
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }
    }
}
