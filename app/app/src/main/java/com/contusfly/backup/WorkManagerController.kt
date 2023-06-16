package com.contusfly.backup

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.work.*
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.backup.workers.*
import com.contusfly.emptyString
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

object WorkManagerController {

    private val appContext by lazy { ChatManager.applicationContext }

    private val workManager: WorkManager by lazy { WorkManager.getInstance(appContext) }

    /**
     * Cancels all the running and scheduled backup workers
     */
    fun cancelBackupWorkers() {
        workManager.cancelAllWorkByTag(BackupConstants.BACKUP_WORKER_TAG)
        workManager.cancelAllWorkByTag(BackupConstants.DRIVE_WORKER_TAG)
        workManager.cancelAllWorkByTag(BackupConstants.CLEANUP_WORKER_TAG)
    }

    /**
     * Cancels all the running and scheduled backup workers
     */
    fun cancelAutoBackupWorkers() {
        workManager.cancelAllWorkByTag(BackupConstants.BACKUP_AUTO_WORKER_TAG)
        workManager.cancelAllWorkByTag(BackupConstants.DRIVE_WORKER_TAG)
        workManager.cancelAllWorkByTag(BackupConstants.CLEANUP_WORKER_TAG)
    }

    /**
     * Cancels all the running and scheduled restore workers
     */
    fun cancelRestoreWorkers() {
        workManager.cancelAllWorkByTag(BackupConstants.RESTORE_WORKER_TAG)
        workManager.cancelAllWorkByTag(BackupConstants.DRIVE_WORKER_TAG)
        workManager.cancelAllWorkByTag(BackupConstants.CLEANUP_WORKER_TAG)
    }

    /**
     * Constraints for the Workers
     *
     * @param isDownload Boolean
     * @return Constraints
     */
    private fun getConstraint(isDownload: Boolean = false): Constraints {

        val isBackupOnlyOnWifi = SharedPreferenceManager.getBoolean(BackupConstants.WIFI_BACKUP_ONLY)

        val builder = Constraints.Builder()
        builder.setRequiresStorageNotLow(true)

        if (isDownload || !isBackupOnlyOnWifi) {
            builder.setRequiredNetworkType(NetworkType.CONNECTED)
        } else {
            builder.setRequiredNetworkType(NetworkType.UNMETERED)
        }
        return builder.build()
    }

    /**
     * Retry Logic for workers in case of unexpected exception or scenarios
     *
     * @param runAttemptCount Int retry attempt made till
     * @param reason String reason that stopped the worker
     * @return ListenableWorker.Result
     */
    fun retryAttemptLogic(
        runAttemptCount: Int,
        reason: String = emptyString()
    ): ListenableWorker.Result {
        return if (runAttemptCount > 5) {
            ListenableWorker.Result.retry()
        } else {
            ListenableWorker.Result.failure(
                Data.Builder().putString(BackupConstants.REASON, reason).build()
            )
        }
    }

    /**
     * Triggers the Auto Backup Process
     */
    fun startBackingUp() {
        if (SharedPreferenceManager.getBoolean(BackupConstants.AUTO_BACKUP)) {
            backUpDriveUploadIsAutoBack(true)
        }
    }

    /**
     * Deletes a file in the device
     * @param filepath String path of the file to be deleted
     */
    fun deleteAFileByPath(filepath: String) {
        if (ChatUtils.checkWritePermission(
                appContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            val fileToBeDeleted = File(filepath)
            if (fileToBeDeleted.exists()) {
                if (fileToBeDeleted.delete()) {
                    LogMessage.i(TAG,"file Deleted :$filepath")
                } else {
                    LogMessage.i(TAG,"file not Deleted :$filepath")
                }
            } else {
                Toast.makeText(appContext, appContext.getString(R.string.file_not_available), Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(appContext, appContext.getString(R.string.permission_not_given), Toast.LENGTH_SHORT).show()
        }
    }


    /**
     * Checks whether the User logged in for Google Account
     * @return Boolean
     */
    fun checkGoogleLogin(): Boolean {
        return GoogleSignIn.getLastSignedInAccount(appContext) != null
    }

    fun runBackupOnly(): UUID {

        cancelBackupWorkers()

        val backUpWorker = OneTimeWorkRequestBuilder<BackUpDataWorker>()
            .addTag(BackupConstants.BACKUP_WORKER_TAG)
            .setInputData(
                Data.Builder().putBoolean(BackupConstants.IS_PERIODIC, false).build()
            )
            .setConstraints(Constraints.Builder().setRequiresStorageNotLow(true).build())
            .build()

        WorkManager.getInstance(appContext).beginUniqueWork(
            BackupConstants.BACKUP_PROCESS_UNIQUE,
            ExistingWorkPolicy.REPLACE,
            backUpWorker
        ).enqueue()

        return backUpWorker.id

    }

    fun runDriveUpload(wifiOnly: Boolean = false): UUID {
        val workers = getDriveWithCleanWorker(wifiOnly)
        if (checkGoogleLogin()) {
            WorkManager.getInstance(appContext).beginUniqueWork(
                BackupConstants.DRIVE_PROCESS_UNIQUE,
                ExistingWorkPolicy.REPLACE,
                workers.first
            )
                .then(workers.second)
                .enqueue()
        }

        return workers.first.id
    }

    private fun getDriveWithCleanWorker(wifiOnly: Boolean): Pair<OneTimeWorkRequest, OneTimeWorkRequest> {
        val driveUploadWorker =
            OneTimeWorkRequestBuilder<GoogleDriveWorker>().addTag(BackupConstants.DRIVE_WORKER_TAG)

        if (wifiOnly) {
            driveUploadWorker.setConstraints(
                Constraints.Builder().setRequiredNetworkType(
                    NetworkType.UNMETERED
                ).build()
            )
        } else {
            driveUploadWorker.setConstraints(
                Constraints.Builder().setRequiredNetworkType(
                    NetworkType.CONNECTED
                ).build()
            )
        }
        val driverWorker = driveUploadWorker.setInputData(
            Data.Builder().putBoolean(BackupConstants.IS_UPLOAD, true).putString(
                BackupConstants.BACKUP_FILE_PATH,
                SharedPreferenceManager.getString(BackupConstants.BACKUP_FILE_PATH)
            ).build()
        )
            .build()

        val cleanupWorker = OneTimeWorkRequestBuilder<CleanUpWorker>()
            .addTag(BackupConstants.CLEANUP_WORKER_TAG)
            .setInputData(
                Data.Builder().putString(
                    BackupConstants.BACKUP_FILE_PATH,
                    SharedPreferenceManager.getString(BackupConstants.BACKUP_FILE_PATH)
                ).build()
            )
            .build()
        return Pair(driverWorker, cleanupWorker)
    }

    fun resetBackupData() {
        SharedPreferenceManager.setString(BackupConstants.BACKUP_INFO, emptyString())
        SharedPreferenceManager.setBoolean(BackupConstants.SHOULD_SHOW_RESTORE, false)
    }

    fun isNetConnected(): Boolean {
        val conMgr =
            appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return conMgr.activeNetworkInfo != null && conMgr.activeNetworkInfo!!.isConnected
    }

    fun isConnectedToWifi(): Boolean {
        val connMgr =
            appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        connMgr ?: return false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network: Network = connMgr.activeNetwork ?: return false
            val capabilities = connMgr.getNetworkCapabilities(network)
            return capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        } else {
            val networkInfo = connMgr.activeNetworkInfo ?: return false
            return networkInfo.isConnected && networkInfo.type == ConnectivityManager.TYPE_WIFI
        }
    }

    fun checkWifiLogic(): Boolean =
        SharedPreferenceManager.getBoolean(BackupConstants.WIFI_BACKUP_ONLY) && !isConnectedToWifi() && isNetConnected()

    suspend fun checkIfAWorkerIsAlreadyScheduledOrNot(tag: String): Boolean {

        val workInfo = workManager.getWorkInfosByTag(tag).await()

        return if (!workInfo.isNullOrEmpty()) {

            val worker = workInfo[0]

            Log.d("WK_TEST", "$tag ${worker.state}")

            worker.state == WorkInfo.State.BLOCKED || worker.state == WorkInfo.State.ENQUEUED || worker.state == WorkInfo.State.RUNNING

        } else {
            Log.d("WK_TEST", "$tag not enqued")
            false
        }
    }


    fun checkRoaming(context: Context): Boolean {
        return try {
            val telephony = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            telephony.isNetworkRoaming
        } catch (exception: Exception) {
            false
        }
    }

    fun backUpDriveUploadIsAutoBack(isBackupActivity: Boolean = false): UUID {
        cancelAutoBackupWorkers()
        LogMessage.i(TAG, "AUTO_BACKUP ${SharedPreferenceManager.getBoolean(BackupConstants.AUTO_BACKUP)}")
        val scheduledTime = SharedPreferenceManager.getString(BackupConstants.BACKUP_FREQUENCY)
        val repeatedInterval = when (scheduledTime) {
            BackupConstants.DAILY -> 1
            BackupConstants.WEEKLY -> 7
            else -> 30
        }.toLong()

        val constraints = Constraints.Builder()
            .setRequiresStorageNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val data = Data.Builder().putBoolean(BackupConstants.IS_PERIODIC, true)
            .putBoolean(BackupConstants.AUTO_BACKUP, isBackupActivity).build()
        val backUpWorker = PeriodicWorkRequestBuilder<BackUpDataWorker>(repeatedInterval, TimeUnit.DAYS)
            .setInputData(data)
            .setConstraints(constraints)
            .setBackoffCriteria(BackoffPolicy.LINEAR, WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)
            .addTag(BackupConstants.BACKUP_AUTO_WORKER_TAG)
            .build()
        WorkManager.getInstance(appContext).enqueueUniquePeriodicWork(BackupConstants.BACKUP_PERIODIC_PROCESS_UNIQUE,
            ExistingPeriodicWorkPolicy.KEEP, backUpWorker)
        return backUpWorker.id
    }

    fun backUpDriveUpload(isBackupActivity: Boolean = false): Triple<UUID, UUID, UUID> {
        cancelBackupWorkers()
        LogMessage.i(TAG, "AUTO_BACKUP ${SharedPreferenceManager.getBoolean(BackupConstants.AUTO_BACKUP)}")
        val backUpWorker = OneTimeWorkRequestBuilder<BackUpDataWorker>()
            .setInputData(
                Data.Builder().putBoolean(BackupConstants.IS_PERIODIC, false)
                    .putBoolean(BackupConstants.AUTO_BACKUP, isBackupActivity).build()
            )
            .addTag(BackupConstants.BACKUP_WORKER_TAG)
            .setConstraints(Constraints.Builder().setRequiresStorageNotLow(true).build())
            .build()

        val workers = getDriveWithCleanWorker(SharedPreferenceManager.getBoolean(BackupConstants.WIFI_BACKUP_ONLY))

        if (checkGoogleLogin()) {
            WorkManager.getInstance(appContext).beginUniqueWork(
                BackupConstants.DRIVE_PROCESS_UNIQUE,
                ExistingWorkPolicy.REPLACE,
                backUpWorker
            )
                .then(workers.first)
                .then(workers.second)
                .enqueue()
        }

        return Triple(backUpWorker.id, workers.first.id, workers.second.id)
    }

    /**
     * Enqueue the workers for User's Google Drive Restore Process
     *
     * @param fileId String id of the file to be Downloaded from User's Google Drive
     * @return Triple<UUID, UUID, UUID> id of all the workers
     */
    fun runDriveRestoreWorkers(fileId: String, fileName: String): Triple<UUID, UUID, UUID> {

        cancelRestoreWorkers()

        val driveWorker = OneTimeWorkRequestBuilder<GoogleDriveWorker>()
            .addTag(BackupConstants.DRIVE_WORKER_TAG)
            .setInputData(
                Data.Builder().putBoolean(BackupConstants.IS_UPLOAD, false)
                    .putString("fileId", fileId).putString("fileName", fileName).build()
            )
            .setConstraints(getConstraint(true))
            .build()

        val restoreWorker = OneTimeWorkRequestBuilder<RestoreDataWorker>()
            .addTag(BackupConstants.RESTORE_WORKER_TAG)
            .build()

        val cleanupWorker = OneTimeWorkRequestBuilder<CleanUpWorker>()
            .addTag(BackupConstants.CLEANUP_WORKER_TAG)
            .build()

        if (ChatUtils.checkWritePermission(
                appContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            if (checkGoogleLogin()) {
                WorkManager.getInstance(appContext).beginUniqueWork(
                    BackupConstants.RESTORE_PROCESS_UNIQUE,
                    ExistingWorkPolicy.REPLACE,
                    driveWorker
                )
                    .then(restoreWorker)
                    .enqueue()

            }
        } else {
            LogMessage.e(
                "No Storage Permission!",
                "Enable storage permission to take backup"
            )
        }
        return Triple(driveWorker.id, restoreWorker.id, cleanupWorker.id)
    }

    fun runRestoreOnly(filepath: String): UUID {

        cancelRestoreWorkers()

        val restoreWorker = OneTimeWorkRequestBuilder<RestoreDataWorker>()
            .addTag(BackupConstants.RESTORE_WORKER_TAG)
            .setInputData(
                Data.Builder().putString(BackupConstants.BACKUP_FILE_PATH, filepath).build()
            )
            .setConstraints(Constraints.Builder().setRequiresStorageNotLow(true).build())
            .build()

        WorkManager.getInstance(appContext).beginUniqueWork(
            BackupConstants.RESTORE_PROCESS_UNIQUE,
            ExistingWorkPolicy.REPLACE,
            restoreWorker
        ).enqueue()

        return restoreWorker.id

    }
}