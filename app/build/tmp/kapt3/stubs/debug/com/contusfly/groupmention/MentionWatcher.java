package com.contusfly.groupmention;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/groupmention/MentionWatcher;", "", "editText", "Landroid/widget/EditText;", "mentionConfig", "Lcom/contusfly/groupmention/UserMentionConfig;", "handler", "Lcom/contusfly/groupmention/MentionWatcher$OnMentionTextChanges;", "(Landroid/widget/EditText;Lcom/contusfly/groupmention/UserMentionConfig;Lcom/contusfly/groupmention/MentionWatcher$OnMentionTextChanges;)V", "delimiter", "", "getEditText", "()Landroid/widget/EditText;", "getHandler", "()Lcom/contusfly/groupmention/MentionWatcher$OnMentionTextChanges;", "trigger", "findMention", "", "editable", "Landroid/text/Editable;", "Companion", "OnMentionTextChanges", "app_debug"})
public final class MentionWatcher {
    @org.jetbrains.annotations.NotNull
    private final android.widget.EditText editText = null;
    @org.jetbrains.annotations.NotNull
    private final com.contusfly.groupmention.MentionWatcher.OnMentionTextChanges handler = null;
    private final java.lang.String trigger = null;
    private final java.lang.String delimiter = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.groupmention.MentionWatcher.Companion Companion = null;
    
    public MentionWatcher(@org.jetbrains.annotations.NotNull
    android.widget.EditText editText, @org.jetbrains.annotations.NotNull
    com.contusfly.groupmention.UserMentionConfig mentionConfig, @org.jetbrains.annotations.NotNull
    com.contusfly.groupmention.MentionWatcher.OnMentionTextChanges handler) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText getEditText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.groupmention.MentionWatcher.OnMentionTextChanges getHandler() {
        return null;
    }
    
    public final void findMention(@org.jetbrains.annotations.NotNull
    android.text.Editable editable) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final int findTriggerIndex(@org.jetbrains.annotations.NotNull
    android.widget.EditText editText, @org.jetbrains.annotations.NotNull
    java.lang.String trigger, @org.jetbrains.annotations.NotNull
    java.lang.String delimiter, int cursorPosition) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/groupmention/MentionWatcher$OnMentionTextChanges;", "", "onMentionTextDetectStateChanged", "", "isDetected", "", "detectedKeyword", "", "app_debug"})
    public static abstract interface OnMentionTextChanges {
        
        public abstract void onMentionTextDetectStateChanged(boolean isDetected, @org.jetbrains.annotations.Nullable
        java.lang.CharSequence detectedKeyword);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/groupmention/MentionWatcher$Companion;", "", "()V", "findTriggerIndex", "", "editText", "Landroid/widget/EditText;", "trigger", "", "delimiter", "cursorPosition", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.JvmStatic
        public final int findTriggerIndex(@org.jetbrains.annotations.NotNull
        android.widget.EditText editText, @org.jetbrains.annotations.NotNull
        java.lang.String trigger, @org.jetbrains.annotations.NotNull
        java.lang.String delimiter, int cursorPosition) {
            return 0;
        }
    }
}