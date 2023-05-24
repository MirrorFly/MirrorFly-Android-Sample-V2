package com.contusfly.activities

import android.Manifest
import android.accounts.Account
import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LiveData
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.contusfly.*
import com.contusfly.backup.*
import com.contusfly.backup.models.BackupInfo
import com.contusfly.backup.workers.CleanUpWorker
import com.contusfly.backup.workers.RestoreDataWorker
import com.contusfly.databinding.ActivityRestoreBinding
import com.contusfly.interfaces.PermissionDialogListener
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaPermissions
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.backup.RestoreManager
import com.mirrorflysdk.flydatabase.model.Backup
import com.mirrorflysdk.utils.Utils
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.googleapis.media.MediaHttpDownloader
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.google.api.services.drive.model.File
import com.mirrorflysdk.backup.BackupManager
import com.mirrorflysdk.flycommons.FlyCommons
import com.mirrorflysdk.flycommons.LogMessage
import kotlinx.android.synthetic.main.activity_back_up.*
import kotlinx.android.synthetic.main.activity_back_up.driveEmail
import kotlinx.android.synthetic.main.activity_restore.*
import kotlinx.android.synthetic.main.backup_dialog.view.*
import kotlinx.android.synthetic.main.frequency_dialog.view.*
import kotlinx.coroutines.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

class RestoreActivity : BackupRestoreParent(), CoroutineScope,
    BackupRestoreParent.CommonBackupDialogListener {

    private lateinit var activityRestoreBinding: ActivityRestoreBinding

    val CHANNEL_ID="Restore_Process_Channel"

    val CHANNEL_NAME="Restore Updates"

    lateinit var driveHelper: DriveHelper

    private var genericDialog: AlertDialog? = null
    private var isDriveBackup = true

    private var driveFile: File? = null

    private var fileId = emptyString()
    private var fileName = emptyString()
    var fileSize = 0L
    private var fileSizeString = emptyString()
    private var lastBackupTimeInLong = 0L

    /**
     * Work manger instance
     */
    private val workManager: WorkManager = WorkManager.getInstance(this)

    private var builder: NotificationCompat.Builder? = null
    private var mNotifyManager: NotificationManager? = null


    /**
     * Ids of the workers
     */
    private lateinit var driveWorkerId: UUID
    private lateinit var restoreWorkerID: UUID

    /**
     * Workers Progress LiveData Observers
     */
    private lateinit var restoreWorker: LiveData<WorkInfo>
    private lateinit var driveWorker: LiveData<WorkInfo>

    private var isExisting: Boolean = false
    private lateinit var restoreImageViews: Array<ImageView>
    private val imageResources = intArrayOf(
        R.drawable.restore_1,
        R.drawable.restore_2,
        R.drawable.restore_3,
        R.drawable.restore_4
    )
    private val duration = 1000L
    private var imageQueue: MutableList<Int> = mutableListOf()

    protected val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val downloadPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val writePermissionGranted = permissions[Manifest.permission.WRITE_EXTERNAL_STORAGE]
            ?: ChatUtils.checkWritePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (writePermissionGranted) {
            activityRestoreBinding.restore.performClick()
        }
    }

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
            this,
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
                AndroidHttp.newCompatibleTransport(),
                JacksonFactory.getDefaultInstance(),
                credential
            )
                .setApplicationName(getString(R.string.drive_backup_folder_name))
                .build()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRestoreBinding = ActivityRestoreBinding.inflate(layoutInflater)
        setContentView(activityRestoreBinding.root)
        SharedPreferenceManager.setString(BackupConstants.BACKUP_FREQUENCY, BackupConstants.DAILY)
        isExisting = intent.getBooleanExtra("isExisting", false)
        setUpViews()
        setCommonBackupDialogListener(this)
        SharedPreferenceManager.setBoolean(BackupConstants.SHOULD_SHOW_RESTORE, true)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.GET_ACCOUNTS),
            BackupConstants.REQUEST_CODE_SIGN_IN
        )
    }

    private fun notificationPermissionChecking(){
        MediaPermissions.requestNotificationPermission(
            this,
            permissionAlertDialog,
            notificationPermissionLauncher,false,permissionDeniedListener)

    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        restoreClickPermission()
    }

    private val permissionDeniedListener = object : PermissionDialogListener {
        override fun onPositiveButtonClicked() {
            //Not Needed
        }

        override fun onNegativeButtonClicked() {
            restoreClickPermission()
        }
    }

    private fun switchImageView(){
        restoreImageViews = arrayOf(
            findViewById(R.id.ic_restore1),
            findViewById(R.id.ic_restore2),
            findViewById(R.id.ic_restore3),
            findViewById(R.id.ic_restore4)
        )
        imageQueue.addAll(imageResources.toMutableList())
        startImageSwitching()
    }

    private fun startImageSwitching() {
        val lastImage = imageQueue.removeAt(imageQueue.size - 1)
        imageQueue.add(0, lastImage)
        updateImageViews()

        // Schedule the next image switch
        restoreImageViews[0].postDelayed({
            startImageSwitching()
        }, duration)
    }

    private fun stopImageSwitching() {
        restoreImageViews[0].removeCallbacks {
            startImageSwitching()
        }
    }

    private fun updateImageViews() {
        for (i in restoreImageViews.indices) {
            restoreImageViews[i].setImageResource(imageQueue[i])
        }
    }

    private fun setUpViews() {
        if (!isExisting) {
            showUINewUser()
        } else {
            showUIOldUser()
        }
    }

    private fun showUINewUser() {
        activityRestoreBinding.textTitle.text = getString(R.string.back_up)
        activityRestoreBinding.mainTitle.text = getString(R.string.add_account)
        activityRestoreBinding.infoText.text = getString(R.string.new_user_info)
        activityRestoreBinding.newAccountBox.show()
        activityRestoreBinding.lastBackupDate.gone()
        activityRestoreBinding.lastBackupSize.gone()
        activityRestoreBinding.accountBox.gone()
        activityRestoreBinding.dividerOne.gone()
        activityRestoreBinding.autoBox.gone()
        activityRestoreBinding.scheduleBox.gone()
        activityRestoreBinding.dividerTwo.gone()
        activityRestoreBinding.initialBox.gone()
        activityRestoreBinding.finalBox.gone()
        newUserSkipButtonVisibility()
    }

    private fun showUIOldUser() {
        activityRestoreBinding.textTitle.text = getString(R.string.looking_backup)
        activityRestoreBinding.mainTitle.text = getString(R.string.add_account)
        activityRestoreBinding.infoText.text = getString(R.string.restore_info)
        activityRestoreBinding.newAccountBox.gone()
        activityRestoreBinding.lastBackupDate.show()
        activityRestoreBinding.lastBackupSize.show()
        activityRestoreBinding.accountBox.show()
        activityRestoreBinding.dividerOne.show()
        activityRestoreBinding.autoBox.show()
        activityRestoreBinding.scheduleBox.gone()
        activityRestoreBinding.dividerTwo.show()
        activityRestoreBinding.initialBox.gone()
        activityRestoreBinding.finalBox.show()
        activityRestoreBinding.workProgress.gone()
        activityRestoreBinding.progressText.gone()
        activityRestoreBinding.newUserBox.gone()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        activityRestoreBinding.skip.setOnClickListener {
            SharedPreferenceManager.setBoolean(BackupConstants.AUTO_BACKUP, false)
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FREQUENCY, emptyString())
            SharedPreferenceManager.setString(BackupConstants.NEXT_BACKUP_TIME, emptyString())
            SharedPreferenceManager.setString(BackupConstants.DRIVE_EMAIL, emptyString())
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_DATE, emptyString())
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_SIZE, emptyString())
            WorkManagerController.cancelRestoreWorkers()
            goToProfile()
        }

        activityRestoreBinding.finalSkip.setOnClickListener {
            if (!isExisting) {
                SharedPreferenceManager.setBoolean(BackupConstants.AUTO_BACKUP, false)
                SharedPreferenceManager.setString(BackupConstants.BACKUP_FREQUENCY, emptyString())
                SharedPreferenceManager.setString(BackupConstants.NEXT_BACKUP_TIME, emptyString())
                SharedPreferenceManager.setString(BackupConstants.DRIVE_EMAIL, emptyString())
                SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_DATE, emptyString())
                SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_SIZE, emptyString())
            }
            RestoreManager.cancelRestore()
            WorkManagerController.cancelRestoreWorkers()
            goToProfile()
        }
        activityRestoreBinding.autoSwitch.setOnCheckedChangeListener { _, isChecked ->
            onAutoSwitchClicked(isChecked)
        }

        activityRestoreBinding.scheduleBox.setOnClickListener {
            showFrequencyDialog()
        }

        activityRestoreBinding.accountBox.setOnClickListener {
            onAccountClicked()
        }

        activityRestoreBinding.newAccountBox.setOnClickListener {
            onAccountClicked()
        }
        activityRestoreBinding.actionNext.setOnClickListener {
            goToProfile()
        }
        activityRestoreBinding.newUserSkip.setOnClickListener {
            SharedPreferenceManager.setBoolean(BackupConstants.AUTO_BACKUP, false)
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FREQUENCY, emptyString())
            SharedPreferenceManager.setString(BackupConstants.NEXT_BACKUP_TIME, emptyString())
            SharedPreferenceManager.setString(BackupConstants.DRIVE_EMAIL, emptyString())
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_DATE, emptyString())
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_SIZE, emptyString())
            goToProfile()
        }

        activityRestoreBinding.restore.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (!ChatUtils.checkNotificationPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                    )
                )
                    notificationPermissionChecking()
                else
                    restoreClickPermission()

            }else {
               restoreClickPermission()
            }
        }
    }

    private fun restoreClickPermission(){
        if (ChatUtils.checkWritePermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) onRestoreClicked() else MediaPermissions.requestContactStorageAccess(
            this,
            permissionAlertDialog,
            downloadPermissionLauncher
        )
    }

    private fun onRestoreClicked() {
        checkInternetAndExecute {
            activityRestoreBinding.initialBox.gone()
            activityRestoreBinding.finalBox.show()
            activityRestoreBinding.workProgress.show()
            activityRestoreBinding.progressText.show()
            if (isDriveBackup) {
                val workerIds = WorkManagerController.runDriveRestoreWorkers(
                    fileId,
                    fileName
                )
                driveWorkerId = workerIds.first
                initDriveListeners(driveWorkerId)
                restoreWorkerID = workerIds.second
                progressText.text = "Downloading : 0.0KB  of $fileSizeString (0%)"
            }
            switchImageView()
            createRestoreNotificationChannel()
            showRestoreNotification()
        }
    }

    private fun createRestoreNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW)
            val mNotifyManager= getSystemService(NotificationManager::class.java)
            mNotifyManager.createNotificationChannel(channel)
        }
    }

    private fun showRestoreNotification() {
        builder=NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Restore Progress 0%")
            .setSmallIcon(R.drawable.ic_notification_blue)
            .setOngoing(true)
            .setProgress(100, 0, false)

        mNotifyManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotifyManager!!.notify(Constants.NOTIFICATION_ID,builder!!.build())

    }

    private fun onAccountClicked() {
        launch {
            val isNetworkUp = checkInternetUp()
            withContext(Dispatchers.Main.immediate) {
                if (isNetworkUp) getAllGoogleAccounts() else showToast(getString(R.string.msg_no_internet))
            }
        }
    }

    private fun onAutoSwitchClicked(isChecked: Boolean) {
        SharedPreferenceManager.setBoolean(BackupConstants.AUTO_BACKUP, isChecked)
        if (SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL).isNullOrEmpty()) {
            activityRestoreBinding.autoSwitch.isChecked = false
            showToast(getString(R.string.select_google_account))
        } else {
            if (isChecked) {
                activityRestoreBinding.scheduleBox.show()
                showFrequencyDialog()
            } else {
                activityRestoreBinding.scheduleBox.gone()
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    private fun goToProfile() {
        startActivity(
            Intent(this, ProfileStartActivity::class.java).putExtra(
                Constants.IS_FIRST_LOGIN,
                true
            )
                .putExtra(Constants.FROM_SPLASH, true)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        )
        GroupManager.getAllGroups(true) { _, _, _ -> }
        finish()
    }

    /**
     * Sets the Frequency text of the current Back up
     */
    private fun setFrequencyText() {
        val frequencyOption = SharedPreferenceManager.getString(BackupConstants.BACKUP_FREQUENCY)
        activityRestoreBinding.frequencyText.text = frequencyOption.capitalize()
    }

    private suspend fun checkInternetUp(): Boolean = hasActiveInternet()

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
            startActivityForResult(intent, BackupConstants.REQUEST_CODE_CHOOSE_ACCOUNT)

        } else {

            MediaPermissions.requestAccountPermissions(
                this,
                BackupConstants.ACCOUNT_PERMS_REQUEST_CODE
            )

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            BackupConstants.REQUEST_CODE_SIGN_IN -> {
                if (resultCode == Activity.RESULT_OK && data != null)
                    handleSignInResult(data)
                else if (SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL)
                        .isNotEmpty()
                )
                    clientLogin(
                        SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL),
                        true
                    )
                setDriveEmailUI()
            }
            BackupConstants.ACCOUNT_PERMS_REQUEST_CODE -> if (resultCode == RESULT_OK) getAllGoogleAccounts()
            BackupConstants.REQUEST_CODE_CHOOSE_ACCOUNT -> {
                if (resultCode == RESULT_OK) {
                    val accountName = data?.extras?.get(AccountManager.KEY_ACCOUNT_NAME) ?: "NONE"
                    SharedPreferenceManager.setString(
                        BackupConstants.DRIVE_EMAIL,
                        accountName.toString()
                    )
                    SharedPreferenceManager.setBoolean(BackupConstants.NEED_RELOGIN, false)
                    driveEmail.text = accountName.toString()
                    setNewUserMail(accountName.toString())
                    checkAndLoginMail(accountName.toString())
                }
            }
        }
    }

    private fun setNewUserMail(mail: String) {
        activityRestoreBinding.driveEmail.text = mail
        if (!isExisting) {
            activityRestoreBinding.newAccountBox.gone()
            activityRestoreBinding.accountBox.show()
            activityRestoreBinding.dividerOne.show()
            activityRestoreBinding.autoBox.show()
            activityRestoreBinding.scheduleBox.gone()
            activityRestoreBinding.dividerTwo.show()
            activityRestoreBinding.initialBox.gone()
            activityRestoreBinding.finalBox.gone()
            newUserSetupMailSkipButtonVisibility()
        }
    }

    private fun newUserSkipButtonVisibility() {
        activityRestoreBinding.newUserBox.show()
        activityRestoreBinding.actionNext.gone()
        activityRestoreBinding.newUserSkip.setBackgroundResource(R.drawable.blue_rounded_corners)
        activityRestoreBinding.newUserSkip.setTextColor(Color.WHITE)
        activityRestoreBinding.newUserSkip.show()
    }

    private fun newUserSetupMailSkipButtonVisibility() {
        activityRestoreBinding.newUserBox.show()
        activityRestoreBinding.actionNext.show()
        activityRestoreBinding.newUserSkip.setBackgroundResource(R.drawable.grey_rounded_corners)
        activityRestoreBinding.newUserSkip.setTextColor(Color.parseColor("#575757"))
        activityRestoreBinding.newUserSkip.show()
    }

    /**
     * Handle the Successful Sign in of Google Account with Drive Permission
     * @param resultData Intent sign in data
     */
    private fun handleSignInResult(resultData: Intent) {

        GoogleSignIn.getSignedInAccountFromIntent(resultData)
            .addOnSuccessListener { googleAccount: GoogleSignInAccount ->
                SharedPreferenceManager.setString(
                    BackupConstants.DRIVE_EMAIL,
                    googleAccount.email.toString()
                )
                SharedPreferenceManager.setString(
                    BackupConstants.GOOGLE_ACCOUNT,
                    Utils.getGSONInstance().toJson(googleAccount.account)
                )
                SharedPreferenceManager.setBoolean(BackupConstants.NEED_RELOGIN, false)
                driveEmail.text = googleAccount.email.toString()

                if (isExisting && drive != null) {

                    // The DriveHelper encapsulates all REST API and SAF functionality. Its instantiation is required before handling any onClick actions.
                    driveHelper = DriveHelper(drive!!)
                    launch {
                        queryDriveFiles()
                    }
                }
            }
    }

    private fun setDriveEmailUI() {
        val myEmail = SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL)
        activityRestoreBinding.driveEmail.text =
            if (myEmail.isNullOrEmpty()) getString(R.string.select_gmail_account) else myEmail
    }

    /**
     * Query the User's Drive Files for Backup file availability
     */
    private suspend fun queryDriveFiles() {

        val fileIdOfBackupFile = driveHelper.queryFiles(BackupManager.getBackupFileName())

        when {
            fileIdOfBackupFile.first == BackupConstants.DRIVE_BACKUP_FILE_QUERY_EXCEPTION -> {
                withContext(Dispatchers.Main.immediate) {
                    genericDialog?.dismiss()
                    LogMessage.e(TAG, "DRIVE_BACKUP_FILE_QUERY_EXCEPTION ")
                    showToast(fileIdOfBackupFile.second)
                }
            }
            fileIdOfBackupFile.first.isEmpty() -> {
                withContext(Dispatchers.Main.immediate) {
                    genericDialog?.dismiss()
                    LogMessage.e(TAG, "newUser")
                    setUpNoBackUpUI()
                    if (!isExisting) {
                        showToast(getString(R.string.no_backup_msg_available))
                    }
                }
            }
            fileIdOfBackupFile.first.isNotEmpty() -> {
                LogMessage.e(
                    TAG,
                    "fileIdOfBackupFile.first  ${fileIdOfBackupFile.first} "
                )
                getFileInfo(fileIdOfBackupFile.first)
            }
        }

    }

    private fun setUpNoBackUpUI() {
        activityRestoreBinding.mainTitle.text = getString(R.string.backup_not_found)
        activityRestoreBinding.lastBackupDate.text = getString(R.string.__dash)
        activityRestoreBinding.lastBackupSize.text = getString(R.string.size_)
        activityRestoreBinding.viewRestoreAnimationImage.visibility = View.VISIBLE
        activityRestoreBinding.animationBox.gone()
        activityRestoreBinding.initialBox.gone()
        activityRestoreBinding.newUserBox.show()
        activityRestoreBinding.newUserSkip.show()
        activityRestoreBinding.actionNext.show()
        activityRestoreBinding.finalBox.gone()
    }

    private fun setUpBackUpDataUI(backupData: Backup) {
        activityRestoreBinding.newUserBox.gone()
        activityRestoreBinding.mainTitle.text = getString(R.string.backup_found)
        activityRestoreBinding.lastBackupDate.text =
            TimeAgo.getTimeAgo(backupData.backupTime.toLong(), this)
        activityRestoreBinding.lastBackupSize.text =
            "Size: ${getFileSizeInStringFormat(backupData.backupSize.toLong())}"
        activityRestoreBinding.viewRestoreAnimationImage.visibility = View.VISIBLE
        activityRestoreBinding.animationBox.gone()
        activityRestoreBinding.initialBox.show()
        activityRestoreBinding.finalBox.gone()
    }

    /**
     * Provides the info about the backup file in Users's Google Drive
     *
     * @param fileId String id of the backup file
     */
    private suspend fun getFileInfo(id: String) {


        driveFile = driveHelper.getFile(id)

        LogMessage.e(
            TAG,
            "getFileInfo driveFile ${driveFile!!.name} \n ${driveFile!!.id} \n ${driveFile!!.size}"
        )
        LogMessage.e(TAG, "getFileInfo modifiedTime \n ${driveFile!!.createdTime} ")

        val lastBackupDate = parseAndReturnDateAsString(
            driveFile!!.createdTime.toString().replace("Z", "")
        ).toString()

        val backupData = Backup()
        backupData.id = driveFile!!.id
        backupData.backupSize = driveFile!!["size"].toString()
        backupData.backupType = "DRIVE"
        backupData.backupTime = lastBackupDate
        fileId = id
        fileName = driveFile!!.name
        fileSize = driveFile!!["size"] as Long
        fileSizeString = getFileSizeInStringFormat(fileSize)!!
        SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_SIZE, backupData.backupSize)
        SharedPreferenceManager.setString(BackupConstants.BACKUP_FILE_DATE, backupData.backupTime)
        val backupInfo =
            BackupInfo(driveFile!!["size"].toString(), lastBackupDate, false, driveFile!!.id)
        SharedPreferenceManager.setString(
            BackupConstants.BACKUP_INFO,
            Utils.getGSONInstance().toJson(backupInfo)
        )

        withContext(Dispatchers.Main.immediate) {
            genericDialog?.dismiss()
            setUpBackUpDataUI(backupData)
        }
    }

    /**
     * Parse the date and return as time in milli seconds
     */
    @SuppressLint("SimpleDateFormat")
    private fun parseAndReturnDateAsString(cd: String): Long {
        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        input.timeZone = TimeZone.getTimeZone("UTC")
        val output = SimpleDateFormat("dd MMM yyyy | hh.mm aa")
        output.timeZone = TimeZone.getDefault()
        var finalTime = ""
        try {
            val date = input.parse(cd)
            finalTime = output.format(date)
            lastBackupTimeInLong = output.parse(finalTime).time
            return lastBackupTimeInLong
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return 0L
    }

    /**
     * Initialization of Drive Downlaod worker and its the Observers
     *
     * @param id UUID of the worker
     */
    private fun initDriveListeners(id: UUID) {

        driveWorker = workManager.getWorkInfoByIdLiveData(id)

        driveWorker.observe(this, androidx.lifecycle.Observer {

            it?.let {

                val workerInfo = it

                when (workerInfo.state) {

                    WorkInfo.State.RUNNING -> {

                        val progressData = workerInfo.progress
                        val reason = progressData.getString(BackupConstants.REASON)

                        when (reason) {

                            MediaHttpDownloader.DownloadState.MEDIA_IN_PROGRESS.name -> {
                                val progressValue =
                                    progressData.getInt(BackupConstants.PROGRESS, 0)
                                if (progressValue > 0) {
                                    activityRestoreBinding.workProgress.progress = progressValue
                                    progressText.text =
                                        "Downloading : ${getFileSizeInStringFormat((fileSize / 100) * progressValue)}  of ${fileSizeString} (${progressValue}%)"
                                }
                                activityRestoreBinding.workProgress.progress = progressValue
                            }
                            MediaHttpDownloader.DownloadState.MEDIA_COMPLETE.name -> activityRestoreBinding.workProgress.progress =
                                100
                            BackupConstants.NO_DRIVE_BACKUP_FOLDER_AVAILABLE,
                            BackupConstants.NO_DRIVE_BACKUP_FILE_AVAILABLE -> {
                                showToast(getString(R.string.no_backup_msg))
                                goToProfile()
                            }
                            else ->
                                Log.d("RESTORE_ACTIVITY_DRIVE", "${reason}")

                        }
                    }
                    WorkInfo.State.FAILED, WorkInfo.State.CANCELLED -> {
                        LogMessage.d(TAG, "Drive Worker is ${it.state}")
                        SharedPreferenceManager.setBoolean(
                            BackupConstants.SHOULD_SHOW_RESTORE,
                            true
                        )
                        resetUIInCaseOfFailure()
                    }

                    else -> {
                        initRestoreListener(restoreWorkerID)
                        Log.d("RESTORE_ACTIVITY_DRIVE", "${workerInfo.state}")
                    }
                }
            }
        })
    }

    /**
     * Initialization of Restore Data worker and its the Observers
     *
     * @param id UUID of the worker
     */
    private fun initRestoreListener(id: UUID) {
        restoreWorker = workManager.getWorkInfoByIdLiveData(id)
        restoreWorker.observe(this, androidx.lifecycle.Observer {

            it?.let {

                val workerInfo = it
                when (workerInfo.state) {

                    WorkInfo.State.RUNNING -> {
                        LogMessage.e(TAG, "Restore worker Running")
                    }

                    WorkInfo.State.SUCCEEDED -> {
                        LogMessage.e(TAG, "Restore worker succeed")
                    }

                    WorkInfo.State.FAILED, WorkInfo.State.CANCELLED -> {
                        LogMessage.d(TAG, "Restore Worker is ${it.state}")
                        SharedPreferenceManager.setBoolean(
                            BackupConstants.SHOULD_SHOW_RESTORE,
                            true
                        )
                        resetUIInCaseOfFailure()
                    }
                    else -> {
                        Log.d("RESTORE_ACTIVITY_REST", "${workerInfo.state}")
                    }
                }

            }

        })
        RestoreDataWorker.setRestoreInStarActivityCallBack(object : RestoreWorkerProgress {
            override fun onProgressChanged(percentage: Int) {
                LogMessage.i(TAG, "StarActivity RestoreWorker RUNNING progressValue$percentage")
                Handler(Looper.getMainLooper()).post {
                    activityRestoreBinding.workProgress.progress = percentage

                    if (percentage == 100) {
                        progressText?.text =
                            "${getString(R.string.restoring_msg)} ($percentage%)"
                        progressText.text = getString(R.string.clean_up_data)
                    } else {
                        progressText?.text =
                            "${getString(R.string.restoring_msg)} ($percentage%)"
                    }
                    LogMessage.e(TAG, "Restore worker Progress UI In StartActivity::$percentage")
                }
            }

            override fun onFailure(reason: String?) {
                Handler(Looper.getMainLooper()).post {
                    LogMessage.e(TAG, "Restore worker Failed In StartActivity::$reason")
                    showToast(reason ?: "")
                }

            }

            override fun onSuccess() {
                Handler(Looper.getMainLooper()).post {
                    LogMessage.e(TAG, "Restore worker completed In UI StartActivity")
                    activityRestoreBinding.workProgress.progress = 100
                    stopImageSwitching()
                }
                cleanupWorker()
                goToProfile()
            }
        })
    }

    private fun cleanupWorker() {
        val cleanupWorker = OneTimeWorkRequestBuilder<CleanUpWorker>()
            .addTag(BackupConstants.CLEANUP_WORKER_TAG)
            .setInputData(
                Data.Builder().putString(
                    BackupConstants.BACKUP_FILE_PATH,
                    SharedPreferenceManager.getString(BackupConstants.BACKUP_FILE_PATH)
                ).build()
            )
            .build()
        workManager.beginUniqueWork(
            BackupConstants.RESTORE_PROCESS_UNIQUE,
            ExistingWorkPolicy.REPLACE,
            cleanupWorker
        ).enqueue()
        workManager.getWorkInfoByIdLiveData(cleanupWorker.id)
    }

    private fun resetUIInCaseOfFailure() {
        progressText.text = getString(R.string.downloading)
        activityRestoreBinding.workProgress.progress = 0
        WorkManagerController.cancelRestoreWorkers()
        activityRestoreBinding.initialBox.show()
        activityRestoreBinding.finalBox.gone()
        activityRestoreBinding.workProgress.gone()
        activityRestoreBinding.progressText.gone()
        activityRestoreBinding.viewRestoreAnimationImage.show()
        activityRestoreBinding.animationBox.gone()
    }

    override fun onDialogClosed() {
        setFrequencyText()
    }

    interface RestoreWorkerProgress {
        fun onProgressChanged(percentage: Int)

        fun onFailure(reason: String?)

        fun onSuccess()
    }
}