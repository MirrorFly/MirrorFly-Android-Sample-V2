package com.contusfly.fragments;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u00bf\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u00bf\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010L\u001a\u00020MH\u0002J \u0010N\u001a\u00020M2\u0016\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0007j\b\u0012\u0004\u0012\u00020\u0010`PH\u0002J\u0006\u0010Q\u001a\u00020MJ\b\u0010R\u001a\u00020MH\u0002J\u0010\u0010S\u001a\u00020M2\u0006\u0010F\u001a\u00020\bH\u0002J\b\u0010T\u001a\u00020MH\u0002J\u0010\u0010U\u001a\u00020M2\u0006\u0010O\u001a\u00020%H\u0002J0\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120W2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\'0Y2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\'0YH\u0002J\u0006\u0010[\u001a\u00020MJ\u0006\u0010\\\u001a\u00020MJ\u0018\u0010]\u001a\u00020M2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\bH\u0002J\b\u0010`\u001a\u00020MH\u0002J\u0010\u0010a\u001a\u00020M2\u0006\u0010b\u001a\u00020\u0012H\u0002J\u0010\u0010c\u001a\u00020M2\u0006\u0010b\u001a\u00020\u0012H\u0002J\u0010\u0010d\u001a\u00020M2\u0006\u0010b\u001a\u00020\u0012H\u0002J\u0012\u0010e\u001a\u00020M2\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0010\u0010h\u001a\u00020M2\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010i\u001a\u00020%H\u0002J\u0006\u0010j\u001a\u00020%J\b\u0010k\u001a\u00020MH\u0002J\u0010\u0010l\u001a\u00020M2\u0006\u0010b\u001a\u00020\u0012H\u0002J\u0010\u0010m\u001a\u00020M2\u0006\u0010n\u001a\u00020%H\u0002J\u0016\u0010o\u001a\u00020M2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020q0YH\u0002J\u0016\u0010r\u001a\u00020M2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020t0YH\u0002J\u001e\u0010u\u001a\u00020M2\u0006\u0010v\u001a\u00020\u00122\f\u0010w\u001a\b\u0012\u0004\u0012\u0002090YH\u0002J\u0016\u0010x\u001a\u00020M2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\'0YH\u0002J%\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2\b\u0010}\u001a\u0004\u0018\u00010~2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020M2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0083\u0001\u001a\u00020M2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020M2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0085\u0001\u001a\u00020M2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0086\u0001\u001a\u00020M2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0002J \u0010\u0087\u0001\u001a\u00020%2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010z2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0017J\u0010\u0010\u008b\u0001\u001a\u00020M2\u0007\u0010\u008c\u0001\u001a\u00020\bJ\u001d\u0010\u008d\u0001\u001a\u00020M2\u0007\u0010\u008e\u0001\u001a\u00020z2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020M2\u0007\u0010\u0090\u0001\u001a\u00020\u0012H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020M2\u0007\u0010\u0092\u0001\u001a\u00020%H\u0002J2\u0010\u0093\u0001\u001a\u00020M2\u000e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020\'0\u0095\u00012\u0017\u0010\u0096\u0001\u001a\u0012\u0012\u0004\u0012\u00020\'0\u0007j\b\u0012\u0004\u0012\u00020\'`PH\u0002J\t\u0010\u0097\u0001\u001a\u00020MH\u0016J\u0007\u0010\u0098\u0001\u001a\u00020MJ\u0012\u0010\u0099\u0001\u001a\u00020M2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u009b\u0001\u001a\u00020M2\u0007\u0010\u009c\u0001\u001a\u00020\bH\u0002J\u0007\u0010\u009d\u0001\u001a\u00020MJ\u0017\u0010\u009e\u0001\u001a\u00020M2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u0007H\u0002J\"\u0010\u009f\u0001\u001a\u00020M2\u0017\u0010\u00a0\u0001\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`PH\u0002J\t\u0010\u00a1\u0001\u001a\u00020MH\u0002J\t\u0010\u00a2\u0001\u001a\u00020MH\u0002J\u0012\u0010\u00a3\u0001\u001a\u00020M2\u0007\u0010\u00a4\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u00a5\u0001\u001a\u00020MH\u0002J\u0012\u0010\u00a6\u0001\u001a\u00020M2\u0007\u0010\u00a7\u0001\u001a\u00020%H\u0002J\u001c\u0010\u00a8\u0001\u001a\u00020M2\u0007\u0010\u00a9\u0001\u001a\u00020+2\b\u0010\u00aa\u0001\u001a\u00030\u00ab\u0001H\u0002J\u0014\u0010\u00ac\u0001\u001a\u00020M2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\bH\u0002J2\u0010\u00ae\u0001\u001a\u00020M2\u000e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020\'0\u0095\u00012\u0017\u0010\u0096\u0001\u001a\u0012\u0012\u0004\u0012\u00020\'0\u0007j\b\u0012\u0004\u0012\u00020\'`PH\u0002J\u0007\u0010\u00af\u0001\u001a\u00020MJ\u0017\u0010\u00b0\u0001\u001a\u00020M2\u000e\u0010\u00b1\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0095\u0001J\u001b\u0010\u00b2\u0001\u001a\u00020M2\u0007\u0010\u009c\u0001\u001a\u00020\b2\u0007\u0010\u00b3\u0001\u001a\u00020%H\u0002J\u001b\u0010\u00b4\u0001\u001a\u00020M2\b\u0010\u00b5\u0001\u001a\u00030\u0080\u00012\u0006\u0010&\u001a\u00020\'H\u0002J\u0012\u0010\u00b6\u0001\u001a\u00020M2\u0007\u0010\u00b7\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u00b8\u0001\u001a\u00020M2\u0007\u0010\u009c\u0001\u001a\u00020\bH\u0002J \u0010\u00b9\u0001\u001a\u00020M2\u0007\u0010\u009c\u0001\u001a\u00020\b2\f\b\u0002\u0010\u00ba\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\u0010\u0010\u00bb\u0001\u001a\u00020M2\u0007\u0010\u00bc\u0001\u001a\u00020%J\u000f\u0010\u00bd\u0001\u001a\u00020M2\u0006\u0010b\u001a\u00020\u0012J\u0012\u0010\u00bd\u0001\u001a\u00020M2\u0007\u0010\u009c\u0001\u001a\u00020\bH\u0002J\u001d\u0010\u00be\u0001\u001a\u00020M2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%0WH\u0002R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u000e\u00102\u001a\u000203X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002090\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u00101\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020A0@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u00101\u001a\u0004\bI\u0010J\u00a8\u0006\u00c0\u0001"}, d2 = {"Lcom/contusfly/fragments/RecentChatListFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/View$OnTouchListener;", "Lcom/contusfly/interfaces/PrivateChatReleaseListener;", "()V", "chatJidList", "Ljava/util/ArrayList;", "", "getChatJidList", "()Ljava/util/ArrayList;", "setChatJidList", "(Ljava/util/ArrayList;)V", "chatTagAdapter", "Lcom/contusfly/chatTag/adapter/RecentChatTagAdapter;", "chatTagList", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "chatTagselectedposition", "", "contactCount", "getContactCount", "()I", "setContactCount", "(I)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dialogFragment", "Lcom/contusfly/fragments/ProfileDialogFragment;", "effectFactory", "Lcom/contusfly/utils/BounceEdgeEffectFactory;", "emptyView", "Landroid/widget/TextView;", "filterContactRunnable", "Ljava/lang/Runnable;", "isRestartActivity", "", "item", "Lcom/mirrorflysdk/api/models/RecentChat;", "lastClickTime", "", "listRecent", "Lcom/contusfly/views/CustomRecyclerView;", "mAdapter", "Lcom/contusfly/adapters/RecentChatListAdapter;", "getMAdapter", "()Lcom/contusfly/adapters/RecentChatListAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mContext", "Landroid/content/Context;", "mHandler", "Landroid/os/Handler;", "mRecentChatListType", "Lcom/contusfly/activities/parent/DashboardParent$RecentChatListType;", "mRecentSearchList", "Lcom/contusfly/models/RecentSearch;", "mSearchAdapter", "Lcom/contusfly/adapters/RecentChatSearchAdapter;", "getMSearchAdapter", "()Lcom/contusfly/adapters/RecentChatSearchAdapter;", "mSearchAdapter$delegate", "myActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "recentChatBinding", "Lcom/contusfly/databinding/FragmentRecentChatBinding;", "recentChatClickedPos", "searchActivityResultLauncher", "searchKey", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "chatTagAdapterinitialize", "", "chatTaglistUpdate", "it", "Lkotlin/collections/ArrayList;", "clearSelectedMessages", "disablePrivateChatView", "doSearch", "emptyViewVisibleOrGone", "fetchingFailObserver", "findAndReplaceNewItem", "Lkotlin/Pair;", "recyclerList", "", "selectedList", "getChatTagData", "getRecentChatData", "getRecentChatFor", "jId", "event", "getRecentChatListBasedOnTagData", "handleOnItemClicked", "position", "handleOnItemLongClicked", "handleOnSearchItemClicked", "initRecentChatAdapter", "diffUtilResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "initView", "isListTypeRecentChat", "isRecentListInitialized", "launchChatPage", "launchHeaderActivity", "launchPinActivity", "isSearchPage", "observeFilteredContactsList", "list", "Lcom/contusfly/models/ProfileDetailsShareModel;", "observeFilteredDeviceContactsList", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "observeFilteredMessageList", "messageCount", "messageList", "observeFilteredRecentChatList", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGroupAdminChanged", "groupId", "onGroupNewUserAdded", "onGroupUpdated", "onGroupUserRemoved", "onProfileUpdated", "onTouch", "p0", "p1", "Landroid/view/MotionEvent;", "onTypingAndGoneStatusUpdate", "singleOrGroupJid", "onViewCreated", "view", "openChatView", "itemPos", "privateChatAdapterChangeStatus", "status", "privateChatPullRefreshViewVisibleGone", "archiveChats", "", "privateChatList", "privateChatReleased", "refreshRecentChatList", "removeSearchListItemOfType", "type", "searchListPrivateChatUserChecking", "jid", "setAdapterBasedOnSearchType", "setEmptyView", "setJidList", "mJid", "setListeners", "setObservers", "setPaginatedData", "listSize", "setRecentChatAdapter", "setRecyclerViewBounceEffectValue", "isBounceNeed", "setScrollListener", "recyclerView", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "showMessage", "message", "showPrivateChatView", "updateAdapter", "updateArchiveChatsList", "selectedJids", "updateArchiveChatsStatus", "archiveStatus", "updateListAdapter", "bundle", "updateMessageUpdate", "messageId", "updateProfileDialog", "updateRecentChatAdapter", "payloads", "updateRecentItem", "mutedStatus", "updateSearchAdapter", "userBlockedByAdmin", "Companion", "app_debug"})
public final class RecentChatListFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope, android.view.View.OnTouchListener, com.contusfly.interfaces.PrivateChatReleaseListener {
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
    @org.jetbrains.annotations.NotNull
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
    private com.contusfly.utils.BounceEdgeEffectFactory effectFactory;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> myActivityResultLauncher;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> searchActivityResultLauncher;
    private final java.lang.Runnable filterContactRunnable = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.RecentChatListFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public RecentChatListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getChatJidList() {
        return null;
    }
    
    public final void setChatJidList(@org.jetbrains.annotations.NotNull
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
    
    private final void launchHeaderActivity(int position) {
    }
    
    private final void launchPinActivity(boolean isSearchPage) {
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
    
    private final void searchListPrivateChatUserChecking(java.lang.String jid) {
    }
    
    private final void launchChatPage() {
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
    
    private final void getRecentChatFor(java.lang.String jId, @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
    }
    
    private final void doSearch(java.lang.String searchKey) {
    }
    
    private final void updateMessageUpdate(java.lang.String messageId) {
    }
    
    public final void onTypingAndGoneStatusUpdate(@org.jetbrains.annotations.NotNull
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
    
    private final void privateChatPullRefreshViewVisibleGone(java.util.List<com.mirrorflysdk.api.models.RecentChat> archiveChats, java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> privateChatList) {
    }
    
    private final void showPrivateChatView(java.util.List<com.mirrorflysdk.api.models.RecentChat> archiveChats, java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> privateChatList) {
    }
    
    @kotlin.jvm.Synchronized
    private final synchronized kotlin.Pair<java.lang.Integer, java.lang.Integer> findAndReplaceNewItem(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recyclerList, java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> selectedList) {
        return null;
    }
    
    private final void setRecentChatAdapter() {
    }
    
    private final void setScrollListener(com.contusfly.views.CustomRecyclerView recyclerView, androidx.recyclerview.widget.LinearLayoutManager layoutManager) {
    }
    
    private final void disablePrivateChatView() {
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
    
    private final void observeFilteredDeviceContactsList(java.util.List<? extends com.mirrorflysdk.api.contacts.ProfileDetails> profileDetails) {
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
    
    public final void updateArchiveChatsList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> selectedJids) {
    }
    
    public final void clearSelectedMessages() {
    }
    
    private final void updateListAdapter(android.os.Bundle bundle, com.mirrorflysdk.api.models.RecentChat item) {
    }
    
    public final void refreshRecentChatList() {
    }
    
    public final void updateRecentItem(boolean mutedStatus) {
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object, with the
     * specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.contusfly.fragments.RecentChatListFragment newInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override
    public boolean onTouch(@org.jetbrains.annotations.Nullable
    android.view.View p0, @org.jetbrains.annotations.Nullable
    android.view.MotionEvent p1) {
        return false;
    }
    
    @java.lang.Override
    public void privateChatReleased() {
    }
    
    private final void privateChatAdapterChangeStatus(boolean status) {
    }
    
    private final void setRecyclerViewBounceEffectValue(boolean isBounceNeed) {
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
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.contusfly.fragments.RecentChatListFragment newInstance() {
            return null;
        }
    }
}