package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0017\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/contusfly/utils/UIKitContactUtils;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "addUIKitContact", "", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "checkContactForBlockAndUnblockUser", "jid", "", "status", "", "clearAllData", "getProfileDetails", "getUserProfile", "contact", "Lcom/contusfly/database/model/ContactModel;", "resetBlockedContacts", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBlockedStatusOfUser", "jidList", "", "app_debug"})
public final class UIKitContactUtils implements kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.UIKitContactUtils INSTANCE = null;
    private static final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    
    private UIKitContactUtils() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.api.contacts.ProfileDetails getProfileDetails(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.api.contacts.ProfileDetails getUserProfile(@org.jetbrains.annotations.NotNull
    com.contusfly.database.model.ContactModel contact) {
        return null;
    }
    
    public final void addUIKitContact(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    public final void clearAllData() {
    }
    
    public final void checkContactForBlockAndUnblockUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, boolean status) {
    }
    
    public final void updateBlockedStatusOfUser(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> jidList) {
    }
    
    private final java.lang.Object resetBlockedContacts(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
}