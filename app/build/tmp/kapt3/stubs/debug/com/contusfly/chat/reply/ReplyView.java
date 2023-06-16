package com.contusfly.chat.reply;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J&\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/chat/reply/ReplyView;", "", "()V", "getAudioResource", "", "replyMessage", "Lcom/mirrorflysdk/api/models/ReplyParentChatMessage;", "setSenderNameColor", "", "context", "Landroid/content/Context;", "txtChatReplyUserName", "Lcom/contusfly/views/CustomTextView;", "isGroupMessage", "", "showReceiverReplyView", "replyMessageViewHolder", "Lcom/contusfly/adapters/holders/ReplyMessageViewHolder;", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "showSenderReplyView", "app_debug"})
public final class ReplyView {
    
    public ReplyView() {
        super();
    }
    
    /**
     * Displays the reply view for the marked message which has to be replied.
     *
     * @param context                   the parent startupActivityContext.
     * @param replyMessageViewHolder    the view used to inflate the reply content.
     * @param replyMessage              the reply message object of specific message that possessing the reply information.
     */
    public final void showSenderReplyView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ReplyMessageViewHolder replyMessageViewHolder, @org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ReplyParentChatMessage replyMessage, boolean isGroupMessage) {
    }
    
    private final void setSenderNameColor(android.content.Context context, com.contusfly.views.CustomTextView txtChatReplyUserName, boolean isGroupMessage, com.mirrorflysdk.api.models.ReplyParentChatMessage replyMessage) {
    }
    
    private final int getAudioResource(com.mirrorflysdk.api.models.ReplyParentChatMessage replyMessage) {
        return 0;
    }
    
    /**
     * Displays the reply view, when the text message replied from the sender is received.
     *
     * @param context                   the parent startupActivityContext.
     * @param replyMessageViewHolder    the view used to inflate the reply content.
     * @param replyMessage              the reply message object of specific message that possessing the reply information.
     */
    public final void showReceiverReplyView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.ReplyMessageViewHolder replyMessageViewHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem, boolean isGroupMessage) {
    }
}