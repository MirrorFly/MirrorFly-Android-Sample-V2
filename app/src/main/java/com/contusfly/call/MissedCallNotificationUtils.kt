package com.contusfly.call

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.activities.DashboardActivity
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.constants.MobileApplication
import com.contusfly.emptyString
import com.contusfly.getDisplayName
import com.contusfly.notification.NotificationBuilder
import com.contusfly.utils.Constants
import com.contusfly.utils.NotifyRefererUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.utils.Utils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.flycall.call.utils.CallConstants
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.PendingIntentHelper
import com.mirrorflysdk.flycommons.models.CallMetaData
import java.security.SecureRandom

object MissedCallNotificationUtils {

    var unReadCallCount = 0
    var missedCallNotificationCount = 0
    private var missedCallNotificationUserJidList = ArrayList<String>()
    var missedCallNotificationUserNames = emptyString()
    private var missedCallTypeList = ArrayList<String>()
    var missedCallNotificationCallType = emptyString()
    /**
     * Creates the missed call notification
     *
     * @param context        Instance of Context
     * @param message        message
     * @param messageContent notification message content
     */
    fun createNotification(context: Context, message: String?, messageContent: String?) {
        val randomNumberGenerator = SecureRandom()
        val bound = 1000
        val channelId = randomNumberGenerator.nextInt(bound).toString()
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
        if (!Utils.isMuteNotification())
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

    fun createMissCallNotification(isOneToOneCall: Boolean, userJid: String, groupId: String?, callType: String,
                                   userList: ArrayList<String>, callMeta: Array<CallMetaData>?) {
        try {
            LogMessage.d(TAG, "onMissedCall")
            missedCallNotificationCount += 1
            addMissedCallNotificationUsers(isOneToOneCall, userJid, groupId, callType)
            val notificationContent = getMissedCallNotificationContent(isOneToOneCall, userJid, groupId, callType, userList,callMeta)
            if (missedCallNotificationCount > 1) {
                createNotification(
                        MobileApplication.getContext(),
                        " $missedCallNotificationCount $missedCallNotificationCallType", //Title Missed call Notification
                        missedCallNotificationUserNames //Message Content Missed call from whom
                )
            } else {
                createNotification(
                        MobileApplication.getContext(),
                        notificationContent.first, //Title Missed call Notification
                        notificationContent.second //Message Content Missed call from whom
                )
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e.toString())
        }
    }

    private fun getMissedCallNotificationContent(isOneToOneCall: Boolean, userJid: String, groupId: String?, callType: String,
                                                 userList: ArrayList<String>,callMeta: Array<CallMetaData>?): Pair<String, String> {
        LogMessage.d(TAG, "#getMissedCallNotificationContent callMetadata Size : ${callMeta?.size}")
        var messageContent : String
        val missedCallMessage = StringBuilder()
        missedCallMessage.append(ChatManager.applicationContext.resources.getString(R.string.you_missed_call))
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
            messageContent = ChatManager.applicationContext.resources.getString(R.string.new_missed_call)
        return Pair(missedCallMessage.toString(), messageContent)
    }

    fun clearMissedCallNotificationDetails() {
        missedCallNotificationCount = 0
        missedCallNotificationUserJidList.clear()
        missedCallNotificationUserNames = emptyString()
        missedCallTypeList.clear()
        missedCallNotificationCallType = emptyString()
    }

    fun addMissedCallNotificationUsers(isOneToOneCall: Boolean, userJid: String, groupId: String?, callType: String) {
        if (!missedCallTypeList.contains(callType))
            missedCallTypeList.add(callType)
        if (isOneToOneCall) {
            if (!missedCallNotificationUserJidList.contains(userJid)) {
                missedCallNotificationUserJidList.add(userJid)
            }
            sortMissedCallList(userJid)
        } else {
            if (!missedCallNotificationUserJidList.contains(groupId)) {
                missedCallNotificationUserJidList.add(groupId!!)
            }
            sortMissedCallList(groupId!!)
        }
        missedCallNotificationCallType = " " + identifyCallType(missedCallTypeList)
    }

    private fun sortMissedCallList(userJid: String) {
        val index = missedCallNotificationUserJidList.indexOf(userJid)
        if (index != -1 && index != 0) {
            // Remove the userJid from its current position and add it to the first position
            missedCallNotificationUserJidList.removeAt(index)
            missedCallNotificationUserJidList.add(0, userJid)
        }
        missedCallNotificationUserNames =
            getSortedUserNames().joinToString(separator = ", ")
    }

    private fun identifyCallType(missedCallTypeList: List<String>): String {
        var hasAudio = false
        var hasVideo = false

        // Check if "audio" & "video" is present in the list
        for (callType in missedCallTypeList) {
            when (callType) {
                CallType.AUDIO_CALL -> hasAudio = true
                CallType.VIDEO_CALL -> hasVideo = true
            }
            if (hasAudio && hasVideo) {
                return "missed calls"
            }
        }

        // Determine the call type ("audio" or "video") present in the list
        return when {
            hasAudio -> "missed audio calls"
            hasVideo -> "missed video calls"
            else -> "missed calls"
        }
    }

    private fun getSortedUserNames(): List<String> {
        val sortedNames = mutableListOf<String>()
        for (userJid in missedCallNotificationUserJidList) {
            val displayName = ProfileDetailsUtils.getProfileDetails(userJid)?.getDisplayName()
            if (displayName != null) {
                sortedNames.add(displayName)
            }
        }
        return sortedNames
    }


}