package com.contusfly.starredMessages.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u001eJ\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J\u000e\u0010\'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020$R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/contusfly/starredMessages/viewmodel/StarredMessageViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "searchedStarredMessageList", "", "Lcom/mirrorflysdk/api/models/ChatMessage;", "getSearchedStarredMessageList", "()Ljava/util/List;", "setSearchedStarredMessageList", "(Ljava/util/List;)V", "starredMessageDiffResult", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getStarredMessageDiffResult", "()Landroidx/lifecycle/MutableLiveData;", "starredMessageFetched", "", "getStarredMessageFetched", "starredMessageUpdated", "", "getStarredMessageUpdated", "starredMessagesList", "getStarredMessagesList", "setStarredMessagesList", "starredMessagesListValues", "", "getStarredMessagesListValues", "setStarredMessagesListValues", "(Landroidx/lifecycle/MutableLiveData;)V", "fetchStarredMessageData", "", "it", "searchEnabled", "getStarredMessageList", "getStarredMessagePosition", "messageId", "", "messageListAddClear", "updateStarredMessageData", "updateStarredMessageDataByJid", "userJid", "app_debug"})
public final class StarredMessageViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.models.ChatMessage>> starredMessagesListValues;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> starredMessageDiffResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> starredMessageFetched = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> starredMessageUpdated = null;
    
    /**
     * The List of chat messages to display in the adapter
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.mirrorflysdk.api.models.ChatMessage> starredMessagesList;
    
    /**
     * The List of chat messages to display in the adapter
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.mirrorflysdk.api.models.ChatMessage> searchedStarredMessageList;
    
    @javax.inject.Inject()
    public StarredMessageViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.models.ChatMessage>> getStarredMessagesListValues() {
        return null;
    }
    
    public final void setStarredMessagesListValues(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.models.ChatMessage>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getStarredMessageDiffResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getStarredMessageFetched() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getStarredMessageUpdated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mirrorflysdk.api.models.ChatMessage> getStarredMessagesList() {
        return null;
    }
    
    public final void setStarredMessagesList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mirrorflysdk.api.models.ChatMessage> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mirrorflysdk.api.models.ChatMessage> getSearchedStarredMessageList() {
        return null;
    }
    
    public final void setSearchedStarredMessageList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mirrorflysdk.api.models.ChatMessage> p0) {
    }
    
    public final void getStarredMessageList() {
    }
    
    public final void fetchStarredMessageData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mirrorflysdk.api.models.ChatMessage> it, boolean searchEnabled) {
    }
    
    private final void messageListAddClear(java.util.List<com.mirrorflysdk.api.models.ChatMessage> it) {
    }
    
    public final void updateStarredMessageData(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId) {
    }
    
    private final int getStarredMessagePosition(java.lang.String messageId) {
        return 0;
    }
    
    public final void updateStarredMessageDataByJid(@org.jetbrains.annotations.NotNull()
    java.lang.String userJid) {
    }
}