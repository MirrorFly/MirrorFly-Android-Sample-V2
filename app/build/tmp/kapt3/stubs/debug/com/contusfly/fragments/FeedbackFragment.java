package com.contusfly.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010&\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010\'\u001a\u00020\u0019J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/contusfly/fragments/FeedbackFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/contusfly/databinding/FragmentFeedbackBinding;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getCommonAlertDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "commonAlertDialog$delegate", "Lkotlin/Lazy;", "initialReasons", "", "", "positionUpdated", "", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "reasons", "selectedPosition", "", "settingsActivity", "Lcom/contusfly/activities/SettingsActivity;", "deleteMyAccount", "", "getReason", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "setClickListeners", "setUpSpinnerView", "updateDeleteMyAccountButton", "Companion", "app_debug"})
public final class FeedbackFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    
    /**
     * The Activity to which this fragment is currently associated with.
     */
    private com.contusfly.activities.SettingsActivity settingsActivity;
    private com.contusfly.databinding.FragmentFeedbackBinding binding;
    
    /**
     * The progress dialog to display the progress bar When the background operations has been
     * doing
     */
    private com.contusfly.views.DoProgressDialog progressDialog;
    private final kotlin.Lazy commonAlertDialog$delegate = null;
    private int selectedPosition = 0;
    private boolean positionUpdated = false;
    private final java.util.List<java.lang.String> initialReasons = null;
    private final java.util.List<java.lang.String> reasons = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.FeedbackFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public FeedbackFragment() {
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
    
    private final void setUpSpinnerView() {
    }
    
    private final void updateDeleteMyAccountButton() {
    }
    
    public final void setClickListeners() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    private final void deleteMyAccount() {
    }
    
    private final java.lang.String getReason() {
        return null;
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object,
     * with the specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.contusfly.fragments.FeedbackFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/FeedbackFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/FeedbackFragment;", "app_debug"})
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
        public final com.contusfly.fragments.FeedbackFragment newInstance() {
            return null;
        }
    }
}