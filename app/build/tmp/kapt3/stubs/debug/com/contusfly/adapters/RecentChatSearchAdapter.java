package com.contusfly.adapters;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003YZ[B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0006\u0010+\u001a\u00020\u0013J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0012H\u0002J\u001a\u0010.\u001a\u00020\u00132\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011J\u0018\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u0002022\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u00103\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u00106\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010\"\u001a\u00020#H\u0002J\u000e\u00109\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\rJ\u0018\u0010:\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010;\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\rH\u0002J\u000e\u0010B\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0012J\u0016\u0010C\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010D\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0012J&\u0010E\u001a\u00020\u00132\u0016\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020I2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\"\u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020I2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020OH\u0002J<\u0010P\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010Q\u001a\u00020I2\b\u0010R\u001a\u0004\u0018\u00010\u00182\u0006\u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020\u00122\u0006\u0010N\u001a\u00020OH\u0002J \u0010U\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0002J \u0010V\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0002J \u0010W\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0002J \u0010X\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\\"}, d2 = {"Lcom/contusfly/adapters/RecentChatSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "recentSearchList", "Ljava/util/ArrayList;", "Lcom/contusfly/models/RecentSearch;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "isLoadingAdded", "", "isPaginate", "isRecentChat", "onSearchItemClicked", "Lkotlin/Function1;", "", "", "recentChatCount", "recentContactCount", "recentMessageCount", "searchKey", "", "addLoadingFooter", "canEnableHeader", "position", "enableHeader", "viewBinding", "Lcom/contusfly/databinding/RowSearchContactMessageBinding;", "getItemCount", "getItemViewType", "imageCaptionHighlight", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "recentSearchItemOnclick", "removeLoadingFooter", "returnFormattedCount", "count", "searchItemClickedCallback", "fn", "setAdapterIcon", "profileDetail", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "setArchivedAndPinLabel", "recent", "Lcom/mirrorflysdk/api/models/RecentChat;", "setImageStatus", "msgType", "Lcom/mirrorflysdk/flycommons/models/MessageType;", "setIsRecentChat", "setMessageData", "setMessageStatus", "messageStatusImageView", "Landroid/widget/ImageView;", "setMessageView", "msgId", "setRecalledMessageText", "isFromSender", "setRecentChatCount", "setRecentContactCount", "setRecentMessageCount", "setRecentSearch", "recentChats", "setSearchHeader", "headerSearchRecent", "Lcom/contusfly/views/CustomTextView;", "setSearchTextHighlightExceptionMention", "txtChat", "fromHtml", "Landroid/text/Spanned;", "mentionedUserName", "Landroid/text/SpannableStringBuilder;", "setTextAndHighLightSearchTextForMention", "textView", "text", "startIndex", "stopIndex", "setUserView", "viewContactItem", "viewMessageItem", "viewRecentChatItem", "Companion", "ProgressViewHolder", "RecentChatSearchViewHolder", "app_debug"})
public final class RecentChatSearchAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private java.util.ArrayList<com.contusfly.models.RecentSearch> recentSearchList;
    
    /**
     * Search string key
     */
    private java.lang.String searchKey;
    
    /**
     * Recent Message count
     */
    private int recentMessageCount = 0;
    
    /**
     * Recent contact count
     */
    private int recentContactCount = 0;
    
    /**
     * Recent chat count
     */
    private int recentChatCount = 0;
    private boolean isLoadingAdded = false;
    
    /**
     * Is called from recent chat or not
     */
    private boolean isRecentChat = true;
    private boolean isPaginate = false;
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onSearchItemClicked;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.adapters.RecentChatSearchAdapter.Companion Companion = null;
    private static final int LOADING = 0;
    private static final int ITEM = 1;
    
    public RecentChatSearchAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.contusfly.models.RecentSearch> recentSearchList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void searchItemClickedCallback(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> fn) {
    }
    
    /**
     * Sets the recent search item and search key in the chat list view.
     *
     * @param recentChats Recent chat data
     * @param searchKey   Key to search
     */
    public final void setRecentSearch(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.contusfly.models.RecentSearch> recentChats, @org.jetbrains.annotations.NotNull()
    java.lang.String searchKey) {
    }
    
    public final void setRecentChatCount(int recentChatCount) {
    }
    
    public final void setRecentContactCount(int recentContactCount, boolean isPaginate) {
    }
    
    public final void setRecentMessageCount(int recentMessageCount) {
    }
    
    public final void setIsRecentChat(boolean isRecentChat) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @kotlin.Suppress(names = {"NAME_SHADOWING"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    private final void recentSearchItemOnclick(int position) {
    }
    
    /**
     * Display the searched message view item
     *
     * @param viewBinding    Holder of the Chat item
     * @param position  Position of the selected item
     * @param profileDetail    Instance of ProfileDetail
     */
    private final void viewMessageItem(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, int position, com.mirrorflysdk.api.contacts.ProfileDetails profileDetail) {
    }
    
    /**
     * Set the message view of the recent chat users. get the message ov]bject and display based on ext or Message type
     *
     * @param msgId  Message id
     * @param viewBinding Holder for the view
     */
    private final void setMessageView(java.lang.String msgId, com.contusfly.databinding.RowSearchContactMessageBinding viewBinding) {
    }
    
    private final void setTextAndHighLightSearchTextForMention(android.content.Context context, com.contusfly.views.CustomTextView textView, java.lang.String text, int startIndex, int stopIndex, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    private final void setSearchTextHighlightExceptionMention(com.contusfly.views.CustomTextView txtChat, android.text.Spanned fromHtml, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    /**
     * Set the message data from the message view
     *
     * @param viewBinding  Holder of the view
     * @param message Instance of the Message
     */
    private final void setMessageData(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final void imageCaptionHighlight(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Sets the image status of the chat type => Audio => Video => Image => LocationMessage => Contact
     *
     * @param viewBinding  Holder of the view
     * @param msgType Type of the message
     */
    private final void setImageStatus(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, com.mirrorflysdk.flycommons.models.MessageType msgType, com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Set the message status of the message and enable the status(Single,Double and Seen tick)
     *
     * @param message                Instance of the Message
     * @param messageStatusImageView Image view to display the status
     */
    private final void setMessageStatus(com.mirrorflysdk.api.models.ChatMessage message, android.widget.ImageView messageStatusImageView) {
    }
    
    /**
     * Sets the text to be displayed.
     *
     * @param viewBinding       The view holding the child items.
     * @param isFromSender Boolean stating whether the recall is either from sender or receiver.
     * @return The information about the recalled message.
     */
    private final java.lang.String setRecalledMessageText(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, boolean isFromSender) {
        return null;
    }
    
    private final void setAdapterIcon(com.mirrorflysdk.api.contacts.ProfileDetails profileDetail, com.contusfly.databinding.RowSearchContactMessageBinding viewBinding) {
    }
    
    public final void addLoadingFooter() {
    }
    
    public final void removeLoadingFooter() {
    }
    
    /**
     * Display the searched contact item
     *
     * @param holder    Holder of the Chat item
     * @param position  Position of the selected item
     * @param profileDetail    Instance of ProfileDetail
     */
    private final void viewContactItem(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, int position, com.mirrorflysdk.api.contacts.ProfileDetails profileDetail) {
    }
    
    /**
     * Display the searched recent chat item
     *
     * @param holder   Holder of the Chat item
     * @param position Position of the selected item
     */
    private final void viewRecentChatItem(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, int position, com.mirrorflysdk.api.contacts.ProfileDetails profileDetail) {
    }
    
    /**
     * Set Archived and Pin label for the chat.
     *
     * @param recent  RecentChat of the User/Group
     * @param viewBinding Holder of the view
     */
    private final void setArchivedAndPinLabel(com.mirrorflysdk.api.models.RecentChat recent, com.contusfly.databinding.RowSearchContactMessageBinding viewBinding) {
    }
    
    /**
     * Set the user view for the recent chat items Set the user information or users from the normal users.
     *
     * @param viewBinding       Holder of the view
     * @param position     Position of the list item
     * @param profileDetail       Instance of ProfileDetail
     */
    private final void setUserView(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, int position, com.mirrorflysdk.api.contacts.ProfileDetails profileDetail) {
    }
    
    /**
     * Enable the header, that might be Chats or Messages or Contacts.
     *
     * @param viewBinding   View holder of the Chat view
     * @param position Position of the List
     */
    private final void enableHeader(com.contusfly.databinding.RowSearchContactMessageBinding viewBinding, int position) {
    }
    
    /**
     * Check the header is needed for the chat item. Search type of the current item and previous item is different then return true
     *
     * @param position Position of the list item
     * @return boolean True if the header need to enable
     */
    private final boolean canEnableHeader(int position) {
        return false;
    }
    
    /**
     * Set the search header in the chat item, which is the Search type
     *
     * @param headerSearchRecent TextView to display the chat item
     * @param position           Position of the list item
     */
    private final void setSearchHeader(com.contusfly.views.CustomTextView headerSearchRecent, int position) {
    }
    
    /**
     * Return formatted unread count for the Recent chat.
     *
     * @param count Count of Unread message
     * @return String Converted string count
     */
    private final java.lang.String returnFormattedCount(int count) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/RecentChatSearchAdapter$RecentChatSearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/contusfly/databinding/RowSearchContactMessageBinding;", "(Lcom/contusfly/databinding/RowSearchContactMessageBinding;)V", "getViewBinding", "()Lcom/contusfly/databinding/RowSearchContactMessageBinding;", "setViewBinding", "app_debug"})
    public static final class RecentChatSearchViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.databinding.RowSearchContactMessageBinding viewBinding;
        
        public RecentChatSearchViewHolder(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowSearchContactMessageBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.databinding.RowSearchContactMessageBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowSearchContactMessageBinding p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/adapters/RecentChatSearchAdapter$ProgressViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "progressViewBinding", "Lcom/contusfly/databinding/RowProgressBarBinding;", "(Lcom/contusfly/databinding/RowProgressBarBinding;)V", "getProgressViewBinding", "()Lcom/contusfly/databinding/RowProgressBarBinding;", "setProgressViewBinding", "app_debug"})
    public static final class ProgressViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.contusfly.databinding.RowProgressBarBinding progressViewBinding;
        
        public ProgressViewHolder(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowProgressBarBinding progressViewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.databinding.RowProgressBarBinding getProgressViewBinding() {
            return null;
        }
        
        public final void setProgressViewBinding(@org.jetbrains.annotations.NotNull()
        com.contusfly.databinding.RowProgressBarBinding p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/adapters/RecentChatSearchAdapter$Companion;", "", "()V", "ITEM", "", "LOADING", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}