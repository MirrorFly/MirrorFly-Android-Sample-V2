package com.contusfly.utils

import android.Manifest
import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.RemoteException
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.R
import com.contusfly.chat.AndroidUtils
import com.contusfly.databinding.NotificationPermissionDialogBinding
import com.contusfly.interfaces.PermissionDialogListener
import com.contusfly.views.PermissionAlertDialog
import com.google.android.material.snackbar.Snackbar

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
object MediaPermissions {
    /**
     * Request the storage permission for accessing Gallery
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    fun requestStorageAccess(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {
        val permissionsToRequest = mutableListOf<String>()
        val hasReadPermission = isPermissionAllowed(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
        val hasWritePermission = isPermissionAllowed(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        val minSdk30 = SDK_INT > Build.VERSION_CODES.Q

        val writePermissionGranted = hasWritePermission || minSdk30


        if (!writePermissionGranted) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasReadPermission) {
            permissionsToRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                    showPermissionPopUpForStorage(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.STORAGE_PERMISSION_ASKED) -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.MEDIA_PERMISSION_DENIED,
                        object : PermissionDialogListener{
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        })
                }
                else -> {
                    showPermissionPopUpForStorage(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
            }
        }
    }

    fun requestMediaFiles(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {
        val permissionsToRequest = mutableListOf<String>()
        val hasReadMediaImage = isPermissionAllowed(activity, Manifest.permission.READ_MEDIA_IMAGES)
        val hasReadMediaVideos = isPermissionAllowed(activity, Manifest.permission.READ_MEDIA_VIDEO)
        if (!hasReadMediaImage) {
            permissionsToRequest.add(Manifest.permission.READ_MEDIA_IMAGES)
        }
        if (!hasReadMediaVideos) {
            permissionsToRequest.add(Manifest.permission.READ_MEDIA_VIDEO)
        }

        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_MEDIA_IMAGES)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_MEDIA_VIDEO) -> {
                    showPermissionPopUpForStorage(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.STORAGE_PERMISSION_ASKED) -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.MEDIA_PERMISSION_DENIED,
                        object : PermissionDialogListener{
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        })
                }
                else -> {
                    showPermissionPopUpForStorage(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
            }
        }
    }

    fun requestAudioMediaFiles(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {
        val permissionsToRequest = mutableListOf<String>()
        val hasReadMediaAudio = isPermissionAllowed(activity, Manifest.permission.READ_MEDIA_AUDIO)
        if (!hasReadMediaAudio) {
            permissionsToRequest.add(Manifest.permission.READ_MEDIA_AUDIO)
        }

        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_MEDIA_AUDIO) -> {
                    showPermissionPopUpForStorage(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.STORAGE_PERMISSION_ASKED) -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.MEDIA_PERMISSION_DENIED,
                        object : PermissionDialogListener{
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        }, true)
                }
                else -> {
                    showPermissionPopUpForStorage(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
            }
        }
    }

    //Android 13 Notification permission checking
    fun runtimeNotificationPermissionEnabledStatus(activity: Activity): Boolean {
        var isPermissionEnabled: Boolean = true
        if (SDK_INT >= Build.VERSION_CODES.TIRAMISU && !ChatUtils.checkNotificationPermission(
                activity,
                Manifest.permission.POST_NOTIFICATIONS
            )
        ) {
            isPermissionEnabled = false
        }

        return isPermissionEnabled
    }

    private fun notificationPermissionNotEnabled(activity: Activity):Boolean{
        return SDK_INT >= Build.VERSION_CODES.TIRAMISU && !ChatUtils.checkNotificationPermission(
            activity,
            Manifest.permission.POST_NOTIFICATIONS
        )
    }


    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private fun isFullScreenNotificationPermissionNotEnabled(activity: Activity):Boolean{
        val notificationManager =  activity.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var canUseFullScreenIntent = false
        try {
            canUseFullScreenIntent =  notificationManager.canUseFullScreenIntent()
        } catch (e: RemoteException) {
            LogMessage.d("MediaPermissions", "isFullScreenNotificationPermissionNotEnabled: exception")
            e.printStackTrace()
        }
        LogMessage.d("MediaPermissions", "#fullscreen isFullScreenNotificationPermissionNotEnabled: $canUseFullScreenIntent")
        return canUseFullScreenIntent
    }

    fun requestFullScreenNotificationPermission(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        isCall: Boolean = false,
        permissionDialogListener: PermissionDialogListener? = null,
    ) {

        if (SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE && !isFullScreenNotificationPermissionNotEnabled(activity)) {
            val permissionsToRequest = mutableListOf<String>()
            permissionsToRequest.add(Manifest.permission.USE_FULL_SCREEN_INTENT)
            if (permissionsToRequest.isNotEmpty()) {
                when {
                    ActivityCompat.shouldShowRequestPermissionRationale(
                        activity,
                        Manifest.permission.USE_FULL_SCREEN_INTENT
                    ) -> {
                        if (isCall) {

                            fullScreenNotificationDialogShow(activity)

                        } else {
                            showPermissionPopUpForFullScreenNotification(
                                permissionsLauncher,
                                permissionsToRequest,
                                permissionAlertDialog,
                                isCall,
                                permissionDialogListener,activity
                            )
                        }
                    }

                    SharedPreferenceManager.getBoolean(Constants.FULLSCREEN_NOTIFICATION_PERMISSION_ASKED) -> {
                        fullScreenNotificationPermissionAsked(activity, permissionAlertDialog, isCall, permissionDialogListener)
                    }

                    else -> {
                        showPermissionPopUpForFullScreenNotification(
                            permissionsLauncher,
                            permissionsToRequest,
                            permissionAlertDialog,
                            isCall,
                            permissionDialogListener,activity
                        )
                    }
                }
            }
        }

    }
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private fun fullScreenNotificationDialogShow(activity: Activity) {

        try {
            val dialogBinding: ViewBinding?
            val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity, R.style.TrasparentAlertDialog)
            val inflater: LayoutInflater = activity.layoutInflater
            dialogBinding = NotificationPermissionDialogBinding.inflate(inflater)
            dialogBuilder.apply {
                setCancelable(false)
                setView((dialogBinding)!!.root)
            }
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
            alertDialogWidth(activity,alertDialog)
            dialogBinding.closeIcon.visibility = View.INVISIBLE
            dialogBinding.titleTv.text = activity.resources.getString(R.string.notification_full_screen_title)
            dialogBinding.dialogDescription.text = activity.resources.getString(R.string.notification_full_intent_permission_denied_alert_label)
            dialogBinding.turnOnTv.setOnClickListener {
                SharedPreferenceManager.setBoolean(Constants.ASK_FULL_SCREEN_INTENT_PERMISSION, true)
                openSettingsForFullScreenNotificationPermissionWithoutSmackBar(activity)
                alertDialog.dismiss()
            }

            dialogBinding.notNowTv.setOnClickListener {
                SharedPreferenceManager.setBoolean(Constants.ASK_FULL_SCREEN_INTENT_PERMISSION, true)
                alertDialog.dismiss()
            }

        } catch (e:Exception) {
            Log.e("TAG", "showPermissionInstructionDialog: $e")
        }

    }

    private fun alertDialogWidth(activity: Activity, alertDialog: AlertDialog) {
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(alertDialog.window!!.attributes)
        layoutParams.width = (AndroidUtils.getScreenWidth(activity) * 0.80).toInt()
        alertDialog.window!!.attributes = layoutParams
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private fun openSettingsForFullScreenNotificationPermissionWithoutSmackBar(activity: Activity) {
        val intent = Intent(
            Settings.ACTION_MANAGE_APP_USE_FULL_SCREEN_INTENT,
            Uri.fromParts("package", activity.packageName, null)
        )
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        activity.startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private fun showPermissionPopUpForFullScreenNotification(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog,
        isCall: Boolean,
        permissionDialogListener: PermissionDialogListener?,
        activity: Activity
    ) {
        if(isCall) {
            SharedPreferenceManager.setBoolean(Constants.FULLSCREEN_NOTIFICATION_PERMISSION_ASKED, true)
            fullScreenNotificationDialogShow(activity)
        } else {
            permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.FULLSCREEN_NOTIFICATION_PERMISSION_DENIED,
                object : PermissionDialogListener {
                    override fun onPositiveButtonClicked() {
                        SharedPreferenceManager.setBoolean(Constants.FULLSCREEN_NOTIFICATION_PERMISSION_ASKED, true)
                        permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                    }

                    override fun onNegativeButtonClicked() {
                        permissionDialogListener?.onNegativeButtonClicked()
                    }
                })
        }

    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private fun fullScreenNotificationPermissionAsked(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        isCall: Boolean,
        permissionDialogListener: PermissionDialogListener?,
    ) {
        if (isCall) {
            fullScreenNotificationDialogShow(activity)
        } else {
            permissionAlertDialog.showPermissionInstructionDialog(
                PermissionAlertDialog.FULLSCREEN_NOTIFICATION_PERMISSION_DENIED,
                object : PermissionDialogListener {
                    override fun onPositiveButtonClicked() {
                        openSettingsForFullScreenNotificationPermissionWithoutSmackBar(activity)
                    }

                    override fun onNegativeButtonClicked() {
                        permissionDialogListener?.onNegativeButtonClicked()
                    }
                }
            )
        }
    }

    fun requestNotificationPermission(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        isCall: Boolean = false,
        permissionDialogListener: PermissionDialogListener? = null,
    ) {

        if (notificationPermissionNotEnabled(activity)) {
            val permissionsToRequest = mutableListOf<String>()
            permissionsToRequest.add(Manifest.permission.POST_NOTIFICATIONS)
            if (permissionsToRequest.isNotEmpty()) {
                when {
                    ActivityCompat.shouldShowRequestPermissionRationale(
                        activity,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) -> {
                        if (isCall) {
                            Snackbar.make(
                                activity.findViewById(android.R.id.content),
                                R.string.notification_permission_label,
                                Snackbar.LENGTH_INDEFINITE
                            )
                                .setAction(R.string.ok_label) {
                                    showPermissionPopUpForNotification(
                                        permissionsLauncher,
                                        permissionsToRequest,
                                        permissionAlertDialog,
                                        isCall,
                                        permissionDialogListener
                                    )
                                }.show()
                        } else {
                            showPermissionPopUpForNotification(
                                permissionsLauncher,
                                permissionsToRequest,
                                permissionAlertDialog,
                                isCall,
                                permissionDialogListener
                            )
                        }
                    }

                    SharedPreferenceManager.getBoolean(Constants.NOTIFICATION_PERMISSION_ASKED) -> {
                        notificationPermissionAsked(activity, permissionAlertDialog, isCall, permissionDialogListener)
                    }

                    else -> {
                        showPermissionPopUpForNotification(
                            permissionsLauncher,
                            permissionsToRequest,
                            permissionAlertDialog,
                            isCall,
                            permissionDialogListener
                        )
                    }
                }
            }
        }

    }

    private fun notificationPermissionAsked(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        isCall: Boolean,
        permissionDialogListener: PermissionDialogListener?,
    ) {
        if (isCall) {
            openSettingsForPermission(
                activity,
                activity.getString(R.string.notification_permission_label)
            )
        } else {
            permissionAlertDialog.showPermissionInstructionDialog(
                PermissionAlertDialog.NOTIFCATION_PERMISSION_DENIED,
                object : PermissionDialogListener {
                    override fun onPositiveButtonClicked() {
                        openSettingsForPermissionWithoutSmackBar(activity)
                    }

                    override fun onNegativeButtonClicked() {
                        permissionDialogListener?.onNegativeButtonClicked()
                    }
                }
            )
        }
    }

    /**
     * Request the storage permission for accessing Gallery
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    fun requestContactStorageAccess(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {

        val hasReadPermission = isPermissionAllowed(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
        val hasWritePermission = isPermissionAllowed(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        val minSdk30 = SDK_INT > Build.VERSION_CODES.Q

        val writePermissionGranted = hasWritePermission || minSdk30

        val permissionsToRequest = mutableListOf<String>()
        if (!writePermissionGranted) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasReadPermission) {
            permissionsToRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
                    showPermissionPopUpForContactMedia(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.STORAGE_PERMISSION_ASKED) -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CONTACT_AND_MEDIA_PERMISSION,
                        object : PermissionDialogListener{
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        })
                } else -> showPermissionPopUpForContactMedia(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
            }
        }
    }

    private fun showPermissionPopUpForNotification(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog,
        isCall: Boolean,
        permissionDialogListener: PermissionDialogListener?
    ) {
        if(isCall) {
            SharedPreferenceManager.setBoolean(Constants.NOTIFICATION_PERMISSION_ASKED, true)
            permissionsLauncher.launch(permissionsToRequest.toTypedArray())
        } else {
            permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.NOTIFCATION_PERMISSION_DENIED,
                object : PermissionDialogListener {
                    override fun onPositiveButtonClicked() {
                        SharedPreferenceManager.setBoolean(Constants.NOTIFICATION_PERMISSION_ASKED, true)
                        permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                    }

                    override fun onNegativeButtonClicked() {
                        permissionDialogListener?.onNegativeButtonClicked()
                    }
                })
        }

    }

    private fun showPermissionPopUpForStorage(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CONTACT_AND_MEDIA_PERMISSION,
            object : PermissionDialogListener {
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.STORAGE_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }

                override fun onNegativeButtonClicked() {
                    //Not Needed
                }
            })
    }

    private fun showPermissionPopUpForContactMedia(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.MEDIA_PERMISSION,
            object : PermissionDialogListener {
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.STORAGE_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }

                override fun onNegativeButtonClicked() {
                    //Not Needed
                }
            })
    }

    /**
     * Request the camera and audio permissions for making audio/video calls
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param activityResultCaller activityResultCaller
     */
    fun requestVideoCallPermissions(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        activityResultCaller: ActivityResultLauncher<Array<String>>,
        permissionDialogListener: PermissionDialogListener? = null
    ) {
        val hasCameraPermission = isPermissionAllowed(activity, Manifest.permission.CAMERA)
        val hasMicPermission = isPermissionAllowed(activity, Manifest.permission.RECORD_AUDIO)
        val hasPhoneStatePermission = isPermissionAllowed(activity, Manifest.permission.READ_PHONE_STATE)
        val hasBluetoothPermission = CallManager.isBluetoothPermissionsGranted()

        val permissionsToRequest = mutableListOf<String>()
        if (!hasCameraPermission) {
            permissionsToRequest.add(Manifest.permission.CAMERA)
        }
        if (!hasMicPermission) {
            permissionsToRequest.add(Manifest.permission.RECORD_AUDIO)
        }
        if (!hasPhoneStatePermission) {
            permissionsToRequest.add(Manifest.permission.READ_PHONE_STATE)
        }
        if (SDK_INT >= Build.VERSION_CODES.S && !hasBluetoothPermission) {
            permissionsToRequest.add(Manifest.permission.BLUETOOTH_CONNECT)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_PHONE_STATE)
                        || (SDK_INT >= Build.VERSION_CODES.S && ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.BLUETOOTH_CONNECT))
                -> {
                    askVideoCallPermissions(activityResultCaller, permissionsToRequest, permissionAlertDialog, permissionDialogListener)
                }
                SharedPreferenceManager.getBoolean(Constants.CAMERA_PERMISSION_ASKED)
                        && (SharedPreferenceManager.getBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED)
                        || SharedPreferenceManager.getBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED)
                        || SharedPreferenceManager.getBoolean(Constants.BLUETOOTH_PERMISSION_ASKED))
                -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.VIDEO_CALL_PERMISSION_DENIED,
                        object : PermissionDialogListener {
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                permissionDialogListener?.onNegativeButtonClicked()
                            }
                        })
                }
                else -> {
                    //And finally ask for the permission.
                    askVideoCallPermissions(activityResultCaller, permissionsToRequest, permissionAlertDialog, permissionDialogListener)
                }
            }
        }
    }

    private fun askVideoCallPermissions(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog,
        permissionDialogListener: PermissionDialogListener?
    ) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.VIDEO_CALL_PERMISSION,
            object : PermissionDialogListener {
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.CAMERA_PERMISSION_ASKED, true)
                    SharedPreferenceManager.setBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED, true)
                    SharedPreferenceManager.setBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED, true)
                    SharedPreferenceManager.setBoolean(Constants.BLUETOOTH_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }

                override fun onNegativeButtonClicked() {
                    permissionDialogListener?.onNegativeButtonClicked()
                }
            })
    }

    /**
     * Request the camera and audio permissions for making audio/video calls
     *
     * @param activity       Activity of the View
     * @param activityResultCaller activityResultCaller
     * @param isConversionRequest isConversionRequest
     * @param isFromVideoCallEnable isFromVideoCallEnable we use this parameter to determine whether to launch permission settings in different screen or same screen.
     */
    fun requestVideoCallPermissions(
        activity: Activity,
        activityResultCaller: ActivityResultLauncher<Array<String>>,
        isConversionRequest: Boolean = false,
        isFromVideoCallEnable: Boolean = false
    ) {
        if (!hasAllRequiredPermissions(activity)) {
            when {
                shouldShowPermissionRationale(activity) -> handlePermissionRationale(
                    activity, isConversionRequest, isFromVideoCallEnable, activityResultCaller
                )
                werePermissionsPreviouslyAsked() -> openSettingsForPermission(
                    activity,
                    activity.getString(R.string.video_record_permission_label),
                    isConversionRequest
                )
                else -> askVideoCallPermissions(activityResultCaller)
            }
        }
    }

    private fun hasAllRequiredPermissions(activity: Activity): Boolean {
        return isPermissionAllowed(activity, Manifest.permission.CAMERA)
                && isPermissionAllowed(activity, Manifest.permission.RECORD_AUDIO)
                && isPermissionAllowed(activity, Manifest.permission.READ_PHONE_STATE)
                && (SDK_INT < Build.VERSION_CODES.S || isPermissionAllowed(activity, Manifest.permission.BLUETOOTH_CONNECT))
    }

    private fun shouldShowPermissionRationale(activity: Activity): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_PHONE_STATE)
                || (SDK_INT >= Build.VERSION_CODES.S && ActivityCompat.shouldShowRequestPermissionRationale(
            activity, Manifest.permission.BLUETOOTH_CONNECT
        ))
    }

    private fun werePermissionsPreviouslyAsked(): Boolean {
        return SharedPreferenceManager.getBoolean(Constants.CAMERA_PERMISSION_ASKED)
                && SharedPreferenceManager.getBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED)
                && SharedPreferenceManager.getBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED)
                && SharedPreferenceManager.getBoolean(Constants.BLUETOOTH_PERMISSION_ASKED)
    }

    private fun handlePermissionRationale(
        activity: Activity,
        isConversionRequest: Boolean,
        isFromVideoCallEnable: Boolean,
        activityResultCaller: ActivityResultLauncher<Array<String>>
    ) {
        if (!isConversionRequest) {
            showPermissionRationaleSnackbar(activity, isFromVideoCallEnable)
        } else {
            askVideoCallPermissions(activityResultCaller)
        }
    }

    private fun showPermissionRationaleSnackbar(activity: Activity, isFromVideoCallEnable: Boolean) {
        val snackbarView = activity.layoutInflater.inflate(R.layout.custom_snack_bar, null)
        val snackbarTextView = snackbarView.findViewById<TextView>(R.id.snackbar_text)
        val buttonOk = snackbarView.findViewById<TextView>(R.id.button_ok)
        val buttonNotNow = snackbarView.findViewById<TextView>(R.id.button_not_now)

        snackbarTextView.text = activity.getString(R.string.video_record_permission_label)
        snackbarTextView.maxLines = 5

        val snackbar = Snackbar.make(
            activity.findViewById(android.R.id.content),
            "", // Empty message since custom view is used
            Snackbar.LENGTH_INDEFINITE
        )

        snackbar.view.setPadding(0, 0, 0, 0)
        val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout
        snackbarLayout.addView(snackbarView, 0)

        buttonOk.setOnClickListener {
            openAppSettings(activity, isFromVideoCallEnable)
            snackbar.dismiss()
        }

        buttonNotNow.setOnClickListener { snackbar.dismiss() }
        snackbar.show()
    }

    private fun openAppSettings(activity: Activity, isFromVideoCallEnable: Boolean) {
        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", activity.packageName, null)
        )
        if (!isFromVideoCallEnable) {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        }
        activity.startActivity(intent)
    }


    private fun askVideoCallPermissions(activityResultCaller: ActivityResultLauncher<Array<String>>) {
        val permissionsToRequest = if (SDK_INT >= Build.VERSION_CODES.S) {
            arrayOf(
                Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CAMERA, Manifest.permission.BLUETOOTH_CONNECT
            )
        } else  arrayOf(
            Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA
        )

        activityResultCaller.launch(permissionsToRequest)
        SharedPreferenceManager.setBoolean(Constants.CAMERA_PERMISSION_ASKED, true)
        SharedPreferenceManager.setBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED, true)
        SharedPreferenceManager.setBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED, true)
        SharedPreferenceManager.setBoolean(Constants.BLUETOOTH_PERMISSION_ASKED, true)
    }

    /**
     * Request the camera and audio permissions for making audio/video calls
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param activityResultCaller Permission result launcher
     */
    fun requestAudioCallPermissions(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        activityResultCaller: ActivityResultLauncher<Array<String>>,
        permissionDialogListener: PermissionDialogListener? = null
    ) {
        val hasMicPermission = isPermissionAllowed(activity, Manifest.permission.RECORD_AUDIO)
        val hasPhoneStatePermission = isPermissionAllowed(activity, Manifest.permission.READ_PHONE_STATE)
        val hasBluetoothPermission = CallManager.isBluetoothPermissionsGranted()

        val permissionsToRequest = mutableListOf<String>()
        if (!hasMicPermission) {
            permissionsToRequest.add(Manifest.permission.RECORD_AUDIO)
        }
        if (!hasPhoneStatePermission) {
            permissionsToRequest.add(Manifest.permission.READ_PHONE_STATE)
        }
        if (SDK_INT >= Build.VERSION_CODES.S && !hasBluetoothPermission) {
            permissionsToRequest.add(Manifest.permission.BLUETOOTH_CONNECT)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_PHONE_STATE)
                        || (SDK_INT >= Build.VERSION_CODES.S && ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.BLUETOOTH_CONNECT))
                -> {
                    askAudioCallPermissions(activityResultCaller, permissionsToRequest, permissionAlertDialog, permissionDialogListener)
                }
                SharedPreferenceManager.getBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED)
                        || SharedPreferenceManager.getBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED)
                        || SharedPreferenceManager.getBoolean(Constants.BLUETOOTH_PERMISSION_ASKED)
                -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.AUDIO_CALL_PERMISSION_DENIED,
                        object : PermissionDialogListener {
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                permissionDialogListener?.onNegativeButtonClicked()
                            }
                        })
                }
                else -> {
                    //And finally ask for the permission.
                    askAudioCallPermissions(activityResultCaller, permissionsToRequest, permissionAlertDialog, permissionDialogListener)
                }
            }
        }
    }

    /**
     * Perform the request permissions
     *
     * @param permissionsLauncher Permission result launcher
     * @param permissionsToRequest List of permissions
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     */
    private fun askAudioCallPermissions(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog,
        permissionDialogListener: PermissionDialogListener?
    ) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.AUDIO_CALL_PERMISSION,
            object : PermissionDialogListener {
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED, true)
                    SharedPreferenceManager.setBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED, true)
                    SharedPreferenceManager.setBoolean(Constants.BLUETOOTH_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }

                override fun onNegativeButtonClicked() {
                    permissionDialogListener?.onNegativeButtonClicked()
                }
            })
    }

    /**
     * Request the camera and audio permissions for making audio/video calls
     *
     * @param activity       Activity of the View
     * @param activityResultCaller activityResultCaller
     */
    fun requestAudioCallPermissions(
        activity: Activity, activityResultCaller: ActivityResultLauncher<Array<String>>,
    ) {
        if (!isPermissionAllowed(activity, Manifest.permission.RECORD_AUDIO) ||
            !isPermissionAllowed(activity, Manifest.permission.READ_PHONE_STATE) ||
            (SDK_INT >= Build.VERSION_CODES.S && !isPermissionAllowed(activity, Manifest.permission.BLUETOOTH_CONNECT))
        ) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_PHONE_STATE)
                        || (SDK_INT >= Build.VERSION_CODES.S && ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.BLUETOOTH_CONNECT))
                -> {
                    Snackbar.make(
                        activity.findViewById(android.R.id.content),
                        R.string.record_permission_label,
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.ok_label) {
                            doRequestAudioCallPermissions(activityResultCaller)
                        }.show()
                }

                SharedPreferenceManager.getBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED) ||
                        SharedPreferenceManager.getBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED) ||
                        SharedPreferenceManager.getBoolean(Constants.BLUETOOTH_PERMISSION_ASKED) -> {
                    openSettingsForPermission(
                        activity,
                        activity.getString(R.string.record_permission_label)
                    )
                }
                else -> doRequestAudioCallPermissions(activityResultCaller)
            }
        }
    }

    /**
     * Perform the request permissions via activityResultCaller
     *
     * @param activityResultCaller  activityResultCaller
     */
    private fun doRequestAudioCallPermissions(activityResultCaller: ActivityResultLauncher<Array<String>>) {
        val permissionsToRequest = if (SDK_INT >= Build.VERSION_CODES.S) {
            arrayOf(
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.BLUETOOTH_CONNECT
            )
        } else arrayOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_PHONE_STATE
        )
        activityResultCaller.launch(permissionsToRequest)
        SharedPreferenceManager.setBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED, true)
        SharedPreferenceManager.setBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED, true)
        SharedPreferenceManager.setBoolean(Constants.BLUETOOTH_PERMISSION_ASKED, true)
    }

    /**
     * Calling this method to check the permission status
     *
     * @param context    Context of the activity
     * @param permission Permission to ask
     * @return boolean True if grand the permission
     */
    fun isPermissionAllowed(context: Context?, permission: String?): Boolean {
        return ContextCompat.checkSelfPermission(context!!, permission!!) == PackageManager.PERMISSION_GRANTED
    }


    fun isNotificationPermissionAllowed(context: Context?): Boolean {
        val minSdk32 = SDK_INT < Build.VERSION_CODES.TIRAMISU
        return isPermissionAllowed(context!!, Manifest.permission.POST_NOTIFICATIONS) || minSdk32
    }

    fun isReadFilePermissionAllowed(context: Context?): Boolean {
        return isPermissionAllowed(context!!, Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    fun isWriteFilePermissionAllowed(context: Context?): Boolean {
        val minSdk30 = SDK_INT > Build.VERSION_CODES.Q
        return isPermissionAllowed(context!!, Manifest.permission.WRITE_EXTERNAL_STORAGE) || minSdk30
    }

    fun isWriteContactPermissionAllowed(context: Context?): Boolean {
        val minSdk30 = SDK_INT > Build.VERSION_CODES.Q
        return isPermissionAllowed(context!!, Manifest.permission.WRITE_CONTACTS) || minSdk30
    }

    /**
     * Request the camera permission from the camera chosen for take photo
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    fun requestCameraStoragePermissions(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {
        val hasReadPermission = isPermissionAllowed(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
        val hasCameraPermission = isPermissionAllowed(activity, Manifest.permission.CAMERA)
        val hasWritePermission = isPermissionAllowed(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        val minSdk30 = SDK_INT > Build.VERSION_CODES.Q

        val writePermissionGranted = hasWritePermission || minSdk30

        val permissionsToRequest = mutableListOf<String>()
        if (!writePermissionGranted) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasReadPermission) {
            permissionsToRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (!hasCameraPermission) {
            permissionsToRequest.add(Manifest.permission.CAMERA)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                -> {
                    showPermissionPopUpForCamera(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.CAMERA_PERMISSION_ASKED)
                        && SharedPreferenceManager.getBoolean(Constants.STORAGE_PERMISSION_ASKED)
                -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CAMERA_PERMISSION_DENIED,
                        object : PermissionDialogListener{
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        })
                }
                else -> {
                    showPermissionPopUpForCamera(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
            }
        }
    }

    private fun showPermissionPopUpForCamera(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog
    ) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CAMERA_PERMISSION,
            object : PermissionDialogListener {
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.STORAGE_PERMISSION_ASKED, true)
                    SharedPreferenceManager.setBoolean(Constants.CAMERA_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }

                override fun onNegativeButtonClicked() {
                    //Not Needed
                }
            })
    }

    /**
     * Request the camera permission from the camera chosen for take photo
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    fun requestAudioStoragePermissions(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {
        val hasReadPermission = isPermissionAllowed(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
        val hasRecordAudioPermission = isPermissionAllowed(activity, Manifest.permission.RECORD_AUDIO)
        val hasWritePermission = isPermissionAllowed(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        val minSdk30 = SDK_INT > Build.VERSION_CODES.Q

        val writePermissionGranted = hasWritePermission || minSdk30

        val permissionsToRequest = mutableListOf<String>()
        if (!writePermissionGranted) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasReadPermission) {
            permissionsToRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (!hasRecordAudioPermission) {
            permissionsToRequest.add(Manifest.permission.RECORD_AUDIO)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)
                        || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                -> {
                    showPermissionPopUpForAudioRecord(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED)
                        && SharedPreferenceManager.getBoolean(Constants.STORAGE_PERMISSION_ASKED)
                -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.MIC_PERMISSION_DENIED,
                        object : PermissionDialogListener {
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        })
                }
                else -> {
                    showPermissionPopUpForAudioRecord(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
            }
        }
    }

    private fun showPermissionPopUpForAudioRecord(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog
    ) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.MIC_PERMISSION,
            object : PermissionDialogListener {
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED, true)
                    SharedPreferenceManager.setBoolean(Constants.STORAGE_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }

                override fun onNegativeButtonClicked() {
                    //Not Needed
                }
            })
    }

    /**
     * Request the read contacts permission
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    fun requestContactsReadPermission(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionDialogListener: PermissionDialogListener?
    ) {
        val hasContactPermission = isPermissionAllowed(activity, Manifest.permission.READ_CONTACTS)

        val permissionsToRequest = mutableListOf<String>()
        if (!hasContactPermission) {
            permissionsToRequest.add(Manifest.permission.READ_CONTACTS)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CONTACTS)
                        || !SharedPreferenceManager.getBoolean(Constants.CONTACT_PERMISSION_ASKED)) -> {
                    showPermissionPopUpForContact(permissionsLauncher, permissionsToRequest,
                        permissionAlertDialog, permissionDialogListener)
                }
                else -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CONTACT_PERMISSION_DENIED,
                        object : PermissionDialogListener {
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                permissionDialogListener?.onNegativeButtonClicked()
                            }
                        })
                }
            }
        }
    }

    /**
     * Request the read contacts permission
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    fun requestContactsReadAndWritePermission(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {
        val hasContactPermission = isPermissionAllowed(activity, Manifest.permission.READ_CONTACTS)
        val hasContactWritePermission = isPermissionAllowed(activity, Manifest.permission.WRITE_CONTACTS)

        val permissionsToRequest = mutableListOf<String>()
        if (!hasContactPermission) {
            permissionsToRequest.add(Manifest.permission.READ_CONTACTS)
        }
        if (!hasContactWritePermission) {
            permissionsToRequest.add(Manifest.permission.WRITE_CONTACTS)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CONTACTS) ||
                        ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_CONTACTS)-> {
                    showPermissionPopUpForContactWrite(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.CONTACT_SAVE_PERMISSION_ASKED) -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CONTACT_PERMISSION_DENIED,
                        object : PermissionDialogListener {
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        })
                }
                else -> {
                    showPermissionPopUpForContactWrite(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
            }
        }
    }

    private fun showPermissionPopUpForContactWrite(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog
    ) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CONTACT_PERMISSION,
            object : PermissionDialogListener {
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.CONTACT_SAVE_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }

                override fun onNegativeButtonClicked() {
                    //Not Needed
                }
            })
    }

    private fun showPermissionPopUpForContact(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog,
        permissionDialogListener: PermissionDialogListener?
    ) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CONTACT_PERMISSION,
            object : PermissionDialogListener {
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.CONTACT_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }
                override fun onNegativeButtonClicked() {
                    permissionDialogListener?.onNegativeButtonClicked()
                }
            })
    }

    private fun openSettingsForPermission(activity: Activity, message: String,isConversionRequest: Boolean = false) {
        if(!isConversionRequest){
            val snackbarView = activity.layoutInflater.inflate(R.layout.custom_snack_bar, null)
            val snackbarTextView = snackbarView.findViewById<TextView>(R.id.snackbar_text)
            val buttonOk = snackbarView.findViewById<TextView>(R.id.button_ok)
            val buttonNotNow = snackbarView.findViewById<TextView>(R.id.button_not_now)
            snackbarTextView.text = message

            val snackbar = Snackbar.make(
                activity.findViewById(android.R.id.content),
                "", // Your long text
                Snackbar.LENGTH_INDEFINITE
            )

            snackbarTextView.maxLines = 5  // Adjust max lines based on your content

            snackbar.view.setPadding(0, 0, 0, 0)  // Remove default padding
            val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout
            snackbarLayout.addView(snackbarView, 0)
            buttonOk.setOnClickListener {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", activity.packageName, null))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                activity.startActivity(intent)
                snackbar.dismiss()
            }

            buttonNotNow.setOnClickListener {
                snackbar.dismiss()
            }
            // Show the Snackbar
            snackbar.show()

        } else {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", activity.packageName, null))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
            activity.startActivity(intent)
        }

    }

    private fun openSettingsForPermissionWithoutSmackBar(activity: Activity) {
        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", activity.packageName, null)
        )
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        activity.startActivity(intent)
    }

    /**
     * Calling this method to check the permission status of the location
     *
     * @param context Context of the activity
     * @return boolean True if grand the permission
     */
    fun isLocationPermissionAllowed(context: Context?): Boolean {
        /*
        * Getting the permission status
        */
        val fineLocation = ContextCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION)
        val coarseLocation = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)

        /*
         *If permission is granted returning true
         */
        return fineLocation == PackageManager.PERMISSION_GRANTED && coarseLocation == PackageManager.PERMISSION_GRANTED
    }


    /**
     * Requesting permission for the specific permission from the user
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher permission launcher to request Permission
     */
    fun requestLocationPermission(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {
        val hasLocationPermission = isLocationPermissionAllowed(activity)

        val permissionsToRequest = mutableListOf<String>()
        if (!hasLocationPermission) {
            permissionsToRequest.add(Manifest.permission.ACCESS_FINE_LOCATION)
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION) ||
                        ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION) -> {
                    showPermissionPopUpForLocation(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.LOCATION_PERMISSION_ASKED) -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.LOCATION_PERMISSION_DENIED,
                        object : PermissionDialogListener{
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermissionWithoutSmackBar(activity)
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        })
                }
                else -> {
                    showPermissionPopUpForLocation(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
            }
        }
    }

    private fun showPermissionPopUpForLocation(
        permissionsLauncher: ActivityResultLauncher<Array<String>>,
        permissionsToRequest: MutableList<String>,
        permissionAlertDialog: PermissionAlertDialog
    ) {
        permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.LOCATION_PERMISSION,
            object : PermissionDialogListener{
                override fun onPositiveButtonClicked() {
                    SharedPreferenceManager.setBoolean(Constants.LOCATION_PERMISSION_ASKED, true)
                    permissionsLauncher.launch(permissionsToRequest.toTypedArray())
                }

                override fun onNegativeButtonClicked() {
                    //Not Needed
                }
            })
    }

    /**
     * Request the telephony call permissions
     *
     * @param activity       Activity of the View
     * @param permissionCode Code for start activity
     */
    fun requestTelephoneCallPermissions(activity: Activity, permissionCode: Int) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CALL_PHONE)) {
            /*
              If the user has denied the permission previously your code will come to this block
              Here you can explain why you need this permission Explain here why you need this
              permission
             */
            Snackbar.make(activity.findViewById(android.R.id.content), R.string.calling_permission_label,
                Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.ok_label) { ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CALL_PHONE), permissionCode) }
                .show()
        } else {
            /*
          And finally ask for the permission.
         */
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CALL_PHONE), permissionCode)
        }
    }

    /**
     * Request the read contacts permission
     *
     * @param activity       Activity of the View
     * @param permissionAlertDialog Alert dialog to show Permission instructions
     * @param permissionsLauncher Permission result launcher
     */
    fun requestCameraPermission(
        activity: Activity,
        permissionAlertDialog: PermissionAlertDialog,
        permissionsLauncher: ActivityResultLauncher<Array<String>>
    ) {
        val hasCameraPermission = isPermissionAllowed(activity, Manifest.permission.CAMERA)

        val permissionsToRequest = mutableListOf<String>()

        if (!hasCameraPermission) {
            permissionsToRequest.add(Manifest.permission.CAMERA)
        }
        if (permissionsToRequest.isNotEmpty()) {
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA) -> {
                    showPermissionPopUpForCamera(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
                SharedPreferenceManager.getBoolean(Constants.CAMERA_PERMISSION_ASKED) -> {
                    permissionAlertDialog.showPermissionInstructionDialog(PermissionAlertDialog.CAMERA_PERMISSION_DENIED,
                        object : PermissionDialogListener{
                            override fun onPositiveButtonClicked() {
                                openSettingsForPermission(activity, activity.getString(R.string.camera_permission_label))
                            }

                            override fun onNegativeButtonClicked() {
                                //Not Needed
                            }
                        })
                }
                else -> {
                    showPermissionPopUpForCamera(permissionsLauncher, permissionsToRequest, permissionAlertDialog)
                }
            }
        }
    }

    /**
     * Request the google account permissions
     *
     * @param activity       Activity of the View
     * @param permissionCode Code for start activity
     */
    fun requestAccountPermissions(activity: Activity, permissionCode: Int) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                Manifest.permission.GET_ACCOUNTS
            )
        ) {
            /*
              If the user has denied the permission previously your code will come to this block
              Here you can explain why you need this permission Explain here why you need this
              permission
             */
            Snackbar.make(
                activity.findViewById(android.R.id.content),
                "Reading google accounts are needed for this action",
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction(
                    "OK"
                ) { _: View? ->
                    ActivityCompat.requestPermissions(
                        activity,
                        arrayOf(Manifest.permission.GET_ACCOUNTS),
                        permissionCode
                    )
                }
                .show()
        } else {
            /*
          And finally ask for the permission.
         */
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.GET_ACCOUNTS),
                permissionCode
            )
        }
    }
}