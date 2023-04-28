package com.contusfly.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.ComponentName
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import com.contusfly.R
import com.contusfly.activities.ImageViewActivity.Companion.startActivity
import com.contusfly.chat.AndroidUtils
import com.contusfly.databinding.PermissionInstructionDialogBinding
import java.util.*


class AutoStartHelper private constructor() {
    /***
     * Xiaomi
     */
    private val BRAND_XIAOMI = "xiaomi"
    private val PACKAGE_XIAOMI_MAIN = "com.miui.securitycenter"
    private val PACKAGE_XIAOMI_COMPONENT =
        "com.miui.permcenter.autostart.AutoStartManagementActivity"
    private val PACKAGE_XIAOMI_WINDOW_COMPONENT = "com.miui.permcenter.permissions.PermissionsEditorActivity"

    /***
     * Letv
     */
    private val BRAND_LETV = "letv"
    private val PACKAGE_LETV_MAIN = "com.letv.android.letvsafe"
    private val PACKAGE_LETV_COMPONENT = "com.letv.android.letvsafe.AutobootManageActivity"

    /***
     * ASUS ROG
     */
    private val BRAND_ASUS = "asus"
    private val PACKAGE_ASUS_MAIN = "com.asus.mobilemanager"
    private val PACKAGE_ASUS_COMPONENT = "com.asus.mobilemanager.powersaver.PowerSaverSettings"

    /***
     * Honor
     */
    private val BRAND_HONOR = "honor"
    private val PACKAGE_HONOR_MAIN = "com.huawei.systemmanager"
    private val PACKAGE_HONOR_COMPONENT =
        "com.huawei.systemmanager.optimize.process.ProtectActivity"

    /**
     * Oppo
     */
    private val BRAND_OPPO = "oppo"
    private val PACKAGE_OPPO_MAIN = "com.coloros.safecenter"
    private val PACKAGE_OPPO_FALLBACK = "com.oppo.safe"
    private val PACKAGE_OPPO_COMPONENT =
        "com.coloros.safecenter.permission.startup.StartupAppListActivity"
    private val PACKAGE_OPPO_COMPONENT_FALLBACK =
        "com.oppo.safe.permission.startup.StartupAppListActivity"
    private val PACKAGE_OPPO_COMPONENT_FALLBACK_A =
        "com.coloros.safecenter.startupapp.StartupAppListActivity"

    /**
     * Vivo
     */
    private val BRAND_VIVO = "vivo"
    private val PACKAGE_VIVO_MAIN = "com.iqoo.secure"
    private val PACKAGE_VIVO_FALLBACK = "com.vivo.permissionmanager"
    private val PACKAGE_VIVO_COMPONENT = "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"
    private val PACKAGE_VIVO_COMPONENT_FALLBACK =
        "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
    private val PACKAGE_VIVO_COMPONENT_FALLBACK_A =
        "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"

    /**
     * Nokia
     */
    private val BRAND_NOKIA = "nokia"
    private val PACKAGE_NOKIA_MAIN = "com.evenwell.powersaving.g3"
    private val PACKAGE_NOKIA_COMPONENT =
        "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity"

    /***
     * Oneplus
     */
    private val BRAND_ONEPLUS = "oneplus"



    fun getAutoStartPermission(context: Context) {
        if(!SharedPreferenceManager.getBoolean(Constants.ASK_PERMISSION)) {
            val buildInfo = Build.BRAND.toLowerCase()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                when (buildInfo) {
                    BRAND_ONEPLUS -> allowPermissiononeplus(context)
                }
            } else {
                when (buildInfo) {
                    BRAND_XIAOMI -> autoStartXiaomi(context)
                    BRAND_OPPO -> autoStartOppo(context)
                    BRAND_VIVO -> autoStartVivo(context)
                }

            }
        }
    }

    private fun allowPermissiononeplus(context: Context) {
            SharedPreferenceManager.setBoolean(Constants.ASK_PERMISSION, true)
            showAlert(context) { dialog: DialogInterface, which: Int ->
                try {
                    val intent = Intent(
                        Settings.ACTION_APP_NOTIFICATION_SETTINGS
                    )
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName);
                    context.startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                dialog.dismiss()
            }
    }

    private fun showAlert(context: Context, onClickListener: DialogInterface.OnClickListener) {
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context, R.style.CustomAlertDialog)
        val inflater: LayoutInflater = (context as Activity).layoutInflater
        val dialogBinding = PermissionInstructionDialogBinding.inflate(inflater)
        dialogBinding.dialogIcon.setImageResource(R.drawable.ic_group_setting)
        dialogBinding.dialogDescription.text = "You will not receive notifications while the app is in background if you disable these permissions"
        dialogBuilder.apply {
            setCancelable(false)
            setView(dialogBinding.root)
            setPositiveButton(context.getString(R.string.continue_label),onClickListener)
            setNegativeButton(context.getString(R.string.not_now_label)) { dialog, _ ->
                dialog.dismiss()
            }
        }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
        adjustAlertDialogWidth(context, alertDialog)
    }

    private fun adjustAlertDialogWidth(activity: Activity, alertDialog: androidx.appcompat.app.AlertDialog) {
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(alertDialog.window!!.attributes)
        layoutParams.width = (AndroidUtils.getScreenWidth(activity) * 0.78).toInt()
        alertDialog.window!!.attributes = layoutParams
    }

    private fun autoStartXiaomi(context: Context) {
        if (isPackageExists(context, PACKAGE_XIAOMI_MAIN)) {
            SharedPreferenceManager.setBoolean(Constants.ASK_PERMISSION, true)
            showAlert(
                context
            ) { dialog: DialogInterface?, which: Int ->
                try {
                    xiaomiFloating(context,PACKAGE_XIAOMI_MAIN,PACKAGE_XIAOMI_WINDOW_COMPONENT)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun autoStartOppo(context: Context) {
        if (isPackageExists(context, PACKAGE_OPPO_MAIN) || isPackageExists(
                context,
                PACKAGE_OPPO_FALLBACK
            )
        ) {
            SharedPreferenceManager.setBoolean(Constants.ASK_PERMISSION, true)
            showAlert(context) { dialog, which ->
                try {
                    startIntent(context, PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT)
                } catch (e: Exception) {
                    e.printStackTrace()
                    try {
                        startIntent(context, PACKAGE_OPPO_FALLBACK, PACKAGE_OPPO_COMPONENT_FALLBACK)
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                        try {
                            startIntent(
                                context,
                                PACKAGE_OPPO_MAIN,
                                PACKAGE_OPPO_COMPONENT_FALLBACK_A
                            )
                        } catch (exx: Exception) {
                            exx.printStackTrace()
                        }
                    }
                }
            }
        }
    }

    private fun autoStartVivo(context: Context) {
        if (isPackageExists(context, PACKAGE_VIVO_MAIN) || isPackageExists(
                context,
                PACKAGE_VIVO_FALLBACK
            )
        ) {
            SharedPreferenceManager.setBoolean(Constants.ASK_PERMISSION, true)
            showAlert(context) { dialog, which ->
                try {
                    startIntent(context, PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT)
                } catch (e: Exception) {
                    e.printStackTrace()
                    try {
                        startIntent(context, PACKAGE_VIVO_FALLBACK, PACKAGE_VIVO_COMPONENT_FALLBACK)
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                        try {
                            startIntent(
                                context,
                                PACKAGE_VIVO_MAIN,
                                PACKAGE_VIVO_COMPONENT_FALLBACK_A
                            )
                        } catch (exx: Exception) {
                            exx.printStackTrace()
                        }
                    }
                }
            }
        }
    }

    @Throws(Exception::class)
    private fun startIntent(context: Context, packageName: String, componentName: String) {
        try {
            val intent = Intent()
            intent.component = ComponentName(packageName, componentName)

            context.startActivity(intent)
        } catch (var5: Exception) {
            var5.printStackTrace()
            throw var5
        }
    }

    private fun xiaomiFloating(context: Context,packageName: String, componentName: String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(context) && ("xiaomi" == Build.MANUFACTURER.toLowerCase())) {
                    val intent = Intent("miui.intent.action.APP_PERM_EDITOR")
                    intent.setClassName(
                        packageName,
                        componentName
                    )
                    intent.putExtra("extra_pkgname", context.packageName)
                    context.startActivity(intent)



        }


    }

    private fun isPackageExists(context: Context, targetPackage: String): Boolean {
        val packages: List<ApplicationInfo>
        val pm: PackageManager = context.getPackageManager()
        packages = pm.getInstalledApplications(0)
        for (packageInfo in packages) {
            if (packageInfo.packageName == targetPackage) {
                return true
            }
        }
        return false
    }

    companion object {
        val instance: AutoStartHelper
            get() = AutoStartHelper()
    }
}