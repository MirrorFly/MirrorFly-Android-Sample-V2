package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0013H\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u001a\u00104\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00107\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0013H\u0016J\u0010\u00108\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0013H\u0016J\u0012\u00109\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0010\u0010:\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0013H\u0016J\u0010\u0010;\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0013H\u0016J\b\u0010<\u001a\u00020&H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/contusfly/activities/SelectContactMessageActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lcom/contusfly/adapters/ContactChatOnClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "audioCallPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "binding", "Lcom/contusfly/databinding/ActivitySelectContactMessageBinding;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getCommonAlertDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "commonAlertDialog$delegate", "Lkotlin/Lazy;", "contactsList", "Ljava/util/ArrayList;", "Lcom/contusfly/adapters/ContactSelectionModel;", "emptyView", "Landroid/widget/TextView;", "messageId", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "phoneNumberUtil", "Lcom/contusfly/libPhone/PhoneNumberUtil;", "getPhoneNumberUtil", "()Lcom/contusfly/libPhone/PhoneNumberUtil;", "phoneNumberUtil$delegate", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "selectedContactNumber", "videoCallPermissionLauncher", "getMessageData", "", "initToolBar", "initViews", "listOptionSelected", "position", "", "onAudioCallClick", "contactData", "onContactSyncComplete", "isSuccess", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "onInviteButtonClick", "onMessageClick", "onPostCreate", "onSaveButtonClick", "onVideoCallClick", "setUpListeners", "Companion", "app_debug"})
public final class SelectContactMessageActivity extends com.contusfly.activities.BaseActivity implements com.contusfly.adapters.ContactChatOnClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private com.contusfly.databinding.ActivitySelectContactMessageBinding binding;
    private android.widget.TextView emptyView;
    private java.util.ArrayList<com.contusfly.adapters.ContactSelectionModel> contactsList;
    private final kotlin.Lazy commonAlertDialog$delegate = null;
    private java.lang.String selectedContactNumber;
    private com.mirrorflysdk.api.contacts.ProfileDetails profileDetails;
    private java.lang.String messageId;
    private final kotlin.Lazy phoneNumberUtil$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> videoCallPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> audioCallPermissionLauncher = null;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.activities.SelectContactMessageActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String countryCode = null;
    private java.util.HashMap _$_findViewCache;
    
    public SelectContactMessageActivity() {
        super();
    }
    
    private final com.contusfly.views.CommonAlertDialog getCommonAlertDialog() {
        return null;
    }
    
    private final com.contusfly.libPhone.PhoneNumberUtil getPhoneNumberUtil() {
        return null;
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onPostCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getMessageData(java.lang.String messageId) {
    }
    
    private final void initToolBar() {
    }
    
    private final void initViews() {
    }
    
    private final void setUpListeners() {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    public void onSaveButtonClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData) {
    }
    
    @java.lang.Override
    public void onInviteButtonClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData) {
    }
    
    @java.lang.Override
    public void onVideoCallClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData) {
    }
    
    @java.lang.Override
    public void onAudioCallClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData) {
    }
    
    @java.lang.Override
    public void onMessageClick(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionModel contactData) {
    }
    
    @java.lang.Override
    public void onContactSyncComplete(boolean isSuccess) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/activities/SelectContactMessageActivity$Companion;", "", "()V", "countryCode", "", "getCountryCode", "()Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCountryCode() {
            return null;
        }
    }
}