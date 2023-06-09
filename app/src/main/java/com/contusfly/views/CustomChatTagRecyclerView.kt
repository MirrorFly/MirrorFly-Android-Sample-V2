package com.contusfly.views

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class CustomChatTagRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        // Prevent touch events from being intercepted by the parent ViewPager
        parent.requestDisallowInterceptTouchEvent(true)
        return super.onInterceptTouchEvent(e)
    }
}
