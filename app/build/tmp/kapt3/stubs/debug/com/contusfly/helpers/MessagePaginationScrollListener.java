package com.contusfly.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\nH$J\b\u0010\u000b\u001a\u00020\nH$J \u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/helpers/MessagePaginationScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "hasNextItems", "", "hasPreviousItems", "isFetching", "loadNextItems", "", "loadPreviousItems", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_debug"})
public abstract class MessagePaginationScrollListener extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    private final androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = null;
    
    public MessagePaginationScrollListener(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager) {
        super();
    }
    
    @java.lang.Override()
    public void onScrolled(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, int dx, int dy) {
    }
    
    protected abstract void loadNextItems();
    
    protected abstract void loadPreviousItems();
    
    public abstract boolean hasNextItems();
    
    public abstract boolean hasPreviousItems();
    
    public abstract boolean isFetching();
}