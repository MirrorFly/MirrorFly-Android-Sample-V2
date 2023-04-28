package com.contusfly.mediapicker.helper

import android.text.TextUtils
import android.webkit.MimeTypeMap
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.URLConnection
import java.util.*

object ImagePickerUtils {

    var maxFileRestriction = 10
    var maxVideoFileSizeRestriction = 30
    var maxImageFileSizeRestriction = 10
    fun isVideoFormat(path: String): Boolean {
        val extension = getExtension(path)
        val mimeType = if (TextUtils.isEmpty(extension)) URLConnection.guessContentTypeFromName(path) else MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
        return mimeType != null && mimeType.startsWith("video")
    }

    private fun getExtension(path: String): String {
        val extension = MimeTypeMap.getFileExtensionFromUrl(path)
        if (!TextUtils.isEmpty(extension)) {
            return extension
        }
        return if (path.contains(".")) {
            path.substring(path.lastIndexOf(".") + 1, path.length)
        } else {
            ""
        }
    }

    private fun makeSafeFile(path: String?): File? {
        return if (path == null || path.isEmpty()) {
            null
        } else try {
            File(path)
        } catch (ignored: Exception) {
            null
        }
    }

    /**
     * Returns image file for the given file path and extension
     *
     * @param path      Path of the parent folder
     * @param extension File extension
     * @return File New image file
     */
    fun getFile(path: String?, extension: String): File {
        val todayDate = Calendar.getInstance()
        val dateToday = (todayDate[Calendar.DAY_OF_MONTH].toString() + "-" + (todayDate[Calendar.MONTH] + 1) + "-"
                + todayDate[Calendar.YEAR] + "-" + todayDate[Calendar.HOUR] + "-"
                + todayDate[Calendar.MINUTE] + "-" + todayDate[Calendar.SECOND] + "-" + todayDate[Calendar.MILLISECOND])
        createFolderIfNotExist(path)
        return File(path, dateToday + extension)
    }

    /**
     * Creates folder if not exist
     *
     * @param path Path of the folder
     */
     fun createFolderIfNotExist(path: String?) {
        val folder = File(path)
        if (!folder.exists())
            folder.mkdirs()
    }

    /**
     * Copy stream from the input stream.
     *
     * @param input  Instance of InputStream
     * @param output Instance of OutputStream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Throws(IOException::class)
    fun copyStream(input: InputStream, output: OutputStream) {
        val buffer = ByteArray(1024)
        var bytesRead: Int
        while (input.read(buffer).also { bytesRead = it } != -1) {
            output.write(buffer, 0, bytesRead)
        }
    }
}