package com.contusfly.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import com.mirrorflysdk.flycommons.ChatType
import com.contusfly.R

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
        if (chatType.equals(ChatType.TYPE_CHAT, ignoreCase = true))
            return context.resources.getDrawable(R.drawable.ic_profile)
        else if (chatType.equals(ChatType.TYPE_GROUP_CHAT, ignoreCase = true))
            return context.resources.getDrawable(R.drawable.ic_grp_bg)
        else if (chatType.equals(ChatType.TYPE_BROADCAST_CHAT, ignoreCase = true))
            return context.resources.getDrawable(R.drawable.ic_broadcast)
        return context.resources.getDrawable(R.drawable.ic_profile)
    }
}