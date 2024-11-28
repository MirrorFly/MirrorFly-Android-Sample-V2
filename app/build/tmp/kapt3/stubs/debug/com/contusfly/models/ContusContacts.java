package com.contusfly.models;

import java.lang.System;

/**
 * Retriving the contus contact
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR \u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR \u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b\u00a8\u0006#"}, d2 = {"Lcom/contusfly/models/ContusContacts;", "", "()V", "activeType", "", "getActiveType", "()Ljava/lang/String;", "setActiveType", "(Ljava/lang/String;)V", "colourCode", "", "getColourCode", "()I", "setColourCode", "(I)V", "email", "getEmail", "setEmail", "image", "getImage", "setImage", "isChatUser", "setChatUser", "mobileNumber", "getMobileNumber", "setMobileNumber", "name", "getName", "setName", "statusMsg", "getStatusMsg", "setStatusMsg", "username", "getUsername", "setUsername", "app_debug"})
public final class ContusContacts {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "mobileNumber")
    private java.lang.String mobileNumber;
    @com.google.gson.annotations.SerializedName(value = "isChatUser")
    private int isChatUser = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "image")
    private java.lang.String image;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "emailId")
    private java.lang.String email;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "username")
    private java.lang.String username;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "statusMsg")
    private java.lang.String statusMsg;
    @org.jetbrains.annotations.Nullable
    private java.lang.String activeType;
    private int colourCode = 0;
    
    public ContusContacts() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMobileNumber() {
        return null;
    }
    
    public final void setMobileNumber(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final int isChatUser() {
        return 0;
    }
    
    public final void setChatUser(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUsername() {
        return null;
    }
    
    public final void setUsername(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStatusMsg() {
        return null;
    }
    
    public final void setStatusMsg(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getActiveType() {
        return null;
    }
    
    public final void setActiveType(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final int getColourCode() {
        return 0;
    }
    
    public final void setColourCode(int p0) {
    }
}