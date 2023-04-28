package com.contusfly.call

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.app.Notification
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.call.utils.CallConstants
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.mirrorflysdk.flycommons.PendingIntentHelper
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.activities.DashboardActivity
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.notification.NotificationBuilder
import com.contusfly.utils.Constants
import com.contusfly.utils.NotifyRefererUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.FlyMessenger
import me.leolin.shortcutbadger.ShortcutBadger

object CallNotificationUtils {

    var unReadCallCount = 0
    /**
     * Creates the missed call notification
     *
     * @param context        Instance of Context
     * @param message        message
     * @param messageContent notification message content
     */
    fun createNotification(context: Context, message: String?, messageContent: String?) {
        val randomNumberGenerator = java.util.Random(System.currentTimeMillis())
        val channelId = randomNumberGenerator.nextInt().toString()
        val notificationManager = context
                .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        unReadCallCount += 1
        unReadCallCount = if (NotificationBuilder.chatNotifications.size == 0) getTotalUnReadCount() else unReadCallCount

        LogMessage.i(TAG,"unReadCallCount $unReadCallCount")
        val notBuilder = NotificationCompat.Builder(context, channelId)
        notBuilder.setSmallIcon(getNotificationIcon())
        notBuilder.color = ContextCompat.getColor(context, R.color.colorAccent)
        notBuilder.setContentTitle(message)
        notBuilder.setContentText(messageContent)
        notBuilder.setAutoCancel(true)
        notBuilder.setNumber(unReadCallCount)
        val createdChannel: NotificationChannel
        val notificationSoundUri = Uri.parse(SharedPreferenceManager.getString(Constants.NOTIFICATION_URI))
        val isRing = SharedPreferenceManager.getBoolean(Constants.NOTIFICATION_SOUND)
        val isVibrate = SharedPreferenceManager.getBoolean(Constants.VIBRATION)
        val channelImportance = getChannelImportance(isRing, isVibrate)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the channel for the notification

            when {
                isRing -> {
                    val mChannel = NotificationChannel(channelId, channelId, channelImportance)
                    val audioAttributes = AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                        .build()
                    if(notificationSoundUri != null) {
                        NotifyRefererUtils.setNotificationChannelSound(notificationSoundUri,audioAttributes,
                            mChannel,context)
                        if (isVibrate) {
                            mChannel.vibrationPattern =
                                NotifyRefererUtils.defaultVibrationPattern
                        } else {
                            mChannel.vibrationPattern = longArrayOf(0L, 0L, 0L, 0L, 0L)
                        }
                    } else {
                        notificationSoundUri?.let {
                            NotifyRefererUtils.setNotificationChannelSound(
                                it,audioAttributes,
                                mChannel,context)
                        }
                    }
                    createdChannel = mChannel
                }
                isVibrate -> {
                    val priorityChannel = NotificationChannel(channelId, channelId, channelImportance)
                    priorityChannel.shouldVibrate()
                    priorityChannel.vibrationPattern = NotifyRefererUtils.defaultVibrationPattern
                    priorityChannel.shouldVibrate()
                    priorityChannel.enableVibration(true)
                    priorityChannel.setSound(null, null)
                    createdChannel = priorityChannel
                }
                else -> {
                    val lowPriorityChannel = NotificationChannel(channelId, channelId, channelImportance)
                    createdChannel = lowPriorityChannel
                }
            }
            // Set the Notification Channel for the Notification Manager.

            notificationManager.createNotificationChannel(createdChannel)
            notBuilder.setChannelId(channelId)

        } else {
            NotifyRefererUtils.setNotificationSound(notBuilder)
        }

        val notificationIntent = Intent(context, DashboardActivity::class.java)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        notificationIntent.putExtra(CallUtils.IS_CALL_NOTIFICATION, true)
        val pendingIntent = PendingIntentHelper.getActivity(
            context, CallConstants.CALL_NOTIFICATION_ID,
            notificationIntent
        )
        notBuilder.setContentIntent(pendingIntent)
        val notification = notBuilder.build()
        if (!SharedPreferenceManager.getBoolean(Constants.MUTE_NOTIFICATION))
            notificationManager.notify(CallConstants.CALL_NOTIFICATION_ID, notification)
    }

    private fun getChannelImportance(isRing: Boolean, isVibrate: Boolean): Int {
        return if (isRing || isVibrate)
            NotificationManager.IMPORTANCE_HIGH
        else
            NotificationManager.IMPORTANCE_LOW
    }

    private fun getNotificationIcon(): Int {
        LogMessage.i(TAG, "${com.contus.call.CallConstants.CALL_UI} getNotificationIcon()")
        return R.drawable.ic_notification_blue
    }

    private fun getTotalUnReadCount(): Int {
        return if (NotificationBuilder.chatNotifications.size == 0) FlyMessenger.getUnreadMessageCountExceptMutedChat() + CallLogManager.getUnreadMissedCallCount() else 1
    }

    fun cancelNotifications() {
        unReadCallCount = 0
    }


}