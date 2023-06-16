package com.contusfly.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheetOtpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002_`B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\u001b\u0010.\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002\u00a2\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u00020,H\u0002J\"\u00104\u001a\u00020,2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u00020,2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J$\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010H\u001a\u00020,H\u0016J\b\u0010I\u001a\u00020,H\u0016J\u001a\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010L\u001a\u00020,H\u0002J\b\u0010M\u001a\u00020,H\u0002J\u0010\u0010N\u001a\u00020,2\b\u0010O\u001a\u0004\u0018\u00010\u0012J\b\u0010P\u001a\u00020,H\u0002J\u0006\u0010Q\u001a\u00020,J\u001b\u0010R\u001a\u00020,2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002\u00a2\u0006\u0002\u0010SJ\u0006\u0010T\u001a\u00020,J#\u0010U\u001a\u00020,2\u0006\u0010V\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002\u00a2\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020,H\u0002J\u0018\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u000206H\u0017J\u0010\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006a"}, d2 = {"Lcom/contusfly/fragments/BottomSheetOtpFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "apiCalls", "Lcom/mirrorflysdk/flynetwork/ApiCalls;", "getApiCalls", "()Lcom/mirrorflysdk/flynetwork/ApiCalls;", "setApiCalls", "(Lcom/mirrorflysdk/flynetwork/ApiCalls;)V", "apiType", "", "binding", "Lcom/contusfly/databinding/FragmentBottomSheetOtpBinding;", "cancelButton", "Lcom/contusfly/fragments/BottomSheetOtpFragment$Cancel;", "code", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "countDownTimer", "Landroid/os/CountDownTimer;", "editTexts", "", "Landroidx/appcompat/widget/AppCompatEditText;", "[Landroidx/appcompat/widget/AppCompatEditText;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mCallbacks", "Lcom/google/firebase/auth/PhoneAuthProvider$OnVerificationStateChangedCallbacks;", "phoneAuthCredential", "Lcom/google/firebase/auth/PhoneAuthCredential;", "progressDialog", "Landroid/app/ProgressDialog;", "resendingCode", "Lcom/google/firebase/auth/PhoneAuthProvider$ForceResendingToken;", "verificationId", "callBackFromResendPhoneAuth", "", "dismissProgress", "getStringFromOtpTextView", "([Landroidx/appcompat/widget/AppCompatEditText;)Ljava/lang/String;", "handleResponse", "status", "message", "initViews", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onResume", "onViewCreated", "view", "requestAndVerifyOtp", "resendVerificationCode", "setCancelButton", "cancel", "setClickListener", "setOnClickListenerForResendOTP", "setOtpTextViewEmpty", "([Landroidx/appcompat/widget/AppCompatEditText;)V", "setResendOtp", "setTextForOtpTextView", "text", "(Ljava/lang/String;[Landroidx/appcompat/widget/AppCompatEditText;)V", "setVerifyBtnOnClickListener", "setupDialog", "dialog", "Landroid/app/Dialog;", "style", "signInWithPhoneAuthCredential", "credential", "Cancel", "Companion", "app_debug"})
public final class BottomSheetOtpFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment implements kotlinx.coroutines.CoroutineScope, android.view.View.OnClickListener {
    private final android.app.Activity activity = null;
    @javax.inject.Inject()
    public com.mirrorflysdk.flynetwork.ApiCalls apiCalls;
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    
    /**
     * The instance of the Firebase authentication object.
     */
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private com.contusfly.databinding.FragmentBottomSheetOtpBinding binding;
    
    /**
     * The instance of the phone authentication callback object.
     */
    private com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private java.lang.String code;
    private java.lang.String verificationId;
    
    /**
     * The resending token received in the phone authentication callback which is used to ask for
     * the verification code to be resent again from the console.
     */
    private com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken resendingCode;
    private androidx.appcompat.widget.AppCompatEditText[] editTexts;
    
    /**
     * to display the progress dialog.
     */
    private android.app.ProgressDialog progressDialog;
    private com.contusfly.fragments.BottomSheetOtpFragment.Cancel cancelButton;
    
    /**
     * textview to for resend otp function
     */
    private android.os.CountDownTimer countDownTimer;
    private com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential;
    
    /**
     * to get the api type
     */
    private java.lang.String apiType;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.fragments.BottomSheetOtpFragment.Companion Companion = null;
    private static final java.lang.String TAG = null;
    private java.util.HashMap _$_findViewCache;
    
    public BottomSheetOtpFragment(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mirrorflysdk.flynetwork.ApiCalls getApiCalls() {
        return null;
    }
    
    public final void setApiCalls(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flynetwork.ApiCalls p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setClickListener() {
    }
    
    /**
     * click listener for resend otp
     */
    public final void setOnClickListenerForResendOTP() {
    }
    
    /**
     * make the otp text box empty
     *
     * @param editTexts array of edit text
     */
    private final void setOtpTextViewEmpty(androidx.appcompat.widget.AppCompatEditText[] editTexts) {
    }
    
    /**
     * to dismiss the progress dialog
     */
    private final void dismissProgress() {
    }
    
    /**
     * to resent the otp
     */
    public final void setResendOtp() {
    }
    
    /**
     * to request and verify otp api call
     */
    private final void requestAndVerifyOtp() {
    }
    
    private final void handleResponse(java.lang.String status, java.lang.String message) {
    }
    
    /**
     * click listener for verify button
     */
    private final void setVerifyBtnOnClickListener() {
    }
    
    /**
     * get the entered string from the otp text box
     *
     * @param editTexts array of edittext
     * @return return the entered otp
     */
    private final java.lang.String getStringFromOtpTextView(androidx.appcompat.widget.AppCompatEditText[] editTexts) {
        return null;
    }
    
    /**
     * Sends the verification code to the user's phone using Firebase services to authenticate the
     * user sign-in.
     */
    private final void resendVerificationCode() {
    }
    
    /**
     * Complete the sign-in flow by passing the PhoneAuthCredential object to the
     * FirebaseAuth.signInWithCredential.
     *
     * @param credential The PhoneAuthCredential object obtained in the onVerificationCompleted
     * callback or by calling PhoneAuthProvider.getCredential.
     */
    private final void signInWithPhoneAuthCredential(com.google.firebase.auth.PhoneAuthCredential credential) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    /**
     * set the text to the otp text box
     *
     * @param text      text to be entered
     * @param editTexts array of edit text
     */
    private final void setTextForOtpTextView(java.lang.String text, androidx.appcompat.widget.AppCompatEditText[] editTexts) {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    @java.lang.Override()
    public void setupDialog(@org.jetbrains.annotations.NotNull()
    android.app.Dialog dialog, int style) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void callBackFromResendPhoneAuth() {
    }
    
    public final void setCancelButton(@org.jetbrains.annotations.Nullable()
    com.contusfly.fragments.BottomSheetOtpFragment.Cancel cancel) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/contusfly/fragments/BottomSheetOtpFragment$Cancel;", "", "cancelCallBack", "", "app_debug"})
    public static abstract interface Cancel {
        
        public abstract void cancelCallBack();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/fragments/BottomSheetOtpFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}