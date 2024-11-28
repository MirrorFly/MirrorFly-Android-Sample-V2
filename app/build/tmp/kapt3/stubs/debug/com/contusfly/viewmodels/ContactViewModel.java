package com.contusfly.viewmodels;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010(\u001a\u00020)J\u0006\u0010\u000b\u001a\u00020)J\u0018\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010$J \u0010*\u001a\u00020)2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000eH\u0002J\u0019\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u000200H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J\u001e\u00102\u001a\u00020)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010,\u001a\u00020$H\u0002J\u0018\u00103\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010$J\u000e\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u0014J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u001eH\u0002J\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR+\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/contusfly/viewmodels/ContactViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "contactDetailsList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getContactDetailsList", "()Landroidx/lifecycle/MutableLiveData;", "contactDiffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getContactDiffResult", "contactListAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getContactListAdapter", "()Ljava/util/ArrayList;", "contactListAdapter$delegate", "Lkotlin/Lazy;", "contactSyncNeeded", "", "getContactSyncNeeded", "isContactSyncSuccess", "isGetContactListInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setGetContactListInProgress", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isRefreshing", "mContactCount", "", "getMContactCount", "()I", "setMContactCount", "(I)V", "selectedUsersJid", "", "getSelectedUsersJid", "setSelectedUsersJid", "(Ljava/util/ArrayList;)V", "checkContactsUpdate", "", "getContactList", "fromGroupInfo", "groupId", "contusContacts", "getDiffUtilResult", "diffUtilCallback", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "(Landroidx/recyclerview/widget/DiffUtil$Callback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupContactList", "getUpdatedContactList", "onContactSyncFinished", "success", "updateContacts", "contactCount", "updateProfiles", "profileDetails", "app_debug"})
public final class ContactViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> contactDetailsList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy contactListAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> contactDiffResult = null;
    
    /**
     * contacts count from preference
     */
    private int mContactCount = 0;
    
    /**
     * contact refreshing status
     */
    private boolean isRefreshing = false;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> contactSyncNeeded = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isContactSyncSuccess = null;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<java.lang.String> selectedUsersJid;
    @org.jetbrains.annotations.NotNull
    private java.util.concurrent.atomic.AtomicBoolean isGetContactListInProgress;
    
    @javax.inject.Inject
    public ContactViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getContactDetailsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getContactListAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getContactDiffResult() {
        return null;
    }
    
    public final int getMContactCount() {
        return 0;
    }
    
    public final void setMContactCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getContactSyncNeeded() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isContactSyncSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getSelectedUsersJid() {
        return null;
    }
    
    public final void setSelectedUsersJid(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.atomic.AtomicBoolean isGetContactListInProgress() {
        return null;
    }
    
    public final void setGetContactListInProgress(@org.jetbrains.annotations.NotNull
    java.util.concurrent.atomic.AtomicBoolean p0) {
    }
    
    public final void getContactList(boolean fromGroupInfo, @org.jetbrains.annotations.Nullable
    java.lang.String groupId) {
    }
    
    @kotlin.jvm.Synchronized
    private final synchronized void getContactList(java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> contusContacts) {
    }
    
    private final void getGroupContactList(java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> contusContacts, java.lang.String groupId) {
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> updateProfiles(java.util.List<? extends com.mirrorflysdk.api.contacts.ProfileDetails> profileDetails) {
        return null;
    }
    
    public final void getUpdatedContactList(boolean fromGroupInfo, @org.jetbrains.annotations.Nullable
    java.lang.String groupId) {
    }
    
    public final void getContactDiffResult() {
    }
    
    private final java.lang.Object getDiffUtilResult(androidx.recyclerview.widget.DiffUtil.Callback diffUtilCallback, kotlin.coroutines.Continuation<? super androidx.recyclerview.widget.DiffUtil.DiffResult> continuation) {
        return null;
    }
    
    public final void checkContactsUpdate() {
    }
    
    /**
     * sync contact whenever its updated
     *
     * @param contactCount current contact count
     */
    private final void updateContacts(int contactCount) {
    }
    
    public final void onContactSyncFinished(boolean success) {
    }
}