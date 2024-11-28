package com.contusfly.views;

import java.lang.System;

/**
 * Image view to display rounder corner for the image view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 `2\u00020\u0001:\u0003`abB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010/\u001a\u0002002\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u00020\u001eH\u0002J\u0006\u00103\u001a\u000200J\u0014\u00104\u001a\u0004\u0018\u00010\u00122\b\u00105\u001a\u0004\u0018\u000106H\u0002J\b\u00107\u001a\u00020\"H\u0016J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000200H\u0002J\b\u0010;\u001a\u000200H\u0002J\b\u0010<\u001a\u000200H\u0014J\u0010\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020?H\u0014J(\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\tH\u0014J\b\u0010E\u001a\u000200H\u0002J\u0010\u0010F\u001a\u0002002\u0006\u0010G\u001a\u00020&H\u0016J\u0012\u0010H\u001a\u0002002\b\b\u0001\u0010I\u001a\u00020\tH\u0002J\u0010\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\"H\u0016J\u0010\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020\u0012H\u0016J\u0012\u0010N\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u0010O\u001a\u0002002\b\b\u0001\u0010P\u001a\u00020\tH\u0016J\u0012\u0010Q\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J(\u0010T\u001a\u0002002\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\tH\u0016J(\u0010Y\u001a\u0002002\u0006\u0010Z\u001a\u00020\t2\u0006\u0010V\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010X\u001a\u00020\tH\u0016J\u0010\u0010\\\u001a\u0002002\u0006\u0010]\u001a\u000209H\u0016J\b\u0010^\u001a\u000200H\u0002J\b\u0010_\u001a\u000200H\u0002R$\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t8F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006c"}, d2 = {"Lcom/contusfly/views/CircularImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderWidth", "getBorderWidth", "()I", "setBorderWidth", "(I)V", "context1", "mBitmap", "Landroid/graphics/Bitmap;", "mBitmapHeight", "mBitmapPaint", "Landroid/graphics/Paint;", "mBitmapShader", "Landroid/graphics/BitmapShader;", "mBitmapWidth", "mBorderColor", "mBorderPaint", "mBorderRadius", "", "mBorderRect", "Landroid/graphics/RectF;", "mBorderWidth", "mCircleBackgroundPaint", "mColorFilter", "Landroid/graphics/ColorFilter;", "mDrawableRadius", "mDrawableRect", "mReady", "", "mSetupPending", "mShaderMatrix", "Landroid/graphics/Matrix;", "shape", "Lcom/contusfly/views/CircularImageView$Shape;", "userList", "Ljava/util/ArrayList;", "", "addImage", "", "applyColorFilter", "calculateBounds", "clear", "getBitmapFromDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "getColorFilter", "getScaleType", "Landroid/widget/ImageView$ScaleType;", "init", "initializeBitmap", "onAttachedToWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "refresh", "setAdjustViewBounds", "adjustViewBounds", "setBorderColor", "borderColor", "setColorFilter", "cf", "setImageBitmap", "bm", "setImageDrawable", "setImageResource", "resId", "setImageURI", "uri", "Landroid/net/Uri;", "setPadding", "left", "top", "right", "bottom", "setPaddingRelative", "start", "end", "setScaleType", "scaleType", "setup", "updateShaderMatrix", "Companion", "OutlineProvider", "Shape", "app_debug"})
public final class CircularImageView extends androidx.appcompat.widget.AppCompatImageView {
    private final android.graphics.RectF mDrawableRect = null;
    private final android.graphics.RectF mBorderRect = null;
    private final android.graphics.Matrix mShaderMatrix = null;
    private final android.graphics.Paint mBitmapPaint = null;
    private final android.graphics.Paint mBorderPaint = null;
    private final android.graphics.Paint mCircleBackgroundPaint = null;
    private int mBorderColor = -16777216;
    private int mBorderWidth = 0;
    private android.graphics.Bitmap mBitmap;
    private android.graphics.BitmapShader mBitmapShader;
    private int mBitmapWidth = 0;
    private int mBitmapHeight = 0;
    private float mDrawableRadius = 0.0F;
    private float mBorderRadius = 0.0F;
    private android.graphics.ColorFilter mColorFilter;
    private boolean mReady = false;
    private boolean mSetupPending = false;
    private com.contusfly.views.CircularImageView.Shape shape;
    private final java.util.ArrayList<java.lang.String> userList = null;
    private android.content.Context context1;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.views.CircularImageView.Companion Companion = null;
    private static final android.widget.ImageView.ScaleType SCALE_TYPE = android.widget.ImageView.ScaleType.CENTER_CROP;
    private static final android.graphics.Bitmap.Config BITMAP_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_BORDER_COLOR = android.graphics.Color.BLACK;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Instantiates a new circular image view.
     *
     * @param context the startupActivityContext
     */
    public CircularImageView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    /**
     * Instantiates a new circular image view.
     *
     * @param context the startupActivityContext
     * @param attrs   the attrs
     */
    public CircularImageView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    /**
     * Instantiates a new circular image view.
     *
     * @param context  the startupActivityContext
     * @param attrs    the attrs
     * @param defStyle the def style
     */
    public CircularImageView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyle) {
        super(null);
    }
    
    /**
     * method to initialize view
     */
    private final void init() {
    }
    
    @java.lang.Override
    protected void onAttachedToWindow() {
    }
    
    /**
     * recreate CustomMultiDrawable and set it as Bitmaps to ImageView
     */
    private final void refresh() {
    }
    
    /**
     * Remove all previous bitmaps
     */
    public final void clear() {
    }
    
    /**
     * to get scale type of an image
     *
     * @return the [ScaleType]
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.widget.ImageView.ScaleType getScaleType() {
        return null;
    }
    
    /**
     * Set scale type of an image
     *
     * @param scaleType enum to set
     */
    @java.lang.Override
    public void setScaleType(@org.jetbrains.annotations.NotNull
    android.widget.ImageView.ScaleType scaleType) {
    }
    
    /**
     * Set this to true if you want the ImageView to adjust its bounds
     * to preserve the aspect ratio of its drawable.
     *
     * @param adjustViewBounds Whether to adjust the bounds of this view
     * to preserve the original aspect ratio of the drawable.
     */
    @java.lang.Override
    public void setAdjustViewBounds(boolean adjustViewBounds) {
    }
    
    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @java.lang.Override
    protected void onDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    @java.lang.Override
    public void setPadding(int left, int top, int right, int bottom) {
    }
    
    @java.lang.Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
    }
    
    private final void setBorderColor(@androidx.annotation.ColorInt
    int borderColor) {
    }
    
    public final int getBorderWidth() {
        return 0;
    }
    
    private final void setBorderWidth(int borderWidth) {
    }
    
    @java.lang.Override
    public void setImageBitmap(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bm) {
    }
    
    @java.lang.Override
    public void setImageDrawable(@org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable drawable) {
    }
    
    @java.lang.Override
    public void setImageResource(@androidx.annotation.DrawableRes
    int resId) {
    }
    
    @java.lang.Override
    public void setImageURI(@org.jetbrains.annotations.Nullable
    android.net.Uri uri) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.graphics.ColorFilter getColorFilter() {
        return null;
    }
    
    @java.lang.Override
    public void setColorFilter(@org.jetbrains.annotations.NotNull
    android.graphics.ColorFilter cf) {
    }
    
    private final void applyColorFilter() {
    }
    
    private final android.graphics.Bitmap getBitmapFromDrawable(android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    private final void initializeBitmap() {
    }
    
    private final void setup() {
    }
    
    private final android.graphics.RectF calculateBounds() {
        return null;
    }
    
    private final void updateShaderMatrix() {
    }
    
    public final void addImage(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<java.lang.String> userList) {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.LOLLIPOP)
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0083\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/views/CircularImageView$OutlineProvider;", "Landroid/view/ViewOutlineProvider;", "(Lcom/contusfly/views/CircularImageView;)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "app_debug"})
    final class OutlineProvider extends android.view.ViewOutlineProvider {
        
        public OutlineProvider() {
            super();
        }
        
        @java.lang.Override
        public void getOutline(@org.jetbrains.annotations.NotNull
        android.view.View view, @org.jetbrains.annotations.NotNull
        android.graphics.Outline outline) {
        }
    }
    
    /**
     * Enum for CircleImageView Shape
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/views/CircularImageView$Shape;", "", "(Ljava/lang/String;I)V", "CIRCLE", "RECTANGLE", "NONE", "app_debug"})
    public static enum Shape {
        /*public static final*/ CIRCLE /* = new CIRCLE() */,
        /*public static final*/ RECTANGLE /* = new RECTANGLE() */,
        /*public static final*/ NONE /* = new NONE() */;
        
        Shape() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/views/CircularImageView$Companion;", "", "()V", "BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "COLORDRAWABLE_DIMENSION", "", "DEFAULT_BORDER_COLOR", "DEFAULT_BORDER_WIDTH", "SCALE_TYPE", "Landroid/widget/ImageView$ScaleType;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}