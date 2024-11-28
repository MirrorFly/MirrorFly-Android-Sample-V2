package com.contusfly.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000f\u00a8\u0006$"}, d2 = {"Lcom/contusfly/models/RecentSearch;", "", "jid", "", "mid", "searchType", "chatType", "search", "", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/mirrorflysdk/api/contacts/ProfileDetails;)V", "getChatType", "()Ljava/lang/String;", "setChatType", "(Ljava/lang/String;)V", "getJid", "setJid", "getMid", "setMid", "getProfileDetails", "()Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "setProfileDetails", "(Lcom/mirrorflysdk/api/contacts/ProfileDetails;)V", "recentSearchList", "", "getRecentSearchList", "()Ljava/util/List;", "setRecentSearchList", "(Ljava/util/List;)V", "getSearch", "()Z", "setSearch", "(Z)V", "getSearchType", "setSearchType", "app_debug"})
public final class RecentSearch {
    @org.jetbrains.annotations.NotNull
    private java.lang.String jid;
    @org.jetbrains.annotations.NotNull
    private java.lang.String mid;
    @org.jetbrains.annotations.NotNull
    private java.lang.String searchType;
    @org.jetbrains.annotations.NotNull
    private java.lang.String chatType;
    private boolean search;
    @org.jetbrains.annotations.NotNull
    private com.mirrorflysdk.api.contacts.ProfileDetails profileDetails;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.contusfly.models.RecentSearch> recentSearchList;
    
    public RecentSearch(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String mid, @org.jetbrains.annotations.NotNull
    java.lang.String searchType, @org.jetbrains.annotations.NotNull
    java.lang.String chatType, boolean search, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getJid() {
        return null;
    }
    
    public final void setJid(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMid() {
        return null;
    }
    
    public final void setMid(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSearchType() {
        return null;
    }
    
    public final void setSearchType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChatType() {
        return null;
    }
    
    public final void setChatType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean getSearch() {
        return false;
    }
    
    public final void setSearch(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.api.contacts.ProfileDetails getProfileDetails() {
        return null;
    }
    
    public final void setProfileDetails(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.contusfly.models.RecentSearch> getRecentSearchList() {
        return null;
    }
    
    public final void setRecentSearchList(@org.jetbrains.annotations.Nullable
    java.util.List<com.contusfly.models.RecentSearch> p0) {
    }
}