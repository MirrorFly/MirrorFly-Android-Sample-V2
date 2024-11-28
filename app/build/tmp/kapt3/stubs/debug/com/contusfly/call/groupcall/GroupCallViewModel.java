package com.contusfly.call.groupcall;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/call/groupcall/GroupCallViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "internetConnectionNotAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "getInternetConnectionNotAvailable", "()Landroidx/lifecycle/MutableLiveData;", "remoteAudioMuteStatus", "", "getRemoteAudioMuteStatus", "checkInternetConnection", "", "setAudioMuteStatus", "userJid", "app_debug"})
public final class GroupCallViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> internetConnectionNotAvailable = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> remoteAudioMuteStatus = null;
    
    public GroupCallViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getInternetConnectionNotAvailable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getRemoteAudioMuteStatus() {
        return null;
    }
    
    public final void checkInternetConnection() {
    }
    
    /**
     * set mute status text based on remote user mute actions
     * @param userJid id of muted user
     */
    public final void setAudioMuteStatus(@org.jetbrains.annotations.Nullable
    java.lang.String userJid) {
    }
}