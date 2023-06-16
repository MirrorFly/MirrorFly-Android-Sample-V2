package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u001c\u0010\u0013\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u001c\u0010\u0015\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/contusfly/adapters/PreviewSendContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/PreviewSendContactAdapter$PreviewSendContactViewHolder;", "context", "Landroid/content/Context;", "contactList", "", "Lcom/contusfly/models/DeviceContactModel;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMobileNumber", "contact", "setProfileDetails", "contactModel", "PreviewSendContactViewHolder", "app_debug"})
public final class PreviewSendContactAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.PreviewSendContactAdapter.PreviewSendContactViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.contusfly.models.DeviceContactModel> contactList = null;
    
    public PreviewSendContactAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.contusfly.models.DeviceContactModel> contactList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.contusfly.adapters.PreviewSendContactAdapter.PreviewSendContactViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.PreviewSendContactAdapter.PreviewSendContactViewHolder holder, int position) {
    }
    
    private final void setMobileNumber(com.contusfly.adapters.PreviewSendContactAdapter.PreviewSendContactViewHolder holder, com.contusfly.models.DeviceContactModel contact) {
    }
    
    private final void setProfileDetails(com.contusfly.adapters.PreviewSendContactAdapter.PreviewSendContactViewHolder holder, com.contusfly.models.DeviceContactModel contactModel) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/adapters/PreviewSendContactAdapter$PreviewSendContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rowPreviewSendContactBinding", "Lcom/contusfly/databinding/RowPreviewSendContactBinding;", "(Lcom/contusfly/adapters/PreviewSendContactAdapter;Lcom/contusfly/databinding/RowPreviewSendContactBinding;)V", "getRowPreviewSendContactBinding", "()Lcom/contusfly/databinding/RowPreviewSendContactBinding;", "setRowPreviewSendContactBinding", "(Lcom/contusfly/databinding/RowPreviewSendContactBinding;)V", "app_debug"})
    public final class PreviewSendContactViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.databinding.RowPreviewSendContactBinding rowPreviewSendContactBinding;
        
        public PreviewSendContactViewHolder(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowPreviewSendContactBinding rowPreviewSendContactBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.databinding.RowPreviewSendContactBinding getRowPreviewSendContactBinding() {
            return null;
        }
        
        public final void setRowPreviewSendContactBinding(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowPreviewSendContactBinding p0) {
        }
    }
}