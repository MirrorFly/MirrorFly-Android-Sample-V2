package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/utils/FirebaseUtils;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "notificationData", "", "", "callImage", "", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "context", "Landroid/content/Context;", "handleReceivedMessage", "firebaseData", "onDestroy", "postRefreshedToken", "s", "Companion", "app_debug"})
public final class FirebaseUtils implements kotlinx.coroutines.CoroutineScope {
    
    /**
     * The notification data read from the Firebase.
     */
    private java.util.Map<java.lang.String, java.lang.String> notificationData;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.FirebaseUtils.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public FirebaseUtils() {
        super();
    }
    
    /**
     * Posts the refreshed token to the server to receive push notifications related to the
     * application package.
     */
    public final void postRefreshedToken(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
    }
    
    public final void callImage(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * Process the notification received via FCM.
     * @param context          Context of the service
     * @param firebaseData     The notification data read from the Firebase
     */
    public final void handleReceivedMessage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, java.lang.String> firebaseData) {
    }
    
    /**
     * Set the analytics with the Unique id which will be shown in the Firebase console. We can
     * handle the multiple actions and views from the firebase instance.
     *
     * @param id          Id of the event
     * @param name        Name which will display in the console
     * @param contentType Firebase Analytic Type
     */
    @kotlin.jvm.JvmStatic()
    public static final void setAnalytics(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String contentType) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    public final void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/utils/FirebaseUtils$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "setAnalytics", "", "id", "name", "contentType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Set the analytics with the Unique id which will be shown in the Firebase console. We can
         * handle the multiple actions and views from the firebase instance.
         *
         * @param id          Id of the event
         * @param name        Name which will display in the console
         * @param contentType Firebase Analytic Type
         */
        @kotlin.jvm.JvmStatic()
        public final void setAnalytics(@org.jetbrains.annotations.Nullable()
        java.lang.String id, @org.jetbrains.annotations.Nullable()
        java.lang.String name, @org.jetbrains.annotations.Nullable()
        java.lang.String contentType) {
        }
    }
}