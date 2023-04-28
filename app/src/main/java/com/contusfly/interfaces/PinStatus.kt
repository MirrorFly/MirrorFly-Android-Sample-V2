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
annotation class PinStatus {
    companion object {
        // Define the list of accepted constants
        var PIN_SET = "pin_set"
        var PIN_CHANGE = "pin_change"
        var PIN_FORGOT = "pin_forgot"
        var PIN_DISABLE = "pin_disable"
    }
}