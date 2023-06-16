package com.contusfly.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/models/GroupedMedia;", "", "()V", "id", "", "getId", "()J", "Header", "MessageItem", "Lcom/contusfly/models/GroupedMedia$MessageItem;", "Lcom/contusfly/models/GroupedMedia$Header;", "app_debug"})
public abstract class GroupedMedia {
    
    private GroupedMedia() {
        super();
    }
    
    public abstract long getId();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/contusfly/models/GroupedMedia$MessageItem;", "Lcom/contusfly/models/GroupedMedia;", "chatMessage", "Lcom/mirrorflysdk/api/models/ChatMessage;", "linkMap", "", "", "(Lcom/mirrorflysdk/api/models/ChatMessage;Ljava/util/Map;)V", "getChatMessage", "()Lcom/mirrorflysdk/api/models/ChatMessage;", "id", "", "getId", "()J", "getLinkMap", "()Ljava/util/Map;", "setLinkMap", "(Ljava/util/Map;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class MessageItem extends com.contusfly.models.GroupedMedia {
        @org.jetbrains.annotations.NotNull()
        private final com.mirrorflysdk.api.models.ChatMessage chatMessage = null;
        @org.jetbrains.annotations.NotNull()
        private java.util.Map<java.lang.String, java.lang.String> linkMap;
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.models.GroupedMedia.MessageItem copy(@org.jetbrains.annotations.NotNull()
        com.mirrorflysdk.api.models.ChatMessage chatMessage, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> linkMap) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public MessageItem(@org.jetbrains.annotations.NotNull()
        com.mirrorflysdk.api.models.ChatMessage chatMessage, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> linkMap) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mirrorflysdk.api.models.ChatMessage component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mirrorflysdk.api.models.ChatMessage getChatMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.lang.String, java.lang.String> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.lang.String, java.lang.String> getLinkMap() {
            return null;
        }
        
        public final void setLinkMap(@org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> p0) {
        }
        
        @java.lang.Override()
        public long getId() {
            return 0L;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/models/GroupedMedia$Header;", "Lcom/contusfly/models/GroupedMedia;", "titleName", "", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "getTitleName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Header extends com.contusfly.models.GroupedMedia {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String titleName = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.models.GroupedMedia.Header copy(@org.jetbrains.annotations.NotNull()
        java.lang.String titleName) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public Header(@org.jetbrains.annotations.NotNull()
        java.lang.String titleName) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitleName() {
            return null;
        }
        
        @java.lang.Override()
        public long getId() {
            return 0L;
        }
    }
}