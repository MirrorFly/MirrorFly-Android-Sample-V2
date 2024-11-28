package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JW\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020 2\u0006\u0010\'\u001a\u00020 2\u0006\u0010(\u001a\u00020 H\u0002\u00a2\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u000eJ.\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0-2\u0006\u00100\u001a\u00020\n2\b\b\u0002\u00101\u001a\u00020\nH\u0002J\u000e\u00102\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00105\u001a\u00020/H\u0002J\u000e\u00106\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u000eJ\"\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001f082\u0006\u00109\u001a\u00020\u000eH\u0002J\u0018\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020/2\u0006\u00100\u001a\u00020\nH\u0002J\u0016\u0010<\u001a\u00020+2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050-H\u0002J\u0016\u0010>\u001a\u00020+2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050-H\u0002J\u0016\u0010@\u001a\u00020+2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050-H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\f\u00a8\u0006B"}, d2 = {"Lcom/contusfly/viewmodels/ViewAllMediaViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "docsListData", "", "Lcom/contusfly/models/GroupedMedia;", "getDocsListData", "()Ljava/util/List;", "docsListLoaded", "Landroidx/lifecycle/MutableLiveData;", "", "getDocsListLoaded", "()Landroidx/lifecycle/MutableLiveData;", "jid", "", "getJid", "()Ljava/lang/String;", "setJid", "(Ljava/lang/String;)V", "linkListData", "getLinkListData", "linkListLoaded", "getLinkListLoaded", "mediaListData", "getMediaListData", "mediaListLoaded", "getMediaListLoaded", "profileDetail", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getProfileDetail", "getCategoryName", "Lkotlin/Pair;", "", "dateSymbols", "", "currentDay", "currentMonth", "currentYear", "day", "month", "year", "([Ljava/lang/String;IIIIII)Lkotlin/Pair;", "getDocsList", "", "getGroupedMediaList", "", "mediaMessages", "Lcom/mirrorflysdk/api/models/ChatMessage;", "isMedia", "isLinkMedia", "getLinksList", "getMediaList", "getMessageWithURLList", "message", "getProfileDetails", "getUrlAndHostList", "Ljava/util/ArrayList;", "text", "isMediaAvailable", "chatMessage", "notifyViewAllDocsFragment", "groupedDocsList", "notifyViewAllLinksFragment", "groupedLinkList", "notifyViewAllMediaFragment", "groupedMediaList", "app_debug"})
public final class ViewAllMediaViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.contusfly.models.GroupedMedia> mediaListData = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.contusfly.models.GroupedMedia> docsListData = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.contusfly.models.GroupedMedia> linkListData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> mediaListLoaded = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> docsListLoaded = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> linkListLoaded = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String jid = "";
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.api.contacts.ProfileDetails> profileDetail = null;
    
    public ViewAllMediaViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.contusfly.models.GroupedMedia> getMediaListData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.contusfly.models.GroupedMedia> getDocsListData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.contusfly.models.GroupedMedia> getLinkListData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getMediaListLoaded() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getDocsListLoaded() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLinkListLoaded() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getJid() {
        return null;
    }
    
    public final void setJid(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.api.contacts.ProfileDetails> getProfileDetail() {
        return null;
    }
    
    public final void getMediaList(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void notifyViewAllMediaFragment(java.util.List<? extends com.contusfly.models.GroupedMedia> groupedMediaList) {
    }
    
    public final void getDocsList(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void notifyViewAllDocsFragment(java.util.List<? extends com.contusfly.models.GroupedMedia> groupedDocsList) {
    }
    
    public final void getLinksList(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void notifyViewAllLinksFragment(java.util.List<? extends com.contusfly.models.GroupedMedia> groupedLinkList) {
    }
    
    private final java.util.List<com.contusfly.models.GroupedMedia> getGroupedMediaList(java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> mediaMessages, boolean isMedia, boolean isLinkMedia) {
        return null;
    }
    
    private final boolean isMediaAvailable(com.mirrorflysdk.api.models.ChatMessage chatMessage, boolean isMedia) {
        return false;
    }
    
    private final kotlin.Pair<java.lang.Integer, java.lang.String> getCategoryName(java.lang.String[] dateSymbols, int currentDay, int currentMonth, int currentYear, int day, int month, int year) {
        return null;
    }
    
    private final java.util.List<com.contusfly.models.GroupedMedia> getMessageWithURLList(com.mirrorflysdk.api.models.ChatMessage message) {
        return null;
    }
    
    private final java.util.ArrayList<kotlin.Pair<java.lang.String, java.lang.String>> getUrlAndHostList(java.lang.String text) {
        return null;
    }
    
    public final void getProfileDetails(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
}