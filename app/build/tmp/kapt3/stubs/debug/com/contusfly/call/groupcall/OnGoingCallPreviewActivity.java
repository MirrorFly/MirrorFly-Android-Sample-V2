package com.contusfly.call.groupcall;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\bH\u0002J\b\u00106\u001a\u000204H\u0002J\b\u00107\u001a\u000204H\u0002J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\u0018H\u0002J\u0010\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020\u0018H\u0002J\u0012\u0010<\u001a\u0002042\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u000204H\u0002J\b\u0010D\u001a\u000204H\u0002J\b\u0010E\u001a\u000204H\u0002J\u0010\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u000204H\u0002J\b\u0010J\u001a\u000204H\u0002J \u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0018H\u0016J\u0010\u0010O\u001a\u0002042\u0006\u0010P\u001a\u00020QH\u0016J\u0012\u0010R\u001a\u0002042\b\u0010S\u001a\u0004\u0018\u00010TH\u0014J\b\u0010U\u001a\u000204H\u0014J\u001a\u0010V\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020\u0018H\u0016J\b\u0010Z\u001a\u000204H\u0014J\b\u0010[\u001a\u000204H\u0002J\b\u0010\\\u001a\u000204H\u0002J\b\u0010]\u001a\u000204H\u0002J\b\u0010^\u001a\u000204H\u0002J\u0018\u0010_\u001a\u0002042\u0006\u0010`\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u0018H\u0002J\b\u0010a\u001a\u000204H\u0002J \u0010b\u001a\u0002042\u0006\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020\b2\u0006\u0010e\u001a\u00020\u0018H\u0002J\u0016\u0010f\u001a\u0002042\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\b0hH\u0002J\u0010\u0010i\u001a\u0002042\u0006\u0010N\u001a\u00020\u0018H\u0002J\b\u0010j\u001a\u000204H\u0002J\b\u0010k\u001a\u000204H\u0002J\b\u0010l\u001a\u000204H\u0002J\b\u0010m\u001a\u000204H\u0002J\u0016\u0010n\u001a\u0002042\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0002J\u0010\u0010p\u001a\u0002042\u0006\u0010L\u001a\u00020\bH\u0016J\u0010\u0010q\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\bH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0013j\b\u0012\u0004\u0012\u00020\b`\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010(\u001a\u0004\b%\u0010&R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006r"}, d2 = {"Lcom/contusfly/call/groupcall/OnGoingCallPreviewActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "audioCallPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "callEndedText", "Lcom/contusfly/views/CustomTextView;", "callEndedTextMessage", "callEndedView", "Landroid/widget/LinearLayout;", "callLink", "checkInternetConnection", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "groupUsersList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imgProfilePicture", "Lcom/contusfly/views/CircularImageView;", "isAudioMuteClicked", "", "isFromOnCreate", "isFromSplashScreen", "joinCallView", "Landroid/widget/RelativeLayout;", "muteAudioImage", "Landroid/widget/ImageView;", "muteVideoImage", "notificationPermissionLauncher", "onGoingCallPreviewScreenBinding", "Lcom/contusfly/databinding/ActivityOnGoingCallPreviewScreenBinding;", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "setDrawable", "Lcom/contusfly/views/SetDrawable;", "userJid", "userName", "userProfilePicView", "videoCallPermissionLauncher", "videoLocalView", "Lcom/mirrorflysdk/flycall/webrtc/TextureViewRenderer;", "askCallSwitchPopup", "", "url", "checkAndAllowToOnGngCall", "checkCallPermissions", "checkUserCallSubscribeDetails", "subscribeStatus", "handleJoinNowButton", "enable", "handleLocalTrackAdded", "videoTrack", "Lorg/webrtc/VideoTrack;", "handleOnFailure", "error", "Lcom/mirrorflysdk/flycommons/Error;", "hideProgressDialog", "initVideoLocalView", "initViews", "joinCallPreviewInitialization", "listOptionSelected", "position", "", "observeNetworkListener", "observingCallEvents", "onAdminBlockedOtherUser", "jid", "type", "status", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onPause", "setAudioMuteUnMuteStatus", "setAudioVideoMuteStatus", "setLocalViewProfilePic", "setUpToolbar", "setViewMuteAndUnMuteStatus", "muteImage", "showAlertForTelephonyCall", "showErrorResponse", "callEnded", "callEndedMessage", "isInvalidLink", "showJoinCallOrCallEndedView", "usersList", "", "showLocalVideoView", "showUserProfilePic", "subscribeCallEvents", "toggleMic", "toggleVideoMute", "updateGroupMemberDetails", "callUsers", "userUpdatedHisProfile", "validateAndStartJoinCallSetup", "app_debug"})
public final class OnGoingCallPreviewActivity extends com.contusfly.activities.BaseActivity implements android.view.View.OnClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private com.contusfly.databinding.ActivityOnGoingCallPreviewScreenBinding onGoingCallPreviewScreenBinding;
    
    /**
     * Instance for surface view render local view
     */
    private com.mirrorflysdk.flycall.webrtc.TextureViewRenderer videoLocalView;
    private com.contusfly.views.DoProgressDialog progressDialog;
    private android.widget.LinearLayout userProfilePicView;
    private android.widget.LinearLayout callEndedView;
    private android.widget.RelativeLayout joinCallView;
    private com.contusfly.views.CustomTextView callEndedText;
    private com.contusfly.views.CustomTextView checkInternetConnection;
    private com.contusfly.views.CustomTextView callEndedTextMessage;
    private com.contusfly.views.CircularImageView imgProfilePicture;
    private com.contusfly.views.SetDrawable setDrawable;
    private java.lang.String callLink = "";
    private java.lang.String userJid = "";
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> videoCallPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> audioCallPermissionLauncher = null;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    
    /**
     * This image view for  audio mute
     */
    private android.widget.ImageView muteAudioImage;
    private boolean isAudioMuteClicked = false;
    private boolean isFromSplashScreen = false;
    private boolean isFromOnCreate = false;
    private java.lang.String userName = "";
    
    /**
     * This image view for video mute
     */
    private android.widget.ImageView muteVideoImage;
    private java.util.ArrayList<java.lang.String> groupUsersList;
    private java.util.HashMap _$_findViewCache;
    
    public OnGoingCallPreviewActivity() {
        super();
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void validateAndStartJoinCallSetup(java.lang.String callLink) {
    }
    
    private final void askCallSwitchPopup(java.lang.String url) {
    }
    
    private final void subscribeCallEvents() {
    }
    
    private final void joinCallPreviewInitialization() {
    }
    
    private final void handleOnFailure(com.mirrorflysdk.flycommons.Error error) {
    }
    
    private final void setAudioVideoMuteStatus() {
    }
    
    private final void setViewMuteAndUnMuteStatus(android.widget.ImageView muteImage, boolean status) {
    }
    
    private final void initViews() {
    }
    
    private final void checkCallPermissions() {
    }
    
    private final void setUpToolbar() {
    }
    
    private final void initVideoLocalView() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    private final void observeNetworkListener() {
    }
    
    private final void checkUserCallSubscribeDetails(boolean subscribeStatus) {
    }
    
    private final void handleLocalTrackAdded(org.webrtc.VideoTrack videoTrack) {
    }
    
    private final void observingCallEvents() {
    }
    
    private final void hideProgressDialog() {
    }
    
    private final void showErrorResponse(java.lang.String callEnded, java.lang.String callEndedMessage, boolean isInvalidLink) {
    }
    
    private final void showJoinCallOrCallEndedView(java.util.List<java.lang.String> usersList) {
    }
    
    private final void handleJoinNowButton(boolean enable) {
    }
    
    private final void setAudioMuteUnMuteStatus() {
    }
    
    @java.lang.Override
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void showUserProfilePic() {
    }
    
    private final void setLocalViewProfilePic() {
    }
    
    private final void showLocalVideoView(boolean status) {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    private final void showAlertForTelephonyCall() {
    }
    
    private final void checkAndAllowToOnGngCall() {
    }
    
    private final void toggleVideoMute() {
    }
    
    private final void toggleMic() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    private final void updateGroupMemberDetails(java.util.ArrayList<java.lang.String> callUsers) {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
}