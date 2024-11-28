package com.contusfly.call.groupcall;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [AddParticipantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\u0002\u0082\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020QH\u0002J\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020W0V2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020W0\u0011H\u0002J\u000e\u0010Y\u001a\u00020Q2\u0006\u0010B\u001a\u00020\u0012J\b\u0010Z\u001a\u00020QH\u0002J\u0010\u0010[\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010\\\u001a\u00020QH\u0002J\u001e\u0010]\u001a\u00020Q2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020-J\u0010\u0010a\u001a\u00020Q2\u0006\u0010b\u001a\u00020cH\u0016J\u0012\u0010d\u001a\u00020Q2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J&\u0010g\u001a\u0004\u0018\u00010S2\u0006\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010l\u001a\u00020QH\u0016J\b\u0010m\u001a\u00020QH\u0016J\u0006\u0010n\u001a\u00020QJ\u001a\u0010o\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u000e\u0010p\u001a\u00020Q2\u0006\u0010^\u001a\u00020\u0012J\u0006\u0010q\u001a\u00020QJ\u000e\u0010r\u001a\u00020Q2\u0006\u0010^\u001a\u00020\u0012J\b\u0010s\u001a\u00020QH\u0002J\b\u0010t\u001a\u00020QH\u0002J\b\u0010u\u001a\u00020QH\u0002J\b\u0010v\u001a\u00020QH\u0002J\u0018\u0010w\u001a\u00020Q2\u0006\u0010x\u001a\u0002002\u0006\u0010y\u001a\u00020zH\u0002J\b\u0010{\u001a\u00020QH\u0002J\b\u0010|\u001a\u00020QH\u0002J \u0010}\u001a\u00020Q2\u0006\u0010~\u001a\u00020-2\u0006\u0010^\u001a\u00020\u00122\b\u0010\u007f\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0080\u0001\u001a\u00020Q2\u0007\u0010\u0081\u0001\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b3\u00104R\u000e\u00106\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010%\u001a\u0004\b9\u00104R\u000e\u0010;\u001a\u00020<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010>\u001a\u00020?\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010C\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010JR\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010%\u001a\u0004\bM\u0010N\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/contusfly/call/groupcall/AddParticipantFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "addParticipantsLayout", "Landroid/widget/RelativeLayout;", "addParticipantsTextView", "Landroid/widget/TextView;", "apiCalls", "Lcom/mirrorflysdk/flynetwork/ApiCalls;", "getApiCalls", "()Lcom/mirrorflysdk/flynetwork/ApiCalls;", "setApiCalls", "(Lcom/mirrorflysdk/flynetwork/ApiCalls;)V", "callActionListener", "Lcom/mirrorflysdk/flycall/webrtc/api/CallActionListener;", "callConnectedUserList", "Ljava/util/ArrayList;", "", "callLink", "Landroidx/appcompat/widget/AppCompatTextView;", "callLinkCopyIcon", "Landroid/widget/ImageView;", "callLinkTitleTextView", "callLinkView", "Landroid/widget/LinearLayout;", "callViewModelFactory", "Lcom/contusfly/di/factory/AppViewModelFactory;", "getCallViewModelFactory", "()Lcom/contusfly/di/factory/AppViewModelFactory;", "setCallViewModelFactory", "(Lcom/contusfly/di/factory/AppViewModelFactory;)V", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getCommonAlertDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "commonAlertDialog$delegate", "Lkotlin/Lazy;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "emptyView", "groupId", "isAddUsersToOneToOneCall", "", "isRefreshing", "listContact", "Lcom/contusfly/views/CustomRecyclerView;", "mAdapter", "Lcom/contusfly/call/groupcall/UserSelectionAdapter;", "getMAdapter", "()Lcom/contusfly/call/groupcall/UserSelectionAdapter;", "mAdapter$delegate", "mHandler", "Landroid/os/Handler;", "mSearchAdapter", "getMSearchAdapter", "mSearchAdapter$delegate", "mUserListType", "Lcom/contusfly/helpers/UserListType;", "onGoingCallLink", "onItemClickListener", "Lcom/contusfly/call/groupcall/listeners/RecyclerViewUserItemClick;", "getOnItemClickListener", "()Lcom/contusfly/call/groupcall/listeners/RecyclerViewUserItemClick;", "searchKey", "selectedList", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedUserCount", "getSelectedUserCount", "()Ljava/lang/String;", "viewModel", "Lcom/contusfly/call/groupcall/CallViewModel;", "getViewModel", "()Lcom/contusfly/call/groupcall/CallViewModel;", "viewModel$delegate", "addParticipantButtonAdjustOverKeyboard", "", "view", "Landroid/view/View;", "checkAndInviteUsersToOngoingCall", "filterList", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "profileDetailsList", "filterResult", "getRefreshedProfilesList", "initView", "observeNetworkListener", "onAdminBlockedStatus", "jid", "type", "status", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onResume", "onUserSelectRestriction", "onViewCreated", "refreshUser", "refreshUsersList", "removeUser", "setAdapterBasedOnSearchType", "setContactAdapter", "setListeners", "setObservers", "setScrollListener", "recyclerView", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "setSearchObservers", "setUserListObservers", "updateMemberRemovedOrAddedInUserList", "isUserLeft", "mGroupId", "updateProfileDetails", "userJid", "Companion", "app_debug"})
public final class AddParticipantFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope {
    @javax.inject.Inject
    public com.contusfly.di.factory.AppViewModelFactory callViewModelFactory;
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject
    public com.mirrorflysdk.flynetwork.ApiCalls apiCalls;
    private android.widget.RelativeLayout addParticipantsLayout;
    private android.widget.TextView addParticipantsTextView;
    
    /**
     * Display the contact list and searched list in the recycler view
     */
    private com.contusfly.views.CustomRecyclerView listContact;
    private android.widget.TextView emptyView;
    private java.lang.String onGoingCallLink;
    private android.widget.LinearLayout callLinkView;
    private androidx.appcompat.widget.AppCompatTextView callLink;
    private android.widget.ImageView callLinkCopyIcon;
    private java.lang.String groupId;
    private java.util.ArrayList<java.lang.String> callConnectedUserList;
    private androidx.appcompat.widget.AppCompatTextView callLinkTitleTextView;
    
    /**
     * The handler to delay the search
     */
    private android.os.Handler mHandler;
    
    /**
     * Used for search
     */
    private java.lang.String searchKey;
    private boolean isRefreshing = false;
    private com.contusfly.helpers.UserListType mUserListType = com.contusfly.helpers.UserListType.USER_LIST;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private final kotlin.Lazy commonAlertDialog$delegate = null;
    
    /**
     * Validate if the call is one to one call
     */
    private boolean isAddUsersToOneToOneCall = false;
    
    /**
     * Selected users from the search list.
     */
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<java.lang.String> selectedList;
    private final kotlin.Lazy mAdapter$delegate = null;
    private final kotlin.Lazy mSearchAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final com.contusfly.call.groupcall.listeners.RecyclerViewUserItemClick onItemClickListener = null;
    
    /**
     * call action listener to listen for invite user list call back
     */
    private com.mirrorflysdk.flycall.webrtc.api.CallActionListener callActionListener;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.call.groupcall.AddParticipantFragment.Companion Companion = null;
    
    /**
     * key constant for add user for existing call action
     */
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ADD_USERS_TO_ONE_TO_ONE_CALL = "add_users_to_one_to_one_call";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CONNECTED_USER_LIST = "connected_user_list";
    private java.util.HashMap _$_findViewCache;
    
    public AddParticipantFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.di.factory.AppViewModelFactory getCallViewModelFactory() {
        return null;
    }
    
    public final void setCallViewModelFactory(@org.jetbrains.annotations.NotNull
    com.contusfly.di.factory.AppViewModelFactory p0) {
    }
    
    private final com.contusfly.call.groupcall.CallViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.flynetwork.ApiCalls getApiCalls() {
        return null;
    }
    
    public final void setApiCalls(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flynetwork.ApiCalls p0) {
    }
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private final com.contusfly.views.CommonAlertDialog getCommonAlertDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getSelectedList() {
        return null;
    }
    
    public final void setSelectedList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    private final com.contusfly.call.groupcall.UserSelectionAdapter getMAdapter() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.UserSelectionAdapter getMSearchAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.call.groupcall.listeners.RecyclerViewUserItemClick getOnItemClickListener() {
        return null;
    }
    
    private final java.lang.String getSelectedUserCount() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onDetach() {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setObservers() {
    }
    
    private final void setUserListObservers() {
    }
    
    private final void setSearchObservers() {
    }
    
    private final void observeNetworkListener() {
    }
    
    private final void initView(android.view.View view) {
    }
    
    /**
     * for below android 10 versions keypad is not adjusted.
     */
    private final void addParticipantButtonAdjustOverKeyboard(android.view.View view) {
    }
    
    private final void setContactAdapter() {
    }
    
    private final void setScrollListener(com.contusfly.views.CustomRecyclerView recyclerView, androidx.recyclerview.widget.LinearLayoutManager layoutManager) {
    }
    
    private final void setListeners() {
    }
    
    private final void checkAndInviteUsersToOngoingCall() {
    }
    
    public final void onUserSelectRestriction() {
    }
    
    public final void refreshUsersList() {
    }
    
    public final void refreshUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    public final void removeUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    public final void onAdminBlockedStatus(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    private final void getRefreshedProfilesList() {
    }
    
    public final void filterResult(@org.jetbrains.annotations.NotNull
    java.lang.String searchKey) {
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> filterList(java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> profileDetailsList) {
        return null;
    }
    
    private final void setAdapterBasedOnSearchType() {
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object, with the
     * specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.contusfly.call.groupcall.AddParticipantFragment newInstance(@org.jetbrains.annotations.Nullable
    java.lang.String groupId, boolean isOneToOneCall, @org.jetbrains.annotations.Nullable
    java.util.ArrayList<java.lang.String> callUsersList, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.flycall.webrtc.api.CallActionListener callActionListener) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    private final void updateProfileDetails(java.lang.String userJid) {
    }
    
    public final void updateMemberRemovedOrAddedInUserList(boolean isUserLeft, @org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.Nullable
    java.lang.String mGroupId) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J4\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/call/groupcall/AddParticipantFragment$Companion;", "", "()V", "ADD_USERS_TO_ONE_TO_ONE_CALL", "", "CONNECTED_USER_LIST", "newInstance", "Lcom/contusfly/call/groupcall/AddParticipantFragment;", "groupId", "isOneToOneCall", "", "callUsersList", "Ljava/util/ArrayList;", "callActionListener", "Lcom/mirrorflysdk/flycall/webrtc/api/CallActionListener;", "app_debug"})
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
        public final com.contusfly.call.groupcall.AddParticipantFragment newInstance(@org.jetbrains.annotations.Nullable
        java.lang.String groupId, boolean isOneToOneCall, @org.jetbrains.annotations.Nullable
        java.util.ArrayList<java.lang.String> callUsersList, @org.jetbrains.annotations.Nullable
        com.mirrorflysdk.flycall.webrtc.api.CallActionListener callActionListener) {
            return null;
        }
    }
}