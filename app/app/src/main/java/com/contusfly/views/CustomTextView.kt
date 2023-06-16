/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import com.contusfly.R
import com.contusfly.utils.CustomFontUtil
import io.github.rockerhieu.emojicon.EmojiconTextView

/**
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class CustomTextView : EmojiconTextView {
    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.TextView] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     */
    constructor(context: Context) : super(context) {}

    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.TextView] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        CustomFontUtil.setTextViewFont(context, attrs, this)
        setTextViewAttributes(attrs)
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
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        CustomFontUtil.setTextViewFont(context, attrs, this)
        setTextViewAttributes(attrs)
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
    @SuppressLint("CustomViewStyleable")
    private fun setTextViewAttributes(set: AttributeSet) {
        val a = context.obtainStyledAttributes(set, R.styleable.Emojicon)
        a.recycle()
    }
}