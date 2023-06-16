package com.contusfly.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2 = {"Lcom/contusfly/notification/AppNotificationManager;", "", "()V", "cancelNotifications", "", "context", "Landroid/content/Context;", "clearConversationOnNotification", "jId", "", "createNotification", "chatMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "app_debug"})
public final class AppNotificationManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.notification.AppNotificationManager INSTANCE = null;
    
    private AppNotificationManager() {
        super();
    }
    
    /**
     * Creates local notification when the app is in foreground for the incoming messages.
     *
     * @param context Instance of Context
     * @param chatMessage Received Message
     */
    public final void createNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    public final void cancelNotifications(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void clearConversationOnNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String jId) {
    }
}