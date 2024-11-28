package com.contusfly.utils;

import java.lang.System;

/**
 * This Class is used for time related operation in Chat.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\"\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/contusfly/utils/ChatViewUtils;", "", "()V", "addContact", "", "activity", "Landroid/app/Activity;", "contactNumber", "", "getDateFromTimestamp", "timeStamp", "", "isContactPermissionAvailable", "", "context", "Landroid/content/Context;", "setUserPresenceStatus", "Landroidx/appcompat/app/AppCompatActivity;", "status", "showSelectedImages", "toUser", "intent", "Landroid/content/Intent;", "Companion", "app_debug"})
public final class ChatViewUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.ChatViewUtils.Companion Companion = null;
    
    /**
     * The request code for adding the unknown participant into the contacts app.
     */
    public static final int INSERT_CONTACT = 1001;
    
    public ChatViewUtils() {
        super();
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
    
    /**
     * Displays the presence status of the chat user in the [android.app.ActionBar]
     * of the current activity. Shows online if the user presence is available,
     * otherwise displays the user's last seen time.
     *
     * @param activity The startupActivityContext of the current activity.
     * @param status   The status of the chat user to be displayed.
     */
    public final void setUserPresenceStatus(@org.jetbrains.annotations.NotNull
    androidx.appcompat.app.AppCompatActivity activity, @org.jetbrains.annotations.Nullable
    java.lang.String status) {
    }
    
    /**
     * Redirect to show selected images preview
     *
     * @param toUser  Selected user
     * @param context Instance of the activity
     * @param intent  Intent data
     */
    public final void showSelectedImages(@org.jetbrains.annotations.Nullable
    java.lang.String toUser, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    /**
     * Starts an intent to add the contact number in the contacts app.
     *
     * @param activity      The calling activity.
     * @param contactNumber The contact number to be added.
     */
    public final void addContact(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    java.lang.String contactNumber) {
    }
    
    /**
     * Determine whether user have granted the permission to read and write the contacts.
     *
     * @param context The parent startupActivityContext.
     * @return True if app has the permission or false if not.
     */
    public final boolean isContactPermissionAvailable(@org.jetbrains.annotations.Nullable
    android.content.Context context) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/utils/ChatViewUtils$Companion;", "", "()V", "INSERT_CONTACT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}