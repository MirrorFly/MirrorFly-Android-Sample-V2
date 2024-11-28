package com.contusfly.utils;

import java.lang.System;

/**
 * This class used to decode the images...
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ4\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0002\u00a8\u0006\u0019"}, d2 = {"Lcom/contusfly/utils/DecodeImageUtils;", "", "()V", "decodeStream", "Landroid/graphics/Bitmap;", "fil", "Ljava/io/File;", "selectedImage", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "loadImageInView", "", "imageView", "Landroid/widget/ImageView;", "path", "", "base64", "context", "id", "", "rotateImage", "bmp", "imageUrl", "Companion", "app_debug"})
public final class DecodeImageUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.DecodeImageUtils.Companion Companion = null;
    
    /**
     * 90 Degree Rotation degree of the image
     */
    private static final int ROTATE_90_D = 90;
    
    /**
     * 180 Degree Rotation degree of the image
     */
    private static final int ROTATE_180_D = 180;
    
    /**
     * 270 Degree Rotation degree of the image
     */
    private static final int ROTATE_270_D = 270;
    
    public DecodeImageUtils() {
        super();
    }
    
    /**
     * Converts URL into the bitmap
     *
     * @param fil           Local file
     * @param selectedImage Uri of the selected image
     * @param mContext      Application context
     * @return Bitmap Bitmap of the image
     */
    @org.jetbrains.annotations.Nullable
    public final android.graphics.Bitmap decodeStream(@org.jetbrains.annotations.NotNull
    java.io.File fil, @org.jetbrains.annotations.Nullable
    android.net.Uri selectedImage, @org.jetbrains.annotations.NotNull
    android.content.Context mContext) {
        return null;
    }
    
    /**
     * Rotate image the original image
     *
     * @param bmp      Instance of bitmap
     * @param imageUrl Image url
     * @return Bitmap Instance of bitmap
     */
    private final android.graphics.Bitmap rotateImage(android.graphics.Bitmap bmp, java.lang.String imageUrl) {
        return null;
    }
    
    /**
     * Load image in view.
     *
     * @param imageView   The image view
     * @param path        String path
     * @param base64      base64 string
     * @param context     The context of the activity
     * @param id          placeholder resource id
     */
    public final void loadImageInView(@org.jetbrains.annotations.Nullable
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String base64, @org.jetbrains.annotations.Nullable
    android.content.Context context, int id) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/utils/DecodeImageUtils$Companion;", "", "()V", "ROTATE_180_D", "", "ROTATE_270_D", "ROTATE_90_D", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}