package com.contusfly.diffCallBacks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u00a8\u0006\b"}, d2 = {"isJidEqual", "", "oldRecentChat", "Lcom/mirrorflysdk/api/models/RecentChat;", "newRecentChat", "isRecentObjEqual", "oldItem", "newItem", "app_debug"})
public final class RecentChatDiffCallbackKt {
    
    public static final boolean isRecentObjEqual(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.RecentChat oldItem, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.RecentChat newItem) {
        return false;
    }
    
    private static final boolean isJidEqual(com.mirrorflysdk.api.models.RecentChat oldRecentChat, com.mirrorflysdk.api.models.RecentChat newRecentChat) {
        return false;
    }
}