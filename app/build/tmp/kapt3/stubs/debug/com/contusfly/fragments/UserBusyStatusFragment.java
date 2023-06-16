package com.contusfly.fragments;

import java.lang.System;

/**
 * This class displays the user busy value status if the user enables busy option and the user can
 * provide their busy status
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001FB\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\"\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001fH\u0016J\u0012\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J&\u0010/\u001a\u0004\u0018\u00010\u001f2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\u001a\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209H\u0016J,\u0010:\u001a\u00020\u00192\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0019H\u0016J\u001a\u0010B\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020EH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0015j\b\u0012\u0004\u0012\u00020\b`\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006G"}, d2 = {"Lcom/contusfly/fragments/UserBusyStatusFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Lcom/contusfly/utils/StatusDeleteDialog$UpdateAdapterListener;", "()V", "busyStatus", "Lcom/mirrorflysdk/api/models/BusyStatus;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "context", "Landroid/app/Activity;", "currentActivity", "fragmentUserBusyStatusBinding", "Lcom/contusfly/databinding/FragmentUserBusyStatusBinding;", "listAdapter", "Lcom/contusfly/adapters/StatusAdapter;", "statusDeleteDialog", "Lcom/contusfly/utils/StatusDeleteDialog;", "statusList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "statusToDelete", "textDone", "", "getTextDone", "()Lkotlin/Unit;", "editUserBusyStatus", "initViews", "statusView", "Landroid/view/View;", "listOptionSelected", "position", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "Landroid/content/Context;", "onClick", "view", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "", "onItemClick", "adapterView", "Landroid/widget/AdapterView;", "i", "l", "", "onNotifyAdapter", "onResume", "onViewCreated", "updateStatus", "status", "", "Companion", "app_debug"})
public final class UserBusyStatusFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, com.contusfly.utils.StatusDeleteDialog.UpdateAdapterListener {
    
    /**
     * The startupActivityContext of the user activity.
     */
    private android.app.Activity context;
    
    /**
     * The status list to display the status list in the recycler view in the activity.
     */
    private java.util.ArrayList<com.mirrorflysdk.api.models.BusyStatus> statusList;
    
    /**
     * The list adapter used to display the status of the user
     */
    private com.contusfly.adapters.StatusAdapter listAdapter;
    
    /**
     * The store the status of the user to display and can able to change and store here
     */
    private com.mirrorflysdk.api.models.BusyStatus busyStatus;
    
    /**
     * The status user selected to delete
     */
    private com.mirrorflysdk.api.models.BusyStatus statusToDelete;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    
    /**
     * The alert dialog to confirm the user action for deleting the user status.
     */
    private com.contusfly.utils.StatusDeleteDialog statusDeleteDialog;
    private com.contusfly.databinding.FragmentUserBusyStatusBinding fragmentUserBusyStatusBinding;
    
    /**
     * Instance of the activity
     */
    private android.app.Activity currentActivity;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.fragments.UserBusyStatusFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public UserBusyStatusFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * Redirect to editor to edit user busy status
     */
    private final void editUserBusyStatus() {
    }
    
    private final kotlin.Unit getTextDone() {
        return null;
    }
    
    /**
     * Update the busy status of the user in the view and they can change their status by enabling
     * busy in settings
     */
    private final void updateStatus(java.lang.String status) {
    }
    
    /**
     * on activity result
     *
     * @param requestCode requestCode of action
     * @param resultCode  resultcode for activity
     * @param data        intent data
     */
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Initiates the user busy status saved by user
     */
    private final void initViews(android.view.View statusView) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    android.widget.AdapterView<?> adapterView, @org.jetbrains.annotations.NotNull()
    android.view.View view, int i, long l) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    /**
     * On dialog closed.
     *
     * @param dialogType the dialog type
     * @param isSuccess  the is success
     */
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    /**
     * List option selected.
     *
     * @param position the position
     */
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override()
    public void onNotifyAdapter() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/UserBusyStatusFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/UserBusyStatusFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Creating the instance of Activity
         *
         * @return Instance of UserBusyStatusFragment
         */
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.fragments.UserBusyStatusFragment newInstance() {
            return null;
        }
    }
}