package com.contusfly.interfaces

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
interface IOtpInteractor {

    /**
     * Get the otp from sms for the particular mobile number.
     *
     * @param doesResendOtp true if the
     */
    fun getOtp(doesResendOtp: Boolean)

    /**
     * Verify the otp in the serve3r
     */
    fun verifyOtp()
}