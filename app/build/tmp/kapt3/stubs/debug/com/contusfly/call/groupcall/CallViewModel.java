package com.contusfly.call.groupcall;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J8\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010.j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e01H\u0002J\"\u0010\u0016\u001a\u00020*2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010.j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`/J*\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u001a2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010.j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`/J(\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010.j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`/J\u0006\u00105\u001a\u00020\u0007J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e01H\u0002J\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020\u0007J\"\u0010<\u001a\u00020*2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010.j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`/J\u0006\u0010=\u001a\u00020*J\u0006\u0010>\u001a\u00020\u0007J*\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020\u001a2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010.j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`/J\u0010\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u00020*H\u0002J\b\u0010F\u001a\u00020*H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\tR\u000e\u0010\'\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/contusfly/call/groupcall/CallViewModel;", "Landroidx/lifecycle/ViewModel;", "callLogRepository", "Lcom/contusfly/call/calllog/CallLogRepository;", "(Lcom/contusfly/call/calllog/CallLogRepository;)V", "addLoadUserLoader", "Landroidx/lifecycle/MutableLiveData;", "", "getAddLoadUserLoader", "()Landroidx/lifecycle/MutableLiveData;", "addUserSearchLoader", "getAddUserSearchLoader", "callUserList", "", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getCallUserList", "currentPage", "", "currentSearchPage", "fetchingError", "getFetchingError", "inviteUserList", "getInviteUserList", "isSearchUserFetching", "isUserFetching", "profileUpdatedLiveData", "", "getProfileUpdatedLiveData", "removeLoadUserLoader", "getRemoveLoadUserLoader", "removeUserSearchLoader", "getRemoveUserSearchLoader", "resetSearchResult", "getResetSearchResult", "setResetSearchResult", "(Landroidx/lifecycle/MutableLiveData;)V", "resultPerPage", "searchCallUserList", "getSearchCallUserList", "totalUserPage", "totalUserSearchPage", "addLoaderToTheList", "", "addSearchLoaderToTheList", "getFilteredList", "callConnectedUserList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "profileDetails", "", "getInviteUserListForGroup", "groupId", "getProfileDetailsWithoutCallMembers", "getSearchUserListFetching", "getSingleProfiles", "profiles", "getUpdatedProfiles", "userProfilesList", "getUserListFetching", "lastPageFetched", "loadUserList", "resetSearch", "searchLastPageFetched", "searchUserList", "searchString", "setSearchUserListFetching", "isSearchFetching", "setUserListFetching", "isFetching", "updateLoaderStatus", "updateSearchLoaderStatus", "app_debug"})
public final class CallViewModel extends androidx.lifecycle.ViewModel {
    private final com.contusfly.call.calllog.CallLogRepository callLogRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> profileUpdatedLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> inviteUserList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> callUserList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addLoadUserLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeLoadUserLoader = null;
    private boolean isUserFetching = false;
    private int currentPage = 0;
    private int resultPerPage = 20;
    private int totalUserPage = 1;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> searchCallUserList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addUserSearchLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeUserSearchLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> fetchingError = null;
    private boolean isSearchUserFetching = false;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> resetSearchResult;
    private int currentSearchPage = 0;
    private int totalUserSearchPage = 1;
    
    @javax.inject.Inject()
    public CallViewModel(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.calllog.CallLogRepository callLogRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getProfileUpdatedLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getInviteUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getCallUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAddLoadUserLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRemoveLoadUserLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getSearchCallUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAddUserSearchLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRemoveUserSearchLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getFetchingError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getResetSearchResult() {
        return null;
    }
    
    public final void setResetSearchResult(@org.jetbrains.annotations.NotNull()
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
    
    public final void addLoaderToTheList() {
    }
    
    public final void loadUserList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<java.lang.String> callConnectedUserList) {
    }
    
    private final void updateLoaderStatus() {
    }
    
    public final boolean lastPageFetched() {
        return false;
    }
    
    public final void searchUserList(@org.jetbrains.annotations.NotNull()
    java.lang.String searchString, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<java.lang.String> callConnectedUserList) {
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
    
    public final void getInviteUserList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<java.lang.String> callConnectedUserList) {
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> getUpdatedProfiles(java.util.List<? extends com.mirrorflysdk.api.contacts.ProfileDetails> userProfilesList) {
        return null;
    }
    
    public final void getInviteUserListForGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<java.lang.String> callConnectedUserList) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> getProfileDetailsWithoutCallMembers(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<java.lang.String> callConnectedUserList) {
        return null;
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> getFilteredList(java.util.ArrayList<java.lang.String> callConnectedUserList, java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> profileDetails) {
        return null;
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> getSingleProfiles(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> profiles) {
        return null;
    }
}