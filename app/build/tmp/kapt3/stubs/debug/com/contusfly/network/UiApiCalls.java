package com.contusfly.network;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H\'J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2$\b\u0001\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H\'J7\u0010\u000f\u001a\u00020\r2$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/network/UiApiCalls;", "", "contactSyncAsync", "Lcom/contusfly/models/ContactSyncData;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactSync", "Lretrofit2/Call;", "Lorg/json/JSONObject;", "getRegisterData", "Lcom/contusfly/models/RegisterData;", "body", "registerAsync", "app_debug"})
public abstract interface UiApiCalls {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/api/v1/sandbox/register")
    public abstract java.lang.Object registerAsync(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.contusfly.models.RegisterData> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/api/v1/sandbox/register")
    public abstract retrofit2.Call<com.contusfly.models.RegisterData> getRegisterData(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> body);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/api/v1/contacts/sandbox/syncContacts")
    public abstract java.lang.Object contactSyncAsync(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.contusfly.models.ContactSyncData> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/api/v1/contacts/sandbox/syncContacts")
    public abstract retrofit2.Call<org.json.JSONObject> getContactSync(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> params);
}