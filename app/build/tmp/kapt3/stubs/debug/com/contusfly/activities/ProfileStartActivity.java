package com.contusfly.activities;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020>H\u0002J\u0014\u0010F\u001a\u0004\u0018\u00010\n2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u00020>H\u0002J\u0010\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020\u0016H\u0002J\"\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u0012\u0010R\u001a\u00020>2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\b\u0010S\u001a\u00020>H\u0002J\u0010\u0010T\u001a\u00020>2\u0006\u0010U\u001a\u00020\u0016H\u0002J\u0012\u0010V\u001a\u00020>2\b\u0010W\u001a\u0004\u0018\u00010XH\u0002J\u0010\u0010Y\u001a\u00020>2\u0006\u0010Z\u001a\u00020DH\u0002J\b\u0010[\u001a\u00020\u0016H\u0002J\u0010\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020NH\u0016J\u0010\u0010^\u001a\u00020>2\u0006\u0010_\u001a\u00020\u0016H\u0016J\b\u0010`\u001a\u00020>H\u0002J\b\u0010a\u001a\u00020>H\u0002J\b\u0010b\u001a\u00020>H\u0002J\"\u0010c\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\b\u0010d\u001a\u0004\u0018\u00010QH\u0014J\b\u0010e\u001a\u00020>H\u0016J\u001a\u0010f\u001a\u00020>2\b\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020NH\u0016J\u0012\u0010f\u001a\u00020>2\b\u0010j\u001a\u0004\u0018\u00010XH\u0016J\b\u0010k\u001a\u00020>H\u0016J\u0012\u0010l\u001a\u00020>2\b\u0010m\u001a\u0004\u0018\u00010nH\u0014J\b\u0010o\u001a\u00020>H\u0014J\u001a\u0010p\u001a\u00020>2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010_\u001a\u00020\u0016H\u0016J\b\u0010s\u001a\u00020>H\u0016J\u0012\u0010t\u001a\u00020>2\b\u0010m\u001a\u0004\u0018\u00010nH\u0014J\b\u0010u\u001a\u00020>H\u0014J\b\u0010v\u001a\u00020>H\u0002J\b\u0010w\u001a\u00020>H\u0002J\b\u0010x\u001a\u00020>H\u0002J\u0012\u0010y\u001a\u00020>2\b\u0010z\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010{\u001a\u00020>H\u0002J\b\u0010|\u001a\u00020>H\u0002J\b\u0010}\u001a\u00020>H\u0016J\u0012\u0010~\u001a\u00020>2\b\u0010\u007f\u001a\u0004\u0018\u00010\nH\u0002J\t\u0010\u0080\u0001\u001a\u00020>H\u0002J\t\u0010\u0081\u0001\u001a\u00020>H\u0003J\t\u0010\u0082\u0001\u001a\u00020>H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020>2\u0007\u0010\u0084\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0085\u0001\u001a\u00020>H\u0002J\t\u0010\u0086\u0001\u001a\u00020>H\u0002J\t\u0010\u0087\u0001\u001a\u00020>H\u0002J\t\u0010\u0088\u0001\u001a\u00020>H\u0016J\u0012\u0010\u0088\u0001\u001a\u00020>2\u0007\u0010\u0089\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u008a\u0001\u001a\u00020>H\u0002J\u0011\u0010\u008b\u0001\u001a\u00020>2\u0006\u0010#\u001a\u00020$H\u0002J\u0013\u0010\u008c\u0001\u001a\u00020>2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\t\u0010\u008d\u0001\u001a\u00020>H\u0002J\t\u0010\u008e\u0001\u001a\u00020>H\u0002J\t\u0010\u008f\u0001\u001a\u00020>H\u0002J\u001a\u0010\u0090\u0001\u001a\u00020>2\u0007\u0010\u0091\u0001\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0016J\t\u0010\u0092\u0001\u001a\u00020>H\u0002J\t\u0010\u0093\u0001\u001a\u00020>H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010\'8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00103\u001a\u0004\u0018\u0001048\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0094\u0001"}, d2 = {"Lcom/contusfly/activities/ProfileStartActivity;", "Lcom/contusfly/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "Landroid/content/DialogInterface$OnClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "fromBackground", "", "galleryPermissionLauncher", "isFirstUser", "isFromSettingsProfile", "isImageSelected", "isProfileChanged", "isProfilePending", "isProfileStart", "isProfileUpdated", "isUpdateClickedOnStart", "isUserProfileRemoved", "lastClickTime", "", "mFileTemp", "Ljava/io/File;", "mStatus", "mobileEditText", "Lcom/contusfly/views/CustomTextView;", "mobileNumber", "name", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "profileName", "profilePicture", "Lcom/contusfly/views/CircularImageView;", "profileStartBinding", "Lcom/contusfly/databinding/ActivityProfileStartBinding;", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "saveLastClickTime", "setDrawable", "Lcom/contusfly/views/SetDrawable;", "userImgUrl", "checkContusMail", "", "checkEmailContentTextWatcher", "textEmail", "Lcom/contusfly/views/CustomEditText;", "checkNameContentTextWatcher", "editProfileName", "Landroidx/appcompat/widget/AppCompatEditText;", "clickListeners", "getFileExtension", "uri", "Landroid/net/Uri;", "getIntentValues", "getProfileFromServer", "isUpdated", "handleActivityResult", "requestCode", "", "resultCode", "intentData", "Landroid/content/Intent;", "handleImageFromGallery", "handleProfileChanges", "handleSaveButton", "enable", "handleUserClick", "v", "Landroid/view/View;", "hideCursorsAndKeyboard", "editText", "isDataChangeValid", "listOptionSelected", "position", "myProfileUpdated", "isSuccess", "navigateToContactSync", "navigateToDashboard", "navigateToMainPage", "onActivityResult", "data", "onBackPressed", "onClick", "p0", "Landroid/content/DialogInterface;", "which", "view", "onConnected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "onDisconnected", "onPostCreate", "onResume", "openGalleryIntent", "profilePicPreview", "profilePicUploadFailure", "profilePicUploadSuccess", "image", "redirectToUpdateProfile", "revokeAccessForProfileImage", "setProfileImagePath", "setStatus", "newStatus", "setUserProfile", "setUserProfileData", "showProfilePicInitials", "showResponseToast", "success", "takePhoto", "updateArchiveChatsSettings", "updateMyProfile", "updateProfile", "inProgress", "updateProfileImageIfUrlEmpty", "updateProfilePic", "updateUserMail", "updateUserName", "updateUserStatus", "uploadImage", "userProfileFetched", "jid", "validateUserMail", "viewInitialization", "app_debug"})
public class ProfileStartActivity extends com.contusfly.activities.BaseActivity implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    private com.contusfly.databinding.ActivityProfileStartBinding profileStartBinding;
    
    /**
     * Mobile number of the user
     */
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    protected java.lang.String mobileNumber;
    private java.lang.String profileName;
    private java.lang.String name;
    private java.lang.String mStatus;
    private java.io.File mFileTemp;
    private boolean fromBackground = false;
    
    /**
     * The mobile edit text in the profile page.User can edit or enter the mobile.
     */
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    protected com.contusfly.views.CustomTextView mobileEditText;
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    protected com.contusfly.views.CircularImageView profilePicture;
    
    /**
     * The progress dialog of the activity When run the background tasks
     */
    private com.contusfly.views.DoProgressDialog progressDialog;
    private boolean isImageSelected = false;
    private boolean isFirstUser = false;
    private java.lang.String userImgUrl = "";
    
    /**
     * Boolean value to handle user profile remove
     */
    private boolean isUserProfileRemoved = false;
    
    /**
     * Store onclick time to avoid double click
     */
    private long lastClickTime = 0L;
    private long saveLastClickTime = 0L;
    private com.contusfly.views.SetDrawable setDrawable;
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    private boolean isProfileStart = false;
    private boolean isProfileUpdated = false;
    private boolean isProfilePending = false;
    private boolean isUpdateClickedOnStart = false;
    private com.mirrorflysdk.api.contacts.ProfileDetails profileDetails;
    private boolean isFromSettingsProfile = true;
    private boolean isProfileChanged = false;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> cameraPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> galleryPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public ProfileStartActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    protected final kotlinx.coroutines.CoroutineExceptionHandler getExceptionHandler() {
        return null;
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onPostCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getIntentValues() {
    }
    
    private final void viewInitialization() {
    }
    
    private final void clickListeners() {
    }
    
    private final void checkEmailContentTextWatcher(com.contusfly.views.CustomEditText textEmail) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void hideCursorsAndKeyboard(androidx.appcompat.widget.AppCompatEditText editText) {
    }
    
    private final void checkNameContentTextWatcher(androidx.appcompat.widget.AppCompatEditText editProfileName) {
    }
    
    private final void handleProfileChanges() {
    }
    
    private final boolean isDataChangeValid() {
        return false;
    }
    
    private final void handleSaveButton(boolean enable) {
    }
    
    @android.annotation.SuppressLint(value = {"UseCompatLoadingForDrawables"})
    private final void setUserProfileData() {
    }
    
    private final void getProfileFromServer(boolean isUpdated) {
    }
    
    private final void setUserProfile() {
    }
    
    private final void setStatus(java.lang.String newStatus) {
    }
    
    public void setProfileImagePath() {
    }
    
    @java.lang.Override
    public void myProfileUpdated(boolean isSuccess) {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.view.View view) {
    }
    
    private final void profilePicPreview() {
    }
    
    private final void openGalleryIntent() {
    }
    
    private final void validateUserMail() {
    }
    
    private final void redirectToUpdateProfile() {
    }
    
    private final void handleUserClick(android.view.View v) {
    }
    
    /**
     * Take photo for profile image
     */
    private final void takePhoto() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.content.DialogInterface p0, int which) {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    /**
     * To get the format of picked image
     * @param uri
     */
    @org.jetbrains.annotations.Nullable
    public java.lang.String getFileExtension(@org.jetbrains.annotations.Nullable
    android.net.Uri uri) {
        return null;
    }
    
    /**
     * Handle the profile activity result
     *
     * @param requestCode Activity request code
     * @param intentData  Instance of Intent
     */
    private final void handleActivityResult(int requestCode, int resultCode, android.content.Intent intentData) {
    }
    
    private final void uploadImage() {
    }
    
    private final void updateProfilePic(java.io.File mFileTemp) {
    }
    
    private final void profilePicUploadSuccess(java.lang.String image) {
    }
    
    private final void profilePicUploadFailure() {
    }
    
    private final void handleImageFromGallery(android.content.Intent intentData) {
    }
    
    private final void updateUserMail(android.content.Intent intentData) {
    }
    
    private final void updateUserName() {
    }
    
    private final void updateUserStatus() {
    }
    
    public void updateProfile() {
    }
    
    private final void showResponseToast(boolean success) {
    }
    
    public void updateProfile(boolean inProgress) {
    }
    
    private final void navigateToDashboard() {
    }
    
    private final void updateArchiveChatsSettings() {
    }
    
    private final void updateProfileImageIfUrlEmpty() {
    }
    
    private final void showProfilePicInitials() {
    }
    
    private final void navigateToMainPage() {
    }
    
    private final void navigateToContactSync() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    private final void revokeAccessForProfileImage() {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    private final void updateMyProfile() {
    }
    
    @java.lang.Override
    public void userProfileFetched(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    private final void checkContusMail() {
    }
    
    @java.lang.Override
    public void onConnected() {
    }
    
    @java.lang.Override
    public void onDisconnected() {
    }
}