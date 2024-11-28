package com.contusfly.adapters;

import java.lang.System;

/**
 * Display the contact list in the Activity from the list of ProfileDetails.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003@ABB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ\u0014\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\"\u001a\u00020\u0010J \u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0015H\u0016J\u0006\u00102\u001a\u00020\u0012J\u000e\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0010J\u0014\u00105\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019J\u0018\u00106\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u00107\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0010J\u0018\u0010:\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010;\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010<\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0010\u0010>\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010,J\u0018\u0010?\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Lcom/contusfly/adapters/SectionedShareAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "onItemClickListener", "Lcom/contusfly/interfaces/RecyclerViewItemClick;", "(Landroid/content/Context;Lcom/contusfly/views/CommonAlertDialog;Lcom/contusfly/interfaces/RecyclerViewItemClick;)V", "isLoadingAdded", "", "profileDetailsList", "", "Lcom/contusfly/models/ProfileDetailsShareModel;", "searchKey", "", "addLoadingFooter", "", "addProfileDetails", "position", "", "shareModel", "addProfileList", "userList", "", "canEnableHeader", "enableHeader", "viewSectionHeader", "Landroid/widget/LinearLayout;", "headerSectionTextView", "Lcom/contusfly/views/CustomTextView;", "getItemCount", "getItemViewType", "getSearchKey", "handleContactSelection", "item", "holder", "Lcom/contusfly/adapters/SectionedShareAdapter$ShareViewHolder;", "handleStatus", "statusTextView", "Landroidx/emoji/widget/EmojiAppCompatTextView;", "type", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeLoadingFooter", "removeProfileDetails", "userId", "setProfileDetails", "setRosterImage", "setSearchHeader", "setSearchKey", "filterKey", "setStatusForChatUsers", "setStatusForGroupAndBroadcastUsers", "setUserInfo", "unblockUser", "updateProfileDetails", "viewContactsAndGroups", "Companion", "ProgressViewHolder", "ShareViewHolder", "app_debug"})
public final class SectionedShareAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final android.content.Context context = null;
    private final com.contusfly.views.CommonAlertDialog commonAlertDialog = null;
    private final com.contusfly.interfaces.RecyclerViewItemClick onItemClickListener = null;
    
    /**
     * The ProfileDetails list to display in the recycler view.
     */
    private java.util.List<com.contusfly.models.ProfileDetailsShareModel> profileDetailsList;
    private java.lang.String searchKey = "";
    private boolean isLoadingAdded = false;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.adapters.SectionedShareAdapter.Companion Companion = null;
    private static final int LOADING = 0;
    private static final int ITEM = 1;
    
    public SectionedShareAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.views.CommonAlertDialog commonAlertDialog, @org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.RecyclerViewItemClick onItemClickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSearchKey() {
        return null;
    }
    
    /**
     * Sets the list data to ProfileDetails list clear the temp data and refresh the view
     *
     * @param profileDetailsList the new data
     */
    public final void setProfileDetails(@org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.ProfileDetailsShareModel> profileDetailsList) {
    }
    
    /**
     * Set the updated data to ProfileDetails list and refresh the view
     *
     * @param profileDetails the new data
     */
    public final void updateProfileDetails(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    /**
     * Set the updated data to ProfileDetails list and refresh the view
     *
     * @param shareModel the new data
     */
    public final void addProfileDetails(int position, @org.jetbrains.annotations.Nullable
    com.contusfly.models.ProfileDetailsShareModel shareModel) {
    }
    
    public final void addProfileList(@org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.ProfileDetailsShareModel> userList) {
    }
    
    public final void addLoadingFooter() {
    }
    
    public final void removeLoadingFooter() {
    }
    
    /**
     * Remove the profile details from the adapter
     *
     * @param userId of the user
     */
    public final void removeProfileDetails(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    /**
     * Display the searched message view item
     *
     * @param holder   Holder of the Chat item
     * @param position Position of the selected item
     */
    private final void viewContactsAndGroups(com.contusfly.adapters.SectionedShareAdapter.ShareViewHolder holder, int position) {
    }
    
    /**
     * Handle group contact selection
     *
     * @param item   Selected contact item
     * @param position position of the item
     */
    private final void handleContactSelection(com.contusfly.models.ProfileDetailsShareModel item, com.contusfly.adapters.SectionedShareAdapter.ShareViewHolder holder, int position) {
    }
    
    private final void unblockUser(com.contusfly.models.ProfileDetailsShareModel item) {
    }
    
    /**
     * Set the user info of the user from the ProfileDetails
     *
     * @param holder View holder of recycler view
     * @param item   ProfileDetails of the user
     */
    private final void setUserInfo(com.contusfly.adapters.SectionedShareAdapter.ShareViewHolder holder, com.contusfly.models.ProfileDetailsShareModel item) {
    }
    
    /**
     * Set the image view of the recent chat for user, broadcast, group chat
     *
     * @param holder Instance of the RecentViewHolder
     * @param profileDetails Instance of the ProfileDetails
     */
    private final void setRosterImage(com.contusfly.adapters.SectionedShareAdapter.ShareViewHolder holder, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    /**
     * Set the search key to highlight search results
     *
     * @param filterKey The search filter key
     */
    public final void setSearchKey(@org.jetbrains.annotations.NotNull
    java.lang.String filterKey) {
    }
    
    /**
     * Enable the header, that might be Chats or MessagesModel or Contacts.
     *
     * @param viewSectionHeader   Linear layout of the header
     * @param headerSectionTextView   Text view of the header
     * @param position Position of the List
     */
    private final void enableHeader(android.widget.LinearLayout viewSectionHeader, com.contusfly.views.CustomTextView headerSectionTextView, int position) {
    }
    
    /**
     * Set the search header in the chat item, which is the Search type
     *
     * @param headerSectionTextView  Text view of the header
     * @param position           Position of the list item
     */
    private final void setSearchHeader(com.contusfly.views.CustomTextView headerSectionTextView, int position) {
    }
    
    /**
     * Check the header is needed for the chat item. Search type of the current item and previous
     * item is different then return true
     *
     * @param position Position of the list item
     * @return boolean True if the header need to enable
     */
    private final boolean canEnableHeader(int position) {
        return false;
    }
    
    private final void handleStatus(androidx.emoji.widget.EmojiAppCompatTextView statusTextView, java.lang.String type, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    private final void setStatusForChatUsers(androidx.emoji.widget.EmojiAppCompatTextView statusTextView, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    private final void setStatusForGroupAndBroadcastUsers(androidx.emoji.widget.EmojiAppCompatTextView statusTextView, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    /**
     * This class containing the view of the contact items
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/adapters/SectionedShareAdapter$ShareViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowShareItemBinding;", "(Lcom/contusfly/databinding/RowShareItemBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/RowShareItemBinding;", "app_debug"})
    public static final class ShareViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.contusfly.databinding.RowShareItemBinding viewBinding = null;
        
        public ShareViewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowShareItemBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.RowShareItemBinding getViewBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/SectionedShareAdapter$ProgressViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "progressViewBinding", "Lcom/contusfly/databinding/RowProgressBarBinding;", "(Lcom/contusfly/databinding/RowProgressBarBinding;)V", "getProgressViewBinding", "()Lcom/contusfly/databinding/RowProgressBarBinding;", "setProgressViewBinding", "app_debug"})
    public static final class ProgressViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.contusfly.databinding.RowProgressBarBinding progressViewBinding;
        
        public ProgressViewHolder(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowProgressBarBinding progressViewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.databinding.RowProgressBarBinding getProgressViewBinding() {
            return null;
        }
        
        public final void setProgressViewBinding(@org.jetbrains.annotations.NotNull
        com.contusfly.databinding.RowProgressBarBinding p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/adapters/SectionedShareAdapter$Companion;", "", "()V", "ITEM", "", "LOADING", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}