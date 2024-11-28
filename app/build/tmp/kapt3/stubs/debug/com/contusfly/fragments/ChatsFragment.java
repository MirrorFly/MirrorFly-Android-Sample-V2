package com.contusfly.fragments;

import java.lang.System;

/**
 * This class provides an option to the user for setting up the chat related settings.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002LMB\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020\'H\u0002J\b\u0010)\u001a\u00020\'H\u0002J\b\u0010*\u001a\u00020\'H\u0002J\b\u0010+\u001a\u00020\'H\u0002J\b\u0010,\u001a\u00020\'H\u0002J\u0010\u0010-\u001a\u00020\'2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\'2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\'2\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020\'2\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u0001052\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u00020\'H\u0016J\u001a\u0010?\u001a\u00020\'2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u0011H\u0016J\b\u0010C\u001a\u00020\'H\u0016J\u001a\u0010D\u001a\u00020\'2\u0006\u0010E\u001a\u0002052\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010F\u001a\u00020\'H\u0002J\b\u0010G\u001a\u00020\'H\u0002J\u0010\u0010H\u001a\u00020\'2\u0006\u0010I\u001a\u00020\u0011H\u0002J\b\u0010J\u001a\u00020\'H\u0002J\b\u0010K\u001a\u00020\'H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006N"}, d2 = {"Lcom/contusfly/fragments/ChatsFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/View$OnClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "chatSettingsAction", "Lcom/contusfly/fragments/ChatsFragment$ChatSettingsAction;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dialog", "Lcom/contusfly/views/CommonAlertDialog;", "fragmentChatsBinding", "Lcom/contusfly/databinding/FragmentChatsBinding;", "lastSeenEnabled", "", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "settingsActivity", "Lcom/contusfly/activities/SettingsActivity;", "settingsUtil", "Lcom/mirrorflysdk/utils/SettingsUtil;", "viewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/DashboardViewModel;", "viewModel$delegate", "writePermissionRequestLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "checkWriteExternalPermission", "clearAllConversation", "", "displayArchiveSettingsPreference", "displayAutoDownloadPreference", "displayLastSeenPreference", "displayTranslateLanguagePreference", "displayUserBusyStatusPreference", "featureActionValidation", "availableFeatures", "Lcom/mirrorflysdk/flycommons/Features;", "listOptionSelected", "position", "", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onResume", "onViewCreated", "view", "postLastSeenUserPreference", "saveMediaToGallery", "setArchivedSettingsData", "status", "setListeners", "setObservers", "ChatSettingsAction", "Companion", "app_debug"})
public final class ChatsFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope, android.view.View.OnClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    
    /**
     * The enumeration object to identify the type of action performed by the user
     * from the available list of chat settings action.
     */
    private com.contusfly.fragments.ChatsFragment.ChatSettingsAction chatSettingsAction;
    private com.contusfly.databinding.FragmentChatsBinding fragmentChatsBinding;
    
    /**
     * The Activity to which this fragment is currently associated with.
     */
    private com.contusfly.activities.SettingsActivity settingsActivity;
    
    /**
     * The alert dialog displayed on this screen to get the confirm about user action when
     * clearing the chat conversations from the app storage.
     */
    private com.contusfly.views.CommonAlertDialog dialog;
    private boolean lastSeenEnabled = true;
    private com.mirrorflysdk.utils.SettingsUtil settingsUtil;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> writePermissionRequestLauncher = null;
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.ChatsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public ChatsFragment() {
        super();
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    private final com.contusfly.viewmodels.DashboardViewModel getViewModel() {
        return null;
    }
    
    /**
     * The CustomTextView display the Only Selected Language
     */
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @org.jetbrains.annotations.Nullable
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
    
    /**
     * Displays the user preference in regard to save media files to gallery
     */
    private final void saveMediaToGallery() {
    }
    
    private final void setObservers() {
    }
    
    private final void setArchivedSettingsData(boolean status) {
    }
    
    /**
     * Displays the user preference in regard to enable/disable archive settings of the user.
     */
    private final void displayArchiveSettingsPreference() {
    }
    
    /**
     * Displays the user preference in regard to hiding the last seen activity of the user.
     */
    private final void displayLastSeenPreference() {
    }
    
    private final void setListeners() {
    }
    
    /**
     * Displays the user preference in regard to the busy status maintained by the user.
     */
    private final void displayUserBusyStatusPreference() {
    }
    
    /**
     * Displays the user preference in regard to downloading the media type chat messages without
     * waiting for the user confirmation.
     */
    private final void displayAutoDownloadPreference() {
    }
    
    /**
     * Displays translated language
     */
    private final void displayTranslateLanguagePreference() {
    }
    
    /**
     * Posts the user preference to the XMPP server, whether to show or hide the last activity of
     * the user so that the other registered app users will get notified of the same.
     */
    private final void postLastSeenUserPreference() {
    }
    
    private final boolean checkWriteExternalPermission() {
        return false;
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    /**
     * On DialogClosed
     *
     * @param dialogType the dialog type
     * @param isSuccess  the is success
     */
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    private final void clearAllConversation() {
    }
    
    /**
     * Only Selected Jids from User
     *
     * @param position the position
     */
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override
    public void onDetach() {
    }
    
    private final void featureActionValidation(com.mirrorflysdk.flycommons.Features availableFeatures) {
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object,
     * with the specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.contusfly.fragments.ChatsFragment newInstance() {
        return null;
    }
    
    /**
     * The enumeration object which defines the different type of chat settings action which can be
     * done in this activity.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/fragments/ChatsFragment$ChatSettingsAction;", "", "(Ljava/lang/String;I)V", "CLEAR_CONVERSATION", "DELETE_CONVERSATION", "EXPORT_CALL_LOG", "app_debug"})
    static enum ChatSettingsAction {
        /*public static final*/ CLEAR_CONVERSATION /* = new CLEAR_CONVERSATION() */,
        /*public static final*/ DELETE_CONVERSATION /* = new DELETE_CONVERSATION() */,
        /*public static final*/ EXPORT_CALL_LOG /* = new EXPORT_CALL_LOG() */;
        
        ChatSettingsAction() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/ChatsFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/ChatsFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.contusfly.fragments.ChatsFragment newInstance() {
            return null;
        }
    }
}