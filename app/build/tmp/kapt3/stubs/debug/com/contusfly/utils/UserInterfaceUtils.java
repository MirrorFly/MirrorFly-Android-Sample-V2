package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/contusfly/utils/UserInterfaceUtils;", "", "()V", "Companion", "app_debug"})
public final class UserInterfaceUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.UserInterfaceUtils.Companion Companion = null;
    
    public UserInterfaceUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ,\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/utils/UserInterfaceUtils$Companion;", "", "()V", "initializeCustomToolbar", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "setUpToolBar", "context", "Landroid/app/Activity;", "actionBar", "Landroidx/appcompat/app/ActionBar;", "title", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Initializes a customized [Toolbar][android.widget.Toolbar] to act as the
         * [android.app.ActionBar] for the Activity window.
         *
         * @param activity The instance of the AppCompatActivity object.
         * @param toolbar  Toolbar to set as the Activity's action bar.
         */
        public final void initializeCustomToolbar(@org.jetbrains.annotations.NotNull
        androidx.appcompat.app.AppCompatActivity activity, @org.jetbrains.annotations.Nullable
        androidx.appcompat.widget.Toolbar toolbar) {
        }
        
        /**
         * Sets the up tool bar for the Activity. This toolbar will be setup with
         * back-press option. The
         * [Activity] back press will called it's super class back-press.
         *
         * @param context   Instance of Context
         * @param toolbar   Instance of Toolbar
         * @param actionBar Instance of Actionbar
         * @param title     String title
         */
        public final void setUpToolBar(@org.jetbrains.annotations.NotNull
        android.app.Activity context, @org.jetbrains.annotations.Nullable
        androidx.appcompat.widget.Toolbar toolbar, @org.jetbrains.annotations.Nullable
        androidx.appcompat.app.ActionBar actionBar, @org.jetbrains.annotations.Nullable
        java.lang.String title) {
        }
    }
}