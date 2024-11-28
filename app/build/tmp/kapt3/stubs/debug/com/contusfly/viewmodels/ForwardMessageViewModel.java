package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u000e\u00104\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/J\u0006\u00105\u001a\u00020\u0005J\u0006\u00106\u001a\u00020\u0005J\u0012\u00107\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0006\u00108\u001a\u00020\u0005J&\u00109\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/0(J0\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/0(H\u0002J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010=\u001a\u00020/H\u0002J\u0012\u0010>\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0006\u0010?\u001a\u00020-J0\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00102\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/0(H\u0002J \u0010C\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010H\u0002J\u000e\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020/J\u000e\u0010F\u001a\u00020-2\u0006\u0010E\u001a\u00020/J\b\u0010G\u001a\u00020-H\u0002J\u0006\u0010H\u001a\u00020\u0005J\u000e\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020/J\u000e\u0010 \u001a\u00020-2\u0006\u0010J\u001a\u00020/J\u0010\u0010K\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010L\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010M\u001a\u00020-H\u0002J\b\u0010N\u001a\u00020-H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0007R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001c0(0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006O"}, d2 = {"Lcom/contusfly/viewmodels/ForwardMessageViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addLoader", "Landroidx/lifecycle/MutableLiveData;", "", "getAddLoader", "()Landroidx/lifecycle/MutableLiveData;", "addSearchLoader", "getAddSearchLoader", "currentPage", "", "currentSearchPage", "fetchingError", "getFetchingError", "friendsList", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "groupList", "isFetching", "isSearchFetching", "recentList", "removeLoader", "getRemoveLoader", "removeSearchLoader", "getRemoveSearchLoader", "resultPerPage", "searchList", "Lcom/contusfly/models/ProfileDetailsShareModel;", "searchListLiveData", "", "getSearchListLiveData", "searchUserList", "getSearchUserList", "shareModelList", "shareModelListLiveData", "getShareModelListLiveData", "totalPage", "totalSearchPage", "updatedProfile", "Lkotlin/Pair;", "getUpdatedProfile", "userList", "getUserList", "checkAndLoadUserList", "", "jid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterSearchList", "userListResult", "filterUserList", "getPositionOfProfile", "getSearchUserListFetching", "getUserListFetching", "isForwardChatListLoaded", "lastPageFetched", "loadForwardChatList", "privateChatPair", "loadPrivateChatGroupList", "loadPrivateChatList", "senderJid", "loadProfileDetailsShareModel", "loadUserList", "loadrecentChatList", "recentChatList", "Lcom/mirrorflysdk/api/models/RecentChat;", "notifyResults", "removeProfileDetails", "userId", "removeSearchProfileDetails", "resetSearch", "searchLastPageFetched", "searchProfileList", "searchString", "setSearchUserListFetching", "setUserListFetching", "updateLoaderStatus", "updateSearchLoaderStatus", "app_debug"})
public final class ForwardMessageViewModel extends androidx.lifecycle.ViewModel {
    private java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> groupList;
    private java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> recentList;
    private java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> friendsList;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> shareModelListLiveData = null;
    private java.util.List<com.contusfly.models.ProfileDetailsShareModel> shareModelList;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, com.contusfly.models.ProfileDetailsShareModel>> updatedProfile = null;
    private boolean isFetching = false;
    private int currentPage = 0;
    private int resultPerPage = 20;
    private int totalPage = 1;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> userList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> searchListLiveData = null;
    private java.util.List<com.contusfly.models.ProfileDetailsShareModel> searchList;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addSearchLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeSearchLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> fetchingError = null;
    private boolean isSearchFetching = false;
    private int currentSearchPage = 0;
    private int totalSearchPage = 1;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> searchUserList = null;
    
    @javax.inject.Inject
    public ForwardMessageViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> getShareModelListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, com.contusfly.models.ProfileDetailsShareModel>> getUpdatedProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAddLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRemoveLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> getUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> getSearchListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAddSearchLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRemoveSearchLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getFetchingError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> getSearchUserList() {
        return null;
    }
    
    private final void setUserListFetching(boolean isFetching) {
    }
    
    public final boolean getUserListFetching() {
        return false;
    }
    
    private final void setSearchUserListFetching(boolean isSearchFetching) {
    }
    
    public final boolean getSearchUserListFetching() {
        return false;
    }
    
    public final void loadForwardChatList(@org.jetbrains.annotations.Nullable
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    kotlin.Pair<java.lang.Boolean, java.lang.String> privateChatPair) {
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> loadPrivateChatGroupList(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> groupList, kotlin.Pair<java.lang.Boolean, java.lang.String> privateChatPair) {
        return null;
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> loadPrivateChatList(java.lang.String senderJid) {
        return null;
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> loadrecentChatList(java.util.List<com.mirrorflysdk.api.models.RecentChat> recentChatList, kotlin.Pair<java.lang.Boolean, java.lang.String> privateChatPair) {
        return null;
    }
    
    private final java.lang.Object checkAndLoadUserList(java.lang.String jid, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void loadUserList() {
    }
    
    private final void updateLoaderStatus() {
    }
    
    public final boolean lastPageFetched() {
        return false;
    }
    
    private final void isForwardChatListLoaded(java.lang.String jid) {
    }
    
    private final void loadProfileDetailsShareModel(java.lang.String jid) {
    }
    
    private final void notifyResults(java.lang.String jid, java.util.List<com.contusfly.models.ProfileDetailsShareModel> shareModelList) {
    }
    
    private final java.util.List<com.contusfly.models.ProfileDetailsShareModel> filterUserList(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> userListResult) {
        return null;
    }
    
    private final java.util.List<com.contusfly.models.ProfileDetailsShareModel> filterSearchList(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> userListResult) {
        return null;
    }
    
    public final int getPositionOfProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
        return 0;
    }
    
    public final void removeProfileDetails(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
    }
    
    public final void removeSearchProfileDetails(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
    }
    
    public final void searchProfileList(@org.jetbrains.annotations.NotNull
    java.lang.String searchString) {
    }
    
    public final void searchUserList(@org.jetbrains.annotations.NotNull
    java.lang.String searchString) {
    }
    
    private final void updateSearchLoaderStatus() {
    }
    
    public final boolean searchLastPageFetched() {
        return false;
    }
    
    private final void resetSearch() {
    }
}