package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u001a\u0010\u0012\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014J\u001a\u0010\u0016\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/contusfly/adapters/ViewAllLinksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "groupedDocsList", "", "Lcom/contusfly/models/GroupedMedia;", "(Ljava/util/List;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onLinkClickedCallback", "fn", "Lkotlin/Function1;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "onLinkMessageClickedCallback", "Companion", "app_debug"})
public final class ViewAllLinksAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final java.util.List<com.contusfly.models.GroupedMedia> groupedDocsList = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.adapters.ViewAllLinksAdapter.Companion Companion = null;
    public static final int HEADER = 0;
    public static final int LINKS_ITEM = 1;
    public static kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> onLinkMessageClicked;
    public static kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> onLinkClicked;
    
    public ViewAllLinksAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.contusfly.models.GroupedMedia> groupedDocsList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void onLinkMessageClickedCallback(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> fn) {
    }
    
    public final void onLinkClickedCallback(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> fn) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/adapters/ViewAllLinksAdapter$Companion;", "", "()V", "HEADER", "", "LINKS_ITEM", "onLinkClicked", "Lkotlin/Function1;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "", "getOnLinkClicked", "()Lkotlin/jvm/functions/Function1;", "setOnLinkClicked", "(Lkotlin/jvm/functions/Function1;)V", "onLinkMessageClicked", "getOnLinkMessageClicked", "setOnLinkMessageClicked", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function1<com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> getOnLinkMessageClicked() {
            return null;
        }
        
        public final void setOnLinkMessageClicked(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function1<com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> getOnLinkClicked() {
            return null;
        }
        
        public final void setOnLinkClicked(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.models.ChatMessage, kotlin.Unit> p0) {
        }
    }
}