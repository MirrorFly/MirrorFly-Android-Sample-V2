package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017J\n\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0017H\u0007J\n\u0010\"\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010#\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0017J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/contusfly/utils/ChatTimeOperations;", "", "calendar", "Ljava/util/Calendar;", "(Ljava/util/Calendar;)V", "getCalendar", "()Ljava/util/Calendar;", "callDateFormat", "Ljava/text/SimpleDateFormat;", "chatMsgTime", "Lcom/contusfly/utils/ChatMsgTime;", "commonDateFormat", "messageDate", "Ljava/util/Date;", "recentChatDateFormat", "equalsWithYesterday", "", "srcDate", "day", "", "getCallDateFormat", "getCallDurationTime", "startTime", "", "endTime", "getCallTime", "context", "Landroid/content/Context;", "epochTime", "getCommonDateFormat", "getDateInMilli", "timeStamp", "getFormattedCallDurationTime", "timeInMilliseconds", "getRecentChatDateFormat", "getRecentChatTime", "manipulateMessageTime", "app_debug"})
public final class ChatTimeOperations {
    @org.jetbrains.annotations.NotNull
    private final java.util.Calendar calendar = null;
    
    /**
     * Recent chat DateFormat
     */
    private java.text.SimpleDateFormat recentChatDateFormat;
    
    /**
     * Recent chat DateFormat
     */
    private java.text.SimpleDateFormat callDateFormat;
    
    /**
     * Common DateFormat
     */
    private java.text.SimpleDateFormat commonDateFormat;
    
    /**
     * chatMsg instance
     */
    private final com.contusfly.utils.ChatMsgTime chatMsgTime = null;
    
    /**
     * date object
     */
    private final java.util.Date messageDate = null;
    
    public ChatTimeOperations(@org.jetbrains.annotations.NotNull
    java.util.Calendar calendar) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    /**
     * Calculates the duration of call.
     *
     * @param startTime call start time
     * @param endTime   call end time
     * @return return the duration
     */
    @org.jetbrains.annotations.NotNull
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    public final java.lang.String getCallDurationTime(long startTime, long endTime) {
        return null;
    }
    
    /**
     * Returns message time in milli seconds removing time.
     *
     * @param timeStamp Timestamp
     * @return long Message date in milli without time
     */
    public final long getDateInMilli(long timeStamp) {
        return 0L;
    }
    
    /**
     * This function formats the the duration of call.
     *
     * @param timeInMilliseconds call duration in milliseconds
     * @return return the  formatted duration
     */
    @org.jetbrains.annotations.NotNull
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    public final java.lang.String getFormattedCallDurationTime(long timeInMilliseconds) {
        return null;
    }
    
    /**
     * Get the recent chat time in the recent chat view. It will display today time or YESTERDAY or
     * Date of the chat.
     *
     * @param context   Activity startupActivityContext
     * @param epochTime Timestamp of the chat
     * @return String Formatted date
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRecentChatTime(@org.jetbrains.annotations.Nullable
    android.content.Context context, long epochTime) {
        return null;
    }
    
    /**
     * Manipulates the message time related operations.
     *
     * @param context     the parent startupActivityContext.
     * @param messageDate the date of the message.
     */
    private final java.lang.String manipulateMessageTime(android.content.Context context, java.util.Date messageDate) {
        return null;
    }
    
    /**
     * Check the time is equal with today or yesterday in the chat view.
     *
     * @param srcDate Date of the chat
     * @param day     Today or yesterday
     * @return boolean True if equals with the day
     */
    @kotlin.Suppress(names = {"NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"})
    private final boolean equalsWithYesterday(java.util.Date srcDate, java.lang.String day) {
        return false;
    }
    
    /**
     * Set the call log date and time if the epoch time is current time its return today and time
     * in hour.
     *
     * @param context   startupActivityContext of the activity
     * @param epochTime call time in millisecond
     * @return return the date and time format
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCallTime(@org.jetbrains.annotations.NotNull
    android.content.Context context, long epochTime) {
        return null;
    }
    
    private final java.text.SimpleDateFormat getRecentChatDateFormat() {
        return null;
    }
    
    private final java.text.SimpleDateFormat getCallDateFormat() {
        return null;
    }
    
    private final java.text.SimpleDateFormat getCommonDateFormat() {
        return null;
    }
}