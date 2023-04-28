package com.contusfly.backup.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.contusfly.activities.BackUpActivity
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.backup.BackupConstants
import com.contusfly.backup.WorkManagerController
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.backup.BackupListener
import com.mirrorflysdk.backup.BackupManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/**
 * Worker Class for managing Backup
 */
class BackUpDataWorker(val appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    var filePath: String = ""

    private val isAutoBackup by lazy {
        inputData.getBoolean(BackupConstants.AUTO_BACKUP, false)
    }
    private val isPeriodic by lazy {
        inputData.getBoolean(BackupConstants.IS_PERIODIC, false)
    }

    companion object {

        private lateinit var workerProgress: BackUpActivity.WorkerProgress
        fun setBackupCallBack(workerProgress: BackUpActivity.WorkerProgress) {
            this.workerProgress = workerProgress
        }

        fun isWorkProgressInitialized()=this::workerProgress.isInitialized
    }

    override suspend fun doWork(): Result {
        return try {
            BackupManager.startBackup(object : BackupListener {
                override fun onFailure(reason: String) {
                    LogMessage.e(
                        "BackUpDataWorker",
                        "BackupManager.startBackup() onFailure() reason $reason"
                    )
                    if (isWorkProgressInitialized())
                        workerProgress.onFailure(reason)
                    WorkManagerController.retryAttemptLogic(runAttemptCount)
                }

                override fun onProgressChanged(percentage: Int) {
                    LogMessage.e(
                        "BackUpDataWorker",
                        "BackupManager.startBackup() onProgressChanged() percentage $percentage"
                    )
                    if (isWorkProgressInitialized())
                        workerProgress.onProgressChanged(percentage)
                    GlobalScope.launch{
                        setProgress(workDataOf(BackupConstants.PROGRESS to percentage))
                    }
                }

                override fun onSuccess(backUpFilePath: String) {
                    LogMessage.e(
                        "BackUpDataWorker",
                        "BackupManager.startBackup() onSuccess() backUpFilePath $backUpFilePath"
                    )
                    if (isWorkProgressInitialized())
                        workerProgress.onSuccess()
                    filePath = backUpFilePath
                    SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_PATH, filePath)
                    onBackupSuccess()
                }
            })

            Result.success(
                Data.Builder()
                    .putString(BackupConstants.BACKUP_FILE_PATH, filePath)
                    .putBoolean(BackupConstants.IS_UPLOAD, true)
                    .putBoolean(BackupConstants.AUTO_BACKUP, isAutoBackup)
                    .build()
            )
        } catch (error: Throwable) {
            LogMessage.e(error)
            WorkManagerController.retryAttemptLogic(runAttemptCount)
        }

    }

    private fun onBackupSuccess() {
        if (!isAutoBackup)
            LogMessage.e("BackUpDataWorker", " !isAutoBackup filePath $filePath")
        else if (isPeriodic) {
            LogMessage.e("BackUpDataWorker", " isPeriodic isPeriodic $isPeriodic")
            if (SharedPreferenceManager.getString(BackupConstants.BACKUP_TYPE) == Constants.DRIVE_BACKUP) {
                GlobalScope.launch {
                    if (!WorkManagerController.checkIfAWorkerIsAlreadyScheduledOrNot(
                            BackupConstants.DRIVE_WORKER_TAG
                        )
                    ) {
                        WorkManagerController.runDriveUpload()
                    }
                }

            }
        } else LogMessage.e("BackUpDataWorker", " isPeriodic isPeriodic $isPeriodic")
    }
}