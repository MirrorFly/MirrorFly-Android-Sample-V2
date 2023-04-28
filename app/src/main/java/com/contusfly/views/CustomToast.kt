package com.contusfly.views

import android.R
import android.content.Context
import android.os.Build
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

object CustomToast {
    fun show(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun showShortToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showCustomToast(context: Context, msg: String) {
        val toast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            toast.view?.let { view ->
                view.setBackgroundColor(ContextCompat.getColor(context, com.contusfly.R.color.color_white))
                view.findViewById<TextView>(R.id.message).setTextColor(ContextCompat.getColor(context, com.contusfly.R.color.text_black_dark))
            }
        }
        toast.show()
    }
}