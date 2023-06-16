package com.contusfly.call.groupcall.listeners;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&\u00a8\u0006\u0013"}, d2 = {"Lcom/contusfly/call/groupcall/listeners/BaseViewOnClickListener;", "", "animateCallOptions", "", "animation", "", "callOptionsVisibility", "arrowVisibility", "animateCallOptionsView", "animateListViewWithCallOptions", "checkOptionArrowVisibility", "visibility", "enableCallOptionAnimation", "onCallOptionsHidden", "onCallOptionsVisible", "onSwapVideo", "ownAudioMuteStatusUpdated", "ownVideoMuteStatusUpdated", "pinnedUserRemoved", "app_debug"})
public abstract interface BaseViewOnClickListener {
    
    /**
     * Callback Method for swap video button click
     */
    public abstract void onSwapVideo();
    
    /**
     * Callback Method to show/hide option arrow
     */
    public abstract void checkOptionArrowVisibility(int visibility);
    
    /**
     * Callback Method to update local view position
     */
    public abstract void onCallOptionsVisible();
    
    /**
     * Callback Method to update local view position
     */
    public abstract void onCallOptionsHidden();
    
    /**
     * Callback Method to animate call detail while call is in hold/reconnecting
     */
    public abstract void animateCallOptionsView();
    
    /**
     * Callback Method to enable call option animation
     */
    public abstract void enableCallOptionAnimation();
    
    /**
     * Callback Method to animates the call options layout with given animation
     *
     * @param animation             animation id
     * @param callOptionsVisibility visibility to be changed for callOptions view
     * @param arrowVisibility       visibility to be changed for arrow view
     */
    public abstract void animateCallOptions(int animation, int callOptionsVisibility, int arrowVisibility);
    
    /**
     * Callback Method to  update local video mute status
     */
    public abstract void ownVideoMuteStatusUpdated();
    
    /**
     * Callback Method to update local audio mute status
     */
    public abstract void ownAudioMuteStatusUpdated();
    
    /**
     * Callback Method to animate list view
     */
    public abstract void animateListViewWithCallOptions();
    
    /**
     * Callback Method to remove pinned user
     */
    public abstract void pinnedUserRemoved();
}