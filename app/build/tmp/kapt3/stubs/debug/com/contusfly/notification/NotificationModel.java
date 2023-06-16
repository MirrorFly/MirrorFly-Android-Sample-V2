package com.contusfly.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/contusfly/notification/NotificationModel;", "", "messagingStyle", "Landroidx/core/app/NotificationCompat$MessagingStyle;", "messages", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "Lkotlin/collections/ArrayList;", "unReadMessageCount", "", "(Landroidx/core/app/NotificationCompat$MessagingStyle;Ljava/util/ArrayList;I)V", "getMessages", "()Ljava/util/ArrayList;", "setMessages", "(Ljava/util/ArrayList;)V", "getMessagingStyle", "()Landroidx/core/app/NotificationCompat$MessagingStyle;", "setMessagingStyle", "(Landroidx/core/app/NotificationCompat$MessagingStyle;)V", "getUnReadMessageCount", "()I", "setUnReadMessageCount", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class NotificationModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.core.app.NotificationCompat.MessagingStyle messagingStyle;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messages;
    private int unReadMessageCount;
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.notification.NotificationModel copy(@org.jetbrains.annotations.NotNull()
    androidx.core.app.NotificationCompat.MessagingStyle messagingStyle, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messages, int unReadMessageCount) {
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
    
    public NotificationModel(@org.jetbrains.annotations.NotNull()
    androidx.core.app.NotificationCompat.MessagingStyle messagingStyle, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messages, int unReadMessageCount) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.core.app.NotificationCompat.MessagingStyle component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.core.app.NotificationCompat.MessagingStyle getMessagingStyle() {
        return null;
    }
    
    public final void setMessagingStyle(@org.jetbrains.annotations.NotNull()
    androidx.core.app.NotificationCompat.MessagingStyle p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> getMessages() {
        return null;
    }
    
    public final void setMessages(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getUnReadMessageCount() {
        return 0;
    }
    
    public final void setUnReadMessageCount(int p0) {
    }
}