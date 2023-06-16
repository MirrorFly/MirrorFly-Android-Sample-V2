package com.contusfly.call.calllog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/call/calllog/CallHistoryDetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/contusfly/call/calllog/CallHistoryDetailAdapter$CallHistoryDetailViewHolder;", "context", "Landroid/content/Context;", "userList", "Ljava/util/ArrayList;", "", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CallHistoryDetailViewHolder", "app_debug"})
public final class CallHistoryDetailAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.contusfly.call.calllog.CallHistoryDetailAdapter.CallHistoryDetailViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private java.util.ArrayList<java.lang.String> userList;
    
    public CallHistoryDetailAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> userList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.contusfly.call.calllog.CallHistoryDetailAdapter.CallHistoryDetailViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.calllog.CallHistoryDetailAdapter.CallHistoryDetailViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/call/calllog/CallHistoryDetailAdapter$CallHistoryDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/contusfly/call/calllog/CallHistoryDetailAdapter;Landroid/view/View;)V", "emailContactIcon", "Lcom/contusfly/views/CircularImageView;", "kotlin.jvm.PlatformType", "getEmailContactIcon", "()Lcom/contusfly/views/CircularImageView;", "setEmailContactIcon", "(Lcom/contusfly/views/CircularImageView;)V", "imgRoster", "getImgRoster", "txtChatPersonName", "Landroidx/emoji/widget/EmojiAppCompatTextView;", "getTxtChatPersonName", "()Landroidx/emoji/widget/EmojiAppCompatTextView;", "app_debug"})
    public final class CallHistoryDetailViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        /**
         * The image view of the Roster.
         */
        private final com.contusfly.views.CircularImageView imgRoster = null;
        
        /**
         * Email icon view for email contacts.
         */
        private com.contusfly.views.CircularImageView emailContactIcon;
        
        /**
         * The name of the Roster.
         */
        private final androidx.emoji.widget.EmojiAppCompatTextView txtChatPersonName = null;
        
        public CallHistoryDetailViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final com.contusfly.views.CircularImageView getImgRoster() {
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
    }
}