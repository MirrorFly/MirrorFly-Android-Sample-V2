package com.contusfly.utils;

import java.lang.System;

/**
 * This Class has been handled when the user click on the recycler view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0000J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/utils/ItemClickSupport;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mAttachListener", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnItemClickListener", "Lcom/contusfly/utils/ItemClickSupport$OnItemClickListener;", "mOnItemLongClickListener", "Lcom/contusfly/utils/ItemClickSupport$OnItemLongClickListener;", "mOnLongClickListener", "Landroid/view/View$OnLongClickListener;", "addTo", "setOnItemClickListener", "listener", "setOnItemLongClickListener", "OnItemClickListener", "OnItemLongClickListener", "app_debug"})
public final class ItemClickSupport {
    private final androidx.recyclerview.widget.RecyclerView recyclerView = null;
    
    /**
     * Item click listener.
     */
    private com.contusfly.utils.ItemClickSupport.OnItemClickListener mOnItemClickListener;
    
    /**
     * Item long click listener.
     */
    private com.contusfly.utils.ItemClickSupport.OnItemLongClickListener mOnItemLongClickListener;
    
    /**
     * The recyclerView on click listener.
     */
    private final android.view.View.OnClickListener mOnClickListener = null;
    
    /**
     * The recyclerView on long click listener.
     */
    private final android.view.View.OnLongClickListener mOnLongClickListener = null;
    
    /**
     * Listener for the click in child views
     */
    private final androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener mAttachListener = null;
    
    public ItemClickSupport(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView) {
        super();
    }
    
    /**
     * Sets the on item click listener.
     *
     * @param listener Instance of OnItemClickListener
     * @return ItemClickSupport Instance of ItemClickSupport
     */
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.utils.ItemClickSupport setOnItemClickListener(@org.jetbrains.annotations.Nullable()
    com.contusfly.utils.ItemClickSupport.OnItemClickListener listener) {
        return null;
    }
    
    /**
     * Sets the on item long click listener.
     *
     * @param listener Instance of OnItemClickListener
     * @return ItemClickSupport Instance of ItemClickSupport
     */
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.utils.ItemClickSupport setOnItemLongClickListener(@org.jetbrains.annotations.Nullable()
    com.contusfly.utils.ItemClickSupport.OnItemLongClickListener listener) {
        return null;
    }
    
    /**
     * Adds the recycler view to the Item click support to handle the click events.
     *
     * @return ItemClickSupport Instance of ItemClickSupport
     */
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.utils.ItemClickSupport addTo() {
        return null;
    }
    
    /**
     * Listener for the recycler view click events
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/utils/ItemClickSupport$OnItemClickListener;", "", "onItemClicked", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "position", "", "v", "Landroid/view/View;", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        /**
         * On recycler view item clicked.
         *
         * @param recyclerView Instance of RecyclerView
         * @param position     Position of the RecyclerView
         * @param v            Instance of the View
         */
        public abstract void onItemClicked(@org.jetbrains.annotations.Nullable()
        androidx.recyclerview.widget.RecyclerView recyclerView, int position, @org.jetbrains.annotations.Nullable()
        android.view.View v);
    }
    
    /**
     * Listener for the recycler view long click events
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/utils/ItemClickSupport$OnItemLongClickListener;", "", "onItemLongClicked", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "position", "", "v", "Landroid/view/View;", "app_debug"})
    public static abstract interface OnItemLongClickListener {
        
        /**
         * On recycler view item long clicked.
         *
         * @param recyclerView Instance of RecyclerView
         * @param position     Position of the RecyclerView
         * @param v            Instance of the View
         * @return boolean True if successful
         */
        public abstract boolean onItemLongClicked(@org.jetbrains.annotations.Nullable()
        androidx.recyclerview.widget.RecyclerView recyclerView, int position, @org.jetbrains.annotations.Nullable()
        android.view.View v);
    }
}