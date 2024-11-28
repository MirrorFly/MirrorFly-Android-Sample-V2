package com.contusfly.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020(H\u0002J\b\u0010.\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020(H\u0002J\b\u00100\u001a\u00020(H\u0002J\b\u00101\u001a\u00020(H\u0002J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020(H\u0002J$\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010@\u001a\u00020(H\u0002J\b\u0010A\u001a\u00020(H\u0002J\u0010\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020(J\b\u0010F\u001a\u00020(H\u0002J\b\u0010G\u001a\u00020(H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100!0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006I"}, d2 = {"Lcom/contusfly/fragments/ProfileDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "callPermissionUtils", "Lcom/contusfly/call/CallPermissionUtils;", "getCallPermissionUtils", "()Lcom/contusfly/call/CallPermissionUtils;", "setCallPermissionUtils", "(Lcom/contusfly/call/CallPermissionUtils;)V", "callResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "chatResultLauncher", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "lastCallAction", "", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getProfileDetails", "()Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "setProfileDetails", "(Lcom/mirrorflysdk/api/contacts/ProfileDetails;)V", "profileDialogBinding", "Lcom/contusfly/databinding/FragmentProfileDialogBinding;", "profileResultLauncher", "requestCallPermissions", "", "rosterImage", "getRosterImage", "()Ljava/lang/String;", "setRosterImage", "(Ljava/lang/String;)V", "callAutheticationChecking", "", "callType", "checkUserBlocked", "dismissDialog", "hideCallIcons", "launchAutheticationCallActivity", "launchAutheticationChatActivity", "launchAutheticationProfileActivity", "launchCall", "makeAudioCall", "makeVideoCall", "navigateToChatViewScreen", "navigateToProfileImageScreen", "navigateToProfileInfoScreen", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "privateChatAuthenticationChecking", "privateProfileAuthenticationChecking", "profileThumbLoad", "drawable", "Landroid/graphics/drawable/Drawable;", "refreshView", "setData", "setListeners", "Companion", "app_debug"})
public final class ProfileDialogFragment extends androidx.fragment.app.DialogFragment {
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    private com.contusfly.databinding.FragmentProfileDialogBinding profileDialogBinding;
    public com.contusfly.call.CallPermissionUtils callPermissionUtils;
    @org.jetbrains.annotations.NotNull
    private com.mirrorflysdk.api.contacts.ProfileDetails profileDetails;
    public java.lang.String rosterImage;
    private java.lang.String lastCallAction = "";
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestCallPermissions = null;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> chatResultLauncher;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> profileResultLauncher;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> callResultLauncher;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.ProfileDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public ProfileDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.call.CallPermissionUtils getCallPermissionUtils() {
        return null;
    }
    
    public final void setCallPermissionUtils(@org.jetbrains.annotations.NotNull
    com.contusfly.call.CallPermissionUtils p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mirrorflysdk.api.contacts.ProfileDetails getProfileDetails() {
        return null;
    }
    
    public final void setProfileDetails(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRosterImage() {
        return null;
    }
    
    public final void setRosterImage(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
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
    
    private final void privateChatAuthenticationChecking() {
    }
    
    private final void navigateToChatViewScreen() {
    }
    
    private final void launchAutheticationChatActivity() {
    }
    
    private final void privateProfileAuthenticationChecking() {
    }
    
    private final void launchAutheticationProfileActivity() {
    }
    
    private final void navigateToProfileInfoScreen() {
    }
    
    private final void navigateToProfileImageScreen() {
    }
    
    private final void callAutheticationChecking(java.lang.String callType) {
    }
    
    private final void launchAutheticationCallActivity() {
    }
    
    private final void launchCall() {
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
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.fragments.ProfileDialogFragment newInstance(@org.jetbrains.annotations.NotNull
        com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
            return null;
        }
    }
}