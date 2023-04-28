package com.contusfly.utils

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatEditText
import com.contusfly.R

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class PinTextWatcher(private val currentIndex: Int, private val editTexts: Array<AppCompatEditText>, val activity: Activity) : TextWatcher {

    private var isFirst = false
    private var isLast = false
    private var newTypedString = ""

    /**
     * constructor of the class
     */
    init {
        when (currentIndex) {
            0 -> {
                isFirst = true
                editTexts[currentIndex].isCursorVisible = true
            }
            editTexts.size - 1 -> {
                isLast = true
                editTexts[currentIndex].isCursorVisible = false
                editTexts[currentIndex].imeOptions = EditorInfo.IME_ACTION_DONE
            }
            else -> editTexts[currentIndex].isCursorVisible = false
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        /* No Implementation Needed */
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        newTypedString = s.subSequence(start, start + count).toString().trim { it <= ' ' }
    }

    override fun afterTextChanged(s: Editable) {
        var text = newTypedString
        /* Detect paste event and set first char */
        if (text.length > 1) text = text[0].toString()
        editTexts[currentIndex].setOnClickListener { editTexts[currentIndex].isCursorVisible = true }
        editTexts[currentIndex].removeTextChangedListener(this)
        editTexts[currentIndex].setText(text)
        editTexts[currentIndex].setSelection(text.length)
        editTexts[currentIndex].addTextChangedListener(this)
        if (text.length == 1) {
            editTexts[currentIndex].setBackgroundResource(R.drawable.otp_selection_bg)
            moveToNext()
        } else if (text.isEmpty()) {
            editTexts[currentIndex].setBackgroundResource(R.drawable.otp_square_bg)
            moveToPrevious()
        }
    }

    private fun moveToNext() {
        if (!isLast && !isAllEditTextsFilled) {
            editTexts[currentIndex + 1].requestFocus()
            editTexts[currentIndex + 1].isCursorVisible = true
        } else {
            editTexts[currentIndex].imeOptions = EditorInfo.IME_ACTION_DONE
            editTexts[currentIndex].isCursorVisible = false
            hideKeyboard()
        }
    }

    private fun moveToPrevious() {
        if (!isFirst)
            changePreviousViewBackGround()
    }

    private val isAllEditTextsFilled: Boolean
        get() {
            for (editText in editTexts)
                if (editText.text.toString().trim { it <= ' ' }.isEmpty())
                    return false
            return true
        }

    private fun hideKeyboard() {
        if (activity.currentFocus != null) {
            val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
        }
    }

    private fun changePreviousViewBackGround() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (currentIndex != 0) {
                editTexts[currentIndex].setBackgroundResource(R.drawable.otp_square_bg)
            } else editTexts[currentIndex].setBackgroundResource(R.drawable.otp_square_bg)
        }, 50)
    }
}