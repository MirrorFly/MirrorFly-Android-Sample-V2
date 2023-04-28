package com.contusfly.utils

object AppConstants {

    const val SEND_TO = "send_to"
    const val IMAGE_CAN_SHOW = "image_can_show"
    const val VIDEO_CAN_SHOW = "video_can_show"
    const val MAX_MEDIA_SELECTION_RESTRICTION = "max_media_selection_restriction"
    const val NOTIFY_PROFILE_ICON = "notify_profile_icon"
    const val NOTIFY_ADMIN_BLOCK = "notify_admin_block"
    const val NOTIFY_SELECTION = "notify_selection"
    const val NOTIFY_IS_SELECTED = "notify_is_selected"
    const val MY_JID = "my_jid"
    const val USER_PROFILE = "user_profile"
    const val GROUP_JID = "group_jid"
    const val GROUP_PROFILE = "group_profile"
    const val PROFILE_DATA = "profile_data"
    const val YOU = "You"
    const val DB_NAME = "UIKit"
    const val LOADING = 0
    const val ITEM = 1

    val supportedFormats = arrayOf("pdf", "txt", "rtf", "xls", "ppt", "pptx", "zip", "xlsx", "doc", "docx", "wav", "mp3", "mp4", "aac", "jpg", "jpeg", "png", "webp", "gif", "pptx", "csv")

    /**
     * Send the network state change to update chat user online status
     */
    const val NETWORK_STATE_CHANGE = "com.contus.connection.network_change"

    /**
     * Send the network status to update chat user online status
     */
    const val NETWORK_STATE_STATUS = "com.contus.connection.network_status"

    /**
     * Notifying action for restoring of chat completion
     */
    const val RESTORE_DONE = "com.contus.chat.restore.done"

    /**
     * Notifying action for uploading  of data completion
     */
    const val UPLOAD_DONE = "com.contus.chat.upload.done"

    /**
     * Notifying the initiation of auto backup
     */
    const val AUTO_BACKUP_INITIATED = "com.contus.chat.auto.backup.initiated"
}