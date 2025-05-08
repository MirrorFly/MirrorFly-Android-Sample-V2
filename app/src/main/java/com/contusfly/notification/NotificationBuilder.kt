package com.contusfly.notification

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.service.notification.StatusBarNotification
import android.text.TextUtils
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.Person
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.IconCompat
import com.contusfly.*
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.PendingIntentHelper
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.contusfly.call.MissedCallNotificationUtils
import com.contusfly.utils.*
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycommons.ChatType
import java.io.File


object NotificationBuilder {

    val chatNotifications = hashMapOf<Int, NotificationModel>()
    private var securedNotificationChannelId = 0
    private var privateChatNotificationChannelId = 0
    var file: File?=null
    var groupFile: File?=null
    var privateChatDeletedMessageCount = 0;
    /**
     * Create notification when new chat message received
     * @param context Context of the application
     * @param message Instance of the ChatMessage
     */
    @SuppressWarnings("kotlin:S3776")
    fun createNotification(context: Context, message: ChatMessage, isFromDelete:Boolean = false, deletedChatUserJid:List<String> = arrayListOf()) {
        var lastMessageTime: Long = 0
        val chatJid = message.getChatUserJid()
        val lastMessageContent = StringBuilder()
        val notificationId = chatJid.hashCode().toLong().toInt()
        val profileDetails = ProfileDetailsUtils.getProfileDetails(chatJid)
        LogMessage.e("NOT_ID",notificationId.toString())
        if (profileDetails?.isMuted == true)
            return

        var messagingStyle =
            NotificationCompat.MessagingStyle(Person.Builder().setName("Me").build())

        if (!chatNotifications.containsKey(notificationId)){
            chatNotifications[notificationId] = NotificationModel(messagingStyle, arrayListOf(),0)
            LogMessage.e("NOT_ID","New_chat $notificationId")
        }

        val notificationModel = chatNotifications[notificationId]

        val isMessageRecalled = message.isMessageRecalled()
        if(isFromDelete) {
            clearNotificationTray(deletedChatUserJid, context)
            return
        }

        notificationModel?.let {
            if (isMessageRecalledOrEditedMessage(isMessageRecalled, message)) { //if message was recalled then rebuild the message style
                val oldMessages = notificationModel.messages.toMutableList()
                notificationModel.messages.clear()
                oldMessages.forEach { chatMessage ->
                    notificationModel.messages.add(addMessagesInNotificationModel(message, chatMessage))
                    appendChatMessageInMessageStyle(
                        context,
                        lastMessageContent,
                        messagingStyle,
                        if (chatMessage.messageId == message.messageId) message else chatMessage
                    )
                }
                notificationModel.messagingStyle = messagingStyle
            } else {
                messagingStyle = notificationModel.messagingStyle
                notificationModel.messages.add(message)
                appendChatMessageInMessageStyle(
                    context,
                    lastMessageContent,
                    messagingStyle,
                    message
                )
            }
            setConversationTitleMessagingStyle(
                context,
                profileDetails,
                notificationModel.messages.size,
                messagingStyle
            )
            lastMessageTime = if (message.getMessageSentTime()
                    .toString().length > 13
            ) message.getMessageSentTime() / 1000 else message.getMessageSentTime()
        }

        displayMessageNotification(
            context,
            notificationId,
            profileDetails,
            messagingStyle,
            lastMessageContent.toString(),
            lastMessageTime,
            message
        )
       displaySummaryNotification(context, lastMessageContent)
    }

    private fun addMessagesInNotificationModel(message: ChatMessage, chatMessage: ChatMessage):ChatMessage{
       return if (chatMessage.messageId == message.messageId) message else chatMessage
    }

    fun clearNotificationTray(deletedChatUserJid: List<String>, context: Context) {
        deletedChatUserJid.forEach {
            AppNotificationManager.clearConversationOnNotification(context, it)
        }
        if (chatNotifications.size == 0) {
            AppNotificationManager.cancelNotifications(context)
        }
    }

    private fun isMessageRecalledOrEditedMessage(isMessageRecalled:Boolean,message: ChatMessage):Boolean{
        return isMessageRecalled || (message.isEdited && FlyMessenger.isOriginalMessageAvailable(
            message.messageId
        ))
    }

    /**
     * Append [ChatMessage] content to the provided [NotificationCompat.MessagingStyle]
     * @param context Context of the application
     * @param messageContent Last message content to be updated
     * @param messagingStyle Unique messaging style of the conversation
     * @param message Instance of the ChatMessage
     */
    private fun appendChatMessageInMessageStyle(
        context: Context,
        messageContent: StringBuilder,
        messagingStyle: NotificationCompat.MessagingStyle,
        message: ChatMessage
    ) {
        val userProfile: ProfileDetails? =
            ProfileDetailsUtils.getProfileDetails(message.getSenderUserJid())
        val name = userProfile?.getDisplayName() ?: Constants.EMPTY_STRING
        val contentBuilder = StringBuilder()
        contentBuilder.append(GetMsgNotificationUtils.getMessageSummary(context, message))
        messageContent.append(contentBuilder)

        val userProfileImage = getUserProfileImage(context, userProfile)
        if (userProfile != null && userProfileImage != null) {
            messagingStyle.addMessage(
                contentBuilder, message.getMessageSentTime(),
                Person.Builder().setName(name)
                    .setIcon(IconCompat.createWithBitmap(userProfileImage)).build()
            )
        } else {
            messagingStyle.addMessage(
                contentBuilder, message.getMessageSentTime(),
                Person.Builder().setName(name)
                    .setIcon(IconCompat.createWithResource(context, R.drawable.ic_notification_blue)).build())
        }
    }

    /**
     * Set the title of the conversation to the provided [NotificationCompat.MessagingStyle]
     * @param context Context of the application
     * @param profileDetails ProfileDetails of the conversation
     * @param messagingStyle Unique messaging style of the conversation
     * @param messagesCount total unread messages count of the conversation
     */
    private fun setConversationTitleMessagingStyle(
        context: Context,
        profileDetails: ProfileDetails?,
        messagesCount: Int,
        messagingStyle: NotificationCompat.MessagingStyle
    ) {
        val title = profileDetails?.getDisplayName()
        if (messagesCount > 1) {
            val appendMessagesLabel = " " + context.getString(R.string.messages_label) + ")"
            val modifiedTitle: String
            if (profileDetails!!.isGroupProfile) {
                modifiedTitle = "$title ($messagesCount$appendMessagesLabel"
                messagingStyle.setGroupConversation(true).conversationTitle = modifiedTitle
            } else if (chatNotifications.size >= 1) {
                modifiedTitle = " ($messagesCount$appendMessagesLabel"
                messagingStyle.conversationTitle = modifiedTitle
            }
        } else if (profileDetails!!.isGroupProfile) messagingStyle.setGroupConversation(true).conversationTitle =
            title
    }

    /**
     * Create [NotificationCompat.Builder] and display chat message notification
     * @param context Context of the application
     * @param notificationId Unique notification id of the conversation
     * @param profileDetails ProfileDetails of the conversation
     * @param messagingStyle Unique MessagingStyle of the conversation
     * @param lastMessageContent Last message of the conversation
     * @param lastMessageTime Time of the last message
     */
    private fun displayMessageNotification(
        context: Context,
        notificationId: Int,
        profileDetails: ProfileDetails?,
        messagingStyle: NotificationCompat.MessagingStyle,
        lastMessageContent: String,
        lastMessageTime: Long,
        message: ChatMessage
    ) {
        val title = profileDetails?.getDisplayName()
        val chatJid = profileDetails?.jid

        val notificationIntent = getNormalChatNotificationIntent(context, chatJid!!)

        val requestID = System.currentTimeMillis().toInt()
        val mainPendingIntent =
            PendingIntentHelper.getActivity(context, requestID, notificationIntent)
        val notificationCompatBuilder = NotificationCompat.Builder(
            context,
            buildNotificationChannelAndGetChannelId(context, notificationId.toString(), null,false)
        )
        chatNotifications[notificationId]!!.unReadMessageCount++
        val unReadMessageCount  = if (chatNotifications.size == 1) getTotalUnReadMessageCount(notificationId) else chatNotifications[notificationId]?.unReadMessageCount ?:1
        LogMessage.i(TAG,"unReadMessageCount $unReadMessageCount")
        chatNotifications[notificationId]!!.unReadMessageCount = unReadMessageCount
        notificationCompatBuilder.apply {
            setStyle(messagingStyle)
            setContentTitle(title)
            setContentText(lastMessageContent)
            setAutoCancel(true)
            setSmallIcon(R.drawable.ic_notification_blue)
            color = ContextCompat.getColor(context, R.color.colorAccent)
            setContentIntent(mainPendingIntent)
            setGroup(GROUP_KEY_MESSAGE)  // Adds the notification to the group sharing the specified key.
            setNumber(unReadMessageCount)
            setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_SUMMARY)
            setCategory(NotificationCompat.CATEGORY_MESSAGE)
            priority = NotificationCompat.PRIORITY_HIGH
            setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            setLargeIcon(getLargeUserOrGroupImage(context, profileDetails, message))


            if (lastMessageTime > 0)
                setWhen(lastMessageTime)

            if (SharedPreferenceManager.getBoolean(Constants.VIBRATION)) {
                setVibrate(NotifyRefererUtils.defaultVibrationPattern)
            } else {
                setVibrate(null)
            }
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            NotifyRefererUtils.setNotificationSound(notificationCompatBuilder)

        val mNotificationManagerCompat: NotificationManagerCompat =
            NotificationManagerCompat.from(context)
        mNotificationManagerCompat.notify(notificationId, notificationCompatBuilder.build())
    }

    private fun getNormalChatNotificationIntent(context: Context, chatJid: String) : Intent {

        val notificationIntent = Intent(context, ChatManager.startActivity).apply {
            flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra(Constants.IS_FROM_NOTIFICATION, true)
            if(AppLifecycleListener.isAPPForeground){
                putExtra(Constants.AUTHENTICATION_NEED, false)
            } else {
                putExtra(Constants.AUTHENTICATION_NEED, true)
            }
            if (!TextUtils.isEmpty(chatJid)) putExtra(Constants.JID, chatJid)
        }
        return notificationIntent
    }

    /**
     * Create [NotificationCompat.Builder] and display summary of the multiple chat conversations
     * @param context Context of the application
     * @param lastMessageContent Last message of the conversation
     */
    private fun displaySummaryNotification(context: Context, lastMessageContent: StringBuilder) {
        try {
            val summaryText = StringBuilder()
            val appTitle = context.resources.getString(R.string.title_app_name)
            summaryText.append(getMessagesCount()).append(" messages from ")
                .append(chatNotifications.size).append(" chats")

            val inboxStyle = NotificationCompat.InboxStyle().setBigContentTitle(appTitle)
            inboxStyle.setSummaryText(summaryText)
            for (notificationInlineMessage in 0 until chatNotifications.size) inboxStyle.addLine("notificationInlineMessage")
            val summaryBuilder =
                NotificationCompat.Builder(context, buildNotificationChannelAndGetChannelId(context, Constants.EMPTY_STRING,SUMMARY_CHANNEL_NAME,true)).apply {
                    setContentTitle(appTitle)
                    setContentText(lastMessageContent)
                    setSmallIcon(R.drawable.ic_notification_blue)
                    color = ContextCompat.getColor(context, R.color.colorAccent)
                    setContentIntent(getSummaryPendingIntent(context))
                    setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_notification_blue))
                    setAutoCancel(true)
                    setNumber(chatNotifications.size)
                    setStyle(inboxStyle)
                    setGroup(GROUP_KEY_MESSAGE)
                    setGroupSummary(true)
                    build()
                }

            if (chatNotifications.size > 0) {
                val mNotificationManagerCompat: NotificationManagerCompat =
                    NotificationManagerCompat.from(context)
                mNotificationManagerCompat.notify(SUMMARY_ID, summaryBuilder.build())
            }
        } catch (e:Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Build notification channel with given notification ID.
     * @param context Context of the application
     * @param notificationId Unique notification id of the conversation
     * @return String notificationId
     */
    private fun buildNotificationChannelAndGetChannelId(context: Context, notificationId: String?, notificationName: String?, isSummaryNotification: Boolean): String {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotifyRefererUtils.buildNotificationChannel(context, notificationManager,notificationId, notificationName, isSummaryNotification)
        } else
            notificationId ?: NotifyRefererUtils.getNotificationId()
    }

    /**
     * Create Pending Intent to open application when tap on summary notification
     * @param context Context of the application
     * @return PendingIntent
     */
    private fun getSummaryPendingIntent(context: Context): PendingIntent {
        val notificationIntent = Intent(context, ChatManager.startActivity)
        notificationIntent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK
                or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        notificationIntent.putExtra(Constants.IS_FROM_NOTIFICATION, true)
        notificationIntent.putExtra(Constants.JID, "")
        val requestID = System.currentTimeMillis().toInt()
        return PendingIntentHelper.getActivity(context, requestID, notificationIntent)
    }

    /**
     * Get total unread messages count showing in the Push
     * @return total unread messages count
     */
    private fun getMessagesCount(): Long {
        var totalMessagesCount = 0L
        chatNotifications.values.forEach { notificationModel ->
            totalMessagesCount += notificationModel.messages.size
        }
        return totalMessagesCount
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getUserProfileImage(context: Context, profileDetails: ProfileDetails?): Bitmap? {
        var bitmapUserProfile: Bitmap? = null
        var image = if (!profileDetails?.thumbImage.isNullOrEmpty()) {
            profileDetails?.thumbImage
        } else profileDetails?.image ?: Constants.EMPTY_STRING
        try {
            if (null != image && image.isNotEmpty()) {
                bitmapUserProfile = getCircularBitmap(BitmapFactory.decodeFile(file?.canonicalPath))
            } else {
                // Load Default icon based on name
                bitmapUserProfile = if (profileDetails != null && profileDetails.isGroupProfile) {
                    drawableToBitmap(context.getDrawable(R.drawable.ic_group_avatar))
                } else {
                    getCircularBitmap(drawableToBitmap(setDrawable(context, profileDetails)))
                }
            }
        } catch (e: Exception) {
            Log.d("qwerty", "Inside getProfileImage Exception ===> ${e.message}")
        }
        return bitmapUserProfile
    }

    private fun getLargeUserOrGroupImage(
        context: Context,
        profileDetails: ProfileDetails?,
        message: ChatMessage
    ): Bitmap? {
        var bitmapUserProfile: Bitmap? = null
        var image = if (!profileDetails?.thumbImage.isNullOrEmpty()) {
            profileDetails?.thumbImage
        } else profileDetails?.image ?: Constants.EMPTY_STRING
        try {
            if (message.getChatType() == ChatType.TYPE_GROUP_CHAT) {
                bitmapUserProfile = if (null != image && image.isNotEmpty()) getCircularBitmap(
                    BitmapFactory.decodeFile(groupFile?.canonicalPath)
                ) else drawableToBitmap(context.getDrawable(R.drawable.ic_group_avatar))

            } else {
                bitmapUserProfile = if (null != image && image.isNotEmpty()) getCircularBitmap(
                    BitmapFactory.decodeFile(file?.canonicalPath)
                ) else getCircularBitmap(drawableToBitmap(setDrawable(context, profileDetails)))
            }

        } catch (e: Exception) {
            Log.d("qwerty", "Inside getProfileImage Exception ===> ${e.message}")
        }
        return bitmapUserProfile
    }


    private fun getCircularBitmap(bitmap: Bitmap?): Bitmap {
        val output: Bitmap = if (bitmap!!.width > bitmap.height) {
            Bitmap.createBitmap(bitmap.height, bitmap.height, Bitmap.Config.ARGB_8888)
        } else {
            Bitmap.createBitmap(bitmap.width, bitmap.width, Bitmap.Config.ARGB_8888)
        }
        val canvas = Canvas(output)
        val color = -0xbdbdbe
        val paint = Paint()
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        val r: Int = if (bitmap.width > bitmap.height) {
            bitmap.height / 2
        } else {
            bitmap.width / 2
        }
        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color
        canvas.drawCircle(r.toFloat(), r.toFloat(), r.toFloat(), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, rect, rect, paint)
        return output
    }

    @Synchronized
    fun setDrawable(context: Context, profileDetails: ProfileDetails?): Drawable? {
        if (profileDetails != null && !profileDetails.isGroupProfile) {
            return SetDrawable(context, profileDetails).setDrawableForProfile(profileDetails.getDisplayName())!!
        }
        return ContextCompat.getDrawable(context, R.drawable.ic_profile)
    }

    private fun drawableToBitmap(drawable: Drawable?): Bitmap? {
        if (drawable is BitmapDrawable && drawable.bitmap != null) {
            return drawable.bitmap
        }
        val bitmap: Bitmap = if (drawable!!.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            Bitmap.createBitmap(
                1,
                1,
                Bitmap.Config.ARGB_8888
            ) // Single color bitmap will be created of 1x1 pixel
        } else {
            Bitmap.createBitmap(
                drawable.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
        }
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    /**
     * Creates a MESSAGING_STYLE Notification for the devices starting on API level 24, otherwise, displays a basic BIG_TEXT_STYLE notification.
     *
     * @param message The most recent received message
     */
    fun createSecuredNotification(context: Context, message: ChatMessage) {
        val name = context.getAppName()
        val chatJid = message.getChatUserJid()
        val lastMessageContent = StringBuilder()
        val notificationId = chatJid.hashCode().toLong().toInt()
        val profileDetails = ProfileDetailsUtils.getProfileDetails(chatJid)

        if (profileDetails?.isMuted == true)
            return

        val messagingStyle = NotificationCompat.MessagingStyle(Person.Builder().setName("Me").build())

        if (!chatNotifications.containsKey(notificationId))
            chatNotifications[notificationId] = NotificationModel(messagingStyle, arrayListOf(),0)

        val notificationModel = chatNotifications[notificationId]

        notificationModel!!.messages.add(message)

        if (securedNotificationChannelId == 0)
            securedNotificationChannelId = notificationId

        lastMessageContent.append("New Message")

        messagingStyle.addMessage(lastMessageContent, message.getMessageSentTime(),
            Person.Builder()
                .setName(GetMsgNotificationUtils.getSummaryTitle(name, FlyMessenger.getUnreadMessageCountExceptMutedChat(), FlyMessenger.getUnreadMessagesCount()))
                .setIcon(IconCompat.createWithResource(context, R.drawable.ic_notification_blue))
                .build())

        val lastMessageTime: Long = if (message.getMessageSentTime().toString().length > 13) message.getMessageSentTime() / 1000 else message.getMessageSentTime()

        val notificationIntent = Intent(context, ChatManager.startActivity).apply {
            flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra(Constants.IS_FROM_NOTIFICATION, true)
            if (!TextUtils.isEmpty(chatJid)) putExtra(Constants.JID, "")
        }
        val requestID = System.currentTimeMillis().toInt()
        val mainPendingIntent = PendingIntentHelper.getActivity(context, requestID, notificationIntent)
        val notificationCompatBuilder = NotificationCompat.Builder(
            context,
            buildNotificationChannelAndGetChannelId(context, securedNotificationChannelId.toString(), null,false)
        )

        notificationCompatBuilder.apply {
            setStyle(messagingStyle)
            setContentTitle(name)
            setContentText(lastMessageContent)
            setAutoCancel(true)
            setSmallIcon(R.drawable.ic_notification_blue)
            color = ContextCompat.getColor(context, R.color.colorAccent)
            setContentIntent(mainPendingIntent)
            setGroup(GROUP_KEY_MESSAGE)  // Adds the notification to the group sharing the specified key.
            setNumber(FlyMessenger.getUnreadMessageCountExceptMutedChat())
            setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_SUMMARY)
            setCategory(NotificationCompat.CATEGORY_MESSAGE)
            priority = NotificationCompat.PRIORITY_HIGH
            setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

            if (lastMessageTime > 0)
                setWhen(lastMessageTime)

            if (SharedPreferenceManager.getBoolean(Constants.VIBRATION)) {
                setVibrate(NotifyRefererUtils.defaultVibrationPattern)
            } else {
                setVibrate(null)
            }
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            NotifyRefererUtils.setNotificationSound(notificationCompatBuilder)

        val mNotificationManagerCompat: NotificationManagerCompat =
            NotificationManagerCompat.from(context)
        mNotificationManagerCompat.notify(securedNotificationChannelId, notificationCompatBuilder.build())

        displaySummaryNotification(context, lastMessageContent)
    }


    fun privateChatNotification(context: Context, message: ChatMessage) {
        val chatJid = message.getChatUserJid()
        val name = context.getAppName()
        val lastMessageContent = StringBuilder()
        val notificationId = chatJid.hashCode().toLong().toInt()
        val profileDetails = ProfileDetailsUtils.getProfileDetails(chatJid)
        LogMessage.e("NOT_ID",notificationId.toString())
        if (profileDetails?.isMuted == true)
            return

        var messagingStyle = NotificationCompat.MessagingStyle(Person.Builder().setName("Me").build())

        if (!chatNotifications.containsKey(notificationId))
            chatNotifications[notificationId] = NotificationModel(messagingStyle, arrayListOf(),0)

        val privateChatnotificationModel = chatNotifications[notificationId]
        privateChatnotificationModel!!.messages.add(message)

        if (privateChatNotificationChannelId == 0)
            privateChatNotificationChannelId = notificationId

        lastMessageContent.append("New Message")

        var messageCount=FlyMessenger.getUnreadPrivateChatUserMessageCount()
        if(message.isMessageRecalled) privateChatDeletedMessageCount+= 1

        var finalMessageCount=messageCount- privateChatDeletedMessageCount

        messagingStyle.addMessage(lastMessageContent, message.getMessageSentTime(),
            Person.Builder()
                .setName(GetMsgNotificationUtils.getSummaryTitle(name, finalMessageCount, FlyMessenger.getUnreadPrivateChatMessagesCount()))
                .setIcon(IconCompat.createWithResource(context, R.drawable.ic_notification_blue))
                .build())

        val lastMessageTime: Long = if (message.getMessageSentTime().toString().length > 13) message.getMessageSentTime() / 1000 else message.getMessageSentTime()

        val notificationIntent = getPrivateChatNotificationIntent(context,chatJid)
        val requestID = System.currentTimeMillis().toInt()
        val mainPendingIntent = PendingIntentHelper.getActivity(context, requestID, notificationIntent)
        val notificationCompatBuilder = NotificationCompat.Builder(
            context,
            buildNotificationChannelAndGetChannelId(context, privateChatNotificationChannelId.toString(), null,false)
        )

        notificationCompatBuilder.apply {
            setStyle(messagingStyle)
            setContentTitle(name)
            setContentText(lastMessageContent)
            setAutoCancel(true)
            setSmallIcon(R.drawable.ic_notification_blue)
            color = ContextCompat.getColor(context, R.color.colorAccent)
            setContentIntent(mainPendingIntent)
            setGroup(GROUP_KEY_MESSAGE)  // Adds the notification to the group sharing the specified key.
            setNumber(FlyMessenger.getUnreadMessageCountExceptMutedChat())
            setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_SUMMARY)
            setCategory(NotificationCompat.CATEGORY_MESSAGE)
            priority = NotificationCompat.PRIORITY_HIGH
            setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

            if (lastMessageTime > 0)
                setWhen(lastMessageTime)

            if (SharedPreferenceManager.getBoolean(Constants.VIBRATION)) {
                setVibrate(NotifyRefererUtils.defaultVibrationPattern)
            } else {
                setVibrate(null)
            }
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            NotifyRefererUtils.setNotificationSound(notificationCompatBuilder)

        val mNotificationManagerCompat: NotificationManagerCompat =
            NotificationManagerCompat.from(context)
        mNotificationManagerCompat.notify(privateChatNotificationChannelId, notificationCompatBuilder.build())

        if(finalMessageCount > 0) {
            displaySummaryNotification(context, lastMessageContent)
        } else cancelPrivateChatNotifications(context)
    }

    private fun getPrivateChatNotificationIntent(context: Context, chatJid: String) : Intent {
        val notificationIntent = Intent(context, ChatManager.startActivity).apply {
            flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra(Constants.IS_FROM_NOTIFICATION, true)
            putExtra(Constants.PRIVATE_CHAT, true)
            if(AppLifecycleListener.isAPPForeground && AppLifecycleListener.isPresentPrivateChat){
                putExtra(Constants.AUTHENTICATION_NEED, false)
            } else {
                putExtra(Constants.AUTHENTICATION_NEED, true)
                if(AppLifecycleListener.isPresentPrivateChat) putExtra(Constants.IS_SHOW_PRIVATE_CHAT_LIST, true)
            }
            if (!TextUtils.isEmpty(chatJid)) putExtra(Constants.JID, chatJid)
        }
        return notificationIntent
    }

    fun cancelPrivateChatNotifications(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val barNotifications: Array<StatusBarNotification> = notificationManager.activeNotifications
            for (notification in barNotifications) {
                NotificationManagerCompat.from(context).cancel(notification.id)
            }
        } else {
            NotificationManagerCompat.from(context).cancel(Constants.NOTIFICATION_ID)
            NotificationBuilderBelow24.cancelNotifications()
        }
    }


    fun cancelNotifications() {
        chatNotifications.clear()
        securedNotificationChannelId = 0
        privateChatNotificationChannelId = 0
        privateChatDeletedMessageCount = 0
    }

    private fun getTotalUnReadMessageCount(notificationId: Int): Int {
        return if (MissedCallNotificationUtils.unReadCallCount == 0) FlyMessenger.getUnreadMessageCountExceptMutedChat() + CallLogManager.getUnreadMissedCallCount() else chatNotifications[notificationId]?.unReadMessageCount ?: 1
    }

    // A unique identifier string for creating the group notification.
    private const val GROUP_KEY_MESSAGE: String = BuildConfig.APPLICATION_ID + ".MESSAGE"
    private const val SUMMARY_ID = 0
    const val SUMMARY_CHANNEL_ID = "message_summary_id"
    const val SUMMARY_CHANNEL_NAME = "Chat Summary"
}