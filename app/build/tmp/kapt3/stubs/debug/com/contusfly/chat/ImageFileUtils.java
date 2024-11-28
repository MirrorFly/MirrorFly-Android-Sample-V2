package com.contusfly.chat;

import java.lang.System;

/**
 * This class contains the all chat related common methods
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/chat/ImageFileUtils;", "", "()V", "setFileImage", "", "fileViewHolder", "Landroid/widget/ImageView;", "fileName", "", "setReceiverFileImage", "setSenderFileImage", "app_debug"})
public final class ImageFileUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.chat.ImageFileUtils INSTANCE = null;
    
    private ImageFileUtils() {
        super();
    }
    
    /**
     * Set the image in the chat view based on the message type
     *
     * @param fileViewHolder Instance of the ImageView
     * @param fileName       Name of the File
     */
    public final void setFileImage(@org.jetbrains.annotations.NotNull
    android.widget.ImageView fileViewHolder, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) {
    }
    
    /**
     * Set the image in the reply view based on the message type
     *
     * @param fileViewHolder Instance of the ImageView
     * @param fileName       Name of the File
     */
    public final void setSenderFileImage(@org.jetbrains.annotations.NotNull
    android.widget.ImageView fileViewHolder, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) {
    }
    
    /**
     * Set the image in the reply view based on the message type
     *
     * @param fileViewHolder Instance of the ImageView
     * @param fileName       Name of the File
     */
    public final void setReceiverFileImage(@org.jetbrains.annotations.NotNull
    android.widget.ImageView fileViewHolder, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) {
    }
}