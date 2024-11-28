package com.contusfly.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001cH\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u001fJ\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020*2\u0006\u0010$\u001a\u00020\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u0010-\u001a\u00020\u001fJ\u0010\u0010.\u001a\u0004\u0018\u00010\u001c2\u0006\u0010-\u001a\u00020\u001fJ.\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u001c00j\b\u0012\u0004\u0012\u00020\u001c`12\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c032\b\b\u0002\u00104\u001a\u00020\bJ\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c032\u0006\u00106\u001a\u00020\u001fH\u0002J4\u00107\u001a\b\u0012\u0004\u0012\u00020\u001c032\u0006\u0010\'\u001a\u00020\u001f2\u0006\u00108\u001a\u00020*2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u001c00j\b\u0012\u0004\u0012\u00020\u001c`1J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020!H\u0002J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001f0<2\u0006\u0010\'\u001a\u00020\u001fJ:\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0>j\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b`?2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u001f00j\b\u0012\u0004\u0012\u00020\u001f`1J\u000e\u0010A\u001a\u00020\b2\u0006\u0010\'\u001a\u00020\u001fJ\b\u0010B\u001a\u00020&H\u0002J\u001e\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020!2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c03H\u0002J\u000e\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u001fJ\u0018\u0010H\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020*H\u0002J*\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0K2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u001f00j\b\u0012\u0004\u0012\u00020\u001f`1J\u0012\u0010L\u001a\u00020&2\b\u0010$\u001a\u0004\u0018\u00010\u001cH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006M"}, d2 = {"Lcom/contusfly/repository/MessageRepository;", "", "()V", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "canBeCopied", "", "canBeCopiedSet", "canBeDeleted", "canBeDeletedSet", "canBeForwarded", "canBeForwardedSet", "canBeReplied", "canBeShared", "canBeSharedSet", "canBeStarred", "canBeUnStarred", "canShowInfo", "canShowReport", "chatTimeOperations", "Lcom/contusfly/utils/ChatTimeOperations;", "containsRecalled", "containsRecalledSet", "dateFormat", "Ljava/text/SimpleDateFormat;", "addDateHeaderMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "item", "checkTwoDigitsForDate", "", "date", "", "createDateHeaderMessageWithDate", "dateText", "message", "deleteUnreadMessageSeparator", "", "jid", "getDateFromTimestamp", "timeStamp", "", "getDateID", "getMessageForId", "mid", "getMessageForReply", "getMessageListWithDate", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "messageList", "", "skipFirstMessage", "getMessages", "userJid", "getMessagesAfter", "time", "getMonthForInt", "num", "getRecalledMessageOfAnUser", "", "handleActionMenuVisibilityValidation", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "messages", "hasUserStarredAnyMessage", "initBoolean", "isDateChanged", "position", "mChatData", "isEditAvailableForGivenMessages", "messageId", "isMessageCanEditable", "editableTime", "isRecallAvailableForGivenMessages", "Lkotlin/Pair;", "validateMessage", "app_debug"})
@javax.inject.Singleton
public final class MessageRepository {
    @org.jetbrains.annotations.NotNull
    private final java.util.Calendar calendar = null;
    private boolean containsRecalled = false;
    private boolean containsRecalledSet = false;
    private boolean canBeStarred = true;
    private boolean canBeUnStarred = true;
    private boolean canBeShared = true;
    private boolean canBeSharedSet = false;
    private boolean canBeForwarded = true;
    private boolean canBeForwardedSet = false;
    private boolean canBeDeleted = true;
    private boolean canBeDeletedSet = true;
    private boolean canBeReplied = true;
    private boolean canBeCopied = true;
    private boolean canBeCopiedSet = false;
    private boolean canShowInfo = true;
    private boolean canShowReport = true;
    private final com.contusfly.utils.ChatTimeOperations chatTimeOperations = null;
    private final java.text.SimpleDateFormat dateFormat = null;
    
    public MessageRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> getMessageListWithDate(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messageList, boolean skipFirstMessage) {
        return null;
    }
    
    /**
     * Checks the current header id with previous header id
     *
     * @param position Position of the current item
     * @return boolean True if header changed, else false
     */
    private final boolean isDateChanged(int position, java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> mChatData) {
        return false;
    }
    
    /**
     * Returns header Id of the
     *
     * @param message message object
     * @return long Header id of the list
     */
    public final long getDateID(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
        return 0L;
    }
    
    private final com.mirrorflysdk.api.models.ChatMessage addDateHeaderMessage(com.mirrorflysdk.api.models.ChatMessage item) {
        return null;
    }
    
    /**
     * Get the date from the timestamp with the dd/MM/yyyy format
     *
     * @param timeStamp Time stamp of the message
     * @return String Formatted date
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDateFromTimestamp(long timeStamp) {
        return null;
    }
    
    private final java.lang.String getMonthForInt(int num) {
        return null;
    }
    
    private final java.lang.String checkTwoDigitsForDate(int date) {
        return null;
    }
    
    /**
     * Create date message
     *
     * @param dateText Text to show
     */
    private final com.mirrorflysdk.api.models.ChatMessage createDateHeaderMessageWithDate(java.lang.String dateText, com.mirrorflysdk.api.models.ChatMessage message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mirrorflysdk.api.models.ChatMessage> getMessagesAfter(@org.jetbrains.annotations.NotNull
    java.lang.String jid, long time, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messageList) {
        return null;
    }
    
    private final void initBoolean() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, java.lang.Boolean> handleActionMenuVisibilityValidation(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> messages) {
        return null;
    }
    
    private final void validateMessage(com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.api.models.ChatMessage getMessageForId(@org.jetbrains.annotations.NotNull
    java.lang.String mid) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.api.models.ChatMessage getMessageForReply(@org.jetbrains.annotations.NotNull
    java.lang.String mid) {
        return null;
    }
    
    public final void deleteUnreadMessageSeparator(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    public final boolean hasUserStarredAnyMessage(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<java.lang.Boolean, java.lang.Boolean> isRecallAvailableForGivenMessages(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> messages) {
        return null;
    }
    
    public final boolean isEditAvailableForGivenMessages(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
        return false;
    }
    
    private final boolean isMessageCanEditable(com.mirrorflysdk.api.models.ChatMessage message, long editableTime) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getRecalledMessageOfAnUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
        return null;
    }
    
    private final java.util.List<com.mirrorflysdk.api.models.ChatMessage> getMessages(java.lang.String userJid) {
        return null;
    }
}