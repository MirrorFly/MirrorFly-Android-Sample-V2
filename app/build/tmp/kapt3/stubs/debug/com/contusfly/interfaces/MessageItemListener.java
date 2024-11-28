package com.contusfly.interfaces;

import java.lang.System;

/**
 * Listener for message item view like image, audio
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J&\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J.\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0019H&J\u001c\u0010\u001a\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H&J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H&J\u001c\u0010\"\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006$"}, d2 = {"Lcom/contusfly/interfaces/MessageItemListener;", "", "setChatStatus", "", "item", "Lcom/mirrorflysdk/api/models/ChatMessage;", "viewHolder", "Landroid/widget/ImageView;", "setImageViewSize", "fileSize", "", "downloadView", "Landroid/view/View;", "fileSizeView", "Landroid/widget/TextView;", "setMediaCaption", "mediStatus", "Lcom/contusfly/models/MediaCaption;", "setMediaDuration", "txtSendDuration", "fileStatus", "", "messageItem", "imgChatType", "setMediaStatus", "Lcom/contusfly/models/MediaStatus;", "setRecentChatStatus", "status", "Lcom/mirrorflysdk/api/MessageStatus;", "setStaredStatus", "isStarred", "", "imageView", "setStarredCaptionStatus", "setStatus", "imgChatStatus", "app_debug"})
public abstract interface MessageItemListener {
    
    /**
     * Set the chat status of the message => Ack => Delivered => Seen
     *
     * @param item       Message item contains message data
     * @param viewHolder Image view status
     */
    public abstract void setChatStatus(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.Nullable
    android.widget.ImageView viewHolder);
    
    /**
     * Set the chat status of the message => Ack => Delivered => Seen
     *
     * @param status     Status of message
     * @param viewHolder Image view status
     */
    public abstract void setRecentChatStatus(@org.jetbrains.annotations.Nullable
    android.widget.ImageView viewHolder, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.MessageStatus status);
    
    /**
     * Set the starred status of the message
     *
     * @param isStarred       True if the Message is starred
     * @param imageView       Image view starred
     */
    public abstract void setStaredStatus(boolean isStarred, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView);
    
    /**
     * Set the starred status of the message
     *
     * @param isStarred       True if the Message is starred
     * @param imageView       Image view starred
     */
    public abstract void setStarredCaptionStatus(boolean isStarred, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView);
    
    /**
     * Sets the media status. Action should be
     *
     *
     * => MEDIA_DOWNLOADED => MEDIA_UPLOADED => MEDIA_DOWNLOADING => MEDIA_UPLOADING =>
     * MEDIA_NOT_DOWNLOADED => MEDIA_NOT_UPLOADED
     *
     * @param txtRetry        Text view to display the retry
     * @param download        The download view of the media
     * @param progressBar     The progress bar for displaying media status
     * @param status          The status of the media
     * @param item            The instance of the message
     * @param imgPlay         The image view for the cancel download or upload
     * @param cancelImageview Cancelling upload/download option
     */
    public abstract void setMediaStatus(@org.jetbrains.annotations.NotNull
    com.contusfly.models.MediaStatus mediStatus);
    
    /**
     * Sets the media caption
     * @param htmlText           Caption Text
     * @param captionView        Caption TextView
     * @param searchEnabled      Search Enabled Status
     * @param searchKey          Search Key value
     * @param mentionedUserName  Mention UserName
     */
    public abstract void setMediaCaption(@org.jetbrains.annotations.NotNull
    com.contusfly.models.MediaCaption mediStatus);
    
    /**
     * Set the media duration for downloaded/uploaded video/audio file
     *
     * @param txtSendDuration Duration of an audio/video file
     * @param fileStatus      Status of file
     * @param messageItem     Details of the message
     * @param imgChatType     Chat type image for video
     */
    public abstract void setMediaDuration(@org.jetbrains.annotations.Nullable
    android.widget.TextView txtSendDuration, int fileStatus, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.Nullable
    android.widget.ImageView imgChatType);
    
    /**
     * setImageViewSize Set the image view size KB or MB in size
     *
     * @param fileSize     File size
     * @param downloadView View of download item
     * @param fileSizeView Text view to show file size
     */
    public abstract void setImageViewSize(@org.jetbrains.annotations.Nullable
    java.lang.String fileSize, @org.jetbrains.annotations.Nullable
    android.view.View downloadView, @org.jetbrains.annotations.Nullable
    android.widget.TextView fileSizeView);
    
    /**
     * Set the chat status of the chat item.
     *
     * @param item          Message item contains message data
     * @param imgChatStatus Image view status
     */
    public abstract void setStatus(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.Nullable
    android.widget.ImageView imgChatStatus);
}