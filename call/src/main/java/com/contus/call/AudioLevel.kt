package com.contus.call

import androidx.annotation.StringDef

@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@StringDef(AudioLevel.AUDIO_TOO_LOW, AudioLevel.AUDIO_LOW,
    AudioLevel.AUDIO_MEDIUM, AudioLevel.AUDIO_HIGH, AudioLevel.AUDIO_PEAK)
annotation class AudioLevel {
    companion object {
        const val AUDIO_TOO_LOW = "audio_too_low"
        const val AUDIO_LOW = "audio_low"
        const val AUDIO_MEDIUM = "audio_medium"
        const val AUDIO_HIGH = "audio_high"
        const val AUDIO_PEAK = "audio_peak"
    }
}