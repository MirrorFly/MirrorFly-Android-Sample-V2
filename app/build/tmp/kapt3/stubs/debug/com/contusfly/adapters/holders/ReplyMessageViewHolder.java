package com.contusfly.adapters.holders;

import java.lang.System;

/**
 * Reply message view holder contains the fields of the reply message view in chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010!R\u0013\u0010(\u001a\u0004\u0018\u00010#\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010%\u00a8\u0006/"}, d2 = {"Lcom/contusfly/adapters/holders/ReplyMessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "imgReceivedReplyImageVideoPreview", "Landroid/widget/ImageView;", "getImgReceivedReplyImageVideoPreview", "()Landroid/widget/ImageView;", "imgReceivedReplyMessageType", "getImgReceivedReplyMessageType", "imgSenderImageVideoPreview", "getImgSenderImageVideoPreview", "imgSenderMessageType", "getImgSenderMessageType", "msgImageMeet", "getMsgImageMeet", "msgMeetReplyLayout", "Landroid/widget/RelativeLayout;", "getMsgMeetReplyLayout", "()Landroid/widget/RelativeLayout;", "replyMessageReceivedView", "getReplyMessageReceivedView", "()Landroid/view/View;", "replyMessageSentLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getReplyMessageSentLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "replyMessageSentView", "getReplyMessageSentView", "txtChatReceivedReply", "Lcom/contusfly/views/MessageTextView;", "getTxtChatReceivedReply", "()Lcom/contusfly/views/MessageTextView;", "txtChatReceivedReplyUserName", "Lcom/contusfly/views/CustomTextView;", "getTxtChatReceivedReplyUserName", "()Lcom/contusfly/views/CustomTextView;", "txtChatReply", "getTxtChatReply", "txtChatReplyUserName", "getTxtChatReplyUserName", "hideReceivedReplyView", "", "hideSentReplyView", "showReceivedReplyView", "showSentReplyView", "app_debug"})
public class ReplyMessageViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    
    /**
     * View for the reply sent message
     */
    @org.jetbrains.annotations.Nullable
    private final android.view.View replyMessageSentView = null;
    @org.jetbrains.annotations.Nullable
    private final androidx.constraintlayout.widget.ConstraintLayout replyMessageSentLayout = null;
    
    /**
     * View for the reply received message
     */
    @org.jetbrains.annotations.Nullable
    private final android.view.View replyMessageReceivedView = null;
    
    /**
     * Text message of the chat
     */
    @org.jetbrains.annotations.Nullable
    private final com.contusfly.views.MessageTextView txtChatReply = null;
    @org.jetbrains.annotations.Nullable
    private final android.widget.RelativeLayout msgMeetReplyLayout = null;
    @org.jetbrains.annotations.Nullable
    private final android.widget.ImageView msgImageMeet = null;
    
    /**
     * Text message of the chat
     */
    @org.jetbrains.annotations.Nullable
    private final com.contusfly.views.MessageTextView txtChatReceivedReply = null;
    
    /**
     * Text message of the chat
     */
    @org.jetbrains.annotations.Nullable
    private final com.contusfly.views.CustomTextView txtChatReplyUserName = null;
    
    /**
     * Text message of the chat
     */
    @org.jetbrains.annotations.Nullable
    private final com.contusfly.views.CustomTextView txtChatReceivedReplyUserName = null;
    
    /**
     * Text message of the chat
     */
    @org.jetbrains.annotations.Nullable
    private final android.widget.ImageView imgSenderMessageType = null;
    
    /**
     * Text message of the chat
     */
    @org.jetbrains.annotations.Nullable
    private final android.widget.ImageView imgSenderImageVideoPreview = null;
    
    /**
     * Text message of the chat
     */
    @org.jetbrains.annotations.Nullable
    private final android.widget.ImageView imgReceivedReplyMessageType = null;
    
    /**
     * Text message of the chat
     */
    @org.jetbrains.annotations.Nullable
    private final android.widget.ImageView imgReceivedReplyImageVideoPreview = null;
    
    public ReplyMessageViewHolder(@org.jetbrains.annotations.NotNull
    android.view.View view) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.view.View getReplyMessageSentView() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.constraintlayout.widget.ConstraintLayout getReplyMessageSentLayout() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.view.View getReplyMessageReceivedView() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.views.MessageTextView getTxtChatReply() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.RelativeLayout getMsgMeetReplyLayout() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getMsgImageMeet() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.views.MessageTextView getTxtChatReceivedReply() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.views.CustomTextView getTxtChatReplyUserName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.views.CustomTextView getTxtChatReceivedReplyUserName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getImgSenderMessageType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getImgSenderImageVideoPreview() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getImgReceivedReplyMessageType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getImgReceivedReplyImageVideoPreview() {
        return null;
    }
    
    /**
     * Show sent reply view
     */
    public final void showSentReplyView() {
    }
    
    /**
     * Hide sent reply view
     */
    public final void hideSentReplyView() {
    }
    
    /**
     * Show received reply view
     */
    public final void showReceivedReplyView() {
    }
    
    /**
     * Hide received reply view
     */
    public final void hideReceivedReplyView() {
    }
}