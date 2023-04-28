package com.contusfly.utils

import android.view.KeyEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class PinOnKeyListener(private val currentIndex: Int, private val editTexts: Array<AppCompatEditText>) : View.OnKeyListener {
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if ((keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN && currentIndex != 0)) {
            editTexts[currentIndex - 1].requestFocus()
            editTexts[currentIndex - 1].isCursorVisible = true
        }
        return false
    }
}