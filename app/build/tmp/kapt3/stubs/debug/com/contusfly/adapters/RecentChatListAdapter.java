package com.contusfly.adapters;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002YZBI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u001e\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b\u00a2\u0006\u0002\u0010\u000fJ\b\u0010 \u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0012\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\rH\u0002J,\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\n\u0010+\u001a\u00060,R\u00020\u00002\u0006\u0010-\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0011H\u0002J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\rH\u0002J\u0018\u00100\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0011H\u0016J&\u00100\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00112\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0016J\u0018\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0011H\u0016J\u001a\u00108\u001a\u00020\u001a2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a0\u0019J\u0010\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u0011H\u0002J \u0010<\u001a\u00020\u001a2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\fJ,\u0010=\u001a\u00020\u001a2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010+\u001a\u00020@2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010A\u001a\u00020\rH\u0002J*\u0010B\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020@2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000eH\u0002J\"\u0010E\u001a\u00020\u001a2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010+\u001a\u00020@2\u0006\u0010D\u001a\u00020\u000eH\u0002J\u0018\u0010F\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020@2\u0006\u0010>\u001a\u00020?H\u0002J4\u0010G\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020@2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010H\u001a\u00020\u000eH\u0002J*\u0010I\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020@2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0011H\u0002J \u0010K\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010+\u001a\u00020@2\u0006\u0010#\u001a\u00020\u0011H\u0002J\u0018\u0010L\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010+\u001a\u00020@H\u0002J\u0018\u0010M\u001a\u00020\r2\u0006\u0010+\u001a\u00020@2\u0006\u0010C\u001a\u00020\u000eH\u0002J\u0018\u0010N\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020@2\u0006\u0010J\u001a\u00020\u0007H\u0002J\u0018\u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020Q2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0018\u0010R\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010+\u001a\u00020@H\u0002J:\u0010S\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020@2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u0007H\u0002J \u0010T\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020@2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0011H\u0002J\u0018\u0010V\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010+\u001a\u00020@H\u0002J\u0018\u0010W\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010+\u001a\u00020@H\u0002J\u001e\u0010X\u001a\u00020\u001a2\b\u0010J\u001a\u0004\u0018\u00010\u00072\n\u0010+\u001a\u00060,R\u00020\u0000H\u0002R\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lcom/contusfly/adapters/RecentChatListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "mainlist", "Ljava/util/LinkedList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "selectedChats", "", "typingAndGoneStatus", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "", "", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/util/List;Ljava/util/ArrayList;)V", "archiveChatStatus", "", "getContext", "()Landroid/content/Context;", "getMainlist", "()Ljava/util/LinkedList;", "messageContent", "msgType", "onProfileIconClicked", "Lkotlin/Function1;", "", "getOnProfileIconClicked", "()Lkotlin/jvm/functions/Function1;", "setOnProfileIconClicked", "(Lkotlin/jvm/functions/Function1;)V", "userBlockedMe", "getItemCount", "getItemId", "", "position", "getItemViewType", "getSpannedText", "Landroid/text/Spanned;", "message", "handlePayloads", "bundle", "Landroid/os/Bundle;", "holder", "Lcom/contusfly/adapters/RecentChatListAdapter$RecentChatViewHolder;", "item", "isValidMessage", "lastMessageId", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onProfileClickedCallback", "fn", "returnFormattedCount", "count", "setArchiveStatus", "setCaptionForImageAndVideo", "chatMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "Lcom/contusfly/databinding/RowRecentChatItemBinding;", "mediaType", "setChatStatus", "isFromSender", "isRecall", "setDataForTextMessage", "setGroupMessageSenderName", "setImageStatus", "audioRecorded", "setMessageData", "recent", "setMessageView", "setPinnedIcon", "setRecalledMessageText", "setRecentChatImage", "setSelected", "view", "Landroid/view/View;", "setUnreadIcon", "setUserTypingList", "setUserTypingStatus", "indexOfTypingStatus", "setUserView", "switchBetweenMuteUnmute", "updateName", "Companion", "RecentChatViewHolder", "app_debug"})
public final class RecentChatListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat> mainlist = null;
    private final java.util.List<com.mirrorflysdk.api.models.RecentChat> selectedChats = null;
    private final java.util.ArrayList<kotlin.Triple<java.lang.String, java.lang.String, java.lang.Boolean>> typingAndGoneStatus = null;
    private boolean userBlockedMe = false;
    private java.lang.String messageContent;
    private java.lang.String msgType;
    private kotlin.Triple<java.lang.Boolean, java.lang.Boolean, java.lang.Integer> archiveChatStatus;
    public kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onProfileIconClicked;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.adapters.RecentChatListAdapter.Companion Companion = null;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    
    public RecentChatListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat> mainlist, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> selectedChats, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<kotlin.Triple<java.lang.String, java.lang.String, java.lang.Boolean>> typingAndGoneStatus) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat> getMainlist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnProfileIconClicked() {
        return null;
    }
    
    public final void setOnProfileIconClicked(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    public final void onProfileClickedCallback(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> fn) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    private final void setPinnedIcon(com.mirrorflysdk.api.models.RecentChat item, com.contusfly.databinding.RowRecentChatItemBinding holder) {
    }
    
    private final void setUnreadIcon(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.RowRecentChatItemBinding holder) {
    }
    
    public final void setArchiveStatus(@org.jetbrains.annotations.NotNull()
    kotlin.Triple<java.lang.Boolean, java.lang.Boolean, java.lang.Integer> archiveChatStatus) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    private final void handlePayloads(android.os.Bundle bundle, com.contusfly.adapters.RecentChatListAdapter.RecentChatViewHolder holder, com.mirrorflysdk.api.models.RecentChat item, int position) {
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * Selected view when long press it
     *
     * @param view Instance of the view
     * @param item Recent chat item
     */
    private final void setSelected(android.view.View view, com.mirrorflysdk.api.models.RecentChat item) {
    }
    
    /**
     * Format the number count for 100 plus
     *
     * @param count Count
     * @return String Formatted number count for 100 plus
     */
    private final java.lang.String returnFormattedCount(int count) {
        return null;
    }
    
    /**
     * Set the user view for the recent chat items Set the user information or users from the normal users.
     *
     * @param recent Instance of RecentChat
     * @param holder Instance of the view holder
     */
    private final void setUserView(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.RowRecentChatItemBinding holder) {
    }
    
    private final void updateName(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.adapters.RecentChatListAdapter.RecentChatViewHolder holder) {
    }
    
    /**
     * Set the message view of the recent chat users. get the message object and display based on text or Message type
     *
     * @param recent Instance of RecentChat
     * @param holder Instance of the holder view
     */
    private final void setMessageView(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.RowRecentChatItemBinding holder, int position) {
    }
    
    private final boolean isValidMessage(java.lang.String lastMessageId) {
        return false;
    }
    
    /**
     * Set the message data from the message view
     *
     * @param holder  Holder of the view
     * @param chatMessage Message object
     * @param recent  Instance of RecentChat
     */
    private final void setMessageData(com.contusfly.databinding.RowRecentChatItemBinding holder, com.mirrorflysdk.api.models.ChatMessage chatMessage, com.mirrorflysdk.api.models.RecentChat recent, int position) {
    }
    
    /**
     * Set message type on recent chat view...
     *
     * @param holder       Recent view holder
     * @param chatMessage      Message content for recent view
     * @param isFromSender Sender message or receiver message
     * @param isRecall     Does recall is applicable
     */
    private final void setUserTypingList(com.contusfly.databinding.RowRecentChatItemBinding holder, com.mirrorflysdk.api.models.ChatMessage chatMessage, boolean isFromSender, boolean isRecall, int position, com.mirrorflysdk.api.models.RecentChat recent) {
    }
    
    private final void setDataForTextMessage(com.mirrorflysdk.api.models.ChatMessage chatMessage, com.contusfly.databinding.RowRecentChatItemBinding holder, boolean isRecall) {
    }
    
    private final void setGroupMessageSenderName(com.contusfly.databinding.RowRecentChatItemBinding holder, com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    private final void setChatStatus(com.contusfly.databinding.RowRecentChatItemBinding holder, com.mirrorflysdk.api.models.ChatMessage chatMessage, boolean isFromSender, boolean isRecall) {
    }
    
    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private final android.text.Spanned getSpannedText(java.lang.String message) {
        return null;
    }
    
    /**
     * Set the typing status in recent chat while the users typing
     *
     * @param holder The holder for the recent chat view
     * @param recent Instance of RecentChat
     */
    private final void setUserTypingStatus(com.contusfly.databinding.RowRecentChatItemBinding holder, com.mirrorflysdk.api.models.RecentChat recent, int indexOfTypingStatus) {
    }
    
    /**
     * Sets the text to be displayed.
     *
     * @param holder       The view holding the child items.
     * @param isFromSender Boolean stating whether the recall is either from sender or receiver.
     * @return The information about the recalled message.
     */
    private final java.lang.String setRecalledMessageText(com.contusfly.databinding.RowRecentChatItemBinding holder, boolean isFromSender) {
        return null;
    }
    
    /**
     * Set the image view of the recent chat for user, broadcast, group chat
     *
     * @param holder Instance of the RecentViewHolder
     * @param recent Instance of the RecentChat
     */
    private final void setRecentChatImage(com.contusfly.databinding.RowRecentChatItemBinding holder, com.mirrorflysdk.api.models.RecentChat recent) {
    }
    
    /**
     * Sets the image status of the chat type => Image
     *
     * @param holder  The holder for the recent chat view
     * @param msgType Message type
     */
    private final void setImageStatus(com.contusfly.databinding.RowRecentChatItemBinding holder, java.lang.String msgType, java.lang.String messageContent, com.mirrorflysdk.api.models.ChatMessage chatMessage, boolean audioRecorded) {
    }
    
    private final void setCaptionForImageAndVideo(com.mirrorflysdk.api.models.ChatMessage chatMessage, com.contusfly.databinding.RowRecentChatItemBinding holder, java.lang.String messageContent, java.lang.String mediaType) {
    }
    
    /**
     * Mute status Icon Showing Recent chat
     *
     * @param recent Instance of RecentChat
     * @param holder Instance of the view holder
     */
    private final void switchBetweenMuteUnmute(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.RowRecentChatItemBinding holder) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/adapters/RecentChatListAdapter$RecentChatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowRecentChatItemBinding;", "(Lcom/contusfly/adapters/RecentChatListAdapter;Lcom/contusfly/databinding/RowRecentChatItemBinding;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "getViewBinding", "()Lcom/contusfly/databinding/RowRecentChatItemBinding;", "setViewBinding", "(Lcom/contusfly/databinding/RowRecentChatItemBinding;)V", "app_debug"})
    public final class RecentChatViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.databinding.RowRecentChatItemBinding viewBinding;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.Lazy compositeDisposable$delegate = null;
        
        public RecentChatViewHolder(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowRecentChatItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.databinding.RowRecentChatItemBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowRecentChatItemBinding p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final io.reactivex.disposables.CompositeDisposable getCompositeDisposable() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/adapters/RecentChatListAdapter$Companion;", "", "()V", "TYPE_FOOTER", "", "TYPE_HEADER", "TYPE_ITEM", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}