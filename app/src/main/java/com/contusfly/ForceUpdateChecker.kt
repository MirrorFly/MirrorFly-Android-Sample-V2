package com.contusfly

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class ForceUpdateChecker(private val activity: Activity) {
    /**
     * This method currently launches the activity.
     */
    fun check() {
        val remoteConfig = FirebaseRemoteConfig.getInstance()
        if (remoteConfig.getBoolean(ANDROID_FORCE_UPDATE_REQUIRED)) {
            val currentVersion = remoteConfig.getString(ANDROID_FORCE_UPDATE_VERSION)
            Log.e("force update version = ", remoteConfig.getString(ANDROID_FORCE_UPDATE_VERSION))
            val appVersion = getAppVersion(activity)
            Log.e("app version = ", appVersion)
            val result = compare(currentVersion, appVersion)
            /**
             * if result = 1, then current version is greater, then we should show update dialog
             * if result = -1, then current version is lesser, then we should not show update dialog
             */
            if (result == 1) {
                if (!SharedPreferenceManager.getBoolean(Constants.IS_DIALOG_SHOWING)) displayAppUpdateDialog(
                    remoteConfig
                )
            } else {
                Log.e("Version check", "")
            }
        }
    }

    /**
     * show force update dialog
     *
     * @param remoteConfig firebase remoteConfig object.
     */
    private fun displayAppUpdateDialog(remoteConfig: FirebaseRemoteConfig) {
        val title = remoteConfig.getString(ANDROID_FORCE_UPDATE_TITLE)
        val message = remoteConfig.getString(ANDROID_FORCE_UPDATE_MESSAGE)
        val builder = AlertDialog.Builder(
            activity, R.style.AlertDialogStyle
        )
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                activity.resources.getString(R.string.force_update_action)
            ) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                SharedPreferenceManager.setBoolean(Constants.IS_DIALOG_SHOWING, false)
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(APP_PLAY_STORE_URL))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                activity.startActivity(intent)
            }
        val dialog = builder.create()
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
        SharedPreferenceManager.setBoolean(Constants.IS_DIALOG_SHOWING, true)
    }

    /**
     * get current version of the app.
     *
     * @param context of the activity
     * @return app version in string type
     */
    private fun getAppVersion(context: Context): String {
        var result = ""
        try {
            result = context.packageManager
                .getPackageInfo(context.packageName, 0).versionName
            result = result.replace("[a-zA-Z]|-".toRegex(), "")
        } catch (e: PackageManager.NameNotFoundException) {
            LogMessage.e(TAG, e)
        }
        return result
    }

    /**
     * This method does some serious stuff
     */
    class Builder
    /**
     * constructor of the Builder
     *
     * @param activity context of the activity
     */(private val activity: Activity) {
        /**
         * Get ForceUpdateChecker
         *
         * @return The value of the activity property
         */
        fun build(): ForceUpdateChecker {
            return ForceUpdateChecker(activity)
        }
    }

    companion object {
        const val ANDROID_FORCE_UPDATE_REQUIRED = "android_force_update_required"
        const val ANDROID_FORCE_UPDATE_VERSION = "android_force_update_version"
        private const val ANDROID_FORCE_UPDATE_TITLE = "android_force_update_title"
        private const val ANDROID_FORCE_UPDATE_MESSAGE = "android_force_update_desc"
        private const val APP_PLAY_STORE_URL =
            "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID

        /**
         * This method is to create builder instance
         *
         * @param activity context of the activity
         * @return builder instance
         */
        fun with(activity: Activity): Builder {
            return Builder(activity)
        }

        /**
         * @param version1 currentVersion of the app
         * @param version2 appVersion what user currently using.
         * @return 1, if current version is greater; -1 current version is lesser
         */
        private fun compare(version1: String, version2: String): Int {
            val ver1 = version1.split(".").toTypedArray()
            val ver2 = version2.split(".").toTypedArray()
            var counter = 0
            var len1 = ver1.size
            var len2 = ver2.size
            for (v in ver1) {
                val vNum = v.toInt()
                if (len1 > 0 && len2 > 0 && vNum > ver2[counter].toInt()) {
                    return 1
                } else {
                    if (len1 > 0 && len2 > 0 && vNum < ver2[counter].toInt()) {
                        return -1
                    } else {
                        len1--
                        len2--
                        counter++
                    }
                }
            }
            if (ver1.size > ver2.size) {
                return 1
            } else if (ver1.size < ver2.size) {
                return -1
            }
            return 0
        }
    }
}