/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView
import com.contusfly.R
import com.mirrorflysdk.utils.Utils

/**
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
object CustomFontUtil {
    /**
     * Set a custom font for the custom [TextView].
     *
     * @param context  The textView's Context.
     * @param attrs    The textView's attribute values.
     * @param textView The textView to which the font should be added.
     */
    fun setTextViewFont(context: Context?, attrs: AttributeSet?, textView: TextView) {
        context?.let {
            val customTypeface = getCustomTypeface(context, attrs)
            if (customTypeface != null) textView.typeface = customTypeface
        }
    }

    /**
     * Set a custom font for the custom [EditText].
     *
     * @param context  The editText's Context.
     * @param attrs    The editText's attribute values.
     * @param editText The editText to which the font should be added.
     */
    fun setEditTextFont(context: Context, attrs: AttributeSet?, editText: EditText) {
        val customTypeface = getCustomTypeface(context, attrs)
        if (customTypeface != null) editText.typeface = customTypeface
    }

    /**
     * Sets the custom typeface and style in which the text should be displayed.
     * Note that not all Typeface families actually have bold and italic
     * variants, so you may need to use
     * [TextView.setTypeface] to get the appearance
     * that you actually want.
     *
     * @param context The View's Context.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    private fun getCustomTypeface(context: Context, attrs: AttributeSet?): Typeface? {
        var typeface = TypefaceFactory.getFontTypeFace(context, "")
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomWidget)
        for (i in 0 until typedArray.indexCount) {
            val attribute = typedArray.getIndex(i)
            if (attribute == R.styleable.CustomWidget_font_name) {
                typeface = TypefaceFactory.getFontTypeFace(context,
                        Utils.returnEmptyStringIfNull(typedArray.getString(attribute)))
            }
        }
        typedArray.recycle()
        return typeface
    }
}