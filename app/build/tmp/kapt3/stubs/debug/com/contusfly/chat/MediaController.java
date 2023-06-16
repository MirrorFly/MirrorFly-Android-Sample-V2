package com.contusfly.chat;

import java.lang.System;

/**
 * The Class MediaController which used to care of the medias in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 _2\u00020\u0001:\u0001_B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010>\u001a\u00020?H\u0002J(\u0010@\u001a\u00020?2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\b\u0010:\u001a\u0004\u0018\u0001042\u0006\u0010A\u001a\u00020\u0006J\u0010\u0010B\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020\rJ\b\u0010E\u001a\u00020?H\u0003J\b\u0010F\u001a\u00020?H\u0002J\u001a\u0010G\u001a\u00020?2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010H\u001a\u0004\u0018\u00010\u0012J\u0006\u0010I\u001a\u00020?J \u0010J\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0006H\u0002J\u000e\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020\rJ1\u0010O\u001a\u00020?2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010P\u001a\u0004\u0018\u00010\u00162\u0006\u0010D\u001a\u00020\r\u00a2\u0006\u0002\u0010QJ\u0010\u0010R\u001a\u00020?2\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010S\u001a\u00020?2\b\u0010:\u001a\u0004\u0018\u000104J\u0006\u0010T\u001a\u00020?J\u000e\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020\u0006J@\u0010W\u001a\u00020?2\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010\u00122\u0006\u0010Z\u001a\u00020\r2\u0006\u0010[\u001a\u0002042\u0006\u0010\\\u001a\u00020]2\u0006\u0010P\u001a\u00020\u0016JB\u0010^\u001a\u00020?2\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010\u00122\u0006\u0010Z\u001a\u00020\r2\u0006\u0010[\u001a\u0002042\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010P\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\b\"\u0004\b2\u0010\nR\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\b\"\u0004\b=\u0010\n\u00a8\u0006`"}, d2 = {"Lcom/contusfly/chat/MediaController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentAudioPosition", "", "getCurrentAudioPosition", "()I", "setCurrentAudioPosition", "(I)V", "currentPosition", "doesSentAudio", "", "duration", "", "Ljava/lang/Long;", "filePath", "", "focusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "imgLastUsed", "Landroid/widget/ImageView;", "imgPlay", "isSender", "lastUsedMedia", "mAudioManager", "Landroid/media/AudioManager;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mPlayedTime", "Ljava/util/HashMap;", "mediaPlayer", "Landroid/media/MediaPlayer;", "getMediaPlayer", "()Landroid/media/MediaPlayer;", "setMediaPlayer", "(Landroid/media/MediaPlayer;)V", "progressMilliSeconds", "seekBar", "Landroid/widget/SeekBar;", "songHandler", "Ljava/lang/ThreadLocal;", "Ljava/lang/Runnable;", "tempProgress", "getTempProgress", "setTempProgress", "tempdurationTxtView", "Landroid/widget/TextView;", "getTempdurationTxtView", "()Landroid/widget/TextView;", "setTempdurationTxtView", "(Landroid/widget/TextView;)V", "timeConsumed", "txtTimer", "updatedProgress", "getUpdatedProgress", "setUpdatedProgress", "abandonAudioFocus", "", "checkStateOfPlayer", "position", "getPlayedTimeOfTrackInSecs", "handlePlayer", "doesSentMessage", "handlePlayerOperations", "mediaPlayerListener", "onStopTrackingTouch", "path", "pausePlayer", "requestAudioFocus", "streamType", "audioFocusGain", "resetAudioPlayer", "isCompleted", "setMediaResource", "imgPlayer", "(Ljava/lang/String;Ljava/lang/Long;Landroid/widget/ImageView;Z)V", "setMediaSeekBar", "setMediaTimer", "stopPlayer", "updateSeekBarProgress", "seekBarProgress", "updateSeekbarChanges", "progress", "layoutPosition", "fromUser", "durationView", "mirrorFlySeekBar", "Lcom/contusfly/views/MirrorFlySeekBar;", "updateSeekbarChangesForStarredMsg", "Companion", "app_debug"})
public final class MediaController {
    private final android.content.Context context = null;
    private final android.media.AudioManager mAudioManager = null;
    private boolean isSender = false;
    
    /**
     * Local file path
     */
    private java.lang.String filePath;
    
    /**
     * Local file duration
     */
    private java.lang.Long duration;
    
    /**
     * Play button view
     */
    private android.widget.ImageView imgPlay;
    private boolean doesSentAudio = false;
    
    /**
     * The seek bar to display in the Audio play.
     */
    private android.widget.SeekBar seekBar;
    
    /**
     * Current position of the seek bar
     */
    private int currentPosition = 0;
    
    /**
     * Current play position
     */
    private int timeConsumed = 0;
    
    /**
     * The updated progress.
     */
    private int updatedProgress = 0;
    private int progressMilliSeconds = 100;
    
    /**
     * The media player to display in the chat view for play the audio.
     */
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaPlayer mediaPlayer;
    
    /**
     * The handler to play the audio.
     */
    @org.jetbrains.annotations.Nullable()
    private android.os.Handler mHandler;
    
    /**
     * The txt timer of the audio player.
     */
    private android.widget.TextView txtTimer;
    private final java.util.HashMap<java.lang.String, java.lang.Integer> mPlayedTime = null;
    private int tempProgress = 0;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView tempdurationTxtView;
    
    /**
     * The song handler to run continuously when playing the media.
     */
    private final java.lang.ThreadLocal<java.lang.Runnable> songHandler = null;
    
    /**
     * Sets the position of the current playing audio from the chat adapter view.
     *
     * message in the chat adapter view.
     */
    private int currentAudioPosition = -1;
    
    /**
     * The file path of the last view media.
     */
    private java.lang.String lastUsedMedia = "";
    
    /**
     * The image view for the last used and play images
     */
    private android.widget.ImageView imgLastUsed;
    private final android.media.AudioManager.OnAudioFocusChangeListener focusChangeListener = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.chat.MediaController.Companion Companion = null;
    
    public MediaController(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final int getUpdatedProgress() {
        return 0;
    }
    
    public final void setUpdatedProgress(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.media.MediaPlayer getMediaPlayer() {
        return null;
    }
    
    public final void setMediaPlayer(@org.jetbrains.annotations.Nullable()
    android.media.MediaPlayer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.os.Handler getMHandler() {
        return null;
    }
    
    public final void setMHandler(@org.jetbrains.annotations.Nullable()
    android.os.Handler p0) {
    }
    
    public final int getTempProgress() {
        return 0;
    }
    
    public final void setTempProgress(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getTempdurationTxtView() {
        return null;
    }
    
    public final void setTempdurationTxtView(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    public final void onStopTrackingTouch(@org.jetbrains.annotations.Nullable()
    android.widget.SeekBar seekBar, @org.jetbrains.annotations.Nullable()
    java.lang.String path) {
    }
    
    public final int getCurrentAudioPosition() {
        return 0;
    }
    
    public final void setCurrentAudioPosition(int p0) {
    }
    
    /**
     * Sets the media resource. Media path and player
     *
     * @param filePath        the file path
     * @param duration        the file duration
     * @param imgPlayer       the img player
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    public final void setMediaResource(@org.jetbrains.annotations.Nullable()
    java.lang.String filePath, @org.jetbrains.annotations.Nullable()
    java.lang.Long duration, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView imgPlayer, boolean doesSentMessage) {
    }
    
    /**
     * Gets the seeker time in seconds
     * @param filePath
     * @return
     */
    public final int getPlayedTimeOfTrackInSecs(@org.jetbrains.annotations.Nullable()
    java.lang.String filePath) {
        return 0;
    }
    
    /**
     * Sets the media seek bar.
     *
     * @param seekBar the new media seek bar
     */
    public final void setMediaSeekBar(@org.jetbrains.annotations.Nullable()
    android.widget.SeekBar seekBar) {
    }
    
    /**
     * Sets the media timer.
     *
     * @param txtTimer Media timer text view
     */
    public final void setMediaTimer(@org.jetbrains.annotations.Nullable()
    android.widget.TextView txtTimer) {
    }
    
    /**
     * Get the file path from the player
     *
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    public final void handlePlayer(boolean doesSentMessage) {
    }
    
    /**
     * Checks the player is playing or not
     *
     * @param imgPlay         the img play
     * @param seekBar         the seek bar
     * @param txtTimer        the txt timer
     * @param position        the position
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    public final void checkStateOfPlayer(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgPlay, @org.jetbrains.annotations.NotNull()
    android.widget.SeekBar seekBar, @org.jetbrains.annotations.Nullable()
    android.widget.TextView txtTimer, int position) {
    }
    
    /**
     * Stop the player of the Media player.
     */
    public final void stopPlayer() {
    }
    
    public final void pausePlayer() {
    }
    
    /**
     * Handle the player operations => pause => start => release
     *
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    @android.annotation.SuppressLint(value = {"NewApi", "ClickableViewAccessibility"})
    private final void handlePlayerOperations() {
    }
    
    /**
     * mediaPlayerListener Check the media player listener
     *
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    private final void mediaPlayerListener() {
    }
    
    /**
     * Reset the audio player to the initial state and releases the resources
     * currently associated with this MediaPlayer object.
     */
    public final void resetAudioPlayer(boolean isCompleted) {
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
    
    private final void abandonAudioFocus() {
    }
    
    /**
     * Used to updated file progress based on file path
     * @param seekBarProgress
     */
    public final void updateSeekBarProgress(int seekBarProgress) {
    }
    
    /**
     * Handle the audio seekbar progressbarchange listener for chat screen
     *
     * @param progress          Message Item data
     * @param path              View holder of current view in adapter
     * @param playImage         Play button of the audio view
     * @param mirrorFlySeekBar  Mirrorfly seek bar of the audio
     * @param durationView      TextView used to set the duration
     * @param fromUser          Boolean to identify whether the audio message is posted by sender
     * @param layoutPosition    position of the holder
     */
    public final void updateSeekbarChanges(int progress, int layoutPosition, @org.jetbrains.annotations.Nullable()
    java.lang.String path, boolean fromUser, @org.jetbrains.annotations.NotNull()
    android.widget.TextView durationView, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.MirrorFlySeekBar mirrorFlySeekBar, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgPlayer) {
    }
    
    /**
     * Handle the audio seekbar progressbarchange listener for starred msg
     *
     * @param progress          Message Item data
     * @param path              View holder of current view in adapter
     * @param playImage         Play button of the audio view
     * @param seekBar           seek bar of the audio
     * @param durationView      TextView used to set the duration
     * @param fromUser          Boolean to identify whether the audio message is posted by sender
     * @param layoutPosition    position of the holder
     */
    public final void updateSeekbarChangesForStarredMsg(int progress, int layoutPosition, @org.jetbrains.annotations.Nullable()
    java.lang.String path, boolean fromUser, @org.jetbrains.annotations.NotNull()
    android.widget.TextView durationView, @org.jetbrains.annotations.Nullable()
    android.widget.SeekBar seekBar, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgPlayer) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/chat/MediaController$Companion;", "", "()V", "getActivity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final android.app.Activity getActivity(android.content.Context context) {
            return null;
        }
    }
}