package com.contusfly.utils

import android.content.Context
import android.media.RingtoneManager
import com.mirrorflysdk.flycommons.FlyCallback
import com.contusfly.R
import com.contusfly.notification.AppNotificationManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyCore.getBusyStatusList
import com.mirrorflysdk.api.FlyCore.getMyBusyStatus
import com.mirrorflysdk.api.FlyCore.getProfileStatusList
import com.mirrorflysdk.api.FlyCore.insertMyBusyStatus
import com.mirrorflysdk.api.FlyCore.setMyBusyStatus
import com.mirrorflysdk.api.FlyCore.setMyProfileStatus
import com.mirrorflysdk.api.models.ProfileStatus
import java.util.*

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ConfigurationUtils {

    companion object {

        /**
         * Set Default values in Mobile Application
         */
        fun setDefaultValues(context: Context) {
            if (!context.getSharedPreferences(context.resources.getString(R.string.title_app_name), Context.MODE_PRIVATE)
                    .contains(Constants.NOTIFICATION_SOUND)) {
                SharedPreferenceManager.setBoolean(Constants.NOTIFICATION_SOUND, true)
                if (!context.getSharedPreferences(context.resources.getString(R.string.title_app_name), Context.MODE_PRIVATE)
                        .contains(Constants.VIBRATION)) {
                    SharedPreferenceManager.setBoolean(Constants.VIBRATION, false)
                    SharedPreferenceManager.setBoolean(Constants.KEY_CHANGE_FLAG, false)
                }
                AppNotificationManager.cancelNotifications(context)
            }
        }

        /**
         * Insert the default status for the logged in user. Also initiate the message tone and vibration alert and conversation settings data.
         *
         * @param context Instance of application
         */
        fun insertDefaultStatus(context: Context, status: String?) {
            if (getProfileStatusList().isEmpty()) {
                val defaultStatus = context.resources.getStringArray(R.array.default_status_values)
                for (statusValue in defaultStatus) {
                    setMyProfileStatus(statusValue!!, FlyCallback { _: Boolean, _: Throwable?, _: HashMap<String?, Any?>? -> })
                }
                setMyProfileStatus(status!!, FlyCallback { _: Boolean, _: Throwable?, _: HashMap<String?, Any?>? -> })
                SharedPreferenceManager.setString(Constants.VIBRATION_TYPE, 0.toString())
                SharedPreferenceManager.setString(Constants.NOTIFICATION_URI, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION).toString())
                SharedPreferenceManager.setBoolean(Constants.CONVERSATION_SOUND, true)
                SharedPreferenceManager.setBoolean(Constants.MUTE_ALL_CONVERSATION, false)
            }else if(SharedPreferenceManager.getString(Constants.NOTIFICATION_URI).isEmpty()){
                SharedPreferenceManager.setString(Constants.NOTIFICATION_URI, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION).toString())
            }
        }

        /**
         * Insert default busy status for the logged in user.
         *
         * @param context Instance of application
         */
        fun insertDefaultBusyStatus(context: Context) {
                val defaultStatus = context.resources.getStringArray(R.array.default_busy_status_values)
                for (statusValue in defaultStatus) {
                    insertMyBusyStatus(statusValue!!)
                }
                if (getMyBusyStatus() == null || getMyBusyStatus()!!.status.isEmpty()) {
                    setMyBusyStatus(context.getString(R.string.default_busy_status)){ _, _, _ -> }
                }
        }

        /**
         * Insert the default status for the logged in user. Also initiate the message tone and vibration alert and conversation settings data.
         *
         * @param context Instance of application
         */
        fun insertDefaultStatusToUser(context: Context, status: String?) {
            val profileStatus: List<ProfileStatus> = getProfileStatusList()
            if (profileStatus.isNotEmpty()) {
                val defaultStatus = context.resources.getStringArray(R.array.default_status_values)
                for (statusValue in defaultStatus) {
                    var isStatusNotExist = true
                    for (flyStatus in profileStatus) {
                        if (flyStatus.equals(statusValue))
                            isStatusNotExist = false
                    }
                    if (isStatusNotExist)
                        FlyCore.insertDefaultStatus(statusValue)
                }
            }
        }

    }
}