package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005\u001f !\"#B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001c\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u001d\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001e\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/contusfly/adapters/AttachmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/AttachmentAdapter$MyViewHolder;", "attachmentMainModel", "", "Lcom/contusfly/models/AttachmentMainModel;", "context", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "mListener1", "Lcom/contusfly/adapters/AttachmentAdapter$RecyclerViewClickListenerType1;", "mListener2", "Lcom/contusfly/adapters/AttachmentAdapter$RecyclerViewClickListenerType2;", "mListener3", "Lcom/contusfly/adapters/AttachmentAdapter$RecyclerViewClickListenerType3;", "mListener4", "Lcom/contusfly/adapters/AttachmentAdapter$RecyclerViewClickListenerType4;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "i", "setmListener1", "setmListener2", "setmListener3", "setmListener4", "MyViewHolder", "RecyclerViewClickListenerType1", "RecyclerViewClickListenerType2", "RecyclerViewClickListenerType3", "RecyclerViewClickListenerType4", "app_debug"})
public final class AttachmentAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.AttachmentAdapter.MyViewHolder> {
    private final java.util.List<com.contusfly.models.AttachmentMainModel> attachmentMainModel = null;
    private final android.content.Context context = null;
    private com.contusfly.adapters.AttachmentAdapter.RecyclerViewClickListenerType1 mListener1;
    private com.contusfly.adapters.AttachmentAdapter.RecyclerViewClickListenerType2 mListener2;
    private com.contusfly.adapters.AttachmentAdapter.RecyclerViewClickListenerType3 mListener3;
    private com.contusfly.adapters.AttachmentAdapter.RecyclerViewClickListenerType4 mListener4;
    
    public AttachmentAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.contusfly.models.AttachmentMainModel> attachmentMainModel, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setmListener1(@org.jetbrains.annotations.Nullable()
    com.contusfly.adapters.AttachmentAdapter.RecyclerViewClickListenerType1 mListener1) {
    }
    
    public final void setmListener2(@org.jetbrains.annotations.Nullable()
    com.contusfly.adapters.AttachmentAdapter.RecyclerViewClickListenerType2 mListener2) {
    }
    
    public final void setmListener3(@org.jetbrains.annotations.Nullable()
    com.contusfly.adapters.AttachmentAdapter.RecyclerViewClickListenerType3 mListener3) {
    }
    
    public final void setmListener4(@org.jetbrains.annotations.Nullable()
    com.contusfly.adapters.AttachmentAdapter.RecyclerViewClickListenerType4 mListener4) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.contusfly.adapters.AttachmentAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int i) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.AttachmentAdapter.MyViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * Click listener for dialog elements
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0011\u0010\u001f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\fR\u0011\u0010!\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/contusfly/adapters/AttachmentAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/contusfly/adapters/AttachmentAdapter;Landroid/view/View;)V", "cameraImageView", "Landroid/widget/ImageView;", "getCameraImageView", "()Landroid/widget/ImageView;", "cameraTextView", "Landroid/widget/TextView;", "getCameraTextView", "()Landroid/widget/TextView;", "cameralinearLayout", "Landroid/widget/LinearLayout;", "getCameralinearLayout", "()Landroid/widget/LinearLayout;", "galleryImageView", "getGalleryImageView", "galleryTextView", "getGalleryTextView", "gallerylinearLayout", "getGallerylinearLayout", "locationImageView", "getLocationImageView", "locationTextView", "getLocationTextView", "locationlinearLayout", "getLocationlinearLayout", "videoImageView", "getVideoImageView", "videoTextView", "getVideoTextView", "videolinearLayout", "getVideolinearLayout", "app_debug"})
    public final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout cameralinearLayout = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView cameraTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView cameraImageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout videolinearLayout = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView videoTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView videoImageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout gallerylinearLayout = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView galleryTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView galleryImageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout locationlinearLayout = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView locationTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView locationImageView = null;
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getCameralinearLayout() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getCameraTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getCameraImageView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getVideolinearLayout() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getVideoTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getVideoImageView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getGallerylinearLayout() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getGalleryTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getGalleryImageView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getLocationlinearLayout() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getLocationTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getLocationImageView() {
            return null;
        }
    }
    
    /**
     * Listeners to get the click action on image item from recent chat view
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/adapters/AttachmentAdapter$RecyclerViewClickListenerType1;", "", "onItemClick1", "", "view", "Landroid/view/View;", "position", "", "selectedOption", "", "app_debug"})
    @java.lang.FunctionalInterface()
    public static abstract interface RecyclerViewClickListenerType1 {
        
        /**
         * Method for getting image item click action
         *
         * @param view     - Imageview
         * @param position - Itemview position
         */
        public abstract void onItemClick1(@org.jetbrains.annotations.Nullable()
        android.view.View view, int position, @org.jetbrains.annotations.Nullable()
        java.lang.String selectedOption);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/adapters/AttachmentAdapter$RecyclerViewClickListenerType2;", "", "onItemClick2", "", "view", "Landroid/view/View;", "position", "", "selectedOption", "", "app_debug"})
    @java.lang.FunctionalInterface()
    public static abstract interface RecyclerViewClickListenerType2 {
        
        /**
         * Method for getting image item click action
         *
         * @param view     - Imageview
         * @param position - Itemview position
         */
        public abstract void onItemClick2(@org.jetbrains.annotations.Nullable()
        android.view.View view, int position, @org.jetbrains.annotations.Nullable()
        java.lang.String selectedOption);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/adapters/AttachmentAdapter$RecyclerViewClickListenerType3;", "", "onItemClick3", "", "view", "Landroid/view/View;", "position", "", "selectedOption", "", "app_debug"})
    @java.lang.FunctionalInterface()
    public static abstract interface RecyclerViewClickListenerType3 {
        
        /**
         * Method for getting image item click action
         *
         * @param view     - Imageview
         * @param position - Itemview position
         */
        public abstract void onItemClick3(@org.jetbrains.annotations.Nullable()
        android.view.View view, int position, @org.jetbrains.annotations.Nullable()
        java.lang.String selectedOption);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/adapters/AttachmentAdapter$RecyclerViewClickListenerType4;", "", "onItemClick4", "", "view", "Landroid/view/View;", "position", "", "selectedOption", "", "app_debug"})
    @java.lang.FunctionalInterface()
    public static abstract interface RecyclerViewClickListenerType4 {
        
        /**
         * Method for getting image item click action
         *
         * @param view     - Imageview
         * @param position - Itemview position
         */
        public abstract void onItemClick4(@org.jetbrains.annotations.Nullable()
        android.view.View view, int position, @org.jetbrains.annotations.Nullable()
        java.lang.String selectedOption);
    }
}