/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.chat

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.content.ContextWrapper
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.text.TextUtils
import android.webkit.MimeTypeMap
import androidx.documentfile.provider.DocumentFile
import com.contusfly.mediapicker.helper.ImagePickerUtils
import com.contusfly.utils.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.FilePathUtils
import com.mirrorflysdk.utils.MemoryInfoHelper
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

/**
 * The utility class to get the real path of the file picked from the primary external storage
 * volume. This helper class supports all the API versions of the Android to get the real decoded
 * path.
 */
object RealPathUtil {
    private val TAG = RealPathUtil::class.java.simpleName
    private var intentType: String? = null

    fun getIntentType(): String? {
        return intentType
    }

    fun setIntentType(intentType: String) {
        RealPathUtil.intentType = intentType
    }

    /**
     * Get file Absolute path from file Uri object
     *
     * @param context the app component context
     * @param fileUri the Uri object of the file
     * @return String the absolute path of the file.
     */
    fun getRealPath(context: ContextWrapper, fileUri: Uri?): String? {
        return when {
            fileUri == null -> {
                getRealPathFromURIAPI19(context, fileUri)
            }
            fileUri.toString().contains("content://com.google.android.apps.docs") -> {
                handleCloudAttach(context, fileUri)
            }
            fileUri.toString().contains("com.google.android.apps.photos.contentprovider/0/1/mediakey") -> {
                handleCloudAttach(context, fileUri)
            }
            else -> getRealPathFromURIAPI19(context, fileUri)
        }
    }

    /**
     * Get a file path from a Uri. This will get the the path for Storage Access Framework
     * Documents, as well as the _data field for the MediaStore and other file-based
     * ContentProviders.
     *
     * @param context The startupActivityContext.
     * @param uri     The Uri to query.
     */
    @SuppressLint("NewApi")
    private fun getRealPathFromURIAPI19(context: ContextWrapper, uri: Uri?): String? {
        if (uri == null)
            return null
        when {
            DocumentsContract.isDocumentUri(context, uri) -> {
                when {
                    isExternalStorageDocument(uri) -> {
                        return handleExternalDoc(context, uri)
                    }
                    isDownloadsDocument(uri) -> {
                        return handleDownloadDocument(context, uri)
                    }
                    isMediaDocument(uri) -> {
                        return handleMediaDocument(context, uri)
                    }
                    isGoogleDriveUri(uri) -> return handleCloudAttach(context, uri)
                    isGoogleCloudPhotosUri(uri) -> return handleCloudAttach(context, uri)
                }
            }
            "content".equals(uri.scheme, ignoreCase = true) -> {
                return if (isGooglePhotosUri(uri)) uri.lastPathSegment else getDataColumn(context, uri, uri, null, null)
            }
            "file".equals(uri.scheme, ignoreCase = true) -> {
                return uri.path
            }
        }
        return null
    }

    private fun handleCloudAttach(context: ContextWrapper, uri: Uri): String? {
        val returnCursor = context.contentResolver.query(uri, null, null,
                null, null)
        val nameIndex = returnCursor!!.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        returnCursor.moveToFirst()
        val name = returnCursor.getString(nameIndex)
        return getDriveFilePath(context, name, uri)
    }

    /**
     * Document from external storage
     *
     * @param context the app component context
     * @param uri     the Uri object of the file
     * @return path of the file
     */
    @SuppressLint("NewApi")
    private fun handleExternalDoc(context: ContextWrapper, uri: Uri): String? {
        val docId = DocumentsContract.getDocumentId(uri)
        val split = docId.split(":".toRegex()).toTypedArray()
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            val type = split[0]
            if ("primary".equals(type, ignoreCase = true)) {
                return FilePathUtils.getExternalStorage().toString() + "/" + split[1]
            }
        }
        var realPath: String?
        try {
            realPath = getDataColumn(context, null, uri, null,null)
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
            val basePath = FilePathUtils.getExternalStorage()
                    .toString() + File.separator + Constants.LOCAL_PATH + File.separator
            val folderName = (basePath + Constants.FILE_LOCAL_PATH
                    + File.separator + Constants.MSG_SENT_PATH)
            val file = createFile(folderName, getFileName(context, uri))
            realPath = file.absolutePath
            if (!saveFileFromUri(context, uri, realPath)) realPath = null
        }
        return realPath
    }

    /**
     * Media Document
     *
     * @param context the app component context
     * @param uri     the Uri object of the file
     * @return getDataColumn
     */
    @SuppressLint("NewApi")
    private fun handleMediaDocument(context: ContextWrapper, uri: Uri): String? {
        val docId = DocumentsContract.getDocumentId(uri)
        val split = docId.split(":".toRegex()).toTypedArray()
        val type = split[0]
        var contentUri: Uri? = null
        when (type) {
            "image" -> {
                contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            }
            "video" -> {
                contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            }
            "audio" -> {
                contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            } else -> {
                contentUri = MediaStore.Files.getContentUri("external")
            }
        }
        val selection = "_id=?"
        val selectionArgs = arrayOf(
                split[1]
        )
        return getDataColumn(context, contentUri, uri, selection, selectionArgs)

    }

    /**
     * Media Download Document
     *
     * @param context the app component context
     * @param uri     the Uri object of the file
     * @return check null
     */
    @SuppressLint("NewApi")
    private fun handleDownloadDocument(context: ContextWrapper, uri: Uri): String? {
        val id = DocumentsContract.getDocumentId(uri)
        return if (!TextUtils.isEmpty(id)) {
            if (id.startsWith("raw:")) {
                id.replaceFirst("raw:".toRegex(), "")
            } else {
                try {
                    val downloadsUri = "content://downloads/public_downloads/$id"
                    val contentUri = Uri.parse(downloadsUri)
                    getDocumentRealPath(context, uri, contentUri)
                } catch (e: NumberFormatException) {
                    null
                }
            }
        } else null
    }

    /**
     * Document Real path
     *
     * @param context    the app component context
     * @param uri        the Uri object of the file
     * @param contentUri the Uri object of the file
     * @return the absolute path of the file.
     */
    private fun getDocumentRealPath(context: ContextWrapper, uri: Uri, contentUri: Uri): String? {
        var realPath: String?
        try {
            realPath = getDataColumn(context, contentUri, uri, null, null)
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
            val basePath = FilePathUtils.getExternalStorage()
                    .toString() + File.separator + Constants.LOCAL_PATH + File.separator
            val folderName = (basePath + Constants.FILE_LOCAL_PATH
                    + File.separator + Constants.MSG_SENT_PATH)
            val file = createFile(folderName, getFileName(context, uri))
            realPath = file.absolutePath
            if (!saveFileFromUri(context, uri, realPath)) realPath = null
        }
        return realPath
    }


    /**
     * Get the value of the data column for this Uri. This is useful for MediaStore Uris, and other
     * file-based ContentProviders.
     *
     * @param context       The startupActivityContext.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    private fun getDataColumn(context: ContextWrapper, uri: Uri?, fileUri: Uri?, selection: String?, selectionArgs: Array<String>?): String? {

            var cursor: Cursor? = null
            val column = MediaStore.Images.Media.DATA
            val projection = arrayOf(column)
            try {
                cursor =
                    context.contentResolver.query(uri!!, projection, selection, selectionArgs, null)
                if (cursor != null && cursor.moveToFirst()) {
                    val index: Int
                    return try {
                        index = cursor.getColumnIndexOrThrow(column)
                        cursor.getString(index)
                    } catch (e: Exception) {
                        getNewFilePath(context, uri)
                    }
                }
            } finally {
                cursor?.close()
            }

           try {
               return getCopyFilePath(context,fileUri)
           } catch(e:Exception) {
               com.contusfly.utils.LogMessage.d(TAG,e.toString())
           }

            return null

    }

    private fun getCopyFilePath(context: ContextWrapper,fileUri: Uri?): String? {
        if (fileUri == null)
            return null
        val directoryName = (FilePathUtils.getFileSentExternalStorage(context)).toString() + File.separator + Constants.LOCAL_PATH
            .replace(" ", "") +
                File.separator + Constants.FILE_LOCAL_PATH + File.separator + Constants.MSG_SENT_PATH


        val documentFile = DocumentFile.fromSingleUri(context, fileUri)
        if(!MemoryInfoHelper.isTransferPossible(documentFile!!.length())) {
            return null
        }

        var fileName =  documentFile!!.name
        ImagePickerUtils.createFolderIfNotExist(directoryName)
        val mimeType = getMimeTypeFromFilePath(context, fileUri)
        if(fileName == null) fileName = Constants.TEMP_FILE_NAME
        val filePath = getFilePath(fileName, mimeType, directoryName)
        return checkFilePath(filePath,context,fileUri)
    }

    private fun checkFilePath(filePath: File?,context: Context,fileUri: Uri?): String?  {
        if(filePath!=null){
            if (filePath!!.exists())
                return filePath.path
            val inputStream = context.contentResolver.openInputStream(fileUri!!)
            val fileOutputStream = FileOutputStream(filePath)
            return if (inputStream != null) {
                ImagePickerUtils.copyStream(inputStream, fileOutputStream)
                fileOutputStream.close()
                inputStream.close()
                filePath.path
            } else
                null
        } else {
            return null
        }
    }

    private fun getFilePath(fileName: String?, mimeType: String, directoryName: String): File? {
        return if (mimeType.startsWith("image", true) || mimeType.startsWith("video", true))
            ImagePickerUtils.getFile(directoryName, getExtension(fileName!!))
        else {
            ImagePickerUtils.createFolderIfNotExist(directoryName)
            if(fileName==null){ return null}
            File(directoryName, fileName)
        }
    }

    private fun getExtension(path: String): String {
        return if (path.contains(".")) {
            path.substring(path.lastIndexOf("."), path.length).toLowerCase(Locale.getDefault())
        } else {
            ""
        }
    }

    private fun getMimeTypeFromFilePath(context: Context, uri: Uri): String {
        return  if (ContentResolver.SCHEME_CONTENT == uri.scheme) {
            val cr = context.contentResolver
            cr.getType(uri) ?: ""
        } else {
            val fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri.toString())
            MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension.toLowerCase())?:""
        }
    }

    /**
     * New file Path
     *
     * @param context the app component context
     * @param uri     the Uri object of the file
     * @return check null
     */
    private fun getNewFilePath(context: ContextWrapper, uri: Uri?): String? {
        //copyFiles file and send new file path
        var fileName = getFileName(uri)
        if (fileName != null && !fileName.contains(".")) {
            if (intentType != null) {
                fileName = fileName + "." + handleFileExtension(intentType!!.split("/".toRegex()).toTypedArray()[1])
            } else {
                LogMessage.d("fileName :", getFileName(uri))
            }
        }
        val directoryName = (FilePathUtils.getFileSentExternalStorage(context).toString() + File.separator
                + Constants.LOCAL_PATH + File.separator + "temp")
        if (!TextUtils.isEmpty(fileName)) {
            val directory = File(directoryName)
            if (!directory.exists())
                directory.mkdirs()
            val copyFile = File(directoryName + File.separator + fileName)
            copyUriToFile(context, uri, copyFile)
            return copyFile.absolutePath
        }
        return null
    }

    private fun getDriveFilePath(context: ContextWrapper, fileName: String, fileUri: Uri): String? {
        //copyFiles file and send new file path
        val directoryName = (FilePathUtils.getExternalStorage().toString() + File.separator
                + Constants.LOCAL_PATH + File.separator + Constants.FILE_LOCAL_PATH + File.separator + Constants.MSG_SENT_PATH)
        if (!TextUtils.isEmpty(fileName)) {
            val directory = File(directoryName)
            if (!directory.exists()) directory.mkdirs()
            val copyFile = File(directoryName + File.separator + fileName)
            val isCopied = copyUriToFile(context, fileUri, copyFile)
            return if (isCopied) copyFile.absolutePath else null
        }
        return null
    }

    private fun copyUriToFile(context: Context, uri: Uri?, dst: File?): Boolean {
        try {
            context.contentResolver.openInputStream(uri!!).use { inputStream ->
                FileOutputStream(dst).use { outputStream ->
                    var read: Int
                    val maxBufferSize = 4 * 1024
                    val bytesAvailable = inputStream!!.available()
                    val bufferSize = Math.min(bytesAvailable, maxBufferSize)
                    val buffers = ByteArray(bufferSize)
                    while (inputStream.read(buffers).also { read = it } != -1) {
                        outputStream.write(buffers, 0, read)
                    }
                }
                return true
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
            return false
        }
    }

    private fun getFileName(uri: Uri?): String? {
        if (uri == null) {
            return null
        }
        var fileName: String? = null
        val path = uri.path
        val cut = path!!.lastIndexOf('/')
        if (cut != -1) {
            fileName = path.substring(cut + 1)
        }
        return fileName
    }

    /**
     * Returns the directory named by this abstract folderName and fileName, including any necessary
     * but nonexistent parent directories.
     *
     * @param folderName The parent's pathname.
     * @param fileName   The child's pathname.
     * @return The created file to which the downloaded data is written.
     */
    private fun createFile(folderName: String, fileName: String?): File {
        val file = File(folderName, fileName ?: Constants.EMPTY_STRING)
        val parentFile = file.parentFile
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs()
        }
        return file
    }

    /**
     * get the name of the file.
     *
     * @param context activity context
     * @param uri     uri of the file
     * @return the file name
     */
    private fun getFileName(context: Context, uri: Uri): String? {
        val mimeType = context.contentResolver.getType(uri)
        var filename: String? = null
        if (mimeType == null) {
            val path = FilePathUtils.getPath(context, uri)
            filename = if (path == null) {
                getName(uri.toString())
            } else {
                val file = File(path)
                file.name
            }
        } else {
            val returnCursor = context.contentResolver.query(uri, null, null, null, null)
            if (returnCursor != null) {
                val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                returnCursor.moveToFirst()
                filename = returnCursor.getString(nameIndex)
                returnCursor.close()
            }
        }
        return filename
    }

    private fun saveFileFromUri(context: Context, uri: Uri, destinationPath: String?): Boolean {
        var doesFileWritten = false
        try {
            context.contentResolver.openInputStream(uri).use { inputStream ->
                BufferedOutputStream(FileOutputStream(destinationPath)).use { bos ->
                    if (inputStream != null) {
                        val buffer = ByteArray(4 * 1024) // or other buffer size
                        var read: Int
                        while (inputStream.read(buffer).also { read = it } != -1) {
                            bos.write(buffer, 0, read)
                        }
                        bos.flush()
                        doesFileWritten = true
                    }
                }
            }
        } catch (e: IOException) {
            LogMessage.e(TAG, e)
        }
        return doesFileWritten
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    private fun isExternalStorageDocument(uri: Uri): Boolean {
        return "com.android.externalstorage.documents" == uri.authority
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    private fun isDownloadsDocument(uri: Uri): Boolean {
        return "com.android.providers.downloads.documents" == uri.authority
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    private fun isMediaDocument(uri: Uri): Boolean {
        return "com.android.providers.media.documents" == uri.authority
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    private fun isGooglePhotosUri(uri: Uri): Boolean {
        return "com.google.android.apps.photos.content" == uri.authority
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Drive.
     */
    private fun isGoogleDriveUri(uri: Uri): Boolean {
        return "com.google.android.apps.docs.storage" == uri.authority || "com.google.android.apps.docs.storage.legacy" == uri.authority
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Drive.
     */
    private fun isGoogleCloudPhotosUri(uri: Uri): Boolean {
        return "com.google.android.apps.photos.contentprovider/0/1/mediakey" == uri.authority || "com.google.android.apps.docs.storage.legacy" == uri.authority
    }

    private fun getName(filename: String?): String? {
        if (filename == null) {
            return null
        }
        val index = filename.lastIndexOf('/')
        return filename.substring(index + 1)
    }

    private fun handleFileExtension(extension: String): String {
        var fileExtension = ""
        fileExtension = when (extension) {
            "excel" -> "xls"
            "ppt" -> "ppt"
            "pdf" -> "pdf"
            "zip" -> "zip"
            "jpg" -> "jpg"
            "jpeg" -> "jpeg"
            "png" -> "png"
            "webp" -> "webp"
            "gif" -> "gif"
            "aac" -> "aac"
            "mp3" -> "mp3"
            "mp4" -> "mp4"
            "wav" -> "wav"
            "msword" -> "doc"
            "rtf" -> "rtf"
            "plain" -> "txt"
            "openxmlformats-officedocument.presentationml.presentation" -> "pptx"
            "openxmlformats-officedocument.wordprocessingml.document" -> "docx"
            "ogg" -> "ogg"
            "mpeg" -> "mpeg"
            "csv" -> "csv"
            else -> ""
        }
        return fileExtension
    }
}