package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\"\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u0012\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u001a\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\"\u001a\u00020\u000bH\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0002J\u0012\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u00105\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u000209H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/contusfly/activities/ProfileStartStatusActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Lcom/contusfly/utils/StatusDeleteDialog$UpdateAdapterListener;", "()V", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "handler", "Landroid/os/Handler;", "isFromSettingsProfile", "", "listAdapter", "Lcom/contusfly/adapters/ProfileStartStatusAdapter;", "profileStartStatusBinding", "Lcom/contusfly/databinding/ActivityProfileStartStatusBinding;", "profileStatus", "", "progress", "Lcom/contusfly/views/DoProgressDialog;", "progressTimeoutRunnable", "Ljava/lang/Runnable;", "statusList", "", "Lcom/mirrorflysdk/api/models/ProfileStatus;", "statusToDelete", "finish", "", "getStatusListFromSDK", "initViews", "listOptionSelected", "position", "", "myProfileUpdated", "isSuccess", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "onNotifyAdapter", "showDeleteStatusAlert", "statusSuccessResult", "status", "updateStatus", "userProfileFetched", "jid", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "app_debug"})
public final class ProfileStartStatusActivity extends com.contusfly.activities.BaseActivity implements android.view.View.OnClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, com.contusfly.utils.StatusDeleteDialog.UpdateAdapterListener {
    private com.contusfly.databinding.ActivityProfileStartStatusBinding profileStartStatusBinding;
    
    /**
     * The status list to display the status list in the recycler view in the activity.
     */
    private java.util.List<com.mirrorflysdk.api.models.ProfileStatus> statusList;
    
    /**
     * The list adapter used to display the status of the user
     */
    private com.contusfly.adapters.ProfileStartStatusAdapter listAdapter;
    
    /**
     * The store the status of the user to display and can able to change and store here
     */
    private java.lang.String profileStatus;
    
    /**
     * The status user selected to delete
     */
    private com.mirrorflysdk.api.models.ProfileStatus statusToDelete;
    
    /**
     * The progress dialog which used to display in the main User interface thread when doing
     * background tasks
     */
    private com.contusfly.views.DoProgressDialog progress;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    private android.os.Handler handler;
    private final java.lang.Runnable progressTimeoutRunnable = null;
    private boolean isFromSettingsProfile = false;
    private java.util.HashMap _$_findViewCache;
    
    public ProfileStartStatusActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void myProfileUpdated(boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void userProfileFetched(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    /**
     * Initialize the views. Creating objects Assigning the values Default display in the activity
     */
    private final void initViews() {
    }
    
    /**
     * Update the status of the user in the view and they can change their status in the profile
     * object and update called in the service
     */
    private final void updateStatus(java.lang.String status) {
    }
    
    private final void statusSuccessResult(java.lang.String status) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    /**
     * Activity finish if the result is okay.
     */
    @java.lang.Override()
    public void finish() {
    }
    
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override()
    public void onNotifyAdapter() {
    }
    
    /**
     * Alert to show the user while choose status delete option
     */
    private final void showDeleteStatusAlert() {
    }
    
    public final void getStatusListFromSDK() {
    }
}