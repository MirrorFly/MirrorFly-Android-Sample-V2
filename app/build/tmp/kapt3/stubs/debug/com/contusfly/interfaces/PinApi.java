package com.contusfly.interfaces;

import java.lang.System;

/**
 * This class contains call status constants
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/contusfly/interfaces/PinApi;", "", "Companion", "app_debug"})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
public abstract @interface PinApi {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.interfaces.PinApi.Companion Companion = null;
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/interfaces/PinApi$Companion;", "", "()V", "REQUEST_OTP", "", "getREQUEST_OTP", "()Ljava/lang/String;", "setREQUEST_OTP", "(Ljava/lang/String;)V", "SAVE_PIN", "getSAVE_PIN", "setSAVE_PIN", "VERIFY_OTP", "getVERIFY_OTP", "setVERIFY_OTP", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        private static java.lang.String REQUEST_OTP = "request_otp";
        @org.jetbrains.annotations.NotNull
        private static java.lang.String VERIFY_OTP = "verify_otp";
        @org.jetbrains.annotations.NotNull
        private static java.lang.String SAVE_PIN = "save_pin";
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getREQUEST_OTP() {
            return null;
        }
        
        public final void setREQUEST_OTP(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getVERIFY_OTP() {
            return null;
        }
        
        public final void setVERIFY_OTP(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSAVE_PIN() {
            return null;
        }
        
        public final void setSAVE_PIN(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
    }
}