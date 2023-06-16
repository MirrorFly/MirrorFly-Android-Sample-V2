package com.contusfly.helpers;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J$\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/contusfly/helpers/OtpPresenter;", "Lcom/contusfly/interfaces/IOtpPresenter;", "otpBinding", "Lcom/contusfly/databinding/ActivityOtpBinding;", "(Lcom/contusfly/databinding/ActivityOtpBinding;)V", "iOtpView", "Lcom/contusfly/interfaces/IOtpView;", "otpActivity", "Lcom/contusfly/activities/OtpActivity;", "attach", "", "disableOtpAndOperation", "enableOtpAndOperation", "validateAndSendOtp", "verifyNumberHasCountryCode", "", "mobileNumber", "", "phoneNumberRegion", "phoneUtil", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "verifyOtp", "verifyOtpView", "Companion", "app_debug"})
public final class OtpPresenter implements com.contusfly.interfaces.IOtpPresenter {
    private com.contusfly.databinding.ActivityOtpBinding otpBinding;
    
    /**
     * The instance of the calling activity.
     */
    private final com.contusfly.activities.OtpActivity otpActivity = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.helpers.OtpPresenter.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    /**
     * Instance of the IOtpView which having the methods for Activity
     */
    private com.contusfly.interfaces.IOtpView iOtpView;
    
    public OtpPresenter(@org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.ActivityOtpBinding otpBinding) {
        super();
    }
    
    @java.lang.Override()
    public void attach(@org.jetbrains.annotations.NotNull()
    com.contusfly.interfaces.IOtpView iOtpView) {
    }
    
    @java.lang.Override()
    public void validateAndSendOtp() {
    }
    
    private final void verifyOtpView() {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {io.michaelrocks.libphonenumber.android.NumberParseException.class})
    private final boolean verifyNumberHasCountryCode(java.lang.String mobileNumber, java.lang.String phoneNumberRegion, io.michaelrocks.libphonenumber.android.PhoneNumberUtil phoneUtil) throws io.michaelrocks.libphonenumber.android.NumberParseException {
        return false;
    }
    
    @java.lang.Override()
    public void enableOtpAndOperation() {
    }
    
    @java.lang.Override()
    public void disableOtpAndOperation() {
    }
    
    @java.lang.Override()
    public void verifyOtp() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/helpers/OtpPresenter$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}