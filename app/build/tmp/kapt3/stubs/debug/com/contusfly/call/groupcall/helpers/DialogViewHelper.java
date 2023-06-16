package com.contusfly.call.groupcall.helpers;

import java.lang.System;

/**
 * This call dialog view helper is handle the incoming and outgoing video call switch requests.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u0006\u0010#\u001a\u00020\u0013J\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020\u001eJ\b\u0010\'\u001a\u00020\u001eH\u0002J\u0006\u0010(\u001a\u00020\u001eJ\u0006\u0010)\u001a\u00020\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001b\u0010\f\u00a8\u0006*"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/DialogViewHelper;", "", "context", "Landroid/content/Context;", "durationHandler", "Landroid/os/Handler;", "activityOnClickListener", "Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;", "(Landroid/content/Context;Landroid/os/Handler;Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;)V", "callSwitchConfirmationDialog", "Landroidx/appcompat/app/AlertDialog;", "getCallSwitchConfirmationDialog", "()Landroidx/appcompat/app/AlertDialog;", "callSwitchConfirmationDialog$delegate", "Lkotlin/Lazy;", "callSwitchDialog", "getCallSwitchDialog", "callSwitchDialog$delegate", "inComingRequest", "", "outGoingRequest", "outgoingRequestRunnable", "Ljava/lang/Runnable;", "getOutgoingRequestRunnable", "()Ljava/lang/Runnable;", "outgoingRequestRunnable$delegate", "requestingVideoCallDialog", "getRequestingVideoCallDialog", "requestingVideoCallDialog$delegate", "disconnectCall", "", "dismissCallSwitchConfirmationDialog", "dismissCallSwitchDialog", "dismissVideoCallRequestingDialog", "isIncomingRequestAvailable", "isVideoCallSwitchRequested", "isVideoCallSwitchRequestedFromBothSides", "showCallSwitchConfirmationDialog", "showCallSwitchDialog", "showVideoCallRequestingDialog", "videoCallSwitchRequestAccepted", "videoCallSwitchRequestCancelled", "app_debug"})
public final class DialogViewHelper {
    private final android.content.Context context = null;
    private final android.os.Handler durationHandler = null;
    private final com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener = null;
    
    /**
     * boolean to check outGoing request
     */
    private boolean outGoingRequest = false;
    
    /**
     * boolean to check inComing request
     */
    private boolean inComingRequest = false;
    
    /**
     * When user doesn't respond to video call request for 20 seconds
     * local toast is shown
     */
    private final kotlin.Lazy outgoingRequestRunnable$delegate = null;
    
    /**
     * Alert dialog to confirm call switch
     */
    private final kotlin.Lazy callSwitchConfirmationDialog$delegate = null;
    
    /**
     * Alert dialog to show requesting call switch
     */
    private final kotlin.Lazy requestingVideoCallDialog$delegate = null;
    
    /**
     * Alert dialog to show incoming call switch request
     */
    private final kotlin.Lazy callSwitchDialog$delegate = null;
    
    public DialogViewHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.os.Handler durationHandler, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener) {
        super();
    }
    
    /**
     * When user doesn't respond to video call request for 20 seconds
     * local toast is shown
     */
    private final java.lang.Runnable getOutgoingRequestRunnable() {
        return null;
    }
    
    /**
     * Alert dialog to confirm call switch
     */
    private final androidx.appcompat.app.AlertDialog getCallSwitchConfirmationDialog() {
        return null;
    }
    
    /**
     * Show call switch confirmation dialog
     */
    public final void showCallSwitchConfirmationDialog() {
    }
    
    /**
     * Dismiss call switch confirmation dialog
     */
    public final void dismissCallSwitchConfirmationDialog() {
    }
    
    /**
     * Alert dialog to show requesting call switch
     */
    private final androidx.appcompat.app.AlertDialog getRequestingVideoCallDialog() {
        return null;
    }
    
    /**
     * Show video call requesting dialog to user once call switch conformation is done
     */
    private final void showVideoCallRequestingDialog() {
    }
    
    /**
     * Dismiss video call requesting dialog
     */
    public final void dismissVideoCallRequestingDialog() {
    }
    
    /**
     * Alert dialog to show incoming call switch request
     */
    private final androidx.appcompat.app.AlertDialog getCallSwitchDialog() {
        return null;
    }
    
    /**
     * Show dialog for call switch
     */
    public final void showCallSwitchDialog() {
    }
    
    /**
     * Dismiss call switch dialog
     */
    public final void dismissCallSwitchDialog() {
    }
    
    /**
     * Accepted video call switch request
     */
    public final void videoCallSwitchRequestAccepted() {
    }
    
    /**
     * Canceled video call switch request
     */
    public final void videoCallSwitchRequestCancelled() {
    }
    
    public final void disconnectCall() {
    }
    
    public final boolean isVideoCallSwitchRequestedFromBothSides() {
        return false;
    }
    
    public final boolean isVideoCallSwitchRequested() {
        return false;
    }
    
    public final void isIncomingRequestAvailable() {
    }
}