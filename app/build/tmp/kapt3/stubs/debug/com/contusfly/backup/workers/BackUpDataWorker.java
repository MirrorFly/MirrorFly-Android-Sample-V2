package com.contusfly.backup.workers;

import java.lang.System;

/**
 * Worker Class for managing Backup
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0016\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/contusfly/backup/workers/BackUpDataWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "getAppContext", "()Landroid/content/Context;", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isAutoBackup", "", "()Z", "isAutoBackup$delegate", "Lkotlin/Lazy;", "isPeriodic", "isPeriodic$delegate", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBackupSuccess", "", "Companion", "app_debug"})
public final class BackUpDataWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String filePath = "";
    private final kotlin.Lazy isAutoBackup$delegate = null;
    private final kotlin.Lazy isPeriodic$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.backup.workers.BackUpDataWorker.Companion Companion = null;
    private static com.contusfly.activities.BackUpActivity.WorkerProgress workerProgress;
    
    public BackUpDataWorker(@org.jetbrains.annotations.NotNull
    android.content.Context appContext, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters workerParams) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getAppContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFilePath() {
        return null;
    }
    
    public final void setFilePath(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    private final boolean isAutoBackup() {
        return false;
    }
    
    private final boolean isPeriodic() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
    
    private final void onBackupSuccess() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/backup/workers/BackUpDataWorker$Companion;", "", "()V", "workerProgress", "Lcom/contusfly/activities/BackUpActivity$WorkerProgress;", "isWorkProgressInitialized", "", "setBackupCallBack", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void setBackupCallBack(@org.jetbrains.annotations.NotNull
        com.contusfly.activities.BackUpActivity.WorkerProgress workerProgress) {
        }
        
        public final boolean isWorkProgressInitialized() {
            return false;
        }
    }
}