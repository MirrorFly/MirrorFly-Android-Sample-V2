package com.contusfly.call.groupcall

import android.Manifest
import android.annotation.SuppressLint
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
import androidx.fragment.app.FragmentTransaction
import com.contus.call.CallActions
import com.contus.call.CallConstants
import com.contus.call.CallConstants.CALL_UI
import com.contusfly.*
import com.contusfly.R
import com.contusfly.activities.BaseActivity
import com.contusfly.call.groupcall.helpers.BaseCallViewHelper
import com.contusfly.call.groupcall.helpers.DialogViewHelper
import com.contusfly.call.groupcall.listeners.ActivityOnClickListener
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.ActivityGroupCallBinding
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.MediaPermissions
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.*
import com.mirrorflysdk.flycall.webrtc.WebRtcCallService.Companion.setupVideoCapture
import com.mirrorflysdk.flycall.webrtc.api.CallActionListener
import com.mirrorflysdk.flycall.webrtc.api.CallEventsListener
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.flycommons.LogMessage
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

    private val permissionAlertDialog : PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

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
            val cameraPermissionGranted = permissions[Manifest.permission.CAMERA] ?: MediaPermissions.isPermissionAllowed(activity, Manifest.permission.CAMERA)
            if (cameraPermissionGranted)
                callViewHelper.toggleVideoMute()
        }

    private val requestCallSwitchCameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val cameraPermissionGranted = permissions[Manifest.permission.CAMERA] ?: MediaPermissions.isPermissionAllowed(activity, Manifest.permission.CAMERA)
            if (cameraPermissionGranted)
                acceptVideoCallSwitch()
        }

    private val requestAudioCallPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val recordPermissionGranted = permissions[Manifest.permission.RECORD_AUDIO] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.RECORD_AUDIO)

            if (!recordPermissionGranted)
                CallManager.sendCallPermissionDenied()
        }

    private val requestVideoCallPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val cameraPermissionGranted = permissions[Manifest.permission.CAMERA] ?: MediaPermissions.isPermissionAllowed(activity, Manifest.permission.CAMERA)
            val recordPermissionGranted = permissions[Manifest.permission.RECORD_AUDIO] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.RECORD_AUDIO)

            if (!cameraPermissionGranted || !recordPermissionGranted)
                CallManager.sendCallPermissionDenied()
            else
                CallManager.startVideoCapture()
        }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { _ ->
        if(!ChatUtils.checkMediaPermission(this, Manifest.permission.POST_NOTIFICATIONS)){
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
        LogMessage.d(TAG, "$CALL_UI onStart()")
        super.onStart()
        CallManager.bindCallService()
        setUpCallUI()
        if (CallManager.isInComingCall()) {
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
            } else
                CallManager.startVideoCapture()
        }
    }

    private fun notificationPermissionChecking() {
        MediaPermissions.requestNotificationPermission(
            this,
            permissionAlertDialog,
            notificationPermissionLauncher, true)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        LogMessage.i(TAG, "$CALL_UI onNewIntent()")
        setUpCallDataAndUI()
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogMessage.d(TAG, "$CALL_UI onCreate")
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        activityBinding = ActivityGroupCallBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)
        CallManager.configureCallActivity(this)
        window.setFormat(PixelFormat.TRANSLUCENT)
        //register for call events
        CallManager.setCallEventsListener(customCallEventsListener)

        initViews()
        setUpCallDataAndUI()
        groupCallViewModel.checkInternetConnection()
    }

    private fun setUpCallDataAndUI() {
        if (intent.extras != null) {
            groupId = intent.getStringExtra(com.mirrorflysdk.flycall.call.utils.CallConstants.EXTRA_GROUP_ID)
            val acceptCall = intent.getBooleanExtra(com.mirrorflysdk.flycall.call.utils.CallConstants.ACCEPT_CALL, false)
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

        groupCallViewModel.internetConnectionNotAvailable.observe(this, {
            showToast(getString(R.string.fly_error_msg_no_internet))
        })

        groupCallViewModel.remoteAudioMuteStatus.observe(this, { userJid ->
            callViewHelper.updateRemoteAudioMuteStatus(userJid)
        })

        AppLifecycleListener.adminBlockedOtherUser.observe(this) {
            updateAdminBlockedStatus(it.first, it.second, it.third)
        }
    }

    private fun acceptVideoCallSwitch() {
        val isRequestAvailable = CallManager.isCallConversionRequestAvailable()
        LogMessage.d(TAG, "$CALL_UI showCallSwitchAlert Accept: $isRequestAvailable")
        if (isRequestAvailable) {
            dialogViewHelper.dismissCallSwitchDialog()
            activityBinding.layoutCallOptions.imageMuteVideo.isActivated = true
            sendResponseToVideoCallRequest(true)
            setUpCallUI()
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
            callUserGridAdapter.notifyItemRangeChanged(0, callUserGridAdapter.gridCallUserList.size, bundle)
        else
            callUsersListAdapter.notifyItemRangeChanged(0, callUsersListAdapter.callUserList.size, bundle)
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
        CallAudioManager.getInstance(this).playIncomingRequestTone()
        dialogViewHelper.showCallSwitchDialog()
        dialogViewHelper.dismissCallSwitchConfirmationDialog()
        if (dialogViewHelper.isVideoCallSwitchRequestedFromBothSides()) {
            switchToVideoCall()
        }
    }

    public override fun onUserLeaveHint() {
        LogMessage.d(TAG, "$CALL_UI onUserLeaveHint() CallManager.isCallAgain:${CallManager.isCallAgain()}")
        callViewHelper.gotoPIPMode()
        if (CallManager.isCallAgain()) {
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
            callViewHelper.hidePIPLayout()
            resetPIPModeByCallType()
        }
    }

    private fun resetPIPModeByCallType() {
        activityBinding.imageMinimizeCall.show()
        setUpCallUI()
    }

    override fun finish() {
        LogMessage.d(TAG, "$CALL_UI finish()")
        if (SystemClock.elapsedRealtime() - lastClickTime > 2000) {
            if (!CallManager.isCallConnected()) {
                super.finish()
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    callViewHelper.gotoPIPMode()
                } else {
                    super.finish()
                }
                LogMessage.i(TAG, "$CALL_UI Call is connected, so entering into pip mode ")
            }
            lastClickTime = SystemClock.elapsedRealtime()
        }
    }

    /**
     * initialize views here
     */
    private fun initViews() {
        LogMessage.d(TAG, "$CALL_UI initViews()")
        activityBinding.callOptionsUpArrow.setOnClickListener(this)
        activityBinding.rootLayout.setOnClickListener(this)
        activityBinding.viewOverlay.setOnClickListener(this)
        activityBinding.imageMinimizeCall.setOnClickListener(this)

        callUsersListAdapter = GroupCallListAdapter(this)
        callUserGridAdapter = GroupCallGridAdapter(this)

        callUsersListAdapter.onPinnedListView { userJid ->
            callViewHelper.pinnedUserChanged(userJid)
        }

        callUsersListAdapter.onTapOnRecyclerView {
            callViewHelper.animateCallOptionsView()
        }

        callUserGridAdapter.onUserPinnedGridView { userJid ->
            if (CallUtils.getIsUserTilePinned() && userJid == CallUtils.getPinnedUserJid())
                callViewHelper.pinnedUserRemoved()
            else
                callViewHelper.pinnedUserChanged(userJid)
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

        if (CallManager.isOneToOneCall() && CallManager.isVideoCall()) {
            setUpCallUI()
        }
        LogMessage.d(TAG, "$CALL_UI setVideoMuteStatus() userJid:${userJid}")
        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_VIEW_VIDEO_MUTE_UPDATED, 1)

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
                    callUsersListAdapter.notifyItemChanged(index, bundle)
                }
            }
        }
    }

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
        LogMessage.d(TAG, "$CALL_UI answer()")
        if (isAnswerCalled.compareAndSet(false, true)) {
            CallManager.answerCall(object : CallActionListener {
                override fun onResponse(isSuccess: Boolean, message: String) {
                    LogMessage.d(TAG, "$CALL_UI answer() success: $isSuccess")
                     setUpCallUI()
                }
            })
        }
    }

    /**
     * update call view
     */
    private fun setUpCallUI() {
        LogMessage.d(TAG, "$CALL_UI setUpCallUI()")
        if (isInPIPMode()) {
            callViewHelper.showPIPLayout()
        } else {
            callViewHelper.setUpCallUI()
        }
    }

    private fun disconnectCall(isNotFromRetry: Boolean, callStatus: String = CallStatus.DISCONNECTED) {
        LogMessage.d(TAG, "$CALL_UI disconnectCall()")
        if (isDisconnectCalled.compareAndSet(false, true)) {
            // The below code execution is guaranteed to be called only once
                setResult(if (CallManager.isAudioCall()) CallConstants.AUDIO_CALL_REQUEST_CODE else CallConstants.VIDEO_CALL_REQUEST_CODE)
            dialogViewHelper.disconnectCall()
            callViewHelper.disconnectCall()
            CallUtils.resetValues()
            if (isNotFromRetry)
                callViewHelper.updateDisconnectedStatus(callStatus)
            else
                finish()
        }
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
            R.id.root_layout, R.id.call_options_up_arrow, R.id.view_overlay -> if (CallManager.isCallConnected()) {
                callViewHelper.animateCallOptionsView()
            }
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
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.refreshUser(jid)
        }
        if (jid == CallManager.getEndCallerJid())
            callViewHelper.setUpProfileDetails(CallManager.getCallUsersList())
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
                CallManager.getCallUsersList()
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
        CallUtils.setVideoViewInitialization(false)
        super.onDestroy()
    }

    private fun updateStatusAndRemove(userJid: String?) {
        LogMessage.d(TAG, " $CALL_UI updateStatusAndRemove userJid: $userJid")
        if (userJid != null) {
            val bundle = Bundle()
            bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)
            if (CallUtils.getIsGridViewEnabled()){
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
                    setUpCallUI()
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

    private inner class CustomCallEventsListener : CallEventsListener {
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
                MuteEvent.ACTION_REMOTE_AUDIO_MUTE, MuteEvent.ACTION_REMOTE_AUDIO_UN_MUTE -> groupCallViewModel.setAudioMuteStatus(userJid)
                else -> LogMessage.e(TAG, "$CALL_UI unknown mute event")
            }
            if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
                participantListFragment.handleMuteEvents(userJid)
            }
        }

        private fun handleCallStatusMessages(@CallStatus callEvent: String, userJid: String) {
            LogMessage.d(TAG, "$CALL_UI received call status: $callEvent")
            when (callEvent) {
                CallStatus.CONNECTED -> handleCallStatusConnected(userJid)
                CallStatus.DISCONNECTED -> disconnectCall(true, callEvent)
                CallStatus.CONNECTING -> callViewHelper.updateStatusAdapter(userJid)
                CallStatus.OUTGOING_CALL_TIME_OUT -> {
                    if (CallManager.isCallConnected()) {
                        checkAndUpdateTimeoutUsers()
                    } else {
                        callViewHelper.showCallAgainView()
                    }
                }
                CallStatus.INVITE_CALL_TIME_OUT -> checkAndUpdateTimeoutInviteUsers()
                CallStatus.INCOMING_CALL_TIME_OUT -> disconnectCall(true, CallStatus.DISCONNECTED)
                else -> handleOtherCallStatusMessages(callEvent, userJid)
            }
        }

        private fun handleOtherCallStatusMessages(@CallStatus callEvent: String, userJid: String) {
            when (callEvent) {
                CallStatus.ON_RESUME -> handleCallStatusResume(userJid)
                CallStatus.RECONNECTING, CallStatus.ON_HOLD -> {
                    setUpCallUI()
                    if ((CallManager.isOneToOneCall() || CallUtils.getPinnedUserJid() == userJid) && !CallUtils.getIsGridViewEnabled()) callViewHelper.updateCallStatus()
                    else callViewHelper.updateStatusAdapter(userJid)
                }
                CallStatus.RINGING, CallStatus.CALLING_AFTER_10S -> {
                    if (CallManager.isCallNotConnected()) callViewHelper.updateCallStatus()
                    else callViewHelper.updateStatusAdapter(userJid)
                }
                CallStatus.RECONNECTED -> handleCallStatusReconnected(userJid)
                CallStatus.USER_JOINED -> updateUserJoined(userJid)
                CallStatus.USER_LEFT -> updateUserLeft(userJid, true)
            }
        }

        private fun handleCallActionMessages(callAction: String, userJid: String) {
            LogMessage.d(TAG, "$CALL_UI received callAction: $callAction")
            when (callAction) {
                CallAction.ACTION_REMOTE_OTHER_BUSY -> {
                    callViewHelper.setUpProfileDetails(CallManager.getCallUsersList())
                    updateStatusAndRemove(userJid)
                }
                CallAction.ACTION_REMOTE_HANGUP, CallAction.ACTION_PERMISSION_DENIED,
                CallAction.ACTION_DENY_CALL, CallAction.ACTION_LOCAL_HANGUP -> disconnectCall(true, CallStatus.DISCONNECTED)
                CallAction.ACTION_REMOTE_BUSY -> disconnectCall(true, "User Busy")
                CallAction.ACTION_REMOTE_ENGAGED -> disconnectCall(true, "Call Engaged")
                CallAction.ACTION_AUDIO_DEVICE_CHANGED -> callViewHelper.setSelectedAudioDeviceIcon()
                CallAction.CHANGE_TO_AUDIO_CALL -> {
                    activityBinding.layoutCallOptions.imageMuteVideo.isActivated = false
                    dialogViewHelper.videoCallSwitchRequestCancelled()
                    setUpCallUI()
                }
                CallAction.ACTION_INVITE_USERS -> {
                    for (inviteUserJid in CallManager.getInvitedUsersList()) {
                        if (CallManager.getCallStatus(inviteUserJid) != CallStatus.DISCONNECTED) {
                            callUsersListAdapter.addUser(inviteUserJid)
                            callUserGridAdapter.addUser(inviteUserJid)
                        }
                    }
                    CallUtils.setIsAddUsersToTheCall(false)
                    setUpCallUI()
                    callViewHelper.showListView()
                }
                CallAction.ACTION_CAMERA_SWITCH_SUCCESS -> callViewHelper.setMirrorLocalView()
                CallAction.ACTION_CAMERA_SWITCH_FAILURE -> {
                    LogMessage.e(TAG, "$CALL_UI Camera switch error occurred")
                }
                else -> handleCallVideoMessages(callAction, userJid)
            }
        }
    }

    private fun handleCallStatusReconnected(userJid: String?) {
        if (isInPIPMode()) {
            callViewHelper.showPIPLayout()
        } else if ((CallManager.isOneToOneCall() || CallUtils.getPinnedUserJid() == userJid) && !CallUtils.getIsGridViewEnabled()){
            callViewHelper.updateCallStatus()
        } else {
            if(!callUsersListAdapter.callUserList.contains(userJid)){
                callUsersListAdapter.addUser(userJid!!)
                setUpCallUI()
            }
            callViewHelper.updateStatusAdapter(userJid)
        }
    }

    private fun handleCallStatusResume(userJid: String?) {
        setUpCallUI()
        activityBinding.layoutCallConnected.textCallStatus.gone()
        if (!CallManager.isOneToOneCall() || (CallManager.isOneToOneCall() && CallManager.getCallType() == CallType.VIDEO_CALL)) {
            activityBinding.layoutCallNotConnected.layoutCallNotConnected.gone()
            activityBinding.layoutCallNotConnected.textCallStatus.gone()
        }
        callViewHelper.updateStatusAdapter(userJid)
    }

    private fun handleCallStatusConnected(userJid: String?) {
        setUpCallUI()
        callViewHelper.updateStatusAdapter(userJid)
        callViewHelper.updatedRejoinedUsers(userJid)
    }

    private fun checkAndUpdateTimeoutUsers() {
        LogMessage.d(TAG, "$CALL_UI checkAndUpdateTimeoutUsers()")
        for (userJid in CallManager.getTimeOutUsersList()) {
            callUsersListAdapter.removeUser(userJid)
            callUserGridAdapter.removeUser(userJid)
            CallManager.removeTimeoutUser(userJid)
        }
        if (CallManager.isPinnedUserLeft()) callViewHelper.pinnedUserLeft()
        setUpCallUI()
    }

    private fun checkAndUpdateTimeoutInviteUsers() {
        LogMessage.d(TAG, "$CALL_UI checkAndUpdateTimeoutInviteUsers()")
        for (userJid in CallManager.getInviteTimeOutUsersList()) {
            callUsersListAdapter.removeUser(userJid)
            callUserGridAdapter.removeUser(userJid)
            CallManager.removeTimeoutUser(userJid)
        }
        if (CallManager.isPinnedUserLeft()) callViewHelper.pinnedUserLeft()
        setUpCallUI()
    }

    override fun addLocalUserToAdapter() {
        if (CallUtils.getPinnedUserJid() != CallManager.getCurrentUserId() && !callUsersListAdapter.callUserList.contains(CallManager.getCurrentUserId())) {
            callUsersListAdapter.addUser(CallManager.getCurrentUserId())
            durationHandler.removeCallbacks(gridResizeRunnable)
            durationHandler.postDelayed(gridResizeRunnable, 500)
        }
    }

    fun updateUserJoined(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI updateUserJoined: $userJid")
        dialogViewHelper.videoCallSwitchRequestAccepted()
        if (CallUtils.getPinnedUserJid() != userJid)
            callUsersListAdapter.addUser(userJid)
        if (!callUserGridAdapter.gridCallUserList.contains(userJid)) {
            callUserGridAdapter.addUser(userJid)
            if (!isInPIPMode())
                callsUsersToast(String.format(getString(R.string.call_member_joined), ProfileDetailsUtils.getDisplayName(userJid)))
        }
        setUpCallUI()
        showOrHideSurfaceViews()
        if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
            participantListFragment.updateUserJoined(userJid)
        }
        callViewHelper.showListView()
    }

    fun updateUserLeft(userJid: String, leftStatus: Boolean) {
        LogMessage.d(TAG, "$CALL_UI updateUserLeft: $userJid")
        if (!isDisconnectCalled.get()) {
            if (CallManager.isPinnedUserLeft(userJid))
                callViewHelper.pinnedUserLeft()
            else
                callUsersListAdapter.removeUser(userJid)

            if (callUserGridAdapter.gridCallUserList.contains(userJid)) {
                callUserGridAdapter.removeUser(userJid)
                if (!isInPIPMode() && leftStatus)
                    callsUsersToast(String.format(getString(R.string.call_member_left), ProfileDetailsUtils.getDisplayName(userJid)))
            }

            setUpCallUI()

            if (::participantListFragment.isInitialized && CallUtils.isAddUsersToTheCall()) {
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
            callUserGridAdapter.notifyItemRangeChanged(0, callUserGridAdapter.gridCallUserList.size, bundle)
        else
            callUsersListAdapter.notifyItemRangeChanged(0, callUsersListAdapter.callUserList.size, bundle)
    }

    override fun requestCameraPermission() {
        MediaPermissions.requestVideoCallPermissions(this, requestSwitchCameraPermission)
    }

    override fun onCallSwitchConfirmationDialog() {
        callViewHelper.animateCallOptionsView()
        callUsersListAdapter.removeUser(CallManager.getCurrentUserId())
        resizeGridView()
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
                MediaPermissions.requestVideoCallPermissions(this, requestCallSwitchCameraPermission)
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
        durationHandler.postDelayed(resetViewUpdatesRunnable, 500)
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        LogMessage.d(TAG, "${CALL_UI} updated Admin Block status")
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
}