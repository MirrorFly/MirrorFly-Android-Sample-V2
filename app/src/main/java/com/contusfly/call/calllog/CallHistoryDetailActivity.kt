package com.contusfly.call.calllog

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flynetwork.ApiCalls
import com.mirrorflysdk.flycall.webrtc.CallMode
import com.mirrorflysdk.flycall.webrtc.CallState
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.Logger
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.mirrorflysdk.flycall.call.database.model.CallLog
import com.mirrorflysdk.flycall.call.utils.CallConstants
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.*
import com.contusfly.activities.BaseActivity
import com.contusfly.call.CallPermissionUtils
import com.contusfly.call.groupcall.isNull
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.ActivityCallHistoryDetailBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.utils.MediaPermissions
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.utils.ChatTimeFormatter
import dagger.android.AndroidInjection
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CallHistoryDetailActivity : BaseActivity(), CoroutineScope, CommonAlertDialog.CommonDialogClosedListener, CallLogManager.CallLogActionListener {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception ${TAG}:  ${exception.printStackTrace()}")
    }

    @Inject
    lateinit var apiCalls: ApiCalls

    private lateinit var roomId: String

    private var mUsersList = ArrayList<String>()

    private val mUserAdapter by lazy { CallHistoryDetailAdapter(this, mUsersList) }

    private var callLogDetails: CallLog? = null

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private lateinit var commonAlertDialog: CommonAlertDialog

    @Inject
    lateinit var dashboardViewModelFactory: AppViewModelFactory
    val viewModel: CallLogViewModel by viewModels { dashboardViewModelFactory }

    private lateinit var callHistoryDetailBinding: ActivityCallHistoryDetailBinding

    private lateinit var callPermissionUtils: CallPermissionUtils

    var callType = ""

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val callPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        if(!permissions.containsValue(false)) {
            if (callType == CallType.AUDIO_CALL)
                callPermissionUtils.audioCall()
            else
                callPermissionUtils.videoCall()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        callHistoryDetailBinding = ActivityCallHistoryDetailBinding.inflate(layoutInflater)
        setContentView(callHistoryDetailBinding.rootView)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = Constants.EMPTY_STRING
        toolbar.setNavigationIcon(R.drawable.ic_back_black)
        toolbar.navigationIcon!!.applySrcInColorFilter(ContextCompat.getColor(this, R.color.color_text))
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        callLogListener()
        startObservingViewModel()
        handleMainIntent()
        initRecyclerView()
        initClickListeners()

        viewModel.getCallLog(roomId)

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_OK)
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.contus.call.R.menu.menu_call_detail_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            com.contus.call.R.id.action_removelog -> {
                showClearAlertDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Displays an alert dialog to get the confirmation from the user to clear
     * the selected entry from call log history.
     *
     */
    private fun showClearAlertDialog() {
        commonAlertDialog.showAlertDialog(resources.getQuantityString(com.contus.call.R.plurals.action_delete_call_log_message, 1),
                resources.getString(R.string.action_Ok), resources.getString(R.string.action_cancel),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
    }

    private fun startObservingViewModel() {
        viewModel.callLog.observe(this) {
            updateCallLogData(it)
        }
    }

    private fun handleMainIntent() {
        val mainIntent = intent
        roomId = mainIntent.getStringExtra(CallConstants.ROOM_ID) ?: Constants.EMPTY_STRING
    }

    private fun updateCallLogData(callLogDetails: CallLog?) {
        this.callLogDetails = callLogDetails
        callLogDetails?.let { callLog ->
            if (callLog.callTime != null)
                callHistoryDetailBinding.textCallTime.text = ChatTimeFormatter.getCallTime(context!!, callLog.callTime!! / 1000)
            callHistoryDetailBinding.textCallDurationTime.text = ChatTimeFormatter.getCallDurationTime(callLog.startTime!! / 1000, callLog.endTime!! / 1000)

            setUserView(callLog)
            setCallType(callLog)
            setCallStatusIcon(callLog)

            mUsersList.clear()
            mUsersList.addAll(CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList) as java.util.ArrayList<String>)
            mUserAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        callHistoryDetailBinding.viewUserList.apply {
            layoutManager = LinearLayoutManager(context)
            setItemViewCacheSize(10)
            setHasFixedSize(true)
            itemAnimator = null
            adapter = mUserAdapter
        }
    }

    private fun initClickListeners() {

        commonAlertDialog = CommonAlertDialog(this)
        commonAlertDialog.setOnDialogCloseListener(this)

        callHistoryDetailBinding.imgCallType.setVisible(ChatManager.getAvailableFeatures().isGroupCallEnabled)
        callHistoryDetailBinding.imgCallType.setOnClickListener {
            callLogDetails?.let { callLog ->
                if (!callLog.groupId.isNullOrEmpty() || (!callLog.userList.isNullOrEmpty() && callLog.userList!!.filter { it != CallManager.getCurrentUserId() }.size > 1)) {
                    if (CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList, false).isNotEmpty())
                        makeGroupCall(callLog)
                } else {
                    makeOneToOneCall(callLog)
                }
            }
        }
    }

    private fun makeOneToOneCall(callLog: CallLog) {
        val toUser = if (callLog.callState == CallState.INCOMING_CALL
                || callLog.callState == CallState.MISSED_CALL)
            callLog.fromUser
        else
            callLog.toUser
        val profileDetails = ProfileDetailsUtils.getProfileDetails(toUser!!)
        if (profileDetails != null && profileDetails.isAdminBlocked) return
        profileDetails?.let {
            callType = callLog.callType ?: CallType.AUDIO_CALL
            if (callLog.callType == CallType.AUDIO_CALL) {
                CallUtils.setIsCallStarted(CallType.AUDIO_CALL)
                callPermissionUtils = CallPermissionUtils(activity!!, profileDetails.isBlocked, profileDetails.isAdminBlocked,
                    arrayListOf(profileDetails.jid),
                    callLog.groupId ?: "", true
                )
                checkAudioCallPermissions()
            } else if (callLog.callType == CallType.VIDEO_CALL) {
                CallUtils.setIsCallStarted(CallType.VIDEO_CALL)
                callPermissionUtils = CallPermissionUtils(activity!!, profileDetails.isBlocked, profileDetails.isAdminBlocked,
                    arrayListOf(profileDetails.jid),
                    callLog.groupId ?: "",
                    true
                )
                checkVideoCallPermissions()
            }
            //if it is not a blocked contact , clear the value. so that we can avoid unknown calls
            //happening due to onBlockListCallBack() callback from CfBaseActivity.
            if (!profileDetails.isBlocked)
                CallUtils.setIsCallStarted(null)
        }
    }

    private fun checkAudioCallPermissions() {
        if (CallManager.isAudioCallPermissionsGranted(skipBlueToothPermission = false)) {
            callPermissionUtils.audioCall()
        } else {
            MediaPermissions.requestAudioCallPermissions(
                this,
                permissionAlertDialog,
                callPermissionLauncher
            )
        }
    }

    private fun checkVideoCallPermissions() {
        if (CallManager.isVideoCallPermissionsGranted(skipBlueToothPermission = false)) {
            callPermissionUtils.videoCall()
        } else {
            MediaPermissions.requestVideoCallPermissions(
                (activity as Activity),
                permissionAlertDialog,
                callPermissionLauncher
            )
        }
    }

    private fun makeGroupCall(callLog: CallLog) {
        if (isAdminBlocked(callLog)) return

        callType = callLog.callType ?: CallType.AUDIO_CALL
        if (callLog.callType == CallType.AUDIO_CALL) {
            CallUtils.setIsCallStarted(CallType.AUDIO_CALL)
            callPermissionUtils = CallPermissionUtils(
                activity!!,
                false, false,
                CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList, false) as java.util.ArrayList<String>,
                callLog.groupId ?: "",
                true
            )
            if (CallManager.isAudioCallPermissionsGranted(skipBlueToothPermission = false)) {
                callPermissionUtils.audioCall()
            } else {
                MediaPermissions.requestAudioCallPermissions(
                    this,
                    permissionAlertDialog,
                    callPermissionLauncher
                )
            }
        } else if (callLog.callType == CallType.VIDEO_CALL) {
            CallUtils.setIsCallStarted(CallType.VIDEO_CALL)
            callPermissionUtils =   CallPermissionUtils(
                activity!!,
                false, false,
                CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList, false) as java.util.ArrayList<String>,
                callLog.groupId ?: "",
                true
            )
            if (CallManager.isVideoCallPermissionsGranted(skipBlueToothPermission = false)) {
                callPermissionUtils.videoCall()
            }  else {
                MediaPermissions.requestVideoCallPermissions(
                    (activity as Activity),
                    permissionAlertDialog,
                    callPermissionLauncher
                )
            }
        }
        CallUtils.setIsCallStarted(null)
    }

    private fun isAdminBlocked(callLog: CallLog): Boolean {
        return if (callLog.callMode == CallMode.ONE_TO_ONE && (callLog.userList == null || callLog.userList!!.size < 2)) {
            ProfileDetailsUtils.getProfileDetails(
                if (callLog.callState == CallState.OUTGOING_CALL)
                    callLog.toUser!! else callLog.fromUser!!
            )!!.isAdminBlocked
        } else if (callLog.groupId!!.isNotEmpty() && ProfileDetailsUtils.getProfileDetails(callLog.groupId!!) != null) {
            ProfileDetailsUtils.getProfileDetails(callLog.groupId!!)!!.isAdminBlocked
        } else false
    }

    /**
     * This method is getting the caller name and profile picture
     *
     * @param callLog Call Details
     */
    private fun setUserView(callLog: CallLog) {
        if (callLog.callMode == CallMode.ONE_TO_ONE && (callLog.userList == null || callLog.userList!!.size < 2)) {
            val roster = ProfileDetailsUtils.getProfileDetails(if (callLog.callState == CallState.OUTGOING_CALL) callLog.toUser!! else callLog.fromUser!!)
            if (roster != null) {
                profileIcon(roster)
            } else {
                callHistoryDetailBinding.imageChatPicture.addImage(arrayListOf(callLog.fromUser!!))
                callHistoryDetailBinding.textChatName.text = ProfileDetailsUtils.getDisplayName(callLog.fromUser!!)
            }
        } else {
            profileIconForManyUsers(callLog)
        }
    }

    private fun profileIconForManyUsers(callLog: CallLog) {
        if (!callLog.groupId.isNullOrEmpty()) {
            val roster = ProfileDetailsUtils.getProfileDetails(callLog.groupId!!)
            if (roster != null) {
                profileIcon(roster)
            } else {
                callHistoryDetailBinding.imageChatPicture.addImage(arrayListOf(callLog.groupId!!))
                callHistoryDetailBinding.textChatName.text = ProfileDetailsUtils.getDisplayName(callLog.groupId!!)
            }
        } else {
            callHistoryDetailBinding.textChatName.text = CallUtils.getCallLogUserNames(callLog.fromUser, callLog.userList)
            callHistoryDetailBinding.imageChatPicture.addImage(CallUtils.getCallLogUserJidList(callLog.fromUser, callLog.userList) as java.util.ArrayList<String>)
        }
        callHistoryDetailBinding.emailContactIcon.gone()
    }

    private fun profileIcon(profileDetails: ProfileDetails) {

        callHistoryDetailBinding.textChatName.text = profileDetails.getDisplayName()
        callHistoryDetailBinding.imageChatPicture.addImage(arrayListOf(profileDetails.jid))
    }

    // here shows the icon whether the call is missed call or attended call
    private fun setCallType(callLogs: CallLog) {
        setIconAlpha(callLogs)
        // Display the icon whether the call is audio or video
        if (callLogs.callType == CallType.AUDIO_CALL) {
            callHistoryDetailBinding.imgCallType.setImageResource(com.contus.call.R.drawable.ic_call_log_voice_call)
        } else if (callLogs.callType == CallType.VIDEO_CALL) {
            callHistoryDetailBinding.imgCallType.setImageResource(com.contus.call.R.drawable.ic_call_log_video_call)
        }
    }

    private fun setIconAlpha(callLogs: CallLog) {
        val profileDetails = if (callLogs.callMode == CallMode.ONE_TO_ONE && (callLogs.userList == null || callLogs.userList!!.size < 2)) {
            ProfileDetailsUtils.getProfileDetails(if (callLogs.callState == CallState.OUTGOING_CALL) callLogs.toUser!! else callLogs.fromUser!!)
        } else if (!callLogs.groupId.isNullOrBlank()) {
            ProfileDetailsUtils.getProfileDetails(callLogs.groupId!!)
        } else null

        val adminBlockedStatus = profileDetails?.isAdminBlocked ?: false
        val isDeletedUser = profileDetails?.isDeletedContact() ?: false
        callHistoryDetailBinding.imgCallType.alpha = if (adminBlockedStatus || isDeletedUser) 0.3f else 1f
        callHistoryDetailBinding.imgCallType.isEnabled = !isDeletedUser
    }

    private fun setCallStatusIcon(callLogs: CallLog) {
        var drawable = com.contus.call.R.drawable.ic_arrow_down_red
        when (callLogs.callState) {
            CallState.MISSED_CALL -> drawable = com.contus.call.R.drawable.ic_arrow_down_red
            CallState.INCOMING_CALL -> drawable = com.contus.call.R.drawable.ic_arrow_down_green
            CallState.OUTGOING_CALL -> drawable = com.contus.call.R.drawable.ic_arrow_up_green
        }
        callHistoryDetailBinding.imgCallStatus.setImageResource(drawable)
    }

    override fun listOptionSelected(position: Int) {
        Logger.d(position.toString())
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            launch(exceptionHandler) {
                ChatManager.deleteCallLog(false,listOf(roomId),object :
                    ChatActionListener {
                    override fun onResponse(isSuccess: Boolean, message: String) {
                        /*
                        * No Implementation needed
                        */
                    }
                })
                CoroutineScope(Dispatchers.Main).launch {
                    setResult(Activity.RESULT_OK)
                    finish()
                }
            }
        }
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        if (isSuccess)
            viewModel.getCallLog(roomId)
    }

    private fun callLogListener(){
        CallLogManager.setCallLogsListener(object : CallLogManager.CallLogsListener {
            override fun onCallLogsDeleted(isClearAll: Boolean,callidList:ArrayList<String>) {
                setResult(Activity.RESULT_OK)
                finish()
            }
            override fun onCallLogsUpdated() {
                //No Implementation needed
            }
        })
    }

    override fun onActionSuccess() {
        onBackPressed()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        viewModel.getCallLog(roomId)
    }

    override fun updateFeatureActions(features: Features) {
        callHistoryDetailBinding.imgCallType.setVisible(features.isGroupCallEnabled)
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        if (isCallLogProfileUpdated(jid))
            viewModel.getCallLog(roomId)
        if(viewModel.callLog.isNull()) return
        updateCallLogData(viewModel.callLog.value!!)
    }

    private fun isCallLogProfileUpdated(jid: String) : Boolean {
        return if (viewModel.callLog.value == null)
            false
        else {
            val callLog = viewModel.callLog.value!!
            val endUserJid =
                if (callLog.callMode == CallMode.ONE_TO_ONE) if (callLog.callState == CallState.INCOMING_CALL
                    || callLog.callState == CallState.MISSED_CALL
                )
                    callLog.fromUser else callLog.toUser else callLog.toUser
            endUserJid?.trim() == jid || endUserJid?.trim()?.contains(jid) ?: false
        }
    }


}