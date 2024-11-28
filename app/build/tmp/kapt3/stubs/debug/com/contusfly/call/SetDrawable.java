package com.contusfly.call;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J,\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000bJ#\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00a2\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002\u00a8\u0006 "}, d2 = {"Lcom/contusfly/call/SetDrawable;", "Lcom/contusfly/views/BaseDrawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "(Landroid/content/Context;Lcom/mirrorflysdk/api/contacts/ProfileDetails;)V", "getDrawableBasedOnUserName", "Landroid/graphics/drawable/Drawable;", "nameString", "", "isProfile", "", "icon", "Lcom/contusfly/views/CustomDrawable;", "getProfileNameIcon", "username", "isEmojiOnly", "string", "setDrawableForGroupCall", "drawableSize", "", "isUnknownContact", "setDrawableForProfile", "name", "setDrawableProfile", "initialname", "", "([Ljava/lang/String;Lcom/contusfly/views/CustomDrawable;)Landroid/graphics/drawable/Drawable;", "setDrawableProfileColour", "", "app_debug"})
public final class SetDrawable extends com.contusfly.views.BaseDrawable {
    
    public SetDrawable(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public SetDrawable(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.drawable.Drawable setDrawableForProfile(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    private final android.graphics.drawable.Drawable setDrawableProfile(java.lang.String[] initialname, com.contusfly.views.CustomDrawable icon) {
        return null;
    }
    
    private final android.graphics.drawable.Drawable getDrawableBasedOnUserName(java.lang.String nameString, boolean isProfile, com.contusfly.views.CustomDrawable icon) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.Synchronized
    public final synchronized android.graphics.drawable.Drawable setDrawableForGroupCall(@org.jetbrains.annotations.Nullable
    java.lang.String nameString, float drawableSize, boolean isProfile, boolean isUnknownContact) {
        return null;
    }
    
    private final void setDrawableProfileColour(com.contusfly.views.CustomDrawable icon, boolean isProfile) {
    }
    
    private final boolean isEmojiOnly(java.lang.String string) {
        return false;
    }
    
    private final java.lang.String getProfileNameIcon(java.lang.String username) {
        return null;
    }
}