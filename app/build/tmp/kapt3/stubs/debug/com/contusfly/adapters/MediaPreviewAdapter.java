package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/contusfly/adapters/MediaPreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/MediaPreviewAdapter$MediaPreviewHolder;", "context", "Landroid/content/Context;", "imagesList", "", "Lcom/contusfly/models/MediaPreviewModel;", "imagePosition", "", "onItemClickListener", "Lcom/contusfly/adapters/MediaPreviewAdapter$OnItemClickListener;", "(Landroid/content/Context;Ljava/util/List;ILcom/contusfly/adapters/MediaPreviewAdapter$OnItemClickListener;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setPosition", "itemPosition", "MediaPreviewHolder", "OnItemClickListener", "app_debug"})
public final class MediaPreviewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.MediaPreviewAdapter.MediaPreviewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.contusfly.models.MediaPreviewModel> imagesList = null;
    private int imagePosition;
    private final com.contusfly.adapters.MediaPreviewAdapter.OnItemClickListener onItemClickListener = null;
    
    public MediaPreviewAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.MediaPreviewModel> imagesList, int imagePosition, @org.jetbrains.annotations.NotNull
    com.contusfly.adapters.MediaPreviewAdapter.OnItemClickListener onItemClickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.adapters.MediaPreviewAdapter.MediaPreviewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.MediaPreviewAdapter.MediaPreviewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    /**
     * Set the position of the selected image item.
     *
     * @param itemPosition Selected image position
     */
    public final void setPosition(int itemPosition) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/adapters/MediaPreviewAdapter$MediaPreviewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowImageItemBinding;", "(Lcom/contusfly/databinding/RowImageItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/RowImageItemBinding;", "app_debug"})
    public static final class MediaPreviewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.contusfly.databinding.RowImageItemBinding viewBinding = null;
        
        public MediaPreviewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowImageItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.RowImageItemBinding getViewBinding() {
            return null;
        }
    }
    
    /**
     * The interface On item click listener.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/MediaPreviewAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "app_debug"})
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
}