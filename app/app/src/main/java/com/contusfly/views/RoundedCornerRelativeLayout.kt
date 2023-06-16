package com.contusfly.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.RelativeLayout

class RoundedCornerRelativeLayout : RelativeLayout {
    private val radius = 10.0f
    private var path: Path? = null
    private var rect: RectF? = null

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
        path = Path()
    }

    override fun onDraw(canvas: Canvas) {
        rect = RectF(0f, 0f, this.width.toFloat(), this.height.toFloat())
        path!!.addRoundRect(rect!!, radius, radius, Path.Direction.CW)
        canvas.clipPath(path!!)
        super.onDraw(canvas)
    }
}