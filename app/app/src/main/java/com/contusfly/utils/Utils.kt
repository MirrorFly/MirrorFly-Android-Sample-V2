package com.contusfly.utils

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.contusfly.TAG
import java.math.BigDecimal
import java.math.RoundingMode

object Utils {
    fun returnEmptyStringIfNull(stringValue: String?): String {
        return stringValue?.trim { it <= ' ' } ?: ""
    }

    fun returnEmptyStringIfNull(stringValue: Long?): String {
        return stringValue?.toString() ?: ""
    }

    fun returnZeroIfStringEmpty(stringValue: String): Int {
        return if (!TextUtils.isEmpty(stringValue) && TextUtils.isDigitsOnly(stringValue)) stringValue.toInt() else 0
    }

    private fun getRoundedFileSize(unscaledValue: Double): Double {
        return BigDecimal.valueOf(unscaledValue).setScale(2, RoundingMode.HALF_UP).toDouble()
    }

    fun hideSoftInput(context: Context, view: View?) {
        val inputMethodManager = context.getSystemService("input_method") as InputMethodManager
        if (inputMethodManager != null && view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun clearOldData(context: Context) {
        LogMessage.d(TAG, "clearOldData called")
        SharedPreferenceManager.clearAllPreference()
        ConfigurationUtils.setDefaultValues(context)
        UIKitContactUtils.clearAllData()
    }
}