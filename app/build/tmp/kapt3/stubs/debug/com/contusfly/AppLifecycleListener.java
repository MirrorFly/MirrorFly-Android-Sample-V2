package com.contusfly;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/AppLifecycleListener;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "appLifeCycleOnCreate", "", "onAppDestroyed", "onMoveToBackground", "onMoveToForeground", "onResumeCallback", "registerBroadcastReceiver", "Companion", "app_debug"})
public final class AppLifecycleListener implements androidx.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.AppLifecycleListener.Companion Companion = null;
    private static final java.lang.String TAG = null;
    private static final long SESSION_TIME = 32000L;
    private static boolean isOnCall = false;
    @kotlin.jvm.JvmField()
    public static boolean isForeground = false;
    @kotlin.jvm.JvmField()
    public static boolean fromOnCreate = false;
    private static boolean deviceLock = false;
    @kotlin.jvm.JvmField()
    public static boolean pinActivityShowing = false;
    @kotlin.jvm.JvmField()
    public static boolean pinScreenShowing = true;
    @kotlin.jvm.JvmField()
    public static int deviceContactCount = 0;
    @kotlin.jvm.JvmField()
    public static boolean isFromQuickShareForBioMetric = false;
    @kotlin.jvm.JvmField()
    public static boolean isFromQuickShareForPin = false;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.lifecycle.MutableLiveData<kotlin.Triple<java.lang.String, java.lang.String, java.lang.Boolean>> _adminBlockedOtherUser = null;
    
    public AppLifecycleListener() {
        super();
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public final void onMoveToBackground() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_CREATE)
    public final void appLifeCycleOnCreate() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_START)
    public final void onMoveToForeground() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_RESUME)
    public final void onResumeCallback() {
    }
    
    private final void registerBroadcastReceiver() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void onAppDestroyed() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0006J\u0006\u0010+\u001a\u00020\u000bJ\u0010\u0010,\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR)\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u0014\u0010\"\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0014R\u0012\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\'\u00a8\u0006-"}, d2 = {"Lcom/contusfly/AppLifecycleListener$Companion;", "", "()V", "SESSION_TIME", "", "TAG", "", "kotlin.jvm.PlatformType", "_adminBlockedOtherUser", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Triple;", "", "get_adminBlockedOtherUser", "()Landroidx/lifecycle/MutableLiveData;", "adminBlockedOtherUser", "Landroidx/lifecycle/LiveData;", "getAdminBlockedOtherUser", "()Landroidx/lifecycle/LiveData;", "backPressedSP", "getBackPressedSP", "()Z", "deviceContactCount", "", "deviceLock", "getDeviceLock", "setDeviceLock", "(Z)V", "fromOnCreate", "isForeground", "isFromQuickShareForBioMetric", "isFromQuickShareForPin", "isOnCall", "setOnCall", "isPinEnabled", "isQuickShare", "pinActivityShowing", "pinScreenShowing", "sessionTimeDifference", "getSessionTimeDifference", "()J", "presentPinActivity", "", "from", "shouldShowPinActivity", "showPinActivity", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isOnCall() {
            return false;
        }
        
        public final void setOnCall(boolean p0) {
        }
        
        public final boolean getDeviceLock() {
            return false;
        }
        
        public final void setDeviceLock(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.MutableLiveData<kotlin.Triple<java.lang.String, java.lang.String, java.lang.Boolean>> get_adminBlockedOtherUser() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.LiveData<kotlin.Triple<java.lang.String, java.lang.String, java.lang.Boolean>> getAdminBlockedOtherUser() {
            return null;
        }
        
        public final boolean getBackPressedSP() {
            return false;
        }
        
        public final void showPinActivity(@org.jetbrains.annotations.Nullable()
        java.lang.String from) {
        }
        
        public final boolean shouldShowPinActivity() {
            return false;
        }
        
        private final long getSessionTimeDifference() {
            return 0L;
        }
        
        public final boolean isPinEnabled() {
            return false;
        }
        
        private final boolean isQuickShare() {
            return false;
        }
        
        public final void presentPinActivity(@org.jetbrains.annotations.Nullable()
        java.lang.String from) {
        }
    }
}