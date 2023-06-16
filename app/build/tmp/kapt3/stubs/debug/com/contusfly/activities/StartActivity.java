package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u0012\u0010\'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\fH\u0014J\b\u0010+\u001a\u00020\fH\u0016J\u001c\u0010,\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u000eH\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/contusfly/activities/StartActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/an/biometric/BiometricCallback;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mBiometricManager", "Lcom/an/biometric/BiometricManager;", "checkAndNavigateToDashboard", "", "jid", "", "chatType", "checkEnableSafeChat", "checkNotificationIntent", "intent", "Landroid/content/Intent;", "clearNotification", "goToChatView", "goToDashboard", "onAuthenticationCancelled", "onAuthenticationError", "errorCode", "", "errString", "", "onAuthenticationFailed", "onAuthenticationHelp", "helpCode", "helpString", "onAuthenticationSuccessful", "onBiometricAuthenticationInternalError", "error", "onBiometricAuthenticationNotAvailable", "onBiometricAuthenticationNotSupported", "onBiometricAuthenticationPermissionNotGranted", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSdkVersionNotSupported", "pinForChatOrGroup", "shouldShowPinOrNot", "", "userView", "validateCallLinkAndNavigateToRespectivePage", "callLink", "Companion", "app_debug"})
public final class StartActivity extends com.contusfly.activities.BaseActivity implements kotlinx.coroutines.CoroutineScope, com.an.biometric.BiometricCallback {
    
    /**
     * instance of BiometricManager class
     */
    private com.an.biometric.BiometricManager mBiometricManager;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.activities.StartActivity.Companion Companion = null;
    private static final java.lang.String TAG = null;
    private static final java.lang.String GOTO = "go_to";
    private java.util.HashMap _$_findViewCache;
    
    public StartActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void userView() {
    }
    
    private final void validateCallLinkAndNavigateToRespectivePage(java.lang.String callLink) {
    }
    
    private final void checkEnableSafeChat() {
    }
    
    /**
     * Checks the notification intent and loads ChatViewActivity if need.
     *
     * @param intent Notification intent
     */
    private final void checkNotificationIntent(android.content.Intent intent) {
    }
    
    private final void goToDashboard() {
    }
    
    private final void goToChatView(java.lang.String jid, java.lang.String chatType) {
    }
    
    private final void checkAndNavigateToDashboard(java.lang.String jid, java.lang.String chatType) {
    }
    
    private final void pinForChatOrGroup(java.lang.String jid, java.lang.String chatType) {
    }
    
    private final boolean shouldShowPinOrNot() {
        return false;
    }
    
    private final void clearNotification() {
    }
    
    @java.lang.Override()
    public void onSdkVersionNotSupported() {
    }
    
    @java.lang.Override()
    public void onBiometricAuthenticationNotSupported() {
    }
    
    @java.lang.Override()
    public void onBiometricAuthenticationPermissionNotGranted() {
    }
    
    @java.lang.Override()
    public void onBiometricAuthenticationNotAvailable() {
    }
    
    @java.lang.Override()
    public void onAuthenticationFailed() {
    }
    
    @java.lang.Override()
    public void onBiometricAuthenticationInternalError(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onAuthenticationCancelled() {
    }
    
    @java.lang.Override()
    public void onAuthenticationHelp(int helpCode, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence helpString) {
    }
    
    @java.lang.Override()
    public void onAuthenticationSuccessful() {
    }
    
    @java.lang.Override()
    public void onAuthenticationError(int errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence errString) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/activities/StartActivity$Companion;", "", "()V", "GOTO", "", "TAG", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}