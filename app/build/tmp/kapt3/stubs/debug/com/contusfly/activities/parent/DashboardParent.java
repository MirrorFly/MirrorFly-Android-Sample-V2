package com.contusfly.activities.parent;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@android.annotation.SuppressLint(value = {"Registered"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00f8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u00cb\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001J\u0010\u0010\u0083\u0001\u001a\u00020;2\u0007\u0010\u0084\u0001\u001a\u00020\u000bJ\u001c\u0010\u0085\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0084\u0001\u001a\u00020\u000bH\u0016J\u0013\u0010\u0087\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u001fH\u0016J\n\u0010\u0089\u0001\u001a\u00030\u0081\u0001H\u0016J\n\u0010\u008a\u0001\u001a\u00030\u0081\u0001H\u0002J\u001a\u0010\u008b\u0001\u001a\u00030\u0081\u00012\u000e\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\u001f0\u008d\u0001H\u0016J\u0012\u0010\u008e\u0001\u001a\u00030\u0081\u00012\u0006\u0010j\u001a\u00020\u001fH\u0004J!\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u001f0\u008d\u00012\u000f\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u0091\u00010\u008d\u0001H\u0016J\n\u0010\u0092\u0001\u001a\u00030\u0081\u0001H\u0002J\u0013\u0010\u0093\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0094\u0001\u001a\u00020;H\u0002J\n\u0010\u0095\u0001\u001a\u00030\u0081\u0001H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020;2\u0007\u0010\u0097\u0001\u001a\u00020eH\u0016J\u0014\u0010\u0098\u0001\u001a\u00030\u0081\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0016J\u0016\u0010\u009b\u0001\u001a\u00030\u0081\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0014J\u0013\u0010\u009e\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001fH\u0016J\u001c\u0010\u00a0\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00a1\u0001\u001a\u00020;2\u0007\u0010\u00a2\u0001\u001a\u00020\u001fH\u0016J\u0013\u0010\u00a3\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001fH\u0016J\u001c\u0010\u00a4\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001f2\u0007\u0010\u00a5\u0001\u001a\u00020\u001fH\u0016J%\u0010\u00a6\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001f2\u0007\u0010\u00a7\u0001\u001a\u00020\u001f2\u0007\u0010\u00a8\u0001\u001a\u00020\u001fH\u0016J%\u0010\u00a9\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001f2\u0007\u0010\u00aa\u0001\u001a\u00020\u001f2\u0007\u0010\u00ab\u0001\u001a\u00020\u001fH\u0016J\u0013\u0010\u00ac\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001fH\u0016J%\u0010\u00ad\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u001f2\u0007\u0010\u00ae\u0001\u001a\u00020\u001f2\u0007\u0010\u00af\u0001\u001a\u00020\u001fH\u0016J\n\u0010\u00b0\u0001\u001a\u00030\u0081\u0001H\u0002J\u0010\u0010\u00b1\u0001\u001a\u00020;2\u0007\u0010\u0084\u0001\u001a\u00020\u000bJ\n\u0010\u00b2\u0001\u001a\u00030\u0081\u0001H\u0016J%\u0010\u00b3\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00b4\u0001\u001a\u00020\u001f2\u0007\u0010\u00b5\u0001\u001a\u00020\u001f2\u0007\u0010\u00b6\u0001\u001a\u00020\u001fH\u0016J\n\u0010\u00b7\u0001\u001a\u00030\u0081\u0001H\u0002J\u001c\u0010\u00b8\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u001f2\u0007\u0010\u00ba\u0001\u001a\u00020\u001fH\u0002J#\u0010\u00bb\u0001\u001a\u00030\u0081\u00012\u000e\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\u001f0\u00bc\u00012\u0007\u0010\u00bd\u0001\u001a\u00020eH\u0002J\u001e\u0010\u00be\u0001\u001a\u00030\u0081\u00012\t\u0010\u00bf\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u00c0\u0001\u001a\u00020;H\u0016J\u0013\u0010\u00c1\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00c2\u0001\u001a\u00020;H\u0016J\u0013\u0010\u00c3\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u001fH\u0016J\u0013\u0010\u00c4\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u001fH\u0016J\u001d\u0010\u00c5\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u001f2\b\u0010\u00c6\u0001\u001a\u00030\u00c7\u0001H\u0016J\u0013\u0010\u00c8\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u001fH\u0016J\u0013\u0010\u00c9\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u001fH\u0016J\n\u0010\u00ca\u0001\u001a\u00030\u0081\u0001H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001e0\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\u000207X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020;X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020AX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020SX\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010X\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001e0\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010Y\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010\u001b\u001a\u0004\b[\u0010\\R\u001a\u0010^\u001a\u00020_X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020\u001fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020pX\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020vX\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001b\u0010{\u001a\u00020|8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u007f\u0010\u001b\u001a\u0004\b}\u0010~\u00a8\u0006\u00cc\u0001"}, d2 = {"Lcom/contusfly/activities/parent/DashboardParent;", "Lcom/contusfly/activities/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "actionMode", "Landroid/view/ActionMode;", "getActionMode", "()Landroid/view/ActionMode;", "setActionMode", "(Landroid/view/ActionMode;)V", "actionModeMenu", "Landroid/view/Menu;", "getActionModeMenu", "()Landroid/view/Menu;", "setActionModeMenu", "(Landroid/view/Menu;)V", "callHistoryFragment", "Lcom/contusfly/call/calllog/CallHistoryFragment;", "getCallHistoryFragment", "()Lcom/contusfly/call/calllog/CallHistoryFragment;", "setCallHistoryFragment", "(Lcom/contusfly/call/calllog/CallHistoryFragment;)V", "callLogviewModel", "Lcom/contusfly/call/calllog/CallLogViewModel;", "getCallLogviewModel", "()Lcom/contusfly/call/calllog/CallLogViewModel;", "callLogviewModel$delegate", "Lkotlin/Lazy;", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getCommonAlertDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "commonAlertDialog$delegate", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dashboardBinding", "Lcom/contusfly/databinding/ActivityDashboardBinding;", "getDashboardBinding", "()Lcom/contusfly/databinding/ActivityDashboardBinding;", "setDashboardBinding", "(Lcom/contusfly/databinding/ActivityDashboardBinding;)V", "dashboardViewModelFactory", "Lcom/contusfly/di/factory/AppViewModelFactory;", "getDashboardViewModelFactory", "()Lcom/contusfly/di/factory/AppViewModelFactory;", "setDashboardViewModelFactory", "(Lcom/contusfly/di/factory/AppViewModelFactory;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "isPageChanged", "", "()Z", "setPageChanged", "(Z)V", "ismarkRead", "mAdapter", "Lcom/contusfly/adapters/ViewPagerAdapter;", "getMAdapter", "()Lcom/contusfly/adapters/ViewPagerAdapter;", "setMAdapter", "(Lcom/contusfly/adapters/ViewPagerAdapter;)V", "mRecentChatListType", "Lcom/contusfly/activities/parent/DashboardParent$RecentChatListType;", "getMRecentChatListType", "()Lcom/contusfly/activities/parent/DashboardParent$RecentChatListType;", "setMRecentChatListType", "(Lcom/contusfly/activities/parent/DashboardParent$RecentChatListType;)V", "mSearchView", "Landroidx/appcompat/widget/SearchView;", "getMSearchView", "()Landroidx/appcompat/widget/SearchView;", "setMSearchView", "(Landroidx/appcompat/widget/SearchView;)V", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getMViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "setMViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "notificationPermissionLauncher", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "recentChatFragment", "Lcom/contusfly/fragments/RecentChatListFragment;", "getRecentChatFragment", "()Lcom/contusfly/fragments/RecentChatListFragment;", "setRecentChatFragment", "(Lcom/contusfly/fragments/RecentChatListFragment;)V", "searchItemClickedPosition", "", "getSearchItemClickedPosition", "()I", "setSearchItemClickedPosition", "(I)V", "searchKey", "getSearchKey", "()Ljava/lang/String;", "setSearchKey", "(Ljava/lang/String;)V", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setSwipeRefreshLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "archiveChats", "", "checkLogin", "closeOption", "menu", "configureActionMode", "mode", "connectionFailed", "message", "connectionSuccess", "deleteChatAlert", "deleteSelectedRecent", "selectedJids", "", "filterResult", "getJidFromList", "recentObjects", "", "markasRead", "notificationPermissionChecking", "isMarkRead", "onBackPressed", "onClickAction", "itemId", "onConnectionFailed", "e", "Lcom/mirrorflysdk/flycommons/exception/FlyException;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteGroup", "groupJid", "onGetGroupParticipants", "isError", "groupId", "onGroupProfileUpdated", "onLeftFromGroup", "leftUserJid", "onMemberMadeAsAdmin", "newAdminMemberJid", "madeByMemberJid", "onMemberRemovedFromGroup", "removedMemberJid", "removedByMemberJid", "onNewGroupCreated", "onNewMemberAddedToGroup", "newMemberJid", "addedByMemberJid", "openChatInfo", "openOption", "reconnecting", "setTypingStatus", "singleOrGroupJid", "userId", "typingStatus", "showErrorMessage", "startInfoActivity", "jid", "chatType", "updateArchiveChatsData", "", "failedCount", "updateArchiveUnArchiveChats", "toUser", "archiveStatus", "updateArchivedSettings", "archivedSettingsStatus", "userBlockedMe", "userDeletedHisProfile", "userProfileFetched", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "userUnBlockedMe", "userUpdatedHisProfile", "webConnect", "RecentChatListType", "app_debug"})
public class DashboardParent extends com.contusfly.activities.BaseActivity implements kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    public com.contusfly.databinding.ActivityDashboardBinding dashboardBinding;
    @org.jetbrains.annotations.Nullable()
    private android.view.ActionMode actionMode;
    public androidx.appcompat.widget.SearchView mSearchView;
    public com.google.android.material.tabs.TabLayout tabLayout;
    public androidx.viewpager2.widget.ViewPager2 mViewPager;
    public androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout;
    public com.contusfly.adapters.ViewPagerAdapter mAdapter;
    public android.view.Menu actionModeMenu;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy commonAlertDialog$delegate = null;
    private boolean isPageChanged = false;
    private int searchItemClickedPosition = -1;
    @org.jetbrains.annotations.NotNull()
    private com.contusfly.activities.parent.DashboardParent.RecentChatListType mRecentChatListType = com.contusfly.activities.parent.DashboardParent.RecentChatListType.RECENT;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String searchKey = "";
    public com.contusfly.fragments.RecentChatListFragment recentChatFragment;
    public com.contusfly.call.calllog.CallHistoryFragment callHistoryFragment;
    private boolean ismarkRead = false;
    @javax.inject.Inject()
    public com.contusfly.di.factory.AppViewModelFactory dashboardViewModelFactory;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy callLogviewModel$delegate = null;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> cameraPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public DashboardParent() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.CoroutineExceptionHandler getExceptionHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.databinding.ActivityDashboardBinding getDashboardBinding() {
        return null;
    }
    
    public final void setDashboardBinding(@org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.ActivityDashboardBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public android.view.ActionMode getActionMode() {
        return null;
    }
    
    public void setActionMode(@org.jetbrains.annotations.Nullable()
    android.view.ActionMode p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public androidx.appcompat.widget.SearchView getMSearchView() {
        return null;
    }
    
    public void setMSearchView(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.SearchView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.google.android.material.tabs.TabLayout getTabLayout() {
        return null;
    }
    
    public void setTabLayout(@org.jetbrains.annotations.NotNull()
    com.google.android.material.tabs.TabLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public androidx.viewpager2.widget.ViewPager2 getMViewPager() {
        return null;
    }
    
    public void setMViewPager(@org.jetbrains.annotations.NotNull()
    androidx.viewpager2.widget.ViewPager2 p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public androidx.swiperefreshlayout.widget.SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
    
    public void setSwipeRefreshLayout(@org.jetbrains.annotations.NotNull()
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.adapters.ViewPagerAdapter getMAdapter() {
        return null;
    }
    
    public final void setMAdapter(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.ViewPagerAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public android.view.Menu getActionModeMenu() {
        return null;
    }
    
    public void setActionModeMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.contusfly.views.CommonAlertDialog getCommonAlertDialog() {
        return null;
    }
    
    public boolean isPageChanged() {
        return false;
    }
    
    public void setPageChanged(boolean p0) {
    }
    
    public int getSearchItemClickedPosition() {
        return 0;
    }
    
    public void setSearchItemClickedPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.activities.parent.DashboardParent.RecentChatListType getMRecentChatListType() {
        return null;
    }
    
    public final void setMRecentChatListType(@org.jetbrains.annotations.NotNull()
    com.contusfly.activities.parent.DashboardParent.RecentChatListType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getSearchKey() {
        return null;
    }
    
    public void setSearchKey(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.fragments.RecentChatListFragment getRecentChatFragment() {
        return null;
    }
    
    public final void setRecentChatFragment(@org.jetbrains.annotations.NotNull()
    com.contusfly.fragments.RecentChatListFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.call.calllog.CallHistoryFragment getCallHistoryFragment() {
        return null;
    }
    
    public final void setCallHistoryFragment(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.calllog.CallHistoryFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.contusfly.di.factory.AppViewModelFactory getDashboardViewModelFactory() {
        return null;
    }
    
    public void setDashboardViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.contusfly.di.factory.AppViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.contusfly.viewmodels.DashboardViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.call.calllog.CallLogViewModel getCallLogviewModel() {
        return null;
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final boolean openOption(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    public final boolean closeOption(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    /**
     * Sets the typing status in the recent chat window. It shows the user who is composing the message..
     *
     * @param singleOrGroupJid     Jabber id of the user/group
     * @param userId           Jabber id of the user, if user typing in group; otherwise empty string
     * @param typingStatus   Composing - if currently typing; Gone - if idle
     */
    @java.lang.Override()
    public void setTypingStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String singleOrGroupJid, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String typingStatus) {
    }
    
    /**
     * update chat when new group created
     *
     * @param groupJid Group jid of the Mix group chat
     */
    @java.lang.Override()
    public void onNewGroupCreated(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid) {
    }
    
    /**
     * getting the group participants response
     *
     * @param isError True if the participants got successfully
     * @param groupId Group Jid of the Mix group chat.
     */
    @java.lang.Override()
    public void onGetGroupParticipants(boolean isError, @org.jetbrains.annotations.NotNull()
    java.lang.String groupId) {
    }
    
    /**
     * Handle the new user added in the group.
     *
     * @param groupJid Group jid
     * @param newMemberJid Jabber id of the User
     * @param addedByMemberJid Jid of user who adds the member
     */
    @java.lang.Override()
    public void onNewMemberAddedToGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull()
    java.lang.String newMemberJid, @org.jetbrains.annotations.NotNull()
    java.lang.String addedByMemberJid) {
    }
    
    /**
     * Handle the user removed from the group
     *
     * @param groupJid Group id
     * @param removedMemberJid Removed member Jid
     * @param removedByMemberJid Made remove member jid
     */
    @java.lang.Override()
    public void onMemberRemovedFromGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull()
    java.lang.String removedMemberJid, @org.jetbrains.annotations.NotNull()
    java.lang.String removedByMemberJid) {
    }
    
    @java.lang.Override()
    public void onLeftFromGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull()
    java.lang.String leftUserJid) {
    }
    
    @java.lang.Override()
    public void onDeleteGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid) {
    }
    
    /**
     * Called when the group is updated
     *
     * @param groupJid Group jid
     */
    @java.lang.Override()
    public void onGroupProfileUpdated(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid) {
    }
    
    /**
     * Called when the group admin changed the affiliation
     *
     * @param groupJid Group jid
     * @param newAdminMemberJid New admin jid
     * @param madeByMemberJid Made new admin jid
     */
    @java.lang.Override()
    public void onMemberMadeAsAdmin(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull()
    java.lang.String newAdminMemberJid, @org.jetbrains.annotations.NotNull()
    java.lang.String madeByMemberJid) {
    }
    
    protected final void filterResult(@org.jetbrains.annotations.NotNull()
    java.lang.String searchKey) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override()
    public void onConnectionFailed(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.exception.FlyException e) {
    }
    
    /**
     * Called when Xmpp tcp connections successfully initiated.
     */
    @java.lang.Override()
    public void connectionSuccess() {
    }
    
    @java.lang.Override()
    public void reconnecting() {
    }
    
    /**
     * Called when the connection has been failed from the server
     *
     * @param message Connection failed message
     */
    @java.lang.Override()
    public void connectionFailed(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    /**
     * Called when the profile update of the logged in user has been completed successfully.
     */
    @java.lang.Override()
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    /**
     * To handle callback of any user's profile deleted
     */
    @java.lang.Override()
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    /**
     * Called when the user blocked me
     */
    @java.lang.Override()
    public void userBlockedMe(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    /**
     * Called when the user unblocked me
     */
    @java.lang.Override()
    public void userUnBlockedMe(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    /**
     * Removes the selected chat from the recent chat history.
     *
     * @param selectedJids the recent chat jid list.
     */
    public void deleteSelectedRecent(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> selectedJids) {
    }
    
    /**
     * List of Jids
     *
     * @param recentObjects add jids recentsearch
     * @return jids
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> getJidFromList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> recentObjects) {
        return null;
    }
    
    @java.lang.Override()
    public void userProfileFetched(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    /**
     * Set the action menu for the long press menu.
     *
     * @param mode Action mode
     * @param menu Long press menu
     */
    public void configureActionMode(@org.jetbrains.annotations.NotNull()
    android.view.ActionMode mode, @org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
    }
    
    /**
     * On click action on the menu when the recent chat long pressed it.
     *
     * @param itemId The item id
     * @return boolean True if the item has click handled successfully.
     */
    public boolean onClickAction(int itemId) {
        return false;
    }
    
    private final void markasRead() {
    }
    
    /**
     * Alert dialog while the user wants to delete chats
     */
    private final void deleteChatAlert() {
    }
    
    /**
     * Open user profile view from the recent chats.
     */
    private final void openChatInfo() {
    }
    
    /**
     * Redirect to user show user info activity if single chat else redirect to group info activity
     *
     * @param jid      Jabber id
     * @param chatType Type of the chat
     */
    private final void startInfoActivity(java.lang.String jid, java.lang.String chatType) {
    }
    
    private final void showErrorMessage() {
    }
    
    @kotlin.jvm.Synchronized()
    private final synchronized void archiveChats() {
    }
    
    private final void updateArchiveChatsData(java.util.List<java.lang.String> selectedJids, int failedCount) {
    }
    
    @java.lang.Override()
    public void updateArchiveUnArchiveChats(@org.jetbrains.annotations.Nullable()
    java.lang.String toUser, boolean archiveStatus) {
    }
    
    @java.lang.Override()
    public void updateArchivedSettings(boolean archivedSettingsStatus) {
    }
    
    /**
     * This method checks whether the web chat is logged in or not and redirects accordingly...
     */
    public void webConnect() {
    }
    
    /**
     * This method is check weather the browser already logged in
     * if it's already stored in the database set the boolean is true
     */
    public final void checkLogin() {
    }
    
    private final void notificationPermissionChecking(boolean isMarkRead) {
    }
    
    /**
     * enum constants for List type, used to differentiate the list in the recent chat view
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/activities/parent/DashboardParent$RecentChatListType;", "", "(Ljava/lang/String;I)V", "RECENT", "SEARCH", "app_debug"})
    public static enum RecentChatListType {
        /*public static final*/ RECENT /* = new RECENT() */,
        /*public static final*/ SEARCH /* = new SEARCH() */;
        
        RecentChatListType() {
        }
    }
}