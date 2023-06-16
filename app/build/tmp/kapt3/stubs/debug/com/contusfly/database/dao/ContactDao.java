package com.contusfly.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\'J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\'J%\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\f\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/database/dao/ContactDao;", "", "deleteAllContacts", "", "getBlockedMeContacts", "", "Lcom/contusfly/database/model/ContactModel;", "getContact", "jid", "", "insertContact", "contactModel", "", "([Lcom/contusfly/database/model/ContactModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertContacts", "users", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ContactDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertContact(@org.jetbrains.annotations.NotNull()
    com.contusfly.database.model.ContactModel[] contactModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertContacts(@org.jetbrains.annotations.NotNull()
    java.util.List<com.contusfly.database.model.ContactModel> users, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM ContactModel WHERE isBlockedMe")
    public abstract java.util.List<com.contusfly.database.model.ContactModel> getBlockedMeContacts();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM ContactModel WHERE jid LIKE (:jid)")
    public abstract com.contusfly.database.model.ContactModel getContact(@org.jetbrains.annotations.NotNull()
    java.lang.String jid);
    
    @androidx.room.Query(value = "delete from ContactModel ")
    public abstract void deleteAllContacts();
}