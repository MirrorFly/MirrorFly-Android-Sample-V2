package com.contusfly.chatTag.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;", "", "filterListUpdated", "", "filterList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "Lkotlin/collections/ArrayList;", "selectUnselectChat", "position", "", "item", "isSelectionlist", "", "app_debug"})
public abstract interface ChatTagClickListener {
    
    public abstract void selectUnselectChat(int position, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.RecentChat item, boolean isSelectionlist);
    
    public abstract void filterListUpdated(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> filterList);
}