package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bJ \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\bJ\u001a\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$J\u0018\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\"2\u0006\u0010\'\u001a\u00020\u0015J\u0016\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0006\u00a8\u0006+"}, d2 = {"Lcom/contusfly/utils/ChatMessageUtils;", "", "()V", "fixEmojiAfterEllipses", "", "textView", "Landroid/widget/TextView;", "getDateFromTimestamp", "", "timeStamp", "", "pattern", "getFileSizeText", "fileSizeInBytes", "getFormattedTime", "timeConsume", "", "getRoundedFileSize", "", "unscaledValue", "isMediaExists", "", "filePath", "receiverReplyWindow", "imgViewHolder", "Lcom/contusfly/adapters/holders/BaseReceivedViewHolder;", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "context", "Landroid/content/Context;", "senderReplyWindow", "Lcom/contusfly/adapters/holders/BaseSentViewHolder;", "setChatStatus", "imageView", "Landroid/widget/ImageView;", "status", "Lcom/mirrorflysdk/api/MessageStatus;", "setFavouriteStatus", "imgFav", "isFav", "setFormattedTimeTextView", "totalDuration", "textTimer", "app_debug"})
public final class ChatMessageUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.ChatMessageUtils INSTANCE = null;
    
    private ChatMessageUtils() {
        super();
    }
    
    /**
     * Sets the chat status of the user It might be Tick(Single,Double,Double Blue).
     *
     * @param imageView Instance of the image view
     * @param status    The status of the message
     */
    public final void setChatStatus(@org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable
    java.lang.String status) {
    }
    
    /**
     * Sets the chat status of the user It might be Tick(Single,Double,Double Blue).
     *
     * @param imageView Instance of the image view
     * @param status    The status of the message
     */
    public final void setChatStatus(@org.jetbrains.annotations.Nullable
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.MessageStatus status) {
    }
    
    public final void setFavouriteStatus(@org.jetbrains.annotations.Nullable
    android.widget.ImageView imgFav, boolean isFav) {
    }
    
    public final boolean isMediaExists(@org.jetbrains.annotations.NotNull
    java.lang.String filePath) {
        return false;
    }
    
    /**
     * Show/hide the reply window for the sent image.
     *
     * @param imgViewHolder The view holding the child items.
     * @param messageItem   The data set used to render the content of child views.
     * @param context       The startupActivityContext
     */
    public final void senderReplyWindow(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.BaseSentViewHolder imgViewHolder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.Nullable
    android.content.Context context) {
    }
    
    /**
     * Show/hide the reply window for the received image.
     *
     * @param imgViewHolder The view holding the child items.
     * @param messageItem   The data set used to render the content of child views.
     * @param context       The startupActivityContext
     */
    public final void receiverReplyWindow(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.BaseReceivedViewHolder imgViewHolder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.Nullable
    android.content.Context context) {
    }
    
    /**
     * To change the long emoji text to elllipse at end
     *
     * Listen to Globallayoutlistener of textview
     * textView?.viewTreeObserver?.addOnGlobalLayoutListener()
     */
    @kotlin.jvm.JvmStatic
    public static final void fixEmojiAfterEllipses(@org.jetbrains.annotations.Nullable
    android.widget.TextView textView) {
    }
    
    /**
     * Gets the formatted time.
     *
     * @param timeConsume Timestamp
     * @return String The formatted time
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedTime(int timeConsume) {
        return null;
    }
    
    /**
     * Sets the formatted duration in the text view with the chat format
     *
     * @param totalDuration Total duration for formatter
     * @param textTimer     View to display
     */
    public final void setFormattedTimeTextView(int totalDuration, @org.jetbrains.annotations.NotNull
    android.widget.TextView textTimer) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFileSizeText(@org.jetbrains.annotations.NotNull
    java.lang.String fileSizeInBytes) {
        return null;
    }
    
    private final double getRoundedFileSize(double unscaledValue) {
        return 0.0;
    }
    
    /**
     * Get the date from the timestamp with the dd/MM/yyyy format
     *
     * @param timeStamp Time stamp of the message
     * @return String Formatted date
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDateFromTimestamp(long timeStamp, @org.jetbrains.annotations.NotNull
    java.lang.String pattern) {
        return null;
    }
}