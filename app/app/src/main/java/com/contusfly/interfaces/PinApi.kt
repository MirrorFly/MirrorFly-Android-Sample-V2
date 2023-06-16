package com.contusfly.interfaces

import androidx.annotation.StringDef
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * This class contains call status constants
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@Retention(RetentionPolicy.SOURCE)
annotation class PinApi {
    companion object {
        // Define the list of accepted constants
        var REQUEST_OTP = "request_otp"
        var VERIFY_OTP = "verify_otp"
        var SAVE_PIN = "save_pin"
    }
}