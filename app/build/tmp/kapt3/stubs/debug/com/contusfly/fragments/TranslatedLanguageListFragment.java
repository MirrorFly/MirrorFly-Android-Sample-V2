package com.contusfly.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [TranslatedLanguageListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/contusfly/fragments/TranslatedLanguageListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "languageListAdapter", "Lcom/contusfly/adapters/LanguageListAdapter;", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "translatedLanguageListBinding", "Lcom/contusfly/databinding/FragmentTranslatedLanguageListBinding;", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setObservers", "updateSearch", "searchKey", "", "Companion", "app_debug"})
public final class TranslatedLanguageListFragment extends androidx.fragment.app.Fragment {
    private com.contusfly.databinding.FragmentTranslatedLanguageListBinding translatedLanguageListBinding;
    
    /**
     * Progress dialog for the background process
     */
    private com.contusfly.views.DoProgressDialog progressDialog;
    private com.contusfly.adapters.LanguageListAdapter languageListAdapter;
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.fragments.TranslatedLanguageListFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public TranslatedLanguageListFragment() {
        super();
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setObservers() {
    }
    
    private final void updateSearch(java.lang.String searchKey) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/TranslatedLanguageListFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/TranslatedLanguageListFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Creating the instance of Activity
         *
         * @return Instance of TranslatedLanguageListFragment
         */
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.fragments.TranslatedLanguageListFragment newInstance() {
            return null;
        }
    }
}