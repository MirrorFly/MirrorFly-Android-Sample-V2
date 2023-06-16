package com.contusfly.call.groupcall;

import java.lang.System;

/**
 * This class used to display the list of contacts from selected group in the Recycler view with
 * multi select option and then choose the list to the create group audio/video call.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 3.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020SH\u0002J\u0016\u0010U\u001a\u00020S2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001f0>H\u0002J\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0FH\u0002J\b\u0010X\u001a\u00020SH\u0002J\b\u0010Y\u001a\u00020SH\u0002J\u0010\u0010Z\u001a\u00020S2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020SH\u0002J\b\u0010^\u001a\u00020SH\u0002J \u0010_\u001a\u00020S2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\u000f2\u0006\u0010b\u001a\u00020$H\u0016J\u0010\u0010c\u001a\u00020S2\u0006\u0010d\u001a\u00020eH\u0016J\u0012\u0010f\u001a\u00020S2\b\u0010g\u001a\u0004\u0018\u00010hH\u0014J\u0012\u0010i\u001a\u00020$2\b\u0010j\u001a\u0004\u0018\u00010kH\u0016J\u001a\u0010l\u001a\u00020S2\b\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010o\u001a\u00020$H\u0016J\u0012\u0010p\u001a\u00020S2\b\u0010g\u001a\u0004\u0018\u00010hH\u0014J\b\u0010q\u001a\u00020SH\u0014J\u0006\u0010r\u001a\u00020SJ\b\u0010s\u001a\u00020SH\u0002J\b\u0010t\u001a\u00020SH\u0002J\u0016\u0010u\u001a\u00020S2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0>H\u0002J\u0010\u0010v\u001a\u00020S2\u0006\u0010`\u001a\u00020\u000fH\u0016J\u0010\u0010w\u001a\u00020S2\u0006\u0010`\u001a\u00020\u000fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\'\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\n\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010.\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u000f0\u000f000/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u00102\u001a\u000203\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010\n\u001a\u0004\b8\u00109R\u000e\u0010;\u001a\u00020<X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f000/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR*\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\u000f0Fj\b\u0012\u0004\u0012\u00020\u000f`OX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010H\"\u0004\bQ\u0010J\u00a8\u0006x"}, d2 = {"Lcom/contusfly/call/groupcall/UsersSelectionActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "adapterSearchUsers", "Lcom/contusfly/call/groupcall/UserSelectionAdapter;", "getAdapterSearchUsers", "()Lcom/contusfly/call/groupcall/UserSelectionAdapter;", "adapterSearchUsers$delegate", "Lkotlin/Lazy;", "adapterUsers", "getAdapterUsers", "adapterUsers$delegate", "blockedUserJid", "", "callNowIcon", "Landroid/widget/ImageView;", "callNowLayout", "Landroid/widget/RelativeLayout;", "callNowTextView", "Landroid/widget/TextView;", "callPermissionUtils", "Lcom/contusfly/call/CallPermissionUtils;", "getCallPermissionUtils", "()Lcom/contusfly/call/CallPermissionUtils;", "setCallPermissionUtils", "(Lcom/contusfly/call/CallPermissionUtils;)V", "callType", "contusProfilesWithBlockedMe", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "groupJid", "handler", "Landroid/os/Handler;", "isUnblockRequested", "", "listRosters", "Lcom/contusfly/views/CustomRecyclerView;", "mDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getMDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "mDialog$delegate", "mUserListType", "Lcom/contusfly/helpers/UserListType;", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "onItemClickListener", "Lcom/contusfly/call/groupcall/listeners/RecyclerViewUserItemClick;", "getOnItemClickListener", "()Lcom/contusfly/call/groupcall/listeners/RecyclerViewUserItemClick;", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "permissionDeniedListener", "Lcom/contusfly/interfaces/PermissionDialogListener;", "profileDetailsList", "", "progressDialog", "Landroid/app/ProgressDialog;", "requestCallPermissions", "searchKey", "Landroidx/appcompat/widget/SearchView;", "searchString", "selectedList", "Ljava/util/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedUserCount", "getSelectedUserCount", "()Ljava/lang/String;", "selectedUsersList", "Lkotlin/collections/ArrayList;", "getSelectedUsersList", "setSelectedUsersList", "checkCallIcon", "", "checkTypeAndCall", "filterGroupMembers", "groupMembers", "filterList", "launchAudioCall", "launchVideoCall", "listOptionSelected", "position", "", "makeCall", "notificationPermissionChecking", "onAdminBlockedOtherUser", "jid", "type", "status", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onPostCreate", "onResume", "onUserSelectRestriction", "setAdapterBasedOnSearchType", "updateGroupMembersList", "updateSelectionAdapter", "userDeletedHisProfile", "userUpdatedHisProfile", "app_debug"})
public final class UsersSelectionActivity extends com.contusfly.activities.BaseActivity implements android.view.View.OnClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private com.contusfly.views.CustomRecyclerView listRosters;
    private android.widget.TextView callNowTextView;
    private android.widget.RelativeLayout callNowLayout;
    private android.widget.ImageView callNowIcon;
    private android.os.Handler handler;
    
    /**
     * Selected users from the search list.
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> selectedList;
    
    /**
     * Selected users
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> selectedUsersList;
    
    /**
     * The instance of the CommonAlertDialog
     */
    private final kotlin.Lazy mDialog$delegate = null;
    
    /**
     * The adapter of the contacts for group creation selection.
     */
    private final kotlin.Lazy adapterUsers$delegate = null;
    private final kotlin.Lazy adapterSearchUsers$delegate = null;
    
    /**
     * Used for search
     */
    private java.lang.String searchString;
    
    /**
     * Blocked user jid
     */
    private java.lang.String blockedUserJid;
    
    /**
     * Search view of the list  of contacts.
     */
    private androidx.appcompat.widget.SearchView searchKey;
    private com.contusfly.helpers.UserListType mUserListType = com.contusfly.helpers.UserListType.USER_LIST;
    
    /**
     * The instance of the DoProgressDialog
     */
    private android.app.ProgressDialog progressDialog;
    
    /**
     * Validate if user block/unblock request sent
     */
    private boolean isUnblockRequested = false;
    private java.lang.String callType;
    private java.lang.String groupJid;
    public com.contusfly.call.CallPermissionUtils callPermissionUtils;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestCallPermissions = null;
    private final com.contusfly.interfaces.PermissionDialogListener permissionDeniedListener = null;
    
    /**
     * Display the list of profile details in the list
     */
    private java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> profileDetailsList;
    private java.util.List<? extends com.mirrorflysdk.api.contacts.ProfileDetails> contusProfilesWithBlockedMe;
    @org.jetbrains.annotations.NotNull()
    private final com.contusfly.call.groupcall.listeners.RecyclerViewUserItemClick onItemClickListener = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public UsersSelectionActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSelectedList() {
        return null;
    }
    
    public final void setSelectedList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSelectedUsersList() {
        return null;
    }
    
    public final void setSelectedUsersList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    /**
     * The instance of the CommonAlertDialog
     */
    private final com.contusfly.views.CommonAlertDialog getMDialog() {
        return null;
    }
    
    /**
     * The adapter of the contacts for group creation selection.
     */
    private final com.contusfly.call.groupcall.UserSelectionAdapter getAdapterUsers() {
        return null;
    }
    
    private final com.contusfly.call.groupcall.UserSelectionAdapter getAdapterSearchUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.call.CallPermissionUtils getCallPermissionUtils() {
        return null;
    }
    
    public final void setCallPermissionUtils(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.CallPermissionUtils p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.call.groupcall.listeners.RecyclerViewUserItemClick getOnItemClickListener() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateGroupMembersList() {
    }
    
    private final void updateSelectionAdapter(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> profileDetailsList) {
    }
    
    private final void filterGroupMembers(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> groupMembers) {
    }
    
    /**
     * Set CallNow Icon based on call type
     */
    private final void checkCallIcon() {
    }
    
    /**
     * On dialog closed.
     *
     * @param dialogType the dialog type
     * @param isSuccess  the is success
     */
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> filterList(java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> profileDetailsList) {
        return null;
    }
    
    private final void setAdapterBasedOnSearchType() {
    }
    
    public final void onUserSelectRestriction() {
    }
    
    private final java.lang.String getSelectedUserCount() {
        return null;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
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
    
    /**
     * Make group call
     */
    private final void checkTypeAndCall() {
    }
    
    private final void makeCall() {
    }
    
    private final void launchAudioCall() {
    }
    
    private final void launchVideoCall() {
    }
    
    private final void notificationPermissionChecking() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean status) {
    }
}