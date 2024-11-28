package com.contusfly.chat;

import java.lang.System;

/**
 * Common operations to invite synchronized contact people to install the application and start
 * chat invitation send through mobile sms or email
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J*\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ#\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/contusfly/chat/InviteContactUtils;", "", "()V", "copyLink", "", "context", "Landroid/content/Context;", "handleSelectedOptions", "position", "", "activity", "Landroid/app/Activity;", "email", "", "mobileNumber", "sendingInviteAsMail", "", "([Ljava/lang/String;Landroid/content/Context;)V", "sendingUserInviteAsSms", "app_debug"})
public final class InviteContactUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.chat.InviteContactUtils INSTANCE = null;
    
    private InviteContactUtils() {
        super();
    }
    
    /**
     * Getting email id of the user by clicking the view sending the app invite link to the user
     *
     * @param email   List of email
     * @param context Instance of the application
     */
    private final void sendingInviteAsMail(java.lang.String[] email, android.content.Context context) {
    }
    
    /**
     * Copy the download link for application
     *
     * @param position     Position of selected option
     * @param activity     Instance of the application
     * @param email        List of email
     * @param mobileNumber List of mobile number
     */
    public final void handleSelectedOptions(int position, @org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    java.lang.String email, @org.jetbrains.annotations.Nullable
    java.lang.String mobileNumber) {
    }
    
    /**
     * Copy the download link for application
     *
     * @param context Instance of the application
     */
    private final void copyLink(android.content.Context context) {
    }
    
    /**
     * Getting mobile number of the user by clicking the view sending the app invite link to the
     * user
     *
     * @param mobileNumber List of mobile number
     * @param activity     Instance of the application
     */
    private final void sendingUserInviteAsSms(java.lang.String mobileNumber, android.app.Activity activity) {
    }
}