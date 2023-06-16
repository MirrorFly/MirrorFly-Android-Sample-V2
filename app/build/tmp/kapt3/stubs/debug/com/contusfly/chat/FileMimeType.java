package com.contusfly.chat;

import java.lang.System;

/**
 * This class contains Mime Type Constants
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@androidx.annotation.StringDef(value = {"image", "video", "audio", "application", "unsupported_format"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/contusfly/chat/FileMimeType;", "", "Companion", "app_debug"})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
public abstract @interface FileMimeType {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.chat.FileMimeType.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE = "image";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VIDEO = "video";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AUDIO = "audio";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APPLICATION = "application";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNSUPPORTED_FORMAT = "unsupported_format";
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/chat/FileMimeType$Companion;", "", "()V", "APPLICATION", "", "AUDIO", "IMAGE", "UNSUPPORTED_FORMAT", "VIDEO", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IMAGE = "image";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String VIDEO = "video";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String AUDIO = "audio";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String APPLICATION = "application";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String UNSUPPORTED_FORMAT = "unsupported_format";
        
        private Companion() {
            super();
        }
    }
}