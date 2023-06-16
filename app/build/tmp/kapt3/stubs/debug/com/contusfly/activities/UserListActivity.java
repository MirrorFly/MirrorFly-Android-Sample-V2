package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J \u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000bH\u0016J\u0012\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u0012\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0006\u0010+\u001a\u00020\u001eJ\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\u0018\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0002J\b\u00105\u001a\u00020\u001eH\u0002J\b\u00106\u001a\u00020\u001eH\u0002J\b\u00107\u001a\u00020\u001eH\u0002J\u0012\u00108\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010:\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010;\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006="}, d2 = {"Lcom/contusfly/activities/UserListActivity;", "Lcom/contusfly/activities/parent/BaseContactActivity;", "()V", "callType", "", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "contactHelperListener", "Lcom/contusfly/interfaces/ContactHelperListener;", "groupId", "isMakeCall", "", "mAdapter", "Lcom/contusfly/adapters/UserListAdapter;", "mHandler", "Landroid/os/Handler;", "mSearchAdapter", "mUserListType", "Lcom/contusfly/helpers/UserListType;", "screenTitle", "searchKey", "userListBinding", "Lcom/contusfly/databinding/ActivityUserListBinding;", "viewModel", "Lcom/contusfly/viewmodels/UserListViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/UserListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "handleIntentValues", "", "initViews", "observeNetworkListener", "onAdminBlockedOtherUser", "jid", "type", "status", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "setAdapterBasedOnSearchType", "setEmptyView", "b", "setObservers", "setScrollListener", "recyclerView", "Lcom/contusfly/views/CustomRecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "setUpActionItems", "setUpToolBar", "setUpViews", "startDashboardActivity", "updateSelectedUserCallView", "userBlockedMe", "userDeletedHisProfile", "userUnBlockedMe", "userUpdatedHisProfile", "app_debug"})
public final class UserListActivity extends com.contusfly.activities.parent.BaseContactActivity {
    private com.contusfly.databinding.ActivityUserListBinding userListBinding;
    private java.lang.String screenTitle;
    private boolean isMakeCall = false;
    private java.lang.String callType;
    private java.lang.String groupId;
    
    /**
     * The handler to delay the search
     */
    private android.os.Handler mHandler;
    
    /**
     * Used for search
     */
    private java.lang.String searchKey;
    private com.contusfly.adapters.UserListAdapter mAdapter;
    private com.contusfly.adapters.UserListAdapter mSearchAdapter;
    private com.contusfly.helpers.UserListType mUserListType = com.contusfly.helpers.UserListType.USER_LIST;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    private final kotlin.Lazy viewModel$delegate = null;
    private final com.contusfly.interfaces.ContactHelperListener contactHelperListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public UserListActivity() {
        super();
    }
    
    private final com.contusfly.viewmodels.UserListViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    private final void setUpActionItems(android.view.Menu menu) {
    }
    
    public final void setAdapterBasedOnSearchType() {
    }
    
    private final void handleIntentValues() {
    }
    
    private final void initViews() {
    }
    
    private final void setUpToolBar() {
    }
    
    private final void setUpViews() {
    }
    
    private final void setScrollListener(com.contusfly.views.CustomRecyclerView recyclerView, androidx.recyclerview.widget.LinearLayoutManager layoutManager) {
    }
    
    private final void setObservers() {
    }
    
    private final void observeNetworkListener() {
    }
    
    private final void setEmptyView(boolean b) {
    }
    
    @java.lang.Override()
    public void updateSelectedUserCallView(@org.jetbrains.annotations.Nullable()
    java.lang.String jid) {
    }
    
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
    
    private final void startDashboardActivity() {
    }
}