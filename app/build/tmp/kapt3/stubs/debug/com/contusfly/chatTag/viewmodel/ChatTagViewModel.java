package com.contusfly.chatTag.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/chatTag/viewmodel/ChatTagViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "recentChatAdapter", "Ljava/util/LinkedList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "getRecentChatAdapter", "()Ljava/util/LinkedList;", "recentChatAdapter$delegate", "Lkotlin/Lazy;", "recentChatDiffResult", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getRecentChatDiffResult", "()Landroidx/lifecycle/MutableLiveData;", "recentChatList", "Ljava/util/ArrayList;", "getRecentChatList", "getRecentChats", "", "app_debug"})
public final class ChatTagViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat>> recentChatList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy recentChatAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> recentChatDiffResult = null;
    
    @javax.inject.Inject()
    public ChatTagViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat>> getRecentChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat> getRecentChatAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getRecentChatDiffResult() {
        return null;
    }
    
    public final void getRecentChats() {
    }
}