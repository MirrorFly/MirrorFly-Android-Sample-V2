package com.contusfly.chat;

import java.lang.System;

/**
 * Helper class for the audio process handling
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/chat/AudioHandler;", "", "()V", "setAudioStatus", "", "uploadOrDownloadLayout", "Landroid/widget/RelativeLayout;", "progressBar", "Landroid/widget/ProgressBar;", "status", "", "imgPlay", "Landroid/widget/ImageView;", "mid", "", "forwardMedia", "cancelLayout", "app_debug"})
public final class AudioHandler {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.chat.AudioHandler INSTANCE = null;
    
    private AudioHandler() {
        super();
    }
    
    /**
     * Sets the audio status. The action contains MEDIA_DOWNLOADED, MEDIA_UPLOADED,
     * MEDIA_DOWNLOADING, MEDIA_UPLOADING, MEDIA_NOT_DOWNLOADED, MEDIA_NOT_UPLOADED
     *
     * @param uploadOrDownloadLayout       Upload or Download action layout
     * @param progressBar       Progress bar of the image view
     * @param status            Status of the message
     * @param imgPlay           Play image of image view
     * @param cancelLayout      Cancel the media Upload or Download layout
     * @param mid               Message id of the message
     */
    public final void setAudioStatus(@org.jetbrains.annotations.Nullable()
    android.widget.RelativeLayout uploadOrDownloadLayout, @org.jetbrains.annotations.Nullable()
    android.widget.ProgressBar progressBar, int status, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgPlay, @org.jetbrains.annotations.Nullable()
    java.lang.String mid, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView forwardMedia, @org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout cancelLayout) {
    }
}