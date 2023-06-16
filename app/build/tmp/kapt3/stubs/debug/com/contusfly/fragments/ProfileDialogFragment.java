package com.contusfly.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010\'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u00020$J\b\u0010:\u001a\u00020$H\u0002J\b\u0010;\u001a\u00020$H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006="}, d2 = {"Lcom/contusfly/fragments/ProfileDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "callPermissionUtils", "Lcom/contusfly/call/CallPermissionUtils;", "getCallPermissionUtils", "()Lcom/contusfly/call/CallPermissionUtils;", "setCallPermissionUtils", "(Lcom/contusfly/call/CallPermissionUtils;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "lastCallAction", "", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getProfileDetails", "()Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "setProfileDetails", "(Lcom/mirrorflysdk/api/contacts/ProfileDetails;)V", "profileDialogBinding", "Lcom/contusfly/databinding/FragmentProfileDialogBinding;", "requestCallPermissions", "Landroidx/activity/result/ActivityResultLauncher;", "", "rosterImage", "getRosterImage", "()Ljava/lang/String;", "setRosterImage", "(Ljava/lang/String;)V", "checkUserBlocked", "", "dismissDialog", "hideCallIcons", "makeAudioCall", "makeVideoCall", "navigateToChatViewScreen", "navigateToProfileImageScreen", "navigateToProfileInfoScreen", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "profileThumbLoad", "drawable", "Landroid/graphics/drawable/Drawable;", "refreshView", "setData", "setListeners", "Companion", "app_debug"})
public final class ProfileDialogFragment extends androidx.fragment.app.DialogFragment {
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    private com.contusfly.databinding.FragmentProfileDialogBinding profileDialogBinding;
    public com.contusfly.call.CallPermissionUtils callPermissionUtils;
    public com.mirrorflysdk.api.contacts.ProfileDetails profileDetails;
    public java.lang.String rosterImage;
    private java.lang.String lastCallAction = "";
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestCallPermissions = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.fragments.ProfileDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public ProfileDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.call.CallPermissionUtils getCallPermissionUtils() {
        return null;
    }
    
    public final void setCallPermissionUtils(@org.jetbrains.annotations.NotNull()
    com.contusfly.call.CallPermissionUtils p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mirrorflysdk.api.contacts.ProfileDetails getProfileDetails() {
        return null;
    }
    
    public final void setProfileDetails(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRosterImage() {
        return null;
    }
    
    public final void setRosterImage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setListeners() {
    }
    
    private final void checkUserBlocked() {
    }
    
    private final void setData() {
    }
    
    private final void profileThumbLoad(android.graphics.drawable.Drawable drawable) {
    }
    
    private final void hideCallIcons() {
    }
    
    private final void navigateToChatViewScreen() {
    }
    
    private final void navigateToProfileInfoScreen() {
    }
    
    private final void navigateToProfileImageScreen() {
    }
    
    private final void makeAudioCall() {
    }
    
    private final void makeVideoCall() {
    }
    
    private final void dismissDialog() {
    }
    
    public final void refreshView() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/fragments/ProfileDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/ProfileDialogFragment;", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.fragments.ProfileDialogFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
            return null;
        }
    }
}