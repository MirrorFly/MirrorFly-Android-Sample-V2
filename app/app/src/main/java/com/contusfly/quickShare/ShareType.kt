package com.contusfly.quickShare

import androidx.annotation.StringDef

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@StringDef(ShareType.MEDIA, ShareType.CONTACT, ShareType.TEXT)
annotation class ShareType {
    companion object {
        const val MEDIA = "media"
        const val CONTACT = "contact"
        const val TEXT = "text"
    }
}
