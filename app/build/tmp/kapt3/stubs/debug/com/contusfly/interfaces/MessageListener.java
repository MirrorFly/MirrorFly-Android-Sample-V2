package com.contusfly.interfaces;

import java.lang.System;

/**
 * Listener for message item sent success
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/interfaces/MessageListener;", "", "onSendMessageSuccess", "", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "app_debug"})
public abstract interface MessageListener {
    
    /**
     * Add the message item into the View after send message success
     *
     * @param message          Message item contains message data
     */
    public abstract void onSendMessageSuccess(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message);
}