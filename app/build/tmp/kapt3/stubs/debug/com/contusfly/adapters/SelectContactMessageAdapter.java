package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/contusfly/adapters/SelectContactMessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/SelectContactMessageAdapter$SelectContactMessageViewHolder;", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lcom/contusfly/adapters/ContactSelectionModel;", "Lkotlin/collections/ArrayList;", "clickListener", "Lcom/contusfly/adapters/ContactChatOnClickListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/contusfly/adapters/ContactChatOnClickListener;)V", "getItemCount", "", "isOwnJid", "", "jid", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SelectContactMessageViewHolder", "app_debug"})
public final class SelectContactMessageAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.SelectContactMessageAdapter.SelectContactMessageViewHolder> {
    private final android.content.Context context = null;
    private java.util.ArrayList<com.contusfly.adapters.ContactSelectionModel> list;
    private final com.contusfly.adapters.ContactChatOnClickListener clickListener = null;
    
    public SelectContactMessageAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.contusfly.adapters.ContactSelectionModel> list, @org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactChatOnClickListener clickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.adapters.SelectContactMessageAdapter.SelectContactMessageViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.SelectContactMessageAdapter.SelectContactMessageViewHolder holder, int position) {
    }
    
    private final boolean isOwnJid(java.lang.String jid) {
        return false;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/SelectContactMessageAdapter$SelectContactMessageViewHolder;", "Lcom/contusfly/adapters/BaseViewHolder;", "viewBinding", "Lcom/contusfly/databinding/SelectContactMessageItemBinding;", "(Lcom/contusfly/databinding/SelectContactMessageItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/SelectContactMessageItemBinding;", "setViewBinding", "app_debug"})
    public static final class SelectContactMessageViewHolder extends com.contusfly.adapters.BaseViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.contusfly.databinding.SelectContactMessageItemBinding viewBinding;
        
        public SelectContactMessageViewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.SelectContactMessageItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.SelectContactMessageItemBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.SelectContactMessageItemBinding p0) {
        }
    }
}