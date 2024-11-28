package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ#\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/contusfly/utils/ContusContactUtils;", "", "()V", "clearAllData", "", "getAdminBlockedContusContacts", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "Lkotlin/collections/ArrayList;", "getBlockedContusContacts", "getBlockedMeContusContacts", "getContusContacts", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProfileDetails", "jid", "", "getUserProfile", "contact", "Lcom/contusfly/database/model/ContusContact;", "insertContusContact", "userProfileDetails", "isContusContact", "", "processContusContactResponse", "contusContactList", "Lcom/contusfly/models/ContusContactList;", "processContusContactCallback", "Lcom/contusfly/interfaces/ProcessContusContactCallback;", "(Lcom/contusfly/models/ContusContactList;Lcom/contusfly/interfaces/ProcessContusContactCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshContusContact", "resetBlockedContacts", "app_debug"})
public final class ContusContactUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.ContusContactUtils INSTANCE = null;
    
    private ContusContactUtils() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object processContusContactResponse(@org.jetbrains.annotations.Nullable
    com.contusfly.models.ContusContactList contusContactList, @org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.ProcessContusContactCallback processContusContactCallback, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getContusContacts(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getBlockedContusContacts() {
        return null;
    }
    
    private final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getBlockedMeContusContacts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getAdminBlockedContusContacts() {
        return null;
    }
    
    public final void resetBlockedContacts() {
    }
    
    public final void refreshContusContact(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    public final void insertContusContact(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails userProfileDetails) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.api.contacts.ProfileDetails getProfileDetails(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.api.contacts.ProfileDetails getUserProfile(@org.jetbrains.annotations.NotNull
    com.contusfly.database.model.ContusContact contact) {
        return null;
    }
    
    public final boolean isContusContact(@org.jetbrains.annotations.Nullable
    java.lang.String jid) {
        return false;
    }
    
    public final void clearAllData() {
    }
}