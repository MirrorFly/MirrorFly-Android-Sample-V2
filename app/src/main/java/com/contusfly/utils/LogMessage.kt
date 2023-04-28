package com.contusfly.utils

import android.text.TextUtils
import android.util.Log

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class LogMessage {
    companion object {
        private var isDebugEnabled = false

        /*
        * Set Debugging Log Enable/Disable */
        fun enableDebugLogging(boolean: Boolean) {
            isDebugEnabled = boolean
        }

        /*
        * Print Info Log */
        fun i(tag: String?, message: String?) {
            if (isDebugEnabled) Log.i(tag, message!!)
        }

        /*
        * Print Verbose Log */
        fun v(tag: String?, message: String?) {
            if (isDebugEnabled) Log.v(tag, message!!)
        }

        /*
        * Print Error Log */
        fun e(tag: String?, message: String?) {
            if (isDebugEnabled) Log.e(tag, message!!)
        }

        /*
        * Print Debug Log */
        fun d(tag: String?, message: String?) {
            if (isDebugEnabled) Log.d(tag, message!!)
        }

        /*
        * Print Error Log */
        fun e(tag: String?, error: Throwable) {
            Log.e(tag, TextUtils.join("\r\n", error.stackTrace))
            if (isDebugEnabled) Log.e(tag, (if (error.message == null) "Eorror " else error.message)!!)
        }
    }
}