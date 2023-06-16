package com.contusfly.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.widget.ImageView
import com.mirrorflysdk.flycommons.LogMessage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

/**
 * This class used to decode the images...
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class DecodeImageUtils
/**
 * Empty constructor
 */
{
    /**
     * Converts URL into the bitmap
     *
     * @param fil           Local file
     * @param selectedImage Uri of the selected image
     * @param mContext      Application context
     * @return Bitmap Bitmap of the image
     */
    fun decodeStream(fil: File, selectedImage: Uri?, mContext: Context): Bitmap? {
        var bitmap: Bitmap?
        try {
            bitmap = BitmapFactory.decodeStream(mContext.contentResolver.openInputStream(selectedImage!!))
            val thumbSize = ThumbSize().getThbSize(bitmap, ThumbSize.TYPE_STREAM)
            bitmap = Bitmap.createScaledBitmap(bitmap, thumbSize, thumbSize, false)
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, ThumbSize.THUMB_100, baos)
            bitmap = BitmapFactory.decodeStream(ByteArrayInputStream(baos.toByteArray()))
            bitmap = rotateImage(bitmap, fil.absolutePath)
            return bitmap
        } catch (e: Exception) {
            LogMessage.e(e)
        }
        return null
    }

    /**
     * Rotate image the original image
     *
     * @param bmp      Instance of bitmap
     * @param imageUrl Image url
     * @return Bitmap Instance of bitmap
     */
    private fun rotateImage(bmp: Bitmap?, imageUrl: String?): Bitmap? {
        return if (bmp != null) {
            val ei: ExifInterface
            var orientation = 0
            val resizedBitmap: Bitmap
            try {
                ei = ExifInterface(imageUrl!!)
                orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
            } catch (e: IOException) {
                LogMessage.e(e)
            }
            val bmpWidth = bmp.width
            val bmpHeight = bmp.height
            val matrix = Matrix()
            when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> matrix.postRotate(ROTATE_90_D.toFloat())
                ExifInterface.ORIENTATION_ROTATE_180 -> matrix.postRotate(ROTATE_180_D.toFloat())
                ExifInterface.ORIENTATION_ROTATE_270 -> matrix.postRotate(ROTATE_270_D.toFloat())
                else -> {
                    /*No Implementation Neeeded*/
                }
            }
            resizedBitmap = Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeight,
                    matrix, true)
            resizedBitmap
        } else {
            null
        }
    }

    /**
     * Load image in view.
     *
     * @param imageView   The image view
     * @param path        String path
     * @param base64      base64 string
     * @param context     The context of the activity
     * @param id          placeholder resource id
     */
    fun loadImageInView(imageView: ImageView?, path: String?, base64: String, context: Context?, id: Int) {
        if (imageView == null)
            return
        MediaUtils.extendedLoadImageInView(imageView, path, base64, context, id)
    }


    companion object {
        /**
         * 90 Degree Rotation degree of the image
         */
        private const val ROTATE_90_D = 90

        /**
         * 180 Degree Rotation degree of the image
         */
        private const val ROTATE_180_D = 180

        /**
         * 270 Degree Rotation degree of the image
         */
        private const val ROTATE_270_D = 270
    }
}