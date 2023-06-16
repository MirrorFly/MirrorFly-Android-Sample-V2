package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 ^2\u00020\u0001:\u0001^B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020+2\u0006\u0010,\u001a\u00020\fJ\u0016\u0010.\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u00020+J\u001c\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0\u0017032\u0006\u00104\u001a\u00020\fH\u0002J\u000e\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u0007J$\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0\u0017032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017H\u0002J\u0006\u00108\u001a\u00020\u000fJ\u001c\u00109\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0006\u0012\u0004\u0018\u00010\f0:2\u0006\u0010<\u001a\u00020\u0007J\u0010\u0010=\u001a\u0004\u0018\u00010\f2\u0006\u00106\u001a\u00020\u0007J\u0010\u0010>\u001a\u0004\u0018\u00010\f2\u0006\u00106\u001a\u00020\u0007J4\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u00106\u001a\u00020\u00072\u0006\u0010@\u001a\u00020A2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`BJ\u000e\u0010C\u001a\u00020+2\u0006\u00106\u001a\u00020\u0007J\u0010\u0010D\u001a\u0004\u0018\u00010E2\u0006\u00106\u001a\u00020\u0007J\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u00106\u001a\u00020\u0007J\u0012\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0\u00170\u0016J\u000e\u0010H\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007J*\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0J2\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`BJ\u000e\u0010L\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u0007J\b\u0010M\u001a\u00020+H\u0002J\u0016\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007J\u0006\u0010P\u001a\u00020\u000fJ\u0006\u0010Q\u001a\u00020\u000fJ*\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0:2\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`BJ\u000e\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020\u0007J\u0010\u0010U\u001a\u00020+2\b\b\u0002\u0010V\u001a\u00020\u0007J\u0010\u0010W\u001a\u00020+2\b\b\u0002\u0010V\u001a\u00020\u0007J\u0006\u0010X\u001a\u00020+J\u0018\u0010Y\u001a\u00020+2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0007H\u0002J\u0016\u0010[\u001a\u00020+2\u0006\u00106\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0007J\u000e\u0010]\u001a\u00020+2\u0006\u00106\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00170\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00170\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0\u00170&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006_"}, d2 = {"Lcom/contusfly/viewmodels/ChatParentViewModel;", "Landroidx/lifecycle/ViewModel;", "messageRepository", "Lcom/contusfly/repository/MessageRepository;", "(Lcom/contusfly/repository/MessageRepository;)V", "groupParticipantsName", "Landroidx/lifecycle/MutableLiveData;", "", "getGroupParticipantsName", "()Landroidx/lifecycle/MutableLiveData;", "initialMessageList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "getInitialMessageList", "loadSuggestion", "", "getLoadSuggestion", "messageListParams", "Lcom/mirrorflysdk/api/chat/FetchMessageListParams;", "messageListQuery", "Lcom/mirrorflysdk/api/chat/FetchMessageListQuery;", "messages", "Landroidx/lifecycle/LiveData;", "", "getMessages", "()Landroidx/lifecycle/LiveData;", "nextMessageList", "getNextMessageList", "paginationMessageList", "previousMessageList", "getPreviousMessageList", "remoteUserId", "removeTempDateHeader", "getRemoveTempDateHeader", "searchkeydata", "getSearchkeydata", "suggestionMessageList", "suggestions", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/google/firebase/ml/naturallanguage/smartreply/SmartReplySuggestion;", "toUser", "toUserJid", "addMessage", "", "message", "addSentMessage", "checkAndUpdateMessageList", "messageList", "clearChat", "clearSuggestions", "createSmartReply", "Lcom/google/android/gms/tasks/Task;", "lastMessage", "deleteUnreadMessageSeparator", "jid", "generateReplies", "getFetchingIsInProgress", "getMessageAndPosition", "Lkotlin/Pair;", "", "messageId", "getMessageForId", "getMessageForReply", "getMessagesAfterThisMessage", "time", "", "Lkotlin/collections/ArrayList;", "getParticipantsNameAsCsv", "getProfileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getRecalledMessageForThisUser", "getSuggestions", "getUnSentMessageForAnUser", "handleActionMenuVisibility", "Ljava/util/HashMap;", "messageIds", "hasUserStarredAnyMessage", "initSuggestionsGenerator", "isGroupUserExist", "groupId", "isLoadNextAvailable", "isLoadPreviousAvailable", "isMessagesCanBeRecalled", "loadInitialData", "loadFromMessageId", "loadNextData", "searchedText", "loadPreviousData", "removeMessages", "searchDataShare", "event", "setUnSentMessageForAnUser", "unsentMessage", "setUserJid", "Companion", "app_debug"})
public final class ChatParentViewModel extends androidx.lifecycle.ViewModel {
    private final com.contusfly.repository.MessageRepository messageRepository = null;
    
    /**
     * random generate string for user differntiation
     */
    private final java.lang.String remoteUserId = null;
    
    /**
     * list of smart reply suggestion
     */
    private final androidx.lifecycle.MediatorLiveData<java.util.List<com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion>> suggestions = null;
    
    /**
     * input list of message provided to the ML smart reply model
     */
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.models.ChatMessage>> suggestionMessageList = null;
    private com.mirrorflysdk.api.chat.FetchMessageListParams messageListParams;
    private com.mirrorflysdk.api.chat.FetchMessageListQuery messageListQuery;
    private final java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> paginationMessageList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage>> initialMessageList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage>> previousMessageList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage>> nextMessageList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> loadSuggestion = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeTempDateHeader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchkeydata = null;
    private java.lang.String toUser;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> groupParticipantsName = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.viewmodels.ChatParentViewModel.Companion Companion = null;
    private static final java.lang.String SMART_REPLY_EXCEPTION = "Not running smart reply!";
    private java.lang.String toUserJid;
    
    @javax.inject.Inject()
    public ChatParentViewModel(@org.jetbrains.annotations.NotNull()
    com.contusfly.repository.MessageRepository messageRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage>> getInitialMessageList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage>> getPreviousMessageList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage>> getNextMessageList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLoadSuggestion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRemoveTempDateHeader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSearchkeydata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getGroupParticipantsName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mirrorflysdk.api.models.ChatMessage>> getMessages() {
        return null;
    }
    
    /**
     * get the suggestion from the ML smart reply api
     *
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion>> getSuggestions() {
        return null;
    }
    
    /**
     * add message to the Ml model
     *
     * @param message add the received and sent messages
     */
    public final void addMessage(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.NotNull()
    java.lang.String toUser) {
    }
    
    /**
     * clear the suggestions
     */
    public final void clearSuggestions() {
    }
    
    public final void removeMessages() {
    }
    
    /**
     * initialise the suggestion generator
     */
    private final void initSuggestionsGenerator() {
    }
    
    /**
     * task for generating the suggestions
     *
     * @param messages list of messages given to the ml kit
     * @return reply suggestions
     */
    private final com.google.android.gms.tasks.Task<java.util.List<com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion>> generateReplies(java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messages) {
        return null;
    }
    
    private final com.google.android.gms.tasks.Task<java.util.List<com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion>> createSmartReply(com.mirrorflysdk.api.models.ChatMessage lastMessage) {
        return null;
    }
    
    public final void setUnSentMessageForAnUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String unsentMessage) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnSentMessageForAnUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.String, java.lang.Boolean> handleActionMenuVisibility(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> messageIds) {
        return null;
    }
    
    public final void setUserJid(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mirrorflysdk.api.models.ChatMessage> getMessagesAfterThisMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, long time, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messageList) {
        return null;
    }
    
    public final boolean hasUserStarredAnyMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.lang.Boolean> isMessagesCanBeRecalled(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> messageIds) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mirrorflysdk.api.models.ChatMessage getMessageForId(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mirrorflysdk.api.models.ChatMessage getMessageForReply(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getRecalledMessageForThisUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return null;
    }
    
    public final void deleteUnreadMessageSeparator(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mirrorflysdk.api.contacts.ProfileDetails getProfileDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return null;
    }
    
    public final boolean isGroupUserExist(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return false;
    }
    
    public final void getParticipantsNameAsCsv(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    public final void clearChat() {
    }
    
    public final void loadInitialData(@org.jetbrains.annotations.NotNull()
    java.lang.String loadFromMessageId) {
    }
    
    public final void loadPreviousData(@org.jetbrains.annotations.NotNull()
    java.lang.String searchedText) {
    }
    
    private final void searchDataShare(java.lang.String searchedText, java.lang.String event) {
    }
    
    public final void loadNextData(@org.jetbrains.annotations.NotNull()
    java.lang.String searchedText) {
    }
    
    public final void addSentMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final void checkAndUpdateMessageList(java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messageList) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Integer, com.mirrorflysdk.api.models.ChatMessage> getMessageAndPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId) {
        return null;
    }
    
    public final boolean isLoadPreviousAvailable() {
        return false;
    }
    
    public final boolean isLoadNextAvailable() {
        return false;
    }
    
    public final boolean getFetchingIsInProgress() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/viewmodels/ChatParentViewModel$Companion;", "", "()V", "SMART_REPLY_EXCEPTION", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}