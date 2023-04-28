/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.utils

import android.graphics.Bitmap
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage

/**
 * This class is used to get the thumb size of the image from the bitmap
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
internal class ThumbSize {
    /**
     * Gets the thumb size of the image.
     *
     * @param bitmap Bitmap of image
     * @param type   Image type
     * @return int Thumb size
     */
    fun getThbSize(bitmap: Bitmap, type: Int): Int {
        var thumbsize = THUMB_64
        if (type == TYPE_BITMAP) {
            thumbsize = THUMB_120
            thumbsize = resizeBitmap(bitmap.width, thumbsize)
        } else if (type == TYPE_STREAM) {
            thumbsize = resizeImage(bitmap.width)
        }
        return thumbsize
    }

    /**
     * Resize the bitmap image
     *
     * @param bitmapWidth Width of the Image
     * @param thbSize     The thumb size of image
     * @return int Size of bitmap
     */
    private fun resizeBitmap(bitmapWidth: Int, thbSize: Int): Int {
        var tempSize = thbSize
        try {
            if (bitmapWidth < WIDTH_200) tempSize = THUMB_64 else if (bitmapWidth < WIDTH_500) tempSize = THUMB_200 else if (bitmapWidth < WIDTH_1000) tempSize = THUMB_250 else if (bitmapWidth < WIDTH_2000) tempSize = THUMB_300 else if (bitmapWidth < WIDTH_4000) tempSize = THUMB_400 else if (bitmapWidth > WIDTH_4000) tempSize = THUMB_450
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
        return tempSize
    }

    /**
     * Resize image the original image
     *
     * @param bitmapWidth Width of the bitmap
     * @return int Thumb size
     */
    private fun resizeImage(bitmapWidth: Int): Int {
        var thumbsize = 0
        try {
            if (bitmapWidth < WIDTH_200) thumbsize = THUMB_64 else if (bitmapWidth < WIDTH_500) thumbsize = THUMB_100 else if (bitmapWidth < WIDTH_1000) thumbsize = THUMB_150 else if (bitmapWidth < WIDTH_2000) thumbsize = THUMB_250 else if (bitmapWidth < WIDTH_4000) thumbsize = THUMB_300 else if (bitmapWidth > WIDTH_4000) thumbsize = THUMB_450
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
        return thumbsize
    }

    companion object {
        /**
         * Stream type
         */
        const val TYPE_STREAM = 1

        /**
         * Thumb image size for 100
         */
        const val THUMB_100 = 100

        /**
         * Bitmap type
         */
        private const val TYPE_BITMAP = 2

        /**
         * Size of the thumb image 120
         */
        private const val THUMB_120 = 120

        /**
         * Width size of the media 120
         */
        private const val WIDTH_200 = 200

        /**
         * Width size of the media 500
         */
        private const val WIDTH_500 = 500

        /**
         * Width size of the media 1000
         */
        private const val WIDTH_1000 = 1000

        /**
         * Width size of the media 2000
         */
        private const val WIDTH_2000 = 2000

        /**
         * Width size of the media 4000
         */
        private const val WIDTH_4000 = 400

        /**
         * Thumb image size for 64
         */
        private const val THUMB_64 = 64

        /**
         * Thumb image size for 200
         */
        private const val THUMB_200 = 200

        /**
         * Thumb image size for 150
         */
        private const val THUMB_150 = 150

        /**
         * Thumb image size for 250
         */
        private const val THUMB_250 = 250

        /**
         * Thumb image size for 300
         */
        private const val THUMB_300 = 300

        /**
         * Thumb image size for 400
         */
        private const val THUMB_400 = 400

        /**
         * Thumb image size for 450
         */
        private const val THUMB_450 = 450
    }
}