package com.contusfly.utils;

import java.lang.System;

/**
 * This class used to pick media files like audio,video and image
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/utils/PickFileUtils;", "", "()V", "checkFileSize", "", "filePath", "", "maxSize", "", "chooseImageFromGallery", "", "context", "Landroid/app/Activity;", "chooseVideoFromGallery", "isValidFileType", "fileType", "pickFile", "app_debug"})
public final class PickFileUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.PickFileUtils INSTANCE = null;
    
    private PickFileUtils() {
        super();
    }
    
    /**
     * Pick file from gallery for sending to receiver.
     *
     * @param context Application startupActivityContext
     */
    public final void pickFile(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
    }
    
    /**
     * Choose file from gallery for sending to receiver.
     *
     * @param context Application startupActivityContext
     */
    @kotlin.jvm.JvmStatic()
    public static final void chooseImageFromGallery(@org.jetbrains.annotations.Nullable()
    android.app.Activity context) {
    }
    
    /**
     * Choose video from gallery for sending to receiver.
     *
     * @param context Application startupActivityContext
     */
    public final void chooseVideoFromGallery(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
    }
    
    /**
     * check the file type is valid or not from the list of supported file types for the
     * application.
     *
     * @param fileType Type of the file means extension
     * @return boolean True if the extension is supported
     */
    @kotlin.jvm.JvmStatic()
    public static final boolean isValidFileType(@org.jetbrains.annotations.Nullable()
    java.lang.String fileType) {
        return false;
    }
    
    /**
     * Check file size of the from the path of the file
     *
     * @param filePath File path
     * @return boolean True if the size is valid
     */
    public final boolean checkFileSize(@org.jetbrains.annotations.Nullable()
    java.lang.String filePath, int maxSize) {
        return false;
    }
}