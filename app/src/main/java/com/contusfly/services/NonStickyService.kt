/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.api.ChatManager.getOnGoingChatUser
import com.mirrorflysdk.api.FlyMessenger.deleteUnreadMessageSeparatorOfAConversation

/**
 * The sticky service class which extends Android service component is used
 * to identify when the application is removed from the recent apps screen.
 *
 *
 * Use [.onTaskRemoved] method to perform necessary operations
 * when the application is removed recent tasks list.
 */
class NonStickyService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        LogMessage.d(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        return START_NOT_STICKY ?: 2 // Handled null exception in hard use cases
    }

    override fun onTaskRemoved(rootIntent: Intent) {
        super.onTaskRemoved(rootIntent)
        LogMessage.d(TAG, "onTaskRemoved")

        // Remove the unread message separator from the message table
        // when user kills the application from the recent apps.
        val recentChat = getOnGoingChatUser()
        if (recentChat.isNotEmpty()) deleteUnreadMessageSeparatorOfAConversation(recentChat)
        onDestroy()
    }

    override fun onDestroy() {
        super.onDestroy()
        LogMessage.d(TAG, "onDestroy")
    }

    companion object {
        private val TAG = NonStickyService::class.java.simpleName
    }
}