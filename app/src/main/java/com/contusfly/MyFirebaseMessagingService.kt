package com.contusfly

import com.contusfly.utils.Constants
import com.contusfly.utils.FirebaseUtils
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SharedPreferenceManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class MyFirebaseMessagingService : FirebaseMessagingService() {

    /**
     * Instance of the chat utils class that contains the common firebase methods
     */
    @Inject
    lateinit var firebaseUtils: FirebaseUtils

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        // Data messages are handled here in onMessageReceived whether the app is in the foreground
        // or background. Data messages are the type traditionally used with GCM.
        val notificationData: Map<String, String> = remoteMessage.data
        if (notificationData.isNotEmpty()) {
            LogMessage.d(TAG, "RemoteMessage:$notificationData")
            firebaseUtils.handleReceivedMessage(this, notificationData)
        }
    }

    override fun onDeletedMessages() {
        // When the app instance receives this callback, perform a full sync with the app server.
        // This occurs when there are too many messages (>100) pending for your app on a particular
        // device at the time it connects or if the device hasn't connected to FCM
        // in more than one month.
    }

    override fun onNewToken(s: String) {
        LogMessage.e(TAG, "FirebaseToken:$s")
        firebaseUtils.postRefreshedToken(s)
    }

    companion object {
        private val TAG = MyFirebaseMessagingService::class.java.simpleName
    }

    override fun onDestroy() {
        super.onDestroy()
        firebaseUtils.onDestroy()
    }

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }
}