package com.contusfly.utils;

import java.lang.System;

/**
 * This class is used to get the thumb size of the image from the bitmap
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/contusfly/utils/ThumbSize;", "", "()V", "getThbSize", "", "bitmap", "Landroid/graphics/Bitmap;", "type", "resizeBitmap", "bitmapWidth", "thbSize", "resizeImage", "Companion", "app_debug"})
public final class ThumbSize {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.ThumbSize.Companion Companion = null;
    
    /**
     * Stream type
     */
    public static final int TYPE_STREAM = 1;
    
    /**
     * Thumb image size for 100
     */
    public static final int THUMB_100 = 100;
    
    /**
     * Bitmap type
     */
    private static final int TYPE_BITMAP = 2;
    
    /**
     * Size of the thumb image 120
     */
    private static final int THUMB_120 = 120;
    
    /**
     * Width size of the media 120
     */
    private static final int WIDTH_200 = 200;
    
    /**
     * Width size of the media 500
     */
    private static final int WIDTH_500 = 500;
    
    /**
     * Width size of the media 1000
     */
    private static final int WIDTH_1000 = 1000;
    
    /**
     * Width size of the media 2000
     */
    private static final int WIDTH_2000 = 2000;
    
    /**
     * Width size of the media 4000
     */
    private static final int WIDTH_4000 = 400;
    
    /**
     * Thumb image size for 64
     */
    private static final int THUMB_64 = 64;
    
    /**
     * Thumb image size for 200
     */
    private static final int THUMB_200 = 200;
    
    /**
     * Thumb image size for 150
     */
    private static final int THUMB_150 = 150;
    
    /**
     * Thumb image size for 250
     */
    private static final int THUMB_250 = 250;
    
    /**
     * Thumb image size for 300
     */
    private static final int THUMB_300 = 300;
    
    /**
     * Thumb image size for 400
     */
    private static final int THUMB_400 = 400;
    
    /**
     * Thumb image size for 450
     */
    private static final int THUMB_450 = 450;
    
    public ThumbSize() {
        super();
    }
    
    /**
     * Gets the thumb size of the image.
     *
     * @param bitmap Bitmap of image
     * @param type   Image type
     * @return int Thumb size
     */
    public final int getThbSize(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap, int type) {
        return 0;
    }
    
    /**
     * Resize the bitmap image
     *
     * @param bitmapWidth Width of the Image
     * @param thbSize     The thumb size of image
     * @return int Size of bitmap
     */
    private final int resizeBitmap(int bitmapWidth, int thbSize) {
        return 0;
    }
    
    /**
     * Resize image the original image
     *
     * @param bitmapWidth Width of the bitmap
     * @return int Thumb size
     */
    private final int resizeImage(int bitmapWidth) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/utils/ThumbSize$Companion;", "", "()V", "THUMB_100", "", "THUMB_120", "THUMB_150", "THUMB_200", "THUMB_250", "THUMB_300", "THUMB_400", "THUMB_450", "THUMB_64", "TYPE_BITMAP", "TYPE_STREAM", "WIDTH_1000", "WIDTH_200", "WIDTH_2000", "WIDTH_4000", "WIDTH_500", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}