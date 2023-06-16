package com.contusfly.call.groupcall.utils;

import java.lang.System;

/**
 * Multiple Images in Single ImageView to display in the chat list
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001-B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0001H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J \u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0012\u0010&\u001a\u00020\r2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\rH\u0002J\b\u0010,\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\tR\u00020\u00000\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/contusfly/call/groupcall/utils/CustomMultiDrawable;", "Landroid/graphics/drawable/Drawable;", "userList", "Ljava/util/ArrayList;", "", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "items", "Lcom/contusfly/call/groupcall/utils/CustomMultiDrawable$PhotoItem;", "paint", "Landroid/graphics/Paint;", "addImage", "", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "errorImg", "Landroid/graphics/Bitmap;", "index", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getBitmap", "drawable", "getCroppedBitmap", "bitmap", "getOpacity", "init", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "scaleCenterCrop", "source", "newHeight", "newWidth", "setAlpha", "i", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setFourOrMoreUserProfile", "setSingleProfile", "setThreeUserProfile", "setTwoUserProfile", "PhotoItem", "app_debug"})
public final class CustomMultiDrawable extends android.graphics.drawable.Drawable {
    private final java.util.ArrayList<java.lang.String> userList = null;
    private final android.content.Context context = null;
    private final android.graphics.Paint paint = null;
    private final java.util.ArrayList<com.contusfly.call.groupcall.utils.CustomMultiDrawable.PhotoItem> items = null;
    
    public CustomMultiDrawable(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> userList, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    protected void onBoundsChange(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect bounds) {
    }
    
    @java.lang.Override()
    public void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    public void setAlpha(int i) {
    }
    
    @java.lang.Override()
    public void setColorFilter(@org.jetbrains.annotations.Nullable()
    android.graphics.ColorFilter colorFilter) {
    }
    
    @java.lang.Override()
    public int getOpacity() {
        return 0;
    }
    
    /**
     * Create PhotoItem with position and size depends of count of images
     */
    private final void init() {
    }
    
    private final void setFourOrMoreUserProfile() {
    }
    
    private final void setThreeUserProfile() {
    }
    
    private final void setTwoUserProfile() {
    }
    
    private final void setSingleProfile() {
    }
    
    /**
     * Load Image url into bitmap
     * @param profileDetails profile of the user
     * @param context Instance of context
     * @param errorImg Placeholder for failure load
     * @param index Position to append in view
     */
    private final void addImage(com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, android.content.Context context, android.graphics.Bitmap errorImg, int index) {
    }
    
    /**
     * Load Drawable resource into bitmap
     * @param drawable Drawable to load bitmap
     */
    private final android.graphics.Bitmap getBitmap(android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    /**
     * Scale and center crop image
     *
     * @param source    Bitmap to be scaled
     * @param newHeight updated height
     * @param newWidth  updated width
     * @return Bitmap scaled bitmap
     */
    private final android.graphics.Bitmap scaleCenterCrop(android.graphics.Bitmap source, int newHeight, int newWidth) {
        return null;
    }
    
    /**
     * Circle crop image
     *
     * @param bitmap Bitmap to be cropped
     * @return Bitmap Circle cropped bitmap
     */
    private final android.graphics.Bitmap getCroppedBitmap(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    /**
     * *
     * Model class for store bitmap and position
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/call/groupcall/utils/CustomMultiDrawable$PhotoItem;", "", "bitmap", "Landroid/graphics/Bitmap;", "position", "Landroid/graphics/Rect;", "(Lcom/contusfly/call/groupcall/utils/CustomMultiDrawable;Landroid/graphics/Bitmap;Landroid/graphics/Rect;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getPosition", "()Landroid/graphics/Rect;", "setPosition", "(Landroid/graphics/Rect;)V", "app_debug"})
    public final class PhotoItem {
        @org.jetbrains.annotations.NotNull()
        private android.graphics.Bitmap bitmap;
        @org.jetbrains.annotations.NotNull()
        private android.graphics.Rect position;
        
        public PhotoItem(@org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
        android.graphics.Rect position) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Bitmap getBitmap() {
            return null;
        }
        
        public final void setBitmap(@org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Rect getPosition() {
            return null;
        }
        
        public final void setPosition(@org.jetbrains.annotations.NotNull()
        android.graphics.Rect p0) {
        }
    }
}