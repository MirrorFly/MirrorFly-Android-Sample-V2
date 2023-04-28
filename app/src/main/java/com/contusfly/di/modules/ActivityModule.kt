package com.contusfly.di.modules

import com.contusfly.activities.*
import com.contusfly.activities.parent.ChatParent
import com.contusfly.call.calllog.CallHistoryDetailActivity
import com.contusfly.chatTag.activities.ChatTagActivity
import com.contusfly.chatTag.activities.EditTagActivity
import com.contusfly.fragments.BottomSheetOtpFragment
import com.contusfly.quickShare.QuickShareActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    /**
     * Here we attach our Activities to Dagger Graph
     */
    @ContributesAndroidInjector
    internal abstract fun contributeDashBoardActivity(): DashboardActivity

    @ContributesAndroidInjector
    internal abstract fun contributeNewContactsActivity(): NewContactsActivity

    @ContributesAndroidInjector
    internal abstract fun contributeUserListActivity(): UserListActivity

    @ContributesAndroidInjector
    internal abstract fun contributeOtpActivity(): OtpActivity

    @ContributesAndroidInjector
    internal abstract fun contributeProfileStartActivity(): ProfileStartActivity

    @ContributesAndroidInjector
    internal abstract fun contributeChatActivity(): ChatActivity

    @ContributesAndroidInjector
    internal abstract fun contributeChatParent(): ChatParent

    @ContributesAndroidInjector
    internal abstract fun contributeForwardMessageActivity(): ForwardMessageActivity

    @ContributesAndroidInjector
    internal abstract fun contributeCallHistoryDetailActivity(): CallHistoryDetailActivity

    @ContributesAndroidInjector
    internal abstract fun contributeImagePreviewActivity(): ImagePreviewActivity

    @ContributesAndroidInjector
    internal abstract fun contributePickContactActivity(): PickContactActivity

    @ContributesAndroidInjector
    internal abstract fun contributeArchiveChatsActivity(): ArchivedChatsActivity

    @ContributesAndroidInjector
    internal abstract fun contributeMediaPreviewActivity(): MediaPreviewActivity

    @ContributesAndroidInjector
    internal abstract fun contributePinActivity(): PinActivity

    @ContributesAndroidInjector
    internal abstract fun contributePinSetting(): PinSetting

    @ContributesAndroidInjector
    internal abstract fun contributeBottomSheetOtpFragment(): BottomSheetOtpFragment

    @ContributesAndroidInjector
    internal abstract fun contributeSettingsActivity(): SettingsActivity

    @ContributesAndroidInjector
    internal abstract fun contributeQuickShareActivity(): QuickShareActivity

    @ContributesAndroidInjector
    internal abstract fun contributeContactSelectionActivity(): ContactSelectionActivity

    @ContributesAndroidInjector
    internal abstract fun contributeChatTagActivity(): ChatTagActivity

    @ContributesAndroidInjector
    internal abstract fun contributeEditTagActivity(): EditTagActivity

    @ContributesAndroidInjector
    internal abstract fun contributeStarredMessageActivity(): StarredMessageActivity

    @ContributesAndroidInjector
    internal abstract fun contributeBaseActivity(): BaseActivity
}