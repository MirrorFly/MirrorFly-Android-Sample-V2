package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008e\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010Z\u001a\u00020FH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010[J\b\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u00020]H\u0002J\b\u0010_\u001a\u00020]H\u0002J\u0019\u0010`\u001a\u00020]2\u0006\u0010a\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020]H\u0002J\u0010\u0010d\u001a\u00020]2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010g\u001a\u00020]2\u0006\u0010a\u001a\u000203H\u0002J\u0010\u0010h\u001a\u00020]2\u0006\u0010a\u001a\u000203H\u0002J\b\u0010i\u001a\u00020]H\u0002J\b\u0010j\u001a\u00020]H\u0002J\b\u0010k\u001a\u00020]H\u0002J\b\u0010l\u001a\u00020]H\u0002J\"\u0010m\u001a\u00020]2\u0006\u0010n\u001a\u00020B2\u0006\u0010o\u001a\u00020B2\b\u0010p\u001a\u0004\u0018\u00010fH\u0014J\u0010\u0010q\u001a\u00020]2\u0006\u0010r\u001a\u00020FH\u0002J\u0012\u0010s\u001a\u00020]2\b\u0010t\u001a\u0004\u0018\u00010uH\u0014J\b\u0010v\u001a\u00020]H\u0016J\u0012\u0010w\u001a\u00020]2\b\u0010t\u001a\u0004\u0018\u00010uH\u0014J\b\u0010x\u001a\u00020]H\u0002J\u0010\u0010y\u001a\u0002052\u0006\u0010z\u001a\u00020\u0006H\u0003J\u0011\u0010{\u001a\u00020]H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010[J\b\u0010|\u001a\u00020]H\u0002J\b\u0010}\u001a\u00020]H\u0002J\b\u0010~\u001a\u00020]H\u0002J\b\u0010\u007f\u001a\u00020]H\u0002J\u0012\u0010\u0080\u0001\u001a\u00020]2\u0007\u0010\u0081\u0001\u001a\u00020\u0006H\u0002J\u0013\u0010\u0082\u0001\u001a\u00020]2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\t\u0010\u0085\u0001\u001a\u00020]H\u0002J\t\u0010\u0086\u0001\u001a\u00020]H\u0002J\t\u0010\u0087\u0001\u001a\u00020]H\u0002J\t\u0010\u0088\u0001\u001a\u00020]H\u0002J\t\u0010\u0089\u0001\u001a\u00020]H\u0002J\t\u0010\u008a\u0001\u001a\u00020]H\u0002J\t\u0010\u008b\u0001\u001a\u00020]H\u0002J\t\u0010\u008c\u0001\u001a\u00020]H\u0002J\t\u0010\u008d\u0001\u001a\u00020]H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00060\u00060 0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b$\u0010%R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020FX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u000205X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010K\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00060\u00060 0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u00020M8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010\u0010\u001a\u0004\bN\u0010OR\u000e\u0010Q\u001a\u00020RX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020T0 X\u0082.\u00a2\u0006\u0004\n\u0002\u0010UR\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020100X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u000203X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/contusfly/activities/RestoreActivity;", "Lcom/contusfly/backup/BackupRestoreParent;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/contusfly/backup/BackupRestoreParent$CommonBackupDialogListener;", "()V", "CHANNEL_ID", "", "getCHANNEL_ID", "()Ljava/lang/String;", "CHANNEL_NAME", "getCHANNEL_NAME", "account", "Landroid/accounts/Account;", "getAccount", "()Landroid/accounts/Account;", "account$delegate", "Lkotlin/Lazy;", "activityRestoreBinding", "Lcom/contusfly/databinding/ActivityRestoreBinding;", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "credential", "Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "getCredential", "()Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "credential$delegate", "downloadPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "drive", "Lcom/google/api/services/drive/Drive;", "getDrive", "()Lcom/google/api/services/drive/Drive;", "drive$delegate", "driveFile", "Lcom/google/api/services/drive/model/File;", "driveHelper", "Lcom/contusfly/backup/DriveHelper;", "getDriveHelper", "()Lcom/contusfly/backup/DriveHelper;", "setDriveHelper", "(Lcom/contusfly/backup/DriveHelper;)V", "driveWorker", "Landroidx/lifecycle/LiveData;", "Landroidx/work/WorkInfo;", "driveWorkerId", "Ljava/util/UUID;", "duration", "", "fileId", "fileName", "fileSize", "getFileSize", "()J", "setFileSize", "(J)V", "fileSizeString", "genericDialog", "Landroid/app/AlertDialog;", "imageQueue", "", "", "imageResources", "", "isDriveBackup", "", "isExisting", "lastBackupTimeInLong", "mNotifyManager", "Landroid/app/NotificationManager;", "notificationPermissionLauncher", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "permissionDeniedListener", "Lcom/contusfly/interfaces/PermissionDialogListener;", "restoreImageViews", "Landroid/widget/ImageView;", "[Landroid/widget/ImageView;", "restoreWorker", "restoreWorkerID", "workManager", "Landroidx/work/WorkManager;", "checkInternetUp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupWorker", "", "createRestoreNotificationChannel", "getAllGoogleAccounts", "getFileInfo", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "goToProfile", "handleSignInResult", "resultData", "Landroid/content/Intent;", "initDriveListeners", "initRestoreListener", "newUserSetupMailSkipButtonVisibility", "newUserSkipButtonVisibility", "notificationPermissionChecking", "onAccountClicked", "onActivityResult", "requestCode", "resultCode", "data", "onAutoSwitchClicked", "isChecked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "onPostCreate", "onRestoreClicked", "parseAndReturnDateAsString", "cd", "queryDriveFiles", "resetUIInCaseOfFailure", "restoreClickPermission", "setDriveEmailUI", "setFrequencyText", "setNewUserMail", "mail", "setUpBackUpDataUI", "backupData", "Lcom/mirrorflysdk/flydatabase/model/Backup;", "setUpNoBackUpUI", "setUpViews", "showRestoreNotification", "showUINewUser", "showUIOldUser", "startImageSwitching", "stopImageSwitching", "switchImageView", "updateImageViews", "RestoreWorkerProgress", "app_debug"})
public final class RestoreActivity extends com.contusfly.backup.BackupRestoreParent implements kotlinx.coroutines.CoroutineScope, com.contusfly.backup.BackupRestoreParent.CommonBackupDialogListener {
    private com.contusfly.databinding.ActivityRestoreBinding activityRestoreBinding;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String CHANNEL_ID = "Restore_Process_Channel";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String CHANNEL_NAME = "Restore Updates";
    public com.contusfly.backup.DriveHelper driveHelper;
    private android.app.AlertDialog genericDialog;
    private boolean isDriveBackup = true;
    private com.google.api.services.drive.model.File driveFile;
    private java.lang.String fileId;
    private java.lang.String fileName;
    private long fileSize = 0L;
    private java.lang.String fileSizeString;
    private long lastBackupTimeInLong = 0L;
    
    /**
     * Work manger instance
     */
    private final androidx.work.WorkManager workManager = null;
    private androidx.core.app.NotificationCompat.Builder builder;
    private android.app.NotificationManager mNotifyManager;
    
    /**
     * Ids of the workers
     */
    private java.util.UUID driveWorkerId;
    private java.util.UUID restoreWorkerID;
    
    /**
     * Workers Progress LiveData Observers
     */
    private androidx.lifecycle.LiveData<androidx.work.WorkInfo> restoreWorker;
    private androidx.lifecycle.LiveData<androidx.work.WorkInfo> driveWorker;
    private boolean isExisting = false;
    private android.widget.ImageView[] restoreImageViews;
    private final int[] imageResources = {com.contusfly.R.drawable.restore_1, com.contusfly.R.drawable.restore_2, com.contusfly.R.drawable.restore_3, com.contusfly.R.drawable.restore_4};
    private final long duration = 1000L;
    private java.util.List<java.lang.Integer> imageQueue;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> downloadPermissionLauncher = null;
    private final kotlin.Lazy account$delegate = null;
    private final kotlin.Lazy credential$delegate = null;
    private final kotlin.Lazy drive$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private final com.contusfly.interfaces.PermissionDialogListener permissionDeniedListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public RestoreActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCHANNEL_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCHANNEL_NAME() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.backup.DriveHelper getDriveHelper() {
        return null;
    }
    
    public final void setDriveHelper(@org.jetbrains.annotations.NotNull()
    com.contusfly.backup.DriveHelper p0) {
    }
    
    public final long getFileSize() {
        return 0L;
    }
    
    public final void setFileSize(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    private final android.accounts.Account getAccount() {
        return null;
    }
    
    private final com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential getCredential() {
        return null;
    }
    
    private final com.google.api.services.drive.Drive getDrive() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void notificationPermissionChecking() {
    }
    
    private final void switchImageView() {
    }
    
    private final void startImageSwitching() {
    }
    
    private final void stopImageSwitching() {
    }
    
    private final void updateImageViews() {
    }
    
    private final void setUpViews() {
    }
    
    private final void showUINewUser() {
    }
    
    private final void showUIOldUser() {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void restoreClickPermission() {
    }
    
    private final void onRestoreClicked() {
    }
    
    private final void createRestoreNotificationChannel() {
    }
    
    private final void showRestoreNotification() {
    }
    
    private final void onAccountClicked() {
    }
    
    private final void onAutoSwitchClicked(boolean isChecked) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    private final void goToProfile() {
    }
    
    /**
     * Sets the Frequency text of the current Back up
     */
    private final void setFrequencyText() {
    }
    
    private final java.lang.Object checkInternetUp(kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    private final void getAllGoogleAccounts() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void setNewUserMail(java.lang.String mail) {
    }
    
    private final void newUserSkipButtonVisibility() {
    }
    
    private final void newUserSetupMailSkipButtonVisibility() {
    }
    
    /**
     * Handle the Successful Sign in of Google Account with Drive Permission
     * @param resultData Intent sign in data
     */
    private final void handleSignInResult(android.content.Intent resultData) {
    }
    
    private final void setDriveEmailUI() {
    }
    
    /**
     * Query the User's Drive Files for Backup file availability
     */
    private final java.lang.Object queryDriveFiles(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void setUpNoBackUpUI() {
    }
    
    private final void setUpBackUpDataUI(com.mirrorflysdk.flydatabase.model.Backup backupData) {
    }
    
    /**
     * Provides the info about the backup file in Users's Google Drive
     *
     * @param fileId String id of the backup file
     */
    private final java.lang.Object getFileInfo(java.lang.String id, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Parse the date and return as time in milli seconds
     */
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    private final long parseAndReturnDateAsString(java.lang.String cd) {
        return 0L;
    }
    
    /**
     * Initialization of Drive Downlaod worker and its the Observers
     *
     * @param id UUID of the worker
     */
    private final void initDriveListeners(java.util.UUID id) {
    }
    
    /**
     * Initialization of Restore Data worker and its the Observers
     *
     * @param id UUID of the worker
     */
    private final void initRestoreListener(java.util.UUID id) {
    }
    
    private final void cleanupWorker() {
    }
    
    private final void resetUIInCaseOfFailure() {
    }
    
    @java.lang.Override()
    public void onDialogClosed() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/activities/RestoreActivity$RestoreWorkerProgress;", "", "onFailure", "", "reason", "", "onProgressChanged", "percentage", "", "onSuccess", "app_debug"})
    public static abstract interface RestoreWorkerProgress {
        
        public abstract void onProgressChanged(int percentage);
        
        public abstract void onFailure(@org.jetbrains.annotations.Nullable()
        java.lang.String reason);
        
        public abstract void onSuccess();
    }
}