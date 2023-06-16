package com.contusfly.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u001f2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010/\u001a\u00020\u001f2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\fH\u0016J\u001a\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020*2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\fH\u0002J\b\u00107\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\u00a8\u00069"}, d2 = {"Lcom/contusfly/fragments/BlockedContactsFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "blockedContactsBinding", "Lcom/contusfly/databinding/FragmentBlockedContactsBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "isBlockClicked", "", "mAdapter", "Lcom/contusfly/adapters/BlockedContactsAdapter;", "mDialog", "Lcom/contusfly/views/CommonAlertDialog;", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "selectedUserJid", "", "selectedUserName", "settingsActivity", "Lcom/contusfly/activities/SettingsActivity;", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "featureActionValidation", "", "availableFeatures", "Lcom/mirrorflysdk/flycommons/Features;", "initViews", "listOptionSelected", "position", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onViewCreated", "view", "refreshAdapter", "serverCall", "setObservers", "Companion", "app_debug"})
public final class BlockedContactsFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private com.contusfly.databinding.FragmentBlockedContactsBinding blockedContactsBinding;
    
    /**
     * Intance of the SettingsActivity
     */
    private com.contusfly.activities.SettingsActivity settingsActivity;
    
    /**
     * The progress dialog to display the progress bar When the background operations has been
     * doing
     */
    private com.contusfly.views.DoProgressDialog progressDialog;
    private com.contusfly.adapters.BlockedContactsAdapter mAdapter;
    
    /**
     * The store selected Jid
     */
    private java.lang.String selectedUserJid = "";
    
    /**
     * The store selected Profile Name
     */
    private java.lang.String selectedUserName = "";
    
    /**
     * The dialog for the common alert dialog.
     */
    private com.contusfly.views.CommonAlertDialog mDialog;
    private final kotlin.Lazy viewModel$delegate = null;
    private boolean isBlockClicked = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.fragments.BlockedContactsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public BlockedContactsFragment() {
        super();
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setObservers() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    /**
     * Refresh adapter once the changes has been made in the recent chats.
     */
    private final void refreshAdapter(boolean serverCall) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.contusfly.fragments.BlockedContactsFragment newInstance() {
        return null;
    }
    
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    private final void featureActionValidation(com.mirrorflysdk.flycommons.Features availableFeatures) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/BlockedContactsFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/BlockedContactsFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.contusfly.fragments.BlockedContactsFragment newInstance() {
            return null;
        }
    }
}