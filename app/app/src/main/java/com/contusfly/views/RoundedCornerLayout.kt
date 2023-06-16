package com.contusfly.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.LinearLayout

class RoundedCornerLayout : LinearLayout {
    private var mOffscreenBitmap: Bitmap? = null
    private var mOffscreenCanvas: Canvas? = null
    private var mPaint: Paint? = null
    private var mRectF: RectF? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        setWillNotDraw(false)
    }

    override fun draw(canvas: Canvas) {
        if (mOffscreenBitmap == null) {
            mOffscreenBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val mOffscreenBitmapFnl = mOffscreenBitmap
            mOffscreenCanvas = mOffscreenBitmapFnl?.let { Canvas(it) }
            val mBitmapShader =
                mOffscreenBitmapFnl?.let { BitmapShader(it, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP) }
            mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
            mPaint!!.shader = mBitmapShader
            mRectF = RectF(0f, 0f, width.toFloat(), height.toFloat())
        }
        super.draw(mOffscreenCanvas)
        canvas.drawRoundRect(mRectF!!, 50.0f, 50.0f, mPaint!!)
    }
}