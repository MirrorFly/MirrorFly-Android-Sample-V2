package com.contusfly.chat;

import java.lang.System;

/**
 * This Class handles the Message Sending part of the Quick Share Module
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rH\u0002J<\u0010\u000e\u001a\u00020\u00062\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rH\u0002J<\u0010\u0010\u001a\u00020\u00062\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rH\u0002JZ\u0010\u0012\u001a\u00020\u00062\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\fj\b\u0012\u0004\u0012\u00020\u0014`\r2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\fj\b\u0012\u0004\u0012\u00020\u0018`\rH\u0002J.\u0010\u0019\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J*\u0010\u001e\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J.\u0010\u001f\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u001e\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00142\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001bJ \u0010&\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rH\u0002J\u001c\u0010\'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/contusfly/chat/ShareMessagesController;", "", "messagingClient", "Lcom/contusfly/chat/MessagingClient;", "(Lcom/contusfly/chat/MessagingClient;)V", "addAudioMessage", "", "audioMessage", "Lkotlin/Triple;", "", "Lcom/contusfly/models/MessageObject;", "messageObjectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addDocumentMessage", "documentMessage", "addVideoMessage", "videoMessage", "sendCallback", "sentMessages", "Lcom/mirrorflysdk/api/models/ChatMessage;", "listener", "Lcom/contusfly/utils/QuickShareMessageListener;", "errorMessageList", "", "sendContactMessage", "contacts", "", "Lcom/contusfly/models/ContactShareModel;", "users", "sendMediaAndContactMessage", "sendMediaMessagesForSingleUser", "fileObjects", "Lcom/contusfly/models/FileObject;", "userIdList", "sendMediaMessagesToRemainingUsers", "message", "usersJID", "sendMessage", "sendTextMessage", "shareText", "app_debug"})
public final class ShareMessagesController {
    private final com.contusfly.chat.MessagingClient messagingClient = null;
    
    @javax.inject.Inject
    public ShareMessagesController(@org.jetbrains.annotations.NotNull
    com.contusfly.chat.MessagingClient messagingClient) {
        super();
    }
    
    /**
     * Compose and send text messages to the given list of rosters
     *
     * @param shareText the text to share or send
     * @param userIdList user list to send the text message
     */
    public final void sendTextMessage(@org.jetbrains.annotations.NotNull
    java.lang.String shareText, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> userIdList) {
    }
    
    /**
     * Compose and send Contact messages to the given list of rosters
     *
     * @param contacts list of ContactShareModel to share to the users
     * @param users    user id list to send the text message
     */
    public final void sendContactMessage(@org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.ContactShareModel> contacts, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> users, @org.jetbrains.annotations.Nullable
    com.contusfly.utils.QuickShareMessageListener listener) {
    }
    
    /**
     * Sends Message to the remaining users of a quick share
     *
     * @param message  the message that sends to each users in the list
     * @param usersJID list of JID to which the message is going to send
     */
    public final void sendMediaMessagesToRemainingUsers(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> usersJID) {
    }
    
    /**
     * Send Media Message to the first user in quick to whom only the uploads takes place
     *
     * @param fileObjects list of files the needs to be uploaded
     * @param userIdList  list of JID to which the message is going to send.
     */
    public final void sendMediaMessagesForSingleUser(@org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.FileObject> fileObjects, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> userIdList, @org.jetbrains.annotations.Nullable
    com.contusfly.utils.QuickShareMessageListener listener) {
    }
    
    private final void addVideoMessage(kotlin.Triple<java.lang.Boolean, java.lang.Boolean, com.contusfly.models.MessageObject> videoMessage, java.util.ArrayList<com.contusfly.models.MessageObject> messageObjectList) {
    }
    
    private final void addAudioMessage(kotlin.Triple<java.lang.Boolean, java.lang.Boolean, com.contusfly.models.MessageObject> audioMessage, java.util.ArrayList<com.contusfly.models.MessageObject> messageObjectList) {
    }
    
    private final void addDocumentMessage(kotlin.Triple<java.lang.Boolean, java.lang.Boolean, com.contusfly.models.MessageObject> documentMessage, java.util.ArrayList<com.contusfly.models.MessageObject> messageObjectList) {
    }
    
    /**
     * Send the message to the SDK
     *
     * @param messageObjectList list of messages to send
     */
    private final void sendMessage(java.util.ArrayList<com.contusfly.models.MessageObject> messageObjectList) {
    }
    
    /**
     * Send the message to the SDK
     *
     * @param messageObjectList list of messages to send
     */
    private final void sendMediaAndContactMessage(java.util.ArrayList<com.contusfly.models.MessageObject> messageObjectList, com.contusfly.utils.QuickShareMessageListener listener) {
    }
    
    private final void sendCallback(java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> sentMessages, java.util.ArrayList<com.contusfly.models.MessageObject> messageObjectList, com.contusfly.utils.QuickShareMessageListener listener, java.util.ArrayList<java.lang.String> errorMessageList) {
    }
}