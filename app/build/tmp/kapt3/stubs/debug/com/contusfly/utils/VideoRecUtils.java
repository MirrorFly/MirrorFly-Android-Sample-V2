package com.contusfly.utils;

import java.lang.System;

/**
 * This class is used to capture video using existing camera applications.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/utils/VideoRecUtils;", "", "()V", "getPath", "", "folderName", "getSentParentPath", "app_debug"})
public final class VideoRecUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.VideoRecUtils INSTANCE = null;
    
    private VideoRecUtils() {
        super();
    }
    
    /**
     * Returns the sent video directory inside which the video recorded file will be created.
     *
     * @param folderName The name of the folder in which the recorded video will be written.
     * @return The parent pathname string.
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSentParentPath(@org.jetbrains.annotations.NotNull
    java.lang.String folderName) {
        return null;
    }
    
    /**
     * Returns the directory inside which a new file will be created.
     *
     * @param folderName The name of the folder in which the recorded video will be written.
     * @return The parent pathname string.
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPath(@org.jetbrains.annotations.NotNull
    java.lang.String folderName) {
        return null;
    }
}