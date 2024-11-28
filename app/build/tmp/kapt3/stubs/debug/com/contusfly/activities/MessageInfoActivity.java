package com.contusfly.activities;

import java.lang.System;

/**
 * The class MessageInfoActivity show single chat message info. when the message delivered to user,
 * when the message read by user.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\"\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/contusfly/activities/MessageInfoActivity;", "Lcom/contusfly/activities/parent/BaseMessageInfoActivity;", "()V", "mChatMsgTime", "Lcom/contusfly/utils/ChatMsgTime;", "messageInfoBinding", "Lcom/contusfly/databinding/ActivityMessageInfoBinding;", "handleReceiptView", "", "seenTime", "", "formatter", "Ljava/text/SimpleDateFormat;", "formatter1", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMessageEvent", "messageEvent", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onMessageStatusUpdated", "messageId", "onPostCreate", "onStart", "onStop", "onUpdateUnStarAllMessages", "setMessageStatus", "messageStatus", "Lcom/mirrorflysdk/api/models/ChatMessageStatusDetail;", "setReceiptView", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "app_debug"})
public final class MessageInfoActivity extends com.contusfly.activities.parent.BaseMessageInfoActivity {
    private com.contusfly.databinding.ActivityMessageInfoBinding messageInfoBinding;
    
    /**
     * Display the chat Message time
     */
    private com.contusfly.utils.ChatMsgTime mChatMsgTime;
    private java.util.HashMap _$_findViewCache;
    
    public MessageInfoActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onPostCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Set the time of the received and seen receipts in the view
     *
     * @param message Message item contains message data
     */
    private final void setReceiptView(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Set the time of the received and seen receipts in the view
     *
     * @param messageStatus   Message delivered ans seen time
     * @param formatter       date format
     * @param formatter1      date format
     */
    private final void setMessageStatus(com.mirrorflysdk.api.models.ChatMessageStatusDetail messageStatus, java.text.SimpleDateFormat formatter, java.text.SimpleDateFormat formatter1) {
    }
    
    /**
     * Set the time of the received and seen receipts in the view
     *
     * @param seenTime   Message seentime
     * @param formatter  date format
     * @param formatter1 date format
     * @throws ParseException checked Exception
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    private final void handleReceiptView(java.lang.String seenTime, java.text.SimpleDateFormat formatter, java.text.SimpleDateFormat formatter1) throws java.text.ParseException {
    }
    
    /**
     * Message Status Updated
     *
     * @param messageId Message item contains message data
     */
    @java.lang.Override
    public void onMessageStatusUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
    }
    
    @java.lang.Override
    public void onUpdateUnStarAllMessages() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(@org.jetbrains.annotations.Nullable
    com.contusfly.models.PrivateChatAuthenticationModel messageEvent) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
}