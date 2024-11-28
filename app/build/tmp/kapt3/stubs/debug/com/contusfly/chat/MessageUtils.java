package com.contusfly.chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/chat/MessageUtils;", "", "()V", "checkIsNotNotification", "", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "filterRecalledMessages", "", "", "messageIds", "Ljava/util/ArrayList;", "getMediaStatus", "", "fileStatus", "filePath", "isUpload", "isMediaExists", "app_debug"})
public final class MessageUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.chat.MessageUtils INSTANCE = null;
    
    private MessageUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> filterRecalledMessages(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> messageIds) {
        return null;
    }
    
    /**
     * Return the status of media with respect to availability
     *
     * @param fileStatus upload / download status
     * @param filePath local path of the media
     * @param isUpload is uploading
     * @return status of the media
     */
    public final int getMediaStatus(@org.jetbrains.annotations.NotNull
    java.lang.String fileStatus, @org.jetbrains.annotations.Nullable
    java.lang.String filePath, boolean isUpload) {
        return 0;
    }
    
    public final boolean isMediaExists(@org.jetbrains.annotations.Nullable
    java.lang.String filePath) {
        return false;
    }
    
    /**
     * Get the view type based on the type of the message
     *
     * @param messageItem message object
     * @return int Type of the chat
     */
    public final boolean checkIsNotNotification(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
        return false;
    }
}