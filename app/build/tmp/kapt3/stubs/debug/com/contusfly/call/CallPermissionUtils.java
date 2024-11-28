package com.contusfly.call;

import java.lang.System;

/**
 * This class is used to start the video call audio call activity. Here checking the audio and video
 * permissions are checked before make a call.And also check whether the user is blocked or not.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0003J\b\u0010\u0017\u001a\u00020\u0015H\u0003J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u00020\u0015H\u0003J\b\u0010#\u001a\u00020\u0015H\u0003J\u001a\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\u0006\u0010-\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/contusfly/call/CallPermissionUtils;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "activity", "Landroid/app/Activity;", "isBlocked", "", "isAdminBlocked", "jidList", "Ljava/util/ArrayList;", "", "groupId", "isCloseScreen", "callMetaDataArray", "", "Lcom/mirrorflysdk/flycommons/models/CallMetaData;", "(Landroid/app/Activity;ZZLjava/util/ArrayList;Ljava/lang/String;Z[Lcom/mirrorflysdk/flycommons/models/CallMetaData;)V", "Landroid/content/Context;", "[Lcom/mirrorflysdk/flycommons/models/CallMetaData;", "doProgressDialog", "Lcom/contusfly/views/DoProgressDialog;", "audioCall", "", "checkAndMakeVideoCall", "checkAndMakeVoiceCall", "closeScreen", "getJidList", "isPermissionAllowed", "context", "permission", "listOptionSelected", "position", "", "makeGroupVideoCall", "makeGroupVoiceCall", "makeVideoCall", "makeVoiceCall", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "showBlockedAlertAudioCall", "showBlockedAlertVideoCall", "showErrorToast", "errorMessage", "unBlock", "videoCall", "Companion", "app_debug"})
public final class CallPermissionUtils implements com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    
    /**
     * Instance for the activity
     */
    private final android.content.Context activity = null;
    
    /**
     * Instance of isBlocked
     */
    private boolean isBlocked;
    
    /**
     * Instance of isAdminBlocked
     */
    private boolean isAdminBlocked;
    
    /**
     * JID
     */
    private final java.util.ArrayList<java.lang.String> jidList = null;
    
    /**
     * Group ID
     */
    private final java.lang.String groupId = null;
    
    /**
     * Call making screen has to be closed or not
     */
    private final boolean isCloseScreen = false;
    
    /**
     * The progress dialog to display the progress bar When the background operations has been doing
     */
    private com.contusfly.views.DoProgressDialog doProgressDialog;
    
    /**
     * list of call meta data value being passed.
     */
    private com.mirrorflysdk.flycommons.models.CallMetaData[] callMetaDataArray;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.call.CallPermissionUtils.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public CallPermissionUtils(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, boolean isBlocked, boolean isAdminBlocked, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> jidList, @org.jetbrains.annotations.Nullable
    java.lang.String groupId, boolean isCloseScreen, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.flycommons.models.CallMetaData[] callMetaDataArray) {
        super();
    }
    
    /**
     * Check the jid has blocked or not. If JID has blocked then show the alert and call after unblock
     * the jid
     */
    public final void audioCall() {
    }
    
    /**
     * Alert dialog whether to unblock or cancel to continue sending messages...
     */
    private final void showBlockedAlertAudioCall() {
    }
    
    /**
     * Check the jid has blocked or not. If JID has blocked then show the alert and call after unblock
     * the jid
     */
    public final void videoCall() {
    }
    
    /**
     * Alert dialog whether to unblock or cancel to continue sending messages...
     */
    private final void showBlockedAlertVideoCall() {
    }
    
    /**
     * This unblock method is start the chat service with the action of unblock
     */
    private final void unBlock() {
    }
    
    /**
     * This method is start the audio call activity
     */
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void makeVoiceCall() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void checkAndMakeVoiceCall() {
    }
    
    private final void makeGroupVoiceCall(java.lang.String groupId) {
    }
    
    private final void showErrorToast(java.lang.String errorMessage) {
    }
    
    /**
     * This method is start the video call activity
     */
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void makeVideoCall() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void checkAndMakeVideoCall() {
    }
    
    private final void makeGroupVideoCall(java.lang.String groupId) {
    }
    
    private final void closeScreen() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getJidList() {
        return null;
    }
    
    /**
     * Calling this method to check the permission status
     *
     * @param context    Context of the activity
     * @param permission Permission to ask
     * @return boolean True if grand the permission
     */
    public final boolean isPermissionAllowed(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String permission) {
        return false;
    }
    
    /**
     * OnD Dialog closed
     *
     * @param dialogType the dialog type
     * @param isSuccess  the is success
     */
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    /**
     * Push all the Custom HyperLog values to server
     *
     * @param position the position
     */
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/call/CallPermissionUtils$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "showOngoingCallAlert", "", "activity", "Landroid/content/Context;", "showTelephonyCallAlert", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Alert dialog for user when he tries to make a call, while on another telephony call.
         */
        public final void showTelephonyCallAlert(@org.jetbrains.annotations.NotNull
        android.content.Context activity) {
        }
        
        /**
         * Alert dialog for user when he tries to make a call, while on another call.
         */
        public final void showOngoingCallAlert(@org.jetbrains.annotations.NotNull
        android.content.Context activity) {
        }
    }
}