package com.contusfly.views;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/views/PermissionAlertDialog;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "adjustAlertDialogWidth", "", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "getDialogDescription", "", "permissionType", "", "getDialogIcon", "", "showPermissionInstructionDialog", "permissionDialogListener", "Lcom/contusfly/interfaces/PermissionDialogListener;", "isFromAudio", "", "Companion", "app_debug"})
public final class PermissionAlertDialog {
    private android.app.Activity activity;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.views.PermissionAlertDialog.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CONTACT_AND_MEDIA_PERMISSION = "contact_and_media_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CONTACT_PERMISSION = "contact_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CONTACT_PERMISSION_DENIED = "contact_permission_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LOCATION_PERMISSION = "location_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LOCATION_PERMISSION_DENIED = "location_permission_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CAMERA_PERMISSION = "camera_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CAMERA_PERMISSION_DENIED = "camera_permission_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MEDIA_PERMISSION = "media_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MEDIA_PERMISSION_DENIED = "media_permission_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MIC_PERMISSION = "mic_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MIC_PERMISSION_DENIED = "mic_permission_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AUDIO_CALL_PERMISSION = "audio_call_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AUDIO_CALL_PERMISSION_DENIED = "audio_call_permission_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String VIDEO_CALL_PERMISSION = "video_call_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AUDIO_MUSIC_PERMISSION = "audio_music_permission";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String VIDEO_CALL_PERMISSION_DENIED = "video_call_permission_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOTIFCATION_PERMISSION_DENIED = "notification_permission_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOTIFICATION_LOCKED_STATE_PERMISSION_DENIED = "notification_permission_locked_state_denied";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FULLSCREEN_NOTIFICATION_PERMISSION_DENIED = "fullscreen_notification_permission_denied";
    
    public PermissionAlertDialog(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
        super();
    }
    
    public final void showPermissionInstructionDialog(@org.jetbrains.annotations.NotNull
    java.lang.String permissionType, @org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.PermissionDialogListener permissionDialogListener, boolean isFromAudio) {
    }
    
    private final java.lang.CharSequence getDialogDescription(java.lang.String permissionType) {
        return null;
    }
    
    private final int getDialogIcon(java.lang.String permissionType) {
        return 0;
    }
    
    private final void adjustAlertDialogWidth(android.app.Activity activity, androidx.appcompat.app.AlertDialog alertDialog) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/views/PermissionAlertDialog$Companion;", "", "()V", "AUDIO_CALL_PERMISSION", "", "AUDIO_CALL_PERMISSION_DENIED", "AUDIO_MUSIC_PERMISSION", "CAMERA_PERMISSION", "CAMERA_PERMISSION_DENIED", "CONTACT_AND_MEDIA_PERMISSION", "CONTACT_PERMISSION", "CONTACT_PERMISSION_DENIED", "FULLSCREEN_NOTIFICATION_PERMISSION_DENIED", "LOCATION_PERMISSION", "LOCATION_PERMISSION_DENIED", "MEDIA_PERMISSION", "MEDIA_PERMISSION_DENIED", "MIC_PERMISSION", "MIC_PERMISSION_DENIED", "NOTIFCATION_PERMISSION_DENIED", "NOTIFICATION_LOCKED_STATE_PERMISSION_DENIED", "VIDEO_CALL_PERMISSION", "VIDEO_CALL_PERMISSION_DENIED", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}