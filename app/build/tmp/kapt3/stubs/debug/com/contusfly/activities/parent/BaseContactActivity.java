package com.contusfly.activities.parent;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019H\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0018\u0010&\u001a\u00020\"2\u0006\u0010\'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0019H\u0004J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019H\u0002J\u0014\u0010,\u001a\u00020\"2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001cH&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006."}, d2 = {"Lcom/contusfly/activities/parent/BaseContactActivity;", "Lcom/contusfly/activities/BaseActivity;", "()V", "addParticipants", "", "getAddParticipants", "()Z", "setAddParticipants", "(Z)V", "fromGroupInfo", "getFromGroupInfo", "setFromGroupInfo", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "multiSelection", "getMultiSelection", "setMultiSelection", "myActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "profiledetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "selectedUsersJid", "Ljava/util/ArrayList;", "", "getSelectedUsersJid", "()Ljava/util/ArrayList;", "setSelectedUsersJid", "(Ljava/util/ArrayList;)V", "handleMultiSelection", "", "profile", "launchChatPage", "launchPinActivity", "listItemClicked", "profileClicked", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "privateChatUserChecking", "updateSelectedUserCallView", "jid", "app_debug"})
public abstract class BaseContactActivity extends com.contusfly.activities.BaseActivity {
    private boolean multiSelection = false;
    
    /**
     * Store onclick time to avoid double click
     */
    private long lastClickTime = 0L;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<java.lang.String> selectedUsersJid;
    private boolean addParticipants = false;
    private boolean fromGroupInfo = false;
    private com.mirrorflysdk.api.contacts.ProfileDetails profiledetails;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> myActivityResultLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public BaseContactActivity() {
        super();
    }
    
    protected final boolean getMultiSelection() {
        return false;
    }
    
    protected final void setMultiSelection(boolean p0) {
    }
    
    protected final long getLastClickTime() {
        return 0L;
    }
    
    protected final void setLastClickTime(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    protected final java.util.ArrayList<java.lang.String> getSelectedUsersJid() {
        return null;
    }
    
    protected final void setSelectedUsersJid(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    protected final boolean getAddParticipants() {
        return false;
    }
    
    protected final void setAddParticipants(boolean p0) {
    }
    
    protected final boolean getFromGroupInfo() {
        return false;
    }
    
    protected final void setFromGroupInfo(boolean p0) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    protected final void listItemClicked(boolean profileClicked, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    private final void privateChatUserChecking(com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    private final void launchChatPage(com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    private final void launchPinActivity() {
    }
    
    private final void handleMultiSelection(com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    public abstract void updateSelectedUserCallView(@org.jetbrains.annotations.Nullable
    java.lang.String jid);
}