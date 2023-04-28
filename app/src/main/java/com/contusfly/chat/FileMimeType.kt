package com.contusfly.chat

import androidx.annotation.StringDef

/**
 * This class contains Mime Type Constants
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@StringDef(FileMimeType.IMAGE, FileMimeType.VIDEO, FileMimeType.AUDIO, FileMimeType.APPLICATION, FileMimeType.UNSUPPORTED_FORMAT)
annotation class FileMimeType {
    companion object {
        const val  IMAGE = "image"
        const val  VIDEO = "video"
        const val  AUDIO = "audio"
        const val  APPLICATION = "application"
        const val  UNSUPPORTED_FORMAT = "unsupported_format"
    }
}