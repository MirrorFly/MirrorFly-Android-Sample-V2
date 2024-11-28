package com.contusfly.call;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/contusfly/call/OnGngCallParticipantsList;", "Landroidx/fragment/app/Fragment;", "()V", "callConnectedUserList", "Ljava/util/ArrayList;", "", "mAdapter", "Lcom/contusfly/call/ParticipantsListAdapter;", "onGngCallParticipantsListBinding", "Lcom/contusfly/databinding/FragmentOnGngCallParticipantsListBinding;", "callConnectedAndDisconnected", "", "updatedUserList", "handleMuteEvents", "userJid", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "refreshUser", "jid", "updateUserJoined", "updateUserLeft", "Companion", "app_debug"})
public final class OnGngCallParticipantsList extends androidx.fragment.app.Fragment {
    private com.contusfly.databinding.FragmentOnGngCallParticipantsListBinding onGngCallParticipantsListBinding;
    private java.util.ArrayList<java.lang.String> callConnectedUserList;
    private com.contusfly.call.ParticipantsListAdapter mAdapter;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.call.OnGngCallParticipantsList.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public OnGngCallParticipantsList() {
        super();
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.contusfly.call.OnGngCallParticipantsList newInstance(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<java.lang.String> callUsersList) {
        return null;
    }
    
    public final void updateUserJoined(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    public final void updateUserLeft(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    public final void handleMuteEvents(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    private final void callConnectedAndDisconnected(java.util.ArrayList<java.lang.String> updatedUserList) {
    }
    
    public final void refreshUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/call/OnGngCallParticipantsList$Companion;", "", "()V", "newInstance", "Lcom/contusfly/call/OnGngCallParticipantsList;", "callUsersList", "Ljava/util/ArrayList;", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.contusfly.call.OnGngCallParticipantsList newInstance(@org.jetbrains.annotations.Nullable
        java.util.ArrayList<java.lang.String> callUsersList) {
            return null;
        }
    }
}