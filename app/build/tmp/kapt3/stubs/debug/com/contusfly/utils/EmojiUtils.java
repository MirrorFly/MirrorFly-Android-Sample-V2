package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J2\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J2\u0010\u0014\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J:\u0010\u0016\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J2\u0010\u0019\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J:\u0010\u001a\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\u0006J(\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004\u00a8\u0006\u001e"}, d2 = {"Lcom/contusfly/utils/EmojiUtils;", "", "()V", "getGraphemeLength", "", "value", "", "setEllipsisText", "", "txtView", "Landroid/widget/TextView;", "text", "setEmojiText", "textView", "setEmojiTextAndHighLightSearchContact", "context", "Landroid/content/Context;", "Landroidx/emoji/widget/EmojiAppCompatTextView;", "startIndex", "stopIndex", "setEmojiTextAndHighLightSearchText", "Lcom/contusfly/views/CustomTextView;", "setEmojiTextAndHighLightSearchTextForMention", "mentionedUserName", "Landroid/text/SpannableStringBuilder;", "setMediaTextHighLightSearched", "setMediaTextHighLightSearchedForMention", "setMessageTextWithEllipsis", "Lcom/contusfly/views/MessageTextView;", "setTextHighLightSearched", "app_debug"})
public final class EmojiUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.EmojiUtils INSTANCE = null;
    
    private EmojiUtils() {
        super();
    }
    
    /**
     * Sets the emoji text after decode the UTF-8 method.
     *
     * @param textView The instance of the CustomTextView
     * @param text     The text to set in the view
     */
    public final void setEmojiText(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text) {
    }
    
    /**
     * Sets the emoji text after decode the UTF-8 method.
     *
     * @param txtView The instance of the TextView
     * @param text     The text to set in the view
     */
    public final void setEllipsisText(@org.jetbrains.annotations.NotNull()
    android.widget.TextView txtView, @org.jetbrains.annotations.Nullable()
    java.lang.String text) {
    }
    
    /**
     * Sets the emoji text after decode the UTF-8 method.
     *
     * @param textView The instance of the MessageTextView
     * @param text     The text to set in the view
     */
    public final void setMessageTextWithEllipsis(@org.jetbrains.annotations.NotNull()
    com.contusfly.views.MessageTextView textView, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    /**
     * Sets the emoji text after decode the UTF-8 method and highlight the search text.
     *
     * @param textView   The instance of the CustomTextView
     * @param text       The text to set in the view
     * @param startIndex Starting position to highlight the text
     * @param stopIndex  Ending position to highlight the text
     */
    public final void setEmojiTextAndHighLightSearchText(@org.jetbrains.annotations.NotNull()
    com.contusfly.views.CustomTextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text, int startIndex, int stopIndex) {
    }
    
    public final void setEmojiTextAndHighLightSearchText(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text, int startIndex, int stopIndex) {
    }
    
    public final void setEmojiTextAndHighLightSearchTextForMention(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text, int startIndex, int stopIndex, @org.jetbrains.annotations.NotNull()
    android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    public final void setEmojiTextAndHighLightSearchContact(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.emoji.widget.EmojiAppCompatTextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text, int startIndex, int stopIndex) {
    }
    
    /**
     * Sets the emoji text after decode the UTF-8 method and highlight the search text.
     *
     * @param textView   The instance of the CustomTextView
     * @param text       The text to set in the view
     * @param startIndex Starting position to highlight the text
     * @param stopIndex  Ending position to highlight the text
     */
    public final void setMediaTextHighLightSearched(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text, int startIndex, int stopIndex) {
    }
    
    public final void setMediaTextHighLightSearchedForMention(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text, int startIndex, int stopIndex, @org.jetbrains.annotations.NotNull()
    android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    /**
     * Sets the emoji text after decode the UTF-8 method and highlight the search text.
     *
     * @param textView   The instance of the CustomTextView
     * @param text       The text to set in the view
     * @param startIndex Starting position to highlight the text
     * @param stopIndex  Ending position to highlight the text
     */
    public final void setEmojiTextAndHighLightSearchText(@org.jetbrains.annotations.NotNull()
    androidx.emoji.widget.EmojiAppCompatTextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text, int startIndex, int stopIndex) {
    }
    
    /**
     * Sets the emoji text after decode the UTF-8 method and highlight the search text.
     *
     * @param textView   The instance of the CustomTextView
     * @param text       The text to set in the view
     * @param startIndex Starting position to highlight the text
     * @param stopIndex  Ending position to highlight the text
     */
    public final void setTextHighLightSearched(@org.jetbrains.annotations.NotNull()
    androidx.emoji.widget.EmojiAppCompatTextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.String text, int startIndex, int stopIndex) {
    }
    
    /**
     * Count Emoji & text character number. Available with JDK 8 or higher
     *
     * @param value
     * @return
     */
    public final int getGraphemeLength(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return 0;
    }
}