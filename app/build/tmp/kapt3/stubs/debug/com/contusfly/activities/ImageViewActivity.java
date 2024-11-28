package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001cB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010%H\u0002J\u0012\u00109\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0010\u0010<\u001a\u0002072\u0006\u0010-\u001a\u00020\u0010H\u0016J\b\u0010=\u001a\u000207H\u0002J\"\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J \u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u0014H\u0016J\u001a\u0010E\u001a\u0002072\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u0010H\u0016J\u0010\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u0002072\b\u0010M\u001a\u0004\u0018\u00010NH\u0014J\u0010\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u0002072\u0006\u0010S\u001a\u00020\bH\u0016J\u001a\u0010T\u001a\u0002072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010U\u001a\u0002072\u0006\u0010S\u001a\u00020\bH\u0016J\u0010\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u000207H\u0002J\b\u0010Z\u001a\u000207H\u0002J\b\u0010[\u001a\u000207H\u0002J\u0018\u0010\\\u001a\u0002072\u0006\u0010B\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u0014H\u0002J\b\u0010]\u001a\u000207H\u0002J\b\u0010^\u001a\u000207H\u0002J\u0010\u0010_\u001a\u0002072\u0006\u0010B\u001a\u00020\bH\u0002J\b\u0010`\u001a\u000207H\u0002J\u0010\u0010a\u001a\u0002072\u0006\u0010B\u001a\u00020\bH\u0016J\u0010\u0010b\u001a\u0002072\u0006\u0010B\u001a\u00020\bH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\'\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006d"}, d2 = {"Lcom/contusfly/activities/ImageViewActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/content/DialogInterface$OnClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "getDialogType", "()Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "setDialogType", "(Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;)V", "errorImage", "", "getErrorImage", "()I", "fromLoginProfile", "", "galleryPermissionLauncher", "groupId", "groupImage", "Landroid/widget/ImageView;", "groupOrUserName", "imageUrl", "imageViewBinding", "Lcom/contusfly/databinding/ActivityImageViewBinding;", "isImageUpdate", "isSuccess", "()Z", "setSuccess", "(Z)V", "mDialog", "Lcom/contusfly/views/CommonAlertDialog;", "mFileCameraTemp", "Ljava/io/File;", "mFileTemp", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "position", "getPosition", "setPosition", "(I)V", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "storagePath", "userId", "userImgUrl", "handleCameraIntent", "", "tempFile", "handleGalleryIntent", "data", "Landroid/content/Intent;", "listOptionSelected", "loadNewImage", "onActivityResult", "requestCode", "resultCode", "onAdminBlockedOtherUser", "jid", "type", "status", "onClick", "p0", "Landroid/content/DialogInterface;", "which", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDeleteGroup", "groupJid", "onDialogClosed", "onGroupProfileUpdated", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "pickImageFromGallery", "profileImageUrlUpdate", "revokeAccessForProfile", "setUserProfileImage", "startDashboardActivity", "takePhoto", "updateUserProfile", "uploadImage", "userDeletedHisProfile", "userUpdatedHisProfile", "Companion", "app_debug"})
public final class ImageViewActivity extends com.contusfly.activities.BaseActivity implements android.content.DialogInterface.OnClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private com.contusfly.databinding.ActivityImageViewBinding imageViewBinding;
    private java.lang.String storagePath = "/storage/emulated/";
    
    /**
     * The jabber id of the selected group.
     */
    private java.lang.String groupId;
    
    /**
     * Flag to identify whether the activity is launched as a result of group image update.
     */
    private boolean isImageUpdate = false;
    
    /**
     * The name of the selected user/group.
     */
    private java.lang.String groupOrUserName;
    
    /**
     * The jabber id of the selected user.
     */
    private java.lang.String userId;
    
    /**
     * The storage url of the selected user/group image.
     */
    private java.lang.String imageUrl = "";
    
    /**
     * The file to which the group image is associated.
     */
    private java.io.File mFileTemp;
    
    /**
     * The file to which the group camera image is associated.
     */
    private java.io.File mFileCameraTemp;
    
    /**
     * The instance of the DoProgressDialog
     */
    private com.contusfly.views.DoProgressDialog progressDialog;
    
    /**
     * The s3 bucket url of the updated image obtained after uploading it to the Amazon server.
     */
    private java.lang.String userImgUrl;
    
    /**
     * The ImageView to display an image resource.
     */
    private android.widget.ImageView groupImage;
    private boolean fromLoginProfile = false;
    
    /**
     * The instance of the CommonAlertDialog object.
     */
    private com.contusfly.views.CommonAlertDialog mDialog;
    @org.jetbrains.annotations.Nullable
    private com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType;
    private boolean isSuccess = false;
    private int position = 0;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> galleryPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> cameraPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.activities.ImageViewActivity.Companion Companion = null;
    private static final java.lang.String TRANSITION_NAME = "image_transition";
    private java.util.HashMap _$_findViewCache;
    
    public ImageViewActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.views.CommonAlertDialog.DIALOGTYPE getDialogType() {
        return null;
    }
    
    public final void setDialogType(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE p0) {
    }
    
    public final boolean isSuccess() {
        return false;
    }
    
    public final void setSuccess(boolean p0) {
    }
    
    public final int getPosition() {
        return 0;
    }
    
    public final void setPosition(int p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override
    public void onGroupProfileUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void profileImageUrlUpdate() {
    }
    
    @java.lang.Override
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    /**
     * To handle callback of any user's profile deleted
     */
    @java.lang.Override
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void updateUserProfile(java.lang.String jid) {
    }
    
    @java.lang.Override
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull
    android.content.res.Configuration newConfig) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.content.DialogInterface p0, int which) {
    }
    
    /**
     * Open the gallery to pick a new image to modify the group icon.
     */
    private final void pickImageFromGallery() {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    public void onDeleteGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid) {
    }
    
    private final void startDashboardActivity() {
    }
    
    private final void revokeAccessForProfile() {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    /**
     * Handle the result of the camera intent and crop the chosen image to update the group icon.
     *
     * @param tempFile An File, which has the result of camera.
     */
    private final void handleCameraIntent(java.io.File tempFile) {
    }
    
    /**
     * Take a photo to update group image.
     */
    private final void takePhoto() {
    }
    
    /**
     * Handle the result of the gallery intent and crop the chosen image to update the group icon.
     *
     * @param data An Intent, which return the result data to the caller.
     */
    private final void handleGalleryIntent(android.content.Intent data) {
    }
    
    /**
     * Upload the updated group image into the Amazon S3 storage.
     */
    private final void uploadImage() {
    }
    
    private final void loadNewImage() {
    }
    
    /**
     * Starts activity with transition of ImageView
     *
     * @param activity  Starting activity
     * @param imageUrl  Image url
     * @param imageView Image view
     */
    @kotlin.jvm.JvmStatic
    public static final void startActivity(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable
    android.widget.ImageView imageView) {
    }
    
    private final int getErrorImage() {
        return 0;
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    private final void setUserProfileImage(java.lang.String jid, boolean status) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/contusfly/activities/ImageViewActivity$Companion;", "", "()V", "TRANSITION_NAME", "", "startActivity", "", "activity", "Landroid/app/Activity;", "imageUrl", "imageView", "Landroid/widget/ImageView;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Starts activity with transition of ImageView
         *
         * @param activity  Starting activity
         * @param imageUrl  Image url
         * @param imageView Image view
         */
        @kotlin.jvm.JvmStatic
        public final void startActivity(@org.jetbrains.annotations.NotNull
        android.app.Activity activity, @org.jetbrains.annotations.Nullable
        java.lang.String imageUrl, @org.jetbrains.annotations.Nullable
        android.widget.ImageView imageView) {
        }
    }
}