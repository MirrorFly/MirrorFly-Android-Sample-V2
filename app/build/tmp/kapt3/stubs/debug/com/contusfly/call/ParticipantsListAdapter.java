package com.contusfly.call;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/contusfly/call/ParticipantsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/call/ParticipantsListAdapter$ParticipantsListViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "profilesUserList", "Ljava/util/ArrayList;", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setParticipantsProfiles", "callConnectedUserList", "setUserMuteAndUnMuteStatus", "profileJid", "viewBinding", "Lcom/contusfly/databinding/RowParticipantsListItemBinding;", "updateParticipantsDetails", "jid", "ParticipantsListViewHolder", "app_debug"})
public final class ParticipantsListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.call.ParticipantsListAdapter.ParticipantsListViewHolder> {
    private final android.content.Context context = null;
    private java.util.ArrayList<java.lang.String> profilesUserList;
    
    public ParticipantsListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setParticipantsProfiles(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<java.lang.String> callConnectedUserList) {
    }
    
    public final void updateParticipantsDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.contusfly.call.ParticipantsListAdapter.ParticipantsListViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.ParticipantsListAdapter.ParticipantsListViewHolder holder, int position) {
    }
    
    private final void setUserMuteAndUnMuteStatus(java.lang.String profileJid, com.contusfly.databinding.RowParticipantsListItemBinding viewBinding) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * This class containing the view of the participants items
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/call/ParticipantsListAdapter$ParticipantsListViewHolder;", "Lcom/contusfly/adapters/BaseViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowParticipantsListItemBinding;", "(Lcom/contusfly/databinding/RowParticipantsListItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/RowParticipantsListItemBinding;", "setViewBinding", "app_debug"})
    public static final class ParticipantsListViewHolder extends com.contusfly.adapters.BaseViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.databinding.RowParticipantsListItemBinding viewBinding;
        
        public ParticipantsListViewHolder(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowParticipantsListItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.databinding.RowParticipantsListItemBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowParticipantsListItemBinding p0) {
        }
    }
}