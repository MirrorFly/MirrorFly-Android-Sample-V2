package com.contusfly

import android.app.KeyguardManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.text.format.DateFormat
import android.util.Log
import androidx.lifecycle.*
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.activities.AdminBlockedActivity
import com.contusfly.models.PrivateChatAuthenticationModel
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import org.greenrobot.eventbus.EventBus


class AppLifecycleListener : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
        isForeground = false
        isAPPForeground = false
        // app moved to background
        Log.d(LOG_TAG, "App moved to background")
        SharedPreferenceManager.setString(Constants.APP_SESSION, System.currentTimeMillis().toString())
        SharedPreferenceManager.setString(Constants.KEY_NOTIIFCATION_SUMMARY_CHANNEL_ID, SharedPreferenceManager.getString(Constants.KEY_NOTIIFCATION_SUMMARY_CHANNEL_ID)+Constants.KEY_BACKGROUND)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun appLifeCycleOnCreate() {
        registerBroadcastReceiver()
        SharedPreferenceManager.setBoolean(Constants.BACK_PRESS, false)
        SharedPreferenceManager.setString(Constants.APP_SESSION, System.currentTimeMillis().toString())
        fromOnCreate = true
        Log.d(LOG_TAG, "OnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        isForeground = true
        isAPPForeground = true
        Log.d(LOG_TAG, "App moved to forground")
        // app moved to foreground
        deviceContactCount = 0
        SharedPreferenceManager.setString(Constants.KEY_NOTIIFCATION_SUMMARY_CHANNEL_ID, SharedPreferenceManager.getString(Constants.KEY_NOTIIFCATION_SUMMARY_CHANNEL_ID)+Constants.KEY_FORGROUND)
        //To check the user blocked by admin status and navigate to show stopper screen
        if (SharedPreferenceManager.getBoolean(Constants.ADMIN_BLOCKED)) {
            val intent = Intent(ChatManager.applicationContext, AdminBlockedActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ChatManager.applicationContext.startActivity(intent)
            return
        }

        val deviceTimeFormat = DateFormat.is24HourFormat(ChatManager.applicationContext)
        val devicePreviousTimeFormat = SharedPreferenceManager.getBoolean(Constants.IS_24_FORMAT)
        SharedPreferenceManager.setBoolean(Constants.IS_TIME_FORMAT_CHANGED, deviceTimeFormat != devicePreviousTimeFormat)
        SharedPreferenceManager.setBoolean(Constants.IS_24_FORMAT, deviceTimeFormat)

        if (isPinEnabled && !CallManager.isOnGoingCall()) {
            fromOnCreate = false
            Log.d(LOG_TAG, " show pin $isOnCall$backPressedSP")
            showPinActivity("onMoveToForeground")
            SharedPreferenceManager.setBoolean(Constants.BACK_PRESS, false)
        } else sendPrivateChatAuthenticationShowStatus()
        Log.d(LOG_TAG, "App moved to Foreground " + isPinEnabled + " " + sessionTimeDifference + shouldShowPinActivity())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeCallback() {
        Log.d(LOG_TAG, "App OnResume $deviceLock $isForeground")
        if (deviceLock && isForeground) {
            presentPinActivity("onResumeCallback")
            deviceLock = false
        }
    }

    private fun registerBroadcastReceiver() {
        val theFilter = IntentFilter()
        /** System Defined Broadcast  */
        theFilter.addAction(Intent.ACTION_SCREEN_ON)
        theFilter.addAction(Intent.ACTION_SCREEN_OFF)
        theFilter.addAction(Intent.ACTION_USER_PRESENT)
        val screenOnOffReceiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val strAction = intent.action
                val myKM = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
                if (strAction == Intent.ACTION_USER_PRESENT || strAction == Intent.ACTION_SCREEN_OFF || strAction == Intent.ACTION_SCREEN_ON) if (myKM.inKeyguardRestrictedInputMode()) {
                    Log.d(LOG_TAG, "Screen_off LOCKED")
                } else {
                    Log.d(LOG_TAG, "Screen_off UNLOCKED")
                    deviceLock = true
                    if (isForeground) {
                        presentPinActivity("receiver ")
                        deviceLock = false
                    }
                }
            }
        }
        ChatManager.applicationContext.registerReceiver(screenOnOffReceiver, theFilter)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onAppDestroyed() {
        Log.d(LOG_TAG, "app destroyed")
    }

    companion object {
        private val LOG_TAG = AppLifecycleListener::class.java.simpleName
        private val SESSION_TIME = (32 * 1000).toLong()
        var isOnCall = false

        @JvmField
        var isForeground = false

        @JvmField
        var isAPPForeground = false

        @JvmField
        var fromOnCreate = false
        var deviceLock = false

        @JvmField
        var pinActivityShowing = false

        @JvmField
        var pinScreenShowing = true

        @JvmField
        var deviceContactCount = 0

        @JvmField
        var isFromQuickShareForBioMetric = false

        @JvmField
        var isFromQuickShareForPin = false

        val _adminBlockedOtherUser = MutableLiveData<Triple<String, String, Boolean>>()
        val adminBlockedOtherUser: LiveData<Triple<String, String, Boolean>>
            get() = _adminBlockedOtherUser

        val backPressedSP: Boolean
            get() = SharedPreferenceManager.getBoolean(Constants.BACK_PRESS) && !shouldShowPinActivity()

        fun showPinActivity(from: String?) {
            if (shouldShowPinActivity()) {
                showPin(from)
            } else {
                sendPrivateChatAuthenticationShowStatus()
            }
        }

        private fun showPin(from: String?) {
            if(isPresentPrivateChat) {
                sendPrivateChatAuthenticationShowStatus()
            } else {
                presentPinActivity(from)
            }
        }

        private fun sendPrivateChatAuthenticationShowStatus() {
            if (isPresentPrivateChat && pinAvailable && !CallManager.isOnGoingCall()) {
                postPrivateChatAuthentication()
            } else if(getCurrentChatUserIsPrivateOrNot() && pinAvailable && !CallManager.isOnGoingCall()) {
                postPrivateChatAuthentication()
            }
        }

        private fun postPrivateChatAuthentication() {
            val model=PrivateChatAuthenticationModel(true)
            EventBus.getDefault().post(model)
        }

        fun getCurrentChatUserIsPrivateOrNot(): Boolean {
            var isPrivateChatUser:Boolean=false
            try {
                var currentChatUser=SharedPreferenceManager.getString(Constants.ON_GOING_CHAT_USER)
                if(currentChatUser.isNotEmpty()) {
                    isPrivateChatUser=ChatManager.isPrivateChat(currentChatUser)
                }
            } catch(e:Exception){
                LogMessage.e("Exception",e.toString())
            }
            return isPrivateChatUser
        }


        fun shouldShowPinActivity(): Boolean =
            if(SharedPreferenceManager.getBoolean(Constants.IS_SAFE_CHAT_ENABLED)){ true }
            else sessionTimeDifference >= SESSION_TIME

        private val sessionTimeDifference: Long
            get() {
                val currentTimeInMillis = System.currentTimeMillis()
                val spValue = SharedPreferenceManager.getString(Constants.APP_SESSION)
                return if (spValue.isEmpty()) {
                    0.toLong()
                } else {
                    when {
                        java.lang.Long.valueOf(spValue) == 0L -> {
                            0.toLong()
                        }
                        java.lang.Long.valueOf(spValue) >= 0L -> {
                            val timeSinceLastUse = java.lang.Long.valueOf(spValue)
                            currentTimeInMillis - timeSinceLastUse
                        }
                        else -> {
                            0L
                        }
                    }
                }
            }

        val isPinEnabled: Boolean
            get() = SharedPreferenceManager.getBoolean(Constants.SHOW_PIN)

         val pinAvailable: Boolean get() =  SharedPreferenceManager.getString(Constants.MY_PIN).isNotEmpty()

         val isPresentPrivateChat: Boolean get() =  SharedPreferenceManager.getBoolean(Constants.PRIVATE_CHAT)


        private val isQuickShare: Boolean
            get() {
                if (SharedPreferenceManager.getBoolean(Constants.QUICK_SHARE)) {
                    SharedPreferenceManager.setBoolean(Constants.QUICK_SHARE, false)
                    return true
                }
                return false
            }

        fun presentPinActivity(from: String?) {
            isForeground = false
            if (isPinEnabled && !isQuickShare &&!isOnCall) {
                if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
                    launchBiometricActivity()
                } else if (!isOnCall && !pinActivityShowing) {
                    launchPinActivity()
                }
            }
        }

        private fun launchBiometricActivity() {
            val intent = Intent(ChatManager.applicationContext, ChatManager.biometricActivty)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(intent)
        }

        private fun launchPinActivity() {
            val intent = Intent(ChatManager.applicationContext, ChatManager.pinActivity)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(intent)
        }
    }
}