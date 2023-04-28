package com.contusfly.chat

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.mirrorflysdk.api.ChatManager

object MapUtils {

    /**
     * Get the image uri for the particular location
     *
     * @param latitude  Latitude of the location
     * @param longitude Longitude of the location
     * @return String Uri of the location
     */
    fun getMapImageUri(latitude: Double, longitude: Double): String {
        val ai: ApplicationInfo = ChatManager.applicationContext.packageManager
            .getApplicationInfo(ChatManager.applicationContext.packageName, PackageManager.GET_META_DATA)
        val value = ai.metaData["com.google.android.geo.API_THUMP_KEY"]
        val key = value.toString()
        return ("https://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude
                + "&zoom=13&size=300x200&markers=color:red|" + latitude + "," + longitude + "&key="
                + key)
    }
}