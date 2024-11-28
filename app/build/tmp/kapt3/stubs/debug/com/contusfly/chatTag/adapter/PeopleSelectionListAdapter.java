package com.contusfly.chatTag.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003456B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\u0002\u0010\rJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000bJ\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u001eH\u0016J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0018\u0010-\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0018\u0010.\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u000bH\u0002J6\u0010/\u001a\u00020\u001c2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "clicklistener", "Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;", "isCreateTagPage", "", "chatSelectedList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;ZLjava/util/ArrayList;)V", "binding", "Lcom/contusfly/databinding/PeopleSelectionListItemLayoutBinding;", "getChatSelectedList", "()Ljava/util/ArrayList;", "setChatSelectedList", "(Ljava/util/ArrayList;)V", "getClicklistener", "()Lcom/contusfly/chatTag/interfaces/ChatTagClickListener;", "getContext", "()Landroid/content/Context;", "()Z", "viewbinding", "Lcom/contusfly/databinding/PeopleViewListItemLayoutBinding;", "clear", "", "getItemCount", "", "getItemPosition", "item", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setRecentChatImage", "imageChatPicture", "Lcom/contusfly/views/CircularImageView;", "recent", "setTagInfo", "setUsername", "updateList", "list", "updatedPosition", "clickedCheckBox", "itemSelected", "Companion", "PeopleSelectionViewHolder", "PeopleViewHolder", "app_debug"})
public final class PeopleSelectionListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.contusfly.chatTag.interfaces.ChatTagClickListener clicklistener = null;
    private final boolean isCreateTagPage = false;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> chatSelectedList;
    private com.contusfly.databinding.PeopleSelectionListItemLayoutBinding binding;
    private com.contusfly.databinding.PeopleViewListItemLayoutBinding viewbinding;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.chatTag.adapter.PeopleSelectionListAdapter.Companion Companion = null;
    private static final int TYPE_CREATE_TAG = 0;
    private static final int TYPE_SELECTION_TAG = 1;
    
    public PeopleSelectionListAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.chatTag.interfaces.ChatTagClickListener clicklistener, boolean isCreateTagPage, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> chatSelectedList) {
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
    
    public final boolean isCreateTagPage() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> getChatSelectedList() {
        return null;
    }
    
    public final void setChatSelectedList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    private final void setRecentChatImage(com.contusfly.views.CircularImageView imageChatPicture, com.mirrorflysdk.api.models.RecentChat recent) {
    }
    
    private final void setUsername(com.contusfly.databinding.PeopleViewListItemLayoutBinding holder, com.mirrorflysdk.api.models.RecentChat recent) {
    }
    
    private final void setTagInfo(com.contusfly.databinding.PeopleViewListItemLayoutBinding binding, com.mirrorflysdk.api.models.RecentChat recent) {
    }
    
    public final int getItemPosition(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.RecentChat item) {
        return 0;
    }
    
    public final void clear() {
    }
    
    public final void updateList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> list, int updatedPosition, boolean clickedCheckBox, boolean itemSelected) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter$PeopleSelectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter;)V", "setData", "", "item", "Lcom/mirrorflysdk/api/models/RecentChat;", "app_debug"})
    public final class PeopleSelectionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public PeopleSelectionViewHolder() {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull
        com.mirrorflysdk.api.models.RecentChat item) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter$PeopleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter;)V", "setData", "", "item", "Lcom/mirrorflysdk/api/models/RecentChat;", "app_debug"})
    public final class PeopleViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public PeopleViewHolder() {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull
        com.mirrorflysdk.api.models.RecentChat item) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/chatTag/adapter/PeopleSelectionListAdapter$Companion;", "", "()V", "TYPE_CREATE_TAG", "", "TYPE_SELECTION_TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}