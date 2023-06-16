package com.contusfly.adapters;

import java.lang.System;

/**
 * This adapter used to showing the blocked users in recyclerview
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0016\u0010\u001a\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/contusfly/adapters/BlockedContactsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/BlockedContactsAdapter$BlockedContactsViewHolder;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "Lkotlin/ParameterName;", "name", "profile", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "getListener", "()Lkotlin/jvm/functions/Function1;", "mTempData", "Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBlockedProfiles", "profileDetails", "setUserInfo", "item", "BlockedContactsViewHolder", "app_debug"})
public final class BlockedContactsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.BlockedContactsAdapter.BlockedContactsViewHolder> {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> listener = null;
    
    /**
     * The temporary data of the list to reuse the list.
     */
    private java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> mTempData;
    
    public BlockedContactsAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.mirrorflysdk.api.contacts.ProfileDetails, kotlin.Unit> getListener() {
        return null;
    }
    
    /**
     * Sets the list data to rosters list clear the temp data and refresh the view
     *
     * @param profileDetails the new data
     */
    public final void setBlockedProfiles(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> profileDetails) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.contusfly.adapters.BlockedContactsAdapter.BlockedContactsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.BlockedContactsAdapter.BlockedContactsViewHolder holder, int position) {
    }
    
    /**
     * Set the user info of the user from the Roster
     *
     * @param holder View holder of recycler view
     * @param item   Roster of the user
     */
    private final void setUserInfo(com.contusfly.adapters.BlockedContactsAdapter.BlockedContactsViewHolder holder, com.mirrorflysdk.api.contacts.ProfileDetails item) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * This class containing the view of the contact items
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/BlockedContactsAdapter$BlockedContactsViewHolder;", "Lcom/contusfly/adapters/BaseViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowContactItemBinding;", "(Lcom/contusfly/databinding/RowContactItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/RowContactItemBinding;", "setViewBinding", "app_debug"})
    public static final class BlockedContactsViewHolder extends com.contusfly.adapters.BaseViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.databinding.RowContactItemBinding viewBinding;
        
        public BlockedContactsViewHolder(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowContactItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.databinding.RowContactItemBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowContactItemBinding p0) {
        }
    }
}