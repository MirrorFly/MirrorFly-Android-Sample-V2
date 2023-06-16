package com.contusfly.adapters;

import java.lang.System;

/**
 * This adapter load the group user seen and delivery list in expandable list view
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010.\u001a\u00020/2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J2\u00100\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u00104\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020/2\u0006\u0010\u0013\u001a\u00020\bH\u0016J*\u00107\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&H\u0016J\b\u00108\u001a\u00020\u0019H\u0016J\u0018\u00109\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u0013\u001a\u00020\bH\u0016J<\u0010<\u001a\u00020;2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010!2\u001a\u0010>\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0!\u0018\u00010#2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0!\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/contusfly/adapters/MessageinfoExpandadapter;", "Landroid/widget/BaseExpandableListAdapter;", "context", "Landroid/content/Context;", "chattype", "Lcom/mirrorflysdk/flycommons/ChatTypeEnum;", "(Landroid/content/Context;Lcom/mirrorflysdk/flycommons/ChatTypeEnum;)V", "childPosition", "", "getChildPosition", "()I", "setChildPosition", "(I)V", "convertView", "Landroid/view/View;", "getConvertView", "()Landroid/view/View;", "setConvertView", "(Landroid/view/View;)V", "groupPosition", "getGroupPosition", "setGroupPosition", "headerTitle", "", "isExpanded", "", "()Z", "setExpanded", "(Z)V", "mChatMsgTime", "Lcom/contusfly/utils/ChatMsgTime;", "msgId", "msgInfoHeader", "", "msgInfoList", "", "Lcom/mirrorflysdk/api/models/MessageStatusDetail;", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "rosterImage", "getChild", "", "getChildId", "", "getChildView", "isLastChild", "convertViews", "getChildrenCount", "getGroup", "getGroupCount", "getGroupId", "getGroupView", "hasStableIds", "isChildSelectable", "onGroupExpanded", "", "setData", "listDataHeader", "listChildData", "Companion", "app_debug"})
public final class MessageinfoExpandadapter extends android.widget.BaseExpandableListAdapter {
    private final android.content.Context context = null;
    
    /**
     * msgId of the message
     */
    private java.lang.String msgId;
    
    /**
     * Chat message time
     */
    private final com.contusfly.utils.ChatMsgTime mChatMsgTime = null;
    private java.util.List<java.lang.String> msgInfoHeader;
    private java.lang.String rosterImage;
    private int groupPosition = 0;
    private int childPosition = 0;
    private boolean isExpanded = false;
    @org.jetbrains.annotations.Nullable()
    private android.view.View convertView;
    @org.jetbrains.annotations.Nullable()
    private android.view.ViewGroup parent;
    
    /**
     * Group Header Title
     */
    private java.lang.String headerTitle = "";
    private java.util.Map<java.lang.String, ? extends java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail>> msgInfoList;
    private final com.mirrorflysdk.flycommons.ChatTypeEnum chattype = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.adapters.MessageinfoExpandadapter.Companion Companion = null;
    private static final java.lang.String DELIVERED_TO = "Delivered to ";
    private static final java.lang.String READ_BY = "Read by ";
    
    public MessageinfoExpandadapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.ChatTypeEnum chattype) {
        super();
    }
    
    public final int getGroupPosition() {
        return 0;
    }
    
    public final void setGroupPosition(int p0) {
    }
    
    public final int getChildPosition() {
        return 0;
    }
    
    public final void setChildPosition(int p0) {
    }
    
    public final boolean isExpanded() {
        return false;
    }
    
    public final void setExpanded(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getConvertView() {
        return null;
    }
    
    public final void setConvertView(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.ViewGroup getParent() {
        return null;
    }
    
    public final void setParent(@org.jetbrains.annotations.Nullable()
    android.view.ViewGroup p0) {
    }
    
    /**
     * set the data for the header and child item
     *
     * @param listDataHeader Header for the Expandable list view
     * @param listChildData  child view for the Expandable list view
     * @param msgId          msgId of the clicked message
     */
    public final void setData(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> listDataHeader, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail>> listChildData, @org.jetbrains.annotations.Nullable()
    java.lang.String msgId) {
    }
    
    @java.lang.Override()
    public int getGroupCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getChildrenCount(int groupPosition) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object getGroup(int groupPosition) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object getChild(int groupPosition, int childPosition) {
        return null;
    }
    
    @java.lang.Override()
    public long getGroupId(int groupPosition) {
        return 0L;
    }
    
    @java.lang.Override()
    public long getChildId(int groupPosition, int childPosition) {
        return 0L;
    }
    
    @java.lang.Override()
    public boolean hasStableIds() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getGroupView(int groupPosition, boolean isExpanded, @org.jetbrains.annotations.Nullable()
    android.view.View convertViews, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getChildView(int groupPosition, int childPosition, boolean isLastChild, @org.jetbrains.annotations.Nullable()
    android.view.View convertViews, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    
    @java.lang.Override()
    public void onGroupExpanded(int groupPosition) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/adapters/MessageinfoExpandadapter$Companion;", "", "()V", "DELIVERED_TO", "", "READ_BY", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}