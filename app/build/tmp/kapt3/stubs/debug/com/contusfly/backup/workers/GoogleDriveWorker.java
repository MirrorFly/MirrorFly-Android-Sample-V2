package com.contusfly.backup.workers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010*\u001a\u00020+H\u0002J\u0011\u0010,\u001a\u00020-H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.J\u001a\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\u0012\u00106\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u000203H\u0002J\u0012\u00107\u001a\u00020+2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u00107\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0018\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bH\u0002R\u0014\u0010\n\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2 = {"Lcom/contusfly/backup/workers/GoogleDriveWorker;", "Landroidx/work/CoroutineWorker;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/google/api/client/googleapis/media/MediaHttpDownloaderProgressListener;", "Lcom/google/api/client/googleapis/media/MediaHttpUploaderProgressListener;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "account", "Landroid/accounts/Account;", "getAccount", "()Landroid/accounts/Account;", "account$delegate", "Lkotlin/Lazy;", "credential", "Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "getCredential", "()Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "credential$delegate", "drive", "Lcom/google/api/services/drive/Drive;", "getDrive", "()Lcom/google/api/services/drive/Drive;", "drive$delegate", "driveUploadFileId", "driverHelper", "Lcom/contusfly/backup/DriveHelper;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "isUpload", "", "localBackupFilePath", "reason", "createBackupFileInMirrorFlyAppFolder", "", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateBackUpFileAndReturnFile", "Ljava/io/File;", "fileName", "count", "", "getAppNameWithUserName", "getBackUpFolderPath", "getNameForBackUp", "progressChanged", "downloader", "Lcom/google/api/client/googleapis/media/MediaHttpDownloader;", "uploader", "Lcom/google/api/client/googleapis/media/MediaHttpUploader;", "saveBackupFileToFolder", "fileId", "app_debug"})
public final class GoogleDriveWorker extends androidx.work.CoroutineWorker implements kotlinx.coroutines.CoroutineScope, com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener, com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener {
    private final android.content.Context appContext = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "GoogleDriveWorker";
    private com.contusfly.backup.DriveHelper driverHelper;
    private java.lang.String localBackupFilePath;
    private java.lang.String reason;
    private java.lang.Exception exception;
    private boolean isUpload = false;
    private java.lang.String driveUploadFileId;
    private final kotlin.Lazy account$delegate = null;
    private final kotlin.Lazy credential$delegate = null;
    private final kotlin.Lazy drive$delegate = null;
    
    public GoogleDriveWorker(@org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParams) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
    
    /**
     * Save backup file from User's Google Drive to  a local file
     *
     * @param fileId String id of the backup file to be downloaded.
     */
    private final void saveBackupFileToFolder(java.lang.String fileId, java.lang.String fileName) {
    }
    
    /**
     * Creates a backup file in Google Drive and upload the local file to Server
     *
     * @param parentFolderId String id of the parent folder in which the backup file is going to be created
     */
    private final void createBackupFileInMirrorFlyAppFolder() {
    }
    
    @java.lang.Override()
    public void progressChanged(@org.jetbrains.annotations.Nullable()
    com.google.api.client.googleapis.media.MediaHttpDownloader downloader) {
    }
    
    @java.lang.Override()
    public void progressChanged(@org.jetbrains.annotations.Nullable()
    com.google.api.client.googleapis.media.MediaHttpUploader uploader) {
    }
    
    /**
     * Create a empty backup file in the application's backup  folder
     *
     * @param fileName String
     * @param count Int append to the filename if file with same name already exists
     * @return File
     */
    private final java.io.File generateBackUpFileAndReturnFile(java.lang.String fileName, int count) {
        return null;
    }
    
    /**
     * Provides the folder path for Backup file to be saved.
     *
     * @return String
     */
    private final java.lang.String getBackUpFolderPath() {
        return null;
    }
    
    private final java.lang.String getNameForBackUp(int count) {
        return null;
    }
    
    private final java.lang.String getAppNameWithUserName() {
        return null;
    }
}