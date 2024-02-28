package com.contusfly.call.groupcall.helpers

import android.annotation.SuppressLint
import android.os.Bundle
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
import com.contus.call.CallActions
import com.contus.call.CallConstants.CALL_UI
import com.contus.call.CallConstants.JOIN_CALL
import com.contus.call.CallGridSpacingItemDecoration
import com.contus.call.SpeakingIndicatorListener
import com.contusfly.*
import com.contusfly.call.groupcall.*
import com.contusfly.call.groupcall.listeners.ActivityOnClickListener
import com.contusfly.call.groupcall.listeners.BaseViewOnClickListener
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.call.groupcall.utils.UserMuteStatus
import com.contusfly.databinding.LayoutCallConnectedBinding
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.CallStatus
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.ChatUtils
import com.mirrorflysdk.utils.Utils
import kotlinx.android.synthetic.main.layout_call_connected.view.single_user_text_call_status
import org.webrtc.RendererCommon
import java.util.*
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
            R.id.view_video_local -> if (!GroupCallUtils.isSingleUserInCall() && CallManager.isCallConnected()) setSwappedFeeds(
                !isSwappedFeeds
            )

            R.id.image_menu_switch_call_view -> showMenuPopUp(view)
            R.id.image_unpin -> baseViewOnClickListener.pinnedUserRemoved()
        }
    }

    /**
     * This method will initiate Grid adapter and it's recycler view
     */
    private fun initGridAdapter() {
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

    /**
     * This method will initiate List adapter and it's recycler view
     */
    private fun initListAdapter() {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL CallConnectedViewHelper initListAdapter")
        val userList = ArrayList<String>()
        for (userJid in CallManager.getCallUsersList()) {
            if (CallUtils.getPinnedUserJid().isBlank() && userJid != CallManager.getCurrentUserId()){
                CallUtils.setIsUserTilePinned(true)
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

        binding.callUsersRecyclerview.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = callUsersListAdapter
            itemAnimator = null
        }
    }

    fun setUpCallUI() {
        val isCallNotConnected = CallManager.isCallNotConnected()
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL CallConnectedViewHelper setUpCallUI() isCallNotConnected: $isCallNotConnected"
        )
        initLocalVideoViews()
        if (isCallNotConnected)
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
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL CallConnectedViewHelper initLocalVideoViews() isVideoViewsInitialized: $isVideoViewsInitialized"
        )
        try{
            if (isVideoViewsInitialized.compareAndSet(false, true)) {
                LogMessage.d(TAG, "$CALL_UI CallConnectedViewHelper initVideoViews()")
                binding.viewVideoLocal.init(CallManager.getRootEglBase()?.eglBaseContext, null)
                binding.viewVideoLocal.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL)
                /* setting Target SurfaceViews to VideoSinks  */
                CallManager.getLocalProxyVideoSink()?.setTarget(binding.viewVideoLocal)
                binding.viewVideoLocal.setMirror(true)
                binding.viewVideoLocal.scaleX = 1.0f

                binding.viewVideoPinned.init(CallManager.getRootEglBase()?.eglBaseContext, null)
                binding.viewVideoPinned.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL)
            }
        }catch (exception:Exception){
            exception.printStackTrace()
        }
    }

    fun checkAndShowLocalVideoView() {
        LogMessage.d(
            TAG,
            "$CALL_UI $JOIN_CALL checkAndShowLocalVideoView  isVideoMuted() : ${CallManager.isVideoMuted()}"
        )
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
            // if local user available in list view then list view item will be refreshed
            // and local user view will not updated, so it is one to one call then remove local user from list view
            callUsersListAdapter.removeUser(CallManager.getCurrentUserId())
            LogMessage.d(
                TAG,
                "$CALL_UI $JOIN_CALL checkAndShowLocalVideoView isOneToOneCall isCallConnected() : ${CallManager.isCallConnected()}"
            )
            LogMessage.d(
                TAG,
                "$CALL_UI $JOIN_CALL checkAndShowLocalVideoView isOneToOneCall isAudioCall() : ${CallManager.isAudioCall()}"
            )
            if (CallManager.isVideoMuted() && (CallManager.isCallConnected() || CallManager.isAudioCall())) {
                binding.viewVideoLocal.gone()
            } else {
                binding.viewVideoLocal.show()
                setSwappedFeeds(isSwappedFeeds) // Set target for surface view
            }
        } else {
            // Since local user will be removed from list view for one to one call,
            // we must add local user to list view for group call
            if (CallUtils.getPinnedUserJid() != CallManager.getCurrentUserId() && !callUsersListAdapter.callUserList.contains(
                    CallManager.getCurrentUserId()
                )
            )
                callUsersListAdapter.addUser(CallManager.getCurrentUserId())
            binding.viewVideoLocal.gone()
            baseViewOnClickListener.onCallOptionsVisible()
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
        showViews(
            binding.layoutTitle, binding.layoutProfile, binding.imageAudioMutedForVideoCall,
            binding.textCallDuration, binding.backgroundView, binding.imageUnpin
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

        if (CallUtils.getIsGridViewEnabled()) {
            LogMessage.i(
                TAG,
                "$CALL_UI CallConnectedViewHelper setUpConnectedCallView() GridViewEnabled"
            )
            checkAndHideListViewVideoSurfaceViews()
            makeViewsGone(
                binding.layoutProfile,
                binding.imageAudioMutedForVideoCall,
                binding.textCallStatus,
                binding.backgroundView,
                binding.viewVideoLocal,
                binding.layoutOneToOneAudioCall,
                binding.callUsersRecyclerview,
                binding.viewVideoPinned,
                binding.imageUnpin
            )
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
                callUsersListAdapter.notifyItemRangeChanged(
                    0,
                    callUsersListAdapter.callUserList.size,
                    bundle
                ) // Set target for surface view
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
        if(BuildConfig.CONTACT_SYNC_ENABLED)
            binding.callerProfileImage.setImageResource(R.drawable.ic_profile)
        else{
            val setDrawable = SetDrawable(activity)
            val icon = setDrawable.setDrawableForProfile(userMobileNumber)
            binding.callerProfileImage.setImageDrawable(icon)
        }
    }

    fun updateLocalUserImage(){
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
                binding.callerProfileImage.loadUserProfileImage(activity, profileDetails)
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
        optionsMenu.show()
    }

    fun updateCallStatus() {
        LogMessage.i(TAG, "$CALL_UI CallConnectedViewHelper updateCallStatus isOneToOneCall: ${CallManager.isOneToOneCall()}")
        val pinnedUser = CallUtils.getPinnedUserJid()
        val connectedStatus =
            if (CallManager.isOneToOneCall()) CallManager.getCallConnectedStatus(activity)
            else CallManager.getCallStatus(pinnedUser)
        LogMessage.i(TAG, "$CALL_UI CallConnectedViewHelper connectedStatus:$connectedStatus")
        if (connectedStatus in arrayOf(
                CallStatus.ON_HOLD,
                CallStatus.RECONNECTING,
                activity.getString(R.string.reconnecting)
            )
        ) {
            LogMessage.e(TAG, "$CALL_UI Call Status $connectedStatus Jid == $pinnedUser")
            if (GroupCallUtils.isSingleUserInCall()) {
                binding.layoutTitle.show()
                binding.textCallStatus.hide()
                if (connectedStatus == CallStatus.RECONNECTING || connectedStatus == activity.getString(
                        R.string.reconnecting
                    )
                ) {
                    binding.layoutOneToOneAudioCall.single_user_text_call_status.text =
                        activity.getString(R.string.reconnecting)
                    binding.layoutOneToOneAudioCall.single_user_text_call_status.visibility =
                        View.VISIBLE
                    LogMessage.e(TAG, "$CALL_UI Call Status RECONNECTING single user")
                } else {
                    binding.layoutOneToOneAudioCall.single_user_text_call_status.visibility =
                        View.GONE
                }
            } else {
                binding.layoutTitle.show()
                binding.layoutOneToOneAudioCall.single_user_text_call_status.visibility = View.GONE
                binding.textCallStatus.show()
                binding.textCallStatus.text =
                    if (connectedStatus == CallStatus.RECONNECTING) activity.getString(R.string.reconnecting)
                    else connectedStatus
            }
        } else {
            binding.textCallStatus.gone()
            binding.layoutOneToOneAudioCall.single_user_text_call_status.visibility = View.GONE
        }

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
                if (userMuteStatus.isAudioMuted) binding.imageAudioMutedForVideoCall.show() else binding.imageAudioMutedForVideoCall.hide()
            }
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

    fun updatePinnedUserVideoMuteStatus() {
        LogMessage.i(
            TAG,
            "$CALL_UI $JOIN_CALL CallConnectedViewHelper updatePinnedUserVideoMuteStatus isSwappedFeeds:$isSwappedFeeds"
        )
        if (GroupCallUtils.isSingleUserInCall()) {
            LogMessage.i(
                TAG,
                "$CALL_UI $JOIN_CALL CallConnectedViewHelper just hide videoPinned SingleUserInCall"
            )
            binding.viewVideoPinned.gone()
            binding.layoutOneToOneAudioCall.show()
        } else if (CallUtils.getIsGridViewEnabled()) {
            makeViewsGone(binding.layoutProfile, binding.textCallStatus)
        } else {
            if (isSwappedFeeds && CallManager.isOneToOneCall()) // when remote user mute their video and we swapped local to full view then we have restore the swapped state
                setSwappedFeeds(false)
            else {
                isSwappedFeeds = false
                val videoSink = CallUtils.getPinnedVideoSink()
                LogMessage.i(
                    TAG,
                    "$CALL_UI $JOIN_CALL CallConnectedViewHelper just hide videoPinned getPinnedUserVideoMuted:${CallUtils.getPinnedUserVideoMuted()}"
                )
                LogMessage.i(
                    TAG,
                    "$CALL_UI $JOIN_CALL CallConnectedViewHelper just hide videoPinned getPinnedUserJid:${CallUtils.getPinnedUserJid()}"
                )
                if (CallUtils.getPinnedUserVideoMuted() || CallManager.isRemoteVideoPaused(CallUtils.getPinnedUserJid()) || videoSink.isNull()) {
                    LogMessage.i(
                        TAG,
                        "$CALL_UI $JOIN_CALL CallConnectedViewHelper just hide videoPinned "
                    )
                    binding.viewVideoPinned.gone()
                    showViews(binding.layoutProfile)
                } else {
                    LogMessage.i(
                        TAG,
                        "$CALL_UI $JOIN_CALL CallConnectedViewHelper just show videoPinned "
                    )
                    makeViewsGone(binding.layoutProfile, binding.textCallStatus)
                    binding.viewVideoPinned.show()
                    videoSink?.setTarget(binding.viewVideoPinned)
                    binding.viewVideoPinned.setMirror(CallUtils.getPinnedUserJid() == CallManager.getCurrentUserId() && !CallUtils.getIsBackCameraCapturing())
                }
            }
            updateCallStatus()
        }
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
                callUsersListAdapter.swapPinnedUser(
                    userJid,
                    CallUtils.getPinnedUserJid(),
                    if (addIndex.isValidIndex() && CallUtils.getPinnedUserJid() != CallManager.getCurrentUserId()) addIndex else callUsersListAdapter.callUserList.size - 1
                )
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
        } catch (e: Exception) {
            LogMessage.e(TAG, "$CALL_UI $e")
        }
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
        } else {
            binding.callerProfileImage.setImageDrawable(null)
            if (CallUtils.getPinnedUserJid().isNotEmpty()) {
                val profileDetails =
                    ProfileDetailsUtils.getProfileDetails(CallUtils.getPinnedUserJid())
                if (profileDetails != null) {
                    binding.callerProfileImage.loadUserProfileImage(activity, profileDetails)
                }else{
                    LogMessage.d(TAG, "updatePinnedUserProfile: pinned user not in contact details!!")
                    updateCallerImageWhenProfileEmpty(ChatUtils.getUserFromJid(CallUtils.getPinnedUserJid()))
                }
            } else
                binding.callerProfileImage.setImageDrawable(
                    ContextCompat.getDrawable(
                        activity,
                        R.drawable.ic_profile
                    )
                )
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

    fun onUserStoppedSpeaking(userJid: String) {
        if (CallUtils.getPinnedUserJid() == userJid) {
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
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_USER_PROFILE, 1)
                callUserGridAdapter.notifyItemChanged(index, bundle)
            }
        }
    }
}