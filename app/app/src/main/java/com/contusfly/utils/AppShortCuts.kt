package com.contusfly.utils

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.activities.StartActivity
import java.util.*

object AppShortCuts {
    fun dynamicAppShortcuts(context: Context) {
        try {
            val shortcutManager: ShortcutManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                shortcutManager = context.getSystemService(ShortcutManager::class.java)
                //if(shortcutManager.dynamicShortcuts.size == 0) {
                val shortCutList: MutableList<ShortcutInfo> = ArrayList()
                val safeChatShortcut = getShortCutForSafeChat(context)
                shortCutList.add(safeChatShortcut)
                shortcutManager.dynamicShortcuts = shortCutList
                //}
            }
        } catch (e: Exception) {
            LogMessage.e(TAG,e)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N_MR1)
    private fun getShortCutForSafeChat(context: Context): ShortcutInfo {
        val isSafeChatEnabled = SharedPreferenceManager.getBoolean(Constants.IS_SAFE_CHAT_ENABLED)
        val safeChatStatusText = if(isSafeChatEnabled) context.resources.getString(R.string.safe_chat_enable) else context.resources.getString(R.string.safe_chat_disable)
        LogMessage.i(TAG, "getShortCutForSafeChat $safeChatStatusText")
        return ShortcutInfo.Builder(context, context.resources.getString(R.string.safe_chat))
            .setShortLabel(safeChatStatusText)
            .setLongLabel(safeChatStatusText)
            .setIcon(Icon.createWithResource(context, if(!isSafeChatEnabled) R.drawable.ic_safe_chat_on else R.drawable.ic_safe_chat_off))
            .setIntent(
                Intent(context.applicationContext, StartActivity::class.java)
                    .setAction(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    .putExtra(Constants.IS_FOR_SAFE_CHAT, true)
            )
            .build()
    }


}