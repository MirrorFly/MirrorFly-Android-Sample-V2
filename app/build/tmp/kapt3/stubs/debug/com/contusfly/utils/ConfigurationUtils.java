package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/contusfly/utils/ConfigurationUtils;", "", "()V", "Companion", "app_debug"})
public final class ConfigurationUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.ConfigurationUtils.Companion Companion = null;
    
    public ConfigurationUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/contusfly/utils/ConfigurationUtils$Companion;", "", "()V", "insertDefaultBusyStatus", "", "context", "Landroid/content/Context;", "insertDefaultStatus", "status", "", "insertDefaultStatusToUser", "setDefaultValues", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Set Default values in Mobile Application
         */
        public final void setDefaultValues(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        /**
         * Insert the default status for the logged in user. Also initiate the message tone and vibration alert and conversation settings data.
         *
         * @param context Instance of application
         */
        public final void insertDefaultStatus(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.Nullable
        java.lang.String status) {
        }
        
        /**
         * Insert default busy status for the logged in user.
         *
         * @param context Instance of application
         */
        public final void insertDefaultBusyStatus(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        /**
         * Insert the default status for the logged in user. Also initiate the message tone and vibration alert and conversation settings data.
         *
         * @param context Instance of application
         */
        public final void insertDefaultStatusToUser(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.Nullable
        java.lang.String status) {
        }
    }
}