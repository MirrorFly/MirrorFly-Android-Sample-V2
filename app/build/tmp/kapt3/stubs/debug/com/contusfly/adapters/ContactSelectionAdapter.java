package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002$%B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J.\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tH\u0014J \u0010\u001a\u001a\u00020\f2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u001cJ\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0002J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J&\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/contusfly/adapters/ContactSelectionAdapter;", "Lcom/contusfly/adapters/GenericSearchAdapter;", "Lcom/contusfly/models/DeviceContactModel;", "Lcom/contusfly/adapters/ContactSelectionAdapter$ContactSelectionViewHolder;", "context", "Landroid/content/Context;", "contactList", "", "selectedList", "", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;)V", "handlePayloads", "", "bundle", "Landroid/os/Bundle;", "holder", "item", "hasSearchKey", "", "filterKey", "", "onBindData", "position", "", "payloads", "", "onContactItemClicked", "fn", "Lkotlin/Function2;", "onContactRemoved", "setProfileDetails", "contactModel", "setSelectedIcon", "setViewHolder", "parent", "Landroid/view/ViewGroup;", "Companion", "ContactSelectionViewHolder", "app_debug"})
public final class ContactSelectionAdapter extends com.contusfly.adapters.GenericSearchAdapter<com.contusfly.models.DeviceContactModel, com.contusfly.adapters.ContactSelectionAdapter.ContactSelectionViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.contusfly.models.DeviceContactModel> contactList = null;
    private final java.util.List<com.contusfly.models.DeviceContactModel> selectedList = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.adapters.ContactSelectionAdapter.Companion Companion = null;
    public static kotlin.jvm.functions.Function2<? super com.contusfly.models.DeviceContactModel, ? super java.lang.Boolean, kotlin.Unit> onContactItemClicked;
    
    public ContactSelectionAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.DeviceContactModel> contactList, @org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.DeviceContactModel> selectedList) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    protected com.contusfly.adapters.ContactSelectionAdapter.ContactSelectionViewHolder setViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override
    protected void onBindData(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionAdapter.ContactSelectionViewHolder holder, @org.jetbrains.annotations.NotNull
    com.contusfly.models.DeviceContactModel item, int position, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Object> payloads) {
    }
    
    private final void handlePayloads(android.os.Bundle bundle, com.contusfly.adapters.ContactSelectionAdapter.ContactSelectionViewHolder holder, com.contusfly.models.DeviceContactModel item) {
    }
    
    @java.lang.Override
    protected void onBindData(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ContactSelectionAdapter.ContactSelectionViewHolder holder, @org.jetbrains.annotations.NotNull
    com.contusfly.models.DeviceContactModel item, int position) {
    }
    
    private final void setProfileDetails(com.contusfly.adapters.ContactSelectionAdapter.ContactSelectionViewHolder holder, com.contusfly.models.DeviceContactModel contactModel) {
    }
    
    private final void setSelectedIcon(com.contusfly.adapters.ContactSelectionAdapter.ContactSelectionViewHolder holder, java.util.List<com.contusfly.models.DeviceContactModel> selectedList, com.contusfly.models.DeviceContactModel contactModel) {
    }
    
    public final void onContactItemClicked(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.contusfly.models.DeviceContactModel, ? super java.lang.Boolean, kotlin.Unit> fn) {
    }
    
    public final void onContactRemoved(@org.jetbrains.annotations.NotNull
    com.contusfly.models.DeviceContactModel item) {
    }
    
    @java.lang.Override
    protected boolean hasSearchKey(@org.jetbrains.annotations.NotNull
    com.contusfly.models.DeviceContactModel item, @org.jetbrains.annotations.NotNull
    java.lang.String filterKey) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/ContactSelectionAdapter$ContactSelectionViewHolder;", "Lcom/contusfly/adapters/BaseViewHolder;", "contactListItemBinding", "Lcom/contusfly/databinding/RowContactSelectionItemBinding;", "(Lcom/contusfly/databinding/RowContactSelectionItemBinding;)V", "getContactListItemBinding", "()Lcom/contusfly/databinding/RowContactSelectionItemBinding;", "setContactListItemBinding", "app_debug"})
    public static final class ContactSelectionViewHolder extends com.contusfly.adapters.BaseViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.contusfly.databinding.RowContactSelectionItemBinding contactListItemBinding;
        
        public ContactSelectionViewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowContactSelectionItemBinding contactListItemBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.RowContactSelectionItemBinding getContactListItemBinding() {
            return null;
        }
        
        public final void setContactListItemBinding(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowContactSelectionItemBinding p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/contusfly/adapters/ContactSelectionAdapter$Companion;", "", "()V", "onContactItemClicked", "Lkotlin/Function2;", "Lcom/contusfly/models/DeviceContactModel;", "", "", "getOnContactItemClicked", "()Lkotlin/jvm/functions/Function2;", "setOnContactItemClicked", "(Lkotlin/jvm/functions/Function2;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function2<com.contusfly.models.DeviceContactModel, java.lang.Boolean, kotlin.Unit> getOnContactItemClicked() {
            return null;
        }
        
        public final void setOnContactItemClicked(@org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function2<? super com.contusfly.models.DeviceContactModel, ? super java.lang.Boolean, kotlin.Unit> p0) {
        }
    }
}