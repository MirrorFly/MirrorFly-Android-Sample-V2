package com.contusfly.call.groupcall.helpers

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuInflater
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.contus.call.CallActions
import com.contus.call.CallConstants.CALL_UI
import com.contus.call.CallConstants.JOIN_CALL
import com.contus.call.CallGridSpacingItemDecoration
import com.contus.call.SpeakingIndicatorListener
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.call.groupcall.GroupCallGridAdapter
import com.contusfly.call.groupcall.GroupCallListAdapter
import com.contusfly.call.groupcall.getCallConnectedStatus
import com.contusfly.call.groupcall.getEndCallerJid
import com.contusfly.call.groupcall.getUserAvailableForReconnection
import com.contusfly.call.groupcall.isAudioCall
import com.contusfly.call.groupcall.isCallNotConnected
import com.contusfly.call.groupcall.isInPIPMode
import com.contusfly.call.groupcall.isNull
import com.contusfly.call.groupcall.isOutgoingCall
import com.contusfly.call.groupcall.isUserAudioMuted
import com.contusfly.call.groupcall.isUserVideoMuted
import com.contusfly.call.groupcall.isVideoCall
import com.contusfly.call.groupcall.isVideoCallUICanShow
import com.contusfly.call.groupcall.listeners.ActivityOnClickListener
import com.contusfly.call.groupcall.listeners.BaseViewOnClickListener
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.call.groupcall.utils.UserMuteStatus
import com.contusfly.databinding.LayoutCallConnectedBinding
import com.contusfly.gone
import com.contusfly.hide
import com.contusfly.isValidIndex
import com.contusfly.loadUserProfileImage
import com.contusfly.makeViewsGone
import com.contusfly.runOnUiThread
import com.contusfly.show
import com.contusfly.showViews
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils.getLocalUserJid
import com.mirrorflysdk.flycall.webrtc.CallLogger
import com.mirrorflysdk.flycall.webrtc.CallStatus
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycall.webrtc.api.ConnectionQuality
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.ChatUtils
import com.mirrorflysdk.utils.Utils
import kotlinx.android.synthetic.main.layout_call_connected.view.local_profile_image
import org.webrtc.RendererCommon
import java.util.Collections
import java.util.concurrent.atomic.AtomicBoolean

class CallConnectedViewHelper(
    private val binding: LayoutCallConnectedBinding,
    private val activity: AppCompatActivity,
    private val callUsersListAdapter: GroupCallListAdapter,
    private val callUserGridAdapter: GroupCallGridAdapter,
    private val activityOnClickListener: ActivityOnClickListener,
    private val baseViewOnClickListener: BaseViewOnClickListener
) : View.OnClickListener {

    /**
     * boolean value indicates whether the video views initialized or not .
     */
    private var isVideoViewsInitialized: AtomicBoolean = AtomicBoolean(false)

    // True if local view is in the fullscreen renderer.
    private var isSwappedFeeds = false

    private val scrollDelayHandler = Handler(Looper.getMainLooper())


    init {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallConnectedViewHelper init")
        binding.imageAddUsers.setOnClickListener(this)
        binding.viewVideoLocal.setOnClickListener(this)
        binding.imageMenuSwitchCallView.setOnClickListener(this)
        binding.imageUnpin.setOnClickListener(this)

        binding.callGridUsersRecyclerview.setOnTouchListener { _, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                baseViewOnClickListener.animateCallOptionsView()
            }
            false
        }

        //Fix for List view shown when call converted into one to one call
        binding.callUsersRecyclerview.setOnTouchListener { _, motionEvent ->
            CallManager.isOneToOneCall() || motionEvent.pointerCount > 1
        }

        binding.callUsersRecyclerview.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    scrollDelayHandler.postDelayed({
                        CallUtils.setIsTileViewScrolling(false)
                        // Now safe to update views
                    }, 1000)  // 1 second delay

                } else {
                    CallUtils.setIsTileViewScrolling(true)
                    scrollDelayHandler.removeCallbacksAndMessages(null)  // Cancel any pending reset

                }
            }
        })

        //Fix for Local view shown when call converted into one to many call
        binding.viewVideoLocal.setOnTouchListener { _, _ ->
            !CallManager.isOneToOneCall()
        }

        initGridAdapter()
        initListAdapter()

    }

    private fun handleLocalVideoViewClicked() {
        LogMessage.d(TAG, "$CALL_UI handleLocalVideoViewClicked")
        if (!GroupCallUtils.isSingleUserInCall() && CallManager.isCallConnected()) {
            val endCallerJid = CallManager.getEndCallerJid()
            val isRemoteVideoPaused = CallManager.isRemoteVideoPaused(endCallerJid)
            val isRemoteVideoMuted = CallManager.isRemoteVideoMuted(endCallerJid)
            LogMessage.d(TAG, "$CALL_UI onSwapVideo getEndCallerJid: $endCallerJid ")
            LogMessage.d(TAG, "$CALL_UI onSwapVideo isRemoteVideoPaused: $isRemoteVideoPaused ")
            LogMessage.d(TAG, "$CALL_UI onSwapVideo isRemoteVideoMuted: $isRemoteVideoMuted ")
            LogMessage.d(TAG, "$CALL_UI onSwapVideo isLocalUsercallStatus: ${CallManager.getCallStatus(getLocalUserJid())} ")
            LogMessage.d(TAG, "$CALL_UI onSwapVideo isremoteUsercallStatus: ${CallManager.getCallStatus(CallUtils.getPinnedUserJid())} ")
            if (CallManager.isOneToOneCall() && !(isRemoteVideoPaused || isRemoteVideoMuted) && CallManager.getCallStatus(getLocalUserJid()) != CallStatus.RECONNECTING && CallManager.getCallStatus(CallUtils.getPinnedUserJid()) != CallStatus.RECONNECTING) {
                setSwappedFeeds(!isSwappedFeeds)
            }

        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.image_add_users -> {
                activityOnClickListener.addUsersInCall()
            }
            R.id.view_video_local -> handleLocalVideoViewClicked()

            R.id.image_menu_switch_call_view -> {
                if (!baseViewOnClickListener.isAnimationStarted()) { // if i click the 3 dot menu while layout animation to up/down, menu only showing but layout moved up. So prevent that issue, we made a condition like this
                    baseViewOnClickListener.disableCallOptionAnimation()
                    showMenuPopUp(view)
                }
            }
            R.id.image_unpin -> baseViewOnClickListener.pinnedUserRemoved()
        }
    }

    /**
     * This method will initiate Grid adapter and it's recycler view
     */
    private fun initGridAdapter() {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallConnectedViewHelper initGridAdapter")
        setupUserListForGridAdapter()

        binding.callGridUsersRecyclerview.apply {
            setHasFixedSize(true)
            val gridLayoutManager = GridLayoutManager(activity, 2)
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (position) {
                        0, 1 -> if (callUserGridAdapter.gridCallUserList.size <= 2) 2 else 1
                        else -> 1
                    }
                }
            }
            layoutManager = gridLayoutManager
            adapter = callUserGridAdapter
            itemAnimator = null
            addItemDecoration(CallGridSpacingItemDecoration(activity))
        }
    }

    private fun setupUserListForGridAdapter(){
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallConnectedViewHelper initGridAdapter")
        val userList = ArrayList<String>()
        for (userJid in CallManager.getCallUsersList()) {
            if (!callUserGridAdapter.gridCallUserList.contains(userJid)) {
                userList.add(userJid)
            }
        }
        if (!callUserGridAdapter.gridCallUserList.contains(CallManager.getCurrentUserId())) {
            userList.add(CallManager.getCurrentUserId())
        }
        if (userList.isNotEmpty()) {
            callUserGridAdapter.addUsers(userList)
        }
    }

    /**
     * This method will initiate List adapter and it's recycler view
     */
    private fun initListAdapter() {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallConnectedViewHelper initListAdapter")
        setupUserListForListAdapter()
        binding.callUsersRecyclerview.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = callUsersListAdapter
            itemAnimator = null
        }
    }

    fun setupUserListForListAdapter(){
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallConnectedViewHelper setupUserListForListAdapter")
        val userList = ArrayList<String>()
        for (userJid in CallManager.getCallUsersList()) {
            if (CallUtils.getPinnedUserJid().isBlank() && userJid != CallManager.getCurrentUserId()){
                LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallConnectedViewHelper setPinnedUserJid userJid: $userJid")
                CallUtils.setIsUserTilePinned(true)
                CallLogger.callTestingLog("UIKIT---> setupUserListForListAdapter setPinnedUserJid $userJid")
                CallUtils.setPinnedUserJid(userJid)
            }
            if (!callUsersListAdapter.callUserList.contains(userJid)) {
                userList.add(userJid)
            }
        }
        userList.remove(CallUtils.getPinnedUserJid())
        if (userList.isNotEmpty()) {
            callUsersListAdapter.addUsers(userList)
        }
    }

    fun setUpCallUI(isLocalTrackAddedFromSwitchRequest: Boolean) {
        val isCallNotConnected = CallManager.isCallNotConnected()
        CallLogger.callTestingLog("#CallConnectedViewHelper setUpCallUI received isCallNotConnected: $isCallNotConnected CallManager_isConnect: ${CallManager.isCallConnected()} CallManager_isAnswer: ${CallManager.isCallAnswered()}")
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL CallConnectedViewHelper setUpCallUI() isCallNotConnected: $isCallNotConnected"
        )
        initLocalVideoViews(isLocalTrackAddedFromSwitchRequest)
        if (isCallNotConnected)
            setUpCallNotConnected()
        else
            setUpConnectedCallView()
    }

    /**
     * Here all the video views are initializing
     */
    private fun initLocalVideoViews(isLocalTrackAddedFromSwitchRequest: Boolean = false) {
        // re-initiating video views will causes {@link IllegalStateException},
        //so this flag is checked before initializing video views
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL CallConnectedViewHelper initLocalVideoViews() isVideoViewsInitialized: $isVideoViewsInitialized"
        )
        try{
            if (isVideoViewsInitialized.compareAndSet(false, true)) {
                LogMessage.d(TAG, "$CALL_UI CallConnectedViewHelper initVideoViews()")
                runOnUiThread {
                    binding.viewVideoLocal.init(CallManager.getRootEglBase()?.eglBaseContext, null)
                }

                binding.viewVideoLocal.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL)
                /* setting Target SurfaceViews to VideoSinks  */
                CallManager.getLocalProxyVideoSink()?.setTarget(binding.viewVideoLocal)
                binding.viewVideoLocal.setMirror(true)
                binding.viewVideoLocal.scaleX = 1.0f

                runOnUiThread {
                    binding.viewVideoPinned.init(CallManager.getRootEglBase()?.eglBaseContext, null)
                }

                binding.viewVideoPinned.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL)
            } else if(isLocalTrackAddedFromSwitchRequest && CallUtils.getIsBackCameraCapturing()) {
                baseViewOnClickListener.onConversionRequestAcceptSwapVideo()
            }
        } catch (exception:Exception) {
            exception.printStackTrace()
        }
    }

    fun checkAndShowLocalVideoView() {
        LogMessage.d(TAG, "$CALL_UI ${com.mirrorflysdk.flycall.call.utils.JOIN_CALL} checkAndShowLocalVideoView  isVideoMuted() : ${CallManager.isVideoMuted()}")
        if (GroupCallUtils.isSingleUserInCall()) {
            binding.layoutOneToOneAudioCall.show()
            binding.viewVideoPinned.hide()
            if (CallManager.isVideoMuted()) {
                binding.viewVideoLocal.gone()
                updateLocalUserImage()
            } else {
                //video enabled
                binding.viewVideoLocal.show()
                setSwappedFeeds(isSwappedFeeds) // Set target for surface view
            }
        } else if (CallManager.isOneToOneCall()) {
            updateLocalVideoView()
        } else {
            CallLogger.callTestingLog("UIKIT---> checkAndShowLocalVideoView userJid: ${CallManager.getCurrentUserId()} pinnedUserJid: ${CallUtils.getPinnedUserJid()}")
            // Since local user will be removed from list view for one to one call,
            // we must add local user to list view for group call
            if (CallUtils.getPinnedUserJid() != CallManager.getCurrentUserId()
                && !callUsersListAdapter.callUserList.contains(CallManager.getCurrentUserId())
            ) callUsersListAdapter.addUser(CallManager.getCurrentUserId())
            binding.viewVideoLocal.gone()
            baseViewOnClickListener.onCallOptionsVisible()
        }
    }

    private fun updateLocalVideoView(){
        // if local user available in list view then list view item will be refreshed
        // and local user view will not updated, so it is one to one call then remove local user from list view
        callUsersListAdapter.removeUser(CallManager.getCurrentUserId())
        if(!CallManager.isCallConnected() && (CallManager.isOutgoingCall() && CallManager.isVideoCall())) {
            if(CallManager.isVideoMuted()) binding.viewVideoLocal.gone() else binding.viewVideoLocal.show()
        } else if (CallManager.isVideoMuted() && (CallManager.isCallConnected() || CallManager.isAudioCall())) {
            binding.viewVideoLocal.gone()
            if(CallManager.isCallConnected()) binding.localProfileImage.show()
            setSwappedFeeds(false)
        } else {
            binding.viewVideoLocal.show()
            setSwappedFeeds(isSwappedFeeds) // Set target for surface view
        }
    }

    private fun setUpCallNotConnected() {
        val isVideoCall = CallManager.isVideoCall()
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL CallConnectedViewHelper setUpCallNotConnected isVideoCall: $isVideoCall"
        )
        if (isVideoCall) {
            binding.layoutCallDetails.show()
            makeViewsGone(
                binding.layoutTitle, binding.layoutProfile, binding.imageAudioMutedForVideoCall,
                binding.textCallStatus, binding.textCallDuration, binding.backgroundView,
                binding.callGridUsersRecyclerview, binding.gridBackgroundView,
                binding.callUsersRecyclerview, binding.imageUnpin
            )
            binding.layoutOneToOneAudioCall.local_profile_image.hide()
            binding.layoutOneToOneAudioCall.show()
            binding.viewVideoLocal.show()
        } else
            hideConnectedView()
    }

    private fun hideViewsForGridDisabled() {
        LogMessage.i(
            TAG,
            "$CALL_UI CallConnectedViewHelper setUpConnectedCallView() hideViewsForGridDisabled"
        )
        CallLogger.callTestingLog("UIKIT---> hideViewsForGridDisabled->binding.layoutTitle visibility VISIBLE")
        showViews(
            binding.layoutTitle, binding.layoutProfile, binding.imageAudioMutedForVideoCall,
            binding.textCallDuration,
            binding.backgroundView,
            binding.imageUnpin,
            binding.layoutProfile,
            binding.videoRenderingProfileImage,binding.callerProfileImage

        )
        makeViewsGone(binding.callGridUsersRecyclerview, binding.gridBackgroundView)
    }

    private fun setUpConnectedCallView() {
        LogMessage.i(TAG, "$CALL_UI CallConnectedViewHelper setUpConnectedCallView() ")
        binding.layoutCallDetails.show()

        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_USER_PROFILE, 1)
        bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)
        bundle.putInt(CallActions.NOTIFY_CONNECT_TO_SINK, 1)
        bundle.putInt(CallActions.NOTIFY_PINNED_USER_VIEW, 1)
        bundle.putInt(CallActions.NOTIFY_VIEW_SIZE_UPDATED, 1)
        bundle.putInt(CallActions.NOTIFY_USER_POOR_CONNECTION, 1)

        if (CallUtils.getIsGridViewEnabled()) {
            LogMessage.i(
                TAG,
                "$CALL_UI CallConnectedViewHelper setUpConnectedCallView() GridViewEnabled"
            )
            baseViewOnClickListener.showGridTitle() //switched to grid view and click on gridview to hide the title & duration and then go to pipmode, now maximize the pipmode, observes gridview overlap on the title & duration issue fixes.
            checkAndHideListViewVideoSurfaceViews()
            makeViewsGone(
                binding.imageAudioMutedForVideoCall,
                binding.textCallStatus,
                binding.backgroundView,
                binding.viewVideoLocal,
                binding.layoutOneToOneAudioCall,
                binding.callUsersRecyclerview,
                binding.viewVideoPinned,
                binding.imageUnpin,
                binding.layoutProfile,
                binding.videoRenderingProfileImage,
                binding.callerProfileImage
            )
            CallLogger.callTestingLog("UIKIT---> setUpConnectedCallView ->binding.layoutTitle visibility VISIBLE")
            showViews(
                binding.callGridUsersRecyclerview, binding.layoutTitle,
                binding.textCallDuration, binding.gridBackgroundView
            )
            callUserGridAdapter.notifyItemRangeChanged(
                0,
                callUserGridAdapter.gridCallUserList.size,
                bundle
            ) // Set target for surface view
        } else {
            LogMessage.i(
                TAG,
                "$CALL_UI CallConnectedViewHelper setUpConnectedCallView() GridView disabled"
            )
            checkAndHideGridViewVideoSurfaceViews()
            hideViewsForGridDisabled()

            if (GroupCallUtils.isSingleUserInCall()) {
                setUpSingleUserInMeetCall()
            } else if (CallManager.isOneToOneCall()) {
                setUpOneToOneCallView()
            } else {
                LogMessage.i(TAG, "$CALL_UI CallConnectedViewHelper user list more than 2")
                binding.layoutOneToOneAudioCall.gone()
                binding.singleUserViewSpeakingIndicatorHelper.gone()
                updatePinnedUserIcon(CallUtils.getPinnedUserJid())
                showViews(binding.callUsersRecyclerview)
                CallLogger.callTestingLog("UIKIT--->setUpConnectedCallView callUserListSize : ${ callUsersListAdapter.callUserList.size}")
                callUsersListAdapter.notifyItemRangeChanged(
                    0,
                    callUsersListAdapter.callUserList.size,
                    bundle
                ) // Set target for surface view
            }
            updatePinnedUserVideoMuteStatus()
            checkAndShowLocalVideoView()
            checkAndShowPoorConnectionQuality()
            updateCallStatus()
        }
        updateRemoteAudioMuteStatus()
        checkAddParticipantsAvailable()
        checkAndUpdateConnectedUserAsPinnedUser()
        updateCallMemberDetails(CallManager.getCallUsersList())
    }

    private fun checkAndHideListViewVideoSurfaceViews() {
        callUsersListAdapter.hideUserSurfaceView()
    }

    private fun checkAndHideGridViewVideoSurfaceViews() {
        if (callUserGridAdapter.gridCallUserList.size == 2) {
            callUserGridAdapter.hideUserSurfaceView()
        }
    }

    private fun checkAndUpdateConnectedUserAsPinnedUser() {
        if (!CallManager.isOneToOneCall()) {
            val userList = CallManager.getCallConnectedUsersList()
            if (userList.isNotEmpty() && CallUtils.getPinnedUserJid()
                    .isNotBlank() && CallManager.getCallStatus(CallUtils.getPinnedUserJid()) !in arrayOf(
                    CallStatus.CONNECTED,
                    CallStatus.CONNECTING,
                    CallStatus.ON_HOLD,
                    CallStatus.RECONNECTING
                )
            ) {
                val userJid = userList.first()
                pinnedUserChanged(userJid, true)
            }
        }
    }

    /**
     * Hide views when single user present in call
     */
    private fun showViewsForOneToOneCall() {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL showViewsForOneToOneCall:")
        makeViewsGone(binding.callUsersRecyclerview, binding.imageUnpin)
        if (CallManager.isVideoCall()) {
            binding.layoutOneToOneAudioCall.local_profile_image.hide()
        } else {
            binding.layoutOneToOneAudioCall.local_profile_image.show()
        }
        binding.layoutOneToOneAudioCall.show()
    }

    private fun setUpSingleUserInMeetCall() {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL setUpSingleUserInMeetCall:")
        showViewsForOneToOneCall()
        binding.layoutProfile.hide()
        binding.textCallStatus.gone()
        binding.viewVideoPinned.hide()
        binding.singleUserViewSpeakingIndicatorHelper.show()
        if (GroupCallUtils.isVideoMuted()) {
            LogMessage.d(TAG, "$CALL_UI $JOIN_CALL videoMuted in single user call")
            binding.viewVideoLocal.hide()
        } else {
            LogMessage.d(TAG, "$CALL_UI $JOIN_CALL videoUnMuted in single user call")
            binding.viewVideoLocal.show()
        }
    }

    private fun setUpOneToOneCallView() {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL setUpOneToOneCallView:")
        showViewsForOneToOneCall()
        binding.singleUserViewSpeakingIndicatorHelper.gone()
        val endCallerJid = CallManager.getEndCallerJid()
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL setUpOneToOneCallView: endCallerJid:$endCallerJid ")
        if (endCallerJid.isNotEmpty() && !CallManager.isRemoteVideoMuted(endCallerJid)) {
            LogMessage.d(TAG, "$CALL_UI $JOIN_CALL setUpOneToOneCallView:  isRemoteVideo Visible")
            binding.layoutProfile.hide()
            binding.textCallStatus.gone()
            binding.viewVideoPinned.show()
            if (!CallManager.getUserAvailableForReconnection(endCallerJid)) {
                LogMessage.d(TAG, "$CALL_UI $JOIN_CALL setUpOneToOneCallView:  status update")
                updateCallStatus()
            } else {
                LogMessage.d(
                    TAG,
                    "$CALL_UI $JOIN_CALL setUpOneToOneCallView:  enableCallOptionAnimation"
                )
                baseViewOnClickListener.enableCallOptionAnimation()
            }
        } else {
            LogMessage.d(TAG, "$CALL_UI $JOIN_CALL setUpOneToOneCallView: show layoutProfile")
            showViews(binding.layoutProfile)
            binding.viewVideoPinned.gone()
        }
    }

    private fun updateCallerImageWhenProfileEmpty(userMobileNumber:String){
        if(BuildConfig.CONTACT_SYNC_ENABLED) {
            binding.callerProfileImage.setImageResource(R.drawable.ic_profile)
            binding.videoRenderingProfileImage.setImageResource(R.drawable.ic_profile)
        } else {
            val setDrawable = SetDrawable(activity)
            val icon = setDrawable.setDrawableForProfile(userMobileNumber)
            binding.callerProfileImage.setImageDrawable(icon)
            binding.videoRenderingProfileImage.setImageDrawable(icon)
        }
    }

    fun updateLocalUserImage(){
        binding.layoutOneToOneAudioCall.local_profile_image.show()
        LogMessage.d(TAG, "updateLocalUserImage: ")
        val userName =
            Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME))
        MediaUtils.loadImageWithGlideSecure(
            activity,
            SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
            binding.localProfileImage,
            SetDrawable(activity).setDrawableForProfile(userName)
        )
    }

    /**
     * This method is getting the caller name and profile picture
     *
     * @param callUsers list of Users in Call
     */
    fun updateCallMemberDetails(callUsers: ArrayList<String>) {
        var name = ""
        val isCallOneToOne = CallManager.isOneToOneCall()
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL userUpdatedHisProfile updateCallMemberDetails:  callUsers:$callUsers isCallOneToOne: $isCallOneToOne"
        )
        if (isCallOneToOne) {
            val endCallerJid = CallManager.getEndCallerJid();
            val profileDetails = if (endCallerJid.contains("@"))
                ProfileDetailsUtils.getProfileDetails(endCallerJid)
            else null
            profileDetails?.let {
                try {
                    binding.callerProfileImage.loadUserProfileImage(activity, profileDetails)
                    binding.videoRenderingProfileImage.loadUserProfileImage(activity, profileDetails)
                } catch(e: Exception) {
                    LogMessage.e(TAG,"Call image loadException : $e")
                }
                val jidList = ArrayList<String>()
                jidList.add(profileDetails.jid)
                name = CallUtils.getGroupMembersName(jidList, CallManager.getGroupID())
            }
            LogMessage.d(
                TAG,
                "$CALL_UI $JOIN_CALL userUpdatedHisProfile updateCallMemberDetails isCallOneToOne getProfile profileDetails: $profileDetails"
            )
            if(profileDetails.isNull()){
                updateCallerImageWhenProfileEmpty(ChatUtils.getUserFromJid(endCallerJid))
                val jidList = ArrayList<String>()
                jidList.add(endCallerJid)
                name = CallUtils.getGroupMembersName(jidList, CallManager.getGroupID())
                LogMessage.d(
                    TAG,
                    "$CALL_UI $JOIN_CALL userUpdatedHisProfile unknown user name: $name"
                )
            }

            if (!CallManager.isVideoCallUICanShow()) {
                LogMessage.d(
                    TAG,
                    "$CALL_UI $JOIN_CALL userUpdatedHisProfile isCallOneToOne updateCallMemberDetails video ui disabled!! "
                )
                updateLocalUserImage()
            }
        } else {
            name = CallUtils.getGroupMembersName(callUsers, CallManager.getGroupID())
            updatePinnedUserProfile()
        }
        if(GroupCallUtils.isSingleUserInCall()){
            LogMessage.d(
                TAG,
                "$CALL_UI $JOIN_CALL userUpdatedHisProfile single user in call so name set to You!!"
            )
            name = "You"
        }
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL userUpdatedHisProfile getProfile name: $name")
        binding.textCallUsers.text = name
    }

    fun updateCallDuration(callDuration: String) {
        binding.textCallDuration.text = callDuration
    }

    fun hideTextCallDuration() {
        CallLogger.callTestingLog("UIKIT---> binding.textCallDuration visibility GONE")
        binding.textCallDuration.visibility = View.GONE
    }

    fun hideConnectedView() {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallConnectedViewHelper hideConnectedView ")
        binding.layoutCallDetails.gone()
        binding.viewVideoPinned.gone()
        binding.callGridUsersRecyclerview.gone()
        binding.callUsersRecyclerview.gone()
    }

    fun checkAddParticipantsAvailable() {
        LogMessage.d(TAG, "$CALL_UI CallConnectedViewHelper checkAddParticipantsAvailable()")
        if (ChatManager.getAvailableFeatures().isGroupCallEnabled && (CallManager.isCallConnected() || GroupCallUtils.isSingleUserInCall()) && !activity.isInPIPMode()) binding.imageAddUsers.show()
        else binding.imageAddUsers.gone()
    }

    @SuppressLint("RestrictedApi")
    private fun showMenuPopUp(view: View) {
        val menuBuilder = MenuBuilder(activity)
        val inflater = MenuInflater(activity)
        inflater.inflate(R.menu.menu_switch_call_view, menuBuilder)
        val optionsMenu = MenuPopupHelper(activity, menuBuilder, view)
        optionsMenu.setForceShowIcon(true)

        if (GroupCallUtils.isSingleUserInCall()) {
            menuBuilder.getItem(0).hide()
            menuBuilder.getItem(1).hide()
        } else if (CallUtils.getIsGridViewEnabled()) {
            menuBuilder.getItem(0).hide()
            menuBuilder.getItem(1).show()
        } else {
            menuBuilder.getItem(0).show()
            menuBuilder.getItem(1).hide()
        }

        menuBuilder.setCallback(object : MenuBuilder.Callback {
            override fun onMenuItemSelected(menu: MenuBuilder, item: MenuItem): Boolean {
                return when (item.itemId) {
                    R.id.grid_view -> {
                        activityOnClickListener.switchToGridView()
                        true
                    }

                    R.id.tile_view -> {
                        activityOnClickListener.switchToTileView()
                        true
                    }

                    else -> false
                }
            }

            override fun onMenuModeChange(menu: MenuBuilder) {
                //Not Needed
            }
        })
        optionsMenu.setOnDismissListener {
            baseViewOnClickListener.enableCallOptionAnimation()
        }
        optionsMenu.show()
    }

    fun updateCallStatus() {
        val pinnedUser = CallUtils.getPinnedUserJid()
        val connectedStatus = if (CallManager.isOneToOneCall()) {
            CallManager.getCallConnectedStatus(activity)
        } else {
            CallManager.getCallStatus(pinnedUser)
        }
        val pinnedUserStatus = CallManager.getCallStatus(pinnedUser)
        val pinnedUserNotConnected = pinnedUserStatus in listOf(CallStatus.CALLING, CallStatus.RINGING)

        LogMessage.d(TAG, "$CALL_UI updateCallStatus connectedStatus: $connectedStatus Jid == $pinnedUser pinnedUserStatus:$pinnedUserStatus")
        LogMessage.d(TAG, "$CALL_UI updateCallStatus pinnedUserNotConnected: $pinnedUserNotConnected")

        if (shouldShowCallStatus(connectedStatus, pinnedUserNotConnected)) {
            handleCallStatusForSingleUser(connectedStatus)
            handleCallStatusForGroupCall(connectedStatus, pinnedUserNotConnected, pinnedUserStatus)
        } else {
            hideCallStatusViews()
        }
    }

    private fun shouldShowCallStatus(connectedStatus: String, pinnedUserNotConnected: Boolean): Boolean {
        return connectedStatus in listOf(
            CallStatus.ON_HOLD, CallStatus.RECONNECTING,
            activity.getString(com.contus.call.R.string.reconnecting)
        ) || pinnedUserNotConnected
    }

    private fun handleCallStatusForSingleUser(connectedStatus: String) {
        if (GroupCallUtils.isSingleUserInCall()) {
            binding.layoutTitle.show()
            binding.textCallStatus.hide()
            if (connectedStatus == CallStatus.RECONNECTING || connectedStatus == activity.getString(com.contus.call.R.string.reconnecting)) {
                binding.singleUserTextCallStatus.text =
                    activity.getString(com.contus.call.R.string.reconnecting)
                binding.singleUserTextCallStatus.visibility = View.VISIBLE
                LogMessage.d(TAG, "$CALL_UI Call Status RECONNECTING single user")
            } else {
                binding.singleUserTextCallStatus.visibility = View.GONE
            }
        }
    }

    private fun handleCallStatusForGroupCall(
        connectedStatus: String,
        pinnedUserNotConnected: Boolean,
        pinnedUserStatus: String
    ) {
        if (!GroupCallUtils.isSingleUserInCall()) {
            binding.layoutTitle.show()
            binding.singleUserTextCallStatus.visibility = View.GONE
            binding.textCallStatus.show()
            binding.textCallStatus.text = if (connectedStatus == CallStatus.RECONNECTING) {
                activity.getString(com.contus.call.R.string.reconnecting)
            } else {
                connectedStatus
            }
            if (pinnedUserNotConnected) {
                binding.textCallStatus.text = pinnedUserStatus
            }
        }
    }

    private fun hideCallStatusViews() {
        binding.textCallStatus.gone()
        binding.singleUserTextCallStatus.visibility = View.GONE
    }

    /*
    * This method will determine whether audio mute icon need to be shown or not and
    * whether it should show on profile picture or center of the screen
    */
    fun updateRemoteAudioMuteStatus() {
        LogMessage.i(TAG, "$CALL_UI CallConnectedViewHelper updateRemoteAudioMuteStatus")
        if (CallUtils.getIsGridViewEnabled())
            binding.imageAudioMutedForVideoCall.gone()
        else {
            val userMuteStatus = UserMuteStatus(
                CallManager.isUserVideoMuted(CallUtils.getPinnedUserJid()),
                CallManager.isUserAudioMuted(CallUtils.getPinnedUserJid())
            )

            if (userMuteStatus.isVideoMuted) {
                binding.imageAudioMutedForVideoCall.gone()
                if (userMuteStatus.isAudioMuted) binding.imageAudioMuted.show() else binding.imageAudioMuted.gone()
            } else {
                binding.imageAudioMuted.gone()
                updateAudioMuteStatusForLocalAndRemote(userMuteStatus)
            }
        }
    }
    private fun updateAudioMuteStatusForLocalAndRemote(userMuteStatus:UserMuteStatus){
        if (isSwappedFeeds) {
            if (CallManager.isAudioMuted())
                binding.imageAudioMutedForVideoCall.show()
            else
                binding.imageAudioMutedForVideoCall.hide()

            if (userMuteStatus.isAudioMuted)
                binding.imageAudioMutedLocalUserTile.show()
            else
                binding.imageAudioMutedLocalUserTile.hide()
        } else {
            if (userMuteStatus.isAudioMuted) binding.imageAudioMutedForVideoCall.show() else binding.imageAudioMutedForVideoCall.hide()
        }
    }

    /**
     * Here handling the video swap
     */
    private fun setSwappedFeeds(isSwappedFeeds: Boolean) {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL setSwappedFeeds() isSwappedFeeds -> $isSwappedFeeds")

        if (CallManager.isOneToOneCall()) {
            this.isSwappedFeeds = isSwappedFeeds
            if (isSwappedFeeds) {
                CallManager.getRemoteProxyVideoSink(CallUtils.getPinnedUserJid())
                    ?.setTarget(binding.viewVideoLocal)
                CallManager.getLocalProxyVideoSink()?.setTarget(binding.viewVideoPinned)
                binding.viewVideoLocal.setMirror(false)
                /* we don't need mirror view for back camera */
                binding.viewVideoPinned.setMirror(!CallUtils.getIsBackCameraCapturing())
                binding.viewVideoLocal.scaleX = 1.0f
                binding.localTileViewUserName.text = ProfileDetailsUtils.getDisplayName(CallManager.getEndCallerJid())
                updateAudioMuteStatusWhileSwapFeedsTrue()

            } else {
                CallManager.getLocalProxyVideoSink()?.setTarget(binding.viewVideoLocal)
                CallManager.getRemoteProxyVideoSink(CallUtils.getPinnedUserJid())
                    ?.setTarget(binding.viewVideoPinned)
                binding.viewVideoPinned.setMirror(false)
                /* we don't need mirror view for back camera */
                binding.viewVideoLocal.setMirror(!CallUtils.getIsBackCameraCapturing())
                if (!CallUtils.getIsBackCameraCapturing()) {
                    binding.viewVideoLocal.scaleX = 1.0f
                }
                binding.localTileViewUserName.text = Constants.YOU
                updateLocalUserImage()
                updateAudioMuteStatusWhileSwapFeedFalse()
            }
        }
    }

    private fun updateAudioMuteStatusWhileSwapFeedsTrue(){
        if (CallManager.isAudioMuted())
            binding.imageAudioMutedForVideoCall.show()
        else
            binding.imageAudioMutedForVideoCall.hide()

        if (CallManager.isRemoteAudioMuted(CallManager.getEndCallerJid()))
            binding.imageAudioMutedLocalUserTile.show()
        else
            binding.imageAudioMutedLocalUserTile.hide()
    }

    private fun updateAudioMuteStatusWhileSwapFeedFalse(){
        if (CallManager.isRemoteAudioMuted(CallManager.getEndCallerJid())){
            binding.imageAudioMutedForVideoCall.show()
        }else{
            binding.imageAudioMutedForVideoCall.hide()
        }

        if(CallManager.isAudioMuted())
            binding.imageAudioMutedLocalUserTile.show()
        else
            binding.imageAudioMutedLocalUserTile.hide()
    }

    /**
     * Set mirror view to the adapter In case local video swapped with remote video view
     */
    fun setMirrorLocalView() {
        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_LOCAL_VIEW_MIRROR, 1)

        if (CallUtils.getIsGridViewEnabled()) {
            LogMessage.d(TAG, "$CALL_UI setMirrorLocalView: remote grid view")
            val girdIndex =
                callUserGridAdapter.gridCallUserList.indexOf(CallManager.getCurrentUserId())
            if (girdIndex.isValidIndex()) {
                callUserGridAdapter.notifyItemChanged(girdIndex, bundle)
            }
        } else {
            if (CallManager.isOneToOneCall()) {
                LogMessage.d(
                    TAG,
                    "$CALL_UI setMirrorLocalView: isOneToOneCall: ${CallManager.isOneToOneCall()} isSwappedFeeds:${isSwappedFeeds}"
                )
                setSwappedFeeds(isSwappedFeeds)
            } else {
                LogMessage.d(TAG, "$CALL_UI setMirrorLocalView: remote list view")
                val index =
                    callUsersListAdapter.callUserList.indexOf(CallManager.getCurrentUserId())
                if (index.isValidIndex()) {
                    callUsersListAdapter.notifyItemChanged(index, bundle)
                }
            }
        }
    }

    fun onSwapVideo() {
        CallUtils.setIsBackCameraCapturing(!CallUtils.getIsBackCameraCapturing())
    }

    fun makeCallAgain() {
        binding.viewVideoLocal.release()
        binding.viewVideoPinned.release()
        isVideoViewsInitialized.compareAndSet(true, false)
    }

    fun onLocalVideoTrackAdded() {
        LogMessage.d(TAG, "$CALL_UI onLocalVideoTrackAdded()")
        initLocalVideoViews(true)
    }

    fun onVideoTrackAdded(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI onVideoTrackAdded for userJid: $userJid")
        val bundle = Bundle()
        bundle.putString(CallActions.NOTIFY_CONNECT_TO_SINK, userJid)
        bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)

        if (CallUtils.getIsGridViewEnabled()) {
            binding.callGridUsersRecyclerview.post {
                val index = callUserGridAdapter.gridCallUserList.indexOf(userJid)
                LogMessage.d(TAG, "$CALL_UI GridViewEnabled notifyItemChanged for userJid: $userJid index:$index")
                if (index.isValidIndex()) callUserGridAdapter.notifyItemChanged(index, bundle)
            }
        } else {
            if (CallUtils.getPinnedUserJid() == userJid) {
                LogMessage.d(TAG, "$CALL_UI PinnedUserJid updatePinnedUserVideo for userJid: $userJid")
                setSwappedFeeds(isSwappedFeeds)
                updatePinnedUserVideoMuteStatus()
            } else
                binding.callUsersRecyclerview.post {
                    val index = callUsersListAdapter.callUserList.indexOf(userJid)
                    LogMessage.d(TAG, "$CALL_UI ListItem notifyItemChanged for userJid: $userJid index:$index")
                    if (index.isValidIndex()) callUsersListAdapter.notifyItemChanged(index, bundle)
                }
        }
    }

    fun updatePinnedUserIcon(userJid: String = Constants.EMPTY_STRING) {
        if (CallUtils.getIsUserTilePinned() && userJid == CallUtils.getPinnedUserJid())
            binding.imageUnpin.setImageDrawable(
                ContextCompat.getDrawable(
                    activity,
                    R.drawable.ic_tile_pinned_icon
                )
            )
        else
            binding.imageUnpin.setImageDrawable(
                ContextCompat.getDrawable(
                    activity,
                    R.drawable.ic_pin_tile
                )
            )
    }

    private fun hideOrShowLocalProfileImage(){
        if (CallManager.isVideoCall()) {
            binding.layoutOneToOneAudioCall.local_profile_image.hide()
        } else {
            binding.layoutOneToOneAudioCall.local_profile_image.show()
        }
    }

    fun updatePinnedUserVideoMuteStatus() {
        LogMessage.i(
            TAG,
            "$CALL_UI $JOIN_CALL CallConnectedViewHelper updatePinnedUserVideoMuteStatus isSwappedFeeds:$isSwappedFeeds"
        )

        when {
            GroupCallUtils.isSingleUserInCall() -> handleSingleUserInCall()
            CallUtils.getIsGridViewEnabled() -> makeViewsGone(binding.layoutProfile, binding.textCallStatus)
            else -> handleNormalCall()
        }

        updateCallStatus()
    }

    private fun handleSingleUserInCall() {
        LogMessage.i(
            TAG,
            "$CALL_UI $JOIN_CALL CallConnectedViewHelper just hide videoPinned SingleUserInCall"
        )
        binding.viewVideoPinned.gone()
        hideOrShowLocalProfileImage()
        binding.layoutOneToOneAudioCall.show()
    }

    private fun handleNormalCall() {
        if (isSwappedFeeds && CallManager.isOneToOneCall()) {
            // Restore swapped state if needed
            setSwappedFeeds(false)
        } else {
            isSwappedFeeds = false
            val videoSink = CallUtils.getPinnedVideoSink()

            if (!CallManager.isCallConnected() && CallManager.isOutgoingCall() && CallManager.isVideoCall()) {
                // Handle outgoing video call mute
                if (CallManager.isVideoMuted()) binding.viewVideoLocal.gone() else binding.viewVideoLocal.show()
            } else if (shouldHidePinnedVideo(videoSink)) {
                // Hide pinned video if muted or other conditions
                binding.viewVideoPinned.gone()
                showViews(binding.layoutProfile)
            } else {
                // Show pinned video
                makeViewsGone(binding.layoutProfile, binding.textCallStatus)
                binding.viewVideoPinned.show()
                videoSink?.setTarget(binding.viewVideoPinned)
                binding.viewVideoPinned.setMirror(
                    CallUtils.getPinnedUserJid() == CallManager.getCurrentUserId()
                            && !CallUtils.getIsBackCameraCapturing()
                )
            }
        }
    }

    private fun shouldHidePinnedVideo(videoSink: Any?): Boolean {
        return CallUtils.getPinnedUserVideoMuted() || videoSink == null
                || CallManager.isRemoteVideoPaused(CallUtils.getPinnedUserJid())
    }

    private fun updatePinnedUserPosition(isUserSpeaking: Boolean, userJid: String) {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL #gridPin updatePinnedUserPosition userJid:${userJid} isLocalUserPinned(): ${CallUtils.isLocalUserPinned()}")
        if (!isUserSpeaking || CallUtils.isLocalUserPinned()) { // Grid Swap not needed for speaking user
            val pinClickedUserPosition = callUserGridAdapter.gridCallUserList.indexOf(userJid)
            val positionToSwap = 0
            Collections.swap(
                callUserGridAdapter.gridCallUserList,
                pinClickedUserPosition,
                positionToSwap
            )
            if (CallUtils.getIsGridViewEnabled())
                callUserGridAdapter.notifyItemMoved(pinClickedUserPosition, positionToSwap)
        }
    }

    fun pinnedUserChanged(userJid: String, isUserSpeaking: Boolean = false) {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL pinnedUserChanged userJid:${userJid}")

        try {
            updatePinnedUserPosition(isUserSpeaking, userJid)
            if (CallUtils.getPinnedUserJid() != userJid) {
                val addIndex = callUsersListAdapter.callUserList.indexOf(userJid)
                CallUtils.getVideoSinkForUser(userJid)?.setTarget(null)
                CallUtils.getVideoSinkForUser(CallUtils.getPinnedUserJid())?.setTarget(null)
                CallLogger.callTestingLog("#callui UIKIT---> pinnedUserChanged setPinnedUserJid $userJid")
                val oldPinnedUserJid = CallUtils.getPinnedUserJid()
                CallUtils.setPinnedUserJid(userJid)
                callUsersListAdapter.swapPinnedUser(
                    userJid,
                    oldPinnedUserJid,
                    if (addIndex.isValidIndex() && CallUtils.getPinnedUserJid() != CallManager.getCurrentUserId()) addIndex else callUsersListAdapter.callUserList.size - 1
                )

            }
            Handler(Looper.getMainLooper()).postDelayed({handleUserSwappedUpdate()}, 500)

        } catch (e: Exception) {
            LogMessage.e(TAG, "$CALL_UI $e")
        }
    }
    private fun handleUserSwappedUpdate(){
        CallLogger.callTestingLog("#callui UIKIT---> pinnedUserChanged handleUserSwappedUpdate ${CallUtils.getIsViewUpdatesCompleted()}")
        if (CallUtils.getIsViewUpdatesCompleted()) {
            CallUtils.setIsViewUpdatesCompleted(false) //frequent speaking indicator animation shouldn't happen while switching view
            activityOnClickListener.resetViewsUpdatedFlag()
            val bundle = Bundle()
            bundle.putInt(CallActions.NOTIFY_USER_PROFILE, 1)
            bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)
            bundle.putInt(CallActions.NOTIFY_CONNECT_TO_SINK, 1)
            bundle.putInt(CallActions.NOTIFY_PINNED_USER_VIEW, 1)
            bundle.putInt(CallActions.NOTIFY_USER_POOR_CONNECTION, 1)
            bundle.putInt(CallActions.NOTIFY_VIEW_SIZE_UPDATED,1)
            if (CallUtils.getIsGridViewEnabled())
                callUserGridAdapter.notifyItemRangeChanged(
                    0,
                    callUserGridAdapter.gridCallUserList.size,
                    bundle
                )
            else {
                callUsersListAdapter.notifyItemRangeChanged(
                    0,
                    callUsersListAdapter.callUserList.size,
                    bundle
                )
                updateCallStatus()
            }
        }
        updatePinnedUserVideoMuteStatus()
        updateRemoteAudioMuteStatus()
        updateCallMemberDetails(CallManager.getCallUsersList())
    }

    fun pinnedUserLeft(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI pinnedUserLeft getCallUsersList:${CallManager.getCallUsersList()}")

        try {

            if (CallManager.getCallUsersList().size > 0) {
                LogMessage.d(TAG, "$CALL_UI pinnedUserLeft so setting new pin user")
                val newPinUser = CallManager.getCallUsersList().first()
                LogMessage.d(TAG, "$CALL_UI pinnedUserLeft so setting new pin user $newPinUser")
                CallUtils.setIsUserTilePinned(true)
                pinnedUserChanged(newPinUser)
            }
            callUsersListAdapter.removeUser(userJid)
            CallLogger.callTestingLog("UIKIT---> pinnedUserLeft setPinnedUserJid $userJid callerUserListSize: ${CallManager.getCallUsersList().size}")
            if(CallManager.getCallUsersList().size==0)
                CallUtils.setPinnedUserJid(Constants.EMPTY_STRING)
        } catch (e: Exception) {
            LogMessage.e(TAG, "$CALL_UI $e")
        }
    }

    private fun updatePinnedUserProfile() {
        LogMessage.d(
            TAG,
            "$CALL_UI updatePinnedUserProfile getPinnedUserJid: ${CallUtils.getPinnedUserJid()}"
        )
        if (CallUtils.getPinnedUserJid() == SharedPreferenceManager.getCurrentUserJid()) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(CallUtils.getPinnedUserJid())
            val setDrawable = SetDrawable(activity, profileDetails)
            val userName =
                Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME))
            val icon = setDrawable.setDrawableForProfile(userName)

            MediaUtils.loadImageWithGlideSecure(
                activity,
                SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
                binding.callerProfileImage,
                icon
            )

            MediaUtils.loadImageWithGlideSecure(
                activity,
                SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
                binding.videoRenderingProfileImage,
                icon
            )
        } else {
            binding.callerProfileImage.setImageDrawable(null)
            binding.videoRenderingProfileImage.setImageDrawable(null)
            if (CallUtils.getPinnedUserJid().isNotEmpty()) {
                val profileDetails =
                    ProfileDetailsUtils.getProfileDetails(CallUtils.getPinnedUserJid())
                if (profileDetails != null) {
                    binding.callerProfileImage.loadUserProfileImage(activity, profileDetails)
                    binding.videoRenderingProfileImage.loadUserProfileImage(activity, profileDetails)
                } else {
                    LogMessage.d(TAG, "updatePinnedUserProfile: pinned user not in contact details!!")
                    updateCallerImageWhenProfileEmpty(ChatUtils.getUserFromJid(CallUtils.getPinnedUserJid()))
                }
            } else {

                binding.callerProfileImage.setImageDrawable(
                    ContextCompat.getDrawable(
                        activity,
                        R.drawable.ic_profile))

                binding.videoRenderingProfileImage.setImageDrawable(
                    ContextCompat.getDrawable(
                        activity,
                        R.drawable.ic_profile))
            }

        }
    }

    fun ownAudioMuteStatusUpdated() {
        onUserStoppedSpeaking(CallManager.getCurrentUserId())
        if (CallUtils.getIsGridViewEnabled()) {
            val index = callUserGridAdapter.gridCallUserList.indexOf(CallManager.getCurrentUserId())
            if (index.isValidIndex()) {
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_VIEW_MUTE_UPDATED, 1)
                callUserGridAdapter.notifyItemChanged(index, bundle)
            }
        } else {
            if (CallUtils.getPinnedUserJid() == CallManager.getCurrentUserId())
                updateRemoteAudioMuteStatus()
            else {
                val index =
                    callUsersListAdapter.callUserList.indexOf(CallManager.getCurrentUserId())
                if (index.isValidIndex()) {
                    val bundle = Bundle()
                    bundle.putInt(CallActions.NOTIFY_VIEW_MUTE_UPDATED, 1)
                    callUsersListAdapter.notifyItemChanged(index, bundle)
                }
            }
        }
    }

    private fun updateAudioMuteStatusViewForCurrentUser(){
        if (isSwappedFeeds) {
            if (CallManager.isAudioMuted())
                binding.imageAudioMutedForVideoCall.show()
            else
                binding.imageAudioMutedForVideoCall.hide()
        } else {
            if (CallManager.isAudioMuted())
                binding.imageAudioMutedLocalUserTile.show()
            else
                binding.imageAudioMutedLocalUserTile.hide()
        }
    }

    fun onUserStoppedSpeaking(userJid: String) {
        if (CallUtils.getPinnedUserJid() == userJid && !isSwappedFeeds) {
            binding.rippleBg.onUserStoppedSpeaking()
        } else {
            if (CallManager.isOneToOneCall()) {
                binding.viewSpeakingIndicator.onUserStoppedSpeaking(object :
                    SpeakingIndicatorListener {
                    override fun onSpeakingIndicatorHidden() {
                        CallUtils.clearPeakSpeakingUser(userJid)
                    }
                })
            } else {
                val index = callUsersListAdapter.callUserList.indexOf(userJid)
                if (index.isValidIndex() && !CallUtils.getIsGridViewEnabled() && CallUtils.getIsViewUpdatesCompleted()) {
                    val bundle = Bundle()
                    bundle.putInt(CallActions.NOTIFY_USER_STOPPED_SPEAKING, 1)
                    callUsersListAdapter.notifyItemChanged(index, bundle)
                }
            }
        }

        val index = callUserGridAdapter.gridCallUserList.indexOf(userJid)
        if (index.isValidIndex() && CallUtils.getIsGridViewEnabled() && CallUtils.getIsViewUpdatesCompleted()) {
            val bundle = Bundle()
            bundle.putInt(CallActions.NOTIFY_USER_STOPPED_SPEAKING, 1)
            callUserGridAdapter.notifyItemChanged(index, bundle)
        }
    }

    fun onUserSpeaking(userJid: String, audioLevel: Int) {
        if (CallUtils.getPinnedUserJid() == userJid && !isSwappedFeeds) {
            binding.rippleBg.onUserSpeaking()
        } else {
            handleUserSpeakingOnNonPinnedUser(userJid,audioLevel)
        }

        val index = callUserGridAdapter.gridCallUserList.indexOf(userJid)
        if (index.isValidIndex() && CallUtils.getIsGridViewEnabled() && CallUtils.getIsViewUpdatesCompleted()) {
            val bundle = Bundle()
            bundle.putInt(CallActions.NOTIFY_USER_SPEAKING, audioLevel)
            callUserGridAdapter.notifyItemChanged(index, bundle)
        }
        if (CallUtils.isSpeakingUserCanBeShownOnTop(userJid, audioLevel)) {
            pinnedUserChanged(userJid, true)
        }
    }

    fun handleUserSpeakingOnNonPinnedUser(userJid: String, audioLevel: Int){
        if (CallManager.isOneToOneCall()) {
            if (isSwappedFeeds && userJid != CallManager.getCurrentUserId() || !isSwappedFeeds && userJid == CallManager.getCurrentUserId())
                binding.viewSpeakingIndicator.onUserSpeaking(audioLevel)
        } else {
            val index = callUsersListAdapter.callUserList.indexOf(userJid)
            if (index.isValidIndex() && !CallUtils.getIsGridViewEnabled() && CallUtils.getIsViewUpdatesCompleted()) {
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_USER_SPEAKING, audioLevel)
                callUsersListAdapter.notifyItemChanged(index, bundle)
            }
        }
    }

    fun onUserProfileDetailsUpdatedDuringCall(updatedUserJid: String) {
        LogMessage.d(
            TAG,
            "$CALL_UI userUpdatedHisProfile onUserProfileDetailsUpdatedDuringCall updatedUserJid: $updatedUserJid"
        )
        if (!CallManager.isOneToOneCall() && updatedUserJid.isNotEmpty()) {
            val index = callUsersListAdapter.callUserList.indexOf(updatedUserJid)
            if (index.isValidIndex() && !CallUtils.getIsGridViewEnabled() && CallUtils.getIsViewUpdatesCompleted()) {
                LogMessage.d(
                    TAG,
                    "$CALL_UI userUpdatedHisProfile onUserProfileDetailsUpdatedDuringCall callUsersListAdapter updatedUserJid: $updatedUserJid"
                )
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_USER_PROFILE, 1)
                callUsersListAdapter.notifyItemChanged(index, bundle)
            } else {
                LogMessage.d(
                    TAG,
                    "$CALL_UI userUpdatedHisProfile onUserProfileDetailsUpdatedDuringCall callUserGridAdapter updatedUserJid: $updatedUserJid"
                )
                val gridIndex = callUserGridAdapter.gridCallUserList.indexOf(updatedUserJid)
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_USER_PROFILE, 1)
                callUserGridAdapter.notifyItemChanged(gridIndex, bundle)
            }
        }
    }

    private fun handleConnectionQualityForSingleUserInCall() {
        if (CallManager.getCallConnectionQuality() == ConnectionQuality.POOR && GroupCallUtils.isCallLinkBehaviourMeet() && !CallManager.getCallStatus(CallManager.getCurrentUserId()).equals(CallStatus.RECONNECTING)) {
            binding.viewPoorNetworkLocalUser.visibility = View.VISIBLE
        } else {
            binding.viewPoorNetworkLocalUser.visibility = View.GONE
        }
    }

    private fun handleConnectionQualityForOneToOneCall() {
        if (CallManager.getCallConnectionQuality() == ConnectionQuality.POOR && !CallManager.getCallStatus(CallManager.getCurrentUserId()).equals(CallStatus.RECONNECTING)) {
            binding.viewPoorNetworkLocalUser.visibility = View.VISIBLE
        } else {
            binding.viewPoorNetworkLocalUser.visibility = View.GONE
        }
    }

    private fun handleConnectionQualityForGrid(bundle: Bundle) {
        val gridIndex =
            callUserGridAdapter.gridCallUserList.indexOf(CallManager.getCurrentUserId())
        LogMessage.d(
            TAG,
            "$CALL_UI #callconnectionquality onQualityUpdated checkAndUpdateGridViewEnabled gridIndex:$gridIndex"
        )
        if (gridIndex.isValidIndex()) {
            callUserGridAdapter.notifyItemChanged(gridIndex, bundle)
        }
    }

    private fun handleConnectionQualityForList(bundle: Bundle) {
        val index = callUsersListAdapter.callUserList.indexOf(CallManager.getCurrentUserId())
        LogMessage.d(
            TAG,
            "$CALL_UI #callconnectionquality onQualityUpdated checkAndUpdateListView index:$index"
        )
        if (index.isValidIndex()) {
            callUsersListAdapter.notifyItemChanged(index, bundle)
        }
    }

    fun checkAndShowPoorConnectionQuality() {
        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_USER_POOR_CONNECTION, 1)
        if (CallUtils.getIsGridViewEnabled()) {
            handleConnectionQualityForGrid(bundle = bundle)
        } else {
            handleConnectionQualityForList(bundle = bundle)
        }

        if (GroupCallUtils.isSingleUserInCall()) {
            handleConnectionQualityForSingleUserInCall()
        } else if (CallManager.isOneToOneCall()) {
            handleConnectionQualityForOneToOneCall()
        }
    }
}