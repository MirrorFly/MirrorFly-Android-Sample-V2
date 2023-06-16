package com.contusfly.utils;

import java.lang.System;

/**
 * This class used to decode the images...
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\fJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0007J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\bJ\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\b2\b\u0010\'\u001a\u0004\u0018\u00010\bJ \u0010(\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\bH\u0002J*\u0010(\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\nH\u0002J(\u0010(\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0004J&\u0010-\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\bJ0\u0010-\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\nJ0\u0010-\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0004J*\u0010/\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\nJ(\u0010/\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020*2\u0006\u0010+\u001a\u00020\bJ.\u0010/\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u00101\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\nJ,\u0010/\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u00101\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u0004J,\u0010/\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00102\u001a\u0004\u0018\u00010\u00142\b\u00101\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u0004J*\u0010/\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00100\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0004J.\u00103\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00104\u001a\u0004\u0018\u00010\b2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u00105\u001a\u0004\u0018\u00010\bJ*\u00106\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00100\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0004J\u001e\u00107\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\bJ*\u00108\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00100\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0004J\u001e\u00109\u001a\u0004\u0018\u00010\u00122\b\u0010:\u001a\u0004\u0018\u00010\u00122\b\u00104\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u000b\u001a\u00020>H\u0002J \u0010?\u001a\u00020\b2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u000b\u001a\u00020>2\u0006\u0010\u0010\u001a\u00020\bH\u0002J \u0010@\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020>2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010A\u001a\u00020BR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Lcom/contusfly/utils/ImageUtils;", "", "()V", "ROTATE_180_D", "", "ROTATE_270_D", "ROTATE_90_D", "TAG", "", "copyDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawable", "createFolderIfNotExist", "", "path", "decodeStream", "Landroid/graphics/Bitmap;", "fil", "Ljava/io/File;", "selectedImage", "Landroid/net/Uri;", "mContext", "getByteArray", "", "bitmap", "getCompressedBitmapData", "maxFileSize", "maxDimensions", "getFile", "extension", "getImageFile", "getImageThumbImage", "imagePath", "getResizedBitmap", "image", "maxSize", "getVideoThumbImage", "videoPath", "loadBase64", "imageView", "Landroid/widget/ImageView;", "base64", "errorImg", "loadImageInView", "id", "loadImageWithGlide", "imgUrl", "imgView", "imgFile", "loadImageWithoutFlickering", "imageUrl", "oldImageUrl", "loadMapWithGlide", "loadReceiverVideoImageInView", "loadVideoThumbnail", "rotateImage", "bmp", "startIntentForCropPhoto", "intent", "Landroid/content/Intent;", "Landroid/app/Activity;", "startIntentForPhoto", "takePhotoFromCamera", "isCropImage", "", "app_debug"})
public final class ImageUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.ImageUtils INSTANCE = null;
    private static final java.lang.String TAG = "ImageUtils";
    
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
    
    private ImageUtils() {
        super();
    }
    
    /**
     * Converts URL into the bitmap
     *
     * @param fil           Local file
     * @param selectedImage Uri of the selected image
     * @param mContext      Application startupActivityContext
     * @return Bitmap Bitmap of the image
     */
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap decodeStream(@org.jetbrains.annotations.NotNull()
    java.io.File fil, @org.jetbrains.annotations.Nullable()
    android.net.Uri selectedImage, @org.jetbrains.annotations.NotNull()
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
     * @param context   The startupActivityContext of the activity
     * @param path      String path
     * @param imageView The image view
     * @param base64    base64 string
     * @param id        placeholder resource id
     */
    public final void loadImageInView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String base64, int id) {
    }
    
    /**
     * Load image in view with [Drawable] as a placeholder.
     *
     * @param context   The startupActivityContext of the activity
     * @param path      String path
     * @param imageView The image view
     * @param base64    base64 string
     * @param drawable  placeholder drawable
     */
    public final void loadImageInView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String base64, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable drawable) {
    }
    
    /**
     * Load image in view with [Drawable] as a placeholder.
     *
     * @param context   The startupActivityContext of the activity
     * @param path      String path
     * @param imageView The image view
     * @param base64    base64 string
     */
    public final void loadImageInView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String base64) {
    }
    
    /**
     * Load image in view with [Drawable] as a placeholder.
     *
     * @param context   The startupActivityContext of the activity
     * @param imageView The image view
     * @param base64    base64 string
     */
    public final void loadReceiverVideoImageInView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String base64) {
    }
    
    /**
     * Load base64 of the image into image view
     *
     * @param context   startupActivityContext instance
     * @param imageView Image view to load
     * @param base64    Base64 string
     */
    public final void loadBase64(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String base64, int errorImg) {
    }
    
    /**
     * Load base64 of the image into image view with [Drawable] as a placeholder
     *
     * @param context   startupActivityContext instance
     * @param imageView Image view to load
     * @param base64    Base64 string
     */
    private final void loadBase64(android.content.Context context, android.widget.ImageView imageView, java.lang.String base64, android.graphics.drawable.Drawable errorImg) {
    }
    
    /**
     * Load base64 of the image into image view with [Drawable] as a placeholder
     *
     * @param context   startupActivityContext instance
     * @param imageView Image view to load
     * @param base64    Base64 string
     */
    private final void loadBase64(android.content.Context context, android.widget.ImageView imageView, java.lang.String base64) {
    }
    
    /**
     * Load image with glide.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgUrl   Image uri
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    public final void loadImageWithGlide(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgView, int errorImg) {
    }
    
    /**
     * Load image with glide.
     *
     * @param context  Instance of the context
     * @param imgUrl   Image uri
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    public final void loadMapWithGlide(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgView, int errorImg) {
    }
    
    /**
     * Load local video thumbnail image with glide.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgUrl   Image uri
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    public final void loadVideoThumbnail(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgView, int errorImg) {
    }
    
    /**
     * Load image with glide.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgFile  Local path
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    public final void loadImageWithGlide(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.io.File imgFile, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView imgView, int errorImg) {
    }
    
    /**
     * Load Bitmap image with glide.
     *
     * @param context  Instance of the startupActivityContext
     * @param bitmap   Local path
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    public final void loadImageWithGlide(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView imgView, int errorImg) {
    }
    
    /**
     * Load Bitmap image with glide with [Drawable] as a placeholder.
     *
     * @param context  Instance of the startupActivityContext
     * @param bitmap   Local path
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    public final void loadImageWithGlide(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView imgView, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable errorImg) {
    }
    
    /**
     * Load image with glide with [Drawable] as a placeholder.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgUrl   image url
     * @param imgView  Image view to display the image
     * @param errorImg Display the drawable, if url return null
     */
    public final void loadImageWithGlide(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgView, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable errorImg) {
    }
    
    /**
     * Load image with glide with [Drawable] as a placeholder.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgUrl   image url
     * @param imgView  Image view to display the image
     * @param base64  Base64 thump image string
     */
    public final void loadImageWithGlide(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imgView, @org.jetbrains.annotations.NotNull()
    java.lang.String base64) {
    }
    
    /**
     * Loads image into an image view without flickering
     *
     * @param context     context
     * @param imageUrl    image url to be loaded
     * @param imageView   target image view
     * @param oldImageUrl old image url
     */
    public final void loadImageWithoutFlickering(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String oldImageUrl) {
    }
    
    /**
     * This method copyFiles the bitmap from drawable which is got from image view
     * [ImageView.getDrawable] and creates new [BitmapDrawable]
     * and returns it.
     *
     *
     * This BitmapDrawable is used to avoid the bitmap recycled exception while using drawable
     * as a placeholder
     *
     * @param context  context
     * @param drawable drawable from image
     * @return [BitmapDrawable]
     */
    private final android.graphics.drawable.Drawable copyDrawable(android.content.Context context, android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    /**
     * Start the intent with the photo url path and ask for camera permission
     *
     * @param intent  Instance of the intent with data
     * @param context Instance of the Context
     * @param path    Photo path
     * @return String Path of the image
     */
    private final java.lang.String startIntentForPhoto(android.content.Intent intent, android.app.Activity context, java.lang.String path) {
        return null;
    }
    
    /**
     * Returns image file
     *
     * @param path Path of the parent folder
     * @return File New image file
     */
    private final java.io.File getImageFile(java.lang.String path) {
        return null;
    }
    
    /**
     * Returns image file for the given file path and extension
     *
     * @param path      Path of the parent folder
     * @param extension File extension
     * @return File New image file
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final java.io.File getFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String extension) {
        return null;
    }
    
    /**
     * Creates folder if not exist
     *
     * @param path Path of the folder
     */
    private final void createFolderIfNotExist(java.lang.String path) {
    }
    
    /**
     * Take photo from camera for sending the photo to the receiver.
     *
     * @param context     Application startupActivityContext
     * @param path        Image url
     * @param isCropImage True if the image crop
     * @return String Path of the image
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String takePhotoFromCamera(@org.jetbrains.annotations.NotNull()
    android.app.Activity context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, boolean isCropImage) {
        return null;
    }
    
    /**
     * Start the intent with the temp path to store and crop the image
     *
     * @param intent  Instance of the intent with data
     * @param context Instance of the Context
     */
    private final void startIntentForCropPhoto(android.content.Intent intent, android.app.Activity context) {
    }
    
    /**
     * Get image thumb image String.
     *
     * @param imagePath Path of image.
     * @return String, Thumb image Base64.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageThumbImage(@org.jetbrains.annotations.Nullable()
    java.lang.String imagePath) {
        return null;
    }
    
    /**
     * Get video thumb image String.
     *
     * @param videoPath Path of video.
     * @return String, Thumb image Base64.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVideoThumbImage(@org.jetbrains.annotations.Nullable()
    java.lang.String videoPath) {
        return null;
    }
    
    private final byte[] getCompressedBitmapData(android.graphics.Bitmap bitmap, int maxFileSize, int maxDimensions) {
        return null;
    }
    
    private final android.graphics.Bitmap getResizedBitmap(android.graphics.Bitmap image, int maxSize) {
        return null;
    }
    
    private final byte[] getByteArray(android.graphics.Bitmap bitmap) {
        return null;
    }
}