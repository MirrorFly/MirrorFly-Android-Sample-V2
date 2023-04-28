package com.contusfly.activities

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.databinding.ActivityAdminBlockedBinding
import com.contusfly.utils.CommonUtils
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SharedPreferenceManager

class AdminBlockedActivity : BaseActivity(), View.OnClickListener {

    private lateinit var adminBlockedBinding: ActivityAdminBlockedBinding
    private var supportEmailID: AppCompatTextView? = null
    private var handler: Handler? = null
    private var adminBlockStatus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adminBlockedBinding = ActivityAdminBlockedBinding.inflate(layoutInflater)
        setContentView(adminBlockedBinding.root)
        SharedPreferenceManager.setBoolean(Constants.ADMIN_BLOCKED, false)
        initViews()
    }

    private fun initViews() {
        handler = Handler(Looper.getMainLooper())
        supportEmailID = adminBlockedBinding.adminMailAddress
        supportEmailID!!.text = BuildConfig.SUPPORT_MAIL
        supportEmailID!!.paintFlags = supportEmailID!!.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        supportEmailID!!.setOnClickListener(this)
        adminBlockedBinding.userOk.setOnClickListener(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishApp()
    }

    private fun finishApp() {
        CommonUtils.navigateUserToLoggedOutUI(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.admin_mail_address -> startActivity(Intent.createChooser(getEmailIntent(supportEmailID!!.text.toString().trim()), "Send mail"))
            R.id.user_ok -> finishApp()
        }
    }

    private fun getEmailIntent(email: String): Intent {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        //intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        return getIntent(intent, true)
    }

    private fun getIntent(intent: Intent, isNewTask: Boolean): Intent {
        return if (isNewTask) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) else intent
    }

    override fun onAdminBlockedUser(jid: String, status: Boolean) {
        adminBlockStatus = status
        LogMessage.d(TAG, "#onAdminBlockedStatus == $adminBlockStatus")
        //To avoid multiple callbacks
        handler?.postDelayed({
            userNavigateToDashboardPage(adminBlockStatus)
        },800)
    }

    private fun userNavigateToDashboardPage(status: Boolean) {
        if (!status && SharedPreferenceManager.getBoolean(Constants.IS_LOGGED_IN)) {
            if (SharedPreferenceManager.getBoolean(Constants.IS_PROFILE_LOGGED)) {
                startActivity(Intent(this, DashboardActivity::class.java).putExtra(Constants.FROM_ADMIN_BLOCK_SCREEN, true).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            } else {
                startActivity(Intent(this, ProfileStartActivity::class.java).putExtra(Constants.IS_FIRST_LOGIN, true)
                    .putExtra(Constants.FROM_SPLASH, true))
            }
            finish()
        }
    }
}