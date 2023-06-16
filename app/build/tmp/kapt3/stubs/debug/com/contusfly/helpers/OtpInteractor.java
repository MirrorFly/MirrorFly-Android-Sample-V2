package com.contusfly.helpers;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u001c\u0010\u001d\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\u0012\u0010%\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010&\u001a\u00020\u001aH\u0016J\u001a\u0010\'\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010(\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/contusfly/helpers/OtpInteractor;", "Lcom/contusfly/interfaces/IOtpInteractor;", "activity", "Landroid/app/Activity;", "otpBinding", "Lcom/contusfly/databinding/ActivityOtpBinding;", "(Landroid/app/Activity;Lcom/contusfly/databinding/ActivityOtpBinding;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "deviceToken", "", "iOtpView", "Lcom/contusfly/interfaces/IOtpView;", "isOauthFailure", "", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mCallbacks", "Lcom/google/firebase/auth/PhoneAuthProvider$OnVerificationStateChangedCallbacks;", "otp", "otpActivity", "Lcom/contusfly/activities/OtpActivity;", "resendingToken", "Lcom/google/firebase/auth/PhoneAuthProvider$ForceResendingToken;", "verificationId", "getOtp", "", "doesResendOtp", "hideOtpEditTextVisibility", "navigateToUserRegisterMethod", "firebaseToken", "requestServerVerificationCode", "isResendCode", "signInWithPhoneAuthCredential", "credential", "Lcom/google/firebase/auth/PhoneAuthCredential;", "userRegister", "validateDeviceToken", "verifyOtp", "verifyPhoneNumberWithCode", "code", "visibleOtpEditTextVisibility", "Companion", "app_debug"})
public final class OtpInteractor implements com.contusfly.interfaces.IOtpInteractor {
    private com.contusfly.databinding.ActivityOtpBinding otpBinding;
    private kotlinx.coroutines.CoroutineScope coroutineScope;
    
    /**
     * Check weather the Otp
     */
    private java.lang.String otp = "";
    
    /**
     * Device token checking
     */
    private java.lang.String deviceToken;
    
    /**
     * The instance of the calling activity.
     */
    private final com.contusfly.activities.OtpActivity otpActivity = null;
    
    /**
     * Instance of the ILoginView
     */
    private final com.contusfly.interfaces.IOtpView iOtpView = null;
    
    /**
     * The instance of the Firebase authentication object.
     */
    private final com.google.firebase.auth.FirebaseAuth mAuth = null;
    
    /**
     * The instance of the phone authentication callback object.
     */
    private final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = null;
    
    /**
     * The verification id received in the phone authentication callback once the verification code
     * is sent to the phone number.
     */
    private java.lang.String verificationId;
    
    /**
     * The resending token received in the phone authentication callback which is used to ask for
     * the verification code to be resent again from the console.
     */
    private com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken resendingToken;
    private boolean isOauthFailure = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.helpers.OtpInteractor.Companion Companion = null;
    
    /**
     * Returns the simple name of the underlying class as given in the
     * source code. Returns an empty string if the underlying class is
     * anonymous.
     */
    private static final java.lang.String TAG = null;
    
    public OtpInteractor(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.ActivityOtpBinding otpBinding) {
        super();
    }
    
    private final void hideOtpEditTextVisibility() {
    }
    
    private final void visibleOtpEditTextVisibility() {
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
    
    /**
     * Validate device token to prevent login with multiple devices
     *
     * @param deviceToken Device token if user registered previously
     */
    private final void validateDeviceToken(java.lang.String deviceToken) {
    }
    
    private final void navigateToUserRegisterMethod(java.lang.String deviceToken, java.lang.String firebaseToken) {
    }
    
    private final void userRegister() {
    }
    
    /**
     * Get the otp from sms for the particular mobile number.
     */
    @java.lang.Override()
    public void getOtp(boolean doesResendOtp) {
    }
    
    /**
     * Request the verification code from the server to authenticate the user sign-in.
     */
    private final void requestServerVerificationCode(boolean isResendCode) {
    }
    
    @java.lang.Override()
    public void verifyOtp() {
    }
    
    /**
     * Create a PhoneAuthCredential object once the user enters the verification code that Firebase
     * sent to the user's phone and verify the code to complete the sig-in process.
     *
     * @param verificationId The verification id received once the verification code is sent to the
     * user.
     * @param code           The verification code entered by the sign-in user.
     */
    private final void verifyPhoneNumberWithCode(java.lang.String verificationId, java.lang.String code) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/helpers/OtpInteractor$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}