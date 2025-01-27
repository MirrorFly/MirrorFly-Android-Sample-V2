package com.contusfly.notification

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.service.notification.StatusBarNotification
import androidx.core.app.NotificationManagerCompat
import com.contusfly.BuildConfig
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.Utils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycall.call.utils.CallConstants

object AppNotificationManager {

    /**
     * Creates local notification when the app is in foreground for the incoming messages.
     *
     * @param context Instance of Context
     * @param chatMessage Received Message
     */
    fun createNotification(context: Context, chatMessage: ChatMessage, isFromDelete:Boolean = false, deletedChatUserJid:List<String> = arrayListOf()) {
        /**
         * if the user enables mute notification in settings, we should not show any notification
         */
        if (Utils.isMuteNotification())
            return

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (BuildConfig.HIPAA_COMPLIANCE_ENABLED)
                NotificationBuilder.createSecuredNotification(context, chatMessage)
            else
                privateChatNotificationValidate(context, chatMessage, isFromDelete, deletedChatUserJid)

        } else {
            NotificationBuilderBelow24.createNotification(context, chatMessage)
        }
    }

    private fun privateChatNotificationValidate(context: Context, chatMessage: ChatMessage, isFromDelete:Boolean = false, deletedChatUserJid:List<String> = arrayListOf()) {
        try {
            val chatJid = chatMessage.getChatUserJid()
            if(ChatManager.isPrivateChat(chatJid)) {
                NotificationBuilder.privateChatNotification(context, chatMessage)
            } else {
                NotificationBuilder.createNotification(context, chatMessage, isFromDelete, deletedChatUserJid)
            }
        } catch(e:Exception){
            LogMessage.e("Notification_Exception",e.toString())
        }


    }

    fun cancelNotifications(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val barNotifications: Array<StatusBarNotification> = notificationManager.activeNotifications
            for (notification in barNotifications) {
                if(notification.id != CallConstants.CALL_NOTIFICATION_ID) {
                    NotificationManagerCompat.from(context).cancel(notification.id)
                }
            }
            NotificationBuilder.cancelNotifications()
        } else {
            NotificationManagerCompat.from(context).cancel(Constants.NOTIFICATION_ID)
            NotificationBuilderBelow24.cancelNotifications()
        }
    }

    fun clearConversationOnNotification(context: Context, jId:String) {
        val id = jId.hashCode().toLong().toInt()
        if (NotificationBuilder.chatNotifications.size > 0) {
            val notification = NotificationBuilder.chatNotifications[id]
            notification?.messagingStyle?.messages?.clear()
            notification?.messages?.clear()
            notification?.messagingStyle?.historicMessages?.clear()
            notification?.messagingStyle?.conversationTitle = Constants.EMPTY_STRING
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val barNotifications: Array<StatusBarNotification> = notificationManager.activeNotifications
                for (notification in barNotifications) {
                    if (notification.id == id) NotificationManagerCompat.from(context).cancel(notification.id)
                }
                NotificationBuilder.chatNotifications.remove(id)
            } else {
                NotificationManagerCompat.from(context).cancel(Constants.NOTIFICATION_ID)
                NotificationBuilderBelow24.cancelNotifications()
            }
        }
    }
}