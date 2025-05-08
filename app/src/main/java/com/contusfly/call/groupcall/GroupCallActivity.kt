package com.contusfly.call.groupcall

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.graphics.PixelFormat
import android.os.*
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.contus.call.CallActions
import com.contus.call.CallConstants
import com.contus.call.CallConstants.CALL_FLOW_TAG
import com.contus.call.CallConstants.CALL_UI
import com.contus.call.CallConstants.JOIN_CALL
import com.contusfly.*
import com.contusfly.activities.BaseActivity
import com.contusfly.call.groupcall.helpers.BaseCallViewHelper
import com.contusfly.call.groupcall.helpers.DialogViewHelper
import com.contusfly.call.groupcall.listeners.ActivityOnClickListener
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.ActivityGroupCallBinding
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.CommonUtils
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaPermissions
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.*
import com.mirrorflysdk.flycall.webrtc.WebRtcCallService.Companion.setupVideoCapture
import com.mirrorflysdk.flycall.webrtc.api.CallActionListener
import com.mirrorflysdk.flycall.webrtc.api.CallEventsListener
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycall.webrtc.api.ConnectionQuality
import com.mirrorflysdk.flycall.webrtc.api.ConnectionQualityListener
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.exception.FlyException
import com.mirrorflysdk.views.CustomToast
import kotlinx.android.synthetic.main.custom_toast.*
import java.util.concurrent.atomic.AtomicBoolean


/**
 * This call activity is handle the incoming and outgoing group calls for both audio and video
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class GroupCallActivity : BaseActivity(), View.OnClickListener, ActivityOnClickListener {

    private lateinit var participantListFragment: ParticipantsListFragment

    private lateinit var activityBinding: ActivityGroupCallBinding

    /**
     * Instance for duration handler
     */
    private var durationHandler: Handler = Handler(Looper.getMainLooper())

    private val callViewHelper by lazy {
        BaseCallViewHelper(
            this,
            activityBinding,
            callUsersListAdapter,
            callUserGridAdapter,
            durationHandler,
            this
        )
    }

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val dialogViewHelper by lazy { DialogViewHelper(this, durationHandler, this) }

    /**
     * This flag indicates whether [.onDestroy] method is called or not
     */
    private val isDisconnectCalled = AtomicBoolean(false)

    /**
     * This flag indicates whether [.answer]  method is called or not
     */
    private val isAnswerCalled = AtomicBoolean(false)

    private lateinit var callUsersListAdapter: GroupCallListAdapter

    private lateinit var callUserGridAdapter: GroupCallGridAdapter

    /**
     * jid of the group call initiated
     */
    private var groupId: String? = null

    private var lastClickTime: Long = 0

    /**
     * call events listener
     */
    private val customCallEventsListener = CustomCallEventsListener()

    private val groupCallViewModel: GroupCallViewModel by viewModels()

    private val requestSwitchCameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val cameraPermissionGranted =
                permissions[Manifest.permission.CAMERA] ?: MediaPermissions.isPermissionAllowed(
                    activity,
                    Manifest.permission.CAMERA
                )
            if (cameraPermissionGranted)
                callViewHelper.toggleVideoMute()
        }

    private val requestCallSwitchCameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val cameraPermissionGranted =
                permissions[Manifest.permission.CAMERA] ?: MediaPermissions.isPermissionAllowed(
                    activity,
                    Manifest.permission.CAMERA)
            if (cameraPermissionGranted) {
                acceptVideoCallSwitch()
            } else {
                if(CallManager.isCallConversionRequestAvailable()) {
                    onCallSwitchDialog(false)
                }
            }
        }

    private val requestAudioCallPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val recordPermissionGranted = permissions[Manifest.permission.RECORD_AUDIO]
                ?: ChatUtils.checkMediaPermission(this, Manifest.permission.RECORD_AUDIO)

            if (!recordPermissionGranted)
                CallManager.sendCallPermissionDenied()
        }

    private val requestVideoCallPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val cameraPermissionGranted =
                permissions[Manifest.permission.CAMERA] ?: MediaPermissions.isPermissionAllowed(
                    activity,
                    Manifest.permission.CAMERA
                )
            val recordPermissionGranted = permissions[Manifest.permission.RECORD_AUDIO]
                ?: ChatUtils.checkMediaPermission(this, Manifest.permission.RECORD_AUDIO)

            if (!cameraPermissionGranted || !recordPermissionGranted)
                CallManager.sendCallPermissionDenied()
            else
                CallManager.startVideoCapture()
        }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { _ ->
        if (!ChatUtils.checkMediaPermission(this, Manifest.permission.POST_NOTIFICATIONS)) {
            CallManager.sendCallPermissionDenied()
        }
    }

    private val gridResizeRunnable by lazy {
        Runnable {
            LogMessage.d(TAG, "$CALL_UI resizeRunnable")
            resizeGridView()
        }
    }

    private val resetViewUpdatesRunnable = Runnable {
        CallUtils.setIsViewUpdatesCompleted(true) //reset the flag
    }
    override fun onStart() {
        // Bind to the service. If the service is in foreground mode, this signals to the service
        // that since this activity is in the foreground, the service can exit foreground mode.
        LogMessage.d(TAG, "$CALL_UI onStart() GroupCallUtils.getIsCallAgain()${GroupCallUtils.getIsCallAgain()}")

        super.onStart()
        CallManager.bindCallService()
        if (GroupCallUtils.getIsCallAgain())
            return
        setUpCallUI()
        if (CallManager.isInComingCall()) {
            LogMessage.d(TAG, "$CALL_UI setUpCallUI() for InComing_${CallManager.getCallType()}")
            notificationPermissionChecking()
            if (CallManager.getCallType() == CallType.AUDIO_CALL) {
                /* check permissions */
                if (!MediaPermissions.isPermissionAllowed(this, Manifest.permission.RECORD_AUDIO))
                    MediaPermissions.requestAudioCallPermissions(this, requestAudioCallPermission)
            } else if (CallManager.getCallType() == CallType.VIDEO_CALL
                && !(MediaPermissions.isPermissionAllowed(this, Manifest.permission.RECORD_AUDIO)
                        && MediaPermissions.isPermissionAllowed(this, Manifest.permission.CAMERA))
            ) {
                MediaPermissions.requestVideoCallPermissions(this, requestVideoCallPermission)
            } else{
                CallLogger.callTestingLog("$CALL_FLOW_TAG onStart() startVideoCapture ")
                CallManager.startVideoCapture()
            }
        } else if(!CallManager.isOnGoingCall() && !CallManager.isOutgoingCall()) {
            cancelCallAgain()
        }
    }

    private fun notificationPermissionChecking() {
        MediaPermissions.requestNotificationPermission(
            this,
            permissionAlertDialog,
            notificationPermissionLauncher, true
        )
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        LogMessage.i(TAG, "$CALL_UI onNewIntent()")
        if(!CallManager.isCallAttended() && CallManager.getCallDirection().equals(CallDirection.INCOMING_CALL)
            && (callUserGridAdapter.gridCallUserList.isEmpty() || callUsersListAdapter.callUserList.isEmpty()) && callViewHelper.isCallRetryVisible()){
            LogMessage.i(TAG, "$CALL_UI incoming call while on call again screen!!")
            CallLogger.callTestingLog("UIKIT--->onNewIntent recreate()")
            recreate()
        } else {
            setUpCallDataAndUI(intent)
        }
    }

    override fun onMemberRemovedFromGroup(
        groupJid: String,
        removedMemberJid: String,
        removedByMemberJid: String
    ) {
        super.onMemberRemovedFromGroup(groupJid, removedMemberJid, removedByMemberJid)
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.onMemberRemovedOrAddedInGroup(true,removedMemberJid,groupJid)
        }
    }

    override fun onLeftFromGroup(groupJid: String, leftUserJid: String) {
        super.onLeftFromGroup(groupJid, leftUserJid)
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.onMemberRemovedOrAddedInGroup(true,leftUserJid,groupJid)
        }
    }

    override fun onNewMemberAddedToGroup(
        groupJid: String,
        newMemberJid: String,
        addedByMemberJid: String
    ) {
        super.onNewMemberAddedToGroup(groupJid, newMemberJid, addedByMemberJid)
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.onMemberRemovedOrAddedInGroup(false, newMemberJid, groupJid)
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogMessage.d(TAG, "$CALL_UI onCreate")
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        activityBinding = ActivityGroupCallBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        if(CallUtils.getIsFromCallAgainPipMode() && !CallManager.isOnGoingCall()){
            CallUtils.setIsFromCallAgainPipMode(isFromPipModeCallAgain = false)
            finish()
        }
        CallUtils.setIsFromCallAgainPipMode(isFromPipModeCallAgain = false)
        CallManager.configureCallActivity(this)
        window.setFormat(PixelFormat.TRANSLUCENT)
        //register for call events
        CallManager.setCallEventsListener(customCallEventsListener)
        CallManager.setupCallActionListener(customCallEventsListener)
        CallManager.setConnectionQualityListener(customCallEventsListener)

        initClickListeners()
        setUpCallDataAndUI(intent)
        groupCallViewModel.checkInternetConnection()

        checkAndRequestFullScreenPermission()
    }

    private fun setUpCallDataAndUI(intent: Intent) {
        if (intent.extras != null) {
            groupId =
                intent.getStringExtra(com.mirrorflysdk.flycall.call.utils.CallConstants.EXTRA_GROUP_ID)
            val acceptCall = intent.getBooleanExtra(
                com.mirrorflysdk.flycall.call.utils.CallConstants.ACCEPT_CALL,
                false
            )
            LogMessage.d(TAG, "$CALL_UI setUpCallDataAndUI acceptCall: $acceptCall")
            if (acceptCall)
                answer()
        }

        setUpCallUI()
        setObservers()

        if (CallManager.isCallConversionRequestAvailable()) {
            handleIncomingRequest()
        }
    }

    private fun setObservers() {

        groupCallViewModel.internetConnectionNotAvailable.observe(this) {
            if (!AppUtils.isNetConnected(this)) {
                showToast(getString(R.string.fly_error_msg_no_internet))
            }
        }

        groupCallViewModel.remoteAudioMuteStatus.observe(this) { userJid ->
            callViewHelper.updateRemoteAudioMuteStatus(userJid)
        }

        AppLifecycleListener.adminBlockedOtherUser.observe(this) {
            updateAdminBlockedStatus(it.first, it.second, it.third)
        }
    }

    private fun acceptVideoCallSwitch() {
        val isRequestAvailable = CallManager.isCallConversionRequestAvailable()
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL showCallSwitchAlert Accept: $isRequestAvailable")
        if (isRequestAvailable) {
            dialogViewHelper.dismissCallSwitchDialog()
            activityBinding.layoutCallOptions.imageMuteVideo.isActivated = true
            sendResponseToVideoCallRequest(true)
            setUpCallUI(true,true)
        }
    }

    /**
     * Video Call switch request accepted
     */
    private fun switchToVideoCall() {
        LogMessage.d(TAG, "$CALL_UI switchToVideoCall")
        dialogViewHelper.videoCallSwitchRequestAccepted()
        sendResponseToVideoCallRequest(true)
        // while switching to video call simultaneously for the second time, we need to update the
        // views from here
        setUpCallUI()
    }

    /**
     * Update mute status to the adapter to show or hide video view
     */
    private fun showOrHideSurfaceViews() {
        LogMessage.d(TAG, "$CALL_UI showOrHideSurfaceViews")
        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_VIEW_VIDEO_MUTE_UPDATED, 1)
        bundle.putInt(CallActions.NOTIFY_VIEW_MUTE_UPDATED, 1)
        if (CallUtils.getIsGridViewEnabled())
            callUserGridAdapter.notifyItemRangeChanged(
                0,
                callUserGridAdapter.gridCallUserList.size,
                bundle
            )
        else
            callUsersListAdapter.notifyItemRangeChanged(
                0,
                callUsersListAdapter.callUserList.size,
                bundle
            )
    }

    /**
     * send response to video switch request
     * @param requestAccepted request accepted or not
     */
    private fun sendResponseToVideoCallRequest(requestAccepted: Boolean) {
        LogMessage.d(TAG, "$CALL_UI sendCallResponse $requestAccepted")
        if (requestAccepted) {
            CallManager.acceptVideoCallSwitchRequest()
        } else {
            CallManager.declineVideoCallSwitchRequest()
        }
        showOrHideSurfaceViews()
    }

    private fun handleIncomingRequest() {
        LogMessage.d(TAG, "$CALL_UI handleIncomingRequest()")
        if (GroupCallUtils.isOneToOneCall()) {
            CallAudioManager.getInstance(this).playIncomingRequestTone()
            dialogViewHelper.showCallSwitchDialog()
            dialogViewHelper.dismissCallSwitchConfirmationDialog()
            if (dialogViewHelper.isVideoCallSwitchRequestedFromBothSides()) {
                switchToVideoCall()
            }
        }
    }

    private fun showOutgoingCallConversionRequest(){
        dialogViewHelper.showVideoCallRequestingDialog()
    }

    private fun handleIncomingCallSwitchRequestForPipMode() {
        LogMessage.d(TAG, "$CALL_UI handleIncomingCallSwitchRequestForPipMode")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && CallManager.isCallConnected() && !CallUtils.isAddUsersToTheCall() && CommonUtils.isPipModeAllowed(
                this
            )
        ) {
            LogMessage.d(TAG, "$CALL_UI dismissCallSwitchDialog for pip mode!!")
            dialogViewHelper.dismissCallSwitchDialog()
            dialogViewHelper.dismissCallSwitchConfirmationDialog()
        }
    }

    private fun handleOutgoingCallSwitchRequestForPipMode() {
        LogMessage.d(TAG, "$CALL_UI handleOutgoingCallSwitchRequestForPipMode")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && CallManager.isCallConnected() && !CallUtils.isAddUsersToTheCall() && CommonUtils.isPipModeAllowed(
                this
            )
        ) {
            LogMessage.d(TAG, "$CALL_UI dismissCallSwitchConfirmationDialog for pip mode!!")
            dialogViewHelper.dismissCallSwitchConfirmationDialog()
            dialogViewHelper.hideVideoCallRequestingDialogForPipMode()
        }
    }

    public override fun onUserLeaveHint() {
        LogMessage.d(
            TAG,
            "$CALL_UI onUserLeaveHint() CallManager.isCallAgain:${CallManager.isCallAgain()}"
        )
        handleOutgoingCallSwitchRequestForPipMode()
        handleIncomingCallSwitchRequestForPipMode()
        callViewHelper.gotoPIPMode()
        if (CallManager.isCallAgain()) {
            CallUtils.setIsFromCallAgainPipMode(isFromPipModeCallAgain = true)
            cancelCallAgain()
        } else if (!CallManager.isCallConnected() && CallManager.isOutgoingCall()) {
            finish()
        }
    }

    override fun onBackPressed() {
        LogMessage.d(TAG, "$CALL_UI onBackPressed()")
        if (CallManager.isCallAgain()) {
            cancelCallAgain()
        }
        try {
            val fragment = supportFragmentManager.findFragmentByTag(ParticipantsListFragment::class.java.name)
                    as? ParticipantsListFragment
            // Check if the fragment is active (attached and visible)
            if (fragment != null && fragment.isVisible) {
                CallUtils.setIsAddUsersToTheCall(false)
                supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                return
            }
        } catch(e: Exception) {
            LogMessage.e(TAG,"error $e")
        }

        supportFragmentManager.fragments.forEach { fragment -> // remove fragment before go to pipmode to prevent this issue->doesnt get back or go to pipmode some times dude to add participant fragment was not properly detach.
            supportFragmentManager.beginTransaction().remove(fragment).commitNowAllowingStateLoss()
        }
        super.onBackPressed()
    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration
    ) {
        pipModeChangeListeners(isInPictureInPictureMode)
    }

    private fun pipModeChangeListeners(pipModeStatus: Boolean) {
        CallManager.enablePIPMode(pipModeStatus)
        LogMessage.d(TAG, "$CALL_UI pipModeChangeListeners() pipModeStatus $pipModeStatus")
        if (!pipModeStatus) {
            CallManager.bindCallService()
            callViewHelper.hidePIPLayout()
            resetPIPModeByCallType()
        }
    }

    private fun resetPIPModeByCallType() {
        CallManager.bindCallService()
        activityBinding.imageMinimizeCall.show()
        setUpCallUI()
        refreshConnectedViewHelper()
        callViewHelper.ownAudioMuteStatusUpdated()
        if (CallManager.isCallConversionRequestAvailable()) {
            handleIncomingRequest()
        }
        if(CallManager.isOutgoingCallConversionRequestAvailable()) {
            showOutgoingCallConversionRequest()
        }
    }

    private fun refreshConnectedViewHelper() {
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            setUpCallUI(false)
        },4000)
    }

    override fun finish() {
        LogMessage.d(TAG, "$CALL_UI finish()")
        CallLogger.callTestingLog("#groupCallActivity Finish - isDisconnectCalled-${isDisconnectCalled.get()}")
        if (SystemClock.elapsedRealtime() - lastClickTime > 2000) {
            if (!CallManager.isCallConnected()) {
                CallLogger.callTestingLog("#groupCallActivity Finish - call not connected")
                super.finish()
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && !isDisconnectCalled.get()) { //receive a call and attend it and instantly cut the call. at the time call ui closed and moved into pipmode issue - fix
                    CallLogger.callTestingLog("#groupCallActivity - go to pipmode")
                    handleOutgoingCallSwitchRequestForPipMode()
                    handleIncomingCallSwitchRequestForPipMode()
                    callViewHelper.gotoPIPMode()
                } else {
                    CallLogger.callTestingLog("#groupCallActivity Finish - call connected")
                    super.finish()
                }
            }
            lastClickTime = SystemClock.elapsedRealtime()
        }
    }

    /**
     * initialize views here
     */
    private fun initClickListeners() {
        LogMessage.d(TAG, "$CALL_UI initViews() setOnClickListener")
        activityBinding.callOptionsUpArrow.setOnClickListener(this)
        activityBinding.rootLayout.setOnClickListener(this)
        activityBinding.viewOverlay.setOnClickListener(this)
        activityBinding.imageMinimizeCall.setOnClickListener(this)

        callUsersListAdapter = GroupCallListAdapter(this)
        callUserGridAdapter = GroupCallGridAdapter(this)

        callUsersListAdapter.onPinnedListView { userJid ->
            if (SystemClock.elapsedRealtime() - lastClickTime > 1000){
                callViewHelper.pinnedUserChanged(userJid)
                lastClickTime = SystemClock.elapsedRealtime()
            }

        }

        callUsersListAdapter.onTapOnRecyclerView {
            callViewHelper.animateCallOptionsView()
        }

        callUserGridAdapter.onUserPinnedGridView { userJid ->
            if (SystemClock.elapsedRealtime() - lastClickTime > 1000){
                if ( userJid == CallUtils.getPinnedUserJid())
                    callViewHelper.pinnedUserRemoved()
                else
                    callViewHelper.pinnedUserChanged(userJid)
                lastClickTime = SystemClock.elapsedRealtime()
            }
        }

        callUserGridAdapter.onTapOnRecyclerView {
            callViewHelper.animateCallOptionsView()
        }
    }

    /**
     * set vide mute status text based on remote user video mute actions
     * @param userJid id of video muted user
     */
    private fun setVideoMuteStatus(userJid: String?) {
        if (!CallManager.isCallConnected() || userJid == null) {
            LogMessage.i(TAG, "$CALL_UI Skipping video mute UI update, since call is not connected")
            return
        }

        if (CallManager.isOneToOneCall() && CallManager.isVideoCall() || GroupCallUtils.isCallLinkBehaviourMeet()) {
            LogMessage.d(TAG, "$CALL_UI setVideoMuteStatus() isOneToOneCall isVideoCall")
            setUpCallUI()
        }
        LogMessage.d(TAG, "$CALL_UI setVideoMuteStatus() userJid:${userJid}")
        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_VIEW_VIDEO_MUTE_UPDATED, 1)
        bundle.putInt(CallActions.NOTIFY_CONNECT_TO_SINK, 1)

        if (CallUtils.getIsGridViewEnabled()) {
            val gridIndex = callUserGridAdapter.gridCallUserList.indexOf(userJid)
            if (gridIndex.isValidIndex()) {
                callUserGridAdapter.notifyItemChanged(gridIndex, bundle)
            }
        } else {
            if (CallUtils.getPinnedUserJid() == userJid)
                callViewHelper.updatePinnedUserVideoMuteStatus()
            else {
                val index = callUsersListAdapter.callUserList.indexOf(userJid)
                if (index.isValidIndex()) {
                    LogMessage.d(TAG, "$CALL_UI setVideoMuteStatus() isValidIndex ")
                    callUsersListAdapter.notifyItemChanged(index, bundle)
                }
            }
        }
    }
    @SuppressWarnings("kotlin:S3923")
    override fun hangVideoCall() {
        LogMessage.d(TAG, "$CALL_UI hangVideoCall()")
        if (!activityBinding.layoutCallOptions.imageMuteVideo.isActivated) {
            dialogViewHelper.showCallSwitchConfirmationDialog()
            if (dialogViewHelper.isVideoCallSwitchRequestedFromBothSides()) {
                CallManager.muteVideo(!activityBinding.layoutCallOptions.imageMuteVideo.isActivated)
                dialogViewHelper.dismissCallSwitchConfirmationDialog()
            }
        } else {
            if (dialogViewHelper.isVideoCallSwitchRequestedFromBothSides()) {
                dialogViewHelper.dismissCallSwitchConfirmationDialog()
            } else {
                activityBinding.layoutCallOptions.imageMuteVideo.isActivated =
                    !activityBinding.layoutCallOptions.imageMuteVideo.isActivated
                CallManager.muteVideo(!activityBinding.layoutCallOptions.imageMuteVideo.isActivated)
            }
        }
        if (activityBinding.layoutCallOptions.imageMuteVideo.isActivated)
            activityBinding.layoutCallOptions.imageSwitchCamera.show()
        else
            activityBinding.layoutCallOptions.imageSwitchCamera.gone()
    }

    /**
     * call answer method
     */
    @SuppressLint("MissingPermission")
    override fun answer() {
        CallLogger.callTestingLog("UIKIT---->answer() called isAnswerCalled: $isAnswerCalled")
        LogMessage.d(TAG, "$CALL_UI answer()")
        if (isAnswerCalled.compareAndSet(false, true)) {
            CallManager.answerCall(object : CallActionListener {
                override fun onResponse(isSuccess: Boolean, flyException: FlyException?) {
                    val errorMessage = flyException?.message ?: ""
                    LogMessage.d(TAG, "$CALL_UI answer() success: $isSuccess message:${errorMessage}")
                    if(isSuccess)
                        setUpCallUI()
                    else
                        Toast.makeText(this@GroupCallActivity,errorMessage,Toast.LENGTH_SHORT)
                }
            })
        }
    }

    /**
     * update call view
     */
    private fun setUpCallUI(
        isCallOptionAnimation: Boolean = false,
        isLocalTrackAddedFromSwitchRequest: Boolean = false
    ) {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL setUpCallUI() isInPIPMode(): ${isInPIPMode()}")
        if (isInPIPMode()) {
            callViewHelper.showPIPLayout()
        } else {
            callViewHelper.setUpCallUI(isCallOptionAnimation,isLocalTrackAddedFromSwitchRequest)
        }
    }

    private fun disconnectCall(
        isNotFromRetry: Boolean,
        callStatus: String = CallStatus.DISCONNECTED
    ) {
        CallLogger.callTestingLog("UIKIT---> disconnectCall called isNotFromRetry : $isNotFromRetry callStatus: $callStatus isDisconnectCalled: $isDisconnectCalled")
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL #disconnect ui start disconnectCall IN UI isDisconnectCalled: $isDisconnectCalled isNotFromRetry:$isNotFromRetry"
        )
        if (isDisconnectCalled.compareAndSet(false, true)) {
            // The below code execution is guaranteed to be called only once
            setResult(if (CallManager.isAudioCall()) CallConstants.AUDIO_CALL_REQUEST_CODE else CallConstants.VIDEO_CALL_REQUEST_CODE)
            dialogViewHelper.disconnectCall()
            callViewHelper.disconnectCall()
            isAnswerCalled.set(false)
            CallUtils.resetValues()
            if (isNotFromRetry)
                callViewHelper.updateDisconnectedStatus(callStatus)
            else
                finish()
        }
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL #disconnect ui done!!"
        )
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            if (CallManager.isInComingCall())
                CallAudioManager.getInstance(context).stopRingTone()
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onClick(v: View) {
        if (isDisconnectCalled.get()) {
            LogMessage.i(TAG, "$CALL_UI Skipping onclick events")
            return
        }

        when (v.id) {
            R.id.root_layout, R.id.call_options_up_arrow, R.id.view_overlay ->
                if (activityBinding.layoutCallOptions.layoutSlowNetwork.poorConnectionRoot.visibility == View.VISIBLE) {
                    LogMessage.d(
                        TAG,
                        "$CALL_UI skip callViewHelper onCallOptionsHidden() poorConnectionRoot VISIBLE"
                    )
                    return
                } else if (CallManager.isCallConnected())
                    callViewHelper.animateCallOptionsView(true)

            R.id.image_minimize_call -> onBackPressed()
        }
    }

    override fun onStop() {
        LogMessage.d(TAG, "$CALL_UI onStop()")
        // Unbind from the service. This signals to the service that this activity is no longer
        // in the foreground, and the service can respond by promoting itself to a foreground
        // service.
        CallManager.unbindCallService()
        CallUtils.setIsListViewAnimated(false)
        CallUtils.clearSpeakingLevels()
        super.onStop()
    }

    override fun onResume() {
        LogMessage.d(TAG, "$CALL_UI onResume()")
        super.onResume()
        setupVideoCapture(this, false)
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        LogMessage.d(TAG, "userUpdatedHisProfile: jid:$jid ")
        LogMessage.d(TAG, "getCallUsersList: userList:${CallManager.getCallUsersList().size} ")
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.refreshUser(jid)
        }
        updateUserDetailsUpdatedInCall(jid)
    }

    private fun updateUserDetailsUpdatedInCall(jid: String) {
        val isUserPresent = CallManager.getCallUsersList().contains(jid)
        LogMessage.d(TAG, "userUpdatedHisProfile getCallUsersList: isUserPresent:${isUserPresent} ")
        when {
            CallManager.isOneToOneCall() && jid == CallManager.getEndCallerJid() -> callViewHelper.setUpProfileDetails(CallManager.getCallUsersList())
            isUserPresent -> callViewHelper.setUpProfileDetails(CallManager.getCallUsersList(), jid)
            CallManager.getGroupID().isNotBlank() && CallManager.getGroupID().equals(jid, false) -> {
                LogMessage.d(TAG, "userUpdatedHisProfile Group ProfileDetails updated!! ")
                callViewHelper.setUpProfileDetails(CallManager.getCallUsersList())
            }
        }
    }

    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.removeUser(jid)
        }
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        if (isSuccess && ::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.refreshUsersList()
        }
    }

    override fun addUsersInCall() {
        LogMessage.d(TAG, "$CALL_UI addUsersInCall()")
        checkInternetAndExecute(true) {
            CallUtils.setIsAddUsersToTheCall(true)
            participantListFragment = ParticipantsListFragment.newInstance(
                groupId,
                groupId.isNullOrEmpty(),
                CallManager.getCallUsersList(),
                customCallEventsListener
            )
            val fragmentTransaction: FragmentTransaction =
                supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(
                R.id.view_container,
                participantListFragment,
                participantListFragment.javaClass.name
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    /**
     * Check the internet connectivity and send the call message
     */
    override fun makeCallAgain() {
        if (AppUtils.isNetConnected(this)) {
            LogMessage.d(TAG, "$CALL_UI makeCallAgain()")
            callViewHelper.hideCallAgainView()
            CallManager.makeCallAgain()
            callViewHelper.makeCallAgainGroupMemberNameUpdate()
        } else {
            CustomToast.show(applicationContext, getString(R.string.fly_error_msg_no_internet))
            cancelCallAgain()
        }
    }

    override fun cancelCallAgain() {
        LogMessage.d(TAG, "$CALL_UI cancelCallAgain()")
        CallManager.cancelCallAgain()
        disconnectCall(false)
    }

    public override fun onDestroy() {
        LogMessage.d(TAG, "$CALL_UI onDestroy  called()")
        CallManager.removeCallEventsListener(customCallEventsListener)
        CallManager.removeCallActionListener(customCallEventsListener)
        CallManager.removeConnectionQualityListener(customCallEventsListener)
        CallUtils.setVideoViewInitialization(false)
        super.onDestroy()
    }

    private fun updateStatusAndRemove(userJid: String?) {
        LogMessage.d(TAG, " $CALL_UI updateStatusAndRemove userJid: $userJid")
        if (userJid != null) {
            val bundle = Bundle()
            bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)
            if (CallUtils.getIsGridViewEnabled()) {
                val gridIndex = callUserGridAdapter.gridCallUserList.indexOf(userJid)
                if (gridIndex.isValidIndex()) {
                    callUserGridAdapter.notifyItemChanged(gridIndex, bundle)
                }
            } else {
                val index = callUsersListAdapter.callUserList.indexOf(userJid)
                if (index.isValidIndex()) {
                    callUsersListAdapter.notifyItemChanged(index, bundle)
                }
            }
            durationHandler.postDelayed({
                updateUserLeft(userJid, false)
            }, 500)
        }
    }

    private fun handleCallVideoMessages(callAction: String, userJid: String) {
        when (callAction) {
            CallAction.ACTION_REMOTE_VIDEO_STATUS -> {
                if (isInPIPMode())
                    callViewHelper.showPIPLayout()
                else setVideoMuteStatus(userJid)
            }

            else -> handleCallConversionMessages(callAction)
        }
    }

    private fun handleCallConversionMessages(callAction: String) {
        when (callAction) {
            CallAction.ACTION_VIDEO_CALL_CONVERSION_ACCEPTED -> {
                if (dialogViewHelper.isVideoCallSwitchRequested()) {
                    showOrHideSurfaceViews()
                    activityBinding.layoutCallNotConnected.layoutCallNotConnected.gone()
                    activityBinding.layoutCallNotConnected.textCallStatus.gone()
                    activityBinding.layoutCallNotConnected.textCallerName.gone()
                    dialogViewHelper.dismissVideoCallRequestingDialog()
                    dialogViewHelper.dismissCallSwitchDialog()
                    setUpCallUI(true,true)
                }
            }

            CallAction.ACTION_VIDEO_CALL_CONVERSION_REJECTED -> {
                activityBinding.layoutCallOptions.imageMuteVideo.isActivated = false
                setUpCallUI()
                dialogViewHelper.dismissVideoCallRequestingDialog()
                Toast.makeText(this, "Request declined", Toast.LENGTH_SHORT).show()
            }

            CallAction.ACTION_VIDEO_CALL_CANCEL_CONVERSION -> {
                dialogViewHelper.isIncomingRequestAvailable()
                if (!dialogViewHelper.isVideoCallSwitchRequestedFromBothSides()) {
                    CallAudioManager.getInstance(context).stopIncomingRequestTone()
                    dialogViewHelper.dismissCallSwitchDialog()
                    dialogViewHelper.videoCallSwitchRequestCancelled()
                    GroupCallUtils.setIsOnVideoCall(false)
                    setUpCallUI()
                }
            }
        }
    }

    private fun handleReconnectingOrHold(@CallStatus callEvent: String, userJid: String) {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL #reconnecting  handleReconnecting userJid:$userJid")
        if (CallManager.isCallAttended()) {
            callViewHelper.updateCallStatus()
        } else {
            checkAndDismissPoorConnection()
            if (CallManager.isOneToOneCall()) {
                setUpCallUI()
            }
            if (callEvent == CallStatus.RECONNECTING) {
                CallUtils.clearPeakSpeakingUser(userJid)
                callViewHelper.onUserStoppedSpeaking(userJid)
                durationHandler.postDelayed({ checkAndUpdateStatusForUser(userJid) }, 1200)
            } else {
                checkAndUpdateStatusForUser(userJid)
            }
        }
    }

    private fun checkAndUpdateStatusForUser(userJid: String){
        if ((CallManager.isOneToOneCall() || CallUtils.getPinnedUserJid() == userJid) && !CallUtils.getIsGridViewEnabled()) callViewHelper.updateCallStatus()
        else callViewHelper.updateStatusAdapter(userJid)
    }

    private fun handleIncomingCallTimeoutCallNotConnectedState(){
        LogMessage.d(TAG, "$CALL_UI handleIncomingCallTimeoutCallNotConnectedState")
        if(CallManager.isCallAttended() && CallManager.getCallUsersList().size>0){
            callViewHelper.updateCallNotConnected()
        }else{
            LogMessage.d(TAG, "$CALL_UI handleIncomingCallTimeoutCall disconnectCall")
            disconnectCall(true, CallStatus.DISCONNECTED)
        }
    }

    private fun checkAndUpdateRingingBasedOnUserSize(userJid: String){
        LogMessage.d(TAG, "$CALL_UI ${com.mirrorflysdk.flycall.call.utils.JOIN_CALL}  checkAndUpdateRingingBasedOnUserSize userJid:$userJid")
        if(GroupCallUtils.getAvailableCallUsersList().size>1)
            callViewHelper.updateStatusAdapter(userJid)
        else{
            callViewHelper.updateCallStatus()
        }
    }

    private fun handleRemoteBusyBasedOnCallSize(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI handleRemoteBusyBasedOnCallSize userJid:$userJid ")
        if (GroupCallUtils.getAvailableCallUsersList().size < 1 &&
            !GroupCallUtils.getInvitedUsersList().contains(userJid)
        ) {
            LogMessage.d(TAG, "$CALL_UI handleRemoteBusyBasedOnCallSize isOneToOneCall ")
            CustomToast.showShortToast(this,"User is busy")
            disconnectCall(true, "User Busy")
        } else {
            LogMessage.d(TAG, "$CALL_UI handleRemoteBusyBasedOnCallSize busy from $userJid ")
            handleToastRemoteOtherBusy(userJid)
            callViewHelper.setUpProfileDetails(CallManager.getCallUsersList())
            updateStatusAndRemove(userJid)
        }
    }

    private fun handleToastRemoteOtherBusy(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI handleToastRemoteOtherBusy   userJid: $userJid ")
        val remoteBusyUserName: String = CallManager.getUserName(userJid)
        if (remoteBusyUserName == Constants.EMPTY_STRING)
            showToast("User is busy")
        else
            showToast("$remoteBusyUserName is busy")
    }

    private fun handleToastRemoteEngaged(userJid: String) {
        try {
            val remoteEngageUserName: String = CallManager.getUserName(userJid)
            LogMessage.d(TAG, "$CALL_UI handleCallEngagedBasedOnCallSize   remoteEngageUserName: $remoteEngageUserName ")
            if (remoteEngageUserName == Constants.EMPTY_STRING) {
                val profile = FlyCore.getUserProfile(userJid)
                if(profile != null && !profile.name.isNullOrEmpty()) showToast("${profile.name} is on another call") else showToast("User is on another call")
            } else
                showToast("$remoteEngageUserName is on another call")
        } catch(e: Exception){
            com.contusfly.utils.LogMessage.e(TAG,"handleToastRemoteEngaged Exception: $e")
        }
    }

    private inner class CustomCallEventsListener : CallEventsListener, CallActionListener,
        ConnectionQualityListener {
        override fun onCallStatusUpdated(callStatus: String, userJid: String) {
            handleCallStatusMessages(callStatus, userJid)
        }

        override fun onLocalVideoTrackAdded() {
            callViewHelper.onLocalVideoTrackAdded()
        }

        override fun onCallAction(callAction: String, userJid: String) {
            handleCallActionMessages(callAction, userJid)
        }

        override fun onVideoTrackAdded(userJid: String) {
            LogMessage.d(TAG, "$CALL_UI onVideoTrackAdded : $userJid")
            callViewHelper.onVideoTrackAdded(userJid)
        }

        override fun onMuteStatusUpdated(@MuteEvent muteEvent: String, userJid: String) {
            handleMuteEvents(muteEvent, userJid)
        }

        override fun onUserSpeaking(userJid: String, audioLevel: Int) {
            callViewHelper.onUserSpeaking(userJid, audioLevel)
        }

        override fun onUserStoppedSpeaking(userJid: String) {
            callViewHelper.onUserStoppedSpeaking(userJid)
        }

        private fun handleMuteEvents(muteEvent: String, userJid: String) {
            LogMessage.d(TAG, "$CALL_UI handleMuteEvents event: $muteEvent user: $userJid")
            when (muteEvent) {
                MuteEvent.ACTION_REMOTE_VIDEO_MUTE, MuteEvent.ACTION_REMOTE_VIDEO_UN_MUTE -> {
                    if (isInPIPMode())
                        callViewHelper.showPIPLayout()
                    else setVideoMuteStatus(userJid)
                }

                MuteEvent.ACTION_REMOTE_AUDIO_MUTE, MuteEvent.ACTION_REMOTE_AUDIO_UN_MUTE -> groupCallViewModel.setAudioMuteStatus(
                    userJid
                )

                else -> LogMessage.e(TAG, "$CALL_UI unknown mute event")
            }
            if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
                participantListFragment.handleMuteEvents(userJid)
            }
        }

        private fun handleCallStatusMessages(@CallStatus callEvent: String, userJid: String) {
            LogMessage.d(
                TAG,
                "$CALL_UI $JOIN_CALL received call status: $callEvent userJid:$userJid"
            )
            CallLogger.callTestingLog("UIKIT--> received call status: $callEvent userJid:$userJid")
            when (callEvent) {
                CallStatus.CONNECTED -> handleCallStatusConnected(userJid)
                CallStatus.DISCONNECTED -> disconnectCall(true, callEvent)
                CallStatus.CONNECTING -> {
                    if (CallManager.isCallAttended()) callViewHelper.updateCallStatus()
                    else callViewHelper.updateStatusAdapter(userJid)
                }

                CallStatus.OUTGOING_CALL_TIME_OUT -> {
                    LogMessage.d(
                        TAG,
                        "$CALL_UI $JOIN_CALL OUTGOING_CALL_TIME_OUT userJid:${userJid}"
                    )
                    if (CallManager.isCallConnected()) {
                        LogMessage.d(
                            TAG,
                            "$CALL_UI $JOIN_CALL OUTGOING_CALL_TIME_OUT userJid:$userJid"
                        )
                        val timeOutUserList = userJid.split(",").toList()
                        checkAndUpdateTimeoutUsers(timeOutUserList)
                    } else {
                        callViewHelper.showCallAgainView()
                    }
                }

                CallStatus.INVITE_CALL_TIME_OUT -> {
                    LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CALL_TIME_OUT userJid:$userJid")
                    val timeOutUserList = userJid.split(",").toList()
                    checkAndUpdateTimeoutInviteUsers(timeOutUserList)
                }

                CallStatus.INCOMING_CALL_TIME_OUT -> {
                    LogMessage.d(
                        TAG,
                        "$CALL_UI ${com.mirrorflysdk.flycall.call.utils.JOIN_CALL} INCOMING_CALL_TIME_OUT userJid:${userJid}"
                    )
                    if (CallManager.isCallConnected()) {
                        LogMessage.d(
                            TAG,
                            "$CALL_UI ${com.mirrorflysdk.flycall.call.utils.JOIN_CALL} INCOMING_CALL_TIME_OUT userJid:$userJid"
                        )
                        val timeOutUserList = userJid.split(",").toList()
                        checkAndUpdateTimeoutUsers(timeOutUserList)
                    } else {
                        handleIncomingCallTimeoutCallNotConnectedState()
                    }
                }

                else -> handleOtherCallStatusMessages(callEvent, userJid)
            }
        }

        private fun handleOtherCallStatusMessages(@CallStatus callEvent: String, userJid: String) {
            when (callEvent) {
                CallStatus.ON_RESUME -> handleCallStatusResume(userJid)
                CallStatus.RECONNECTING, CallStatus.ON_HOLD -> {
                    handleReconnectingOrHold(callEvent, userJid)
                }
                CallStatus.RINGING, CallStatus.CALLING_AFTER_10S -> {
                    val isCallNotConnected = CallManager.isCallNotConnected()
                    LogMessage.d(TAG, "$CALL_UI $callEvent $isCallNotConnected")
                    if (isCallNotConnected) callViewHelper.updateCallStatus()
                    else {
                        checkAndUpdateRingingBasedOnUserSize(userJid)
                    }
                }
                CallStatus.RECONNECTED -> handleCallStatusReconnected(userJid)
                CallStatus.USER_JOINED -> updateUserJoined(userJid)
                CallStatus.USER_LEFT -> updateUserLeft(userJid, true)
            }
        }

        private fun handleCallActionMessages(callAction: String, userJid: String) {
            LogMessage.d(TAG, "$CALL_UI received callAction: $callAction")
            CallLogger.callTestingLog("UIKIT---> handleCallActionMessages received callAction: $callAction")
            when (callAction) {
                CallAction.ACTION_REMOTE_OTHER_BUSY -> {
                    handleToastRemoteOtherBusy(userJid)
                    callViewHelper.setUpProfileDetails(CallManager.getCallUsersList())
                    updateStatusAndRemove(userJid)
                    if (::participantListFragment.isInitialized) {
                        LogMessage.e(TAG, "$CALL_UI RemoteOtherBusy user left::$userJid")
                        participantListFragment.updateUserLeft(userJid)
                    }
                }

                CallAction.ACTION_REMOTE_HANGUP, CallAction.ACTION_PERMISSION_DENIED,
                CallAction.ACTION_DENY_CALL, CallAction.ACTION_LOCAL_HANGUP -> disconnectCall(
                    true,
                    CallStatus.DISCONNECTED
                )

                CallAction.ACTION_REMOTE_BUSY -> {
                    handleRemoteBusyBasedOnCallSize(userJid)
                    if (::participantListFragment.isInitialized) {
                        LogMessage.e(TAG, "$CALL_UI RemoteOtherBusy user left::$userJid")
                        participantListFragment.updateUserLeft(userJid)
                    }
                }

                CallAction.ACTION_REMOTE_ENGAGED -> {
                    handleToastRemoteEngaged(userJid)
                    handleCallEngagedBasedOnCallSize(userJid)
                    if (::participantListFragment.isInitialized) {
                        LogMessage.e(TAG, "$CALL_UI RemoteOtherBusy user left::$userJid")
                        participantListFragment.updateUserLeft(userJid)
                    }
                }

                CallAction.ACTION_AUDIO_DEVICE_CHANGED -> callViewHelper.setSelectedAudioDeviceIcon()
                CallAction.CHANGE_TO_AUDIO_CALL -> {
                    activityBinding.layoutCallOptions.imageMuteVideo.isActivated = false
                    dialogViewHelper.videoCallSwitchRequestCancelled()
                    setUpCallUI()
                }

                CallAction.ACTION_INVITE_USERS -> {
                    invitedUsersProcess()
                }

                CallAction.ACTION_CAMERA_SWITCH_SUCCESS -> callViewHelper.setMirrorLocalView()
                CallAction.ACTION_CAMERA_SWITCH_FAILURE -> {
                    LogMessage.e(TAG, "$CALL_UI Camera switch error occurred")
                }

                else -> handleCallVideoMessages(callAction, userJid)
            }
        }

        private fun invitedUsersProcess() {
            try {
                dismissSwitchRequestDialog()
                for (inviteUserJid in CallManager.getInvitedUsersList()) {
                    if (CallManager.getCallStatus(inviteUserJid) != CallStatus.DISCONNECTED) {
                        checkAndAddPinnedUser(inviteUserJid)
                        checkAndAddNotPinnedUserInListAdapter(inviteUserJid)
                        callUserGridAdapter.addUser(inviteUserJid)
                        checkAndUpdateUserJoinedForInvitedUser(inviteUserJid)
                    }
                }
                CallUtils.setIsAddUsersToTheCall(false)
                setUpCallUI()
                callViewHelper.showListView()
            } catch (e: Exception) {
                com.contusfly.utils.LogMessage.e("Error", "invitedUsersProcess exception $e")
            }
        }


        override fun onResponse(isSuccess: Boolean, flyException: FlyException?) {
            LogMessage.d(TAG, "$CALL_UI onResponse")
            val errorMessage = flyException?.message ?: ""
            runOnUiThread {
                if (!isSuccess)
                    Toast.makeText(this@GroupCallActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }

        override fun onQualityUpdated(quality: ConnectionQuality) {
            LogMessage.d(
                TAG,
                "$CALL_UI onQualityUpdated received quality:$quality isInPIPMode:${isInPIPMode()}"
            )
            if (!isInPIPMode()) {
                checkAndShowPoorConnection(quality)
            }
        }
    }

    private fun checkAndAddPinnedUser(userJid:String){
        if (CallUtils.getPinnedUserJid().isBlank() && userJid != CallManager.getCurrentUserId()){
            LogMessage.d(
                TAG,
                "$CALL_UI checkAndAddPinnedUser  userJid: $userJid"
            )
            CallUtils.setIsUserTilePinned(true)
            CallLogger.callTestingLog("UIKIT---> checkAndAddPinnedUser setPinnedUserJid $userJid")
            CallUtils.setPinnedUserJid(userJid)
        }
    }

    /**
     * To dismiss switchRequest dialog if user A & B ongoing call with displaying switch request dialog in user A, at the time
     * if user B invite user c, then the switchRequest should not be applicable for group call & need to close the popup.
     */

    private fun dismissSwitchRequestDialog() {
        if (!GroupCallUtils.isOneToOneCall()) {
            dialogViewHelper.dismissCallSwitchDialog()
            dialogViewHelper.dismissCallSwitchConfirmationDialog()
            dialogViewHelper.dismissVideoCallRequestingDialog()
        }
    }

    private fun checkAndAddNotPinnedUserInListAdapter(userJid: String){
        if (CallUtils.getPinnedUserJid() != userJid)
            callUsersListAdapter.addUser(userJid)
    }

    private fun checkAndUpdateUserJoinedForInvitedUser(userJid: String){
        if (::participantListFragment.isInitialized) {
            LogMessage.d(
                TAG,
                "$CALL_UI checkAndUpdateUserJoined added in participant fragment::$userJid"
            )
            participantListFragment.updateUserJoined(userJid)
        }
    }

    private fun handleCallEngagedBasedOnCallSize(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI handleCallEngagedBasedOnCallSize userJid:$userJid ")
        if (GroupCallUtils.getAvailableCallUsersList().size < 1 &&
            !GroupCallUtils.getInvitedUsersList().contains(userJid)
        )
            disconnectCall(true, "Call Engaged")
        else {
            callViewHelper.setUpProfileDetails(CallManager.getCallUsersList())
            updateStatusAndRemove(userJid)
        }
    }

    private fun handleCallStatusReconnected(userJid: String?) {
        LogMessage.d(TAG, "$CALL_UI handleCallStatusReconnected userJid:$userJid ")
        if (isInPIPMode()) {
            callViewHelper.showPIPLayout()
        } else if ((CallManager.isOneToOneCall() || CallUtils.getPinnedUserJid() == userJid) && !CallUtils.getIsGridViewEnabled()) {
            LogMessage.d(
                TAG,
                "$CALL_UI handleCallStatusReconnected seems like isOneToOneCall just update status"
            )
            callViewHelper.updateCallStatus()
        } else {
            LogMessage.d(
                TAG,
                "$CALL_UI handleCallStatusReconnected more than 2 users lets update list/grid adapters!!"
            )
            if (!callUsersListAdapter.callUserList.contains(userJid)) {
                LogMessage.d(
                    TAG,
                    "$CALL_UI handleCallStatusReconnected new user connected for list id: $userJid"
                )
                callUsersListAdapter.addUser(userJid!!)
                setUpCallUI()
            }
            if (userJid != null) {
                checkAndAddUserJoinedForGridLayout(userJid)
            }
            callViewHelper.updateStatusAdapter(userJid)
        }
    }

    private fun handleCallStatusResume(userJid: String?) {
        setUpCallUI()
        if (!CallManager.isOneToOneCall() || (CallManager.isOneToOneCall() && CallManager.getCallType() == CallType.VIDEO_CALL)) {
            activityBinding.layoutCallNotConnected.layoutCallNotConnected.gone()
            activityBinding.layoutCallNotConnected.textCallStatus.gone()
        }
        callViewHelper.updateStatusAdapter(userJid)
    }

    private fun handleCallStatusConnected(userJid: String?) {
        LogMessage.d(TAG, "$CALL_UI handleCallStatusConnected: userJid:$userJid")
        setUpCallUI()
        callViewHelper.updateStatusAdapter(userJid)
        callViewHelper.updatedRejoinedUsers(userJid)
    }

    private fun checkAndUpdateTimeoutUsers(timeOutUserList:List<String>) {
        LogMessage.d(TAG, "$CALL_UI checkAndUpdateTimeoutUsers() timeOutUserList:$timeOutUserList")
        for (userJid in timeOutUserList) {
            callUsersListAdapter.removeUser(userJid)
            callUserGridAdapter.removeUser(userJid)
            if (::participantListFragment.isInitialized) {
                LogMessage.e(TAG, "$CALL_UI checkAndUpdateTimeoutUsers invite user left::$userJid")
                participantListFragment.updateUserLeft(userJid)
            }
        }
        checkAndRemoveIfPinnedUserLeft()
        setUpCallUI()
    }

    private fun checkAndRemoveIfPinnedUserLeft(){
        LogMessage.d(TAG, "$CALL_UI checkAndRemoveIfPinnedUserLeft() pinnedUser: ${CallUtils.getPinnedUserJid()}")
        if (CallManager.isPinnedUserLeft()) callViewHelper.pinnedUserLeft(CallUtils.getPinnedUserJid())
    }

    private fun checkAndUpdateTimeoutInviteUsers(timeOutUserList:List<String>) {
        LogMessage.d(TAG, "$CALL_UI checkAndUpdateTimeoutInviteUsers()")
        for (userJid in timeOutUserList) {
            callUsersListAdapter.removeUser(userJid)
            callUserGridAdapter.removeUser(userJid)
            if (::participantListFragment.isInitialized) {
                LogMessage.e(TAG, "$CALL_UI invite user left::$userJid")
                participantListFragment.updateUserLeft(userJid)
            }
        }
        checkAndRemoveIfPinnedUserLeft()
        setUpCallUI()
    }

    override fun addLocalUserToAdapter() {
        if (CallUtils.getPinnedUserJid() != CallManager.getCurrentUserId() && !callUsersListAdapter.callUserList.contains(
                CallManager.getCurrentUserId()
            )
        ) {
            callUsersListAdapter.addUser(CallManager.getCurrentUserId())
            durationHandler.removeCallbacks(gridResizeRunnable)
            durationHandler.postDelayed(gridResizeRunnable, 500)
        }
    }

    private fun checkAndAddUserJoinedForGridLayout(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI #joinCall checkAndAddUserJoinedForGridLayout: user: $userJid")
        if (!callUserGridAdapter.gridCallUserList.contains(userJid)) {
            LogMessage.d(TAG, "$CALL_UI #joinCall new UserJoined: $userJid")
            callUserGridAdapter.addUser(userJid)
            if (!isInPIPMode())
                callsUsersToast(
                    String.format(
                        getString(R.string.call_member_joined),
                        ProfileDetailsUtils.getDisplayNameFromJid(userJid)
                    )
                )
        }
    }

    fun updateUserJoined(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI #joinCall updateUserJoined: $userJid")
        dialogViewHelper.videoCallSwitchRequestAccepted()
        if (CallUtils.getPinnedUserJid().isBlank() && userJid != CallManager.getCurrentUserId()){
            CallUtils.setIsUserTilePinned(true)
            CallLogger.callTestingLog("UIKIT---> updateUserJoined setPinnedUserJid $userJid")
            CallUtils.setPinnedUserJid(userJid)
        }
        CallLogger.callTestingLog("UIKIT---> updateUserJoined userJid: $userJid pinnedUserJid: ${CallUtils.getPinnedUserJid()}")
        if (CallUtils.getPinnedUserJid() != userJid)
            callUsersListAdapter.addUser(userJid)
        checkAndAddUserJoinedForGridLayout(userJid)
        setUpCallUI()
        showOrHideSurfaceViews()
        LogMessage.d(TAG, "$CALL_UI #joinCall isInitialized: ${::participantListFragment.isInitialized }")
        LogMessage.d(TAG, "$CALL_UI #joinCall isAddUsersToTheCall: ${CallUtils.isAddUsersToTheCall()}")
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.updateUserJoined(userJid)
        }
        callViewHelper.showListView()
    }

    fun updateUserLeft(userJid: String, leftStatus: Boolean) {
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL updateUserLeft: $userJid isDisconnectCalled: $isDisconnectCalled getPinnedUserJid: ${CallUtils.getPinnedUserJid()}"
        )
        if (!isDisconnectCalled.get()) {
            if (CallManager.isPinnedUserLeft(userJid))
                callViewHelper.pinnedUserLeft(userJid)
            else
                callUsersListAdapter.removeUser(userJid)

            if (callUserGridAdapter.gridCallUserList.contains(userJid)) {
                callUserGridAdapter.removeUser(userJid)
                if (!isInPIPMode() && leftStatus)
                    callsUsersToast(
                        String.format(
                            getString(R.string.call_member_left),
                            ProfileDetailsUtils.getDisplayNameFromJid(userJid)
                        )
                    )
            }

            if (GroupCallUtils.isSingleUserInCall()) {
                //resetting grid view enabled
                CallUtils.setIsGridViewEnabled(false)
            }

            if(CallManager.isOneToOneCall()){
                LogMessage.d(
                    TAG,
                    "$CALL_UI $JOIN_CALL isOneToOneCall updateUserLeft "
                )
                setUpCallUI()
            }

            if (::participantListFragment.isInitialized) {
                participantListFragment.updateUserLeft(userJid)
            }
            CallUtils.clearPeakSpeakingUser(userJid)
        }
    }

    private fun callsUsersToast(msg: String) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            //getting the View object as defined in the custom_toast.xml file
            val customLayout = layoutInflater.inflate(R.layout.custom_toast, toast_layout)
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_LONG
            toast.setGravity(Gravity.BOTTOM, 0, 180)
            customLayout.findViewById<TextView>(R.id.custom_toast_message).text = msg
            toast.view = customLayout
            toast.show()
        } else Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }


    private fun resizeGridView() {
        LogMessage.d(TAG, "$CALL_UI resizeGridView()")
        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_VIEW_SIZE_UPDATED, 1)
        bundle.putInt(CallActions.NOTIFY_VIEW_VIDEO_MUTE_UPDATED, 1)
        bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)
        if (CallUtils.getIsGridViewEnabled())
            callUserGridAdapter.notifyItemRangeChanged(
                0,
                callUserGridAdapter.gridCallUserList.size,
                bundle
            )
        else
            callUsersListAdapter.notifyItemRangeChanged(
                0,
                callUsersListAdapter.callUserList.size,
                bundle
            )
    }

    override fun requestCameraPermission() {
        MediaPermissions.requestVideoCallPermissions(this, requestSwitchCameraPermission,isConversionRequest = false,isFromVideoCallEnable = true)
    }

    override fun onCallSwitchConfirmationDialog() {
        LogMessage.d(TAG, "$CALL_UI onCallSwitchConfirmationDialog removeUser")
        callViewHelper.animateCallOptionsView()
        callUsersListAdapter.removeUser(CallManager.getCurrentUserId())
        activityBinding.layoutCallOptions.imageMuteVideo.isActivated = true
    }

    override fun onRequestingVideoCallDialog() {
        activityBinding.layoutCallOptions.imageMuteVideo.isActivated = false
        setUpCallUI()
    }

    override fun onCallSwitchDialog(isAccepted: Boolean) {
        if (isAccepted) {
            if (MediaPermissions.isPermissionAllowed(context, Manifest.permission.CAMERA)) {
                acceptVideoCallSwitch()
            } else {
                MediaPermissions.requestVideoCallPermissions(
                    this,
                    requestCallSwitchCameraPermission,true)
            }
        } else {
            callViewHelper.checkAndUpdateCameraView()
            sendResponseToVideoCallRequest(false)
        }
    }

    override fun switchToGridView() {
        CallUtils.setIsGridViewEnabled(true)
        CallUtils.setIsViewUpdatesCompleted(false) //frequent speaking indicator animation shouldn't happen while switching view
        setUpCallUI()
        resetViewsUpdatedFlag()
    }

    override fun switchToTileView() {
        CallUtils.setIsGridViewEnabled(false)
        CallUtils.setIsViewUpdatesCompleted(false) //frequent speaking indicator animation shouldn't happen while switching view
        setUpCallUI()
        resetViewsUpdatedFlag()
    }

    override fun resetViewsUpdatedFlag() {
        durationHandler.removeCallbacks(resetViewUpdatesRunnable)
        durationHandler.postDelayed(resetViewUpdatesRunnable, 700)
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        LogMessage.d(TAG, "$CALL_UI updated Admin Block status")
        updateAdminBlockedStatus(jid, type, status)
    }

    private fun updateAdminBlockedStatus(jid: String, type: String, status: Boolean) {
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.onAdminBlockedStatus(jid, type, status)
        }
    }

    override fun updateFeatureActions(features: Features) {
        callViewHelper.updateFeatureActions()
    }

    override fun onGroupProfileUpdated(groupJid: String) {
        super.onGroupProfileUpdated(groupJid)
        LogMessage.d(TAG, "$CALL_UI onGroupProfileUpdated groupJid:$groupJid")
        updateUserDetailsUpdatedInCall(groupJid)
    }

    override fun onSuperAdminDeleteGroup(groupJid: String, groupName: String) {
        super.onSuperAdminDeleteGroup(groupJid, groupName)
        clearDeletedGroupChatNotification(groupJid, context)
        if (CallManager.getGroupID() == groupJid){
            showToast(getString(R.string.deleted_by_super_admin, groupName))
            setResult(Activity.RESULT_FIRST_USER)
            disconnectCall(true)
            if (!isInPIPMode())
                startDashboardActivity(this)
        }
    }

    fun checkAndRequestFullScreenPermission() {
        if(!ChatUtils.checkFullScreenNotificationPermissionEnabled()){
            com.contusfly.utils.LogMessage.d(TAG,"#fullscreen fullScreenNotificationPermission requesting!!")
            if(!SharedPreferenceManager.getBoolean(Constants.ASK_FULL_SCREEN_INTENT_PERMISSION)) {
                MediaPermissions.requestFullScreenNotificationPermission(
                    this,
                    permissionAlertDialog,
                    fullScreenNotificationPermissionLauncher,isCall = true)
            }

        } else {
            com.contusfly.utils.LogMessage.d(TAG,"#fullscreen fullScreenNotificationPermission enabled!!")
        }
    }

    private val fullScreenNotificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { _ ->
        if(ChatUtils.checkFullScreenNotificationPermissionEnabled()){
            com.contusfly.utils.LogMessage.d(TAG,"#fullscreen fullScreenNotificationPermission Launcher enabled!!")
        }
    }

    private fun dismissPoorConnectionLayout() {
        activityBinding.layoutCallOptions.layoutSlowNetwork.poorConnectionRoot.visibility =
            View.GONE
        callViewHelper.updatePoorConnectionLayout()
        checkAndUpdateUiForPoorConnection()
    }

    private fun checkAndShowPoorConnection(connectionQuality: ConnectionQuality) {
        LogMessage.d(
            TAG,
            "$CALL_UI #callconnectionquality checkAndShowPoorConnection connectionQuality: $connectionQuality"
        )
        if(connectionQuality == ConnectionQuality.POOR){
            activityBinding.layoutCallOptions.layoutSlowNetwork.poorConnectionRoot.visibility =
                View.VISIBLE
            activityBinding.layoutCallOptions.layoutSlowNetwork.closeSnack.setOnClickListener(1000) {
                dismissPoorConnectionLayout()
            }
            callViewHelper.updatePoorConnectionLayout()
            activityBinding.layoutCallOptions.layoutSlowNetwork.poorConnectionRoot.postDelayed({
                dismissPoorConnectionLayout()
            }, 5000)
        }else{
            checkAndUpdateUiForPoorConnection()
        }

    }

    private fun checkAndUpdateUiForPoorConnection() {
        callViewHelper.updateUiForCallConnectionQuality()
    }

    private fun checkAndDismissPoorConnection(){
        if(activityBinding.layoutCallOptions.layoutSlowNetwork.poorConnectionRoot.visibility == View.VISIBLE){
            LogMessage.d(
                    TAG,
                    "$CALL_UI #callconnectionquality checkAndDismissPoorConnection"
            )
            dismissPoorConnectionLayout()
        }
    }
}