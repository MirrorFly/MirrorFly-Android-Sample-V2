package com.contusfly.call.groupcall.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\u0006\u0010\"\u001a\u00020\u0016J\b\u0010#\u001a\u00020\u0016H\u0002J\u0006\u0010$\u001a\u00020\u0016J\b\u0010%\u001a\u00020\u0016H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010\'\u001a\u00020\u0016H\u0002J\u0012\u0010(\u001a\u00020\u00162\b\b\u0002\u0010)\u001a\u00020\u0010H\u0002J\u0006\u0010*\u001a\u00020\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0016J\u0006\u0010.\u001a\u00020\u0016J\u0006\u0010/\u001a\u00020\u0016J\u000e\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u0002022\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020\u00162\u0006\u00104\u001a\u000202J\u000e\u00108\u001a\u00020\u00162\u0006\u00104\u001a\u000202J\u0006\u00109\u001a\u00020\u0016J\u0018\u0010:\u001a\u00020\u00162\u0006\u00104\u001a\u0002022\b\b\u0002\u0010;\u001a\u00020\u0010J\u000e\u0010<\u001a\u00020\u00162\u0006\u00104\u001a\u000202J\u0006\u0010=\u001a\u00020\u0016J\u0010\u0010>\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010?\u001a\u00020\u0016H\u0002J\u000e\u0010@\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0010J\b\u0010A\u001a\u00020\u0016H\u0002J\b\u0010B\u001a\u00020\u0016H\u0002J\b\u0010C\u001a\u00020\u0016H\u0002J\u0010\u0010D\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0003J\b\u0010E\u001a\u00020\u0016H\u0002J\u000e\u0010F\u001a\u00020\u00162\u0006\u0010G\u001a\u000202J\u001e\u0010H\u001a\u00020\u00162\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u0002020Jj\b\u0012\u0004\u0012\u000202`KJ\u0006\u0010L\u001a\u00020\u0016J\u0010\u0010M\u001a\u00020\u00162\u0006\u0010N\u001a\u000202H\u0002J\u0006\u0010O\u001a\u00020\u0016J\u0010\u0010P\u001a\u00020\u00162\b\b\u0002\u00104\u001a\u000202J\u0018\u0010Q\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00102\u0006\u00104\u001a\u000202H\u0002J\b\u0010R\u001a\u00020\u0016H\u0002J\u0006\u0010S\u001a\u00020\u0016J\u0006\u0010T\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/CallConnectedViewHelper;", "Landroid/view/View$OnClickListener;", "binding", "Lcom/contusfly/databinding/LayoutCallConnectedBinding;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "callUsersListAdapter", "Lcom/contusfly/call/groupcall/GroupCallListAdapter;", "callUserGridAdapter", "Lcom/contusfly/call/groupcall/GroupCallGridAdapter;", "activityOnClickListener", "Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;", "baseViewOnClickListener", "Lcom/contusfly/call/groupcall/listeners/BaseViewOnClickListener;", "(Lcom/contusfly/databinding/LayoutCallConnectedBinding;Landroidx/appcompat/app/AppCompatActivity;Lcom/contusfly/call/groupcall/GroupCallListAdapter;Lcom/contusfly/call/groupcall/GroupCallGridAdapter;Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;Lcom/contusfly/call/groupcall/listeners/BaseViewOnClickListener;)V", "isSwappedFeeds", "", "isVideoViewsInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scrollDelayHandler", "Landroid/os/Handler;", "checkAddParticipantsAvailable", "", "checkAndHideGridViewVideoSurfaceViews", "checkAndHideListViewVideoSurfaceViews", "checkAndShowLocalVideoView", "checkAndShowPoorConnectionQuality", "checkAndUpdateConnectedUserAsPinnedUser", "handleConnectionQualityForGrid", "bundle", "Landroid/os/Bundle;", "handleConnectionQualityForList", "handleConnectionQualityForOneToOneCall", "handleConnectionQualityForSingleUserInCall", "hideConnectedView", "hideOrShowLocalProfileImage", "hideTextCallDuration", "hideViewsForGridDisabled", "initGridAdapter", "initListAdapter", "initLocalVideoViews", "isLocalTrackAddedFromSwitchRequest", "makeCallAgain", "onClick", "view", "Landroid/view/View;", "onLocalVideoTrackAdded", "onSwapVideo", "onUserProfileDetailsUpdatedDuringCall", "updatedUserJid", "", "onUserSpeaking", "userJid", "audioLevel", "", "onUserStoppedSpeaking", "onVideoTrackAdded", "ownAudioMuteStatusUpdated", "pinnedUserChanged", "isUserSpeaking", "pinnedUserLeft", "setMirrorLocalView", "setSwappedFeeds", "setUpCallNotConnected", "setUpCallUI", "setUpConnectedCallView", "setUpOneToOneCallView", "setUpSingleUserInMeetCall", "showMenuPopUp", "showViewsForOneToOneCall", "updateCallDuration", "callDuration", "updateCallMemberDetails", "callUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateCallStatus", "updateCallerImageWhenProfileEmpty", "userMobileNumber", "updateLocalUserImage", "updatePinnedUserIcon", "updatePinnedUserPosition", "updatePinnedUserProfile", "updatePinnedUserVideoMuteStatus", "updateRemoteAudioMuteStatus", "app_debug"})
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
    private final android.os.Handler scrollDelayHandler = null;
    
    public CallConnectedViewHelper(@org.jetbrains.annotations.NotNull
    com.contusfly.databinding.LayoutCallConnectedBinding binding, @org.jetbrains.annotations.NotNull
    androidx.appcompat.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull
    com.contusfly.call.groupcall.GroupCallListAdapter callUsersListAdapter, @org.jetbrains.annotations.NotNull
    com.contusfly.call.groupcall.GroupCallGridAdapter callUserGridAdapter, @org.jetbrains.annotations.NotNull
    com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener, @org.jetbrains.annotations.NotNull
    com.contusfly.call.groupcall.listeners.BaseViewOnClickListener baseViewOnClickListener) {
        super();
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
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
    
    public final void setUpCallUI(boolean isLocalTrackAddedFromSwitchRequest) {
    }
    
    /**
     * Here all the video views are initializing
     */
    private final void initLocalVideoViews(boolean isLocalTrackAddedFromSwitchRequest) {
    }
    
    public final void checkAndShowLocalVideoView() {
    }
    
    private final void setUpCallNotConnected() {
    }
    
    private final void hideViewsForGridDisabled() {
    }
    
    private final void setUpConnectedCallView() {
    }
    
    private final void checkAndHideListViewVideoSurfaceViews() {
    }
    
    private final void checkAndHideGridViewVideoSurfaceViews() {
    }
    
    private final void checkAndUpdateConnectedUserAsPinnedUser() {
    }
    
    /**
     * Hide views when single user present in call
     */
    private final void showViewsForOneToOneCall() {
    }
    
    private final void setUpSingleUserInMeetCall() {
    }
    
    private final void setUpOneToOneCallView() {
    }
    
    private final void updateCallerImageWhenProfileEmpty(java.lang.String userMobileNumber) {
    }
    
    public final void updateLocalUserImage() {
    }
    
    /**
     * This method is getting the caller name and profile picture
     *
     * @param callUsers list of Users in Call
     */
    public final void updateCallMemberDetails(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> callUsers) {
    }
    
    public final void updateCallDuration(@org.jetbrains.annotations.NotNull
    java.lang.String callDuration) {
    }
    
    public final void hideTextCallDuration() {
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
    
    public final void onVideoTrackAdded(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    public final void updatePinnedUserIcon(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    public final void updatePinnedUserVideoMuteStatus() {
    }
    
    private final void hideOrShowLocalProfileImage() {
    }
    
    private final void updatePinnedUserPosition(boolean isUserSpeaking, java.lang.String userJid) {
    }
    
    public final void pinnedUserChanged(@org.jetbrains.annotations.NotNull
    java.lang.String userJid, boolean isUserSpeaking) {
    }
    
    public final void pinnedUserLeft(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    private final void updatePinnedUserProfile() {
    }
    
    public final void ownAudioMuteStatusUpdated() {
    }
    
    public final void onUserStoppedSpeaking(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    public final void onUserSpeaking(@org.jetbrains.annotations.NotNull
    java.lang.String userJid, int audioLevel) {
    }
    
    public final void onUserProfileDetailsUpdatedDuringCall(@org.jetbrains.annotations.NotNull
    java.lang.String updatedUserJid) {
    }
    
    private final void handleConnectionQualityForSingleUserInCall() {
    }
    
    private final void handleConnectionQualityForOneToOneCall() {
    }
    
    private final void handleConnectionQualityForGrid(android.os.Bundle bundle) {
    }
    
    private final void handleConnectionQualityForList(android.os.Bundle bundle) {
    }
    
    public final void checkAndShowPoorConnectionQuality() {
    }
}