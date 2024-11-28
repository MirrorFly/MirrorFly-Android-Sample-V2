package com.contusfly.interfaces;

import java.lang.System;

/**
 * The listener interface for receiving onChatItemClick events. The class that is interested in
 * processing a onChatItemClick event implements this interface, and the object created with that
 * class is registered with a component using the component's addOnChatItemClickListener method.
 * When the onChatItemClick event occurs, that object's appropriate method is invoked.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J*\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H&J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\u0014\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000eH&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0018\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u001b"}, d2 = {"Lcom/contusfly/interfaces/OnChatItemClickListener;", "", "mediaPermissionCheck", "", "onAudioPlayed", "onCancelDownloadClicked", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "onCancelUploadClicked", "onContactClick", "item", "position", "", "registeredJid", "", "isSavedContact", "", "onDownloadClicked", "onHandleStarredItemMediaClickToAction", "onReceiverItemClicked", "onReceiverItemLongClick", "onReplyMessageClick", "messageId", "onRetryClicked", "onSenderItemClicked", "onSenderItemLongClick", "onSenderMediaForward", "app_debug"})
public abstract interface OnChatItemClickListener {
    
    /**
     * Called when the download icon has been clicked on the image in the chat view.
     *
     * @param item Instance of the message
     */
    public abstract void onDownloadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item);
    
    /**
     * Called when the download cancel icon has been clicked on the image in the chat view.
     *
     * @param messageItem Instance of the message
     */
    public abstract void onCancelDownloadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem);
    
    /**
     * Called when the upload cancel icon has been clicked on the image in the chat view.
     *
     * @param messageItem Instance of the message
     */
    public abstract void onCancelUploadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem);
    
    /**
     * Handle on retry icon clicked on the chat item, and it will try to  download it again for the
     * message.
     *
     * @param item Instance of the message
     */
    public abstract void onRetryClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item);
    
    /**
     * Handle on sender message item clicked to make the operation, it may be share or view the
     * image.
     *
     * @param item     Instance of the message
     * @param position Position of message
     */
    public abstract void onSenderItemClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position);
    
    /**
     * Handle on sender media message item clicked to make the operation, it may be share or view the
     * image.
     *
     * @param item     Instance of the message
     * @param position Position of message
     */
    public abstract void onHandleStarredItemMediaClickToAction(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position);
    
    /**
     * Handle on receiver message item clicked to make the operation, it may be share or view the
     * image.
     *
     * @param item     Instance of the message
     * @param position Position of message
     */
    public abstract void onReceiverItemClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position);
    
    /**
     * Handle on sender message item long clicked to make the operation, it will show the menu for
     * the message actions in the toolbar.
     *
     * @param item     Instance of the message
     * @param position The position of chat
     */
    public abstract void onSenderItemLongClick(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position);
    
    /**
     * Handle on receiver message item long clicked to make the operation, it will show the menu for
     * the message actions in the toolbar.
     *
     * @param item     Instance of the message
     * @param position The position of chat
     */
    public abstract void onReceiverItemLongClick(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position);
    
    /**
     * Handle the reply message click
     *
     * @param messageId Message id
     */
    public abstract void onReplyMessageClick(@org.jetbrains.annotations.NotNull
    java.lang.String messageId);
    
    /**
     * Handle on sender message item long clicked to make the operation, it will show the menu for
     * the message actions in the toolbar.
     *
     * @param item     Instance of the message
     * @param position The position of chat
     */
    public abstract void onSenderMediaForward(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item, int position);
    
    /**
     * Handle the message Single click
     *
     * @param item Instance of the message
     * @param position The position of chat
     * @param registeredJid The user JID
     * @param isSavedContact Is the contact is saved or not
     */
    public abstract void onContactClick(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item, int position, @org.jetbrains.annotations.Nullable
    java.lang.String registeredJid, boolean isSavedContact);
    
    /**
     * Handle the audio play click
     */
    public abstract void onAudioPlayed();
    
    public abstract void mediaPermissionCheck();
}