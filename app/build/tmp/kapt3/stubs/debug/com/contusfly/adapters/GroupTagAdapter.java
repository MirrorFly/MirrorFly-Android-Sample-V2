package com.contusfly.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001f B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J$\u0010\u0012\u001a\u00020\f2\n\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J2\u0010\u0012\u001a\u00020\f2\n\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0014J\u0014\u0010\u0019\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0014\u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006!"}, d2 = {"Lcom/contusfly/adapters/GroupTagAdapter;", "Lcom/contusfly/adapters/GenericSearchAdapter;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "Lcom/contusfly/adapters/GroupTagAdapter$GroupTagViewHolder;", "context", "Landroid/content/Context;", "userTagClickListener", "Lcom/contusfly/adapters/GroupTagAdapter$UserTagClickListener;", "(Landroid/content/Context;Lcom/contusfly/adapters/GroupTagAdapter$UserTagClickListener;)V", "getUserTagClickListener", "()Lcom/contusfly/adapters/GroupTagAdapter$UserTagClickListener;", "clearList", "", "hasSearchKey", "", "item", "filterKey", "", "onBindData", "holder", "position", "", "payloads", "", "", "setViewHolder", "parent", "Landroid/view/ViewGroup;", "submitList", "list", "", "GroupTagViewHolder", "UserTagClickListener", "app_debug"})
public final class GroupTagAdapter extends com.contusfly.adapters.GenericSearchAdapter<com.mirrorflysdk.api.contacts.ProfileDetails, com.contusfly.adapters.GroupTagAdapter.GroupTagViewHolder> {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.contusfly.adapters.GroupTagAdapter.UserTagClickListener userTagClickListener = null;
    
    public GroupTagAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.GroupTagAdapter.UserTagClickListener userTagClickListener) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.adapters.GroupTagAdapter.UserTagClickListener getUserTagClickListener() {
        return null;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.mirrorflysdk.api.contacts.ProfileDetails> list) {
    }
    
    public final void clearList() {
    }
    
    @java.lang.Override()
    protected void onBindData(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.GroupTagAdapter.GroupTagViewHolder holder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails item, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    @java.lang.Override()
    protected void onBindData(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.GroupTagAdapter.GroupTagViewHolder holder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails item, int position) {
    }
    
    @java.lang.Override()
    protected boolean hasSearchKey(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails item, @org.jetbrains.annotations.NotNull()
    java.lang.String filterKey) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.contusfly.adapters.GroupTagAdapter.GroupTagViewHolder setViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/contusfly/adapters/GroupTagAdapter$GroupTagViewHolder;", "Lcom/contusfly/adapters/BaseViewHolder;", "viewBinding", "Lcom/contusfly/databinding/ListGroupUserTagItemBinding;", "(Lcom/contusfly/adapters/GroupTagAdapter;Lcom/contusfly/databinding/ListGroupUserTagItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/ListGroupUserTagItemBinding;", "setViewBinding", "(Lcom/contusfly/databinding/ListGroupUserTagItemBinding;)V", "bind", "", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "app_debug"})
    public final class GroupTagViewHolder extends com.contusfly.adapters.BaseViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.databinding.ListGroupUserTagItemBinding viewBinding;
        
        public GroupTagViewHolder(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.ListGroupUserTagItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.databinding.ListGroupUserTagItemBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.ListGroupUserTagItemBinding p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/adapters/GroupTagAdapter$UserTagClickListener;", "", "onUserTagClicked", "", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "app_debug"})
    public static abstract interface UserTagClickListener {
        
        public abstract void onUserTagClicked(@org.jetbrains.annotations.NotNull()
        com.mirrorflysdk.api.contacts.ProfileDetails profileDetails);
    }
}