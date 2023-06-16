package com.contusfly.activities;

import java.lang.System;

/**
 * The class GroupMessageInfoActivity shows group/broadcast chat message in common.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J \u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0015H\u0016J\b\u0010;\u001a\u00020.H\u0002J\u0010\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u0015H\u0016J\u0012\u0010>\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u0010?\u001a\u00020.2\u0006\u00102\u001a\u00020\u0015H\u0016J\b\u0010@\u001a\u00020.H\u0016J0\u0010A\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010\n2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010E\u001a\u0004\u0018\u00010(H\u0002J\b\u0010F\u001a\u00020.H\u0002J\u0010\u0010G\u001a\u00020.2\u0006\u00102\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u0010\u0010&\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/contusfly/activities/GroupMessageInfoActivity;", "Lcom/contusfly/activities/parent/BaseMessageInfoActivity;", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "deliverStatus", "Landroid/widget/ExpandableListView;", "deliveryStatus", "", "Lcom/mirrorflysdk/api/models/MessageStatusDetail;", "img", "Landroid/widget/ImageView;", "infoadapterdeliver", "Lcom/contusfly/adapters/MessageinfoExpandadapter;", "infoadapterread", "listdeliverDataChild", "Ljava/util/HashMap;", "", "getListdeliverDataChild", "()Ljava/util/HashMap;", "setListdeliverDataChild", "(Ljava/util/HashMap;)V", "listdeliverDataHeader", "", "getListdeliverDataHeader", "()Ljava/util/List;", "setListdeliverDataHeader", "(Ljava/util/List;)V", "listreadDataChild", "getListreadDataChild", "setListreadDataChild", "listreadDataHeader", "getListreadDataHeader", "setListreadDataHeader", "noimgread", "notxt", "Landroid/widget/TextView;", "notxtread", "read", "readStatus", "txtDate", "loadChatInfo", "", "loadChatInformation", "loadGroupChatInfo", "onAdminBlockedOtherUser", "jid", "type", "status", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteGroup", "groupJid", "onGroupMsgStatusUpdated", "onMessageStatusUpdated", "messageId", "onPostCreate", "onProfileUpdatedCallback", "onUpdateUnStarAllMessages", "ongroupclicklistener", "listView", "adapter", "Landroid/widget/BaseExpandableListAdapter;", "txt", "startDashboardActivity", "userDeletedHisProfile", "app_debug"})
public final class GroupMessageInfoActivity extends com.contusfly.activities.parent.BaseMessageInfoActivity {
    
    /**
     * Header for delivery Expandable list view
     */
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> listdeliverDataHeader;
    
    /**
     * Child data for delivery status Expandable list view
     */
    @org.jetbrains.annotations.Nullable()
    private java.util.HashMap<java.lang.String, java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail>> listdeliverDataChild;
    
    /**
     * Header for read Expandablelist view
     */
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> listreadDataHeader;
    
    /**
     * child view for Read status Expandable list view
     */
    @org.jetbrains.annotations.Nullable()
    private java.util.HashMap<java.lang.String, java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail>> listreadDataChild;
    
    /**
     * group memebers count
     */
    private int count = 0;
    
    /**
     * group message read status
     */
    private java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail> readStatus;
    
    /**
     * text view to show the messages sent date
     */
    private android.widget.TextView txtDate;
    
    /**
     */
    private android.widget.TextView notxt;
    
    /**
     * image view seen when message deliver to no one
     */
    private android.widget.ImageView img;
    
    /**
     * group message delivery status
     */
    private java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail> deliveryStatus;
    
    /**
     * expandable list for the deliver status
     */
    private android.widget.ExpandableListView deliverStatus;
    
    /**
     * expandable list for the read status
     */
    private android.widget.ExpandableListView read;
    
    /**
     * Adapter for the deliver status
     */
    private com.contusfly.adapters.MessageinfoExpandadapter infoadapterdeliver;
    
    /**
     * Adapter for the read status
     */
    private com.contusfly.adapters.MessageinfoExpandadapter infoadapterread;
    private android.widget.TextView notxtread;
    private android.widget.ImageView noimgread;
    private java.util.HashMap _$_findViewCache;
    
    public GroupMessageInfoActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getListdeliverDataHeader() {
        return null;
    }
    
    public final void setListdeliverDataHeader(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.HashMap<java.lang.String, java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail>> getListdeliverDataChild() {
        return null;
    }
    
    public final void setListdeliverDataChild(@org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getListreadDataHeader() {
        return null;
    }
    
    public final void setListreadDataHeader(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.HashMap<java.lang.String, java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail>> getListreadDataChild() {
        return null;
    }
    
    public final void setListreadDataChild(@org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail>> p0) {
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onMessageStatusUpdated(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId) {
    }
    
    @java.lang.Override()
    public void onUpdateUnStarAllMessages() {
    }
    
    @java.lang.Override()
    public void onProfileUpdatedCallback(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    private final void onGroupMsgStatusUpdated() {
    }
    
    /**
     * method to load the chat info broadcast or group message info
     */
    private final void loadChatInfo() {
    }
    
    /**
     * method to show the seen and delivery info status of members in the group messages
     */
    private final void loadGroupChatInfo() {
    }
    
    private final void loadChatInformation() {
    }
    
    /**
     * @param listView expandable list view to set for on groupexapand and collapse listener
     * @param adapter  adapter for expandable list view
     */
    private final void ongroupclicklistener(android.widget.ExpandableListView listView, android.widget.BaseExpandableListAdapter adapter, android.widget.ImageView img, android.widget.TextView txt) {
    }
    
    @java.lang.Override()
    public void onDeleteGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid) {
    }
    
    private final void startDashboardActivity() {
    }
    
    @java.lang.Override()
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean status) {
    }
}