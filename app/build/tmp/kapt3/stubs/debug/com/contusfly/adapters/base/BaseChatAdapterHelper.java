package com.contusfly.adapters.base;

import java.lang.System;

/**
 * Helper class for Chat view Adapter
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0011\u001a\u0004\u0018\u00010\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0002J>\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u001f\u001a\u00020 2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0004J$\u0010!\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\"2\b\u0010\u0007\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&\u00a8\u0006\'"}, d2 = {"Lcom/contusfly/adapters/base/BaseChatAdapterHelper;", "", "()V", "enableMediaCancel", "", "mid", "", "cancel", "Landroid/widget/RelativeLayout;", "getItemViewType", "", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "getMediaItemTypeReceiver", "messageType", "Lcom/mirrorflysdk/flycommons/models/MessageType;", "getMediaItemTypeSender", "getPreviousMessage", "messageList", "", "position", "getType", "typeSender", "typeReceiver", "handleProcessing", "uploadOrDownloadLayout", "progressBar", "Landroid/widget/ProgressBar;", "progressBarBuffer", "status", "cancelLayout", "isMessageDateEqual", "", "mediaUploadView", "Landroid/view/View;", "viewProgress", "showHideDateHeader", "dateViewHolder", "Lcom/contusfly/adapters/holders/DateViewHolder;", "app_debug"})
public abstract class BaseChatAdapterHelper {
    
    public BaseChatAdapterHelper() {
        super();
    }
    
    /**
     * Show or Hides the header view based on position
     *
     * @param dateViewHolder Date view holder
     */
    public final void showHideDateHeader(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.DateViewHolder dateViewHolder) {
    }
    
    /**
     * Returns message dates are equal or not by validating previous message is date message
     *
     * @param position Position of the item
     * @return boolean True if dates are equal, false if not
     */
    protected final boolean isMessageDateEqual(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messageList, int position) {
        return false;
    }
    
    /**
     * Returns previous message related to position if exist
     *
     * @param position Current position
     * @return Message Previous message related to position
     */
    private final com.mirrorflysdk.api.models.ChatMessage getPreviousMessage(java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messageList, int position) {
        return null;
    }
    
    /**
     * Get the view type based on the type of the message
     *
     * @param messageItem message object
     * @return int Type of the chat
     */
    public final int getItemViewType(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
        return 0;
    }
    
    /**
     * @param messageItem  message instance
     * @param typeSender   sender layout type
     * @param typeReceiver sender layout type
     * @return sender or receiver type for given messageItem
     */
    private final int getType(com.mirrorflysdk.api.models.ChatMessage messageItem, int typeSender, int typeReceiver) {
        return 0;
    }
    
    /**
     * Get the media type for the list item to display
     *
     * @param messageType Type of the message
     * @return int View of the chat item
     */
    private final int getMediaItemTypeSender(com.mirrorflysdk.flycommons.models.MessageType messageType) {
        return 0;
    }
    
    /**
     * Get the media type for the list item to display
     *
     * @param messageType Type of the message
     * @return int View of the chat item
     */
    private final int getMediaItemTypeReceiver(com.mirrorflysdk.flycommons.models.MessageType messageType) {
        return 0;
    }
    
    /**
     * Enable the views and make the cancel click listener
     *
     * @param progressBar Progressing
     * @param cancel      Cancel view
     * @param viewProgress  Progress view
     */
    public final void mediaUploadView(@org.jetbrains.annotations.Nullable
    android.view.View progressBar, @org.jetbrains.annotations.Nullable
    android.view.View cancel, @org.jetbrains.annotations.Nullable
    android.view.View viewProgress) {
    }
    
    /**
     * Set the file status for uploading or downloading status
     *
     * @param uploadOrDownloadLayout    Upload or Download action layout
     * @param progressBar Progress bar of the media view
     * @param progressBarBuffer Progress buffer of the media view
     * @param status      Status of the image
     * @param mid         Message id of the message
     * @param cancelLayout  Cancel the media Upload or Download layout
     */
    public final void handleProcessing(@org.jetbrains.annotations.Nullable
    android.widget.RelativeLayout uploadOrDownloadLayout, @org.jetbrains.annotations.NotNull
    android.widget.ProgressBar progressBar, @org.jetbrains.annotations.Nullable
    android.widget.ProgressBar progressBarBuffer, int status, @org.jetbrains.annotations.Nullable
    java.lang.String mid, @org.jetbrains.annotations.Nullable
    android.widget.RelativeLayout cancelLayout) {
    }
    
    /**
     * Enable the media cancel in the chat view
     *
     * @param mid    Message id of the message
     * @param cancel Cancel image view
     */
    public void enableMediaCancel(@org.jetbrains.annotations.Nullable
    java.lang.String mid, @org.jetbrains.annotations.NotNull
    android.widget.RelativeLayout cancel) {
    }
}