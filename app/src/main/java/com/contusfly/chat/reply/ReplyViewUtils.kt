package com.contusfly.chat.reply

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.adapters.holders.*
import com.contusfly.gone
import com.contusfly.isGroupMessage
import com.contusfly.show
import com.mirrorflysdk.api.models.ChatMessage


class ReplyViewUtils {

    /**
     * Show/hide the reply window for the sent audio.
     * @param viewHolder The view holding the child items.
     * @param item            The data set used to render the content of child views.
     * @param context         The context
     */
    fun showSenderReplyWindow(viewHolder: RecyclerView.ViewHolder, item: ChatMessage, context: Context) {
        with(viewHolder) {
            when (this) {
                is TextSentViewHolder -> {
                    if (item.isThisAReplyMessage()) {
                        replyMessageSentView?.show()
                        replyMessageSentLayout?.show()
                        ReplyView().showSenderReplyView(context, this, item.getReplyParentChatMessage(), item.isGroupMessage())
                    } else {
                        replyMessageSentLayout?.gone()
                        replyMessageSentView?.gone()
                    }
                }
                is ImageSentViewHolder, is AudioSentViewHolder, is ContactSentViewHolder,
                is FileSentViewHolder, is LocationSentViewHolder, is VideoSentViewHolder, is MeetSentViewHolder -> {
                    val replyMessageViewHolder = this as ReplyMessageViewHolder
                    if (item.isThisAReplyMessage()) {
                        replyMessageViewHolder.showSentReplyView()
                        ReplyView().showSenderReplyView(context, replyMessageViewHolder, item.getReplyParentChatMessage(), item.isGroupMessage())
                    } else
                        replyMessageViewHolder.hideSentReplyView()
                }
            }

            when (this) {
                is AudioSentViewHolder -> handleVisibility(audSentStarred, item.isMessageStarred())
                is LocationSentViewHolder -> handleVisibility(imgSentStarred, item.isMessageStarred())
                else -> { //Not needed
                }
            }
        }
    }

    /**
     * Show/hide the reply window for the received audio.
     * @param viewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     * @param context                 The context
     */
    fun showReceiverReplyWindow(viewHolder: RecyclerView.ViewHolder, item: ChatMessage, context: Context) {
        with(viewHolder) {
            when (this) {
                is TextReceivedViewHolder -> {
                    if (item.isThisAReplyMessage()) {
                        replyMessageReceivedView?.show()
                        handleReceiverReplyview(context, this, this, item)
                    } else
                        replyMessageReceivedView?.gone()
                }
                is AudioReceivedViewHolder, is ContactReceivedViewHolder, is FileReceivedViewHolder,
                is LocationReceivedViewHolder, is ImageReceivedViewHolder, is VideoReceivedViewHolder, is MeetReceivedViewHolder -> {
                    val replyMessageViewHolder = this as ReplyMessageViewHolder
                    handleReceiverReplyview(context, this, replyMessageViewHolder, item)
                }
            }

            when (this) {
                is AudioReceivedViewHolder -> handleVisibility(audRevStarred, item.isMessageStarred())
                is LocationReceivedViewHolder -> handleVisibility(imgStarredReceived, item.isMessageStarred())
                else -> { //Not needed
                }
            }
        }
    }

    private fun handleReceiverReplyview(context: Context, viewHolder: RecyclerView.ViewHolder,
                                        replyMessageViewHolder: ReplyMessageViewHolder, item: ChatMessage) {
        if (item.isThisAReplyMessage()) {
            if (viewHolder is AudioReceivedViewHolder || viewHolder is ContactReceivedViewHolder || viewHolder is FileReceivedViewHolder)
                replyMessageViewHolder.showSentReplyView()
            else
                replyMessageViewHolder.showReceivedReplyView()
            ReplyView().showReceiverReplyView(context, replyMessageViewHolder, item, item.isGroupMessage())
        } else {
            replyMessageViewHolder.hideSentReplyView()
            replyMessageViewHolder.hideReceivedReplyView()
        }
    }

    /**
     * Show/hide the favorite icon when the text is added to favorites.
     *
     * @param viewHolder The view holding the child items.
     * @param item                  The data set used to render the content of child views.
     */
    fun markFavoriteItem(viewHolder: RecyclerView.ViewHolder, item: ChatMessage) {

        with(viewHolder) {
            when (this) {
                is TextSentViewHolder -> handleVisibility(imageStar, item.isMessageStarred())
                is TextReceivedViewHolder -> handleVisibility(imgReceivedStar, item.isMessageStarred())
                is FileReceivedViewHolder -> {
                    if (!item.isMessageSentByMe())
                        handleVisibility(fileFavoriteImage, item.isMessageStarred())
                }
                is MeetSentViewHolder -> handleVisibility(imageStar, item.isMessageStarred)
                is MeetReceivedViewHolder -> handleVisibility(
                    imgReceivedStar,
                    item.isMessageStarred
                )
                else -> { //Not needed
                }
            }
        }
    }

    private fun handleVisibility(view: View, show: Boolean?) {
        if (show != null) {
            if (show) view.show() else view.gone()
        } else {
            view.gone()
        }
    }

}