package com.contusfly.utils;

import java.lang.System;

/**
 * This Class contains all the common operations for creating and showing notification
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b\fJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J+\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0000\u00a2\u0006\u0002\b\u0013J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/contusfly/utils/GetMsgNotificationUtils;", "", "()V", "deleted_message", "", "getMediaMessageContent", "context", "Landroid/content/Context;", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "getMentionMediaCaptionTextFormat", "getMessageSummary", "getMessageSummary$app_debug", "getMessagesInboxNotification", "", "notificationCompatBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "unseenMessages", "", "getMessagesInboxNotification$app_debug", "getSummaryTitle", "name", "unreadMessageCount", "", "unreadChatCount", "app_debug"})
public final class GetMsgNotificationUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.GetMsgNotificationUtils INSTANCE = null;
    private static final java.lang.String deleted_message = "This message was deleted";
    
    private GetMsgNotificationUtils() {
        super();
    }
    
    /**
     * Returns the message summary
     *
     * @param message Instance of message
     * @return String Summary of the message
     */
    private final java.lang.String getMessageSummary(com.mirrorflysdk.api.models.ChatMessage message, android.content.Context context) {
        return null;
    }
    
    /**
     * Returns the message summary
     *
     * @param message Instance of message
     * @return String Summary of the message
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessageSummary$app_debug(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
        return null;
    }
    
    private final java.lang.String getMediaMessageContent(android.content.Context context, com.mirrorflysdk.api.models.ChatMessage message) {
        return null;
    }
    
    /**
     * Loads messages in inbox style
     *
     * @param context        Instance of Context
     * @param notificationCompatBuilder     Instance of NotificationCompat.Builder
     * @param unseenMessages List of unread messages
     */
    public final void getMessagesInboxNotification$app_debug(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.core.app.NotificationCompat.Builder notificationCompatBuilder, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> unseenMessages) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSummaryTitle(@org.jetbrains.annotations.NotNull
    java.lang.String name, int unreadMessageCount, int unreadChatCount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMentionMediaCaptionTextFormat(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
        return null;
    }
}