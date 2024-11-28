package com.contusfly.interfaces;

import java.lang.System;

/**
 * This class contains call status constants
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/contusfly/interfaces/PinStatus;", "", "Companion", "app_debug"})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
public abstract @interface PinStatus {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.interfaces.PinStatus.Companion Companion = null;
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/interfaces/PinStatus$Companion;", "", "()V", "PIN_CHANGE", "", "getPIN_CHANGE", "()Ljava/lang/String;", "setPIN_CHANGE", "(Ljava/lang/String;)V", "PIN_DISABLE", "getPIN_DISABLE", "setPIN_DISABLE", "PIN_FORGOT", "getPIN_FORGOT", "setPIN_FORGOT", "PIN_SET", "getPIN_SET", "setPIN_SET", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        private static java.lang.String PIN_SET = "pin_set";
        @org.jetbrains.annotations.NotNull
        private static java.lang.String PIN_CHANGE = "pin_change";
        @org.jetbrains.annotations.NotNull
        private static java.lang.String PIN_FORGOT = "pin_forgot";
        @org.jetbrains.annotations.NotNull
        private static java.lang.String PIN_DISABLE = "pin_disable";
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPIN_SET() {
            return null;
        }
        
        public final void setPIN_SET(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPIN_CHANGE() {
            return null;
        }
        
        public final void setPIN_CHANGE(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPIN_FORGOT() {
            return null;
        }
        
        public final void setPIN_FORGOT(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPIN_DISABLE() {
            return null;
        }
        
        public final void setPIN_DISABLE(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
    }
}