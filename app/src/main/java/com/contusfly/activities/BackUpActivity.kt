package com.contusfly.activities

import android.Manifest
import android.accounts.AccountManager
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import androidx.work.Data
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.backup.BackupConstants
import com.contusfly.backup.BackupConstants.ACCOUNT_PERMS_REQUEST_CODE
import com.contusfly.backup.BackupConstants.REQUEST_CODE_CHOOSE_ACCOUNT
import com.contusfly.backup.BackupConstants.REQUEST_CODE_SIGN_IN
import com.contusfly.backup.BackupRestoreParent
import com.contusfly.backup.TimeAgo
import com.contusfly.backup.WorkManagerController
import com.contusfly.backup.workers.BackUpDataWorker
import com.contusfly.backup.workers.RestoreDataWorker
import com.contusfly.chat.RealPathUtil
import com.contusfly.checkInternetAndExecute
import com.contusfly.databinding.ActivityBackUpBinding
import com.contusfly.databinding.BackupDialogBinding
import com.contusfly.databinding.ConnectivityDialogBinding
import com.contusfly.emptyString
import com.contusfly.getFileSizeInStringFormat
import com.contusfly.gone
import com.contusfly.hasActiveInternet
import com.contusfly.isPermissionsAllowed
import com.contusfly.show
import com.contusfly.showToast
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.MediaPermissions
import com.contusfly.utils.PickFileUtils
import com.contusfly.utils.RequestCode
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.PermissionAlertDialog
import com.google.api.client.googleapis.media.MediaHttpUploader
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.backup.BackupManager
import com.mirrorflysdk.backup.RestoreManager
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.util.LinkedList
import java.util.UUID
import kotlin.coroutines.CoroutineContext


open class BackUpActivity : BackupRestoreParent(), CoroutineScope,
    BackupRestoreParent.CommonBackupDialogListener {

    private lateinit var activityBackUpBinding: ActivityBackUpBinding
    private lateinit var dialogBinding: BackupDialogBinding
    private lateinit var connectdialogBinding: ConnectivityDialogBinding

    private var isDriveBackup = false

    /**
     * Work manger instance
     */
    private val workManager: WorkManager = WorkManager.getInstance(this)

    /**
     * Ids of the workers
     */
    private lateinit var backupWorkerID: UUID
    private lateinit var driveUploadWorkerID: UUID
    private lateinit var restoreWorkerID: UUID

    /**
     * Workers Progress LiveData Observers
     */
    private lateinit var backupWorker: LiveData<WorkInfo>
    private lateinit var driveUploadWorker: LiveData<WorkInfo>
    private lateinit var restoreDataWorker: LiveData<WorkInfo>

    private var genericDialog: AlertDialog? = null
    private var backupProgressBar: ProgressBar? = null
    private var titleTv: AppCompatTextView? = null
    private var backupProgressText: AppCompatTextView? = null
    private var fileSize = 0L
    private var fileSizeString = "0 KB"
    private var filePath = emptyString()
    private var totalCount: Long = 0L
    private var isUploadInEnqueuedState = false
    private var alertDialog: AlertDialog? = null
    private var isOnlyBackup: Boolean = false

    protected val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }


    private val uploadWorkerGeneric by lazy {
        workManager.getWorkInfosByTagLiveData(BackupConstants.DRIVE_WORKER_TAG)
    }

    private val backupWorkerGeneric =
        workManager.getWorkInfosByTagLiveData(BackupConstants.BACKUP_WORKER_TAG)


    private val downloadPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val writePermissionGranted = permissions[Manifest.permission.WRITE_EXTERNAL_STORAGE]
            ?: ChatUtils.checkWritePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (writePermissionGranted) {
            activityBackUpBinding.backup.performClick()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBackUpBinding = ActivityBackUpBinding.inflate(layoutInflater)
        setContentView(activityBackUpBinding.root)
        setLastBackupInfo()
        SharedPreferenceManager.setString(BackupConstants.BACKUP_TYPE, Constants.DRIVE_BACKUP)
        isDriveBackup =
            SharedPreferenceManager.getString(BackupConstants.BACKUP_TYPE) == Constants.DRIVE_BACKUP
        setCommonBackupDialogListener(this)
        if (isDriveBackup) {
            activityBackUpBinding.backupInfoText.text = getString(R.string.backup_info_text)
            setDriveEmailUI()
        } else {
            activityBackUpBinding.driveBox.gone()
        }
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.GET_ACCOUNTS), 202)
    }

    private fun setDriveEmailUI() {
        val myEmail = SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL)
        activityBackUpBinding.driveEmail.text =
            if (myEmail.isEmpty()) getString(R.string.select_gmail_account) else myEmail
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        getRecentChatCount()
        val autoBackupOption = SharedPreferenceManager.getBoolean(BackupConstants.AUTO_BACKUP)
        activityBackUpBinding.autoSwitch.isChecked = autoBackupOption

        if (autoBackupOption) activityBackUpBinding.scheduleBox.show() else activityBackUpBinding.scheduleBox.gone()

        setConnectivityText()

        setFrequencyText()


        activityBackUpBinding.autoSwitch.setOnCheckedChangeListener { _, isChecked ->
            onAutoSwitchClicked(isChecked)
        }

        activityBackUpBinding.scheduleBox.setOnClickListener {
            showFrequencyDialog()
        }

        activityBackUpBinding.backupOverBox.setOnClickListener {
            showConnectivityDialog()
        }

        activityBackUpBinding.backBtn.setOnClickListener {
            finish()
        }

        activityBackUpBinding.backup.setOnClickListener {
            isOnlyBackup = false
            onBackupClicked()
        }

        activityBackUpBinding.cancelBackup.setOnClickListener {
            if (isDriveBackup && ::driveUploadWorkerID.isInitialized) workManager.cancelWorkById(
                driveUploadWorkerID
            )
            BackupManager.cancelBackup()
            LogMessage.e(TAG, "cancelBackup BACKUP_FILE_PATH empty")
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_PATH, emptyString())
            resetBackupUI()
        }

        activityBackUpBinding.localCancelBackup.setOnClickListener {
            if (isOnlyBackup && ::backupWorkerID.isInitialized) {
                workManager.cancelWorkById(backupWorkerID)
                BackupManager.cancelBackup()
            } else if (::restoreWorkerID.isInitialized) {
                RestoreManager.cancelRestore()
                workManager.cancelWorkById(restoreWorkerID)
            }
            LogMessage.e(TAG, "cancelBackup BACKUP_FILE_PATH empty")
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_PATH, emptyString())
            resetUI()
        }

        activityBackUpBinding.accountBox.setOnClickListener {
            launch {
                val isNetworkUp = checkInternetUp()
                withContext(Dispatchers.Main.immediate) {
                    if (isNetworkUp) getAllGoogleAccounts() else showToast(getString(R.string.msg_no_internet))
                }
            }
        }

        activityBackUpBinding.downloadBackup.setOnClickListener {
            isOnlyBackup = true
            onDownloadClicked()
        }

        activityBackUpBinding.restoreData.setOnClickListener {
            isOnlyBackup = false
            onRestoreClicked()
        }

        genericWorkerObserver()

    }

    private fun onDownloadClicked() {
        if (totalCount <= 0)
            showToast(getString(R.string.no_msg_backup))
        else if (ChatUtils.checkWritePermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            LogMessage.d(TAG, "#backup startBackup")
            onlyBackUpInit()
        } else
            MediaPermissions.requestContactStorageAccess(
                this,
                permissionAlertDialog,
                downloadPermissionLauncher
            )
    }

    private fun onRestoreClicked() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            if (MediaPermissions.isReadFilePermissionAllowed(this)
                && MediaPermissions.isWriteFilePermissionAllowed(this)
            )
                PickFileUtils.pickFile(this)
            else
                MediaPermissions.requestStorageAccess(
                    this,
                    permissionAlertDialog,
                    filePermissionLauncher
                )
        } else {
            PickFileUtils.pickFile(this)
        }
    }

    private fun onBackupClicked() {
        isUploadInEnqueuedState = false
        if (totalCount <= 0)
            showToast(getString(R.string.no_msg_backup))
        else if (ChatUtils.checkWritePermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            startBackUp()
        } else
            MediaPermissions.requestContactStorageAccess(
                this,
                permissionAlertDialog,
                downloadPermissionLauncher
            )
    }

    private fun startBackUp() {
        if (SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL).isEmpty())
            showToast(getString(R.string.select_google_account))
        else {
            launch {
                val isNetworkUp = checkInternetUp()
                withContext(Dispatchers.Main.immediate) {
                    if (isNetworkUp) {
                        if (WorkManagerController.checkGoogleLogin()) {
                            showBackupDialog()
                            initWorkers()
                        } else showToast(getString(R.string.google_logout_info))
                    } else showToast(getString(R.string.msg_no_internet))
                }
            }
        }
    }

    private fun initWorkers() {
        if (WorkManagerController.checkWifiLogic()
            || !WorkManagerController.isNetConnected()
            || WorkManagerController.checkRoaming(this@BackUpActivity)
            || isOnlyBackup
        ) onlyBackUpInit() else driveBackupInit()
    }

    private fun driveBackupInit() {
        if (!SharedPreferenceManager.getBoolean(BackupConstants.AUTO_BACKUP)) {
            val workerIds =
                WorkManagerController.backUpDriveUpload(false)
            backupWorkerID = workerIds.first
            initBackupWorker(backupWorkerID)
            driveUploadWorkerID = workerIds.second
            LogMessage.e(
                TAG,
                "activityBackUpBinding.backup driveUploadWorkerID initDriveWorker"
            )
        } else {
            autoBackupInit()
        }
    }

    private fun autoBackupInit() {
        if (SharedPreferenceManager.getBoolean(BackupConstants.AUTO_BACKUP)) {
            val workerIds =
                WorkManagerController.backUpDriveUploadIsAutoBack(
                    true
                )
            backupWorkerID = workerIds
            LogMessage.e(
                TAG,
                "activityBackUpBinding.backup backupWorkerID auto backup"
            )
            initBackupWorker(backupWorkerID)
        }
    }

    private fun onlyBackUpInit() {
        if (isOnlyBackup) showDownloadUI("Downloading : 0.0KB  of $fileSizeString (0%)")
        backupWorkerID =
            WorkManagerController.runBackupOnly()
        LogMessage.e(
            TAG,
            "#backup activityBackUpBinding.backup only backupWorkerID"
        )
        initBackupWorker(backupWorkerID)
    }

    /**
     * Updates the UI when downloading backup file is in downloading state
     *
     * @param infoText String either no internet or progress status string
     */
    private fun showDownloadUI(infoText: String) {
        activityBackUpBinding.localProgressText.text = infoText
        activityBackUpBinding.localWorkProgress.progress = 0
        activityBackUpBinding.downloadBackup.gone()
        activityBackUpBinding.restoreData.gone()
        activityBackUpBinding.localProgressBox.show()
    }

    private fun onAutoSwitchClicked(isChecked: Boolean) {
        SharedPreferenceManager.setBoolean(BackupConstants.AUTO_BACKUP, isChecked)
        if (!isChecked) {
            WorkManagerController.cancelAutoBackupWorkers()
        } else {
            WorkManagerController.cancelBackupWorkers()
        }
        if (SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL).isEmpty()) {
            activityBackUpBinding.autoSwitch.isChecked = false
            showToast(getString(R.string.select_google_account))
        } else {
            if (isChecked) {
                activityBackUpBinding.scheduleBox.show()
                showFrequencyDialog()
            } else {
                activityBackUpBinding.scheduleBox.gone()
                WorkManagerController.cancelAutoBackupWorkers()
            }
        }
    }

    private fun getRecentChatCount() {
        FlyCore.getRecentChatList { isSuccess, _, data ->
            if (isSuccess) {
                val list =
                    LinkedList(data[com.contusfly.utils.Constants.SDK_DATA] as MutableList<RecentChat>)
                totalCount = list.size.toLong()
            }
        }

        val callEntryCount = CallLogManager.getCallLogs()

        if (callEntryCount.isNotEmpty()) {
            totalCount += callEntryCount.size
        }

    }

    private fun genericWorkerObserver() {
        uploadWorkerGeneric.observe(this) {
            if (it!!.isNotEmpty()) {
                val workerInfo = it.first()
                LogMessage.e(TAG, "uploadWorkerGeneric::" + workerInfo.state)
                when (workerInfo.state) {
                    WorkInfo.State.ENQUEUED, WorkInfo.State.BLOCKED -> setFilePathIfEmpty()
                    WorkInfo.State.RUNNING -> onUploadWorkerGenericRunning(workerInfo!!)
                    WorkInfo.State.SUCCEEDED -> setLastBackupInfo()
                    else -> Log.d(TAG, "${workerInfo.state}")
                }
            }
        }

        backupWorkerGeneric.observe(this) {
            if (it!!.isNotEmpty()) {
                val workerInfo = it.first()
                when (workerInfo.state) {
                    WorkInfo.State.RUNNING -> onBackupWorkerGenericRunning(workerInfo!!)
                    else -> Log.d(TAG, "${workerInfo.state}")
                }
            }
        }

    }

    private fun onBackupWorkerGenericRunning(workerInfo: WorkInfo) {
        if (!::backupWorkerID.isInitialized) {
            backupWorkerID = workerInfo.id
            initBackupWorker(workerInfo.id)
            showBackupDialog()
        }
    }

    private fun onUploadWorkerGenericRunning(workerInfo: WorkInfo) {
        LogMessage.e(TAG, "uploadWorkerGeneric RUNNING")
        setFilePathIfEmpty()
        if (isDriveBackup && !::driveUploadWorkerID.isInitialized) {
            LogMessage.e(TAG, "uploadWorkerGeneric driveUploadWorkerID initDriveWorker")
            driveUploadWorkerID = workerInfo.id
            initDriveWorker(driveUploadWorkerID)
        }
    }

    private fun setFilePathIfEmpty() {
        if (filePath.isEmpty() && !SharedPreferenceManager.getString(BackupConstants.BACKUP_FILE_PATH)
                .isNullOrEmpty()
        ) {
            setFileInfo(SharedPreferenceManager.getString(BackupConstants.BACKUP_FILE_PATH))
            activityBackUpBinding.uploadingProgressText.text =
                "Uploading : 0 KB  of $fileSizeString (0%)"
        }
    }

    private fun setFileInfo(fileLocalPath: String) {
        if (fileSize == 0L && fileLocalPath.isNotEmpty()) {
            LogMessage.e(TAG, "setFileInfo $fileLocalPath")
            filePath = fileLocalPath
            fileSize = File(filePath).length()
            fileSizeString = getFileSizeInStringFormat(fileSize)!!
            LogMessage.e(TAG, "file size--->$fileSize file size string--->$fileSizeString")
            Log.d("BACKUP_BACKUP", "$filePath $fileSize")
        }
    }


    /**
     * Initialization of  Drive upload worker and its the Observers
     *
     * @param id UUID of the worker
     */
    private fun initDriveWorker(id: UUID) {
        var workerInfo: WorkInfo?
        val context = this
        driveUploadWorker = workManager.getWorkInfoByIdLiveData(id)
        launch(Dispatchers.Main.immediate) {
            driveUploadWorker.observe(context) {

                it?.let {

                    try {
                        LogMessage.e(TAG, "initDriveWorker observer")


                        workerInfo = it

                        when (workerInfo!!.state) {

                            WorkInfo.State.ENQUEUED -> {
                                LogMessage.e(TAG, "Enqueued state")
                                showUploadUI("Uploading : 0 KB  of $fileSizeString (0%)")
                            }

                            WorkInfo.State.RUNNING -> {
                                LogMessage.i(TAG, "initBackupWorker RUNNING progressValue")
                                onDriveWorkerRunning(workerInfo!!)
                            }

                            WorkInfo.State.CANCELLED, WorkInfo.State.FAILED -> {
                                resetBackupUI()
                                LogMessage.d(TAG, "Backup Worker is ${it.state}")
                            }

                            WorkInfo.State.SUCCEEDED -> {
                                onDriveWorkerSucceeded()
                                LogMessage.i(TAG, "initBackupWorker SUCCEEDED")
                            }

                            else -> Log.d("BACKUP_DRIVE_OBSERVER", "${workerInfo!!.state}")
                        }

                    } catch (e: Throwable) {
                        LogMessage.e(e)
                    }
                }

            }
        }


    }

    private fun onDriveWorkerRunning(workerInfo: WorkInfo) {
        val progressData = workerInfo.progress
        genericDialog?.dismiss()
        val filePath =
            progressData.getString(BackupConstants.BACKUP_FILE_PATH) ?: emptyString()
        setFileInfo(filePath)

        val reason = progressData.getString(BackupConstants.REASON)
            ?: emptyString()

        Log.d("BACKUP_DRIVE_OBSERVER", " reason=> $reason")

        updateDriveReasonUI(reason, progressData)
    }

    private fun onDriveWorkerSucceeded() {
        backupProgressBar?.progress = 100
        showToast(getString(R.string.backup_success_msg))
        resetBackupUI()
    }

    private fun updateDriveReasonUI(reason: String, progressData: Data) {
        when (reason) {
            MediaHttpUploader.UploadState.MEDIA_IN_PROGRESS.name -> {
                LogMessage.e(TAG, "UploadState.MEDIA_IN_PROGRESS.name")
                val progressValue =
                    progressData.getInt(BackupConstants.PROGRESS, 0)
                if (progressValue > 0) {
                    LogMessage.e(TAG, "work progress to drive upload--->$progressValue")
                    activityBackUpBinding.workProgress.progress = progressValue
                    activityBackUpBinding.uploadingProgressText.text =
                        "Uploading : ${getFileSizeInStringFormat((fileSize / 100) * progressValue)}  of $fileSizeString (${progressValue}%)"
                }
            }

            MediaHttpUploader.UploadState.MEDIA_COMPLETE.name -> {
                LogMessage.e(TAG, "UploadState.MEDIA_COMPLETE.name")

                activityBackUpBinding.workProgress.progress = 100
                activityBackUpBinding.uploadingProgressText.text =
                    "Uploaded :$fileSizeString  of $fileSizeString (100%)"

                resetBackupUI()
                launch {
                    delay(250L)
                    withContext(Dispatchers.Main.immediate) {
                        setLastBackupInfo()
                    }
                }
            }

            "403" -> showToast(getString(R.string.drive_space_issue_msg))
            "401" -> {
                setDriveEmailUI()
                showToast(progressData.getString(BackupConstants.MESSAGE))
            }

            "100" -> showToast(progressData.getString(BackupConstants.MESSAGE))
            else -> Log.d(
                "BACKUP_DRIVE_OBSERVER",
                "else branch reason $reason ${
                    Utils.getGSONInstance().toJson(progressData)
                }"
            )
        }
    }

    /**
     * Updates the UI when backup is in uploading state
     *
     * @param uploadInfoText String either no internet or progress status string
     */
    private fun showUploadUI(uploadInfoText: String) {
        isUploadInEnqueuedState = true
        activityBackUpBinding.uploadingProgressText.text = uploadInfoText
        activityBackUpBinding.workProgress.progress = 0
        activityBackUpBinding.backup.gone()
        activityBackUpBinding.progressBox.show()
    }

    /**
     * Resets the UI related to backup
     */
    private fun resetBackupUI() {
        setLastBackupInfo()
        activityBackUpBinding.progressBox.gone()
        genericDialog?.dismiss()
        activityBackUpBinding.backup.show()
        activityBackUpBinding.workProgress.progress = 0
        isUploadInEnqueuedState = false
        resetUI()

    }

    /**
     * Initialization of Back up messages worker and its the Observers
     *
     * @param id UUID of the worker
     */
    private fun initBackupWorker(id: UUID) {
        LogMessage.e(TAG, "#backup init initBackupWorker worker----->")

        backupWorker = workManager.getWorkInfoByIdLiveData(id)

        backupWorker.observe(this) {

            it?.let {

                val workerInfo = it
                val progressData = workerInfo.progress
                val progressValue = progressData.getInt(BackupConstants.PROGRESS, 0)
                LogMessage.e(TAG, "#backup progressValue $progressValue")
                when (workerInfo.state) {

                    WorkInfo.State.RUNNING -> {
                        LogMessage.e(TAG, "#backup init backup worker running--->")
                    }

                    WorkInfo.State.SUCCEEDED -> {
                        LogMessage.e(TAG, "#backup init backup worker succeed--->")

                        setFileInfo(it.outputData.getString(BackupConstants.BACKUP_FILE_PATH)!!)
                        LogMessage.i(
                            TAG,
                            "#backup Success ${it.outputData.getString(BackupConstants.BACKUP_FILE_PATH)!!}"
                        )
                        Log.d("DRIVE_T", "#backup Backup WorkInfo.State.SUCCEEDED")
                    }

                    WorkInfo.State.FAILED, WorkInfo.State.CANCELLED -> resetBackupUI()
                    else -> LogMessage.d(TAG, "#backup WORK Manager State ${workerInfo.state}")
                }
            }

        }

        BackUpDataWorker.setBackupCallBack(object : WorkerProgress {
            override fun onProgressChanged(percentage: Int) {

                launch(Dispatchers.Main.immediate) {
                    backupProgressBar?.progress = percentage
                    backupProgressText?.text =
                        "${getString(R.string.please_wait_msg)} ($percentage%)"
                    activityBackUpBinding.localWorkProgress?.progress = percentage
                    updateProgress("${getString(R.string.please_wait_msg)} ($percentage%)")
                    LogMessage.e(TAG, "#backup new method backup on progress:::$percentage")

                }
            }

            override fun onFailure(reason: String?) {
                Handler(Looper.getMainLooper()).post {
                    LogMessage.e(TAG, "#backup Backup failure::$reason")
                    showToast(reason ?: "")
                    resetBackupUI()
                }
            }

            override fun onSuccess() {
                launch(Dispatchers.Main.immediate) {
                    LogMessage.e(TAG, "#backup init backup worker success")
                    onBackupWorkerSucceeded()
                }
            }
        })

    }

    private fun onBackupWorkerSucceeded() {
        when {
            !WorkManagerController.isNetConnected() -> showAlertDialog(true)
            WorkManagerController.checkRoaming(this) && !WorkManagerController.isConnectedToWifi() -> showAlertDialog(isRoamingLogic = true)
            WorkManagerController.checkWifiLogic() -> showAlertDialog()
            else -> {
                LogMessage.d("#backup","onBackupWorkerSucceeded isOnlyBackup: $isOnlyBackup isDriveBackup: $isDriveBackup")
                if (isOnlyBackup) {
                    showToast(getString(R.string.downloaded_backup_info))
                    resetDownloadUI()
                } else if (isDriveBackup) {
                    launch {
                        if (!WorkManagerController.checkIfAWorkerIsAlreadyScheduledOrNot(
                                BackupConstants.DRIVE_WORKER_TAG)) {
                            driveUploadWorkerID = WorkManagerController.runDriveUpload()
                            LogMessage.e(TAG, "#backup backupWorker.observe driveUploadWorkerID initDriveWorker")
                            initDriveWorker(driveUploadWorkerID)
                        }
                    }
                    if (WorkManagerController.isNetConnected()) {
                        driveWorkerIfNotInitialized()
                        initDriveWorker(driveUploadWorkerID)
                        showUploadUI("Uploading : 0 KB  of $fileSizeString (0%)")
                    }
                }
            }
        }
    }

    private fun driveWorkerIfNotInitialized() {
        if (!::driveUploadWorkerID.isInitialized)
            driveUploadWorkerID = WorkManagerController.runDriveUpload()
    }

    private fun resetDownloadUI() {
        activityBackUpBinding.localWorkProgress.progress = 100
        activityBackUpBinding.downloadBackup.show()
        activityBackUpBinding.restoreData.show()
        activityBackUpBinding.localProgressBox.gone()
    }

    private fun resetUI() {
        activityBackUpBinding.downloadBackup.show()
        activityBackUpBinding.restoreData.show()
        activityBackUpBinding.localProgressBox.gone()
    }

    private fun showAlertDialog(
        isNetDisconnected: Boolean = false,
        isRoamingLogic: Boolean = false
    ) {

        genericDialog?.dismiss()

        val alertDialogBuilder = AlertDialog.Builder(this)

        when {
            isNetDisconnected -> {
                if (SharedPreferenceManager.getBoolean(BackupConstants.WIFI_BACKUP_ONLY)) {
                    alertDialogBuilder.setMessage(getString(R.string.connect_wifi_info))
                } else {
                    alertDialogBuilder.setMessage(getString(R.string.connect_wifi_cell_info))
                }

                alertDialogBuilder.setPositiveButton(getString(R.string.ok_label)) { dialog, _ ->
                    dialog.dismiss()
                }

            }

            isRoamingLogic -> {

                alertDialogBuilder.setMessage(getString(R.string.roaming_info))

                alertDialogBuilder.setPositiveButton(getString(R.string.ok_label)) { dialog, _ ->
                    startUploadingWorkers(true)
                    dialog.dismiss()
                }

            }

            else -> {
                alertDialogBuilder.setMessage(getString(R.string.wifi_alert))

                alertDialogBuilder.setTitle(getString(R.string.over_cell_backup))

                alertDialogBuilder.setPositiveButton(getString(R.string.back_up)) { dialog, _ ->
                    startUploadingWorkers()
                    dialog.dismiss()
                }

                alertDialogBuilder.setNegativeButton(getString(R.string.action_cancel)) { dialog, _ ->
                    resetBackupUI()
                    dialog.dismiss()
                }
            }
        }

        alertDialogBuilder.setCancelable(false)

        alertDialog = alertDialogBuilder.create()

        alertDialog!!.show()
    }

    private fun startUploadingWorkers(wifiOnly: Boolean = false) {
        checkInternetAndExecute {
            if (isDriveBackup) {
                driveUploadWorkerID = WorkManagerController.runDriveUpload(wifiOnly)
                LogMessage.e(TAG, "startUploadingWorkers driveUploadWorkerID initDriveWorker")
                initDriveWorker(driveUploadWorkerID)
            }
        }
    }

    /**
     * Shows the Backing up messages dialog
     */
    private fun showBackupDialog(isAuthentication: Boolean = false) {
        if (!isOnlyBackup) {
            if (genericDialog == null) {
                val builder = AlertDialog.Builder(this)
                dialogBinding = BackupDialogBinding.inflate(LayoutInflater.from(context))
                builder.setView(dialogBinding.root)

                titleTv = dialogBinding.dialogTitle
                backupProgressBar = dialogBinding.backUpProgress
                backupProgressText = dialogBinding.backUpText

                if (isAuthentication) {
                    titleTv?.text = getString(R.string.authenticating)
                    backupProgressText!!.text = getString(R.string.authenticating_drive)
                } else {
                    titleTv?.text = getString(R.string.backing_up_msg)
                    backupProgressText!!.text = getString(R.string.please_wait_msg)
                }

                builder.setCancelable(false)
                genericDialog = builder.create()
                genericDialog!!.show()
            } else {
                if (isAuthentication) {
                    titleTv?.text = getString(R.string.authenticating)
                    backupProgressText!!.text = getString(R.string.authenticating_drive)
                } else {
                    titleTv?.text = getString(R.string.backing_up_msg)
                    backupProgressText!!.text = getString(R.string.please_wait_msg)
                }
                genericDialog!!.show()
            }
        }

    }

    /**
     * Sets the Last backup info in the UI
     */
    private fun setLastBackupInfo() {
        val date = SharedPreferenceManager.getString(BackupConstants.BACKUP_FILE_DATE)
        val size = SharedPreferenceManager.getString(BackupConstants.BACKUP_FILE_SIZE)
        if (date != "") {
            activityBackUpBinding.lastBackupDate.text = TimeAgo.getTimeAgo(date.toLong(), this)
        }
        if (size != "") {
            activityBackUpBinding.lastBackupSize.text =
                "${getFileSizeInStringFormat(size.toLong())}"
        }
    }

    /**
     * Shows the Backup Connectivity Dialog
     */
    private fun showConnectivityDialog() {

        var connectDialog: AlertDialog? = null
        val cBuilder = AlertDialog.Builder(this)
        connectdialogBinding = ConnectivityDialogBinding.inflate(LayoutInflater.from(context))
        cBuilder.setView(connectdialogBinding.root)
        val wifiImage = connectdialogBinding.wifiImage
        val cellImage = connectdialogBinding.cellImage
        val isWifiOnly = SharedPreferenceManager.getBoolean(BackupConstants.WIFI_BACKUP_ONLY)

        if (isWifiOnly) {
            setImageForImageView(0, listOf(wifiImage, cellImage))
        } else {
            setImageForImageView(1, listOf(wifiImage, cellImage))
        }

        connectdialogBinding.wifiOnlyBox.setOnClickListener {
            setImageForImageView(0, listOf(wifiImage, cellImage))
            SharedPreferenceManager.setBoolean(BackupConstants.WIFI_BACKUP_ONLY, true)
            connectDialog?.dismiss()
        }

        connectdialogBinding.cellularBox.setOnClickListener {
            setImageForImageView(1, listOf(wifiImage, cellImage))
            SharedPreferenceManager.setBoolean(BackupConstants.WIFI_BACKUP_ONLY, false)
            connectDialog?.dismiss()
        }

        connectdialogBinding.cancel.setOnClickListener {
            connectDialog?.dismiss()
        }

        connectDialog = cBuilder.create()
        connectDialog.setOnDismissListener {
            setConnectivityText()
        }
        connectDialog.show()
    }

    private fun getAllGoogleAccounts() {

        if (isPermissionsAllowed(Manifest.permission.GET_ACCOUNTS)) {

            val intent = AccountManager.newChooseAccountIntent(
                null,
                null,
                arrayOf(BackupConstants.ACCOUNT_TYPE),
                null,
                null,
                null,
                null
            )
            startActivityForResult(intent, REQUEST_CODE_CHOOSE_ACCOUNT)
        } else {
            MediaPermissions.requestAccountPermissions(this, ACCOUNT_PERMS_REQUEST_CODE)

        }

    }

    /**
     * Sets the Frequency text of the current Back up
     */
    private fun setFrequencyText() {
        val frequencyOption = SharedPreferenceManager.getString(BackupConstants.BACKUP_FREQUENCY)
        activityBackUpBinding.frequencyText.text = frequencyOption.capitalize()
    }

    /**
     * Sets the text of frequency backup
     */
    private fun setConnectivityText() {
        SharedPreferenceManager.getBoolean(BackupConstants.WIFI_BACKUP_ONLY).let {
            if (it) {
                activityBackUpBinding.connectivityText.text = getString(R.string.wifi_only)
            } else {
                activityBackUpBinding.connectivityText.text = getString(R.string.wifi_cellular)
            }
        }
    }


    private suspend fun checkInternetUp(): Boolean = hasActiveInternet()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    companion object {

        const val TAG = "BackUpActivity"

    }


    /*
    * Storage Permissions Result handling
    */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && permissions[0] == Manifest.permission.WRITE_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                activityBackUpBinding.backup.performClick()
            } else {
                val showRationale = ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                if (!showRationale)
                    Toast.makeText(
                        this,
                        getString(R.string.need_permission_backup),
                        Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_SIGN_IN -> {
                if (resultCode == Activity.RESULT_OK && data != null)
                    handleSignInResult(data, activityBackUpBinding.driveEmail)
                else if (SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL)
                        .isNotEmpty()
                )
                    clientLogin(
                        SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL),
                        true
                    )
                setDriveEmailUI()
                genericDialog?.dismiss()
            }

            ACCOUNT_PERMS_REQUEST_CODE -> if (resultCode == RESULT_OK) getAllGoogleAccounts()

            REQUEST_CODE_CHOOSE_ACCOUNT -> {
                if (resultCode == RESULT_OK) {
                    val accountName = data?.extras?.get(AccountManager.KEY_ACCOUNT_NAME) ?: ""
                    SharedPreferenceManager.setString(
                        BackupConstants.DRIVE_EMAIL,
                        accountName.toString()
                    )
                    SharedPreferenceManager.setBoolean(BackupConstants.NEED_RELOGIN, false)
                    activityBackUpBinding.driveEmail.text = accountName.toString()
                    checkAndLoginMail(accountName.toString())
                }
            }

            RequestCode.PICK_FILE -> data?.let { checkFileToRestore(data.data) }
        }
    }

    override fun onDialogClosed() {
        setFrequencyText()
        autoBackupInit()
    }

    private fun checkFileToRestore(filePathUri: Uri?) {
        filePathUri.let {
            try {
                val fileRealPath = RealPathUtil.getRealPath(this, filePathUri)
                if (!fileRealPath.isNullOrEmpty())
                    startRestore(fileRealPath)
                else
                    showFileValidation()
            } catch (e: Exception) {
                LogMessage.e(e)
            }

        }
    }

    private fun startRestore(fileRealPath: String) {
        showDownloadUI("${getString(R.string.restoring_msg)} (0%)")
        restoreWorkerID = WorkManagerController.runRestoreOnly(fileRealPath)
        initRestoreWorker(restoreWorkerID)
    }

    private fun initRestoreWorker(id: UUID) {
        restoreDataWorker = workManager.getWorkInfoByIdLiveData(id)
        restoreDataWorker.observe(this) {

            it?.let {

                val workerInfo = it
                when (workerInfo.state) {

                    WorkInfo.State.RUNNING -> {
                        val progressData = workerInfo.progress
                        val progressValue = progressData.getInt(BackupConstants.PROGRESS, 0)
                        LogMessage.i(TAG, "initRestoreWorker RUNNING progressValue$progressValue")
                    }

                    WorkInfo.State.SUCCEEDED -> {
                        LogMessage.i(TAG, "initRestoreWorker SUCCEEDED")
                    }

                    WorkInfo.State.FAILED, WorkInfo.State.CANCELLED -> {
                        LogMessage.d(TAG, "Restore Worker is ${it.state}")
                        showToast(getString(R.string.restore_failed_info))
                    }

                    else -> {
                        Log.d("RESTORE_ACTIVITY_REST", "${workerInfo.state}")
                    }
                }

            }

        }
        RestoreDataWorker.setRestoreCallBack(object : WorkerProgress {
            override fun onProgressChanged(percentage: Int) {
                LogMessage.i(TAG, "RestoreWorker RUNNING progressValue$percentage")
                Handler(Looper.getMainLooper()).post {
                    updateProgress("${getString(R.string.restoring_msg)} ($percentage%)")
                    activityBackUpBinding.localWorkProgress.progress = percentage
                }
            }

            override fun onFailure(reason: String?) {
                Handler(Looper.getMainLooper()).post {
                    showToast(reason ?: "")
                    resetUI()
                }

            }

            override fun onSuccess() {
                Handler(Looper.getMainLooper()).post {
                    showToast(getString(R.string.restore_success_info))
                    resetDownloadUI()
                }
            }
        })
    }

    private fun updateProgress(info: String) {
        activityBackUpBinding.localProgressText?.text = info
    }

    interface WorkerProgress {
        fun onProgressChanged(percentage: Int)

        fun onFailure(reason: String?)

        fun onSuccess()
    }


}