package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/utils/AppChatShortCuts;", "", "()V", "createChatShortcutWithBitmap", "", "context", "Landroid/content/Context;", "toUser", "", "chatType", "contactBitmap", "Landroid/graphics/Bitmap;", "contactName", "dynamicAppShortcuts", "getAppShortCutIntent", "Landroid/content/Intent;", "getPendingIntent", "Landroid/app/PendingIntent;", "pinShortCut", "shortcutInfo", "Landroidx/core/content/pm/ShortcutInfoCompat;", "successCallBack", "Landroid/content/IntentSender;", "app_debug"})
public final class AppChatShortCuts {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.AppChatShortCuts INSTANCE = null;
    
    private AppChatShortCuts() {
        super();
    }
    
    @android.annotation.TargetApi(value = 25)
    public final void dynamicAppShortcuts(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String toUser, @org.jetbrains.annotations.NotNull()
    java.lang.String chatType) {
    }
    
    private final void createChatShortcutWithBitmap(android.content.Context context, java.lang.String toUser, java.lang.String chatType, android.graphics.Bitmap contactBitmap, java.lang.String contactName) {
    }
    
    private final android.app.PendingIntent getPendingIntent(android.content.Context context) {
        return null;
    }
    
    private final android.content.Intent getAppShortCutIntent(android.content.Context context) {
        return null;
    }
    
    @android.annotation.TargetApi(value = 26)
    private final void pinShortCut(android.content.Context context, androidx.core.content.pm.ShortcutInfoCompat shortcutInfo, android.content.IntentSender successCallBack) {
    }
}