package com.contusfly.backup.workers

import android.accounts.Account
import android.content.Context
import android.os.Build
import android.os.Environment
import androidx.work.*
import com.contusfly.R
import com.contusfly.backup.BackupConstants
import com.contusfly.backup.DriveHelper
import com.contusfly.backup.WorkManagerController
import com.contusfly.backup.models.BackupInfo
import com.contusfly.emptyString
import com.contusfly.getString
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.backup.*
import com.mirrorflysdk.flydatabase.model.Backup
import com.mirrorflysdk.utils.Utils
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException
import com.google.api.client.googleapis.json.GoogleJsonResponseException
import com.google.api.client.googleapis.media.MediaHttpDownloader
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener
import com.google.api.client.googleapis.media.MediaHttpUploader
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import kotlinx.coroutines.*
import java.io.File
import java.util.*
import kotlin.math.roundToInt

/*
* Worker Class for Uploading and Downloading backup file to or from Google Drive using Google Account credential.
*/
class GoogleDriveWorker(private val appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams), CoroutineScope, MediaHttpDownloaderProgressListener,
    MediaHttpUploaderProgressListener {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("GoogleDriveWorker Coroutine Exception ${TAG}:  ${exception.printStackTrace()}")
    }

    val TAG = "GoogleDriveWorker"

    private var driverHelper: DriveHelper? = null

    private var localBackupFilePath: String = emptyString()

    private var reason = emptyString()

    private var exception: Exception? = null

    private var isUpload = false

    private var driveUploadFileId = UUID.randomUUID().toString()

    /*
    Google Account Initialization
     */
    private val account: Account? by lazy {
        val accountAsString = SharedPreferenceManager.getString(BackupConstants.GOOGLE_ACCOUNT)
        if (accountAsString.isEmpty()) null else Utils.getGSONInstance()
            .fromJson(accountAsString, Account::class.java)
    }

    /*
    Credential initialization for Drive Access
     */
    private val credential: GoogleAccountCredential? by lazy {
        val cred = GoogleAccountCredential.usingOAuth2(
            appContext,
            Collections.singleton(DriveScopes.DRIVE_APPDATA)
        )
        cred.selectedAccount = account
        return@lazy cred
    }

    /*
    Drive Object Initialization
     */
    private val drive: Drive? by lazy {
        if (account == null) {
            null
        } else {
            Drive.Builder(
                NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                credential
            )
                .setApplicationName(getString(R.string.drive_backup_folder_name))
                .build()
        }
    }

    override suspend fun doWork(): Result {

        return try {

            delay(500)


            isUpload = inputData.getBoolean(BackupConstants.IS_UPLOAD, false)

            if (drive == null) {
                reason = appContext.getString(R.string.google_not_initialized)
                return Result.failure(
                    Data.Builder().putString(BackupConstants.REASON, reason).build()
                )
            } else {
                driverHelper = DriveHelper(drive!!)
                if (isUpload) {
                    localBackupFilePath = SharedPreferenceManager.getString(BackupConstants.BACKUP_FILE_PATH)
                    try {
                        launch(exceptionHandler) {
                            setProgress(
                                workDataOf(
                                    BackupConstants.REASON to BackupConstants.BACKUP_FILE_PATH,
                                    BackupConstants.BACKUP_FILE_PATH to localBackupFilePath
                                )
                            )
                        }
                    } catch (e: Throwable) {
                        LogMessage.e(e)
                    }
                    createBackupFileInMirrorFlyAppFolder()
                } else {
                    saveBackupFileToFolder(
                        inputData.getString("fileId")!!,
                        inputData.getString("fileName")!!
                    )
                }
            }

            exception?.let {
                val code: String
                when (it) {
                    is GoogleJsonResponseException -> {
                        val apiException = it
                        code = apiException.details.code.toString()
                        setProgress(
                            workDataOf(
                                BackupConstants.REASON to code,
                                BackupConstants.MESSAGE to apiException.details.message,
                                BackupConstants.BACKUP_FILE_PATH to localBackupFilePath
                            )
                        )
                    }
                    is UserRecoverableAuthIOException -> {
                        SharedPreferenceManager.setBoolean(BackupConstants.NEED_RELOGIN, true)
                        SharedPreferenceManager.setString(BackupConstants.DRIVE_EMAIL, emptyString())
                        code = "401"
                        setProgress(
                            workDataOf(
                                BackupConstants.REASON to code,
                                BackupConstants.MESSAGE to appContext.getString(R.string.drive_access_revoked),
                                BackupConstants.BACKUP_FILE_PATH to localBackupFilePath
                            )
                        )
                    }
                    else -> {
                        code = "100"
                        setProgress(
                            workDataOf(
                                BackupConstants.REASON to code,
                                BackupConstants.MESSAGE to appContext.getString(R.string.api_call_error),
                                BackupConstants.BACKUP_FILE_PATH to localBackupFilePath
                            )
                        )
                    }
                }
                delay(1000)
                Result.failure(Data.Builder().putString(BackupConstants.REASON, code).build())
            } ?: kotlin.run {
                LogMessage.e(TAG, " localBackupFilePath $localBackupFilePath")
                return Result.success(
                    Data.Builder()
                        .putBoolean(BackupConstants.IS_UPLOAD, isUpload)
                        .putString("reason", reason)
                        .putString(BackupConstants.BACKUP_FILE_PATH, localBackupFilePath).build()
                )
            }

        } catch (error: Throwable) {
            error.printStackTrace()
            if (isUpload) {
                WorkManagerController.retryAttemptLogic(runAttemptCount, error.localizedMessage)
            } else {
                Result.failure(Data.Builder().putString(BackupConstants.REASON, reason).build())
            }
        }

    }

    /**
     * Save backup file from User's Google Drive to  a local file
     *
     * @param fileId String id of the backup file to be downloaded.
     */
    private fun saveBackupFileToFolder(fileId: String, fileName: String) {

        val localBackupFile = generateBackUpFileAndReturnFile(fileName)
        localBackupFilePath = localBackupFile.absolutePath
        driverHelper!!.saveBackupFileFromDriveToLocal(fileId, localBackupFilePath, this)

    }

    /**
     *   Creates a backup file in Google Drive and upload the local file to Server
     *
     * @param parentFolderId String id of the parent folder in which the backup file is going to be created
     */
    private fun createBackupFileInMirrorFlyAppFolder() {
        val fileName = File(localBackupFilePath).name
        val driveUpload =
            driverHelper?.createFileWithProgress(fileName, localBackupFilePath, this)!!
        LogMessage.e(TAG, "createBackupFile id : ${driveUpload.first}")
        LogMessage.e(TAG, "createBackupFile exception : ${driveUpload.second}")
        driveUploadFileId = driveUpload.first
        exception = driveUpload.second
    }

    override fun progressChanged(downloader: MediaHttpDownloader?) {
        LogMessage.e(TAG, "progressChanged downloader")
        when (downloader!!.downloadState!!) {
            MediaHttpDownloader.DownloadState.MEDIA_IN_PROGRESS -> {
                LogMessage.e(TAG, "progressChanged downloader MEDIA_IN_PROGRESS ")
                val progressValue = (downloader.progress * 100).roundToInt()
                LogMessage.e(
                    TAG,
                    "progressChanged downloader MEDIA_IN_PROGRESS progressValue $progressValue"
                )
                launch(exceptionHandler) {
                    setProgress(
                        workDataOf(
                            BackupConstants.REASON to MediaHttpDownloader.DownloadState.MEDIA_IN_PROGRESS.name,
                            BackupConstants.PROGRESS to progressValue
                        )
                    )
                }
            }
            MediaHttpDownloader.DownloadState.MEDIA_COMPLETE -> {
                LogMessage.e(TAG, "progressChanged downloader MEDIA_COMPLETE")
                SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_PATH, localBackupFilePath)
                launch(exceptionHandler) {
                    setProgress(workDataOf(BackupConstants.REASON to MediaHttpDownloader.DownloadState.MEDIA_COMPLETE.name))
                }
            }
            else -> {
                LogMessage.d(
                    TAG,
                    "downloader UploadProgressListener ${downloader.downloadState!!.name}"
                )
            }
        }
    }

    override fun progressChanged(uploader: MediaHttpUploader?) {
        LogMessage.e(TAG, "progressChanged uploader")
        when (uploader!!.uploadState!!) {

            MediaHttpUploader.UploadState.MEDIA_IN_PROGRESS -> {
                LogMessage.e(TAG, "progressChanged uploader MEDIA_IN_PROGRESS ")
                val progressValue = (uploader.progress * 100).roundToInt()
                LogMessage.e(TAG, "progressChanged uploader MEDIA_IN_PROGRESS progressValue $progressValue")
                LogMessage.e(TAG, "progressChanged uploader localBackupFilePath $localBackupFilePath")
                launch(exceptionHandler) {
                    setProgress(
                        workDataOf(
                            BackupConstants.REASON to MediaHttpUploader.UploadState.MEDIA_IN_PROGRESS.name,
                            BackupConstants.PROGRESS to progressValue,
                            BackupConstants.BACKUP_FILE_PATH to localBackupFilePath
                        )
                    )
                }
            }
            
            MediaHttpUploader.UploadState.MEDIA_COMPLETE -> {
                LogMessage.e(TAG, "progressChanged uploader MEDIA_COMPLETE")
                GlobalScope.launch {

                    val backupData = Backup()
                    backupData.id = driveUploadFileId
                    backupData.backupSize = File(localBackupFilePath).length().toString()
                    backupData.backupType = Constants.DRIVE_BACKUP
                    backupData.backupTime = System.currentTimeMillis().toString()
                    val backupInfo = BackupInfo(backupData.backupSize, backupData.backupTime, false, driveUploadFileId)
                    SharedPreferenceManager.setString(BackupConstants.BACKUP_INFO, Utils.getGSONInstance().toJson(backupInfo))
                    SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_SIZE, backupData.backupSize)
                    SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_DATE, backupData.backupTime)
                    SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_PATH, localBackupFilePath)
                }
                launch(exceptionHandler) {
                    setProgress(
                        workDataOf(
                            BackupConstants.REASON to MediaHttpUploader.UploadState.MEDIA_COMPLETE.name,
                            BackupConstants.BACKUP_FILE_PATH to localBackupFilePath
                        )
                    )
                }
            }
            else -> {
                LogMessage.d(
                    TAG,
                    "uploader UploadProgressListener ${uploader.uploadState!!.name}"
                )
            }
        }
    }

    /**
     * Create a empty backup file in the application's backup  folder
     *
     * @param fileName String
     * @return File
     */
    private fun generateBackUpFileAndReturnFile(fileName: String): File {
        val backupFolderPath = getBackUpFolderPath()
        val backupFolder = File(backupFolderPath)

        if (!backupFolder.exists()) {
            backupFolder.mkdirs()
        }

        val backupFile = File(backupFolder, fileName)
        if (!backupFile.exists()) {
            backupFile.createNewFile()
        }
        return backupFile
    }

    /**
     * Provides the folder path for Backup file to be saved.
     *
     * @return String
     */
    private fun getBackUpFolderPath(): String {
        val rootFilePath: String = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            Environment.getExternalStorageDirectory().absolutePath
        } else {
            ChatManager.applicationContext.externalMediaDirs[0].absolutePath
        }

        return rootFilePath + File.separator +
                ChatManager.applicationContext.resources.getString(com.mirrorflysdk.R.string.title_app_name)
                    .replace(" ", "") + File.separator + Constants.BACKUP_FOLDER.also {
            LogMessage.i(TAG, "getBackUpFolderPath: $it")
        }
    }

}