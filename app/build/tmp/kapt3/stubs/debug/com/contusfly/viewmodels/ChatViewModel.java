package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b\u00a8\u0006\u001f"}, d2 = {"Lcom/contusfly/viewmodels/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "messageRepository", "Lcom/contusfly/repository/MessageRepository;", "(Lcom/contusfly/repository/MessageRepository;)V", "isContactSyncSuccess", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "mContactCount", "", "getMContactCount", "()I", "setMContactCount", "(I)V", "toUserJid", "", "userRoster", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getUserRoster", "deleteUnreadMessageSeparator", "", "jid", "getMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "messageId", "getProfileDetails", "onContactSyncFinished", "success", "setUserJid", "app_debug"})
public final class ChatViewModel extends androidx.lifecycle.ViewModel {
    private final com.contusfly.repository.MessageRepository messageRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.api.contacts.ProfileDetails> userRoster = null;
    
    /**
     * contact refreshing status
     */
    private boolean isRefreshing = false;
    private java.lang.String toUserJid;
    
    /**
     * contacts count from preference
     */
    private int mContactCount = 0;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isContactSyncSuccess = null;
    
    @javax.inject.Inject
    public ChatViewModel(@org.jetbrains.annotations.NotNull
    com.contusfly.repository.MessageRepository messageRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.api.contacts.ProfileDetails> getUserRoster() {
        return null;
    }
    
    public final int getMContactCount() {
        return 0;
    }
    
    public final void setMContactCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isContactSyncSuccess() {
        return null;
    }
    
    public final void setUserJid(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    public final void getProfileDetails() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.api.models.ChatMessage getMessage(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
        return null;
    }
    
    public final void deleteUnreadMessageSeparator(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    public final void onContactSyncFinished(boolean success) {
    }
}