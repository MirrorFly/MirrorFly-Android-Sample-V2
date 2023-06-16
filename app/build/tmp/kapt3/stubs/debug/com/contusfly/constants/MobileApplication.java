package com.contusfly.constants;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eJN\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u001dj\b\u0012\u0004\u0012\u00020\u0016`\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0016J\u0016\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160#H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u0012H\u0016J\b\u0010\'\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020\u0012H\u0002R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/contusfly/constants/MobileApplication;", "Landroid/app/Application;", "Ldagger/android/HasAndroidInjector;", "()V", "activityInjector", "Ldagger/android/DispatchingAndroidInjector;", "", "getActivityInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setActivityInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "defaultUncaughtHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "mediaCaptionMentionList", "Lcom/contusfly/utils/MediaCaptionMentionList;", "androidInjector", "Ldagger/android/AndroidInjector;", "clearMediaCaptionObject", "", "getMediaCaptionObject", "getMissedCallNotificationContent", "Lkotlin/Pair;", "", "isOneToOneCall", "", "userJid", "groupId", "callType", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNotificationMessage", "getPendingIntent", "Landroid/app/PendingIntent;", "toUsers", "", "initEmojiCompat", "initializeCallSdk", "onCreate", "setAdminBlockListener", "setupFirebaseRemoteConfig", "Companion", "app_debug"})
public final class MobileApplication extends android.app.Application implements dagger.android.HasAndroidInjector {
    @javax.inject.Inject()
    public dagger.android.DispatchingAndroidInjector<java.lang.Object> activityInjector;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.constants.MobileApplication.Companion Companion = null;
    private static com.contusfly.constants.MobileApplication instance;
    private java.lang.Thread.UncaughtExceptionHandler defaultUncaughtHandler;
    private com.contusfly.utils.MediaCaptionMentionList mediaCaptionMentionList;
    
    public MobileApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dagger.android.DispatchingAndroidInjector<java.lang.Object> getActivityInjector() {
        return null;
    }
    
    public final void setActivityInjector(@org.jetbrains.annotations.NotNull()
    dagger.android.DispatchingAndroidInjector<java.lang.Object> p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.contusfly.utils.MediaCaptionMentionList getMediaCaptionObject() {
        return null;
    }
    
    public final void clearMediaCaptionObject() {
    }
    
    private final void setAdminBlockListener() {
    }
    
    private final void setupFirebaseRemoteConfig() {
    }
    
    private final void initializeCallSdk() {
    }
    
    private final kotlin.Pair<java.lang.String, java.lang.String> getMissedCallNotificationContent(boolean isOneToOneCall, java.lang.String userJid, java.lang.String groupId, java.lang.String callType, java.util.ArrayList<java.lang.String> userList) {
        return null;
    }
    
    private final android.app.PendingIntent getPendingIntent(java.util.List<java.lang.String> toUsers) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNotificationMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public dagger.android.AndroidInjector<java.lang.Object> androidInjector() {
        return null;
    }
    
    private final void initEmojiCompat() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/constants/MobileApplication$Companion;", "", "()V", "instance", "Lcom/contusfly/constants/MobileApplication;", "getContext", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
    }
}