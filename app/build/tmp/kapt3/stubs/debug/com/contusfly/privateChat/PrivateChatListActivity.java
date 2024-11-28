package com.contusfly.privateChat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\bH\u0002J\u0016\u0010A\u001a\u00020:2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00150CH\u0016J\b\u0010D\u001a\u00020:H\u0002J\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00150C2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0CH\u0002J\b\u0010H\u001a\u00020:H\u0002J\u0018\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u0015H\u0002J\b\u0010L\u001a\u00020:H\u0002J\u0010\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010Q\u001a\u00020:H\u0002J\b\u0010R\u001a\u00020:H\u0002J\u0012\u0010S\u001a\u00020:2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0010\u0010V\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010W\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010X\u001a\u00020:H\u0002J\u0010\u0010Y\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010Z\u001a\u00020:H\u0002J\u0016\u0010[\u001a\u00020:2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0CH\u0002J\b\u0010^\u001a\u00020:H\u0002J\u001c\u0010_\u001a\u00020\n2\b\u0010`\u001a\u0004\u0018\u00010\u00062\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J \u0010c\u001a\u00020:2\u0006\u0010d\u001a\u00020\u00152\u0006\u0010e\u001a\u00020\u00152\u0006\u0010f\u001a\u00020\nH\u0016J\b\u0010g\u001a\u00020:H\u0016J\u0010\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020OH\u0002J\u0012\u0010j\u001a\u00020:2\b\u0010k\u001a\u0004\u0018\u00010lH\u0014J\u001c\u0010m\u001a\u00020\n2\b\u0010`\u001a\u0004\u0018\u00010\u00062\b\u0010a\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010n\u001a\u00020:H\u0014J\u0012\u0010o\u001a\u00020:2\b\u0010`\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010p\u001a\u00020:2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020\nH\u0016J\u0010\u0010t\u001a\u00020:2\u0006\u0010u\u001a\u00020\u0015H\u0016J\b\u0010v\u001a\u00020:H\u0002J\u0018\u0010w\u001a\u00020:2\u0006\u0010u\u001a\u00020\u00152\u0006\u0010x\u001a\u00020\u0015H\u0016J \u0010y\u001a\u00020:2\u0006\u0010u\u001a\u00020\u00152\u0006\u0010z\u001a\u00020\u00152\u0006\u0010{\u001a\u00020\u0015H\u0016J \u0010|\u001a\u00020:2\u0006\u0010u\u001a\u00020\u00152\u0006\u0010}\u001a\u00020\u00152\u0006\u0010~\u001a\u00020\u0015H\u0016J\u0014\u0010\u007f\u001a\u00020:2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0007J\u0013\u0010\u0082\u0001\u001a\u00020:2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0012\u0010\u0085\u0001\u001a\u00020:2\u0007\u0010\u0086\u0001\u001a\u00020\u0015H\u0016J#\u0010\u0087\u0001\u001a\u00020:2\u0006\u0010u\u001a\u00020\u00152\u0007\u0010\u0088\u0001\u001a\u00020\u00152\u0007\u0010\u0089\u0001\u001a\u00020\u0015H\u0016J\u001d\u0010\u008a\u0001\u001a\u00020\n2\b\u0010`\u001a\u0004\u0018\u00010\u00062\b\u0010a\u001a\u0004\u0018\u00010\bH\u0016J\u0011\u0010\u008b\u0001\u001a\u00020:2\u0006\u0010d\u001a\u00020\u0015H\u0002J\t\u0010\u008c\u0001\u001a\u00020:H\u0014J\t\u0010\u008d\u0001\u001a\u00020:H\u0014J\t\u0010\u008e\u0001\u001a\u00020:H\u0016J\t\u0010\u008f\u0001\u001a\u00020:H\u0016J$\u0010\u0090\u0001\u001a\u00020:2\b\u0010d\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0091\u0001\u001a\u00020\u00152\u0006\u0010f\u001a\u00020\nH\u0002J\t\u0010\u0092\u0001\u001a\u00020:H\u0002J \u0010\u0093\u0001\u001a\u00020:2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0C2\u0007\u0010\u0094\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0095\u0001\u001a\u00020:2\u0006\u0010u\u001a\u00020\u0015H\u0002J\u0011\u0010\u0096\u0001\u001a\u00020:2\u0006\u0010u\u001a\u00020\u0015H\u0002J \u0010\u0097\u0001\u001a\u00020:2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0C2\u0007\u0010\u0094\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0098\u0001\u001a\u00020:2\u0006\u0010u\u001a\u00020\u0015H\u0002J\u0017\u0010\u0099\u0001\u001a\u00020:2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0CH\u0002J\u0012\u0010\u009a\u0001\u001a\u00020:2\u0007\u0010\u0086\u0001\u001a\u00020\u0015H\u0002J\u0011\u0010\u009b\u0001\u001a\u00020:2\u0006\u0010u\u001a\u00020\u0015H\u0002J\u0013\u0010\u009c\u0001\u001a\u00020:2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0011\u0010\u009d\u0001\u001a\u00020:2\u0006\u0010d\u001a\u00020\u0015H\u0002J\u0011\u0010\u009e\u0001\u001a\u00020:2\u0006\u0010d\u001a\u00020\u0015H\u0002J\t\u0010\u009f\u0001\u001a\u00020:H\u0002J\u0017\u0010\u00a0\u0001\u001a\u00020:2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0CH\u0002J#\u0010\u00a1\u0001\u001a\u00020:2\u0007\u0010\u00a2\u0001\u001a\u00020O2\u0007\u0010\u00a3\u0001\u001a\u00020l2\u0006\u0010d\u001a\u00020\u0015H\u0002J\u0012\u0010\u00a4\u0001\u001a\u00020:2\u0007\u0010\u00a5\u0001\u001a\u00020]H\u0002J\t\u0010\u00a6\u0001\u001a\u00020:H\u0002J$\u0010\u00a7\u0001\u001a\u00020:2\u0019\u0010\u00a8\u0001\u001a\u0014\u0012\u0004\u0012\u00020\n0\u00a9\u0001j\t\u0012\u0004\u0012\u00020\n`\u00aa\u0001H\u0002J\t\u0010\u00ab\u0001\u001a\u00020:H\u0002J\u0012\u0010\u00ac\u0001\u001a\u00020:2\u0007\u0010\u00ad\u0001\u001a\u00020OH\u0002J\t\u0010\u00ae\u0001\u001a\u00020:H\u0002J\u0012\u0010\u00af\u0001\u001a\u00020:2\u0007\u0010\u00a5\u0001\u001a\u00020]H\u0002J\u0017\u0010\u00b0\u0001\u001a\u00020\n2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0CH\u0002J\t\u0010\u00b1\u0001\u001a\u00020:H\u0002J\t\u0010\u00b2\u0001\u001a\u00020:H\u0002J\u0013\u0010\u00b3\u0001\u001a\u00020:2\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u0001H\u0002J!\u0010\u00b6\u0001\u001a\u00020:2\b\u0010\u00b7\u0001\u001a\u00030\u00b8\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0CH\u0002J\u0007\u0010\u00b9\u0001\u001a\u00020:J\t\u0010\u00ba\u0001\u001a\u00020:H\u0002J\u0013\u0010\u00bb\u0001\u001a\u00020:2\b\u0010\u00b7\u0001\u001a\u00030\u00b8\u0001H\u0014J\u0012\u0010\u00bc\u0001\u001a\u00020:2\u0007\u0010\u0086\u0001\u001a\u00020\u0015H\u0002J\u0011\u0010\u00bd\u0001\u001a\u00020:2\u0006\u0010d\u001a\u00020\u0015H\u0016J\u001b\u0010\u00be\u0001\u001a\u00020:2\u0006\u0010d\u001a\u00020\u00152\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u0001H\u0016J\u0011\u0010\u00bf\u0001\u001a\u00020:2\u0006\u0010d\u001a\u00020\u0015H\u0016J\t\u0010\u00c0\u0001\u001a\u00020:H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150#0 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b&\u0010\'R\u000e\u0010)\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b0\u00101R\u001e\u00103\u001a\u0002048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u00a8\u0006\u00c1\u0001"}, d2 = {"Lcom/contusfly/privateChat/PrivateChatListActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/view/ActionMode$Callback;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "actionMode", "Landroid/view/ActionMode;", "actionModeMenu", "Landroid/view/Menu;", "adminBlockStatus", "", "cabOpen", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getCommonAlertDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "commonAlertDialog$delegate", "Lkotlin/Lazy;", "emptyListView", "Landroid/widget/TextView;", "goTo", "", "handler", "Landroid/os/Handler;", "mAdapter", "Lcom/contusfly/adapters/RecentChatListAdapter;", "getMAdapter", "()Lcom/contusfly/adapters/RecentChatListAdapter;", "mAdapter$delegate", "mContext", "Landroid/content/Context;", "myActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "notificationPermissionLauncher", "", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "privateChatsBinding", "Lcom/contusfly/databinding/ActivityPrivateChatListBinding;", "privateListRecent", "Lcom/contusfly/views/CustomRecyclerView;", "userJid", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "viewModelFactory", "Lcom/contusfly/di/factory/AppViewModelFactory;", "getViewModelFactory", "()Lcom/contusfly/di/factory/AppViewModelFactory;", "setViewModelFactory", "(Lcom/contusfly/di/factory/AppViewModelFactory;)V", "chatObserver", "", "clickListener", "itemclickSupport", "Lcom/contusfly/utils/ItemClickSupport;", "configureActionMode", "mode", "menu", "deleteSelectedRecent", "selectedJids", "", "getIntentValues", "getJidFromList", "recentObjects", "", "getPrivateChat", "getPrivateChatFor", "jId", "event", "groupObserver", "handleOnPrivateChatItemClicked", "position", "", "handlePrivateChatOnItemLongClicked", "handleProfileImageClick", "init", "initChatAdapter", "diffUtilResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "itemClick", "itemLongClick", "launchDashboardActivity", "listOptionSelected", "markasRead", "menuValidationForDelete", "recentList", "Lcom/mirrorflysdk/api/models/RecentChat;", "notificationPermissionChecking", "onActionItemClicked", "p0", "p1", "Landroid/view/MenuItem;", "onAdminBlockedOtherUser", "jid", "type", "status", "onBackPressed", "onClickAction", "itemId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateActionMode", "onDestroy", "onDestroyActionMode", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onGroupProfileUpdated", "groupJid", "onGroupUpdated", "onLeftFromGroup", "leftUserJid", "onMemberMadeAsAdmin", "newAdminMemberJid", "madeByMemberJid", "onMemberRemovedFromGroup", "removedMemberJid", "removedByMemberJid", "onMessageEvent", "messageEvent", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onMessageReceived", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "onMessageStatusUpdated", "messageId", "onNewMemberAddedToGroup", "newMemberJid", "addedByMemberJid", "onPrepareActionMode", "onPrivateChatProfileUpdated", "onRestart", "onResume", "onStart", "onStop", "openPrivateChatActivity", "chatType", "privateChatClearSelectedMessages", "privateChatClick", "startActionMode", "privateChatGroupMadeAsAdmin", "privateChatGroupProfileUpdate", "privateChatListeItemClick", "privateChatMemberRemovedFromGroup", "privateChatMenuValidationForMuteUnMuteIcon", "privateChatMessageStatusUpdate", "privateChatNewMemberAddedGroup", "privateChatOnMessageReceived", "privateChatUserDeletedHisProfile", "privateChatUserUpdateProfile", "privateChatdeleteChatAlert", "privateChatmenuValidationForMarkReadUnReadIcon", "profileAdapterChange", "index", "bundle", "profileDialog", "item", "profileObserver", "readUnRead", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setActionMode", "setEmptyView", "visible", "setListeners", "setupPrivateChatProfileItemClickEvent", "showDeleteOption", "showErrorMessage", "showPrivateChatGroupUserBlockedByAdminPopup", "showProfileDialog", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "updateActionMenuIcons", "features", "Lcom/mirrorflysdk/flycommons/Features;", "updateAdapter", "updateChatItem", "updateFeatureActions", "updateMessage", "userDeletedHisProfile", "userProfileFetched", "userUpdatedHisProfile", "viewInitialize", "app_debug"})
public final class PrivateChatListActivity extends com.contusfly.activities.BaseActivity implements android.view.ActionMode.Callback, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private android.content.Context mContext;
    private com.contusfly.databinding.ActivityPrivateChatListBinding privateChatsBinding;
    private java.lang.String goTo = "";
    private com.contusfly.views.CustomRecyclerView privateListRecent;
    private android.widget.TextView emptyListView;
    @javax.inject.Inject
    public com.contusfly.di.factory.AppViewModelFactory viewModelFactory;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy commonAlertDialog$delegate = null;
    private final kotlin.Lazy mAdapter$delegate = null;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private boolean adminBlockStatus = false;
    private java.lang.String userJid = "";
    private android.view.ActionMode actionMode;
    private android.view.Menu actionModeMenu;
    private boolean cabOpen = false;
    private android.os.Handler handler;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> myActivityResultLauncher;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public PrivateChatListActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.di.factory.AppViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.contusfly.di.factory.AppViewModelFactory p0) {
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getViewModel() {
        return null;
    }
    
    private final com.contusfly.views.CommonAlertDialog getCommonAlertDialog() {
        return null;
    }
    
    private final com.contusfly.adapters.RecentChatListAdapter getMAdapter() {
        return null;
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    private final void getIntentValues() {
    }
    
    private final void viewInitialize() {
    }
    
    private final void showPrivateChatGroupUserBlockedByAdminPopup() {
    }
    
    private final void profileDialog(com.mirrorflysdk.api.models.RecentChat item) {
    }
    
    private final void handleProfileImageClick() {
    }
    
    private final void showProfileDialog(com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    private final void profileObserver() {
    }
    
    private final void chatObserver() {
    }
    
    private final void groupObserver() {
    }
    
    private final void getPrivateChatFor(java.lang.String jId, @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
    }
    
    private final void updateMessage(java.lang.String messageId) {
    }
    
    private final void onPrivateChatProfileUpdated(java.lang.String jid) {
    }
    
    private final void profileAdapterChange(int index, android.os.Bundle bundle, java.lang.String jid) {
    }
    
    private final void onGroupUpdated() {
    }
    
    private final void initChatAdapter(androidx.recyclerview.widget.DiffUtil.DiffResult diffUtilResult) {
    }
    
    private final void setEmptyView(int visible) {
    }
    
    private final void getPrivateChat() {
    }
    
    private final void setListeners() {
    }
    
    private final void clickListener(com.contusfly.utils.ItemClickSupport itemclickSupport) {
    }
    
    private final void handleOnPrivateChatItemClicked(int position) {
    }
    
    private final void itemClick(int position) {
    }
    
    private final void setupPrivateChatProfileItemClickEvent(com.mirrorflysdk.api.models.RecentChat item) {
    }
    
    private final void openPrivateChatActivity(java.lang.String jid, java.lang.String chatType, boolean status) {
    }
    
    /**
     * Handle the long click on the recent chat
     *
     * @param position Position of the list view
     */
    private final void handlePrivateChatOnItemLongClicked(int position) {
    }
    
    private final void itemLongClick(int position) {
    }
    
    private final void privateChatClick(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList, boolean startActionMode) {
    }
    
    private final void privateChatListeItemClick(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList, boolean startActionMode) {
    }
    
    private final void privateChatMenuValidationForMuteUnMuteIcon(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
    
    private final void updateActionMenuIcons(com.mirrorflysdk.flycommons.Features features, java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
    
    private final void menuValidationForDelete(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
    
    private final boolean showDeleteOption(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
        return false;
    }
    
    private final void privateChatmenuValidationForMarkReadUnReadIcon(java.util.List<? extends com.mirrorflysdk.api.models.RecentChat> recentList) {
    }
    
    private final void readUnRead(java.util.ArrayList<java.lang.Boolean> list) {
    }
    
    /**
     * Alert dialog while the user wants to delete chats
     */
    private final void privateChatdeleteChatAlert() {
    }
    
    private final void setActionMode() {
    }
    
    @java.lang.Override
    public boolean onCreateActionMode(@org.jetbrains.annotations.Nullable
    android.view.ActionMode p0, @org.jetbrains.annotations.Nullable
    android.view.Menu p1) {
        return false;
    }
    
    /**
     * Set the action menu for the long press menu.
     *
     * @param mode Action mode
     * @param menu Long press menu
     */
    private final void configureActionMode(android.view.ActionMode mode, android.view.Menu menu) {
    }
    
    @java.lang.Override
    public boolean onPrepareActionMode(@org.jetbrains.annotations.Nullable
    android.view.ActionMode p0, @org.jetbrains.annotations.Nullable
    android.view.Menu p1) {
        return false;
    }
    
    @java.lang.Override
    public boolean onActionItemClicked(@org.jetbrains.annotations.Nullable
    android.view.ActionMode p0, @org.jetbrains.annotations.Nullable
    android.view.MenuItem p1) {
        return false;
    }
    
    /**
     * On click action on the menu when the private chat long pressed it.
     *
     * @param itemId The item id
     * @return boolean True if the item has click handled successfully.
     */
    private final boolean onClickAction(int itemId) {
        return false;
    }
    
    private final void updateChatItem() {
    }
    
    @java.lang.Override
    public void onDestroyActionMode(@org.jetbrains.annotations.Nullable
    android.view.ActionMode p0) {
    }
    
    private final void privateChatClearSelectedMessages() {
    }
    
    /**
     * Called when get updated user profile.
     */
    @java.lang.Override
    public void userProfileFetched(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    @java.lang.Override
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void privateChatUserUpdateProfile(java.lang.String jid) {
    }
    
    @java.lang.Override
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void privateChatUserDeletedHisProfile(java.lang.String jid) {
    }
    
    @java.lang.Override
    public void onNewMemberAddedToGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String newMemberJid, @org.jetbrains.annotations.NotNull
    java.lang.String addedByMemberJid) {
    }
    
    private final void privateChatNewMemberAddedGroup(java.lang.String groupJid) {
    }
    
    @java.lang.Override
    public void onMemberRemovedFromGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String removedMemberJid, @org.jetbrains.annotations.NotNull
    java.lang.String removedByMemberJid) {
    }
    
    private final void privateChatMemberRemovedFromGroup(java.lang.String groupJid) {
    }
    
    @java.lang.Override
    public void onGroupProfileUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid) {
    }
    
    private final void privateChatGroupProfileUpdate(java.lang.String groupJid) {
    }
    
    @java.lang.Override
    public void onMemberMadeAsAdmin(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String newAdminMemberJid, @org.jetbrains.annotations.NotNull
    java.lang.String madeByMemberJid) {
    }
    
    private final void privateChatGroupMadeAsAdmin(java.lang.String groupJid) {
    }
    
    @java.lang.Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final void privateChatOnMessageReceived(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    @java.lang.Override
    public void onMessageStatusUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
    }
    
    private final void privateChatMessageStatusUpdate(java.lang.String messageId) {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    public void onLeftFromGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String leftUserJid) {
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onRestart() {
    }
    
    @java.lang.Override
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    /**
     * Removes the selected chat from the recent chat history.
     *
     * @param selectedJids the recent chat jid list.
     */
    public void deleteSelectedRecent(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> selectedJids) {
    }
    
    public final void updateAdapter() {
    }
    
    private final java.util.List<java.lang.String> getJidFromList(java.util.List<? extends java.lang.Object> recentObjects) {
        return null;
    }
    
    private final void markasRead() {
    }
    
    private final void showErrorMessage() {
    }
    
    private final void notificationPermissionChecking() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(@org.jetbrains.annotations.Nullable
    com.contusfly.models.PrivateChatAuthenticationModel messageEvent) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void launchDashboardActivity() {
    }
}