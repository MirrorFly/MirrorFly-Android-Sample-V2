package com.contusfly.fragments;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001dH\u0002J\"\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020#2\u0006\u0010\'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020+H\u0002J\u0012\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0004H\u0016J\b\u00109\u001a\u00020\u001dH\u0016J\u001a\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010<\u001a\u00020\u001dH\u0002J\b\u0010=\u001a\u00020\u001dH\u0002J\b\u0010>\u001a\u00020\u001dH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006@"}, d2 = {"Lcom/contusfly/fragments/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "navigateToSafeChat", "", "(Ljava/lang/Boolean;)V", "context", "Landroid/app/Activity;", "mDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getNavigateToSafeChat", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "progressDialog", "Landroid/app/ProgressDialog;", "<set-?>", "Lcom/contusfly/activities/SettingsActivity;", "settingsActivity", "getSettingsActivity", "()Lcom/contusfly/activities/SettingsActivity;", "settingsBinding", "Lcom/contusfly/databinding/FragmentSettingsBinding;", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "featureActionValidation", "", "availableFeatures", "Lcom/mirrorflysdk/flycommons/Features;", "initViews", "listOptionSelected", "position", "", "logOutAccount", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCheckedChanged", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onStart", "onViewCreated", "view", "setListeners", "setObserver", "setVersionName", "Companion", "app_debug"})
public final class SettingsFragment extends androidx.fragment.app.Fragment implements com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    @org.jetbrains.annotations.Nullable
    private final java.lang.Boolean navigateToSafeChat = null;
    private com.contusfly.databinding.FragmentSettingsBinding settingsBinding;
    
    /**
     * The dialog for the common alert dialog.
     */
    private com.contusfly.views.CommonAlertDialog mDialog;
    
    /**
     * The settings activity
     * The Activity to which this fragment is currently associated with.
     */
    @org.jetbrains.annotations.Nullable
    private com.contusfly.activities.SettingsActivity settingsActivity;
    
    /**
     * The context of the user activity.
     */
    private android.app.Activity context;
    
    /**
     * Progress dialog for the background process
     */
    private android.app.ProgressDialog progressDialog;
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.SettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public SettingsFragment() {
        super();
    }
    
    public SettingsFragment(@org.jetbrains.annotations.Nullable
    java.lang.Boolean navigateToSafeChat) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getNavigateToSafeChat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.activities.SettingsActivity getSettingsActivity() {
        return null;
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setListeners() {
    }
    
    private final void setVersionName() {
    }
    
    private final android.widget.CompoundButton.OnCheckedChangeListener onCheckedChanged() {
        return null;
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.contusfly.fragments.SettingsFragment newInstance(@org.jetbrains.annotations.Nullable
    java.lang.Boolean navigateToSafeChat) {
        return null;
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void logOutAccount() {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    private final void setObserver() {
    }
    
    private final void featureActionValidation(com.mirrorflysdk.flycommons.Features availableFeatures) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/fragments/SettingsFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/SettingsFragment;", "navigateToSafeChat", "", "(Ljava/lang/Boolean;)Lcom/contusfly/fragments/SettingsFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.contusfly.fragments.SettingsFragment newInstance(@org.jetbrains.annotations.Nullable
        java.lang.Boolean navigateToSafeChat) {
            return null;
        }
    }
}