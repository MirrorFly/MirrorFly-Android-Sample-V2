package com.contusfly.call;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/contusfly/call/CallConfiguration;", "", "()V", "IS_GROUP_CALL_ENABLED", "", "isGroupCallEnabled", "", "setIsGroupCallEnabled", "", "enabled", "app_debug"})
public final class CallConfiguration {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.call.CallConfiguration INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String IS_GROUP_CALL_ENABLED = "is_group_call_enabled";
    
    /**
     * flag indicates whether group call feature is enabled or not
     *
     * setting this flag to false will hide call buttons from group, call logs
     * add group call button , add participants button in one to one call
     * and also the call button of group call logs in call log screen.
     */
    private static boolean isGroupCallEnabled = false;
    
    private CallConfiguration() {
        super();
    }
    
    public final boolean isGroupCallEnabled() {
        return false;
    }
    
    public final void setIsGroupCallEnabled(boolean enabled) {
    }
}