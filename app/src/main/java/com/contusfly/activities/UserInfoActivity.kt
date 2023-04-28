package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.mirrorflysdk.flycommons.*
import com.contusfly.*
import com.contusfly.R
import com.contusfly.R.string.fly_error_forbidden_exception
import com.contusfly.databinding.ActivityUserInfoBinding
import com.contusfly.network.NetworkConnection
import com.contusfly.utils.AppConstants
import com.contusfly.utils.ChatUtils
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomToast
import com.contusfly.views.DoProgressDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.MediaUtils
import com.mirrorflysdk.utils.Utils
import com.google.android.material.appbar.AppBarLayout
import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout
import java.io.File

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
        binding.muteSwitch.setOnCheckedChangeListener { _, isChecked ->
            FlyCore.updateChatMuteStatus(userProfileDetails.jid, isChecked)
        }
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
        observeNetworkListener()
        mediaValidation()
        userFeatureValidation(ChatManager.getAvailableFeatures())
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
        mAppBarLayout.post {
            val heightPx = collapsingToolbar.height
            setAppBarOffset(heightPx / 3)
        }
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

    private fun setAppBarOffset(offsetPx: Int) {
        val params = mAppBarLayout.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as AppBarLayout.Behavior
        behavior.onNestedPreScroll(mCoordinatorLayout, mAppBarLayout, binding.nestedScrollView, 0, offsetPx, intArrayOf(0, 0), 0)
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

    private fun setMuteNotificationStatus(isMute: Boolean) {
        if (!FlyCore.isUserUnArchived(userProfileDetails.jid)) {
            binding.muteSwitch.isEnabled = false
            binding.muteSwitch.alpha = 0.5F
        }
        binding.muteSwitch.isChecked = isMute
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
            }
        }
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
}