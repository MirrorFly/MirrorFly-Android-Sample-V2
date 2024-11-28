package com.contusfly.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/contusfly/models/ChatItemRowModel;", "", "messageItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "filePath", "", "time", "base64Img", "searchEnabled", "", "searchKey", "(Lcom/mirrorflysdk/api/models/ChatMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBase64Img", "()Ljava/lang/String;", "setBase64Img", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "getMessageItem", "()Lcom/mirrorflysdk/api/models/ChatMessage;", "setMessageItem", "(Lcom/mirrorflysdk/api/models/ChatMessage;)V", "getSearchEnabled", "()Z", "setSearchEnabled", "(Z)V", "getSearchKey", "setSearchKey", "getTime", "setTime", "app_debug"})
public final class ChatItemRowModel {
    @org.jetbrains.annotations.NotNull
    private com.mirrorflysdk.api.models.ChatMessage messageItem;
    @org.jetbrains.annotations.Nullable
    private java.lang.String filePath;
    @org.jetbrains.annotations.Nullable
    private java.lang.String time;
    @org.jetbrains.annotations.Nullable
    private java.lang.String base64Img;
    private boolean searchEnabled;
    @org.jetbrains.annotations.NotNull
    private java.lang.String searchKey;
    
    public ChatItemRowModel(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.Nullable
    java.lang.String filePath, @org.jetbrains.annotations.Nullable
    java.lang.String time, @org.jetbrains.annotations.Nullable
    java.lang.String base64Img, boolean searchEnabled, @org.jetbrains.annotations.NotNull
    java.lang.String searchKey) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.api.models.ChatMessage getMessageItem() {
        return null;
    }
    
    public final void setMessageItem(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFilePath() {
        return null;
    }
    
    public final void setFilePath(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBase64Img() {
        return null;
    }
    
    public final void setBase64Img(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
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
}