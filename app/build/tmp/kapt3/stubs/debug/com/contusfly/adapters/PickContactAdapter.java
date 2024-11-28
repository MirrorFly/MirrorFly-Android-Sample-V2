package com.contusfly.adapters;

import java.lang.System;

/**
 * Which used to display the contacts to pick it for the contact share from the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/adapters/PickContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/adapters/PickContactAdapter$ContactViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contacts", "", "Lcom/mirrorflysdk/models/Contact;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setContacts", "ContactViewHolder", "app_debug"})
public final class PickContactAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.adapters.PickContactAdapter.ContactViewHolder> {
    private final android.content.Context context = null;
    
    /**
     * The rosters list for the recycler view.
     */
    private java.util.List<? extends com.mirrorflysdk.models.Contact> contacts;
    
    public PickContactAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Sets the contact data.
     *
     * @param contacts List of contact
     */
    public final void setContacts(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.mirrorflysdk.models.Contact> contacts) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.contusfly.adapters.PickContactAdapter.ContactViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.PickContactAdapter.ContactViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    /**
     * The Class ContactSentViewHolder for the properties in the contact view
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/adapters/PickContactAdapter$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/contusfly/adapters/PickContactAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "noDivider", "getNoDivider", "()Landroid/view/View;", "setNoDivider", "(Landroid/view/View;)V", "txtNumber", "Landroid/widget/TextView;", "getTxtNumber", "()Landroid/widget/TextView;", "viewRow", "getViewRow", "app_debug"})
    public final class ContactViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        /**
         * The txt number of the user.
         */
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView txtNumber = null;
        
        /**
         * The check box to choose the contact.
         */
        @org.jetbrains.annotations.NotNull
        private final android.widget.CheckBox checkBox = null;
        
        /**
         * The view row of the contact
         */
        @org.jetbrains.annotations.NotNull
        private final android.view.View viewRow = null;
        @org.jetbrains.annotations.NotNull
        private android.view.View noDivider;
        
        public ContactViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTxtNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.CheckBox getCheckBox() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.view.View getViewRow() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.view.View getNoDivider() {
            return null;
        }
        
        public final void setNoDivider(@org.jetbrains.annotations.NotNull
        android.view.View p0) {
        }
    }
}