package com.contusfly.views;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/views/SetDrawable;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "(Landroid/content/Context;Lcom/mirrorflysdk/api/contacts/ProfileDetails;)V", "emojiPattern", "Ljava/util/regex/Pattern;", "getProfileNameIcon", "", "username", "isEmojiOnly", "", "string", "(Ljava/lang/String;)Ljava/lang/Boolean;", "setDrawable", "Landroid/graphics/drawable/Drawable;", "name", "setDrawableForCustomName", "setDrawableForProfile", "app_debug"})
public final class SetDrawable {
    private android.content.Context context;
    private com.mirrorflysdk.api.contacts.ProfileDetails profileDetails;
    private final java.util.regex.Pattern emojiPattern = null;
    
    public SetDrawable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public SetDrawable(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Synchronized()
    public final synchronized android.graphics.drawable.Drawable setDrawable(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.drawable.Drawable setDrawableForProfile(@org.jetbrains.annotations.Nullable()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.drawable.Drawable setDrawableForCustomName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    private final java.lang.Boolean isEmojiOnly(java.lang.String string) {
        return null;
    }
    
    private final java.lang.String getProfileNameIcon(java.lang.String username) {
        return null;
    }
}