package com.contusfly.views

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
open class DoProgressDialog(context: Context) : Dialog(context) {

    /**
     * Shows the progress dialog with the custom view defined.
     */
    open fun showProgress() {
        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            val view: View = LayoutInflater.from(context).inflate(R.layout.progress_dialog, null)
            this.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            this.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(false)
            this.setContentView(view)
            show()
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }
}