package com.contusfly.views

import android.content.Context
import android.text.Layout
import android.util.AttributeSet
import com.contusfly.R
import com.contusfly.utils.CustomFontUtil
import io.github.rockerhieu.emojicon.EmojiconTextView

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class MessageTextView : EmojiconTextView {

    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.TextView] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     */
    constructor(context: Context?) : super(context)

    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.TextView] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        CustomFontUtil.setTextViewFont(context, attrs, this)
        attrs?.let { setTextViewAttributes(it) }
    }

    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.TextView] object.
     *
     * @param context      The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     * reference to a style resource that supplies default values for
     * the view.
     */
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        CustomFontUtil.setTextViewFont(context, attrs, this)
        attrs?.let { setTextViewAttributes(it) }
    }

    /**
     * Return a TypedArray holding the attribute values in
     * <var>set</var>
     * that are listed in <var>attrs</var>.  In addition, if the given
     * AttributeSet specifies a style class (through the "style" attribute),
     * that style will be applied on top of the base attributes it defines.
     *
     * @param set The base set of attribute values.
     */
    private fun setTextViewAttributes(set: AttributeSet) {
        val a = context.obtainStyledAttributes(set, R.styleable.Emojicon)
        a.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val layout = layout
        if (layout != null) {
            val width = (Math.ceil(getMaxLineWidth(layout).toDouble()).toInt()
                    + compoundPaddingLeft + compoundPaddingRight)
            val height = measuredHeight
            setMeasuredDimension(width, height)
        }
    }

    private fun getMaxLineWidth(layout: Layout): Float {
        var maxWidth = 0.0f
        val lines = layout.lineCount
        for (i in 0 until lines) {
            if (layout.getLineWidth(i) > maxWidth) {
                maxWidth = layout.getLineWidth(i)
            }
        }
        return maxWidth
    }

}