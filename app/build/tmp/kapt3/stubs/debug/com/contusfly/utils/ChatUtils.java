package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u001a\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bJ\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bH\u0002J \u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bJ\u0016\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\bJ+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\'\u001a\u0004\u0018\u00010%\u00a2\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\bJ\u000e\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bJ\u0010\u00100\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\bJ\u001e\u00101\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00102\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ$\u00103\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ\u0016\u00109\u001a\u00020:2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010;\u001a\u00020<J$\u0010=\u001a\u00020\u00042\f\u0010>\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ \u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J.\u0010C\u001a\u00020\u00042\u0006\u0010@\u001a\u00020<2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010A\u001a\u00020B2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\nJ0\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010\u001b\u001a\u00020<2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010J2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J \u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J(\u0010L\u001a\b\u0012\u0004\u0012\u00020\b0M2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0J2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0MJ\u0016\u0010Q\u001a\u0004\u0018\u00010\b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a8\u0006S"}, d2 = {"Lcom/contusfly/utils/ChatUtils;", "", "()V", "askCallSwitchPopup", "", "context", "Landroid/content/Context;", "url", "", "checkMediaPermission", "", "permission", "checkNotificationPermission", "checkWritePermission", "convertProfileDetailsList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "value", "copy", "src", "Ljava/io/File;", "dst", "copyGif", "srcPath", "getFileSizeText", "fileSizeInBytes", "getHtmlChatMessageText", "message", "getJidFromPhoneNumber", "phoneNumberUtil", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "mobileNumber", "countryCode", "getLastSeenTime", "time", "getMobileWidthAndHeight", "Lkotlin/Pair;", "", "originalWidth", "originalHeight", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlin/Pair;", "getRoundedFileSize", "", "unscaledValue", "getSpannedText", "Landroid/text/Spanned;", "getUserFromJid", "jid", "isMine", "navigateToOnGoingCallPreviewScreen", "userJid", "setCameraPreviewActivity", "chatClass", "Ljava/lang/Class;", "Lcom/contusfly/activities/MediaPreviewActivity;", "toUser", "chatType", "setMentionFormattedTextForRecentChat", "Landroid/text/SpannableStringBuilder;", "chatMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "setPreviewActivity", "previewClass", "setReplyParentMessage", "replyMessage", "textView", "Lcom/contusfly/views/MessageTextView;", "setReplyViewMessageFormat", "messageMediaCaption", "isMediaMessage", "setSelectedChatItem", "view", "Landroid/view/View;", "selectedMessages", "", "isHighLighted", "setSelectedUserIdForMention", "", "mentionedUsersId", "Lcom/contusfly/groupmention/MentionUser;", "mentionedUsersIds", "toUserList", "list", "app_debug"})
public final class ChatUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.ChatUtils INSTANCE = null;
    
    private ChatUtils() {
        super();
    }
    
    public final void setSelectedChatItem(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage message, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> selectedMessages, @org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    public final void setSelectedChatItem(@org.jetbrains.annotations.NotNull()
    android.view.View view, boolean isHighLighted, @org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    /**
     * Copies gif file from source to destination
     *
     * @param srcPath Source gif file
     * @param dst Destination file
     */
    public final void copyGif(@org.jetbrains.annotations.NotNull()
    java.lang.String srcPath, @org.jetbrains.annotations.Nullable()
    java.io.File dst) {
    }
    
    /**
     * Copies file from source to destination
     *
     * @param src Source file
     * @param dst Destination file
     */
    public final void copy(@org.jetbrains.annotations.Nullable()
    java.io.File src, @org.jetbrains.annotations.Nullable()
    java.io.File dst) {
    }
    
    public final boolean checkNotificationPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    public final boolean checkMediaPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    public final boolean checkWritePermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    public final void setPreviewActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<com.contusfly.activities.MediaPreviewActivity> previewClass, @org.jetbrains.annotations.NotNull()
    java.lang.String toUser, @org.jetbrains.annotations.NotNull()
    java.lang.String chatType) {
    }
    
    public final void setCameraPreviewActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<com.contusfly.activities.MediaPreviewActivity> chatClass, @org.jetbrains.annotations.NotNull()
    java.lang.String toUser, @org.jetbrains.annotations.NotNull()
    java.lang.String chatType) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserFromJid(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return null;
    }
    
    /**
     * Prepares the file size text to be displayed from the actual size represented in bytes.
     *
     * @param fileSizeInBytes The actual file size represented in bytes.
     * @return The file size represented in the byte convention format.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFileSizeText(@org.jetbrains.annotations.NotNull()
    java.lang.String fileSizeInBytes) {
        return null;
    }
    
    /**
     * Returns a new double value with the specified scale.
     *
     * @param unscaledValue Value to be converted to a [Double].
     * @return [Double] instance with the value `unscaledVal`.
     */
    private final double getRoundedFileSize(double unscaledValue) {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getJidFromPhoneNumber(@org.jetbrains.annotations.NotNull()
    io.michaelrocks.libphonenumber.android.PhoneNumberUtil phoneNumberUtil, @org.jetbrains.annotations.NotNull()
    java.lang.String mobileNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String countryCode) {
        return null;
    }
    
    public final boolean navigateToOnGoingCallPreviewScreen(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String userJid, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    private final void askCallSwitchPopup(android.content.Context context, java.lang.String url) {
    }
    
    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    @org.jetbrains.annotations.NotNull()
    public final android.text.Spanned getSpannedText(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return null;
    }
    
    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in
     * FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private final java.lang.String getHtmlChatMessageText(android.content.Context context, java.lang.String message) {
        return null;
    }
    
    public final boolean isMine(@org.jetbrains.annotations.Nullable()
    java.lang.String jid) {
        return false;
    }
    
    /**
     * Returns mentionformatted message
     *
     * @param context Context
     * @param chatMessage ChatMessage content
     * @return SpannableStringBuilder Result
     */
    @org.jetbrains.annotations.NotNull()
    public final android.text.SpannableStringBuilder setMentionFormattedTextForRecentChat(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage chatMessage) {
        return null;
    }
    
    /**
     * Convert mention original format to name for mention tag
     *
     * @param context Context
     * @param replyMessage ChatMessage content
     * @param textView MessageTextView
     * @param messageMediaCaption String to set the messagecontent from mediaMEssage for message info
     * @param isMediaMessage Boolean to identify image,video or text
     */
    public final void setReplyViewMessageFormat(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage replyMessage, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.MessageTextView textView, @org.jetbrains.annotations.NotNull()
    java.lang.String messageMediaCaption, boolean isMediaMessage) {
    }
    
    /**
     * setReplyMessage
     * @param replyMessage ChatMeasage
     * @param textView MessageTextview
     * @param context Context
     */
    private final void setReplyParentMessage(com.mirrorflysdk.api.models.ChatMessage replyMessage, com.contusfly.views.MessageTextView textView, android.content.Context context) {
    }
    
    /**
     * Convert mentionuser model object into list
     *
     * @param mentionedUsersId mentioned usersids as modelclass
     * @param mentionedUsersIds MutableList<String>
     *
     * @return mentionedUsersIds MutableList<String>
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> setSelectedUserIdForMention(@org.jetbrains.annotations.NotNull()
    java.util.List<com.contusfly.groupmention.MentionUser> mentionedUsersId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> mentionedUsersIds) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastSeenTime(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String time) {
        return null;
    }
    
    /**
     * Get Width and Height for Mobile
     *
     * @param originalWidth original width of media
     * @param originalHeight original height of media
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> getMobileWidthAndHeight(@org.jetbrains.annotations.Nullable()
    java.lang.Integer originalWidth, @org.jetbrains.annotations.Nullable()
    java.lang.Integer originalHeight) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String toUserList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> list) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> convertProfileDetailsList(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
}