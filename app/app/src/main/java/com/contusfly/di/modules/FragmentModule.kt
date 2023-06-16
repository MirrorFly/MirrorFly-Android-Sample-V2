package com.contusfly.di.modules

import com.contusfly.call.calllog.CallHistoryFragment
import com.contusfly.call.groupcall.AddParticipantFragment
import com.contusfly.call.groupcall.ParticipantsListFragment
import com.contusfly.fragments.BlockedContactsFragment
import com.contusfly.fragments.ChatsFragment
import com.contusfly.fragments.RecentChatListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@Module
abstract class FragmentModule {

    /**
     * Here we attach our Fragments to Dagger Graph
     */
    @ContributesAndroidInjector
    internal abstract fun contributeRecentChatListFragment(): RecentChatListFragment
    @ContributesAndroidInjector
    internal abstract fun contributeCallHistoryFragment(): CallHistoryFragment
    @ContributesAndroidInjector
    internal abstract fun contributeAddParticipantFragment(): AddParticipantFragment
    @ContributesAndroidInjector
    internal abstract fun contributeBlockedContactsFragment(): BlockedContactsFragment
    @ContributesAndroidInjector
    internal abstract fun contributeChatsFragment(): ChatsFragment
    @ContributesAndroidInjector
    internal abstract fun contributeParticipantsListFragment(): ParticipantsListFragment
}