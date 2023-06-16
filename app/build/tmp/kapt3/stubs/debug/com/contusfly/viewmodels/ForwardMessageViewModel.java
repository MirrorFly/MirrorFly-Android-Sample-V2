package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u000e\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u0012\u00103\u001a\u0002042\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0006\u00105\u001a\u00020\u0005J\u0010\u00106\u001a\u0002042\b\u0010/\u001a\u0004\u0018\u000100J\u0012\u00107\u001a\u0002042\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0006\u00108\u001a\u000204J\u000e\u00109\u001a\u0002042\u0006\u0010:\u001a\u000200J\u000e\u0010;\u001a\u0002042\u0006\u0010:\u001a\u000200J\b\u0010<\u001a\u000204H\u0002J\u0006\u0010=\u001a\u00020\u0005J\u000e\u0010>\u001a\u0002042\u0006\u0010?\u001a\u000200J\u000e\u0010\u001f\u001a\u0002042\u0006\u0010?\u001a\u000200J\u0010\u0010@\u001a\u0002042\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010A\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u000204H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001d0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001d0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001d0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\'0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0007R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001d0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007\u00a8\u0006D"}, d2 = {"Lcom/contusfly/viewmodels/ForwardMessageViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addLoader", "Landroidx/lifecycle/MutableLiveData;", "", "getAddLoader", "()Landroidx/lifecycle/MutableLiveData;", "addSearchLoader", "getAddSearchLoader", "currentPage", "", "currentSearchPage", "fetchingError", "getFetchingError", "groupList", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "isFetching", "isSearchFetching", "recentList", "removeLoader", "getRemoveLoader", "removeSearchLoader", "getRemoveSearchLoader", "resultPerPage", "searchList", "Lcom/contusfly/models/ProfileDetailsShareModel;", "searchListLiveData", "", "getSearchListLiveData", "searchUserList", "getSearchUserList", "shareModelList", "shareModelListLiveData", "getShareModelListLiveData", "totalPage", "totalSearchPage", "updatedProfile", "Lkotlin/Pair;", "getUpdatedProfile", "userList", "getUserList", "filterSearchList", "userListResult", "filterUserList", "getPositionOfProfile", "jid", "", "getSearchUserListFetching", "getUserListFetching", "isForwardChatListLoaded", "", "lastPageFetched", "loadForwardChatList", "loadProfileDetailsShareModel", "loadUserList", "removeProfileDetails", "userId", "removeSearchProfileDetails", "resetSearch", "searchLastPageFetched", "searchProfileList", "searchString", "setSearchUserListFetching", "setUserListFetching", "updateLoaderStatus", "updateSearchLoaderStatus", "app_debug"})
public final class ForwardMessageViewModel extends androidx.lifecycle.ViewModel {
    private java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> groupList;
    private java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> recentList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> shareModelListLiveData = null;
    private java.util.List<com.contusfly.models.ProfileDetailsShareModel> shareModelList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, com.contusfly.models.ProfileDetailsShareModel>> updatedProfile = null;
    private boolean isFetching = false;
    private int currentPage = 0;
    private int resultPerPage = 20;
    private int totalPage = 1;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> userList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> searchListLiveData = null;
    private java.util.List<com.contusfly.models.ProfileDetailsShareModel> searchList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addSearchLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeSearchLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> fetchingError = null;
    private boolean isSearchFetching = false;
    private int currentSearchPage = 0;
    private int totalSearchPage = 1;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> searchUserList = null;
    
    @javax.inject.Inject()
    public ForwardMessageViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> getShareModelListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, com.contusfly.models.ProfileDetailsShareModel>> getUpdatedProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAddLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRemoveLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> getUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> getSearchListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAddSearchLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRemoveSearchLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getFetchingError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
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
    
    public final void loadForwardChatList(@org.jetbrains.annotations.Nullable()
    java.lang.String jid) {
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
    
    private final java.util.List<com.contusfly.models.ProfileDetailsShareModel> filterUserList(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> userListResult) {
        return null;
    }
    
    private final java.util.List<com.contusfly.models.ProfileDetailsShareModel> filterSearchList(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> userListResult) {
        return null;
    }
    
    public final int getPositionOfProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
        return 0;
    }
    
    public final void removeProfileDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    public final void removeSearchProfileDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    public final void searchProfileList(@org.jetbrains.annotations.NotNull()
    java.lang.String searchString) {
    }
    
    public final void searchUserList(@org.jetbrains.annotations.NotNull()
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