package com.contusfly.adapters.viewhelpers;

import java.lang.System;

/**
 * File sent/received item view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/adapters/viewhelpers/FileItemView;", "", "messageItemListener", "Lcom/contusfly/interfaces/MessageItemListener;", "(Lcom/contusfly/interfaces/MessageItemListener;)V", "fileReceiverItemView", "", "fileViewHolder", "Lcom/contusfly/adapters/holders/FileReceivedViewHolder;", "time", "", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "fileSenderItemView", "Lcom/contusfly/adapters/holders/FileSentViewHolder;", "handleReceiverFileItemProgressUpdate", "handleSenderFileItemProgressUpdate", "app_debug"})
public final class FileItemView {
    private final com.contusfly.interfaces.MessageItemListener messageItemListener = null;
    
    public FileItemView(@org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.MessageItemListener messageItemListener) {
        super();
    }
    
    /**
     * Sender image item view
     *
     * @param fileViewHolder File item view holder
     * @param time           Time of message sent
     * @param message           Message item
     */
    public final void fileSenderItemView(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.FileSentViewHolder fileViewHolder, @org.jetbrains.annotations.Nullable
    java.lang.String time, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Sender file uploading progress based on file upload status
     *
     * @param message      Message item
     * @param fileViewHolder    File item view holder
     */
    public final void handleSenderFileItemProgressUpdate(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.FileSentViewHolder fileViewHolder) {
    }
    
    /**
     * Receiver image item view
     *
     * @param fileViewHolder File item view holder
     * @param time           Time of message sent
     * @param message           Message item
     */
    public final void fileReceiverItemView(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.FileReceivedViewHolder fileViewHolder, @org.jetbrains.annotations.Nullable
    java.lang.String time, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Receiver file downloading progress based on file upload status
     *
     * @param message      Message item
     * @param fileViewHolder    File item view holder
     */
    public final void handleReceiverFileItemProgressUpdate(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.FileReceivedViewHolder fileViewHolder) {
    }
}