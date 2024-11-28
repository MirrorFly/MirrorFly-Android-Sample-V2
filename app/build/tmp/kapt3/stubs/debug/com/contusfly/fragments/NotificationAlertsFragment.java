package com.contusfly.fragments;

import java.lang.System;

/**
 * This class provides an option to the user for setting up the notification alert preferences when
 * receiving new messages.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/contusfly/fragments/NotificationAlertsFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/contusfly/databinding/FragmentNotificationAlertsBinding;", "settingsActivity", "Lcom/contusfly/activities/SettingsActivity;", "checkWhetherMuteEnabled", "", "displayMuteNotificationPreference", "displayNotificationPopupPreference", "displayNotificationSoundPreference", "displayVibrationPreference", "enableNotification", "initView", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setClickListeners", "unSetAlerts", "Companion", "app_debug"})
public final class NotificationAlertsFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    
    /**
     * The Activity to which this fragment is currently associated with.
     */
    private com.contusfly.activities.SettingsActivity settingsActivity;
    private com.contusfly.databinding.FragmentNotificationAlertsBinding binding;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.fragments.NotificationAlertsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public NotificationAlertsFragment() {
        super();
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
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
    
    private final void initView() {
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    /**
     * Displays the user preference in regard to playing the notification sound for incoming
     * messages. Vibration Preference is displayed only if the notification sound has been selected
     */
    private final void displayNotificationSoundPreference() {
    }
    
    /**
     * Displays the user preference in regard to presenting the notification popup for incoming
     * messages.
     */
    private final void displayNotificationPopupPreference() {
    }
    
    /**
     * Displays the user preference in regard to vibrating the device for new messages while the app
     * is in foreground.
     */
    private final void displayVibrationPreference() {
    }
    
    /**
     * Displays the user preference in regard to not showing up the notification for new messages.
     */
    private final void displayMuteNotificationPreference() {
    }
    
    /**
     * This method sets the Notification sound,Notification Popup and Vibration to false when mute
     * is selected
     */
    private final void unSetAlerts() {
    }
    
    private final void enableNotification() {
    }
    
    private final void checkWhetherMuteEnabled() {
    }
    
    /**
     * The constructor used to create and initialize a new instance of this class object,
     * with the specified initialization parameters.
     *
     * @return a new object created by calling the constructor of this object representation.
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.contusfly.fragments.NotificationAlertsFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/fragments/NotificationAlertsFragment$Companion;", "", "()V", "newInstance", "Lcom/contusfly/fragments/NotificationAlertsFragment;", "app_debug"})
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
        public final com.contusfly.fragments.NotificationAlertsFragment newInstance() {
            return null;
        }
    }
}