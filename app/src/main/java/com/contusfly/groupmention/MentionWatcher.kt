package com.contusfly.groupmention

import android.text.Editable
import android.widget.EditText


internal class MentionWatcher(
    val editText: EditText,
    mentionConfig: UserMentionConfig,
    val handler: OnMentionTextChanges

) {
    private val trigger: String
    private val delimiter: String

    internal interface OnMentionTextChanges {
        fun onMentionTextDetectStateChanged(isDetected: Boolean, detectedKeyword: CharSequence?)
    }

    fun findMention(editable: Editable) {
        val src = editable.toString()
        val cursorStart = editText.selectionStart
        val cursorEnd = editText.selectionEnd
        if (cursorStart == cursorEnd) {
            val index = findTriggerIndex(editText, trigger, delimiter, cursorStart)
            var keyword: CharSequence? = null
            if (index >= 0 && index + trigger.length <= cursorStart) {
                keyword = src.subSequence(index + trigger.length, cursorStart)
            }
            handler.onMentionTextDetectStateChanged(keyword != null, keyword)
        }
    }

    companion object {
        @JvmStatic
        fun findTriggerIndex(editText: EditText, trigger: String, delimiter: String, cursorPosition: Int): Int {
            val editable = editText.text

            // select word -> insert a new character -> MentionSapn is not removed if there exists
            val currentSpan = editable.getSpans(cursorPosition, cursorPosition, MentionSpan::class.java)
            if (currentSpan.isNotEmpty()) {
                val currentSpanStart = editable.getSpanStart(currentSpan[0])
                val currentSpanEnd = editable.getSpanEnd(currentSpan[0])
                if (!currentSpan[0].displayText.contentEquals(editable.subSequence(currentSpanStart, currentSpanEnd))) {
                    editable.removeSpan(currentSpan[0])
                }
            }

            // skip the previous spannable string.
            val spans = editable.getSpans(0, cursorPosition, MentionSpan::class.java)
            val spanCount = spans.size
            var from = 0
            if (spanCount > 0) {
                val lastSpan = spans[spanCount - 1]
                from = editable.getSpanEnd(lastSpan)
            }
            var result = -1
            if (from >= cursorPosition) return result
            val src = editable.toString().substring(from, cursorPosition)
            // 1. splits a string by delimiter, new line
            val words = src.split("[\\n$delimiter]".toRegex()).toTypedArray()
            // 2. loops the split strings from the last
            var i = words.size
            while (i-- > 0) {
                val targetWord = words[i]
                // 3. finds the first token in a string.
                val triggerIndex = targetWord.indexOf(trigger)
                if (triggerIndex != -1) {
                    if (triggerIndex != 0 && !targetWord.get(triggerIndex - 1).toString().contains(" ")) {
                        // except first index, if the @ symbol doesn't have spaces before that,then we don't show group list
                        result - 1
                        break
                    }
                    val wordIndex = src.lastIndexOf(targetWord)
                    result = from + wordIndex + triggerIndex
                    break
                }
            }
            return result
        }
    }

    init {
        this.trigger = mentionConfig.trigger
        this.delimiter = mentionConfig.delimiter
    }
}
