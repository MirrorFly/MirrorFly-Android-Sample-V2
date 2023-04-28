package com.contusfly.call

import com.contus.call.CallConstants.CALL_UI
import com.contusfly.TAG
import com.mirrorflysdk.flycommons.LogMessage

object CallConfiguration {

    const val IS_GROUP_CALL_ENABLED ="is_group_call_enabled"
    /**
     * flag indicates whether group call feature is enabled or not
     *
     * setting this flag to false will hide call buttons from group, call logs
     * add group call button , add participants button in one to one call
     * and also the call button of group call logs in call log screen.
     */
    private var isGroupCallEnabled = false

    fun isGroupCallEnabled(): Boolean {
        LogMessage.d(TAG, "$CALL_UI isGroupCallEnabled: $isGroupCallEnabled")
        return isGroupCallEnabled
    }

    fun setIsGroupCallEnabled(enabled: Boolean) {
        LogMessage.d(TAG, "$CALL_UI setIsGroupCallEnabled: $enabled")
        isGroupCallEnabled = enabled
    }
}