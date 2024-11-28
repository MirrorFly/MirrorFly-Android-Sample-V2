package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010\'\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+J\u0006\u0010,\u001a\u00020#J\u0006\u0010-\u001a\u00020\u0005J \u0010\u001a\u001a\u00020#2\u0006\u0010.\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010/\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020#H\u0002J\b\u00102\u001a\u00020#H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007\u00a8\u00063"}, d2 = {"Lcom/contusfly/viewmodels/UserListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addLoader", "Landroidx/lifecycle/MutableLiveData;", "", "getAddLoader", "()Landroidx/lifecycle/MutableLiveData;", "addSearchLoader", "getAddSearchLoader", "currentPage", "", "currentSearchPage", "fetchingError", "getFetchingError", "isFetching", "isSearchFetching", "removeLoader", "getRemoveLoader", "removeSearchLoader", "getRemoveSearchLoader", "resetSearchResult", "getResetSearchResult", "setResetSearchResult", "(Landroidx/lifecycle/MutableLiveData;)V", "resultPerPage", "searchUserList", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getSearchUserList", "totalPage", "totalSearchPage", "userList", "getUserList", "addLoaderToTheList", "", "addSearchLoaderToTheList", "getSearchUserListFetching", "getUserListFetching", "lastPageFetched", "loadUserList", "fromGroupInfo", "groupId", "", "resetSearch", "searchLastPageFetched", "searchString", "setSearchUserListFetching", "setUserListFetching", "updateLoaderStatus", "updateSearchLoaderStatus", "app_debug"})
public final class UserListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> userList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeLoader = null;
    private boolean isFetching = false;
    private int currentPage = 0;
    private int resultPerPage = 20;
    private int totalPage = 1;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> searchUserList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addSearchLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeSearchLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> fetchingError = null;
    private boolean isSearchFetching = false;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> resetSearchResult;
    private int currentSearchPage = 0;
    private int totalSearchPage = 1;
    
    @javax.inject.Inject
    public UserListViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getUserList() {
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
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getSearchUserList() {
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
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getResetSearchResult() {
        return null;
    }
    
    public final void setResetSearchResult(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
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
    
    public final void loadUserList(boolean fromGroupInfo, @org.jetbrains.annotations.Nullable
    java.lang.String groupId) {
    }
    
    private final void updateLoaderStatus() {
    }
    
    public final void addLoaderToTheList() {
    }
    
    public final boolean lastPageFetched() {
        return false;
    }
    
    public final void searchUserList(@org.jetbrains.annotations.NotNull
    java.lang.String searchString, boolean fromGroupInfo, @org.jetbrains.annotations.Nullable
    java.lang.String groupId) {
    }
    
    private final void updateSearchLoaderStatus() {
    }
    
    public final void addSearchLoaderToTheList() {
    }
    
    public final boolean searchLastPageFetched() {
        return false;
    }
    
    public final void resetSearch() {
    }
}