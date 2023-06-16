package com.contusfly.fragments;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0010\u0018\u0000 \u00a5\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00a5\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010E\u001a\u00020FH\u0002J \u0010G\u001a\u00020F2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0006j\b\u0012\u0004\u0012\u00020\u000f`IH\u0002J\u0006\u0010J\u001a\u00020FJ\u0010\u0010K\u001a\u00020F2\u0006\u0010?\u001a\u00020\u0007H\u0002J\b\u0010L\u001a\u00020FH\u0002J\u0010\u0010M\u001a\u00020F2\u0006\u0010H\u001a\u00020\"H\u0002J0\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110O2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020$0Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020$0QH\u0002J\u0006\u0010S\u001a\u00020FJ\u0006\u0010T\u001a\u00020FJ\u0018\u0010U\u001a\u00020F2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0002J\b\u0010X\u001a\u00020FH\u0002J\u0010\u0010Y\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u0011H\u0002J\u0010\u0010[\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u0011H\u0002J\u0010\u0010\\\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u0011H\u0002J\u0012\u0010]\u001a\u00020F2\b\u0010^\u001a\u0004\u0018\u00010_H\u0002J\u0010\u0010`\u001a\u00020F2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010a\u001a\u00020\"H\u0002J\u0006\u0010b\u001a\u00020\"J\u0016\u0010c\u001a\u00020F2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0QH\u0002J\u001e\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020\u00112\f\u0010h\u001a\b\u0012\u0004\u0012\u0002060QH\u0002J\u0016\u0010i\u001a\u00020F2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020$0QH\u0002J$\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020m2\b\u0010n\u001a\u0004\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\u0010\u0010r\u001a\u00020F2\u0006\u0010s\u001a\u00020\u0007H\u0002J\u0010\u0010t\u001a\u00020F2\u0006\u0010s\u001a\u00020\u0007H\u0002J\u0010\u0010u\u001a\u00020F2\u0006\u0010s\u001a\u00020\u0007H\u0002J\u0010\u0010v\u001a\u00020F2\u0006\u0010s\u001a\u00020\u0007H\u0002J\u0010\u0010w\u001a\u00020F2\u0006\u0010s\u001a\u00020\u0007H\u0002J\u001c\u0010x\u001a\u00020\"2\b\u0010y\u001a\u0004\u0018\u00010k2\b\u0010z\u001a\u0004\u0018\u00010{H\u0017J\u000e\u0010|\u001a\u00020F2\u0006\u0010}\u001a\u00020\u0007J\u001a\u0010~\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020k2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020F2\u0007\u0010\u0081\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u0082\u0001\u001a\u00020F2\u0007\u0010\u0083\u0001\u001a\u00020\u0007H\u0002J\u0007\u0010\u0084\u0001\u001a\u00020FJ\u0017\u0010\u0085\u0001\u001a\u00020F2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0006H\u0002J\"\u0010\u0086\u0001\u001a\u00020F2\u0017\u0010\u0087\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`IH\u0002J\t\u0010\u0088\u0001\u001a\u00020FH\u0002J\t\u0010\u0089\u0001\u001a\u00020FH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020F2\u0007\u0010\u008b\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u008c\u0001\u001a\u00020FH\u0002J\u001c\u0010\u008d\u0001\u001a\u00020F2\u0007\u0010\u008e\u0001\u001a\u00020(2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0002J\u0014\u0010\u0091\u0001\u001a\u00020F2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0007H\u0002J\u0007\u0010\u0093\u0001\u001a\u00020FJ\u0017\u0010\u0094\u0001\u001a\u00020F2\u000e\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0096\u0001J\u001b\u0010\u0097\u0001\u001a\u00020F2\u0007\u0010\u0098\u0001\u001a\u00020\u00072\u0007\u0010\u0099\u0001\u001a\u00020\"H\u0002J\u001a\u0010\u009a\u0001\u001a\u00020F2\u0007\u0010\u009b\u0001\u001a\u00020q2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010\u009c\u0001\u001a\u00020F2\u0007\u0010\u009d\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020F2\u0007\u0010\u0098\u0001\u001a\u00020\u0007H\u0002J\u001f\u0010\u009f\u0001\u001a\u00020F2\u0007\u0010\u0098\u0001\u001a\u00020\u00072\u000b\b\u0002\u0010\u00a0\u0001\u001a\u0004\u0018\u00010qH\u0002J\u0010\u0010\u00a1\u0001\u001a\u00020F2\u0007\u0010\u00a2\u0001\u001a\u00020\"J\u000f\u0010\u00a3\u0001\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u0011J\u0012\u0010\u00a3\u0001\u001a\u00020F2\u0007\u0010\u0098\u0001\u001a\u00020\u0007H\u0002J\u001d\u0010\u00a4\u0001\u001a\u00020F2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0OH\u0002R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b9\u0010:R\u000e\u0010<\u001a\u00020=X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010.\u001a\u0004\bB\u0010C\u00a8\u0006\u00a6\u0001"}, d2 = {"Lcom/contusfly/fragments/RecentChatListFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/View$OnTouchListener;", "()V", "chatJidList", "Ljava/util/ArrayList;", "", "getChatJidList", "()Ljava/util/ArrayList;", "setChatJidList", "(Ljava/util/ArrayList;)V", "chatTagAdapter", "Lcom/contusfly/chatTag/adapter/RecentChatTagAdapter;", "chatTagList", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "chatTagselectedposition", "", "contactCount", "getContactCount", "()I", "setContactCount", "(I)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dialogFragment", "Lcom/contusfly/fragments/ProfileDialogFragment;", "emptyView", "Landroid/widget/TextView;", "filterContactRunnable", "Ljava/lang/Runnable;", "isRestartActivity", "", "item", "Lcom/mirrorflysdk/api/models/RecentChat;", "lastClickTime", "", "listRecent", "Lcom/contusfly/views/CustomRecyclerView;", "mAdapter", "Lcom/contusfly/adapters/RecentChatListAdapter;", "getMAdapter", "()Lcom/contusfly/adapters/RecentChatListAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mContext", "Landroid/content/Context;", "mHandler", "Landroid/os/Handler;", "mRecentChatListType", "Lcom/contusfly/activities/parent/DashboardParent$RecentChatListType;", "mRecentSearchList", "Lcom/contusfly/models/RecentSearch;", "mSearchAdapter", "Lcom/contusfly/adapters/RecentChatSearchAdapter;", "getMSearchAdapter", "()Lcom/contusfly/adapters/RecentChatSearchAdapter;", "mSearchAdapter$delegate", "recentChatBinding", "Lcom/contusfly/databinding/FragmentRecentChatBinding;", "recentChatClickedPos", "searchKey", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "chatTagAdapterinitialize", "", "chatTaglistUpdate", "it", "Lkotlin/collections/ArrayList;", "clearSelectedMessages", "doSearch", "emptyViewVisibleOrGone", "fetchingFailObserver", "findAndReplaceNewItem", "Lkotlin/Pair;", "recyclerList", "", "selectedList", "getChatTagData", "getRecentChatData", "getRecentChatFor", "jId", "event", "getRecentChatListBasedOnTagData", "handleOnItemClicked", "position", "handleOnItemLongClicked", "handleOnSearchItemClicked", "initRecentChatAdapter", "diffUtilResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "initView", "isListTypeRecentChat", "isRecentListInitialized", "observeFilteredContactsList", "list", "Lcom/contusfly/models/ProfileDetailsShareModel;", "observeFilteredMessageList", "messageCount", "messageList", "observeFilteredRecentChatList", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGroupAdminChanged", "groupId", "onGroupNewUserAdded", "onGroupUpdated", "onGroupUserRemoved", "onProfileUpdated", "onTouch", "p0", "p1", "Landroid/view/MotionEvent;", "onTypingAndGoneStatusUpdate", "singleOrGroupJid", "onViewCreated", "view", "openChatView", "itemPos", "removeSearchListItemOfType", "type", "setAdapterBasedOnSearchType", "setEmptyView", "setJidList", "mJid", "setListeners", "setObservers", "setPaginatedData", "listSize", "setRecentChatAdapter", "setScrollListener", "recyclerView", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "showMessage", "message", "updateAdapter", "updateArchiveChatsList", "selectedJids", "", "updateArchiveChatsStatus", "jid", "archiveStatus", "updateListAdapter", "bundle", "updateMessageUpdate", "messageId", "updateProfileDialog", "updateRecentChatAdapter", "payloads", "updateRecentItem", "mutedStatus", "updateSearchAdapter", "userBlockedByAdmin", "Companion", "app_debug"})
public final class RecentChatListFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope, android.view.View.OnTouchListener {
    private com.mirrorflysdk.api.models.RecentChat recentChatClickedPos;
    private android.content.Context mContext;
    private com.contusfly.databinding.FragmentRecentChatBinding recentChatBinding;
    
    /**
     * Display the recent list and searched list in the recycler view
     */
    private com.contusfly.views.CustomRecyclerView listRecent;
    private android.widget.TextView emptyView;
    private com.contusfly.fragments.ProfileDialogFragment dialogFragment;
    private com.mirrorflysdk.api.models.RecentChat item;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> chatJidList;
    
    /**
     * The handler to delay the recent chat list
     */
    private android.os.Handler mHandler;
    private final kotlin.Lazy mAdapter$delegate = null;
    private com.contusfly.activities.parent.DashboardParent.RecentChatListType mRecentChatListType = com.contusfly.activities.parent.DashboardParent.RecentChatListType.RECENT;
    private final kotlin.Lazy viewModel$delegate = null;
    private final java.util.ArrayList<com.contusfly.models.RecentSearch> mRecentSearchList = null;
    private java.lang.String searchKey = "";
    private int contactCount = 0;
    
    /**
     * Store onclick time to avoid double click
     */
    private long lastClickTime = 0L;
    private final kotlin.Lazy mSearchAdapter$delegate = null;
    private com.contusfly.chatTag.adapter.RecentChatTagAdapter chatTagAdapter;
    private java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> chatTagList;
    private int chatTagselectedposition = 0;
    private boolean isRestartActivity = false;
    private final java.lang.Runnable filterContactRunnable = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.fragments.RecentChatListFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public RecentChatListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getChatJidList() {
        return null;
    }
    
    public final void setChatJidList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    private final com.contusfly.adapters.RecentChatListAdapter getMAdapter() {
        return null;
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getViewModel() {
        return null;
    }
    
    public final int getContactCount() {
        return 0;
    }
    
    public final void setContactCount(int p0) {
    }
    
    private final com.contusfly.adapters.RecentChatSearchAdapter getMSearchAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void getChatTagData() {
    }
    
    public final void getRecentChatData() {
    }
    
    private final boolean isListTypeRecentChat() {
        return false;
    }
    
    private final void initView(com.contusfly.databinding.FragmentRecentChatBinding recentChatBinding) {
    }
    
    private final void setListeners() {
    }
    
    private final void setObservers() {
    }
    
    private final void chatTaglistUpdate(java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel> it) {
    }
    
    private final void chatTagAdapterinitialize() {
    }
    
    private final void getRecentChatListBasedOnTagData() {
    }
    
    private final void userBlockedByAdmin(kotlin.Pair<java.lang.String, java.lang.Boolean> it) {
    }
    
    private final void updateProfileDialog(java.lang.String jid) {
    }
    
    private final void showMessage(java.lang.String message) {
    }
    
    private final void handleOnSearchItemClicked(int position) {
    }
    
    public final void updateSearchAdapter(int position) {
    }
    
    private final void updateSearchAdapter(java.lang.String jid) {
    }
    
    private final void updateRecentChatAdapter(java.lang.String jid, android.os.Bundle payloads) {
    }
    
    private final void updateArchiveChatsStatus(java.lang.String jid, boolean archiveStatus) {
    }
    
    /**
     * Handle the click operation the recycler view in the recent chats
     *
     * @param position Position of the list view
     */
    private final void handleOnItemClicked(int position) {
    }
    
    /**
     * Handle the long click on the recent chat
     *
     * @param position Position of the list view
     */
    private final void handleOnItemLongClicked(int position) {
    }
    
    private final void getRecentChatFor(java.lang.String jId, @com.contusfly.interfaces.RecentChatEvent()
    java.lang.String event) {
    }
    
    private final void doSearch(java.lang.String searchKey) {
    }
    
    private final void updateMessageUpdate(java.lang.String messageId) {
    }
    
    public final void onTypingAndGoneStatusUpdate(@org.jetbrains.annotations.NotNull()
    java.lang.String singleOrGroupJid) {
    }
    
    private final void onGroupUpdated(java.lang.String groupId) {
    }
    
    private final void onProfileUpdated(java.lang.String groupId) {
    }
    
    private final void onGroupNewUserAdded(java.lang.String groupId) {
    }
    
    private final void onGroupUserRemoved(java.lang.String groupId) {
    }
    
    private final void onGroupAdminChanged(java.lang.String groupId) {
    }
    
    private final void initRecentChatAdapter(androidx.recyclerview.widget.DiffUtil.DiffResult diffUtilResult) {
    }
    
    private final void emptyViewVisibleOrGone() {
    }
    
    @kotlin.jvm.Synchronized()
    private final synchronized kotlin.Pair<java.lang.Integer, java.lang.Integer> findAndReplaceNewItem(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recyclerList, java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> selectedList) {
        return null;
    }
    
    private final void setRecentChatAdapter() {
    }
    
    private final void setScrollListener(com.contusfly.views.CustomRecyclerView recyclerView, androidx.recyclerview.widget.LinearLayoutManager layoutManager) {
    }
    
    public final boolean isRecentListInitialized() {
        return false;
    }
    
    private final void fetchingFailObserver(boolean it) {
    }
    
    public final void setAdapterBasedOnSearchType() {
    }
    
    private final void observeFilteredRecentChatList(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> list) {
    }
    
    private final void setEmptyView(java.util.ArrayList<com.contusfly.models.RecentSearch> mRecentSearchList) {
    }
    
    private final void observeFilteredContactsList(java.util.List<com.contusfly.models.ProfileDetailsShareModel> list) {
    }
    
    private final void observeFilteredMessageList(int messageCount, java.util.List<com.contusfly.models.RecentSearch> messageList) {
    }
    
    private final void setJidList(java.util.ArrayList<java.lang.String> mJid) {
    }
    
    private final void setPaginatedData(int listSize) {
    }
    
    /**
     * Remove items of a Type of a previous search.
     * @param type : item of type Recent,Contact,Message
     */
    private final void removeSearchListItemOfType(java.lang.String type) {
    }
    
    /**
     * Open chat view for particular roster.
     *
     * @param itemPos the item pos
     */
    private final void openChatView(int itemPos) {
    }
    
    public final void updateAdapter() {
    }
    
    public final void updateArchiveChatsList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> selectedJids) {
    }
    
    public final void clearSelectedMessages() {
    }
    
    private final void updateListAdapter(android.os.Bundle bundle, com.mirrorflysdk.api.models.RecentChat item) {
    }
    
    public final void updateRecentItem(boolean mutedStatus) {
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object, with the
     * specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.contusfly.fragments.RecentChatListFragment newInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override()
    public boolean onTouch(@org.jetbrains.annotations.Nullable()
    android.view.View p0, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent p1) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/RecentChatListFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/RecentChatListFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * The constructor used to create and initialize a new instance of this class object, with the
         * specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.contusfly.fragments.RecentChatListFragment newInstance() {
            return null;
        }
    }
}