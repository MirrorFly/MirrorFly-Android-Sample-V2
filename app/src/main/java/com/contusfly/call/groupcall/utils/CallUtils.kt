package com.contusfly.call.groupcall.utils

import android.app.Activity
import android.content.Context
import androidx.core.content.ContextCompat
import com.contus.call.CallConstants
import com.contus.call.CallConstants.JOIN_CALL
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.call.groupcall.isUserVideoMuted
import com.contusfly.getDisplayName
import com.contusfly.isDeletedContact
import com.contusfly.loadUserProfileImage
import com.contusfly.makeViewsGone
import com.contusfly.show
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.views.CircularImageView
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flycall.webrtc.Logger
import com.mirrorflysdk.flycall.webrtc.ProxyVideoSink
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.ChatUtils
import com.mirrorflysdk.utils.Utils
import kotlin.collections.set

object CallUtils {

    const val IS_CALL_NOTIFICATION = "is_call_notification"
    const val ACTION_PHONE_CALL_STATE_CHANGED = "call.action.PHONE_CALL_STATE_CHANGED"

    /**
     * flag indicates whether group call grid view is showing or not
     */
    private var isGridViewEnabled = false

    private var isVideoViewInitialized = false

    /**
     * boolean represents whether we have to show calls tab or not.
     */
    private var showCallsTab = false

    /**
     * Boolean stating whether if add participant in progress
     */
    private var isAddUsersToTheCall = false

    /**
     * flag indicates whether call grid/list view updates currently happening
     */
    private var isViewUpdatesCompleted = true

    /**
     * flag indicates whether list view is showing above call options
     */
    private var isListViewAnimated = false

    /**
     * Contains the user jid which need to be showed in pinned view
     */
    private var pinnedUserJid = Constants.EMPTY_STRING

    /**
     * flag indicates whether user tile pinned
     */
    private var isUserTilePinned = false

    /**
     * Boolean to identify whether the action is with respect to the call initiation.
     */
    private var mIsCallStarted: String? = null

    /**
     * This indicates whether the back camera capturing or not
     */
    private var isBackCameraCapturing = false

    /**
     * flag indicates which user audio level reaches peak
     */
    private var peakSpeakingUser = SpeakingUser(Constants.EMPTY_STRING, 0)

    private val speakingLevelMap by lazy { HashMap<String, Int>() }

    /**
     * Flag to update list view options
     */
    private var isFromPoorInternetUpdate = false

    private var isTileViewScrolling = false

    fun setIsTileViewScrolling(boolean: Boolean) {
        LogMessage.e("tileScroll","set tileview scrolling-->$boolean")
        isTileViewScrolling = boolean
    }

    fun isTileViewScrolling():Boolean{
        LogMessage.e("tileScroll","iscroll-->$isTileViewScrolling")
        return isTileViewScrolling
    }


    fun setVideoViewInitialization(enabled: Boolean) {
        isVideoViewInitialized = enabled
    }

    fun getIsVideoViewInitialized(): Boolean {
        return isVideoViewInitialized
    }

    fun setIsGridViewEnabled(enabled: Boolean) {
        isGridViewEnabled = enabled
    }

    fun getIsGridViewEnabled(): Boolean {
        return isGridViewEnabled
    }

    fun setIsViewUpdatesCompleted(boolean: Boolean) {
        isViewUpdatesCompleted = boolean
    }

    fun getIsViewUpdatesCompleted(): Boolean {
        return isViewUpdatesCompleted
    }

    fun setIsListViewAnimated(animated: Boolean) {
        isListViewAnimated = animated
    }

    fun getIsListViewAnimated(): Boolean {
        return isListViewAnimated
    }

    fun setPinnedUserJid(userJid: String) {
        LogMessage.d(TAG, "${CallConstants.CALL_UI} $JOIN_CALL setPinnedUserJid userJid:$userJid")
        pinnedUserJid = userJid
    }

    fun getPinnedUserJid(): String {
        return pinnedUserJid
    }

    fun setIsUserTilePinned(pinned: Boolean) {
        isUserTilePinned = pinned
    }

    fun getIsUserTilePinned(): Boolean {
        return isUserTilePinned
    }

    fun setIsBackCameraCapturing(isBackCamera: Boolean) {
        isBackCameraCapturing = isBackCamera
    }

    fun getIsBackCameraCapturing(): Boolean {
        return isBackCameraCapturing
    }

    private fun setPeakSpeakingUser(userJid: String, audioLevel: Int) {
        peakSpeakingUser = SpeakingUser(userJid, audioLevel)
    }

    private fun getPeakSpeakingUser(): SpeakingUser {
        return peakSpeakingUser
    }

    fun isSpeakingUserCanBeShownOnTop(userJid: String, audioLevel: Int): Boolean {
        return userJid != CallManager.getCurrentUserId() // Local User view no need to move to top
                && !getIsUserTilePinned()  // If any user is pinned then no need to move to top
                && !CallManager.isOneToOneCall() // In 1-1 call no need to move speaking user to top
                && isSpeakingLevelsReceivedForSameUser(userJid, audioLevel)
                && !getIsGridViewEnabled() // In Grid view no need to move speaking user to top
    }

    /*
    * This function will decide whether speaking level received continuously for same user
    */
    private fun isSpeakingLevelsReceivedForSameUser(userJid: String, audioLevel: Int): Boolean {
        return if (getPeakSpeakingUser().userJid == userJid) {
            getPeakSpeakingUser().audioLevel = audioLevel
            if (getPeakSpeakingUser().count >= 2 && userJid != getPinnedUserJid()) {
                getPeakSpeakingUser().count = 0
                true
            } else {
                getPeakSpeakingUser().count++
                false
            }
        } else {
            if (getPeakSpeakingUser().audioLevel <= audioLevel)
                setPeakSpeakingUser(userJid, audioLevel)
            false
        }
    }

    fun onUserSpeaking(userJid: String, audioLevel: Int) {
        speakingLevelMap[userJid] = audioLevel
    }

    fun onUserStoppedSpeaking(userJid: String) {
        speakingLevelMap[userJid] = 0
    }

    fun getUserSpeakingLevel(userJid: String): Int {
        return speakingLevelMap[userJid] ?: 0
    }

    fun clearSpeakingLevels() {
        speakingLevelMap.clear()
        setPeakSpeakingUser(Constants.EMPTY_STRING, 0)
    }

    fun clearPeakSpeakingUser(userJid: String) {
        if (getPeakSpeakingUser().userJid == userJid)
            setPeakSpeakingUser(userJid, 0)
    }

    fun setGroupMemberProfile(
        context: Context,
        callUsers: ArrayList<String>,
        imageCallMember1: CircularImageView,
        imageCallMember2: CircularImageView,
        imageCallMember3: CircularImageView,
        imageCallMember4: CircularImageView
    ): StringBuilder {
        makeViewsGone(imageCallMember2, imageCallMember3, imageCallMember4)
        var membersName = StringBuilder("")
        var isMaxMemberNameNotReached = true
        for (i in callUsers.indices) {
            val pair = getNameAndProfileDetails(callUsers[i])
            if (i == 0) {
                val actualMemberName = getActualMemberName(StringBuilder(pair.first))
                membersName = actualMemberName.first
                isMaxMemberNameNotReached = actualMemberName.second
                loadUserProfilePic(context, imageCallMember1, pair)
            } else if (isMaxMemberNameNotReached && i == 1) {
                membersName.append(", ").append(pair.first)
                val actualMemberName = getActualMemberName(membersName)
                membersName = actualMemberName.first
                isMaxMemberNameNotReached = actualMemberName.second
                imageCallMember2.show()
                loadUserProfilePic(context, imageCallMember2, pair)
            } else if (isMaxMemberNameNotReached && i == 2) {
                membersName.append(", ").append(pair.first)
                val actualMemberName = getActualMemberName(membersName)
                membersName = actualMemberName.first
                imageCallMember3.show()
                loadUserProfilePic(context, imageCallMember3, pair)
            } else {
                membersName.append(" (+").append(callUsers.size - i).append(")")
                imageCallMember4.show()
                val text = "+${callUsers.size - i}"
                val setDrawable = SetDrawable(context)
                imageCallMember4.setImageDrawable(setDrawable.setDrawableForCustomName(text))
                break
            }
        }
        return membersName
    }

    private fun loadUserProfilePic(
        context: Context,
        callMember: CircularImageView,
        pair: Pair<String, ProfileDetails?>
    ) {
        if (pair.second != null) callMember.loadUserProfileImage(context, pair.second!!)
        else callMember.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_profile))
    }

    private fun getNameAndProfileDetails(jid: String): Pair<String, ProfileDetails?> {
        val profileDetails = ProfileDetailsUtils.getProfileDetails(jid)
        val name = if (profileDetails != null) {
            com.contusfly.utils.Utils.returnEmptyStringIfNull(profileDetails.getDisplayName())
        } else Utils.getFormattedPhoneNumber(ChatUtils.getUserFromJid(jid))
            ?: Constants.EMPTY_STRING
        return Pair(name, profileDetails)
    }


    private fun getActualMemberName(stringBuilder: java.lang.StringBuilder): Pair<StringBuilder, Boolean> {
        return if (stringBuilder.length > CallConstants.MAX_NAME_LENGTH)
            Pair(
                StringBuilder(
                    stringBuilder.substring(
                        0,
                        CallConstants.MAX_NAME_LENGTH
                    )
                ).append("..."),
                false
            )
        else
            Pair(stringBuilder, true)
    }

    fun getGroupMembersName(callUsers: ArrayList<String>, groupID: String): String {
        if (groupID.isNotBlank()) {
            return ProfileDetailsUtils.getDisplayName(groupID)
        }
        var membersName = StringBuilder(if (callUsers.size <= 1) "You and " else "You, ")
        var isMaxMemberNameNotReached = true
        for (i in callUsers.indices) {
            val pair = getNameAndProfileDetails(callUsers[i])
            if (i == 0) {
                membersName.append(pair.first)
                val actualMemberName = getActualMemberName(membersName)
                membersName = actualMemberName.first
                isMaxMemberNameNotReached = actualMemberName.second
            } else if (isMaxMemberNameNotReached && i == 1) {
                membersName.append(", ").append(pair.first)
                val actualMemberName = getActualMemberName(membersName)
                membersName = actualMemberName.first
                isMaxMemberNameNotReached = actualMemberName.second
            } else if (isMaxMemberNameNotReached && i == 2) {
                membersName.append(", ").append(pair.first)
                val actualMemberName = getActualMemberName(membersName)
                membersName = actualMemberName.first
            } else {
                membersName.append(" (+").append(callUsers.size - i).append(")")
                break
            }
        }
        return membersName.toString()
    }

    fun getCallUsersName(callUsers: ArrayList<String>): StringBuilder {
        var name = StringBuilder("")
        for (i in callUsers.indices) {
            if (i == 2) {
                name.append(" and (+").append(callUsers.size - i).append(")")
                break
            } else if (i == 1) {
                name.append(", ").append(ProfileDetailsUtils.getDisplayName(callUsers[i]))
            } else {
                name = StringBuilder(ProfileDetailsUtils.getDisplayName(callUsers[i]))
            }
        }
        return name
    }

    /**
     * this method return the user jid for the call
     */
    fun getCallLogUserJidList(
        toUser: String?,
        callUsers: List<String>? = null,
        withDeletedUser: Boolean = true
    ): List<String> {
        val userList = mutableListOf<String>()
        if (toUser != null
            && toUser != CallManager.getCurrentUserId()
            && (withDeletedUser || ProfileDetailsUtils.getProfileDetails(toUser)
                ?.isDeletedContact() != true)
        )
            userList.add(toUser)
        if (callUsers != null) {
            for (jid in callUsers) {
                if (jid != CallManager.getCurrentUserId()
                    && !userList.contains(jid)
                    && (withDeletedUser || ProfileDetailsUtils.getProfileDetails(jid)
                        ?.isDeletedContact() != true)
                )
                    userList.add(jid)
            }
        }
        return userList
    }

    fun getCallLogUserNames(toUser: String?, callUsers: List<String>? = null): String {
        val userNames = mutableListOf<String?>()
        if (toUser != null && toUser != CallManager.getCurrentUserId()) {
            userNames.add(ProfileDetailsUtils.getDisplayName(toUser))
        }
        if (callUsers != null) {
            for (jid in callUsers) {
                if (jid.isNotEmpty()
                    && jid != CallManager.getCurrentUserId()
                    && !userNames.contains(ProfileDetailsUtils.getDisplayName(jid))
                )
                    userNames.add(ProfileDetailsUtils.getDisplayName(jid))
            }
        }
        return userNames.filter { !it.isNullOrEmpty() }.joinToString(", ")
    }

    fun getPinnedVideoSink(): ProxyVideoSink? {
        return if (getPinnedUserJid() == CallManager.getCurrentUserId())
            CallManager.getLocalProxyVideoSink()
        else
            CallManager.getRemoteProxyVideoSink(getPinnedUserJid())
    }

    fun getVideoSinkForUser(userJid: String): ProxyVideoSink? {
        return if (userJid == CallManager.getCurrentUserId())
            CallManager.getLocalProxyVideoSink()
        else
            CallManager.getRemoteProxyVideoSink(userJid)
    }

    fun isLocalUserPinned(): Boolean {
        return getPinnedUserJid() == CallManager.getCurrentUserId()
    }

    fun getPinnedUserVideoMuted(): Boolean {
        return CallManager.isUserVideoMuted(getPinnedUserJid())
    }

    /**
     * Determines whether the action is in respect to the call initiation.
     *
     * @return string representing the call action.
     */
    fun getIsCallStarted(): String? {
        return mIsCallStarted
    }

    /**
     * Sets the boolean if the action is related to call initiation.
     *
     * @param isCallStarted string stating the call action.
     */
    @JvmStatic
    fun setIsCallStarted(isCallStarted: String?) {
        mIsCallStarted = isCallStarted
    }

    /*
     *
     * Method to check the activity is destroyed or finished
     *  @param activity instance of an activity.
     * */
    @JvmStatic
    fun isActivityDestroyed(activity: Activity): Boolean {
        return activity.isDestroyed
    }

    /**
     * @return boolean returns whether we have to show calls tab or not
     */
    fun isCallsTabToBeShown(): Boolean {
        return showCallsTab
    }

    /**
     * @param isCallsTabToBeShown sets whether we have to show calls tab or not
     */
    fun setCallsTabToBeShown(isCallsTabToBeShown: Boolean) {
        showCallsTab = isCallsTabToBeShown
    }

    /**
     * @return true, if add participant in progress
     */
    @JvmStatic
    fun isAddUsersToTheCall(): Boolean {
        Logger.d(TAG, "isAddUsersToTheCall: $isAddUsersToTheCall")
        return isAddUsersToTheCall
    }

    /**
     * This method is used to set the add participant in progress
     *
     * @param isAddUsers boolean value, which is true when add participant in progress
     */
    @JvmStatic
    fun setIsAddUsersToTheCall(isAddUsers: Boolean) {
        Logger.d(TAG, "setIsAddUsersToTheCall: $isAddUsers")
        isAddUsersToTheCall = isAddUsers
    }

    fun setIsFromPoorInternetUpdate(isUpdatedFromPoorInternet:Boolean){
        isFromPoorInternetUpdate = isUpdatedFromPoorInternet
    }

    fun getIsFromPoorInternetUpdate():Boolean
    {
        return isFromPoorInternetUpdate
    }
    fun resetValues() {
        setIsGridViewEnabled(false)
        setIsBackCameraCapturing(false)
        setIsViewUpdatesCompleted(true)
        setIsListViewAnimated(false)
        setPinnedUserJid(Constants.EMPTY_STRING)
        setIsUserTilePinned(false)
        setIsCallStarted(null)
        setIsAddUsersToTheCall(false)
        setPeakSpeakingUser(Constants.EMPTY_STRING, 0)
        setIsFromPoorInternetUpdate(false)
    }
}

data class SpeakingUser(
    val userJid: String,
    var audioLevel: Int,
    var count: Int
) {
    constructor(userJid: String, audioLevel: Int) : this(userJid, audioLevel, 1)
}

data class UserMuteStatus(
    val isVideoMuted: Boolean,
    val isAudioMuted: Boolean
)