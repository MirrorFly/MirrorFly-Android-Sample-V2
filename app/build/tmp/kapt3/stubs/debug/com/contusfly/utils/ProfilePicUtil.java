package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/utils/ProfilePicUtil;", "", "()V", "getDefaultDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "chatType", "", "app_debug"})
public final class ProfilePicUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.ProfilePicUtil INSTANCE = null;
    
    private ProfilePicUtil() {
        super();
    }
    
    /**
     * Get the default pic for each profile type when the user uploaded pic is not there &
     * the user is blocked or unknown
     * @param context
     * @param chatType 'chat','group'...
     * @return drawable
     */
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"UseCompatLoadingForDrawables"})
    public final android.graphics.drawable.Drawable getDefaultDrawable(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String chatType) {
        return null;
    }
}