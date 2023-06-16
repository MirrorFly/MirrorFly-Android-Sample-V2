package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0085\u0001\u0086\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u00109\u001a\u00020:H\u0002J\u0012\u0010;\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0011\u0010>\u001a\u00020&H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010?J\b\u0010@\u001a\u00020:H\u0002J\b\u0010A\u001a\u00020:H\u0002J\b\u0010B\u001a\u00020:H\u0002J\b\u0010C\u001a\u00020:H\u0002J\b\u0010D\u001a\u00020:H\u0002J\u0010\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u0015H\u0002J\u0010\u0010G\u001a\u00020:2\u0006\u0010F\u001a\u00020\u0015H\u0002J\u0010\u0010H\u001a\u00020:2\u0006\u0010F\u001a\u00020\u0015H\u0002J\b\u0010I\u001a\u00020:H\u0002J\"\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020L2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\u0010\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020&H\u0002J\b\u0010R\u001a\u00020:H\u0002J\u0010\u0010S\u001a\u00020:2\u0006\u0010T\u001a\u00020\u000fH\u0002J\b\u0010U\u001a\u00020:H\u0002J\u0012\u0010V\u001a\u00020:2\b\u0010W\u001a\u0004\u0018\u00010XH\u0014J\b\u0010Y\u001a\u00020:H\u0016J\b\u0010Z\u001a\u00020:H\u0002J\u0010\u0010[\u001a\u00020:2\u0006\u0010T\u001a\u00020\u000fH\u0002J\b\u0010\\\u001a\u00020:H\u0002J\u0012\u0010]\u001a\u00020:2\b\u0010W\u001a\u0004\u0018\u00010XH\u0014J-\u0010^\u001a\u00020:2\u0006\u0010K\u001a\u00020L2\u000e\u0010_\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c2\u0006\u0010`\u001a\u00020aH\u0016\u00a2\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020:H\u0002J\u0010\u0010d\u001a\u00020:2\u0006\u0010T\u001a\u00020\u000fH\u0002J\b\u0010e\u001a\u00020:H\u0002J\b\u0010f\u001a\u00020:H\u0002J\b\u0010g\u001a\u00020:H\u0002J\b\u0010h\u001a\u00020:H\u0002J\b\u0010i\u001a\u00020:H\u0002J\b\u0010j\u001a\u00020:H\u0002J\u0010\u0010k\u001a\u00020:2\u0006\u0010l\u001a\u00020\u001dH\u0002J\b\u0010m\u001a\u00020:H\u0002J\b\u0010n\u001a\u00020:H\u0002J\b\u0010o\u001a\u00020:H\u0002J\u001c\u0010p\u001a\u00020:2\b\b\u0002\u0010q\u001a\u00020&2\b\b\u0002\u0010r\u001a\u00020&H\u0002J\u0012\u0010s\u001a\u00020:2\b\b\u0002\u0010t\u001a\u00020&H\u0002J\b\u0010u\u001a\u00020:H\u0002J\u0010\u0010v\u001a\u00020:2\u0006\u0010w\u001a\u00020\u001dH\u0002J\u0010\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020\u001dH\u0002J\b\u0010z\u001a\u00020:H\u0002J\u0010\u0010{\u001a\u00020:2\u0006\u0010|\u001a\u00020\u001dH\u0002J\u0012\u0010}\u001a\u00020:2\b\b\u0002\u0010~\u001a\u00020&H\u0002J\u001b\u0010\u007f\u001a\u00020:2\u0007\u0010\u0080\u0001\u001a\u00020\u001d2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020:2\u0007\u0010\u0084\u0001\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R8\u0010\u0010\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000f0\u000f \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00130\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u001d0\u001d0\u001c0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000RE\u00103\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000f0\u000f \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00130\u00110\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u000208X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0087\u0001"}, d2 = {"Lcom/contusfly/activities/BackUpActivity;", "Lcom/contusfly/backup/BackupRestoreParent;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/contusfly/backup/BackupRestoreParent$CommonBackupDialogListener;", "()V", "activityBackUpBinding", "Lcom/contusfly/databinding/ActivityBackUpBinding;", "alertDialog", "Landroid/app/AlertDialog;", "backupProgressBar", "Landroid/widget/ProgressBar;", "backupProgressText", "Landroidx/appcompat/widget/AppCompatTextView;", "backupWorker", "Landroidx/lifecycle/LiveData;", "Landroidx/work/WorkInfo;", "backupWorkerGeneric", "", "kotlin.jvm.PlatformType", "", "backupWorkerID", "Ljava/util/UUID;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "downloadPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "driveUploadWorker", "driveUploadWorkerID", "filePath", "fileSize", "", "fileSizeString", "genericDialog", "isDriveBackup", "", "isOnlyBackup", "isUploadInEnqueuedState", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "restoreDataWorker", "restoreWorkerID", "titleTv", "totalCount", "uploadWorkerGeneric", "getUploadWorkerGeneric", "()Landroidx/lifecycle/LiveData;", "uploadWorkerGeneric$delegate", "workManager", "Landroidx/work/WorkManager;", "autoBackupInit", "", "checkFileToRestore", "filePathUri", "Landroid/net/Uri;", "checkInternetUp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "driveBackupInit", "driveWorkerIfNotInitialized", "genericWorkerObserver", "getAllGoogleAccounts", "getRecentChatCount", "initBackupWorker", "id", "initDriveWorker", "initRestoreWorker", "initWorkers", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAutoSwitchClicked", "isChecked", "onBackupClicked", "onBackupWorkerGenericRunning", "workerInfo", "onBackupWorkerSucceeded", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "onDownloadClicked", "onDriveWorkerRunning", "onDriveWorkerSucceeded", "onPostCreate", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreClicked", "onUploadWorkerGenericRunning", "onlyBackUpInit", "resetBackupUI", "resetDownloadUI", "resetUI", "setConnectivityText", "setDriveEmailUI", "setFileInfo", "fileLocalPath", "setFilePathIfEmpty", "setFrequencyText", "setLastBackupInfo", "showAlertDialog", "isNetDisconnected", "isRoamingLogic", "showBackupDialog", "isAuthentication", "showConnectivityDialog", "showDownloadUI", "infoText", "showUploadUI", "uploadInfoText", "startBackUp", "startRestore", "fileRealPath", "startUploadingWorkers", "wifiOnly", "updateDriveReasonUI", "reason", "progressData", "Landroidx/work/Data;", "updateProgress", "info", "Companion", "WorkerProgress", "app_debug"})
public class BackUpActivity extends com.contusfly.backup.BackupRestoreParent implements kotlinx.coroutines.CoroutineScope, com.contusfly.backup.BackupRestoreParent.CommonBackupDialogListener {
    private com.contusfly.databinding.ActivityBackUpBinding activityBackUpBinding;
    private boolean isDriveBackup = false;
    
    /**
     * Work manger instance
     */
    private final androidx.work.WorkManager workManager = null;
    
    /**
     * Ids of the workers
     */
    private java.util.UUID backupWorkerID;
    private java.util.UUID driveUploadWorkerID;
    private java.util.UUID restoreWorkerID;
    
    /**
     * Workers Progress LiveData Observers
     */
    private androidx.lifecycle.LiveData<androidx.work.WorkInfo> backupWorker;
    private androidx.lifecycle.LiveData<androidx.work.WorkInfo> driveUploadWorker;
    private androidx.lifecycle.LiveData<androidx.work.WorkInfo> restoreDataWorker;
    private android.app.AlertDialog genericDialog;
    private android.widget.ProgressBar backupProgressBar;
    private androidx.appcompat.widget.AppCompatTextView titleTv;
    private androidx.appcompat.widget.AppCompatTextView backupProgressText;
    private long fileSize = 0L;
    private java.lang.String fileSizeString = "0 KB";
    private java.lang.String filePath;
    private long totalCount = 0L;
    private boolean isUploadInEnqueuedState = false;
    private android.app.AlertDialog alertDialog;
    private boolean isOnlyBackup = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final kotlin.Lazy uploadWorkerGeneric$delegate = null;
    private final androidx.lifecycle.LiveData<java.util.List<androidx.work.WorkInfo>> backupWorkerGeneric = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> downloadPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.activities.BackUpActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "BackUpActivity";
    private java.util.HashMap _$_findViewCache;
    
    public BackUpActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    private final androidx.lifecycle.LiveData<java.util.List<androidx.work.WorkInfo>> getUploadWorkerGeneric() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setDriveEmailUI() {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void onDownloadClicked() {
    }
    
    private final void onRestoreClicked() {
    }
    
    private final void onBackupClicked() {
    }
    
    private final void startBackUp() {
    }
    
    private final void initWorkers() {
    }
    
    private final void driveBackupInit() {
    }
    
    private final void autoBackupInit() {
    }
    
    private final void onlyBackUpInit() {
    }
    
    /**
     * Updates the UI when downloading backup file is in downloading state
     *
     * @param uploadInfoText String either no internet or progress status string
     */
    private final void showDownloadUI(java.lang.String infoText) {
    }
    
    private final void onAutoSwitchClicked(boolean isChecked) {
    }
    
    private final void getRecentChatCount() {
    }
    
    private final void genericWorkerObserver() {
    }
    
    private final void onBackupWorkerGenericRunning(androidx.work.WorkInfo workerInfo) {
    }
    
    private final void onUploadWorkerGenericRunning(androidx.work.WorkInfo workerInfo) {
    }
    
    private final void setFilePathIfEmpty() {
    }
    
    private final void setFileInfo(java.lang.String fileLocalPath) {
    }
    
    /**
     * Initialization of  Drive upload worker and its the Observers
     *
     * @param id UUID of the worker
     */
    private final void initDriveWorker(java.util.UUID id) {
    }
    
    private final void onDriveWorkerRunning(androidx.work.WorkInfo workerInfo) {
    }
    
    private final void onDriveWorkerSucceeded() {
    }
    
    private final void updateDriveReasonUI(java.lang.String reason, androidx.work.Data progressData) {
    }
    
    /**
     * Updates the UI when backup is in uploading state
     *
     * @param uploadInfoText String either no internet or progress status string
     */
    private final void showUploadUI(java.lang.String uploadInfoText) {
    }
    
    /**
     * Resets the UI related to backup
     */
    private final void resetBackupUI() {
    }
    
    /**
     * Initialization of Back up messages worker and its the Observers
     *
     * @param id UUID of the worker
     */
    private final void initBackupWorker(java.util.UUID id) {
    }
    
    private final void onBackupWorkerSucceeded() {
    }
    
    private final void driveWorkerIfNotInitialized() {
    }
    
    private final void resetDownloadUI() {
    }
    
    private final void resetUI() {
    }
    
    private final void showAlertDialog(boolean isNetDisconnected, boolean isRoamingLogic) {
    }
    
    private final void startUploadingWorkers(boolean wifiOnly) {
    }
    
    /**
     * Shows the Backing up messages dialog
     */
    private final void showBackupDialog(boolean isAuthentication) {
    }
    
    /**
     * Sets the Last backup info in the UI
     */
    private final void setLastBackupInfo() {
    }
    
    /**
     * Shows the Backup Connectivity Dialog
     */
    private final void showConnectivityDialog() {
    }
    
    private final void getAllGoogleAccounts() {
    }
    
    /**
     * Sets the Frequency text of the current Back up
     */
    private final void setFrequencyText() {
    }
    
    /**
     * Sets the text of frequency backup
     */
    private final void setConnectivityText() {
    }
    
    private final java.lang.Object checkInternetUp(kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onDialogClosed() {
    }
    
    private final void checkFileToRestore(android.net.Uri filePathUri) {
    }
    
    private final void startRestore(java.lang.String fileRealPath) {
    }
    
    private final void initRestoreWorker(java.util.UUID id) {
    }
    
    private final void updateProgress(java.lang.String info) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/activities/BackUpActivity$WorkerProgress;", "", "onFailure", "", "reason", "", "onProgressChanged", "percentage", "", "onSuccess", "app_debug"})
    public static abstract interface WorkerProgress {
        
        public abstract void onProgressChanged(int percentage);
        
        public abstract void onFailure(@org.jetbrains.annotations.Nullable()
        java.lang.String reason);
        
        public abstract void onSuccess();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/activities/BackUpActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}