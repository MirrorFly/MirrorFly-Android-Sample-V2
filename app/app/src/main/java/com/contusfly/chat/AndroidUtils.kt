package com.contusfly.chat

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import com.contusfly.utils.Constants
import com.contusfly.utils.SharedPreferenceManager
import java.io.File


object AndroidUtils {

    private var density = 1f

    fun getDensity(context: Context): Float {
        if (density == 1f) {
            checkDisplaySize(context)
        }
        return density
    }

    fun dp(value: Float, context: Context): Int {
        if (density == 1f) {
            checkDisplaySize(context)
        }
        return if (value == 0f) {
            0
        } else Math.ceil((density * value).toDouble()).toInt()
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    fun convertDpToPixel(dp: Int, context: Context): Int {
        if (density == 1f) {
            checkDisplaySize(context)
        }
        return (dp * (density / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    fun convertPixelsToDp(px: Int, context: Context): Int {
        if (density == 1f) {
            checkDisplaySize(context)
        }
        return (px / (density / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }


    private fun checkDisplaySize(context: Context) {
        try {
            density = context.resources.displayMetrics.density
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * Device width will be calculated and stored in SharedPreference which will be
     * used to calculate message view width in chat activity
     */
    fun calculateAndStoreDeviceWidth(activity: Activity) {
        val width = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics: WindowMetrics = activity.windowManager.currentWindowMetrics
            val insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMetrics.bounds.width() - insets.left - insets.right
        } else {
            Resources.getSystem().displayMetrics.widthPixels
        }
        val measuredWidth = width * 0.7
        val calculatedWidth = measuredWidth.toInt()
        SharedPreferenceManager.setInt(Constants.DEVICE_WIDTH, calculatedWidth)
    }

    fun getStatusBarHeight(context: Context):Int{
        val resources = context.resources
        val statusBarHeightId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (statusBarHeightId>0)
            resources.getDimensionPixelSize(statusBarHeightId)
        else
            0
    }

    fun getNavBarHeight(context: Context): Int {
        //The device has a navigation bar
        val resources = context.resources
        val orientation = resources.configuration.orientation
        val resourceId = if (isTablet(context)) {
            resources.getIdentifier(
                if (orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_height" else "navigation_bar_height_landscape",
                "dimen",
                "android"
            )
        } else {
            resources.getIdentifier(
                if (orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_height" else "navigation_bar_width",
                "dimen",
                "android"
            )
        }
        return if (resourceId > 0) {
            resources.getDimensionPixelSize(resourceId)
        } else
            0
    }

    private fun isTablet(c: Context): Boolean {
        return ((c.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }

    fun getFileSizeInMb(file: File): Float {
        // Get length of file in bytes
        val fileSizeInBytes = file.length()
        // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
        val fileSizeInKB = fileSizeInBytes / 1024f
        // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
        val fileSizeInMB = fileSizeInKB / 1024f
        Log.d("getFileSizeInMb", "getFileSizeInMb : $fileSizeInMB")
        return fileSizeInMB
    }

    fun getScreenWidth(activity: Activity): Int {
        val displayMetrics = DisplayMetrics()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val display = activity.display
            display?.getRealMetrics(displayMetrics)
        } else {
            @Suppress("DEPRECATION")
            val display = activity.windowManager.defaultDisplay
            @Suppress("DEPRECATION")
            display.getMetrics(displayMetrics)
        }
        return displayMetrics.widthPixels
    }
}
