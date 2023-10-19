package com.contusfly.interfaces

import com.mirrorflysdk.api.models.ChatMessage

/**
 * Listener for message item sent success
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
interface MessageListener {

    /**
     * Add the message item into the View after send message success
     *
     * @param message          Message item contains message data
     */
    fun onSendMessageSuccess(message: ChatMessage)

}