package com.contusfly.call.groupcall.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\fJ\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0014J\b\u0010\"\u001a\u00020\fH\u0002J\b\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\fH\u0002J\u0006\u0010%\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/CallOptionsViewHelper;", "Landroid/view/View$OnClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "binding", "Lcom/contusfly/databinding/LayoutCallOptionsBinding;", "activityOnClickListener", "Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;", "baseViewOnClickListener", "Lcom/contusfly/call/groupcall/listeners/BaseViewOnClickListener;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/contusfly/databinding/LayoutCallOptionsBinding;Lcom/contusfly/call/groupcall/listeners/ActivityOnClickListener;Lcom/contusfly/call/groupcall/listeners/BaseViewOnClickListener;)V", "animateCallOptions", "", "animation", "", "callOptionsVisibility", "arrowVisibility", "checkAndUpdateCameraView", "enableOrDisableSwitchCamera", "isEnabled", "", "hideCallOptions", "muteVideoForGroupCall", "muteVideoForOneToOneCall", "onClick", "v", "Landroid/view/View;", "setAudioDeviceIcon", "device", "", "setUpCallUI", "showCallOptions", "showOrHideSwitchCamera", "showCamera", "showSelection", "swapCamera", "toggleMic", "toggleVideoMute", "app_debug"})
public final class CallOptionsViewHelper implements android.view.View.OnClickListener {
    private final androidx.appcompat.app.AppCompatActivity activity = null;
    private final com.contusfly.databinding.LayoutCallOptionsBinding binding = null;
    private final com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener = null;
    private final com.contusfly.call.groupcall.listeners.BaseViewOnClickListener baseViewOnClickListener = null;
    
    public CallOptionsViewHelper(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.databinding.LayoutCallOptionsBinding binding, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.listeners.ActivityOnClickListener activityOnClickListener, @org.jetbrains.annotations.NotNull()
    com.contusfly.call.groupcall.listeners.BaseViewOnClickListener baseViewOnClickListener) {
        super();
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    /**
     * This method is used to set the Audio mute icons and also send a mute message
     */
    private final void toggleMic() {
    }
    
    /**
     * handles the swap camera functionality and animations
     */
    private final void swapCamera() {
    }
    
    /**
     * This method is used to set the video mute icons and also send a mute message
     */
    public final void toggleVideoMute() {
    }
    
    /**
     * This method shows the audio device selection UI
     */
    private final void showSelection() {
    }
    
    public final void setUpCallUI() {
    }
    
    public final void showCallOptions() {
    }
    
    public final void hideCallOptions() {
    }
    
    /**
     * sets icon for the audio device image view based on the selected audio device
     *
     * @param device          selected audio device
     */
    public final void setAudioDeviceIcon(@org.jetbrains.annotations.Nullable()
    @com.mirrorflysdk.flycall.webrtc.AudioDevice()
    java.lang.String device) {
    }
    
    public final void checkAndUpdateCameraView() {
    }
    
    /**
     * This method animates the call options layout with given animation
     *
     * @param animation             animation id
     * @param callOptionsVisibility visibility to be changed for callOptions view
     * @param arrowVisibility       visibility to be changed for arrow view
     */
    public final void animateCallOptions(int animation, int callOptionsVisibility, int arrowVisibility) {
    }
    
    public final void showOrHideSwitchCamera(boolean showCamera) {
    }
    
    public final void enableOrDisableSwitchCamera(boolean isEnabled) {
    }
    
    private final void muteVideoForOneToOneCall() {
    }
    
    private final void muteVideoForGroupCall() {
    }
}