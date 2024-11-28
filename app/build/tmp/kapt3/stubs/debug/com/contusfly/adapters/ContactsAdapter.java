package com.contusfly.adapters;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001:B\u0080\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012K\u0010\r\u001aG\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000e\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u00020\'2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J \u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J \u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010.\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0018H\u0014J\u0018\u00100\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0003H\u0002J \u00101\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J.\u00101\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0014J\u0018\u00105\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u000208H\u0014J\u0010\u00109\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0002H\u0002R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000RV\u0010\r\u001aG\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/contusfly/adapters/ContactsAdapter;", "Lcom/contusfly/adapters/GenericSearchAdapter;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "Lcom/contusfly/adapters/ContactsAdapter$ContactsViewHolder;", "context", "Landroid/content/Context;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "isMultiSelection", "", "profilesList", "Ljava/util/ArrayList;", "isMakeCall", "listener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "position", "profileClicked", "profile", "", "(Landroid/content/Context;Lcom/contusfly/views/CommonAlertDialog;ZLjava/util/ArrayList;ZLkotlin/jvm/functions/Function3;)V", "blockedUser", "", "getBlockedUser", "()Ljava/lang/String;", "setBlockedUser", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "groupCallMembersCount", "getGroupCallMembersCount", "()I", "setGroupCallMembersCount", "(I)V", "getListener", "()Lkotlin/jvm/functions/Function3;", "getItemId", "", "handleContactSelection", "item", "holder", "handlePayloads", "bundle", "Landroid/os/Bundle;", "hasSearchKey", "filterKey", "makeCall", "onBindData", "payloads", "", "", "setUserInfo", "setViewHolder", "parent", "Landroid/view/ViewGroup;", "showUserUnBlockPopup", "ContactsViewHolder", "app_debug"})
public final class ContactsAdapter extends com.contusfly.adapters.GenericSearchAdapter<com.mirrorflysdk.api.contacts.ProfileDetails, com.contusfly.adapters.ContactsAdapter.ContactsViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private final com.contusfly.views.CommonAlertDialog commonAlertDialog = null;
    private final boolean isMultiSelection = false;
    private java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> profilesList;
    private final boolean isMakeCall = false;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Boolean, com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> listener = null;
    private int groupCallMembersCount = 0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String blockedUser;
    
    public ContactsAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.views.CommonAlertDialog commonAlertDialog, boolean isMultiSelection, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> profilesList, boolean isMakeCall, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Boolean, ? super com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> listener) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Boolean, com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> getListener() {
        return null;
    }
    
    public final int getGroupCallMembersCount() {
        return 0;
    }
    
    public final void setGroupCallMembersCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBlockedUser() {
        return null;
    }
    
    public final void setBlockedUser(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    protected com.contusfly.adapters.ContactsAdapter.ContactsViewHolder setViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override
    protected void onBindData(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactsAdapter.ContactsViewHolder holder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails item, int position) {
    }
    
    private final void handleContactSelection(com.mirrorflysdk.api.contacts.ProfileDetails item, com.contusfly.adapters.ContactsAdapter.ContactsViewHolder holder, int position) {
    }
    
    private final void makeCall(com.mirrorflysdk.api.contacts.ProfileDetails item, com.contusfly.adapters.ContactsAdapter.ContactsViewHolder holder) {
    }
    
    private final void showUserUnBlockPopup(com.mirrorflysdk.api.contacts.ProfileDetails item) {
    }
    
    @java.lang.Override
    protected void onBindData(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactsAdapter.ContactsViewHolder holder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails item, int position, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Object> payloads) {
    }
    
    private final void handlePayloads(android.os.Bundle bundle, com.contusfly.adapters.ContactsAdapter.ContactsViewHolder holder, com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    @java.lang.Override
    public long getItemId(int position) {
        return 0L;
    }
    
    /**
     * Set the user info of the user from the Roster
     *
     * @param holder View holder of recycler view
     * @param profile   ProfileDetails of the user
     */
    private final void setUserInfo(com.contusfly.adapters.ContactsAdapter.ContactsViewHolder holder, com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    @java.lang.Override
    protected boolean hasSearchKey(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails item, @org.jetbrains.annotations.NotNull
    java.lang.String filterKey) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/ContactsAdapter$ContactsViewHolder;", "Lcom/contusfly/adapters/BaseViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowContactItemBinding;", "(Lcom/contusfly/databinding/RowContactItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/RowContactItemBinding;", "setViewBinding", "app_debug"})
    public static final class ContactsViewHolder extends com.contusfly.adapters.BaseViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.contusfly.databinding.RowContactItemBinding viewBinding;
        
        public ContactsViewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowContactItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.RowContactItemBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowContactItemBinding p0) {
        }
    }
}