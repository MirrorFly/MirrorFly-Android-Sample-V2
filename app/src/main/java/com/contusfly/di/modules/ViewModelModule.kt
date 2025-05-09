package com.contusfly.di.modules

import androidx.lifecycle.ViewModel
import com.contusfly.call.calllog.CallLogViewModel
import com.contusfly.call.groupcall.CallViewModel
import com.contusfly.di.ViewModelKey
import com.contusfly.viewmodels.*
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
// Dagger requires @Module to be an abstract class, not an interface
@Module
@SuppressWarnings("kotlin:S6526")
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    internal abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChatParentViewModel::class)
    internal abstract fun bindChatParentViewModel(chatParentViewModel: ChatParentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ContactViewModel::class)
    internal abstract fun bindContactViewModel(contactViewModel: ContactViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    internal abstract fun bindChatViewModel(chatViewModel: ChatViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ForwardMessageViewModel::class)
    internal abstract fun bindForwardMessageViewModel(chatViewModel: ForwardMessageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CallLogViewModel::class)
    internal abstract fun bindCallLogViewModel(callLogViewModel: CallLogViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CallViewModel::class)
    internal abstract fun bindCallViewModel(callViewModel: CallViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MediaPreviewViewModel::class)
    internal abstract fun bindMediaPreviewViewModel(mediaPreviewViewModel: MediaPreviewViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    internal abstract fun bindUserListViewModel(userListViewModel: UserListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MentionsViewModel::class)
    internal abstract fun bindMentionsViewModel(mentionsViewModel: MentionsViewModel): ViewModel
}