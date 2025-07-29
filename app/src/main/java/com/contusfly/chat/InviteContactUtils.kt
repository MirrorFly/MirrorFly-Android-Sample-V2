package com.contusfly.chat

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.mirrorflysdk.views.CustomToast
import java.lang.Exception

/**
 * Common operations to invite synchronized contact people to install the application and start
 * chat invitation send through mobile sms or email
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
object InviteContactUtils {
    /**
     * Getting email id of the user by clicking the view sending the app invite link to the user
     *
     * @param email   List of email
     * @param context Instance of the application
     */
    private fun sendingInviteAsMail(email: Array<String>, context: Context) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.type = "message/rfc822"
        mIntent.putExtra(Intent.EXTRA_SUBJECT, Constants.MAIL_SUBJECT)
        mIntent.putExtra(
            Intent.EXTRA_TEXT,
            context.resources.getString(R.string.invite_app_message)
        )
        mIntent.putExtra(Intent.EXTRA_EMAIL, email)
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(mIntent)
    }

    /**
     * Copy the download link for application
     *
     * @param position     Position of selected option
     * @param activity     Instance of the application
     * @param email        List of email
     * @param mobileNumber List of mobile number
     */
    fun handleSelectedOptions(
        position: Int,
        activity: Activity,
        email: String?,
        mobileNumber: String?
    ) {
        when (position) {
            0 -> copyLink(activity)
            1 -> sendingUserInviteAsSms(mobileNumber, activity)
        }
    }

    /**
     * Copy the download link for application
     *
     * @param context Instance of the application
     */
    private fun copyLink(context: Context) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(
            "Link",
            context.resources.getString(R.string.invite_app_link)
        )
        clipboard.setPrimaryClip(clip)
        CustomToast.show(context, context.getString(com.mirrorflysdk.R.string.fly_info_msg_link_copied))
    }

    /**
     * Getting mobile number of the user by clicking the view sending the app invite link to the
     * user
     *
     * @param mobileNumber List of mobile number
     * @param activity     Instance of the application
     */
    private fun sendingUserInviteAsSms(mobileNumber: String?, activity: Activity) {
        try {
            /**
             * Verifying whether the selected user provides mobile number or not
             */
            if (mobileNumber != null) {
                val uri = Uri.parse("smsto:$mobileNumber")
                val smsIntent = Intent(Intent.ACTION_SENDTO, uri)
                smsIntent.putExtra(
                    "sms_body",
                    activity.resources.getString(R.string.invite_app_message)
                )
                smsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                activity.startActivity(smsIntent)
            } else CustomToast.show(activity, activity.getString(com.mirrorflysdk.R.string.fly_error_no_mobile_nos))
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }
}