package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/contusfly/viewmodels/MentionsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "groupUsers", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getGroupUsers", "()Landroidx/lifecycle/MutableLiveData;", "setGroupUsers", "(Landroidx/lifecycle/MutableLiveData;)V", "selectedRecipient", "Lcom/mirrorflysdk/flycommons/SingleLiveEvent;", "toUserJid", "", "getParticipantsHashMap", "", "jid", "getSelectedRecipient", "Landroidx/lifecycle/LiveData;", "onSelectionChange", "profileDetails", "setUserJid", "Companion", "app_debug"})
public final class MentionsViewModel extends androidx.lifecycle.ViewModel {
    private final com.mirrorflysdk.flycommons.SingleLiveEvent<com.mirrorflysdk.api.contacts.ProfileDetails> selectedRecipient = null;
    private java.lang.String toUserJid;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> groupUsers;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.viewmodels.MentionsViewModel.Companion Companion = null;
    private static final java.lang.String TAG = "MentionViewModel";
    
    @javax.inject.Inject()
    public MentionsViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getGroupUsers() {
        return null;
    }
    
    public final void setGroupUsers(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> p0) {
    }
    
    public final void setUserJid(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    public final void getParticipantsHashMap(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    public final void onSelectionChange(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.mirrorflysdk.api.contacts.ProfileDetails> getSelectedRecipient() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/viewmodels/MentionsViewModel$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}