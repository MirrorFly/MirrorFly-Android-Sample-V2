package com.contusfly.utils

import android.annotation.TargetApi
import android.app.PendingIntent
import android.content.*
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.contusfly.activities.StartActivity
import com.contusfly.views.CustomDrawable
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.PendingIntentHelper
import com.contusfly.*
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.media.MediaUploadHelper

object AppChatShortCuts {

    @TargetApi(25)
    fun dynamicAppShortcuts(context: Context, toUser: String, chatType: String) {
        try {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(toUser)
            var contactName: String
            profileDetails.let { userVcard -> contactName = userVcard!!.name }

            val contactImageUrl = profileDetails?.image

            val contactBitmap: Drawable? = when (chatType) {
                ChatType.TYPE_GROUP_CHAT -> ContextCompat.getDrawable(context, R.drawable.ic_grp_bg)
                ChatType.TYPE_BROADCAST_CHAT -> ContextCompat.getDrawable(context, R.drawable.ic_broadcast)
                else -> if (profileDetails != null) CustomDrawable(context).getDefaultDrawable(profileDetails) else null
            }

            if (contactImageUrl != null && contactImageUrl.isNotEmpty()) {
                val imgURL = Uri.parse(MediaUploadHelper.UPLOAD_ENDPOINT).buildUpon()
                        .appendPath(Uri.parse(contactImageUrl).lastPathSegment).build().toString()
                Glide.with(context).asBitmap().load(imgURL)
                        .override(128, 128)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .transform(CircleCrop())
                        .error(contactBitmap)
                        .into(object : CustomTarget<Bitmap>(48, 48) {
                            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                                createChatShortcutWithBitmap(context, toUser, chatType, resource, contactName)
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                                //Do nothing
                            }
                        })
            } else {
                Glide.with(context).asBitmap().load(contactBitmap?.toBitmap())
                        .override(128, 128)
                        .transform(CircleCrop())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(object : CustomTarget<Bitmap>(48, 48) {
                            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                                createChatShortcutWithBitmap(context, toUser, chatType, resource, contactName)
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                                //Do nothing
                            }
                        })
            }
        } catch (e: Exception) {
            Log.d(TAG, e.message ?: emptyString())
        }
    }

    private fun createChatShortcutWithBitmap(context: Context, toUser: String, chatType: String, contactBitmap: Bitmap, contactName: String) {
        val shortcut = ShortcutInfoCompat.Builder(context, toUser)
                .setShortLabel(contactName)
                .setLongLabel(contactName)
                .setIcon(IconCompat.createWithAdaptiveBitmap(contactBitmap))
                .setIntent(Intent(context.applicationContext, StartActivity::class.java)
                        .setAction(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        .putExtra(Constants.IS_FROM_CHAT_SHORTCUT, chatType).putExtra(LibConstants.JID, toUser))
                .build()

        pinShortCut(context, shortcut, getPendingIntent(context).intentSender)
    }

    private fun getPendingIntent(context: Context): PendingIntent {
        return PendingIntentHelper.getBroadcast(context, 100, getAppShortCutIntent(context))
    }

    private fun getAppShortCutIntent(context: Context): Intent {
        val chatShortCutSuccessIntent: Intent
        if (Build.VERSION.SDK_INT > 25) {

            context.registerReceiver(object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent?) {
                    context.unregisterReceiver(this)
                }
            }, IntentFilter("ACTION_CREATE_SHORTCUT"))
            chatShortCutSuccessIntent = Intent("ACTION_CREATE_SHORTCUT")
        } else {
            context.registerReceiver(object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent?) {
                    context.unregisterReceiver(this)
                }
            }, IntentFilter("com.android.launcher.action.INSTALL_SHORTCUT"))
            chatShortCutSuccessIntent = Intent("com.android.launcher.action.INSTALL_SHORTCUT")

        }

        return chatShortCutSuccessIntent
    }

    @TargetApi(26)
    private fun pinShortCut(context: Context, shortcutInfo: ShortcutInfoCompat, successCallBack: IntentSender) {
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
            ShortcutManagerCompat.requestPinShortcut(context, shortcutInfo, successCallBack)
            ShortcutManagerCompat.updateShortcuts(context, listOf(shortcutInfo))
        } else context.showToast(context.getString(R.string.biometric_error_sdk_not_supported))
    }



}