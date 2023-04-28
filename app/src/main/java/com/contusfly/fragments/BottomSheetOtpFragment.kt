package com.contusfly.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatEditText
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flynetwork.ApiCalls
import com.contusfly.R
import com.contusfly.activities.PinActivity
import com.contusfly.activities.PinEntryChange
import com.contusfly.databinding.FragmentBottomSheetOtpBinding
import com.contusfly.interfaces.PinApi
import com.contusfly.utils.PinOnKeyListener
import com.contusfly.utils.PinTextWatcher
import com.contusfly.utils.RequestCode
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.views.CustomToast
import com.google.android.gms.tasks.Task
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.*
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheetOtpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomSheetOtpFragment(private val activity: Activity) : BottomSheetDialogFragment(),
    CoroutineScope, View.OnClickListener {

    @Inject
    lateinit var apiCalls: ApiCalls

    private val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Coroutine Exception ${TAG}:  ${exception.printStackTrace()}")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    /**
     * The instance of the Firebase authentication object.
     */
    private var mAuth: FirebaseAuth? = null
    private lateinit var binding: FragmentBottomSheetOtpBinding
    /**
     * The instance of the phone authentication callback object.
     */
    private var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null
    private var code: String? = null
    private var verificationId: String? = null
    /**
     * The resending token received in the phone authentication callback which is used to ask for
     * the verification code to be resent again from the console.
     */
    private var resendingCode: PhoneAuthProvider.ForceResendingToken? = null
    private lateinit var editTexts: Array<AppCompatEditText>

    /**
     * to display the progress dialog.
     */
    private var progressDialog: ProgressDialog? = null

    private var cancelButton: Cancel? = null

    /**
     * textview to for resend otp function
     */

    private var countDownTimer: CountDownTimer? = null


    private var phoneAuthCredential: PhoneAuthCredential? = null


    /**
     * to get the api type
     */
    private var apiType = PinApi.REQUEST_OTP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentBottomSheetOtpBinding.inflate(inflater,container,false)
        mAuth = FirebaseAuth.getInstance()
        callBackFromResendPhoneAuth()
        val bundle = arguments
        if (bundle != null) {
            resendingCode = bundle.getParcelable("resendingCode")
            code = bundle.getString("otp")
            verificationId = bundle.getString("verficationCode")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews(){
        dialog?.setOnShowListener {
            val dialog = it as BottomSheetDialog
            val bottomSheet = dialog.findViewById<View>(R.id.design_bottom_sheet)
            bottomSheet?.let { sheet ->
                dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
                sheet.parent.parent.requestLayout()
            }
        }
        editTexts = arrayOf(binding.otpview.otp1, binding.otpview.otp2, binding.otpview.otp3, binding.otpview.otp4, binding.otpview.otp5, binding.otpview.otp6)
        binding.otpview.otp1.addTextChangedListener(PinTextWatcher(0, editTexts, activity))
        binding.otpview.otp2.addTextChangedListener(PinTextWatcher(1, editTexts, activity))
        binding.otpview.otp3.addTextChangedListener(PinTextWatcher(2, editTexts, activity))
        binding.otpview.otp4.addTextChangedListener(PinTextWatcher(3, editTexts, activity))
        binding.otpview.otp5.addTextChangedListener(PinTextWatcher(4, editTexts, activity))
        binding.otpview.otp6.addTextChangedListener(PinTextWatcher(5, editTexts, activity))
        binding.otpview.otp1.setOnKeyListener(PinOnKeyListener(0, editTexts))
        binding.otpview.otp2.setOnKeyListener(PinOnKeyListener(1, editTexts))
        binding.otpview.otp3.setOnKeyListener(PinOnKeyListener(2, editTexts))
        binding.otpview.otp4.setOnKeyListener(PinOnKeyListener(3, editTexts))
        binding.otpview.otp5.setOnKeyListener(PinOnKeyListener(4, editTexts))
        binding.otpview.otp6.setOnKeyListener(PinOnKeyListener(5, editTexts))
        if (code != null) {
            setTextForOtpTextView(code!!, editTexts)
        }
        progressDialog = ProgressDialog(activity)
        setOnClickListenerForResendOTP()
        setResendOtp()
        setVerifyBtnOnClickListener()
        setClickListener()
    }

    private fun setClickListener() {
        binding.cancel!!.setOnClickListener(this)
    }

    /**
     * click listener for resend otp
     */
    fun setOnClickListenerForResendOTP() {
        binding.resendOtp!!.setOnClickListener { v: View? ->
            setOtpTextViewEmpty(editTexts)
            apiType = PinApi.REQUEST_OTP
            requestAndVerifyOtp()
        }
    }


    /**
     * make the otp text box empty
     *
     * @param editTexts array of edit text
     */
    private fun setOtpTextViewEmpty(editTexts: Array<AppCompatEditText>) {
        editTexts[0].setText("")
        editTexts[1].setText("")
        editTexts[2].setText("")
        editTexts[3].setText("")
        editTexts[4].setText("")
        editTexts[5].setText("")
    }

    /**
     * to dismiss the progress dialog
     */
    private fun dismissProgress() {
        if (progressDialog != null) progressDialog!!.dismiss()
    }

    /**
     * to resent the otp
     */
    fun setResendOtp() {
        if (isAdded && activity != null) {
            dismissProgress()
            binding.resendOtp!!.setOnClickListener(null)
            binding.resendOtp!!.setTextColor(resources.getColor(R.color.color_black))
            countDownTimer = object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val seconds = millisUntilFinished / 1000
                    val minutes = seconds % 3600 / 60
                    binding.resendOtp!!.setTextColor(resources.getColor(R.color.colorAccent))
                    binding.resendOtp!!.text = String.format("%02d:%02d", minutes, seconds)
                }

                override fun onFinish() {
                    binding.resendOtp!!.text = "Resend OTP"
                    binding.resendOtp!!.setTextColor(resources.getColor(R.color.color_dark_red))
                    setOnClickListenerForResendOTP()
                    setVerifyBtnOnClickListener()
                }
            }.start()
        }
    }

    /**
     * to request and verify otp api call
     */
    private fun requestAndVerifyOtp() {
        if (AppUtils.isNetConnected(activity)) {
            binding.resendOtp!!.setOnClickListener(null)
            if (apiType == PinApi.REQUEST_OTP) {
                progressDialog!!.setMessage(getString(R.string.sending_otp))
            }
            progressDialog!!.isIndeterminate = true
            progressDialog!!.setCancelable(false)
            progressDialog!!.show()
            launch(exceptionHandler) {
                if (apiType == PinApi.REQUEST_OTP) {

                    val mobileNUmber = com.contusfly.utils.SharedPreferenceManager.getString(com.contusfly.utils.Constants.USER_MOBILE_NUMBER).replace(" ", "").replace("+", "")

                    val otpResponse = apiCalls.pinGetOtp(mobileNUmber).await()

                    withContext(Dispatchers.Main.immediate) {
                        if (otpResponse.isSuccessful) {

                            val response = otpResponse.body()!!

                            val status = response.status!!.toString()

                            val message = response.message!!

                            handleResponse(status, message)

                        } else {
                            setOnClickListenerForResendOTP()
                            dismissProgress()
                            CustomToast.show(activity, Constants.ERROR_SERVER)
                        }
                    }
                }
            }
        } else {
            dismissProgress()
            CustomToast.show(activity, getString(R.string.msg_no_internet))
        }
    }

    private fun handleResponse(status: String,message: String){
        when {
            Constants.STATUS_CODE_SUCCESS == status -> {
                CustomToast.show(ChatManager.applicationContext, message)
                setResendOtp()
                resendVerificationCode()
            }
            Constants.STATUS_CODE_SECURITY_TOKEN_ERROR == status -> {
                LogMessage.e(TAG, "Token refresh error")
                CustomToast.show(ChatManager.applicationContext, message)
            }
            else -> {
                setOnClickListenerForResendOTP()
                setVerifyBtnOnClickListener()
                CustomToast.show(ChatManager.applicationContext, message)
            }
        }
    }

    /**
     * click listener for verify button
     */
    private fun setVerifyBtnOnClickListener() {
        binding.verifyOtp!!.setOnClickListener { v: View? ->
            progressDialog!!.setMessage(getString(R.string.verify_otp))
            progressDialog!!.isIndeterminate = true
            progressDialog!!.setCancelable(false)
            progressDialog!!.show()
            try {
                val authCode = getStringFromOtpTextView(editTexts)
                phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId!!, authCode)
                signInWithPhoneAuthCredential(phoneAuthCredential!!)
            } catch (e: Exception) {
                LogMessage.e(e)
                CustomToast.show(activity, "OTP not valid")
                progressDialog!!.dismiss()
            }
        }
    }

    /**
     * get the entered string from the otp text box
     *
     * @param editTexts array of edittext
     * @return return the entered otp
     */
    private fun getStringFromOtpTextView(editTexts: Array<AppCompatEditText>): String {
        return (editTexts[0].text.toString().trim { it <= ' ' } + editTexts[1].text.toString().trim { it <= ' ' } + editTexts[2].text.toString().trim { it <= ' ' }
                + editTexts[3].text.toString().trim { it <= ' ' } + editTexts[4].text.toString().trim { it <= ' ' }
                + editTexts[5].text.toString().trim { it <= ' ' })
    }

    /**
     * Sends the verification code to the user's phone using Firebase services to authenticate the
     * user sign-in.
     */
    private fun resendVerificationCode() {
        val phoneNumber = StringBuilder()
        val mobile = com.contusfly.utils.SharedPreferenceManager.getString(com.contusfly.utils.Constants.USER_MOBILE_NUMBER)
        if (!mobile.startsWith("+")) phoneNumber.append("+")
        phoneNumber.append(mobile)
        val timeoutDuration = resources
            .getString(R.string.firebase_auth_timeout_duration).toLong()
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber.toString(),
            timeoutDuration, TimeUnit.SECONDS, activity, mCallbacks!!, resendingCode)
    }

    /**
     * Complete the sign-in flow by passing the PhoneAuthCredential object to the
     * FirebaseAuth.signInWithCredential.
     *
     * @param credential The PhoneAuthCredential object obtained in the onVerificationCompleted
     * callback or by calling PhoneAuthProvider.getCredential.
     */
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task: Task<AuthResult?> ->
                if (task.isSuccessful) {
                    progressDialog!!.dismiss()
                    countDownTimer!!.cancel()
                    dismiss()
                    startActivityForResult(
                        Intent(activity, PinEntryChange::class.java)
                            .putExtra("TYPE", "forgot")
                            .putExtra("FROM_SETTINGS", false),
                        RequestCode.SET_NEW_PIN)
                } else {
                    progressDialog!!.dismiss()
                    LogMessage.e(TAG, Objects.requireNonNull(task.exception!!.message))
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid.
                        CustomToast.show(activity,
                            activity.getString(R.string.error_otp_verification))
                    } else if (task.exception is FirebaseTooManyRequestsException) {
                        //Do nothing
                    }
                }
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            (activity as PinActivity).goToDashBoard()
        }
    }

    /**
     * set the text to the otp text box
     *
     * @param text      text to be entered
     * @param editTexts array of edit text
     */
    private fun setTextForOtpTextView(text: String, editTexts: Array<AppCompatEditText>) {
        var i: Int
        val textArray = text.toCharArray()
        i = 0
        while (i < textArray.size) {
            editTexts[i].setText(textArray[i].toString())
            i++
        }
    }

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        super.setupDialog(dialog, style)
    }

    override fun onResume() {
        super.onResume()
        setOtpTextViewEmpty(editTexts)
        if (isVisible && com.contusfly.utils.SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.CLOSE_DIALOG)) {
            com.contusfly.utils.SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.CLOSE_DIALOG, false)
            dismiss()
        }
    }

    private fun callBackFromResendPhoneAuth() {
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                if (phoneAuthCredential.smsCode == null) {
                    //Do nothing
                } else {
                    code = phoneAuthCredential.smsCode
                    LogMessage.d(TAG, phoneAuthCredential.smsCode)
                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                if (e is FirebaseAuthInvalidCredentialsException) {
                    CustomToast.show(activity, activity!!.getString(R.string.valid_mobile_number))
                } else if (e is FirebaseTooManyRequestsException) {
                    CustomToast.show(activity, "Too many Request,Please Try again later")
                }
            }

            override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)
                verificationId = s
                resendingCode = forceResendingToken
            }
        }
    }

    fun setCancelButton(cancel: Cancel?) {
        cancelButton = cancel
    }

    override fun onClick(v: View) {
        if (v.id == R.id.cancel) {
            cancelButton!!.cancelCallBack()
            dismiss()
            countDownTimer!!.cancel()
        }
    }

    interface Cancel {
        fun cancelCallBack()
    }

    override fun onDetach() {
        coroutineContext.cancel(CancellationException("$TAG onDetach"))
        countDownTimer!!.cancel()
        super.onDetach()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    companion object {
        private val TAG = BottomSheetOtpFragment::class.java.simpleName
    }


}