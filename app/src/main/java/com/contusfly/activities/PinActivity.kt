package com.contusfly.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityCompat
import androidx.core.app.TaskStackBuilder
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.flynetwork.ApiCalls
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.AppLifecycleListener
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.databinding.ActivityPinBinding
import com.contusfly.fragments.BottomSheetOtpFragment
import com.contusfly.utils.RequestCode
import com.contusfly.utils.SafeChatUtils
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.views.CustomToast
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import dagger.android.AndroidInjection
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PinActivity : BaseActivity(), CommonAlertDialog.CommonDialogClosedListener,
    BottomSheetOtpFragment.Cancel, CoroutineScope {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception :  ${exception.printStackTrace()}")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    @Inject
    lateinit var apiCalls: ApiCalls

    private lateinit var binding: ActivityPinBinding

    /**
     * check whether boolean value is to disable both function
     */
    private var isFromDisableBoth = false

    /**
     * check whether boolean value is to disable bio function
     */
    private var isFromDisableBio = false

    /**
     * check whether boolean value is to enable both function
     */
    private var isEnableBiometric = false

    /**
     * to store the value of the pin
     */
    private var myPin: String? = null

    /**
     * to display the progress dialog.
     */
    private var progressDialog: ProgressDialog? = null

    /**
     * to store the value from intent that decides where to navigate from this activity
     */
    private var goTo = ""

    /**
     * to store the Jid.
     */
    private var jid: String? = null

    /**
     * to store the type of the chat
     */
    private var chatType: String? = null

    /**
     * to store the expiry date of the pin value
     */
    private var expiryDate: Date? = null

    /**
     * to store the alert date of the pin (5 days before expiry)
     */
    private var alertDate: Date? = null

    /**
     * The instance of the phone authentication callback object.
     */
    private var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null

    /**
     * Alert dialog builder to show pin expired dialog and pin expiry alert dialog.
     */
    private val builder by lazy { AlertDialog.Builder(this@PinActivity, R.style.AlertDialogStyle) }

    val dialog: AlertDialog by lazy { builder.create() }

    /**
     * The resending token received in the phone authentication callback which is used to ask for
     * the verification code to be resent again from the console.
     */
    private var resendingToken: PhoneAuthProvider.ForceResendingToken? = null
    private var verificationCode: String? = null
    private var otp: String? = null
    private var bottomSheetOtpFragment: BottomSheetOtpFragment? = null
    private var hideForget = false
    private var count = 0
    private var commonAlertDialog: CommonAlertDialog? = null
    private var isFromShowDialog = false
    private var isFromChatShortcut: Boolean? = false
    private var isFromSettings = false



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        callAppListener(true)
        super.onCreate(savedInstanceState)
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.IS_PIN_VALIDATED, true)
        binding = ActivityPinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setUpPinExpiryDialog()
        callBackFromPhoneAuth()
        hideKeyboard()
        currentPin
        intentExtras
        progressDialog = ProgressDialog(this)
        if (intent != null) {
            isFromDisableBoth = intent.getBooleanExtra("DISABLE_BOTH", false)
            isFromDisableBio = intent.getBooleanExtra("DISABLE_BIO", false)
            isEnableBiometric = intent.getBooleanExtra("SET_BIOMETRIC", false)
            isFromSettings = intent.getBooleanExtra("FROM_SETTINGS",false)
            hideForget = intent.getBooleanExtra("HIDE_FORGET", false)
            isFromChatShortcut = intent.getBooleanExtra("IS_FROM_CHAT_SHORTCUT", false)
        }
        if (hideForget) binding.forgotPin.visibility = View.GONE
        showInvalidPinToomanyAttempts()
    }
    private fun showInvalidPinToomanyAttempts() {
        if (SharedPreferenceManager.getInt(WRONG_CODE) > 5) {
            commonAlertDialog!!.showAlertDialog(
                resources.getString(R.string.message_toomany_attempts),
                resources.getString(R.string.generate_otp),
                resources.getString(R.string.cancel_otp),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
        }
    }


    private fun initViews(){
        bottomSheetOtpFragment = BottomSheetOtpFragment(this)
        bottomSheetOtpFragment!!.setCancelButton(this)
        commonAlertDialog = CommonAlertDialog(this)
        commonAlertDialog!!.setOnDialogCloseListener(this)
        binding.keyboardNumeric.setmPasswordField(binding.pinEditText)
        setPinEmptyDrawable(mutableListOf(binding.pin1, binding.pin2, binding.pin3, binding.pin4))
        binding.forgotPin.setOnClickListener {
            binding.forgotPin.setOnClickListener(null)
            sendOtpAlert()
        }
        binding.pinEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //Code will not be added.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //Code will not be added.
            }

            override fun afterTextChanged(s: Editable) {
                try {
                    when (s.length) {
                        1 -> {
                            setPinFillDrawable(mutableListOf(binding.filledPin1))
                            hidePinFilledView(mutableListOf(binding.filledPin2, binding.filledPin3, binding.filledPin4))
                            setPinEmptyDrawable(mutableListOf(binding.pin2, binding.pin3, binding.pin4))
                        }
                        2 -> {
                            setPinFillDrawable(mutableListOf(binding.filledPin1, binding.filledPin2))
                            hidePinFilledView(mutableListOf(binding.filledPin3, binding.filledPin4))
                            setPinEmptyDrawable(mutableListOf(binding.pin3, binding.pin4))
                        }
                        3 -> {
                            setPinFillDrawable(mutableListOf(binding.filledPin1, binding.filledPin2, binding.filledPin3))
                            hidePinFilledView(mutableListOf(binding.filledPin4))
                            setPinEmptyDrawable(mutableListOf(binding.pin4))
                        }
                        4 -> {
                            setPinFillDrawable(mutableListOf(binding.filledPin1, binding.filledPin2, binding.filledPin3, binding.filledPin4))
                            validateAndUnlock(s.toString())
                        }
                        else -> {
                            hidePinFilledView(mutableListOf(binding.filledPin1, binding.filledPin2, binding.filledPin3, binding.filledPin4))
                            setPinEmptyDrawable(mutableListOf(binding.pin1, binding.pin2, binding.pin3, binding.pin4))
                        }
                    }
                } catch (e: Exception) {
                    com.contusfly.utils.LogMessage.e(TAG, "Pin Entry issue ==> ${e.message}")
                }
            }
        })
       binding.pinLayout.setOnClickListener { hideKeyboard() }
    }

    override fun onResume() {
        super.onResume()
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.PIN_SCREEN,true)
        setUpPinExpiryDialog()
    }

    private fun setUpPinExpiryDialog(){
        if (!SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.RESET_PIN) || goTo == Constants.PIN_EXPIRE_BIOMETRIC)
            showExpiryAlert()
        else
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.RESET_PIN, false)
        setOnClickListerForSendOTP()
    }

    override fun onBackPressed() {
        if (isFromDisableBoth || isFromDisableBio ||isFromSettings) {
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BACKPRESS, true)
            finish()
            super.onBackPressed()
        } else if (goTo == Constants.LOGOUT_PIN)
            finish()
        else {
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BACK_PRESS, false)
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.IS_PIN_VALIDATED, true)
            callAppListener(false)
            ChatManager.closeXMPPConnection()
            ActivityCompat.finishAffinity(this)
        }
    }

    /**
     * to validate and unlock the app
     *
     * @param pin - pin value
     */
    fun validateAndUnlock(pin: String?) {
        currentPin
        if (myPin!!.isNotEmpty() && myPin.equals(pin, ignoreCase = true)) {
            when {
                isFromDisableBoth -> {
//                    SharedPreferenceManager.setString(com.contusfly.utils.Constants.MY_PIN, "")
                    SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.SHOW_PIN, false)
                    SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BIOMETRIC, false)
                    SafeChatUtils.silentDisableSafeChat(this)
                }
                isEnableBiometric -> SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BIOMETRIC, !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.BIOMETRIC))
                isFromDisableBio -> SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BIOMETRIC, false)
            }
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.IS_PIN_VALIDATED, false)
            callAppListener(false)
            SharedPreferenceManager.setInt(WRONG_CODE, 0)
            hideKeyboard()
            checkAndRedirect()
        } else if (SharedPreferenceManager.getInt(WRONG_CODE) > 5) {
            binding.pinEditText.setText("")
            showGenerateOtp()
        } else {
            val toast = Toast.makeText(this, "Invalid PIN! Try again", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 100)
            toast.show()
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({ binding.pinEditText.setText("") }, 50)
            count++
            if (count > 5) {
                SharedPreferenceManager.setInt(WRONG_CODE, count)
                showGenerateOtp()
            }
        }
    }

    private fun showGenerateOtp() {
        commonAlertDialog!!.showAlertDialog(resources.getString(R.string.message_toomany_attempts),
            resources.getString(R.string.generate_otp), resources.getString(R.string.cancel_otp),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
    }

    /**
     * to check and redirect to appropriate screens
     */
    private fun checkAndRedirect() {
        if (isFromShowDialog) {
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.SHOW_PIN, false)
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BIOMETRIC, false)
            SafeChatUtils.silentDisableSafeChat(this)
        }
        when (goTo) {
            com.contusfly.utils.Constants.QUICK_SHARE -> {
                AppLifecycleListener.isFromQuickShareForBioMetric = false
                AppLifecycleListener.isFromQuickShareForPin = false
                finish()
            }
            "CHATVIEW" -> {
                if (isFromChatShortcut!!) {
                    Log.d("TAG", "isFromChatShortcut")
                    startActivities(
                        TaskStackBuilder.create(this.applicationContext)
                            .addNextIntent(
                                Intent(this.applicationContext, DashboardActivity::class.java).setAction(Intent.ACTION_VIEW)
                                    .putExtra(com.contusfly.utils.Constants.IS_FROM_CHAT_SHORTCUT, chatType)
                                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)).addNextIntent(Intent(this.applicationContext, ChatActivity::class.java).setAction(Intent.ACTION_VIEW)
                                .putExtra(LibConstants.JID, jid).putExtra(Constants.CHAT_TYPE, chatType)).intents)
                } else {
                    startActivities(
                        TaskStackBuilder.create(this)
                            .addNextIntent(Intent(this, DashboardActivity::class.java).setAction(Intent.ACTION_VIEW))
                            .addNextIntent(Intent(this, ChatActivity::class.java).setAction(Intent.ACTION_VIEW)
                                .putExtra(LibConstants.JID, jid).putExtra(Constants.CHAT_TYPE, chatType)).intents)
                    finish()
                }
            }
            Constants.LOGOUT_PIN -> {
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.SHOW_PIN, false)
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BIOMETRIC, false)
                SafeChatUtils.silentDisableSafeChat(this)
                SharedPreferenceManager.setString(com.contusfly.utils.Constants.CHANGE_PIN_NEXT, "")
                SharedPreferenceManager.setString(com.contusfly.utils.Constants.MY_PIN, "")
                val resultIntent = Intent()
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
            else -> {
                handleReDirections()
            }
        }
        isFromShowDialog = false
    }

    private fun handleReDirections() {
        if (SafeChatUtils.updateSafeChat != SafeChatUtils.SafeChatUpdate.NONE) {
            SafeChatUtils.actionAuthorized(this, object : () -> Unit {
                override fun invoke() {
                    finish()
                }
            })
        } else if ("DASHBOARD" == goTo || !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.RESET_PIN)) {
            if (isFromSettings) finish()
            else {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }
        } else finish()
    }

    fun hidePinFilledView(imageView: MutableList<AppCompatImageView>) {
        for (iv in imageView) iv.visibility = View.GONE
    }

    /**
     * to set fill drawable on the imageview
     *
     * @param imageView- view of the pin
     */
    fun setPinFillDrawable(imageView: MutableList<AppCompatImageView>) {
        for (iv in imageView) {
            iv.visibility = View.VISIBLE
            iv.setImageResource(R.drawable.ic_pin_filled_drawable)
        }
    }

    /**
     * to set empty drawable on the imageview
     *
     * @param imageView- view of the pin
     */
    fun setPinEmptyDrawable(imageView: MutableList<AppCompatImageView>) {
        for (iv in imageView) iv.setImageResource(R.drawable.ic_pin_empty)
    }

    /**
     * to check the last launch date
     *
     * @param daysBetween- days inbetween the last launch and current launch
     */
    private fun checkLastLaunchedDate(daysBetween: Float) {
        if (SharedPreferenceManager.getString(com.contusfly.utils.Constants.LAST_LAUNCH_DATE) != SimpleDateFormat("yyyy/MM/dd", Locale.US).format(Date())) {
            showAlertDialog(daysBetween)
            SharedPreferenceManager.setString(com.contusfly.utils.Constants.LAST_LAUNCH_DATE, SimpleDateFormat("yyyy/MM/dd", Locale.US).format(Date()))
        }
    }

    /**
     * to store the alert date of the pin (5 days before expiry)
     */
    @SuppressLint("StringFormatMatches")
    private fun showAlertDialog(daysBetween: Float) {
        builder.setMessage(String.format(resources.getString(R.string.alert_message, daysBetween.toInt() + 1)))
        builder.setNegativeButton("Change pin") { dialog: DialogInterface, _: Int ->
            goToChangePinActivity()
            dialog.dismiss()
        }
        builder.setPositiveButton(resources.getString(R.string.ok)) { dialog: DialogInterface, _: Int -> dialog.dismiss() }
        if(bottomSheetOtpFragment?.isVisible != true) {
            dialog.show()
        }
    }

    /**
     * to check and show the expiry alert
     */
    private fun showExpiryAlert() {
        val expiryDateString = SharedPreferenceManager.getString(com.contusfly.utils.Constants.EXPIRY_DATE)
        val alertDateString = SharedPreferenceManager.getString(com.contusfly.utils.Constants.ALERT_DATE)
        val sdf = SimpleDateFormat("E MMM dd HH:mm:ss yyyy", Locale.getDefault())
        try {
            expiryDate = sdf.parse(expiryDateString)
            alertDate = sdf.parse(alertDateString)
        } catch (e: Exception) {
            LogMessage.e("TAG", e.toString())
        }
        val todayDate = Calendar.getInstance().time
        if (alertDate != null && expiryDate != null) {
            if (alertDate!! <= todayDate && todayDate <= expiryDate) {
                val difference = expiryDate!!.time - todayDate.time
                val daysBetween = (difference / (1000 * 60 * 60 * 24)).toFloat()
                /* You can also convert the milliseconds to days using this method
                 * float daysBetween = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
                 */LogMessage.v("TAG", "Number of Days between dates: $daysBetween")
                checkLastLaunchedDate(daysBetween)
            } else if (expiryDate!! < todayDate)
                showDialog()
        }
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        Log.d("TAG", "onDialogClosed: out$isSuccess")
        if (isSuccess) {
            Log.d("TAG", "onDialogClosed: in$isSuccess")
            sendOtp()
        }
    }

    override fun listOptionSelected(position: Int) {
        TODO("Not yet implemented")
    }

    override fun cancelCallBack() {
        showExpiryAlert()
    }

    private fun callBackFromPhoneAuth() {
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                if (phoneAuthCredential.smsCode == null) goToPinEntry() else {
                    otp = phoneAuthCredential.smsCode
                    goToPinEntry()
                    LogMessage.d("TAG", phoneAuthCredential.smsCode)
                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                if (e is FirebaseAuthInvalidCredentialsException){
                    CustomToast.show(this@PinActivity, this@PinActivity.getString(R.string.valid_mobile_number))
                } else if (e is FirebaseTooManyRequestsException){
                    CustomToast.show(this@PinActivity, "Too many Request,Please Try again later")
                    setUpPinExpiryDialog()
                }
                dismissProgress()
            }

            override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
                CustomToast.show(this@PinActivity, "OTP sent successfully")
                super.onCodeSent(s, forceResendingToken)
                verificationCode = s
                resendingToken = forceResendingToken
                goToPinEntry()
            }
        }
    }

    /**
     * to redirect to pin entry change screens
     */
    fun goToPinEntry() {
        setOnClickListerForSendOTP()
        val bundle = Bundle()
        bundle.putBoolean("DISABLE_BIO", isFromDisableBio)
        bundle.putBoolean("DISABLE_BOTH", isFromDisableBoth)
        bundle.putString("TYPE", "FORGOT")
        bundle.putString("otp", otp)
        bundle.putString("verficationCode", verificationCode)
        bundle.putParcelable("resendingCode", resendingToken)
        bottomSheetOtpFragment!!.arguments = bundle
        bottomSheetOtpFragment!!.isCancelable = false
        if (!bottomSheetOtpFragment!!.isAdded && !bottomSheetOtpFragment!!.isVisible) bottomSheetOtpFragment!!.show(supportFragmentManager, "otp")
        dismissProgress()
    }

    /**
     * to hide the keyboard to the user
     */
    private fun hideKeyboard() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * to get current pin
     */
    private val currentPin: Unit
        get() {
            myPin = SharedPreferenceManager.getString(com.contusfly.utils.Constants.MY_PIN)
        }

    /**
     * to get Intent
     */
    private val intentExtras: Unit
        get() {
            val intentKey = com.contusfly.utils.Constants.GO_TO
            if (intent.hasExtra(intentKey)) {
                goTo = intent.getStringExtra(intentKey).toString()
                if (goTo.equals("CHATVIEW", ignoreCase = true)) {
                    jid = intent.getStringExtra(LibConstants.JID)
                    chatType = intent.getStringExtra(Constants.CHAT_TYPE)
                } else if (goTo.equals(Constants.PIN_EXPIRE_BIOMETRIC, ignoreCase = true))
                    showDialog()
            }
        }

    /**
     * to show the alert dialog
     */
    private fun showDialog() {
        val message = "Your current PIN has been expired. Please set a new PIN to continue further"
        builder.setMessage(message)
        builder.setNegativeButton("Change PIN") { dialog: DialogInterface, _: Int ->
            goToChangePinActivity()
            dialog.dismiss()
        }
        builder.setPositiveButton("Forgot PIN?") { dialog: DialogInterface, _: Int ->
            sendOtp()
            dialog.dismiss()
        }
        builder.setNeutralButton("DISABLE PIN") { dialog: DialogInterface, _: Int ->
            isFromShowDialog = true
            CustomToast.show(applicationContext, "Enter Current Pin To Disable Pin And FingerPrint")
            dialog.dismiss()
        }
        builder.setCancelable(false)
        if(bottomSheetOtpFragment?.isVisible != true) {
            dialog.show()
        }
    }

    /**
     * to redirect to the pinentry change screen
     */
    private fun goToChangePinActivity() {
        startActivityForResult(
            Intent(this, PinEntryChange::class.java)
                .putExtra("TYPE", "CHANGE")
                .putExtra("FROM_SETTINGS", false),
            RequestCode.SET_NEW_PIN
        )
    }

    /**
     * to send the otp
     */
    private fun sendOtp() {
        progressDialog!!.setMessage(getString(R.string.sending_otp))
        progressDialog!!.isIndeterminate = true
        progressDialog!!.setCancelable(false)
        progressDialog!!.show()
        sendVerificationCode()
    }

    /**
     * to dismiss the progress dialog
     */
    fun dismissProgress() {
        if (progressDialog != null) progressDialog!!.dismiss()
    }

    /**
     * Sends the verification code to the user's phone using Firebase services to authenticate the
     * user sign-in.
     */
    private fun sendVerificationCode() {
        val phoneNumber = StringBuilder()
        val mobile = SharedPreferenceManager.getString(com.contusfly.utils.Constants.USER_MOBILE_NUMBER)
        if (!mobile.startsWith("+")) phoneNumber.append("+")
        phoneNumber.append(mobile)
        val timeoutDuration = resources.getString(R.string.firebase_auth_timeout_duration).toLong()
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber.toString(), timeoutDuration, TimeUnit.SECONDS, this@PinActivity, mCallbacks!!)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        bottomSheetOtpFragment!!.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 500 && data != null) {
            val disablePin = data.getBooleanExtra("disable_pin", false)
            if (disablePin) {
//                SharedPreferenceManager.setString(com.contusfly.utils.Constants.MY_PIN, "")
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.SHOW_PIN, false)
                SafeChatUtils.silentDisableSafeChat(this)
                CustomToast.show(this, "Pin disabled")
                callAppListener(false)
                finish()
            } else {
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BIOMETRIC, false)
                finish()
            }
        }else if(requestCode == RequestCode.SET_NEW_PIN && resultCode == Activity.RESULT_OK) {
           goToDashBoard()
        }
    }

    /**
     * if Pin Expired, this function helps to navigate to Dashboard after new pin set.
     */
    fun goToDashBoard(){
        goTo = "DASHBOARD"
        dialog.dismiss()
    }

    /**
     * to set click function for sendotp
     */
    private fun setOnClickListerForSendOTP() {
        binding.forgotPin.setOnClickListener { sendOtpAlert() }
    }

    private fun sendOtpAlert() {
        commonAlertDialog!!.showAlertDialog(resources.getString(R.string.otp_generate),
            resources.getString(R.string.generate_otp), resources.getString(R.string.cancel_otp),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
    }

    companion object {
        private const val WRONG_CODE = "Wrong_password_count"

        /**
         * to indicate applifecyclelistencer class
         *
         * @param isShow bool value to show pin screen
         */
        private fun callAppListener(isShow: Boolean) {
            AppLifecycleListener.pinActivityShowing = isShow
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineContext.cancel(CancellationException("Destroyed"))
    }
}
