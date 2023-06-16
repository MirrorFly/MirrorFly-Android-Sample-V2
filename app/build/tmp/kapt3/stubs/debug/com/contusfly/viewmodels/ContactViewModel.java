package com.contusfly.viewmodels;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0019\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR+\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/contusfly/viewmodels/ContactViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "contactDetailsList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getContactDetailsList", "()Landroidx/lifecycle/MutableLiveData;", "contactDiffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getContactDiffResult", "contactListAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getContactListAdapter", "()Ljava/util/ArrayList;", "contactListAdapter$delegate", "Lkotlin/Lazy;", "", "getContactList", "fromGroupInfo", "", "groupId", "", "getDiffUtilResult", "diffUtilCallback", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "(Landroidx/recyclerview/widget/DiffUtil$Callback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUpdatedContactList", "app_debug"})
public final class ContactViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> contactDetailsList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy contactListAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> contactDiffResult = null;
    
    @javax.inject.Inject()
    public ContactViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getContactDetailsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getContactListAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getContactDiffResult() {
        return null;
    }
    
    public final void getContactList(boolean fromGroupInfo, @org.jetbrains.annotations.Nullable()
    java.lang.String groupId) {
    }
    
    public final void getUpdatedContactList(boolean fromGroupInfo, @org.jetbrains.annotations.Nullable()
    java.lang.String groupId) {
    }
    
    private final void getContactDiffResult() {
    }
    
    private final java.lang.Object getDiffUtilResult(androidx.recyclerview.widget.DiffUtil.Callback diffUtilCallback, kotlin.coroutines.Continuation<? super androidx.recyclerview.widget.DiffUtil.DiffResult> continuation) {
        return null;
    }
}