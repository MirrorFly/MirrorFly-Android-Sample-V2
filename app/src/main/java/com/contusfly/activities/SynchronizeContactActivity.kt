package com.contusfly.activities

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.contusfly.EmailContactSyncService
import com.mirrorflysdk.flycommons.Result
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.call.calllog.CallLogViewModel
import com.contusfly.databinding.ActivitySynchronizeContactBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.interfaces.PermissionDialogListener
import com.contusfly.utils.*
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SynchronizeContactActivity : BaseActivity(), CoroutineScope {

    private lateinit var binding: ActivitySynchronizeContactBinding

    private val permissionAlertDialog : PermissionAlertDialog by lazy { PermissionAlertDialog(this)}

    private var permissionNotDenied = true

    @Inject
    lateinit var callLogsViewModelFactory: AppViewModelFactory

    private val callLogviewModel by lazy {
        ViewModelProvider(this, callLogsViewModelFactory
        ).get(CallLogViewModel::class.java)
    }

    private val contactPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val contactPermissionGranted = permissions[Manifest.permission.READ_CONTACTS] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_CONTACTS)

        if(contactPermissionGranted) {
            startContactSyncTask()
        } else {
            contactPermissionNotProvided()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivitySynchronizeContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        try{
            if(ChatManager.getUserProfileName().isNotEmpty())
                binding.welcomeMessageTextView.text = String.format(getString(R.string.title_contact_sync_welcome_message), ChatManager.getUserProfileName())
        }catch(e:Exception){
            LogMessage.e(TAG,e.toString())
        }

    }

    override fun onResume() {
        super.onResume()
        deviceContact
    }

    /**
     * Method used to get the device contact
     */
    private val deviceContact: Unit
        get() {
            val email = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.EMAIL))
            if (ChatUtils.isContusUser(email))
                EmailContactSyncService.start()
            /*
             *storage permission has granted
             */
            if (isContactPermissionGranted) {
                binding.textContactSync.visibility = View.VISIBLE
                if (FlyCore.contactSyncState.value == null || FlyCore.contactSyncState.value == Result.InProgress) {
                    binding.textContactSync.text = getString(R.string.title_contact_sync)
                } else
                    binding.textContactSync.text = getString(R.string.msg_no_internet)
                startContactSyncTask()
                observeContactSyncStatus()
            }
        }

    /**
     * Method used to check the run time read contact permission
     *
     * @return Permission status
     */
    private val isContactPermissionGranted: Boolean
        get() =// Verify the SDK version for permission validation
            if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) true else {
                if (permissionNotDenied)
                    MediaPermissions.requestContactsReadPermission(this,
                        permissionAlertDialog,
                        contactPermissionLauncher, object : PermissionDialogListener {
                            override fun onPositiveButtonClicked() {
                                //Not Needed
                            }

                            override fun onNegativeButtonClicked() {
                                contactPermissionNotProvided()
                            }
                        })
                permissionNotDenied = false
                false
            }

    /**
     * Start contact sync task running
     */
    private fun startContactSyncTask() {
        LogMessage.d(TAG, "Contacts Sync startContactSyncTask")
        showProgressDialog()
        if (AppUtils.isNetConnected(this))
            FlyCore.syncContacts(true) { b, _, _ ->
                LogMessage.d(TAG, "Contacts Sync contactSyncSuccess:$b and count: ${ContactUtils.getContactCount(this)}")
                SharedPreferenceManager.setInt(ContactUtils.CONTACTS_COUNT, ContactUtils.getContactCount(this))
                initiateUserData()
            }
    }

    private fun observeContactSyncStatus(){
        FlyCore.contactSyncState.observe(this, {
            when(it){
                is Result.Error -> {
                    binding.textContactSync.text = getString(R.string.msg_no_internet)
                }
                is Result.InProgress -> {
                    binding.textContactSync.text = getString(R.string.title_contact_sync)
                    showProgressDialog()
                }
                else -> {
                    //Not Needed
                }
            }
        })
    }

    /**
     * This method shows the progress dialog
     */
    private fun showProgressDialog() {
        binding.imageContactSyncLoader.visibility = View.VISIBLE
    }

    /**
     * This method hides the progress dialog
     */
    private fun hideProgressDialog() {
        binding.imageContactSyncLoader.visibility = View.GONE
    }

    /**
     * Get the user roster, broadcast and groups
     */
    private fun initiateUserData() {
        try {
            if (AppUtils.isNetConnected(this)) {
                FlyCore.getRegisteredUsers(true) { isSuccess, _, _ ->
                    if (isSuccess)
                        FlyCore.getUsersIBlocked(true) { _, _, _ ->
                            runOnUiThread { redirectToDashBoard() }
                        }
                    else
                        runOnUiThread { redirectToDashBoard() }
                }
                if(!SharedPreferenceManager.getBoolean(Constants.ADMIN_BLOCKED)) {
                    callLogviewModel.uploadUnSyncedCallLogs()
                }
                GroupManager.getAllGroups(true) { _, _, _ -> }
            } else {
                hideProgressDialog()
                CustomToast.show(this, getString(R.string.msg_no_internet))
                redirectToDashBoard()
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun contactPermissionNotProvided() {
        LogMessage.d(TAG, "Contacts Sync contactPermissionNotProvided")
        hideProgressDialog()
        SharedPreferenceManager.setBoolean(Constants.CONTACT_SYNC_DONE, true)
        FlyCore.getRegisteredUsers(true) { _, _, _ ->
            runOnUiThread { redirectToDashBoard() }
        }
        if(!SharedPreferenceManager.getBoolean(Constants.ADMIN_BLOCKED)) {
            callLogviewModel.uploadUnSyncedCallLogs()
        }
        GroupManager.getAllGroups(true) { _, _, _ -> }
    }

    /**
     * Redirect to user profile while register/login.
     */
    private fun redirectToDashBoard() {
        hideProgressDialog()
        if (!FlyCore.getIsProfileBlockedByAdmin())
            startActivity(Intent(this, DashboardActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        if (isSuccess) {
            SharedPreferenceManager.setBoolean(Constants.CONTACT_SYNC_DONE, true)
            SharedPreferenceManager.setBoolean(Constants.INITIAL_CONTACT_SYNC_DONE, true)
            initiateUserData()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()
}