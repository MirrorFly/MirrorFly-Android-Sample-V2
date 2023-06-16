package com.contusfly.activities

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.AdapterView
import com.mirrorflysdk.flycommons.FlyCallback
import com.mirrorflysdk.flycommons.exception.FlyException
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.adapters.ProfileStartStatusAdapter
import com.contusfly.databinding.ActivityProfileStartStatusBinding
import com.contusfly.utils.*
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.DoProgressDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyCore.deleteProfileStatus
import com.mirrorflysdk.api.FlyCore.getMyProfileStatus
import com.mirrorflysdk.api.FlyCore.getProfileStatusList
import com.mirrorflysdk.api.FlyCore.setMyProfileStatus
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ProfileStatus
import com.mirrorflysdk.utils.RequestCode
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import java.util.*

class ProfileStartStatusActivity : BaseActivity(), View.OnClickListener, CommonAlertDialog.CommonDialogClosedListener, StatusDeleteDialog.UpdateAdapterListener {

    private lateinit var profileStartStatusBinding: ActivityProfileStartStatusBinding

    /**
     * The status list to display the status list in the recycler view in the activity.
     */
    private var statusList: MutableList<ProfileStatus> = mutableListOf()

    /**
     * The list adapter used to display the status of the user
     */
    private var listAdapter: ProfileStartStatusAdapter? = null

    /**
     * The store the status of the user to display and can able to change and store here
     */
    private var profileStatus: String? = null

    /**
     * The status user selected to delete
     */
    private var statusToDelete: ProfileStatus? = null

    /**
     * The progress dialog which used to display in the main User interface thread when doing
     * background tasks
     */
    private var progress: DoProgressDialog? = null

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private var commonAlertDialog: CommonAlertDialog? = null
    private var handler: Handler? = null
    private val progressTimeoutRunnable: Runnable? = null

    private var isFromSettingsProfile = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileStartStatusBinding = ActivityProfileStartStatusBinding.inflate(layoutInflater)
        setContentView(profileStartStatusBinding.root)

        commonAlertDialog = CommonAlertDialog(this)
        commonAlertDialog!!.setOnDialogCloseListener(this)
        initViews()
        /**
         * The alert dialog to confirm the user action for deleting the user status.
         */
        val statusDeleteDialog = StatusDeleteDialog(this)
        statusDeleteDialog.setUpdateAdapterListener(this)
        handler = Handler(Looper.getMainLooper())
    }

    override fun myProfileUpdated(isSuccess: Boolean) {
        super.myProfileUpdated(isSuccess)
        if (progressTimeoutRunnable != null) {
            handler!!.removeCallbacks(progressTimeoutRunnable)
        }
        try {
            if(isFromSettingsProfile) profileStatus?.let { setMyProfileStatus(it, FlyCallback { _: Boolean, _: Throwable?, _: HashMap<String?, Any?>? -> }) }
            if (progress != null)
                progress!!.dismiss()
            EmojiUtils.setEmojiText(profileStartStatusBinding.textEdit, profileStatus)
            listAdapter!!.notifyDataSetChanged()
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    override fun userProfileFetched(jid: String, profileDetails: ProfileDetails) {
        super.userProfileFetched(jid, profileDetails)
        if (profileStatus.isNullOrEmpty()) {
            setMyProfileStatus(getString(R.string.default_status), FlyCallback { _: Boolean, _: Throwable?, _: HashMap<String?, Any?>? -> })
            profileStatus = getMyProfileStatus()?.status
        }
        EmojiUtils.setEmojiText(profileStartStatusBinding.textEdit, profileStatus)
        /*
         * Below code is used to refresh the list view in status list view
         * after instant update
         * */
        /*
         * Below code is used to refresh the list view in status list view
         * after instant update
         * */
        getStatusListFromSDK()
        listAdapter!!.setStatus(statusList, profileStatus)
        listAdapter!!.notifyDataSetChanged()
    }

    /**
     * Initialize the views. Creating objects Assigning the values Default display in the activity
     */
    private fun initViews() {
        try {
            isFromSettingsProfile = intent.getBooleanExtra(Constants.FROM_SETTINGS_PROFILE, false)
            setSupportActionBar(profileStartStatusBinding.toolBar.toolbar)
            UserInterfaceUtils.setUpToolBar(this, profileStartStatusBinding.toolBar.toolbar, supportActionBar, getString(R.string.status_label))
            val listStatus = profileStartStatusBinding.listStatus
            if (isFromSettingsProfile) profileStatus = getMyProfileStatus()!!.status
            else profileStatus = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_STATUS))
            if (profileStatus!!.isEmpty()) {
                setMyProfileStatus(getString(R.string.default_status), FlyCallback { _: Boolean, _: Throwable?, _: HashMap<String?, Any?>? -> })
                profileStatus = getMyProfileStatus()!!.status
            }
            /**
             * Display the list of status in the list
             */
            getStatusListFromSDK()
            if (statusList.isEmpty()) {
                val staticStatusList: Array<String> = this.resources.getStringArray(R.array.default_status_values)
                var profileStatus: ProfileStatus
                for ((index, staticStatus) in staticStatusList.withIndex()) {
                    profileStatus = ProfileStatus(index.toLong(), staticStatus, false)
                    if(!statusList.contains(profileStatus) && statusList.none { it.status == profileStatus.status })
                        statusList.add(profileStatus)
                    FlyCore.insertDefaultStatus(staticStatus)
                }
            }
            listAdapter = ProfileStartStatusAdapter(this)
            listAdapter!!.setStatus(statusList, profileStatus)
            listStatus.adapter = listAdapter
            listStatus.onItemClickListener = AdapterView.OnItemClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
                updateStatus(statusList[position].status)
            }
            listStatus.onItemLongClickListener = AdapterView.OnItemLongClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
                statusToDelete = statusList[position]
                if (getMyProfileStatus() != statusToDelete) commonAlertDialog!!.showListDialog(Constants.EMPTY_STRING, arrayOf(resources.getString(R.string.delete_status)))
                true
            }
            EmojiUtils.setEmojiText(profileStartStatusBinding.textEdit, profileStatus)
            profileStartStatusBinding.textEdit.setOnClickListener(this)
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Update the status of the user in the view and they can change their status in the profile
     * object and update called in the service
     */
    private fun updateStatus(status: String?) {
        try {
            if (AppUtils.isNetConnected(this)) {
                profileStatus = status
                progress = DoProgressDialog(this)
                progress!!.showProgress()
                /* While updating the status without Profile Name */
                if (SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME).isEmpty()) {
                    statusSuccessResult(status)
                    progress!!.dismiss()
                } else {
                    status?.let {
                        setMyProfileStatus(it, FlyCallback { isSuccess: Boolean, throws: Throwable?, _: HashMap<String?, Any?>? ->
                            if (isSuccess) {
                                statusSuccessResult(status)
                            } else CustomToast.show(this, throws!!.message)
                            progress!!.dismiss()
                        })
                    }
                }
            } else CustomToast.show(this, getString(R.string.msg_no_internet))
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun statusSuccessResult(status: String?) {
        SharedPreferenceManager.setString(Constants.USER_STATUS, status)
        EmojiUtils.setEmojiText(profileStartStatusBinding.textEdit, status)
        FlyCore.insertDefaultStatus(status!!)
        getStatusListFromSDK()
        listAdapter!!.setStatus(statusList, status)
        listAdapter!!.notifyDataSetChanged()
        CustomToast.show(this, getString(R.string.msg_status_updated))
    }

    override fun onClick(v: View?) {
        if (v == profileStartStatusBinding.textEdit) {
            startActivityForResult(Intent(this, CommonEditorActivity::class.java)
                    .putExtra(Constants.TITLE, getString(R.string.msg_add_new_status))
                    .putExtra(Constants.TYPE, RequestCode.STATUS_UPDATE)
                    .putExtra(Constants.TEXT_COUNT, Constants.MAX_TEXT_COUNT)
                    .putExtra(Constants.MSG_TYPE_TEXT, profileStatus), Constants.ACTIVITY_REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /* setting isActivityStartedForResult to false for xmpp disconnection */
        ChatManager.isActivityStartedForResult = false
        try {
            if (requestCode == Constants.ACTIVITY_REQ_CODE && resultCode == Activity.RESULT_OK && data != null && data.getStringExtra(Constants.TITLE) != profileStatus) {
                profileStatus = data.getStringExtra(Constants.TITLE)!!
                listAdapter!!.setStatus(statusList, profileStatus)
                listAdapter!!.notifyDataSetChanged()
                updateStatus(profileStatus)
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Activity finish if the result is okay.
     */
    override fun finish() {
        val data = Intent()
        setResult(Activity.RESULT_OK, data)
        super.finish()
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        //nthg do
    }

    override fun listOptionSelected(position: Int) {
        if (position == 0 && getMyProfileStatus() != statusToDelete) {
            showDeleteStatusAlert()
        }
    }

    override fun onNotifyAdapter() {
        try {
            statusToDelete?.let { deleteProfileStatus(it) }
        } catch (e: FlyException) {
            e.printStackTrace()
        }
        getStatusListFromSDK()
        listAdapter!!.setStatus(statusList, profileStatus)
        listAdapter!!.notifyDataSetChanged()
    }

    /**
     * Alert to show the user while choose status delete option
     */
    private fun showDeleteStatusAlert() {
        try {
            val mBuilder = AlertDialog.Builder(this, R.style.AlertDialogStyle)
            mBuilder.setMessage(this.getString(R.string.msg_status_delete))
            mBuilder.setPositiveButton(this.getString(R.string.yes_label)
            ) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                try {
                    statusToDelete?.let { deleteProfileStatus(it) }
                } catch (e: FlyException) {
                    e.printStackTrace()
                }
                getStatusListFromSDK()
                listAdapter!!.setStatus(statusList, profileStatus)
                listAdapter!!.notifyDataSetChanged()
            }
            mBuilder.setNegativeButton(this.getString(R.string.no_label)
            ) { dialog: DialogInterface, _: Int -> dialog.dismiss() }
            val dialog = mBuilder.create()
            dialog.setCancelable(false)
            dialog.show()
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    fun getStatusListFromSDK() {
        statusList.clear()
        val list = getProfileStatusList()
        for (i in list) {
            if(!statusList.contains(i) && statusList.filter { it.status == i.status }.size == 0)
                statusList.add(i)
        }
    }
}