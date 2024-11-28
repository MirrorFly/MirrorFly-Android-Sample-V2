package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/utils/ChatUserTimeUtils;", "", "()V", "equalsWithYesterday", "", "timestamp", "", "day", "", "getDateFromTimestamp", "timeStamp", "getFormattedTime", "timeConsume", "", "scheduledDateTimeFormat", "app_debug"})
public final class ChatUserTimeUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.ChatUserTimeUtils INSTANCE = null;
    
    private ChatUserTimeUtils() {
        super();
    }
    
    /**
     * Gets the formatted time.
     *
     * @param timeConsume Timestamp
     * @return String The formatted time
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFormattedTime(int timeConsume) {
        return null;
    }
    
    /**
     * Get the date from the timestamp with the dd/MM/yyyy format
     *
     * @param timeStamp Time stamp of the message
     * @return String Formatted date
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDateFromTimestamp(long timeStamp) {
        return null;
    }
    
    /**
     * Check the time is equal with today or yesterday in the chat view.
     *
     * @param timestamp Timestamp of the chat
     * @param day       Today or yesterday
     * @return boolean True if equals with the day
     */
    public final boolean equalsWithYesterday(long timestamp, @org.jetbrains.annotations.NotNull
    java.lang.String day) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String scheduledDateTimeFormat(long timestamp) {
        return null;
    }
}