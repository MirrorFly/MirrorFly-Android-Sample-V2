package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\"\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0016H\u0014J\u0018\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u001a\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00072\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u001a\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010(H\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\b\u0010.\u001a\u00020\u001bH\u0016J\u0012\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u001bH\u0016J\u0012\u00104\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\u0012\u00107\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u00109\u001a\u00020\u001bH\u0014J\b\u0010:\u001a\u00020\u001bH\u0016J\b\u0010;\u001a\u00020\u001bH\u0016J\b\u0010<\u001a\u00020\u001bH\u0002J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006B"}, d2 = {"Lcom/contusfly/activities/BiometricActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lcom/an/biometric/BiometricCallback;", "()V", "chatType", "", "count", "", "getCount", "()I", "setCount", "(I)V", "expiryDate", "Ljava/util/Date;", "goTo", "isSwitchedToPin", "", "jid", "mBiometricManager", "Lcom/an/biometric/BiometricManager;", "myActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pinExpired", "getPinExpired", "()Z", "checkAndRedirect", "", "getIntentExtras", "launchChatView", "onActivityResult", "requestCode", "resultCode", "data", "onAdminBlockedUser", "status", "onAuthenticationCancelled", "onAuthenticationError", "errorCode", "errString", "", "onAuthenticationFailed", "onAuthenticationHelp", "helpCode", "helpString", "onAuthenticationSuccessful", "onBackPressed", "onBiometricAuthenticationInternalError", "error", "onBiometricAuthenticationNotAvailable", "onBiometricAuthenticationNotSupported", "onBiometricAuthenticationPermissionNotGranted", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onResume", "onSdkVersionNotSupported", "onStart", "pinForDashBoard", "setPrivateChatEnableOrDisable", "setResultLaunchType", "type", "showBiometricDialog", "Companion", "app_debug"})
public final class BiometricActivity extends com.contusfly.activities.BaseActivity implements com.an.biometric.BiometricCallback {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.activities.BiometricActivity.Companion Companion = null;
    private static final java.lang.String GOTOCONST = "go_to";
    private static final int INTENT_AUTHENTICATE = 200;
    private static final java.lang.String TAG = null;
    private boolean isSwitchedToPin = false;
    
    /**
     * instance of biometric manager class
     */
    private com.an.biometric.BiometricManager mBiometricManager;
    
    /**
     * authentication failed count
     */
    private int count = 0;
    
    /**
     * to store the value from intent that decides where to navigate from this activity
     */
    private java.lang.String goTo = "";
    
    /**
     * to store the Jid.
     */
    private java.lang.String jid;
    
    /**
     * to store the type of the chat
     */
    private java.lang.String chatType;
    
    /**
     * to store the expiry date of the pin value
     */
    private java.util.Date expiryDate;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> myActivityResultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public BiometricActivity() {
        super();
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    private final boolean getPinExpired() {
        return false;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onSdkVersionNotSupported() {
    }
    
    @java.lang.Override
    public void onBiometricAuthenticationNotSupported() {
    }
    
    @java.lang.Override
    public void onBiometricAuthenticationNotAvailable() {
    }
    
    @java.lang.Override
    public void onBiometricAuthenticationPermissionNotGranted() {
    }
    
    @java.lang.Override
    public void onBiometricAuthenticationInternalError(@org.jetbrains.annotations.Nullable
    java.lang.String error) {
    }
    
    @java.lang.Override
    public void onAuthenticationFailed() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    public void onAuthenticationCancelled() {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    private final void showBiometricDialog() {
    }
    
    @java.lang.Override
    public void onAuthenticationSuccessful() {
    }
    
    private final void checkAndRedirect() {
    }
    
    private final void launchChatView() {
    }
    
    @java.lang.Override
    public void onAuthenticationHelp(int helpCode, @org.jetbrains.annotations.Nullable
    java.lang.CharSequence helpString) {
    }
    
    @java.lang.Override
    public void onAuthenticationError(int errorCode, @org.jetbrains.annotations.Nullable
    java.lang.CharSequence errString) {
    }
    
    /**
     * redirect to pin screen after authernication failed
     */
    private final void pinForDashBoard() {
    }
    
    private final void setPrivateChatEnableOrDisable(android.content.Intent data) {
    }
    
    private final void setResultLaunchType(java.lang.String type) {
    }
    
    private final void getIntentExtras() {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public void onAdminBlockedUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, boolean status) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    protected void onNewIntent(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/contusfly/activities/BiometricActivity$Companion;", "", "()V", "GOTOCONST", "", "INTENT_AUTHENTICATE", "", "TAG", "kotlin.jvm.PlatformType", "callAppListener", "", "isShow", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * to indicate applifecyclelistencer class
         *
         * @param isShow bool value to show pin screen
         */
        private final void callAppListener(boolean isShow) {
        }
    }
}