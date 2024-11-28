package com.contusfly.utils;

import java.lang.System;

/**
 * This class used to get the media details...
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0003\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ6\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/utils/MediaDetailUtils;", "", "()V", "getMediaDuration", "", "context", "Landroid/content/Context;", "duration", "", "(Landroid/content/Context;Ljava/lang/Long;)Ljava/lang/String;", "audioPath", "getMediaDurationInSecs", "", "setMediaView", "", "txtSendDuration", "Landroid/widget/TextView;", "fileStatus", "starredMessageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "imgChatType", "Landroid/widget/ImageView;", "app_debug"})
public final class MediaDetailUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.MediaDetailUtils INSTANCE = null;
    
    private MediaDetailUtils() {
        super();
    }
    
    /**
     * Sets the downloaded/uploaded view for the video/audio file.
     *
     * @param context            the startupActivityContext of the calling parent.
     * @param txtSendDuration    duration of an audio/video file.
     * @param fileStatus         the status of file.
     * @param starredMessageItem the details of the message.
     * @param imgChatType        chat type image for video.
     */
    public final void setMediaView(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.widget.TextView txtSendDuration, int fileStatus, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage starredMessageItem, @org.jetbrains.annotations.Nullable
    android.widget.ImageView imgChatType) {
    }
    
    /**
     * Calling this method to get the audio duration of an audio file
     *
     * @param context   Application startupActivityContext
     * @param duration Audio file duration
     * @return String Audio file duration
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMediaDuration(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.Long duration) {
        return null;
    }
    
    /**
     * Calling this method to get the audio duration of an audio file
     *
     * @param audioPath Audio file local path
     * @return String Audio file duration
     */
    public final long getMediaDuration(@org.jetbrains.annotations.Nullable
    java.lang.String audioPath) {
        return 0L;
    }
    
    /**
     * Calling this method to get the audio duration of an audio file
     *
     * @param duration Audio file duration
     * @return String Audio file duration
     */
    public final int getMediaDurationInSecs(long duration) {
        return 0;
    }
}