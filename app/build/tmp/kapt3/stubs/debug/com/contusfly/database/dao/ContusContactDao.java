package com.contusfly.database.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0019\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH\'J\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH\'J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH\'J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\'J%\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0015\"\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0015\"\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010\u0019\u001a\u00020\u00032\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0015\"\u00020\rH\'\u00a2\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0019\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ#\u0010 \u001a\u00020\u00032\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/contusfly/database/dao/ContusContactDao;", "", "deleteAllContusContacts", "", "deleteContusContact", "jid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteContusContacts", "jidList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdminBlockedContusContactS", "Lcom/contusfly/database/model/ContusContact;", "getAllContusContact", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBlockedContusContactS", "getBlockedMeContusContactS", "getContusContact", "insertAll", "users", "", "([Lcom/contusfly/database/model/ContusContact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertContusContact", "contusContact", "insertContusContactAsSingle", "([Lcom/contusfly/database/model/ContusContact;)V", "insertContusContacts", "isContusContact", "", "updateContusContact", "(Lcom/contusfly/database/model/ContusContact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateContusContacts", "list", "app_debug"})
public abstract interface ContusContactDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertContusContact(@org.jetbrains.annotations.NotNull
    com.contusfly.database.model.ContusContact[] contusContact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertContusContactAsSingle(@org.jetbrains.annotations.NotNull
    com.contusfly.database.model.ContusContact... contusContact);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertContusContacts(@org.jetbrains.annotations.NotNull
    java.util.List<com.contusfly.database.model.ContusContact> users, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull
    com.contusfly.database.model.ContusContact[] users, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM ContusContact WHERE jid = :jid")
    public abstract java.lang.Object deleteContusContact(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "delete from ContusContact where jid in (:jidList)")
    public abstract java.lang.Object deleteContusContacts(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> jidList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Query(value = "delete from ContusContact ")
    public abstract void deleteAllContusContacts();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM ContusContact WHERE jid LIKE (:jid)")
    public abstract com.contusfly.database.model.ContusContact getContusContact(@org.jetbrains.annotations.NotNull
    java.lang.String jid);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM ContusContact")
    public abstract java.lang.Object getAllContusContact(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.contusfly.database.model.ContusContact>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM ContusContact WHERE isBlocked")
    public abstract java.util.List<com.contusfly.database.model.ContusContact> getBlockedContusContactS();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM ContusContact WHERE isBlockedMe")
    public abstract java.util.List<com.contusfly.database.model.ContusContact> getBlockedMeContusContactS();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM ContusContact WHERE isAdminBlocked")
    public abstract java.util.List<com.contusfly.database.model.ContusContact> getAdminBlockedContusContactS();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateContusContact(@org.jetbrains.annotations.NotNull
    com.contusfly.database.model.ContusContact contusContact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateContusContacts(@org.jetbrains.annotations.Nullable
    java.util.List<com.contusfly.database.model.ContusContact> list, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Query(value = "SELECT count(*) FROM ContusContact WHERE jid LIKE (:jid)")
    public abstract int isContusContact(@org.jetbrains.annotations.NotNull
    java.lang.String jid);
}