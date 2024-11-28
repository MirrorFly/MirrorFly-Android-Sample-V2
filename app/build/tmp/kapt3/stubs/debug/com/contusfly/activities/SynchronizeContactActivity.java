package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u0012\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0012\u00101\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00102\u001a\u00020\u001bH\u0014J\b\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/contusfly/activities/SynchronizeContactActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "binding", "Lcom/contusfly/databinding/ActivitySynchronizeContactBinding;", "callLogsViewModelFactory", "Lcom/contusfly/di/factory/AppViewModelFactory;", "getCallLogsViewModelFactory", "()Lcom/contusfly/di/factory/AppViewModelFactory;", "setCallLogsViewModelFactory", "(Lcom/contusfly/di/factory/AppViewModelFactory;)V", "callLogviewModel", "Lcom/contusfly/call/calllog/CallLogViewModel;", "getCallLogviewModel", "()Lcom/contusfly/call/calllog/CallLogViewModel;", "callLogviewModel$delegate", "Lkotlin/Lazy;", "contactPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "deviceContact", "", "getDeviceContact", "()Lkotlin/Unit;", "isContactPermissionGranted", "", "()Z", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "permissionNotDenied", "contactPermissionNotProvided", "getUsersContact", "hideProgressDialog", "initiateUserData", "observeContactSyncStatus", "onContactSyncComplete", "isSuccess", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPostCreate", "onResume", "redirectToDashBoard", "showProgressDialog", "startContactSyncTask", "app_debug"})
public final class SynchronizeContactActivity extends com.contusfly.activities.BaseActivity implements kotlinx.coroutines.CoroutineScope {
    private com.contusfly.databinding.ActivitySynchronizeContactBinding binding;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private boolean permissionNotDenied = true;
    @javax.inject.Inject
    public com.contusfly.di.factory.AppViewModelFactory callLogsViewModelFactory;
    private final kotlin.Lazy callLogviewModel$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> contactPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public SynchronizeContactActivity() {
        super();
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.di.factory.AppViewModelFactory getCallLogsViewModelFactory() {
        return null;
    }
    
    public final void setCallLogsViewModelFactory(@org.jetbrains.annotations.NotNull
    com.contusfly.di.factory.AppViewModelFactory p0) {
    }
    
    private final com.contusfly.call.calllog.CallLogViewModel getCallLogviewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onPostCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final kotlin.Unit getDeviceContact() {
        return null;
    }
    
    private final boolean isContactPermissionGranted() {
        return false;
    }
    
    /**
     * Start contact sync task running
     */
    private final void startContactSyncTask() {
    }
    
    private final void observeContactSyncStatus() {
    }
    
    /**
     * This method shows the progress dialog
     */
    private final void showProgressDialog() {
    }
    
    /**
     * This method hides the progress dialog
     */
    private final void hideProgressDialog() {
    }
    
    /**
     * Get the user roster, broadcast and groups
     */
    private final void initiateUserData() {
    }
    
    private final void getUsersContact() {
    }
    
    private final void contactPermissionNotProvided() {
    }
    
    /**
     * Redirect to user profile while register/login.
     */
    private final void redirectToDashBoard() {
    }
    
    @java.lang.Override
    public void onContactSyncComplete(boolean isSuccess) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
}