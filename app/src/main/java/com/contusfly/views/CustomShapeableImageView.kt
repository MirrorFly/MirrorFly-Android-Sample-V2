package com.contusfly.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import com.contusfly.TAG
import com.contusfly.utils.LogMessage
import com.google.android.material.imageview.ShapeableImageView
import java.lang.Exception

class CustomShapeableImageView : ShapeableImageView {
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?) : super(context) {}

    override fun onDraw(canvas: Canvas) {
        try {
            super.onDraw(canvas)
        } catch (e: Exception) {
            LogMessage.i(TAG, "Catch Canvas: trying to use a recycled bitmap")
        }
    }
}