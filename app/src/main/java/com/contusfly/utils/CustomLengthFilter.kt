package com.contusfly.utils

import android.text.InputFilter
import android.text.Spanned
import com.mirrorflysdk.flycommons.Constants

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class CustomLengthFilter(max: Int) : InputFilter {

    private var mMax = 0

    /**
     * To set maximum length of edits
     *
     * @param max Maximum length for edits
     */
    init {
        mMax = max
    }

    override fun filter(source: CharSequence?, start: Int, end: Int, dest: Spanned?, dStart: Int, dEnd: Int): CharSequence {
        val textLength = EmojiHandler.getEmojiCharLength(dest.toString())
        val remainingLength = mMax - textLength
        return if (remainingLength <= -1) Constants.EMPTY_STRING else source!!
    }
}