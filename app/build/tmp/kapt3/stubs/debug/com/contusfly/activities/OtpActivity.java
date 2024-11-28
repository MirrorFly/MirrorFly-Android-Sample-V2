package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u008e\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u008e\u0001\u008f\u0001B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020EH\u0002J\b\u0010G\u001a\u00020EH\u0002J\b\u0010H\u001a\u00020EH\u0016J\b\u0010I\u001a\u00020EH\u0016J\n\u0010J\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010K\u001a\u00020\u0010H\u0016J\b\u0010L\u001a\u00020-H\u0016J\n\u0010M\u001a\u0004\u0018\u00010\u0010H\u0016J\u0013\u0010N\u001a\b\u0012\u0004\u0012\u00020&0\u0014H\u0016\u00a2\u0006\u0002\u0010(J\n\u0010O\u001a\u0004\u0018\u00010;H\u0016J\u001b\u0010P\u001a\u00020\u00102\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020&0\u0014H\u0016\u00a2\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020EH\u0002J\b\u0010T\u001a\u00020EH\u0002J\u0012\u0010U\u001a\u00020\u00182\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\u0010\u0010X\u001a\u00020E2\u0006\u0010Y\u001a\u00020ZH\u0016J\"\u0010[\u001a\u00020E2\u0006\u0010\\\u001a\u00020Z2\u0006\u0010]\u001a\u00020Z2\b\u0010^\u001a\u0004\u0018\u00010_H\u0014J\u0012\u0010`\u001a\u00020E2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020EH\u0016J\u0012\u0010d\u001a\u00020E2\b\u0010e\u001a\u0004\u0018\u00010fH\u0014J\b\u0010g\u001a\u00020EH\u0014J\u001a\u0010h\u001a\u00020E2\b\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u00020\u0018H\u0016J+\u0010l\u001a\u00020E2\u0006\u0010\\\u001a\u00020Z2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010n\u001a\u00020oH\u0016\u00a2\u0006\u0002\u0010pJ\b\u0010q\u001a\u00020EH\u0014J\b\u0010r\u001a\u00020EH\u0016J\u0010\u0010s\u001a\u00020E2\u0006\u0010t\u001a\u00020\u0018H\u0016J\u0010\u0010u\u001a\u00020E2\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010x\u001a\u00020E2\u0006\u0010y\u001a\u00020\u0010H\u0002J\u0010\u0010z\u001a\u00020E2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010{\u001a\u00020EH\u0002J\u001b\u0010|\u001a\u00020E2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020&0\u0014H\u0016\u00a2\u0006\u0002\u0010*J\u001b\u0010}\u001a\u00020E2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020&0\u0014H\u0016\u00a2\u0006\u0002\u0010*J\u001b\u0010~\u001a\u00020E2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020&0\u0014H\u0016\u00a2\u0006\u0002\u0010*J\u0013\u0010\u007f\u001a\u00020E2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020E2\u0007\u0010\u0082\u0001\u001a\u00020&H\u0003J\t\u0010\u0083\u0001\u001a\u00020EH\u0002J\t\u0010\u0084\u0001\u001a\u00020EH\u0002J\u0012\u0010\u0085\u0001\u001a\u00020E2\u0007\u0010\u0086\u0001\u001a\u00020\u0010H\u0002J\u001f\u0010\u0087\u0001\u001a\u00020E2\u0014\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0089\u00010\u0088\u0001H\u0002J\t\u0010\u008a\u0001\u001a\u00020EH\u0016J\t\u0010\u008b\u0001\u001a\u00020EH\u0016J\t\u0010\u008c\u0001\u001a\u00020EH\u0016J\t\u0010\u008d\u0001\u001a\u00020\u0010H\u0002R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0014X\u0086.\u00a2\u0006\u0010\n\u0002\u0010+\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020-X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u001a\u0010:\u001a\u00020;X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0090\u0001"}, d2 = {"Lcom/contusfly/activities/OtpActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lcom/contusfly/interfaces/IOtpView;", "Landroid/view/View$OnClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "country", "", "countryCode", "downloadPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "handler", "Landroid/os/Handler;", "isExisting", "", "mDialog", "Lcom/contusfly/views/CommonAlertDialog;", "manageAccount", "Lcom/contusfly/activities/OtpActivity$ManageAccount;", "mobile", "getMobile", "()Ljava/lang/String;", "setMobile", "(Ljava/lang/String;)V", "mobileNumber", "otpBinding", "Lcom/contusfly/databinding/ActivityOtpBinding;", "otpEditTextViews", "Landroidx/appcompat/widget/AppCompatEditText;", "getOtpEditTextViews", "()[Landroidx/appcompat/widget/AppCompatEditText;", "setOtpEditTextViews", "([Landroidx/appcompat/widget/AppCompatEditText;)V", "[Landroidx/appcompat/widget/AppCompatEditText;", "otpInteractor", "Lcom/contusfly/interfaces/IOtpInteractor;", "getOtpInteractor", "()Lcom/contusfly/interfaces/IOtpInteractor;", "setOtpInteractor", "(Lcom/contusfly/interfaces/IOtpInteractor;)V", "otpViewPresenter", "Lcom/contusfly/interfaces/IOtpPresenter;", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "progress", "Landroid/app/ProgressDialog;", "getProgress", "()Landroid/app/ProgressDialog;", "setProgress", "(Landroid/app/ProgressDialog;)V", "progressTimeoutRunnable", "Ljava/lang/Runnable;", "telephonyManager", "Landroid/telephony/TelephonyManager;", "checkCurrentUser", "", "clickListener", "deleteUserAccount", "dismissProgress", "enableOtpView", "getCountryCode", "getDialNumber", "getInteractor", "getMobileNumber", "getOtpEditText", "getOtpProgress", "getStringFromOtpTextView", "editTexts", "([Landroidx/appcompat/widget/AppCompatEditText;)Ljava/lang/String;", "gotoRestorePage", "handleProgress", "isReadDefaultPhoneNumberPermissionAllowed", "context", "Landroid/content/Context;", "listOptionSelected", "position", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "view", "Landroid/view/View;", "onConnected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "otpAutoLogin", "registerAccount", "isForceRegister", "renderUserRegistrationResponseData", "decodedResponseObject", "Lorg/json/JSONObject;", "sessionExpiredDialogShow", "message", "setMobileNumber", "setOtpEditText", "setOtpTextViewDisable", "setOtpTextViewEmpty", "setOtpTextViewEnabled", "setTextForOtpTextView", "text", "setTouchListener", "editText", "setupCountryCode", "setupDefaultMobileNo", "setupInitialData", "dialCode", "showErrorResponse", "Ljava/util/HashMap;", "", "showProgress", "showUserAccountDeviceStatus", "showUserBlockedDialog", "splitPhoneNumber", "Companion", "ManageAccount", "app_debug"})
public final class OtpActivity extends com.contusfly.activities.BaseActivity implements com.contusfly.interfaces.IOtpView, android.view.View.OnClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, kotlinx.coroutines.CoroutineScope {
    private com.contusfly.databinding.ActivityOtpBinding otpBinding;
    
    /**
     * User mobile number
     */
    @org.jetbrains.annotations.Nullable
    private java.lang.String mobile;
    public androidx.appcompat.widget.AppCompatEditText[] otpEditTextViews;
    
    /**
     * Instance of the presenter interface, will used to access the multiple values
     */
    private com.contusfly.interfaces.IOtpPresenter otpViewPresenter;
    
    /**
     * Mobile number of the user
     */
    private java.lang.String mobileNumber;
    
    /**
     * Country code
     */
    private java.lang.String countryCode;
    
    /**
     * Country Name
     */
    private java.lang.String country;
    
    /**
     * Progress dialog
     */
    public android.app.ProgressDialog progress;
    
    /**
     * Instance of the ILoginInteractor
     */
    public com.contusfly.interfaces.IOtpInteractor otpInteractor;
    
    /**
     * Alter dialog to display for the user action confirmation
     */
    private com.contusfly.views.CommonAlertDialog mDialog;
    
    /**
     * Store the account management option to manage account
     */
    private com.contusfly.activities.OtpActivity.ManageAccount manageAccount;
    
    /**
     * handler for posting runnable
     */
    private android.os.Handler handler;
    
    /**
     * This runnable is used to close the progress after a {@value LOGIN_TIME_OUT} milliseconds
     */
    private java.lang.Runnable progressTimeoutRunnable;
    private android.telephony.TelephonyManager telephonyManager;
    private boolean isExisting = false;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> downloadPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.activities.OtpActivity.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    /**
     * login time out in milliseconds to close progress dialog
     */
    private static final long LOGIN_TIME_OUT = 20000L;
    private java.util.HashMap _$_findViewCache;
    
    public OtpActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMobile() {
        return null;
    }
    
    public final void setMobile(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.appcompat.widget.AppCompatEditText[] getOtpEditTextViews() {
        return null;
    }
    
    public final void setOtpEditTextViews(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatEditText[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.app.ProgressDialog getProgress() {
        return null;
    }
    
    public final void setProgress(@org.jetbrains.annotations.NotNull
    android.app.ProgressDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.interfaces.IOtpInteractor getOtpInteractor() {
        return null;
    }
    
    public final void setOtpInteractor(@org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.IOtpInteractor p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void setupInitialData(java.lang.String dialCode) {
    }
    
    private final boolean isReadDefaultPhoneNumberPermissionAllowed(android.content.Context context) {
        return false;
    }
    
    private final void setupDefaultMobileNo() {
    }
    
    private final void setupCountryCode() {
    }
    
    private final void setOtpEditText() {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void setTouchListener(androidx.appcompat.widget.AppCompatEditText editText) {
    }
    
    /**
     * Handle the click listener based on the user input
     */
    private final void clickListener() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.app.Activity getActivityContext() {
        return null;
    }
    
    /**
     * Get the mobile number of the user
     *
     * @return String Mobile number
     */
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.String getMobileNumber() {
        return null;
    }
    
    /**
     * Set the mobile number of the user
     *
     * @param mobileNumber Mobile number fo the user
     */
    @java.lang.Override
    public void setMobileNumber(@org.jetbrains.annotations.NotNull
    java.lang.String mobileNumber) {
    }
    
    /**
     * Get the country code
     *
     * @return String Country code
     */
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.String getCountryCode() {
        return null;
    }
    
    /**
     * Get the dial number
     *
     * @return String Dial number
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getDialNumber() {
        return null;
    }
    
    /**
     * Enable the otp screen view
     */
    @java.lang.Override
    public void enableOtpView() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.appcompat.widget.AppCompatEditText[] getOtpEditText() {
        return null;
    }
    
    /**
     * make the otp text box disable
     *
     * @param editTexts array of edit text
     */
    @java.lang.Override
    public void setOtpTextViewDisable(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatEditText[] editTexts) {
    }
    
    /**
     * make the otp text box enable
     *
     * @param editTexts array of edit text
     */
    @java.lang.Override
    public void setOtpTextViewEnabled(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatEditText[] editTexts) {
    }
    
    /**
     * set the text to the otp text box
     *
     * @param text text to be entered
     */
    @java.lang.Override
    public void setTextForOtpTextView(@org.jetbrains.annotations.Nullable
    java.lang.String text) {
    }
    
    /**
     * Make auto login after otp received
     */
    @java.lang.Override
    public void otpAutoLogin() {
    }
    
    /**
     * make the otp text box empty
     *
     * @param editTexts array of edit text
     */
    @java.lang.Override
    public void setOtpTextViewEmpty(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatEditText[] editTexts) {
    }
    
    /**
     * get the entered string from the otp text box
     *
     * @param editTexts array of edittext
     * @return return the entered otp
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getStringFromOtpTextView(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.AppCompatEditText[] editTexts) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.app.ProgressDialog getOtpProgress() {
        return null;
    }
    
    /**
     * Dismiss the progress
     */
    @java.lang.Override
    public void dismissProgress() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.interfaces.IOtpInteractor getInteractor() {
        return null;
    }
    
    /**
     * Show the progress dialog with message
     */
    @java.lang.Override
    public void showProgress() {
    }
    
    @java.lang.Override
    public void showUserAccountDeviceStatus() {
    }
    
    @java.lang.Override
    public void showUserBlockedDialog() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.view.View view) {
    }
    
    /**
     * check if the last logged number and  current logged number are same.
     * true- take him/her directly to dashboard activty
     * false- follow the normal flow along with db clearing process
     */
    private final void checkCurrentUser() {
    }
    
    /**
     * Handling progress dialog
     */
    private final void handleProgress() {
    }
    
    /**
     * on activity result
     *
     * @param requestCode requestCode of action
     * @param resultCode  result code for activity
     * @param data        intent data
     */
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    /**
     * Split country code and phone number
     */
    private final java.lang.String splitPhoneNumber() {
        return null;
    }
    
    /**
     * Request to register the user account
     */
    @java.lang.Override
    public void registerAccount(boolean isForceRegister) {
    }
    
    private final void showErrorResponse(java.util.HashMap<java.lang.String, java.lang.Object> data) {
    }
    
    private final void sessionExpiredDialogShow(java.lang.String message) {
    }
    
    private final void renderUserRegistrationResponseData(org.json.JSONObject decodedResponseObject) {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    /**
     * Delete the user account
     */
    private final void deleteUserAccount() {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override
    public void onConnected() {
    }
    
    private final void gotoRestorePage() {
    }
    
    /**
     * Manage register/blocked user options
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/activities/OtpActivity$ManageAccount;", "", "(Ljava/lang/String;I)V", "REGISTER", "ON_REGISTER", "BLOCK_ACCOUNT", "LOGIN", "SESSION_EXPIRED", "app_debug"})
    static enum ManageAccount {
        /*public static final*/ REGISTER /* = new REGISTER() */,
        /*public static final*/ ON_REGISTER /* = new ON_REGISTER() */,
        /*public static final*/ BLOCK_ACCOUNT /* = new BLOCK_ACCOUNT() */,
        /*public static final*/ LOGIN /* = new LOGIN() */,
        /*public static final*/ SESSION_EXPIRED /* = new SESSION_EXPIRED() */;
        
        ManageAccount() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/activities/OtpActivity$Companion;", "", "()V", "LOGIN_TIME_OUT", "", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
    }
}