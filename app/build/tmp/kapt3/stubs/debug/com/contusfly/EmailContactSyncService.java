package com.contusfly;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u000289B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020!2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020!H\u0016J\b\u0010+\u001a\u00020!H\u0007J\b\u0010,\u001a\u00020!H\u0007J\u0012\u0010-\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\"\u0010.\u001a\u00020/2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0016J\u0012\u00102\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00103\u001a\u00020!H\u0002J\b\u00104\u001a\u00020!H\u0002J\b\u00105\u001a\u00020!H\u0002J\b\u00106\u001a\u00020!H\u0002J\b\u00107\u001a\u00020!H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/contusfly/EmailContactSyncService;", "Landroidx/lifecycle/LifecycleService;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "getBuilder", "()Landroidx/core/app/NotificationCompat$Builder;", "setBuilder", "(Landroidx/core/app/NotificationCompat$Builder;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "isEmailContactSyncApiFailed", "", "isEmailContactSyncFailed", "isEmailSyncInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mBinder", "Lcom/contusfly/EmailContactSyncService$EmailContactBinder;", "mChangingConfiguration", "mNotificationManager", "Landroid/app/NotificationManager;", "getMNotificationManager", "()Landroid/app/NotificationManager;", "setMNotificationManager", "(Landroid/app/NotificationManager;)V", "retryBuilder", "handleRetrySync", "", "observeNetworkListener", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onMoveToBackground", "onMoveToForeground", "onRebind", "onStartCommand", "", "flags", "startId", "onUnbind", "prepareMailContacts", "showNotification", "showRetryNotification", "startForegroundTasks", "stopEmailContactService", "Companion", "EmailContactBinder", "app_debug"})
public final class EmailContactSyncService extends androidx.lifecycle.LifecycleService implements androidx.lifecycle.LifecycleObserver, kotlinx.coroutines.CoroutineScope {
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    private com.contusfly.EmailContactSyncService.EmailContactBinder mBinder;
    public android.app.NotificationManager mNotificationManager;
    public androidx.core.app.NotificationCompat.Builder builder;
    private androidx.core.app.NotificationCompat.Builder retryBuilder;
    private boolean mChangingConfiguration = false;
    private boolean isEmailContactSyncFailed = false;
    private boolean isEmailContactSyncApiFailed = false;
    private java.util.concurrent.atomic.AtomicBoolean isEmailSyncInProgress;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.EmailContactSyncService.Companion Companion = null;
    private static boolean appInForeground = true;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHANNEL_ID = "Sync Email Contacts";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHANNEL_NAME = "Email Contacts operations";
    public static final int NOTIFICATION_ID = 8003;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "EmailContactSyncService";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_RETRY = "com.contusfly.emailcontactsync.retry";
    
    public EmailContactSyncService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.app.NotificationManager getMNotificationManager() {
        return null;
    }
    
    public final void setMNotificationManager(@org.jetbrains.annotations.NotNull
    android.app.NotificationManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.core.app.NotificationCompat.Builder getBuilder() {
        return null;
    }
    
    public final void setBuilder(@org.jetbrains.annotations.NotNull
    androidx.core.app.NotificationCompat.Builder p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    private final void observeNetworkListener() {
    }
    
    /**
     * called when the service in running and app moved to background
     */
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public final void onMoveToBackground() {
    }
    
    /**
     * called when the service in running and app moved to or is in foreground
     */
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_START)
    public final void onMoveToForeground() {
    }
    
    /**
     * shows the notification for the ongoing contact sync task
     */
    private final void showNotification() {
    }
    
    /**
     * shows the notification with retry option for contact sync task
     */
    private final void showRetryNotification() {
    }
    
    private final void startForegroundTasks() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public boolean onUnbind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
        return false;
    }
    
    @java.lang.Override
    public void onRebind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    @java.lang.Override
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull
    android.content.res.Configuration newConfig) {
    }
    
    private final void stopEmailContactService() {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void handleRetrySync() {
    }
    
    private final void prepareMailContacts() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/EmailContactSyncService$EmailContactBinder;", "Landroid/os/Binder;", "(Lcom/contusfly/EmailContactSyncService;)V", "service", "Lcom/contusfly/EmailContactSyncService;", "getService", "()Lcom/contusfly/EmailContactSyncService;", "app_debug"})
    public final class EmailContactBinder extends android.os.Binder {
        
        public EmailContactBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.EmailContactSyncService getService() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/EmailContactSyncService$Companion;", "", "()V", "ACTION_RETRY", "", "CHANNEL_ID", "CHANNEL_NAME", "NOTIFICATION_ID", "", "TAG", "appInForeground", "", "start", "", "stop", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void start() {
        }
        
        public final void stop() {
        }
    }
}