package com.contusfly.utils;

import java.lang.System;

/**
 * This class is used to record the audio.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/contusfly/utils/AudioRecorder;", "Landroid/media/MediaRecorder$OnInfoListener;", "activity", "Landroid/app/Activity;", "audioRecordingListener", "Lcom/contusfly/utils/AudioRecorder$AudioRecordingListener;", "(Landroid/app/Activity;Lcom/contusfly/utils/AudioRecorder$AudioRecordingListener;)V", "mediaHandler", "Landroid/os/Handler;", "mediaRecorder", "Landroid/media/MediaRecorder;", "recorder", "Ljava/lang/ThreadLocal;", "Ljava/lang/Runnable;", "recordingStartTimeInMillis", "", "onInfo", "", "mr", "what", "", "extra", "startRecording", "", "stopRecording", "AudioRecordingListener", "app_debug"})
public final class AudioRecorder implements android.media.MediaRecorder.OnInfoListener {
    private final android.app.Activity activity = null;
    private final com.contusfly.utils.AudioRecorder.AudioRecordingListener audioRecordingListener = null;
    
    /**
     * The media recorder to record the audio in the chat view
     */
    private android.media.MediaRecorder mediaRecorder;
    
    /**
     * The audio handler to record the audio in the background
     */
    private android.os.Handler mediaHandler;
    
    /**
     * The calculate the elapsed duration after audio recorder is started
     */
    private long recordingStartTimeInMillis = 0L;
    
    /**
     * The recorder to record the audio into the chat view to the receiver
     */
    private final java.lang.ThreadLocal<java.lang.Runnable> recorder = null;
    
    public AudioRecorder(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    com.contusfly.utils.AudioRecorder.AudioRecordingListener audioRecordingListener) {
        super();
    }
    
    /**
     * When user clicked Start recording in the view we have to call this method.
     *
     * @return string Recorded audio file path.
     * @throws IOException throws I/O exception if occurred.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final java.lang.String startRecording() throws java.io.IOException {
        return null;
    }
    
    /**
     * Stop the recording when the user desire to stop in the user interface
     */
    public final void stopRecording() {
    }
    
    @java.lang.Override
    public void onInfo(@org.jetbrains.annotations.NotNull
    android.media.MediaRecorder mr, int what, int extra) {
    }
    
    /**
     * Listener to catch the audio recording events like duration update and stop recording
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/utils/AudioRecorder$AudioRecordingListener;", "", "onDurationUpdateListener", "", "totalDuration", "", "onMaxDurationReached", "app_debug"})
    public static abstract interface AudioRecordingListener {
        
        /**
         * This method will called when the total duration of the recording has changed
         *
         * @param totalDuration total duration of the recording
         */
        public abstract void onDurationUpdateListener(int totalDuration);
        
        /**
         * This method will called when the audio recording duration reaches max
         * duration limit
         */
        public abstract void onMaxDurationReached();
    }
}