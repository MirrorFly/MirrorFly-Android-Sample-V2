package com.contusfly.call.groupcall.helpers

import android.app.PictureInPictureParams
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.DisplayMetrics
import android.util.Rational
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.view.marginBottom
import com.contus.call.CallActions
import com.contus.call.CallConstants.CALL_UI
import com.contus.call.CallConstants.JOIN_CALL
import com.contusfly.*
import com.contusfly.call.groupcall.*
import com.contusfly.call.groupcall.listeners.ActivityOnClickListener
import com.contusfly.call.groupcall.listeners.BaseViewOnClickListener
import com.contusfly.call.groupcall.utils.AnimationsHelper
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.ActivityGroupCallBinding
import com.contusfly.utils.CommonUtils
import com.contusfly.utils.Constants
import com.contusfly.TAG
import com.mirrorflysdk.api.utils.ChatTimeFormatter
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.*
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.LogMessage
import kotlin.math.roundToInt

class BaseCallViewHelper(
    private val activity: AppCompatActivity,
    private val binding: ActivityGroupCallBinding,
    private val callUsersListAdapter: GroupCallListAdapter,
    private val callUserGridAdapter: GroupCallGridAdapter,
    private val durationHandler: Handler,
    private val activityOnClickListener: ActivityOnClickListener
) : BaseViewOnClickListener {

    private val callNotConnectedViewHelper by lazy {
        CallNotConnectedViewHelper(
            activity,
            binding.layoutCallNotConnected
        )
    }
    private val callConnectedViewHelper by lazy {
        CallConnectedViewHelper(
            binding.layoutCallConnected,
            activity,
            callUsersListAdapter,
            callUserGridAdapter,
            activityOnClickListener,
            this
        )
    }
    private val pipViewHelper by lazy { PIPViewHelper(activity, binding.layoutPipMode) }
    private val callOptionsViewHelper by lazy {
        CallOptionsViewHelper(
            activity,
            binding.layoutCallOptions,
            activityOnClickListener,
            this
        )
    }
    private val incomingCallViewHelper by lazy {
        IncomingCallViewHelper(
            activity,
            binding.layoutIncomingCall,
            activityOnClickListener
        )
    }
    private val retryCallViewHelper by lazy {
        RetryCallViewHelper(
            binding.layoutCallRetry,
            activityOnClickListener
        )
    }

    /**
     * Actual screen height in dp
     */
    private var actualScreenHeight = 0

    /**
     * Actual screen width in dp
     */
    private var actualScreenWidth = 0

    private var isAnimateClicked = false


    /**
     * The arguments to be used for Picture-in-Picture mode.
     */
    private val mPictureInPictureParamsBuilder: PictureInPictureParams.Builder? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PictureInPictureParams.Builder()
        } else {
            null
        }
    }

    init {
        val displayMetrics = DisplayMetrics()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val display = activity.display
            display?.getRealMetrics(displayMetrics)
        } else {
            @Suppress("DEPRECATION")
            val display = activity.windowManager.defaultDisplay
            @Suppress("DEPRECATION")
            display.getMetrics(displayMetrics)
        }
        actualScreenHeight = displayMetrics.heightPixels
        actualScreenWidth = displayMetrics.widthPixels
        callUsersListAdapter.setScreenHeight(actualScreenHeight)
        callUsersListAdapter.setScreenWidth(actualScreenWidth)
        callUserGridAdapter.setScreenHeight(actualScreenHeight)
        callUserGridAdapter.setScreenWidth(actualScreenWidth)
    }

    /**
     * Time in milli seconds
     */
    var timeInMilliseconds = 0L

    /**
     * Call start time
     */
    private var startTime = 0L

    var callDuration = Constants.EMPTY_STRING

    /**
     * The Update Timer thread to run continuously when call is going on.
     */
    private val updateTimerThread: Runnable = object : Runnable {
        override fun run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime
            callDuration = ChatTimeFormatter.getFormattedCallDurationTime(timeInMilliseconds)
            if (callDuration.isBlank())
                callDuration = activity.getString(R.string.start_timer)
            callConnectedViewHelper.updateCallDuration(callDuration)
            durationHandler.postDelayed(this, 1000)
        }
    }

    private fun startCallTimer() {
        startTime = CallManager.getCallTimerStartTime()
        durationHandler.postDelayed(updateTimerThread, 0)
    }

    fun setUpCallUI(isCallOptionAnimation:Boolean,isLocalTrackAddedFromSwitchRequest:Boolean) {
        LogMessage.d(TAG, "$CALL_UI $JOIN_CALL callViewHelper setUpCallUI()")
        setOverlayBackground()
        callNotConnectedViewHelper.setUpCallUI()
        callConnectedViewHelper.setUpCallUI(isLocalTrackAddedFromSwitchRequest)
        callOptionsViewHelper.setUpCallUI()
        retryCallViewHelper.setUpCallUI()
        incomingCallViewHelper.setUpCallUI()

        hidePIPLayout()
        resizeLocalTile(isCallOptionAnimation)

        if (CallManager.isCallAnswered()) callDuration = activity.getString(R.string.start_timer)
        if (CallManager.isCallConnected() && (!GroupCallUtils.isCallLinkBehaviourMeet())) {
            startCallTimer()
            if(isCallOptionAnimation) enableCallOptionAnimation()
        }
        if (GroupCallUtils.isCallLinkBehaviourMeet()) {
            callConnectedViewHelper.hideTextCallDuration()
        }
    }

    /**
     * Show/Hide local small video view in adapter while mute/un mute the local video
     */
    override fun ownVideoMuteStatusUpdated() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper ownVideoMuteStatusUpdated")
        if (CallUtils.getIsGridViewEnabled()) {
            val gridIndex =
                callUserGridAdapter.gridCallUserList.indexOf(CallManager.getCurrentUserId())
            if (gridIndex.isValidIndex()) { // if local user available in grid view then refresh grid view
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_VIEW_VIDEO_MUTE_UPDATED, 1)
                callUserGridAdapter.notifyItemChanged(gridIndex, bundle)
            }
        } else {
            val index = callUsersListAdapter.callUserList.indexOf(CallManager.getCurrentUserId())
            LogMessage.d(TAG, "$CALL_UI callViewHelper index: $index  ")
            if (!GroupCallUtils.isSingleUserInCall() && index.isValidIndex()) { // if local user available in list view then refresh list view
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_VIEW_VIDEO_MUTE_UPDATED, 1)
                callUsersListAdapter.notifyItemChanged(index, bundle)
            } else {
                if (GroupCallUtils.isSingleUserInCall() || CallManager.isOneToOneCall()) {
                    callConnectedViewHelper.checkAndShowLocalVideoView()
                } else
                    callConnectedViewHelper.updatePinnedUserVideoMuteStatus()
            }
        }
    }


    fun setUpProfileDetails(callUsers: ArrayList<String>, updatedProfileId: String = "") {
        if (CallManager.isCallConnected()) {
            callConnectedViewHelper.updateCallMemberDetails(callUsers)
            if (updatedProfileId.isNotEmpty()) {
                callConnectedViewHelper.onUserProfileDetailsUpdatedDuringCall(updatedProfileId)
            }
        } else
            callNotConnectedViewHelper.updateCallMemberDetails(callUsers)
    }

    fun updateCallStatus() {
        if (CallManager.isCallNotConnected() || CallManager.isCallAttended())
            callNotConnectedViewHelper.updateCallStatus()
        else {
            callConnectedViewHelper.updateCallStatus()
            disableCallOptionAnimation()
        }
    }

    fun updateStatusAdapter(userJid: String?) {
        LogMessage.d(TAG, "$CALL_UI callViewHelper updateStatusAdapter userJid: $userJid")
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
        }
    }

    fun updatedRejoinedUsers(userJid: String?) {
        LogMessage.d(TAG, "$CALL_UI callViewHelper updateStatusAdapter userJid: $userJid")
        if (userJid != null) {
            if (CallUtils.getIsGridViewEnabled()) {
                if (!callUserGridAdapter.gridCallUserList.contains(userJid) && CallUtils.getPinnedUserJid() != userJid) {
                    callUserGridAdapter.addUser(userJid)
                }
            } else {
                if (!callUsersListAdapter.callUserList.contains(userJid) && CallUtils.getPinnedUserJid() != userJid) {
                    callUsersListAdapter.addUser(userJid)
                }
            }
        }
    }

    private fun setOverlayBackground() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper $JOIN_CALL setOverlayBackground()")
        if (activity.isInPIPMode())
            binding.viewOverlay.background = null
        else if (CallManager.isCallNotConnected()) {
            if (CallManager.isVideoCall()) {
                LogMessage.d(
                    TAG,
                    "$CALL_UI $JOIN_CALL callViewHelper setOverlayBackground() call not connected and video call set black transparent"
                )
                binding.viewOverlay.setBackgroundColor(
                    ContextCompat.getColor(
                        activity,
                        R.color.color_black_transparent
                    )
                )
            } else {
                LogMessage.d(
                    TAG,
                    "$CALL_UI $JOIN_CALL callViewHelper setOverlayBackground() call not connected and audio call set audio blue call layout!!"
                )
                binding.viewOverlay.background =
                    ContextCompat.getDrawable(activity, R.drawable.ic_audio_call_bg)
            }
        } else {
            LogMessage.d(
                TAG,
                "$CALL_UI $JOIN_CALL callViewHelper setOverlayBackground() call connected isOneToOneVideoCall: ${CallManager.isOneToOneVideoCall()}"
            )
            if (!CallManager.isOneToOneVideoCall())
                binding.viewOverlay.setBackgroundColor(
                    ContextCompat.getColor(
                        activity,
                        R.color.audio_caller_background
                    )
                )
            else
                binding.viewOverlay.background = null
        }
    }

    /**
     * sets icon for the audio device image view based on the selected audio device
     */
    fun setSelectedAudioDeviceIcon() {
        callOptionsViewHelper.setAudioDeviceIcon(CallAudioManager.getInstance(activity).selectedAudioDevice)
    }

    private fun hideCallOptions() {
        callOptionsViewHelper.hideCallOptions()
    }

    private fun showCallOptions() {
        callOptionsViewHelper.showCallOptions()
    }

    fun checkAndUpdateCameraView() {
        callOptionsViewHelper.checkAndUpdateCameraView()
    }

    /**
     * This method animates the call options layout with given animation
     *
     * @param animation             animation id
     * @param callOptionsVisibility visibility to be changed for callOptions view
     * @param arrowVisibility       visibility to be changed for arrow view
     */
    override fun animateCallOptions(
        animation: Int,
        callOptionsVisibility: Int,
        arrowVisibility: Int
    ) {
        callOptionsViewHelper.animateCallOptions(animation, callOptionsVisibility, arrowVisibility)
    }

    fun toggleVideoMute() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper toggleVideoMute()")
        callOptionsViewHelper.toggleVideoMute()
    }

    /**
     * shows buttons to call again or cancel the action.̥
     */
    fun showCallAgainView() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper showCallAgainView")
        hideCallOptions()
        binding.imageMinimizeCall.gone()
        callNotConnectedViewHelper.showRetryLayout()
        retryCallViewHelper.showRetryLayout()
    }

    /**
     * hides the call again view
     */
    fun hideCallAgainView() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper hideCallAgainView()")
        showCallOptions()
        binding.imageMinimizeCall.show()
        callNotConnectedViewHelper.hideRetryLayout()
        retryCallViewHelper.hideRetryLayout()
        callConnectedViewHelper.makeCallAgain()
    }

    fun hidePIPLayout() {
        pipViewHelper.hidePIPLayout()
    }

    fun gotoPIPMode() {
        LogMessage.d(
            TAG,
            "$CALL_UI gotoPIPMode(): ${Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && CallManager.isCallConnected() && !CallUtils.isAddUsersToTheCall()}"
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && CallManager.isCallConnected() && !CallUtils.isAddUsersToTheCall()) {
            if (CommonUtils.isPipModeAllowed(activity)) {
                // Calculate the aspect ratio of the PiP screen.
                CallManager.unbindCallService()
                val aspectRatio = Rational(binding.rootLayout.width, binding.rootLayout.height)
                mPictureInPictureParamsBuilder!!.setAspectRatio(aspectRatio).build()
                val isSuccess =
                    activity.enterPictureInPictureMode(mPictureInPictureParamsBuilder!!.build())
                if (isSuccess) {
                    showPIPLayout()
                }
            } else {
                CommonUtils.openPipModeSettings(activity)
            }
        }
    }

    fun showPIPLayout() {
        // Hide the call controls UI while going to picture-in-picture mode.
        hideCallOptions()
        binding.callOptionsUpArrow.gone()
        binding.imageMinimizeCall.gone()
        callConnectedViewHelper.hideConnectedView()
        pipViewHelper.showPIPLayout()
    }

    private val hideOptionsRunnable = Runnable {
        LogMessage.d(TAG, "$CALL_UI callViewHelper hideOptionsRunnable")
        isAnimateClicked = false
        animateCallOptionsView()
    }

    override fun enableCallOptionAnimation() {
        when {
            CallUtils.getIsGridViewEnabled() -> {
                durationHandler.postDelayed(hideOptionsRunnable, 3000)
                showGridTitle()
            }

            CallManager.isOneToOneAudioCall() -> {
                isAnimateClicked = false
                durationHandler.removeCallbacks(hideOptionsRunnable)
            }

            else -> durationHandler.postDelayed(hideOptionsRunnable, 3000)
        }
    }


    override fun checkOptionArrowVisibility(visibility: Int) {
        binding.callOptionsUpArrow.visibility = visibility
    }


    /**
     * animates the local video view to move down to bottom of the screen
     */
    override fun onCallOptionsHidden() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper onCallOptionsHidden()")

        if(binding.layoutCallOptions.layoutSlowNetwork.poorConnectionRoot.visibility == View.VISIBLE){
            LogMessage.d(TAG, "$CALL_UI skip callViewHelper onCallOptionsHidden() poorConnectionRoot VISIBLE")
            binding.layoutCallOptions.layoutCallOptions.visibility = View.VISIBLE
            return
        }
        val bottomMarginStart =
            binding.layoutCallOptions.layoutCallOptions.height // margin start value
        if (CallManager.isOneToOneCall()) {
            val bottomMarginTo = CommonUtils.convertDpToPixel(activity, 20) // where to animate to
            val params =
                binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams as RelativeLayout.LayoutParams
            if (binding.layoutCallConnected.layoutOneToOneAudioCall.visibility == View.VISIBLE) {
                LogMessage.d(
                    TAG,
                    "$CALL_UI callViewHelper onCallOptionsHidden() layoutOneToOneAudioCall VISIBLE"
                )
                AnimationsHelper.animateViewWithValues(
                    binding.layoutCallConnected.layoutOneToOneAudioCall, bottomMarginStart,
                    bottomMarginTo, Constants.ANIMATION_DURATION
                ) { updatedValue: Int ->
                    params.setMargins(
                        0,
                        0,
                        CommonUtils.convertDpToPixel(activity, 20),
                        updatedValue
                    )
                    binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
                }
            } else {
                LogMessage.d(
                    TAG,
                    "$CALL_UI callViewHelper onCallOptionsHidden() layoutOneToOneAudioCall gone"
                )
                params.setMargins(
                    0,
                    0,
                    CommonUtils.convertDpToPixel(activity, 20),
                    bottomMarginStart
                )
                binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
            }
        } else {
            showListViewAtBottom()
        }
    }

    /**
     * animates the local video view to move up above [.callOptionsLayout]
     */
    override fun onCallOptionsVisible() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper onCallOptionsVisible()")
        val bottomMarginTo =
            binding.layoutCallOptions.layoutCallOptions.height // where to animate to
        if (CallManager.isOneToOneCall()) {
            LogMessage.d(TAG, "$CALL_UI callViewHelper onCallOptionsVisible() isOneToOneCall")
            val bottomMarginStart = CommonUtils.convertDpToPixel(activity, 20) // margin start value
            val params =
                binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams as RelativeLayout.LayoutParams
            if (binding.layoutCallConnected.layoutOneToOneAudioCall.visibility == View.VISIBLE) {
                LogMessage.d(
                    TAG,
                    "$CALL_UI callViewHelper onCallOptionsVisible() isOneToOneCall VISIBLE"
                )
                AnimationsHelper.animateViewWithValues(
                    binding.layoutCallConnected.layoutOneToOneAudioCall,
                    bottomMarginStart,
                    bottomMarginTo,
                    Constants.ANIMATION_DURATION
                ) { updatedValue: Int ->
                    params.setMargins(
                        0,
                        0,
                        CommonUtils.convertDpToPixel(activity, 20),
                        updatedValue
                    )
                    binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
                }
            } else {
                LogMessage.d(
                    TAG,
                    "$CALL_UI callViewHelper onCallOptionsVisible() isOneToOneCall gone"
                )
                params.setMargins(
                    0,
                    0,
                    CommonUtils.convertDpToPixel(activity, 20),
                    bottomMarginTo
                )
                binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
            }
        } else {
            showListViewAboveCallOptions()
        }
    }

    private fun showListViewAtBottom() {
        LogMessage.d(TAG, "$CALL_UI showListViewAtBottom()")
        val bottomMarginEnd = CommonUtils.convertDpToPixel(activity, 20) // margin start value
        val layoutMargin = CommonUtils.convertDpToPixel(activity, 10) // margin value
        val params =
            binding.layoutCallConnected.callUsersRecyclerview.layoutParams as RelativeLayout.LayoutParams
        params.width = RelativeLayout.LayoutParams.MATCH_PARENT
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT

        params.setMargins(layoutMargin, layoutMargin, layoutMargin, bottomMarginEnd)
        binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
    }

    private fun showListViewAboveCallOptions() {
        if (binding.layoutCallConnected.callUsersRecyclerview.visibility != View.VISIBLE) {
            return // 3 users group video call->when any one of the user left, at the time if you go to pipmode and then come to maximize, left user view also visible ->issue fix
        }
        LogMessage.d(TAG, "$CALL_UI callViewHelper showListViewAboveCallOptions()")
        LogMessage.i(
            TAG,
            "$CALL_UI #callconnectionquality  showListViewAboveCallOptions()"
        )
        val bottomMarginTo =
            binding.layoutCallOptions.layoutCallOptions.height // where to animate to
        val layoutMargin = CommonUtils.convertDpToPixel(activity, 10) // margin value
        val params =
            binding.layoutCallConnected.callUsersRecyclerview.layoutParams as RelativeLayout.LayoutParams
        params.width = RelativeLayout.LayoutParams.MATCH_PARENT
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT

        params.addRule(RelativeLayout.ABOVE, binding.layoutCallOptions.layoutCallOptions.id) // Align RecyclerView's bottom to the top of the bottomView
        params.setMargins(layoutMargin, layoutMargin, layoutMargin, bottomMarginTo)
        binding.layoutCallConnected.callUsersRecyclerview.layoutParams = params
    }

    /**
     * animates the call options layout with respect to it's visibility
     */
    override fun animateCallOptionsView(isTouch: Boolean) {
        if (!isAnimateClicked) {
            durationHandler.removeCallbacks(hideOptionsRunnable)
            isAnimateClicked = true
            LogMessage.d(TAG, "$CALL_UI callViewHelper animateCallOptionsView()")
            if (!CallManager.isCallConnected() || CallUtils.isAddUsersToTheCall()
                || !CallUtils.getIsGridViewEnabled() && (CallManager.isOneToOneAudioCall()
                        || CallManager.isOneToOneRemoteVideoMuted()
                        || CallManager.isReconnecting())
            ) {
                if (!binding.layoutCallOptions.layoutCallOptions.isVisible) {
                    animateCallOptions(com.contus.call.R.anim.slide_up, View.VISIBLE, View.GONE)
                    animateCallDetails(com.contus.call.R.anim.slide_out_down, View.VISIBLE)
                }
                isAnimateClicked = false
                return
            }

            if (GroupCallUtils.isSingleUserInCall()){
                isAnimateClicked = false
                return
            }

            if (CallUtils.getIsGridViewEnabled())
                animateGridView()
            else
                animateListView(isTouch)
        }
    }

    private fun clearAnimation(){
        binding.layoutCallOptions.layoutCallOptions.clearAnimation()
        binding.layoutCallConnected.layoutTitle.clearAnimation()
        binding.layoutCallConnected.callGridUsersRecyclerview.clearAnimation()
    }

    private fun animateGridView() {
        clearAnimation()
        isAnimateClicked = false
        LogMessage.d(TAG, "$CALL_UI callViewHelper animateCallOptionsView animateGridView()")
        durationHandler.removeCallbacks(hideOptionsRunnable)
        if (binding.layoutCallOptions.layoutCallOptions.visibility == View.VISIBLE && binding.layoutCallConnected.layoutTitle.visibility == View.VISIBLE) {
            animateCallOptions(R.anim.slide_down, View.GONE, View.GONE)
            animateGridCallDetails(R.anim.slide_out_up, View.GONE)
        } else {
            animateCallOptions(R.anim.slide_up, View.VISIBLE, View.GONE)
            animateGridCallDetails(R.anim.slide_out_down, View.VISIBLE)
        }
    }

    private fun animateGridCallDetails(animation: Int, callDetailsVisibility: Int) {
        val slideUpAnimation = AnimationUtils.loadAnimation(activity, animation)
        binding.layoutCallConnected.layoutTitle.startAnimation(slideUpAnimation)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                /* not needed */
            }

            override fun onAnimationEnd(animation: Animation) {
                binding.layoutCallConnected.layoutTitle.visibility = callDetailsVisibility
            }

            override fun onAnimationRepeat(animation: Animation) {
                /* not needed */
            }
        })
        if (callDetailsVisibility == View.VISIBLE) onCallTitleVisible() else onCallTitleHidden()
    }

    private fun onCallTitleHidden() {
        LogMessage.d(TAG, "$CALL_UI onCallTitleHidden()")
        val bottomMarginStart = binding.layoutCallConnected.layoutTitle.height // margin start value
        val bottomMarginTo = CommonUtils.convertDpToPixel(activity, 8) // where to animate to
        val params =
            binding.layoutCallConnected.callGridUsersRecyclerview.layoutParams as RelativeLayout.LayoutParams

        AnimationsHelper.animateViewWithValues(
            binding.layoutCallConnected.callGridUsersRecyclerview,
            bottomMarginStart, bottomMarginTo, Constants.ANIMATION_DURATION
        ) { updatedValue: Int ->
            params.setMargins(
                bottomMarginTo, updatedValue + bottomMarginTo, bottomMarginTo, bottomMarginTo
            )
            binding.layoutCallConnected.callGridUsersRecyclerview.layoutParams = params
        }
    }

    private fun onCallTitleVisible() {
        LogMessage.d(TAG, "$CALL_UI onCallTitleVisible()")
        val bottomMarginStart = CommonUtils.convertDpToPixel(activity, 8) // margin start value
        val bottomMarginTo = binding.layoutCallConnected.layoutTitle.height // where to animate to
        val params =
            binding.layoutCallConnected.callGridUsersRecyclerview.layoutParams as RelativeLayout.LayoutParams

        AnimationsHelper.animateViewWithValues(
            binding.layoutCallConnected.callGridUsersRecyclerview,
            bottomMarginStart, bottomMarginTo, Constants.ANIMATION_DURATION
        ) { updatedValue: Int ->
            params.setMargins(
                bottomMarginStart, updatedValue + bottomMarginStart,
                bottomMarginStart, bottomMarginStart
            )
            binding.layoutCallConnected.callGridUsersRecyclerview.layoutParams = params
        }
    }

    override fun showGridTitle() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper showGridTitle()")
        val bottomMarginStart = CommonUtils.convertDpToPixel(activity, 8) // margin start value
        binding.layoutCallConnected.backgroundView.gone()
        binding.layoutCallConnected.backgroundView.post {
            val bottomMarginTo =
                binding.layoutCallConnected.layoutTitle.height // where to animate to
            val params =
                binding.layoutCallConnected.callGridUsersRecyclerview.layoutParams as RelativeLayout.LayoutParams
            params.setMargins(
                bottomMarginStart,
                bottomMarginTo + bottomMarginStart,
                bottomMarginStart,
                bottomMarginStart
            )
            binding.layoutCallConnected.callGridUsersRecyclerview.layoutParams = params
        }
    }

    private fun animateListView(isTouch: Boolean) {
        LogMessage.d(TAG, "$CALL_UI animateListView()")
        if (CallManager.isOneToOneCall()) animateOneToOneCallOption(isTouch) else animateGroupListView()
    }

    private fun animateOneToOneCallOption(isTouch: Boolean) {
        LogMessage.d(TAG, "$CALL_UI animateOneToOneCallOption() isTouch: $isTouch")
        animateOnetoOne()
    }

    private fun animateOnetoOne(){
        if (binding.layoutCallOptions.layoutCallOptions.visibility == View.VISIBLE) {
            animateCallOptions(com.contus.call.R.anim.slide_down, View.GONE, View.VISIBLE)
            animateCallDetails(com.contus.call.R.anim.slide_out_up, View.GONE)
            isAnimateClicked = false
            durationHandler.removeCallbacks(hideOptionsRunnable)
        } else {
            animateCallOptions(com.contus.call.R.anim.slide_up, View.VISIBLE, View.GONE)
            animateCallDetails(com.contus.call.R.anim.slide_out_down, View.VISIBLE)
            isAnimateClicked = false
        }
    }

    /**
     * This method animates the call options layout with List View
     */
    private fun animateGroupListView() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper animateCallOptionsView animateGroupListView()")
        if (binding.layoutCallOptions.layoutCallOptions.visibility == View.VISIBLE) {
            animateCallOptions(R.anim.slide_down, View.GONE, View.GONE)
            animateCallDetails(R.anim.slide_out_up, View.GONE)
            isAnimateClicked = false
            durationHandler.removeCallbacks(hideOptionsRunnable)
        } else {
            animateCallOptions(R.anim.slide_up, View.VISIBLE, View.GONE)
            animateCallDetails(R.anim.slide_out_down, View.VISIBLE)
            durationHandler.postDelayed(hideOptionsRunnable, 3000)
        }
    }

    /**
     * This method animates the call options layout with given animation
     *
     * @param animation             animation id
     * @param callDetailsVisibility visibility to be changed for callDetails view
     */
    private fun animateCallDetails(animation: Int, callDetailsVisibility: Int) {
        val slideUpAnimation = AnimationUtils.loadAnimation(activity, animation)
        binding.layoutCallConnected.layoutTitle.startAnimation(slideUpAnimation)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                /* not needed */
            }

            override fun onAnimationEnd(animation: Animation) {
                binding.layoutCallConnected.layoutTitle.visibility = callDetailsVisibility
            }

            override fun onAnimationRepeat(animation: Animation) {
                /* not needed */
            }
        })
    }

    fun disconnectCall() {
        isAnimateClicked = false
        durationHandler.removeCallbacks(hideOptionsRunnable)
        durationHandler.removeCallbacks(updateTimerThread)
        releaseSurfaceViews()
        resetAnswerRejectCallButtonState()
    }

    private fun resetAnswerRejectCallButtonState(){
        incomingCallViewHelper.resetButtonState()
    }

    /**
     * Release video view surface while disconnect the call
     */
    private fun releaseSurfaceViews() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper #surface releaseSurfaceViews: remoteView")
        binding.layoutCallConnected.viewVideoLocal.release()
        binding.layoutCallConnected.viewVideoPinned.release()
        val bundle = Bundle()
        bundle.putInt(CallActions.NOTIFY_REMOTE_VIEW_RELEASE, 1)
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

    private fun updateCallConnectedLayout(callStatus: String, animation: Animation) {
        binding.layoutCallConnected.textCallDuration.text = callStatus
        if (binding.layoutCallConnected.layoutTitle.visibility == View.GONE) {
            if (CallUtils.getIsGridViewEnabled())
                animateGridView()
            else {
                animateCallDetails(com.contus.call.R.anim.slide_out_down, View.VISIBLE)
                animateCallOptions(com.contus.call.R.anim.slide_up, View.VISIBLE, View.GONE)
            }
        }

        if (binding.layoutCallConnected.textCallDuration.visibility == View.VISIBLE) {
            binding.layoutCallConnected.textCallDuration.startAnimation(animation)
            activityFinishWithdelay()
        } else {
            activity.finish()
            CallLogger.callTestingLog("UIKIT---> updateCallConnectedLayout via activity.finish() called")
        }
    }

    //Some time Animation not working properly so that time actiivty not finished so safer side added some delay logic
    private fun activityFinishWithdelay() {
        try {
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                if(!activity.isDestroyed) {
                    CallLogger.callTestingLog("UIKIT---> updateCallConnectedLayout Handler Via Activity Destroyed..")
                    activity.finish()
                }
            },1500)
        } catch(e: Exception) {
            LogMessage.e(TAG,"hander exception $e")
            CallLogger.callTestingLog("UIKIT---> hander exception $e",true)
        }
    }

    fun updateDisconnectedStatus(callStatus: String) {
        LogMessage.d(
            TAG,
            "$CALL_UI #JOIN_CALL #disconnect callViewHelper updateDisconnectedStatus: isCallUIVisible():${isCallUIVisible()} GroupCallUtils.isCallLinkBehaviourMeet(): ${GroupCallUtils.isCallLinkBehaviourMeet()}"
        )
        if (isCallUIVisible()) {
            val animation = AnimationUtils.loadAnimation(activity, com.contus.call.R.anim.blink)
            LogMessage.d(
                TAG,
                "$CALL_UI #JOIN_CALL #disconnect callViewHelper updateDisconnectedStatus: callDuration.isNotBlank() :${callDuration.isNotBlank()} CallManager.isCallConnected(): ${CallManager.isCallConnected()}"
            )
            if (callDuration.isNotBlank() || CallManager.isCallConnected()) {
                updateCallConnectedLayout(callStatus, animation)
            } else {
                binding.layoutCallNotConnected.textCallStatus.text = callStatus
                binding.layoutCallNotConnected.textCallStatus.startAnimation(animation)
                activityFinishWithdelay()
                CallLogger.callTestingLog("UIKIT---> updateCallConnectedLayout called isViewVisibility : ${binding.layoutCallConnected.textCallStatus.visibility}")
                if (binding.layoutCallNotConnected.textCallStatus.visibility != View.VISIBLE) {
                    activity.finish()
                }
            }
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    if (callStatus == CallStatus.DISCONNECTED) // while disconnecting the call, simultaneously new call receives which showing the ui without closing the group call activity. so pre-set variables doesnt reset and which causes the issue couldnt able to accept the call.
                        activity.finish()
                    LogMessage.d(TAG,"on animation start-->")
                    /* not needed */
                }

                override fun onAnimationEnd(animation: Animation) {
                    activity.finish()
                }

                override fun onAnimationRepeat(animation: Animation) {
                    LogMessage.d(TAG,"$CALL_UI #Disconnect #onAnimationRepeat")
                }
            })
        } else
            activity.finish()
    }

    private fun isCallUIVisible(): Boolean {
        return !(activity.isInPIPMode()) && AppLifecycleListener.isForeground && !CallUtils.isAddUsersToTheCall() && callDuration.isNotBlank()
    }

    fun updateRemoteAudioMuteStatus(userJid: String) {
        CallUtils.clearPeakSpeakingUser(userJid)
        callConnectedViewHelper.updateRemoteAudioMuteStatus()
        callConnectedViewHelper.onUserStoppedSpeaking(userJid)
        if (CallUtils.getIsGridViewEnabled()) {
            val gridIndex = callUserGridAdapter.gridCallUserList.indexOf(userJid)
            if (gridIndex.isValidIndex()) {
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_VIEW_MUTE_UPDATED, 1)
                callUserGridAdapter.notifyItemChanged(gridIndex, bundle)
            }
        } else {
            val index = callUsersListAdapter.callUserList.indexOf(userJid)
            if (index.isValidIndex()) {
                val bundle = Bundle()
                bundle.putInt(CallActions.NOTIFY_VIEW_MUTE_UPDATED, 1)
                callUsersListAdapter.notifyItemChanged(index, bundle)
            }
        }
    }

    /**
     * In a video call once local video track available this method will be triggered
     */
    fun onLocalVideoTrackAdded() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper onLocalVideoTrackAdded()")
        if (!CallUtils.isActivityDestroyed(activity)) {
            if (!activity.isInPIPMode()) {
                callConnectedViewHelper.onLocalVideoTrackAdded()
            }
        } else LogMessage.d(
            TAG,
            "$CALL_UI callViewHelper onLocalVideoTrackAdded Activity Destroyed"
        )
    }

    /**
     * After the video call is connected the video view will be placed near call options view
     */
    fun onVideoTrackAdded(userJid: String) {
        LogMessage.d(TAG, "$CALL_UI callViewHelper onVideoTrackAdded():$userJid")
        if (!CallUtils.isActivityDestroyed(activity)) {
            if (activity.isInPIPMode()) {
                pipViewHelper.onVideoTrackAdded(userJid)
            } else {
                callConnectedViewHelper.onVideoTrackAdded(userJid)
                if (CallManager.isOneToOneCall())
                    resizeLocalTile(false)
            }
        } else LogMessage.d(TAG, "$CALL_UI callViewHelper onVideoTrackAdded Activity Destroyed")
    }

    /**
     * When single user is in meet call we call below method to resize
     * layout one to one audio call which has been programmatically changed to
     * align above layout call options.
     */
    private fun reSizeLocalTileForSingleUserMeetBehaviourCall() {
        LogMessage.d(TAG, "$CALL_UI callViewHelper reSizeLocalTileForSingleUserMeetBehaviourCall")
        if (GroupCallUtils.isSingleUserInCall()) {
            val params =
                binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams as RelativeLayout.LayoutParams
            params.height = ViewGroup.LayoutParams.MATCH_PARENT
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            params.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            params.setMargins(0, 0, 0, 0)
            binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
            LogMessage.i(TAG, "$CALL_UI callViewHelper reset one to one call params")
        }
    }

    private fun resizeLocalTile(isCallOptionAnimation:Boolean) {


        if (GroupCallUtils.isSingleUserInCall()) {
            LogMessage.d(TAG, "$CALL_UI callViewHelper resizeLocalTile singleUserInCall")
            reSizeLocalTileForSingleUserMeetBehaviourCall()
        } else if (CallManager.isLocalTileCanResize()) {
            LogMessage.d(TAG, "$CALL_UI callViewHelper resizeLocalTile isLocalTileCanResize")

            val params =
                binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams as RelativeLayout.LayoutParams
            val rightMargin = CommonUtils.convertDpToPixel(activity, 20)
            /* align video view bottom in right-center of call options layout */
            if (binding.layoutCallOptions.layoutCallOptions.visibility == View.VISIBLE) {
                // once view measured, get height
                binding.layoutCallOptions.layoutCallOptions.post {
                    params.height = actualScreenHeight / 5
                    params.width = (actualScreenWidth / 3.5).roundToInt()
                    val callOptionsHeight = binding.layoutCallOptions.layoutCallOptions.height
                    params.setMargins(0, 0, rightMargin, callOptionsHeight)
                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
                    binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
                    LogMessage.i(TAG, "$CALL_UI Set video layout params on view post")
                }
            } else {
                params.height = actualScreenHeight / 5
                params.width = (actualScreenWidth / 3.5).roundToInt()
                params.setMargins(0, 0, rightMargin, rightMargin)
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
                binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
                LogMessage.i(TAG, "$CALL_UI Set video layout params")
            }
        } else {
            LogMessage.i(TAG, "$CALL_UI resizeLocalTile skip one to one call tile update")
            if (!CallUtils.getIsListViewAnimated() && isCallOptionAnimation)
                animateListViewWithCallOptions()
        }
    }

    override fun animateListViewWithCallOptions() {

        LogMessage.i(
            TAG,
            "$CALL_UI callViewHelper animateListViewWithCallOptions CallManager.isCallConnected(): ${CallManager.isCallConnected()}"
        )

        if (GroupCallUtils.isSingleUserInCall())
            return
        if (!CallUtils.getIsGridViewEnabled() && CallManager.isCallConnected())
            binding.layoutCallOptions.layoutCallOptions.post {
                if(!binding.layoutCallOptions.layoutCallOptions.isVisible) {
                    Handler(Looper.getMainLooper()).postDelayed(Runnable {
                        animateListViewCallOption()
                    },1000)
                } else {
                    animateListViewCallOption()
                }
            }
    }


    private fun animateListViewCallOption(){
        CallUtils.setIsListViewAnimated(true)
        if (binding.layoutCallOptions.layoutCallOptions.visibility == View.VISIBLE ) {
            val layoutMargin = CommonUtils.convertDpToPixel(activity, 20)
            if (layoutMargin >= binding.layoutCallConnected.callUsersRecyclerview.marginBottom || CallUtils.getIsFromPoorInternetUpdate())
                showListViewAboveCallOptions()
        } else
            showListViewAtBottom()
    }

    /*
    * Update List view alignment while 1-1 call converted into 1-Many call
    */
    fun showListView() {
        LogMessage.i(TAG, "$CALL_UI callViewHelper showListView()")
        if (CallUtils.getIsGridViewEnabled())
            return
        if (binding.layoutCallOptions.layoutCallOptions.visibility == View.VISIBLE) {
            val layoutMargin = CommonUtils.convertDpToPixel(activity, 20)
            if (layoutMargin >= binding.layoutCallConnected.callUsersRecyclerview.marginBottom) {
                val bottomMarginTo =
                    binding.layoutCallOptions.layoutCallOptions.height // where to animate to
                val margin = CommonUtils.convertDpToPixel(activity, 10) // margin value
                val params =
                    binding.layoutCallConnected.callUsersRecyclerview.layoutParams as RelativeLayout.LayoutParams
                params.width = RelativeLayout.LayoutParams.MATCH_PARENT
                params.height = RelativeLayout.LayoutParams.WRAP_CONTENT
                params.setMargins(margin, margin, margin, bottomMarginTo)
                binding.layoutCallConnected.callUsersRecyclerview.layoutParams = params
            }
        } else {
            val bottomMarginEnd = CommonUtils.convertDpToPixel(activity, 20) // margin start value
            val layoutMargin = CommonUtils.convertDpToPixel(activity, 10) // margin value
            val params =
                binding.layoutCallConnected.callUsersRecyclerview.layoutParams as RelativeLayout.LayoutParams
            params.width = RelativeLayout.LayoutParams.MATCH_PARENT
            params.height = RelativeLayout.LayoutParams.WRAP_CONTENT
            params.setMargins(layoutMargin, layoutMargin, layoutMargin, bottomMarginEnd)
            binding.layoutCallConnected.layoutOneToOneAudioCall.layoutParams = params
        }
    }

    fun setMirrorLocalView() {
        callConnectedViewHelper.setMirrorLocalView()
    }

    override fun onSwapVideo() {
        callConnectedViewHelper.onSwapVideo()
    }

    fun updatePinnedUserVideoMuteStatus() {
        LogMessage.d(TAG, "$CALL_UI setVideoMuteStatus() updatePinnedUserVideoMuteStatus ")
        callConnectedViewHelper.updatePinnedUserVideoMuteStatus()
        callConnectedViewHelper.updateRemoteAudioMuteStatus() // Update audio mute icon position based on video mute
    }

    override fun pinnedUserRemoved() {
        CallUtils.setIsUserTilePinned(false)
        callConnectedViewHelper.updatePinnedUserIcon()
    }

    override fun onConversionRequestAcceptSwapVideo() {
        callOptionsViewHelper.conversionRequestAcceptSwapVideo()
    }

    fun pinnedUserChanged(userJid: String) {
        CallUtils.setIsUserTilePinned(true)
        callConnectedViewHelper.pinnedUserChanged(userJid)
        callConnectedViewHelper.updatePinnedUserIcon(userJid)
    }

    fun pinnedUserLeft(userJid: String) {
        CallUtils.setIsUserTilePinned(false)
        callConnectedViewHelper.pinnedUserLeft(userJid)
        callConnectedViewHelper.updatePinnedUserIcon()
    }

    override fun ownAudioMuteStatusUpdated() {
        callConnectedViewHelper.ownAudioMuteStatusUpdated()
    }

    fun onUserStoppedSpeaking(userJid: String) {
        if (CallManager.isCallConnected()) {
            if (activity.isInPIPMode())
                pipViewHelper.onUserStoppedSpeaking(userJid)
            else
                callConnectedViewHelper.onUserStoppedSpeaking(userJid)
            CallUtils.onUserStoppedSpeaking(userJid)
        }
    }

    fun onUserSpeaking(userJid: String, audioLevel: Int) {
        val userStatus = GroupCallUtils.getCallStatus(userJid)
        if (CallManager.isCallConnected() && !userStatus.equals(CallStatus.RECONNECTING,false)) {
            CallUtils.onUserSpeaking(userJid, audioLevel)
            if (activity.isInPIPMode())
                pipViewHelper.onUserSpeaking(userJid, audioLevel)
            else
                callConnectedViewHelper.onUserSpeaking(userJid, audioLevel)
        }
    }

    fun updateFeatureActions() {
        callConnectedViewHelper.checkAddParticipantsAvailable()
    }

    fun updatePoorConnectionLayout(){
        showCallOptions()
        CallUtils.setIsFromPoorInternetUpdate(true)
        CallUtils.setIsListViewAnimated(false)
        resizeLocalTile(false)
    }
    fun updateUiForCallConnectionQuality(){
        callConnectedViewHelper.checkAndShowPoorConnectionQuality()
    }

    override fun isAnimationStarted(): Boolean {
        return callOptionsViewHelper.isAnimationStarted
    }

    override fun disableCallOptionAnimation() {
        isAnimateClicked = false
        durationHandler.removeCallbacks(hideOptionsRunnable)
    }

    fun updateCallNotConnected(){
        if(CallManager.isCallAttended()){
            callNotConnectedViewHelper.setUpCallUIForCallAttended()
        }
    }
}