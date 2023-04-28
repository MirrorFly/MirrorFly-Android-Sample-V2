package com.contusfly.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import com.contusfly.R

/**
 * numeric keyboard for pin activity
 */
class CustomNumericKeyboard : FrameLayout, View.OnClickListener {
    private var mPasswordField: EditText? = null

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    ) {
        init()
    }

    /**
     * This method is to inflate the view
     */
    private fun init() {
        inflate(context, R.layout.keyboard, this)
        initViews()
    }

    fun getmPasswordField(): EditText? {
        return mPasswordField
    }

    fun setmPasswordField(mPasswordField: EditText?) {
        this.mPasswordField = mPasswordField
    }

    /**
     * This method is to initialise the views.
     */
    private fun initViews() {
        findViewById<View>(R.id.t9_key_0).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_1).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_2).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_3).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_4).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_5).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_6).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_7).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_8).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_9).setOnClickListener(this)
        findViewById<View>(R.id.t9_key_backspace).setOnClickListener(this)
    }

    /**
     * Handle the delete in the numeric keyboard
     * @param v view
     */
    override fun onClick(v: View) {
        // handle number button click
        if (v.tag != null && "number_button" == v.tag) {
            mPasswordField!!.append((v as TextView).text)
            return
        }
        if (v.id == R.id.t9_key_backspace) {
            val editable = mPasswordField!!.text
            val charCount = editable.length
            if (charCount > 0) {
                editable.delete(charCount - 1, charCount)
            }
        }
    }

    /**
     * This method is to get the type string
     * @return string typed from the numeric keyboard
     */
    val inputText: String
        get() = mPasswordField!!.text.toString()
}
