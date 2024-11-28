package com.contusfly.quickShare;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@androidx.annotation.StringDef(value = {"media", "contact", "text"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/contusfly/quickShare/ShareType;", "", "Companion", "app_debug"})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
public abstract @interface ShareType {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.quickShare.ShareType.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MEDIA = "media";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CONTACT = "contact";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TEXT = "text";
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/quickShare/ShareType$Companion;", "", "()V", "CONTACT", "", "MEDIA", "TEXT", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEDIA = "media";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONTACT = "contact";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String TEXT = "text";
        
        private Companion() {
            super();
        }
    }
}