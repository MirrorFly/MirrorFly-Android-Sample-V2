package com.contusfly.chat;

import java.lang.System;

/**
 * Presenter class for the reply related operation
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bJ\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/contusfly/chat/ReplyViewHandler;", "", "context", "Landroid/content/Context;", "replyLayout", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "messageContent", "Lcom/contusfly/views/MessageTextView;", "messageImageOrVideoThumb", "Landroidx/appcompat/widget/AppCompatImageView;", "messageSenderName", "Lcom/contusfly/views/CustomTextView;", "messageTypeIcon", "extendShowReplyImageVideoMessage", "", "replyMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "showRecalledReplyMessage", "showReplyAudioMessage", "showReplyContactMessage", "showReplyImageVideoMessage", "showReplyLocationMessage", "showReplyMessageToSend", "messageId", "", "parentViewmodel", "Lcom/contusfly/viewmodels/ChatParentViewModel;", "suggestionLayout", "Landroid/widget/LinearLayout;", "jid", "showReplyTextMessage", "showSentReplyFileMessage", "app_debug"})
public final class ReplyViewHandler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final com.contusfly.views.MessageTextView messageContent = null;
    private final com.contusfly.views.CustomTextView messageSenderName = null;
    private final androidx.appcompat.widget.AppCompatImageView messageTypeIcon = null;
    private final androidx.appcompat.widget.AppCompatImageView messageImageOrVideoThumb = null;
    
    public ReplyViewHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.view.View replyLayout) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    /**
     * Show sender reply message in the message item
     *
     * @param messageId Reply message id
     */
    public final void showReplyMessageToSend(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId, @org.jetbrains.annotations.NotNull()
    com.contusfly.viewmodels.ChatParentViewModel parentViewmodel, @org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout suggestionLayout, @org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    /**
     * Show reply message for send
     *
     * @param replyMessage       Reply message item
     */
    private final void showReplyTextMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage) {
    }
    
    /**
     * Show sent reply image/video message
     *
     * @param replyMessage Reply message item
     */
    private final void showReplyImageVideoMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage) {
    }
    
    private final void extendShowReplyImageVideoMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage) {
    }
    
    /**
     * Show sent reply contact message
     *
     * @param replyMessage       Reply message item
     */
    private final void showReplyContactMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage) {
    }
    
    /**
     * Show sent reply location message
     *
     * @param replyMessage       Reply message item
     */
    private final void showReplyLocationMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage) {
    }
    
    /**
     * Show sent reply audio message
     *
     * @param replyMessage Reply message item
     */
    private final void showReplyAudioMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage) {
    }
    
    /**
     * Show sent reply file message
     *
     * @param replyMessage Reply message item
     */
    private final void showSentReplyFileMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage) {
    }
    
    /**
     * Show recalled reply messages
     *
     * @param replyMessage Reply message item
     */
    private final void showRecalledReplyMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage) {
    }
}