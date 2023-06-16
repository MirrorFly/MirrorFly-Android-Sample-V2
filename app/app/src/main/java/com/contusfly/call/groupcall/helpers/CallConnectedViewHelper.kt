package com.contusfly.call.groupcall.helpers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.core.content.ContextCompat
import com.contus.call.CallActions
import com.contus.call.CallConstants.CALL_UI
import com.contus.call.CallGridSpacingItemDecoration
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.CallStatus
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.*
import com.contusfly.call.groupcall.listeners.ActivityOnClickListener
import com.contusfly.databinding.LayoutCallConnectedBinding
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.utils.Utils
import com.contusfly.call.groupcall.*
import com.contusfly.call.groupcall.listeners.BaseViewOnClickListener
import com.contusfly.call.groupcall.utils.CallUtils
import org.webrtc.RendererCommon
import java.util.concurrent.atomic.AtomicBoolean
import android.view.MenuInflater
import android.view.MotionEvent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.contus.call.SpeakingIndicatorListener
import com.contusfly.call.SetDrawable
import com.contusfly.call.groupcall.utils.UserMuteStatus
import com.contusfly.utils.ProfileDetailsUtils
import java.util.*
import kotlin.collections.ArrayList


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

    init {
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

        //Fix for Local view shown when call converted into one to many call
        binding.viewVideoLocal.setOnTouchListener { _, _ ->
            !CallManager.isOneToOneCall()
        }

        initGridAdapter()
        initListAdapter()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.image_add_users -> activityOnClickListener.addUsersInCall()
            R.id.view_video_local -> if (CallManager.isCallConnected()) setSwappedFeeds(!isSwappedFeeds)
            R.id.image_menu_switch_call_view -> showMenuPopUp(view)
            R.id.image_unpin -> baseViewOnClickListener.pinnedUserRemoved()
        }
    }

    /**
     * This method will initiate Grid adapter and it's recycler view
     */
    private fun initGridAdapter() {
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

        binding.callGridUsersRecyclerview.apply {
            setHasFixedSize(true)
            val gridLayoutManager = GridLayoutManager(activity,2)
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

    /**
     * This method will initiate List adapter and it's recycler view
     */
    private fun initListAdapter() {
        val userList = ArrayList<String>()
        for (userJid in CallManager.getCallUsersList()) {
            if (CallUtils.getPinnedUserJid().isBlank() && userJid != CallManager.getCurrentUserId())
                CallUtils.setPinnedUserJid(userJid)
            if (!callUsersListAdapter.callUserList.contains(userJid)) {
                userList.add(userJid)
            }
        }
        userList.remove(CallUtils.getPinnedUserJid())
        if (userList.isNotEmpty()) {
            callUsersListAdapter.addUsers(userList)
        }

        binding.callUsersRecyclerview.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = callUsersListAdapter
            itemAnimator = null
        }
    }

    fun setUpCallUI() {
        initLocalVideoViews()
        if (CallManager.isCallNotConnected())
            setUpCallNotConnected()
        else
            setUpConnectedCallView()
    }

    /**
     * Here all the video views are initializing
     */
    private fun initLocalVideoViews() {
        // re-initiating video views will causes {@link IllegalStateException},
        //so this flag is checked before initializing video views
        if (isVideoViewsInitialized.compareAndSet(false, true)) {
            LogMessage.d(TAG, "$CALL_UI initVideoViews()")
            binding.viewVideoLocal.init(CallManager.getRootEglBase()?.eglBaseContext, null)
            binding.viewVideoLocal.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL)
            /* setting Target SurfaceViews to VideoSinks  */
            CallManager.getLocalProxyVideoSink()?.setTarget(binding.viewVideoLocal)
            binding.viewVideoLocal.setMirror(true)

            binding.viewVideoPinned.init(CallManager.getRootEglBase()?.eglBaseContext, null)
            binding.viewVideoPinned.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL)
        }
    }

    fun checkAndShowLocalVideoView() {
        if (CallManager.isOneToOneCall()) {
            // if local user available in list view then list view item will be refreshed
            // and local user view will not updated, so it is one to one call then remove local user from list view
            callUsersListAdapter.removeUser(CallManager.getCurrentUserId())
            if (CallManager.isVideoMuted() && (CallManager.isCallConnected() || CallManager.isAudioCall())) {
                binding.viewVideoLocal.gone()
            } else {
                binding.viewVideoLocal.show()
                setSwappedFeeds(isSwappedFeeds) // Set target for surface view
            }
        } else {
            // Since local user will be removed from list view for one to one call,
            // we must add local user to list view for group call
            if (CallUtils.getPinnedUserJid() != CallManager.getCurrentUserId() && !callUsersListAdapter.callUserList.contains(CallManager.getCurrentUserId()))
                callUsersListAdapter.addUser(CallManager.getCurrentUserId())
            binding.viewVideoLocal.gone()
            baseViewOnClickListener.onCallOptionsVisible()
        }
    }

    private fun setUpCallNotConnected() {
        if (CallManager.isVideoCall()) {
            binding.layoutCallDetails.show()
            makeViewsGone(binding.layoutTitle, binding.layoutProfile, binding.imageAudioMutedForVideoCall,
                binding.textCallStatus,binding.textCallDuration, binding.backgroundView,
                binding.callGridUsersRecyclerview, binding.gridBackgroundView,
                binding.callUsersRecyclerview, binding.imageUnpin)
            binding.layoutOneToOneAudioCall.show()
            binding.viewVideoLocal.show()
        } else
            hideConnectedView()
    }

    private fun setUpConnectedCallView() {
        LogMessage.i(TAG, "$CALL_UI setUpConnectedCallView()")
        binding.layoutCallDetails.show()

        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_USER_PROFILE, 1)
        bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)
        bundle.putInt(CallActions.NOTIFY_CONNECT_TO_SINK, 1)
        bundle.putInt(CallActions.NOTIFY_PINNED_USER_VIEW, 1)
        bundle.putInt(CallActions.NOTIFY_VIEW_SIZE_UPDATED, 1)

        if (CallUtils.getIsGridViewEnabled()) {
            checkAndHideListViewVideoSurfaceViews()
            makeViewsGone(binding.layoutProfile, binding.imageAudioMutedForVideoCall,
                binding.textCallStatus, binding.backgroundView, binding.viewVideoLocal, binding.layoutOneToOneAudioCall,
                binding.callUsersRecyclerview, binding.viewVideoPinned, binding.imageUnpin)
            showViews(binding.callGridUsersRecyclerview, binding.layoutTitle,
                binding.textCallDuration, binding.gridBackgroundView)
            callUserGridAdapter.notifyItemRangeChanged(0, callUserGridAdapter.gridCallUserList.size, bundle) // Set target for surface view
        } else {
            checkAndHideGridViewVideoSurfaceViews()
            showViews(binding.layoutTitle, binding.layoutProfile, binding.imageAudioMutedForVideoCall,
                binding.textCallDuration, binding.backgroundView, binding.imageUnpin)
            makeViewsGone(binding.callGridUsersRecyclerview, binding.gridBackgroundView)

            if (CallManager.isOneToOneCall()) {
                setUpOneToOneCallView()
            } else {
                binding.layoutOneToOneAudioCall.gone()
                updatePinnedUserIcon(CallUtils.getPinnedUserJid())
                showViews(binding.callUsersRecyclerview)
                callUsersListAdapter.notifyItemRangeChanged(0, callUsersListAdapter.callUserList.size, bundle) // Set target for surface view
            }
            updatePinnedUserVideoMuteStatus()
            checkAndShowLocalVideoView()
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
            if (userList.isNotEmpty() && CallUtils.getPinnedUserJid().isNotBlank() && CallManager.getCallStatus(CallUtils.getPinnedUserJid()) !in arrayOf(CallStatus.CONNECTED, CallStatus.CONNECTING, CallStatus.ON_HOLD, CallStatus.RECONNECTING)) {
                val userJid = userList.first()
                pinnedUserChanged(userJid, true)
            }
        }
    }

    private fun setUpOneToOneCallView() {
        binding.layoutOneToOneAudioCall.show()
        makeViewsGone(binding.callUsersRecyclerview, binding.imageUnpin)
        if (!CallManager.isRemoteVideoMuted(CallManager.getEndCallerJid())) {
            binding.layoutProfile.hide()
            binding.textCallStatus.gone()
            binding.viewVideoPinned.show()
            if (!CallManager.getUserAvailableForReconnection(CallManager.getEndCallerJid())) {
                updateCallStatus()
            } else {
                baseViewOnClickListener.enableCallOptionAnimation()
            }
        } else {
            showViews(binding.layoutProfile)
            binding.viewVideoPinned.gone()
        }
    }

    /**
     * This method is getting the caller name and profile picture
     *
     * @param callUsers list of Users in Call
     */
    fun updateCallMemberDetails(callUsers: ArrayList<String>) {
        var name = ""
        if (CallManager.isOneToOneCall()) {
            val profileDetails = if (CallManager.getEndCallerJid().contains("@"))
                ProfileDetailsUtils.getProfileDetails(CallManager.getEndCallerJid())
            else null
            profileDetails?.let {
                binding.callerProfileImage.loadUserProfileImage(activity, profileDetails)
                val jidList = ArrayList<String>()
                jidList.add(profileDetails.jid)
                name = CallUtils.getGroupMembersName(jidList, CallManager.getGroupID())
            }

            if (!CallManager.isVideoCallUICanShow()) {
                val userName = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME))
                MediaUtils.loadImageWithGlideSecure(
                    activity,
                    SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
                    binding.localProfileImage,
                    SetDrawable(activity).setDrawableForProfile(userName)
                )
            }
        } else {
            name = CallUtils.getGroupMembersName(callUsers, CallManager.getGroupID())
            updatePinnedUserProfile()
        }
        LogMessage.d(TAG, "$CALL_UI getProfile name: $name")
        binding.textCallUsers.text = name
    }

    fun updateCallDuration(callDuration: String) {
        binding.textCallDuration.text = callDuration
    }

    fun hideConnectedView() {
        binding.layoutCallDetails.gone()
        binding.viewVideoPinned.gone()
        binding.callGridUsersRecyclerview.gone()
        binding.callUsersRecyclerview.gone()
    }

    fun checkAddParticipantsAvailable() {
        LogMessage.d(TAG, "$CALL_UI checkAddParticipantsAvailable()")
        if (ChatManager.getAvailableFeatures().isGroupCallEnabled && CallManager.isCallConnected() && !activity.isInPIPMode()) binding.imageAddUsers.show()
        else binding.imageAddUsers.gone()
    }

    @SuppressLint("RestrictedApi")
    private fun showMenuPopUp(view: View) {
        val menuBuilder = MenuBuilder(activity)
        val inflater = MenuInflater(activity)
        inflater.inflate(R.menu.menu_switch_call_view, menuBuilder)
        val optionsMenu = MenuPopupHelper(activity, menuBuilder, view)
        optionsMenu.setForceShowIcon(true)

        if (CallUtils.getIsGridViewEnabled()) {
            menuBuilder.getItem(0).hide()
            menuBuilder.getItem(1).show()
        } else {
            menuBuilder.getItem(0).show()
            menuBuilder.getItem(1).hide()
        }

        menuBuilder.setCallback(object : MenuBuilder.Callback{
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
        optionsMenu.show()
    }

    fun updateCallStatus() {
        val pinnedUser = CallUtils.getPinnedUserJid()
        val connectedStatus = if (CallManager.isOneToOneCall()) CallManager.getCallConnectedStatus(activity)
        else CallManager.getCallStatus(pinnedUser)
        if (connectedStatus in arrayOf(CallStatus.ON_HOLD, CallStatus.RECONNECTING, activity.getString(R.string.reconnecting))) {
            LogMessage.e(TAG, "$CALL_UI Call Status $connectedStatus Jid == $pinnedUser")
            binding.layoutTitle.show()
            binding.textCallStatus.show()
            binding.textCallStatus.text = if (connectedStatus == CallStatus.RECONNECTING) activity.getString(R.string.reconnecting)
            else connectedStatus
        } else
            binding.textCallStatus.gone()
    }

    /*
    * This method will determine whether audio mute icon need to be shown or not and
    * whether it should show on profile picture or center of the screen
    */
    fun updateRemoteAudioMuteStatus() {
        if (CallUtils.getIsGridViewEnabled())
            binding.imageAudioMutedForVideoCall.gone()
        else {
            val userMuteStatus = UserMuteStatus(CallManager.isUserVideoMuted(CallUtils.getPinnedUserJid()),  CallManager.isUserAudioMuted(CallUtils.getPinnedUserJid()))

            if (userMuteStatus.isVideoMuted) {
                binding.imageAudioMutedForVideoCall.gone()
                if (userMuteStatus.isAudioMuted) binding.imageAudioMuted.show() else binding.imageAudioMuted.gone()
            } else {
                binding.imageAudioMuted.gone()
                if (userMuteStatus.isAudioMuted) binding.imageAudioMutedForVideoCall.show() else binding.imageAudioMutedForVideoCall.hide()
            }
        }
    }

    /**
     * Here handling the video swap
     */
    private fun setSwappedFeeds(isSwappedFeeds: Boolean) {
        LogMessage.d(TAG, "$CALL_UI setSwappedFeeds() isSwappedFeeds -> $isSwappedFeeds")
        if (CallManager.isOneToOneCall()) {
            this.isSwappedFeeds = isSwappedFeeds
            if (isSwappedFeeds) {
                CallManager.getRemoteProxyVideoSink(CallUtils.getPinnedUserJid())?.setTarget(binding.viewVideoLocal)
                CallManager.getLocalProxyVideoSink()?.setTarget(binding.viewVideoPinned)
                binding.viewVideoLocal.setMirror(false)
                /* we don't need mirror view for back camera */
                binding.viewVideoPinned.setMirror(!CallUtils.getIsBackCameraCapturing())
            } else {
                CallManager.getLocalProxyVideoSink()?.setTarget(binding.viewVideoLocal)
                CallManager.getRemoteProxyVideoSink(CallUtils.getPinnedUserJid())?.setTarget(binding.viewVideoPinned)
                binding.viewVideoPinned.setMirror(false)
                /* we don't need mirror view for back camera */
                binding.viewVideoLocal.setMirror(!CallUtils.getIsBackCameraCapturing())
            }
        }
    }

    /**
     * Set mirror view to the adapter In case local video swapped with remote video view
     */
    fun setMirrorLocalView() {
        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_LOCAL_VIEW_MIRROR, 1)

        if (CallUtils.getIsGridViewEnabled()) {
            LogMessage.d(TAG, "$CALL_UI setMirrorLocalView: remote grid view")
            val girdIndex = callUserGridAdapter.gridCallUserList.indexOf(CallManager.getCurrentUserId())
            if (girdIndex.isValidIndex()) {
                callUserGridAdapter.notifyItemChanged(girdIndex, bundle)
            }
        } else {
            if (CallManager.isOneToOneCall()) {
                LogMessage.d(TAG, "$CALL_UI setMirrorLocalView: isOneToOneCall: ${CallManager.isOneToOneCall()} isSwappedFeeds:${isSwappedFeeds}")
                setSwappedFeeds(isSwappedFeeds)
            } else {
                LogMessage.d(TAG, "$CALL_UI setMirrorLocalView: remote list view")
                val index = callUsersListAdapter.callUserList.indexOf(CallManager.getCurrentUserId())
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
        initLocalVideoViews()
    }

    fun onVideoTrackAdded(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI onVideoTrackAdded for userJid: $userJid")
        val bundle = Bundle()
        bundle.putString(CallActions.NOTIFY_CONNECT_TO_SINK, userJid)
        bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)

        if (CallUtils.getIsGridViewEnabled()) {
            binding.callGridUsersRecyclerview.post {
                val index = callUserGridAdapter.gridCallUserList.indexOf(userJid)
                if (index.isValidIndex()) callUserGridAdapter.notifyItemChanged(index, bundle)
            }
        } else {
            if (CallUtils.getPinnedUserJid() == userJid) {
                setSwappedFeeds(isSwappedFeeds)
                updatePinnedUserVideoMuteStatus()
            } else
                binding.callUsersRecyclerview.post {
                    val index = callUsersListAdapter.callUserList.indexOf(userJid)
                    if (index.isValidIndex()) callUsersListAdapter.notifyItemChanged(index, bundle)
                }
        }
    }

    fun updatePinnedUserIcon(userJid: String = Constants.EMPTY_STRING) {
        if (CallUtils.getIsUserTilePinned() && userJid == CallUtils.getPinnedUserJid())
            binding.imageUnpin.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_tile_pinned_icon))
        else
            binding.imageUnpin.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_pin_tile))
    }

    fun updatePinnedUserVideoMuteStatus() {
        if (CallUtils.getIsGridViewEnabled()) {
            makeViewsGone(binding.layoutProfile, binding.textCallStatus)
        } else {
            if (isSwappedFeeds && CallManager.isOneToOneCall()) // when remote user mute their video and we swapped local to full view then we have restore the swapped state
                setSwappedFeeds(false)
            else {
                isSwappedFeeds = false
                val videoSink = CallUtils.getPinnedVideoSink()

                if (CallUtils.getPinnedUserVideoMuted() || CallManager.isRemoteVideoPaused(CallUtils.getPinnedUserJid()) || videoSink.isNull()) {
                    binding.viewVideoPinned.gone()
                    showViews(binding.layoutProfile)
                } else {
                    makeViewsGone(binding.layoutProfile, binding.textCallStatus)
                    binding.viewVideoPinned.show()
                    videoSink?.setTarget(binding.viewVideoPinned)
                    binding.viewVideoPinned.setMirror(CallUtils.getPinnedUserJid() == CallManager.getCurrentUserId() && !CallUtils.getIsBackCameraCapturing())
                }
            }
            updateCallStatus()
        }
    }

    private fun localPinnedUser(localUserPosition: Int, pinClickedUserPosition: Int){
        val moveToEnd = callUserGridAdapter.gridCallUserList[localUserPosition]
        val moveToFirst = callUserGridAdapter.gridCallUserList[pinClickedUserPosition]
        callUserGridAdapter.gridCallUserList.removeAt(pinClickedUserPosition)
        callUserGridAdapter.gridCallUserList.removeAt(localUserPosition)

        callUserGridAdapter.gridCallUserList.add(0, moveToFirst)
        callUserGridAdapter.gridCallUserList.add(callUserGridAdapter.gridCallUserList.size, moveToEnd)
    }

    private fun updatePinnedUserPosition(isUserSpeaking:Boolean, userJid: String){
        if (!isUserSpeaking || CallUtils.isLocalUserPinned()) { // Grid Swap not needed for speaking user
            val pinClickedUserPosition=callUserGridAdapter.gridCallUserList.indexOf(userJid)
            val positionToSwap = 0
            if (CallUtils.isLocalUserPinned()) {
                localPinnedUser(positionToSwap, pinClickedUserPosition)
            } else {
                Collections.swap(callUserGridAdapter.gridCallUserList, pinClickedUserPosition, positionToSwap)
            }
            if (CallUtils.getIsGridViewEnabled())
                callUserGridAdapter.notifyItemMoved(pinClickedUserPosition, positionToSwap)
        }
    }

    fun pinnedUserChanged(userJid: String, isUserSpeaking:Boolean = false) {
        LogMessage.d(TAG, "$CALL_UI pinnedUserChanged userJid:${userJid}")

        try {
            updatePinnedUserPosition(isUserSpeaking,userJid)
            if (CallUtils.getPinnedUserJid() != userJid) {
                val addIndex = callUsersListAdapter.callUserList.indexOf(userJid)
                CallUtils.getVideoSinkForUser(userJid)?.setTarget(null)
                CallUtils.getVideoSinkForUser(CallUtils.getPinnedUserJid())?.setTarget(null)
                callUsersListAdapter.swapPinnedUser(userJid, CallUtils.getPinnedUserJid(), if (addIndex.isValidIndex() && CallUtils.getPinnedUserJid() != CallManager.getCurrentUserId()) addIndex else callUsersListAdapter.callUserList.size - 1)
                CallUtils.setPinnedUserJid(userJid)
            }

            if (CallUtils.getIsViewUpdatesCompleted()) {
                CallUtils.setIsViewUpdatesCompleted(false) //frequent speaking indicator animation shouldn't happen while switching view
                activityOnClickListener.resetViewsUpdatedFlag()
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_USER_PROFILE, 1)
                bundle.putInt(CallActions.NOTIFY_VIEW_STATUS_UPDATED, 1)
                bundle.putInt(CallActions.NOTIFY_CONNECT_TO_SINK, 1)
                bundle.putInt(CallActions.NOTIFY_PINNED_USER_VIEW, 1)
                if (CallUtils.getIsGridViewEnabled())
                    callUserGridAdapter.notifyItemRangeChanged(0, callUserGridAdapter.gridCallUserList.size, bundle)
                else {
                    callUsersListAdapter.notifyItemRangeChanged(0, callUsersListAdapter.callUserList.size, bundle)
                    updateCallStatus()
                }
            }
            updatePinnedUserVideoMuteStatus()
            updateRemoteAudioMuteStatus()
            updateCallMemberDetails(CallManager.getCallUsersList())
        } catch (e: Exception) {
            LogMessage.e(TAG, "$CALL_UI $e")
        }
    }

    fun pinnedUserLeft() {
        LogMessage.d(TAG, "$CALL_UI pinnedUserLeft")

        try {
            val userJid = CallManager.getCallUsersList().first()
            callUsersListAdapter.removeUser(userJid)
            CallUtils.setPinnedUserJid(userJid)

            updatePinnedUserVideoMuteStatus()
            updateRemoteAudioMuteStatus()
            updateCallMemberDetails(CallManager.getCallUsersList())
        } catch (e: Exception) {
            LogMessage.e(TAG, "$CALL_UI $e")
        }
    }

    private fun updatePinnedUserProfile() {
        LogMessage.d(TAG, "$CALL_UI updatePinnedUserProfile getPinnedUserJid: ${CallUtils.getPinnedUserJid()}")
        if (CallUtils.getPinnedUserJid() == SharedPreferenceManager.getCurrentUserJid()) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(CallUtils.getPinnedUserJid())
            val setDrawable = SetDrawable(activity, profileDetails)
            val userName = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME))
            val icon = setDrawable.setDrawable(userName)

            MediaUtils.loadImageWithGlideSecure(
                activity,
                SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE),
                binding.callerProfileImage,
                icon
            )
        } else {
            binding.callerProfileImage.setImageDrawable(null)
            if (CallUtils.getPinnedUserJid().isNotEmpty()) {
                val profileDetails = ProfileDetailsUtils.getProfileDetails(CallUtils.getPinnedUserJid())
                binding.callerProfileImage.loadUserProfileImage(activity, profileDetails!!)
            } else
                binding.callerProfileImage.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_profile))
        }
    }

    fun ownAudioMuteStatusUpdated() {
        onUserStoppedSpeaking(CallManager.getCurrentUserId())
        if (CallUtils.getIsGridViewEnabled()){
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
                val index = callUsersListAdapter.callUserList.indexOf(CallManager.getCurrentUserId())
                if (index.isValidIndex()) {
                    val bundle = Bundle()
                    bundle.putInt(CallActions.NOTIFY_VIEW_MUTE_UPDATED, 1)
                    callUsersListAdapter.notifyItemChanged(index, bundle)
                }
            }
        }
    }

    fun onUserStoppedSpeaking(userJid: String) {
        if (CallUtils.getPinnedUserJid() == userJid) {
            binding.rippleBg.onUserStoppedSpeaking()
        } else {
            if (CallManager.isOneToOneCall()) {
                binding.viewSpeakingIndicator.onUserStoppedSpeaking(object : SpeakingIndicatorListener {
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

    fun onUserSpeaking(userJid: String, audioLevel:Int) {
        if (CallUtils.getPinnedUserJid() == userJid) {
            binding.rippleBg.onUserSpeaking()
        } else {
            if (CallManager.isOneToOneCall()) {
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
}