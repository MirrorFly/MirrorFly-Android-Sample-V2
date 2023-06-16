package com.contusfly.call.calllog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00012B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u001a\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u001a\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u001c\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0014\u0010\"\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u0002R\u00020\u0000H\u0016J\u001c\u0010#\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020%H\u0002J\u001c\u0010&\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\'\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020\u0007H\u0002J\u001c\u0010)\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020\u0007H\u0002J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\nJ\u001c\u0010,\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/contusfly/call/calllog/CallHistorySearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/call/calllog/CallHistorySearchAdapter$CallHistorySearchViewHolder;", "context", "Landroid/content/Context;", "mCallLogsList", "", "Lcom/mirrorflysdk/flycall/call/database/model/CallLog;", "selectedCallLogs", "Ljava/util/ArrayList;", "", "listener", "Lcom/contusfly/call/calllog/CallHistoryAdapter$OnItemClickListener;", "(Landroid/content/Context;Ljava/util/List;Ljava/util/ArrayList;Lcom/contusfly/call/calllog/CallHistoryAdapter$OnItemClickListener;)V", "getContext", "()Landroid/content/Context;", "searchKey", "getCallLogAtPosition", "position", "", "getItemCount", "handlePayloads", "", "bundle", "Landroid/os/Bundle;", "holder", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "profileIcon", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "profileIconForManyUsers", "setCallStatusIcon", "callLogs", "setCallType", "setSearchKey", "key", "setUserView", "updateSelectedItem", "view", "Landroid/view/View;", "isSelected", "", "CallHistorySearchViewHolder", "app_debug"})
public final class CallHistorySearchAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog> mCallLogsList = null;
    private final java.util.ArrayList<java.lang.String> selectedCallLogs = null;
    private com.contusfly.call.calllog.CallHistoryAdapter.OnItemClickListener listener;
    private java.lang.String searchKey = "";
    
    public CallHistorySearchAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog> mCallLogsList, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> selectedCallLogs, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.calllog.CallHistoryAdapter.OnItemClickListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewRecycled(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder) {
    }
    
    public final void setSearchKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    private final void handlePayloads(android.os.Bundle bundle, com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder, int position) {
    }
    
    /**
     * Selected view when long press it
     *
     * @param view       Instance of the view
     * @param isSelected true if item is selected
     */
    private final void updateSelectedItem(android.view.View view, boolean isSelected) {
    }
    
    /**
     * This method is getting the caller name and profile picture
     *
     * @param holder viewHolder instance
     * @param position Item Position
     */
    private final void setUserView(com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder, int position) {
    }
    
    private final void profileIconForManyUsers(com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder, int position) {
    }
    
    private final void profileIcon(com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    private final void setCallType(com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder, com.mirrorflysdk.flycall.call.database.model.CallLog callLogs) {
    }
    
    private final void setCallStatusIcon(com.contusfly.call.calllog.CallHistorySearchAdapter.CallHistorySearchViewHolder holder, com.mirrorflysdk.flycall.call.database.model.CallLog callLogs) {
    }
    
    /**
     * Get the Call log position form the
     *
     * @param position holder position
     * @return list position
     */
    @org.jetbrains.annotations.NotNull()
    public final com.mirrorflysdk.flycall.call.database.model.CallLog getCallLogAtPosition(int position) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/contusfly/call/calllog/CallHistorySearchAdapter$CallHistorySearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/contusfly/call/calllog/CallHistorySearchAdapter;Landroid/view/View;)V", "emailContactIcon", "Lcom/contusfly/views/CircularImageView;", "getEmailContactIcon", "()Lcom/contusfly/views/CircularImageView;", "setEmailContactIcon", "(Lcom/contusfly/views/CircularImageView;)V", "imageViewCallIcon", "Landroid/widget/ImageView;", "getImageViewCallIcon", "()Landroid/widget/ImageView;", "imgCallStatus", "getImgCallStatus", "imgRoster", "getImgRoster", "txtCallDurationTime", "Lcom/contusfly/views/CustomTextView;", "getTxtCallDurationTime", "()Lcom/contusfly/views/CustomTextView;", "txtCallTime", "getTxtCallTime", "txtChatPersonName", "Landroidx/emoji/widget/EmojiAppCompatTextView;", "getTxtChatPersonName", "()Landroidx/emoji/widget/EmojiAppCompatTextView;", "app_debug"})
    public final class CallHistorySearchViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        /**
         * The image view of the Roster.
         */
        @org.jetbrains.annotations.NotNull()
        private final com.contusfly.views.CircularImageView imgRoster = null;
        
        /**
         * TextView for call start time
         */
        @org.jetbrains.annotations.NotNull()
        private final com.contusfly.views.CustomTextView txtCallTime = null;
        
        /**
         * TextView for call duration.
         */
        @org.jetbrains.annotations.NotNull()
        private final com.contusfly.views.CustomTextView txtCallDurationTime = null;
        
        /**
         * Incoming or outgoing call type
         */
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imageViewCallIcon = null;
        
        /**
         * The call status image.
         */
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imgCallStatus = null;
        
        /**
         * Email icon view for email contacts.
         */
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.views.CircularImageView emailContactIcon;
        
        /**
         * The name of the Roster.
         */
        @org.jetbrains.annotations.NotNull()
        private final androidx.emoji.widget.EmojiAppCompatTextView txtChatPersonName = null;
        
        public CallHistorySearchViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.views.CircularImageView getImgRoster() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.views.CustomTextView getTxtCallTime() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.views.CustomTextView getTxtCallDurationTime() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImageViewCallIcon() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgCallStatus() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.views.CircularImageView getEmailContactIcon() {
            return null;
        }
        
        public final void setEmailContactIcon(@org.jetbrains.annotations.NotNull()
        com.contusfly.views.CircularImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.emoji.widget.EmojiAppCompatTextView getTxtChatPersonName() {
            return null;
        }
    }
}