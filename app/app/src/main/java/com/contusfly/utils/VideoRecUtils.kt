package com.contusfly.utils

import com.mirrorflysdk.utils.FilePathUtils
import java.io.File

/**
 * This class is used to capture video using existing camera applications.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
object VideoRecUtils {
    /**
     * Returns the sent video directory inside which the video recorded file will be created.
     *
     * @param folderName The name of the folder in which the recorded video will be written.
     * @return The parent pathname string.
     */
    fun getSentParentPath(folderName: String): String {
        return (FilePathUtils.getExternalStorage().toString() + File.separator + Constants.LOCAL_PATH + File.separator
                + folderName + File.separator + Constants.MSG_SENT_PATH)
    }

    /**
     * Returns the directory inside which a new file will be created.
     *
     * @param folderName The name of the folder in which the recorded video will be written.
     * @return The parent pathname string.
     */
    fun getPath(folderName: String): String {
        return FilePathUtils.getExternalStorage().toString() + File.separator + Constants.LOCAL_PATH + File.separator + folderName
    }
}