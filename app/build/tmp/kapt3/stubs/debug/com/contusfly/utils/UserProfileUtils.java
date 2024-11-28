package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/utils/UserProfileUtils;", "", "()V", "changeUpdateStatus", "", "intent", "Landroid/content/Intent;", "userActionUpdate", "Lcom/contusfly/views/CustomTextView;", "context", "Landroid/content/Context;", "closeProgress", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "previewUserImage", "activity", "Landroid/app/Activity;", "userImgUrl", "", "currentUserJid", "app_debug"})
public final class UserProfileUtils {
    
    public UserProfileUtils() {
        super();
    }
    
    /**
     * Redirect to image preview to preview the user image
     *
     * @param activity   Activity of the View
     * @param userImgUrl User profile image url
     */
    public final void previewUserImage(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    java.lang.String userImgUrl, @org.jetbrains.annotations.NotNull
    java.lang.String currentUserJid) {
    }
    
    /**
     * Change the status of update button after changing user image
     *
     * @param intent           Intent from the previous activity
     * @param userActionUpdate User update TextView
     * @param context          Instance of Context
     */
    public final void changeUpdateStatus(@org.jetbrains.annotations.NotNull
    android.content.Intent intent, @org.jetbrains.annotations.NotNull
    com.contusfly.views.CustomTextView userActionUpdate, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    /**
     * Close progress dialog after the completion of the any background tasks.
     *
     * @param progressDialog The progress dialog of the activity when run the background tasks
     */
    public final void closeProgress(@org.jetbrains.annotations.Nullable
    com.contusfly.views.DoProgressDialog progressDialog) {
    }
}