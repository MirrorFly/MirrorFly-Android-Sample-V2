package com.contusfly.activities

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.*
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.R
import com.contusfly.*
import com.contusfly.databinding.ActivityOtpBinding
import com.contusfly.helpers.OtpInteractor
import com.contusfly.helpers.OtpPresenter
import com.contusfly.interfaces.IOtpInteractor
import com.contusfly.interfaces.IOtpPresenter
import com.contusfly.interfaces.IOtpView
import com.contusfly.utils.*
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.utils.Utils.clearOldData
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.*
import com.mirrorflysdk.api.notification.PushNotificationManager
import com.mirrorflysdk.utils.ChatUtilsOperations
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import io.michaelrocks.libphonenumber.android.NumberParseException
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import io.michaelrocks.libphonenumber.android.Phonenumber
import kotlinx.coroutines.*
import org.json.JSONObject
import java.lang.Runnable
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class OtpActivity : BaseActivity(), IOtpView, View.OnClickListener,
    CommonAlertDialog.CommonDialogClosedListener, CoroutineScope {

    private lateinit var otpBinding: ActivityOtpBinding

    /**
     * User mobile number
     */
    var mobile: String? = null


    lateinit var otpEditTextViews: Array<AppCompatEditText>

    /**
     * Instance of the presenter interface, will used to access the multiple values
     */
    private lateinit var otpViewPresenter: IOtpPresenter

    /**
     * Mobile number of the user
     */
    private lateinit var mobileNumber: String

    /**
     * Country code
     */
    private lateinit var countryCode: String

    /**
     * Country Name
     */
    private var country: String? = null

    /**
     * Progress dialog
     */
    lateinit var progress: ProgressDialog

    /**
     * Get the interactor instance to access the interactor
     *
     * @return IOtpInteractor Instance of IOtpInteractor
     */
    /**
     * Instance of the ILoginInteractor
     */
    lateinit var otpInteractor: IOtpInteractor

    /**
     * Alter dialog to display for the user action confirmation
     */
    private var mDialog: CommonAlertDialog? = null

    /**
     * Store the account management option to manage account
     */
    private var manageAccount: ManageAccount? = null

    /**
     * handler for posting runnable
     */
    private var handler: Handler? = null

    /**
     * This runnable is used to close the progress after a {@value LOGIN_TIME_OUT} milliseconds
     */
    private var progressTimeoutRunnable: Runnable? = null

    private lateinit var telephonyManager: TelephonyManager

    private var isExisting: Boolean = false

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val downloadPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { _ ->
        gotoRestorePage()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        AutoStartHelper.instance.getAutoStartPermission(this@OtpActivity)
        super.onCreate(savedInstanceState)
        otpBinding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(otpBinding.root)
        telephonyManager =
            activityContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        setupCountryCode()
        val dialCode = "+" + PhoneNumberUtil.createInstance(applicationContext)
            .getCountryCodeForRegion(countryCode)
        SharedPreferenceManager.setString(Constants.DIAL_CODE, dialCode)
        SharedPreferenceManager.setString(Constants.COUNTRY_CODE, countryCode)
        otpBinding.toolbar.root.visibility = View.GONE
        setSupportActionBar(otpBinding.toolbar.root)
        otpBinding.toolbar.toolbarTitle.text = getString(R.string.register_label)
        supportActionBar?.title = Constants.EMPTY_STRING
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        mDialog = CommonAlertDialog(this)
        mDialog!!.setOnDialogCloseListener(this)

        setupInitialData(dialCode)
    }

    override fun onResume() {
        super.onResume()
        if (otpBinding.edtMobileNo.hasFocus()) {
            otpBinding.edtMobileNo.requestFocus()
            otpBinding.edtMobileNo.showSoftKeyboard()
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }

    /*
    * Setup Initial Data */
    private fun setupInitialData(dialCode: String) {
        otpBinding.txtCountry.text = country
        otpBinding.txtCode.text = dialCode
        setupDefaultMobileNo()
        otpViewPresenter = OtpPresenter(otpBinding)
        otpViewPresenter.attach(this)
        otpInteractor = OtpInteractor(this, otpBinding)
        progress = ProgressDialog(this, R.style.AppCompatAlertDialogStyle)
        progress.setMessage(getString(R.string.please_wait_label))
        progress.setCancelable(false)
        progress.setCanceledOnTouchOutside(false)

        setOtpEditText()
        clickListener()
        handler = Handler(Looper.getMainLooper())

        otpBinding.txtTermsAndConditions.text = String.format(
            getString(R.string.terms_and_privacy_policy_label),
            getString(R.string.terms_and_condition_label),
            getString(R.string.privacy_policy_label)
        )
        otpBinding.txtTermsAndConditions.makeLinks(
            Pair(getString(R.string.terms_and_condition_label), View.OnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.terms_and_conditions_link))
                    )
                )
            }),
            Pair(getString(R.string.privacy_policy_label), View.OnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.privacy_policy_link))
                    )
                )
            })
        )
    }

    private fun isReadDefaultPhoneNumberPermissionAllowed(context: Context?): Boolean {
        val readDefaultPhoneNumber =
            ContextCompat.checkSelfPermission(context!!, Manifest.permission.READ_PHONE_STATE)
        val readDefaultPhoneNumberMaxApiLevel =
            ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_NUMBERS)

        return readDefaultPhoneNumber == PackageManager.PERMISSION_GRANTED && readDefaultPhoneNumberMaxApiLevel == PackageManager.PERMISSION_GRANTED
    }


    private fun setupDefaultMobileNo() {

        val requestPhoneNumberRead = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            if (!permissions.containsValue(false)) {
                otpBinding.edtMobileNo.setText(splitPhoneNumber())
            }
        }

        if (!isReadDefaultPhoneNumberPermissionAllowed(context)) {
            requestPhoneNumberRead.launch(
                arrayOf(
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_PHONE_NUMBERS
                )
            )
        } else {
            otpBinding.edtMobileNo.setText(splitPhoneNumber())
        }
    }

    /*
    * Setup Country code */
    private fun setupCountryCode() {
        val telephonyManager =
            activityContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        countryCode = telephonyManager.simCountryIso.toUpperCase()
        val countryName = CountriesListObject.getCountriesListByCountryCode(this, countryCode)
        if (countryName.isNotEmpty()) {
            country = countryName
        } else {
            countryCode = Locale.getDefault().country
            country = Locale.getDefault().displayCountry
        }
        ChatManager.setUserCountryISOCode(countryCode)
    }

    private fun setOtpEditText() {
        val otpBox1: AppCompatEditText = otpBinding.edtVerifyCode.otp1
        val otpBox2: AppCompatEditText = otpBinding.edtVerifyCode.otp2
        val otpBox3: AppCompatEditText = otpBinding.edtVerifyCode.otp3
        val otpBox4: AppCompatEditText = otpBinding.edtVerifyCode.otp4
        val otpBox5: AppCompatEditText = otpBinding.edtVerifyCode.otp5
        val otpBox6: AppCompatEditText = otpBinding.edtVerifyCode.otp6

        setTouchListener(otpBox1)
        setTouchListener(otpBox2)
        setTouchListener(otpBox3)
        setTouchListener(otpBox4)
        setTouchListener(otpBox5)
        setTouchListener(otpBox6)

        otpEditTextViews = arrayOf(otpBox1, otpBox2, otpBox3, otpBox4, otpBox5, otpBox6)
        otpBox1.addTextChangedListener(PinTextWatcher(0, otpEditTextViews, this))
        otpBox2.addTextChangedListener(PinTextWatcher(1, otpEditTextViews, this))
        otpBox3.addTextChangedListener(PinTextWatcher(2, otpEditTextViews, this))
        otpBox4.addTextChangedListener(PinTextWatcher(3, otpEditTextViews, this))
        otpBox5.addTextChangedListener(PinTextWatcher(4, otpEditTextViews, this))
        otpBox6.addTextChangedListener(PinTextWatcher(5, otpEditTextViews, this))

        otpBox1.setOnKeyListener(PinOnKeyListener(0, otpEditTextViews))
        otpBox2.setOnKeyListener(PinOnKeyListener(1, otpEditTextViews))
        otpBox3.setOnKeyListener(PinOnKeyListener(2, otpEditTextViews))
        otpBox4.setOnKeyListener(PinOnKeyListener(3, otpEditTextViews))
        otpBox5.setOnKeyListener(PinOnKeyListener(4, otpEditTextViews))
        otpBox6.setOnKeyListener(PinOnKeyListener(5, otpEditTextViews))
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setTouchListener(editText: AppCompatEditText) {
        editText.setOnTouchListener { _, _ ->
            editText.requestFocus()
            false
        }
    }

    /**
     * Handle the click listener based on the user input
     */
    private fun clickListener() {
        otpBinding.viewGetOtp.setOnClickListener(this)
        otpBinding.txtResend.setOnClickListener(this)
        otpBinding.txtChangeNumber.setOnClickListener(this)
        otpBinding.txtCountry.setOnClickListener(this)
        otpBinding.viewVerify.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::progress.isInitialized && progress.isShowing)
            progress.cancel()
        coroutineContext.cancel(CancellationException("$TAG Destroyed"))
    }

    /**
     * Get the Context of the activity.
     *
     * @return Activity Instance of the Context
     */
    override val activityContext: Activity
        get() = this

    /**
     * Get the mobile number of the user
     *
     * @return String Mobile number
     */
    override fun getMobileNumber(): String? {
        return if (!TextUtils.isEmpty(mobileNumber)) {
            if (mobileNumber.startsWith("000000")) mobileNumber else {
                val userMobileNumber = BigInteger(mobileNumber)
                userMobileNumber.toString()
            }
        } else Constants.EMPTY_STRING
    }

    /**
     * Set the mobile number of the user
     *
     * @param mobileNumber Mobile number fo the user
     */
    override fun setMobileNumber(mobileNumber: String) {
        this.mobileNumber = mobileNumber
    }

    /**
     * Get the country code
     *
     * @return String Country code
     */
    override fun getCountryCode(): String? {
        return Utils.returnEmptyStringIfNull(countryCode)
    }

    /**
     * Get the dial number
     *
     * @return String Dial number
     */
    override fun getDialNumber(): String {
        return otpBinding.txtCode.text.toString().replace("+", "")
    }

    /**
     * Enable the otp screen view
     */
    override fun enableOtpView() {
        otpViewPresenter.enableOtpAndOperation()
    }

    override fun getOtpEditText(): Array<AppCompatEditText> {
        return otpEditTextViews
    }

    /**
     * make the otp text box disable
     *
     * @param editTexts array of edit text
     */
    override fun setOtpTextViewDisable(editTexts: Array<AppCompatEditText>) {
        editTexts[0].isEnabled = false
        editTexts[1].isEnabled = false
        editTexts[2].isEnabled = false
        editTexts[3].isEnabled = false
        editTexts[4].isEnabled = false
        editTexts[5].isEnabled = false
    }

    /**
     * make the otp text box enable
     *
     * @param editTexts array of edit text
     */
    override fun setOtpTextViewEnabled(editTexts: Array<AppCompatEditText>) {
        editTexts[0].isEnabled = true
        editTexts[1].isEnabled = true
        editTexts[2].isEnabled = true
        editTexts[3].isEnabled = true
        editTexts[4].isEnabled = true
        editTexts[5].isEnabled = true
    }

    /**
     * set the text to the otp text box
     *
     * @param text text to be entered
     */
    override fun setTextForOtpTextView(text: String?) {
        text?.let {
            val textArray = it.toCharArray()
            var i = 0
            while (i < textArray.size) {
                otpEditTextViews[i].setText(textArray[i].toString())
                i++
            }
        }
    }

    /**
     * Make auto login after otp received
     */

    override fun otpAutoLogin() {
        onClick(otpBinding.viewVerify)
    }

    /**
     * make the otp text box empty
     *
     * @param editTexts array of edit text
     */
    override fun setOtpTextViewEmpty(editTexts: Array<AppCompatEditText>) {
        editTexts[0].setText("")
        editTexts[1].setText("")
        editTexts[2].setText("")
        editTexts[3].setText("")
        editTexts[4].setText("")
        editTexts[5].setText("")
    }

    /**
     * get the entered string from the otp text box
     *
     * @param editTexts array of edittext
     * @return return the entered otp
     */
    override fun getStringFromOtpTextView(editTexts: Array<AppCompatEditText>): String {
        return (editTexts[0].text.toString().trim { it <= ' ' } + editTexts[1].text.toString()
            .trim { it <= ' ' }
                + editTexts[2].text.toString().trim { it <= ' ' } + editTexts[3].text.toString()
            .trim { it <= ' ' }
                + editTexts[4].text.toString().trim { it <= ' ' } + editTexts[5].text.toString()
            .trim { it <= ' ' })
    }

    override fun getOtpProgress(): ProgressDialog? {
        return progress
    }

    /**
     * Dismiss the progress
     */
    override fun dismissProgress() {
        if (::progress.isInitialized)
            progress.dismiss()
    }

    override fun getInteractor(): IOtpInteractor {
        return otpInteractor
    }

    /**
     * Show the progress dialog with message
     */
    override fun showProgress() {
        if (::progress.isInitialized)
            progress.show()
    }

    /**
     * Manage register/blocked user options
     */
    private enum class ManageAccount {
        REGISTER, ON_REGISTER, BLOCK_ACCOUNT, LOGIN, SESSION_EXPIRED
    }

    companion object {
        val TAG = OtpActivity::class.java.simpleName

        /**
         * login time out in milliseconds to close progress dialog
         */
        private const val LOGIN_TIME_OUT: Long = 20000 //20 seconds(20000ms)
    }

    override fun showUserAccountDeviceStatus() {
        manageAccount = ManageAccount.REGISTER
        FlyCore.logoutOfChatSDK(FlyCallback { _, _, _ -> })
        mDialog!!.showAlertDialog(
            activityContext.getString(R.string.already_logged),
            activityContext.getString(R.string.yes_label),
            activityContext.getString(R.string.no_label),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
            false
        )
    }

    override fun showUserBlockedDialog() {
        manageAccount = ManageAccount.BLOCK_ACCOUNT
        mDialog!!.showAlertDialog(
            activityContext.getString(R.string.account_blocked_label),
            activityContext.getString(R.string.ok_label), Constants.EMPTY_STRING,
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )

    }

    override fun onClick(view: View?) {
        when (view) {
            otpBinding.viewGetOtp -> {
                progress.setMessage(resources.getString(R.string.please_wait_label))
                progress.show()
                setOtpTextViewEmpty(getOtpEditText())
                otpViewPresenter.validateAndSendOtp()
                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
            otpBinding.txtResend -> {
                progress.setMessage(resources.getString(R.string.resend_otp_message))
                progress.show()
                otpBinding.viewVerify.visibility = View.VISIBLE
                otpInteractor.getOtp(true)
            }
            otpBinding.txtChangeNumber -> {
                setOtpTextViewEmpty(getOtpEditText())
                otpBinding.viewVerify.visibility = View.VISIBLE
                otpViewPresenter.disableOtpAndOperation()
                otpBinding.edtMobileNo.setText("")
                otpBinding.edtMobileNo.requestFocus()
                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
            otpBinding.txtCountry -> {
                startActivityForResult(
                    Intent(this, CountryListActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP),
                    Constants.COUNTRY_REQUEST_CODE
                )
            }
            otpBinding.viewVerify -> {
                if (AppUtils.isNetConnected(this@OtpActivity)) {
                    val otp = getStringFromOtpTextView(getOtpEditText())
                    if (!TextUtils.isEmpty(otp) && otp.length == 6) {
                        otpViewPresenter.verifyOtp()
                        otpBinding.viewVerify.visibility = View.GONE
                    } else {
                        if (TextUtils.isEmpty(otp))
                            CustomToast.show(
                                activityContext,
                                activityContext.getString(R.string.enter_otp_label)
                            )
                        else
                            CustomToast.show(
                                activityContext,
                                activityContext.getString(R.string.enter_valid_otp_label)
                            )
                    }
                } else
                    CustomToast.show(
                        activityContext,
                        activityContext.getString(R.string.error_check_internet)
                    )
            }
        }
    }

    /**
     * check if the last logged number and  current logged number are same.
     * true- take him/her directly to dashboard activty
     * false- follow the normal flow along with db clearing process
     */
    private fun checkCurrentUser() {
        SharedPreferenceManager.setString(Constants.USER_MOBILE_NUMBER, mobile)
        handleProgress()
    }

    /**
     * Handling progress dialog
     */
    private fun handleProgress() {
        progressTimeoutRunnable = Runnable {
            if (::progress.isInitialized && progress.isShowing && this@OtpActivity.isDestroyed) {
                progress.dismiss()
                Toast.makeText(
                    activityContext,
                    getString(R.string.error_check_internet),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        handler!!.postDelayed(progressTimeoutRunnable!!, LOGIN_TIME_OUT)
    }

    /**
     * on activity result
     *
     * @param requestCode requestCode of action
     * @param resultCode  result code for activity
     * @param data        intent data
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /* setting isActivityStartedForResult to false for xmpp disconnection */
        ChatManager.isActivityStartedForResult = false
        if (resultCode == Activity.RESULT_OK && data != null) {
            otpBinding.txtCountry.text = data.getStringExtra(Constants.COUNTRY_NAME)
            otpBinding.txtCode.text =
                Utils.returnEmptyStringIfNull(data.getStringExtra(Constants.DIAL_CODE))
            countryCode = Utils.returnEmptyStringIfNull(data.getStringExtra(Constants.COUNTRY_CODE))
            SharedPreferenceManager.setString(
                Constants.DIAL_CODE,
                data.getStringExtra(Constants.DIAL_CODE)
            )
            SharedPreferenceManager.setString(Constants.COUNTRY_CODE, countryCode)
            ChatManager.setUserCountryISOCode(countryCode)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RequestAppPermissionUtils.PERMISSION_REQUEST_READ_CONTACTS && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_DENIED)
            CustomToast.show(
                applicationContext,
                resources.getString(R.string.verification_code_label)
            )
    }

    /**
     * Split country code and phone number
     */

    private fun splitPhoneNumber(): String {
        var nationalNumber = ""
        try {
            val phoneUtil: PhoneNumberUtil = PhoneNumberUtil.createInstance(activity)
            val numberProto: Phonenumber.PhoneNumber = phoneUtil.parse(
                telephonyManager.line1Number,
                telephonyManager.simCountryIso.toUpperCase(Locale.getDefault())
            )
            nationalNumber = numberProto.nationalNumber.toString()
        } catch (e: NumberParseException) {
            LogMessage.e(Constants.TAG, e)
        }
        return nationalNumber
    }

    /**
     * Request to register the user account
     */
    override fun registerAccount(isForceRegister:Boolean) {
        LogMessage.d(TAG, "registering account")
        if (AppUtils.isNetConnected(this)) {
            ChatManager.setUserCountryISOCode(countryCode)
            var resource = SharedPreferenceManager.getString(Constants.XMPP_RESOURCE)
            if (Constants.EMPTY_STRING == resource) {
                resource = ChatUtilsOperations().generateRandomString()
                SharedPreferenceManager.setString(Constants.XMPP_RESOURCE, resource)
            }
            /*
              Firebase token for user account
             */
            val regId = SharedPreferenceManager.getString(Constants.FIRE_BASE_TOKEN)
            mobile = getDialNumber().replace("+", "") + getMobileNumber()

            manageAccount = ManageAccount.ON_REGISTER
            FlyCore.registerUser(mobile!!, regId, isForceRegister) { isSuccess, _, data ->
                if (isSuccess) {
                    val isNewUser = data["is_new_user"] as Boolean
                    if (isNewUser)
                        clearOldData(this)
                    renderUserRegistrationResponseData(data.getData() as JSONObject)
                } else {
                    showErrorResponse(data)
                }
            }

        } else {
            dismissProgress()
            CustomToast.show(this, getString(R.string.error_check_internet))
        }
    }

    private fun showErrorResponse(data: HashMap<String, Any>) {
        dismissProgress()
        if (data.getHttpStatusCode() == 403) {
            startActivity(
                Intent(
                    this,
                    AdminBlockedActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()

        } else if(data.getHttpStatusCode() == 405){

            sessionExpiredDialogShow(data.getMessage())
        }
        else {
            otpBinding.viewVerify.visibility = View.VISIBLE
            Log.d(TAG, "showErrorResponse: ${data.getMessage()}")
            showToast(data.getMessage())
        }
    }

    private fun sessionExpiredDialogShow(message: String) {
        manageAccount = ManageAccount.SESSION_EXPIRED
        FlyCore.logoutOfChatSDK(FlyCallback { _, _, _ -> })
        mDialog!!.showAlertDialog(
            message,
            activityContext.getString(R.string.continue_label),
            activityContext.getString(R.string.action_cancel),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
            false
        )
    }

    /*
    * Register API Success Response */
    private fun renderUserRegistrationResponseData(decodedResponseObject: JSONObject) {
        try {
            LogMessage.d(TAG, decodedResponseObject.toString())
            val username: String = decodedResponseObject.getString(Constants.USERNAME)
            isExisting = decodedResponseObject.getBoolean(Constants.IS_EXISTING)

            SharedPreferenceManager.setString(Constants.USERNAME, username)
            SharedPreferenceManager.setBoolean(Constants.IS_LOGGED_IN, true)
            SharedPreferenceManager.setBoolean(Constants.IS_MESSAGE_MIGRATION_DONE, true)

            checkCurrentUser()
            CallManager.setCurrentUserId(FlyUtils.getJid(username))
            SharedPreferenceManager.setString(Constants.SENDER_USER_JID, FlyUtils.getJid(username))
            SharedPreferenceManager.setString(Constants.USER_JID, FlyUtils.getJid(username))

            PushNotificationManager.updateFcmToken(
                SharedPreferenceManager.getString(Constants.FIRE_BASE_TOKEN),
                object : ChatActionListener {
                    override fun onResponse(isSuccess: Boolean, message: String) {
                        if (isSuccess)
                            LogMessage.e(TAG, "Token updated successfully")
                    }
                })

        } catch (e: Exception) {
            dismissProgress()
            showToast(e.message)
            LogMessage.e(TAG, e)
        }
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            if (manageAccount == ManageAccount.REGISTER) {
                progress.show()
                registerAccount()
            } else if (manageAccount == ManageAccount.SESSION_EXPIRED) {
                progress.show()
                registerAccount(true)
            }
        } else deleteUserAccount()
        /*
          Delete the user account if the account has been blocked by admin
         */
        if (manageAccount == ManageAccount.BLOCK_ACCOUNT) deleteUserAccount()
    }

    /**
     * Delete the user account
     */
    private fun deleteUserAccount() {
        progress.show()
        CommonUtils.navigateUserToLoggedOutUI(applicationContext)
    }

    override fun listOptionSelected(position: Int) {
        TODO("Not yet implemented")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    override fun onConnected() {
        if (SharedPreferenceManager.getString(Constants.SENDER_USER_JID).isNotEmpty()) {
            ChatManager.setUserCountryISOCode(countryCode)
            dismissProgress()
            if (ChatUtils.checkWritePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                gotoRestorePage()
            } else {
                MediaPermissions.requestContactStorageAccess(
                    this,
                    permissionAlertDialog,
                    downloadPermissionLauncher
                )
            }
        }
    }

    private fun gotoRestorePage() {
        val intent = Intent(this@OtpActivity, RestoreActivity::class.java)
        intent.putExtra("isExisting", isExisting)
        startActivity(intent)
        finish()
    }


}