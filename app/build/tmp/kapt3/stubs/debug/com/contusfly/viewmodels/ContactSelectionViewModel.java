package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010\u0006\u001a\u00020\u001aH\u0002J\u0019\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u000e\u0010\'\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/contusfly/viewmodels/ContactSelectionViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "contactDiffResult", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getContactDiffResult", "()Landroidx/lifecycle/MutableLiveData;", "contactsList", "", "Lcom/contusfly/models/DeviceContactModel;", "getContactsList", "()Ljava/util/List;", "contactsListLoaded", "", "getContactsListLoaded", "contactsSelectionReachedMaximum", "getContactsSelectionReachedMaximum", "deviceContactsList", "Ljava/util/LinkedHashMap;", "", "selectedContactList", "getSelectedContactList", "selectedList", "getSelectedList", "checkAndAddContact", "", "displayName", "displayNumber", "contactId", "label", "", "getAllDeviceContacts", "context", "Landroid/content/Context;", "getDiffUtilResult", "diffUtilCallback", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "(Landroidx/recyclerview/widget/DiffUtil$Callback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalContactUserProfiles", "onContactItemClicked", "item", "app_debug"})
public final class ContactSelectionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.contusfly.models.DeviceContactModel> contactsList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.contusfly.models.DeviceContactModel> selectedContactList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.DeviceContactModel>> selectedList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> contactDiffResult = null;
    private final java.util.LinkedHashMap<java.lang.String, com.contusfly.models.DeviceContactModel> deviceContactsList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> contactsListLoaded = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> contactsSelectionReachedMaximum = null;
    
    public ContactSelectionViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.contusfly.models.DeviceContactModel> getContactsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.contusfly.models.DeviceContactModel> getSelectedContactList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.DeviceContactModel>> getSelectedList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getContactDiffResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getContactsListLoaded() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getContactsSelectionReachedMaximum() {
        return null;
    }
    
    private final void getAllDeviceContacts(android.content.Context context) {
    }
    
    private final void checkAndAddContact(java.lang.String displayName, java.lang.String displayNumber, java.lang.String contactId, java.lang.CharSequence label) {
    }
    
    public final void getLocalContactUserProfiles(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void onContactItemClicked(@org.jetbrains.annotations.NotNull
    com.contusfly.models.DeviceContactModel item) {
    }
    
    private final void getContactDiffResult() {
    }
    
    private final java.lang.Object getDiffUtilResult(androidx.recyclerview.widget.DiffUtil.Callback diffUtilCallback, kotlin.coroutines.Continuation<? super androidx.recyclerview.widget.DiffUtil.DiffResult> continuation) {
        return null;
    }
}