package com.contusfly.fragments;

import java.lang.System;

/**
 * This class provides an option to the user for setting up the data usage preferences based on the
 * type of data connection network.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0003J0\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010*\u001a\u00020\"H\u0016J\b\u0010+\u001a\u00020\"H\u0016J\u001a\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020\"H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/contusfly/fragments/DataUsageSettingsFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/widget/ExpandableListView$OnChildClickListener;", "()V", "clickFlag", "", "getClickFlag", "()I", "setClickFlag", "(I)V", "dataUsageSettingsAdapter", "Lcom/contusfly/adapters/DataUsageSettingsAdapter;", "fragmentDataUsageSettingsBinding", "Lcom/contusfly/databinding/FragmentDataUsageSettingsBinding;", "<set-?>", "Lcom/mirrorflysdk/models/MediaAutoDownloadOption;", "mediaAutoDownloadOption", "getMediaAutoDownloadOption", "()Lcom/mirrorflysdk/models/MediaAutoDownloadOption;", "nonStickyServiceIntent", "Landroid/content/Intent;", "settingsActivity", "Lcom/contusfly/activities/SettingsActivity;", "onChildClick", "", "parent", "Landroid/widget/ExpandableListView;", "v", "Landroid/view/View;", "groupPosition", "childPosition", "id", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onViewCreated", "view", "processMobileDataSettings", "processWifiDataSettings", "updateDataSettings", "Companion", "app_debug"})
public final class DataUsageSettingsFragment extends androidx.fragment.app.Fragment implements android.widget.ExpandableListView.OnChildClickListener {
    private int clickFlag = 0;
    @org.jetbrains.annotations.Nullable
    private com.mirrorflysdk.models.MediaAutoDownloadOption mediaAutoDownloadOption;
    private com.contusfly.databinding.FragmentDataUsageSettingsBinding fragmentDataUsageSettingsBinding;
    private com.contusfly.activities.SettingsActivity settingsActivity;
    private android.content.Intent nonStickyServiceIntent;
    private com.contusfly.adapters.DataUsageSettingsAdapter dataUsageSettingsAdapter;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.DataUsageSettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public DataUsageSettingsFragment() {
        super();
    }
    
    public final int getClickFlag() {
        return 0;
    }
    
    public final void setClickFlag(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.models.MediaAutoDownloadOption getMediaAutoDownloadOption() {
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
    
    @java.lang.Override
    public void onPause() {
    }
    
    private final void updateDataSettings() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public boolean onChildClick(@org.jetbrains.annotations.NotNull
    android.widget.ExpandableListView parent, @org.jetbrains.annotations.NotNull
    android.view.View v, int groupPosition, int childPosition, long id) {
        return false;
    }
    
    /**
     * Processes the user preferred data usage settings for the data connection network of type
     * [ConnectivityManager.TYPE_MOBILE].
     *
     * @param childPosition The position of the child within the group view.
     */
    private final void processMobileDataSettings(int childPosition) {
    }
    
    /**
     * Processes the user preferred data usage settings for the data connection network of type
     * [ConnectivityManager.TYPE_WIFI].
     *
     * @param childPosition The position of the child within the group view.
     */
    private final void processWifiDataSettings(int childPosition) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/DataUsageSettingsFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/DataUsageSettingsFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * The constructor used to create and initialize a new instance of this class object, with the
         * specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.fragments.DataUsageSettingsFragment newInstance() {
            return null;
        }
    }
}