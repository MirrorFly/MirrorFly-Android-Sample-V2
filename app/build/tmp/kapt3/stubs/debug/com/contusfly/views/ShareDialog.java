package com.contusfly.views;

import java.lang.System;

/**
 * A Common Dialog used across Quick Share to show progressDialog and Dismiss them
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/views/ShareDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "Landroid/app/ProgressDialog;", "progressDialog", "getProgressDialog", "()Landroid/app/ProgressDialog;", "dismissShareDialog", "", "initializeAndShowShareDialog", "title", "", "message", "app_debug"})
public final class ShareDialog {
    private final android.content.Context context = null;
    
    /**
     * Instance of the ProgressDialog
     */
    @org.jetbrains.annotations.Nullable()
    private android.app.ProgressDialog progressDialog;
    
    public ShareDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.app.ProgressDialog getProgressDialog() {
        return null;
    }
    
    /**
     * Dismiss Dialog if it is Showing
     */
    public final void dismissShareDialog() {
    }
    
    /**
     * Initialize and present the dialog with given title and message
     *
     * @param title   title to show in Dialog
     * @param message message to display in dialog
     */
    public final void initializeAndShowShareDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
}