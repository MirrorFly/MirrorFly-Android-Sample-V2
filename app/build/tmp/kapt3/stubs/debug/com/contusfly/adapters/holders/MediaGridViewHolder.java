package com.contusfly.adapters.holders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/adapters/holders/MediaGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewBinding", "Lcom/contusfly/databinding/GridMediaItemBinding;", "onMediaIconClicked", "Lkotlin/Function1;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "", "(Landroid/content/Context;Lcom/contusfly/databinding/GridMediaItemBinding;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "getOnMediaIconClicked", "()Lkotlin/jvm/functions/Function1;", "getViewBinding", "()Lcom/contusfly/databinding/GridMediaItemBinding;", "setViewBinding", "(Lcom/contusfly/databinding/GridMediaItemBinding;)V", "bindValues", "messageItem", "Lcom/contusfly/models/GroupedMedia$MessageItem;", "Companion", "app_debug"})
public final class MediaGridViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private com.contusfly.databinding.GridMediaItemBinding viewBinding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> onMediaIconClicked = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.adapters.holders.MediaGridViewHolder.Companion Companion = null;
    
    public MediaGridViewHolder(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.GridMediaItemBinding viewBinding, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> onMediaIconClicked) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.databinding.GridMediaItemBinding getViewBinding() {
        return null;
    }
    
    public final void setViewBinding(@org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.GridMediaItemBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> getOnMediaIconClicked() {
        return null;
    }
    
    public final void bindValues(@org.jetbrains.annotations.NotNull()
    com.contusfly.models.GroupedMedia.MessageItem messageItem) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/adapters/holders/MediaGridViewHolder$Companion;", "", "()V", "create", "Lcom/contusfly/adapters/holders/MediaGridViewHolder;", "parent", "Landroid/view/ViewGroup;", "onMediaIconClicked", "Lkotlin/Function1;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.adapters.holders.MediaGridViewHolder create(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> onMediaIconClicked) {
            return null;
        }
    }
}