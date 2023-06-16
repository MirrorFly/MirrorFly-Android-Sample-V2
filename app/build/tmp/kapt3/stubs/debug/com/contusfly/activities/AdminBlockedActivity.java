package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/contusfly/activities/AdminBlockedActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "adminBlockStatus", "", "adminBlockedBinding", "Lcom/contusfly/databinding/ActivityAdminBlockedBinding;", "handler", "Landroid/os/Handler;", "supportEmailID", "Landroidx/appcompat/widget/AppCompatTextView;", "finishApp", "", "getEmailIntent", "Landroid/content/Intent;", "email", "", "getIntent", "intent", "isNewTask", "initViews", "onAdminBlockedUser", "jid", "status", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "userNavigateToDashboardPage", "app_debug"})
public final class AdminBlockedActivity extends com.contusfly.activities.BaseActivity implements android.view.View.OnClickListener {
    private com.contusfly.databinding.ActivityAdminBlockedBinding adminBlockedBinding;
    private androidx.appcompat.widget.AppCompatTextView supportEmailID;
    private android.os.Handler handler;
    private boolean adminBlockStatus = false;
    private java.util.HashMap _$_findViewCache;
    
    public AdminBlockedActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void finishApp() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final android.content.Intent getEmailIntent(java.lang.String email) {
        return null;
    }
    
    private final android.content.Intent getIntent(android.content.Intent intent, boolean isNewTask) {
        return null;
    }
    
    @java.lang.Override()
    public void onAdminBlockedUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, boolean status) {
    }
    
    private final void userNavigateToDashboardPage(boolean status) {
    }
}