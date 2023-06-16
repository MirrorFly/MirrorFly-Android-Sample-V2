package com.contusfly.call.groupcall.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0006\u0010\u0017\u001a\u00020\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0006\u0010!\u001a\u00020\u0014J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u0014J\u0006\u0010&\u001a\u00020\u0014J\u0016\u0010\'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fJ\u000e\u0010+\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)J\u0006\u0010-\u001a\u00020\u0014J\u0018\u0010.\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010/\u001a\u00020\u0010J\u0006\u00100\u001a\u00020\u0014J\u0006\u00101\u001a\u00020\u0014J\u0010\u00102\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u00103\u001a\u00020\u0014H\u0002J\u0006\u00104\u001a\u00020\u0014J\b\u00105\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020\u0014H\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0003J\u000e\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020)J\u001e\u0010:\u001a\u00020\u00142\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020)0<j\b\u0012\u0004\u0012\u00020)`=J\u0006\u0010>\u001a\u00020\u0014J\u0010\u0010?\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020)J\u0018\u0010@\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010A\u001a\u00020\u0014H\u0002J\u0006\u0010B\u001a\u00020\u0014J\u0006\u0010C\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/CallConnectedViewHelper;", "Landroid/view/View$OnClickListener;", "binding", "Lcom/contusfly/databinding/LayoutCallConnectedBinding;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "callUsersListAdapter", "Lcom/contusfly/call/groupcall/GroupCallListAdapter;", "callUserGridAdapter", "Lcom/contusfly/call/groupcall/GroupCallGridAdapter;", "activityOnClickListener", "Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;", "baseViewOnClickListener", "Lcom/contusfly/call/groupcall/listeners/BaseViewOnClickListener;", "(Lcom/contusfly/databinding/LayoutCallConnectedBinding;Landroidx/appcompat/app/AppCompatActivity;Lcom/contusfly/call/groupcall/GroupCallListAdapter;Lcom/contusfly/call/groupcall/GroupCallGridAdapter;Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;Lcom/contusfly/call/groupcall/listeners/BaseViewOnClickListener;)V", "isSwappedFeeds", "", "isVideoViewsInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checkAddParticipantsAvailable", "", "checkAndHideGridViewVideoSurfaceViews", "checkAndHideListViewVideoSurfaceViews", "checkAndShowLocalVideoView", "checkAndUpdateConnectedUserAsPinnedUser", "hideConnectedView", "initGridAdapter", "initListAdapter", "initLocalVideoViews", "localPinnedUser", "localUserPosition", "", "pinClickedUserPosition", "makeCallAgain", "onClick", "view", "Landroid/view/View;", "onLocalVideoTrackAdded", "onSwapVideo", "onUserSpeaking", "userJid", "", "audioLevel", "onUserStoppedSpeaking", "onVideoTrackAdded", "ownAudioMuteStatusUpdated", "pinnedUserChanged", "isUserSpeaking", "pinnedUserLeft", "setMirrorLocalView", "setSwappedFeeds", "setUpCallNotConnected", "setUpCallUI", "setUpConnectedCallView", "setUpOneToOneCallView", "showMenuPopUp", "updateCallDuration", "callDuration", "updateCallMemberDetails", "callUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateCallStatus", "updatePinnedUserIcon", "updatePinnedUserPosition", "updatePinnedUserProfile", "updatePinnedUserVideoMuteStatus", "updateRemoteAudioMuteStatus", "app_debug"})
public final class CallConnectedViewHelper implements android.view.View.OnClickListener {
    private final com.contusfly.databinding.LayoutCallConnectedBinding binding = null;
    private final androidx.appcompat.app.AppCompatActivity activity = null;
    private final com.contusfly.call.groupcall.GroupCallListAdapter callUsersListAdapter = null;
    private final com.contusfly.call.groupcall.GroupCallGridAdapter callUserGridAdapter = null;
    private final com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener = null;
    private final com.contusfly.call.groupcall.listeners.BaseViewOnClickListener baseViewOnClickListener = null;
    
    /**
     * boolean value indicates whether the video views initialized or not .
     */
    private java.util.concurrent.atomic.AtomicBoolean isVideoViewsInitialized;
    private boolean isSwappedFeeds = false;
    
    public CallConnectedViewHelper(@org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.LayoutCallConnectedBinding binding, @org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.GroupCallListAdapter callUsersListAdapter, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.GroupCallGridAdapter callUserGridAdapter, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.listeners.BaseViewOnClickListener baseViewOnClickListener) {
        super();
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * This method will initiate Grid adapter and it's recycler view
     */
    private final void initGridAdapter() {
    }
    
    /**
     * This method will initiate List adapter and it's recycler view
     */
    private final void initListAdapter() {
    }
    
    public final void setUpCallUI() {
    }
    
    /**
     * Here all the video views are initializing
     */
    private final void initLocalVideoViews() {
    }
    
    public final void checkAndShowLocalVideoView() {
    }
    
    private final void setUpCallNotConnected() {
    }
    
    private final void setUpConnectedCallView() {
    }
    
    private final void checkAndHideListViewVideoSurfaceViews() {
    }
    
    private final void checkAndHideGridViewVideoSurfaceViews() {
    }
    
    private final void checkAndUpdateConnectedUserAsPinnedUser() {
    }
    
    private final void setUpOneToOneCallView() {
    }
    
    /**
     * This method is getting the caller name and profile picture
     *
     * @param callUsers list of Users in Call
     */
    public final void updateCallMemberDetails(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> callUsers) {
    }
    
    public final void updateCallDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String callDuration) {
    }
    
    public final void hideConnectedView() {
    }
    
    public final void checkAddParticipantsAvailable() {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    private final void showMenuPopUp(android.view.View view) {
    }
    
    public final void updateCallStatus() {
    }
    
    public final void updateRemoteAudioMuteStatus() {
    }
    
    /**
     * Here handling the video swap
     */
    private final void setSwappedFeeds(boolean isSwappedFeeds) {
    }
    
    /**
     * Set mirror view to the adapter In case local video swapped with remote video view
     */
    public final void setMirrorLocalView() {
    }
    
    public final void onSwapVideo() {
    }
    
    public final void makeCallAgain() {
    }
    
    public final void onLocalVideoTrackAdded() {
    }
    
    public final void onVideoTrackAdded(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
    
    public final void updatePinnedUserIcon(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
    
    public final void updatePinnedUserVideoMuteStatus() {
    }
    
    private final void localPinnedUser(int localUserPosition, int pinClickedUserPosition) {
    }
    
    private final void updatePinnedUserPosition(boolean isUserSpeaking, java.lang.String userJid) {
    }
    
    public final void pinnedUserChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid, boolean isUserSpeaking) {
    }
    
    public final void pinnedUserLeft() {
    }
    
    private final void updatePinnedUserProfile() {
    }
    
    public final void ownAudioMuteStatusUpdated() {
    }
    
    public final void onUserStoppedSpeaking(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
    
    public final void onUserSpeaking(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid, int audioLevel) {
    }
}