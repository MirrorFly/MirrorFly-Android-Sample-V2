package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/contusfly/utils/LogMessage;", "", "()V", "Companion", "app_debug"})
public final class LogMessage {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.LogMessage.Companion Companion = null;
    private static boolean isDebugEnabled = false;
    
    public LogMessage() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/utils/LogMessage$Companion;", "", "()V", "isDebugEnabled", "", "d", "", "tag", "", "message", "e", "error", "", "enableDebugLogging", "boolean", "i", "v", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void enableDebugLogging(boolean p0_32355860) {
        }
        
        public final void i(@org.jetbrains.annotations.Nullable()
        java.lang.String tag, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
        
        public final void v(@org.jetbrains.annotations.Nullable()
        java.lang.String tag, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
        
        public final void e(@org.jetbrains.annotations.Nullable()
        java.lang.String tag, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
        
        public final void d(@org.jetbrains.annotations.Nullable()
        java.lang.String tag, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
        
        public final void e(@org.jetbrains.annotations.Nullable()
        java.lang.String tag, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable error) {
        }
    }
}