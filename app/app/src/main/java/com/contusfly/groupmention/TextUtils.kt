package com.contusfly.groupmention

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils

object TextUtils {
    fun replace(
        template: CharSequence,
        sources: Array<String>,
        destinations: Array<CharSequence?>
    ): SpannableStringBuilder {
        val tb = SpannableStringBuilder(template)
        var from = 0
        for (source in sources) {
            val where = TextUtils.indexOf(tb, source, from)
            if (where >= 0) {
                from = where + source.length
                tb.setSpan(
                    source, where, where + source.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        for (i in sources.indices) {
            val start = tb.getSpanStart(sources[i])
            val end = tb.getSpanEnd(sources[i])
            if (start >= 0) {
                tb.replace(start, end, destinations[i])
            }
        }
        return tb
    }
}