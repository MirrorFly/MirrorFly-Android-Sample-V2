package com.contusfly.views

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.contusfly.R
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.viewbinding.ViewBinding
import com.contusfly.chat.AndroidUtils
import com.contusfly.databinding.NotificationPermissionDialogBinding
import com.contusfly.databinding.PermissionInstructionDialogBinding
import com.contusfly.interfaces.PermissionDialogListener


/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class PermissionAlertDialog(private var activity: Activity) {

    fun showPermissionInstructionDialog(
        permissionType: String,
        permissionDialogListener: PermissionDialogListener
    ) {
        var dialogBinding : ViewBinding?=null
        var dialogBuilder:AlertDialog.Builder
        if(permissionType == NOTIFCATION_PERMISSION_DENIED){
            dialogBuilder = AlertDialog.Builder(activity,R.style.TrasparentAlertDialog)
            val inflater: LayoutInflater = activity.layoutInflater
            dialogBinding = NotificationPermissionDialogBinding.inflate(inflater)
            dialogBuilder.apply {
                setCancelable(false)
                setView((dialogBinding)!!.root)

            }
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
            adjustAlertDialogWidth(activity, alertDialog)
            dialogBinding.turnOnTv.setOnClickListener{
                alertDialog.dismiss()
                permissionDialogListener.onPositiveButtonClicked()
            }
            dialogBinding.closeIcon.setOnClickListener{
                permissionDialogListener.onNegativeButtonClicked()
                alertDialog.dismiss()
            }
            dialogBinding.notNowTv.setOnClickListener{
                permissionDialogListener.onNegativeButtonClicked()
                alertDialog.dismiss()
            }
        } else {
            dialogBuilder = AlertDialog.Builder(activity, R.style.CustomAlertDialog)
            val inflater: LayoutInflater = activity.layoutInflater
            dialogBinding = PermissionInstructionDialogBinding.inflate(inflater)
            dialogBinding.dialogIcon.setImageResource(getDialogIcon(permissionType))
            dialogBinding.dialogDescription.text = getDialogDescription(permissionType)
            dialogBuilder.apply {
                setCancelable(false)
                setView(dialogBinding.root)
                setPositiveButton(activity.getString(R.string.continue_label)) { dialog, _ ->
                    dialog.dismiss()
                    permissionDialogListener.onPositiveButtonClicked()
                }
                setNegativeButton(activity.getString(R.string.not_now_label)) { dialog, _ ->
                    dialog.dismiss()
                    permissionDialogListener.onNegativeButtonClicked()
                }
            }
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
            adjustAlertDialogWidth(activity, alertDialog)
        }

    }

    private fun getDialogDescription(permissionType: String): CharSequence {
        return when (permissionType) {
            CONTACT_AND_MEDIA_PERMISSION -> activity.getString(R.string.contact_and_media_permission_alert_label)
            CONTACT_PERMISSION -> activity.getString(R.string.contact_permission_alert_label)
            CONTACT_PERMISSION_DENIED -> activity.getString(R.string.contact_permission_denied_alert_label)
            LOCATION_PERMISSION -> activity.getString(R.string.location_permission_alert_label)
            LOCATION_PERMISSION_DENIED -> activity.getString(R.string.location_permission_denied_alert_label)
            CAMERA_PERMISSION -> activity.getString(R.string.camera_permission_alert_label)
            CAMERA_PERMISSION_DENIED -> activity.getString(R.string.camera_permission_denied_alert_label)
            MEDIA_PERMISSION -> activity.getString(R.string.media_permission_alert_label)
            MEDIA_PERMISSION_DENIED -> activity.getString(R.string.media_permission_denied_alert_label)
            MIC_PERMISSION -> activity.getString(R.string.mic_permission_alert_label)
            MIC_PERMISSION_DENIED -> activity.getString(R.string.mic_permission_denied_alert_label)
            AUDIO_CALL_PERMISSION -> activity.getString(R.string.audio_call_permission_alert_label)
            AUDIO_CALL_PERMISSION_DENIED -> activity.getString(R.string.audio_call_permission_denied_alert_label)
            VIDEO_CALL_PERMISSION -> activity.getString(R.string.video_call_permission_alert_label)
            VIDEO_CALL_PERMISSION_DENIED -> activity.getString(R.string.video_call_permission_denied_alert_label)
            NOTIFCATION_PERMISSION_DENIED -> activity.getString(R.string.notification_permission_denied_alert_label)
            else -> activity.getString(R.string.contact_and_media_permission_alert_label)
        }
    }

    private fun getDialogIcon(permissionType: String): Int {
        return when (permissionType) {
            CONTACT_AND_MEDIA_PERMISSION -> R.drawable.ic_contact_media_alert
            CONTACT_PERMISSION, CONTACT_PERMISSION_DENIED -> R.drawable.ic_contact_alert
            LOCATION_PERMISSION, LOCATION_PERMISSION_DENIED -> R.drawable.ic_location_alert
            CAMERA_PERMISSION, CAMERA_PERMISSION_DENIED -> R.drawable.ic_camera_alert
            MEDIA_PERMISSION, MEDIA_PERMISSION_DENIED -> R.drawable.ic_media_alert
            MIC_PERMISSION, MIC_PERMISSION_DENIED -> R.drawable.ic_mic_alert
            AUDIO_CALL_PERMISSION, AUDIO_CALL_PERMISSION_DENIED -> R.drawable.ic_mic_alert
            VIDEO_CALL_PERMISSION, VIDEO_CALL_PERMISSION_DENIED -> R.drawable.ic_video_call_alert
            NOTIFCATION_PERMISSION_DENIED -> R.drawable.ic_notification_alert
            else -> R.drawable.ic_contact_media_alert
        }
    }

    private fun adjustAlertDialogWidth(activity: Activity, alertDialog: AlertDialog) {
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(alertDialog.window!!.attributes)
        layoutParams.width = (AndroidUtils.getScreenWidth(activity) * 0.80).toInt()
        alertDialog.window!!.attributes = layoutParams
    }

    companion object {
        const val CONTACT_AND_MEDIA_PERMISSION = "contact_and_media_permission"
        const val CONTACT_PERMISSION = "contact_permission"
        const val CONTACT_PERMISSION_DENIED = "contact_permission_denied"
        const val LOCATION_PERMISSION = "location_permission"
        const val LOCATION_PERMISSION_DENIED = "location_permission_denied"
        const val CAMERA_PERMISSION = "camera_permission"
        const val CAMERA_PERMISSION_DENIED = "camera_permission_denied"
        const val MEDIA_PERMISSION = "media_permission"
        const val MEDIA_PERMISSION_DENIED = "media_permission_denied"
        const val MIC_PERMISSION = "mic_permission"
        const val MIC_PERMISSION_DENIED = "mic_permission_denied"
        const val AUDIO_CALL_PERMISSION = "audio_call_permission"
        const val AUDIO_CALL_PERMISSION_DENIED = "audio_call_permission_denied"
        const val VIDEO_CALL_PERMISSION = "video_call_permission"
        const val VIDEO_CALL_PERMISSION_DENIED = "video_call_permission_denied"
        const val NOTIFCATION_PERMISSION_DENIED = "notification_permission_denied"
    }
}