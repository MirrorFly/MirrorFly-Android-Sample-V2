package com.contusfly.adapters.holders;

import java.lang.System;

/**
 * Sender Name view holder contains the fields of the sender name view in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001d\u001a\u00020\u0018J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u0006\u0010\u001f\u001a\u00020\u0018J\u001a\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001aR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/contusfly/adapters/holders/SenderNameHolder;", "Lcom/contusfly/adapters/holders/DateViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "favouriteMessageData", "Lcom/contusfly/views/CustomTextView;", "favouriteMessageNameView", "Landroid/widget/RelativeLayout;", "favouriteReceiverName", "favouriteSenderName", "isRecallMessage", "", "()Z", "setRecallMessage", "(Z)V", "isSentMessage", "setSentMessage", "sendNameView", "Landroid/widget/TextView;", "sendNameViewStub", "Landroid/view/ViewStub;", "viewFavouriteMessages", "favouriteSenderReceiverName", "", "senderName", "", "receiverName", "messageData", "hideSendNameView", "renderSendNameView", "showFavouriteNameView", "showSenderName", "text", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "showSenderNameView", "sendJid", "app_debug"})
public class SenderNameHolder extends com.contusfly.adapters.holders.DateViewHolder {
    
    /**
     * Sender name view to show sender of the message for group chat
     */
    private android.widget.TextView sendNameView;
    
    /**
     * View stub to avoid unwanted rendering of views. Its used to render view whenever it is
     * necessary
     */
    private final android.view.ViewStub sendNameViewStub = null;
    
    /**
     * Favourite list user name view
     */
    private final android.widget.RelativeLayout favouriteMessageNameView = null;
    
    /**
     * Favourite list sender name
     */
    private final com.contusfly.views.CustomTextView favouriteSenderName = null;
    
    /**
     * Favourite list receiver name
     */
    private final com.contusfly.views.CustomTextView favouriteReceiverName = null;
    
    /**
     * Separator view between favourite messages
     */
    private final android.view.View viewFavouriteMessages = null;
    
    /**
     * Favourite message date
     */
    private final com.contusfly.views.CustomTextView favouriteMessageData = null;
    
    /**
     * Status For message deleted
     */
    private boolean isRecallMessage = false;
    
    /**
     * Status For message sent
     */
    private boolean isSentMessage = false;
    
    public SenderNameHolder(@org.jetbrains.annotations.NotNull
    android.view.View itemView) {
        super(null);
    }
    
    public final boolean isRecallMessage() {
        return false;
    }
    
    public final void setRecallMessage(boolean p0) {
    }
    
    public final boolean isSentMessage() {
        return false;
    }
    
    public final void setSentMessage(boolean p0) {
    }
    
    /**
     * Hides date view header if it is already rendered
     */
    public final void hideSendNameView() {
    }
    
    /**
     * Shows the date view and shows text based on item position
     *
     * @param sendJid jid of the message sender
     */
    public final void showSenderNameView(@org.jetbrains.annotations.NotNull
    java.lang.String sendJid) {
    }
    
    /**
     * Show favourite message name view
     */
    public final void showFavouriteNameView() {
    }
    
    /**
     * Set favourite message sender and receiver name
     *
     * @param senderName   Sender name
     * @param receiverName Receiver name
     * @param messageData  Message date
     */
    public final void favouriteSenderReceiverName(@org.jetbrains.annotations.Nullable
    java.lang.String senderName, @org.jetbrains.annotations.Nullable
    java.lang.String receiverName, @org.jetbrains.annotations.Nullable
    java.lang.String messageData) {
    }
    
    /**
     * Shows date view and sets text
     *
     * @param text Text to show
     */
    private final void showSenderName(java.lang.String text, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    /**
     * Renders the view from ViewStub
     */
    private final void renderSendNameView() {
    }
}