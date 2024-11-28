package com.contusfly.interfaces;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/interfaces/IOtpPresenter;", "", "attach", "", "iOtpView", "Lcom/contusfly/interfaces/IOtpView;", "disableOtpAndOperation", "enableOtpAndOperation", "validateAndSendOtp", "verifyOtp", "app_debug"})
public abstract interface IOtpPresenter {
    
    /**
     * Attach the otp view into the presenter for the communication between Activity and the
     * Presenter
     *
     * @param iOtpView Instance of the IOtpView
     */
    public abstract void attach(@org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.IOtpView iOtpView);
    
    /**
     * Validate the mobile number and send the Api request to get the sms
     */
    public abstract void validateAndSendOtp();
    
    /**
     * Enable the otp view and disable the get otp button
     */
    public abstract void enableOtpAndOperation();
    
    /**
     * Enable the otp view and disable the get otp button
     */
    public abstract void disableOtpAndOperation();
    
    /**
     * Verify the otp in the API
     */
    public abstract void verifyOtp();
}