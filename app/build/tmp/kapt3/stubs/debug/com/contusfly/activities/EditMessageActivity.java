package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u000e\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nJ\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010\'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0019H\u0016J \u0010+\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020)H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u001fH\u0016J\u0010\u00102\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u001fH\u0016J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u000205H\u0016J*\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\n2\u0006\u0010;\u001a\u00020)H\u0016J\u0012\u0010<\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\u0010\u0010?\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001fH\u0016J\u0012\u0010@\u001a\u00020\u00192\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010A\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001a\u0010D\u001a\u00020\u00192\b\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u000209H\u0016J \u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\nH\u0016J\u001a\u0010I\u001a\u00020\u00192\b\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u000209H\u0016J\u001a\u0010J\u001a\u00020\u00192\b\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\nH\u0016J\b\u0010M\u001a\u00020\u0019H\u0014J\u0012\u0010N\u001a\u00020\u00192\b\u00107\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010O\u001a\u00020\u00192\b\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u000209H\u0016J\u001a\u0010P\u001a\u00020\u00192\b\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u000209H\u0016J\u0018\u0010Q\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0016J\u001a\u0010R\u001a\u00020)2\u0006\u00104\u001a\u0002052\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u0017H\u0016J\b\u0010W\u001a\u00020\u0019H\u0002J\u0010\u0010X\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u001fH\u0002J\b\u0010Z\u001a\u00020\u0019H\u0002J\u0010\u0010[\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u001fH\u0002J\u0010\u0010\\\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u001fH\u0002J\u0016\u0010]\u001a\u00020\u00192\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\n0_H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006`"}, d2 = {"Lcom/contusfly/activities/EditMessageActivity;", "Lcom/contusfly/activities/parent/EditChatParent;", "Landroid/view/View$OnTouchListener;", "Lio/github/rockerhieu/emojicon/EmojiconsFragment$OnEmojiconBackspaceClickedListener;", "Lio/github/rockerhieu/emojicon/EmojiconGridFragment$OnEmojiconClickedListener;", "Lcom/contusfly/adapters/GroupTagAdapter$UserTagClickListener;", "Landroid/view/View$OnClickListener;", "Lcom/contusfly/interfaces/OnChatItemClickListener;", "()V", "NOT_YET_IMPLEMENTED_MESSAGE", "", "TAG", "kotlin.jvm.PlatformType", "handler", "Landroid/os/Handler;", "keyboardHeightProvider", "Lcom/contusfly/views/KeyboardHeightProvider;", "mentionFilterKey", "mentionedUsersIds", "", "sendTextMessageWithMentionFormat", "unSentMentionedUserIdList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "filterGroupListTag", "", "text", "", "getKeyboardListener", "Lcom/contusfly/views/KeyboardHeightProvider$KeyboardListener;", "getMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "getUserFromJid", "jid", "handleCursorAndKeyboardVisibility", "hideGroupMentionMembersList", "initClickListeners", "initEditMessageAdapter", "initEditMessageGroupTag", "intent", "isValidToSendEditedMessage", "", "mediaPermissionCheck", "onAdminBlockedOtherUser", "type", "status", "onAudioPlayed", "onBackPressed", "onCancelDownloadClicked", "messageItem", "onCancelUploadClicked", "onClick", "v", "Landroid/view/View;", "onContactClick", "item", "position", "", "registeredJid", "isSavedContact", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDownloadClicked", "onEmojiconBackspaceClicked", "onEmojiconClicked", "emojicon", "Lio/github/rockerhieu/emojicon/emoji/Emojicon;", "onHandleStarredItemMediaClickToAction", "onMemberRemovedFromGroup", "groupJid", "removedMemberJid", "removedByMemberJid", "onReceiverItemClicked", "onReceiverItemLongClick", "onReplyMessageClick", "messageId", "onResume", "onRetryClicked", "onSenderItemClicked", "onSenderItemLongClick", "onSenderMediaForward", "onTouch", "event", "Landroid/view/MotionEvent;", "onUserTagClicked", "profileDetails", "sendEditedContent", "setMediaTypeContent", "message", "setMentionPopupBackground", "setMessageInEditText", "setTextTypeContent", "usersIBlockedListFetched", "jidList", "", "app_debug"})
public final class EditMessageActivity extends com.contusfly.activities.parent.EditChatParent implements android.view.View.OnTouchListener, io.github.rockerhieu.emojicon.EmojiconsFragment.OnEmojiconBackspaceClickedListener, io.github.rockerhieu.emojicon.EmojiconGridFragment.OnEmojiconClickedListener, com.contusfly.adapters.GroupTagAdapter.UserTagClickListener, android.view.View.OnClickListener, com.contusfly.interfaces.OnChatItemClickListener {
    private com.contusfly.views.KeyboardHeightProvider keyboardHeightProvider;
    private final java.lang.String TAG = null;
    private java.lang.String mentionFilterKey;
    private android.os.Handler handler;
    private java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> unSentMentionedUserIdList;
    private java.lang.String sendTextMessageWithMentionFormat = "";
    private java.util.List<java.lang.String> mentionedUsersIds;
    private final java.lang.String NOT_YET_IMPLEMENTED_MESSAGE = "Not yet implemented";
    private java.util.HashMap _$_findViewCache;
    
    public EditMessageActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void intent() {
    }
    
    private final void initEditMessageAdapter() {
    }
    
    private final void setMessageInEditText(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final void setTextTypeContent(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final void setMediaTypeContent(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final void sendEditedContent() {
    }
    
    private final boolean isValidToSendEditedMessage() {
        return false;
    }
    
    private final void initClickListeners() {
    }
    
    private final void handleCursorAndKeyboardVisibility() {
    }
    
    private final void initEditMessageGroupTag() {
    }
    
    private final void filterGroupListTag(java.lang.CharSequence text) {
    }
    
    private final void setMentionPopupBackground() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserFromJid(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
        return null;
    }
    
    private final void hideGroupMentionMembersList() {
    }
    
    private final com.contusfly.views.KeyboardHeightProvider.KeyboardListener getKeyboardListener() {
        return null;
    }
    
    private final com.mirrorflysdk.api.models.ChatMessage getMessage() {
        return null;
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    public boolean onTouch(@org.jetbrains.annotations.NotNull
    android.view.View v, @org.jetbrains.annotations.Nullable
    android.view.MotionEvent event) {
        return false;
    }
    
    @java.lang.Override
    public void onEmojiconBackspaceClicked(@org.jetbrains.annotations.Nullable
    android.view.View v) {
    }
    
    @java.lang.Override
    public void onEmojiconClicked(@org.jetbrains.annotations.Nullable
    io.github.rockerhieu.emojicon.emoji.Emojicon emojicon) {
    }
    
    @java.lang.Override
    public void usersIBlockedListFetched(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> jidList) {
    }
    
    @java.lang.Override
    public void onMemberRemovedFromGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String removedMemberJid, @org.jetbrains.annotations.NotNull
    java.lang.String removedByMemberJid) {
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    @java.lang.Override
    public void onUserTagClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    public void onDownloadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    @java.lang.Override
    public void onCancelDownloadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    @java.lang.Override
    public void onCancelUploadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    @java.lang.Override
    public void onRetryClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    @java.lang.Override
    public void onSenderItemClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onHandleStarredItemMediaClickToAction(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onReceiverItemClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onSenderItemLongClick(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onReceiverItemLongClick(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onReplyMessageClick(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
    }
    
    @java.lang.Override
    public void onSenderMediaForward(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onContactClick(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item, int position, @org.jetbrains.annotations.Nullable
    java.lang.String registeredJid, boolean isSavedContact) {
    }
    
    @java.lang.Override
    public void onAudioPlayed() {
    }
    
    @java.lang.Override
    public void mediaPermissionCheck() {
    }
}