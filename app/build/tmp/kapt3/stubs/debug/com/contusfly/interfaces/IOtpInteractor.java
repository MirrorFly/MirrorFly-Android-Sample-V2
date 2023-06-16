package com.contusfly.interfaces;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/interfaces/IOtpInteractor;", "", "getOtp", "", "doesResendOtp", "", "verifyOtp", "app_debug"})
public abstract interface IOtpInteractor {
    
    /**
     * Get the otp from sms for the particular mobile number.
     *
     * @param doesResendOtp true if the
     */
    public abstract void getOtp(boolean doesResendOtp);
    
    /**
     * Verify the otp in the serve3r
     */
    public abstract void verifyOtp();
}