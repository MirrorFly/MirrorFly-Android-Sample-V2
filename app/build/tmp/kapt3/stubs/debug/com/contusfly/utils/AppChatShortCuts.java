package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0003R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/contusfly/utils/AppChatShortCuts;", "", "()V", "installShortCutAction", "", "getInstallShortCutAction", "()Ljava/lang/String;", "createChatShortcutWithBitmap", "", "context", "Landroid/content/Context;", "toUser", "chatType", "contactBitmap", "Landroid/graphics/Bitmap;", "contactName", "dynamicAppShortcuts", "getAppShortCutIntent", "Landroid/content/Intent;", "getIntent", "getPendingIntent", "Landroid/app/PendingIntent;", "pinShortCut", "shortcutInfo", "Landroidx/core/content/pm/ShortcutInfoCompat;", "successCallBack", "Landroid/content/IntentSender;", "app_debug"})
public final class AppChatShortCuts {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.AppChatShortCuts INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String installShortCutAction = "com.android.launcher.action.INSTALL_SHORTCUT";
    
    private AppChatShortCuts() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getInstallShortCutAction() {
        return null;
    }
    
    @android.annotation.TargetApi(value = 25)
    public final void dynamicAppShortcuts(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String toUser, @org.jetbrains.annotations.NotNull
    java.lang.String chatType) {
    }
    
    private final void createChatShortcutWithBitmap(android.content.Context context, java.lang.String toUser, java.lang.String chatType, android.graphics.Bitmap contactBitmap, java.lang.String contactName) {
    }
    
    private final android.content.Intent getIntent(android.content.Context context, java.lang.String toUser, java.lang.String chatType) {
        return null;
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