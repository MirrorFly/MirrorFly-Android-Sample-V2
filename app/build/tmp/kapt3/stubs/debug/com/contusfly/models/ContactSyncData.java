package com.contusfly.models;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/contusfly/models/ContactSyncData;", "", "data", "Lcom/contusfly/models/ContusContactList;", "error", "", "message", "status", "", "(Lcom/contusfly/models/ContusContactList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getData", "()Lcom/contusfly/models/ContusContactList;", "getError", "()Ljava/lang/String;", "getMessage", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Lcom/contusfly/models/ContusContactList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/contusfly/models/ContactSyncData;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class ContactSyncData {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "data")
    private final com.contusfly.models.ContusContactList data = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "error")
    private final java.lang.String error = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "message")
    private final java.lang.String message = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "status")
    private final java.lang.Integer status = null;
    
    /**
     * @author ContusTeam <developers@contus.in>
     * @version 1.0
     */
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.ContactSyncData copy(@org.jetbrains.annotations.Nullable
    com.contusfly.models.ContusContactList data, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.Nullable
    java.lang.String message, @org.jetbrains.annotations.Nullable
    java.lang.Integer status) {
        return null;
    }
    
    /**
     * @author ContusTeam <developers@contus.in>
     * @version 1.0
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * @author ContusTeam <developers@contus.in>
     * @version 1.0
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * @author ContusTeam <developers@contus.in>
     * @version 1.0
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public ContactSyncData() {
        super();
    }
    
    public ContactSyncData(@org.jetbrains.annotations.Nullable
    com.contusfly.models.ContusContactList data, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.Nullable
    java.lang.String message, @org.jetbrains.annotations.Nullable
    java.lang.Integer status) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.models.ContusContactList component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.models.ContusContactList getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getStatus() {
        return null;
    }
}