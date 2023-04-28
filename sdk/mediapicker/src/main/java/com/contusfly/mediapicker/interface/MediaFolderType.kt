package com.contusfly.mediapicker.`interface`

import androidx.annotation.StringDef

/**
 * This class contains Folder Type Constants
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@StringDef(MediaFolderType.CAMERA, MediaFolderType.ALL_MEDIA, MediaFolderType.ALL_VIDEO, MediaFolderType.FOLDER)
annotation class MediaFolderType {
    companion object {
        const val  CAMERA = "camera"
        const val  ALL_MEDIA = "all_media"
        const val  ALL_VIDEO = "all_video"
        const val  FOLDER = "folder"
    }
}