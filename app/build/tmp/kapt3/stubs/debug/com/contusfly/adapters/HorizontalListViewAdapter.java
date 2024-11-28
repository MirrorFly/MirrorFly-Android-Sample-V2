package com.contusfly.adapters;

import java.lang.System;

/**
 * Recycler adapter which used to viewlist the images horizontally
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/contusfly/adapters/HorizontalListViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/HorizontalListViewAdapter$HorizontalViewHolder;", "context", "Landroid/content/Context;", "imagesList", "", "Lcom/mirrorflysdk/models/MultipleImages;", "imagePosition", "", "(Landroid/content/Context;Ljava/util/List;I)V", "onItemClickListener", "Lcom/contusfly/adapters/HorizontalListViewAdapter$OnItemClickListener;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "mItemClickListener", "setPosition", "itemPosition", "HorizontalViewHolder", "OnItemClickListener", "app_debug"})
public final class HorizontalListViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.HorizontalListViewAdapter.HorizontalViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.mirrorflysdk.models.MultipleImages> imagesList = null;
    private int imagePosition;
    
    /**
     * Image item click listener
     */
    private com.contusfly.adapters.HorizontalListViewAdapter.OnItemClickListener onItemClickListener;
    
    public HorizontalListViewAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.mirrorflysdk.models.MultipleImages> imagesList, int imagePosition) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.adapters.HorizontalListViewAdapter.HorizontalViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.HorizontalListViewAdapter.HorizontalViewHolder holder, int position) {
    }
    
    /**
     * Set the position of the selected image item.
     *
     * @param itemPosition Selected image position
     */
    public final void setPosition(int itemPosition) {
    }
    
    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return imagesList
     */
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    /**
     * Sets on item click listener.
     *
     * @param mItemClickListener the m item click listener
     */
    public final void setOnItemClickListener(@org.jetbrains.annotations.Nullable
    com.contusfly.adapters.HorizontalListViewAdapter.OnItemClickListener mItemClickListener) {
    }
    
    /**
     * The interface On item click listener.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/HorizontalListViewAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        /**
         * On item click.
         *
         * @param view     the view
         * @param position the position
         */
        public abstract void onItemClick(@org.jetbrains.annotations.Nullable
        android.view.View view, int position);
    }
    
    /**
     * The type View holder.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/adapters/HorizontalListViewAdapter$HorizontalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/contusfly/adapters/HorizontalListViewAdapter;Landroid/view/View;)V", "imageItem", "Landroid/widget/ImageView;", "getImageItem", "()Landroid/widget/ImageView;", "imageItemBorder", "getImageItemBorder", "videoItem", "getVideoItem", "onClick", "", "v", "app_debug"})
    public final class HorizontalViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
        
        /**
         * The Iv product images.
         */
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView imageItem = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView imageItemBorder = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView videoItem = null;
        
        public HorizontalViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getImageItem() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getImageItemBorder() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getVideoItem() {
            return null;
        }
        
        /**
         * Interface definition for a callback to be invoked when a view is clicked
         *
         * @param v
         */
        @java.lang.Override
        public void onClick(@org.jetbrains.annotations.NotNull
        android.view.View v) {
        }
    }
}