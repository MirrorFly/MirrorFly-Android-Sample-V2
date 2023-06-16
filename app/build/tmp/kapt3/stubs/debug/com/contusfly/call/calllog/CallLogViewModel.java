package com.contusfly.call.calllog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020\tJ\u000e\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020(J\u0006\u00104\u001a\u00020/J\u000e\u0010\u0011\u001a\u00020/2\u0006\u00105\u001a\u00020(J\u000e\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\tJ\u0006\u00108\u001a\u00020\tJ\u0006\u00109\u001a\u00020\tJ\u0006\u0010:\u001a\u00020\tJ\b\u0010%\u001a\u00020/H\u0002J\b\u0010;\u001a\u00020/H\u0002J\u0006\u0010<\u001a\u00020/J\u0010\u0010=\u001a\u00020/2\u0006\u0010$\u001a\u00020\tH\u0002J\u000e\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020-J\u0006\u0010@\u001a\u00020/R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR+\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0013j\b\u0012\u0004\u0012\u00020\u000e`\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u000e\u0010#\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020(0\u0013j\b\u0012\u0004\u0012\u00020(`\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b)\u0010\u0016R\u000e\u0010+\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000b\u00a8\u0006A"}, d2 = {"Lcom/contusfly/call/calllog/CallLogViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/contusfly/call/calllog/CallLogRepository;", "apiCalls", "Lcom/mirrorflysdk/flynetwork/ApiCalls;", "(Lcom/contusfly/call/calllog/CallLogRepository;Lcom/mirrorflysdk/flynetwork/ApiCalls;)V", "addLoader", "Landroidx/lifecycle/MutableLiveData;", "", "getAddLoader", "()Landroidx/lifecycle/MutableLiveData;", "callList", "", "Lcom/mirrorflysdk/flycall/call/database/model/CallLog;", "getCallList", "callLog", "getCallLog", "callLogAdapterList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallLogAdapterList", "()Ljava/util/ArrayList;", "callLogAdapterList$delegate", "Lkotlin/Lazy;", "clearAllCallLog", "getClearAllCallLog", "currentPage", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "fetchingError", "getFetchingError", "filteredCallLogsList", "getFilteredCallLogsList", "fromCallLogScreen", "isFetching", "removeLoader", "getRemoveLoader", "selectedCallLogs", "", "getSelectedCallLogs", "selectedCallLogs$delegate", "totalPages", "updatedFeaturesLiveData", "Lcom/mirrorflysdk/flycommons/Features;", "getUpdatedFeaturesLiveData", "", "addLoaderToTheList", "fromCallLog", "filterCallLogsList", "searchKey", "getAllCallLogs", "roomId", "getCallLogsList", "isLoadDataOnMainThread", "getUserListFetching", "isCallLogScreenInitiated", "lastPageFetched", "resetPagination", "setClearAllCallLog", "setUserListFetching", "updateFeatureActions", "updateFeatures", "uploadUnSyncedCallLogs", "app_debug"})
public final class CallLogViewModel extends androidx.lifecycle.ViewModel {
    private final com.contusfly.call.calllog.CallLogRepository repository = null;
    private final com.mirrorflysdk.flynetwork.ApiCalls apiCalls = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.flycommons.Features> updatedFeaturesLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog>> filteredCallLogsList = null;
    private boolean isFetching = false;
    private int currentPage = 0;
    private int totalPages = 1;
    private boolean fromCallLogScreen = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog>> callList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> fetchingError = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> clearAllCallLog = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy callLogAdapterList$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy selectedCallLogs$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.flycall.call.database.model.CallLog> callLog = null;
    
    @javax.inject.Inject()
    public CallLogViewModel(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.calllog.CallLogRepository repository, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flynetwork.ApiCalls apiCalls) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.flycommons.Features> getUpdatedFeaturesLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog>> getFilteredCallLogsList() {
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
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog>> getCallList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getFetchingError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getClearAllCallLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.mirrorflysdk.flycall.call.database.model.CallLog> getCallLogAdapterList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSelectedCallLogs() {
        return null;
    }
    
    public final void setClearAllCallLog() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.flycall.call.database.model.CallLog> getCallLog() {
        return null;
    }
    
    public final void getCallLog(@org.jetbrains.annotations.NotNull()
    java.lang.String roomId) {
    }
    
    private final void resetPagination() {
    }
    
    public final void getCallLogsList(boolean isLoadDataOnMainThread) {
    }
    
    public final void getAllCallLogs() {
    }
    
    private final void addLoader() {
    }
    
    private final void removeLoader() {
    }
    
    public final void addLoaderToTheList(boolean fromCallLog) {
    }
    
    public final boolean lastPageFetched() {
        return false;
    }
    
    public final boolean isCallLogScreenInitiated() {
        return false;
    }
    
    private final void setUserListFetching(boolean isFetching) {
    }
    
    public final boolean getUserListFetching() {
        return false;
    }
    
    public final void uploadUnSyncedCallLogs() {
    }
    
    public final void filterCallLogsList(@org.jetbrains.annotations.NotNull()
    java.lang.String searchKey) {
    }
    
    public final void updateFeatureActions(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.flycommons.Features updateFeatures) {
    }
}