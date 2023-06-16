package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001[B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\u001a\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0016H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\u0018\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020+H\u0002J\u0010\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0002J\u0006\u00107\u001a\u00020&J\u000e\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020$H\u0016J\b\u0010=\u001a\u00020&H\u0016J\b\u0010>\u001a\u00020&H\u0016J\u0018\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020&H\u0016J\u0018\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020BH\u0016J\b\u0010G\u001a\u00020&H\u0016J\u0010\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020+H\u0016J\b\u0010J\u001a\u00020&H\u0016J\b\u0010K\u001a\u00020&H\u0016J\b\u0010L\u001a\u00020&H\u0016J\u0012\u0010M\u001a\u00020&2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\u001a\u0010P\u001a\u00020&2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u0016H\u0016J\b\u0010T\u001a\u00020&H\u0014J\b\u0010U\u001a\u00020&H\u0016J\b\u0010V\u001a\u00020&H\u0014J\b\u0010W\u001a\u00020&H\u0002J\b\u0010X\u001a\u00020&H\u0002J\b\u0010Y\u001a\u00020&H\u0002J\b\u0010Z\u001a\u00020&H\u0002R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\\"}, d2 = {"Lcom/contusfly/activities/PinSetting;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/an/biometric/BiometricCallback;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/mirrorflysdk/flycall/webrtc/api/CallLogManager$CallLogActionListener;", "()V", "apiCalls", "Lcom/mirrorflysdk/flynetwork/ApiCalls;", "getApiCalls", "()Lcom/mirrorflysdk/flynetwork/ApiCalls;", "setApiCalls", "(Lcom/mirrorflysdk/flynetwork/ApiCalls;)V", "binding", "Lcom/contusfly/databinding/ActivityPinSettingBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "isClearChat", "", "isForSafeChat", "mBiometricManager", "Lcom/an/biometric/BiometricManager;", "mDialog", "Lcom/contusfly/views/CommonAlertDialog;", "pinAvailable", "getPinAvailable", "()Z", "progressDialog", "Landroid/app/ProgressDialog;", "calculateNextExpiryDate", "Ljava/util/Date;", "noOfDays", "", "checkFingerPrintAuthentication", "", "deleteAccount", "deleteRecords", "goToSetOrChangePinActivity", "type", "", "isFromBio", "handleBiometricChecked", "handleBiometricUnChecked", "handleLogoutResponse", "status", "message", "handleLogoutSuccess", "response", "Lcom/mirrorflysdk/flynetwork/model/DefaultResponse;", "handlePinChecked", "handlePinUnChecked", "initViews", "isFingerPrintAvailable", "context", "Landroid/content/Context;", "listOptionSelected", "position", "onActionSuccess", "onAuthenticationCancelled", "onAuthenticationError", "errorCode", "errString", "", "onAuthenticationFailed", "onAuthenticationHelp", "helpCode", "helpString", "onAuthenticationSuccessful", "onBiometricAuthenticationInternalError", "error", "onBiometricAuthenticationNotAvailable", "onBiometricAuthenticationNotSupported", "onBiometricAuthenticationPermissionNotGranted", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onResume", "onSdkVersionNotSupported", "onStart", "setPinNotes", "setToolbar", "showAlert", "verifyFingerprintIsEnabledInDevice", "Companion", "app_debug"})
public final class PinSetting extends androidx.appcompat.app.AppCompatActivity implements com.an.biometric.BiometricCallback, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, kotlinx.coroutines.CoroutineScope, com.mirrorflysdk.flycall.webrtc.api.CallLogManager.CallLogActionListener {
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    @javax.inject.Inject()
    public com.mirrorflysdk.flynetwork.ApiCalls apiCalls;
    private com.contusfly.databinding.ActivityPinSettingBinding binding;
    
    /**
     * The dialog for the common alert dialog.
     */
    private com.contusfly.views.CommonAlertDialog mDialog;
    
    /**
     * The is clear chat want to clear it.
     */
    private boolean isClearChat = false;
    
    /**
     * Progress dialog for the background process
     */
    private android.app.ProgressDialog progressDialog;
    
    /**
     * instance of biometric manager class
     */
    private com.an.biometric.BiometricManager mBiometricManager;
    private boolean isForSafeChat = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.activities.PinSetting.Companion Companion = null;
    private static final java.lang.String HIDEFORGET = "HIDE_FORGET";
    private java.util.HashMap _$_findViewCache;
    
    public PinSetting() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mirrorflysdk.flynetwork.ApiCalls getApiCalls() {
        return null;
    }
    
    public final void setApiCalls(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flynetwork.ApiCalls p0) {
    }
    
    private final boolean getPinAvailable() {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * to set the toolbar
     */
    private final void setToolbar() {
    }
    
    /**
     * to to initialize the views and widgets
     */
    public final void initViews() {
    }
    
    private final void setPinNotes() {
    }
    
    private final void handleBiometricChecked() {
    }
    
    private final void showAlert() {
    }
    
    private final void handleBiometricUnChecked() {
    }
    
    private final void handlePinUnChecked() {
    }
    
    private final void goToSetOrChangePinActivity(java.lang.String type, boolean isFromBio) {
    }
    
    private final void handlePinChecked() {
    }
    
    /**
     * to calculate the expiry date
     *
     * @param noOfDays - number of days for expiring.
     */
    private final java.util.Date calculateNextExpiryDate(int noOfDays) {
        return null;
    }
    
    private final void checkFingerPrintAuthentication() {
    }
    
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    /**
     * Delete records from the all chats
     */
    private final void deleteRecords() {
    }
    
    /**
     * Logout request to delete account
     */
    private final void deleteAccount() {
    }
    
    private final void handleLogoutSuccess(com.mirrorflysdk.flynetwork.model.DefaultResponse response) {
    }
    
    private final void handleLogoutResponse(java.lang.String status, java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    public final boolean isFingerPrintAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void verifyFingerprintIsEnabledInDevice() {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override()
    public void onSdkVersionNotSupported() {
    }
    
    @java.lang.Override()
    public void onBiometricAuthenticationNotSupported() {
    }
    
    @java.lang.Override()
    public void onBiometricAuthenticationNotAvailable() {
    }
    
    @java.lang.Override()
    public void onBiometricAuthenticationPermissionNotGranted() {
    }
    
    @java.lang.Override()
    public void onBiometricAuthenticationInternalError(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onAuthenticationFailed() {
    }
    
    @java.lang.Override()
    public void onAuthenticationCancelled() {
    }
    
    @java.lang.Override()
    public void onAuthenticationSuccessful() {
    }
    
    @java.lang.Override()
    public void onAuthenticationHelp(int helpCode, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence helpString) {
    }
    
    @java.lang.Override()
    public void onAuthenticationError(int errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence errString) {
    }
    
    @java.lang.Override()
    public void onActionSuccess() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/activities/PinSetting$Companion;", "", "()V", "HIDEFORGET", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}