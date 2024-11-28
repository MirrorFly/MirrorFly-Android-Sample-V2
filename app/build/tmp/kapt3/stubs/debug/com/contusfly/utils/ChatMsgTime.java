package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/contusfly/utils/ChatMsgTime;", "", "calendar", "Ljava/util/Calendar;", "(Ljava/util/Calendar;)V", "getCalendar", "()Ljava/util/Calendar;", "hhmmDateFormat", "Ljava/text/SimpleDateFormat;", "hhmmaaDateFormat", "hmmDateFormat", "hmmaaDateFormat", "getDaySentMsg", "", "context", "Landroid/content/Context;", "epocheTime", "", "getHhmmDateFormat", "getHhmmaaDateFormat", "getHmmDateFormat", "getHmmaaDateFormat", "setDateHourFormat", "format", "", "hours", "app_debug"})
public final class ChatMsgTime {
    @org.jetbrains.annotations.NotNull
    private final java.util.Calendar calendar = null;
    
    /**
     * hh:mm aa DateFormat
     */
    private java.text.SimpleDateFormat hhmmaaDateFormat;
    
    /**
     * h:mm aa DateFormat
     */
    private java.text.SimpleDateFormat hmmaaDateFormat;
    
    /**
     * hh:mm DateFormat
     */
    private java.text.SimpleDateFormat hhmmDateFormat;
    
    /**
     * h:mm DateFormat
     */
    private java.text.SimpleDateFormat hmmDateFormat;
    
    public ChatMsgTime(@org.jetbrains.annotations.NotNull
    java.util.Calendar calendar) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    /**
     * Gets the day sent msg. The epoche time getting timestamp using date object getting the
     * current time using date format get the time format 12 or 24 getting the date format and
     * dateHourFormat using simpleDate format getting today time using calendar instance
     *
     * @param context    Instance of the startupActivityContext
     * @param epocheTime Timestamp of the Message
     * @return String Formatted date
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDaySentMsg(@org.jetbrains.annotations.Nullable
    android.content.Context context, long epocheTime) {
        return null;
    }
    
    /**
     * Set the date and time format
     *
     * @param format Hour format value
     * @param hours  Hour of the day
     * @return SimpleDateFormat Formatted date
     */
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat setDateHourFormat(int format, int hours) {
        return null;
    }
    
    private final java.text.SimpleDateFormat getHhmmaaDateFormat() {
        return null;
    }
    
    private final java.text.SimpleDateFormat getHmmaaDateFormat() {
        return null;
    }
    
    private final java.text.SimpleDateFormat getHhmmDateFormat() {
        return null;
    }
    
    private final java.text.SimpleDateFormat getHmmDateFormat() {
        return null;
    }
}