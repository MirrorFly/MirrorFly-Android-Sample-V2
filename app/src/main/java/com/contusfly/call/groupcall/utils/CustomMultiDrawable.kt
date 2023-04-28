package com.contusfly.call.groupcall.utils

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.ThumbnailUtils
import android.net.Uri
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.contusfly.getDefaultDrawable
import com.contusfly.getMoreUsersDrawable
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.views.CustomDrawable
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.media.MediaUploadHelper
import java.util.*


/**
 * Multiple Images in Single ImageView to display in the chat list
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
class CustomMultiDrawable internal constructor(private val userList: ArrayList<String>, private val context: Context) : Drawable() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val items = ArrayList<PhotoItem>()
    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        init()
    }

    override fun draw(canvas: Canvas) {
        for (i in items.indices) {
            canvas.drawBitmap(items[i].bitmap, bounds, items[i].position, paint)
        }
    }

    override fun setAlpha(i: Int) {
        paint.alpha = i
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    /**
     * Create PhotoItem with position and size depends of count of images
     */
    private fun init() {
        items.clear()
        when (userList.size) {
            1 -> {
                setSingleProfile()
            }
            2 -> {
                setTwoUserProfile()
            }
            3 -> {
                setThreeUserProfile()
            }
            else -> {
                setFourOrMoreUserProfile()
            }
        }
    }

    private fun setFourOrMoreUserProfile() {
        if (userList.size >= 4) {
            val profileDetails1 = ProfileDetailsUtils.getProfileDetails(userList[0])
            if (profileDetails1 != null) {
                val tempBitmap1 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails1))
                val fourthBitmap1 = scaleCenterCrop(tempBitmap1, bounds.width(), bounds.height())
                items.add(PhotoItem(
                        getCroppedBitmap(fourthBitmap1),
                        Rect(0, 0, bounds.width() / 2, bounds.height() / 2)
                ))
                addImage(profileDetails1, context, tempBitmap1, 0)
            }
            val profileDetails2 = ProfileDetailsUtils.getProfileDetails(userList[1])
            if (profileDetails2 != null) {
                val tempBitmap2 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails2))
                val fourthBitmap2 = scaleCenterCrop(tempBitmap2, bounds.width(), bounds.height())
                items.add(PhotoItem(
                        getCroppedBitmap(fourthBitmap2),
                        Rect(0, bounds.height() / 2, bounds.width() / 2, bounds.height())
                ))
                addImage(profileDetails2, context, tempBitmap2, items.size - 1)
            }
            val profileDetails3 = ProfileDetailsUtils.getProfileDetails(userList[2])
            if (profileDetails3!= null) {
                val tempBitmap3 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails3))
                val fourthBitmap3 = scaleCenterCrop(tempBitmap3, bounds.width(), bounds.height())
                items.add(PhotoItem(
                        getCroppedBitmap(fourthBitmap3),
                        Rect(bounds.width() / 2, 0, bounds.width(), bounds.height() / 2)
                ))
                addImage(profileDetails3, context, tempBitmap3, items.size - 1)
            }
            val profileDetails4 = ProfileDetailsUtils.getProfileDetails(userList[3])
            if (profileDetails4!= null) {
                val tempBitmap4 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails4))
                val fourthBitmap4 = scaleCenterCrop(tempBitmap4, bounds.width(), bounds.height())
                items.add(PhotoItem(
                        getCroppedBitmap(fourthBitmap4),
                        Rect(bounds.width() / 2, bounds.height() / 2, bounds.width(), bounds.height())
                ))
                addImage(profileDetails4, context, tempBitmap4, items.size - 1)
            }

            if (userList.size > 4) {
                val tempBitmap5 = getBitmap(CustomDrawable(context).getMoreUsersDrawable("+${userList.size - items.size}"))
                val fourthBitmap5 = scaleCenterCrop(tempBitmap5, bounds.width(), bounds.height())
                items.add(PhotoItem(
                        getCroppedBitmap(fourthBitmap5),
                        Rect(bounds.width() / 2, bounds.height() / 2, bounds.width(), bounds.height())
                ))
            }
        }
    }

    private fun setThreeUserProfile() {
        val profileDetails1 = ProfileDetailsUtils.getProfileDetails(userList[0])
        if (profileDetails1!= null) {
            val tempBitmap1 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails1))
            val thirdBitmap1 = scaleCenterCrop(tempBitmap1, bounds.width(), bounds.height())
            items.add(PhotoItem(
                    getCroppedBitmap(thirdBitmap1),
                    Rect(
                            bounds.width() / 4,
                            bounds.height() / 15,
                            (bounds.width() / 1.33).toInt(),
                            (bounds.height() / 1.76).toInt()
                    )
            ))
            addImage(profileDetails1, context, tempBitmap1, 0)
        }
        val profileDetails2 = ProfileDetailsUtils.getProfileDetails(userList[1])
        if (profileDetails2 != null) {
            val tempBitmap2 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails2))
            val thirdBitmap2 = scaleCenterCrop(tempBitmap2, bounds.width(), bounds.height())
            items.add(PhotoItem(
                    getCroppedBitmap(thirdBitmap2),
                    Rect(
                            0,
                            bounds.height() / 2,
                            bounds.width() / 2,
                            bounds.height()
                    )
            ))
            addImage(profileDetails2, context, tempBitmap2, items.size - 1)
        }
        val profileDetails3 = ProfileDetailsUtils.getProfileDetails(userList[2])
        if (profileDetails3 != null) {
            val tempBitmap3 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails3))
            val thirdBitmap3 = scaleCenterCrop(tempBitmap3, bounds.width(), bounds.height())
            items.add(PhotoItem(
                    getCroppedBitmap(thirdBitmap3),
                    Rect(
                            bounds.width() / 2,
                            bounds.height() / 2,
                            bounds.width(),
                            bounds.height()
                    )
            ))
            addImage(profileDetails3, context, tempBitmap3, items.size - 1)
        }
    }

    private fun setTwoUserProfile() {
        val profileDetails1 = ProfileDetailsUtils.getProfileDetails(userList[0])
        if (profileDetails1 != null) {
            val tempBitmap1 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails1))
            val bitmap1 = scaleCenterCrop(tempBitmap1, bounds.width(), bounds.height())
            items.add(PhotoItem(
                    getCroppedBitmap(bitmap1),
                    Rect(0, 0, (bounds.width() / 1.7).toInt(), (bounds.height() / 1.7).toInt())
            ))
            addImage(profileDetails1, context, tempBitmap1, 0)
        }
        val profileDetails2 = ProfileDetailsUtils.getProfileDetails(userList[1])
        if (profileDetails2 != null) {
            val tempBitmap2 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails2))
            val bitmap2 = scaleCenterCrop(tempBitmap2, bounds.width(), bounds.height())
            items.add(PhotoItem(
                    getCroppedBitmap(bitmap2),
                    Rect(
                            (bounds.width() / 2.43).toInt(),
                            (bounds.height() / 2.43).toInt(),
                            bounds.width(),
                            bounds.height()
                    )
            ))
            addImage(profileDetails2, context, tempBitmap2, items.size - 1)
        }
    }

    private fun setSingleProfile() {
        val profileDetails1 = ProfileDetailsUtils.getProfileDetails(userList[0])
        if (profileDetails1 != null) {
            val tempBitmap1 = getBitmap(CustomDrawable(context).getDefaultDrawable(profileDetails1))
            val bitmap = scaleCenterCrop(tempBitmap1, bounds.width(), bounds.height())
            items.add(PhotoItem(
                    getCroppedBitmap(bitmap),
                    Rect(0, 0, bounds.width(), bounds.height())
            ))
            addImage(profileDetails1, context, tempBitmap1, 0)
        }
    }

    /**
     * Load Image url into bitmap
     * @param profileDetails profile of the user
     * @param context Instance of context
     * @param errorImg Placeholder for failure load
     * @param index Position to append in view
     */
    private fun addImage(profileDetails: ProfileDetails?, context: Context?, errorImg: Bitmap, index: Int) {
        var imgUrl = profileDetails?.image ?: ""
        if(profileDetails?.isBlockedMe!! || profileDetails?.isAdminBlocked!!)
            imgUrl=""
        if (imgUrl.isBlank())
            items[index].bitmap = getCroppedBitmap(scaleCenterCrop(errorImg, bounds.width(), bounds.height()))
        else {
            imgUrl = Uri.parse(MediaUploadHelper.UPLOAD_ENDPOINT)
            .buildUpon().appendPath(Uri.parse(imgUrl).lastPathSegment).build().toString()
            val options = RequestOptions().priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide.with(context!!)
                .asBitmap()
                .load(imgUrl).apply(options)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        items[index].bitmap = getCroppedBitmap(scaleCenterCrop(resource, bounds.width(), bounds.height()))
                        invalidateSelf()
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                        /** not needed**/
                    }

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        items[index].bitmap = getCroppedBitmap(scaleCenterCrop(errorImg, bounds.width(), bounds.height()))
                    }
                })
        }
    }

    /**
     * Load Drawable resource into bitmap
     * @param drawable Drawable to load bitmap
     */
    private fun getBitmap(drawable: Drawable): Bitmap {
        if (drawable is BitmapDrawable && drawable.bitmap != null) {
            return drawable.bitmap
        }
        val bitmap: Bitmap = if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) // Single color bitmap will be created of 1x1 pixel
        } else {
            Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        }
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    /**
     * Scale and center crop image
     *
     * @param source    Bitmap to be scaled
     * @param newHeight updated height
     * @param newWidth  updated width
     * @return Bitmap scaled bitmap
     */
    private fun scaleCenterCrop(source: Bitmap, newHeight: Int, newWidth: Int): Bitmap {
        return ThumbnailUtils.extractThumbnail(source, newWidth, newHeight)
    }

    /**
     * Circle crop image
     *
     * @param bitmap Bitmap to be cropped
     * @return Bitmap Circle cropped bitmap
     */
    private fun getCroppedBitmap(bitmap: Bitmap): Bitmap {
        val output = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val color = -0xbdbdbe
        val paint = Paint()
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color
        canvas.drawCircle(
                (bitmap.width / 2).toFloat(),
                (bitmap.height / 2).toFloat(),
                (bitmap.width / 2).toFloat(),
                paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, rect, rect, paint)
        return output
    }

    /***
     * Model class for store bitmap and position
     */
    inner class PhotoItem internal constructor(var bitmap: Bitmap, var position: Rect)

}
