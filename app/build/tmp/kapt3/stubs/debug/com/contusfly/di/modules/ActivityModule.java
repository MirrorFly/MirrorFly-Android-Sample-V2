package com.contusfly.di.modules;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H!\u00a2\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0007H!\u00a2\u0006\u0002\b\bJ\r\u0010\t\u001a\u00020\nH!\u00a2\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH!\u00a2\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u0010H!\u00a2\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\u0013H!\u00a2\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u0016H!\u00a2\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0019H!\u00a2\u0006\u0002\b\u001aJ\r\u0010\u001b\u001a\u00020\u001cH!\u00a2\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001fH!\u00a2\u0006\u0002\b J\r\u0010!\u001a\u00020\"H!\u00a2\u0006\u0002\b#J\r\u0010$\u001a\u00020%H!\u00a2\u0006\u0002\b&J\r\u0010\'\u001a\u00020(H!\u00a2\u0006\u0002\b)J\r\u0010*\u001a\u00020+H!\u00a2\u0006\u0002\b,J\r\u0010-\u001a\u00020.H!\u00a2\u0006\u0002\b/J\r\u00100\u001a\u000201H!\u00a2\u0006\u0002\b2J\r\u00103\u001a\u000204H!\u00a2\u0006\u0002\b5J\r\u00106\u001a\u000207H!\u00a2\u0006\u0002\b8J\r\u00109\u001a\u00020:H!\u00a2\u0006\u0002\b;J\r\u0010<\u001a\u00020=H!\u00a2\u0006\u0002\b>J\r\u0010?\u001a\u00020@H!\u00a2\u0006\u0002\bAJ\r\u0010B\u001a\u00020CH!\u00a2\u0006\u0002\bDJ\r\u0010E\u001a\u00020FH!\u00a2\u0006\u0002\bG\u00a8\u0006H"}, d2 = {"Lcom/contusfly/di/modules/ActivityModule;", "", "()V", "contributeArchiveChatsActivity", "Lcom/contusfly/activities/ArchivedChatsActivity;", "contributeArchiveChatsActivity$app_debug", "contributeBaseActivity", "Lcom/contusfly/activities/BaseActivity;", "contributeBaseActivity$app_debug", "contributeBottomSheetOtpFragment", "Lcom/contusfly/fragments/BottomSheetOtpFragment;", "contributeBottomSheetOtpFragment$app_debug", "contributeCallHistoryDetailActivity", "Lcom/contusfly/call/calllog/CallHistoryDetailActivity;", "contributeCallHistoryDetailActivity$app_debug", "contributeChatActivity", "Lcom/contusfly/activities/ChatActivity;", "contributeChatActivity$app_debug", "contributeChatParent", "Lcom/contusfly/activities/parent/ChatParent;", "contributeChatParent$app_debug", "contributeChatTagActivity", "Lcom/contusfly/chatTag/activities/ChatTagActivity;", "contributeChatTagActivity$app_debug", "contributeContactSelectionActivity", "Lcom/contusfly/activities/ContactSelectionActivity;", "contributeContactSelectionActivity$app_debug", "contributeDashBoardActivity", "Lcom/contusfly/activities/DashboardActivity;", "contributeDashBoardActivity$app_debug", "contributeEditTagActivity", "Lcom/contusfly/chatTag/activities/EditTagActivity;", "contributeEditTagActivity$app_debug", "contributeForwardMessageActivity", "Lcom/contusfly/activities/ForwardMessageActivity;", "contributeForwardMessageActivity$app_debug", "contributeImagePreviewActivity", "Lcom/contusfly/activities/ImagePreviewActivity;", "contributeImagePreviewActivity$app_debug", "contributeMediaPreviewActivity", "Lcom/contusfly/activities/MediaPreviewActivity;", "contributeMediaPreviewActivity$app_debug", "contributeNewContactsActivity", "Lcom/contusfly/activities/NewContactsActivity;", "contributeNewContactsActivity$app_debug", "contributeOtpActivity", "Lcom/contusfly/activities/OtpActivity;", "contributeOtpActivity$app_debug", "contributePickContactActivity", "Lcom/contusfly/activities/PickContactActivity;", "contributePickContactActivity$app_debug", "contributePinActivity", "Lcom/contusfly/activities/PinActivity;", "contributePinActivity$app_debug", "contributePinSetting", "Lcom/contusfly/activities/PinSetting;", "contributePinSetting$app_debug", "contributeProfileStartActivity", "Lcom/contusfly/activities/ProfileStartActivity;", "contributeProfileStartActivity$app_debug", "contributeQuickShareActivity", "Lcom/contusfly/quickShare/QuickShareActivity;", "contributeQuickShareActivity$app_debug", "contributeSettingsActivity", "Lcom/contusfly/activities/SettingsActivity;", "contributeSettingsActivity$app_debug", "contributeStarredMessageActivity", "Lcom/contusfly/activities/StarredMessageActivity;", "contributeStarredMessageActivity$app_debug", "contributeUserListActivity", "Lcom/contusfly/activities/UserListActivity;", "contributeUserListActivity$app_debug", "app_debug"})
@dagger.Module()
public abstract class ActivityModule {
    
    public ActivityModule() {
        super();
    }
    
    /**
     * Here we attach our Activities to Dagger Graph
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.DashboardActivity contributeDashBoardActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.NewContactsActivity contributeNewContactsActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.UserListActivity contributeUserListActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.OtpActivity contributeOtpActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.ProfileStartActivity contributeProfileStartActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.ChatActivity contributeChatActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.parent.ChatParent contributeChatParent$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.ForwardMessageActivity contributeForwardMessageActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.call.calllog.CallHistoryDetailActivity contributeCallHistoryDetailActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.ImagePreviewActivity contributeImagePreviewActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.PickContactActivity contributePickContactActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.ArchivedChatsActivity contributeArchiveChatsActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.MediaPreviewActivity contributeMediaPreviewActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.PinActivity contributePinActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.PinSetting contributePinSetting$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.fragments.BottomSheetOtpFragment contributeBottomSheetOtpFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.SettingsActivity contributeSettingsActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.quickShare.QuickShareActivity contributeQuickShareActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.ContactSelectionActivity contributeContactSelectionActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.chatTag.activities.ChatTagActivity contributeChatTagActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.chatTag.activities.EditTagActivity contributeEditTagActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.StarredMessageActivity contributeStarredMessageActivity$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.contusfly.activities.BaseActivity contributeBaseActivity$app_debug();
}