package com.contusfly.call.calllog

import com.contus.call.CallConstants.CALL_UI
import com.contusfly.getDisplayName
import com.mirrorflysdk.flycommons.CallState
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.mirrorflysdk.flycall.call.database.model.CallLog
import com.contusfly.utils.ProfileDetailsUtils
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flydatabase.model.CallLogs
import com.mirrorflysdk.utils.ChatUtils
import com.mirrorflysdk.utils.CommonUtils
import com.mirrorflysdk.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.collections.ArrayList

@Singleton
class CallLogRepository @Inject constructor() {

    private val tag = this::class.java.simpleName

    fun getCallLogs(): MutableList<CallLog> {
        LogMessage.v(tag, "$CALL_UI getCallLogs() is working in thread ${Thread.currentThread().name}")
        val callLogs = (CallLogManager.getCallLogs() as? ArrayList<*>)?.filterIsInstance<CallLog>().orEmpty().toMutableList()
        return callLogs
    }

    suspend fun filteredCallLogs(searchKey: String): MutableList<CallLog> = withContext(Dispatchers.IO) {
        LogMessage.v(tag, "$CALL_UI filteredCallLogs() is working in thread ${Thread.currentThread().name}")
        val callLogs = mutableListOf<CallLog>()
        val callLogsList = CallLogManager.getCallLogs()
        if (callLogsList != null) {
            callLogs.addAll(callLogsList)
            val callLogsWithNickName = ArrayList<CallLog>()
            for (callLog in callLogs) {
                callLogsWithNickName.add(setProfile(getEndUserJid(callLog)!!, callLog))
            }
            callLogs.clear()
            val searchKeyWithoutSpace = searchKey.toLowerCase(Locale.getDefault()).replace(" ", "")
            for (callLog in callLogsWithNickName)
                if ((callLog.nickName != null && callLog.nickName!!.toLowerCase(Locale.getDefault()).replace(" ", "").contains(searchKeyWithoutSpace))
                        || (callLog.mobileNumber != null && callLog.mobileNumber!!.replace(" ", "").contains(searchKeyWithoutSpace))) {
                    callLog.searchKey = searchKeyWithoutSpace
                    callLogs.add(callLog)
                }
        }
        callLogs
    }

    private fun getEndUserJid(callLog: CallLog): String? {
        var endUserJid = if (!callLog.groupId.isNullOrEmpty())
            callLog.groupId else if (callLog.callState == CallState.INCOMING_CALL
            || callLog.callState == CallState.MISSED_CALL)
            callLog.fromUser else callLog.toUser
        if (!endUserJid!!.contains("@"))
            endUserJid = CommonUtils.getJidFromUser(endUserJid)
        return endUserJid
    }

    @Synchronized
    private fun setProfile(toUser: String, callLog: CallLog): CallLog {
        var name = ChatUtils.getUserFromJid(toUser)
        var profileImage: String = Constants.EMPTY_STRING
        var mobile: String = Constants.EMPTY_STRING
        var rosterInfo: ProfileDetails?
        try {
            rosterInfo = ProfileDetailsUtils.getProfileDetails(toUser)
        } catch (e: Exception) {
            rosterInfo = null
        }
        if (rosterInfo != null) {
            with(rosterInfo) {
                name = getDisplayName() ?: Constants.EMPTY_STRING
                profileImage = image ?: Constants.EMPTY_STRING
                mobile = mobileNumber ?: Constants.EMPTY_STRING
            }
            callLog.nickName = name
            callLog.profileImage = profileImage
            ///  callLog.profilePrivacy = rosterInfo.profilePhoto
            ///  callLog.callDisable = Prefs.getBoolean(SharedPreferenceManager.IS_CALLS_ENABLED)
            callLog.mobileNumber = mobile
        } else {
            val unKnownName = Utils.getFormattedPhoneNumber(ChatUtils.getUserFromJid(toUser))
            callLog.nickName = unKnownName
            callLog.mobileNumber = unKnownName
        }
        return callLog
    }


    @Synchronized
    private fun setProfile(toUser: String, callLog: CallLogs): CallLogs {
        var name = ChatUtils.getUserFromJid(toUser)
        var profileImage: String = Constants.EMPTY_STRING
        var mobile: String = Constants.EMPTY_STRING
        val rosterInfo = ProfileDetailsUtils.getProfileDetails(toUser)
        if (rosterInfo != null) {
            with(rosterInfo) {
                name = getDisplayName() ?: Constants.EMPTY_STRING
                profileImage = image ?: Constants.EMPTY_STRING
                mobile = mobileNumber ?: Constants.EMPTY_STRING
            }
            callLog.nickName = name
            callLog.profileImage = profileImage
            ///  callLog.profilePrivacy = rosterInfo.profilePhoto
            ///  callLog.callDisable = Prefs.getBoolean(SharedPreferenceManager.IS_CALLS_ENABLED)
            callLog.mobileNumber = mobile
        } else {
            val unKnownName = Utils.getFormattedPhoneNumber(ChatUtils.getUserFromJid(toUser))
            callLog.nickName = unKnownName
            callLog.mobileNumber = unKnownName
        }
        return callLog
    }

    suspend fun getCallLog(roomId: String): CallLog? = withContext(Dispatchers.IO) {
        LogMessage.v(tag, "$CALL_UI getCallLogs() is working in thread ${Thread.currentThread().name}")
        CallLogManager.getCallLog(roomId)
    }


}
