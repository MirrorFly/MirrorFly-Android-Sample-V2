package com.contusfly.call.groupcall

import android.app.Activity
import android.content.Context
import android.os.Build
import com.contus.call.CallConstants
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.utils.Constants
import com.contusfly.views.CustomToast
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.CallDirection
import com.mirrorflysdk.flycall.webrtc.CallStatus
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.LogMessage

fun CallManager.isOutgoingCall() = getCallDirection() == CallDirection.OUTGOING_CALL

fun CallManager.isInComingCall() = getCallDirection() == CallDirection.INCOMING_CALL

fun CallManager.isVideoCall() = getCallType() == CallType.VIDEO_CALL

fun CallManager.isOneToOneVideoCall() = isVideoCallUICanShow() && isOneToOneCall()

fun CallManager.isOneToOneRemoteVideoMuted() =
    isOneToOneCall() && isRemoteVideoMuted(getEndCallerJid())

fun CallManager.isVideoCallUICanShow() = isVideoCall() && !isRemoteVideoMuted(getEndCallerJid())

fun CallManager.isAudioCall() = getCallType() == CallType.AUDIO_CALL

fun CallManager.isCallAttended() = isCallAnswered() && !isCallConnected()
fun CallManager.isCallNotConnected() = !isCallConnected() && !isCallAnswered()

fun CallManager.isLocalTileCanResize() =
    isOneToOneCall() && (isAudioCall() || isCallConnected()) && !CallUtils.getIsGridViewEnabled()

fun CallManager.isPinnedUserLeft(userJid: String = Constants.EMPTY_STRING) =
    CallUtils.getPinnedUserJid() == userJid || (isOneToOneCall() && CallUtils.getPinnedUserJid() != CallManager.getEndCallerJid())

fun CallManager.isUserAudioMuted(userJid: String): Boolean {
    return if (userJid == getCurrentUserId())
        isAudioMuted()
    else isRemoteAudioMuted(userJid)
}

fun CallManager.isUserVideoMuted(userJid: String): Boolean {
    return if (userJid == getCurrentUserId())
        isVideoMuted()
    else isRemoteVideoMuted(userJid)
}

//Get Call Status dependent functions
fun CallManager.getOnGoingCallStatus(context: Context): String {
    when {
        isCallConnected() -> return getCallConnectedStatus(context)
        isOutgoingCall() -> return getOutGoingCallStatus(context)
        isInComingCall() -> return getInComingCallStatus(context)
    }
    return Constants.EMPTY_STRING
}

fun CallManager.getCallConnectedStatus(context: Context): String {
    return if (isOneToOneCall() || GroupCallUtils.isSingleUserInCall()) {
        when (val localCallStatus = getCallStatus(getCurrentUserId())) {
            CallStatus.ON_HOLD -> localCallStatus
            CallStatus.RECONNECTING -> context.getString(com.contus.call.R.string.reconnecting)
            else -> {
                when (val remoteCallStatus = getCallStatus(getEndCallerJid())) {
                    CallStatus.CALLING, CallStatus.RINGING, CallStatus.ON_HOLD,CallStatus.RECONNECTING,CallStatus.CONNECTING -> remoteCallStatus
                    else -> Constants.EMPTY_STRING
                }
            }
        }
    } else
        CallStatus.CONNECTED
}

fun CallManager.getOutGoingCallStatus(context: Context): String {
    val localCallStatus = getCallStatus(getCurrentUserId())
    LogMessage.d(TAG, "${CallConstants.CALL_UI} ${CallConstants.JOIN_CALL}  getOutGoingCallStatus : $localCallStatus")
    return when {
        isCallTryingToConnect(localCallStatus) -> context.getString(com.contus.call.R.string.trying_to_connect)
        isCallTimeOut(localCallStatus) -> context.getString(com.contus.call.R.string.call_try_again_info)
        isCallRinging(localCallStatus) -> CallStatus.RINGING
        isCallConnecting(localCallStatus) -> CallStatus.CONNECTING
        else -> localCallStatus
    }
}


fun CallManager.isReconnecting() = getCallStatus(getCurrentUserId()) == CallStatus.RECONNECTING

fun isCallTryingToConnect(callStatus: String) = callStatus.isEmpty()
        || callStatus == CallStatus.DISCONNECTED

fun isCallConnecting(callStatus: String) = callStatus == CallStatus.CONNECTING

fun isCallRinging(callStatus: String) = callStatus == CallStatus.RINGING

fun isCallTimeOut(callStatus: String) =
    callStatus.isNotBlank() && (callStatus == CallStatus.CALL_TIME_OUT || callStatus == CallStatus.OUTGOING_CALL_TIME_OUT)

fun CallManager.getInComingCallStatus(context: Context): String {
    return if (isAudioCall())
        if (isOneToOneCall())
            context.getString(com.contus.call.R.string.incoming_audio_call)
        else
            context.getString(com.contus.call.R.string.incoming_audio_group_call)
    else
        if (isOneToOneCall())
            context.getString(com.contus.call.R.string.incoming_video_call)
        else
            context.getString(com.contus.call.R.string.incoming_video_group_call)
}

fun CallManager.getEndCallerJid(): String {
    return try {
        if (getCallUsersList()
                .isNotEmpty()
        ) getCallUsersList().first() else ""
    } catch (e: Exception) {
        LogMessage.e(TAG, "${CallConstants.CALL_UI} $e")
        ""
    }
}

fun CallManager.isOneToOneAudioCall() = isOneToOneCall() && getCallType() == CallType.AUDIO_CALL

fun CallManager.getUserAvailableForReconnection(jid: String): Boolean {
    val callStatus = getCallStatus(jid)
    return callStatus == CallStatus.CONNECTED
            || callStatus == CallStatus.RECONNECTING
            || callStatus == CallStatus.CONNECTING
            || callStatus == CallStatus.RECONNECTED
            || callStatus == CallStatus.ON_HOLD
            || callStatus == CallStatus.ON_RESUME
}

fun Context.showCustomToast(text: String?) {
    text?.let {
        CustomToast.showCustomToast(this, text)
    }
}

fun Any?.isNull(): Boolean = this == null

fun Activity.isInPIPMode() =
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && isInPictureInPictureMode
