package com.contusfly.notification

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.text.TextUtils
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.ChatTypeEnum
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.PendingIntentHelper
import com.mirrorflysdk.flycommons.models.MessageType
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.getAppName
import com.contusfly.getDisplayName
import com.contusfly.utils.*
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage

object NotificationBuilderBelow24 {

    private val chatNotifications = hashMapOf<Int, ArrayList<ChatMessage>>()

    fun createNotification(context: Context, message: ChatMessage) {
        val chatJid = message.getChatUserJid()
        val notificationId = chatJid.hashCode().toLong().toInt()
        val profileDetails = ProfileDetailsUtils.getProfileDetails(chatJid)

        if (profileDetails?.isMuted == true)
            return

        try {
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notificationCompatBuilder = NotificationCompat.Builder(context, Constants.NOTIFICATION_CHANNEL_ID).apply {
                setSmallIcon(R.drawable.ic_notification_blue)
                setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_notification_blue))
                color = ContextCompat.getColor(context, R.color.colorAccent)
                setOnlyAlertOnce(true)
                setAutoCancel(true)
                setDefaults(Notification.DEFAULT_SOUND)
                setContentTitle(profileDetails?.getDisplayName())
            }

            if (!chatNotifications.containsKey(notificationId))
                chatNotifications[notificationId] = arrayListOf()

            if (BuildConfig.HIPAA_COMPLIANCE_ENABLED)
                hippaComplianceNotificationBuilder(context, notificationCompatBuilder)
            else
                appendChatMessageInNotificationBuilder(context, notificationCompatBuilder, notificationId, message)

            val notificationIntent = Intent(context, ChatManager.startActivity).apply {
                flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                putExtra(Constants.IS_FROM_NOTIFICATION, true)
                if (!TextUtils.isEmpty(chatJid)) putExtra(Constants.JID, chatJid)
            }
            val pendingIntent = PendingIntentHelper.getActivity(context, Constants.NOTIFICATION_ID, notificationIntent)
            notificationCompatBuilder.setContentIntent(pendingIntent)
            NotifyRefererUtils.setNotificationSound(notificationCompatBuilder)
            notificationManager.notify(Constants.NOTIFICATION_ID, notificationCompatBuilder.build())
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    private fun appendChatMessageInNotificationBuilder(
        context: Context,
        notificationCompatBuilder: NotificationCompat.Builder,
        notificationId: Int,
        message: ChatMessage
    ) {
        val messageList = chatNotifications[notificationId]!!
        messageList.add(message)

        if (messageList.size > 1) {
            GetMsgNotificationUtils.getMessagesInboxNotification(context, notificationCompatBuilder, messageList)
        } else {
            var messageContent = getMessageContent(message)
            messageContent = getGroupUserAppendedText(message, messageContent)
            notificationCompatBuilder.setContentText(messageContent)
        }
    }

    /**
     * Returns the message summary
     *
     * @param message Instance of message
     * @return String Summary of the message
     */
    private fun getMessageContent(message: ChatMessage): String {
        return if (MessageType.TEXT == message.getMessageType()) message.getMessageTextContent() else message.getMessageType().name.uppercase()
    }

    /**
     * Returns group user appended text if the chat type is group.
     *
     * @param message        Unseen message
     * @param messageContent Notification line message content
     * @return String Appended with group user
     */
    private fun getGroupUserAppendedText(message: ChatMessage, messageContent: String): String {
        var appendedContent = messageContent
        if (ChatTypeEnum.groupchat == message.getMessageChatType()) {
            val groupUser = ProfileDetailsUtils.getProfileDetails(message.getChatUserJid())
            appendedContent = groupUser?.getDisplayName() + ":" + messageContent
        }
        return appendedContent
    }

    private fun hippaComplianceNotificationBuilder(context: Context,
                                                   notBuilder: NotificationCompat.Builder) {
        val name = context.getAppName()
        notBuilder.setContentText("New Message")
        notBuilder.setDefaults(Notification.DEFAULT_SOUND)
        notBuilder.setContentTitle(GetMsgNotificationUtils.getSummaryTitle(name, FlyMessenger.getUnreadMessageCountExceptMutedChat(), FlyMessenger.getUnreadMessagesCount()))
    }

    fun cancelNotifications() {
        chatNotifications.clear()
    }
}