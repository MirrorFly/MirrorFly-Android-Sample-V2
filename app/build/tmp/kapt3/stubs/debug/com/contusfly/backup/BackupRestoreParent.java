package com.contusfly.backup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)J\u0006\u0010+\u001a\u00020\u0017J\u0006\u0010,\u001a\u00020\u0017R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/contusfly/backup/BackupRestoreParent;", "Lcom/contusfly/activities/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "getCommonAlertDialog", "()Lcom/contusfly/views/CommonAlertDialog;", "commonAlertDialog$delegate", "Lkotlin/Lazy;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "filePermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "getFilePermissionLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "listener", "Lcom/contusfly/backup/BackupRestoreParent$CommonBackupDialogListener;", "checkAndLoginMail", "", "accountName", "clientLogin", "newEmail", "silentSignIn", "", "clientLogout", "oldEmail", "handleSignInResult", "resultData", "Landroid/content/Intent;", "driveEmail", "Lcom/contusfly/views/CustomTextView;", "setCommonBackupDialogListener", "setImageForImageView", "selected", "", "imageViewList", "", "Landroidx/appcompat/widget/AppCompatImageView;", "showFileValidation", "showFrequencyDialog", "CommonBackupDialogListener", "app_debug"})
public class BackupRestoreParent extends com.contusfly.activities.BaseActivity implements kotlinx.coroutines.CoroutineScope {
    private com.contusfly.backup.BackupRestoreParent.CommonBackupDialogListener listener;
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy commonAlertDialog$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> filePermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public BackupRestoreParent() {
        super();
    }
    
    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    @org.jetbrains.annotations.NotNull
    protected final com.contusfly.views.CommonAlertDialog getCommonAlertDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> getFilePermissionLauncher() {
        return null;
    }
    
    public final void setCommonBackupDialogListener(@org.jetbrains.annotations.NotNull
    com.contusfly.backup.BackupRestoreParent.CommonBackupDialogListener listener) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    /**
     * Shows the Frequency Dialog
     */
    public final void showFrequencyDialog() {
    }
    
    /**
     * Sets the selected/deselected image in Frequency and Connectivity dialog
     *
     * @param selected Int
     * @param imageViewList List<AppCompatImageView>
     */
    public final void setImageForImageView(int selected, @org.jetbrains.annotations.NotNull
    java.util.List<? extends androidx.appcompat.widget.AppCompatImageView> imageViewList) {
    }
    
    private final void clientLogout(java.lang.String oldEmail) {
    }
    
    public final void clientLogin(@org.jetbrains.annotations.NotNull
    java.lang.String newEmail, boolean silentSignIn) {
    }
    
    public final void checkAndLoginMail(@org.jetbrains.annotations.NotNull
    java.lang.String accountName) {
    }
    
    /**
     * Handle the Successful Sign in of Google Account with Drive Permission
     * @param resultData Intent sign in data
     */
    public final void handleSignInResult(@org.jetbrains.annotations.NotNull
    android.content.Intent resultData, @org.jetbrains.annotations.NotNull
    com.contusfly.views.CustomTextView driveEmail) {
    }
    
    /**
     * Show the dialog for wrong file extension
     */
    public final void showFileValidation() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/contusfly/backup/BackupRestoreParent$CommonBackupDialogListener;", "", "onDialogClosed", "", "app_debug"})
    public static abstract interface CommonBackupDialogListener {
        
        public abstract void onDialogClosed();
    }
}