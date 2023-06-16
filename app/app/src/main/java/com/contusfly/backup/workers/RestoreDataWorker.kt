package com.contusfly.backup.workers

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.*
import com.contusfly.R
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.activities.BackUpActivity
import com.contusfly.activities.RestoreActivity
import com.contusfly.backup.BackupConstants
import com.contusfly.backup.WorkManagerController
import com.contusfly.utils.Constants
import com.mirrorflysdk.backup.RestoreListener
import com.mirrorflysdk.backup.RestoreManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

class RestoreDataWorker(private val appContext: Context, workerParams: WorkerParameters) : CoroutineWorker(appContext, workerParams) {

    companion object {

        val CHANNEL_ID="Restore_Process_Channel"

        private lateinit var workerProgress: BackUpActivity.WorkerProgress

        private lateinit var restoreWorkerProgress: RestoreActivity.RestoreWorkerProgress
        fun setRestoreCallBack(workerProgress: BackUpActivity.WorkerProgress) {
            this.workerProgress = workerProgress
        }
        fun setRestoreInStarActivityCallBack(restoreWorkerProgress: RestoreActivity.RestoreWorkerProgress){
            this.restoreWorkerProgress=restoreWorkerProgress
        }
        fun isWorkProgressInitialized()=this::workerProgress.isInitialized

        fun isRestoreWorkProgressInitialized()=this::restoreWorkerProgress.isInitialized
    }

    override suspend fun doWork(): Result {

        return try {

            val filePath = inputData.getString(BackupConstants.BACKUP_FILE_PATH)!!

            filePath.let {
                val file  = File(it)
                RestoreManager.restoreData(file,object:RestoreListener{
                    override fun onFailure(reason: String) {
                        LogMessage.e(
                            "RestoreDataWorker",
                            "RestoreManager.restoreData() onFailure() reason $reason"
                        )
                        workerProgressOnFailure(reason)
                        WorkManagerController.retryAttemptLogic(runAttemptCount)
                    }

                    override fun onProgressChanged(percentage: Int) {
                        updateRestoreNotification(percentage)
                        LogMessage.e(
                            "RestoreDataWorker",
                            "RestoreManager.restoreData() onProgressChanged() percentage $percentage"
                        )

                        GlobalScope.launch{
                            setProgress(workDataOf(BackupConstants.PROGRESS to percentage))
                        }
                        workerProgressOnProgress(percentage)
                    }

                    override fun onSuccess() {
                        LogMessage.e(
                            "RestoreDataWorker",
                            "RestoreManager.restoreData() onSuccess() "
                        )
                        workerProgressOnSuccess()
                        restoreCompletedNotify()
                    }

                })
            }
            Result.success(Data.Builder().putString(BackupConstants.BACKUP_FILE_PATH, filePath).build())
        } catch (error: Throwable) {
            LogMessage.e(error)
            Result.failure()
        }

    }

    private fun workerProgressOnFailure(reason:String){
        if (isWorkProgressInitialized())
            workerProgress.onFailure(reason)
        if (isRestoreWorkProgressInitialized())
            restoreWorkerProgress.onFailure(reason)
    }

    private fun workerProgressOnProgress(percentage: Int){
        if (isWorkProgressInitialized())
            workerProgress.onProgressChanged(percentage)
        if (isRestoreWorkProgressInitialized())
            restoreWorkerProgress.onProgressChanged(percentage)
    }

    private fun workerProgressOnSuccess(){
        if (isWorkProgressInitialized())
            workerProgress.onSuccess()
        if (isRestoreWorkProgressInitialized())
            restoreWorkerProgress.onSuccess()
    }

    private fun updateRestoreNotification(progress: Int) {
        val builder = NotificationCompat.Builder(appContext, CHANNEL_ID)
            .setContentTitle("Restore Progress $progress%")
            .setSmallIcon(R.drawable.ic_notification_blue)
            .setOngoing(true)
            .setProgress(100, progress, false)

        val mNotifyManager =
            appContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotifyManager.notify(Constants.NOTIFICATION_ID, builder.build())

    }

    private fun restoreCompletedNotify() {
        val builder=NotificationCompat.Builder(appContext, CHANNEL_ID)
            .setContentTitle("Restore progress completed 100%")
            .setSmallIcon(R.drawable.ic_notification_blue)
            .setOngoing(false)
            .setProgress(100, 100, false)

        val mNotifyManager = appContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotifyManager.notify(Constants.NOTIFICATION_ID, builder.build())
    }

}