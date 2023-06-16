package com.contusfly.chat.reply;

import java.lang.System;

/**
 * This class handles the sent reply message related operations
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2 = {"Lcom/contusfly/chat/reply/ReplyMessageUtils;", "Lcom/contusfly/chat/reply/SentReplyTextUtils;", "()V", "showReplyMessage", "", "context", "Landroid/content/Context;", "replyMessageViewHolder", "Lcom/contusfly/adapters/holders/ReplyMessageViewHolder;", "replyMessage", "Lcom/mirrorflysdk/api/models/ReplyParentChatMessage;", "isGroupMessage", "", "app_debug"})
public final class ReplyMessageUtils extends com.contusfly.chat.reply.SentReplyTextUtils {
    
    public ReplyMessageUtils() {
        super();
    }
    
    /**
     * Displays the reply view for the marked message which has to be replied.
     *
     * @param context                the parent startupActivityContext.
     * @param replyMessageViewHolder the view used to inflate the reply content.
     * @param replyMessage           the Message of the respective message object which is marked
     * for the reply action.
     */
    public final void showReplyMessage(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ReplyMessageViewHolder replyMessageViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ReplyParentChatMessage replyMessage, boolean isGroupMessage) {
    }
}