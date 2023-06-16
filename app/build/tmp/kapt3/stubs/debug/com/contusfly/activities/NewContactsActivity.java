package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020#H\u0002J \u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\nH\u0016J\u0012\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0012\u0010/\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\nH\u0016J\u0012\u00104\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u00105\u001a\u00020#H\u0014J\u0010\u00106\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\nH\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\u0010\u0010<\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010=\u001a\u00020#H\u0002J\b\u0010>\u001a\u00020#H\u0002J\u0012\u0010?\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010@\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0010\u0010A\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010B\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0005H\u0016J\b\u0010C\u001a\u00020#H\u0014J\u0010\u0010D\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010E\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006F"}, d2 = {"Lcom/contusfly/activities/NewContactsActivity;", "Lcom/contusfly/activities/parent/BaseContactActivity;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "callType", "", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "groupId", "isMakeCall", "", "mAdapter", "Lcom/contusfly/adapters/ContactsAdapter;", "newContactsBinding", "Lcom/contusfly/databinding/ActivityNewContactsBinding;", "screenTitle", "searchKey", "users", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "Lkotlin/collections/ArrayList;", "getUsers", "()Ljava/util/ArrayList;", "setUsers", "(Ljava/util/ArrayList;)V", "viewModel", "Lcom/contusfly/viewmodels/ContactViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/ContactViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "closeMenuOption", "menu", "Landroid/view/Menu;", "initViews", "", "listOptionSelected", "position", "", "makeCall", "onAdminBlockedOtherUser", "jid", "type", "status", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onPostCreate", "onResume", "removeUserProfile", "retrievedSelectedProfilesState", "setEmptyView", "b", "setObservers", "setUpToolBar", "showMenuOption", "startDashboardActivity", "updateContactsList", "updateSelectedUserCallView", "updateUserProfileInfo", "userBlockedMe", "userDeletedHisProfile", "userDetailsUpdated", "userUnBlockedMe", "userUpdatedHisProfile", "app_debug"})
public final class NewContactsActivity extends com.contusfly.activities.parent.BaseContactActivity implements com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> users;
    private com.contusfly.databinding.ActivityNewContactsBinding newContactsBinding;
    private com.contusfly.adapters.ContactsAdapter mAdapter;
    private boolean isMakeCall = false;
    private java.lang.String callType;
    private java.lang.String screenTitle;
    
    /**
     * Used for search
     */
    private java.lang.String searchKey;
    private java.lang.String groupId;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public NewContactsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getUsers() {
        return null;
    }
    
    public final void setUsers(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> p0) {
    }
    
    private final com.contusfly.viewmodels.ContactViewModel getViewModel() {
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
    
    private final void setEmptyView(boolean b) {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean showMenuOption(android.view.Menu menu) {
        return false;
    }
    
    private final boolean closeMenuOption(android.view.Menu menu) {
        return false;
    }
    
    private final void setUpToolBar() {
    }
    
    private final void initViews() {
    }
    
    private final void makeCall() {
    }
    
    private final void setObservers() {
    }
    
    private final void retrievedSelectedProfilesState() {
    }
    
    private final void updateContactsList() {
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
    
    private final void removeUserProfile(java.lang.String jid) {
    }
    
    @java.lang.Override()
    protected void userDetailsUpdated() {
    }
    
    @java.lang.Override()
    public void userBlockedMe(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    public void userUnBlockedMe(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    private final void updateUserProfileInfo(java.lang.String jid) {
    }
    
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean status) {
    }
    
    private final void startDashboardActivity() {
    }
}