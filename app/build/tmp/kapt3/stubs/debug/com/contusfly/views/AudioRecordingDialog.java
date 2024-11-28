package com.contusfly.views;

import java.lang.System;

/**
 * This utility class shows audio recording dialog and records audio based on the media state
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020 H\u0016J \u0010$\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\'\u001a\u00020\u0016H\u0002J\u0006\u0010(\u001a\u00020 J\u0006\u0010)\u001a\u00020 J\u000e\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020 R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0016@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/contusfly/views/AudioRecordingDialog;", "Lcom/contusfly/utils/AudioRecorder$AudioRecordingListener;", "context", "Landroid/app/Activity;", "onClickListener", "Landroid/view/View$OnClickListener;", "(Landroid/app/Activity;Landroid/view/View$OnClickListener;)V", "anim", "Landroid/view/animation/Animation;", "audioRecorder", "Lcom/contusfly/utils/AudioRecorder;", "dialogRecording", "Landroid/app/Dialog;", "focusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "mAudioManager", "Landroid/media/AudioManager;", "<set-?>", "", "mediaPath", "getMediaPath", "()Ljava/lang/String;", "", "mediaState", "getMediaState", "()I", "recordingCompleteTextView", "Landroid/widget/TextView;", "recordingImageView", "Landroid/widget/ImageView;", "recordingTimerTextView", "dismissRecordingDialog", "", "onDurationUpdateListener", "totalDuration", "onMaxDurationReached", "requestAudioFocus", "", "streamType", "audioFocusGain", "showRecordingDialog", "startRecording", "stopRecording", "isSend", "toPauseMediaPlayer", "app_debug"})
public final class AudioRecordingDialog implements com.contusfly.utils.AudioRecorder.AudioRecordingListener {
    private final android.app.Activity context = null;
    private final android.view.View.OnClickListener onClickListener = null;
    private final android.media.AudioManager mAudioManager = null;
    
    /**
     * The dialog recording to display the user for sending the  audio file to the user
     */
    private android.app.Dialog dialogRecording;
    
    /**
     * Recording timer of the audio view to record the audio in the custom alert dialog
     */
    private android.widget.TextView recordingTimerTextView;
    
    /**
     * Record complete text in the alert dialog to close the dialog
     */
    private android.widget.TextView recordingCompleteTextView;
    
    /**
     * Recording image view in the alert dialog
     */
    private android.widget.ImageView recordingImageView;
    
    /**
     * The media state of the audio in the audio
     */
    private int mediaState = 0;
    
    /**
     * The audio recorder to record the audio in the chat view
     */
    private com.contusfly.utils.AudioRecorder audioRecorder;
    
    /**
     * Media path of the recording file
     */
    @org.jetbrains.annotations.Nullable
    private java.lang.String mediaPath;
    private final android.media.AudioManager.OnAudioFocusChangeListener focusChangeListener = null;
    private android.view.animation.Animation anim;
    
    public AudioRecordingDialog(@org.jetbrains.annotations.NotNull
    android.app.Activity context, @org.jetbrains.annotations.NotNull
    android.view.View.OnClickListener onClickListener) {
        super();
    }
    
    public final int getMediaState() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMediaPath() {
        return null;
    }
    
    /**
     * When user clicked Start recording in the view we have to call this method
     */
    public final void startRecording() {
    }
    
    /**
     * Request audio focus.
     * Send a request to obtain the audio focus
     *
     * @param focusChangeListener the listener to be notified of audio focus changes
     * @param streamType          the main audio stream type affected by the focus request
     * @param audioFocusGain      the focus gain
     * @return true if AUDIOFOCUS_REQUEST_GRANTED otherwise false
     */
    private final boolean requestAudioFocus(android.media.AudioManager.OnAudioFocusChangeListener focusChangeListener, int streamType, int audioFocusGain) {
        return false;
    }
    
    /**
     * Stop the recording when the user desire to stop in the user interface
     *
     * @param isSend the is send
     */
    public final void stopRecording(boolean isSend) {
    }
    
    /**
     * Show recording dialog to the user so that can able to record the audio.
     */
    public final void showRecordingDialog() {
    }
    
    public final void dismissRecordingDialog() {
    }
    
    @java.lang.Override
    public void onDurationUpdateListener(int totalDuration) {
    }
    
    @java.lang.Override
    public void onMaxDurationReached() {
    }
    
    public final void toPauseMediaPlayer() {
    }
}