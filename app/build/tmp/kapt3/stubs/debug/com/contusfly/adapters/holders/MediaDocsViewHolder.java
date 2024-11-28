package com.contusfly.adapters.holders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/contusfly/adapters/holders/MediaDocsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowMediaDocsItemBinding;", "onDocsClicked", "Lkotlin/Function1;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "", "(Lcom/contusfly/databinding/RowMediaDocsItemBinding;Lkotlin/jvm/functions/Function1;)V", "getOnDocsClicked", "()Lkotlin/jvm/functions/Function1;", "getViewBinding", "()Lcom/contusfly/databinding/RowMediaDocsItemBinding;", "setViewBinding", "(Lcom/contusfly/databinding/RowMediaDocsItemBinding;)V", "bindValues", "messageItem", "Lcom/contusfly/models/GroupedMedia$MessageItem;", "Companion", "app_debug"})
public final class MediaDocsViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull
    private com.contusfly.databinding.RowMediaDocsItemBinding viewBinding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> onDocsClicked = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.adapters.holders.MediaDocsViewHolder.Companion Companion = null;
    
    public MediaDocsViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.databinding.RowMediaDocsItemBinding viewBinding, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> onDocsClicked) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.databinding.RowMediaDocsItemBinding getViewBinding() {
        return null;
    }
    
    public final void setViewBinding(@org.jetbrains.annotations.NotNull
    com.contusfly.databinding.RowMediaDocsItemBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> getOnDocsClicked() {
        return null;
    }
    
    public final void bindValues(@org.jetbrains.annotations.NotNull
    com.contusfly.models.GroupedMedia.MessageItem messageItem) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/adapters/holders/MediaDocsViewHolder$Companion;", "", "()V", "create", "Lcom/contusfly/adapters/holders/MediaDocsViewHolder;", "parent", "Landroid/view/ViewGroup;", "onDocsClicked", "Lkotlin/Function1;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.adapters.holders.MediaDocsViewHolder create(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> onDocsClicked) {
            return null;
        }
    }
}