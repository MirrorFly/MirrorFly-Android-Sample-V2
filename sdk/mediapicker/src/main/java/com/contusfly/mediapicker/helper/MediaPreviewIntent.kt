package com.contusfly.mediapicker.helper

class MediaPreviewIntent private constructor() {
    var toUser: String? = null
    var chatType: String? = null
    var mediaClass: Class<*>? = null
    var settingsClass: Class<*>? = null
    var chatClass: Class<*>? = null

    companion object {
        private var mInstance: MediaPreviewIntent? = null
        val instance: MediaPreviewIntent?
            get() {
                if (mInstance == null) mInstance = MediaPreviewIntent()
                return mInstance
            }
    }
}