package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.CompoundButton
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.mirrorflysdk.flycommons.*
import com.contusfly.*
import com.contusfly.R
import com.contusfly.R.string.fly_error_forbidden_exception
import com.contusfly.databinding.ActivityUserInfoBinding
import com.contusfly.models.PrivateChatAuthenticationModel
import com.contusfly.network.NetworkConnection
import com.contusfly.privateChat.PrivateChatEnableDisableActivity
import com.contusfly.utils.AppConstants
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.LogMessage
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.DoProgressDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.Utils
import com.google.android.material.appbar.AppBarLayout
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.collapsingToolbar.CollapsingToolbarLayout
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import com.contusfly.utils.Constants.Companion.MUTE_STATUS

class UserInfoActivity : BaseActivity(), CommonAlertDialog.CommonDialogClosedListener {

    private lateinit var binding: ActivityUserInfoBinding

    private lateinit var mAppBarLayout: AppBarLayout

    private lateinit var mCoordinatorLayout: CoordinatorLayout

    private lateinit var collapsingToolbar: CollapsingToolbarLayout

    private lateinit var userProfileDetails: ProfileDetails

    private var commonAlertDialog: CommonAlertDialog? = null

    /**
     * The instance of the DoProgressDialog
     */
    lateinit var progressDialog: DoProgressDialog

    /**
     * check weather the collapsed or not
     */
    private var isToolbarCollapsed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userProfileDetails = intent.getParcelableExtra(AppConstants.PROFILE_DATA)!!
        commonAlertDialog = CommonAlertDialog(this)
        commonAlertDialog!!.setOnDialogCloseListener(this)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setToolbar()
        getLastSeenData()
        setUserData()
        SharedPreferenceManager.setString(com.contusfly.utils.Constants.ON_GOING_CHAT_USER,userProfileDetails.jid)
        binding.muteSwitch.setOnCheckedChangeListener(listener)
        binding.textMedia.setOnClickListener {
            var feature=ChatManager.getAvailableFeatures()
            if(feature.isViewAllMediaEnabled){
                launchActivity<ViewAllMediaActivity> {
                    putExtra(Constants.ROSTER_JID, userProfileDetails.jid)
                }
            } else {
                showToast(resources.getString(fly_error_forbidden_exception))
            }
        }
        binding.reportUser.setOnClickListener {
            val isUserNotAvailable = userProfileDetails.isAdminBlocked || userProfileDetails.isDeletedContact()
            if (isUserNotAvailable) {
                val errorMessage = if (userProfileDetails.isAdminBlocked) getString(R.string.user_block_message_label)
                else getString(R.string.label_deleted_user_report_message)
                runOnUiThread {
                    showToast(errorMessage)
                }
                return@setOnClickListener
            }
            commonAlertDialog!!.dialogAction = CommonAlertDialog.DialogAction.REPORT_MESSAGES
            val reportLabel = getString(R.string.label_report)
            val userName = "$reportLabel ${userProfileDetails.getDisplayName()}?"
            commonAlertDialog!!.showAlertDialog(userName, getString(R.string.label_user_report_5_message), reportLabel,
                getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL)
        }
        checkPrivateChatAvailable()
        onClickFunction()
        observeNetworkListener()
        mediaValidation()
        userFeatureValidation(ChatManager.getAvailableFeatures())
    }

    private fun checkPrivateChatAvailable() {
        try {
            if(ChatManager.getIsRecentChatOfUser(userProfileDetails.jid)) {
                binding.privateChatView.privateChatLayout.visibility=View.VISIBLE
                checkingIsArchivedChatUser()
            } else {
                binding.privateChatView.privateChatLayout.visibility=View.GONE
            }
        } catch(e : Exception){
            LogMessage.e(TAG,e.toString())
        }
    }

    private fun checkingIsArchivedChatUser() {
        if(FlyCore.isArchivedUser(userProfileDetails.jid)){
            binding.privateChatView.privateChatTv.setTextColor(ContextCompat.getColor(this,R.color.color_light_gray))
        } else {
            binding.privateChatView.privateChatTv.setTextColor(ContextCompat.getColor(this,R.color.text_color_black))

        }
    }


    private fun onClickFunction() {
        binding.privateChatView.privateChatLayout.setOnClickListener {
            if(FlyCore.isArchivedUser(userProfileDetails.jid)){
                makeUnArchiveAlertShow()
            } else {
                val intent=Intent(this,PrivateChatEnableDisableActivity::class.java)
                intent.putExtra(LibConstants.JID, userProfileDetails.jid)
                startActivity(intent)
            }
        }
    }

    private fun makeUnArchiveAlertShow(){
        commonAlertDialog!!.dialogAction = CommonAlertDialog.DialogAction.UNARCHIVE
        val archiveLabel = getString(R.string.unarchive_label)
        commonAlertDialog!!.showAlertDialog(Constants.EMPTY_STRING, getString(R.string.archive_chat_lock_title), archiveLabel,
            getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL)
    }

    private fun observeNetworkListener() {
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, {
            if (!it)
                getLastSeenData()
        })
    }

    override fun onConnected() {
        super.onConnected()
        getLastSeenData()
    }

    private fun setToolbar() {

        val toolbar = binding.toolbar
        collapsingToolbar = binding.collapsingToolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        mAppBarLayout = binding.appBarLayout
        mCoordinatorLayout = binding.coordinatorLayout
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.navigationIcon!!.applyMultiplyColorFilter(ContextCompat.getColor(this, R.color.color_black))
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.title = Constants.EMPTY_STRING
        mAppBarLayout.addOnOffsetChangedListener(AppBarLayout.BaseOnOffsetChangedListener { _: AppBarLayout?, verticalOffset: Int ->
            if (collapsingToolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsingToolbar))
                toolbar.navigationIcon!!.applySourceColorFilter(ContextCompat.getColor(this, R.color.color_black))
            else toolbar.navigationIcon!!.applySourceColorFilter(ContextCompat.getColor(this, R.color.color_white))
        } as AppBarLayout.BaseOnOffsetChangedListener<*>)

    }

    private fun setToolbarTitle(title: String) {

        collapsingToolbar.title = title
        (collapsingToolbar.parent as AppBarLayout)
                .addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _: AppBarLayout?, i: Int ->
                    isToolbarCollapsed = i != 0
                    invalidateOptionsMenu()
                })
    }

    private fun setProfileImage(userProfileDetails: ProfileDetails) {
        binding.profileImage.setImageDrawable(null)
        binding.profileImage.loadUserInfoProfileImage(this, userProfileDetails)
    }

    private fun setMuteNotificationStatus(isMute: Boolean, isReceivedFromServer: Boolean = false) {
        LogMessage.d(MUTE_STATUS,"setMuteNotificationStatus called isReceivedFromServer: $isReceivedFromServer")
        if (!FlyCore.isUserUnArchived(userProfileDetails.jid)) {
            binding.muteSwitch.isEnabled = false
            binding.muteSwitch.alpha = 0.5F
        }
        if(isReceivedFromServer) binding.muteSwitch.setOnCheckedChangeListener(null)
        binding.muteSwitch.isChecked = isMute
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            binding.muteSwitch.setOnCheckedChangeListener(listener)
        },500)
    }

    val listener = object:CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            LogMessage.d(MUTE_STATUS,"onCheckedChanged received isChecked: $isChecked")
            var userJidList = mutableListOf<String>()
            userJidList.add(userProfileDetails.jid)
            updateMuteStatus(userJidList,isChecked)
        }
    }

    private fun updateMuteStatus(jidList: MutableList<String>, muteStatus: Boolean) {
        try {
            ChatManager.updateChatMuteStatus(jidList, muteStatus)
        } catch(e: Exception) {
            LogMessage.e(TAG,"#updateMuteStatus exception $e")
        }
    }

    private fun setUserData() {
        binding.emailText.text = userProfileDetails.email
        binding.mobileNumberText.text = userProfileDetails.mobileNumber
        binding.statusText.text = userProfileDetails.status
        setMuteNotificationStatus(userProfileDetails.isMuted)
        setToolbarTitle(userProfileDetails.getDisplayName())
        if (userProfileDetails.isBlockedMe) {
            binding.profileImage.isEnabled = false
            binding.statusText.visibility = View.GONE
            binding.statusTitle.visibility = View.GONE
            binding.statusDivider.visibility = View.GONE
        } else {
            binding.profileImage.setOnClickListener { redirectToImageView() }
        }
        setProfileImage(userProfileDetails)
        if (userProfileDetails.isDeletedContact()){
            binding.mobileNumberText.visibility = View.GONE
            binding.mobileNumberTitle.visibility = View.GONE
            binding.mobileNumberDivider.visibility = View.GONE
            binding.emailText.visibility = View.GONE
            binding.emailTitle.visibility = View.GONE
            binding.emailDivider.visibility = View.GONE
            binding.statusText.visibility = View.GONE
            binding.statusTitle.visibility = View.GONE
            binding.statusDivider.visibility = View.GONE
        }
    }

    override fun userCameOnline(jid: String) {
        super.userCameOnline(jid)
        if (jid == userProfileDetails.jid) {
            getLastSeenData()
        }
    }

    override fun userWentOffline(jid: String) {
        super.userWentOffline(jid)
        if (jid == userProfileDetails.jid) {
            getLastSeenData()
        }
    }

    /**
     * Redirect to user image preview
     */
    private fun redirectToImageView() {
        if (Utils.returnEmptyStringIfNull(userProfileDetails.image).isNotEmpty()) {
            startActivity(
                    Intent(this, ImageViewActivity::class.java)
                        .putExtra(com.contusfly.utils.Constants.GROUP_OR_USER_NAME, userProfileDetails.getDisplayName())
                        .putExtra(Constants.MEDIA_URL, Utils.returnEmptyStringIfNull(userProfileDetails.image))
                        .putExtra(Constants.USER_JID,userProfileDetails.jid)
            )
        }
    }


    private fun getLastSeenData() {
        netConditionalCall({
            if (binding.subTitle.text.isEmpty()) {
                ContactManager.getRegisteredUserLastSeenTime(userProfileDetails.jid, object : ContactManager.LastSeenListener {
                    override fun onFailure(message: String) {
                        binding.subTitle.text = com.contusfly.utils.Constants.EMPTY_STRING
                    }

                    override fun onSuccess(lastSeenTime: String) {
                        binding.subTitle.text = ChatUtils.getLastSeenTime(this@UserInfoActivity,lastSeenTime)
                    }

                })
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    ContactManager.getRegisteredUserLastSeenTime(userProfileDetails.jid, object : ContactManager.LastSeenListener {
                        override fun onFailure(message: String) {
                            binding.subTitle.text = com.contusfly.utils.Constants.EMPTY_STRING
                        }

                        override fun onSuccess(lastSeenTime: String) {
                            binding.subTitle.text = ChatUtils.getLastSeenTime(this@UserInfoActivity,lastSeenTime)
                        }

                    })
                }, 500)
            }
        }, {
            binding.subTitle.text = com.contusfly.utils.Constants.EMPTY_STRING
        })
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        userProfileUpdated(jid)
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        userProfileUpdated(jid)
    }

    override fun onResume() {
        super.onResume()
        userProfileUpdated(userProfileDetails.jid)
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        userProfileUpdated(jid)
    }

    private fun userProfileUpdated(jid: String) {
        if (jid == userProfileDetails.jid) {
            ContactManager.getUserProfile(jid, fetchFromServer = false, saveAsFriend = false) { isSuccess, _, data ->
                if (isSuccess) {
                    userProfileDetails = data.getData() as ProfileDetails
                    setUserData()
                }
            }
        }
    }

    override fun userBlockedMe(jid: String) {
        super.userBlockedMe(jid)
        if (jid == userProfileDetails.jid) {
            ContactManager.getUserProfile(jid, fetchFromServer = false, saveAsFriend = false) { isSuccess, _, data ->
                if (isSuccess) {
                    userProfileDetails = data.getData() as ProfileDetails
                    setUserData()
                    binding.subTitle.text = com.contusfly.utils.Constants.EMPTY_STRING
                }
            }
        }
    }

    override fun userUnBlockedMe(jid: String) {
        super.userUnBlockedMe(jid)
        if (jid == userProfileDetails.jid) {
            ContactManager.getUserProfile(jid, fetchFromServer = false, saveAsFriend = false) { isSuccess, _, data ->
                if (isSuccess) {
                    userProfileDetails = data.getData() as ProfileDetails
                    setUserData()
                    getLastSeenData()
                }
            }
        }

    }

    /**
     * To verify is there any media is present in conversation
     *
     */
    private fun mediaValidation() {
        binding.textMedia.visibility = View.VISIBLE
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        val action: CommonAlertDialog.DialogAction? = commonAlertDialog!!.dialogAction
        action?.let {
            if (isSuccess && action == CommonAlertDialog.DialogAction.REPORT_MESSAGES) {
                if (userProfileDetails.isAdminBlocked) {
                    showToast(getString(R.string.user_block_message_label))
                    return
                }
                progressDialog = DoProgressDialog(this)
                progressDialog.showProgress()
                FlyCore.reportUserOrMessages(userProfileDetails.jid, ChatType.TYPE_CHAT) { isSuccess, _, data ->
                    if (isSuccess) {
                        showToast(getString(R.string.label_report_sent))
                    } else {
                        showToast(data.getMessage())
                    }
                    progressDialog.dismiss()
                }
            } else if (isSuccess && action == CommonAlertDialog.DialogAction.UNARCHIVE) {
                unArchiveUser()
            }
        }
    }

    private fun unArchiveUser(){
        FlyCore.updateArchiveUnArchiveChat(userProfileDetails.jid, false, FlyCallback { isSuccess, _, _ ->
            if (isSuccess) {
                //No implement
                checkingIsArchivedChatUser()
            }
        })
    }

    override fun listOptionSelected(position: Int) {
        //"Not yet implemented"
    }

    override fun updateFeatureActions(features: Features) {
        userFeatureValidation(features)
    }

    private fun userFeatureValidation(availableFeatures: Features) {
        if(availableFeatures.isReportEnabled) {
            showViews(binding.reportUser)
        } else {
            makeViewsGone(binding.reportUser)
        }

        if(availableFeatures.isViewAllMediaEnabled) {
            showViews(binding.textMedia)
        } else {
            makeViewsGone(binding.textMedia)
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: PrivateChatAuthenticationModel?) {
        if(messageEvent!!.isAutheticationShow) {
            privateChatlaunchPinActivity()
        }
    }

    private fun privateChatlaunchPinActivity() {
        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.BIOMETRIC)) {
            val intent = Intent(activity, BiometricActivity::class.java)
            intent.putExtra(com.contusfly.utils.Constants.GO_TO, com.contusfly.utils.Constants.PRIVATE_CHAT_LIST)
            privateChatActivityResultLauncher.launch(intent)
        } else  {
            val intent = Intent(activity, PinActivity::class.java)
            intent.putExtra(com.contusfly.utils.Constants.GO_TO, com.contusfly.utils.Constants.PRIVATE_CHAT_LIST)
            privateChatActivityResultLauncher.launch(intent)
        }

    }

    private var privateChatActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result->
            if (result.resultCode != AppCompatActivity.RESULT_OK) {
                launchAuthPinActivity()
            }
        }

    override fun onMuteStatusUpdated(isSuccess: Boolean,message: String,jidList: List<String>) {
        super.onMuteStatusUpdated(isSuccess,message,jidList)
        LogMessage.d("DashboardActivity", "#mute #recentChat update")
        LogMessage.d(MUTE_STATUS,"onMuteStatusUpdated received from server isSuccess: $isSuccess message : $message")
        muteChatStatusUpdate(jidList)
    }

    private fun muteChatStatusUpdate(jidList: List<String>) {
        try {
            for(jid in jidList) {
                if(userProfileDetails.jid == jid) {
                    var profile =  ProfileDetailsUtils.getProfileDetails(jid)!!
                    if(profile != null) {
                        userProfileDetails = profile
                        LogMessage.d(MUTE_STATUS,"muteChatStatusUpdate--> isProfileMuteStatus: ${userProfileDetails.isMuted} switchButtonStatus: ${binding.muteSwitch.isChecked}")
                        if(userProfileDetails.isMuted != binding.muteSwitch.isChecked)
                        setMuteNotificationStatus(userProfileDetails.isMuted,true)
                    }
                    break
                }
            }

        } catch(e: Exception) {
            LogMessage.e(TAG,"#mute #update exception $e")
        }
    }
    override fun updateArchiveUnArchiveChats(toUser: String?, archiveStatus: Boolean) {
        muteButtonEnabeDisable()
    }

    override fun updateArchivedSettings(archivedSettingsStatus: Boolean) {
        super.updateArchivedSettings(archivedSettingsStatus)
        muteButtonEnabeDisable()
    }

    private fun muteButtonEnabeDisable(){
        try {
            if (!FlyCore.isUserUnArchived(userProfileDetails.jid)) {
                binding.muteSwitch.isEnabled = false
                binding.muteSwitch.alpha = 0.5F
            } else {
                binding.muteSwitch.isEnabled = true
                binding.muteSwitch.alpha = 1F
            }
        } catch(e: Exception){
            LogMessage.e(TAG,"updateArchiveUnArchiveChats exception $e")
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