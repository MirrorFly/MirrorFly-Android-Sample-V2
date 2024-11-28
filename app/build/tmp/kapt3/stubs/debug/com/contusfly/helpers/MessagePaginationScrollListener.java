package com.contusfly.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u000fH$J\b\u0010\u0010\u001a\u00020\u000fH$J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/contusfly/helpers/MessagePaginationScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "isScrollStateSettle", "", "()Z", "setScrollStateSettle", "(Z)V", "hasNextItems", "hasPreviousItems", "isFetching", "isLastpageFetched", "loadNextItems", "", "loadPreviousItems", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "app_debug"})
public abstract class MessagePaginationScrollListener extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    private final androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = null;
    private boolean isScrollStateSettle = false;
    
    public MessagePaginationScrollListener(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager) {
        super();
    }
    
    public final boolean isScrollStateSettle() {
        return false;
    }
    
    public final void setScrollStateSettle(boolean p0) {
    }
    
    @java.lang.Override
    public void onScrollStateChanged(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, int newState) {
    }
    
    @java.lang.Override
    public void onScrolled(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, int dx, int dy) {
    }
    
    protected abstract void loadNextItems();
    
    protected abstract void loadPreviousItems();
    
    public abstract boolean hasNextItems();
    
    public abstract boolean hasPreviousItems();
    
    public abstract boolean isFetching();
    
    public abstract boolean isLastpageFetched();
}