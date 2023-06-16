package com.contusfly.call;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/call/CallNotificationUtils;", "", "()V", "unReadCallCount", "", "getUnReadCallCount", "()I", "setUnReadCallCount", "(I)V", "cancelNotifications", "", "createNotification", "context", "Landroid/content/Context;", "message", "", "messageContent", "getChannelImportance", "isRing", "", "isVibrate", "getNotificationIcon", "getTotalUnReadCount", "app_debug"})
public final class CallNotificationUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.call.CallNotificationUtils INSTANCE = null;
    private static int unReadCallCount = 0;
    
    private CallNotificationUtils() {
        super();
    }
    
    public final int getUnReadCallCount() {
        return 0;
    }
    
    public final void setUnReadCallCount(int p0) {
    }
    
    /**
     * Creates the missed call notification
     *
     * @param context        Instance of Context
     * @param message        message
     * @param messageContent notification message content
     */
    public final void createNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.String messageContent) {
    }
    
    private final int getChannelImportance(boolean isRing, boolean isVibrate) {
        return 0;
    }
    
    private final int getNotificationIcon() {
        return 0;
    }
    
    private final int getTotalUnReadCount() {
        return 0;
    }
    
    public final void cancelNotifications() {
    }
}