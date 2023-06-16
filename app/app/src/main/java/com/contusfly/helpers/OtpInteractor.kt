package com.contusfly.helpers

import android.app.Activity
import android.text.TextUtils
import android.view.View
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.activities.OtpActivity
import com.contusfly.databinding.ActivityOtpBinding
import com.contusfly.interfaces.IOtpInteractor
import com.contusfly.interfaces.IOtpView
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.views.CustomToast
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.installations.FirebaseInstallations
import kotlinx.coroutines.*
import java.util.*
import java.util.concurrent.TimeUnit

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
internal class OtpInteractor(activity: Activity, private var otpBinding: ActivityOtpBinding) : IOtpInteractor {

    private var coroutineScope: CoroutineScope

    /**
     * Check weather the Otp
     */
    private var otp: String = Constants.EMPTY_STRING

    /**
     * Device token checking
     */
    private var deviceToken: String? = null

    /**
     * The instance of the calling activity.
     */
    private val otpActivity: OtpActivity

    /**
     * Instance of the ILoginView
     */
    private val iOtpView: IOtpView

    /**
     * The instance of the Firebase authentication object.
     */
    private val mAuth: FirebaseAuth

    /**
     * The instance of the phone authentication callback object.
     */
    private val mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    /**
     * The verification id received in the phone authentication callback once the verification code
     * is sent to the phone number.
     */
    private var verificationId: String? = null

    /**
     * The resending token received in the phone authentication callback which is used to ask for
     * the verification code to be resent again from the console.
     */
    private var resendingToken: PhoneAuthProvider.ForceResendingToken? = null

    private var isOauthFailure = false

    private fun hideOtpEditTextVisibility() {
        for (appCompatEditText in iOtpView.getOtpEditText()) appCompatEditText.visibility = View.GONE
    }

    private fun visibleOtpEditTextVisibility() {
        for (appCompatEditText in iOtpView.getOtpEditText()) appCompatEditText.visibility = View.VISIBLE
    }

    /**
     * Constructor for the Login interactor to store the IOtpView
     */
    init {
        otpActivity = activity as OtpActivity
        coroutineScope = activity
        iOtpView = activity

        // Initialize the Firebase authentication.
        mAuth = FirebaseAuth.getInstance()

        // Initialize the phone authentication callbacks.
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            /** This callback will be invoked in two situations:
             * 1 - Instant verification. In some cases the phone number can be instantly
             * verified without needing to send or enter a verification code.
             * 2 - Auto-retrieval. On some devices Google Play services can automatically
             * detect the incoming verification SMS and perform verification without
             * user action.
             */
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                LogMessage.d(TAG, "completed")
                if (phoneAuthCredential.smsCode == null) {
                    hideOtpEditTextVisibility()
                    otpBinding.otpView.visibility = View.GONE
                    CustomToast.show(iOtpView.activityContext, activity.getString(R.string.otp_instant_verification_success_message))
                    signInWithPhoneAuthCredential(phoneAuthCredential)
                } else {
                    visibleOtpEditTextVisibility()
                    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    iOtpView.setTextForOtpTextView(phoneAuthCredential.smsCode.toString())
                }
                iOtpView.dismissProgress()
                iOtpView.otpAutoLogin()
            }

            /**
             * This callback is invoked in an invalid request for verification is made,
             * for instance if the the phone number format is not valid.
             */
            override fun onVerificationFailed(e: FirebaseException) {
                LogMessage.e(TAG, e.toString() + java.lang.Boolean.toString(isOauthFailure))
                if (e is FirebaseAuthInvalidCredentialsException) {
                    CustomToast.show(iOtpView.activityContext, iOtpView.activityContext
                            .getString(R.string.valid_mobile_number))
                } else if (e is FirebaseTooManyRequestsException) {
                    isOauthFailure = false
                    CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.getString(R.string.error_otp_many_attempts))
                }
                iOtpView.dismissProgress()
            }

            /**
             * The SMS verification code has been sent to the provided phone number,
             * we now need to ask the user to enter the code and then construct a credential
             * by combining the code with a verification ID.
             * @param s The verification Id.
             * @param forceResendingToken The token used to resend the verification code again.
             */
            override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                iOtpView.enableOtpView()
                verificationId = s
                resendingToken = forceResendingToken
                otpBinding.viewVerify.isEnabled = true
                iOtpView.setOtpTextViewEnabled(iOtpView.getOtpEditText())
                iOtpView.dismissProgress()
            }

            override fun onCodeAutoRetrievalTimeOut(s: String) {
                super.onCodeAutoRetrievalTimeOut(s)
                LogMessage.e(TAG, s)
                iOtpView.dismissProgress()
            }
        }
    }

    /**
     * Complete the sign-in flow by passing the PhoneAuthCredential object to the
     * FirebaseAuth.signInWithCredential.
     *
     * @param credential The PhoneAuthCredential object obtained in the onVerificationCompleted
     * callback or by calling PhoneAuthProvider.getCredential.
     */
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(otpActivity) { task: Task<AuthResult?> ->
            if (task.isSuccessful) {
                userRegister()
            } else {
                iOtpView.dismissProgress()
                LogMessage.e(TAG, Objects.requireNonNull(task.exception!!.message))
                if (task.exception is FirebaseAuthInvalidCredentialsException) {
                    // The verification code entered was invalid.
                    CustomToast.show(otpActivity, otpActivity.getString(R.string.error_invalid_otp))
                    otpBinding.otpView.visibility = View.VISIBLE
                    otpBinding.viewVerify.visibility = View.VISIBLE
                } else if (task.exception is FirebaseTooManyRequestsException) {
                    isOauthFailure = false
                    CustomToast.show(iOtpView.activityContext, otpActivity.getString(R.string.error_otp_many_attempts))
                }
            }
        }
    }

    /**
     * Validate device token to prevent login with multiple devices
     *
     * @param deviceToken Device token if user registered previously
     */
    private fun validateDeviceToken(deviceToken: String?) {
        var firebaseToken = SharedPreferenceManager.getString(Constants.FIRE_BASE_TOKEN)
        if (firebaseToken.isEmpty()) {
            FirebaseInstallations.getInstance().getToken(true).addOnCompleteListener {
                firebaseToken = it.result!!.token
                SharedPreferenceManager.setString(Constants.FIRE_BASE_TOKEN, firebaseToken)
                navigateToUserRegisterMethod(deviceToken, firebaseToken)
            }
        } else {
            navigateToUserRegisterMethod(deviceToken, firebaseToken)
        }
    }

    private fun navigateToUserRegisterMethod(deviceToken: String?, firebaseToken: String?) {
        CustomToast.showShortToast(iOtpView.activityContext, otpActivity.getString(R.string.msg_otp_validated))
        if (TextUtils.isEmpty(deviceToken) || deviceToken == firebaseToken) {
            if (!iOtpView.getOtpProgress()!!.isShowing) iOtpView.showProgress()
            iOtpView.registerAccount()
        } else {
            iOtpView.dismissProgress()
            iOtpView.showUserAccountDeviceStatus()
        }
    }

    private fun userRegister(){
        if (!iOtpView.getOtpProgress()!!.isShowing) iOtpView.showProgress()
        iOtpView.registerAccount()
    }

    /**
     * Get the otp from sms for the particular mobile number.
     */
    override fun getOtp(doesResendOtp: Boolean) {
        if (AppUtils.isNetConnected(iOtpView.activityContext)) {
            requestServerVerificationCode(doesResendOtp)
        } else {
            iOtpView.dismissProgress()
            CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.resources.getString(R.string.error_check_internet))
        }
    }

    /**
     * Request the verification code from the server to authenticate the user sign-in.
     */
    private fun requestServerVerificationCode(isResendCode: Boolean) {
        val phoneNumber = "+" + iOtpView.getDialNumber().replace("+", "") + iOtpView.getMobileNumber()

        val options = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber(phoneNumber)       // Phone number to verify
                .setTimeout(10L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(iOtpView.activityContext)                 // Activity (for callback binding)
                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
        if (isResendCode && resendingToken != null) {
            iOtpView.setOtpTextViewEmpty(iOtpView.getOtpEditText())
            options.setForceResendingToken(resendingToken!!)
        }
        PhoneAuthProvider.verifyPhoneNumber(options.build())
    }

    override fun verifyOtp() {
        if (AppUtils.isNetConnected(iOtpView.activityContext)) {
            if (BuildConfig.IS_QA_BUILD) {
                verifyPhoneNumberWithCode(verificationId, iOtpView.getStringFromOtpTextView(iOtpView.getOtpEditText()))
            } else {
                visibleOtpEditTextVisibility()
                iOtpView.setTextForOtpTextView(otp)
                validateDeviceToken(deviceToken)
            }
        } else {
            iOtpView.dismissProgress()
            CustomToast.show(iOtpView.activityContext, iOtpView.activityContext.resources.getString(R.string.error_check_internet))
        }
    }

    /*
     * Verifies the verification code sent from the server to authenticate the user sign-in
     * process.
     */
    /**
     * Create a PhoneAuthCredential object once the user enters the verification code that Firebase
     * sent to the user's phone and verify the code to complete the sig-in process.
     *
     * @param verificationId The verification id received once the verification code is sent to the
     * user.
     * @param code           The verification code entered by the sign-in user.
     */
    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        signInWithPhoneAuthCredential(credential)
    }

    companion object {
        /**
         * Returns the simple name of the underlying class as given in the
         * source code. Returns an empty string if the underlying class is
         * anonymous.
         */
        private val TAG = OtpInteractor::class.java.simpleName
    }
}