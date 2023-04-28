/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.call

import android.animation.Animator
import android.widget.RelativeLayout
import android.animation.AnimatorSet
import android.util.TypedValue
import android.graphics.DashPathEffect
import android.view.animation.AccelerateDecelerateInterpolator
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import java.util.ArrayList

/**
 * This is custom layout which shows ripple effect for background
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class RippleBackgroundView : RelativeLayout {
    private var rippleStrokeWidth = 0f
    private var paint: Paint? = null

    /**
     * Ripple Animation
     *
     * @return running animation
     */
    private var isRippleAnimationRunning = false
    private var animatorSet: AnimatorSet? = null
    private val rippleViewList = ArrayList<RippleView>()

    private val speakingHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    private val stoppedSpeakingRunnable = Runnable {
        hideSpeakingIndicator()
    }

    /**
     * Constructs with context
     *
     * @param context the app component context
     */
    constructor(context: Context?) : super(context)

    /**
     * Constructs with context & attrs
     *
     * @param context the app component context
     * @param attrs   the attribute set
     */
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    /**
     * Constructs with context & attrs & defStyleAttr
     *
     * @param context      the app component context
     * @param attrs        the attribute set
     * @param defStyleAttr the style attribute
     */
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    /**
     * Initialization
     *
     * @param context the app component context
     * @param attrs   the attribute set
     */
    private fun init(context: Context, attrs: AttributeSet?) {
        if (isInEditMode) return
        requireNotNull(attrs) { "Attributes should be provided to this view," }
        val defaultStrokeWidth = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 10.0f,
            context.resources.displayMetrics
        )
        val defaultRippleRadius = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 64.0f,
            context.resources.displayMetrics
        )
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RippleBackgroundView)
        val rippleColor = typedArray.getColor(
            R.styleable.RippleBackgroundView_rb_color,
            ContextCompat.getColor(context, android.R.color.white)
        )
        rippleStrokeWidth = typedArray.getDimension(
            R.styleable.RippleBackgroundView_rb_strokeWidth,
            defaultStrokeWidth
        )
        val rippleRadius =
            typedArray.getDimension(R.styleable.RippleBackgroundView_rb_radius, defaultRippleRadius)
        val rippleDurationTime =
            typedArray.getInt(R.styleable.RippleBackgroundView_rb_duration, DEFAULT_DURATION_TIME)
        val rippleAmount = typedArray.getInt(
            R.styleable.RippleBackgroundView_rb_rippleAmount,
            DEFAULT_RIPPLE_COUNT
        )
        val rippleScale =
            typedArray.getFloat(R.styleable.RippleBackgroundView_rb_scale, DEFAULT_SCALE)
        val rippleType =
            typedArray.getInt(R.styleable.RippleBackgroundView_rb_type, DEFAULT_FILL_TYPE)
        typedArray.recycle()
        val rippleDelay = rippleDurationTime / rippleAmount
        paint = Paint()
        paint!!.isAntiAlias = true
        if (rippleType == DEFAULT_FILL_TYPE) {
            rippleStrokeWidth = 0f
            paint!!.style = Paint.Style.FILL
        } else paint!!.style = Paint.Style.STROKE
        paint!!.color = rippleColor
        paint!!.strokeWidth = DEFAULT_STROKE_WIDTH
        paint!!.pathEffect = DashPathEffect(floatArrayOf(4f, 8f), 4f)
        val rippleParams = LayoutParams(
            (2 * (rippleRadius + rippleStrokeWidth)).toInt(),
            (2 * (rippleRadius + rippleStrokeWidth)).toInt()
        )
        rippleParams.addRule(CENTER_IN_PARENT, TRUE)
        animatorSet = AnimatorSet()
        animatorSet!!.interpolator = AccelerateDecelerateInterpolator()
        val animatorList = ArrayList<Animator>()
        for (i in 0 until rippleAmount) {
            val rippleView = RippleView(getContext())
            addView(rippleView, rippleParams)
            rippleViewList.add(rippleView)
            val scaleXAnimator = ObjectAnimator.ofFloat(rippleView, "ScaleX", 1.0f, rippleScale)
            scaleXAnimator.repeatCount = ObjectAnimator.INFINITE
            scaleXAnimator.repeatMode = ObjectAnimator.RESTART
            scaleXAnimator.startDelay = (i * rippleDelay).toLong()
            scaleXAnimator.duration = rippleDurationTime.toLong()
            animatorList.add(scaleXAnimator)
            val scaleYAnimator = ObjectAnimator.ofFloat(rippleView, "ScaleY", 1.0f, rippleScale)
            scaleYAnimator.repeatCount = ObjectAnimator.INFINITE
            scaleYAnimator.repeatMode = ObjectAnimator.RESTART
            scaleYAnimator.startDelay = (i * rippleDelay).toLong()
            scaleYAnimator.duration = rippleDurationTime.toLong()
            animatorList.add(scaleYAnimator)
            val alphaAnimator = ObjectAnimator.ofFloat(rippleView, "Alpha", 1.0f, 0f)
            alphaAnimator.repeatCount = ObjectAnimator.INFINITE
            alphaAnimator.repeatMode = ObjectAnimator.RESTART
            alphaAnimator.startDelay = (i * rippleDelay).toLong()
            alphaAnimator.duration = rippleDurationTime.toLong()
            animatorList.add(alphaAnimator)
        }
        animatorSet!!.playTogether(animatorList)
    }

    /**
     * starts ripple animation for the view
     */
    fun startRippleAnimation() {
        if (!isRippleAnimationRunning) {
            for (rippleView in rippleViewList) {
                rippleView.visibility = VISIBLE
            }
            animatorSet!!.start()
            isRippleAnimationRunning = true
        }
    }

    /**
     * stops ripple animation for the view
     */
    fun stopRippleAnimation() {
        if (isRippleAnimationRunning) {
            animatorSet!!.end()
            isRippleAnimationRunning = false
        }
    }

    /**
     * starts ripple animation for the speaking view
     */
    fun onUserSpeaking() {
        if (!isRippleAnimationRunning) {
            for (rippleView in rippleViewList) {
                rippleView.visibility = VISIBLE
            }
            animatorSet!!.start()
            isRippleAnimationRunning = true
            speakingHandler.removeCallbacks(stoppedSpeakingRunnable)
        }
    }

    /**
     * stops ripple animation for the speaking view
     */
    fun onUserStoppedSpeaking() {
        if (isRippleAnimationRunning) {
            speakingHandler.postDelayed(stoppedSpeakingRunnable, 250)
        }
    }

    private fun hideSpeakingIndicator() {
        speakingHandler.removeCallbacksAndMessages(null)
        if (isRippleAnimationRunning) {
            animatorSet!!.end()
            isRippleAnimationRunning = false
        }
    }

    private inner class RippleView(context: Context?) : View(context) {
        override fun onDraw(canvas: Canvas) {
            val radius = width.coerceAtMost(height) / 2
            canvas.drawCircle(
                radius.toFloat(),
                radius.toFloat(),
                radius - rippleStrokeWidth,
                paint!!
            )
        }

        init {
            this.visibility = INVISIBLE
        }
    }

    companion object {
        private const val DEFAULT_RIPPLE_COUNT = 6
        private const val DEFAULT_DURATION_TIME = 3000
        private const val DEFAULT_SCALE = 6.0f
        private const val DEFAULT_FILL_TYPE = 0
        private const val DEFAULT_STROKE_WIDTH = 2.0f
    }
}