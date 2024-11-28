package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J2\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J*\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ.\u0010\u001b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J,\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0007J*\u0010\u001c\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0013J.\u0010\u001c\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001f\u001a\u00020\u0013H\u0007J,\u0010\u001c\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0013H\u0007J,\u0010$\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0013H\u0007J,\u0010%\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aJ,\u0010&\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0013H\u0007J4\u0010\'\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\nJ4\u0010(\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010*\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006,"}, d2 = {"Lcom/contusfly/utils/MediaUtils;", "", "()V", "tokenError", "", "getTokenError", "()Ljava/lang/String;", "dismissProgressDialog", "", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "extendedLoadImageInView", "imageView", "Landroid/widget/ImageView;", "path", "base64", "context", "Landroid/content/Context;", "id", "", "getSentPath", "folderName", "loadBase64", "loadImage", "imageUrl", "defaultImage", "Landroid/graphics/drawable/Drawable;", "loadImageInView", "loadImageWithGlide", "imgUrl", "imgView", "errorImg", "frame", "Landroid/graphics/Bitmap;", "imgFile", "Ljava/io/File;", "loadImageWithGlideAnimate", "loadImageWithGlideSecure", "loadImageWithGlideSkipCache", "loadImageWithLoader", "loadThumbImage", "thumbImageUrl", "openMediaFile", "filePath", "app_debug"})
public final class MediaUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.MediaUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String tokenError = "Token refresh error";
    
    private MediaUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTokenError() {
        return null;
    }
    
    /**
     * Load image with [Drawable] as a placeholder.
     *
     * @param context  Instance of the context
     * @param imageUrl   image url
     * @param imageView  Image view to display the image
     * @param defaultImage Display the drawable, if url return null
     */
    public final void loadImage(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable defaultImage) {
    }
    
    /**
     * Load Original image with thumbnail image as a placeholder.
     *
     * @param context  Instance of the context
     * @param imageUrl   image url
     * @param thumbImageUrl thumbImage url
     * @param imageView  Image view to display the image
     * @param defaultImage Display the drawable, if url return null
     */
    public final void loadThumbImage(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable
    java.lang.String thumbImageUrl, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable defaultImage) {
    }
    
    /**
     * Load local image with glide with [Drawable] as a placeholder.
     *
     * @param context  Instance of the context
     * @param imgUrl   image url
     * @param imgView  Image view to display the image
     * @param errorImg Display the drawable, if url return null
     */
    @kotlin.jvm.JvmStatic
    public static final void loadImageWithGlide(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imgView, @org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable errorImg) {
    }
    
    /**
     * Load image with glide.
     *
     * @param context  Instance of the context
     * @param imgFile  Local path
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    @kotlin.jvm.JvmStatic
    public static final void loadImageWithGlide(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.io.File imgFile, @org.jetbrains.annotations.Nullable
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
    @kotlin.jvm.JvmStatic
    public static final void loadImageWithGlide(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull
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
    @kotlin.jvm.JvmStatic
    public static final void loadImageWithGlideAnimate(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imgView, int errorImg) {
    }
    
    /**
     * Open media file using intent action view
     *
     * @param context  Application context
     * @param filePath The file path
     */
    @kotlin.jvm.JvmStatic
    public static final void openMediaFile(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String filePath) {
    }
    
    public final void loadImageWithLoader(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable defaultImage, @org.jetbrains.annotations.Nullable
    com.contusfly.views.DoProgressDialog progressDialog) {
    }
    
    private final void dismissProgressDialog(com.contusfly.views.DoProgressDialog progressDialog) {
    }
    
    /**
     * Load image with glide with [Drawable] as a placeholder.
     *
     * @param context  Instance of the context
     * @param imgUrl   image url
     * @param imgView  Image view to display the image
     * @param errorImg Display the drawable, if url return null
     */
    public final void loadImageWithGlideSecure(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imgView, @org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable errorImg) {
    }
    
    /**
     * Returns sent local folder path from app folder
     *
     * @param folderName Folder name
     * @return String Sent folder path for media
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSentPath(@org.jetbrains.annotations.NotNull
    java.lang.String folderName) {
        return null;
    }
    
    /**
     * Load image with glide.
     *
     * @param context  Instance of the context
     * @param imgUrl   Image uri
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    @kotlin.jvm.JvmStatic
    public static final void loadImageWithGlideSkipCache(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imgView, int errorImg) {
    }
    
    public final void loadImageWithGlide(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.graphics.Bitmap frame, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imgView, int errorImg) {
    }
    
    /**
     * Load image in view.
     *
     * @param imageView   The image view
     * @param path        String path
     * @param base64      base64 string
     * @param messageType Message Type
     * @param context     The context of the activity
     * @param id          placeholder resource id
     */
    public final void loadImageInView(@org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String base64, @org.jetbrains.annotations.NotNull
    android.content.Context context, int id) {
    }
    
    public final void extendedLoadImageInView(@org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String base64, @org.jetbrains.annotations.Nullable
    android.content.Context context, int id) {
    }
    
    /**
     * Load base64 of the image into image view
     *
     * @param imageView Image view to load
     * @param base64    Base64 string
     */
    private final void loadBase64(android.widget.ImageView imageView, java.lang.String base64) {
    }
}