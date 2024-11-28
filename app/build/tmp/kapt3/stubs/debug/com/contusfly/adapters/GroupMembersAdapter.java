package com.contusfly.adapters;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001.BS\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\nH\u0016J$\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#H\u0014J$\u0010$\u001a\u00020\u000f2\n\u0010\u001e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0014J2\u0010$\u001a\u00020\u000f2\n\u0010\u001e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&H\u0014J \u0010(\u001a\u00020\u000f2\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\tJ\u001c\u0010*\u001a\u00020\u000f2\n\u0010\u001e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0014\u0010+\u001a\u00060\u0003R\u00020\u00002\u0006\u0010,\u001a\u00020-H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012RA\u0010\b\u001a2\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/contusfly/adapters/GroupMembersAdapter;", "Lcom/contusfly/adapters/GenericSearchAdapter;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "Lcom/contusfly/adapters/GroupMembersAdapter$GroupMemberViewHolder;", "context", "Landroid/content/Context;", "profilesList", "Ljava/util/ArrayList;", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "profile", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "getListener", "()Lkotlin/jvm/functions/Function2;", "onParticipantClicked", "getOnParticipantClicked", "setOnParticipantClicked", "(Lkotlin/jvm/functions/Function2;)V", "getItemId", "", "handlePayloads", "bundle", "Landroid/os/Bundle;", "holder", "hasSearchKey", "", "item", "filterKey", "", "onBindData", "payloads", "", "", "onProfileClickedCallback", "fn", "setUserInfo", "setViewHolder", "parent", "Landroid/view/ViewGroup;", "GroupMemberViewHolder", "app_debug"})
public final class GroupMembersAdapter extends com.contusfly.adapters.GenericSearchAdapter<com.mirrorflysdk.api.contacts.ProfileDetails, com.contusfly.adapters.GroupMembersAdapter.GroupMemberViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> profilesList;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<java.lang.Integer, com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> listener = null;
    public kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> onParticipantClicked;
    
    public GroupMembersAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> profilesList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> listener) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> getListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> getOnParticipantClicked() {
        return null;
    }
    
    public final void setOnParticipantClicked(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> p0) {
    }
    
    public final void onProfileClickedCallback(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> fn) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    protected com.contusfly.adapters.GroupMembersAdapter.GroupMemberViewHolder setViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent) {
        return null;
    }
    
    private final void handlePayloads(android.os.Bundle bundle, com.contusfly.adapters.GroupMembersAdapter.GroupMemberViewHolder holder, com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    @java.lang.Override
    public long getItemId(int position) {
        return 0L;
    }
    
    /**
     * Set the user info of the user from the Roster
     *
     * @param holder View holder of recycler view
     * @param item   Roster of the user
     */
    private final void setUserInfo(com.contusfly.adapters.GroupMembersAdapter.GroupMemberViewHolder holder, com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    @java.lang.Override
    protected boolean hasSearchKey(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails item, @org.jetbrains.annotations.NotNull
    java.lang.String filterKey) {
        return false;
    }
    
    @java.lang.Override
    protected void onBindData(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.GroupMembersAdapter.GroupMemberViewHolder holder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails item, int position, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Object> payloads) {
    }
    
    @java.lang.Override
    protected void onBindData(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.GroupMembersAdapter.GroupMemberViewHolder holder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails item, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/adapters/GroupMembersAdapter$GroupMemberViewHolder;", "Lcom/contusfly/adapters/BaseViewHolder;", "viewBinding", "Lcom/contusfly/databinding/ListParticipantsItemBinding;", "(Lcom/contusfly/adapters/GroupMembersAdapter;Lcom/contusfly/databinding/ListParticipantsItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/ListParticipantsItemBinding;", "setViewBinding", "(Lcom/contusfly/databinding/ListParticipantsItemBinding;)V", "app_debug"})
    public final class GroupMemberViewHolder extends com.contusfly.adapters.BaseViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.contusfly.databinding.ListParticipantsItemBinding viewBinding;
        
        public GroupMemberViewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.ListParticipantsItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.ListParticipantsItemBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.ListParticipantsItemBinding p0) {
        }
    }
}