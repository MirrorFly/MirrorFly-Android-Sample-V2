package com.contusfly.chatTag.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001,B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u001dH\u0016J\u001c\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001dH\u0016J\u0018\u0010\'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u001dH\u0016J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001dR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006-"}, d2 = {"Lcom/contusfly/chatTag/adapter/EditChatTagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/chatTag/adapter/EditChatTagAdapter$ViewHolder;", "Lcom/contusfly/chatTag/interfaces/ItemTouchHelperAdapter;", "mContext", "Landroid/content/Context;", "itemclick", "Lcom/contusfly/chatTag/interfaces/ListItemClickListener;", "chatTagnamelist", "", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "reorderList", "Lcom/contusfly/chatTag/adapter/ReorderList;", "(Landroid/content/Context;Lcom/contusfly/chatTag/interfaces/ListItemClickListener;Ljava/util/List;Lcom/contusfly/chatTag/adapter/ReorderList;)V", "binding", "Lcom/contusfly/databinding/EditChatTagListItemLayoutBinding;", "getChatTagnamelist", "()Ljava/util/List;", "setChatTagnamelist", "(Ljava/util/List;)V", "getItemclick", "()Lcom/contusfly/chatTag/interfaces/ListItemClickListener;", "getMContext", "()Landroid/content/Context;", "getReorderList", "()Lcom/contusfly/chatTag/adapter/ReorderList;", "setReorderList", "(Lcom/contusfly/chatTag/adapter/ReorderList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemDismiss", "onItemMove", "fromPosition", "toPosition", "updateList", "selectedPosition", "ViewHolder", "app_debug"})
public final class EditChatTagAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.chatTag.adapter.EditChatTagAdapter.ViewHolder> implements com.contusfly.chatTag.interfaces.ItemTouchHelperAdapter {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull
    private final com.contusfly.chatTag.interfaces.ListItemClickListener itemclick = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.mirrorflysdk.flydatabase.model.ChatTagModel> chatTagnamelist;
    @org.jetbrains.annotations.NotNull
    private com.contusfly.chatTag.adapter.ReorderList reorderList;
    private com.contusfly.databinding.EditChatTagListItemLayoutBinding binding;
    
    public EditChatTagAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    com.contusfly.chatTag.interfaces.ListItemClickListener itemclick, @org.jetbrains.annotations.NotNull
    java.util.List<com.mirrorflysdk.flydatabase.model.ChatTagModel> chatTagnamelist, @org.jetbrains.annotations.NotNull
    com.contusfly.chatTag.adapter.ReorderList reorderList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getMContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.chatTag.interfaces.ListItemClickListener getItemclick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mirrorflysdk.flydatabase.model.ChatTagModel> getChatTagnamelist() {
        return null;
    }
    
    public final void setChatTagnamelist(@org.jetbrains.annotations.NotNull
    java.util.List<com.mirrorflysdk.flydatabase.model.ChatTagModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.chatTag.adapter.ReorderList getReorderList() {
        return null;
    }
    
    public final void setReorderList(@org.jetbrains.annotations.NotNull
    com.contusfly.chatTag.adapter.ReorderList p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.chatTag.adapter.EditChatTagAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.chatTag.adapter.EditChatTagAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateList(int selectedPosition) {
    }
    
    @java.lang.Override
    public void onItemMove(int fromPosition, int toPosition) {
    }
    
    @java.lang.Override
    public void onItemDismiss(int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/chatTag/adapter/EditChatTagAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/contusfly/chatTag/adapter/EditChatTagAdapter;)V", "setData", "", "item", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ViewHolder() {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull
        com.mirrorflysdk.flydatabase.model.ChatTagModel item) {
        }
    }
}