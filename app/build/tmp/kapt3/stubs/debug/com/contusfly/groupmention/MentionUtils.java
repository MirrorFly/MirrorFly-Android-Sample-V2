package com.contusfly.groupmention;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J4\u0010\u0010\u001a\u00020\u00072\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rJ4\u0010\u001d\u001a\u00020\u00072\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ,\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0002J \u0010&\u001a\u00020#2\u0006\u0010\'\u001a\u00020%2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\rR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/contusfly/groupmention/MentionUtils;", "", "()V", "MENTION1", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "convertMessageToMentionFormat", "Landroid/text/SpannableStringBuilder;", "message", "Lcom/mirrorflysdk/api/models/ChatMessage;", "mentionedText", "", "mentionClickable", "", "context", "Landroid/content/Context;", "convertMessageToUnsentMessageMentionFormat", "mentionedUsersIds", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "chatMessageEditText", "Lcom/contusfly/groupmention/MentionEditGroupText;", "formatMentionText", "formatMentionTextForMediaCaption", "caption", "formatMentionTextForReplyParent", "replyParentMessage", "Lcom/mirrorflysdk/api/models/ReplyParentChatMessage;", "formatReplyMentionText", "formatUnSentMentionText", "getMentionTextForRecentChat", "getMentionedUserId", "mentionedMessage", "mentionUserIdSearchAvoid", "setMentionClickable", "", "spannable", "Landroid/text/SpannableString;", "setSpanColorText", "spannableString", "isMentionedCurrentUser", "app_debug"})
public final class MentionUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.groupmention.MentionUtils INSTANCE = null;
    private static final java.util.regex.Pattern MENTION1 = null;
    
    private MentionUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder formatMentionText(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message, boolean mentionClickable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder formatReplyMentionText(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ReplyParentChatMessage message, boolean mentionClickable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder getMentionedUserId(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage mentionedMessage, boolean mentionClickable) {
        return null;
    }
    
    private final android.text.SpannableStringBuilder mentionUserIdSearchAvoid(com.mirrorflysdk.api.models.ChatMessage message, java.lang.String mentionedText, boolean mentionClickable, android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder formatMentionTextForMediaCaption(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.NotNull
    java.lang.String caption, boolean mentionClickable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder formatUnSentMentionText(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> mentionedUsersIds, @org.jetbrains.annotations.Nullable
    java.lang.String mentionedText, @org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.groupmention.MentionEditGroupText chatMessageEditText) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder convertMessageToUnsentMessageMentionFormat(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> mentionedUsersIds, @org.jetbrains.annotations.Nullable
    java.lang.String mentionedText, @org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.groupmention.MentionEditGroupText chatMessageEditText) {
        return null;
    }
    
    private final android.text.SpannableStringBuilder convertMessageToMentionFormat(com.mirrorflysdk.api.models.ChatMessage message, java.lang.String mentionedText, boolean mentionClickable, android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder formatMentionTextForReplyParent(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ReplyParentChatMessage replyParentMessage, boolean mentionClickable) {
        return null;
    }
    
    private final void setMentionClickable(boolean mentionClickable, android.text.SpannableString spannable) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder getMentionTextForRecentChat(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
        return null;
    }
    
    public final void setSpanColorText(@org.jetbrains.annotations.NotNull
    android.text.SpannableString spannableString, @org.jetbrains.annotations.Nullable
    android.content.Context context, boolean isMentionedCurrentUser) {
    }
}