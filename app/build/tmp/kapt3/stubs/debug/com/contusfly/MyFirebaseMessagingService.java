package com.contusfly;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/MyFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "firebaseUtils", "Lcom/contusfly/utils/FirebaseUtils;", "getFirebaseUtils", "()Lcom/contusfly/utils/FirebaseUtils;", "setFirebaseUtils", "(Lcom/contusfly/utils/FirebaseUtils;)V", "onCreate", "", "onDeletedMessages", "onDestroy", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "s", "", "Companion", "app_debug"})
public final class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    
    /**
     * Instance of the chat utils class that contains the common firebase methods
     */
    @javax.inject.Inject
    public com.contusfly.utils.FirebaseUtils firebaseUtils;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.MyFirebaseMessagingService.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public MyFirebaseMessagingService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.utils.FirebaseUtils getFirebaseUtils() {
        return null;
    }
    
    public final void setFirebaseUtils(@org.jetbrains.annotations.NotNull
    com.contusfly.utils.FirebaseUtils p0) {
    }
    
    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    @java.lang.Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull
    com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    @java.lang.Override
    public void onDeletedMessages() {
    }
    
    @java.lang.Override
    public void onNewToken(@org.jetbrains.annotations.NotNull
    java.lang.String s) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/MyFirebaseMessagingService$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}