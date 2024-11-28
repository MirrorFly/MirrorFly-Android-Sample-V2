package com.contusfly.chatTag.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0005j\b\u0012\u0004\u0012\u00020\u0017`\u0018J\u0006\u0010\u0019\u001a\u00020\u0015R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/contusfly/chatTag/viewmodel/ChatTagViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "chatTagRecentItems", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "getChatTagRecentItems", "()Landroidx/lifecycle/MutableLiveData;", "recentChatAdapter", "Ljava/util/LinkedList;", "getRecentChatAdapter", "()Ljava/util/LinkedList;", "recentChatAdapter$delegate", "Lkotlin/Lazy;", "recentChatDiffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getRecentChatDiffResult", "recentChatList", "getRecentChatList", "getRecentChatBasedOnChatTag", "", "jidList", "", "Lkotlin/collections/ArrayList;", "getRecentChats", "app_debug"})
public final class ChatTagViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat>> recentChatList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy recentChatAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> recentChatDiffResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat>> chatTagRecentItems = null;
    
    @javax.inject.Inject
    public ChatTagViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat>> getRecentChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat> getRecentChatAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getRecentChatDiffResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat>> getChatTagRecentItems() {
        return null;
    }
    
    public final void getRecentChats() {
    }
    
    public final void getRecentChatBasedOnChatTag(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> jidList) {
    }
}