package com.contusfly.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import com.mirrorflysdk.flycommons.ChatType
import com.contusfly.R
import com.contusfly.checkEqualString

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
object ProfilePicUtil {

    /**
     * Get the default pic for each profile type when the user uploaded pic is not there &
     * the user is blocked or unknown
     * @param context
     * @param chatType 'chat','group'...
     * @return drawable
     */
    @SuppressLint("UseCompatLoadingForDrawables")
    fun getDefaultDrawable(context: Context, chatType: String): Drawable? {
        return when {
            checkEqualString(chatType,ChatType.TYPE_CHAT) -> context.resources.getDrawable(R.drawable.ic_profile, null)
            checkEqualString(chatType,ChatType.TYPE_GROUP_CHAT) -> context.resources.getDrawable(R.drawable.ic_grp_bg, null)
            checkEqualString(chatType,ChatType.TYPE_BROADCAST_CHAT) -> context.resources.getDrawable(R.drawable.ic_broadcast, null)
            else -> context.resources.getDrawable(R.drawable.ic_profile, null)
        }
    }
}