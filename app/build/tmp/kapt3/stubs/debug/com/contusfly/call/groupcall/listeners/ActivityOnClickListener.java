package com.contusfly.call.groupcall.listeners;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;", "", "addLocalUserToAdapter", "", "addUsersInCall", "answer", "cancelCallAgain", "hangVideoCall", "makeCallAgain", "onCallSwitchConfirmationDialog", "onCallSwitchDialog", "isAccepted", "", "onRequestingVideoCallDialog", "requestCameraPermission", "resetViewsUpdatedFlag", "switchToGridView", "switchToTileView", "app_debug"})
public abstract interface ActivityOnClickListener {
    
    /**
     * Callback Method to answer the call
     */
    public abstract void answer();
    
    /**
     * Callback Method to request camera permission when un mute video
     */
    public abstract void requestCameraPermission();
    
    /**
     * Callback Method to cancel call again
     */
    public abstract void cancelCallAgain();
    
    /**
     * Callback Method to initiate call again
     */
    public abstract void makeCallAgain();
    
    /**
     * Callback Method to hang video call
     */
    public abstract void hangVideoCall();
    
    /**
     * Callback Method to add users to the call
     */
    public abstract void addUsersInCall();
    
    /**
     * Callback Method to handle call confirmation dialog
     */
    public abstract void onCallSwitchConfirmationDialog();
    
    /**
     * Callback Method to handle requesting video call dialog
     */
    public abstract void onRequestingVideoCallDialog();
    
    /**
     * Callback Method to handle call switch dialog
     * @param isAccepted to determine whether call switch accepted or declined
     */
    public abstract void onCallSwitchDialog(boolean isAccepted);
    
    /**
     * Callback Method to add local user to adapter
     */
    public abstract void addLocalUserToAdapter();
    
    /**
     * Callback Method to switch tile view to grid view
     */
    public abstract void switchToGridView();
    
    /**
     * Callback Method to switch grid view to tile view
     */
    public abstract void switchToTileView();
    
    /**
     * Callback Method to reset view updated flag
     */
    public abstract void resetViewsUpdatedFlag();
}