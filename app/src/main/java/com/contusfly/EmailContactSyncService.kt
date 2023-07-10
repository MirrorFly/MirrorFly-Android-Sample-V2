package com.contusfly

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.os.RemoteException
import androidx.core.app.NotificationCompat
import androidx.lifecycle.*
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.contusfly.interfaces.ProcessContusContactCallback
import com.contusfly.models.ContusContactSyncTime
import com.contusfly.network.NetworkConnection
import com.contusfly.network.RetrofitClientNetwork
import com.contusfly.utils.Constants
import com.contusfly.utils.ContusContactUtils
import com.contusfly.utils.LogMessage
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.views.CustomToast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class EmailContactSyncService : LifecycleService(), LifecycleObserver, CoroutineScope {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception :  ${exception.printStackTrace()}")
    }

    private var mBinder = EmailContactBinder()
    lateinit var mNotificationManager: NotificationManager
    lateinit var builder: NotificationCompat.Builder
    private lateinit var retryBuilder: NotificationCompat.Builder
    private var mChangingConfiguration = false
    private var isEmailContactSyncFailed = false
    private var isEmailContactSyncApiFailed = false

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // Android O requires a Notification Channel.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the channel for the notification
            val mChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW)
            // Set the Notification Channel for the Notification Manager.
            mNotificationManager.createNotificationChannel(mChannel)
        }
        observeNetworkListener()
    }

    private fun observeNetworkListener() {
        try {
            val networkConnection = NetworkConnection(applicationContext)
            networkConnection.observe(this) { isConnected ->
                if (isConnected) {
                    if (isEmailContactSyncFailed) {
                        showNotification()
                        handleRetrySync()
                    }
                } else {
                    isEmailContactSyncFailed = true
                    showRetryNotification()
                }
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * called when the service in running and app moved to background
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
        try {
            appInForeground = false
            when {
                isEmailContactSyncFailed -> showRetryNotification()
                isEmailContactSyncApiFailed -> stopEmailContactService()
                else -> showNotification()
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * called when the service in running and app moved to or is in foreground
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        appInForeground = true
        stopForeground(true)
    }

    /**
     * shows the notification for the ongoing contact sync task
     */
    private fun showNotification() {
        if (!appInForeground) {
            builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(applicationContext.getString(R.string.app_name))
                .setContentText("Contus email contact sync in progress")
                .setSmallIcon(R.mipmap.ic_notification_small)
                .setAutoCancel(false)
                .setWhen(System.currentTimeMillis())
            startForeground(NOTIFICATION_ID, builder.build())
        }
    }

    /**
     * shows the notification with retry option for contact sync task
     */
    private fun showRetryNotification() {
        try {
            if (!appInForeground) {
                val intent = Intent(this, EmailContactSyncService::class.java)
                intent.putExtra(ACTION_RETRY, true)
                val serviceIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
                } else {
                    PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
                }
                retryBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
                    .addAction(-1, "Retry", serviceIntent)
                    .setContentTitle(applicationContext.getString(R.string.app_name))
                    .setContentText(getString(R.string.fly_error_msg_no_internet))
                    .setSubText("Email Contacts Sync failed.")
                    .setSmallIcon(R.mipmap.ic_notification_small)
                    .setAutoCancel(false)
                    .setTicker(getString(R.string.fly_error_msg_no_internet))
                    .setWhen(System.currentTimeMillis())
                startForeground(NOTIFICATION_ID, retryBuilder.build())
            }
        } catch(e:RemoteException) {
            LogMessage.e(TAG,e.toString())
        } catch(e:Exception) {
            LogMessage.e(TAG,e.toString())
        }

    }

    private fun startForegroundTasks() {
        if (AppUtils.isNetConnected(applicationContext)) showNotification()
    }

    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)
        mChangingConfiguration = false
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        if (!mChangingConfiguration)
            startForegroundTasks()
        return true
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        mChangingConfiguration = false
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mChangingConfiguration = true
    }

    private fun stopEmailContactService(){
        stopForeground(true)
        stopSelf()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        try {
            if (intent != null) {
                val startedFromRetryNotification = intent.getBooleanExtra(ACTION_RETRY, false)
                if (startedFromRetryNotification) {
                    if (AppUtils.isNetConnected(this)) {//Execute the sync when Retry is clicked in notification
                        showNotification()
                        handleRetrySync()
                    } else CustomToast.show(this, getString(R.string.fly_error_msg_no_internet))
                } else {
                    showNotification()
                    launch(coroutineContext) {
                        prepareMailContacts()
                    }
                }
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
        return START_NOT_STICKY
    }

    private fun handleRetrySync() {
        launch(coroutineContext) {
            prepareMailContacts()
        }
    }


    private fun prepareMailContacts() {
        launch(exceptionHandler) {
            isEmailContactSyncApiFailed = false
            if (AppUtils.isNetConnected(ChatManager.applicationContext)) {
                val response =
                    RetrofitClientNetwork.retrofit.getMailContactSync(ContusContactSyncTime(null))
                when (response.status) {
                    200 -> {
                        LogMessage.e(TAG, "getMailContacts success ${response.message}")
                        ContusContactUtils.processContusContactResponse(response.data, object :
                            ProcessContusContactCallback {
                            override fun onProcessContusContactCompleted() {
                                LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(Intent(Constants.EMAIL_CONTACT_SYNC_COMPLETE))
                                isEmailContactSyncFailed = false
                                mNotificationManager.cancel(NOTIFICATION_ID)
                                stopEmailContactService()
                            }
                        })
                    }
                    204 -> {
                        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(Intent(Constants.EMAIL_CONTACT_SYNC_COMPLETE))
                        isEmailContactSyncFailed = false
                        mNotificationManager.cancel(NOTIFICATION_ID)
                        stopEmailContactService()
                    }
                    else -> {
                        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(Intent(Constants.EMAIL_CONTACT_SYNC_COMPLETE))
                        isEmailContactSyncApiFailed = true
                        stopEmailContactService()
                    }
                }
            } else {
                LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(Intent(Constants.EMAIL_CONTACT_SYNC_COMPLETE))
                isEmailContactSyncApiFailed = true
                showRetryNotification()
            }
        }
    }

    inner class EmailContactBinder : Binder() {
        val service: EmailContactSyncService
            get() = this@EmailContactSyncService
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    companion object {
        fun start() {
            try {
                val serviceIntent = Intent(ChatManager.applicationContext, EmailContactSyncService::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && !appInForeground) {
                    ChatManager.applicationContext.startForegroundService(serviceIntent)
                } else ChatManager.applicationContext.startService(serviceIntent)
            } catch(e:RemoteException) {
                LogMessage.e(TAG,e.toString())
            } catch(e:Exception) {
                LogMessage.e(TAG,e.toString())
            }
        }
        fun stop() {
            val serviceIntent = Intent(ChatManager.applicationContext, EmailContactSyncService::class.java)
            ChatManager.applicationContext.stopService(serviceIntent)
        }
        private var appInForeground = true
        const val CHANNEL_ID = "Sync Email Contacts"
        const val CHANNEL_NAME = "Email Contacts operations"
        const val NOTIFICATION_ID = 8003
        const val TAG = "EmailContactSyncService"
        const val ACTION_RETRY = "com.contusfly.emailcontactsync.retry"

    }
}