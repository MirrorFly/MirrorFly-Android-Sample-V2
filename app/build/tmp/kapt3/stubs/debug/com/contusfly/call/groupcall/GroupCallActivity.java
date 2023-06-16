package com.contusfly.call.groupcall;

import java.lang.System;

/**
 * This call activity is handle the incoming and outgoing group calls for both audio and video
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0092\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020<H\u0016J\b\u0010>\u001a\u00020<H\u0016J\b\u0010?\u001a\u00020<H\u0017J\u0010\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020%H\u0002J\b\u0010B\u001a\u00020<H\u0016J\b\u0010C\u001a\u00020<H\u0002J\b\u0010D\u001a\u00020<H\u0002J\u001a\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020%H\u0002J\b\u0010I\u001a\u00020<H\u0016J\u0010\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020%H\u0002J\u0012\u0010L\u001a\u00020<2\b\u0010M\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010N\u001a\u00020<2\b\u0010M\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010O\u001a\u00020<2\b\u0010M\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010P\u001a\u00020<2\u0006\u0010K\u001a\u00020%2\u0006\u0010M\u001a\u00020%H\u0002J\b\u0010Q\u001a\u00020<H\u0002J\b\u0010R\u001a\u00020<H\u0016J\b\u0010S\u001a\u00020<H\u0002J\b\u0010T\u001a\u00020<H\u0016J\b\u0010U\u001a\u00020<H\u0002J \u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020%2\u0006\u0010Y\u001a\u00020GH\u0016J\b\u0010Z\u001a\u00020<H\u0016J\b\u0010[\u001a\u00020<H\u0016J\u0010\u0010\\\u001a\u00020<2\u0006\u0010]\u001a\u00020GH\u0016J\u0010\u0010^\u001a\u00020<2\u0006\u0010_\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020<2\u0006\u0010b\u001a\u00020GH\u0016J\u0012\u0010c\u001a\u00020<2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020<H\u0016J\u0018\u0010g\u001a\u00020G2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020<2\u0006\u0010m\u001a\u00020nH\u0014J\u0018\u0010o\u001a\u00020<2\u0006\u0010p\u001a\u00020G2\u0006\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020<H\u0016J\b\u0010t\u001a\u00020<H\u0014J\b\u0010u\u001a\u00020<H\u0016J\b\u0010v\u001a\u00020<H\u0016J\b\u0010w\u001a\u00020<H\u0016J\u0010\u0010x\u001a\u00020<2\u0006\u0010y\u001a\u00020GH\u0002J\b\u0010z\u001a\u00020<H\u0016J\b\u0010{\u001a\u00020<H\u0002J\b\u0010|\u001a\u00020<H\u0016J\b\u0010}\u001a\u00020<H\u0002J\u0010\u0010~\u001a\u00020<2\u0006\u0010\u007f\u001a\u00020GH\u0002J\t\u0010\u0080\u0001\u001a\u00020<H\u0002J\t\u0010\u0081\u0001\u001a\u00020<H\u0002J\t\u0010\u0082\u0001\u001a\u00020<H\u0002J\u0013\u0010\u0083\u0001\u001a\u00020<2\b\u0010M\u001a\u0004\u0018\u00010%H\u0002J\t\u0010\u0084\u0001\u001a\u00020<H\u0002J\t\u0010\u0085\u0001\u001a\u00020<H\u0016J\t\u0010\u0086\u0001\u001a\u00020<H\u0016J\t\u0010\u0087\u0001\u001a\u00020<H\u0002J!\u0010\u0088\u0001\u001a\u00020<2\u0006\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020%2\u0006\u0010Y\u001a\u00020GH\u0002J\u0013\u0010\u0089\u0001\u001a\u00020<2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0014J\u0013\u0010\u008c\u0001\u001a\u00020<2\b\u0010M\u001a\u0004\u0018\u00010%H\u0002J\u000f\u0010\u008d\u0001\u001a\u00020<2\u0006\u0010M\u001a\u00020%J\u0018\u0010\u008e\u0001\u001a\u00020<2\u0006\u0010M\u001a\u00020%2\u0007\u0010\u008f\u0001\u001a\u00020GJ\u0011\u0010\u0090\u0001\u001a\u00020<2\u0006\u0010W\u001a\u00020%H\u0016J\u0011\u0010\u0091\u0001\u001a\u00020<2\u0006\u0010W\u001a\u00020%H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b!\u0010\"R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010+\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010%0%0-0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u00104R\"\u00106\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010%0%0-0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u00107\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010%0%0-0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u00108\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010%0%0-0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010%0%0-0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/contusfly/call/groupcall/GroupCallActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;", "()V", "activityBinding", "Lcom/contusfly/databinding/ActivityGroupCallBinding;", "callUserGridAdapter", "Lcom/contusfly/call/groupcall/GroupCallGridAdapter;", "callUsersListAdapter", "Lcom/contusfly/call/groupcall/GroupCallListAdapter;", "callViewHelper", "Lcom/contusfly/call/groupcall/helpers/BaseCallViewHelper;", "getCallViewHelper", "()Lcom/contusfly/call/groupcall/helpers/BaseCallViewHelper;", "callViewHelper$delegate", "Lkotlin/Lazy;", "customCallEventsListener", "Lcom/contusfly/call/groupcall/GroupCallActivity$CustomCallEventsListener;", "dialogViewHelper", "Lcom/contusfly/call/groupcall/helpers/DialogViewHelper;", "getDialogViewHelper", "()Lcom/contusfly/call/groupcall/helpers/DialogViewHelper;", "dialogViewHelper$delegate", "durationHandler", "Landroid/os/Handler;", "gridResizeRunnable", "Ljava/lang/Runnable;", "getGridResizeRunnable", "()Ljava/lang/Runnable;", "gridResizeRunnable$delegate", "groupCallViewModel", "Lcom/contusfly/call/groupcall/GroupCallViewModel;", "getGroupCallViewModel", "()Lcom/contusfly/call/groupcall/GroupCallViewModel;", "groupCallViewModel$delegate", "groupId", "", "isAnswerCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDisconnectCalled", "lastClickTime", "", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "participantListFragment", "Lcom/contusfly/call/groupcall/ParticipantsListFragment;", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "requestAudioCallPermission", "requestCallSwitchCameraPermission", "requestSwitchCameraPermission", "requestVideoCallPermission", "resetViewUpdatesRunnable", "acceptVideoCallSwitch", "", "addLocalUserToAdapter", "addUsersInCall", "answer", "callsUsersToast", "msg", "cancelCallAgain", "checkAndUpdateTimeoutInviteUsers", "checkAndUpdateTimeoutUsers", "disconnectCall", "isNotFromRetry", "", "callStatus", "finish", "handleCallConversionMessages", "callAction", "handleCallStatusConnected", "userJid", "handleCallStatusReconnected", "handleCallStatusResume", "handleCallVideoMessages", "handleIncomingRequest", "hangVideoCall", "initViews", "makeCallAgain", "notificationPermissionChecking", "onAdminBlockedOtherUser", "jid", "type", "status", "onBackPressed", "onCallSwitchConfirmationDialog", "onCallSwitchDialog", "isAccepted", "onClick", "v", "Landroid/view/View;", "onContactSyncComplete", "isSuccess", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "newConfig", "Landroid/content/res/Configuration;", "onRequestingVideoCallDialog", "onResume", "onStart", "onStop", "onUserLeaveHint", "pipModeChangeListeners", "pipModeStatus", "requestCameraPermission", "resetPIPModeByCallType", "resetViewsUpdatedFlag", "resizeGridView", "sendResponseToVideoCallRequest", "requestAccepted", "setObservers", "setUpCallDataAndUI", "setUpCallUI", "setVideoMuteStatus", "showOrHideSurfaceViews", "switchToGridView", "switchToTileView", "switchToVideoCall", "updateAdminBlockedStatus", "updateFeatureActions", "features", "Lcom/mirrorflysdk/flycommons/Features;", "updateStatusAndRemove", "updateUserJoined", "updateUserLeft", "leftStatus", "userDeletedHisProfile", "userUpdatedHisProfile", "CustomCallEventsListener", "app_debug"})
public final class GroupCallActivity extends com.contusfly.activities.BaseActivity implements android.view.View.OnClickListener, com.contusfly.call.groupcall.listeners.ActivityOnClickListener {
    private com.contusfly.call.groupcall.ParticipantsListFragment participantListFragment;
    private com.contusfly.databinding.ActivityGroupCallBinding activityBinding;
    
    /**
     * Instance for duration handler
     */
    private android.os.Handler durationHandler;
    private final kotlin.Lazy callViewHelper$delegate = null;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final kotlin.Lazy dialogViewHelper$delegate = null;
    
    /**
     * This flag indicates whether [.onDestroy] method is called or not
     */
    private final java.util.concurrent.atomic.AtomicBoolean isDisconnectCalled = null;
    
    /**
     * This flag indicates whether [.answer]  method is called or not
     */
    private final java.util.concurrent.atomic.AtomicBoolean isAnswerCalled = null;
    private com.contusfly.call.groupcall.GroupCallListAdapter callUsersListAdapter;
    private com.contusfly.call.groupcall.GroupCallGridAdapter callUserGridAdapter;
    
    /**
     * jid of the group call initiated
     */
    private java.lang.String groupId;
    private long lastClickTime = 0L;
    
    /**
     * call events listener
     */
    private final com.contusfly.call.groupcall.GroupCallActivity.CustomCallEventsListener customCallEventsListener = null;
    private final kotlin.Lazy groupCallViewModel$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestSwitchCameraPermission = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestCallSwitchCameraPermission = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestAudioCallPermission = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestVideoCallPermission = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private final kotlin.Lazy gridResizeRunnable$delegate = null;
    private final java.lang.Runnable resetViewUpdatesRunnable = null;
    private java.util.HashMap _$_findViewCache;
    
    public GroupCallActivity() {
        super();
    }
    
    private final com.contusfly.call.groupcall.helpers.BaseCallViewHelper getCallViewHelper() {
        return null;
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.helpers.DialogViewHelper getDialogViewHelper() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.GroupCallViewModel getGroupCallViewModel() {
        return null;
    }
    
    private final java.lang.Runnable getGridResizeRunnable() {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void notificationPermissionChecking() {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setUpCallDataAndUI() {
    }
    
    private final void setObservers() {
    }
    
    private final void acceptVideoCallSwitch() {
    }
    
    /**
     * Video Call switch request accepted
     */
    private final void switchToVideoCall() {
    }
    
    /**
     * Update mute status to the adapter to show or hide video view
     */
    private final void showOrHideSurfaceViews() {
    }
    
    /**
     * send response to video switch request
     * @param requestAccepted request accepted or not
     */
    private final void sendResponseToVideoCallRequest(boolean requestAccepted) {
    }
    
    private final void handleIncomingRequest() {
    }
    
    @java.lang.Override()
    public void onUserLeaveHint() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, @org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    private final void pipModeChangeListeners(boolean pipModeStatus) {
    }
    
    private final void resetPIPModeByCallType() {
    }
    
    @java.lang.Override()
    public void finish() {
    }
    
    /**
     * initialize views here
     */
    private final void initViews() {
    }
    
    /**
     * set vide mute status text based on remote user video mute actions
     * @param userJid id of video muted user
     */
    private final void setVideoMuteStatus(java.lang.String userJid) {
    }
    
    @java.lang.Override()
    public void hangVideoCall() {
    }
    
    /**
     * call answer method
     */
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override()
    public void answer() {
    }
    
    /**
     * update call view
     */
    private final void setUpCallUI() {
    }
    
    private final void disconnectCall(boolean isNotFromRetry, java.lang.String callStatus) {
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    public void onContactSyncComplete(boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void addUsersInCall() {
    }
    
    /**
     * Check the internet connectivity and send the call message
     */
    @java.lang.Override()
    public void makeCallAgain() {
    }
    
    @java.lang.Override()
    public void cancelCallAgain() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void updateStatusAndRemove(java.lang.String userJid) {
    }
    
    private final void handleCallVideoMessages(java.lang.String callAction, java.lang.String userJid) {
    }
    
    private final void handleCallConversionMessages(java.lang.String callAction) {
    }
    
    private final void handleCallStatusReconnected(java.lang.String userJid) {
    }
    
    private final void handleCallStatusResume(java.lang.String userJid) {
    }
    
    private final void handleCallStatusConnected(java.lang.String userJid) {
    }
    
    private final void checkAndUpdateTimeoutUsers() {
    }
    
    private final void checkAndUpdateTimeoutInviteUsers() {
    }
    
    @java.lang.Override()
    public void addLocalUserToAdapter() {
    }
    
    public final void updateUserJoined(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
    
    public final void updateUserLeft(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid, boolean leftStatus) {
    }
    
    private final void callsUsersToast(java.lang.String msg) {
    }
    
    private final void resizeGridView() {
    }
    
    @java.lang.Override()
    public void requestCameraPermission() {
    }
    
    @java.lang.Override()
    public void onCallSwitchConfirmationDialog() {
    }
    
    @java.lang.Override()
    public void onRequestingVideoCallDialog() {
    }
    
    @java.lang.Override()
    public void onCallSwitchDialog(boolean isAccepted) {
    }
    
    @java.lang.Override()
    public void switchToGridView() {
    }
    
    @java.lang.Override()
    public void switchToTileView() {
    }
    
    @java.lang.Override()
    public void resetViewsUpdatedFlag() {
    }
    
    @java.lang.Override()
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean status) {
    }
    
    private final void updateAdminBlockedStatus(java.lang.String jid, java.lang.String type, boolean status) {
    }
    
    @java.lang.Override()
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/call/groupcall/GroupCallActivity$CustomCallEventsListener;", "Lcom/mirrorflysdk/flycall/webrtc/api/CallEventsListener;", "(Lcom/contusfly/call/groupcall/GroupCallActivity;)V", "handleCallActionMessages", "", "callAction", "", "userJid", "handleCallStatusMessages", "callEvent", "handleMuteEvents", "muteEvent", "handleOtherCallStatusMessages", "onCallAction", "onCallStatusUpdated", "callStatus", "onLocalVideoTrackAdded", "onMuteStatusUpdated", "onUserSpeaking", "audioLevel", "", "onUserStoppedSpeaking", "onVideoTrackAdded", "app_debug"})
    final class CustomCallEventsListener implements com.mirrorflysdk.flycall.webrtc.api.CallEventsListener {
        
        public CustomCallEventsListener() {
            super();
        }
        
        @java.lang.Override()
        public void onCallStatusUpdated(@org.jetbrains.annotations.NotNull()
        java.lang.String callStatus, @org.jetbrains.annotations.NotNull()
        java.lang.String userJid) {
        }
        
        @java.lang.Override()
        public void onLocalVideoTrackAdded() {
        }
        
        @java.lang.Override()
        public void onCallAction(@org.jetbrains.annotations.NotNull()
        java.lang.String callAction, @org.jetbrains.annotations.NotNull()
        java.lang.String userJid) {
        }
        
        @java.lang.Override()
        public void onVideoTrackAdded(@org.jetbrains.annotations.NotNull()
        java.lang.String userJid) {
        }
        
        @java.lang.Override()
        public void onMuteStatusUpdated(@org.jetbrains.annotations.NotNull()
        @com.mirrorflysdk.flycall.webrtc.MuteEvent()
        java.lang.String muteEvent, @org.jetbrains.annotations.NotNull()
        java.lang.String userJid) {
        }
        
        @java.lang.Override()
        public void onUserSpeaking(@org.jetbrains.annotations.NotNull()
        java.lang.String userJid, int audioLevel) {
        }
        
        @java.lang.Override()
        public void onUserStoppedSpeaking(@org.jetbrains.annotations.NotNull()
        java.lang.String userJid) {
        }
        
        private final void handleMuteEvents(java.lang.String muteEvent, java.lang.String userJid) {
        }
        
        private final void handleCallStatusMessages(@com.mirrorflysdk.flycall.webrtc.CallStatus()
        java.lang.String callEvent, java.lang.String userJid) {
        }
        
        private final void handleOtherCallStatusMessages(@com.mirrorflysdk.flycall.webrtc.CallStatus()
        java.lang.String callEvent, java.lang.String userJid) {
        }
        
        private final void handleCallActionMessages(java.lang.String callAction, java.lang.String userJid) {
        }
    }
}