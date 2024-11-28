package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/contusfly/adapters/ContactSelectionPreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/ContactSelectionPreviewAdapter$ContactSelectedPreviewHolder;", "context", "Landroid/content/Context;", "selectedContactList", "", "Lcom/contusfly/models/DeviceContactModel;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onContactRemoved", "fn", "Lkotlin/Function1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setProfileDetails", "contactModel", "Companion", "ContactSelectedPreviewHolder", "app_debug"})
public final class ContactSelectionPreviewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.ContactSelectionPreviewAdapter.ContactSelectedPreviewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.contusfly.models.DeviceContactModel> selectedContactList = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.adapters.ContactSelectionPreviewAdapter.Companion Companion = null;
    public static kotlin.jvm.functions.Function1<? super com.contusfly.models.DeviceContactModel, kotlin.Unit> onContactRemoved;
    
    public ContactSelectionPreviewAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.DeviceContactModel> selectedContactList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.adapters.ContactSelectionPreviewAdapter.ContactSelectedPreviewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionPreviewAdapter.ContactSelectedPreviewHolder holder, int position) {
    }
    
    private final void setProfileDetails(com.contusfly.adapters.ContactSelectionPreviewAdapter.ContactSelectedPreviewHolder holder, com.contusfly.models.DeviceContactModel contactModel) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void onContactRemoved(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.contusfly.models.DeviceContactModel, kotlin.Unit> fn) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/ContactSelectionPreviewAdapter$ContactSelectedPreviewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rowContactSelectedPreviewBinding", "Lcom/contusfly/databinding/RowContactSelectedPreviewBinding;", "(Lcom/contusfly/databinding/RowContactSelectedPreviewBinding;)V", "getRowContactSelectedPreviewBinding", "()Lcom/contusfly/databinding/RowContactSelectedPreviewBinding;", "setRowContactSelectedPreviewBinding", "app_debug"})
    public static final class ContactSelectedPreviewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.contusfly.databinding.RowContactSelectedPreviewBinding rowContactSelectedPreviewBinding;
        
        public ContactSelectedPreviewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowContactSelectedPreviewBinding rowContactSelectedPreviewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.RowContactSelectedPreviewBinding getRowContactSelectedPreviewBinding() {
            return null;
        }
        
        public final void setRowContactSelectedPreviewBinding(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowContactSelectedPreviewBinding p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/adapters/ContactSelectionPreviewAdapter$Companion;", "", "()V", "onContactRemoved", "Lkotlin/Function1;", "Lcom/contusfly/models/DeviceContactModel;", "", "getOnContactRemoved", "()Lkotlin/jvm/functions/Function1;", "setOnContactRemoved", "(Lkotlin/jvm/functions/Function1;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function1<com.contusfly.models.DeviceContactModel, kotlin.Unit> getOnContactRemoved() {
            return null;
        }
        
        public final void setOnContactRemoved(@org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.contusfly.models.DeviceContactModel, kotlin.Unit> p0) {
        }
    }
}