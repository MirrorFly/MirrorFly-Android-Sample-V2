package com.contusfly.backup;

import java.lang.System;

/**
 * An Utility class for performing read/write operations on Drive files via the REST API
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J4\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\"\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00122\u0006\u0010\n\u001a\u00020\u0007J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/backup/DriveHelper;", "", "mDriveService", "Lcom/google/api/services/drive/Drive;", "(Lcom/google/api/services/drive/Drive;)V", "createFileWithProgress", "Lkotlin/Pair;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "fileName", "filePath", "listener", "Lcom/google/api/client/googleapis/media/MediaHttpUploaderProgressListener;", "getFile", "Lcom/google/api/services/drive/model/File;", "fileId", "queryFiles", "Lkotlin/Triple;", "saveBackupFileFromDriveToLocal", "", "localFilePath", "Lcom/google/api/client/googleapis/media/MediaHttpDownloaderProgressListener;", "app_debug"})
public final class DriveHelper {
    private final com.google.api.services.drive.Drive mDriveService = null;
    
    public DriveHelper(@org.jetbrains.annotations.NotNull()
    com.google.api.services.drive.Drive mDriveService) {
        super();
    }
    
    /**
     * Get the File Info of the Backup file
     *
     * @param fileId String id of the backup file
     * @return File backup file
     */
    @org.jetbrains.annotations.NotNull()
    public final com.google.api.services.drive.model.File getFile(@org.jetbrains.annotations.NotNull()
    java.lang.String fileId) {
        return null;
    }
    
    /**
     * Download the backup file from User's Google Drive to local
     *
     * @param fileId String id of the backup file to be downloaded
     * @param localFilePath String local path to which the file should be downloaded
     * @param listener MediaHttpDownloaderProgressListener listener for backup file download progress
     */
    public final void saveBackupFileFromDriveToLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String fileId, @org.jetbrains.annotations.NotNull()
    java.lang.String localFilePath, @org.jetbrains.annotations.NotNull()
    com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener listener) {
    }
    
    /**
     * Query the User's Google Drive for the backup file
     *
     * @param fileName String String search term  the query
     * @return Triple<String, String, java.lang.Exception?>
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Triple<java.lang.String, java.lang.String, java.lang.Exception> queryFiles(@org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    /**
     * Creates a file in the User's Google Drive and uploads the backup data content to that file
     *
     * @param parentId String id of the backup folder
     * @param fileName String? filename of the backup file
     * @param filePath String local backup file's file path
     * @param listener MediaHttpUploaderProgressListener listener for Drive upload progress
     * @return kotlin.Pair<String, Exception?>
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.String, java.lang.Exception> createFileWithProgress(@org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, @org.jetbrains.annotations.NotNull()
    com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener listener) {
        return null;
    }
}