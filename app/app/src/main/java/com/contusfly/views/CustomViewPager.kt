package com.contusfly.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator
import android.widget.Scroller
import androidx.viewpager.widget.ViewPager
import java.lang.reflect.Field

class CustomViewPager : ViewPager {
    constructor(context: Context?) : super(context!!) {
        setMyScroller()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        setMyScroller()
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        try {
            return super.onTouchEvent(ev)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        try {
            return super.onInterceptTouchEvent(ev)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
        return false
    }

    private fun setMyScroller() {
        try {
            val viewpager: Class<*> = ViewPager::class.java
            val scroller: Field = viewpager.getDeclaredField("mScroller")
            scroller.isAccessible = true
            val interpolator = ViewPager::class.java.getDeclaredField("sInterpolator")
            interpolator.isAccessible = true
            val mScroller = ScrollerCustomDuration(context, interpolator[null] as Interpolator)
            scroller[this] = mScroller
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    class MyScroller(context: Context?) :
        Scroller(context, DecelerateInterpolator()) {
        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, 400 /*0.4 secs*/)
        }
    }

    class ScrollerCustomDuration : Scroller {
        private var mScrollFactor = 1.0

        constructor(context: Context?) : super(context) {}
        constructor(context: Context?, interpolator: Interpolator?) : super(
            context,
            interpolator
        ) {
        }

        @SuppressLint("NewApi")
        constructor(context: Context?, interpolator: Interpolator?, flywheel: Boolean) : super(
            context,
            interpolator,
            flywheel
        ) {
        }

        /**
         * Set the factor by which the duration will change
         */
        fun setScrollDurationFactor(scrollFactor: Double) {
            mScrollFactor = scrollFactor
        }

        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, (400 * mScrollFactor).toInt())
        }
    }
}