package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u001eH\u0014J\b\u0010#\u001a\u00020\u001eH\u0014J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0006\u0010&\u001a\u00020\u001eJ\b\u0010\'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0006H\u0016J\u001a\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0016J \u00100\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u0006H\u0016J\u0018\u00103\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0006\u00102\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u001eH\u0016J\b\u00105\u001a\u00020\u001eH\u0016J\u0010\u00106\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0012\u00107\u001a\u00020\u001e2\b\u00108\u001a\u0004\u0018\u000109H\u0014J\b\u0010:\u001a\u00020\u001eH\u0014J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u001eH\u0016J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u001eH\u0014J\u001a\u0010A\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010B\u001a\u00020\u001eH\u0002J\b\u0010C\u001a\u00020\u001eH\u0002J\b\u0010D\u001a\u00020\u001eH\u0002J\b\u0010E\u001a\u00020\u001eH\u0002J\u001a\u0010F\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010G\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020\u001eH\u0002J\b\u0010I\u001a\u00020\u001eH\u0002J\u0010\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020LH\u0014J\u0010\u0010M\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.H\u0016J\u001a\u0010N\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u001a\u0010O\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010P\u001a\u00020\u001eH\u0014J\u0018\u0010Q\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0006\u0010R\u001a\u00020SH\u0016J\u0016\u0010T\u001a\u00020\u001e2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020,0VH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006W"}, d2 = {"Lcom/contusfly/activities/BaseActivity;", "Lcom/mirrorflysdk/activities/FlyBaseActivity;", "()V", "adminBlockRunnable", "Ljava/lang/Runnable;", "adminBlockStatus", "", "adminBlockedOtherUserStatus", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "firebaseUtils", "Lcom/contusfly/utils/FirebaseUtils;", "getFirebaseUtils", "()Lcom/contusfly/utils/FirebaseUtils;", "setFirebaseUtils", "(Lcom/contusfly/utils/FirebaseUtils;)V", "handler", "Landroid/os/Handler;", "otherUserHandler", "privateChatActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "syncNeeded", "getSyncNeeded", "()Z", "setSyncNeeded", "(Z)V", "availableFeatureCallback", "", "checkContactChange", "checkContactPermission", "checkIsUserInCall", "clearActionMenu", "emailContactSyncCompleted", "handleBroadcastActions", "intent", "launchAuthPinActivity", "launchDashboardActivity", "myProfileUpdated", "isSuccess", "normalChatNotification", "jid", "", "chatMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "notifyShareUploadStatus", "onAdminBlockedOtherUser", "type", "status", "onAdminBlockedUser", "onBackPressed", "onConnected", "onContactSyncComplete", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFirebaseRemoteConfigFetched", "onLoggedOut", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "privateChatNotification", "registerBroadcast", "removeFlag", "setFlag", "setSecureFlag", "showOrUpdateOrCancelNotification", "startDashboardActivity", "startShowStopperActivity", "updateContacts", "updateFeatureActions", "features", "Lcom/mirrorflysdk/flycommons/Features;", "updateGroupReplyNotificationForArchivedSettingsEnabled", "updateNotification", "updateNotificationShowCancel", "userDetailsUpdated", "userProfileFetched", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "usersIBlockedListFetched", "jidList", "", "app_debug"})
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
    private boolean syncNeeded = false;
    public com.contusfly.utils.FirebaseUtils firebaseUtils;
    private final java.lang.Runnable adminBlockRunnable = null;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> privateChatActivityResultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    protected final boolean getSyncNeeded() {
        return false;
    }
    
    protected final void setSyncNeeded(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.utils.FirebaseUtils getFirebaseUtils() {
        return null;
    }
    
    public final void setFirebaseUtils(@org.jetbrains.annotations.NotNull
    com.contusfly.utils.FirebaseUtils p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setSecureFlag() {
    }
    
    private final void setFlag() {
    }
    
    private final void removeFlag() {
    }
    
    private final void availableFeatureCallback() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
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
    @java.lang.Override
    public void notifyShareUploadStatus(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
    }
    
    @java.lang.Override
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
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    public void showOrUpdateOrCancelNotification(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    private final void updateNotificationShowCancel(java.lang.String jid, com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    private final void normalChatNotification(java.lang.String jid, com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    private final void privateChatNotification(java.lang.String jid, com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    private final void updateNotification(java.lang.String jid, com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    @java.lang.Override
    public void updateGroupReplyNotificationForArchivedSettingsEnabled(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override
    public void onLoggedOut() {
    }
    
    @java.lang.Override
    public void onAdminBlockedUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, boolean status) {
    }
    
    private final boolean checkIsUserInCall() {
        return false;
    }
    
    private final void startShowStopperActivity() {
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    @java.lang.Override
    public void usersIBlockedListFetched(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> jidList) {
    }
    
    /**
     * Launches a new Dashboard activity. If the activity being launched is already running in the current task,
     * then instead of launching a new instance of that activity, all of the other activities on top of it will be closed
     * and this Intent will be delivered to the (now on top) old activity as a new Intent.
     */
    private final void startDashboardActivity() {
    }
    
    @java.lang.Override
    public void onContactSyncComplete(boolean isSuccess) {
    }
    
    private final void checkContactPermission() {
    }
    
    public final void checkContactChange() {
    }
    
    /**
     * sync contact whenever its updated
     */
    private final void updateContacts() {
    }
    
    @java.lang.Override
    public void userProfileFetched(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    @java.lang.Override
    public void onConnected() {
    }
    
    /**
     * Callback for email contact sync completion
     */
    protected void emailContactSyncCompleted() {
    }
    
    /**
     * The callback invoked on the completion of fetching the RemoteConfig task.
     */
    private final void onFirebaseRemoteConfigFetched() {
    }
    
    public final void launchAuthPinActivity() {
    }
    
    private final void launchDashboardActivity() {
    }
}