package com.contusfly.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.AppLifecycleListener
import com.contusfly.R
import com.contusfly.databinding.ActivityPinEntryChangeBinding
import com.contusfly.databinding.ActivityProfileStartBinding
import com.contusfly.interfaces.PinStatus
import com.contusfly.utils.Constants
import com.contusfly.utils.SafeChatUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.views.CustomToast
import java.text.ParseException
import java.util.*

class PinEntryChange : AppCompatActivity() {

     /**
     * to store the title and set it to the action bar layout
     */
    private var title: String? = null

    /**
     * to store the new pin value
     */
    private var setPinValue: String? = null

    /**
     * to store the confirm pin value
     */
    private var confirmPinValue: String? = null

    /**
     * to store the old pin value
     */
    private var oldPinValue: String? = null

    /**
     * to store the error message value that shown on the toast message
     */
    private var errorMessage: String? = null

    /**
     * to get type of pin
     */
    private var pinType: String? = null


    private lateinit var binding: ActivityPinEntryChangeBinding

    /**
     * to store the pin
     */
    private var myPin: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myPin = SharedPreferenceManager.getString(Constants.MY_PIN)
        binding = ActivityPinEntryChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        showKeyboard()
    }

    /**
     * to set the tool bar and get Intent values and validate
     */
    fun setToolbar() {
        setSaveBtnOnClickListener()
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val type = intent.getStringExtra("TYPE")
        if (type.equals("SET", ignoreCase = true)) {
            pinType = PinStatus.PIN_SET
            title = "PIN Lock"
            binding.oldLayout!!.visibility = View.GONE
        } else if (type.equals("forgot", ignoreCase = true)) {
            callAppListener(true)
            pinType = PinStatus.PIN_FORGOT
            title = "Change PIN"
            binding.oldLayout!!.visibility = View.GONE
            binding.newPinLayout!!.visibility = View.VISIBLE
            binding.setPin!!.isFocusable = true
            binding.confirmPinLayout!!.visibility = View.VISIBLE
        } else if (type.equals("CHANGE", ignoreCase = true)) {
            pinType = PinStatus.PIN_CHANGE
            title = "Change PIN"
        }
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = title
        }
        toolbar.background = resources.getDrawable(R.drawable.gradient_top)
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.navigationIcon!!.setColorFilter(
            ContextCompat
            .getColor(this, R.color.color_black), PorterDuff.Mode.MULTIPLY)
        toolbar.setNavigationOnClickListener { _: View? -> finish() }
    }

    /**
     * to validate the pin
     */
    private fun validatePin(): Boolean {
        return if (setPinValue!!.isEmpty()) {
            errorMessage = "Enter the PIN"
            false
        } else if (setPinValue!!.length < 4) {
            errorMessage = "PIN must be of 4 digits"
            false
        } else if (confirmPinValue!!.isEmpty()) {
            errorMessage = "Enter the Confirm PIN"
            false
        } else if (confirmPinValue!!.length < 4) {
            errorMessage = "Confirm PIN must be of 4 digits"
            false
        } else if (!setPinValue.equals(confirmPinValue, ignoreCase = true)) {
            errorMessage = "PIN and Confirm PIN must be same"
            false
        } else if (pinType == PinStatus.PIN_CHANGE && oldPinValue == confirmPinValue || myPin == confirmPinValue) {
            errorMessage = "Old PIN and new PIN should not be same"
            false
        } else if (pinType == PinStatus.PIN_SET && setPinValue == SharedPreferenceManager.getString(Constants.CHANGE_PIN_NEXT)) {
            errorMessage = "PIN should not be same as immediate previous PIN"
            false
        } else {
            true
        }
    }

    /**
     * click listener for save vutton
     */
    private fun setSaveBtnOnClickListener() {
        binding.saveBtn!!.setOnClickListener { _: View? ->
            if (validateOldAndNewPin()) {
                if (validatePin()) {
                    pinSaveChangeValidation()
                } else {
                    CustomToast.show(this@PinEntryChange, errorMessage)
                }
            } else {
                CustomToast.show(this@PinEntryChange, errorMessage)
            }
        }
    }

    private fun pinSaveChangeValidation() {
        try {
            if(intent.extras!!.containsKey("FROM_PRIVATE_CHAT")) {
                privateChatSavePin()
            } else {
                savePin()
            }
        } catch (e: ParseException) {
            LogMessage.e("TAG", e.toString())
        }
    }

    /**
     * to save the pin
     */
    @Throws(ParseException::class)
    private fun savePin() {
        val enableSafeChat = SafeChatUtils.updateSafeChat == SafeChatUtils.SafeChatUpdate.ENABLE
        if (pinType == PinStatus.PIN_CHANGE) {
            CustomToast.show(ChatManager.applicationContext, "PIN changed successfully")
            SharedPreferenceManager.setBoolean(Constants.RESET_PIN, true)
        }  else if(!enableSafeChat)
            CustomToast.show(ChatManager.applicationContext, "PIN set successfully")
        val expiryDate = calculateNextExpiryDate(31)
        val alertDate = calculateNextExpiryDate(31 - 5)
        SharedPreferenceManager.setString(Constants.EXPIRY_DATE, expiryDate.toString().replace("GMT+05:30", ""))
        SharedPreferenceManager.setString(Constants.ALERT_DATE, alertDate.toString().replace("GMT+05:30", ""))
        SharedPreferenceManager.setInt(Constants.PIN_TIMEOUT,32)
        SharedPreferenceManager.setString(Constants.MY_PIN, confirmPinValue)
        SharedPreferenceManager.setBoolean(Constants.RESET_PIN, true)
        SharedPreferenceManager.setString(Constants.CHANGE_PIN_NEXT, confirmPinValue)
        SharedPreferenceManager.setBoolean(Constants.SHOW_PIN, true)
        SharedPreferenceManager.setBoolean(Constants.CLOSE_DIALOG, true)
        callAppListener(false)
        when {
            intent.getStringExtra("fromScreen") != null -> {
                if(enableSafeChat){
                    updateSafeChat()
                }else {
                    startActivity(Intent(this, DashboardActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    finish()
                }
            }
            !intent.getBooleanExtra("FROM_SETTINGS", false) -> {
                setResult(RESULT_OK)
                finish()
            }
            else -> {
                if (SharedPreferenceManager.getBoolean(Constants.SET_PIN_BEFORE_BIOMETRIC)){
                    SharedPreferenceManager.setBoolean(Constants.BIOMETRIC, true)
                    updateSafeChat()
                }else if(intent.getBooleanExtra("IS_FOR_SAFE_CHAT",false)){
                    updateSafeChat()
                }
                finish()
            }
        }
    }


    /**
     * to save the pin
     */
    @Throws(ParseException::class)
    private fun privateChatSavePin() {
        SharedPreferenceManager.setString(Constants.MY_PIN, confirmPinValue)
        SharedPreferenceManager.setBoolean(Constants.RESET_PIN, true)
        SharedPreferenceManager.setString(Constants.CHANGE_PIN_NEXT, confirmPinValue)
        val intent=Intent()
        intent.putExtra(Constants.PRIVATE_CHAT_TYPE,Constants.PRIVATE_CHAT_ENABLE)
        setResult(RESULT_OK,intent)
        finish()
    }

    private fun updateSafeChat(){
        SafeChatUtils.actionAuthorized(this,object : () -> Unit {
            override fun invoke() {
                finish()
            }
        })
    }

    /**
     * to calculate the expiry date
     *
     * @param noOfDays - number of days for expiring.
     */
    fun calculateNextExpiryDate(noOfDays: Int): Date {
        val c = Calendar.getInstance()
        c.add(Calendar.DATE, noOfDays)
        return c.time
    }

    /**
     * to validate the otp
     */
    private fun validateOldAndNewPin(): Boolean {
        oldPinValue = binding.oldPin.text.toString()
        setPinValue = binding.setPin.text.toString()
        confirmPinValue = binding.confirmPin.text.toString()
        Log.d("PIN", "$setPinValue $confirmPinValue")
        if (pinType == PinStatus.PIN_CHANGE) {
            if (!oldPinValue.equals(myPin, ignoreCase = true)) {
                errorMessage = "Invalid old PIN"
                return false
            }
            return validatePin()
        }
        return true
    }

    /**
     * to show key board to the user
     */
    private fun showKeyboard() {
        if (pinType == PinStatus.PIN_SET) {
            binding.setPin.requestFocus()
        } else {
            binding.oldPin.requestFocus()
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    /**
     * to hide key board to the user
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

    override fun onPause() {
        hideKeyboard()
        super.onPause()
    }

    override fun onBackPressed() {
        hideKeyboard()
        super.onBackPressed()
    }

    override fun onDestroy() {
        callAppListener(false)
        super.onDestroy()
    }


    companion object {

        /**
         * to indicate applifecyclelistencer class
         *
         * @param isShow bool value to show pin screen
         */
        private fun callAppListener(isShow: Boolean) {
            AppLifecycleListener.pinActivityShowing = isShow
        }
    }
}
