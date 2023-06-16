package com.contusfly.utils;

import java.lang.System;

/**
 * This Class contains all the common operations for creating and showing notification
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J:\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0007J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010 \u001a\u00020\u000bJ\u0016\u0010!\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0#H\u0007J\u0006\u0010$\u001a\u00020\bJ(\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u0018\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020+2\u0006\u0010\f\u001a\u00020\rH\u0003R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u00a8\u00061"}, d2 = {"Lcom/contusfly/utils/NotifyRefererUtils;", "", "()V", "defaultVibrationPattern", "", "getDefaultVibrationPattern", "()[J", "isLastMessageRecalled", "", "()Z", "buildNotificationChannel", "", "packageContext", "Landroid/content/Context;", "notificationManager", "Landroid/app/NotificationManager;", "chatChannelId", "chatChannelName", "isSummaryNotification", "deleteNotificationChannels", "", "mNotificationManager", "getAudioMode", "", "context", "getDeviceVibrateMode", "getGroupUserAppendedText", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "messageContent", "delimiter", "getNotificationChannelId", "getNotificationId", "hasMultipleSenders", "unseenMessages", "", "isForegrounded", "setNotificationChannelSound", "notificationSoundUri", "Landroid/net/Uri;", "audioAttributes", "Landroid/media/AudioAttributes;", "highPriorityChannel", "Landroid/app/NotificationChannel;", "setNotificationSound", "notificationCompatBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "setVibration", "priorityChannel", "app_debug"})
public final class NotifyRefererUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.NotifyRefererUtils INSTANCE = null;
    
    private NotifyRefererUtils() {
        super();
    }
    
    /**
     * To generate tone and vibration while receiving the message. The tone will played if user has
     * been selected ringtone for message where the option is available to select tone, vibration
     * while receive notification
     *
     * @param notificationCompatBuilder Instance of Notification builder
     */
    public final void setNotificationSound(@org.jetbrains.annotations.NotNull()
    androidx.core.app.NotificationCompat.Builder notificationCompatBuilder) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final long[] getDefaultVibrationPattern() {
        return null;
    }
    
    /**
     * Returns group user appended text if the chat type is group.
     *
     * @param message        Unseen message
     * @param messageContent Notification line message content
     * @param delimiter      Delimiter to append in between
     * @return String Appended with group user
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final java.lang.String getGroupUserAppendedText(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.NotNull()
    java.lang.String messageContent, @org.jetbrains.annotations.NotNull()
    java.lang.String delimiter) {
        return null;
    }
    
    /**
     * Checks whether messages has single sender or not
     *
     * @param unseenMessages List of unread messages
     * @return boolean True: if single sender, false: if not
     */
    @kotlin.jvm.JvmStatic()
    public static final boolean hasMultipleSenders(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> unseenMessages) {
        return false;
    }
    
    /**
     * Used to build notification channel for devices running on Oreo and above
     *
     * @param packageContext      Context
     * @param notificationManager instance of notification manager
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.O)
    public final java.lang.String buildNotificationChannel(@org.jetbrains.annotations.NotNull()
    android.content.Context packageContext, @org.jetbrains.annotations.Nullable()
    android.app.NotificationManager notificationManager, @org.jetbrains.annotations.Nullable()
    java.lang.String chatChannelId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatChannelName, boolean isSummaryNotification) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void setVibration(android.app.NotificationChannel priorityChannel, android.content.Context packageContext) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void setNotificationChannelSound(@org.jetbrains.annotations.NotNull()
    android.net.Uri notificationSoundUri, @org.jetbrains.annotations.NotNull()
    android.media.AudioAttributes audioAttributes, @org.jetbrains.annotations.NotNull()
    android.app.NotificationChannel highPriorityChannel, @org.jetbrains.annotations.NotNull()
    android.content.Context packageContext) {
    }
    
    private final java.lang.String getNotificationChannelId(boolean isSummaryNotification, java.lang.String chatChannelId) {
        return null;
    }
    
    private final int getAudioMode(android.content.Context context) {
        return 0;
    }
    
    /**
     * Generates a list of notification channels associated with a notification manager
     *
     * @param mNotificationManager Instance of notification manager
     * @return list of notification channels
     */
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.O)
    public final void deleteNotificationChannels(@org.jetbrains.annotations.Nullable()
    android.app.NotificationManager mNotificationManager) {
    }
    
    public final boolean isForegrounded() {
        return false;
    }
    
    public final boolean getDeviceVibrateMode(@org.jetbrains.annotations.NotNull()
    android.content.Context packageContext) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNotificationId() {
        return null;
    }
    
    private final boolean isLastMessageRecalled() {
        return false;
    }
}