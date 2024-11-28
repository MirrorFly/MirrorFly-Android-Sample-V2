package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/adapters/ContactChatOnClickListener;", "", "onAudioCallClick", "", "contactData", "Lcom/contusfly/adapters/ContactSelectionModel;", "onInviteButtonClick", "onMessageClick", "onSaveButtonClick", "onVideoCallClick", "app_debug"})
public abstract interface ContactChatOnClickListener {
    
    public abstract void onSaveButtonClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData);
    
    public abstract void onInviteButtonClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData);
    
    public abstract void onVideoCallClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData);
    
    public abstract void onAudioCallClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData);
    
    public abstract void onMessageClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData);
}