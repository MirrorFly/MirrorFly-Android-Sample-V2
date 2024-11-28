package com.contusfly.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006\'"}, d2 = {"Lcom/contusfly/models/MediaCaption;", "", "htmlText", "", "captionView", "Landroid/widget/TextView;", "searchEnabled", "", "searchKey", "", "mentionedUserName", "Landroid/text/SpannableStringBuilder;", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "(Ljava/lang/CharSequence;Landroid/widget/TextView;ZLjava/lang/String;Landroid/text/SpannableStringBuilder;Lcom/mirrorflysdk/api/models/ChatMessage;)V", "getCaptionView", "()Landroid/widget/TextView;", "setCaptionView", "(Landroid/widget/TextView;)V", "getHtmlText", "()Ljava/lang/CharSequence;", "setHtmlText", "(Ljava/lang/CharSequence;)V", "getMentionedUserName", "()Landroid/text/SpannableStringBuilder;", "setMentionedUserName", "(Landroid/text/SpannableStringBuilder;)V", "getMessageItem", "()Lcom/mirrorflysdk/api/models/ChatMessage;", "setMessageItem", "(Lcom/mirrorflysdk/api/models/ChatMessage;)V", "getSearchEnabled", "()Z", "setSearchEnabled", "(Z)V", "getSearchKey", "()Ljava/lang/String;", "setSearchKey", "(Ljava/lang/String;)V", "app_debug"})
public final class MediaCaption {
    @org.jetbrains.annotations.NotNull
    private java.lang.CharSequence htmlText;
    @org.jetbrains.annotations.NotNull
    private android.widget.TextView captionView;
    private boolean searchEnabled;
    @org.jetbrains.annotations.NotNull
    private java.lang.String searchKey;
    @org.jetbrains.annotations.NotNull
    private android.text.SpannableStringBuilder mentionedUserName;
    @org.jetbrains.annotations.NotNull
    private com.mirrorflysdk.api.models.ChatMessage messageItem;
    
    public MediaCaption(@org.jetbrains.annotations.NotNull
    java.lang.CharSequence htmlText, @org.jetbrains.annotations.NotNull
    android.widget.TextView captionView, boolean searchEnabled, @org.jetbrains.annotations.NotNull
    java.lang.String searchKey, @org.jetbrains.annotations.NotNull
    android.text.SpannableStringBuilder mentionedUserName, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.CharSequence getHtmlText() {
        return null;
    }
    
    public final void setHtmlText(@org.jetbrains.annotations.NotNull
    java.lang.CharSequence p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getCaptionView() {
        return null;
    }
    
    public final void setCaptionView(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    public final boolean getSearchEnabled() {
        return false;
    }
    
    public final void setSearchEnabled(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSearchKey() {
        return null;
    }
    
    public final void setSearchKey(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.text.SpannableStringBuilder getMentionedUserName() {
        return null;
    }
    
    public final void setMentionedUserName(@org.jetbrains.annotations.NotNull
    android.text.SpannableStringBuilder p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.api.models.ChatMessage getMessageItem() {
        return null;
    }
    
    public final void setMessageItem(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage p0) {
    }
}