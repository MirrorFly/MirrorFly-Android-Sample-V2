package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015J\u001e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015J\u0006\u0010\u0017\u001a\u00020\u0011J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/contusfly/utils/SafeChatUtils;", "", "()V", "appLockEnabled", "", "getAppLockEnabled", "()Z", "muteNotificationEnabled", "getMuteNotificationEnabled", "pinAvailable", "getPinAvailable", "safeChatEnabled", "getSafeChatEnabled", "updateAlert", "updateSafeChat", "Lcom/contusfly/utils/SafeChatUtils$SafeChatUpdate;", "actionAuthorized", "", "activity", "Landroid/app/Activity;", "callback", "Lkotlin/Function0;", "changeSafeChatStatus", "changeSafeChatUpdateValue", "disableSafeChat", "enableSafeChat", "launchAppUnlock", "safeChatEnabledPrompt", "context", "Landroid/content/Context;", "setSafeChatInPreference", "enableDisable", "showPinRequiredPrompt", "silentDisableSafeChat", "SafeChatUpdate", "app_debug"})
public final class SafeChatUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.SafeChatUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmField
    public static com.contusfly.utils.SafeChatUtils.SafeChatUpdate updateSafeChat = com.contusfly.utils.SafeChatUtils.SafeChatUpdate.NONE;
    @kotlin.jvm.JvmField
    public static boolean updateAlert = false;
    
    private SafeChatUtils() {
        super();
    }
    
    public final boolean getSafeChatEnabled() {
        return false;
    }
    
    private final boolean getPinAvailable() {
        return false;
    }
    
    private final boolean getAppLockEnabled() {
        return false;
    }
    
    private final boolean getMuteNotificationEnabled() {
        return false;
    }
    
    public final void changeSafeChatStatus(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void changeSafeChatUpdateValue() {
    }
    
    private final void enableSafeChat(android.app.Activity activity) {
    }
    
    private final void launchAppUnlock() {
    }
    
    private final void setSafeChatInPreference(boolean enableDisable) {
    }
    
    private final void disableSafeChat(android.app.Activity activity) {
    }
    
    public final void silentDisableSafeChat(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    private final void showPinRequiredPrompt(android.app.Activity activity) {
    }
    
    public final void safeChatEnabledPrompt(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void actionAuthorized(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/utils/SafeChatUtils$SafeChatUpdate;", "", "(Ljava/lang/String;I)V", "NONE", "ENABLE", "DISABLE", "app_debug"})
    public static enum SafeChatUpdate {
        /*public static final*/ NONE /* = new NONE() */,
        /*public static final*/ ENABLE /* = new ENABLE() */,
        /*public static final*/ DISABLE /* = new DISABLE() */;
        
        SafeChatUpdate() {
        }
    }
}