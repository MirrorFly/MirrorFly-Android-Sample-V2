package com.contusfly.chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/contusfly/chat/AndroidUtils;", "", "()V", "density", "", "calculateAndStoreDeviceWidth", "", "activity", "Landroid/app/Activity;", "checkDisplaySize", "context", "Landroid/content/Context;", "convertDpToPixel", "", "dp", "convertPixelsToDp", "px", "value", "getDensity", "getFileSizeInMb", "file", "Ljava/io/File;", "getNavBarHeight", "getScreenWidth", "getStatusBarHeight", "isTablet", "", "c", "app_debug"})
public final class AndroidUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.chat.AndroidUtils INSTANCE = null;
    private static float density = 1.0F;
    
    private AndroidUtils() {
        super();
    }
    
    public final float getDensity(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return 0.0F;
    }
    
    public final int dp(float value, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return 0;
    }
    
    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public final int convertDpToPixel(int dp, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return 0;
    }
    
    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public final int convertPixelsToDp(int px, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return 0;
    }
    
    private final void checkDisplaySize(android.content.Context context) {
    }
    
    /**
     * Device width will be calculated and stored in SharedPreference which will be
     * used to calculate message view width in chat activity
     */
    public final void calculateAndStoreDeviceWidth(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    public final int getStatusBarHeight(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return 0;
    }
    
    public final int getNavBarHeight(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return 0;
    }
    
    private final boolean isTablet(android.content.Context c) {
        return false;
    }
    
    public final float getFileSizeInMb(@org.jetbrains.annotations.NotNull
    java.io.File file) {
        return 0.0F;
    }
    
    public final int getScreenWidth(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
        return 0;
    }
}