package com.contusfly.chatTag.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001(B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u001c\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u0017H\u0016J\u001c\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017H\u0016J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0017J&\u0010&\u001a\u00020\u001e2\u0016\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010 \u001a\u00020\u0017R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/contusfly/chatTag/adapter/RecentChatTagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/chatTag/adapter/RecentChatTagAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "itemclick", "Lcom/contusfly/chatTag/interfaces/ListItemClickListener;", "chatTagnamelist", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Lcom/contusfly/chatTag/interfaces/ListItemClickListener;Ljava/util/ArrayList;)V", "binding", "Lcom/contusfly/databinding/RecentChatTagHeaderListItemLayoutBinding;", "getChatTagnamelist", "()Ljava/util/ArrayList;", "setChatTagnamelist", "(Ljava/util/ArrayList;)V", "getItemclick", "()Lcom/contusfly/chatTag/interfaces/ListItemClickListener;", "getMContext", "()Landroid/content/Context;", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateSelectedPosition", "updatelist", "list", "ViewHolder", "app_debug"})
public final class RecentChatTagAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.chatTag.adapter.RecentChatTagAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull()
    private final com.contusfly.chatTag.interfaces.ListItemClickListener itemclick = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> chatTagnamelist;
    private int selectedPosition = 0;
    private com.contusfly.databinding.RecentChatTagHeaderListItemLayoutBinding binding;
    
    public RecentChatTagAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    com.contusfly.chatTag.interfaces.ListItemClickListener itemclick, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> chatTagnamelist) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.chatTag.interfaces.ListItemClickListener getItemclick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> getChatTagnamelist() {
        return null;
    }
    
    public final void setChatTagnamelist(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> p0) {
    }
    
    public final int getSelectedPosition() {
        return 0;
    }
    
    public final void setSelectedPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.contusfly.chatTag.adapter.RecentChatTagAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.chatTag.adapter.RecentChatTagAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updatelist(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> list, int position) {
    }
    
    public final void updateSelectedPosition(int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/chatTag/adapter/RecentChatTagAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/contusfly/chatTag/adapter/RecentChatTagAdapter;)V", "setData", "", "item", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "position", "", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ViewHolder() {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        com.mirrorflysdk.flydatabase.model.ChatTagModel item, int position) {
        }
    }
}