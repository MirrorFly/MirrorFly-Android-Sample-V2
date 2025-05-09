package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.TaskStackBuilder
import com.an.biometric.BiometricCallback
import com.an.biometric.BiometricManager
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.utils.*
import com.mirrorflysdk.api.ChatManager
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import com.contus.call.CallConstants
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.*
import com.contusfly.call.groupcall.GroupCallActivity
import com.contusfly.call.groupcall.OnGoingCallPreviewActivity
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.notification.AppNotificationManager
import com.contusfly.privateChat.PrivateChatListActivity
import com.mirrorflysdk.api.FlyCore


class StartActivity : BaseActivity(), CoroutineScope, BiometricCallback {

    /**
     * instance of BiometricManager class
     */
    private var mBiometricManager: BiometricManager? = null

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeSDK()
    }

    private fun initializeSDK(){
        try{
            ChatManager.initializeSDK(BuildConfig.LICENSE){ isSuccess, _, data ->
                if (isSuccess) {
                    LogMessage.d(TAG,"Config Details Fetched")
                } else {
                    LogMessage.d(TAG,"initializeSDK failed with reason:${data.getMessage()}")
                }
                userView()
            }
        }catch(exception:Exception){
            LogMessage.e(TAG,"Exception while trying to initialize sdk!!")
        }
    }

    private fun userView() {
        val licenseKey = ChatManager.getLicenseKey()
        SharedPreferenceManager.setBoolean(Constants.PIN_SCREEN,false)
        val callLink = if (!intent.dataString.isNullOrEmpty()) intent.dataString!!.replace(
            BuildConfig.WEB_CHAT_LOGIN, "") else ""
        if (intent.hasExtra(CallUtils.IS_CALL_NOTIFICATION)) {
            val showCallsTab = intent.getBooleanExtra(CallUtils.IS_CALL_NOTIFICATION, false)
            CallUtils.setCallsTabToBeShown(showCallsTab)
        }
        if (licenseKey?.isNotEmpty()!! && SharedPreferenceManager.getBoolean(Constants.IS_LOGGED_IN)) {
            if (SharedPreferenceManager.getBoolean(Constants.IS_PROFILE_LOGGED)) {
                if (callLink.isNotEmpty())
                    validateCallLinkAndNavigateToRespectivePage(callLink)
                else if (!BuildConfig.CONTACT_SYNC_ENABLED || SharedPreferenceManager.getBoolean(Constants.CONTACT_SYNC_DONE) || FlyCore.getNonChatUsers().size > 0)
                    checkNotificationIntent(intent)
                else
                    startActivity(Intent(this, SynchronizeContactActivity::class.java))
            } else {
                startActivity(Intent(this, ProfileStartActivity::class.java).putExtra(Constants.IS_FIRST_LOGIN, true)
                        .putExtra(Constants.FROM_SPLASH, true))
            }
        } else {
            startActivity(Intent(this, OtpActivity::class.java))
        }
        GlobalScope.launch {
            AppShortCuts.dynamicAppShortcuts(this@StartActivity)
        }
        finish()
    }

    private fun validateCallLinkAndNavigateToRespectivePage(callLink: String) {
        val onGngCallLink = CallManager.getCallLink()
        if (onGngCallLink == callLink) {
            startActivity(Intent(this, GroupCallActivity::class.java))
        } else {
            startActivity(
                Intent(context, OnGoingCallPreviewActivity::class.java)
                    .putExtra(CallConstants.CALL_LINK, callLink)
                    .putExtra(Constants.FROM_SPLASH_SCREEN, true)
            )
        }
    }

    private fun checkEnableSafeChat() {
        if (intent.getBooleanExtra(Constants.IS_FOR_SAFE_CHAT, false)){
            SafeChatUtils.changeSafeChatUpdateValue()
        }
        AppShortCuts.dynamicAppShortcuts(this)
    }

    /**
     * Checks the notification intent and loads ChatViewActivity if need.
     *
     * @param intent Notification intent
     */
    private fun checkNotificationIntent(intent: Intent) {
        checkEnableSafeChat()
        if (intent.hasExtra(LibConstants.JID)) {
            clearNotification()
            val jid = intent.getStringExtra(LibConstants.JID)
            if (!jid.isNullOrBlank()) {
                val profileDetail = ProfileDetailsUtils.getProfileDetails(jid)
                if (profileDetail != null) {
                    val chatType = profileDetail.getChatType()
                    goToChatView(jid, chatType)
                } else goToDashboard()
            } else goToDashboard()
        } else if (intent.hasExtra(Constants.IS_FOR_SAFE_CHAT)){
            Log.d(TAG, getString(R.string.is_from_chat_shortcut))
            startActivities(
                TaskStackBuilder.create(this)
                    .addNextIntent(
                        Intent(this,DashboardActivity::class.java)
                            .setAction(Intent.ACTION_VIEW)
                            .putExtra(Constants.IS_FOR_SAFE_CHAT, true)
                    ).intents
            )
        }  else goToDashboard()
    }

    private fun goToDashboard() {
        if (AppLifecycleListener.backPressedSP) startActivity(Intent(this, DashboardActivity::class.java))
        else
            startActivity(Intent(this, DashboardActivity::class.java)
                .putExtra("shouldShowPinOrNot", shouldShowPinOrNot())
                .putExtra(Constants.FROM_SPLASH_SCREEN, true).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }

    private fun goToChatView(jid: String, chatType: String) {
        when {
            AppLifecycleListener.fromOnCreate && AppLifecycleListener.isPinEnabled -> {
                Log.d(TAG, "checkNotificationIntent:  oncreate_APP")
                privateChatNotificationHandle(jid, chatType)
            }
            !AppLifecycleListener.isAPPForeground && shouldShowPinOrNot() -> {
                Log.d(TAG, "checkNotificationIntent:  SHOW_PIN")
                NormalNotificationHandle(jid, chatType)
            }
            AppLifecycleListener.pinActivityShowing -> {
                Log.d(TAG, "checkNotificationIntent:  SHOW_PIN1")
                SharedPreferenceManager.setString(Constants.APP_SESSION, System.currentTimeMillis().toString())
                privateChatNotificationHandle(jid, chatType)
            }
            intent.hasExtra(Constants.IS_FOR_SAFE_CHAT) -> {
                Log.d(TAG, getString(R.string.is_from_chat_shortcut))
                startActivities(
                    TaskStackBuilder.create(this)
                        .addNextIntent(
                            Intent(this,DashboardActivity::class.java)
                                .setAction(Intent.ACTION_VIEW)
                                .putExtra(Constants.IS_FOR_SAFE_CHAT, true)
                        ).intents
                )
            }
            intent.hasExtra(Constants.PRIVATE_CHAT) -> {
                Log.d(TAG, "checkNotificationIntent:  in PRIVATE_CHAT")
                privateChatNotificationHandle(jid, chatType)
            }
            else -> {
                checkAndNavigateToDashboard(jid, chatType)
            }
        }
    }

    private fun NormalNotificationHandle(jid: String, chatType: String){
        if(intent.hasExtra(Constants.AUTHENTICATION_NEED)){
            var isAuthenticationNeed=intent.getBooleanExtra(Constants.AUTHENTICATION_NEED,false)
            if(isAuthenticationNeed) {
                pinForChatOrGroup(jid, chatType)
            } else {
                redirectToChatPageWithoutAuthentication(jid,chatType)
            }
        } else {
            pinForChatOrGroup(jid, chatType)
        }
        SharedPreferenceManager.setString(Constants.APP_SESSION, System.currentTimeMillis().toString())

    }

    private fun redirectToChatPageWithoutAuthentication(jid: String, chatType: String) {
        if(shouldShowPinOrNot()) {
            pinForChatOrGroup(jid, chatType)
        } else {
            startActivities(
                TaskStackBuilder.create(this)
                    .addNextIntent(
                        Intent(this, DashboardActivity::class.java)
                            .setAction(Intent.ACTION_VIEW)
                            .putExtra(Constants.CHAT_TYPE, chatType)
                    ).addNextIntent(
                        Intent(this, ChatActivity::class.java)
                            .setAction(Intent.ACTION_VIEW)
                            .putExtra(LibConstants.JID, jid)
                            .putExtra(com.mirrorflysdk.flycommons.Constants.CHAT_TYPE, chatType)
                    )
                    .intents
            )
        }

    }

    private fun privateChatNotificationHandle(jid: String, chatType: String) {
        if(intent.hasExtra(Constants.AUTHENTICATION_NEED)){
            var isAuthenticationNeed=intent.getBooleanExtra(Constants.AUTHENTICATION_NEED,false)
            if(isAuthenticationNeed) {
                pinForChatOrGroup(jid, chatType)
            } else {
                if(intent.hasExtra(Constants.PRIVATE_CHAT)){
                    privateChatRedirectToChatPageWithoutAuthentication(jid,chatType)
                } else {
                    redirectToChatPageWithoutAuthentication(jid,chatType)
                }
            }
        } else {
            pinForChatOrGroup(jid, chatType)
        }
    }

    private fun privateChatRedirectToChatPageWithoutAuthentication(jid: String, chatType: String){

        startActivities(
            TaskStackBuilder.create(this)
                .addNextIntent(
                    Intent(this, DashboardActivity::class.java)
                        .setAction(Intent.ACTION_VIEW)
                        .putExtra(Constants.CHAT_TYPE, chatType)
                ).addNextIntent(
                    Intent(this, PrivateChatListActivity::class.java)
                        .setAction(Intent.ACTION_VIEW)
                ).addNextIntent(
                    Intent(this, ChatActivity::class.java)
                        .setAction(Intent.ACTION_VIEW)
                        .putExtra(LibConstants.JID, jid)
                        .putExtra(com.mirrorflysdk.flycommons.Constants.CHAT_TYPE, chatType)
                )
                .intents
        )

    }

    private fun checkAndNavigateToDashboard(jid: String, chatType: String) {
        if (intent.hasExtra(Constants.IS_FROM_CHAT_SHORTCUT)) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(jid)
            Log.d(TAG, getString(R.string.is_from_chat_shortcut))
            if (ChatType.TYPE_GROUP_CHAT == chatType && profileDetails != null && profileDetails.isAdminBlocked) {
                startActivity(Intent(this, DashboardActivity::class.java)
                    .setAction(Intent.ACTION_VIEW)
                    .putExtra(Constants.CHAT_TYPE, chatType))
                showToast(getString(R.string.group_block_message_label))
            } else {
                startActivities(
                    TaskStackBuilder.create(this)
                        .addNextIntent(
                            Intent(this, DashboardActivity::class.java)
                                .setAction(Intent.ACTION_VIEW)
                                .putExtra(Constants.CHAT_TYPE, chatType)
                        ).addNextIntent(
                            Intent(this, ChatActivity::class.java)
                                .setAction(Intent.ACTION_VIEW)
                                .putExtra(LibConstants.JID, jid)
                                .putExtra(com.mirrorflysdk.flycommons.Constants.CHAT_TYPE, chatType)
                        )
                        .intents
                )
            }
        } else {
            startActivities(
                TaskStackBuilder.create(this)
                    .addNextIntent(
                        Intent(this, DashboardActivity::class.java).setAction(Intent.ACTION_VIEW)
                    )
                    .addNextIntent(
                        Intent(this, ChatActivity::class.java).setAction(Intent.ACTION_VIEW)
                            .putExtra(LibConstants.JID, jid)
                            .putExtra(com.mirrorflysdk.flycommons.Constants.CHAT_TYPE, chatType)
                    )
                    .intents
            )
        }
    }

    private fun pinForChatOrGroup(jid: String?, chatType: String?) {
        var isShowPrivateChatList:Boolean=false
        if(intent.hasExtra(Constants.IS_SHOW_PRIVATE_CHAT_LIST)) isShowPrivateChatList=true
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(this@StartActivity, BiometricActivity::class.java)
            intent.putExtra(GOTO, "CHATVIEW")
            intent.putExtra(LibConstants.JID, jid)
            intent.putExtra(com.mirrorflysdk.flycommons.Constants.CHAT_TYPE, chatType)
            if(isShowPrivateChatList)  intent.putExtra(Constants.IS_SHOW_PRIVATE_CHAT_LIST, true)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(intent)
        } else {
            val intent = Intent(ChatManager.applicationContext, ChatManager.pinActivity)
            intent.putExtra(GOTO, "CHATVIEW")
            intent.putExtra(LibConstants.JID, jid)
            intent.putExtra(com.mirrorflysdk.flycommons.Constants.CHAT_TYPE, chatType)
            if(isShowPrivateChatList)  intent.putExtra(Constants.IS_SHOW_PRIVATE_CHAT_LIST, true)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(intent)
        }
    }

    private fun shouldShowPinOrNot(): Boolean {
        LogMessage.d("StartActivity", AppLifecycleListener.shouldShowPinActivity().toString() + " shouldShowPinOrNot " + AppLifecycleListener.isPinEnabled)
        return AppLifecycleListener.shouldShowPinActivity() && AppLifecycleListener.isPinEnabled
    }

    private fun clearNotification() {
        AppNotificationManager.cancelNotifications(applicationContext)
    }

    override fun onSdkVersionNotSupported() {
        Toast.makeText(applicationContext, getString(R.string.biometric_error_sdk_not_supported), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(applicationContext, getString(R.string.biometric_error_hardware_not_supported), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(applicationContext, getString(R.string.biometric_error_permission_not_granted), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationNotAvailable() {
        SharedPreferenceManager.setBoolean(Constants.BIOMETRIC,false)
        Toast.makeText(applicationContext, getString(R.string.biometric_error_fingerprint_not_available), Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationFailed() {
        Toast.makeText(applicationContext, getString(R.string.biometric_failure), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationInternalError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationCancelled() {
        Toast.makeText(applicationContext, getString(R.string.biometric_cancelled), Toast.LENGTH_LONG).show()
        mBiometricManager!!.cancelAuthentication()
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
        Toast.makeText(applicationContext, helpString, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationSuccessful() {
        Toast.makeText(applicationContext, getString(R.string.biometric_success), Toast.LENGTH_LONG).show()
        startActivity(Intent(this, DashboardActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        Toast.makeText(applicationContext, errString, Toast.LENGTH_LONG).show()
    }

    companion object {
        private val TAG = StartActivity::class.java.simpleName
        private const val GOTO = Constants.GO_TO
    }

    override fun onDestroy() {
        super.onDestroy()
        clearNotification()
    }
}
