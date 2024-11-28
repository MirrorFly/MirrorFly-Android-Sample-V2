package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&J\u0012\u0010\'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010#H\u0007J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0015J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0015H\u0016J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0014J\u0016\u00100\u001a\u00020\u00192\f\u00101\u001a\b\u0012\u0004\u0012\u00020#02H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u00063"}, d2 = {"Lcom/contusfly/activities/SettingsActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "mMenu", "Landroid/view/Menu;", "settingsBinding", "Lcom/contusfly/databinding/ActivitySettingsBinding;", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkIsToEnableSafeChat", "", "intent", "Landroid/content/Intent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "onStart", "onUpdateBusyStatus", "status", "message", "", "performFragmentTransaction", "fragment", "Landroidx/fragment/app/Fragment;", "setActionBarTitle", "title", "showSearchMenu", "show", "updateArchivedSettings", "archivedSettingsStatus", "updateFeatureActions", "features", "Lcom/mirrorflysdk/flycommons/Features;", "usersIBlockedListFetched", "jidList", "", "app_debug"})
public final class SettingsActivity extends com.contusfly.activities.BaseActivity implements kotlinx.coroutines.CoroutineScope {
    private com.contusfly.databinding.ActivitySettingsBinding settingsBinding;
    private androidx.fragment.app.FragmentManager fragmentManager;
    private final kotlin.Lazy viewModel$delegate = null;
    
    /**
     * menus
     */
    private android.view.Menu mMenu;
    private java.util.HashMap _$_findViewCache;
    
    public SettingsActivity() {
        super();
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean checkIsToEnableSafeChat(android.content.Intent intent) {
        return false;
    }
    
    /**
     * Set the action bar's title.
     *
     * @param title Title to set.
     */
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    public final void setActionBarTitle(@org.jetbrains.annotations.Nullable
    java.lang.String title) {
    }
    
    public final void showSearchMenu(boolean show) {
    }
    
    /**
     * Performs fragment transaction by replacing an existing fragment that was added to the
     * container which is actually present in the parent activity. This is essentially the same as
     * calling [FragmentTransaction.remove] for all currently added fragments that
     * were added with the container and then [FragmentTransaction.add]
     * with the arguments specified.
     *
     * @param fragment The new fragment to place in the container.
     */
    public final void performFragmentTransaction(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    public void usersIBlockedListFetched(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> jidList) {
    }
    
    @java.lang.Override
    public void updateArchivedSettings(boolean archivedSettingsStatus) {
    }
    
    @java.lang.Override
    public void onUpdateBusyStatus(boolean status, @org.jetbrains.annotations.Nullable
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    /**
     * Implemented the search listener for country selection.
     *
     * @param menu Menu item
     * @return
     */
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.Features features) {
    }
}