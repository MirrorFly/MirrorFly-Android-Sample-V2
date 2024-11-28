package com.contusfly.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\rH\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/contusfly/notification/NotificationBuilderBelow24;", "", "()V", "chatNotifications", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "appendChatMessageInNotificationBuilder", "", "context", "Landroid/content/Context;", "notificationCompatBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "notificationId", "message", "cancelNotifications", "createNotification", "getGroupUserAppendedText", "", "messageContent", "getMessageContent", "hippaComplianceNotificationBuilder", "notBuilder", "app_debug"})
public final class NotificationBuilderBelow24 {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.notification.NotificationBuilderBelow24 INSTANCE = null;
    private static final java.util.HashMap<java.lang.Integer, java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage>> chatNotifications = null;
    
    private NotificationBuilderBelow24() {
        super();
    }
    
    public final void createNotification(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final void appendChatMessageInNotificationBuilder(android.content.Context context, androidx.core.app.NotificationCompat.Builder notificationCompatBuilder, int notificationId, com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Returns the message summary
     *
     * @param message Instance of message
     * @return String Summary of the message
     */
    private final java.lang.String getMessageContent(com.mirrorflysdk.api.models.ChatMessage message) {
        return null;
    }
    
    /**
     * Returns group user appended text if the chat type is group.
     *
     * @param message        Unseen message
     * @param messageContent Notification line message content
     * @return String Appended with group user
     */
    private final java.lang.String getGroupUserAppendedText(com.mirrorflysdk.api.models.ChatMessage message, java.lang.String messageContent) {
        return null;
    }
    
    private final void hippaComplianceNotificationBuilder(android.content.Context context, androidx.core.app.NotificationCompat.Builder notBuilder) {
    }
    
    public final void cancelNotifications() {
    }
}