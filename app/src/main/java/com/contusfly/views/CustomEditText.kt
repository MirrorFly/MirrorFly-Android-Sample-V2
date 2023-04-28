/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.views

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.widget.AppCompatEditText
import com.contusfly.utils.CustomFontUtil
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.view.KeyEvent
import com.contusfly.R

/**
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class CustomEditText : AppCompatEditText {
    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.EditText] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     */
    constructor(context: Context?) : super(context!!) {}

    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.EditText] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        CustomFontUtil.setEditTextFont(context, attrs, this)
        setEditTextAttributes(attrs)
    }

    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.EditText] object.
     *
     * @param context      The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     * reference to a style resource that supplies default values for
     * the view.
     */
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr) {
        CustomFontUtil.setEditTextFont(context, attrs, this)
        setEditTextAttributes(attrs)
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
    private fun setEditTextAttributes(set: AttributeSet?) {
        val a = context.obtainStyledAttributes(set, R.styleable.Emojicon)
        a.recycle()
    }

    /**
     * Sets the text to be displayed.
     *
     * @param text The text to be displayed.
     * @param type The [BufferType] which defines whether the text is
     * stored as a static text, styleable/spannable text, or editable text.
     */
    override fun setText(text: CharSequence, type: BufferType) {
        val builder = SpannableStringBuilder(text)
        super.setText(builder, type)
    }

    /**
     * Handle a key event before it is processed by any input method
     * associated with the view hierarchy.  This can be used to intercept
     * key events in special situations before the IME consumes them; a
     * typical example would be handling the BACK key to update the application's
     * UI instead of allowing the IME to see it and close itself.
     *
     * @param keyCode The value in event.getKeyCode().
     * @param event   Description of the key event.
     * @return true if handled the event.
     */
    override fun onKeyPreIme(keyCode: Int, event: KeyEvent): Boolean {
        return ((keyCode != KeyEvent.KEYCODE_BACK || event.action != KeyEvent.ACTION_UP)
                && super.onKeyPreIme(keyCode, event))
    }
}