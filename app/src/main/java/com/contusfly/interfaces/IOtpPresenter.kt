package com.contusfly.interfaces

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
interface IOtpPresenter {

    /**
     * Attach the otp view into the presenter for the communication between Activity and the
     * Presenter
     *
     * @param iOtpView Instance of the IOtpView
     */
    fun attach(iOtpView: IOtpView)

    /**
     * Validate the mobile number and send the Api request to get the sms
     */
    fun validateAndSendOtp()

    /**
     * Enable the otp view and disable the get otp button
     */
    fun enableOtpAndOperation()

    /**
     * Enable the otp view and disable the get otp button
     */
    fun disableOtpAndOperation()

    /**
     * Verify the otp in the API
     */
    fun verifyOtp()
}