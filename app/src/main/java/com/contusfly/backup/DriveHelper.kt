package com.contusfly.backup

import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager.scope
import com.contusfly.TAG
import com.contusfly.emptyString
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener
import com.google.api.client.googleapis.media.MediaHttpUploader
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener
import com.google.api.client.http.FileContent
import com.google.api.services.drive.Drive
import com.google.api.services.drive.model.File
import kotlinx.coroutines.launch
import java.io.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * An Utility class for performing read/write operations on Drive files via the REST API
 */
class DriveHelper(private val mDriveService: Drive) {

    /**
     * Get the File Info of the Backup file
     *
     * @param fileId String id of the backup file
     * @return File backup file
     */
    fun getFile(fileId: String): File {
        return mDriveService.files().get(fileId).setFields("id, name, size, modifiedTime, createdTime").execute()
    }

    /**
     * Download the backup file from User's Google Drive to local
     *
     * @param fileId String id of the backup file to be downloaded
     * @param localFilePath String local path to which the file should be downloaded
     * @param listener MediaHttpDownloaderProgressListener listener for backup file download progress
     */
    fun saveBackupFileFromDriveToLocal(
        fileId: String,
        localFilePath: String,
        listener: MediaHttpDownloaderProgressListener
    ) {

        val localBackupFile = File(localFilePath)

        try {
            val outStream: OutputStream = FileOutputStream(localBackupFile)
            val request = mDriveService.files().get(fileId)
            request.mediaHttpDownloader.setProgressListener(listener).chunkSize = MediaHttpUploader.MINIMUM_CHUNK_SIZE
            request.executeMediaAndDownloadTo(outStream)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * Query the User's Google Drive for the backup file
     *
     * @param fileName String String search term  the query
     * @return Triple<String, String, java.lang.Exception?>
     */
    fun queryFiles(fileName: String): Triple<String, String, java.lang.Exception?> {

        try {

            val fileLists = mDriveService.files().list()
                .setSpaces("appDataFolder")
                .setPageSize(3)
                .setFields("nextPageToken, files(id, name, size, modifiedTime)")
                .setQ("name contains '${fileName}' and trashed = false")
                .setOrderBy("modifiedTime desc")
                .execute()
            return if (fileLists.files.isNotEmpty()) {
                Triple(
                    fileLists.files.first().id,
                    BackupConstants.DRIVE_BACKUP_FILE_AVAILABLE,
                    null
                )
            } else {
                Triple(emptyString(), BackupConstants.NO_DRIVE_BACKUP_FILE_AVAILABLE, null)
            }

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            return Triple(BackupConstants.DRIVE_BACKUP_FILE_QUERY_EXCEPTION, e.localizedMessage, e)
        }
    }

    /**
     * Creates a file in the User's Google Drive and uploads the backup data content to that file
     *
     * @param parentId String id of the backup folder
     * @param fileName String? filename of the backup file
     * @param filePath String local backup file's file path
     * @param listener MediaHttpUploaderProgressListener listener for Drive upload progress
     * @return kotlin.Pair<String, Exception?>
     */
    fun createFileWithProgress(
        fileName: String?,
        filePath: String,
        listener: MediaHttpUploaderProgressListener
    ): Pair<String, Exception?> {

        try {
            val localFile = File(filePath)

            //Generates an input stream with your file content to be uploaded
            val mediaContent = FileContent(BackupConstants.BACKUP_FILE_TYPE, localFile)
            //Creates an empty Drive file
            val metadata = File()
                .setParents(Collections.singletonList("appDataFolder"))
                .setMimeType(BackupConstants.BACKUP_FILE_TYPE)
                .setName(fileName)

            //Builds up the upload request
            val uploadFile = mDriveService.files().create(metadata, mediaContent)

            //This will handle the resumable upload
            val uploader: MediaHttpUploader = uploadFile.mediaHttpUploader

            //choose your chunk size and it will automatically divide parts
            uploader.chunkSize = MediaHttpUploader.MINIMUM_CHUNK_SIZE

            //according to Google, this enables gzip in future (optional)
            uploader.disableGZipContent = false

            //important, this enables resumable upload
            uploader.isDirectUploadEnabled = false

            //listener to be updated
            uploader.progressListener = listener

            val file = uploadFile.execute()

            LogMessage.e(TAG, "createFileWithProgress file id ${file.id}")
            LogMessage.e(TAG, "createFileWithProgress file name ${file.name}")
            LogMessage.e(TAG, "createFileWithProgress file name ${file.createdTime}")
            return Pair(file.id, null)

        } catch (exception: Exception) {
            exception.printStackTrace()
            return Pair(emptyString(), exception)
        }
    }

}