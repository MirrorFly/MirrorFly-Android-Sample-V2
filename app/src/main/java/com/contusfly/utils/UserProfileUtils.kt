package com.contusfly.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.contusfly.R
import com.contusfly.activities.ImageViewActivity
import com.contusfly.views.CustomTextView
import com.contusfly.views.DoProgressDialog

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class UserProfileUtils {

    /**
     * Redirect to image preview to preview the user image
     *
     * @param activity   Activity of the View
     * @param userImgUrl User profile image url
     */
    fun previewUserImage(activity: Activity, userImgUrl: String?, currentUserJid: String) {
        val profilePhoto = activity.resources.getString(R.string.profile_photo_label)
        val imageChanged = userImgUrl?.contains(Constants.TEMP_PHOTO_FILE_NAME)
        activity.startActivity(Intent(activity, ImageViewActivity::class.java)
                .putExtra(Constants.GROUP_OR_USER_NAME, profilePhoto)
                .putExtra(com.mirrorflysdk.flycommons.Constants.MEDIA_URL, userImgUrl)
                .putExtra(com.mirrorflysdk.flycommons.Constants.GROUP_ID, currentUserJid)
                .putExtra(Constants.FROM_LOGIN_PROFILE,imageChanged))

    }

    /**
     * Change the status of update button after changing user image
     *
     * @param intent           Intent from the previous activity
     * @param userActionUpdate User update TextView
     * @param context          Instance of Context
     */
    fun changeUpdateStatus(intent: Intent, userActionUpdate: CustomTextView, context: Context) {

        // Check whether it is first login or not
        if (intent.getBooleanExtra(Constants.IS_FIRST_LOGIN, false))
            userActionUpdate.text = context.resources.getString(R.string.update_continue_label)
    }

    /**
     * Close progress dialog after the completion of the any background tasks.
     *
     * @param progressDialog The progress dialog of the activity when run the background tasks
     */
    fun closeProgress(progressDialog: DoProgressDialog?) {
        progressDialog?.dismiss()
    }
}