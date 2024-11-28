package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J \u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'2\u0006\u0010)\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0016J\u0012\u0010,\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u001a\u0010/\u001a\u00020\u001c2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u000bH\u0016J\u0012\u00103\u001a\u00020\u001c2\b\u00104\u001a\u0004\u0018\u000105H\u0007J\u0012\u00106\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u00107\u001a\u00020\u001cH\u0014J\b\u00108\u001a\u00020\u001cH\u0016J\b\u00109\u001a\u00020\u001cH\u0016J\b\u0010:\u001a\u00020\u001cH\u0002J\b\u0010;\u001a\u00020\u001cH\u0002J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u000bH\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010?\u001a\u00020\u001cH\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\'H\u0002J\b\u0010B\u001a\u00020\u001cH\u0002J\b\u0010C\u001a\u00020\u001cH\u0002J\u0010\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020FH\u0014J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'H\u0016J\u0010\u0010H\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'H\u0016J\u0010\u0010I\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'H\u0016J\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020FH\u0002J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'H\u0002J\u0010\u0010M\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'H\u0016J\u0010\u0010N\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'H\u0016J\u0010\u0010O\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006P"}, d2 = {"Lcom/contusfly/activities/UserInfoActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "binding", "Lcom/contusfly/databinding/ActivityUserInfoBinding;", "collapsingToolbar", "Lcom/contusfly/collapsingToolbar/CollapsingToolbarLayout;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "isToolbarCollapsed", "", "mAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "mCoordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "privateChatActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "getProgressDialog", "()Lcom/contusfly/views/DoProgressDialog;", "setProgressDialog", "(Lcom/contusfly/views/DoProgressDialog;)V", "userProfileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "checkPrivateChatAvailable", "", "checkingIsArchivedChatUser", "getLastSeenData", "listOptionSelected", "position", "", "makeUnArchiveAlertShow", "mediaValidation", "observeNetworkListener", "onAdminBlockedOtherUser", "jid", "", "type", "status", "onClickFunction", "onConnected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onMessageEvent", "messageEvent", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onPostCreate", "onResume", "onStart", "onStop", "privateChatlaunchPinActivity", "redirectToImageView", "setMuteNotificationStatus", "isMute", "setProfileImage", "setToolbar", "setToolbarTitle", "title", "setUserData", "unArchiveUser", "updateFeatureActions", "features", "Lcom/mirrorflysdk/flycommons/Features;", "userBlockedMe", "userCameOnline", "userDeletedHisProfile", "userFeatureValidation", "availableFeatures", "userProfileUpdated", "userUnBlockedMe", "userUpdatedHisProfile", "userWentOffline", "app_debug"})
public final class UserInfoActivity extends com.contusfly.activities.BaseActivity implements com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private com.contusfly.databinding.ActivityUserInfoBinding binding;
    private com.google.android.material.appbar.AppBarLayout mAppBarLayout;
    private androidx.coordinatorlayout.widget.CoordinatorLayout mCoordinatorLayout;
    private com.contusfly.collapsingToolbar.CollapsingToolbarLayout collapsingToolbar;
    private com.mirrorflysdk.api.contacts.ProfileDetails userProfileDetails;
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    
    /**
     * The instance of the DoProgressDialog
     */
    public com.contusfly.views.DoProgressDialog progressDialog;
    
    /**
     * check weather the collapsed or not
     */
    private boolean isToolbarCollapsed = false;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> privateChatActivityResultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public UserInfoActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.views.DoProgressDialog getProgressDialog() {
        return null;
    }
    
    public final void setProgressDialog(@org.jetbrains.annotations.NotNull
    com.contusfly.views.DoProgressDialog p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onPostCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkPrivateChatAvailable() {
    }
    
    private final void checkingIsArchivedChatUser() {
    }
    
    private final void onClickFunction() {
    }
    
    private final void makeUnArchiveAlertShow() {
    }
    
    private final void observeNetworkListener() {
    }
    
    @java.lang.Override
    public void onConnected() {
    }
    
    private final void setToolbar() {
    }
    
    private final void setToolbarTitle(java.lang.String title) {
    }
    
    private final void setProfileImage(com.mirrorflysdk.api.contacts.ProfileDetails userProfileDetails) {
    }
    
    private final void setMuteNotificationStatus(boolean isMute) {
    }
    
    private final void setUserData() {
    }
    
    @java.lang.Override
    public void userCameOnline(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    @java.lang.Override
    public void userWentOffline(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    /**
     * Redirect to user image preview
     */
    private final void redirectToImageView() {
    }
    
    private final void getLastSeenData() {
    }
    
    @java.lang.Override
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    /**
     * To handle callback of any user's profile deleted
     */
    @java.lang.Override
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    private final void userProfileUpdated(java.lang.String jid) {
    }
    
    @java.lang.Override
    public void userBlockedMe(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    @java.lang.Override
    public void userUnBlockedMe(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    /**
     * To verify is there any media is present in conversation
     */
    private final void mediaValidation() {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    private final void unArchiveUser() {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    private final void userFeatureValidation(com.mirrorflysdk.flycommons.Features availableFeatures) {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(@org.jetbrains.annotations.Nullable
    com.contusfly.models.PrivateChatAuthenticationModel messageEvent) {
    }
    
    private final void privateChatlaunchPinActivity() {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
}