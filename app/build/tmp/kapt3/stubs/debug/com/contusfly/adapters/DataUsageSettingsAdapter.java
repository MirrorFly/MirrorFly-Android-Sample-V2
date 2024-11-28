package com.contusfly.adapters;

import java.lang.System;

/**
 * This class which extends ExpandableListAdapter is used to provide data and views in an
 * expandable list view.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016J2\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\nH\u0016J*\u0010%\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010\'\u001a\u00020\u001dH\u0016J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010+\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010,\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010-\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u00100\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/contusfly/adapters/DataUsageSettingsAdapter;", "Landroid/widget/BaseExpandableListAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "childItemList", "Ljava/util/HashMap;", "", "", "clickedPosition", "", "compoundDrawable", "dataUsageSettingsFragment", "Lcom/contusfly/fragments/DataUsageSettingsFragment;", "groupItemList", "audioAutoDownloadCheckViaData", "", "childViewText", "Lcom/contusfly/views/CustomTextView;", "audioAutoDownloadCheckViaWifi", "getChild", "", "groupPosition", "childPosition", "getChildId", "", "getChildView", "Landroid/view/View;", "isLastChild", "", "convertView", "parent", "Landroid/view/ViewGroup;", "getChildrenCount", "getGroup", "getGroupCount", "getGroupId", "getGroupView", "isExpanded", "hasStableIds", "isChildSelectable", "photoAutoDownloadCheckViaData", "photoAutoDownloadCheckViaWifi", "setClickedPosition", "setCompoundDrawable", "setUpMobileDataSettingsChildView", "setUpWifiDataSettingsChildView", "videoAutoDownloadCheckViaData", "videoAutoDownloadCheckViaWifi", "app_debug"})
public final class DataUsageSettingsAdapter extends android.widget.BaseExpandableListAdapter {
    
    /**
     * Only Clicked position
     */
    private int clickedPosition = 0;
    private int compoundDrawable = 0;
    private final com.contusfly.fragments.DataUsageSettingsFragment dataUsageSettingsFragment = null;
    private final java.util.List<java.lang.String> groupItemList = null;
    private final java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> childItemList = null;
    
    public DataUsageSettingsAdapter(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment) {
        super();
    }
    
    @java.lang.Override
    public int getGroupCount() {
        return 0;
    }
    
    @java.lang.Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.Object getGroup(int groupPosition) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.Object getChild(int groupPosition, int childPosition) {
        return null;
    }
    
    @java.lang.Override
    public long getGroupId(int groupPosition) {
        return 0L;
    }
    
    @java.lang.Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0L;
    }
    
    @java.lang.Override
    public boolean hasStableIds() {
        return false;
    }
    
    public final void setCompoundDrawable(int compoundDrawable) {
    }
    
    public final void setClickedPosition(int clickedPosition) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View getGroupView(int groupPosition, boolean isExpanded, @org.jetbrains.annotations.Nullable
    android.view.View convertView, @org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View getChildView(int groupPosition, int childPosition, boolean isLastChild, @org.jetbrains.annotations.Nullable
    android.view.View convertView, @org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    
    /**
     * Sets a View that displays the mobile data usage settings for the given child.
     *
     * @param childViewText The child view to display the data.
     * @param childPosition The position of the child within the group view.
     */
    private final void setUpMobileDataSettingsChildView(com.contusfly.views.CustomTextView childViewText, int childPosition) {
    }
    
    private final void photoAutoDownloadCheckViaData(com.contusfly.views.CustomTextView childViewText) {
    }
    
    private final void videoAutoDownloadCheckViaData(com.contusfly.views.CustomTextView childViewText) {
    }
    
    private final void audioAutoDownloadCheckViaData(com.contusfly.views.CustomTextView childViewText) {
    }
    
    /**
     * Sets a View that displays the wifi data usage settings for the given child.
     *
     * @param childViewText The child view to display the data.
     * @param childPosition The position of the child within the group view.
     */
    private final void setUpWifiDataSettingsChildView(com.contusfly.views.CustomTextView childViewText, int childPosition) {
    }
    
    private final void photoAutoDownloadCheckViaWifi(com.contusfly.views.CustomTextView childViewText) {
    }
    
    private final void videoAutoDownloadCheckViaWifi(com.contusfly.views.CustomTextView childViewText) {
    }
    
    private final void audioAutoDownloadCheckViaWifi(com.contusfly.views.CustomTextView childViewText) {
    }
}