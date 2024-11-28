package com.contusfly.call.calllog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020QH\u0002J\b\u0010S\u001a\u00020QH\u0002J\b\u0010T\u001a\u00020QH\u0002J\u0006\u0010U\u001a\u00020QJ\u0010\u0010V\u001a\u00020Q2\u0006\u0010W\u001a\u00020\u001dH\u0002J\u001e\u0010X\u001a\b\u0012\u0004\u0012\u00020?0Y2\u0006\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020+H\u0002J\u001a\u0010\\\u001a\u00020Q2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010a\u001a\u00020Q2\u0006\u0010_\u001a\u00020`H\u0002J\b\u0010b\u001a\u00020QH\u0002J\u0010\u0010c\u001a\u00020+2\u0006\u0010d\u001a\u00020?H\u0002J\b\u0010e\u001a\u00020QH\u0002J\u0010\u0010f\u001a\u00020Q2\u0006\u0010-\u001a\u00020\u001dH\u0002J\u0010\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u001dH\u0002J\u0010\u0010i\u001a\u00020Q2\u0006\u0010j\u001a\u00020+H\u0002J\b\u0010k\u001a\u00020QH\u0002J\u0010\u0010l\u001a\u00020Q2\u0006\u0010_\u001a\u00020`H\u0016J8\u0010m\u001a\u00020Q2\u0006\u0010n\u001a\u00020\u001d2\b\u0010o\u001a\u0004\u0018\u00010\u001d2\u0006\u0010p\u001a\u00020+2\u0006\u0010c\u001a\u00020+2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001d0>H\u0002J*\u0010r\u001a\u00020Q2\u0006\u0010Z\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020?2\b\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010u\u001a\u00020+H\u0002J\b\u0010v\u001a\u00020QH\u0002J\b\u0010w\u001a\u00020QH\u0002J\u0010\u0010x\u001a\u00020Q2\u0006\u0010y\u001a\u00020\u001dH\u0002J\u0016\u0010z\u001a\u00020Q2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020?0YH\u0002J\b\u0010|\u001a\u00020QH\u0016J\u0010\u0010}\u001a\u00020Q2\u0006\u0010~\u001a\u00020\u007fH\u0016J+\u0010\u0080\u0001\u001a\u00020^2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\t\u0010\u0087\u0001\u001a\u00020QH\u0016J\u001e\u0010\u0088\u0001\u001a\u00020Q2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010\u008b\u0001\u001a\u00020+H\u0016J\u001d\u0010\u008c\u0001\u001a\u00020Q2\u0006\u0010]\u001a\u00020^2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u001b\u0010\u008d\u0001\u001a\u00020Q2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`H\u0002J%\u0010\u008e\u0001\u001a\u00020Q2\u0006\u0010d\u001a\u00020?2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010h\u001a\u0004\u0018\u00010\u001dH\u0002J\u001b\u0010\u008f\u0001\u001a\u00020Q2\u0006\u0010d\u001a\u00020?2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0011\u0010\u0090\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u001dH\u0002J\t\u0010\u0091\u0001\u001a\u00020QH\u0002J\t\u0010\u0092\u0001\u001a\u00020QH\u0002J\u0011\u0010\u0093\u0001\u001a\u00020Q2\u0006\u0010_\u001a\u00020`H\u0002J\t\u0010\u0094\u0001\u001a\u00020QH\u0002J\t\u0010\u0095\u0001\u001a\u00020QH\u0002J\t\u0010\u0096\u0001\u001a\u00020QH\u0002J\t\u0010\u0097\u0001\u001a\u00020QH\u0002J\t\u0010\u0098\u0001\u001a\u00020QH\u0002J\t\u0010\u0099\u0001\u001a\u00020QH\u0002J\t\u0010\u009a\u0001\u001a\u00020QH\u0002J\u0013\u0010\u009b\u0001\u001a\u00020Q2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J\u000f\u0010\u009e\u0001\u001a\u00020Q2\u0006\u0010*\u001a\u00020+J\u0012\u0010\u009f\u0001\u001a\u00020Q2\u0007\u0010\u00a0\u0001\u001a\u00020\u001dH\u0002J\u001b\u0010\u00a1\u0001\u001a\u00020Q2\u0007\u0010\u00a2\u0001\u001a\u00020`2\u0007\u0010\u00a3\u0001\u001a\u00020+H\u0002J\t\u0010\u00a4\u0001\u001a\u00020QH\u0002J\t\u0010\u00a5\u0001\u001a\u00020QH\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010\'\u001a\u0004\b:\u0010;R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010\'\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010\'\u001a\u0004\bM\u0010N\u00a8\u0006\u00a6\u0001"}, d2 = {"Lcom/contusfly/call/calllog/CallHistoryFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Lcom/mirrorflysdk/flycall/webrtc/api/CallLogManager$CallLogActionListener;", "()V", "apiCalls", "Lcom/mirrorflysdk/flynetwork/ApiCalls;", "getApiCalls", "()Lcom/mirrorflysdk/flynetwork/ApiCalls;", "setApiCalls", "(Lcom/mirrorflysdk/flynetwork/ApiCalls;)V", "callActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "callHistoryBinding", "Lcom/contusfly/databinding/FragmentCallHistoryBinding;", "callLogsViewModelFactory", "Lcom/contusfly/di/factory/AppViewModelFactory;", "getCallLogsViewModelFactory", "()Lcom/contusfly/di/factory/AppViewModelFactory;", "setCallLogsViewModelFactory", "(Lcom/contusfly/di/factory/AppViewModelFactory;)V", "callPermissionUtils", "Lcom/contusfly/call/CallPermissionUtils;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "contactPermissionLauncher", "", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dashBoardViewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getDashBoardViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "dashBoardViewModel$delegate", "Lkotlin/Lazy;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "isClearAll", "", "isDeleteCallLogInitiated", "lastCallAction", "launchIntent", "kotlin.jvm.PlatformType", "listener", "Lcom/contusfly/call/calllog/CallHistoryAdapter$OnItemClickListener;", "mAdapter", "Lcom/contusfly/call/calllog/CallHistoryAdapter;", "mCallLogsType", "Lcom/contusfly/call/calllog/CallLogsType;", "mHandler", "Landroid/os/Handler;", "mSearchAdapter", "Lcom/contusfly/call/calllog/CallHistorySearchAdapter;", "getMSearchAdapter", "()Lcom/contusfly/call/calllog/CallHistorySearchAdapter;", "mSearchAdapter$delegate", "mSearchCallLogs", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/flycall/call/database/model/CallLog;", "myActivityResultLauncher", "notificationPermissionLauncher", "openContactsActivity", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "requestCallPermissions", "searchKeyword", "toUserJid", "viewModel", "Lcom/contusfly/call/calllog/CallLogViewModel;", "getViewModel", "()Lcom/contusfly/call/calllog/CallLogViewModel;", "viewModel$delegate", "callLogListener", "", "checkPermissionAndSelectParticipant", "clearCallLogNotify", "clearCallLogObserver", "clearSelectedMessages", "doSearch", "searchKey", "getIndicesOfUserInCallLog", "", "jid", "isFromAdminBlock", "handleOnItemClicked", "view", "Landroid/view/View;", "position", "", "handleOnItemLongClicked", "initView", "isAdminBlocked", "callLog", "launchAudioCall", "launchCall", "launchChatPage", "toUser", "launchPinActivity", "isChatPage", "launchVideoCall", "listOptionSelected", "makeCall", "callType", "groupId", "isBlocked", "jidList", "makeJanusCall", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "isGroupCall", "notificationPermissionChecking", "notifyAdapterOfDeletedCallLog", "notifyProfileUpdate", "userJid", "observeFilteredCallLogs", "callLogs", "onActionSuccess", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onViewCreated", "openChatView", "openDirectChatView", "openGroupChatView", "privateChatUserChecking", "profileUpdateObserver", "selectParticipants", "selectUnselectPayload", "setAdapterBasedOnSearchType", "setClickListenerForAudioCall", "setClickListenerForCreateCallLink", "setClickListenerForVideoCall", "setListeners", "setObservers", "setPaginationObservers", "setScrollListener", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "showClearAlertDialog", "showCreateMeetLinkDialog", "meetLink", "startActionModeChange", "size", "status", "unSelectCallLogs", "updateCallLogSearch", "app_debug"})
public final class CallHistoryFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, com.mirrorflysdk.flycall.webrtc.api.CallLogManager.CallLogActionListener {
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    private java.lang.String lastCallAction = "";
    private final android.os.Handler mHandler = null;
    @javax.inject.Inject
    public com.mirrorflysdk.flynetwork.ApiCalls apiCalls;
    private com.contusfly.databinding.FragmentCallHistoryBinding callHistoryBinding;
    private java.util.ArrayList<com.mirrorflysdk.flycall.call.database.model.CallLog> mSearchCallLogs;
    private com.contusfly.call.calllog.CallHistoryAdapter mAdapter;
    private final kotlin.Lazy mSearchAdapter$delegate = null;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    private com.contusfly.call.calllog.CallLogsType mCallLogsType = com.contusfly.call.calllog.CallLogsType.NORMAL;
    private java.lang.String searchKeyword = "";
    
    /**
     * Boolean to verify whether the entire call log history has to be deleted.
     */
    private boolean isClearAll = false;
    private boolean isDeleteCallLogInitiated = false;
    private com.contusfly.call.CallPermissionUtils callPermissionUtils;
    @javax.inject.Inject
    public com.contusfly.di.factory.AppViewModelFactory callLogsViewModelFactory;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> contactPermissionLauncher = null;
    private final kotlin.Lazy dashBoardViewModel$delegate = null;
    private com.contusfly.call.calllog.CallHistoryAdapter.OnItemClickListener listener;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestCallPermissions = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> openContactsActivity;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> launchIntent = null;
    private java.lang.String toUserJid = "";
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> myActivityResultLauncher;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> callActivityResultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public CallHistoryFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.flynetwork.ApiCalls getApiCalls() {
        return null;
    }
    
    public final void setApiCalls(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flynetwork.ApiCalls p0) {
    }
    
    private final com.contusfly.call.calllog.CallHistorySearchAdapter getMSearchAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.di.factory.AppViewModelFactory getCallLogsViewModelFactory() {
        return null;
    }
    
    public final void setCallLogsViewModelFactory(@org.jetbrains.annotations.NotNull
    com.contusfly.di.factory.AppViewModelFactory p0) {
    }
    
    private final com.contusfly.call.calllog.CallLogViewModel getViewModel() {
        return null;
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getDashBoardViewModel() {
        return null;
    }
    
    private final void launchAudioCall() {
    }
    
    private final void launchCall(java.lang.String lastCallAction) {
    }
    
    private final void launchVideoCall() {
    }
    
    private final void notificationPermissionChecking() {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
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
    
    private final void initView() {
    }
    
    private final void setClickListenerForAudioCall() {
    }
    
    private final void setClickListenerForVideoCall() {
    }
    
    private final void setClickListenerForCreateCallLink() {
    }
    
    private final void checkPermissionAndSelectParticipant() {
    }
    
    private final void selectParticipants() {
    }
    
    private final void callLogListener() {
    }
    
    private final void updateCallLogSearch() {
    }
    
    private final void setScrollListener(androidx.recyclerview.widget.LinearLayoutManager layoutManager) {
    }
    
    private final void setObservers() {
    }
    
    private final void clearCallLogObserver() {
    }
    
    private final void setPaginationObservers() {
    }
    
    private final void clearCallLogNotify() {
    }
    
    private final void profileUpdateObserver() {
    }
    
    private final void notifyProfileUpdate(java.lang.String userJid) {
    }
    
    private final void doSearch(java.lang.String searchKey) {
    }
    
    private final void observeFilteredCallLogs(java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog> callLogs) {
    }
    
    private final void setAdapterBasedOnSearchType() {
    }
    
    private final java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog> getIndicesOfUserInCallLog(java.lang.String jid, boolean isFromAdminBlock) {
        return null;
    }
    
    private final void setListeners() {
    }
    
    private final void selectUnselectPayload(int position) {
    }
    
    private final void handleOnItemClicked(android.view.View view, int position) {
    }
    
    private final void handleOnItemLongClicked(int position) {
    }
    
    private final void openChatView(android.view.View view, int position) {
    }
    
    private final void openDirectChatView(com.mirrorflysdk.flycall.call.database.model.CallLog callLog, android.view.View view, java.lang.String toUser) {
    }
    
    private final void launchChatPage(java.lang.String toUser) {
    }
    
    private final void privateChatUserChecking(java.lang.String toUser) {
    }
    
    private final void launchPinActivity(boolean isChatPage) {
    }
    
    private final void makeJanusCall(java.lang.String jid, com.mirrorflysdk.flycall.call.database.model.CallLog callLog, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, boolean isGroupCall) {
    }
    
    private final void openGroupChatView(com.mirrorflysdk.flycall.call.database.model.CallLog callLog, android.view.View view) {
    }
    
    private final boolean isAdminBlocked(com.mirrorflysdk.flycall.call.database.model.CallLog callLog) {
        return false;
    }
    
    /**
     * Starts the call activity based on the call icon click action.
     *
     * @param callType the call type object in the adapter data set.
     */
    private final void makeCall(java.lang.String callType, java.lang.String groupId, boolean isBlocked, boolean isAdminBlocked, java.util.ArrayList<java.lang.String> jidList) {
    }
    
    /**
     * Displays an alert dialog to get the confirmation from the user to clear
     * either the selected entry or the entire call log history.
     *
     * @param isClearAll true if the entire call log history has to be deleted.
     */
    public final void showClearAlertDialog(boolean isClearAll) {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    public void onActionSuccess() {
    }
    
    private final void startActionModeChange(int size, boolean status) {
    }
    
    private final void notifyAdapterOfDeletedCallLog() {
    }
    
    public final void clearSelectedMessages() {
    }
    
    private final void unSelectCallLogs() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    private final void showCreateMeetLinkDialog(java.lang.String meetLink) {
    }
}