package com.contusfly.views

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.text.style.ReplacementSpan
import android.text.style.TypefaceSpan
import androidx.core.content.res.ResourcesCompat
import kotlin.math.roundToInt

class RoundedBackgroundColorSpan(private val textColor: Int,
                                 private val backgroundColor: Int,
                                  private val fontFamily : Typeface) : ReplacementSpan() {

    private val additionalPadding = 4.toPx().toFloat()
    private val cornerRadius = 4.toPx().toFloat()

        override fun draw(
            canvas: Canvas,
            text: CharSequence,
            start: Int,
            end: Int,
            x: Float,
            top: Int,
            y: Int,
            bottom: Int,
            paint: Paint
        ) {
            val newTop = y + paint.fontMetrics.ascent
            val newBottom = y + paint.fontMetrics.descent
            val rect = RectF(x, newTop, x + measureText(paint, text, start, end) + 2 * additionalPadding, newBottom)
            paint.color = backgroundColor

            canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint)
            paint.typeface = Typeface.create(fontFamily,Typeface.NORMAL)
            paint.color = textColor
            canvas.drawText(text, start, end, x + additionalPadding, y.toFloat(), paint)
        }

        override fun getSize(paint: Paint, text: CharSequence?, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
            return (paint.measureText(text, start, end) + 2 * additionalPadding).roundToInt()
        }

        private fun measureText(paint: Paint, text: CharSequence, start: Int, end: Int): Float {
            return paint.measureText(text, start, end)
        }

        private fun Int.toPx(): Int {
            val resources = Resources.getSystem()
            val metrics = resources.displayMetrics
            return Math.round(this * (metrics.densityDpi / 160.0f))
        }
}
