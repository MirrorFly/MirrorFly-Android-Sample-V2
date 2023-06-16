package com.contusfly.views

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.contusfly.R

class CustomAlertDialog {
    fun showFeatureRestrictionAlert(context: Context) {
        val mBuilder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        mBuilder.setMessage(context.getString(R.string.fly_error_forbidden_exception))
        mBuilder.setPositiveButton(context.getString(R.string.ok)) { dialog: DialogInterface?, _: Int ->
            dialog?.dismiss()
        }
        mBuilder.create()
        mBuilder.show()
    }
}