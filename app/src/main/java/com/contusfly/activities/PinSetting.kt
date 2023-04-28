package com.contusfly.activities

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import com.an.biometric.BiometricCallback
import com.an.biometric.BiometricManager
import com.mirrorflysdk.flynetwork.ApiCalls
import com.mirrorflysdk.flynetwork.model.DefaultResponse
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.contusfly.R
import com.contusfly.databinding.ActivityPinSettingBinding
import com.contusfly.showToast
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SafeChatUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PinSetting : AppCompatActivity(), BiometricCallback/*, CallLogListener*/, CommonAlertDialog.CommonDialogClosedListener, CoroutineScope,CallLogManager.CallLogActionListener {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception :  ${exception.printStackTrace()}")
    }

    @Inject
    lateinit var apiCalls: ApiCalls

    private lateinit var binding: ActivityPinSettingBinding

    /**
     * The dialog for the common alert dialog.
     */
    private var mDialog: CommonAlertDialog? = null

    /**
     * The is clear chat want to clear it.
     */
    private var isClearChat = false

    /**
     * Progress dialog for the background process
     */
    private var progressDialog: ProgressDialog? = null

    /**
     * instance of biometric manager class
     */
    private var mBiometricManager: BiometricManager? = null

    /**
     * to get current pin
     */
    private val pinAvailable: Boolean get() =  SharedPreferenceManager.getString(Constants.MY_PIN).isNotEmpty()

    private var isForSafeChat: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityPinSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isForSafeChat = intent.getBooleanExtra(Constants.IS_FOR_SAFE_CHAT,false)
        setToolbar()
    }

    /**
     * to set the toolbar
     */
    private fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        progressDialog = ProgressDialog(this)
        mDialog = CommonAlertDialog(this)
        mDialog!!.setOnDialogCloseListener(this)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "App Lock"
        }
        toolbar.background = ContextCompat.getDrawable(this, R.drawable.gradient_top)
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.navigationIcon!!.setColorFilter(
            ContextCompat
            .getColor(this, R.color.color_black), PorterDuff.Mode.MULTIPLY)
        toolbar.setNavigationOnClickListener { finish() }
        initViews()
    }

    /**
     * to to initialize the views and widgets
     */
    fun initViews() {
        checkFingerPrintAuthentication()
        binding.layoutDeleteAccount.setOnClickListener {
            isClearChat = false
            mDialog!!.showAlertDialog(
                getString(R.string.msg_are_you_sure_you_want_to_delete_ac),
                getString(R.string.action_yes), getString(R.string.action_no),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
            )
        }
        binding.setPinLayout.setOnClickListener {
            goToSetOrChangePinActivity("SET", false)
        }
        binding.changePinLayout.setOnClickListener {
            goToSetOrChangePinActivity("CHANGE", false)
        }
        setPinNotes()
    }

    private fun setPinNotes() {
        val sec = 32
        val seconds = sec % 60.toLong()
        val stringBuilder = StringBuilder()

        stringBuilder.append(String.format(resources.getString(R.string.pin_message_1), seconds))
        stringBuilder.append(System.getProperty("line.separator"))
        stringBuilder.append(String.format(resources.getString(R.string.notes), 31))
        binding.pinMessageText.text = stringBuilder
    }

    private fun handleBiometricChecked() {
        if (SharedPreferenceManager.getBoolean(Constants.SHOW_PIN) &&
            SharedPreferenceManager.getString(Constants.MY_PIN).isNotEmpty()) {
            LogMessage.d("PinSettings", "biochecked")
            val intent = Intent(this@PinSetting, PinActivity::class.java)
            intent.putExtra("DISABLE", false)
            intent.putExtra(HIDEFORGET, true)
            intent.putExtra("FROM_SETTINGS", true)
            intent.putExtra("SET_BIOMETRIC", true)
            startActivity(intent)
        } else {
            showAlert()
        }
    }

    private fun showAlert() {
        binding.biometricTogglePin.isChecked = false
        mDialog!!.showAlertDialog(getString(R.string.msg_set_pin_alert), getString(R.string.action_Ok),
            getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_SINGLE, false)
        mDialog!!.dialogAction = CommonAlertDialog.DialogAction.SET_PIN_ALERT
    }

    private fun handleBiometricUnChecked() {
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(this@PinSetting, PinActivity::class.java)
            intent.putExtra("DISABLE_BIO", true)
            intent.putExtra(HIDEFORGET, true)
            intent.putExtra("FROM_SETTINGS", true)
            intent.putExtra("SET_BIOMETRIC", false)
            startActivity(intent)
        }
    }

    private fun handlePinUnChecked() {
        if (SharedPreferenceManager.getBoolean(Constants.SHOW_PIN)) {
            val intent = Intent(this@PinSetting, PinActivity::class.java)
            intent.putExtra("DISABLE_BOTH", true)
            intent.putExtra("FROM_SETTINGS", true)
            intent.putExtra(HIDEFORGET, true)
            startActivity(intent)
        } else {
            binding.setChangePinLayout.visibility = View.GONE
        }
    }

    private fun goToSetOrChangePinActivity(type: String?, isFromBio: Boolean) {
        SharedPreferenceManager.setBoolean(Constants.SET_PIN_BEFORE_BIOMETRIC, isFromBio)

        val intent = Intent(this, PinEntryChange::class.java)
        intent.putExtra("TYPE", type)
        intent.putExtra("FROM_SETTINGS", true)
        intent.putExtra("IS_FOR_SAFE_CHAT",isForSafeChat)
        startActivity(intent)
    }

    private fun handlePinChecked() {
        if (SharedPreferenceManager.getBoolean(Constants.SHOW_PIN)) {
            binding.changePinLayout.visibility = View.VISIBLE
            binding.setPinLayout.visibility = View.GONE
        } else {
            if(pinAvailable) {
                    SharedPreferenceManager.setBoolean(Constants.SHOW_PIN, true)
                    val expiryDate = calculateNextExpiryDate(31)
                    val alertDate = calculateNextExpiryDate(31 - 5)
                    SharedPreferenceManager.setString(Constants.EXPIRY_DATE, expiryDate.toString().replace("GMT+05:30", ""))
                    SharedPreferenceManager.setString(Constants.ALERT_DATE, alertDate.toString().replace("GMT+05:30", ""))
                    binding.setChangePinLayout.visibility = View.VISIBLE
                    binding.changePinLayout.visibility = View.VISIBLE
                    binding.setPinLayout.visibility = View.GONE
            } else {
                if (SharedPreferenceManager.getBoolean(Constants.SHOW_PIN)) {
                    binding.changePinLayout.visibility = View.VISIBLE
                    binding.setPinLayout.visibility = View.GONE
                } else {
                    goToSetOrChangePinActivity("SET", false)
                }
            }
        }
    }

    /**
     * to calculate the expiry date
     *
     * @param noOfDays - number of days for expiring.
     */
    private fun calculateNextExpiryDate(noOfDays: Int): Date {
        val c = Calendar.getInstance()
        c.add(Calendar.DATE, noOfDays)
        return c.time
    }

    private fun checkFingerPrintAuthentication() {
        // Check if we're running on Android 6.0 (M) or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.llFingerPrint.visibility = View.VISIBLE
            binding.llFingerPrintView.visibility = View.VISIBLE
            binding.txtTitle.visibility = View.GONE

            //Fingerprint API only available on from Android 6.0 (M)
            val fingerprintManager = FingerprintManagerCompat.from(this)
            if (!fingerprintManager.isHardwareDetected) {
                // Device doesn't support fingerprint authentication
                binding.llFingerPrint.visibility = View.GONE
                binding.llFingerPrintView.visibility = View.GONE
                binding.txtTitle.visibility = View.GONE
            }
        } else {
            binding.llFingerPrint.visibility = View.GONE
            binding.llFingerPrintView.visibility = View.GONE
            binding.txtTitle.visibility = View.GONE
        }
    }

    companion object {
        private const val HIDEFORGET = "HIDE_FORGET"
    }



    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) if (mDialog!!.dialogAction == CommonAlertDialog.DialogAction.SET_PIN_ALERT) {
            goToSetOrChangePinActivity("SET", true)
        } else deleteRecords()
    }

    /**
     * Delete records from the all chats
     */
    private fun deleteRecords() {
        /**
         * Check the option selected by user
         */
        if (!isClearChat) {
            progressDialog!!.show()
            deleteAccount()
        } else {
//            CfDatabaseManager.getDatabaseManager().deleteAllMessages()
            CustomToast.show(this, resources.getString(R.string.msg_chat_msg_deleted))
        }
    }

    /**
     * Logout request to delete account
     */
    private fun deleteAccount() {
        if (AppUtils.isNetConnected(this)) {

            launch(exceptionHandler) {

                val logoutResponse = apiCalls.logout().await()

                withContext(Dispatchers.Main.immediate) {

                    if (logoutResponse.isSuccessful) {
                        val response = logoutResponse.body()!!
                        handleLogoutSuccess(response)
                    } else {
                        LogMessage.e("TAG", "Error in deleteAccount")
                    }
                }
            }
        } else {
            progressDialog!!.dismiss()
            CustomToast.show(this, getString(R.string.msg_no_internet))
        }
    }

    private fun handleLogoutSuccess(response: DefaultResponse) {
        try {
            progressDialog!!.dismiss()
            val message = response.message!!
            progressDialog!!.dismiss()
            if (message.equals("Uploaded Successfully", ignoreCase = true)) {
                showToast("Log Uploaded Successfully")
            } else {
                handleLogoutResponse(response.status!!.toString(), message)
            }
        } catch (e: Exception) {
            progressDialog!!.dismiss()
            LogMessage.e("TAG",e)
        }
    }

    private fun handleLogoutResponse(status: String, message: String) {
        try {
            if (Constants.STATUS_CODE_SUCCESS == status) {
                launch(exceptionHandler) {
                    CallLogManager.clearCallLog(apiCalls,this@PinSetting)
                }
            } else {
                if (Constants.STATUS_CODE_SECURITY_TOKEN_ERROR == status) {
                    LogMessage.e("PinSetting", "Token refresh error")
                } else
                    showToast(message)
            }
        } catch (e: Exception) {
            LogMessage.e("TAG",e)
        }
    }

    override fun onStart() {
        super.onStart()
        if (SharedPreferenceManager.getBoolean(Constants.SHOW_PIN)) {
            binding.togglePin.isChecked = true
            binding.setChangePinLayout.visibility = View.VISIBLE
            binding.setPinLayout.visibility = View.GONE
            binding.changePinLayout.visibility = View.VISIBLE
        } else {
            binding.togglePin.isChecked = false
            binding.setChangePinLayout.visibility = View.GONE
        }

        binding.biometricTogglePin.isChecked = SharedPreferenceManager.getBoolean(Constants.BIOMETRIC) && isFingerPrintAvailable(this)
        binding.biometricTogglePin.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean -> if (isChecked) verifyFingerprintIsEnabledInDevice() else handleBiometricUnChecked() }
        binding.togglePin.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean -> if (isChecked) handlePinChecked() else handlePinUnChecked() }
        if(SafeChatUtils.updateAlert)
            finish()
    }

    fun isFingerPrintAvailable(context: Context): Boolean {
        val fingerprintManager = FingerprintManagerCompat.from(context)
        return fingerprintManager.isHardwareDetected && fingerprintManager.hasEnrolledFingerprints()
    }

    override fun onResume() {
        super.onResume()
        binding.biometricTogglePin.isChecked = SharedPreferenceManager.getBoolean(Constants.BIOMETRIC) && isFingerPrintAvailable(this)
    }

    private fun verifyFingerprintIsEnabledInDevice() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val fingerprintManager = this@PinSetting.getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager
            if (!fingerprintManager.isHardwareDetected) {
                binding.biometricTogglePin.isChecked = false
                CustomToast.show(this@PinSetting, "Fingerprint is not supported")
            } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                CustomToast.show(this@PinSetting, "Please enable the fingerprint on your device")
                binding.biometricTogglePin.isChecked = false
            } else if(!SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)){
                Log.e("PinSettings", "verifyFingerprintIsEnabledInDevice: ")
                handleBiometricChecked()
            }
        }
    }

    override fun listOptionSelected(position: Int) {
        TODO("Not yet implemented")
    }


    override fun onSdkVersionNotSupported() {
        Toast.makeText(applicationContext, getString(R.string.biometric_error_sdk_not_supported), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(applicationContext, getString(R.string.biometric_error_hardware_not_supported), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationNotAvailable() {
        SharedPreferenceManager.setBoolean(Constants.BIOMETRIC, true)
        binding.biometricTogglePin.isChecked = true
        Toast.makeText(applicationContext, getString(R.string.biometric_error_fingerprint_not_available), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(applicationContext, getString(R.string.biometric_error_permission_not_granted), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationInternalError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationFailed() {
        Toast.makeText(applicationContext, getString(R.string.biometric_failure), Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationCancelled() {
        SharedPreferenceManager.setBoolean(Constants.BIOMETRIC, true)
        binding.biometricTogglePin.isChecked = true
        Toast.makeText(applicationContext, getString(R.string.biometric_cancelled), Toast.LENGTH_LONG).show()
        mBiometricManager!!.cancelAuthentication()
    }

    override fun onAuthenticationSuccessful() {
        SharedPreferenceManager.setBoolean(Constants.BIOMETRIC, false)
        binding.biometricTogglePin.isChecked = false
        Toast.makeText(applicationContext, "Biometric disabled", Toast.LENGTH_LONG).show()
        if (SharedPreferenceManager.getBoolean(Constants.IS_SET_PIN)) {
            binding.setChangePinLayout.visibility = View.VISIBLE
            if (SharedPreferenceManager.getBoolean(Constants.SHOW_PIN)) {
                binding.changePinLayout.visibility = View.VISIBLE
                binding.setPinLayout.visibility = View.GONE
            } else {
                binding.setPinLayout.visibility = View.VISIBLE
                binding.changePinLayout.visibility = View.GONE
            }
        }
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
        Toast.makeText(applicationContext, helpString, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        Toast.makeText(applicationContext, errString, Toast.LENGTH_LONG).show()
    }

    override fun onActionSuccess() {
        TODO("Not yet implemented")
    }

}
