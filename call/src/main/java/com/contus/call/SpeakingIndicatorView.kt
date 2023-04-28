package com.contus.call

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView

class SpeakingIndicatorView : AppCompatImageView {

    private var lastAudioLevel = 0
    private var isAnimated = false
    private var speakingIndicatorListener : SpeakingIndicatorListener? = null
    private val speakingHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    private val hideSpeakingIndicatorRunnable = Runnable {
        hideSpeakingIndicator()
    }

    private val stoppedSpeakingRunnable = Runnable {
        speakingHandler.removeCallbacks(animateSpeakingIndicatorRunnable)
        speakingHandler.postDelayed(hideSpeakingIndicatorRunnable, 50)
    }

    private val animateSpeakingIndicatorRunnable = Runnable {
        animateSpeakingIndicator()
    }

    constructor(context: Context?) : super(context!!)

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    )

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!, attrs, defStyle
    )

    fun onUserStoppedSpeaking(speakingIndicatorListener: SpeakingIndicatorListener?) {
        this.speakingIndicatorListener = speakingIndicatorListener
        speakingHandler.postDelayed(stoppedSpeakingRunnable, 250)
    }

    fun onUserSpeaking(audioLevel: Int) {
        this.visibility = View.VISIBLE
        lastAudioLevel = audioLevel
        speakingHandler.removeCallbacks(stoppedSpeakingRunnable)
        speakingHandler.removeCallbacks(animateSpeakingIndicatorRunnable)
        setAudioLevelDrawable(audioLevel.getAudioLevel())
        speakingHandler.postDelayed(animateSpeakingIndicatorRunnable, 250)
    }

    private fun setAudioLevelDrawable(@AudioLevel audioLevel: String) {
        when (audioLevel) {
            AudioLevel.AUDIO_TOO_LOW -> this.setImageResource(R.drawable.ic_audio_speak_indicator_1)
            AudioLevel.AUDIO_LOW -> this.setImageResource(R.drawable.ic_audio_speak_indicator_2)
            AudioLevel.AUDIO_MEDIUM -> this.setImageResource(R.drawable.ic_audio_speak_indicator_3)
            AudioLevel.AUDIO_HIGH -> this.setImageResource(R.drawable.ic_audio_speak_indicator_4)
            else -> this.setImageResource(R.drawable.ic_audio_speak_indicator_5)
        }
    }

    private fun hideSpeakingIndicator() {
        if (lastAudioLevel > 0) {
            lastAudioLevel--
            setAudioLevelDrawable(lastAudioLevel.getAudioLevel())
            speakingHandler.postDelayed(hideSpeakingIndicatorRunnable, 50)
        } else {
            speakingIndicatorListener?.onSpeakingIndicatorHidden()
            speakingHandler.removeCallbacksAndMessages(null)
            this.visibility = View.GONE
        }
    }

    private fun animateSpeakingIndicator() {

        isAnimated = if (isAnimated) {
            setAudioLevelDrawable(lastAudioLevel.getAudioLevel().getAnimationLevel())
            false
        } else {
            setAudioLevelDrawable(lastAudioLevel.getAudioLevel())
            true
        }

        speakingHandler.postDelayed(animateSpeakingIndicatorRunnable, 250)
    }

    private fun Int.getAudioLevel() : String {
       return when {
            this <= 1 -> AudioLevel.AUDIO_TOO_LOW
            this <= 3 -> AudioLevel.AUDIO_LOW
            this <= 4 -> AudioLevel.AUDIO_MEDIUM
            this <= 5 -> AudioLevel.AUDIO_HIGH
            else -> AudioLevel.AUDIO_PEAK
        }
    }

    private fun String.getAnimationLevel(): String {
        return when (this) {
            AudioLevel.AUDIO_PEAK -> AudioLevel.AUDIO_HIGH
            AudioLevel.AUDIO_HIGH -> AudioLevel.AUDIO_MEDIUM
            AudioLevel.AUDIO_MEDIUM -> AudioLevel.AUDIO_LOW
            AudioLevel.AUDIO_LOW -> AudioLevel.AUDIO_TOO_LOW
            else -> AudioLevel.AUDIO_TOO_LOW
        }
    }
}

interface SpeakingIndicatorListener {
    fun onSpeakingIndicatorHidden()
}
