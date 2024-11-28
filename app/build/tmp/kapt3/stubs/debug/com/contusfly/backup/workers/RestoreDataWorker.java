package com.contusfly.backup.workers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/backup/workers/RestoreDataWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreCompletedNotify", "", "updateRestoreNotification", "progress", "", "workerProgressOnFailure", "reason", "", "workerProgressOnProgress", "percentage", "workerProgressOnSuccess", "Companion", "app_debug"})
public final class RestoreDataWorker extends androidx.work.CoroutineWorker {
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.backup.workers.RestoreDataWorker.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_ID = "Restore_Process_Channel";
    private static com.contusfly.activities.BackUpActivity.WorkerProgress workerProgress;
    private static com.contusfly.activities.RestoreActivity.RestoreWorkerProgress restoreWorkerProgress;
    
    public RestoreDataWorker(@org.jetbrains.annotations.NotNull
    android.content.Context appContext, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters workerParams) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
    
    private final void workerProgressOnFailure(java.lang.String reason) {
    }
    
    private final void workerProgressOnProgress(int percentage) {
    }
    
    private final void workerProgressOnSuccess() {
    }
    
    private final void updateRestoreNotification(int progress) {
    }
    
    private final void restoreCompletedNotify() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/backup/workers/RestoreDataWorker$Companion;", "", "()V", "CHANNEL_ID", "", "getCHANNEL_ID", "()Ljava/lang/String;", "restoreWorkerProgress", "Lcom/contusfly/activities/RestoreActivity$RestoreWorkerProgress;", "workerProgress", "Lcom/contusfly/activities/BackUpActivity$WorkerProgress;", "isRestoreWorkProgressInitialized", "", "isWorkProgressInitialized", "setRestoreCallBack", "", "setRestoreInStarActivityCallBack", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCHANNEL_ID() {
            return null;
        }
        
        public final void setRestoreCallBack(@org.jetbrains.annotations.NotNull
        com.contusfly.activities.BackUpActivity.WorkerProgress workerProgress) {
        }
        
        public final void setRestoreInStarActivityCallBack(@org.jetbrains.annotations.NotNull
        com.contusfly.activities.RestoreActivity.RestoreWorkerProgress restoreWorkerProgress) {
        }
        
        public final boolean isWorkProgressInitialized() {
            return false;
        }
        
        public final boolean isRestoreWorkProgressInitialized() {
            return false;
        }
    }
}