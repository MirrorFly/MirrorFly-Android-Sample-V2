package com.contusfly.activities

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.os.SystemClock
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.*
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.TAG
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.R
import com.contusfly.BuildConfig
import com.contusfly.adapters.ContactsAdapter
import com.contusfly.checkInternetAndExecute
import com.contusfly.databinding.ActivityNewContactsBinding
import com.contusfly.fragments.ProfileDialogFragment
import com.contusfly.utils.*
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.utils.UserInterfaceUtils
import com.contusfly.viewmodels.ContactViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomAlertDialog
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class NewContactsActivity : BaseActivity(), CoroutineScope, CommonAlertDialog.CommonDialogClosedListener {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    var users: ArrayList<ProfileDetails>? = null

    private lateinit var newContactsBinding: ActivityNewContactsBinding

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private lateinit var mAdapter: ContactsAdapter

    private var multiSelection = false

    private var isMakeCall = false

    private var callType: String? = null

    private var addParticipants = false

    private var fromGroupInfo = false

    private var screenTitle: String = emptyStringFE()

    /**
     * Used for search
     */
    private var searchKey: String = emptyString()

    /**
     * Store onclick time to avoid double click
     */
    private var lastClickTime: Long = 0

    private var groupId:String? = null

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private var commonAlertDialog: CommonAlertDialog? = null

    private var profileDetails:ProfileDetails ?= null

    private  var dialogFragment:ProfileDialogFragment? = null

    private val viewModel by lazy {
        ViewModelProvider(this).get(ContactViewModel::class.java)
    }

    private val contactPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val contactPermissionGranted = permissions[Manifest.permission.READ_CONTACTS] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_CONTACTS)

        if(contactPermissionGranted) {
            syncContacts()
            viewModel.checkContactsUpdate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newContactsBinding = ActivityNewContactsBinding.inflate(layoutInflater)
        setContentView(newContactsBinding.root)
        screenTitle = if (intent.hasExtra(Constants.TITLE)) intent.getStringExtra(Constants.TITLE)!! else getString(R.string.title_contacts)
        addParticipants = intent.getBooleanExtra(Constants.ADD_PARTICIAPANTS, false)
        fromGroupInfo = intent.getBooleanExtra(Constants.FROM_GROUP_INFO, false)
        groupId = intent.getStringExtra(Constants.GROUP_ID)
        multiSelection = intent.getBooleanExtra(Constants.MULTI_SELECTION, addParticipants)
        isMakeCall = intent.getBooleanExtra(Constants.IS_MAKE_CALL, false)
        callType = intent.getStringExtra(Constants.CALL_TYPE)
        setUpToolBar()
        initViews()
        setObservers()
        observeContactSyncStatus()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.contact_menu, menu)

        val menuItem = menu?.findItem(R.id.action_search)
        val mSearchView = menu?.findItem(R.id.action_search)?.actionView as SearchView

        val actionItem = menu.get(R.id.action_done)
        val settingsItem = menu.get(R.id.action_settings)
        val refreshItem = menu.get(R.id.action_refresh)

        refreshItem.isVisible = BuildConfig.CONTACT_SYNC_ENABLED
        when {
            addParticipants -> {
                if(fromGroupInfo){
                    actionItem.title = getString(R.string.label_next)
                }else{
                    actionItem.title = getString(R.string.label_create)
                }
                settingsItem.hide()
            }
            isMakeCall -> {
                actionItem.hide()
                settingsItem.hide()
                refreshItem.hide()
            }
            else -> {
                actionItem.hide()
            }
        }

        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(searchString: String): Boolean {
                searchKey = searchString.trim()
                mAdapter.filter.filter(searchKey)
                return true
            }
        })

        menuItem?.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                if (!addParticipants) mSearchView.maxWidth = Integer.MAX_VALUE
                closeMenuOption(menu)
                setEmptyView(true)
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                showMenuOption(menu)
                setEmptyView(false)
                return true
            }
        })
        return true

    }

    private fun setEmptyView(b: Boolean) {
        searchKey = emptyString()
        if (b) {
            val emptyView: TextView = newContactsBinding.emptyList.textEmptyView
            emptyView.text = getString(R.string.msg_no_results)
            emptyView.setTextColor(ResourcesCompat.getColor(resources, R.color.color_text_no_list, null))
            emptyView.show()
            newContactsBinding.viewListContacts.setEmptyView(emptyView)
        } else {
            newContactsBinding.emptyList.textEmptyView.gone()
            newContactsBinding.viewListContacts.setEmptyView(newContactsBinding.noContactsView.root)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }

    private fun showMenuOption(menu: Menu): Boolean {
        with(menu) {
            get(R.id.action_done).isVisible = addParticipants
            get(R.id.action_settings).isVisible = !addParticipants && !isMakeCall
            get(R.id.action_refresh).isVisible = BuildConfig.CONTACT_SYNC_ENABLED  && !isMakeCall
        }
        super.onPrepareOptionsMenu(menu)
        return true
    }

    private fun closeMenuOption(menu: Menu): Boolean {
        with(menu) {
            get(R.id.action_settings).hide()
            get(R.id.action_refresh).hide()
            if (!addParticipants) get(R.id.action_done).hide()
        }
        super.onPrepareOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            R.id.action_refresh -> {
                checkContactPermissionAndSync()
                true
            }
            R.id.action_done -> {
                if (addParticipants) {
                    if (viewModel.selectedUsersJid.size < 2 && !fromGroupInfo) {
                        showToast("Add at least two contacts")
                    } else {
                        if (!ChatManager.getAvailableFeatures().isGroupChatEnabled){
                            CustomAlertDialog().showFeatureRestrictionAlert(this)
                        } else {
                            val output = Intent().apply {
                                putStringArrayListExtra(Constants.USERS_JID, viewModel.selectedUsersJid)
                            }
                            setResult(RESULT_OK, output)
                            finish()
                        }
                    }
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpToolBar() {
        setSupportActionBar(newContactsBinding.toolbar)
        supportActionBar?.title = screenTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        UserInterfaceUtils.initializeCustomToolbar(this, newContactsBinding.toolbar)
        newContactsBinding.toolbar.navigationIcon?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color), BlendModeCompat.SRC_ATOP)
    }

    private fun initViews() {
        commonAlertDialog = CommonAlertDialog(this)
        commonAlertDialog!!.setOnDialogCloseListener(this)
        mAdapter = ContactsAdapter(
            this, commonAlertDialog!!,
            multiSelection,
            viewModel.contactListAdapter,
            isMakeCall) { _: Int, profileClicked: Boolean, profile: ProfileDetails ->
            listItemClicked(profileClicked, profile)
        }
        mAdapter.setHasStableIds(true)

        newContactsBinding.viewListContacts.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            itemAnimator = null
            adapter = mAdapter
        }
        if (isMakeCall && !callType.isNullOrEmpty()) {
            newContactsBinding.buttonMakeCall.gone()
            newContactsBinding.buttonMakeCall.text = String.format(getString(R.string.action_call_now), viewModel.selectedUsersJid.size)
            if (callType.equals(CallType.VIDEO_CALL)) {
                newContactsBinding.buttonMakeCall.icon = ContextCompat.getDrawable(this, R.drawable.ic_fab_video_call)
            } else {
                newContactsBinding.buttonMakeCall.icon = ContextCompat.getDrawable(this, R.drawable.ic_fab_voice_call)
            }
            newContactsBinding.buttonMakeCall.setOnClickListener(1000) {
                makeCall()
            }
        } else {
            newContactsBinding.buttonMakeCall.gone()
        }
        setListeners()
        setRefreshContacts()
    }

    private fun makeCall() {
        if (!groupId.isNullOrBlank() || viewModel.selectedUsersJid.size > 1) {
            if (!ChatManager.getAvailableFeatures().isGroupCallEnabled) {
                CustomAlertDialog().showFeatureRestrictionAlert(this)
                return
            }
        } else {
            if (!ChatManager.getAvailableFeatures().isOneToOneCallEnabled) {
                CustomAlertDialog().showFeatureRestrictionAlert(this)
                return
            }
        }
        checkInternetAndExecute {
            val output = Intent().apply {
                putStringArrayListExtra(Constants.USERS_JID, viewModel.selectedUsersJid)
                putExtra(Constants.CALL_TYPE, callType)
            }
            setResult(RESULT_OK, output)
            finish()
        }
    }

    /* Contacts will get refresh if email changed in profile setting */
    private fun setRefreshContacts(){
        if(SharedPreferenceManager.getBoolean(Constants.IS_PROFILE_UPDATED)) {
            refreshContacts()
            SharedPreferenceManager.setBoolean(Constants.IS_PROFILE_UPDATED, false)
        }
    }

    private fun setListeners(){
        newContactsBinding.swipeToRefreshLayout.setOnRefreshListener {
            checkContactPermissionAndSync()
            newContactsBinding.swipeToRefreshLayout.isRefreshing = false
        }
    }

    private fun setObservers() {
        viewModel.contactDiffResult.observe(this) {
            // Retrieve the selected profiles state
            retrievedSelectedProfilesState()

            // Save Current Scroll state to retain scroll position after DiffUtils Applied
            val previousState = newContactsBinding.viewListContacts.layoutManager?.onSaveInstanceState() as Parcelable
            it.dispatchUpdatesTo(mAdapter)
            newContactsBinding.viewListContacts.layoutManager?.onRestoreInstanceState(previousState)
            //To handle search result while user profiles updated
            newContactsBinding.viewListContacts.post {
                if (searchKey.isNotEmpty()) {
                    mAdapter.filter.filter(searchKey)
                }
            }
            newContactsBinding.viewListContacts.setEmptyView(newContactsBinding.noContactsView.root)
        }
    }

    private fun retrievedSelectedProfilesState() {
        if (viewModel.selectedUsersJid.isNotEmpty()) {
            viewModel.selectedUsersJid.forEach {
                val isJidSelected = viewModel.contactListAdapter.any { profileDetails -> profileDetails.jid == it  }
                val index = viewModel.contactListAdapter.indexOfFirst { profileDetails -> profileDetails.jid == it }
                if (isJidSelected && index.isValidIndex()) {
                    viewModel.contactListAdapter[index].isSelected = true
                }
            }
        }
    }

    private fun observeContactSyncStatus() {
        FlyCore.contactSyncState.observe(this) {
            when (it) {
                is Result.Error -> {
                    newContactsBinding.progressSpinner.gone()
                }
                is Result.InProgress -> {
                    newContactsBinding.progressSpinner.show()
                }
                else -> {
                    //Not Needed
                }
            }
        }
    }

    private fun updateContactsList() {
        viewModel.getContactList(fromGroupInfo, groupId)
    }

    private fun listItemClicked(profileClicked : Boolean, profile: ProfileDetails) {
        if (multiSelection) {
            handleMultiSelection(profile)
        } else {
            if(profileClicked){
                if (SystemClock.elapsedRealtime() - lastClickTime < 1000)
                    return
                lastClickTime = SystemClock.elapsedRealtime()
                this.profileDetails = profile
                dialogFragment = ProfileDialogFragment.newInstance(ProfileDetailsUtils.getProfileDetails(profile.jid, profile.isUnknownContact())!!)
                val ft = supportFragmentManager.beginTransaction()
                val prev = supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null) {
                    ft.remove(prev)
                }
                ft.addToBackStack(null)
                dialogFragment!!.show(ft, "dialog")
            } else{
                startActivity(Intent(context, ChatActivity::class.java)
                    .putExtra(LibConstants.JID, profile.jid)
                    .putExtra(Constants.CHAT_TYPE, ChatType.TYPE_CHAT))
            }
        }
    }

    private fun handleMultiSelection(profile: ProfileDetails) {
        if (profile.isBlocked)
            return
        if (viewModel.selectedUsersJid.contains(profile.jid)) {
            viewModel.selectedUsersJid.remove(profile.jid)
        } else {
            viewModel.selectedUsersJid.add(profile.jid)
        }
        updateSelectedUserCallView(profile.jid)
    }

    private fun updateSelectedUserCallView(jid: String? = Constants.EMPTY_STRING) {
        if (isMakeCall) {
            newContactsBinding.buttonMakeCall.show()
            newContactsBinding.buttonMakeCall.isEnabled = viewModel.selectedUsersJid.size > 0
            if ((viewModel.selectedUsersJid.size + 1) > CallManager.getMaxCallUsersCount()) {
                if (jid!!.isNotEmpty())  viewModel.selectedUsersJid.remove(jid)
                newContactsBinding.buttonMakeCall.text =
                    String.format(getString(R.string.action_call_now), viewModel.selectedUsersJid.size)
                newContactsBinding.buttonMakeCall.isEnabled = true
                val message = String.format(
                    getString(com.contus.call.R.string.info_call_members_limit),
                    CallManager.getMaxCallUsersCount()
                )
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            } else {
                if (viewModel.selectedUsersJid.size == 0) newContactsBinding.buttonMakeCall.gone() else newContactsBinding.buttonMakeCall.show()
                newContactsBinding.buttonMakeCall.text = String.format(getString(R.string.action_call_now), viewModel.selectedUsersJid.size)
            }
        } else newContactsBinding.buttonMakeCall.gone()
    }

    override fun userDetailsUpdated() {
        super.userDetailsUpdated()
        updateContactsList()
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        updateUserProfileInfo(jid)
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        removeUserProfile(jid)
    }

    private fun removeUserProfile(jid: String) {
        val userIndex = viewModel.contactListAdapter.indexOfFirst { profile -> profile.jid == jid }
        if (userIndex.isValidIndex()) {
            viewModel.selectedUsersJid.remove(jid)
            viewModel.contactListAdapter.removeAt(userIndex)
            mAdapter.notifyItemRemoved(userIndex)
            mAdapter.filter.filter(searchKey)
        }
    }

    override fun userBlockedMe(jid: String) {
        super.userBlockedMe(jid)
        ContusContactUtils.refreshContusContact(jid)
        updateUserProfileInfo(jid)
    }

    override fun userUnBlockedMe(jid: String) {
        super.userUnBlockedMe(jid)
        ContusContactUtils.refreshContusContact(jid)
        updateUserProfileInfo(jid)
    }

    private fun updateUserProfileInfo(jid: String) {
        try {
            val userIndex = viewModel.contactListAdapter.indexOfFirst { profile -> profile.jid == jid }
            if (userIndex.isValidIndex()) {
                val oldProfile = viewModel.contactListAdapter[userIndex]
                val updatedProfile = ProfileDetailsUtils.getProfileDetails(jid)!!
                updatedProfile.isSelected = oldProfile.isSelected
                viewModel.contactListAdapter[userIndex] = updatedProfile
                val bundle = Bundle()
                bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 2)
                mAdapter.notifyItemChanged(userIndex, bundle)
                newContactsBinding.viewListContacts.post {
                    if (searchKey.isNotBlank())
                        mAdapter.filter.filter(searchKey)
                }
                if (this.profileDetails != null && dialogFragment != null && dialogFragment!!.context != null && dialogFragment!!.profileDetails.jid == jid) {
                    dialogFragment!!.profileDetails = ProfileDetailsUtils.getProfileDetails(jid)!!
                    dialogFragment!!.refreshView()
                }
            } else {
                val updatedProfile = ProfileDetailsUtils.getProfileDetails(jid)!!
                if(!updatedProfile.isUnknownContact() && !updatedProfile.isDeletedContact() ) {
                    val list =
                        viewModel.contactDetailsList.value?.toMutableList() ?: mutableListOf()
                    list.add(updatedProfile)
                    val sortedList = ProfileDetailsUtils.sortProfileList(list)
                    val newIndex = sortedList.indexOfFirst { profile -> profile.jid == jid }
                    viewModel.contactListAdapter.add(newIndex, updatedProfile)
                    mAdapter.notifyItemInserted(newIndex)
                    mAdapter.filter.filter(searchKey)
                }
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            if (isSuccess && mAdapter.blockedUser.isNotEmpty()) {
                if (AppUtils.isNetConnected(this)) {
                    FlyCore.unblockUser(mAdapter.blockedUser) { isUnblocked, _, _ ->
                        if (isUnblocked) {
                            ContactUtils.checkEmailContactForBlockAndUnblockUser(mAdapter.blockedUser, false)
                            updateUserProfileInfo(mAdapter.blockedUser)
                            runOnUiThread { mAdapter.filter.filter(searchKey) }
                            mAdapter.blockedUser = emptyString()
                        } else {
                            CustomToast.show(this, Constants.ERROR_SERVER)
                            mAdapter.blockedUser = emptyString()
                        }
                    }
                } else {
                    CustomToast.show(this, getString(R.string.msg_no_internet))
                    mAdapter.blockedUser = emptyString()
                }
            } else {
                mAdapter.blockedUser = emptyString()
            }
        }
    }

    override fun listOptionSelected(position: Int) {
        //Do nothing
    }

    override fun onResume() {
        super.onResume()
        if (BuildConfig.CONTACT_SYNC_ENABLED) {
            if (viewModel.contactSyncNeeded.value != null && !viewModel.contactSyncNeeded.value!!)
                newContactsBinding.progressSpinner.gone()
            checkContactPermission()
        }
        updateContactsList()
    }

    private fun checkContactPermission() {
        if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)){
            syncContacts()
            if (syncNeeded)
                viewModel.checkContactsUpdate()
            else if (FlyCore.contactSyncState.value == Result.InProgress)
                newContactsBinding.progressSpinner.show()
        }
    }

    private fun syncContacts() {
        viewModel.contactSyncNeeded.observe(this, { syncNeeded ->
            LogMessage.i(TAG, "[Contact Sync] contactSyncNeeded: $syncNeeded ")
            if (syncNeeded && BuildConfig.CONTACT_SYNC_ENABLED) refreshContacts()
        })
        viewModel.isContactSyncSuccess.observe(this, {
            viewModel.getContactList(fromGroupInfo, groupId)
        })
    }

    private fun checkContactPermissionAndSync(){
        if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) {
            viewModel.contactSyncNeeded.value = true
        } else MediaPermissions.requestContactsReadPermission(
            this,
            permissionAlertDialog,
            contactPermissionLauncher,
            null)
    }

    private fun refreshContacts() {
        LogMessage.d(TAG, "[Contact Sync] refreshContacts()")
        if (AppUtils.isNetConnected(this)) {
            if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) {
                newContactsBinding.progressSpinner.show()
                newContactsBinding.swipeToRefreshLayout.isRefreshing = false
                if (FlyCore.contactSyncState.value != Result.InProgress) {
                    val s=SharedPreferenceManager.getBoolean(Constants.INITIAL_CONTACT_SYNC_DONE)
                    LogMessage.d(TAG, "[Contact Sync] refreshContacts()$s")
                    FlyCore.syncContacts(!SharedPreferenceManager.getBoolean(Constants.INITIAL_CONTACT_SYNC_DONE)) { success, _, _ ->
                        newContactsBinding.progressSpinner.gone()
                        viewModel.onContactSyncFinished(success)
                        viewModel.isContactSyncSuccess.value = true
                    }
                } else LogMessage.d(TAG, "[Contact Sync] Contact syncing is already in progress")
            } else {
                MediaPermissions.requestContactsReadPermission(
                    this,
                    permissionAlertDialog,
                    contactPermissionLauncher,
                    null)
                val email = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.EMAIL))
                if (ChatUtils.isContusUser(email))
                    EmailContactSyncService.start()
            }
        } else {
            showToast(getString(R.string.error_check_internet))
            viewModel.onContactSyncFinished(false)
        }
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        LogMessage.e(TAG, "checkContactPermission isSuccess: called2")
        if (!MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)){
            viewModel.getContactList(fromGroupInfo, groupId)
            LogMessage.e(TAG, "checkContactPermission isSuccess: called")
            return
        }
        if (isSuccess) {
            SharedPreferenceManager.setBoolean(Constants.INITIAL_CONTACT_SYNC_DONE, true)
            val email = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.EMAIL))
            if (ChatUtils.isContusUser(email))
                EmailContactSyncService.start()
            else
                finishContactSync(isSuccess)
        } else{
            finishContactSync(isSuccess)
        }
    }

    private fun finishContactSync(success: Boolean) {
        newContactsBinding.progressSpinner.gone()
        viewModel.onContactSyncFinished(success)
        viewModel.isContactSyncSuccess.value = true
    }

    override fun emailContactSyncCompleted() {
        super.emailContactSyncCompleted()
        finishContactSync(true)
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        if (jid == groupId && status && fromGroupInfo && type == ChatType.TYPE_GROUP_CHAT) {
            showToast(getString(R.string.group_block_message_label))
            startDashboardActivity()
        } else {
            if (status && viewModel.selectedUsersJid.contains(jid)) {
                viewModel.selectedUsersJid.remove(jid)
                updateSelectedUserCallView()
            }
            updateContactsList()
            for (selectedJid in viewModel.selectedUsersJid) {
                updateUserProfileInfo(selectedJid)
            }
        }
    }

    private fun startDashboardActivity() {
        val dashboardIntent = Intent(this, DashboardActivity::class.java)
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(dashboardIntent)
        finish()
    }
}