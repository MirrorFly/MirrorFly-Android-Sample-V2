package com.contusfly.call.calllog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020=H\u0002J\b\u0010A\u001a\u00020=H\u0002J\b\u0010B\u001a\u00020=H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u000fH\u0002J\u0010\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020\u0013H\u0002J\u0010\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000fH\u0002J\u0010\u0010L\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000fH\u0002J\b\u0010M\u001a\u00020=H\u0016J \u0010N\u001a\u00020=2\u0006\u0010G\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020DH\u0016J\b\u0010Q\u001a\u00020=H\u0016J\u0010\u0010R\u001a\u00020=2\u0006\u0010S\u001a\u00020DH\u0016J\u0012\u0010T\u001a\u00020=2\b\u0010U\u001a\u0004\u0018\u00010VH\u0014J\u0012\u0010W\u001a\u00020D2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u001a\u0010Z\u001a\u00020=2\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010S\u001a\u00020DH\u0016J\u0010\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020=2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000fH\u0002J\u0010\u0010d\u001a\u00020=2\u0006\u0010e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020=2\u0006\u0010e\u001a\u00020\u000fH\u0002J\u0010\u0010f\u001a\u00020=2\u0006\u0010e\u001a\u00020\u000fH\u0002J\u0010\u0010g\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000fH\u0002J\b\u0010h\u001a\u00020=H\u0002J\b\u0010i\u001a\u00020=H\u0002J\u0012\u0010j\u001a\u00020=2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010k\u001a\u00020=2\u0006\u0010l\u001a\u00020mH\u0014J\u0010\u0010n\u001a\u00020=2\u0006\u0010G\u001a\u00020\u0013H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001300X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b3\u00104R\u000e\u00106\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b9\u0010:\u00a8\u0006o"}, d2 = {"Lcom/contusfly/call/calllog/CallHistoryDetailActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Lcom/mirrorflysdk/flycall/webrtc/api/CallLogManager$CallLogActionListener;", "()V", "apiCalls", "Lcom/mirrorflysdk/flynetwork/ApiCalls;", "getApiCalls", "()Lcom/mirrorflysdk/flynetwork/ApiCalls;", "setApiCalls", "(Lcom/mirrorflysdk/flynetwork/ApiCalls;)V", "callHistoryDetailBinding", "Lcom/contusfly/databinding/ActivityCallHistoryDetailBinding;", "callLogDetails", "Lcom/mirrorflysdk/flycall/call/database/model/CallLog;", "callPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "callPermissionUtils", "Lcom/contusfly/call/CallPermissionUtils;", "callType", "getCallType", "()Ljava/lang/String;", "setCallType", "(Ljava/lang/String;)V", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dashboardViewModelFactory", "Lcom/contusfly/di/factory/AppViewModelFactory;", "getDashboardViewModelFactory", "()Lcom/contusfly/di/factory/AppViewModelFactory;", "setDashboardViewModelFactory", "(Lcom/contusfly/di/factory/AppViewModelFactory;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mUserAdapter", "Lcom/contusfly/call/calllog/CallHistoryDetailAdapter;", "getMUserAdapter", "()Lcom/contusfly/call/calllog/CallHistoryDetailAdapter;", "mUserAdapter$delegate", "Lkotlin/Lazy;", "mUsersList", "Ljava/util/ArrayList;", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "roomId", "viewModel", "Lcom/contusfly/call/calllog/CallLogViewModel;", "getViewModel", "()Lcom/contusfly/call/calllog/CallLogViewModel;", "viewModel$delegate", "callLogListener", "", "checkAudioCallPermissions", "checkVideoCallPermissions", "handleMainIntent", "initClickListeners", "initRecyclerView", "isAdminBlocked", "", "callLog", "isCallLogProfileUpdated", "jid", "listOptionSelected", "position", "", "makeGroupCall", "makeOneToOneCall", "onActionSuccess", "onAdminBlockedOtherUser", "type", "status", "onBackPressed", "onContactSyncComplete", "isSuccess", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "profileIcon", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "profileIconForManyUsers", "setCallStatusIcon", "callLogs", "setIconAlpha", "setUserView", "showClearAlertDialog", "startObservingViewModel", "updateCallLogData", "updateFeatureActions", "features", "Lcom/mirrorflysdk/flycommons/Features;", "userUpdatedHisProfile", "app_debug"})
public final class CallHistoryDetailActivity extends com.contusfly.activities.BaseActivity implements kotlinx.coroutines.CoroutineScope, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, com.mirrorflysdk.flycall.webrtc.api.CallLogManager.CallLogActionListener {
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    @javax.inject.Inject
    public com.mirrorflysdk.flynetwork.ApiCalls apiCalls;
    private java.lang.String roomId;
    private java.util.ArrayList<java.lang.String> mUsersList;
    private final kotlin.Lazy mUserAdapter$delegate = null;
    private com.mirrorflysdk.flycall.call.database.model.CallLog callLogDetails;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    @javax.inject.Inject
    public com.contusfly.di.factory.AppViewModelFactory dashboardViewModelFactory;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.contusfly.databinding.ActivityCallHistoryDetailBinding callHistoryDetailBinding;
    private com.contusfly.call.CallPermissionUtils callPermissionUtils;
    @org.jetbrains.annotations.NotNull
    private java.lang.String callType = "";
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> callPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public CallHistoryDetailActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.flynetwork.ApiCalls getApiCalls() {
        return null;
    }
    
    public final void setApiCalls(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flynetwork.ApiCalls p0) {
    }
    
    private final com.contusfly.call.calllog.CallHistoryDetailAdapter getMUserAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.di.factory.AppViewModelFactory getDashboardViewModelFactory() {
        return null;
    }
    
    public final void setDashboardViewModelFactory(@org.jetbrains.annotations.NotNull
    com.contusfly.di.factory.AppViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.call.calllog.CallLogViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCallType() {
        return null;
    }
    
    public final void setCallType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    /**
     * Displays an alert dialog to get the confirmation from the user to clear
     * the selected entry from call log history.
     */
    private final void showClearAlertDialog() {
    }
    
    private final void startObservingViewModel() {
    }
    
    private final void handleMainIntent() {
    }
    
    private final void updateCallLogData(com.mirrorflysdk.flycall.call.database.model.CallLog callLogDetails) {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void initClickListeners() {
    }
    
    private final void makeOneToOneCall(com.mirrorflysdk.flycall.call.database.model.CallLog callLog) {
    }
    
    private final void checkAudioCallPermissions() {
    }
    
    private final void checkVideoCallPermissions() {
    }
    
    private final void makeGroupCall(com.mirrorflysdk.flycall.call.database.model.CallLog callLog) {
    }
    
    private final boolean isAdminBlocked(com.mirrorflysdk.flycall.call.database.model.CallLog callLog) {
        return false;
    }
    
    /**
     * This method is getting the caller name and profile picture
     *
     * @param callLog Call Details
     */
    private final void setUserView(com.mirrorflysdk.flycall.call.database.model.CallLog callLog) {
    }
    
    private final void profileIconForManyUsers(com.mirrorflysdk.flycall.call.database.model.CallLog callLog) {
    }
    
    private final void profileIcon(com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    private final void setCallType(com.mirrorflysdk.flycall.call.database.model.CallLog callLogs) {
    }
    
    private final void setIconAlpha(com.mirrorflysdk.flycall.call.database.model.CallLog callLogs) {
    }
    
    private final void setCallStatusIcon(com.mirrorflysdk.flycall.call.database.model.CallLog callLogs) {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override
    public void onContactSyncComplete(boolean isSuccess) {
    }
    
    private final void callLogListener() {
    }
    
    @java.lang.Override
    public void onActionSuccess() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    @java.lang.Override
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    @java.lang.Override
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final boolean isCallLogProfileUpdated(java.lang.String jid) {
        return false;
    }
}