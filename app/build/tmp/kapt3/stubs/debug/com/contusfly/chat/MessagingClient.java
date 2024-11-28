package com.contusfly.chat;

import java.lang.System;

/**
 * This class is used for performing all the chat related functionality like send message , send seen status
 * and set last availability time.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@android.annotation.SuppressLint(value = {"DefaultLocale"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J<\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0016\u001a\u00020\u0006J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0016\u001a\u00020\u0006J.\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\b\b\u0002\u0010\u0016\u001a\u00020\u0006J4\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006J8\u0010 \u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eJ.\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120%2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0016\u001a\u00020\u0006J.\u0010&\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010\'\u001a\u00020(J0\u0010)\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eJL\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eJ\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u001a\u00103\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u001a\u00104\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0018\u00105\u001a\u00020/2\u0006\u00106\u001a\u0002072\b\u00101\u001a\u0004\u0018\u000102J\u0018\u00108\u001a\u00020/2\u0006\u00106\u001a\u0002072\b\u00101\u001a\u0004\u0018\u000102J\u0018\u00109\u001a\u00020/2\u0006\u00106\u001a\u0002072\b\u00101\u001a\u0004\u0018\u000102J\u001a\u0010:\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u001a\u0010;\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u001a\u0010<\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0018\u0010=\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102J\u001a\u0010>\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u001a\u0010?\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006A"}, d2 = {"Lcom/contusfly/chat/MessagingClient;", "Lkotlinx/coroutines/CoroutineScope;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getApplication", "()Landroid/app/Application;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composeAudioMessage", "Lkotlin/Triple;", "", "Lcom/contusfly/models/MessageObject;", "toJid", "isAudioRecorded", "mediaFilePath", "replyMessageId", "composeContactMessage", "data", "Landroid/content/Intent;", "contactShareModel", "Lcom/contusfly/models/ContactShareModel;", "contactName", "contactNumbers", "", "composeDocumentsMessage", "composeImageMessage", "imageFilePath", "imageCaption", "mentionedUsersIds", "composeLocationMessage", "Lkotlin/Pair;", "composeMeetMessage", "meetMessageParams", "Lcom/contusfly/models/MeetMessageParams;", "composeTextMessage", "textMessage", "composeVideoMessage", "videoFilePath", "videoCaption", "sendAudioMessage", "", "messageObject", "messageListener", "Lcom/contusfly/interfaces/MessageListener;", "sendContactMessage", "sendDocumentMessage", "sendEditedMediaMessage", "editedMessageParams", "Lcom/contusfly/models/EditMessageParams;", "sendEditedMessage", "sendEditedTextMessage", "sendImageMessage", "sendLocationMessage", "sendMeetMessage", "sendMessage", "sendTextMessage", "sendVideoMessage", "Companion", "app_debug"})
public final class MessagingClient implements kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.NotNull
    private final android.app.Application application = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.chat.MessagingClient.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String INTENT_PHONE_NUMBERS = "INTENT_PHONE_NUMBERS";
    
    @javax.inject.Inject
    public MessagingClient(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.app.Application getApplication() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTAG() {
        return null;
    }
    
    /**
     * Creates a new text message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param textMessage text content which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.MessageObject composeTextMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String textMessage, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        return null;
    }
    
    public final void sendEditedMessage(@org.jetbrains.annotations.NotNull
    com.contusfly.models.EditMessageParams editedMessageParams, @org.jetbrains.annotations.Nullable
    com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    public final void sendEditedTextMessage(@org.jetbrains.annotations.NotNull
    com.contusfly.models.EditMessageParams editedMessageParams, @org.jetbrains.annotations.Nullable
    com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    public final void sendEditedMediaMessage(@org.jetbrains.annotations.NotNull
    com.contusfly.models.EditMessageParams editedMessageParams, @org.jetbrains.annotations.Nullable
    com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull
    com.contusfly.models.MessageObject messageObject, @org.jetbrains.annotations.Nullable
    com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    private final void sendTextMessage(com.contusfly.models.MessageObject messageObject, com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    private final void sendLocationMessage(com.contusfly.models.MessageObject messageObject, com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    private final void sendContactMessage(com.contusfly.models.MessageObject messageObject, com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    private final void sendDocumentMessage(com.contusfly.models.MessageObject messageObject, com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    private final void sendImageMessage(com.contusfly.models.MessageObject messageObject, com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    private final void sendAudioMessage(com.contusfly.models.MessageObject messageObject, com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    private final void sendVideoMessage(com.contusfly.models.MessageObject messageObject, com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    private final void sendMeetMessage(com.contusfly.models.MessageObject messageObject, com.contusfly.interfaces.MessageListener messageListener) {
    }
    
    /**
     * Creates a new contact message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param data contact data which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.MessageObject composeContactMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    android.content.Intent data, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        return null;
    }
    
    /**
     * Creates a new contact message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param contactName name of the contact
     * @param contactNumbers selected numbers for the contact
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.MessageObject composeContactMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String contactName, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> contactNumbers, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        return null;
    }
    
    /**
     * Creates a new contact message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param contactShareModel contact data which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.MessageObject composeContactMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    com.contusfly.models.ContactShareModel contactShareModel, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        return null;
    }
    
    /**
     * Creates a new location message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param data location data which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object in a [Pair]. [Pair.first] indicates the success status
     */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<java.lang.Boolean, com.contusfly.models.MessageObject> composeLocationMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    android.content.Intent data, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        return null;
    }
    
    /**
     * Creates a new Image message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param imageFilePath image file path which needs to be sent
     * @param imageCaption image caption which needs to be attached with image
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object
     */
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.MessageObject composeImageMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String imageFilePath, @org.jetbrains.annotations.NotNull
    java.lang.String imageCaption, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        return null;
    }
    
    /**
     * Creates a new Document message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param mediaFilePath file path of document which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object in a [Triple.third]
     * [Triple.first] indicates isValidDocumentsType
     * [Triple.second] indicates isValidDocumentsSize
     */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Triple<java.lang.Boolean, java.lang.Boolean, com.contusfly.models.MessageObject> composeDocumentsMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String mediaFilePath, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        return null;
    }
    
    /**
     * Creates a new Audio message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param mediaFilePath file path of audio file which needs to be sent
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object in a [Triple.third].
     * [Triple.first] indicates isValidAudioType
     * [Triple.second] indicates isAudioSizeUnderLimit
     */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Triple<java.lang.Boolean, java.lang.Boolean, com.contusfly.models.MessageObject> composeAudioMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, boolean isAudioRecorded, @org.jetbrains.annotations.NotNull
    java.lang.String mediaFilePath, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId) {
        return null;
    }
    
    /**
     * Creates a new Video message[MessageObject] with required default values which
     * can be sent to the user via [sendMessage] method.
     *
     * if it is reply message for some other message, original message id should be
     * passed in [replyMessageId]  otherwise it could be null
     *
     * @param toJid jid of the receiver
     * @param videoFilePath file path of video which needs to be sent
     * @param videoCaption caption for the video
     * @param replyMessageId The message id for which this message will be sent as a reply message.
     * @return the prepared [MessageObject] object in a [Pair.second]. [Pair.first] indicates whether video size
     * exceeds the limit or not.
     */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Triple<java.lang.Boolean, java.lang.Boolean, com.contusfly.models.MessageObject> composeVideoMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String videoFilePath, @org.jetbrains.annotations.NotNull
    java.lang.String videoCaption, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.MessageObject composeMeetMessage(@org.jetbrains.annotations.NotNull
    java.lang.String toJid, @org.jetbrains.annotations.NotNull
    java.lang.String replyMessageId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> mentionedUsersIds, @org.jetbrains.annotations.NotNull
    com.contusfly.models.MeetMessageParams meetMessageParams) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/chat/MessagingClient$Companion;", "", "()V", "INTENT_PHONE_NUMBERS", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}