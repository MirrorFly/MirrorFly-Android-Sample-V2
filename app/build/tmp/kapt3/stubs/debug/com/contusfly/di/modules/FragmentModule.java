package com.contusfly.di.modules;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H!\u00a2\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0007H!\u00a2\u0006\u0002\b\bJ\r\u0010\t\u001a\u00020\nH!\u00a2\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH!\u00a2\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u0010H!\u00a2\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\u0013H!\u00a2\u0006\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/di/modules/FragmentModule;", "", "()V", "contributeAddParticipantFragment", "Lcom/contusfly/call/groupcall/AddParticipantFragment;", "contributeAddParticipantFragment$app_debug", "contributeBlockedContactsFragment", "Lcom/contusfly/fragments/BlockedContactsFragment;", "contributeBlockedContactsFragment$app_debug", "contributeCallHistoryFragment", "Lcom/contusfly/call/calllog/CallHistoryFragment;", "contributeCallHistoryFragment$app_debug", "contributeChatsFragment", "Lcom/contusfly/fragments/ChatsFragment;", "contributeChatsFragment$app_debug", "contributeParticipantsListFragment", "Lcom/contusfly/call/groupcall/ParticipantsListFragment;", "contributeParticipantsListFragment$app_debug", "contributeRecentChatListFragment", "Lcom/contusfly/fragments/RecentChatListFragment;", "contributeRecentChatListFragment$app_debug", "app_debug"})
@dagger.Module()
public abstract class FragmentModule {
    
    public FragmentModule() {
        super();
    }
    
    /**
     * Here we attach our Fragments to Dagger Graph
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.fragments.RecentChatListFragment contributeRecentChatListFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.call.calllog.CallHistoryFragment contributeCallHistoryFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.call.groupcall.AddParticipantFragment contributeAddParticipantFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.fragments.BlockedContactsFragment contributeBlockedContactsFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.fragments.ChatsFragment contributeChatsFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.call.groupcall.ParticipantsListFragment contributeParticipantsListFragment$app_debug();
}