package com.contusfly.chat;

import java.lang.System;

/**
 * The utility class to get the real path of the file picked from the primary external storage
 * volume. This helper class supports all the API versions of the Android to get the real decoded
 * path.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b \n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002JE\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0002\u00a2\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002J$\u0010 \u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u0004\u0018\u00010\u0004J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\'\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001c\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0003J\u001a\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0003J\u001a\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0003J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001a\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0003J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u00103\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\"\u00106\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u00108\u001a\u0002092\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/contusfly/chat/RealPathUtil;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "intentType", "checkFilePath", "filePath", "Ljava/io/File;", "context", "Landroid/content/Context;", "fileUri", "Landroid/net/Uri;", "copyUriToFile", "", "uri", "dst", "createFile", "folderName", "fileName", "getDataColumn", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getDocumentRealPath", "contentUri", "getDriveFilePath", "getExtension", "path", "getFileName", "getFilePath", "mimeType", "directoryName", "getIntentType", "getMimeTypeFromFilePath", "getName", "filename", "getNewFilePath", "getRealPath", "getRealPathFromURIAPI19", "handleCloudAttach", "handleDownloadDocument", "handleExternalDoc", "handleFileExtension", "extension", "handleMediaDocument", "isDownloadsDocument", "isExternalStorageDocument", "isGoogleCloudPhotosUri", "isGoogleDriveUri", "isGooglePhotosUri", "isMediaDocument", "saveFileFromUri", "destinationPath", "setIntentType", "", "app_debug"})
public final class RealPathUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.chat.RealPathUtil INSTANCE = null;
    private static final java.lang.String TAG = null;
    private static java.lang.String intentType;
    
    private RealPathUtil() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIntentType() {
        return null;
    }
    
    public final void setIntentType(@org.jetbrains.annotations.NotNull()
    java.lang.String intentType) {
    }
    
    /**
     * Get file Absolute path from file Uri object
     *
     * @param context the app component context
     * @param fileUri the Uri object of the file
     * @return String the absolute path of the file.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRealPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.net.Uri fileUri) {
        return null;
    }
    
    /**
     * Get a file path from a Uri. This will get the the path for Storage Access Framework
     * Documents, as well as the _data field for the MediaStore and other file-based
     * ContentProviders.
     *
     * @param context The startupActivityContext.
     * @param uri     The Uri to query.
     */
    @android.annotation.SuppressLint(value = {"NewApi"})
    private final java.lang.String getRealPathFromURIAPI19(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String handleCloudAttach(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    /**
     * Document from external storage
     *
     * @param context the app component context
     * @param uri     the Uri object of the file
     * @return path of the file
     */
    @android.annotation.SuppressLint(value = {"NewApi"})
    private final java.lang.String handleExternalDoc(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    /**
     * Media Document
     *
     * @param context the app component context
     * @param uri     the Uri object of the file
     * @return getDataColumn
     */
    @android.annotation.SuppressLint(value = {"NewApi"})
    private final java.lang.String handleMediaDocument(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    /**
     * Media Download Document
     *
     * @param context the app component context
     * @param uri     the Uri object of the file
     * @return check null
     */
    @android.annotation.SuppressLint(value = {"NewApi"})
    private final java.lang.String handleDownloadDocument(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    /**
     * Document Real path
     *
     * @param context    the app component context
     * @param uri        the Uri object of the file
     * @param contentUri the Uri object of the file
     * @return the absolute path of the file.
     */
    private final java.lang.String getDocumentRealPath(android.content.Context context, android.net.Uri uri, android.net.Uri contentUri) {
        return null;
    }
    
    /**
     * Get the value of the data column for this Uri. This is useful for MediaStore Uris, and other
     * file-based ContentProviders.
     *
     * @param context       The startupActivityContext.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    private final java.lang.String getDataColumn(android.content.Context context, android.net.Uri uri, android.net.Uri fileUri, java.lang.String selection, java.lang.String[] selectionArgs) {
        return null;
    }
    
    private final java.lang.String checkFilePath(java.io.File filePath, android.content.Context context, android.net.Uri fileUri) {
        return null;
    }
    
    private final java.io.File getFilePath(java.lang.String fileName, java.lang.String mimeType, java.lang.String directoryName) {
        return null;
    }
    
    private final java.lang.String getExtension(java.lang.String path) {
        return null;
    }
    
    private final java.lang.String getMimeTypeFromFilePath(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    /**
     * New file Path
     *
     * @param context the app component context
     * @param uri     the Uri object of the file
     * @return check null
     */
    private final java.lang.String getNewFilePath(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String getDriveFilePath(android.content.Context context, java.lang.String fileName, android.net.Uri fileUri) {
        return null;
    }
    
    private final boolean copyUriToFile(android.content.Context context, android.net.Uri uri, java.io.File dst) {
        return false;
    }
    
    private final java.lang.String getFileName(android.net.Uri uri) {
        return null;
    }
    
    /**
     * Returns the directory named by this abstract folderName and fileName, including any necessary
     * but nonexistent parent directories.
     *
     * @param folderName The parent's pathname.
     * @param fileName   The child's pathname.
     * @return The created file to which the downloaded data is written.
     */
    private final java.io.File createFile(java.lang.String folderName, java.lang.String fileName) {
        return null;
    }
    
    /**
     * get the name of the file.
     *
     * @param context activity context
     * @param uri     uri of the file
     * @return the file name
     */
    private final java.lang.String getFileName(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    private final boolean saveFileFromUri(android.content.Context context, android.net.Uri uri, java.lang.String destinationPath) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    private final boolean isExternalStorageDocument(android.net.Uri uri) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    private final boolean isDownloadsDocument(android.net.Uri uri) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    private final boolean isMediaDocument(android.net.Uri uri) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    private final boolean isGooglePhotosUri(android.net.Uri uri) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Drive.
     */
    private final boolean isGoogleDriveUri(android.net.Uri uri) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Drive.
     */
    private final boolean isGoogleCloudPhotosUri(android.net.Uri uri) {
        return false;
    }
    
    private final java.lang.String getName(java.lang.String filename) {
        return null;
    }
    
    private final java.lang.String handleFileExtension(java.lang.String extension) {
        return null;
    }
}