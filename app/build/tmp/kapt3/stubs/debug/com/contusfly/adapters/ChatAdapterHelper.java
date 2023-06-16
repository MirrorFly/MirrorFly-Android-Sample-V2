package com.contusfly.adapters;

import java.lang.System;

/**
 * Helper class for Chat view Adapter
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0002JF\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J$\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\nJ$\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/contusfly/adapters/ChatAdapterHelper;", "Lcom/contusfly/adapters/base/BaseChatAdapterHelper;", "inflater", "Landroid/view/LayoutInflater;", "(Landroid/view/LayoutInflater;)V", "getItemViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getMediaItemViewHolder", "isSenderChanged", "", "messageList", "", "Lcom/mirrorflysdk/api/models/ChatMessage;", "position", "presentFileTypeView", "", "cancelLayout", "Landroid/widget/RelativeLayout;", "progressBar", "Landroid/widget/ProgressBar;", "progressBarBuffer", "messageId", "", "status", "forwardImage", "Landroid/widget/ImageView;", "viewUploadOrDownload", "showHideSenderName", "senderNameHolder", "Lcom/contusfly/adapters/holders/SenderNameHolder;", "showHideSpace", "space", "Landroid/view/View;", "app_debug"})
public final class ChatAdapterHelper extends com.contusfly.adapters.base.BaseChatAdapterHelper {
    private android.view.LayoutInflater inflater;
    
    public ChatAdapterHelper(@org.jetbrains.annotations.Nullable()
    android.view.LayoutInflater inflater) {
        super();
    }
    
    /**
     * Show or Hides the sender name view based on position
     *
     * @param senderNameHolder Sender name view holder
     * @param messageList      messages list
     * @param position         Position of the view
     */
    public final void showHideSenderName(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.SenderNameHolder senderNameHolder, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messageList, int position) {
    }
    
    /**
     * Checks the current header id with previous header id
     *
     * @param position Position of the current item
     * @return boolean True if header changed, else false
     */
    private final boolean isSenderChanged(java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messageList, int position) {
        return false;
    }
    
    /**
     * Show or Hides the space view based on position
     *
     * @param space       Space view
     * @param position    Position of the view
     * @param messageList messages list
     */
    public final void showHideSpace(@org.jetbrains.annotations.NotNull()
    android.view.View space, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messageList) {
    }
    
    /**
     * Get the View holder of the chat view.
     *
     * @param parent   Parent view group
     * @param viewType Type of the view
     * @return RecyclerView.HorizontalViewHolder Holder for the view
     */
    @org.jetbrains.annotations.Nullable()
    public final androidx.recyclerview.widget.RecyclerView.ViewHolder getItemViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    /**
     * Handle view holders for the views based on the type
     *
     * @param parent   Parent view
     * @param viewType Type of the view
     * @return RecyclerView.HorizontalViewHolder Holder for the view
     */
    private final androidx.recyclerview.widget.RecyclerView.ViewHolder getMediaItemViewHolder(android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    /**
     * Sets the file status. The action contains
     *
     *
     * => MEDIA_DOWNLOADED => MEDIA_UPLOADED => MEDIA_DOWNLOADING => MEDIA_UPLOADING =>
     * MEDIA_NOT_DOWNLOADED => MEDIA_NOT_UPLOADED
     *
     * @param cancelLayout  Cancel the media Upload or Download layout
     * @param progressBar       Progress bar of the image view
     * @param status            Status of the message
     * @param viewUploadOrDownload  Upload or Download action layout
     * @param messageId         Message id of the message
     */
    public final void presentFileTypeView(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout cancelLayout, @org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar progressBar, @org.jetbrains.annotations.Nullable()
    android.widget.ProgressBar progressBarBuffer, @org.jetbrains.annotations.Nullable()
    java.lang.String messageId, int status, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView forwardImage, @org.jetbrains.annotations.Nullable()
    android.widget.RelativeLayout viewUploadOrDownload) {
    }
}