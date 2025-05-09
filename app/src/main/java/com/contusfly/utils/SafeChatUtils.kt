package com.contusfly.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.AppLifecycleListener
import com.contusfly.R
import com.contusfly.activities.DashboardActivity
import com.contusfly.activities.SettingsActivity
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.helpers.ResourceHelper
import com.mirrorflysdk.views.CustomToast

object SafeChatUtils {

    val safeChatEnabled: Boolean
        get() = SharedPreferenceManager.getBoolean(Constants.IS_SAFE_CHAT_ENABLED)

    private val pinAvailable: Boolean
        get() = SharedPreferenceManager.getString(Constants.MY_PIN).isNotEmpty()

    private val appLockEnabled: Boolean
        get() = SharedPreferenceManager.getBoolean(Constants.SHOW_PIN)

    private val muteNotificationEnabled: Boolean
        get() = Utils.isMuteNotification()

    @JvmField
    var updateSafeChat : SafeChatUpdate = SafeChatUpdate.NONE

    @JvmField
    var updateAlert : Boolean = false

    fun changeSafeChatStatus(activity: Activity,callback:(()->Unit)?) {
        LogMessage.i("SAFECHAT", "changeSafeChatStatus safeChatEnabled : $safeChatEnabled")
        LogMessage.i("SAFECHAT", "changeSafeChatStatus pinAvailable : $pinAvailable")
        LogMessage.i("SAFECHAT", "changeSafeChatStatus appLockEnabled : $appLockEnabled")
        if (safeChatEnabled) {
            updateSafeChat = SafeChatUpdate.DISABLE
        } else {
            enableSafeChat(activity)
        }
        AppShortCuts.dynamicAppShortcuts(activity)
    }

    fun changeSafeChatUpdateValue(){
        if (safeChatEnabled) {
            updateSafeChat = SafeChatUpdate.DISABLE
        } else {
            if (appLockEnabled) {
                updateSafeChat = SafeChatUpdate.ENABLE
            }
        }
    }

    private fun enableSafeChat(activity: Activity) {
        LogMessage.i("SAFECHAT", "enableSafeChat safeChatEnabled : $safeChatEnabled")
        if (appLockEnabled) {
            updateSafeChat = SafeChatUpdate.ENABLE
            launchAppUnlock()
        } else {
            if (pinAvailable) {
                updateSafeChat = SafeChatUpdate.ENABLE
                launchAppUnlock()
            } else {
                showPinRequiredPrompt(activity)
            }
        }
    }

    private fun launchAppUnlock() {
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(ChatManager.applicationContext, ChatManager.biometricActivty)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(intent)
        } else if(!AppLifecycleListener.isOnCall) {
            val intent = Intent(ChatManager.applicationContext, ChatManager.pinActivity)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(intent)
        }
    }

    private fun setSafeChatInPreference(enableDisable:Boolean){
        SharedPreferenceManager.setBoolean(Constants.IS_SAFE_CHAT_ENABLED, enableDisable)
        Utils.updateMuteSettings(enableDisable)
        SharedPreferenceManager.setBoolean(Constants.SHOW_PIN, enableDisable)
        if(SharedPreferenceManager.getBoolean(Constants.BIOMETRIC) == true)
            SharedPreferenceManager.setBoolean(Constants.BIOMETRIC,enableDisable)
        CallManager.muteCallNotification(enableDisable)
        LogMessage.i("SAFECHAT", "setSafeChatInPreference actionAuthorized : $safeChatEnabled")
        LogMessage.i("SAFECHAT", "setSafeChatInPreference updateSafeChat : $updateSafeChat")
    }

    private fun disableSafeChat(activity: Activity) {
        setSafeChatInPreference(false)
        LogMessage.i("SAFECHAT", "disableSafeChat actionAuthorized : $safeChatEnabled")
        LogMessage.i("SAFECHAT", "disableSafeChat updateSafeChat : $updateSafeChat")
        CustomToast.show(activity, ResourceHelper.getString(R.string.safe_chat_disabled))
    }

    fun silentDisableSafeChat(context: Context) {
        if(SharedPreferenceManager.getBoolean(Constants.IS_SAFE_CHAT_ENABLED)) {
            SharedPreferenceManager.setBoolean(
                Constants.IS_SAFE_CHAT_ENABLED,
                appLockEnabled && muteNotificationEnabled
            )
            AppShortCuts.dynamicAppShortcuts(context)
        }
    }

    private fun showPinRequiredPrompt(
        activity: Activity
    ) {
        val safeChatNeedsAppLockPrompt = CommonAlertDialog(activity)
        safeChatNeedsAppLockPrompt.showAlertDialogWithActionCallBack(
            msg = ResourceHelper.getString(R.string.safe_chat_prompt_no_app_lock),
            positiveString = ResourceHelper.getString(R.string.safe_chat_prompt_positive),
            negativeString = ResourceHelper.getString(R.string.safe_chat_prompt_negative),
            dialogType = CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
            dialogAction = CommonAlertDialog.DialogAction.SAFE_CHAT_ENABLE_APP_LOCK,
            cancelable = false,
            dismissListener = { dialogAction, isSuccess ->
                if(dialogAction == CommonAlertDialog.DialogAction.SAFE_CHAT_ENABLE_APP_LOCK && isSuccess){
                    updateSafeChat = SafeChatUpdate.ENABLE
                    val safeChatSetPinIntent = Intent(activity, SettingsActivity::class.java)
                    safeChatSetPinIntent.putExtra(Constants.IS_FOR_SAFE_CHAT,true)
                    activity.startActivity(safeChatSetPinIntent)
                }
            }
        )
    }

    fun safeChatEnabledPrompt(
        context: Context,
        callback: (() -> Unit)?
    ) {
        setSafeChatInPreference(true)
        val safeChatEnabledPrompt = CommonAlertDialog(context)
        safeChatEnabledPrompt.showAlertDialogWithActionCallBack(
            msg = ResourceHelper.getString(R.string.safe_chat_enabled),
            positiveString = ResourceHelper.getString(R.string.safe_chat_prompt_positive),
            negativeString = null,
            dialogType = CommonAlertDialog.DIALOGTYPE.DIALOG_SINGLE,
            dialogAction = CommonAlertDialog.DialogAction.SAFE_CHAT_ENABLED,
            cancelable = false,
            dismissListener = { _, _ ->
                if(callback!=null) {
                    callback.invoke()
                    LogMessage.i("SAFECHAT", "safeChatEnabledPrompt safeChatEnabled : $safeChatEnabled")
                }
            }
        )
    }

    fun actionAuthorized(activity: Activity, callback: (() -> Unit)?) {
        LogMessage.i("SAFECHAT", "actionAuthorized : $safeChatEnabled")
        LogMessage.i("SAFECHAT", "updateSafeChat : $updateSafeChat")
        if(updateSafeChat == SafeChatUpdate.ENABLE){
            if(activity is DashboardActivity) {
                safeChatEnabledPrompt(activity, callback)
            }else{
                updateAlert = true
                callback?.invoke()
            }
        }
        else if(updateSafeChat == SafeChatUpdate.DISABLE){
            disableSafeChat(activity)
            callback?.invoke()
        }
        updateSafeChat = SafeChatUpdate.NONE
        AppShortCuts.dynamicAppShortcuts(activity)
    }

    enum class SafeChatUpdate{
        NONE, ENABLE, DISABLE
    }
}