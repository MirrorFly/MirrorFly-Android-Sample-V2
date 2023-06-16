package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0002J<\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u0017\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001b\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\"\u0010$\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J6\u0010$\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ*\u0010%\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J*\u0010&\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J*\u0010\'\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J*\u0010(\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J*\u0010)\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J*\u0010*\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J4\u0010+\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ*\u0010,\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J*\u0010-\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J@\u0010.\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0002\u0010/\u001a\u00020\u00132\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ*\u00100\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0016\u00101\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\"\u00102\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J6\u00102\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u00103\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ2\u00104\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J2\u00105\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J<\u00106\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J2\u00107\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J2\u00108\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J2\u00109\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002JD\u0010:\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J2\u0010;\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a8\u0006<"}, d2 = {"Lcom/contusfly/utils/MediaPermissions;", "", "()V", "askAudioCallPermissions", "", "permissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "permissionsToRequest", "", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "permissionDialogListener", "Lcom/contusfly/interfaces/PermissionDialogListener;", "askVideoCallPermissions", "activityResultCaller", "doRequestAudioCallPermissions", "isLocationPermissionAllowed", "", "context", "Landroid/content/Context;", "isNotificationPermissionAllowed", "isPermissionAllowed", "permission", "isReadFilePermissionAllowed", "isWriteContactPermissionAllowed", "isWriteFilePermissionAllowed", "openSettingsForPermission", "activity", "Landroid/app/Activity;", "message", "openSettingsForPermissionWithoutSmackBar", "requestAccountPermissions", "permissionCode", "", "requestAudioCallPermissions", "requestAudioMediaFiles", "requestAudioStoragePermissions", "requestCameraPermission", "requestCameraStoragePermissions", "requestContactStorageAccess", "requestContactsReadAndWritePermission", "requestContactsReadPermission", "requestLocationPermission", "requestMediaFiles", "requestNotificationPermission", "isCall", "requestStorageAccess", "requestTelephoneCallPermissions", "requestVideoCallPermissions", "runtimeNotificationPermissionEnabledStatus", "showPermissionPopUpForAudioRecord", "showPermissionPopUpForCamera", "showPermissionPopUpForContact", "showPermissionPopUpForContactMedia", "showPermissionPopUpForContactWrite", "showPermissionPopUpForLocation", "showPermissionPopUpForNotification", "showPermissionPopUpForStorage", "app_debug"})
public final class MediaPermissions {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.MediaPermissions INSTANCE = null;
    
    private MediaPermissions() {
        super();
    }
    
    /**
     * Request the storage permission for accessing Gallery
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    public final void requestStorageAccess(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    public final void requestMediaFiles(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    public final void requestAudioMediaFiles(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    public final boolean runtimeNotificationPermissionEnabledStatus(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return false;
    }
    
    public final void requestNotificationPermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, boolean isCall, @org.jetbrains.annotations.Nullable()
    com.contusfly.interfaces.PermissionDialogListener permissionDialogListener) {
    }
    
    /**
     * Request the storage permission for accessing Gallery
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    public final void requestContactStorageAccess(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    private final void showPermissionPopUpForNotification(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog, boolean isCall, com.contusfly.interfaces.PermissionDialogListener permissionDialogListener) {
    }
    
    private final void showPermissionPopUpForStorage(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog) {
    }
    
    private final void showPermissionPopUpForContactMedia(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog) {
    }
    
    /**
     * Request the camera and audio permissions for making audio/video calls
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param activityResultCaller activityResultCaller
     */
    public final void requestVideoCallPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> activityResultCaller, @org.jetbrains.annotations.Nullable()
    com.contusfly.interfaces.PermissionDialogListener permissionDialogListener) {
    }
    
    private final void askVideoCallPermissions(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog, com.contusfly.interfaces.PermissionDialogListener permissionDialogListener) {
    }
    
    /**
     * Request the camera and audio permissions for making audio/video calls
     *
     * @param activity       Activity of the View
     * @param activityResultCaller activityResultCaller
     */
    public final void requestVideoCallPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> activityResultCaller) {
    }
    
    private final void askVideoCallPermissions(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> activityResultCaller) {
    }
    
    /**
     * Request the camera and audio permissions for making audio/video calls
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param activityResultCaller Permission result launcher
     */
    public final void requestAudioCallPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> activityResultCaller, @org.jetbrains.annotations.Nullable()
    com.contusfly.interfaces.PermissionDialogListener permissionDialogListener) {
    }
    
    /**
     * Perform the request permissions
     *
     * @param permissionsLauncher Permission result launcher
     * @param permissionsToRequest List of permissions
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     */
    private final void askAudioCallPermissions(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog, com.contusfly.interfaces.PermissionDialogListener permissionDialogListener) {
    }
    
    /**
     * Request the camera and audio permissions for making audio/video calls
     *
     * @param activity       Activity of the View
     * @param activityResultCaller activityResultCaller
     */
    public final void requestAudioCallPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> activityResultCaller) {
    }
    
    /**
     * Perform the request permissions via activityResultCaller
     *
     * @param activityResultCaller  activityResultCaller
     */
    private final void doRequestAudioCallPermissions(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> activityResultCaller) {
    }
    
    /**
     * Calling this method to check the permission status
     *
     * @param context    Context of the activity
     * @param permission Permission to ask
     * @return boolean True if grand the permission
     */
    public final boolean isPermissionAllowed(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String permission) {
        return false;
    }
    
    public final boolean isNotificationPermissionAllowed(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return false;
    }
    
    public final boolean isReadFilePermissionAllowed(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return false;
    }
    
    public final boolean isWriteFilePermissionAllowed(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return false;
    }
    
    public final boolean isWriteContactPermissionAllowed(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Request the camera permission from the camera chosen for take photo
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    public final void requestCameraStoragePermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    private final void showPermissionPopUpForCamera(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog) {
    }
    
    /**
     * Request the camera permission from the camera chosen for take photo
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    public final void requestAudioStoragePermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    private final void showPermissionPopUpForAudioRecord(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog) {
    }
    
    /**
     * Request the read contacts permission
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    public final void requestContactsReadPermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, @org.jetbrains.annotations.Nullable()
    com.contusfly.interfaces.PermissionDialogListener permissionDialogListener) {
    }
    
    /**
     * Request the read contacts permission
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    public final void requestContactsReadAndWritePermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    private final void showPermissionPopUpForContactWrite(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog) {
    }
    
    private final void showPermissionPopUpForContact(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog, com.contusfly.interfaces.PermissionDialogListener permissionDialogListener) {
    }
    
    private final void openSettingsForPermission(android.app.Activity activity, java.lang.String message) {
    }
    
    private final void openSettingsForPermissionWithoutSmackBar(android.app.Activity activity) {
    }
    
    /**
     * Calling this method to check the permission status of the location
     *
     * @param context Context of the activity
     * @return boolean True if grand the permission
     */
    public final boolean isLocationPermissionAllowed(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Requesting permission for the specific permission from the user
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    public final void requestLocationPermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    private final void showPermissionPopUpForLocation(androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher, java.util.List<java.lang.String> permissionsToRequest, com.contusfly.views.PermissionAlertDialog permissionAlertDialog) {
    }
    
    /**
     * Request the telephony call permissions
     *
     * @param activity       Activity of the View
     * @param permissionCode Code for start activity
     */
    public final void requestTelephoneCallPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int permissionCode) {
    }
    
    /**
     * Request the read contacts permission
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher Permission result launcher
     */
    public final void requestCameraPermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.contusfly.views.PermissionAlertDialog permissionAlertDialog, @org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionsLauncher) {
    }
    
    /**
     * Request the google account permissions
     *
     * @param activity       Activity of the View
     * @param permissionCode Code for start activity
     */
    public final void requestAccountPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int permissionCode) {
    }
}