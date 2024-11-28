package com.contusfly.backup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/backup/TimeAgo;", "", "()V", "currentDate", "Ljava/util/Date;", "getTimeAgo", "", "dateInLong", "", "ctx", "Landroid/content/Context;", "getTimeDistanceInMinutes", "", "time", "lastBackupTimeInfo", "timestamp", "yesterDay", "app_debug"})
public final class TimeAgo {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.backup.TimeAgo INSTANCE = null;
    
    private TimeAgo() {
        super();
    }
    
    /**
     * Get the System Current Data
     *
     * @return Date today
     */
    private final java.util.Date currentDate() {
        return null;
    }
    
    /**
     * Given the date as a Relative Human Readable String
     *
     * @param dateInLong Long date in milliseconds
     * @param ctx Context android Context
     * @return String relative time
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTimeAgo(long dateInLong, @org.jetbrains.annotations.NotNull
    android.content.Context ctx) {
        return null;
    }
    
    /**
     * Returns the rounded difference between the current system time and given time in long
     *
     * @param time Long for which difference we need
     * @return Int difference between the time
     */
    private final int getTimeDistanceInMinutes(long time) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    public final java.lang.String lastBackupTimeInfo(long timestamp) {
        return null;
    }
    
    private final java.lang.String yesterDay(long timestamp) {
        return null;
    }
}