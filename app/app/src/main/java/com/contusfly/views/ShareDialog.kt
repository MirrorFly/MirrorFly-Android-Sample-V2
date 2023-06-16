package com.contusfly.views

import android.app.ProgressDialog
import android.content.Context
import com.contusfly.R

/**
 * A Common Dialog used across Quick Share to show progressDialog and Dismiss them
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class ShareDialog(private val context: Context) {
    /**
     * get instance of progress dialog
     * @return
     */
    /**
     * Instance of the ProgressDialog
     */
    var progressDialog: ProgressDialog? = null
        private set

    /**
     * Dismiss Dialog if it is Showing
     */
    fun dismissShareDialog() {
        if (progressDialog != null) {
            progressDialog!!.dismiss()
        }
    }

    /**
     * Initialize and present the dialog with given title and message
     *
     * @param title   title to show in Dialog
     * @param message message to display in dialog
     */
    fun initializeAndShowShareDialog(title: String, message: String?) {
        progressDialog = ProgressDialog(context, R.style.AppCompatAlertDialogStyle)
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.setCancelable(false)
        if (title.isNotEmpty()) progressDialog!!.setTitle(title)
        progressDialog!!.setMessage(message)
        progressDialog!!.show()
    }
}