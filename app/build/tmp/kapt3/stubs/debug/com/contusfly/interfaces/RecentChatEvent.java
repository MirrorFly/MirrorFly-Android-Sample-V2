package com.contusfly.interfaces;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@androidx.annotation.StringDef(value = {"group_events", "archive_events", "message_received", "message_updated", "mute_event", "pin_event"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/contusfly/interfaces/RecentChatEvent;", "", "Companion", "app_debug"})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
public abstract @interface RecentChatEvent {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.interfaces.RecentChatEvent.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String GROUP_EVENT = "group_events";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ARCHIVE_EVENT = "archive_events";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MESSAGE_RECEIVED = "message_received";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MESSAGE_UPDATED = "message_updated";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MUTE_EVENT = "mute_event";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PIN_EVENT = "pin_event";
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/interfaces/RecentChatEvent$Companion;", "", "()V", "ARCHIVE_EVENT", "", "GROUP_EVENT", "MESSAGE_RECEIVED", "MESSAGE_UPDATED", "MUTE_EVENT", "PIN_EVENT", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String GROUP_EVENT = "group_events";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ARCHIVE_EVENT = "archive_events";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MESSAGE_RECEIVED = "message_received";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MESSAGE_UPDATED = "message_updated";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MUTE_EVENT = "mute_event";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String PIN_EVENT = "pin_event";
        
        private Companion() {
            super();
        }
    }
}