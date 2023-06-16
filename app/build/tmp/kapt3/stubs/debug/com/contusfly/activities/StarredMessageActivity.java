package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\bH\u0002J\b\u0010F\u001a\u00020DH\u0014J\u0018\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020I2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010J\u001a\u00020DH\u0002J\b\u0010K\u001a\u00020DH\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010-2\u0006\u0010M\u001a\u00020\bH\u0002J\b\u0010N\u001a\u00020DH\u0002J\u0010\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020\u001cH\u0002J\b\u0010Q\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020DH\u0002J\u0018\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020-2\u0006\u0010E\u001a\u00020\bH\u0002J\u0018\u0010U\u001a\u00020)2\u0006\u0010T\u001a\u00020-2\u0006\u0010E\u001a\u00020\bH\u0002J\u0018\u0010V\u001a\u00020)2\u0006\u0010T\u001a\u00020-2\u0006\u0010E\u001a\u00020\bH\u0002J\u0018\u0010W\u001a\u00020)2\u0006\u0010T\u001a\u00020-2\u0006\u0010E\u001a\u00020\bH\u0002J\u0018\u0010X\u001a\u00020)2\u0006\u0010T\u001a\u00020-2\u0006\u0010E\u001a\u00020\bH\u0002J\u0010\u0010Y\u001a\u00020D2\u0006\u0010P\u001a\u00020\u001cH\u0016J\b\u0010Z\u001a\u00020DH\u0016J\u001c\u0010[\u001a\u00020)2\b\u0010\\\u001a\u0004\u0018\u00010I2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J \u0010_\u001a\u00020D2\u0006\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020)H\u0016J\b\u0010c\u001a\u00020DH\u0016J\u0010\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020-H\u0016J\u0010\u0010f\u001a\u00020D2\u0006\u0010e\u001a\u00020-H\u0016J\u0010\u0010g\u001a\u00020)2\u0006\u0010h\u001a\u00020\u001cH\u0002J\"\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020-2\u0006\u0010P\u001a\u00020\u001c2\b\u0010k\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010l\u001a\u00020D2\b\u0010m\u001a\u0004\u0018\u00010nH\u0014J\u0018\u0010o\u001a\u00020)2\u0006\u0010p\u001a\u00020I2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010q\u001a\u00020)2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010r\u001a\u00020DH\u0014J\u0012\u0010s\u001a\u00020D2\b\u0010\\\u001a\u0004\u0018\u00010IH\u0016J\u001a\u0010t\u001a\u00020D2\b\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010w\u001a\u00020)H\u0016J\u0010\u0010x\u001a\u00020D2\u0006\u0010j\u001a\u00020-H\u0016J\u0010\u0010y\u001a\u00020D2\u0006\u0010z\u001a\u00020\bH\u0016J\u0010\u0010{\u001a\u00020D2\u0006\u0010P\u001a\u00020\u001cH\u0002J\u0010\u0010|\u001a\u00020D2\u0006\u0010}\u001a\u00020\u001cH\u0002J\u0010\u0010~\u001a\u00020D2\u0006\u0010T\u001a\u00020-H\u0016J\u0010\u0010\u007f\u001a\u00020D2\u0006\u0010M\u001a\u00020\bH\u0016J,\u0010\u0080\u0001\u001a\u00020D2\u0019\u0010\u0081\u0001\u001a\u0014\u0012\u0004\u0012\u00020\b0\u0082\u0001j\t\u0012\u0004\u0012\u00020\b`\u0083\u00012\u0006\u0010`\u001a\u00020\bH\u0016J\u001e\u0010\u0084\u0001\u001a\u00020)2\b\u0010\\\u001a\u0004\u0018\u00010I2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010%H\u0016J\u001b\u0010\u0086\u0001\u001a\u00020D2\b\u0010j\u001a\u0004\u0018\u00010-2\u0006\u0010P\u001a\u00020\u001cH\u0016J\u001b\u0010\u0087\u0001\u001a\u00020D2\b\u0010j\u001a\u0004\u0018\u00010-2\u0006\u0010P\u001a\u00020\u001cH\u0016J\u0011\u0010\u0088\u0001\u001a\u00020D2\u0006\u0010M\u001a\u00020\bH\u0016J\t\u0010\u0089\u0001\u001a\u00020DH\u0014J\u0013\u0010\u008a\u0001\u001a\u00020D2\b\u0010j\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010\u008b\u0001\u001a\u00020D2\u0007\u0010\u008c\u0001\u001a\u00020-2\u0006\u0010P\u001a\u00020\u001cH\u0002J\u001b\u0010\u008d\u0001\u001a\u00020D2\b\u0010j\u001a\u0004\u0018\u00010-2\u0006\u0010P\u001a\u00020\u001cH\u0016J\u001b\u0010\u008e\u0001\u001a\u00020D2\b\u0010j\u001a\u0004\u0018\u00010-2\u0006\u0010P\u001a\u00020\u001cH\u0016J\u0019\u0010\u008f\u0001\u001a\u00020D2\u0006\u0010j\u001a\u00020-2\u0006\u0010P\u001a\u00020\u001cH\u0016J\t\u0010\u0090\u0001\u001a\u00020DH\u0016J\t\u0010\u0091\u0001\u001a\u00020DH\u0016J\u001a\u0010\u0092\u0001\u001a\u00020D2\u0006\u0010M\u001a\u00020\b2\u0007\u0010\u0093\u0001\u001a\u00020\u001cH\u0016J\t\u0010\u0094\u0001\u001a\u00020DH\u0002J\u0011\u0010\u0095\u0001\u001a\u00020D2\u0006\u0010P\u001a\u00020\u001cH\u0002J\u0011\u0010\u0096\u0001\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0097\u0001\u001a\u00020D2\u0007\u0010\u0098\u0001\u001a\u00020)H\u0002J\t\u0010\u0099\u0001\u001a\u00020DH\u0002J\u0013\u0010\u009a\u0001\u001a\u00020D2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002J\t\u0010\u009d\u0001\u001a\u00020DH\u0002J\u0013\u0010\u009e\u0001\u001a\u00020D2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0014J\u0013\u0010\u009f\u0001\u001a\u00020D2\b\u0010\u00a0\u0001\u001a\u00030\u009c\u0001H\u0002J\u0011\u0010\u00a1\u0001\u001a\u00020D2\u0006\u0010`\u001a\u00020\bH\u0016J\u0011\u0010\u00a2\u0001\u001a\u00020D2\u0006\u0010`\u001a\u00020\bH\u0016J\u0011\u0010\u00a3\u0001\u001a\u00020D2\u0006\u0010`\u001a\u00020\bH\u0016J\u0011\u0010\u00a4\u0001\u001a\u00020D2\u0006\u0010`\u001a\u00020\bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u00108\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\b0\b0\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\u000e\u001a\u0004\b4\u00105R\u001c\u00107\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\b0\b08X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010\u000e\u001a\u0004\b;\u0010<R\u001b\u0010>\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010\u000e\u001a\u0004\b@\u0010A\u00a8\u0006\u00a5\u0001"}, d2 = {"Lcom/contusfly/activities/StarredMessageActivity;", "Lcom/contusfly/activities/parent/ChatParent;", "Lcom/contusfly/interfaces/OnChatItemClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Landroid/view/ActionMode$Callback;", "()V", "clickedStarredMessages", "", "", "dashboardViewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getDashboardViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "dashboardViewModel$delegate", "Lkotlin/Lazy;", "dashboardViewModelFactory", "Lcom/contusfly/di/factory/AppViewModelFactory;", "getDashboardViewModelFactory", "()Lcom/contusfly/di/factory/AppViewModelFactory;", "setDashboardViewModelFactory", "(Lcom/contusfly/di/factory/AppViewModelFactory;)V", "downloadPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "emptyView", "Landroid/widget/TextView;", "itemPosition", "", "listStarredMessages", "Lcom/contusfly/views/CustomRecyclerView;", "getListStarredMessages", "()Lcom/contusfly/views/CustomRecyclerView;", "listStarredMessages$delegate", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "menu", "Landroid/view/Menu;", "rootLayout", "Landroid/widget/RelativeLayout;", "searchCleared", "", "selectedContactMessage", "Lcom/mirrorflysdk/api/models/ContactChatMessage;", "selectedStarredMessagesList", "Lcom/mirrorflysdk/api/models/ChatMessage;", "starredMessageAdapter", "Lcom/contusfly/starredMessages/adapter/StarredMessagesAdapter;", "starredMessageBinding", "Lcom/contusfly/databinding/ActivityStarredMessageBinding;", "txtNoStarredMsg", "Lcom/contusfly/views/CustomTextView;", "getTxtNoStarredMsg", "()Lcom/contusfly/views/CustomTextView;", "txtNoStarredMsg$delegate", "uploadDownloadProgressObserver", "Lio/reactivex/subjects/PublishSubject;", "viewModelStarredMessage", "Lcom/contusfly/starredMessages/viewmodel/StarredMessageViewModel;", "getViewModelStarredMessage", "()Lcom/contusfly/starredMessages/viewmodel/StarredMessageViewModel;", "viewModelStarredMessage$delegate", "viewStarredMessages", "Landroid/widget/LinearLayout;", "getViewStarredMessages", "()Landroid/widget/LinearLayout;", "viewStarredMessages$delegate", "addSearchedMessagesToList", "", "filterKey", "clearActionMenu", "configureActionMode", "mode", "Landroid/view/ActionMode;", "deleteMessage", "deleteMessageAction", "getMessageByID", "messageId", "handleStarredItemClick", "handleStarredMediaMessageClick", "position", "initObservers", "initStarredMessageViews", "isImageCaptionContainsFilterKey", "message", "isMentionUserIdAvailableInMediaMessage", "isMentionUserIdAvailableInMessage", "isTextMessageContainsFilterKey", "isVideoCaptionContainsFilterKey", "listOptionSelected", "mediaPermissionCheck", "onActionItemClicked", "p0", "menuItem", "Landroid/view/MenuItem;", "onAdminBlockedOtherUser", "jid", "type", "status", "onAudioPlayed", "onCancelDownloadClicked", "messageItem", "onCancelUploadClicked", "onClickAction", "itemId", "onContactClick", "item", "registeredJid", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateActionMode", "actionMode", "onCreateOptionsMenu", "onDestroy", "onDestroyActionMode", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onDownloadClicked", "onGroupProfileUpdated", "groupJid", "onItemClick", "onItemLongClick", "starredItemPosition", "onMediaStatusUpdated", "onMessageStatusUpdated", "onMessagesClearedOrDeleted", "messageIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onPrepareActionMode", "p1", "onReceiverItemClicked", "onReceiverItemLongClick", "onReplyMessageClick", "onResume", "onRetryClicked", "onSelectItem", "clickedMessage", "onSenderItemClicked", "onSenderItemLongClick", "onSenderMediaForward", "onStop", "onUpdateUnStarAllMessages", "onUploadDownloadProgressChanged", "progressPercentage", "prepareActionMode", "refreshSelectedMessages", "searchStarredMessage", "setEmptyView", "b", "setUpToolbar", "updateActionMenuIcons", "features", "Lcom/mirrorflysdk/flycommons/Features;", "updateAdapter", "updateFeatureActions", "updateFeatureRestriction", "availableFeatures", "userBlockedMe", "userDeletedHisProfile", "userUnBlockedMe", "userUpdatedHisProfile", "app_debug"})
public final class StarredMessageActivity extends com.contusfly.activities.parent.ChatParent implements com.contusfly.interfaces.OnChatItemClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, android.view.ActionMode.Callback {
    private com.contusfly.databinding.ActivityStarredMessageBinding starredMessageBinding;
    
    /**
     * The List of chat messages to display in the adapter
     */
    private java.util.List<com.mirrorflysdk.api.models.ChatMessage> selectedStarredMessagesList;
    
    /**
     * The adapter chat data in the to attach in the recycler view list
     */
    private com.contusfly.starredMessages.adapter.StarredMessagesAdapter starredMessageAdapter;
    
    /**
     * Selected messages for the info, delete and forward
     */
    private java.util.List<java.lang.String> clickedStarredMessages;
    
    /**
     * Menu of the clicked item
     */
    private android.view.Menu menu;
    private int itemPosition = 0;
    
    /**
     * Recycler view object which used to display the chat view
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy listStarredMessages$delegate = null;
    
    /**
     * Root layout of the chat view
     */
    private android.widget.RelativeLayout rootLayout;
    private final io.reactivex.subjects.PublishSubject<java.lang.String> uploadDownloadProgressObserver = null;
    
    /**
     * The Txt no msg.
     */
    private final kotlin.Lazy txtNoStarredMsg$delegate = null;
    private android.widget.TextView emptyView;
    private boolean searchCleared = false;
    
    /**
     * The View chat.
     */
    private final kotlin.Lazy viewStarredMessages$delegate = null;
    
    /**
     * contact msg for invite
     */
    private com.mirrorflysdk.api.models.ContactChatMessage selectedContactMessage;
    @javax.inject.Inject()
    public com.contusfly.di.factory.AppViewModelFactory dashboardViewModelFactory;
    private final kotlin.Lazy dashboardViewModel$delegate = null;
    private androidx.recyclerview.widget.LinearLayoutManager mLayoutManager;
    private final kotlin.Lazy viewModelStarredMessage$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> downloadPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public StarredMessageActivity() {
        super();
    }
    
    /**
     * Recycler view object which used to display the chat view
     */
    @org.jetbrains.annotations.NotNull()
    protected final com.contusfly.views.CustomRecyclerView getListStarredMessages() {
        return null;
    }
    
    /**
     * The Txt no msg.
     */
    private final com.contusfly.views.CustomTextView getTxtNoStarredMsg() {
        return null;
    }
    
    /**
     * The View chat.
     */
    private final android.widget.LinearLayout getViewStarredMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.contusfly.di.factory.AppViewModelFactory getDashboardViewModelFactory() {
        return null;
    }
    
    public void setDashboardViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.contusfly.di.factory.AppViewModelFactory p0) {
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getDashboardViewModel() {
        return null;
    }
    
    private final com.contusfly.starredMessages.viewmodel.StarredMessageViewModel getViewModelStarredMessage() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onGroupProfileUpdated(@org.jetbrains.annotations.NotNull()
    java.lang.String groupJid) {
    }
    
    /**
     * To handle broadcast of any user's profile changes
     * like Profile pic, Profile msg
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
    
    private final void setUpToolbar() {
    }
    
    /**
     * Handle the list item click and long click from the recycler view of the chat view.
     */
    private final void handleStarredItemClick() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    private final void initStarredMessageViews() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    private final void setEmptyView(boolean b) {
    }
    
    /**
     * Validate search key for getting message
     *
     * @param filterKey Key to search
     */
    public final void searchStarredMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String filterKey) {
    }
    
    /**
     * Add the message into the search list which are all available from the search key. Search the
     * text in the message list.
     *
     * @param filterKey Key to search
     */
    private final void addSearchedMessagesToList(java.lang.String filterKey) {
    }
    
    private final boolean isVideoCaptionContainsFilterKey(com.mirrorflysdk.api.models.ChatMessage message, java.lang.String filterKey) {
        return false;
    }
    
    private final boolean isImageCaptionContainsFilterKey(com.mirrorflysdk.api.models.ChatMessage message, java.lang.String filterKey) {
        return false;
    }
    
    private final boolean isTextMessageContainsFilterKey(com.mirrorflysdk.api.models.ChatMessage message, java.lang.String filterKey) {
        return false;
    }
    
    private final boolean isMentionUserIdAvailableInMediaMessage(com.mirrorflysdk.api.models.ChatMessage message, java.lang.String filterKey) {
        return false;
    }
    
    private final boolean isMentionUserIdAvailableInMessage(com.mirrorflysdk.api.models.ChatMessage message, java.lang.String filterKey) {
        return false;
    }
    
    @java.lang.Override()
    public void onMessageStatusUpdated(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId) {
    }
    
    @java.lang.Override()
    public void onUpdateUnStarAllMessages() {
    }
    
    private final void initObservers() {
    }
    
    @java.lang.Override()
    public void onUploadDownloadProgressChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId, int progressPercentage) {
    }
    
    private final com.mirrorflysdk.api.models.ChatMessage getMessageByID(java.lang.String messageId) {
        return null;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onMediaStatusUpdated(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    @java.lang.Override()
    public void onMessagesClearedOrDeleted(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> messageIds, @org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    protected void clearActionMenu() {
    }
    
    @java.lang.Override()
    public void onDownloadClicked(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    @java.lang.Override()
    public void onCancelDownloadClicked(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    @java.lang.Override()
    public void onCancelUploadClicked(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    @java.lang.Override()
    public void onRetryClicked(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    @java.lang.Override()
    public void onSenderItemClicked(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override()
    public void onReceiverItemClicked(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Handle media message item click and long press
     *
     * @param position Position of the item in view
     */
    private final void handleStarredMediaMessageClick(int position) {
    }
    
    @java.lang.Override()
    public void onSenderItemLongClick(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Handle On item long click for the options having delete, forward and info. Add into the
     * selected list for the list showing and do the operations
     *
     * @param starredItemPosition Position of the clicked list item
     */
    private final void onItemLongClick(int starredItemPosition) {
    }
    
    @java.lang.Override()
    public void onReceiverItemLongClick(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Handle On item click for the options having delete, forward and info. and remove that from
     * the selected list
     *
     * @param position Position of the item
     */
    private final void onItemClick(int position) {
    }
    
    private final void refreshSelectedMessages(int position) {
    }
    
    /**
     * Call back for on item selection
     *
     * @param clickedMessage Selected message item
     */
    private final void onSelectItem(com.mirrorflysdk.api.models.ChatMessage clickedMessage, int position) {
    }
    
    private final void updateActionMenuIcons(com.mirrorflysdk.flycommons.Features features) {
    }
    
    @java.lang.Override()
    public void onReplyMessageClick(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId) {
    }
    
    @java.lang.Override()
    public void onSenderMediaForward(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override()
    public void onContactClick(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage item, int position, @org.jetbrains.annotations.Nullable()
    java.lang.String registeredJid) {
    }
    
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override()
    public boolean onCreateActionMode(@org.jetbrains.annotations.NotNull()
    android.view.ActionMode actionMode, @org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onPrepareActionMode(@org.jetbrains.annotations.Nullable()
    android.view.ActionMode p0, @org.jetbrains.annotations.Nullable()
    android.view.Menu p1) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onActionItemClicked(@org.jetbrains.annotations.Nullable()
    android.view.ActionMode p0, @org.jetbrains.annotations.Nullable()
    android.view.MenuItem menuItem) {
        return false;
    }
    
    /**
     * On click action boolean of the long press menu.
     *
     * @param itemId The menu item id
     * @return boolean True if click completed
     */
    private final boolean onClickAction(int itemId) {
        return false;
    }
    
    private final void deleteMessageAction() {
    }
    
    private final void deleteMessage() {
    }
    
    /**
     * Set the action menu for the long press menu
     *
     * @param mode Instance of the Alert dialog action mode
     * @param menu Instance of Menu
     */
    private final void configureActionMode(android.view.ActionMode mode, android.view.Menu menu) {
    }
    
    @java.lang.Override()
    public void onDestroyActionMode(@org.jetbrains.annotations.Nullable()
    android.view.ActionMode p0) {
    }
    
    private final void updateAdapter() {
    }
    
    private final void prepareActionMode() {
    }
    
    @java.lang.Override()
    public void onAudioPlayed() {
    }
    
    @java.lang.Override()
    public void mediaPermissionCheck() {
    }
    
    @java.lang.Override()
    public void userBlockedMe(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    public void userUnBlockedMe(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean status) {
    }
    
    @java.lang.Override()
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    private final void updateFeatureRestriction(com.mirrorflysdk.flycommons.Features availableFeatures) {
    }
}