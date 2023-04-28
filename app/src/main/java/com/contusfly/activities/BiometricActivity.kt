package com.contusfly.activities

import android.app.KeyguardManager
import android.content.Intent
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.TaskStackBuilder
import com.an.biometric.BiometricCallback
import com.an.biometric.BiometricManager
import com.an.biometric.BiometricManager.BiometricBuilder
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.AppLifecycleListener
import com.contusfly.R
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SafeChatUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.ChatManager.closeXMPPConnection
import com.mirrorflysdk.api.ChatManager.pinActivity
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class BiometricActivity : BaseActivity(), BiometricCallback {

    companion object{
        private const val GOTOCONST = Constants.GO_TO
        private const val INTENT_AUTHENTICATE = 200
        private val TAG = BiometricActivity::class.java.simpleName
        /**
         * to indicate applifecyclelistencer class
         *
         * @param isShow bool value to show pin screen
         */
        private fun callAppListener(isShow: Boolean) {
            AppLifecycleListener.pinActivityShowing = isShow
        }
    }


    /**
     * instance of biometric manager class
     */
    private var mBiometricManager: BiometricManager? = null

    /**
     * authentication failed count
     */
    var count = 0

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
     * to check pin is expired or not
     */
    private val pinExpired: Boolean
        get() {
        val expiryDateString: String = SharedPreferenceManager.getString(Constants.EXPIRY_DATE)
        val sdf = SimpleDateFormat("E MMM dd HH:mm:ss yyyy")
        try {
            expiryDate = sdf.parse(expiryDateString)
        } catch (e: Exception) {
            LogMessage.e(TAG, e.toString())
        }
        val todayDate = Calendar.getInstance().time
        return expiryDate != null && expiryDate!! < todayDate
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callAppListener(true)
        if (SystemClock.uptimeMillis() -  SharedPreferenceManager.getInt("Uptime").toLong() <= 30000) {
            LogMessage.d("TAG", "inside")
            pinForDashBoard()
        }
        setContentView(R.layout.activity_biometric)
        getIntentExtras()
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.IS_PIN_VALIDATED, true)
    }

    override fun onSdkVersionNotSupported() {
        Toast.makeText(
            applicationContext,
            getString(R.string.biometric_error_sdk_not_supported),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(
            applicationContext,
            getString(R.string.biometric_error_hardware_not_supported),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onBiometricAuthenticationNotAvailable() {
        SharedPreferenceManager.setBoolean(Constants.BIOMETRIC,false)
        Toast.makeText(
            applicationContext,
            getString(R.string.biometric_error_fingerprint_not_available),
            Toast.LENGTH_LONG
        ).show()
        pinForDashBoard()
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(
            applicationContext,
            getString(R.string.biometric_error_permission_not_granted),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onBiometricAuthenticationInternalError(error: String?) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationFailed() {
        count++
        if (count > 2) {
            Toast.makeText(applicationContext, getString(R.string.biometric_failure), Toast.LENGTH_LONG)
                .show()
            mBiometricManager?.cancelAuthentication()
            finish()
            pinForDashBoard()
        }
    }
    override fun onResume() {
        super.onResume()
        SharedPreferenceManager.setBoolean(Constants.PIN_SCREEN,true)
    }

    override fun onAuthenticationCancelled() {
        mBiometricManager?.cancelAuthentication()
        SharedPreferenceManager.setBoolean(Constants.BACK_PRESS, false)
        callAppListener(true)
        pinForDashBoard()
    }

    override fun onStart() {
        super.onStart()
        showBiometricDialog()
    }

    private fun showBiometricDialog(){
        count = 0
        /*
         *
         * */mBiometricManager = BiometricBuilder(this@BiometricActivity)
            .setTitle(getString(R.string.biometric_title))
            .setSubtitle(getString(R.string.biometric_subtitle))
            .setDescription(getString(R.string.biometric_description))
            .setNegativeButtonText(getString(R.string.use_pin))
            .build()
        //start authentication
        mBiometricManager!!.authenticate(this@BiometricActivity)
    }

    override fun onAuthenticationSuccessful() {
        if (pinExpired) {
            val intent = Intent(
                applicationContext,
                PinActivity::class.java
            )
            intent.putExtra(GOTOCONST, Constants.PIN_EXPIRE_BIOMETRIC)
            startActivity(intent)
            finish()
        } else {
            SharedPreferenceManager.setInt("Wrong_password_count", 0)
            SharedPreferenceManager.setBoolean(Constants.IS_PIN_VALIDATED, false)
            checkAndRedirect()
        }
    }

    private fun checkAndRedirect() {
        when {
            "CHATVIEW" == goTo -> {
                startActivities(TaskStackBuilder.create(this)
                    .addNextIntent(
                        Intent(this, DashboardActivity::class.java).setAction(Intent.ACTION_VIEW)
                    )
                    .addNextIntent(
                        Intent(this, ChatActivity::class.java)
                            .setAction(Intent.ACTION_VIEW).putExtra(LibConstants.JID, jid)
                            .putExtra(Constants.CHAT_TYPE, chatType)
                    ).intents
                )
                finish()
            }
            SafeChatUtils.updateSafeChat != SafeChatUtils.SafeChatUpdate.NONE-> {
                SafeChatUtils.actionAuthorized(this, object : () -> Unit {
                    override fun invoke() {
                        finish()
                        }
                    })
            }
            AppLifecycleListener.isFromQuickShareForBioMetric -> {
                AppLifecycleListener.isFromQuickShareForBioMetric = false
                AppLifecycleListener.isFromQuickShareForPin = false
                finish()
            }
            "DASHBOARD" == goTo -> {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }
            else -> finish()
        }
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
        Toast.makeText(applicationContext, helpString, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
        mBiometricManager?.cancelAuthentication()
        if (errorCode == BiometricPrompt.BIOMETRIC_ERROR_LOCKOUT) {
            val upTimeWhenCallBackReceive = SystemClock.uptimeMillis()
            SharedPreferenceManager.setInt("Uptime", upTimeWhenCallBackReceive.toInt())
            finish()
            pinForDashBoard()
        } else if (errorCode == BiometricPrompt.BIOMETRIC_ERROR_LOCKOUT_PERMANENT) {
            mBiometricManager?.cancelAuthentication()
            finish()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val km = getSystemService(KEYGUARD_SERVICE) as KeyguardManager
                if (km.isKeyguardSecure) {
                    val authIntent = km.createConfirmDeviceCredentialIntent(
                        getString(R.string.verify_device_password),
                        getString(R.string.enable_finger_print)
                    )
                    startActivityForResult(authIntent, INTENT_AUTHENTICATE)
                }
            }
        } else {
            SharedPreferenceManager.setBoolean(Constants.BACK_PRESS, false)
            callAppListener(true)
            closeXMPPConnection()
            Snackbar.make(activity!!.findViewById(android.R.id.content),
                "Confirm your fingerprint to proceed",
                Snackbar.LENGTH_INDEFINITE)
                .setAction("verify") {
                    showBiometricDialog()
                }.show()
        }
    }

    /**
     * redirect to pin screen after authernication failed
     */
    private fun pinForDashBoard() {
        val intent = Intent(applicationContext, pinActivity)
        intent.putExtra(GOTOCONST, goTo)
        intent.putExtra(LibConstants.JID, jid)
        intent.putExtra(com.mirrorflysdk.flycommons.Constants.CHAT_TYPE, chatType)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        applicationContext.startActivity(intent)
        finish()
    }

    private fun getIntentExtras() {
        if (intent.hasExtra(GOTOCONST)) {
            goTo = intent.getStringExtra(GOTOCONST)!!
            if (goTo.equals("CHATVIEW", ignoreCase = true)) {
                jid = intent.getStringExtra(LibConstants.JID)
                chatType = intent.getStringExtra(Constants.CHAT_TYPE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == INTENT_AUTHENTICATE && resultCode == RESULT_OK) {
            pinForDashBoard()
        }
    }

    override fun onAdminBlockedUser(jid: String, status: Boolean) {
        super.onAdminBlockedUser(jid, status)
        if (status) {
            mBiometricManager!!.closeBiometricDialogIfOpened()
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.BACK_PRESS, false)
        ActivityCompat.finishAffinity(this)
    }
}
