package com.contusfly.call.calllog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0012H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/contusfly/call/calllog/CallLogRepository;", "", "()V", "tag", "", "kotlin.jvm.PlatformType", "filteredCallLogs", "", "Lcom/mirrorflysdk/flycall/call/database/model/CallLog;", "searchKey", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCallLog", "roomId", "getCallLogs", "getEndUserJid", "callLog", "setProfile", "toUser", "Lcom/mirrorflysdk/flydatabase/model/CallLogs;", "app_debug"})
@javax.inject.Singleton()
public final class CallLogRepository {
    private final java.lang.String tag = null;
    
    @javax.inject.Inject()
    public CallLogRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog> getCallLogs() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object filteredCallLogs(@org.jetbrains.annotations.NotNull()
    java.lang.String searchKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog>> continuation) {
        return null;
    }
    
    private final java.lang.String getEndUserJid(com.mirrorflysdk.flycall.call.database.model.CallLog callLog) {
        return null;
    }
    
    @kotlin.jvm.Synchronized()
    private final synchronized com.mirrorflysdk.flycall.call.database.model.CallLog setProfile(java.lang.String toUser, com.mirrorflysdk.flycall.call.database.model.CallLog callLog) {
        return null;
    }
    
    @kotlin.jvm.Synchronized()
    private final synchronized com.mirrorflysdk.flydatabase.model.CallLogs setProfile(java.lang.String toUser, com.mirrorflysdk.flydatabase.model.CallLogs callLog) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCallLog(@org.jetbrains.annotations.NotNull()
    java.lang.String roomId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mirrorflysdk.flycall.call.database.model.CallLog> continuation) {
        return null;
    }
}