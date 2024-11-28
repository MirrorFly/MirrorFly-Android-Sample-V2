package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\b\u00100\u001a\u00020*H\u0002J\u0012\u00101\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0012\u0010;\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u0010<\u001a\u00020*H\u0016J\b\u0010=\u001a\u00020*H\u0016J\b\u0010>\u001a\u00020*H\u0002J\u0010\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u000205H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\n\"\u0004\b(\u0010\f\u00a8\u0006A"}, d2 = {"Lcom/contusfly/activities/ContactSelectionActivity;", "Lcom/contusfly/activities/BaseActivity;", "()V", "activityPreviewResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "chatType", "", "getChatType", "()Ljava/lang/String;", "setChatType", "(Ljava/lang/String;)V", "contactSectionAdapter", "Lcom/contusfly/adapters/ContactSelectionAdapter;", "getContactSectionAdapter", "()Lcom/contusfly/adapters/ContactSelectionAdapter;", "contactSectionAdapter$delegate", "Lkotlin/Lazy;", "contactSelectionBinding", "Lcom/contusfly/databinding/ActivityContactSelectionBinding;", "contactSelectionPreviewAdapter", "Lcom/contusfly/adapters/ContactSelectionPreviewAdapter;", "getContactSelectionPreviewAdapter", "()Lcom/contusfly/adapters/ContactSelectionPreviewAdapter;", "contactSelectionPreviewAdapter$delegate", "contactSelectionViewModel", "Lcom/contusfly/viewmodels/ContactSelectionViewModel;", "getContactSelectionViewModel", "()Lcom/contusfly/viewmodels/ContactSelectionViewModel;", "contactSelectionViewModel$delegate", "messagingClient", "Lcom/contusfly/chat/MessagingClient;", "getMessagingClient", "()Lcom/contusfly/chat/MessagingClient;", "setMessagingClient", "(Lcom/contusfly/chat/MessagingClient;)V", "searchKey", "toUser", "getToUser", "setToUser", "getIntentData", "", "getMobileNumbers", "", "mobileNumbers", "", "Lcom/contusfly/models/PhoneNumber;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onMessageEvent", "messageEvent", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onPostCreate", "onStart", "onStop", "setObservers", "showMaxRestrictionToast", "isShow", "app_debug"})
public final class ContactSelectionActivity extends com.contusfly.activities.BaseActivity {
    private com.contusfly.databinding.ActivityContactSelectionBinding contactSelectionBinding;
    private final kotlin.Lazy contactSelectionViewModel$delegate = null;
    public java.lang.String toUser;
    public java.lang.String chatType;
    @javax.inject.Inject
    public com.contusfly.chat.MessagingClient messagingClient;
    
    /**
     * Used for search
     */
    private java.lang.String searchKey;
    private final kotlin.Lazy contactSectionAdapter$delegate = null;
    private final kotlin.Lazy contactSelectionPreviewAdapter$delegate = null;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> activityPreviewResult;
    private java.util.HashMap _$_findViewCache;
    
    public ContactSelectionActivity() {
        super();
    }
    
    private final com.contusfly.viewmodels.ContactSelectionViewModel getContactSelectionViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getToUser() {
        return null;
    }
    
    public final void setToUser(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChatType() {
        return null;
    }
    
    public final void setChatType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.chat.MessagingClient getMessagingClient() {
        return null;
    }
    
    public final void setMessagingClient(@org.jetbrains.annotations.NotNull
    com.contusfly.chat.MessagingClient p0) {
    }
    
    private final com.contusfly.adapters.ContactSelectionAdapter getContactSectionAdapter() {
        return null;
    }
    
    private final com.contusfly.adapters.ContactSelectionPreviewAdapter getContactSelectionPreviewAdapter() {
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
    
    private final void setObservers() {
    }
    
    private final void showMaxRestrictionToast(boolean isShow) {
    }
    
    private final void initViews() {
    }
    
    private final void getIntentData() {
    }
    
    private final java.util.List<java.lang.String> getMobileNumbers(java.util.List<com.contusfly.models.PhoneNumber> mobileNumbers) {
        return null;
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
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
}