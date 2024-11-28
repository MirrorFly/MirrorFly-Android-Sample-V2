package com.contusfly.call.calllog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002@ABE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017J\u0006\u0010\u0018\u001a\u00020\u0015J$\u0010\u0019\u001a\u00020\u00152\n\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0006\u0010\u001e\u001a\u00020\u0015J\u001e\u0010\u001f\u001a\u00020\u00152\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bJ\u0010\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\"\u001a\u00020\u0013H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J$\u0010&\u001a\u00020\u00152\u0006\u0010\'\u001a\u00020(2\n\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0006\u0010)\u001a\u00020\u0015J\u0018\u0010*\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J&\u0010*\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0013H\u0016J\u001c\u00102\u001a\u00020\u00152\n\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u00103\u001a\u000204H\u0002J\u001c\u00105\u001a\u00020\u00152\n\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0006\u00106\u001a\u00020\u0015J\u001c\u00107\u001a\u00020\u00152\n\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u00108\u001a\u00020\u0007H\u0002J\u001c\u00109\u001a\u00020\u00152\n\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u00108\u001a\u00020\u0007H\u0002J\u001c\u0010:\u001a\u00020\u00152\n\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u00108\u001a\u00020\u0007H\u0002J\u001c\u0010;\u001a\u00020\u00152\n\u0010\u001a\u001a\u00060\u001bR\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0018\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/contusfly/call/calllog/CallHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "callLogsList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/flycall/call/database/model/CallLog;", "Lkotlin/collections/ArrayList;", "selectedCallLogs", "", "listener", "Lcom/contusfly/call/calllog/CallHistoryAdapter$OnItemClickListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/contusfly/call/calllog/CallHistoryAdapter$OnItemClickListener;)V", "getContext", "()Landroid/content/Context;", "isLoadingAdded", "", "loaderPosition", "", "addCallLogList", "", "callList", "", "addLoadingFooter", "bindCallData", "holder", "Lcom/contusfly/call/calllog/CallHistoryAdapter$CallHistoryViewHolder;", "callLog", "position", "clearCallLogs", "deleteCallLogList", "callidList", "getCallLogAtPosition", "getItemCount", "getItemId", "", "getItemViewType", "handlePayloads", "bundle", "Landroid/os/Bundle;", "loaderChecking", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "profileIcon", "roster", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "profileIconForManyUsers", "removeLoadingFooter", "setCallStatusIcon", "callLogs", "setCallType", "setIconAlpha", "setUserView", "updateSelectedItem", "view", "Landroid/view/View;", "isSelected", "CallHistoryViewHolder", "OnItemClickListener", "app_debug"})
public final class CallHistoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.mirrorflysdk.flycall.call.database.model.CallLog> callLogsList = null;
    private final java.util.ArrayList<java.lang.String> selectedCallLogs = null;
    private com.contusfly.call.calllog.CallHistoryAdapter.OnItemClickListener listener;
    private boolean isLoadingAdded = false;
    private int loaderPosition = -1;
    
    public CallHistoryAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.flycall.call.database.model.CallLog> callLogsList, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> selectedCallLogs, @org.jetbrains.annotations.NotNull
    com.contusfly.call.calllog.CallHistoryAdapter.OnItemClickListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void clearCallLogs() {
    }
    
    public final void addLoadingFooter() {
    }
    
    public final void removeLoadingFooter() {
    }
    
    public final void addCallLogList(@org.jetbrains.annotations.NotNull
    java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog> callList) {
    }
    
    public final void deleteCallLogList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> callidList) {
    }
    
    public final void loaderChecking() {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    private final void bindCallData(com.contusfly.call.calllog.CallHistoryAdapter.CallHistoryViewHolder holder, com.mirrorflysdk.flycall.call.database.model.CallLog callLog, int position) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Object> payloads) {
    }
    
    private final void handlePayloads(android.os.Bundle bundle, com.contusfly.call.calllog.CallHistoryAdapter.CallHistoryViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public long getItemId(int position) {
        return 0L;
    }
    
    /**
     * Selected view when long press it
     *
     * @param view     Instance of the view
     * @param isSelected item selected or not
     */
    private final void updateSelectedItem(android.view.View view, boolean isSelected) {
    }
    
    /**
     * Get the Call log position form the
     *
     * @param position holder position
     * @return list position
     */
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.flycall.call.database.model.CallLog getCallLogAtPosition(int position) {
        return null;
    }
    
    /**
     * This method is getting the caller name and profile picture
     *
     * @param holder holder instance
     * @param position adapter position
     */
    private final void setUserView(com.contusfly.call.calllog.CallHistoryAdapter.CallHistoryViewHolder holder, int position) {
    }
    
    private final void profileIconForManyUsers(com.contusfly.call.calllog.CallHistoryAdapter.CallHistoryViewHolder holder, int position) {
    }
    
    private final void profileIcon(com.contusfly.call.calllog.CallHistoryAdapter.CallHistoryViewHolder holder, com.mirrorflysdk.api.contacts.ProfileDetails roster) {
    }
    
    private final void setCallType(com.contusfly.call.calllog.CallHistoryAdapter.CallHistoryViewHolder holder, com.mirrorflysdk.flycall.call.database.model.CallLog callLogs) {
    }
    
    private final void setIconAlpha(com.contusfly.call.calllog.CallHistoryAdapter.CallHistoryViewHolder holder, com.mirrorflysdk.flycall.call.database.model.CallLog callLogs) {
    }
    
    private final void setCallStatusIcon(com.contusfly.call.calllog.CallHistoryAdapter.CallHistoryViewHolder holder, com.mirrorflysdk.flycall.call.database.model.CallLog callLogs) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/call/calllog/CallHistoryAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/widget/ImageView;", "position", "", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull
        android.widget.ImageView view, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\r0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0019\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00150\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00150\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u001b0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2 = {"Lcom/contusfly/call/calllog/CallHistoryAdapter$CallHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/contusfly/call/calllog/CallHistoryAdapter;Landroid/view/View;)V", "emailContactIcon", "Lcom/contusfly/views/CircularImageView;", "kotlin.jvm.PlatformType", "getEmailContactIcon", "()Lcom/contusfly/views/CircularImageView;", "setEmailContactIcon", "(Lcom/contusfly/views/CircularImageView;)V", "imageViewCallIcon", "Landroid/widget/ImageView;", "getImageViewCallIcon", "()Landroid/widget/ImageView;", "imgCallStatus", "getImgCallStatus", "imgRoster", "getImgRoster", "txtCallDurationTime", "Lcom/contusfly/views/CustomTextView;", "getTxtCallDurationTime", "()Lcom/contusfly/views/CustomTextView;", "txtCallTime", "getTxtCallTime", "txtChatPersonName", "Landroidx/emoji/widget/EmojiAppCompatTextView;", "getTxtChatPersonName", "()Landroidx/emoji/widget/EmojiAppCompatTextView;", "viewDiver", "getViewDiver", "()Landroid/view/View;", "app_debug"})
    public final class CallHistoryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        /**
         * The image view of the Roster.
         */
        private final com.contusfly.views.CircularImageView imgRoster = null;
        
        /**
         * TextView for call start time
         */
        private final com.contusfly.views.CustomTextView txtCallTime = null;
        
        /**
         * TextView for call duration.
         */
        private final com.contusfly.views.CustomTextView txtCallDurationTime = null;
        
        /**
         * Incoming or outgoing call type
         */
        private final android.widget.ImageView imageViewCallIcon = null;
        
        /**
         * The call status image.
         */
        private final android.widget.ImageView imgCallStatus = null;
        
        /**
         * Email icon view for email contacts.
         */
        private com.contusfly.views.CircularImageView emailContactIcon;
        
        /**
         * The name of the Roster.
         */
        private final androidx.emoji.widget.EmojiAppCompatTextView txtChatPersonName = null;
        @org.jetbrains.annotations.Nullable
        private final android.view.View viewDiver = null;
        
        public CallHistoryViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final com.contusfly.views.CircularImageView getImgRoster() {
            return null;
        }
        
        public final com.contusfly.views.CustomTextView getTxtCallTime() {
            return null;
        }
        
        public final com.contusfly.views.CustomTextView getTxtCallDurationTime() {
            return null;
        }
        
        public final android.widget.ImageView getImageViewCallIcon() {
            return null;
        }
        
        public final android.widget.ImageView getImgCallStatus() {
            return null;
        }
        
        public final com.contusfly.views.CircularImageView getEmailContactIcon() {
            return null;
        }
        
        public final void setEmailContactIcon(com.contusfly.views.CircularImageView p0) {
        }
        
        public final androidx.emoji.widget.EmojiAppCompatTextView getTxtChatPersonName() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.view.View getViewDiver() {
            return null;
        }
    }
}