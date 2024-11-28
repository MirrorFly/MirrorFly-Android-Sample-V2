package com.contusfly;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/ForceUpdateChecker;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "check", "", "displayAppUpdateDialog", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getAppVersion", "", "context", "Landroid/content/Context;", "Builder", "Companion", "app_debug"})
public final class ForceUpdateChecker {
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.ForceUpdateChecker.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ANDROID_FORCE_UPDATE_REQUIRED = "android_force_update_required";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ANDROID_FORCE_UPDATE_VERSION = "android_force_update_version";
    private static final java.lang.String ANDROID_FORCE_UPDATE_TITLE = "android_force_update_title";
    private static final java.lang.String ANDROID_FORCE_UPDATE_MESSAGE = "android_force_update_desc";
    private static final java.lang.String APP_PLAY_STORE_URL = "https://play.google.com/store/apps/details?id=com.mirrorfly.uikit";
    
    public ForceUpdateChecker(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
        super();
    }
    
    /**
     * This method currently launches the activity.
     */
    public final void check() {
    }
    
    /**
     * show force update dialog
     *
     * @param remoteConfig firebase remoteConfig object.
     */
    private final void displayAppUpdateDialog(com.google.firebase.remoteconfig.FirebaseRemoteConfig remoteConfig) {
    }
    
    /**
     * get current version of the app.
     *
     * @param context of the activity
     * @return app version in string type
     */
    private final java.lang.String getAppVersion(android.content.Context context) {
        return null;
    }
    
    /**
     * This method does some serious stuff
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/ForceUpdateChecker$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "build", "Lcom/contusfly/ForceUpdateChecker;", "app_debug"})
    public static final class Builder {
        private final android.app.Activity activity = null;
        
        public Builder(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
            super();
        }
        
        /**
         * Get ForceUpdateChecker
         *
         * @return The value of the activity property
         */
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.ForceUpdateChecker build() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/ForceUpdateChecker$Companion;", "", "()V", "ANDROID_FORCE_UPDATE_MESSAGE", "", "ANDROID_FORCE_UPDATE_REQUIRED", "ANDROID_FORCE_UPDATE_TITLE", "ANDROID_FORCE_UPDATE_VERSION", "APP_PLAY_STORE_URL", "compare", "", "version1", "version2", "with", "Lcom/contusfly/ForceUpdateChecker$Builder;", "activity", "Landroid/app/Activity;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * This method is to create builder instance
         *
         * @param activity context of the activity
         * @return builder instance
         */
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.ForceUpdateChecker.Builder with(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
            return null;
        }
        
        /**
         * @param version1 currentVersion of the app
         * @param version2 appVersion what user currently using.
         * @return 1, if current version is greater; -1 current version is lesser
         */
        private final int compare(java.lang.String version1, java.lang.String version2) {
            return 0;
        }
    }
}