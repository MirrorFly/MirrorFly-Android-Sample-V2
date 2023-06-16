package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u0010J\u0018\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u0016J\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/contusfly/utils/SharedPreferenceManager;", "", "()V", "editor", "Landroid/content/SharedPreferences$Editor;", "kotlin.jvm.PlatformType", "masterKey", "Landroidx/security/crypto/MasterKey;", "nonEncryptedPreferences", "Landroid/content/SharedPreferences;", "sharedPreferences", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "clearAllPreference", "", "isFromLogout", "", "getBoolean", "key", "", "getCurrentUserJid", "getInt", "", "getString", "setBoolean", "value", "setInt", "setString", "app_debug"})
public final class SharedPreferenceManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.SharedPreferenceManager INSTANCE = null;
    private static final androidx.security.crypto.MasterKey masterKey = null;
    private static final android.content.SharedPreferences nonEncryptedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private static final android.content.SharedPreferences sharedPreferences = null;
    private static android.content.SharedPreferences.Editor editor;
    
    private SharedPreferenceManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    /**
     * Set Boolean in preference.
     *
     * @param key   the key
     * @param value the value
     */
    public final void setBoolean(@org.jetbrains.annotations.Nullable()
    java.lang.String key, boolean value) {
    }
    
    /**
     * Get Boolean from preference.
     *
     * @param key the key
     * @return boolean Value from preference
     */
    public final boolean getBoolean(@org.jetbrains.annotations.Nullable()
    java.lang.String key) {
        return false;
    }
    
    /**
     * Set String in preference.
     *
     * @param key   the key
     * @param value the value
     */
    public final void setString(@org.jetbrains.annotations.Nullable()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    /**
     * Get the string from preference.
     *
     * @param key the key
     * @return String Value from preference
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getString(@org.jetbrains.annotations.Nullable()
    java.lang.String key) {
        return null;
    }
    
    /**
     * Set int in preference.
     *
     * @param key   the key
     * @param value the value
     */
    public final void setInt(@org.jetbrains.annotations.Nullable()
    java.lang.String key, int value) {
    }
    
    /**
     * Get the int from preference.
     *
     * @param key the key
     * @return Int Value from preference
     */
    public final int getInt(@org.jetbrains.annotations.Nullable()
    java.lang.String key) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserJid() {
        return null;
    }
    
    /**
     * Clear all preference.
     */
    public final void clearAllPreference(boolean isFromLogout) {
    }
}