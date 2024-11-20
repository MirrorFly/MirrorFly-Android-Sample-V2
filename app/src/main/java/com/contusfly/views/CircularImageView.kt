/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.views

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.call.groupcall.utils.CustomMultiDrawable
import java.util.*

/**
 * Image view to display rounder corner for the image view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class CircularImageView : AppCompatImageView {
    private val mDrawableRect = RectF()
    private val mBorderRect = RectF()
    private val mShaderMatrix = Matrix()
    private val mBitmapPaint = Paint()
    private val mBorderPaint = Paint()
    private val mCircleBackgroundPaint = Paint()
    private var mBorderColor = DEFAULT_BORDER_COLOR
    private var mBorderWidth = DEFAULT_BORDER_WIDTH
    private var mBitmap: Bitmap? = null
    private var mBitmapShader: BitmapShader? = null
    private var mBitmapWidth = 0
    private var mBitmapHeight = 0
    private var mDrawableRadius = 0f
    private var mBorderRadius = 0f
    private var mColorFilter: ColorFilter? = null
    private var mReady = false
    private var mSetupPending = false
    private var shape: Shape? = null
    private val userList = ArrayList<String>()
    private var context1: Context

    /**
     * Instantiates a new circular image view.
     *
     * @param context the startupActivityContext
     */
    constructor(context: Context) : super(context) {
        this.context1 = context
        init()
    }

    /**
     * Instantiates a new circular image view.
     *
     * @param context the startupActivityContext
     * @param attrs   the attrs
     */
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        this.context1 = context
    }

    /**
     * Instantiates a new circular image view.
     *
     * @param context  the startupActivityContext
     * @param attrs    the attrs
     * @param defStyle the def style
     */
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        this.context1 = context
        val attributes = context.obtainStyledAttributes(attrs,
                R.styleable.CircularImageView, defStyle, 0)
        if (attributes.getBoolean(R.styleable.CircularImageView_border, true)) {
            borderWidth = attributes.getDimensionPixelOffset(R.styleable.CircularImageView_border_width, 0)
            setBorderColor(attributes.getColor(R.styleable.CircularImageView_border_color, Color.WHITE))
        }
        mBorderWidth = attributes.getDimensionPixelSize(R.styleable.CircularImageView_border_width,
                DEFAULT_BORDER_WIDTH)
        mBorderColor = attributes.getColor(R.styleable.CircularImageView_border_color, Color.WHITE)
        shape = if (attributes.getBoolean(R.styleable.CircularImageView_is_circle, true)) Shape.CIRCLE else Shape.RECTANGLE
        attributes.recycle()
        init()
    }

    /**
     * method to initialize view
     */
    private fun init() {
        super.setScaleType(SCALE_TYPE)
        mReady = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            outlineProvider = OutlineProvider()
        }
        if (mSetupPending) {
            setup()
            mSetupPending = false
        }
        borderWidth = 1
        setBorderColor(Color.LTGRAY)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (shape == Shape.RECTANGLE) refresh()
    }

    /**
     * recreate CustomMultiDrawable and set it as Bitmaps to ImageView
     */
    private fun refresh() {
        val customDrawable: Drawable = CustomMultiDrawable(userList, context1)
        setImageDrawable(customDrawable)
    }

    /**
     * Remove all previous bitmaps
     */
    fun clear() {
        userList.clear()
        refresh()
    }

    /**
     * to get scale type of an image
     *
     * @return the [ScaleType]
     */
    override fun getScaleType(): ScaleType {
        return SCALE_TYPE
    }

    /**
     * Set scale type of an image
     *
     * @param scaleType enum to set
     */
    override fun setScaleType(scaleType: ScaleType) {
        require(scaleType == SCALE_TYPE) { String.format("ScaleType %s not supported.", scaleType) }
    }

    /**
     * Set this to true if you want the ImageView to adjust its bounds
     * to preserve the aspect ratio of its drawable.
     *
     * @param adjustViewBounds Whether to adjust the bounds of this view
     * to preserve the original aspect ratio of the drawable.
     */
    override fun setAdjustViewBounds(adjustViewBounds: Boolean) {
        require(!adjustViewBounds) { "adjustViewBounds not supported." }
    }

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    override fun onDraw(canvas: Canvas) {
        try {
            if (shape == Shape.RECTANGLE) {
                if (drawable != null) {
                   super.onDraw(canvas)
                }
            } else {
                if (mBitmap == null) {
                    return
                }
                canvas.drawCircle(mDrawableRect.centerX(), mDrawableRect.centerY(), mDrawableRadius, mBitmapPaint)
                if (mBorderWidth > 0) {
                    canvas.drawCircle(mBorderRect.centerX(), mBorderRect.centerY(), mBorderRadius, mBorderPaint)
                }
            }
        } catch (e: Exception) {
            LogMessage.i(TAG, "Catch Canvas: trying to use a recycled bitmap")
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (shape != Shape.RECTANGLE) setup()
    }

    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        super.setPadding(left, top, right, bottom)
        if (shape != Shape.RECTANGLE) setup()
    }

    override fun setPaddingRelative(start: Int, top: Int, end: Int, bottom: Int) {
        super.setPaddingRelative(start, top, end, bottom)
        if (shape != Shape.RECTANGLE) setup()
    }

    private fun setBorderColor(@ColorInt borderColor: Int) {
        if (borderColor == mBorderColor) {
            return
        }
        mBorderColor = borderColor
        mBorderPaint.color = mBorderColor
        invalidate()
    }

    var borderWidth: Int
        get() = mBorderWidth
        private set(borderWidth) {
            if (borderWidth == mBorderWidth) {
                return
            }
            mBorderWidth = borderWidth
            setup()
        }

    override fun setImageBitmap(bm: Bitmap) {
        super.setImageBitmap(bm)
        if (shape != Shape.RECTANGLE) initializeBitmap()
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        if (shape != Shape.RECTANGLE) initializeBitmap()
    }

    override fun setImageResource(@DrawableRes resId: Int) {
        super.setImageResource(resId)
        if (shape != Shape.RECTANGLE) initializeBitmap()
    }

    override fun setImageURI(uri: Uri?) {
        super.setImageURI(uri)
        if (shape != Shape.RECTANGLE) initializeBitmap()
    }

    override fun getColorFilter(): ColorFilter {
        return mColorFilter!!
    }

    override fun setColorFilter(cf: ColorFilter) {
        if (cf === mColorFilter) {
            return
        }
        mColorFilter = cf
        applyColorFilter()
        invalidate()
    }

    private fun applyColorFilter() {
        mBitmapPaint.colorFilter = mColorFilter
    }

    private fun getBitmapFromDrawable(drawable: Drawable?): Bitmap? {
        if (drawable == null) {
            return null
        }
        return if (drawable is BitmapDrawable) {
            drawable.bitmap
        } else try {
            val bitmap: Bitmap
            bitmap = if (drawable is ColorDrawable) {
                Bitmap.createBitmap(COLORDRAWABLE_DIMENSION, COLORDRAWABLE_DIMENSION, BITMAP_CONFIG)
            } else {
                Bitmap.createBitmap(drawable.intrinsicWidth,
                        drawable.intrinsicHeight, BITMAP_CONFIG)
            }
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
            bitmap
        } catch (e: Exception) {
            LogMessage.e(e)
            null
        }
    }

    private fun initializeBitmap() {
        mBitmap = getBitmapFromDrawable(drawable)
        setup()
    }

    private fun setup() {
        if (!mReady) {
            mSetupPending = true
            return
        }
        if (width == 0 && height == 0) {
            return
        }
        if (mBitmap == null) {
            invalidate()
            return
        }
        if (mBitmap!!.isRecycled) {
            LogMessage.e("#circularImageView","bitmap is recycled--->")
            return
        }
        mBitmapShader = BitmapShader(mBitmap!!, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mBitmapPaint.isAntiAlias = true
        mBitmapPaint.shader = mBitmapShader
        mBorderPaint.style = Paint.Style.STROKE
        mBorderPaint.isAntiAlias = true
        mBorderPaint.color = mBorderColor
        mBorderPaint.strokeWidth = mBorderWidth.toFloat()
        mCircleBackgroundPaint.style = Paint.Style.FILL
        mCircleBackgroundPaint.isAntiAlias = true
        mBitmapHeight = mBitmap!!.height
        mBitmapWidth = mBitmap!!.width
        mBorderRect.set(calculateBounds())
        mBorderRadius = Math.min((mBorderRect.height() - mBorderWidth) / 2.0f,
                (mBorderRect.width() - mBorderWidth) / 2.0f)
        mDrawableRect.set(mBorderRect)
        mDrawableRadius = Math.min(mDrawableRect.height() / 2.0f, mDrawableRect.width() / 2.0f)
        applyColorFilter()
        updateShaderMatrix()
        invalidate()
    }

    private fun calculateBounds(): RectF {
        val availableWidth = width - paddingLeft - paddingRight
        val availableHeight = height - paddingTop - paddingBottom
        val sideLength = Math.min(availableWidth, availableHeight)
        val left = paddingLeft + (availableWidth - sideLength) / 2f
        val top = paddingTop + (availableHeight - sideLength) / 2f
        return RectF(left, top, left + sideLength, top + sideLength)
    }

    private fun updateShaderMatrix() {
        val scale: Float
        var dx = 0f
        var dy = 0f
        mShaderMatrix.set(null)
        if (mBitmapWidth * mDrawableRect.height() > mDrawableRect.width() * mBitmapHeight) {
            scale = mDrawableRect.height() / mBitmapHeight.toFloat()
            dx = (mDrawableRect.width() - mBitmapWidth * scale) * 0.5f
        } else {
            scale = mDrawableRect.width() / mBitmapWidth.toFloat()
            dy = (mDrawableRect.height() - mBitmapHeight * scale) * 0.5f
        }
        mShaderMatrix.setScale(scale, scale)
        mShaderMatrix.postTranslate((dx + 0.5f).toInt() + mDrawableRect.left, (dy + 0.5f).toInt() + mDrawableRect.top)
        mBitmapShader!!.setLocalMatrix(mShaderMatrix)
    }

    fun addImage(userList: ArrayList<String>?) {
        this.userList.clear()
        this.userList.addAll(userList!!.filter { it.isNotEmpty() })
        refresh()
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private inner class OutlineProvider : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            val bounds = Rect()
            mBorderRect.roundOut(bounds)
            outline.setRoundRect(bounds, bounds.width() / 2.0f)
        }
    }

    /**
     * Enum for CircleImageView Shape
     */
    enum class Shape {
        CIRCLE, RECTANGLE, NONE
    }

    companion object {
        private val SCALE_TYPE = ScaleType.CENTER_CROP
        private val BITMAP_CONFIG = Bitmap.Config.ARGB_8888
        private const val COLORDRAWABLE_DIMENSION = 2
        private const val DEFAULT_BORDER_WIDTH = 0
        private const val DEFAULT_BORDER_COLOR = Color.BLACK
    }
}