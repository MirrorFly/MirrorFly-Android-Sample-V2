package com.contusfly.utils

import com.mirrorflysdk.flycommons.LogMessage
import java.io.File
import java.io.FileWriter
import java.io.IOException

class ConversationUtils {

    val TAG = ConversationUtils::class.simpleName


    /**
     * Default applications in Android like Photo Gallery, Android MP3 Player, Android Video Player
     * will display all the photos, songs & videos from all of the folders in your device.
     * But if you add ".nomedia" file in any folder, the media content of that folder will be disappear from the Gallery/Player.
     *
     *
     * ".nomedia" is a simple blank file to hide pictures, songs & videos in Android phone/tablet.
     *
     *
     * Sent Media files to other user will save in "/UIKit/Images/sent".
     * This "sent" folder we don't need to expose to "Gallery" app; So, we are adding ".nomedia" file in "sent" folder
     *
     * @param rootPath sent media file path
     */
    fun createDotNoMediaFile(rootPath: String) {
        val sentMedia = File(rootPath)
        if (!sentMedia.exists()) {
            sentMedia.mkdirs()
        }
        val noMediaFile = File(sentMedia, ".nomedia")
        if (!noMediaFile.exists()) {
            try {
                FileWriter(noMediaFile).use { writer -> LogMessage.d(TAG, "createNoMedia: $writer") }
            } catch (e: IOException) {
                LogMessage.e(e)
            }
        }
    }
}