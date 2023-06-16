package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\u0012\u0010&\u001a\u00020\u00162\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0016H\u0014J\b\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0016H\u0014J\b\u0010/\u001a\u00020\u0016H\u0002J\u001a\u00100\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020\u0016H\u0002J\u0010\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0014J\u0010\u00108\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0016J\b\u00109\u001a\u00020\u0016H\u0014J\u0016\u0010:\u001a\u00020\u00162\f\u0010;\u001a\b\u0012\u0004\u0012\u00020!0<H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/contusfly/activities/BaseActivity;", "Lcom/mirrorflysdk/activities/FlyBaseActivity;", "()V", "adminBlockRunnable", "Ljava/lang/Runnable;", "adminBlockStatus", "", "adminBlockedOtherUserStatus", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "firebaseUtils", "Lcom/contusfly/utils/FirebaseUtils;", "getFirebaseUtils", "()Lcom/contusfly/utils/FirebaseUtils;", "setFirebaseUtils", "(Lcom/contusfly/utils/FirebaseUtils;)V", "handler", "Landroid/os/Handler;", "otherUserHandler", "availableFeatureCallback", "", "checkIsUserInCall", "clearActionMenu", "handleBroadcastActions", "intent", "Landroid/content/Intent;", "myProfileUpdated", "isSuccess", "notifyShareUploadStatus", "onAdminBlockedOtherUser", "jid", "", "type", "status", "onAdminBlockedUser", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoggedOut", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "registerBroadcast", "showOrUpdateOrCancelNotification", "chatMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "startDashboardActivity", "startShowStopperActivity", "updateFeatureActions", "features", "Lcom/mirrorflysdk/flycommons/Features;", "updateGroupReplyNotificationForArchivedSettingsEnabled", "userDetailsUpdated", "usersIBlockedListFetched", "jidList", "", "app_debug"})
public class BaseActivity extends com.mirrorflysdk.activities.FlyBaseActivity {
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    
    /**
     * The broadcast receiver. To handle the actions from the service/activity
     */
    private android.content.BroadcastReceiver broadcastReceiver;
    private android.os.Handler handler;
    private android.os.Handler otherUserHandler;
    private boolean adminBlockStatus = false;
    private boolean adminBlockedOtherUserStatus = false;
    @javax.inject.Inject()
    public com.contusfly.utils.FirebaseUtils firebaseUtils;
    private final java.lang.Runnable adminBlockRunnable = null;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.utils.FirebaseUtils getFirebaseUtils() {
        return null;
    }
    
    public final void setFirebaseUtils(@org.jetbrains.annotations.NotNull()
    com.contusfly.utils.FirebaseUtils p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void availableFeatureCallback() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void myProfileUpdated(boolean isSuccess) {
    }
    
    /**
     * register broadcast to handle the chat services
     */
    private final void registerBroadcast() {
    }
    
    /**
     * Here handle the following callbacks from the local broadcast receivers.
     *
     * FORWARDED_MESSAGE_ITEM.
     *
     * @param intent Intent from the broadcast actions
     */
    private final void handleBroadcastActions(android.content.Intent intent) {
    }
    
    /**
     * Update the upload status of a file
     *
     * @param intent intent that contains message and status of the uploaded file
     */
    @java.lang.Override()
    public void notifyShareUploadStatus(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    /**
     * Callback for clearing of action Menu
     */
    protected void clearActionMenu() {
    }
    
    /**
     * Callback for update user details in Recent Chat
     */
    protected void userDetailsUpdated() {
    }
    
    /**
     * Callback for update feature actions
     */
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void showOrUpdateOrCancelNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    @java.lang.Override()
    public void updateGroupReplyNotificationForArchivedSettingsEnabled(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onLoggedOut() {
    }
    
    @java.lang.Override()
    public void onAdminBlockedUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, boolean status) {
    }
    
    private final boolean checkIsUserInCall() {
        return false;
    }
    
    private final void startShowStopperActivity() {
    }
    
    @java.lang.Override()
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean status) {
    }
    
    @java.lang.Override()
    public void usersIBlockedListFetched(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> jidList) {
    }
    
    /**
     * Launches a new Dashboard activity. If the activity being launched is already running in the current task,
     * then instead of launching a new instance of that activity, all of the other activities on top of it will be closed
     * and this Intent will be delivered to the (now on top) old activity as a new Intent.
     */
    private final void startDashboardActivity() {
    }
}