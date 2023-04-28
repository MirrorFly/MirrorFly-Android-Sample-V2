package com.contusfly.quickShare

import androidx.annotation.StringDef

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@StringDef(FileValidation.SIZE, FileValidation.DURATION, FileValidation.TYPE)
annotation class FileValidation {
    companion object {
        const val SIZE = "size"
        const val DURATION = "duration"
        const val TYPE = "type"
    }
}
