package com.contusfly.models;

import java.lang.System;

/**
 * This class will show the list of created, updated, deleted contus contact
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/models/ContusContactList;", "", "()V", "created", "", "Lcom/contusfly/models/ContusContacts;", "getCreated", "()Ljava/util/List;", "setCreated", "(Ljava/util/List;)V", "deleted", "getDeleted", "setDeleted", "updated", "getUpdated", "setUpdated", "app_debug"})
public final class ContusContactList {
    
    /**
     * variable holds created contus contact list.
     */
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "created")
    private java.util.List<com.contusfly.models.ContusContacts> created;
    
    /**
     * variable holds updated contus contact list.
     */
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "updated")
    private java.util.List<com.contusfly.models.ContusContacts> updated;
    
    /**
     * variable holds contus contact list to be delete.
     */
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "deleted")
    private java.util.List<com.contusfly.models.ContusContacts> deleted;
    
    public ContusContactList() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.contusfly.models.ContusContacts> getCreated() {
        return null;
    }
    
    public final void setCreated(@org.jetbrains.annotations.Nullable
    java.util.List<com.contusfly.models.ContusContacts> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.contusfly.models.ContusContacts> getUpdated() {
        return null;
    }
    
    public final void setUpdated(@org.jetbrains.annotations.Nullable
    java.util.List<com.contusfly.models.ContusContacts> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.contusfly.models.ContusContacts> getDeleted() {
        return null;
    }
    
    public final void setDeleted(@org.jetbrains.annotations.Nullable
    java.util.List<com.contusfly.models.ContusContacts> p0) {
    }
}