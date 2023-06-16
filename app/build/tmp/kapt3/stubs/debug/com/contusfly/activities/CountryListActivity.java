package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0014\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/activities/CountryListActivity;", "Lcom/contusfly/activities/BaseActivity;", "()V", "actionBar", "Landroidx/appcompat/app/ActionBar;", "adapter", "Lcom/contusfly/adapters/CountriesAdapter;", "countriesRecyclerView", "Lcom/contusfly/views/CustomRecyclerView;", "countryListBinding", "Lcom/contusfly/databinding/ActivityCountryListBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onPostCreate", "setCountriesView", "app_debug"})
public final class CountryListActivity extends com.contusfly.activities.BaseActivity {
    private com.contusfly.databinding.ActivityCountryListBinding countryListBinding;
    
    /**
     * Instance of the action bar
     */
    private androidx.appcompat.app.ActionBar actionBar;
    
    /**
     * The list countries in the Recycler view
     */
    private com.contusfly.views.CustomRecyclerView countriesRecyclerView;
    
    /**
     * The adapter for the countries Set the list in this adapter Render it into the Recycler
     * view.
     */
    private com.contusfly.adapters.CountriesAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    public CountryListActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setCountriesView() {
    }
    
    /**
     * Implemented the search listener for country selection.
     *
     * @param menu Menu item
     * @return
     */
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
}