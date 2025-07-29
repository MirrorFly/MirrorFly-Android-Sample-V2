package com.contusfly.call.groupcall

import android.app.Activity
import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycall.webrtc.api.CallManager.isOnTelephonyCall
import com.mirrorflysdk.flycall.call.utils.CallConstants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.*
import com.contusfly.activities.BaseActivity
import com.contusfly.call.CallPermissionUtils
import com.contusfly.call.groupcall.listeners.RecyclerViewUserItemClick
import com.contusfly.helpers.UserListType
import com.contusfly.interfaces.PermissionDialogListener
import com.contusfly.utils.FirebaseUtils.Companion.setAnalytics
import com.contusfly.utils.MediaPermissions
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.utils.UserInterfaceUtils
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomAlertDialog
import com.contusfly.views.CustomRecyclerView
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.views.CustomToast

/**
 * This class used to display the list of contacts from selected group in the Recycler view with
 * multi select option and then choose the list to the create group audio/video call.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 3.0
 */
class UsersSelectionActivity : BaseActivity(), View.OnClickListener, CommonAlertDialog.CommonDialogClosedListener {

    private lateinit var listRosters: CustomRecyclerView
    private lateinit var callNowTextView: TextView
    private lateinit var callNowLayout: RelativeLayout
    private lateinit var callNowIcon: ImageView
    private var handler: Handler? = null

    /**
     * Selected users from the search list.
     */
    var selectedList: java.util.ArrayList<String> = java.util.ArrayList()

    /**
     * Selected users
     */
    var selectedUsersList: ArrayList<String> = ArrayList()

    /**
     * The instance of the CommonAlertDialog
     */
    private val mDialog: CommonAlertDialog by lazy {
        CommonAlertDialog(this)
    }

    /**
     * The adapter of the contacts for group creation selection.
     */
    private val adapterUsers: UserSelectionAdapter by lazy {
        UserSelectionAdapter(this, false, mDialog, onItemClickListener)
    }

    private val adapterSearchUsers: UserSelectionAdapter by lazy {
        UserSelectionAdapter(this, false, mDialog, onItemClickListener)
    }

    /**
     * Used for search
     */
    private var searchString: String = emptyString()

    /**
     * Blocked user jid
     */
    private var blockedUserJid: String? = null

    /**
     * Search view of the list  of contacts.
     */
    private var searchKey: SearchView? = null

    private var mUserListType = UserListType.USER_LIST

    /**
     * The instance of the DoProgressDialog
     */
    private var progressDialog: ProgressDialog? = null

    /**
     * Validate if user block/unblock request sent
     */
    private var isUnblockRequested = false

    private lateinit var callType: String
    private lateinit var groupJid: String

    lateinit var callPermissionUtils: CallPermissionUtils

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val requestCallPermissions: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            // Do something if some permissions granted or denied
            if (!permissions.containsValue(false)) {
                if (callType == CallType.AUDIO_CALL) {
                    callPermissionUtils.audioCall()
                } else {
                    callPermissionUtils.videoCall()
                }
            } else {
                callNowLayout.isEnabled = true
            }
        }

    private val permissionDeniedListener = object : PermissionDialogListener {
        override fun onPositiveButtonClicked() {
            //Not Needed
        }

        override fun onNegativeButtonClicked() {
            callNowLayout.isEnabled = true
        }
    }
    /**
     * Display the list of profile details in the list
     */
    private var profileDetailsList: MutableList<ProfileDetails>? = null
    private var contusProfilesWithBlockedMe: List<ProfileDetails>? = null

    val onItemClickListener = object : RecyclerViewUserItemClick {
        override fun onItemClicked(position: Int, profileDetails: ProfileDetails) {
            if (!selectedList.contains(profileDetails.jid)) {
                if (selectedList.size +1 >= CallManager.getMaxCallUsersCount()) {
                    onUserSelectRestriction()
                } else {
                    selectedList.add(profileDetails.jid)
                }
            } else {
                selectedList.remove(profileDetails.jid)
            }
            callNowTextView.text = selectedUserCount
        }

        override fun onSelectBlockedUser(profileDetails: ProfileDetails) {
            showAlertDialog(this@UsersSelectionActivity, String.format(if (callType == CallType.AUDIO_CALL) getString(com.contus.call.R.string.msg_unblockGroupAudioCall) else getString(com.contus.call.R.string.msg_unblockGroupVideoCall), ProfileDetailsUtils.getDisplayName(profileDetails.jid)))
        }

        override fun isSelected(userId: String): Boolean {
            return selectedList.contains(userId)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_selection)
        setAnalytics("View", "Group Call Contact selection", "")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        UserInterfaceUtils.setUpToolBar(this, toolbar, supportActionBar, getString(com.contus.call.R.string.add_participants))
        handler = Handler(Looper.getMainLooper())

        /*
       * Populate the list for display the contacts
       */
        listRosters = findViewById<CustomRecyclerView>(R.id.view_contact_list)
        listRosters.layoutManager = LinearLayoutManager(this)
        val emptyView = findViewById<TextView>(R.id.text_empty_view)
        emptyView.text = getString(R.string.msg_no_contacts)
        listRosters.setEmptyView(emptyView)
        callNowTextView = findViewById(R.id.call_now_text_view)
        callNowLayout = findViewById(R.id.call_now_layout)
        callNowIcon = findViewById(R.id.call_now_icon)
        groupJid = intent.getStringExtra(Constants.GROUP_ID)!!
        callType = intent.getStringExtra(CallConstants.CALL_TYPE)!!

        checkCallIcon()
        callNowLayout.setOnClickListener(this)
        mDialog.setOnDialogCloseListener(this)

        // Initiate group call user selection
        callNowLayout.visibility = View.VISIBLE

        updateGroupMembersList()
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun updateGroupMembersList() {
        GroupManager.getGroupMembersList(false, groupJid) { isSuccess, _, data ->
            if (isSuccess) {
                val groupMembers: MutableList<ProfileDetails> = data.getData() as ArrayList<ProfileDetails>
                filterGroupMembers(groupMembers)

                if (contusProfilesWithBlockedMe != null) profileDetailsList!!.addAll(contusProfilesWithBlockedMe!!)

                profileDetailsList!!.sortWith { o1: ProfileDetails, o2: ProfileDetails ->
                    o1.getDisplayName().compareTo(o2.getDisplayName())
                }
                updateSelectionAdapter(profileDetailsList!!)
            }
        }
    }

    private fun updateSelectionAdapter(profileDetailsList: MutableList<ProfileDetails>) {
        adapterUsers.setProfileDetails(profileDetailsList)
        /*
         * if group users less than max user in call all the users will be  auto selected
         */
        if ((profileDetailsList.size + 1) <= CallManager.getMaxCallUsersCount()) {
            profileDetailsList.forEach { roster ->
                if (!roster.isBlocked) {
                    selectedList.add(roster.jid)
                }
            }
        }
        callNowTextView.text = selectedUserCount
        listRosters.adapter = adapterUsers
    }

    private fun filterGroupMembers(groupMembers: MutableList<ProfileDetails>){
        val filteredMembers = groupMembers.filter { it.jid != SharedPreferenceManager.getCurrentUserJid() }
            .toMutableList()
        profileDetailsList = mutableListOf()
        filteredMembers.forEach { contact ->
            if (!contact.isAdminBlocked) {
                profileDetailsList!!.add(contact)
            }
        }
    }

    /**
     * Set CallNow Icon based on call type
     */
    private fun checkCallIcon() {
        if (callType == CallType.VIDEO_CALL) {
            callNowIcon.setImageResource(com.contus.call.R.drawable.ic_video_call_button)
        } else {
            callNowIcon.setImageResource(com.contus.call.R.drawable.ic_phone_call_button)
        }
    }

    /**
     * On dialog closed.
     *
     * @param dialogType the dialog type
     * @param isSuccess  the is success
     */
    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            if (AppUtils.isNetConnected(this)) {
                progressDialog = ProgressDialog(this)
                progressDialog!!.show()
                FlyCore.unblockUser(blockedUserJid!!) { _, _, _ -> }
                isUnblockRequested = true
            } else CustomToast.show(this, getString(com.mirrorflysdk.R.string.fly_error_msg_no_internet))
        }
    }

    override fun listOptionSelected(position: Int) {
        //Do Nothing
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.contus.call.R.menu.menu_search_group_call, menu)
        searchKey = menu!!.findItem(R.id.action_search).actionView as SearchView
        searchKey!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                searchString = s.trim()
                if (searchString.isNotBlank()) {
                    adapterSearchUsers.resetSearch()
                    adapterSearchUsers.addProfileList(filterList(adapterUsers.profileDetailsList))
                }
                mUserListType = if (searchString.isEmpty()) {
                    UserListType.USER_LIST
                } else {
                    UserListType.SEARCH
                }
                setAdapterBasedOnSearchType()
                adapterSearchUsers.setSearchKey(searchString)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun filterList(profileDetailsList: java.util.ArrayList<ProfileDetails>): List<ProfileDetails> {
        return profileDetailsList.filter { it.getDisplayName().contains(searchString, true) }
    }

    private fun setAdapterBasedOnSearchType() {
        if (mUserListType == UserListType.USER_LIST && (listRosters.adapter as UserSelectionAdapter).getSearchKey().isNotBlank()) {
            listRosters.adapter = adapterUsers
        } else if (mUserListType == UserListType.SEARCH && (listRosters.adapter as UserSelectionAdapter).getSearchKey().isBlank()) {
            listRosters.adapter = adapterSearchUsers
        }
    }

    fun onUserSelectRestriction() {
        Toast.makeText(
            context,
            String.format(context!!.getString(com.contus.call.R.string.msg_user_call_limit), CallManager.getMaxCallUsersCount() - 1),
            Toast.LENGTH_SHORT
        ).show()
    }

    /**
     * Get Selected users count in CallNow button
     */
    private val selectedUserCount: String
        get() {
            return if (selectedList?.isEmpty() != false) {
                callNowLayout.isEnabled = false
                getString(com.contus.call.R.string.msg_no_selected_user_call)
            } else {
                callNowLayout.isEnabled = true
                String.format(getString(com.contus.call.R.string.msg_selected_user_call), selectedList.size)
            }
        }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.call_now_layout -> {
                checkTypeAndCall()
            }
        }
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        if (selectedList?.isEmpty() != null)
            selectedUsersList = selectedList
        updateGroupMembersList()
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        updateGroupMembersList()
    }

    /**
     * Make group call
     */
    private fun checkTypeAndCall() {
        if (selectedList.isNotEmpty()) {
            when {
                !AppUtils.isNetConnected(this) -> {
                    CustomToast.show(this, getString(com.mirrorflysdk.R.string.fly_error_msg_no_internet))
                }
                isOnTelephonyCall(this) -> {
                    showAlertDialog(this, getString(com.contus.call.R.string.msg_telephony_call_alert))
                }
                isOnAnyCall() -> {
                    showAlertDialog(this, getString(com.contus.call.R.string.msg_ongoing_call_alert_for_group_call))
                }
                else -> {
                    makeCall()
                }
            }
        } else {
            Toast.makeText(context, context!!.getString(com.contus.call.R.string.error_select_atleast_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun makeCall() {
        if (groupJid.isNotBlank() || selectedList.size > 1) {
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
        callNowLayout.isEnabled = false
        if (callType == CallType.AUDIO_CALL) {
            callPermissionUtils = CallPermissionUtils(this, false, false, selectedList, groupJid, true)
            if (CallManager.isAudioCallPermissionsGranted(skipBlueToothPermission = false)) {
                launchAudioCall()
            } else {
                MediaPermissions.requestAudioCallPermissions(
                    this,
                    permissionAlertDialog,
                    requestCallPermissions,
                    permissionDeniedListener
                )
            }
        } else {
            callPermissionUtils = CallPermissionUtils(this, false, false, selectedList, groupJid, true)
            if (CallManager.isVideoCallPermissionsGranted(skipBlueToothPermission = false)) {
                launchVideoCall()
            } else {
                MediaPermissions.requestVideoCallPermissions(
                    this,
                    permissionAlertDialog,
                    requestCallPermissions,
                    permissionDeniedListener
                )
            }
        }
    }

    private fun launchAudioCall(){
        if(CallManager.isNotificationPermissionsGranted()){
            callPermissionUtils.audioCall()
        } else {
            notificationPermissionChecking()
        }
    }

    private fun launchVideoCall(){
        if(CallManager.isNotificationPermissionsGranted()){
            callPermissionUtils.videoCall()
        } else {
            notificationPermissionChecking()
        }
    }

    private fun notificationPermissionChecking(){
        MediaPermissions.requestNotificationPermission(
            this,
            permissionAlertDialog,
            notificationPermissionLauncher,
            false,
            permissionDeniedListener)
    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (!permissions.containsValue(false)) {
                if (callType == CallType.AUDIO_CALL) {
                    launchAudioCall()
                } else {
                    launchVideoCall()
                }
            } else {
                callNowLayout.isEnabled = true
            }

    }



    override fun onResume() {
        super.onResume()
        selectedUserCount
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        LogMessage.d(TAG, "#onAdminBlockedStatus jid == $jid status == $status")
        //To avoid multiple callbacks
        handler?.postDelayed({
            val index = selectedList.indexOfFirst { it == jid }
            val isJidAvailable = selectedList.any { it == jid }
            if (status && isJidAvailable && index.isValidIndex()) {
                selectedList.removeAt(index)
            }
            selectedUsersList = selectedList
            updateGroupMembersList()
        }, 500)
    }


    override fun onSuperAdminDeleteGroup(groupJid: String, groupName: String) {
        super.onSuperAdminDeleteGroup(groupJid, groupName)
        clearDeletedGroupChatNotification(groupJid, context)
        if(groupJid == this.groupJid){
            showToast(getString(R.string.deleted_by_super_admin, groupName))
            setResult(Activity.RESULT_FIRST_USER)
            startDashboardActivity(this)
            finish()
        }
    }
}