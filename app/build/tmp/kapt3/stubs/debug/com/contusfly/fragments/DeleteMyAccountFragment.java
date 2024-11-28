package com.contusfly.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/contusfly/fragments/DeleteMyAccountFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/contusfly/databinding/FragmentDeleteMyAccountBinding;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getCommonAlertDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "commonAlertDialog$delegate", "Lkotlin/Lazy;", "myActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "settingsActivity", "Lcom/contusfly/activities/SettingsActivity;", "hideKeyboard", "", "moveToReasonForDeleteAccount", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "setClickListeners", "setupCountryCode", "validateAndDeleteAccount", "Companion", "app_debug"})
public final class DeleteMyAccountFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    
    /**
     * The Activity to which this fragment is currently associated with.
     */
    private com.contusfly.activities.SettingsActivity settingsActivity;
    private com.contusfly.databinding.FragmentDeleteMyAccountBinding binding;
    private final kotlin.Lazy commonAlertDialog$delegate = null;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> myActivityResultLauncher;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.DeleteMyAccountFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public DeleteMyAccountFragment() {
        super();
    }
    
    private final com.contusfly.views.CommonAlertDialog getCommonAlertDialog() {
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
    
    private final void setupCountryCode() {
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    private final void validateAndDeleteAccount() {
    }
    
    /**
     * Hide the soft input keyboard from the delete my account of the window that is currently accepting
     * input..
     */
    private final void hideKeyboard() {
    }
    
    private final void moveToReasonForDeleteAccount() {
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object,
     * with the specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.contusfly.fragments.DeleteMyAccountFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/DeleteMyAccountFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/DeleteMyAccountFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.contusfly.fragments.DeleteMyAccountFragment newInstance() {
            return null;
        }
    }
}