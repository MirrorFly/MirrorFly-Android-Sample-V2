package com.contusfly.backup

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.Constants
import com.contusfly.R
import com.contusfly.activities.BaseActivity
import com.contusfly.checkInternetAndExecute
import com.contusfly.emptyString
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.PickFileUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.utils.Utils
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope
import com.google.api.services.drive.DriveScopes
import kotlinx.android.synthetic.main.frequency_dialog.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BackupRestoreParent : BaseActivity(), CoroutineScope {

    private var listener : CommonBackupDialogListener? = null

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    protected val commonAlertDialog: CommonAlertDialog by lazy { CommonAlertDialog(this) }

    val filePermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            if(readPermissionGranted) {
                PickFileUtils.pickFile(this)
            }
    }

    interface CommonBackupDialogListener {
        fun onDialogClosed()
    }

    fun setCommonBackupDialogListener(listener: CommonBackupDialogListener) {
        this.listener = listener
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()


    /**
     * Shows the Frequency Dialog
     */
    fun showFrequencyDialog() {

        var dialog: AlertDialog? = null
        val fBuilder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.frequency_dialog, null)
        fBuilder.setView(dialogView)

        val dailyImage = dialogView.dailyImage
        val weeklyImage = dialogView.weeklyImage
        val monthlyImage = dialogView.monthlyImage

        when (SharedPreferenceManager.getString(BackupConstants.BACKUP_FREQUENCY)) {
            BackupConstants.DAILY -> setImageForImageView(
                0,
                listOf(dailyImage, weeklyImage, monthlyImage)
            )
            BackupConstants.MONTHLY -> setImageForImageView(
                2,
                listOf(dailyImage, weeklyImage, monthlyImage)
            )
            else -> {
                setImageForImageView(1, listOf(dailyImage, weeklyImage, monthlyImage))
            }
        }


        dialogView.dailyBox.setOnClickListener {
            setImageForImageView(0, listOf(dailyImage, weeklyImage, monthlyImage))
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FREQUENCY, BackupConstants.DAILY)
            SharedPreferenceManager.setString(BackupConstants.NEXT_BACKUP_TIME, emptyString())
            dialog?.dismiss()
        }

        dialogView.weeklyBox.setOnClickListener {
            setImageForImageView(1, listOf(dailyImage, weeklyImage, monthlyImage))
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FREQUENCY, BackupConstants.WEEKLY)
            SharedPreferenceManager.setString(BackupConstants.NEXT_BACKUP_TIME, emptyString())
            dialog?.dismiss()
        }

        dialogView.monthlyBox.setOnClickListener {
            setImageForImageView(2, listOf(dailyImage, weeklyImage, monthlyImage))
            SharedPreferenceManager.setString(BackupConstants.BACKUP_FREQUENCY, BackupConstants.MONTHLY)
            SharedPreferenceManager.setString(BackupConstants.NEXT_BACKUP_TIME, emptyString())
            dialog?.dismiss()
        }

        dialogView.cancelBtn.setOnClickListener {
            dialog?.dismiss()
        }

        dialog = fBuilder.create()
        dialog.setOnDismissListener {
            listener?.onDialogClosed()
        }
        dialog?.show()
    }

    /**
     * Sets the selected/deselected image in Frequency and Connectivity dialog
     *
     * @param selected Int
     * @param imageViewList List<AppCompatImageView>
     */
    fun setImageForImageView(selected: Int, imageViewList: List<AppCompatImageView>) {
        for ((index, imageView) in imageViewList.withIndex()) {
            if (index == selected) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_backup_selected
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_backup_unselected
                    )
                )
            }
        }
    }


    private fun clientLogout(oldEmail: String) {
        if (oldEmail.isNotEmpty()) {
            val sio = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .setAccountName(oldEmail)
                .requestEmail()
                .build()
            GoogleSignIn.getClient(this, sio).signOut()
        }
    }

    fun clientLogin(newEmail: String, silentSignIn: Boolean = false) {
        val sio = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .setAccountName(newEmail)
            .requestEmail()
            .requestScopes(Scope(DriveScopes.DRIVE_APPDATA))
            .build()

        if (silentSignIn) {
            GoogleSignIn.getClient(this, sio).silentSignIn()
        } else {
            startActivityForResult(
                GoogleSignIn.getClient(this, sio).signInIntent,
                BackupConstants.REQUEST_CODE_SIGN_IN
            )
        }

    }

    fun checkAndLoginMail(accountName:String) {
        checkInternetAndExecute {
            val oldMail = SharedPreferenceManager.getString(BackupConstants.DRIVE_EMAIL)
            if (oldMail != "")
                clientLogout(oldMail)
            clientLogin(accountName)
        }
    }


    /**
     * Handle the Successful Sign in of Google Account with Drive Permission
     * @param resultData Intent sign in data
     */
    fun handleSignInResult(resultData: Intent, driveEmail: CustomTextView) {
        GoogleSignIn.getSignedInAccountFromIntent(resultData)
            .addOnSuccessListener { googleAccount: GoogleSignInAccount ->
                SharedPreferenceManager.setString(BackupConstants.DRIVE_EMAIL, googleAccount.email.toString())
                SharedPreferenceManager.setString(
                    BackupConstants.GOOGLE_ACCOUNT,
                    Utils.getGSONInstance().toJson(googleAccount.account)
                )
                SharedPreferenceManager.setBoolean(BackupConstants.NEED_RELOGIN, false)
                driveEmail.text = googleAccount.email.toString()
            }
    }

    /**
     * Show the dialog for wrong file extension
     */
    fun showFileValidation() {
        commonAlertDialog.showAlertDialog(
            getString(R.string.text_backup_upload),
            Constants.EMPTY_STRING,
            getString(R.string.action_Ok),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
            false
        )
    }

}