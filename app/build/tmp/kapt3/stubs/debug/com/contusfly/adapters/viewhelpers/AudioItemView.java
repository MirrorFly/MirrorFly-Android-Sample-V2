package com.contusfly.adapters.viewhelpers;

import java.lang.System;

/**
 * Audio sent/received item view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/contusfly/adapters/viewhelpers/AudioItemView;", "", "messageItemListener", "Lcom/contusfly/interfaces/MessageItemListener;", "(Lcom/contusfly/interfaces/MessageItemListener;)V", "audioReceiverItemView", "", "audioReceiverViewHolder", "Lcom/contusfly/adapters/holders/AudioReceivedViewHolder;", "time", "", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "audioSenderItemView", "audioViewHolder", "Lcom/contusfly/adapters/holders/AudioSentViewHolder;", "disableReceiverAudioViews", "fromStarred", "", "disableSenderAudioViews", "handleReceiverAudioItemProgressUpdate", "handleSenderAudioItemProgressUpdate", "audioSentViewHolder", "setAudioReceiverMediaStatus", "setAudioSenderMediaStatus", "app_debug"})
public final class AudioItemView {
    private final com.contusfly.interfaces.MessageItemListener messageItemListener = null;
    
    public AudioItemView(@org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.MessageItemListener messageItemListener) {
        super();
    }
    
    /**
     * Sender audio item view
     *
     * @param message            Message item
     * @param audioViewHolder Audio item view holder
     * @param time            Time of message sent
     */
    public final void audioSenderItemView(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.AudioSentViewHolder audioViewHolder, @org.jetbrains.annotations.Nullable
    java.lang.String time, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    public final void setAudioSenderMediaStatus(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.AudioSentViewHolder audioViewHolder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Sender audio uploading progress based on file upload status
     *
     * @param message      Message item
     * @param audioSentViewHolder    Audio item view holder
     */
    public final void handleSenderAudioItemProgressUpdate(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.AudioSentViewHolder audioSentViewHolder) {
    }
    
    /**
     * Receiver audio item view
     *
     * @param message                    Message item
     * @param audioReceiverViewHolder Audio item view holder
     * @param time                    Time of message sent
     */
    public final void audioReceiverItemView(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.AudioReceivedViewHolder audioReceiverViewHolder, @org.jetbrains.annotations.Nullable
    java.lang.String time, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    public final void setAudioReceiverMediaStatus(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.AudioReceivedViewHolder audioReceiverViewHolder, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Receiver audio downloading progress based on file upload status
     *
     * @param message      Message item
     * @param audioReceiverViewHolder    Audio item view holder
     */
    public final void handleReceiverAudioItemProgressUpdate(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.AudioReceivedViewHolder audioReceiverViewHolder) {
    }
    
    /**
     * Disable the unwanted views in the chat view
     *
     * @param audioViewHolder Holder of the audio view
     */
    public final void disableSenderAudioViews(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.AudioSentViewHolder audioViewHolder, boolean fromStarred) {
    }
    
    /**
     * Disable the unwanted views in the chat view
     *
     * @param audioReceiverViewHolder Holder of the audio view
     */
    public final void disableReceiverAudioViews(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.AudioReceivedViewHolder audioReceiverViewHolder, boolean fromStarred) {
    }
}