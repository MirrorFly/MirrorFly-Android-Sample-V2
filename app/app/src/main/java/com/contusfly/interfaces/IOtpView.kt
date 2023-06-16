package com.contusfly.interfaces

import android.app.Activity
import android.app.ProgressDialog
import androidx.appcompat.widget.AppCompatEditText

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
interface IOtpView {

    /**
     * Get the Context of the activity.
     *
     * @return Activity Instance of the Context
     */
    val activityContext: Activity

    /**
     * Get the mobile number of the user
     *
     * @return String Mobile number
     */
    /**
     * Set the mobile number of the user
     *
     * @param mobileNumber Mobile number fo the user
     */
    fun getMobileNumber(): String?


    fun setMobileNumber(mobileNumber: String)

    /**
     * Get the country code
     *
     * @return String Country code
     */
    fun getCountryCode(): String?

    /**
     * Get the dial number
     *
     * @return String Dial number
     */
    fun getDialNumber(): String

    /**
     * Enable the otp screen view
     */
    fun enableOtpView()

    /**
     * Get the AppCompat edit text instance of the otp view
     *
     * @return AppCompatEditText Instance of the EditText
     */
    fun getOtpEditText(): Array<AppCompatEditText>

    /**
     * Set the otp value disable
     *
     * @param editTexts Otp value
     */
    fun setOtpTextViewDisable(editTexts: Array<AppCompatEditText>)

    /**
     * Auto login after received otp
     */
    fun otpAutoLogin()

    /**
     * Set the otp value enable
     *
     * @param editTexts Otp value
     */
    fun setOtpTextViewEnabled(editTexts: Array<AppCompatEditText>)

    /**
     * Set the otp value
     */
    fun setTextForOtpTextView(text: String?)

    /**
     * Set the otp view value empty
     *
     * @param editTexts Otp value
     */
    fun setOtpTextViewEmpty(editTexts: Array<AppCompatEditText>)

    /**
     * Get the otp string
     *
     * @return String otp value
     */
    fun getStringFromOtpTextView(editTexts: Array<AppCompatEditText>): String

    /**
     * Get the progress dialog
     *
     * @return DoProgressDialog Instance of the DoProgressDialog
     */
    fun  getOtpProgress(): ProgressDialog?

    /**
     * Dismiss the progress
     */
    fun dismissProgress()

    /**
     * Get the interactor instance to access the interactor
     *
     * @return IOtpInteractor Instance of IOtpInteractor
     */
    fun getInteractor(): IOtpInteractor

    /**
     * Show the progress dialog with message
     */
    fun showProgress()

    /**
     * Request to register the user account
     */
    fun registerAccount(isForceRegister:Boolean=false)

    /**
     * Show alert dialog for multiple device login
     */
    fun showUserAccountDeviceStatus()

    /**
     * Show alert dialog for blocked user
     */
    fun showUserBlockedDialog()
}