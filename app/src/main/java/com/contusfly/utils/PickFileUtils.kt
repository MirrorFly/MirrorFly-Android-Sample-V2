/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.utils


import android.app.Activity
import android.content.Intent
import android.os.Build
import android.provider.MediaStore
import com.contusfly.mediapicker.utils.PickerConstants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.api.ChatManager.isActivityStartedForResult
import com.mirrorflysdk.utils.RequestCode
import java.io.File
import java.util.*

/**
 * This class used to pick media files like audio,video and image
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
object PickFileUtils {
    /**
     * Pick file from gallery for sending to receiver.
     *
     * @param context Application startupActivityContext
     */
    fun pickFile(context: Activity) {
        /* setting isActivityStartedForResult to true to avoid xmpp disconnection */
        isActivityStartedForResult = true
        val manufacturer = Build.MANUFACTURER.uppercase(Locale.getDefault())
        /*
          If the device is samsung
         */
        when {
            manufacturer.contains("SAMSUNG") -> {
                val intent = Intent("com.sec.android.app.myfiles.PICK_DATA")
                intent.putExtra("CONTENT_TYPE", "*/*")
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                context.startActivityForResult(intent, com.contusfly.utils.RequestCode.PICK_FILE)
            }
            else -> {
                /*
              Above kitkat version
             */
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = "*/*"
                context.startActivityForResult(intent, com.contusfly.utils.RequestCode.PICK_FILE)
            }
        }
    }

    /**
     * Choose file from gallery for sending to receiver.
     *
     * @param context Application startupActivityContext
     */
    @JvmStatic
    fun chooseImageFromGallery(context: Activity?) {
        try {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            context?.startActivityForResult(intent, RequestCode.FROM_GALLERY)
            /* setting isActivityStartedForResult to true to avoid xmpp disconnection */
            isActivityStartedForResult = true
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Choose video from gallery for sending to receiver.
     *
     * @param context Application startupActivityContext
     */
    fun chooseVideoFromGallery(context: Activity) {
        try {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                Constants.MIME_TYPE_VIDEO
            )
            intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true)
            context.startActivityForResult(intent, RequestCode.FROM_GALLERY)
            /* setting isActivityStartedForResult to true to avoid xmpp disconnection */
            isActivityStartedForResult = true
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * check the file type is valid or not from the list of supported file types for the
     * application.
     *
     * @param fileType Type of the file means extension
     * @return boolean True if the extension is supported
     */
    @JvmStatic
    fun isValidFileType(fileType: String?): Boolean {
        if (fileType.isNullOrEmpty()) return false
        val type = fileType.lowercase(Locale.getDefault())
        val extension2 = PickerConstants.supportedFormats
        for (extension in extension2) {
            if (type.endsWith(extension)) return true
        }
        return false
    }

    /**
     * Check file size of the from the path of the file
     *
     * @param filePath File path
     * @return boolean True if the size is valid
     */
    fun checkFileSize(filePath: String?, maxSize: Int): Boolean {
        if (filePath.isNullOrEmpty()) return true
        val file = File(filePath)
        val fileInKb = file.length() / 1024
        val fileInMb = fileInKb / 1024
        return maxSize > fileInMb
    }

    fun checkFileSize(fileLength:Long, maxSize: Int): Boolean {
        val fileInKb = fileLength / 1024
        val fileInMb = fileInKb / 1024
        return maxSize > fileInMb
    }
}