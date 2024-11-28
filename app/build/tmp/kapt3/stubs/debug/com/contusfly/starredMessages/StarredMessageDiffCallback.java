package com.contusfly.starredMessages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/starredMessages/StarredMessageDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/mirrorflysdk/api/models/ChatMessage;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "isStarredMessageObjEqual", "oldItem", "newItem", "app_debug"})
public final class StarredMessageDiffCallback extends androidx.recyclerview.widget.DiffUtil.Callback {
    private final java.util.List<com.mirrorflysdk.api.models.ChatMessage> oldList = null;
    private final java.util.List<com.mirrorflysdk.api.models.ChatMessage> newList = null;
    
    public StarredMessageDiffCallback(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> oldList, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> newList) {
        super();
    }
    
    @java.lang.Override
    public int getOldListSize() {
        return 0;
    }
    
    @java.lang.Override
    public int getNewListSize() {
        return 0;
    }
    
    @java.lang.Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return null;
    }
    
    @java.lang.Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
    
    private final boolean isStarredMessageObjEqual(com.mirrorflysdk.api.models.ChatMessage oldItem, com.mirrorflysdk.api.models.ChatMessage newItem) {
        return false;
    }
}