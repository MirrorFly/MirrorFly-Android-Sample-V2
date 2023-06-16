package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0006\u0010&\u001a\u00020\'J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\'H\u0016J\u0016\u0010*\u001a\u00020\"2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0016\u0010.\u001a\u00020\"2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0016\u0010/\u001a\u00020\"2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0016\u00100\u001a\u00020\"2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u001e\u00101\u001a\u00020\"2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u00102\u001a\u00020\nH\u0002J\u001c\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J \u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\nH\u0016J\u0012\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\u001c\u0010B\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u0001052\b\u0010C\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010D\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010E\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u0010F\u001a\u00020\"2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\nH\u0016J\u0010\u0010J\u001a\u00020\"2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020\"2\u0006\u0010N\u001a\u00020\u0007H\u0016J\u0010\u0010O\u001a\u00020\"2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020\u0007H\u0016J(\u0010R\u001a\u00020\"2\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001ej\b\u0012\u0004\u0012\u00020\u0007` 2\u0006\u00109\u001a\u00020\u0007H\u0016J\u0010\u0010T\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0016J\u001c\u0010U\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u0001052\b\u0010C\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010V\u001a\u00020\"H\u0014J\b\u0010W\u001a\u00020\"H\u0014J\b\u0010X\u001a\u00020\"H\u0016J\b\u0010Y\u001a\u00020\"H\u0002J\u001c\u0010Z\u001a\u00020\"2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u00102\u001a\u00020\nJ\u0006\u0010[\u001a\u00020\"J\b\u0010\\\u001a\u00020\"H\u0014J\b\u0010]\u001a\u00020\"H\u0002J\b\u0010^\u001a\u00020\"H\u0002J\b\u0010_\u001a\u00020\"H\u0002J\u0010\u0010`\u001a\u00020\"2\u0006\u0010)\u001a\u00020\'H\u0002J\b\u0010a\u001a\u00020\"H\u0003J\b\u0010b\u001a\u00020\"H\u0002J\b\u0010c\u001a\u00020\"H\u0002J\u0016\u0010d\u001a\u00020\n2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0016\u0010e\u001a\u00020\"2\u0006\u0010f\u001a\u00020\'2\u0006\u00102\u001a\u00020\nJ\u001e\u0010g\u001a\u00020\"2\u0006\u0010h\u001a\u00020i2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0010\u0010j\u001a\u00020\"2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010k\u001a\u00020\"2\u0006\u0010h\u001a\u00020iH\u0014J\u0010\u0010l\u001a\u00020\"2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010m\u001a\u00020\"H\u0014J\u0006\u0010n\u001a\u00020\"J\u0010\u0010o\u001a\u00020\"2\u0006\u0010p\u001a\u00020\'H\u0002R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006q"}, d2 = {"Lcom/contusfly/activities/DashboardActivity;", "Lcom/contusfly/activities/parent/DashboardParent;", "Landroid/view/View$OnClickListener;", "Landroid/view/ActionMode$Callback;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "adminBlockStatus", "", "cabOpen", "callTitleTextView", "Landroid/widget/TextView;", "chatTitleTextView", "handler", "Landroid/os/Handler;", "isLoadCallLogsOnMainThread", "menuReference", "Landroid/view/Menu;", "missedCallCountTextView", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "unReadChatCountTextView", "userJid", "addFragmentsToViewPagerAdapter", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "callLogMenuShowHide", "", "checkBioMetricLock", "checkConditionForPin", "checkEnableSafeChat", "getViewPagerCurrentPosition", "", "listOptionSelected", "position", "menuValidationForDeleteIcon", "recentList", "", "Lcom/mirrorflysdk/api/models/RecentChat;", "menuValidationForMarkReadUnReadIcon", "menuValidationForMuteUnMuteIcon", "menuValidationForPinIcon", "menuValidationForSingleItem", "startActionMode", "onActionItemClicked", "mode", "Landroid/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onAdminBlockedOtherUser", "jid", "type", "status", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateActionMode", "menu", "onCreateOptionsMenu", "onDestroyActionMode", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onGroupNotificationMessage", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "onGroupProfileFetched", "groupJid", "onMessageReceived", "onMessageStatusUpdated", "messageId", "onMessagesClearedOrDeleted", "messageIds", "onOptionsItemSelected", "onPrepareActionMode", "onRestart", "onResume", "onStop", "pinForDashBoard", "recentClick", "recentClickOnAdminBlockedUser", "restoreCompleted", "setActionMode", "setListeners", "setObservers", "setUpTabColors", "setUpTabLayout", "setUpViewPager", "setupTabPosition", "showDeleteOption", "startActionModeForCallLogs", "count", "updateActionMenuIcons", "features", "Lcom/mirrorflysdk/flycommons/Features;", "updateAdapterItems", "updateFeatureActions", "updateMenuIcons", "userDetailsUpdated", "validateMissedCallsCount", "validateUnreadChatUsers", "unReadChatCount", "app_debug"})
public final class DashboardActivity extends com.contusfly.activities.parent.DashboardParent implements android.view.View.OnClickListener, android.view.ActionMode.Callback, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private java.lang.String TAG;
    private android.widget.TextView chatTitleTextView;
    private android.widget.TextView callTitleTextView;
    private android.widget.TextView unReadChatCountTextView;
    private android.widget.TextView missedCallCountTextView;
    private boolean isLoadCallLogsOnMainThread = false;
    private boolean adminBlockStatus = false;
    private java.lang.String userJid = "";
    private android.os.Handler handler;
    private android.view.Menu menuReference;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    
    /**
     * Keep track of whether the contextual action bar is open
     */
    private boolean cabOpen = false;
    private java.util.HashMap _$_findViewCache;
    
    public DashboardActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkConditionForPin() {
    }
    
    private final void checkBioMetricLock() {
    }
    
    private final void pinForDashBoard() {
    }
    
    private final void checkEnableSafeChat() {
    }
    
    /**
     * When a new notification message is received the recent chat has to be updated and set a view to show the latest message...
     *
     * @param message Instance of the Message
     */
    @java.lang.Override()
    public void onGroupNotificationMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final java.util.ArrayList<androidx.fragment.app.Fragment> addFragmentsToViewPagerAdapter() {
        return null;
    }
    
    private final void setUpTabColors(int position) {
    }
    
    private final void setupTabPosition() {
    }
    
    private final void setUpViewPager() {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void setUpTabLayout() {
    }
    
    public final int getViewPagerCurrentPosition() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean status) {
    }
    
    @java.lang.Override()
    public boolean onActionItemClicked(@org.jetbrains.annotations.Nullable()
    android.view.ActionMode mode, @org.jetbrains.annotations.Nullable()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onCreateActionMode(@org.jetbrains.annotations.Nullable()
    android.view.ActionMode mode, @org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onPrepareActionMode(@org.jetbrains.annotations.Nullable()
    android.view.ActionMode mode, @org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public void onDestroyActionMode(@org.jetbrains.annotations.Nullable()
    android.view.ActionMode mode) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @java.lang.Override()
    protected void onRestart() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public final void recentClick(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList, boolean startActionMode) {
    }
    
    public final void recentClickOnAdminBlockedUser() {
    }
    
    private final void menuValidationForSingleItem(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList, boolean startActionMode) {
    }
    
    private final void menuValidationForPinIcon(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
    
    private final void menuValidationForMarkReadUnReadIcon(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
    
    private final void menuValidationForDeleteIcon(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
    
    private final boolean showDeleteOption(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
        return false;
    }
    
    private final void menuValidationForMuteUnMuteIcon(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
    
    /**
     * When a new message is received the recent chat has to be updated and set a view to show the latest message...
     *
     * @param message Instance of the Message
     */
    @java.lang.Override()
    public void onMessageReceived(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    @java.lang.Override()
    public void onMessageStatusUpdated(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId) {
    }
    
    @java.lang.Override()
    public void onMessagesClearedOrDeleted(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> messageIds, @org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    private final void setObservers() {
    }
    
    /**
     * Update the recent chat unread users count
     */
    private final void validateUnreadChatUsers(int unReadChatCount) {
    }
    
    private final void setListeners() {
    }
    
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    private final void setActionMode() {
    }
    
    public final void startActionModeForCallLogs(int count, boolean startActionMode) {
    }
    
    public final void validateMissedCallsCount() {
    }
    
    @java.lang.Override()
    protected void restoreCompleted() {
    }
    
    @java.lang.Override()
    protected void userDetailsUpdated() {
    }
    
    @java.lang.Override()
    public void onGroupProfileFetched(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid) {
    }
    
    @java.lang.Override()
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    private final void updateAdapterItems(com.mirrorflysdk.flycommons.Features features) {
    }
    
    private final void updateMenuIcons(com.mirrorflysdk.flycommons.Features features) {
    }
    
    private final void callLogMenuShowHide() {
    }
    
    private final void updateActionMenuIcons(com.mirrorflysdk.flycommons.Features features, java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
}