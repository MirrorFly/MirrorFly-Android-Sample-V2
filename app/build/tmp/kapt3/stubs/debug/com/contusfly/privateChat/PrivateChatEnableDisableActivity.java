package com.contusfly.privateChat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0007J\b\u0010\'\u001a\u00020\u001bH\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u000fH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u00061"}, d2 = {"Lcom/contusfly/privateChat/PrivateChatEnableDisableActivity;", "Lcom/contusfly/activities/BaseActivity;", "()V", "binding", "Lcom/contusfly/databinding/ActivityPrivateChatEnableDisableBinding;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getCommonAlertDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "commonAlertDialog$delegate", "Lkotlin/Lazy;", "mContext", "Landroid/content/Context;", "myActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pinAvailable", "", "getPinAvailable", "()Z", "toUser", "", "getToUser", "()Ljava/lang/String;", "setToUser", "(Ljava/lang/String;)V", "checkIsAlreadyPrivateChatUser", "", "handleMainIntent", "launchPinActivity", "chatEnableDisableValue", "launchSetPinActivity", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMessageEvent", "messageEvent", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onStart", "onStop", "privateChatStatusChange", "status", "setEnablePrivateChat", "setPrivateChatEnableOrDisable", "data", "setToolbar", "showDialogFirstPrivateChatUser", "privateChatEnabledStatus", "app_debug"})
public final class PrivateChatEnableDisableActivity extends com.contusfly.activities.BaseActivity {
    private android.content.Context mContext;
    private com.contusfly.databinding.ActivityPrivateChatEnableDisableBinding binding;
    public java.lang.String toUser;
    private final kotlin.Lazy commonAlertDialog$delegate = null;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> myActivityResultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public PrivateChatEnableDisableActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getToUser() {
        return null;
    }
    
    public final void setToUser(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    private final com.contusfly.views.CommonAlertDialog getCommonAlertDialog() {
        return null;
    }
    
    private final boolean getPinAvailable() {
        return false;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setToolbar() {
    }
    
    private final void handleMainIntent() {
    }
    
    private final void checkIsAlreadyPrivateChatUser() {
    }
    
    private final void onClick() {
    }
    
    private final void setEnablePrivateChat() {
    }
    
    private final void launchSetPinActivity() {
    }
    
    private final void launchPinActivity(java.lang.String chatEnableDisableValue) {
    }
    
    private final void setPrivateChatEnableOrDisable(android.content.Intent data) {
    }
    
    private final void privateChatStatusChange(boolean status) {
    }
    
    private final void showDialogFirstPrivateChatUser(boolean privateChatEnabledStatus) {
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