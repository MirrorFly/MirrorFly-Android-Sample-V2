package com.contusfly.adapters;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u001e\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/contusfly/adapters/ProfileStartStatusAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultStatus", "", "statusList", "", "Lcom/mirrorflysdk/api/models/ProfileStatus;", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setStatus", "", "status", "app_debug"})
public final class ProfileStartStatusAdapter extends android.widget.BaseAdapter {
    
    /**
     * The status list.
     */
    private java.util.List<com.mirrorflysdk.api.models.ProfileStatus> statusList;
    
    /**
     * Default status for the application user
     */
    private java.lang.String defaultStatus;
    
    public ProfileStartStatusAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Set the status list list to set in the list view
     *
     * @param status        List of available status
     * @param defaultStatus Default status
     */
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mirrorflysdk.api.models.ProfileStatus> status, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultStatus) {
    }
    
    /**
     * List of Status
     *
     * @return size of status list
     */
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object getItem(int position) {
        return null;
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"ViewHolder"})
    @java.lang.Override()
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable()
    android.view.View convertView, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
}