package com.contusfly.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J,\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\n\u0010&\u001a\u00060\'j\u0002`(2\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020\u001fH\u0002J,\u0010+\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020#J\u000e\u00101\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u001e\u00102\u001a\u00020#2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0004042\u0006\u0010$\u001a\u00020%H\u0002J0\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u00106\u001a\u00020/2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u000404J\u0016\u00107\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001fJB\u00108\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010,\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u001c\u0010>\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\n\u0010;\u001a\u00060\'j\u0002`(H\u0002J\u0014\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010C\u001a\u00020@2\b\u0010D\u001a\u0004\u0018\u00010@H\u0002J$\u0010E\u001a\u0004\u0018\u00010@2\u0006\u0010$\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010F\u001a\u00020=H\u0002J\u0018\u0010G\u001a\u00020H2\u0006\u0010$\u001a\u00020%2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u0018\u0010J\u001a\u00020H2\u0006\u0010$\u001a\u00020%2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010M\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002J\u001c\u0010N\u001a\u0004\u0018\u00010@2\u0006\u0010$\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010:H\u0003J\u0018\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020/2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0016\u0010Q\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001fJ*\u0010R\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010S\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0002J\u001a\u0010T\u001a\u0004\u0018\u00010B2\u0006\u0010$\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010:R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/contusfly/notification/NotificationBuilder;", "", "()V", "GROUP_KEY_MESSAGE", "", "SUMMARY_CHANNEL_ID", "SUMMARY_CHANNEL_NAME", "SUMMARY_ID", "", "chatNotifications", "Ljava/util/HashMap;", "Lcom/contusfly/notification/NotificationModel;", "getChatNotifications", "()Ljava/util/HashMap;", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "groupFile", "getGroupFile", "setGroupFile", "privateChatDeletedMessageCount", "getPrivateChatDeletedMessageCount", "()I", "setPrivateChatDeletedMessageCount", "(I)V", "privateChatNotificationChannelId", "securedNotificationChannelId", "addMessagesInNotificationModel", "Lcom/mirrorflysdk/api/models/ChatMessage;", "message", "chatMessage", "appendChatMessageInMessageStyle", "", "context", "Landroid/content/Context;", "messageContent", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "messagingStyle", "Landroidx/core/app/NotificationCompat$MessagingStyle;", "buildNotificationChannelAndGetChannelId", "notificationId", "notificationName", "isSummaryNotification", "", "cancelNotifications", "cancelPrivateChatNotifications", "clearNotificationTray", "deletedChatUserJid", "", "createNotification", "isFromDelete", "createSecuredNotification", "displayMessageNotification", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "lastMessageContent", "lastMessageTime", "", "displaySummaryNotification", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "getCircularBitmap", "bitmap", "getLargeUserOrGroupImage", "getMessagesCount", "getNormalChatNotificationIntent", "Landroid/content/Intent;", "chatJid", "getPrivateChatNotificationIntent", "getSummaryPendingIntent", "Landroid/app/PendingIntent;", "getTotalUnReadMessageCount", "getUserProfileImage", "isMessageRecalledOrEditedMessage", "isMessageRecalled", "privateChatNotification", "setConversationTitleMessagingStyle", "messagesCount", "setDrawable", "app_debug"})
public final class NotificationBuilder {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.notification.NotificationBuilder INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.HashMap<java.lang.Integer, com.contusfly.notification.NotificationModel> chatNotifications = null;
    private static int securedNotificationChannelId = 0;
    private static int privateChatNotificationChannelId = 0;
    @org.jetbrains.annotations.Nullable
    private static java.io.File file;
    @org.jetbrains.annotations.Nullable
    private static java.io.File groupFile;
    private static int privateChatDeletedMessageCount = 0;
    private static final java.lang.String GROUP_KEY_MESSAGE = "com.mirrorfly.uikit.MESSAGE";
    private static final int SUMMARY_ID = 0;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SUMMARY_CHANNEL_ID = "message_summary_id";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SUMMARY_CHANNEL_NAME = "Chat Summary";
    
    private NotificationBuilder() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.Integer, com.contusfly.notification.NotificationModel> getChatNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File getGroupFile() {
        return null;
    }
    
    public final void setGroupFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
    }
    
    public final int getPrivateChatDeletedMessageCount() {
        return 0;
    }
    
    public final void setPrivateChatDeletedMessageCount(int p0) {
    }
    
    /**
     * Create notification when new chat message received
     * @param context Context of the application
     * @param message Instance of the ChatMessage
     */
    public final void createNotification(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message, boolean isFromDelete, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> deletedChatUserJid) {
    }
    
    private final com.mirrorflysdk.api.models.ChatMessage addMessagesInNotificationModel(com.mirrorflysdk.api.models.ChatMessage message, com.mirrorflysdk.api.models.ChatMessage chatMessage) {
        return null;
    }
    
    private final void clearNotificationTray(java.util.List<java.lang.String> deletedChatUserJid, android.content.Context context) {
    }
    
    private final boolean isMessageRecalledOrEditedMessage(boolean isMessageRecalled, com.mirrorflysdk.api.models.ChatMessage message) {
        return false;
    }
    
    /**
     * Append [ChatMessage] content to the provided [NotificationCompat.MessagingStyle]
     * @param context Context of the application
     * @param messageContent Last message content to be updated
     * @param messagingStyle Unique messaging style of the conversation
     * @param message Instance of the ChatMessage
     */
    private final void appendChatMessageInMessageStyle(android.content.Context context, java.lang.StringBuilder messageContent, androidx.core.app.NotificationCompat.MessagingStyle messagingStyle, com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Set the title of the conversation to the provided [NotificationCompat.MessagingStyle]
     * @param context Context of the application
     * @param profileDetails ProfileDetails of the conversation
     * @param messagingStyle Unique messaging style of the conversation
     * @param messagesCount total unread messages count of the conversation
     */
    private final void setConversationTitleMessagingStyle(android.content.Context context, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, int messagesCount, androidx.core.app.NotificationCompat.MessagingStyle messagingStyle) {
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
    private final void displayMessageNotification(android.content.Context context, int notificationId, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, androidx.core.app.NotificationCompat.MessagingStyle messagingStyle, java.lang.String lastMessageContent, long lastMessageTime, com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final android.content.Intent getNormalChatNotificationIntent(android.content.Context context, java.lang.String chatJid) {
        return null;
    }
    
    /**
     * Create [NotificationCompat.Builder] and display summary of the multiple chat conversations
     * @param context Context of the application
     * @param lastMessageContent Last message of the conversation
     */
    private final void displaySummaryNotification(android.content.Context context, java.lang.StringBuilder lastMessageContent) {
    }
    
    /**
     * Build notification channel with given notification ID.
     * @param context Context of the application
     * @param notificationId Unique notification id of the conversation
     * @return String notificationId
     */
    private final java.lang.String buildNotificationChannelAndGetChannelId(android.content.Context context, java.lang.String notificationId, java.lang.String notificationName, boolean isSummaryNotification) {
        return null;
    }
    
    /**
     * Create Pending Intent to open application when tap on summary notification
     * @param context Context of the application
     * @return PendingIntent
     */
    private final android.app.PendingIntent getSummaryPendingIntent(android.content.Context context) {
        return null;
    }
    
    /**
     * Get total unread messages count showing in the Push
     * @return total unread messages count
     */
    private final long getMessagesCount() {
        return 0L;
    }
    
    @android.annotation.SuppressLint(value = {"UseCompatLoadingForDrawables"})
    private final android.graphics.Bitmap getUserProfileImage(android.content.Context context, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        return null;
    }
    
    private final android.graphics.Bitmap getLargeUserOrGroupImage(android.content.Context context, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, com.mirrorflysdk.api.models.ChatMessage message) {
        return null;
    }
    
    private final android.graphics.Bitmap getCircularBitmap(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.Synchronized
    public final synchronized android.graphics.drawable.Drawable setDrawable(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        return null;
    }
    
    private final android.graphics.Bitmap drawableToBitmap(android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    /**
     * Creates a MESSAGING_STYLE Notification for the devices starting on API level 24, otherwise, displays a basic BIG_TEXT_STYLE notification.
     *
     * @param message The most recent received message
     */
    public final void createSecuredNotification(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    public final void privateChatNotification(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final android.content.Intent getPrivateChatNotificationIntent(android.content.Context context, java.lang.String chatJid) {
        return null;
    }
    
    public final void cancelPrivateChatNotifications(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void cancelNotifications() {
    }
    
    private final int getTotalUnReadMessageCount(int notificationId) {
        return 0;
    }
}