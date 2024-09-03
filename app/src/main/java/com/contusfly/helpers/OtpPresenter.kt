package com.contusfly.helpers

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.text.TextUtils
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.activities.OtpActivity
import com.contusfly.databinding.ActivityOtpBinding
import com.contusfly.interfaces.IOtpPresenter
import com.contusfly.interfaces.IOtpView
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.helpers.ResourceHelper
import com.mirrorflysdk.views.CustomToast
import com.contusfly.libPhone.NumberParseException
import com.contusfly.libPhone.PhoneNumberUtil
import com.contusfly.libPhone.Phonenumber

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class OtpPresenter(private var otpBinding: ActivityOtpBinding) : IOtpPresenter {

    /**
     * The instance of the calling activity.
     */
    private val otpActivity: OtpActivity = OtpActivity()

    companion object {
        private val TAG = OtpPresenter::class.java.simpleName
    }

    /**
     * Instance of the IOtpView which having the methods for Activity
     */
    private lateinit var iOtpView: IOtpView

    override fun attach(iOtpView: IOtpView) {
        this.iOtpView = iOtpView
    }

    override fun validateAndSendOtp() {
        val mobileEditText = otpBinding.edtMobileNo
        iOtpView.setMobileNumber(mobileEditText.text.toString())

        //Checking the valid given mobile number
        when {
            iOtpView.getMobileNumber()!!.isEmpty() -> {
                iOtpView.dismissProgress()
                CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.error_enter_mobile_number))}
            iOtpView.getMobileNumber()!!.length < 6 -> {
                iOtpView.dismissProgress()
                CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.error_mobile_number_short))}
            iOtpView.getMobileNumber()!!.length > 16 -> {
                iOtpView.dismissProgress()
                CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.error_mobile_number_length)) }
            else -> {
                val phoneUtil = PhoneNumberUtil.createInstance(iOtpView.activityContext)
                val phoneNumberProtocol: Phonenumber.PhoneNumber
                try {
                    /*
                  Validate the mobile number with country code
                 */
                    if (verifyNumberHasCountryCode(iOtpView.getMobileNumber(), iOtpView.getCountryCode(), phoneUtil)) {
                        phoneNumberProtocol = phoneUtil.parse(iOtpView.getMobileNumber(), iOtpView.getCountryCode())
                        if (iOtpView.getMobileNumber()!!.length > 8 && !phoneUtil.isValidNumber(phoneNumberProtocol)) {
                            iOtpView.dismissProgress()
                            CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.valid_mobile_number))
                        } else if (!AppUtils.isNetConnected(iOtpView.activityContext)) {
                            iOtpView.dismissProgress()
                            CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.error_check_internet))
                        } else {
                            iOtpView.getInteractor().getOtp(false)
                        }
                    } else {
                        iOtpView.dismissProgress()
                        CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.valid_mobile_number))
                    }
                } catch (e: Exception) {
                    LogMessage.e(e)
                    iOtpView.dismissProgress()
                    CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.valid_mobile_number))
                }
            }
        }
    }

    /*
    * Verify OTP View will be opened once Get OTP response success */
    private fun verifyOtpView() {
        otpBinding.toolbar.root.visibility = View.VISIBLE
        otpBinding.toolbar.root.title = Constants.EMPTY_STRING
        otpBinding.toolbar.toolbarTitle.text = ResourceHelper.getString(R.string.verify_label)
        otpBinding.getMobileNumberView2.visibility = View.VISIBLE
        val otpText = otpBinding.otpText
        otpText.setText(R.string.verify_otp_label)
        val otpInfo = otpBinding.txtInfo
        otpInfo.setText(R.string.otp_info_label)
        otpBinding.txtCountry.visibility = View.GONE
        otpBinding.divider.visibility = View.GONE
        otpBinding.mobileNumber.visibility = View.GONE
        otpBinding.viewGetOtp.visibility = View.GONE
        otpBinding.txtTermsAndConditions.visibility = View.GONE
        otpBinding.txtTermsAndConditionsDescription.visibility = View.GONE
        otpBinding.otpView.visibility = View.VISIBLE
        otpBinding.editNumber.visibility = View.VISIBLE
    }

    @Throws(NumberParseException::class)
    private fun verifyNumberHasCountryCode(mobileNumber: String?, phoneNumberRegion: String?, phoneUtil: PhoneNumberUtil): Boolean {
        val countryCode = phoneUtil.getCountryCodeForRegion(phoneNumberRegion).toString()
        val countryCodeFromNumber = iOtpView.getMobileNumber()!!.substring(0, countryCode.length)
        return if (countryCodeFromNumber.contains(countryCode) && countryCodeFromNumber == countryCode) {
            val numberWithoutCountryCode = mobileNumber!!.substring(countryCodeFromNumber.length)
            LogMessage.d(TAG, "number before removing: $mobileNumber:after:$numberWithoutCountryCode")
            if (phoneUtil.isValidNumber(phoneUtil.parse(numberWithoutCountryCode, phoneNumberRegion)))
                false
            else {
                LogMessage.d(TAG, "its already a valid number hence no change$mobileNumber")
                true
            }
        } else true
    }

    override fun enableOtpAndOperation() {
        verifyOtpView()
        otpBinding.otpView.visibility = View.VISIBLE
        otpBinding.seperator.visibility = View.VISIBLE
        otpBinding.txtChangeNumber.visibility = View.VISIBLE
        otpBinding.edtMobileNo.isEnabled = false
        otpBinding.txtCountry.isEnabled = false
        val getOtpView: CustomTextView = otpBinding.viewGetOtp
        getOtpView.isEnabled = false
        getOtpView.background.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(iOtpView.activityContext, R.color.color_menu_divider), PorterDuff.Mode.SRC_IN)
    }

    override fun disableOtpAndOperation() {
        val toolbar: Toolbar = otpBinding.toolbar.root
        toolbar.visibility = View.GONE
        toolbar.title = Constants.EMPTY_STRING
        val otpText = otpBinding.otpText
        otpText.setText(R.string.register_your_number_label)
        val otpInfo = otpBinding.txtInfo
        otpInfo.setText(R.string.register_number_label)
        otpBinding.getMobileNumberView2.visibility = View.VISIBLE
        otpBinding.txtCountry.visibility = View.VISIBLE
        otpBinding.divider.visibility = View.VISIBLE
        otpBinding.mobileNumber.visibility = View.VISIBLE
        otpBinding.viewGetOtp.visibility = View.VISIBLE
        otpBinding.txtTermsAndConditions.visibility = View.VISIBLE
        otpBinding.txtTermsAndConditionsDescription.visibility = View.VISIBLE
        otpBinding.otpView.visibility = View.GONE
        otpBinding.editNumber.visibility = View.GONE
        otpBinding.edtMobileNo.isEnabled = true
        otpBinding.txtCountry.isEnabled = true
        val getOtpView: CustomTextView = otpBinding.viewGetOtp
        getOtpView.isEnabled = true
        getOtpView.background.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(iOtpView.activityContext, R.color.colorAccent), PorterDuff.Mode.SRC_IN)
    }

    override fun verifyOtp() {
        val otp = iOtpView.getStringFromOtpTextView(iOtpView.getOtpEditText())
        if (!TextUtils.isEmpty(otp)) {
            if (iOtpView.getOtpProgress() != null && !iOtpView.getOtpProgress()!!.isShowing) {
                iOtpView.getOtpProgress()!!.setMessage(iOtpView.activityContext.getString(R.string.please_wait_label))
                iOtpView.getOtpProgress()!!.show()
            }
            iOtpView.getInteractor().verifyOtp()
            iOtpView.getOtpProgress()?.setCanceledOnTouchOutside(false)
        } else {
            CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.enter_otp_label))
        }
        otpBinding.otpView.visibility = View.VISIBLE
    }
}