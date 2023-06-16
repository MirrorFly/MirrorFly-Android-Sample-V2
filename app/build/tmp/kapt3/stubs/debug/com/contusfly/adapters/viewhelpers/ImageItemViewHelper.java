package com.contusfly.adapters.viewhelpers;

import java.lang.System;

/**
 * Image sent/received item view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ2\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J(\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J0\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u001dJ\"\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ(\u0010$\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J0\u0010%\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010&\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\'\u001a\u00020\nJH\u0010(\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\fJH\u0010)\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\fJ\u0016\u0010*\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010,\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010,\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J \u0010-\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010.\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/contusfly/adapters/viewhelpers/ImageItemViewHelper;", "", "context", "Landroid/content/Context;", "messageItemListener", "Lcom/contusfly/interfaces/MessageItemListener;", "(Landroid/content/Context;Lcom/contusfly/interfaces/MessageItemListener;)V", "checkCaption", "", "imgViewHolder", "Lcom/contusfly/adapters/holders/ImageSentViewHolder;", "getHtmlChatMessageText", "", "message", "getSpannedText", "handleImageLoading", "filePath", "base64Img", "handleImageWithCaption", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "time", "searchEnabled", "", "searchKey", "handleReceiverImageCaptionSearch", "htmlText", "", "holder", "Lcom/contusfly/adapters/holders/ImageReceivedViewHolder;", "handleReceiverImageCaptionSearchExceptMention", "mentionedUserName", "Landroid/text/SpannableStringBuilder;", "handleReceiverImageItemProgressUpdate", "imageReceivedViewHolder", "handleReceiverImageLoading", "handleSenderImageCaptionSearch", "handleSenderImageCaptionSearchExceptMention", "handleSenderImageItemProgressUpdate", "imageSentViewHolder", "receiverImageViewItem", "senderImageItemView", "setImageReceiverMediaStatus", "setImageSenderMediaStatus", "setImageWidthAndHeight", "uploadImgProgressView", "fileUploadStatus", "app_debug"})
public final class ImageItemViewHelper {
    private final android.content.Context context = null;
    private final com.contusfly.interfaces.MessageItemListener messageItemListener = null;
    
    public ImageItemViewHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.interfaces.MessageItemListener messageItemListener) {
        super();
    }
    
    /**
     * Sender image item view
     *
     * @param imgViewHolder Image item view holder
     * @param messageItem   Message item
     */
    public final void setImageWidthAndHeight(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Sender image item view
     *
     * @param messageItem   Message item
     * @param imgViewHolder Image item view holder
     * @param filePath      File local path
     * @param time          Time of message sent
     * @param base64Img     Thumb image
     */
    public final void senderImageItemView(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder, @org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.String time, @org.jetbrains.annotations.Nullable()
    java.lang.String base64Img, boolean searchEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String searchKey) {
    }
    
    public final void setImageSenderMediaStatus(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    public final void handleImageLoading(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder, @org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.String base64Img) {
    }
    
    private final void handleImageWithCaption(com.mirrorflysdk.api.models.ChatMessage messageItem, com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder, java.lang.String time, boolean searchEnabled, java.lang.String searchKey) {
    }
    
    private final void handleSenderImageCaptionSearch(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.ImageSentViewHolder holder, boolean searchEnabled, java.lang.String searchKey) {
    }
    
    private final void handleSenderImageCaptionSearchExceptMention(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.ImageSentViewHolder holder, boolean searchEnabled, java.lang.String searchKey, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    /**
     * Check if the image item contain caption to show
     *
     * @param imgViewHolder Image item view holder
     */
    private final void checkCaption(com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder) {
    }
    
    /**
     * Sender image uploading progress based on file upload status
     *
     * @param messageItem      Message item
     * @param imageSentViewHolder    Image item view holder
     */
    public final void handleSenderImageItemProgressUpdate(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageSentViewHolder imageSentViewHolder) {
    }
    
    /**
     * Sender image uploading progress bar view based on file upload status
     *
     * @param messageItem      Message item
     * @param imgViewHolder    Image item view holder
     * @param fileUploadStatus Response code for fileuploadstatus
     */
    private final void uploadImgProgressView(com.mirrorflysdk.api.models.ChatMessage messageItem, com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder, java.lang.String fileUploadStatus) {
    }
    
    /**
     * Receiver image item view
     *
     * @param imgViewHolder Image item view holder
     * @param messageItem   Message item
     */
    public final void setImageWidthAndHeight(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageReceivedViewHolder imgViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Receiver image item view
     *
     * @param messageItem   Message item
     * @param imgViewHolder Image item view holder
     * @param filePath      File local path
     * @param time          Time of message sent
     * @param base64Img     Thumb image
     */
    public final void receiverImageViewItem(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageReceivedViewHolder imgViewHolder, @org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.String time, @org.jetbrains.annotations.Nullable()
    java.lang.String base64Img, boolean searchEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String searchKey) {
    }
    
    public final void handleReceiverImageLoading(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageReceivedViewHolder imgViewHolder, @org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.String base64Img) {
    }
    
    public final void setImageReceiverMediaStatus(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageReceivedViewHolder imageReceivedViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    public final void handleReceiverImageItemProgressUpdate(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ImageReceivedViewHolder imageReceivedViewHolder) {
    }
    
    private final void handleReceiverImageCaptionSearch(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.ImageReceivedViewHolder holder, boolean searchEnabled, java.lang.String searchKey) {
    }
    
    private final void handleReceiverImageCaptionSearchExceptMention(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.ImageReceivedViewHolder holder, boolean searchEnabled, java.lang.String searchKey, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in
     * FrameLayout
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