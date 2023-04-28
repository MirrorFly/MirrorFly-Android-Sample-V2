package com.contusfly.backup.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.contusfly.backup.WorkManagerController

/**
 * Receiver class to notify the app of System Boot completion and Date Time Changes
 */
class BootCompletedTimeChangedListener : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED" || intent.action == "android.intent.action.LOCKED_BOOT_COMPLETED") {
            WorkManagerController.startBackingUp()
        } else if (intent.action == "android.intent.action.TIME_SET") {
            WorkManagerController.cancelBackupWorkers()
        }
    }
}