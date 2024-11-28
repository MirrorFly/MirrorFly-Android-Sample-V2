package com.contusfly.adapters;

import java.lang.System;

/**
 * Which used to display the contacts to pick it for the contact share from the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/adapters/ShareContactsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/ShareContactsAdapter$ContactViewHolder;", "context", "Landroid/content/Context;", "cm", "Ljava/util/ArrayList;", "Lcom/contusfly/models/ContactShareModel;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "contacts", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setContacts", "ContactViewHolder", "app_debug"})
public final class ShareContactsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.ShareContactsAdapter.ContactViewHolder> {
    private final android.content.Context context = null;
    
    /**
     * The rosters list for the recycler view.
     */
    private java.util.List<com.contusfly.models.ContactShareModel> contacts;
    
    public ShareContactsAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.contusfly.models.ContactShareModel> cm) {
        super();
    }
    
    /**
     * Sets the contact data.
     *
     * @param contacts List of contact
     */
    public final void setContacts(@org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.models.ContactShareModel> contacts) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.adapters.ShareContactsAdapter.ContactViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.ShareContactsAdapter.ContactViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    /**
     * The Class ContactSentViewHolder for the properties in the contact view
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/adapters/ShareContactsAdapter$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/contusfly/adapters/ShareContactsAdapter;Landroid/view/View;)V", "phoneNumbersRecyclerView", "Lcom/contusfly/views/CustomRecyclerView;", "getPhoneNumbersRecyclerView", "()Lcom/contusfly/views/CustomRecyclerView;", "setPhoneNumbersRecyclerView", "(Lcom/contusfly/views/CustomRecyclerView;)V", "txtName", "Lcom/contusfly/views/CustomTextView;", "getTxtName", "()Lcom/contusfly/views/CustomTextView;", "setTxtName", "(Lcom/contusfly/views/CustomTextView;)V", "app_debug"})
    public final class ContactViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        /**
         * The txt name of the user.
         */
        @org.jetbrains.annotations.NotNull
        private com.contusfly.views.CustomTextView txtName;
        
        /**
         * The RecyclerView which holds list of phone numbers
         */
        @org.jetbrains.annotations.NotNull
        private com.contusfly.views.CustomRecyclerView phoneNumbersRecyclerView;
        
        public ContactViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.views.CustomTextView getTxtName() {
            return null;
        }
        
        public final void setTxtName(@org.jetbrains.annotations.NotNull
        com.contusfly.views.CustomTextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.views.CustomRecyclerView getPhoneNumbersRecyclerView() {
            return null;
        }
        
        public final void setPhoneNumbersRecyclerView(@org.jetbrains.annotations.NotNull
        com.contusfly.views.CustomRecyclerView p0) {
        }
    }
}