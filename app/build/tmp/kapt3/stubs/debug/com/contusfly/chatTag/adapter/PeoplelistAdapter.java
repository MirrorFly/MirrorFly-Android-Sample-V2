package com.contusfly.chatTag.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u00017B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020(H\u0002J\u001c\u0010)\u001a\u00020\u001e2\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010+\u001a\u00020\"H\u0016J\u001c\u0010,\u001a\u00060\u0002R\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\"H\u0016J\u001a\u00100\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0018\u00103\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0018\u00104\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0018\u00105\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\nH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/contusfly/chatTag/adapter/PeoplelistAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/chatTag/adapter/PeoplelistAdapter$ViewHolder;", "Landroid/widget/Filterable;", "context", "Landroid/content/Context;", "clicklistener", "Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;", "recentChatList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;Ljava/util/ArrayList;)V", "binding", "Lcom/contusfly/databinding/AddPeopleRecentChatItemLayoutBinding;", "chatTimeOperations", "Lcom/contusfly/utils/ChatTimeOperations;", "getClicklistener", "()Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;", "getContext", "()Landroid/content/Context;", "filterlist", "getFilterlist", "()Ljava/util/ArrayList;", "setFilterlist", "(Ljava/util/ArrayList;)V", "getRecentChatList", "userblockedMe", "", "chatTagSelection", "", "recent", "chatTagonClick", "absoluteAdapterPosition", "", "getFilter", "Landroid/widget/Filter;", "getItemCount", "isChatTagValidMessage", "lastMessageId", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setChatTagMessageData", "chatMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "setChatTagMessageView", "setChatTagUserView", "setPeopleChatImage", "data", "ViewHolder", "app_debug"})
public final class PeoplelistAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.chatTag.adapter.PeoplelistAdapter.ViewHolder> implements android.widget.Filterable {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.contusfly.chatTag.interfaces.ChatTagClickListener clicklistener = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> recentChatList = null;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> filterlist;
    private boolean userblockedMe = false;
    private final com.contusfly.utils.ChatTimeOperations chatTimeOperations = null;
    private com.contusfly.databinding.AddPeopleRecentChatItemLayoutBinding binding;
    
    public PeoplelistAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.chatTag.interfaces.ChatTagClickListener clicklistener, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> recentChatList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.chatTag.interfaces.ChatTagClickListener getClicklistener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> getRecentChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> getFilterlist() {
        return null;
    }
    
    public final void setFilterlist(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.chatTag.adapter.PeoplelistAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.chatTag.adapter.PeoplelistAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    private final void setChatTagUserView(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.AddPeopleRecentChatItemLayoutBinding holder) {
    }
    
    private final void setPeopleChatImage(com.contusfly.databinding.AddPeopleRecentChatItemLayoutBinding holder, com.mirrorflysdk.api.models.RecentChat data) {
    }
    
    private final void setChatTagMessageView(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.AddPeopleRecentChatItemLayoutBinding holder) {
    }
    
    private final boolean isChatTagValidMessage(java.lang.String lastMessageId) {
        return false;
    }
    
    private final void setChatTagMessageData(com.contusfly.databinding.AddPeopleRecentChatItemLayoutBinding holder, com.mirrorflysdk.api.models.ChatMessage chatMessage) {
    }
    
    private final void chatTagSelection(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.AddPeopleRecentChatItemLayoutBinding binding) {
    }
    
    private final void chatTagonClick(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.AddPeopleRecentChatItemLayoutBinding binding, int absoluteAdapterPosition) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.widget.Filter getFilter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/chatTag/adapter/PeoplelistAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/contusfly/chatTag/adapter/PeoplelistAdapter;)V", "setData", "", "item", "Lcom/mirrorflysdk/api/models/RecentChat;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ViewHolder() {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull
        com.mirrorflysdk.api.models.RecentChat item) {
        }
    }
}