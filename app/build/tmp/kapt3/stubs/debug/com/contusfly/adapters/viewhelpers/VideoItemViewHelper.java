package com.contusfly.adapters.viewhelpers;

import java.lang.System;

/**
 * Image sent/received item view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002J0\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010J\"\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ(\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002J0\u0010$\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010%\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\"J2\u0010\'\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ2\u0010*\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002JH\u0010,\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\bJH\u0010-\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\bJ\u0016\u0010.\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010.\u001a\u00020\f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010/\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u00100\u001a\u00020\f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u0019J \u00101\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\"2\u0006\u0010)\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/contusfly/adapters/viewhelpers/VideoItemViewHelper;", "", "context", "Landroid/content/Context;", "messageItemListener", "Lcom/contusfly/interfaces/MessageItemListener;", "(Landroid/content/Context;Lcom/contusfly/interfaces/MessageItemListener;)V", "getHtmlChatMessageText", "", "message", "getSpannedText", "handleReceiverVideoCaptionSearch", "", "htmlText", "", "holder", "Lcom/contusfly/adapters/holders/VideoReceivedViewHolder;", "searchEnabled", "", "searchKey", "handleReceiverVideoCaptionSearchExceptMention", "mentionedUserName", "Landroid/text/SpannableStringBuilder;", "handleReceiverVideoItemProgressUpdate", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "videoReceivedViewHolder", "handleReceiverVideoLoading", "videoReceiverViewHolder", "filePath", "base64Img", "handleSenderVideoCaptionSearch", "videoHtmlText", "videoHolder", "Lcom/contusfly/adapters/holders/VideoSentViewHolder;", "videoSearchEnabled", "handleSenderVideoCaptionSearchExceptMention", "handleSenderVideoItemProgressUpdate", "videoViewHolder", "handleVideoLoading", "videoSenderViewHolder", "fileUploadStatus", "handleVideoWithCaption", "time", "receiverVideoViewItem", "senderVideoItemView", "setImageWidthAndHeight", "setVideoReceiverMediaStatus", "setVideoSenderMediaStatus", "uploadImgProgressView", "app_debug"})
public final class VideoItemViewHelper {
    private final android.content.Context context = null;
    private final com.contusfly.interfaces.MessageItemListener messageItemListener = null;
    
    public VideoItemViewHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.interfaces.MessageItemListener messageItemListener) {
        super();
    }
    
    /**
     * Sender image item view
     *
     * @param videoSenderViewHolder Video item view holder
     * @param messageItem   Message item
     */
    public final void setImageWidthAndHeight(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoSentViewHolder videoSenderViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Sender image item view
     *
     * @param messageItem           Message item
     * @param videoSenderViewHolder Video item view holder
     * @param filePath              File local path
     * @param time                  Time of message sent
     * @param base64Img             Thumb image
     */
    public final void senderVideoItemView(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoSentViewHolder videoSenderViewHolder, @org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.String time, @org.jetbrains.annotations.Nullable()
    java.lang.String base64Img, boolean searchEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String searchKey) {
    }
    
    public final void handleVideoLoading(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoSentViewHolder videoSenderViewHolder, @org.jetbrains.annotations.NotNull()
    java.lang.String fileUploadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.String base64Img) {
    }
    
    public final void setVideoSenderMediaStatus(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoSentViewHolder videoSenderViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    private final void handleVideoWithCaption(com.mirrorflysdk.api.models.ChatMessage messageItem, com.contusfly.adapters.holders.VideoSentViewHolder videoSenderViewHolder, java.lang.String time, boolean searchEnabled, java.lang.String searchKey) {
    }
    
    private final void handleSenderVideoCaptionSearch(java.lang.CharSequence videoHtmlText, com.contusfly.adapters.holders.VideoSentViewHolder videoHolder, boolean videoSearchEnabled, java.lang.String searchKey) {
    }
    
    private final void handleSenderVideoCaptionSearchExceptMention(java.lang.CharSequence videoHtmlText, com.contusfly.adapters.holders.VideoSentViewHolder videoHolder, boolean videoSearchEnabled, java.lang.String searchKey, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    /**
     * Handle Sender video uploading progress based on file upload status
     *
     * @param messageItem      Message item
     * @param videoViewHolder  The view holding the child items.
     */
    public final void handleSenderVideoItemProgressUpdate(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoSentViewHolder videoViewHolder) {
    }
    
    /**
     * Sender image uploading progress bar view based on file upload status
     *
     * @param messageItem      Message item
     * @param videoViewHolder  The view holding the child items.
     * @param fileUploadStatus Response code for file upload status
     */
    private final void uploadImgProgressView(com.mirrorflysdk.api.models.ChatMessage messageItem, com.contusfly.adapters.holders.VideoSentViewHolder videoViewHolder, java.lang.String fileUploadStatus) {
    }
    
    /**
     * Receiver image item view
     *
     * @param videoReceiverViewHolder Video item view holder
     * @param messageItem   Message item
     */
    public final void setImageWidthAndHeight(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoReceivedViewHolder videoReceiverViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Receiver image item view
     *
     * @param messageItem             Message item
     * @param videoReceiverViewHolder Image item view holder
     * @param filePath                File local path
     * @param time                    Time of message sent
     * @param base64Img               Thumb image
     */
    public final void receiverVideoViewItem(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoReceivedViewHolder videoReceiverViewHolder, @org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.String time, @org.jetbrains.annotations.Nullable()
    java.lang.String base64Img, boolean searchEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String searchKey) {
    }
    
    public final void handleReceiverVideoLoading(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoReceivedViewHolder videoReceiverViewHolder, @org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.String base64Img) {
    }
    
    public final void setVideoReceiverMediaStatus(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoReceivedViewHolder videoReceiverViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    public final void handleReceiverVideoItemProgressUpdate(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.VideoReceivedViewHolder videoReceivedViewHolder) {
    }
    
    private final void handleReceiverVideoCaptionSearch(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.VideoReceivedViewHolder holder, boolean searchEnabled, java.lang.String searchKey) {
    }
    
    private final void handleReceiverVideoCaptionSearchExceptMention(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.VideoReceivedViewHolder holder, boolean searchEnabled, java.lang.String searchKey, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private final java.lang.String getHtmlChatMessageText(java.lang.String message) {
        return null;
    }
    
    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private final java.lang.String getSpannedText(java.lang.String message) {
        return null;
    }
}