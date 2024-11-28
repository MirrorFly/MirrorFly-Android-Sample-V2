package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0002J\u0018\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\bH\u0002J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u000208H\u0014J\u0010\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010D\u001a\u0002082\u0006\u0010E\u001a\u00020\'H\u0002J\b\u0010F\u001a\u000208H\u0002J\u0010\u0010G\u001a\u0002082\u0006\u0010E\u001a\u00020\'H\u0002J\b\u0010H\u001a\u000208H\u0002J\u0018\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\'H\u0002J\u0010\u0010K\u001a\u0002082\u0006\u0010L\u001a\u00020<H\u0016J\b\u0010M\u001a\u000208H\u0002J\b\u0010N\u001a\u000208H\u0002J \u0010O\u001a\u0002082\u0006\u0010=\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u0006H\u0016J\u0010\u0010R\u001a\u0002082\u0006\u0010S\u001a\u00020\u0006H\u0016J\u0012\u0010T\u001a\u0002082\b\u0010U\u001a\u0004\u0018\u00010VH\u0014J\u0012\u0010W\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001a\u0010X\u001a\u0002082\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010S\u001a\u00020\u0006H\u0016J\u0010\u0010[\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u000208H\u0014J\u0010\u0010_\u001a\u0002082\u0006\u0010E\u001a\u00020\'H\u0002J\b\u0010`\u001a\u000208H\u0002J\u0010\u0010a\u001a\u0002082\u0006\u0010=\u001a\u00020\bH\u0002J\b\u0010b\u001a\u000208H\u0002J\b\u0010c\u001a\u000208H\u0002J\u0010\u0010d\u001a\u0002082\u0006\u0010e\u001a\u00020\u0006H\u0002J\b\u0010f\u001a\u000208H\u0002J\b\u0010g\u001a\u000208H\u0002J\b\u0010h\u001a\u000208H\u0002J\b\u0010i\u001a\u000208H\u0002J\u0010\u0010j\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010k\u001a\u000208H\u0002J\b\u0010l\u001a\u000208H\u0002J\u0014\u0010m\u001a\u0002082\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010n\u001a\u0002082\u0006\u0010=\u001a\u00020\bH\u0002J\u0010\u0010o\u001a\u0002082\u0006\u0010=\u001a\u00020\bH\u0016J\u0010\u0010p\u001a\u0002082\u0006\u0010=\u001a\u00020\bH\u0016J\b\u0010q\u001a\u000208H\u0014J\u0010\u0010r\u001a\u0002082\u0006\u0010=\u001a\u00020\bH\u0016J\u0010\u0010s\u001a\u0002082\u0006\u0010=\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\'\u0018\u00010,j\n\u0012\u0004\u0012\u00020\'\u0018\u0001`-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b4\u00105\u00a8\u0006t"}, d2 = {"Lcom/contusfly/activities/NewContactsActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "addParticipants", "", "callType", "", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "contactPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dialogFragment", "Lcom/contusfly/fragments/ProfileDialogFragment;", "fromGroupInfo", "groupId", "isMakeCall", "lastClickTime", "", "mAdapter", "Lcom/contusfly/adapters/ContactsAdapter;", "multiSelection", "myActivityResultLauncher", "Landroid/content/Intent;", "newContactsBinding", "Lcom/contusfly/databinding/ActivityNewContactsBinding;", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "profiledetails", "screenTitle", "searchKey", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getUsers", "()Ljava/util/ArrayList;", "setUsers", "(Ljava/util/ArrayList;)V", "viewModel", "Lcom/contusfly/viewmodels/ContactViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/ContactViewModel;", "viewModel$delegate", "checkContactPermission", "", "checkContactPermissionAndSync", "checkWhenUserIndexIsValid", "userIndex", "", "jid", "closeMenuOption", "menu", "Landroid/view/Menu;", "emailContactSyncCompleted", "finishContactSync", "success", "handleMultiSelection", "profile", "initViews", "launchChatPage", "launchPinActivity", "listItemClicked", "profileClicked", "listOptionSelected", "position", "makeCall", "observeContactSyncStatus", "onAdminBlockedOtherUser", "type", "status", "onContactSyncComplete", "isSuccess", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "privateChatUserChecking", "refreshContacts", "removeUserProfile", "retrievedSelectedProfilesState", "setContactSyncObservers", "setEmptyView", "b", "setListeners", "setObservers", "setRefreshContacts", "setUpToolBar", "showMenuOption", "startDashboardActivity", "updateContactsList", "updateSelectedUserCallView", "updateUserProfileInfo", "userBlockedMe", "userDeletedHisProfile", "userDetailsUpdated", "userUnBlockedMe", "userUpdatedHisProfile", "app_debug"})
public final class NewContactsActivity extends com.contusfly.activities.BaseActivity implements kotlinx.coroutines.CoroutineScope, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> users;
    private com.contusfly.databinding.ActivityNewContactsBinding newContactsBinding;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private com.contusfly.adapters.ContactsAdapter mAdapter;
    private boolean multiSelection = false;
    private boolean isMakeCall = false;
    private java.lang.String callType;
    private boolean addParticipants = false;
    private boolean fromGroupInfo = false;
    private java.lang.String screenTitle;
    
    /**
     * Used for search
     */
    private java.lang.String searchKey;
    
    /**
     * Store onclick time to avoid double click
     */
    private long lastClickTime = 0L;
    private java.lang.String groupId;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    private com.mirrorflysdk.api.contacts.ProfileDetails profileDetails;
    private com.contusfly.fragments.ProfileDialogFragment dialogFragment;
    private final kotlin.Lazy viewModel$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> contactPermissionLauncher = null;
    private com.mirrorflysdk.api.contacts.ProfileDetails profiledetails;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> myActivityResultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public NewContactsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getUsers() {
        return null;
    }
    
    public final void setUsers(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    private final com.contusfly.viewmodels.ContactViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
    
    private final void setEmptyView(boolean b) {
    }
    
    private final boolean showMenuOption(android.view.Menu menu) {
        return false;
    }
    
    private final boolean closeMenuOption(android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setUpToolBar() {
    }
    
    private final void initViews() {
    }
    
    private final void makeCall() {
    }
    
    private final void setRefreshContacts() {
    }
    
    private final void setListeners() {
    }
    
    private final void setObservers() {
    }
    
    private final void retrievedSelectedProfilesState() {
    }
    
    private final void observeContactSyncStatus() {
    }
    
    private final void updateContactsList() {
    }
    
    private final void listItemClicked(boolean profileClicked, com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    private final void privateChatUserChecking(com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    private final void launchChatPage(com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    private final void launchPinActivity() {
    }
    
    private final void handleMultiSelection(com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    private final void updateSelectedUserCallView(java.lang.String jid) {
    }
    
    @java.lang.Override
    protected void userDetailsUpdated() {
    }
    
    @java.lang.Override
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    /**
     * To handle callback of any user's profile deleted
     */
    @java.lang.Override
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void removeUserProfile(java.lang.String jid) {
    }
    
    @java.lang.Override
    public void userBlockedMe(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    @java.lang.Override
    public void userUnBlockedMe(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void checkWhenUserIndexIsValid(int userIndex, java.lang.String jid) {
    }
    
    private final void updateUserProfileInfo(java.lang.String jid) {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void checkContactPermission() {
    }
    
    private final void setContactSyncObservers() {
    }
    
    private final void checkContactPermissionAndSync() {
    }
    
    private final void refreshContacts() {
    }
    
    @java.lang.Override
    public void onContactSyncComplete(boolean isSuccess) {
    }
    
    private final void finishContactSync(boolean success) {
    }
    
    @java.lang.Override
    protected void emailContactSyncCompleted() {
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    private final void startDashboardActivity() {
    }
}