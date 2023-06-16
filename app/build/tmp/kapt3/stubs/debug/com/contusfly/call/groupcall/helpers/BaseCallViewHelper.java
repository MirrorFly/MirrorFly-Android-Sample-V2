package com.contusfly.call.groupcall.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0010H\u0002J \u0010J\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u0010H\u0016J\b\u0010M\u001a\u00020GH\u0016J\u0018\u0010N\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0010H\u0002J\b\u0010O\u001a\u00020GH\u0002J\b\u0010P\u001a\u00020GH\u0002J\b\u0010Q\u001a\u00020GH\u0002J\b\u0010R\u001a\u00020GH\u0016J\b\u0010S\u001a\u00020GH\u0002J\u0006\u0010T\u001a\u00020GJ\u0010\u0010U\u001a\u00020G2\u0006\u0010V\u001a\u00020\u0010H\u0016J\b\u0010W\u001a\u00020GH\u0002J\u0006\u0010X\u001a\u00020GJ\b\u0010Y\u001a\u00020GH\u0016J\u0006\u0010Z\u001a\u00020GJ\u0006\u0010[\u001a\u00020GJ\b\u0010\\\u001a\u00020GH\u0002J\u0006\u0010]\u001a\u00020GJ\b\u0010^\u001a\u00020_H\u0002J\b\u0010`\u001a\u00020GH\u0016J\b\u0010a\u001a\u00020GH\u0016J\b\u0010b\u001a\u00020GH\u0002J\b\u0010c\u001a\u00020GH\u0002J\u0006\u0010d\u001a\u00020GJ\b\u0010e\u001a\u00020GH\u0016J\u0016\u0010f\u001a\u00020G2\u0006\u0010g\u001a\u00020\u00192\u0006\u0010h\u001a\u00020\u0010J\u000e\u0010i\u001a\u00020G2\u0006\u0010g\u001a\u00020\u0019J\u000e\u0010j\u001a\u00020G2\u0006\u0010g\u001a\u00020\u0019J\b\u0010k\u001a\u00020GH\u0016J\b\u0010l\u001a\u00020GH\u0016J\u000e\u0010m\u001a\u00020G2\u0006\u0010g\u001a\u00020\u0019J\u0006\u0010n\u001a\u00020GJ\b\u0010o\u001a\u00020GH\u0016J\b\u0010p\u001a\u00020GH\u0002J\b\u0010q\u001a\u00020GH\u0002J\u0006\u0010r\u001a\u00020GJ\b\u0010s\u001a\u00020GH\u0002J\u0006\u0010t\u001a\u00020GJ\u0006\u0010u\u001a\u00020GJ\u001e\u0010v\u001a\u00020G2\u0016\u0010w\u001a\u0012\u0012\u0004\u0012\u00020\u00190xj\b\u0012\u0004\u0012\u00020\u0019`yJ\u0006\u0010z\u001a\u00020GJ\b\u0010{\u001a\u00020GH\u0002J\b\u0010|\u001a\u00020GH\u0002J\u0006\u0010}\u001a\u00020GJ\b\u0010~\u001a\u00020GH\u0002J\b\u0010\u007f\u001a\u00020GH\u0002J\u0007\u0010\u0080\u0001\u001a\u00020GJ\t\u0010\u0081\u0001\u001a\u00020GH\u0002J\u0007\u0010\u0082\u0001\u001a\u00020GJ\u0007\u0010\u0083\u0001\u001a\u00020GJ\u0010\u0010\u0084\u0001\u001a\u00020G2\u0007\u0010\u0085\u0001\u001a\u00020\u0019J\u0007\u0010\u0086\u0001\u001a\u00020GJ\u0007\u0010\u0087\u0001\u001a\u00020GJ\u000f\u0010\u0088\u0001\u001a\u00020G2\u0006\u0010g\u001a\u00020\u0019J\u0011\u0010\u0089\u0001\u001a\u00020G2\b\u0010g\u001a\u0004\u0018\u00010\u0019J\u0011\u0010\u008a\u0001\u001a\u00020G2\b\u0010g\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010\u0017\u001a\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u0017\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\u0017\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010\u0017\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010\u0017\u001a\u0004\b;\u0010<R\u000e\u0010>\u001a\u00020?X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020?X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/BaseCallViewHelper;", "Lcom/contusfly/call/groupcall/listeners/BaseViewOnClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "binding", "Lcom/contusfly/databinding/ActivityGroupCallBinding;", "callUsersListAdapter", "Lcom/contusfly/call/groupcall/GroupCallListAdapter;", "callUserGridAdapter", "Lcom/contusfly/call/groupcall/GroupCallGridAdapter;", "durationHandler", "Landroid/os/Handler;", "activityOnClickListener", "Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/contusfly/databinding/ActivityGroupCallBinding;Lcom/contusfly/call/groupcall/GroupCallListAdapter;Lcom/contusfly/call/groupcall/GroupCallGridAdapter;Landroid/os/Handler;Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;)V", "actualScreenHeight", "", "actualScreenWidth", "callConnectedViewHelper", "Lcom/contusfly/call/groupcall/helpers/CallConnectedViewHelper;", "getCallConnectedViewHelper", "()Lcom/contusfly/call/groupcall/helpers/CallConnectedViewHelper;", "callConnectedViewHelper$delegate", "Lkotlin/Lazy;", "callDuration", "", "getCallDuration", "()Ljava/lang/String;", "setCallDuration", "(Ljava/lang/String;)V", "callNotConnectedViewHelper", "Lcom/contusfly/call/groupcall/helpers/CallNotConnectedViewHelper;", "getCallNotConnectedViewHelper", "()Lcom/contusfly/call/groupcall/helpers/CallNotConnectedViewHelper;", "callNotConnectedViewHelper$delegate", "callOptionsViewHelper", "Lcom/contusfly/call/groupcall/helpers/CallOptionsViewHelper;", "getCallOptionsViewHelper", "()Lcom/contusfly/call/groupcall/helpers/CallOptionsViewHelper;", "callOptionsViewHelper$delegate", "hideOptionsRunnable", "Ljava/lang/Runnable;", "incomingCallViewHelper", "Lcom/contusfly/call/groupcall/helpers/IncomingCallViewHelper;", "getIncomingCallViewHelper", "()Lcom/contusfly/call/groupcall/helpers/IncomingCallViewHelper;", "incomingCallViewHelper$delegate", "mPictureInPictureParamsBuilder", "Landroid/app/PictureInPictureParams$Builder;", "getMPictureInPictureParamsBuilder", "()Landroid/app/PictureInPictureParams$Builder;", "mPictureInPictureParamsBuilder$delegate", "pipViewHelper", "Lcom/contusfly/call/groupcall/helpers/PIPViewHelper;", "getPipViewHelper", "()Lcom/contusfly/call/groupcall/helpers/PIPViewHelper;", "pipViewHelper$delegate", "retryCallViewHelper", "Lcom/contusfly/call/groupcall/helpers/RetryCallViewHelper;", "getRetryCallViewHelper", "()Lcom/contusfly/call/groupcall/helpers/RetryCallViewHelper;", "retryCallViewHelper$delegate", "startTime", "", "timeInMilliseconds", "getTimeInMilliseconds", "()J", "setTimeInMilliseconds", "(J)V", "updateTimerThread", "animateCallDetails", "", "animation", "callDetailsVisibility", "animateCallOptions", "callOptionsVisibility", "arrowVisibility", "animateCallOptionsView", "animateGridCallDetails", "animateGridView", "animateGroupListView", "animateListView", "animateListViewWithCallOptions", "animateOneToOneCallOption", "checkAndUpdateCameraView", "checkOptionArrowVisibility", "visibility", "disableCallOptionAnimation", "disconnectCall", "enableCallOptionAnimation", "gotoPIPMode", "hideCallAgainView", "hideCallOptions", "hidePIPLayout", "isCallUIVisible", "", "onCallOptionsHidden", "onCallOptionsVisible", "onCallTitleHidden", "onCallTitleVisible", "onLocalVideoTrackAdded", "onSwapVideo", "onUserSpeaking", "userJid", "audioLevel", "onUserStoppedSpeaking", "onVideoTrackAdded", "ownAudioMuteStatusUpdated", "ownVideoMuteStatusUpdated", "pinnedUserChanged", "pinnedUserLeft", "pinnedUserRemoved", "releaseSurfaceViews", "resizeLocalTile", "setMirrorLocalView", "setOverlayBackground", "setSelectedAudioDeviceIcon", "setUpCallUI", "setUpProfileDetails", "callUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showCallAgainView", "showCallOptions", "showGridTitle", "showListView", "showListViewAboveCallOptions", "showListViewAtBottom", "showPIPLayout", "startCallTimer", "toggleVideoMute", "updateCallStatus", "updateDisconnectedStatus", "callStatus", "updateFeatureActions", "updatePinnedUserVideoMuteStatus", "updateRemoteAudioMuteStatus", "updateStatusAdapter", "updatedRejoinedUsers", "app_debug"})
public final class BaseCallViewHelper implements com.contusfly.call.groupcall.listeners.BaseViewOnClickListener {
    private final androidx.appcompat.app.AppCompatActivity activity = null;
    private final com.contusfly.databinding.ActivityGroupCallBinding binding = null;
    private final com.contusfly.call.groupcall.GroupCallListAdapter callUsersListAdapter = null;
    private final com.contusfly.call.groupcall.GroupCallGridAdapter callUserGridAdapter = null;
    private final android.os.Handler durationHandler = null;
    private final com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener = null;
    private final kotlin.Lazy callNotConnectedViewHelper$delegate = null;
    private final kotlin.Lazy callConnectedViewHelper$delegate = null;
    private final kotlin.Lazy pipViewHelper$delegate = null;
    private final kotlin.Lazy callOptionsViewHelper$delegate = null;
    private final kotlin.Lazy incomingCallViewHelper$delegate = null;
    private final kotlin.Lazy retryCallViewHelper$delegate = null;
    
    /**
     * Actual screen height in dp
     */
    private int actualScreenHeight = 0;
    
    /**
     * Actual screen width in dp
     */
    private int actualScreenWidth = 0;
    
    /**
     * The arguments to be used for Picture-in-Picture mode.
     */
    private final kotlin.Lazy mPictureInPictureParamsBuilder$delegate = null;
    
    /**
     * Time in milli seconds
     */
    private long timeInMilliseconds = 0L;
    
    /**
     * Call start time
     */
    private long startTime = 0L;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String callDuration = "";
    
    /**
     * The Update Timer thread to run continuously when call is going on.
     */
    private final java.lang.Runnable updateTimerThread = null;
    private final java.lang.Runnable hideOptionsRunnable = null;
    
    public BaseCallViewHelper(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.ActivityGroupCallBinding binding, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.GroupCallListAdapter callUsersListAdapter, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.GroupCallGridAdapter callUserGridAdapter, @org.jetbrains.annotations.NotNull()
    android.os.Handler durationHandler, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener) {
        super();
    }
    
    private final com.contusfly.call.groupcall.helpers.CallNotConnectedViewHelper getCallNotConnectedViewHelper() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.helpers.CallConnectedViewHelper getCallConnectedViewHelper() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.helpers.PIPViewHelper getPipViewHelper() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.helpers.CallOptionsViewHelper getCallOptionsViewHelper() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.helpers.IncomingCallViewHelper getIncomingCallViewHelper() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.helpers.RetryCallViewHelper getRetryCallViewHelper() {
        return null;
    }
    
    /**
     * The arguments to be used for Picture-in-Picture mode.
     */
    private final android.app.PictureInPictureParams.Builder getMPictureInPictureParamsBuilder() {
        return null;
    }
    
    public final long getTimeInMilliseconds() {
        return 0L;
    }
    
    public final void setTimeInMilliseconds(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCallDuration() {
        return null;
    }
    
    public final void setCallDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final void startCallTimer() {
    }
    
    public final void setUpCallUI() {
    }
    
    /**
     * Show/Hide local small video view in adapter while mute/un mute the local video
     */
    @java.lang.Override()
    public void ownVideoMuteStatusUpdated() {
    }
    
    public final void setUpProfileDetails(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> callUsers) {
    }
    
    public final void updateCallStatus() {
    }
    
    public final void updateStatusAdapter(@org.jetbrains.annotations.Nullable()
    java.lang.String userJid) {
    }
    
    public final void updatedRejoinedUsers(@org.jetbrains.annotations.Nullable()
    java.lang.String userJid) {
    }
    
    private final void setOverlayBackground() {
    }
    
    /**
     * sets icon for the audio device image view based on the selected audio device
     */
    public final void setSelectedAudioDeviceIcon() {
    }
    
    private final void hideCallOptions() {
    }
    
    private final void showCallOptions() {
    }
    
    public final void checkAndUpdateCameraView() {
    }
    
    /**
     * This method animates the call options layout with given animation
     *
     * @param animation             animation id
     * @param callOptionsVisibility visibility to be changed for callOptions view
     * @param arrowVisibility       visibility to be changed for arrow view
     */
    @java.lang.Override()
    public void animateCallOptions(int animation, int callOptionsVisibility, int arrowVisibility) {
    }
    
    public final void toggleVideoMute() {
    }
    
    /**
     * shows buttons to call again or cancel the action.̥
     */
    public final void showCallAgainView() {
    }
    
    /**
     * hides the call again view
     */
    public final void hideCallAgainView() {
    }
    
    public final void hidePIPLayout() {
    }
    
    public final void gotoPIPMode() {
    }
    
    public final void showPIPLayout() {
    }
    
    @java.lang.Override()
    public void enableCallOptionAnimation() {
    }
    
    private final void disableCallOptionAnimation() {
    }
    
    @java.lang.Override()
    public void checkOptionArrowVisibility(int visibility) {
    }
    
    /**
     * animates the local video view to move down to bottom of the screen
     */
    @java.lang.Override()
    public void onCallOptionsHidden() {
    }
    
    /**
     * animates the local video view to move up above [.callOptionsLayout]
     */
    @java.lang.Override()
    public void onCallOptionsVisible() {
    }
    
    private final void showListViewAtBottom() {
    }
    
    private final void showListViewAboveCallOptions() {
    }
    
    /**
     * animates the call options layout with respect to it's visibility
     */
    @java.lang.Override()
    public void animateCallOptionsView() {
    }
    
    private final void animateGridView() {
    }
    
    private final void animateGridCallDetails(int animation, int callDetailsVisibility) {
    }
    
    private final void onCallTitleHidden() {
    }
    
    private final void onCallTitleVisible() {
    }
    
    private final void showGridTitle() {
    }
    
    private final void animateListView() {
    }
    
    private final void animateOneToOneCallOption() {
    }
    
    /**
     * This method animates the call options layout with List View
     */
    private final void animateGroupListView() {
    }
    
    /**
     * This method animates the call options layout with given animation
     *
     * @param animation             animation id
     * @param callDetailsVisibility visibility to be changed for callDetails view
     */
    private final void animateCallDetails(int animation, int callDetailsVisibility) {
    }
    
    public final void disconnectCall() {
    }
    
    /**
     * Release video view surface while disconnect the call
     */
    private final void releaseSurfaceViews() {
    }
    
    public final void updateDisconnectedStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String callStatus) {
    }
    
    private final boolean isCallUIVisible() {
        return false;
    }
    
    public final void updateRemoteAudioMuteStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
    
    /**
     * In a video call once local video track available this method will be triggered
     */
    public final void onLocalVideoTrackAdded() {
    }
    
    /**
     * After the video call is connected the video view will be placed near call options view
     */
    public final void onVideoTrackAdded(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
    
    private final void resizeLocalTile() {
    }
    
    @java.lang.Override()
    public void animateListViewWithCallOptions() {
    }
    
    public final void showListView() {
    }
    
    public final void setMirrorLocalView() {
    }
    
    @java.lang.Override()
    public void onSwapVideo() {
    }
    
    public final void updatePinnedUserVideoMuteStatus() {
    }
    
    @java.lang.Override()
    public void pinnedUserRemoved() {
    }
    
    public final void pinnedUserChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
    
    public final void pinnedUserLeft() {
    }
    
    @java.lang.Override()
    public void ownAudioMuteStatusUpdated() {
    }
    
    public final void onUserStoppedSpeaking(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
    
    public final void onUserSpeaking(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid, int audioLevel) {
    }
    
    public final void updateFeatureActions() {
    }
}