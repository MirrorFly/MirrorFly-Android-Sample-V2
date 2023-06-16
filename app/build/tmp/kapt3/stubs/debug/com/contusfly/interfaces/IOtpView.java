package com.contusfly.interfaces;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH&J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&\u00a2\u0006\u0002\u0010\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u001b\u0010\u0015\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0007H&J\u0012\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\nH&J\u001b\u0010\u001e\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&\u00a2\u0006\u0002\u0010\u001fJ\u001b\u0010 \u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&\u00a2\u0006\u0002\u0010\u001fJ\u001b\u0010!\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&\u00a2\u0006\u0002\u0010\u001fJ\u0012\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\nH&J\b\u0010$\u001a\u00020\u0007H&J\b\u0010%\u001a\u00020\u0007H&J\b\u0010&\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\'"}, d2 = {"Lcom/contusfly/interfaces/IOtpView;", "", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "dismissProgress", "", "enableOtpView", "getCountryCode", "", "getDialNumber", "getInteractor", "Lcom/contusfly/interfaces/IOtpInteractor;", "getMobileNumber", "getOtpEditText", "", "Landroidx/appcompat/widget/AppCompatEditText;", "()[Landroidx/appcompat/widget/AppCompatEditText;", "getOtpProgress", "Landroid/app/ProgressDialog;", "getStringFromOtpTextView", "editTexts", "([Landroidx/appcompat/widget/AppCompatEditText;)Ljava/lang/String;", "otpAutoLogin", "registerAccount", "isForceRegister", "", "setMobileNumber", "mobileNumber", "setOtpTextViewDisable", "([Landroidx/appcompat/widget/AppCompatEditText;)V", "setOtpTextViewEmpty", "setOtpTextViewEnabled", "setTextForOtpTextView", "text", "showProgress", "showUserAccountDeviceStatus", "showUserBlockedDialog", "app_debug"})
public abstract interface IOtpView {
    
    /**
     * Get the Context of the activity.
     *
     * @return Activity Instance of the Context
     */
    @org.jetbrains.annotations.NotNull()
    public abstract android.app.Activity getActivityContext();
    
    /**
     * Set the mobile number of the user
     *
     * @param mobileNumber Mobile number fo the user
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getMobileNumber();
    
    public abstract void setMobileNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String mobileNumber);
    
    /**
     * Get the country code
     *
     * @return String Country code
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getCountryCode();
    
    /**
     * Get the dial number
     *
     * @return String Dial number
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDialNumber();
    
    /**
     * Enable the otp screen view
     */
    public abstract void enableOtpView();
    
    /**
     * Get the AppCompat edit text instance of the otp view
     *
     * @return AppCompatEditText Instance of the EditText
     */
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.appcompat.widget.AppCompatEditText[] getOtpEditText();
    
    /**
     * Set the otp value disable
     *
     * @param editTexts Otp value
     */
    public abstract void setOtpTextViewDisable(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatEditText[] editTexts);
    
    /**
     * Auto login after received otp
     */
    public abstract void otpAutoLogin();
    
    /**
     * Set the otp value enable
     *
     * @param editTexts Otp value
     */
    public abstract void setOtpTextViewEnabled(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatEditText[] editTexts);
    
    /**
     * Set the otp value
     */
    public abstract void setTextForOtpTextView(@org.jetbrains.annotations.Nullable()
    java.lang.String text);
    
    /**
     * Set the otp view value empty
     *
     * @param editTexts Otp value
     */
    public abstract void setOtpTextViewEmpty(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatEditText[] editTexts);
    
    /**
     * Get the otp string
     *
     * @return String otp value
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStringFromOtpTextView(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatEditText[] editTexts);
    
    /**
     * Get the progress dialog
     *
     * @return DoProgressDialog Instance of the DoProgressDialog
     */
    @org.jetbrains.annotations.Nullable()
    public abstract android.app.ProgressDialog getOtpProgress();
    
    /**
     * Dismiss the progress
     */
    public abstract void dismissProgress();
    
    /**
     * Get the interactor instance to access the interactor
     *
     * @return IOtpInteractor Instance of IOtpInteractor
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.contusfly.interfaces.IOtpInteractor getInteractor();
    
    /**
     * Show the progress dialog with message
     */
    public abstract void showProgress();
    
    /**
     * Request to register the user account
     */
    public abstract void registerAccount(boolean isForceRegister);
    
    /**
     * Show alert dialog for multiple device login
     */
    public abstract void showUserAccountDeviceStatus();
    
    /**
     * Show alert dialog for blocked user
     */
    public abstract void showUserBlockedDialog();
    
    /**
     * @author ContusTeam <developers@contus.in>
     * @version 1.0
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}