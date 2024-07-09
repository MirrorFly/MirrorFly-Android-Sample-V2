package com.contusfly.constants

import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import androidx.lifecycle.ProcessLifecycleOwner
import com.contusfly.*
import com.contusfly.activities.AdminBlockedActivity
import com.contusfly.activities.BiometricActivity
import com.contusfly.activities.PinActivity
import com.contusfly.activities.StartActivity
import com.contusfly.call.CallConfiguration
import com.contusfly.call.MissedCallNotificationUtils
import com.contusfly.call.groupcall.GroupCallActivity
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.database.MirrorFlyDatabase
import com.contusfly.database.UIKitDatabase
import com.contusfly.di.components.DaggerAppComponent
import com.contusfly.notification.AppNotificationManager
import com.contusfly.utils.*
import com.facebook.stetho.Stetho
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.mirrorflysdk.api.*
import com.mirrorflysdk.api.utils.NameHelper
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.*
import com.mirrorflysdk.flycall.webrtc.api.CallHelper
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycall.webrtc.api.CallNameHelper
import com.mirrorflysdk.flycall.webrtc.api.MissedCallListener
import com.mirrorflysdk.flycommons.PendingIntentHelper
import com.mirrorflysdk.flycommons.models.CallMetaData
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class MobileApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    init {
        instance = this
    }

    companion object {
        private var instance: MobileApplication? = null

        fun getContext(): Context {
            return instance!!.applicationContext
        }
    }
    private var defaultUncaughtHandler: Thread.UncaughtExceptionHandler? = null
    private var mediaCaptionMentionList: MediaCaptionMentionList? = null


    override fun onCreate() {
        super.onCreate()
        // For chat log
        LogMessage.enableDebugLogging(BuildConfig.DEBUG)
        DaggerAppComponent.builder()
                .application(this)
                .sdkComponent(ChatManager.sdkComponent)
                .build().inject(this)
        FirebaseApp.initializeApp(this)
        Stetho.initializeWithDefaults(this)

        try {
            //before setting our own exception handler, taking a backup of default handler so
            // that we don't break any exception handlers/loggers like crashlytics
            defaultUncaughtHandler = Thread.getDefaultUncaughtExceptionHandler()
            Thread.setDefaultUncaughtExceptionHandler { t, e ->
                Logger.e(e.stackTraceToString())
                defaultUncaughtHandler?.uncaughtException(t, e)
            }
        } catch (e:Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(e)
        }

        ChatManager.enableMobileNumberLogin(true)
        ChatManager.setMediaFolderName(Constants.LOCAL_PATH)
        ChatManager.enableChatHistory(true)

        //activity to open when use clicked from notification
        //activity to open when a user logout from the app.
        ChatManager.startActivity = StartActivity::class.java

        ChatManager.pinActivity = PinActivity::class.java

        ChatManager.biometricActivty = BiometricActivity::class.java

        ChatManager.setMediaEncryption(true)

        ChatManager.setMediaNotificationHelper(object : MediaNotificationHelper {
            override fun setMediaNotificationIntentAction(
                notificationCompatBuilder: NotificationCompat.Builder, jidList: List<String>) {
                notificationCompatBuilder.setContentIntent(getPendingIntent(jidList))
            }
        })

        setAdminBlockListener()

        //register observer
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycleListener())

        initEmojiCompat()
        UIKitDatabase.initDatabase(this)
        MirrorFlyDatabase.initDatabase(this)

        //Set Name based on the Profile data
        ChatManager.setNameHelper(object  : NameHelper {
            override fun getDisplayName(jid: String): String {
                return if (ProfileDetailsUtils.getProfileDetails(jid) != null) ProfileDetailsUtils.getProfileDetails(jid)!!.getDisplayName() else Constants.EMPTY_STRING
            }
        })

        //initialize call sdk
        initializeCallSdk()
        Logger.enableDebugLogging(true)
        setupFirebaseRemoteConfig()
        mediaCaptionMentionList = MediaCaptionMentionList()

    }

    fun getMediaCaptionObject(): MediaCaptionMentionList? {
        return mediaCaptionMentionList
    }

    fun clearMediaCaptionObject(){
        mediaCaptionMentionList!!.mediaCaptionParameters.clear()
    }
    private fun setAdminBlockListener() {
        ChatManager.setAdminBlockHelper(object : AdminBlockHelper {
            override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
                AppLifecycleListener._adminBlockedOtherUser.postValue(Triple(jid, type, status))
            }

            override fun onAdminBlockedUser(jid: String, status: Boolean) {
                if (status) {
                    SharedPreferenceManager.setBoolean(Constants.SHOW_PIN, false)
                    SharedPreferenceManager.setBoolean(Constants.BIOMETRIC, false)
                    SharedPreferenceManager.setString(Constants.CHANGE_PIN_NEXT, "")
                    SharedPreferenceManager.setString(Constants.MY_PIN, "")
                    SafeChatUtils.silentDisableSafeChat(applicationContext)
                    AppNotificationManager.cancelNotifications(applicationContext)
                    SharedPreferenceManager.clearAllPreference(true)
                    if (AppLifecycleListener.isForeground) {
                        val intent = Intent(ChatManager.applicationContext, AdminBlockedActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        ChatManager.applicationContext.startActivity(intent)
                    }
                }
                SharedPreferenceManager.setBoolean(Constants.ADMIN_BLOCKED, status)
            }
        })
    }

    private fun setupFirebaseRemoteConfig() {
        CallConfiguration.setIsGroupCallEnabled(true) // set default value as true
        val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(14400)
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings)

        val remoteConfigDefaults: MutableMap<String, Any> = HashMap()
        remoteConfigDefaults[CallConfiguration.IS_GROUP_CALL_ENABLED] = true

        remoteConfig.setDefaultsAsync(remoteConfigDefaults)
        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val updated = task.result
                LogMessage.d(TAG, "Config params updated: $updated")
            } else {
                LogMessage.d(TAG, "Config params Fetch failed")
            }
            CallConfiguration.setIsGroupCallEnabled(remoteConfig.getBoolean(CallConfiguration.IS_GROUP_CALL_ENABLED))
        }
    }

    private fun initializeCallSdk() {
        CallManager.setCallActivityClass(GroupCallActivity::class.java)
        CallManager.setMissedCallListener(object : MissedCallListener {
            override fun onMissedCall(isOneToOneCall: Boolean, userJid: String, groupId: String?, callType: String, userList: ArrayList<String>, callMeta: Array<CallMetaData>?) {
                //show missed call notification
                MissedCallNotificationUtils.createMissCallNotification(
                        isOneToOneCall,
                        userJid,
                        groupId,
                        callType,
                        userList, callMeta)
            }
        })

        CallManager.setCallHelper(object : CallHelper {
            override fun getNotificationContent(callDirection: String, callMetaDataArray: Array<CallMetaData>?): String {
                return if (BuildConfig.HIPAA_COMPLIANCE_ENABLED) {
                    when (callDirection) {
                        CallDirection.INCOMING_CALL -> resources.getString(R.string.new_incoming_call)
                        CallDirection.OUTGOING_CALL -> resources.getString(R.string.new_outgoing_call)
                        else -> resources.getString(R.string.new_ongoing_call)
                    }
                }else{
                    getNotificationMessage()
                }

            }
        })

        CallManager.setCallNameHelper(object : CallNameHelper {
            override fun getDisplayName(jid: String, callMetaDataArray: Array<CallMetaData>?): String {
                return if (ProfileDetailsUtils.getProfileDetails(jid) != null) ProfileDetailsUtils.getProfileDetails(jid)!!.getDisplayName() else Constants.EMPTY_STRING
            }
        })
        CallManager.enableCallLogExport(true)
        CallManager.enableDebugLogs(true)
    }

    private fun getMissedCallNotificationContent( isOneToOneCall: Boolean, userJid: String, groupId: String?, callType: String,
                                                  userList: ArrayList<String>): Pair<String, String> {
        var messageContent : String
        val missedCallMessage = StringBuilder()
        missedCallMessage.append(resources.getString(R.string.you_missed_call))
        if (isOneToOneCall && groupId.isNullOrEmpty()) {
            if (callType == CallType.AUDIO_CALL) {
                missedCallMessage.append("an ")
            } else {
                missedCallMessage.append("a ")
            }
            missedCallMessage.append(callType).append(" call")
            messageContent = ProfileDetailsUtils.getProfileDetails(userJid)?.getDisplayName()!!
        } else {
            missedCallMessage.append("a group ").append(callType).append(" call")
            messageContent = if (!groupId.isNullOrBlank()) {
                ProfileDetailsUtils.getProfileDetails(groupId)?.getDisplayName()!!
            } else {
                CallUtils.getCallUsersName(userList).toString()
            }
        }
        if (BuildConfig.HIPAA_COMPLIANCE_ENABLED)
            messageContent = resources.getString(R.string.new_missed_call)
        return Pair(missedCallMessage.toString(), messageContent)
    }

    private fun getPendingIntent(toUsers: List<String>): PendingIntent {
        val notificationIntent = Intent(this, ChatManager.startActivity)
        notificationIntent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK
                or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        notificationIntent.putExtra(Constants.IS_FROM_NOTIFICATION, true)
        notificationIntent.putExtra(Constants.JID, if (toUsers.count() == 1) toUsers.elementAt(0) else Constants.EMPTY_STRING)
        val requestID = System.currentTimeMillis().toInt()
        return PendingIntentHelper.getActivity(this, requestID, notificationIntent)
    }

    fun getNotificationMessage() : String {
        return if (CallManager.isOneToOneCall() && CallManager.getGroupID().isEmpty() && CallManager.getCallUsersList().isNotEmpty()) {
            ProfileDetailsUtils.getDisplayName(CallManager.getCallUsersList().first())
        } else {
            if (CallManager.getGroupID().isNotBlank()) {
                ProfileDetailsUtils.getDisplayName(CallManager.getGroupID())
            } else {
                CallUtils.getCallUsersName(CallManager.getCallUsersList()).toString()
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return activityInjector
    }

    private fun initEmojiCompat() {
        val config: EmojiCompat.Config

        // Use a downloadable font for EmojiCompat
        val fontRequest = FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                "Noto Color Emoji Compat", R.array.com_google_android_gms_fonts_certs)
        config = FontRequestEmojiCompatConfig(applicationContext, fontRequest)
        config.setReplaceAll(true)
                .registerInitCallback(object : EmojiCompat.InitCallback() {
                    override fun onInitialized() {
                        Log.i(TAG, "EmojiCompat initialized")
                    }

                    override fun onFailed(throwable: Throwable?) {
                        Log.e(TAG, "EmojiCompat initialization failed", throwable)
                    }
                })
        EmojiCompat.init(config)
    }
}