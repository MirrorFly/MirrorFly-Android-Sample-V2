package com.contusfly.views;

import java.lang.System;

/**
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/views/CustomRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emptyView", "Landroid/view/View;", "observer", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "checkIfEmpty", "", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setEmptyView", "app_debug"})
public final class CustomRecyclerView extends androidx.recyclerview.widget.RecyclerView {
    
    /**
     * Empty view in recycler view
     */
    private android.view.View emptyView;
    
    /**
     * Observer of the recycler view
     */
    private final androidx.recyclerview.widget.RecyclerView.AdapterDataObserver observer = null;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Instantiates a new custom recycler view.
     *
     * @param context the startupActivityContext
     */
    public CustomRecyclerView(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    /**
     * Instantiates a new custom recycler view.
     *
     * @param context the startupActivityContext
     * @param attrs   the attrs
     */
    public CustomRecyclerView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    /**
     * Instantiates a new custom recycler view.
     *
     * @param context  the startupActivityContext
     * @param attrs    the attrs
     * @param defStyle the def style
     */
    public CustomRecyclerView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyle) {
        super(null);
    }
    
    @java.lang.Override()
    public void setAdapter(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
    }
    
    /**
     * Check if empty. And enable or disable based on that
     */
    private final void checkIfEmpty() {
    }
    
    /**
     * Sets the empty view.
     *
     * @param emptyView the new empty view
     */
    public final void setEmptyView(@org.jetbrains.annotations.Nullable()
    android.view.View emptyView) {
    }
}