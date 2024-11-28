package com.contusfly.adapters;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/adapters/WebLoginAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/WebLoginAdapter$RecyclerViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dataProvider", "", "Lcom/mirrorflysdk/flydatabase/model/WebLogin;", "layoutInflater", "Landroid/view/LayoutInflater;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAdapterData", "RecyclerViewHolder", "app_debug"})
public final class WebLoginAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.WebLoginAdapter.RecyclerViewHolder> {
    
    /**
     * * The inflater for inflating the views.
     */
    private android.view.LayoutInflater layoutInflater;
    
    /**
     * The login list
     */
    private java.util.List<? extends com.mirrorflysdk.flydatabase.model.WebLogin> dataProvider;
    
    /**
     * The startupActivityContext of the user activity.
     */
    private android.content.Context context;
    
    public WebLoginAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Initiate the Adapter class
     *
     * @param context      pass this activity startupActivityContext
     * @param dataProvider pass the list object
     */
    public final void setAdapterData(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.mirrorflysdk.flydatabase.model.WebLogin> dataProvider) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.adapters.WebLoginAdapter.RecyclerViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.WebLoginAdapter.RecyclerViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    /**
     * The Class media view holder contains the browsername, OS version and imageview...
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/adapters/WebLoginAdapter$RecyclerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserNameTextView", "Lcom/contusfly/views/CustomTextView;", "getBrowserNameTextView", "()Lcom/contusfly/views/CustomTextView;", "circularImageView", "Lcom/contusfly/views/CircularImageView;", "getCircularImageView", "()Lcom/contusfly/views/CircularImageView;", "osVersionTextView", "getOsVersionTextView", "app_debug"})
    public static final class RecyclerViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        /**
         * CustomTextView display the BrowserName
         */
        @org.jetbrains.annotations.NotNull
        private final com.contusfly.views.CustomTextView browserNameTextView = null;
        
        /**
         * CustomTextView display the osversion
         */
        @org.jetbrains.annotations.NotNull
        private final com.contusfly.views.CustomTextView osVersionTextView = null;
        
        /**
         * CircularImageView display the image
         */
        @org.jetbrains.annotations.NotNull
        private final com.contusfly.views.CircularImageView circularImageView = null;
        
        public RecyclerViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.views.CustomTextView getBrowserNameTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.views.CustomTextView getOsVersionTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.views.CircularImageView getCircularImageView() {
            return null;
        }
    }
}