package com.contusfly.backup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0012J\u0019\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001bJ\u0012\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0012H\u0002J\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\'0&2\u0006\u0010(\u001a\u00020\u0012H\u0002J\u0006\u0010)\u001a\u00020\u0012J\u0006\u0010*\u001a\u00020\u0012J\u0006\u0010+\u001a\u00020\u0015J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u001bJ\u0006\u00101\u001a\u00020\u0010J(\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bJ\u0010\u00105\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u0012J\u000e\u00106\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001bJ\u0006\u00107\u001a\u00020\u0015R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/contusfly/backup/WorkManagerController;", "", "()V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "appContext$delegate", "Lkotlin/Lazy;", "workManager", "Landroidx/work/WorkManager;", "getWorkManager", "()Landroidx/work/WorkManager;", "workManager$delegate", "backUpDriveUpload", "Lkotlin/Triple;", "Ljava/util/UUID;", "isBackupActivity", "", "backUpDriveUploadIsAutoBack", "cancelAutoBackupWorkers", "", "cancelBackupWorkers", "cancelRestoreWorkers", "checkGoogleLogin", "checkIfAWorkerIsAlreadyScheduledOrNot", "tag", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkRoaming", "context", "checkWifiLogic", "deleteAFileByPath", "filepath", "getConstraint", "Landroidx/work/Constraints;", "isDownload", "getDriveWithCleanWorker", "Lkotlin/Pair;", "Landroidx/work/OneTimeWorkRequest;", "wifiOnly", "isConnectedToWifi", "isNetConnected", "resetBackupData", "retryAttemptLogic", "Landroidx/work/ListenableWorker$Result;", "runAttemptCount", "", "reason", "runBackupOnly", "runDriveRestoreWorkers", "fileId", "fileName", "runDriveUpload", "runRestoreOnly", "startBackingUp", "app_debug"})
public final class WorkManagerController {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.backup.WorkManagerController INSTANCE = null;
    private static final kotlin.Lazy appContext$delegate = null;
    private static final kotlin.Lazy workManager$delegate = null;
    
    private WorkManagerController() {
        super();
    }
    
    private final android.content.Context getAppContext() {
        return null;
    }
    
    private final androidx.work.WorkManager getWorkManager() {
        return null;
    }
    
    /**
     * Cancels all the running and scheduled backup workers
     */
    public final void cancelBackupWorkers() {
    }
    
    /**
     * Cancels all the running and scheduled backup workers
     */
    public final void cancelAutoBackupWorkers() {
    }
    
    /**
     * Cancels all the running and scheduled restore workers
     */
    public final void cancelRestoreWorkers() {
    }
    
    /**
     * Constraints for the Workers
     *
     * @param isDownload Boolean
     * @return Constraints
     */
    private final androidx.work.Constraints getConstraint(boolean isDownload) {
        return null;
    }
    
    /**
     * Retry Logic for workers in case of unexpected exception or scenarios
     *
     * @param runAttemptCount Int retry attempt made till
     * @param reason String reason that stopped the worker
     * @return ListenableWorker.Result
     */
    @org.jetbrains.annotations.NotNull
    public final androidx.work.ListenableWorker.Result retryAttemptLogic(int runAttemptCount, @org.jetbrains.annotations.NotNull
    java.lang.String reason) {
        return null;
    }
    
    /**
     * Triggers the Auto Backup Process
     */
    public final void startBackingUp() {
    }
    
    /**
     * Deletes a file in the device
     * @param filepath String path of the file to be deleted
     */
    public final void deleteAFileByPath(@org.jetbrains.annotations.NotNull
    java.lang.String filepath) {
    }
    
    /**
     * Checks whether the User logged in for Google Account
     * @return Boolean
     */
    public final boolean checkGoogleLogin() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID runBackupOnly() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID runDriveUpload(boolean wifiOnly) {
        return null;
    }
    
    private final kotlin.Pair<androidx.work.OneTimeWorkRequest, androidx.work.OneTimeWorkRequest> getDriveWithCleanWorker(boolean wifiOnly) {
        return null;
    }
    
    public final void resetBackupData() {
    }
    
    public final boolean isNetConnected() {
        return false;
    }
    
    public final boolean isConnectedToWifi() {
        return false;
    }
    
    public final boolean checkWifiLogic() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object checkIfAWorkerIsAlreadyScheduledOrNot(@org.jetbrains.annotations.NotNull
    java.lang.String tag, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    public final boolean checkRoaming(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID backUpDriveUploadIsAutoBack(boolean isBackupActivity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Triple<java.util.UUID, java.util.UUID, java.util.UUID> backUpDriveUpload(boolean isBackupActivity) {
        return null;
    }
    
    /**
     * Enqueue the workers for User's Google Drive Restore Process
     *
     * @param fileId String id of the file to be Downloaded from User's Google Drive
     * @return Triple<UUID, UUID, UUID> id of all the workers
     */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Triple<java.util.UUID, java.util.UUID, java.util.UUID> runDriveRestoreWorkers(@org.jetbrains.annotations.NotNull
    java.lang.String fileId, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID runRestoreOnly(@org.jetbrains.annotations.NotNull
    java.lang.String filepath) {
        return null;
    }
}