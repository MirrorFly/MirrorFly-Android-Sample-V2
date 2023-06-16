package com.contusfly.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\fH$J \u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/contusfly/helpers/PaginationScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "handler", "Landroid/os/Handler;", "(Landroidx/recyclerview/widget/LinearLayoutManager;Landroid/os/Handler;)V", "canLoadMore", "", "isFetching", "isLastPage", "loadMoreItems", "", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_debug"})
public abstract class PaginationScrollListener extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    private final androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = null;
    private final android.os.Handler handler = null;
    private boolean canLoadMore = true;
    
    public PaginationScrollListener(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager, @org.jetbrains.annotations.NotNull()
    android.os.Handler handler) {
        super();
    }
    
    @java.lang.Override()
    public void onScrolled(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, int dx, int dy) {
    }
    
    protected abstract void loadMoreItems();
    
    public abstract boolean isLastPage();
    
    public abstract boolean isFetching();
}