package com.contusfly.fragments;

import java.lang.System;

/**
 * This class provides an option to the user for setting up the app notification preferences.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u001a\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\u0012\u0010 \u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010!\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/contusfly/fragments/NotificationsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/contusfly/databinding/FragmentNotificationsBinding;", "settingsActivity", "Lcom/contusfly/activities/SettingsActivity;", "getRingtoneName", "", "uri", "initViews", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewCreated", "view", "setClickListeners", "setNotificationToneChangedStatus", "setSelectedNotificationTone", "showCustomTones", "Companion", "app_debug"})
public final class NotificationsFragment extends androidx.fragment.app.Fragment {
    
    /**
     * The Activity to which this fragment is currently associated with.
     */
    private com.contusfly.activities.SettingsActivity settingsActivity;
    private com.contusfly.databinding.FragmentNotificationsBinding binding;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.fragments.NotificationsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public NotificationsFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void initViews() {
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    /**
     * To select alert tone for notication messages
     */
    private final void showCustomTones() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void setSelectedNotificationTone(android.content.Intent data) {
    }
    
    private final void setNotificationToneChangedStatus() {
    }
    
    /**
     * This method is to get the currently set ringtone name
     *
     * @param uri uri of the ringtone.
     * @return returns the name of the current ringtone
     */
    private final java.lang.String getRingtoneName(java.lang.String uri) {
        return null;
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object,
     * with the specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.contusfly.fragments.NotificationsFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/NotificationsFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/NotificationsFragment;", "app_debug"})
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
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.contusfly.fragments.NotificationsFragment newInstance() {
            return null;
        }
    }
}