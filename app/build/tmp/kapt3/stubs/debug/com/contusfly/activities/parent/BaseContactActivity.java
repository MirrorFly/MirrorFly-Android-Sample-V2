package com.contusfly.activities.parent;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0004J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016J\u0014\u0010%\u001a\u00020\u001d2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0017H&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\'"}, d2 = {"Lcom/contusfly/activities/parent/BaseContactActivity;", "Lcom/contusfly/activities/BaseActivity;", "()V", "addParticipants", "", "getAddParticipants", "()Z", "setAddParticipants", "(Z)V", "fromGroupInfo", "getFromGroupInfo", "setFromGroupInfo", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "multiSelection", "getMultiSelection", "setMultiSelection", "selectedUsersJid", "Ljava/util/ArrayList;", "", "getSelectedUsersJid", "()Ljava/util/ArrayList;", "setSelectedUsersJid", "(Ljava/util/ArrayList;)V", "handleMultiSelection", "", "profile", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "listItemClicked", "profileClicked", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "updateSelectedUserCallView", "jid", "app_debug"})
public abstract class BaseContactActivity extends com.contusfly.activities.BaseActivity {
    private boolean multiSelection = false;
    
    /**
     * Store onclick time to avoid double click
     */
    private long lastClickTime = 0L;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> selectedUsersJid;
    private boolean addParticipants = false;
    private boolean fromGroupInfo = false;
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
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.ArrayList<java.lang.String> getSelectedUsersJid() {
        return null;
    }
    
    protected final void setSelectedUsersJid(@org.jetbrains.annotations.NotNull()
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
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    protected final void listItemClicked(boolean profileClicked, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    private final void handleMultiSelection(com.mirrorflysdk.api.contacts.ProfileDetails profile) {
    }
    
    public abstract void updateSelectedUserCallView(@org.jetbrains.annotations.Nullable()
    java.lang.String jid);
}