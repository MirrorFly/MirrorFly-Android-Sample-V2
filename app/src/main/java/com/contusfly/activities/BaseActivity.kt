package com.contusfly.activities

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.WindowManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.contusfly.AppLifecycleListener
import com.contusfly.BuildConfig
import com.contusfly.EmailContactSyncService
import com.contusfly.ForceUpdateChecker
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.api.CallActionListener
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.call.groupcall.isCallNotConnected
import com.contusfly.call.groupcall.isInComingCall
import com.contusfly.call.groupcall.isInPIPMode
import com.contusfly.chat.AndroidUtils
import com.contusfly.checkInternetAndExecute
import com.contusfly.constants.MobileApplication
import com.contusfly.notification.AppNotificationManager
import com.contusfly.showToast
import com.contusfly.utils.*
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.activities.FlyBaseActivity
import com.mirrorflysdk.api.AvailableFeaturesCallback
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycommons.Result
import com.mirrorflysdk.utils.Utils
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
open class BaseActivity : FlyBaseActivity() {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        LogMessage.e(exception)
    }
    /**
     * The broadcast receiver. To handle the actions from the service/activity
     */
    private lateinit var broadcastReceiver: BroadcastReceiver

    private var handler: Handler? = null

    private var otherUserHandler: Handler? = null

    private var adminBlockStatus = false

    private var adminBlockedOtherUserStatus = false

    protected var syncNeeded = false

    lateinit var firebaseUtils: FirebaseUtils

    private val adminBlockRunnable = Runnable {
        LogMessage.d(TAG, "#onAdminBlockedStatus adminBlockRunnable == $adminBlockStatus")
        if (adminBlockStatus) {
            SharedPreferenceManager.clearAllPreference(true)
            AppNotificationManager.cancelNotifications(this)
            if (checkIsUserInCall()) {
                CallManager.disconnectCall(object : CallActionListener {
                    override fun onResponse(isSuccess: Boolean, message: String) {
                        startShowStopperActivity()
                    }
                })
            } else startShowStopperActivity()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseUtils=FirebaseUtils()
        AndroidUtils.calculateAndStoreDeviceWidth(this)
        handler = Handler(Looper.getMainLooper())
        otherUserHandler = Handler(Looper.getMainLooper())
        setSecureFlag()
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                handleBroadcastActions(intent)
            }
        }

        registerBroadcast()

    }

    private fun setSecureFlag(){
        if(AppLifecycleListener.isPinEnabled){
            setFlag()
        } else if(AppLifecycleListener.pinAvailable && AppLifecycleListener.isPresentPrivateChat){
            setFlag()
        } else if(AppLifecycleListener.pinAvailable && AppLifecycleListener.getCurrentChatUserIsPrivateOrNot()){
            setFlag()
        } else {
            removeFlag()
        }
    }

    private fun setFlag(){
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
    }
    private fun removeFlag(){
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }

    private fun availableFeatureCallback(){
        ChatManager.setAvailableFeaturesCallback(object : AvailableFeaturesCallback{
            override fun onUpdateAvailableFeatures(features: Features) {
                updateFeatureActions(features)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        setSecureFlag()
        availableFeatureCallback()
        checkContactPermission()
        onFirebaseRemoteConfigFetched()
    }

    override fun myProfileUpdated(isSuccess: Boolean) {
        super.myProfileUpdated(isSuccess)
        if (isSuccess) {
            try {
                ContactManager.getUserProfile(
                    SharedPreferenceManager.getString(Constants.SENDER_USER_JID),
                    fetchFromServer = false
                ) { success, _, data ->
                    if (success && data.isNotEmpty()) {
                        val profileDetails = data["data"] as ProfileDetails
                        SharedPreferenceManager.setString(
                            Constants.USER_PROFILE_NAME,
                            profileDetails.name
                        )
                        SharedPreferenceManager.setString(
                            Constants.USER_PROFILE_IMAGE,
                            profileDetails.image
                        )
                        var status = profileDetails.status
                        if (status.isNullOrEmpty()) status = getString(R.string.default_status)
                        SharedPreferenceManager.setString(Constants.USER_STATUS, status)
                    }
                }
            } catch (e: Exception) {
                LogMessage.e(TAG, e.toString())
            }
        }
    }

    /**
     * register broadcast to handle the chat services
     */
    private fun registerBroadcast() {
        val intentFilter = IntentFilter(Constants.FORWARDED_MESSAGE_ITEM)
        intentFilter.addAction(Constants.EMAIL_CONTACT_SYNC_COMPLETE)
        intentFilter.addAction(Constants.INTENT_ACTION_FORCIBLE_UPDATE)
        /*
         * Register receiver
         */
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter)
    }

    /**
     * Here handle the following callbacks from the local broadcast receivers.
     *
     * FORWARDED_MESSAGE_ITEM.
     *
     * @param intent Intent from the broadcast actions
     */
    private fun handleBroadcastActions(intent: Intent) {
        try {
            val action = intent.action
            if (action != null) {
                when (action) {
                    Constants.FORWARDED_MESSAGE_ITEM -> clearActionMenu()
                    Constants.EMAIL_CONTACT_SYNC_COMPLETE -> emailContactSyncCompleted()
                    Constants.INTENT_ACTION_FORCIBLE_UPDATE -> onFirebaseRemoteConfigFetched()
                    Constants.QUICK_SHARE_UPLOAD_RESPONSE -> notifyShareUploadStatus(intent)
                }
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Update the upload status of a file
     *
     * @param intent intent that contains message and status of the uploaded file
     */
    override fun notifyShareUploadStatus(intent: Intent) {
        /*Implementation will be added in extended activity*/
    }

    override fun onDestroy() {
        super.onDestroy()
        /*
         * Unregister receiver
         */
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver)
    }

    /**
     * Callback for clearing of action Menu
     */
    protected open fun clearActionMenu() {
        /*Implementation will be added in extended activity*/
    }

    /**
     * Callback for update user details in Recent Chat
     */
    protected open fun userDetailsUpdated() {
        /*Implementation will be added in extended activity*/
    }

    /**
     * Callback for update feature actions
     */
    protected open fun updateFeatureActions(features: Features) {
        /*Implementation will be added in extended activity*/
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

    override fun showOrUpdateOrCancelNotification(jid: String, chatMessage: ChatMessage?) {
        super.showOrUpdateOrCancelNotification(jid, chatMessage)
        updateNotificationShowCancel(jid,chatMessage)
    }

    private fun updateNotificationShowCancel(jid: String, chatMessage: ChatMessage?) {
        if(ChatManager.isPrivateChat(jid)){
            privateChatNotification(jid,chatMessage)
        } else {
            normalChatNotification(jid,chatMessage)
        }
    }
    private fun normalChatNotification(jid: String,chatMessage: ChatMessage?) {
        if (FlyMessenger.getUnreadMessagesCount() <= 0 || !SharedPreferenceManager.getBoolean(Constants.IS_PROFILE_LOGGED) || chatMessage == null) {
            AppNotificationManager.cancelNotifications(applicationContext)
        } else {
            updateNotification(jid,chatMessage)
        }
    }


    private fun privateChatNotification(jid: String,chatMessage: ChatMessage?) {
        if (FlyMessenger.getUnreadPrivateChatMessagesCount() <= 0 || !SharedPreferenceManager.getBoolean(Constants.IS_PROFILE_LOGGED) || chatMessage == null) {
            AppNotificationManager.cancelNotifications(applicationContext)
        } else {
            updateNotification(jid,chatMessage)
        }
    }

    private fun updateNotification(jid: String,chatMessage: ChatMessage?){
        if (ProfileDetailsUtils.getProfileDetails(jid)?.isMuted != true){
            GlobalScope.launch(exceptionHandler) {
                if(firebaseUtils!=null)
                    firebaseUtils.updateProfileOnNotification( this@BaseActivity, chatMessage!!)

                AppNotificationManager.createNotification(MobileApplication.getContext(),
                    chatMessage!!)
            }

        }
    }


    override fun updateGroupReplyNotificationForArchivedSettingsEnabled(chatMessage: ChatMessage) {
        super.updateGroupReplyNotificationForArchivedSettingsEnabled(chatMessage)
        AppNotificationManager.createNotification(MobileApplication.getContext(), chatMessage)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onLoggedOut() {
        super.onLoggedOut()
        SharedPreferenceManager.setBoolean(Constants.SHOW_PIN, false)
        SharedPreferenceManager.setBoolean(Constants.BIOMETRIC, false)
        SharedPreferenceManager.setString(Constants.CHANGE_PIN_NEXT, "")
        SharedPreferenceManager.setString(Constants.MY_PIN, "")
        SafeChatUtils.silentDisableSafeChat(this)
        SharedPreferenceManager.clearAllPreference(true)
    }

    override fun onAdminBlockedUser(jid: String, status: Boolean) {
        adminBlockStatus = status
        LogMessage.d(TAG, "#onAdminBlockedStatus == $adminBlockStatus")
        //To avoid multiple callbacks
        handler?.removeCallbacks(adminBlockRunnable)
        handler?.postDelayed(adminBlockRunnable, 800)
    }

    private fun checkIsUserInCall(): Boolean {
        return CallManager.isOnGoingCall() ||
                (CallManager.isCallNotConnected() && CallManager.isInComingCall()) || isInPIPMode()
    }

    private fun startShowStopperActivity() {
        val intent = Intent(this@BaseActivity, AdminBlockedActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("EXIT", true)
        startActivity(intent)
        finish()
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        adminBlockedOtherUserStatus = status
        //To avoid multiple callbacks
        otherUserHandler?.postDelayed({
            if (CallManager.getGroupID() == jid && adminBlockedOtherUserStatus && checkIsUserInCall()) {
                CallManager.disconnectCall(object : CallActionListener {
                    override fun onResponse(isSuccess: Boolean, message: String) {
                        startDashboardActivity()
                    }
                })
            }
        }, 800)
    }

    /*
     * Blocked List
     */
    override fun usersIBlockedListFetched(jidList: List<String>) {
        super.usersIBlockedListFetched(jidList)
        UIKitContactUtils.updateBlockedStatusOfUser(jidList)
        ContusContactUtils.resetBlockedContacts()
        for (jid in jidList) {
            ContactUtils.checkEmailContactForBlockAndUnblockUser(jid, true)
        }
    }

    /**
     * Launches a new Dashboard activity. If the activity being launched is already running in the current task,
     * then instead of launching a new instance of that activity, all of the other activities on top of it will be closed
     * and this Intent will be delivered to the (now on top) old activity as a new Intent.
     */
    private fun startDashboardActivity() {
        showToast(getString(R.string.group_block_message_label))
        val dashboardIntent = Intent(this@BaseActivity, DashboardActivity::class.java)
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        dashboardIntent.putExtra("EXIT", true)
        startActivity(dashboardIntent)
        finish()
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        LogMessage.e(TAG, "checkContactPermission isSuccess: called8")
        LogMessage.d(TAG, "#contact sync onContactSyncComplete $isSuccess")
        if (isSuccess && MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) {
            SharedPreferenceManager.setInt(ContactUtils.CONTACTS_COUNT, ContactUtils.getContactCount(ChatManager.applicationContext))
            SharedPreferenceManager.setBoolean(Constants.INITIAL_CONTACT_SYNC_DONE, true)
            val email = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.EMAIL))
            if (ChatUtils.isContusUser(email))
                EmailContactSyncService.start()
        }
    }

    private fun checkContactPermission() {
        LogMessage.d(TAG, "#contact sync checkContactPermission called")
        if (SharedPreferenceManager.getBoolean(Constants.IS_PROFILE_LOGGED) && BuildConfig.CONTACT_SYNC_ENABLED) {
            LogMessage.d(TAG, "#contact sync checkContactPermission logged in")
            if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) {
                if (SharedPreferenceManager.getBoolean(Constants.CONTACT_SYNC_DONE) && (syncNeeded || AppLifecycleListener.deviceContactCount == 0)) {
                    syncNeeded = false
                    checkContactChange()
                }
            } else if (SharedPreferenceManager.getBoolean(Constants.INITIAL_CONTACT_SYNC_DONE)) {
                LogMessage.d(TAG, "#contact sync checkContactPermission revoked")
                SharedPreferenceManager.setBoolean(Constants.INITIAL_CONTACT_SYNC_DONE, false)
                FlyCore.revokeContactSync { s, e, _ ->
                    onContactSyncComplete(true)
                    LogMessage.d(TAG, "#contact sync revoked $s")
                    LogMessage.e(TAG, "#contact sync checkContactPermission isSuccess: $s, exception : $e")
                }
            }
        }
    }

    fun checkContactChange() {
        LogMessage.d(TAG, "#contact sync checkContactChange ")
        if (!AppLifecycleListener.isForeground) {
            syncNeeded = true
            return
        }
        val mContactCount = SharedPreferenceManager.getInt(ContactUtils.CONTACTS_COUNT)
        val currentCount = ContactUtils.getContactCount(ChatManager.applicationContext)
        AppLifecycleListener.deviceContactCount = currentCount
        when {
            currentCount < mContactCount -> {
                // DELETE HAPPENED.
                LogMessage.d(TAG, "#contact Contact delete happened")
                updateContacts()
            }
            currentCount == mContactCount -> {
                // UPDATE HAPPENED.
                LogMessage.d(TAG, "#contact Contact update might be happened")
                updateContacts()
            }
            else -> {
                // INSERT HAPPENED.
                LogMessage.d(TAG, "#contact Contact insert happened")
                updateContacts()
            }
        }
    }

    /**
     * sync contact whenever its updated
     *
     */
    private fun updateContacts() {
        if (AppUtils.isNetConnected(this) && FlyCore.contactSyncState.value != Result.InProgress) {
            LogMessage.d(TAG, "#contact Contact syncing due to phone book changes")
            if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) {
                FlyCore.syncContacts(!SharedPreferenceManager.getBoolean(Constants.INITIAL_CONTACT_SYNC_DONE)) { _, _, _ -> }
            }
        } else {
            LogMessage.d(TAG, "#contact Contact syncing is already in progress")
        }
    }

    /*
     * Update Email Contact profile details
     * */
    override fun userProfileFetched(jid: String, profileDetails: ProfileDetails) {
        super.userProfileFetched(jid, profileDetails)
        ContactUtils.checkEmailContactForProfileUpdate(jid, profileDetails)
    }

    override fun onConnected() {
        super.onConnected()
        if (!BuildConfig.CONTACT_SYNC_ENABLED)
            return
        try {
            checkInternetAndExecute(false) {
                LogMessage.i(TAG, "#contact #NewContacts #chatServer SDK has connected INITIAL_CONTACT_SYNC_DONE ")
                if (SharedPreferenceManager.getBoolean(Constants.INITIAL_CONTACT_SYNC_DONE))
                    FlyCore.getRegisteredUsers(true) { isSuccess, _, _ ->
                        if (isSuccess)
                            userDetailsUpdated()
                    }
            }
        }catch (e:Exception){
            LogMessage.e(TAG,e)
        }
    }


    /**
     * Callback for email contact sync completion
     */
    protected open fun emailContactSyncCompleted() {
        /*Implementation will be added in extended activity*/
    }

    /**
     * The callback invoked on the completion of fetching the RemoteConfig task.
     */
    private fun onFirebaseRemoteConfigFetched() {
        if (BuildConfig.CONTACT_SYNC_ENABLED)
            ForceUpdateChecker.with(this).build().check()
    }

     fun launchAuthPinActivity() {
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(activity, BiometricActivity::class.java)
            intent.putExtra(Constants.GO_TO, Constants.PRIVATE_CHAT_LIST)
            privateChatActivityResultLauncher.launch(intent)
        } else  {
            val intent = Intent(activity, PinActivity::class.java)
            intent.putExtra(Constants.GO_TO, Constants.PRIVATE_CHAT_LIST)
            privateChatActivityResultLauncher.launch(intent)
        }

    }

    private var privateChatActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result->
            if (result.resultCode != AppCompatActivity.RESULT_OK) {
                launchDashboardActivity()
            }
        }

    private fun launchDashboardActivity(){
        val intent = Intent(this, DashboardActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

}