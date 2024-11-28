package com.contusfly.starredMessages;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u000f\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/starredMessages/StarredMessagesUtils;", "", "()V", "configureStarredMenuActionMode", "Landroid/view/Menu;", "context", "Landroid/content/Context;", "mode", "Landroid/view/ActionMode;", "menu", "prepareSingleMenuItem", "", "clickedStarredMessages", "", "", "validateFavouriteAction", "app_debug"})
public final class StarredMessagesUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.starredMessages.StarredMessagesUtils INSTANCE = null;
    
    private StarredMessagesUtils() {
        super();
    }
    
    /**
     * Set the action menu for the long press menu
     *
     * @param context Context
     * @param mode    Instance of the Alert dialog action mode
     * @param menu    Instance of Menu
     * @return Menu Configured action menu
     */
    @org.jetbrains.annotations.NotNull
    public final android.view.Menu configureStarredMenuActionMode(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.view.ActionMode mode, @org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return null;
    }
    
    /**
     * Prepare the single item menu for differentiate media end text to copyFiles or share.
     */
    public final void prepareSingleMenuItem(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> clickedStarredMessages, @org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
    }
    
    /**
     * Checks if the message is favourite message or not and makes the star actions visible or invisible
     */
    public final void validateFavouriteAction(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> clickedStarredMessages, @org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
    }
}