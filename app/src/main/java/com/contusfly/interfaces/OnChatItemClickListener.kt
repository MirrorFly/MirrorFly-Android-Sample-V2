/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.interfaces

import com.mirrorflysdk.api.models.ChatMessage

/**
 * The listener interface for receiving onChatItemClick events. The class that is interested in
 * processing a onChatItemClick event implements this interface, and the object created with that
 * class is registered with a component using the component's addOnChatItemClickListener method.
 * When the onChatItemClick event occurs, that object's appropriate method is invoked.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
interface OnChatItemClickListener {
    /**
     * Called when the download icon has been clicked on the image in the chat view.
     *
     * @param item Instance of the message
     */
    fun onDownloadClicked(item: ChatMessage)

    /**
     * Called when the download cancel icon has been clicked on the image in the chat view.
     *
     * @param messageItem Instance of the message
     */
    fun onCancelDownloadClicked(messageItem: ChatMessage)

    /**
     * Called when the upload cancel icon has been clicked on the image in the chat view.
     *
     * @param messageItem Instance of the message
     */
    fun onCancelUploadClicked(messageItem: ChatMessage)

    /**
     * Handle on retry icon clicked on the chat item, and it will try to  download it again for the
     * message.
     *
     * @param item Instance of the message
     */
    fun onRetryClicked(item: ChatMessage?)

    /**
     * Handle on sender message item clicked to make the operation, it may be share or view the
     * image.
     *
     * @param item     Instance of the message
     * @param position Position of message
     */
    fun onSenderItemClicked(item: ChatMessage?, position: Int)

    /**
     * Handle on receiver message item clicked to make the operation, it may be share or view the
     * image.
     *
     * @param item     Instance of the message
     * @param position Position of message
     */
    fun onReceiverItemClicked(item: ChatMessage?, position: Int)

    /**
     * Handle on sender message item long clicked to make the operation, it will show the menu for
     * the message actions in the toolbar.
     *
     * @param item     Instance of the message
     * @param position The position of chat
     */
    fun onSenderItemLongClick(item: ChatMessage?, position: Int)

    /**
     * Handle on receiver message item long clicked to make the operation, it will show the menu for
     * the message actions in the toolbar.
     *
     * @param item     Instance of the message
     * @param position The position of chat
     */
    fun onReceiverItemLongClick(item: ChatMessage?, position: Int)

    /**
     * Handle the reply message click
     *
     * @param messageId Message id
     */
    fun onReplyMessageClick(messageId: String)

    /**
     * Handle on sender message item long clicked to make the operation, it will show the menu for
     * the message actions in the toolbar.
     *
     * @param item     Instance of the message
     * @param position The position of chat
     */
    fun onSenderMediaForward(item: ChatMessage, position: Int)

    /**
     * Handle the message Single click
     *
     * @param item Instance of the message
     * @param position The position of chat
     * @param registeredJid The user JID
     */
    fun onContactClick(item: ChatMessage, position: Int, registeredJid: String?)

    /**
     * Handle the audio play click
     */
    fun onAudioPlayed()

    /*
    * Storage Permission Check and Allow */
    fun mediaPermissionCheck()
}