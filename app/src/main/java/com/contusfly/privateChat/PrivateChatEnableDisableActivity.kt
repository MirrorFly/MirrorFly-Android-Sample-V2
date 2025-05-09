package com.contusfly.privateChat

import android.content.Context
import android.content.Intent
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.activities.BaseActivity
import com.contusfly.activities.BiometricActivity
import com.contusfly.activities.PinActivity
import com.contusfly.activities.PinEntryChange
import com.contusfly.clearDeletedGroupChatNotification
import com.contusfly.databinding.ActivityPrivateChatEnableDisableBinding
import com.contusfly.models.PrivateChatAuthenticationModel
import com.contusfly.utils.Constants
import com.contusfly.utils.LogMessage
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.views.CustomToast
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class PrivateChatEnableDisableActivity : BaseActivity() {

    private lateinit var mContext: Context
    private lateinit var binding: ActivityPrivateChatEnableDisableBinding
    lateinit var toUser : String
    private val commonAlertDialog by lazy { CommonAlertDialog(this) }
    /**
     * to get current pin
     */
    private val pinAvailable: Boolean get() =  SharedPreferenceManager.getString(Constants.MY_PIN).isNotEmpty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivateChatEnableDisableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext=this@PrivateChatEnableDisableActivity
        setToolbar()
    }

    private fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = resources.getString(R.string.label_private_chat)
        }
        toolbar.background = ContextCompat.getDrawable(this, R.drawable.gradient_top)
        toolbar.setNavigationIcon(R.drawable.ic_back)
        if (Build.VERSION.SDK_INT >= 29) {
            BlendModeColorFilter(
                ContextCompat
                    .getColor(this, R.color.color_black), BlendMode.MULTIPLY
            )
        } else {
            PorterDuffColorFilter(
                ContextCompat.getColor(this, R.color.color_black),
                PorterDuff.Mode.MULTIPLY
            )
        }
        toolbar.setNavigationOnClickListener { finish() }
        handleMainIntent()
        checkIsAlreadyPrivateChatUser()
        onClick()
    }

    override fun onSuperAdminDeleteGroup(groupJid: String, groupName: String) {
        super.onSuperAdminDeleteGroup(groupJid, groupName)
        clearDeletedGroupChatNotification(groupJid, context)
        if (toUser == groupJid){
            if (groupName.isNotEmpty())
                CustomToast.show(
                    context,
                    getString(R.string.deleted_by_super_admin, groupName)
                )
            com.contusfly.startDashboardActivity(this)
            finish()
        }
    }

    private fun handleMainIntent() {
        val mainIntent = intent
        toUser = mainIntent.getStringExtra(LibConstants.JID) ?: Constants.EMPTY_STRING
    }

    private fun checkIsAlreadyPrivateChatUser() {

        try {

            if(ChatManager.isPrivateChat(toUser)){
                binding.lockChatSwitch.isChecked=true
            } else {
                binding.lockChatSwitch.isChecked=false
            }

        } catch(e : Exception) {
          LogMessage.e(TAG,e.toString())
        }

    }

    private fun onClick(){
        binding.lockChatSwitch.setOnClickListener {
            if(ChatManager.isPrivateChat(toUser)) {
                launchPinActivity(Constants.PRIVATE_CHAT_DISABLE)
            } else {
                setEnablePrivateChat()
            }
        }

    }

    private fun setEnablePrivateChat() {
        if(pinAvailable) {
            launchPinActivity(Constants.PRIVATE_CHAT_ENABLE)
        } else {
            launchSetPinActivity()
        }
    }

    private fun launchSetPinActivity() {
        val intent=Intent(mContext,PinEntryChange::class.java)
        intent.putExtra("TYPE", "SET")
        intent.putExtra("FROM_SETTINGS", false)
        intent.putExtra("FROM_PRIVATE_CHAT", true)
        myActivityResultLauncher.launch(intent)
    }

    private fun launchPinActivity(chatEnableDisableValue: String) {

        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(this, BiometricActivity::class.java)
            intent.putExtra(Constants.GO_TO, chatEnableDisableValue)
            myActivityResultLauncher.launch(intent)
        } else  {
            val intent = Intent(mContext, PinActivity::class.java)
            intent.putExtra(Constants.GO_TO, chatEnableDisableValue)
            myActivityResultLauncher.launch(intent)
        }

    }


    private var myActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result->
            if (result.resultCode == AppCompatActivity.RESULT_OK && result.data!=null) {
                setPrivateChatEnableOrDisable(result.data!!)
            } else {
                checkIsAlreadyPrivateChatUser()
            }
        }

    private fun setPrivateChatEnableOrDisable(data: Intent) {

        try {
            var privateChatType=data.getStringExtra(Constants.PRIVATE_CHAT_TYPE)
            if(privateChatType == Constants.PRIVATE_CHAT_ENABLE) {
                privateChatStatusChange(true)
            } else if(privateChatType == Constants.PRIVATE_CHAT_DISABLE) {
                privateChatStatusChange(false)
            }

        } catch(e: Exception) {
            LogMessage.e(TAG,e.toString())
        }
    }

    private fun privateChatStatusChange(status:Boolean){
        binding.lockChatSwitch.isChecked=status
        showDialogFirstPrivateChatUser(status)
        ChatManager.setPrivateChat(toUser,status)
    }

    private fun showDialogFirstPrivateChatUser(privateChatEnabledStatus: Boolean) {

       if(privateChatEnabledStatus && ChatManager.getPrivateChatList().size == 0){

            commonAlertDialog.privateChatEnableDialog(this,
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, object : CommonAlertDialog.CommonDialogClosedListener{
                    override fun onDialogClosed(
                        dialogType: CommonAlertDialog.DIALOGTYPE?,
                        isSuccess: Boolean) {
                        if (isSuccess) {
                            val intent = Intent(mContext, PrivateChatListActivity::class.java)
                            intent.putExtra(Constants.GO_TO, Constants.DASHBOARD)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        }
                    }

                    override fun listOptionSelected(position: Int) {
                        //Not Needed
                    }
                })

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: PrivateChatAuthenticationModel?) {
        if(messageEvent!!.isAutheticationShow) {
            launchAuthPinActivity()
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }
}