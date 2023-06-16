package com.contusfly.chat.reply;

import java.lang.System;

/**
 * This class handles the received reply message related operations
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\u000e"}, d2 = {"Lcom/contusfly/chat/reply/ReceivedReplyContactUtils;", "Lcom/contusfly/chat/reply/ReceivedReplyMediaUtils;", "()V", "showReceivedReplyContactMessage", "", "replyMessageViewHolder", "Lcom/contusfly/adapters/holders/ReplyMessageViewHolder;", "context", "Landroid/content/Context;", "replyMessage", "Lcom/mirrorflysdk/api/models/ReplyParentChatMessage;", "isGroupMessage", "", "showReceivedReplyLocationMessage", "app_debug"})
public class ReceivedReplyContactUtils extends com.contusfly.chat.reply.ReceivedReplyMediaUtils {
    
    public ReceivedReplyContactUtils() {
        super();
    }
    
    /**
     * Show received reply contact message
     *
     * @param replyMessageViewHolder Holder of the text view
     * @param context                Instance of the application
     * @param replyMessage           Reply message item
     */
    public final void showReceivedReplyContactMessage(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ReplyMessageViewHolder replyMessageViewHolder, @org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ReplyParentChatMessage replyMessage, boolean isGroupMessage) {
    }
    
    /**
     * Show received reply location message
     *
     * @param replyMessageViewHolder Holder of the text view
     * @param context                Instance of the application
     * @param replyMessage           Reply message item
     */
    public final void showReceivedReplyLocationMessage(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ReplyMessageViewHolder replyMessageViewHolder, @org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ReplyParentChatMessage replyMessage, boolean isGroupMessage) {
    }
}