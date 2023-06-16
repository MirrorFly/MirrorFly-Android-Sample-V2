package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/viewmodels/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "messageRepository", "Lcom/contusfly/repository/MessageRepository;", "(Lcom/contusfly/repository/MessageRepository;)V", "isRefreshing", "", "toUserJid", "", "userRoster", "Landroidx/lifecycle/MutableLiveData;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getUserRoster", "()Landroidx/lifecycle/MutableLiveData;", "deleteUnreadMessageSeparator", "", "jid", "getMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "messageId", "getProfileDetails", "setUserJid", "app_debug"})
public final class ChatViewModel extends androidx.lifecycle.ViewModel {
    private final com.contusfly.repository.MessageRepository messageRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.api.contacts.ProfileDetails> userRoster = null;
    
    /**
     * contact refreshing status
     */
    private boolean isRefreshing = false;
    private java.lang.String toUserJid;
    
    @javax.inject.Inject()
    public ChatViewModel(@org.jetbrains.annotations.NotNull()
    com.contusfly.repository.MessageRepository messageRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.api.contacts.ProfileDetails> getUserRoster() {
        return null;
    }
    
    public final void setUserJid(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    public final void getProfileDetails() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mirrorflysdk.api.models.ChatMessage getMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId) {
        return null;
    }
    
    public final void deleteUnreadMessageSeparator(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
}