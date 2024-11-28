package com.contusfly.chat.reply;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/chat/reply/ReplyViewUtils;", "", "()V", "handleReceiverReplyview", "", "context", "Landroid/content/Context;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "replyMessageViewHolder", "Lcom/contusfly/adapters/holders/ReplyMessageViewHolder;", "item", "Lcom/mirrorflysdk/api/models/ChatMessage;", "handleVisibility", "view", "Landroid/view/View;", "show", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "markFavoriteItem", "showReceiverReplyWindow", "showSenderReplyWindow", "app_debug"})
public final class ReplyViewUtils {
    
    public ReplyViewUtils() {
        super();
    }
    
    /**
     * Show/hide the reply window for the sent audio.
     * @param viewHolder The view holding the child items.
     * @param item            The data set used to render the content of child views.
     * @param context         The context
     */
    public final void showSenderReplyWindow(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    /**
     * Show/hide the reply window for the received audio.
     * @param viewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     * @param context                 The context
     */
    public final void showReceiverReplyWindow(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    private final void handleReceiverReplyview(android.content.Context context, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, com.contusfly.adapters.holders.ReplyMessageViewHolder replyMessageViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Show/hide the favorite icon when the text is added to favorites.
     *
     * @param viewHolder The view holding the child items.
     * @param item                  The data set used to render the content of child views.
     */
    public final void markFavoriteItem(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void handleVisibility(android.view.View view, java.lang.Boolean show) {
    }
}