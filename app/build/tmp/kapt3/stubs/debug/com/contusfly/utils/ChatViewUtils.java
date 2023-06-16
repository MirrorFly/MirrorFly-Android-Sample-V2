package com.contusfly.utils;

import java.lang.System;

/**
 * This Class is used for time related operation in Chat.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\"\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/utils/ChatViewUtils;", "", "()V", "getDateFromTimestamp", "", "timeStamp", "", "setUserPresenceStatus", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "status", "showSelectedImages", "toUser", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_debug"})
public final class ChatViewUtils {
    
    public ChatViewUtils() {
        super();
    }
    
    /**
     * Get the date from the timestamp with the dd/MM/yyyy format
     *
     * @param timeStamp Time stamp of the message
     * @return String Formatted date
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDateFromTimestamp(long timeStamp) {
        return null;
    }
    
    /**
     * Displays the presence status of the chat user in the [android.app.ActionBar]
     * of the current activity. Shows online if the user presence is available,
     * otherwise displays the user's last seen time.
     *
     * @param activity The startupActivityContext of the current activity.
     * @param status   The status of the chat user to be displayed.
     */
    public final void setUserPresenceStatus(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity, @org.jetbrains.annotations.Nullable()
    java.lang.String status) {
    }
    
    /**
     * Redirect to show selected images preview
     *
     * @param toUser  Selected user
     * @param context Instance of the activity
     * @param intent  Intent data
     */
    public final void showSelectedImages(@org.jetbrains.annotations.Nullable()
    java.lang.String toUser, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
}