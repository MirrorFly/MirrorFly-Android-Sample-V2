package com.contusfly.utils;

import java.lang.System;

/**
 * This class used to check the availability of the media
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/utils/MediaChecker;", "", "()V", "isMediaAvailable", "", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "isMediaFileAvailable", "msgType", "Lcom/mirrorflysdk/flycommons/models/MessageType;", "isMediaType", "app_debug"})
public final class MediaChecker {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.MediaChecker INSTANCE = null;
    
    private MediaChecker() {
        super();
    }
    
    /**
     * Check whether the media file exists
     *
     * @param msgType Type of the message
     * @param message Instance of the message
     * @return boolean True if media available
     */
    public final boolean isMediaFileAvailable(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.models.MessageType msgType, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message) {
        return false;
    }
    
    /**
     * Check whether the media is downloaded or uploaded
     *
     * @param message Message item
     * @return boolean True if media available
     */
    public final boolean isMediaAvailable(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message) {
        return false;
    }
    
    /**
     * Check the type is media
     *
     * @param msgType Type of the message
     * @return boolean True if it is media
     */
    public final boolean isMediaType(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.models.MessageType msgType) {
        return false;
    }
}