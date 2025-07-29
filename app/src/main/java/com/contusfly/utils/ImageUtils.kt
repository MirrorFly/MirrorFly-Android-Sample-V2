package com.contusfly.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.media.ExifInterface
import android.media.ThumbnailUtils
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Base64
import android.widget.ImageView
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.bumptech.glide.request.transition.Transition
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.utils.FilePathUtils
import com.mirrorflysdk.utils.RequestCode
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.util.*

/**
 * This class used to decode the images...
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
object ImageUtils {

    /**
     * Converts URL into the bitmap
     *
     * @param fil           Local file
     * @param selectedImage Uri of the selected image
     * @param mContext      Application startupActivityContext
     * @return Bitmap Bitmap of the image
     */
    fun decodeStream(fil: File, selectedImage: Uri?, mContext: Context): Bitmap? {
        var bitmap: Bitmap?
        if (selectedImage != null) {
            try {
                bitmap = BitmapFactory.decodeStream(mContext.contentResolver.openInputStream(selectedImage))
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
        return if (bmp != null && imageUrl != null) {
            val ei: ExifInterface
            var orientation = 0
            val resizedBitmap: Bitmap
            try {
                ei = ExifInterface(imageUrl)
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
            }
            resizedBitmap = Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeight, matrix, true)
            resizedBitmap
        } else
            null
    }

    private const val TAG = "ImageUtils"
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

    /**
     * Load image in view.
     *
     * @param context   The startupActivityContext of the activity
     * @param path      String path
     * @param imageView The image view
     * @param base64    base64 string
     * @param id        placeholder resource id
     */
    fun loadImageInView(context: Context?, path: String, imageView: ImageView, base64: String, id: Int) {
        if (path.isNotEmpty()) {
            val file = File(path)
            if (file.exists())
                loadImageWithGlide(context, path, imageView, id)
            else if (!TextUtils.isEmpty(base64))
                loadBase64(context, imageView, base64, id)
        } else if (!TextUtils.isEmpty(base64))
            loadBase64(context, imageView, base64, id)
    }

    /**
     * Load image in view with [Drawable] as a placeholder.
     *
     * @param context   The startupActivityContext of the activity
     * @param path      String path
     * @param imageView The image view
     * @param base64    base64 string
     * @param drawable  placeholder drawable
     */
    fun loadImageInView(context: Context, path: String, imageView: ImageView, base64: String, drawable: Drawable?) {
        if (path.isNotEmpty()) {
            val file = File(path)
            if (file.exists())
                loadImageWithGlide(context, path, imageView, drawable)
            else if (!TextUtils.isEmpty(base64))
                loadBase64(context, imageView, base64, drawable)
        } else if (!TextUtils.isEmpty(base64))
            loadBase64(context, imageView, base64, drawable)
    }

    /**
     * Load image in view with [Drawable] as a placeholder.
     *
     * @param context   The startupActivityContext of the activity
     * @param path      String path
     * @param imageView The image view
     * @param base64    base64 string
     */
    fun loadImageInView(context: Context, path: String, imageView: ImageView, base64: String) {
        if (path.isNotEmpty()) {
            val file = File(path)
            if (file.exists())
                loadImageWithGlide(context, path, imageView, base64)
            else if (!TextUtils.isEmpty(base64))
                loadBase64(context, imageView, base64)
        } else if (!TextUtils.isEmpty(base64))
            loadBase64(context, imageView, base64)
    }

    /**
    * Load image in view with [Drawable] as a placeholder.
    *
    * @param context   The startupActivityContext of the activity
    * @param imageView The image view
    * @param base64    base64 string
    */
    fun loadReceiverVideoImageInView(context: Context, imageView: ImageView, base64: String) {
        loadBase64(context, imageView, base64)
    }

    /**
     * Load base64 of the image into image view
     *
     * @param context   startupActivityContext instance
     * @param imageView Image view to load
     * @param base64    Base64 string
     */
    fun loadBase64(context: Context?, imageView: ImageView, base64: String, errorImg: Int) {
        LogMessage.d(TAG, "loadBase64")
        try {
            val array = Base64.decode(base64, Base64.DEFAULT)
            val mBitmap = BitmapFactory.decodeByteArray(array, 0, array.size)
            mBitmap?.let { loadImageWithGlide(context, it, imageView, errorImg) }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Load base64 of the image into image view with [Drawable] as a placeholder
     *
     * @param context   startupActivityContext instance
     * @param imageView Image view to load
     * @param base64    Base64 string
     */
    private fun loadBase64(context: Context, imageView: ImageView, base64: String, errorImg: Drawable?) {
        LogMessage.d(TAG, "loadBase64")
        try {
            val array = Base64.decode(base64, Base64.DEFAULT)
            val mBitmap = BitmapFactory.decodeByteArray(array, 0, array.size)
            mBitmap?.let { loadImageWithGlide(context, it, imageView, errorImg) }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Load base64 of the image into image view with [Drawable] as a placeholder
     *
     * @param context   startupActivityContext instance
     * @param imageView Image view to load
     * @param base64    Base64 string
     */
    private fun loadBase64(context: Context, imageView: ImageView, base64: String) {
        LogMessage.d(TAG, "loadBase64")
        try {
            val array = Base64.decode(base64, Base64.DEFAULT)
            val mBitmap = BitmapFactory.decodeByteArray(array, 0, array.size)
            val thumbnail: Drawable = BitmapDrawable(context.resources, mBitmap)
            mBitmap?.let { loadImageWithGlide(context, it, imageView, thumbnail) }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Load image with glide.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgUrl   Image uri
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    fun loadImageWithGlide(context: Context?, imgUrl: String?, imgView: ImageView, errorImg: Int) {
        LogMessage.d(TAG, "loadImageWithGlide#URL/URI :$imgUrl")
        if (imgUrl != null && imgUrl.isNotEmpty()) {
            val options = RequestOptions()
                    .placeholder(errorImg)
                    .error(errorImg)
                    .dontTransform()
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
            Glide.with(context!!).load(imgUrl).thumbnail(0.1f).apply(options).into(imgView)
        } else imgView.setImageResource(errorImg)
    }

    /**
     * Load image with glide.
     *
     * @param context  Instance of the context
     * @param imgUrl   Image uri
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    fun loadMapWithGlide(context: Context?, imgUrl: String?, imgView: ImageView, errorImg: Int) {
        LogMessage.d(TAG, "loadMapWithGlide#URL/URI :$imgUrl")
        if (imgUrl != null && imgUrl.isNotEmpty()) {
            val options = RequestOptions()
                    .placeholder(errorImg)
                    .error(errorImg)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
            Glide.with(context!!).load(imgUrl).thumbnail(0.1f).apply(options).into(imgView)
            LogMessage.d(TAG, "loadMapWithGlide#URL/URI : if --$imgUrl")
        } else {
            imgView.setImageResource(errorImg)
            LogMessage.d(TAG, "loadMapWithGlide#URL/URI : else --$imgUrl")
        }
    }

    /**
     * Load local video thumbnail image with glide.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgUrl   Image uri
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    fun loadVideoThumbnail(context: Context?, imgUrl: String?, imgView: ImageView, errorImg: Int) {
        if (imgUrl != null && imgUrl.isNotEmpty()) {
            val options = RequestOptions().centerCrop()
                    .placeholder(errorImg)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
            Glide.with(context!!).asBitmap().load(Uri.fromFile(File(imgUrl))).apply(options).into(imgView)
        } else
            imgView.setImageResource(errorImg)
    }

    /**
     * Load image with glide.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgFile  Local path
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    fun loadImageWithGlide(context: Context?, imgFile: File?, imgView: ImageView?, errorImg: Int) {
        LogMessage.d(TAG, "loadImageWithGlide#File")
        val options = RequestOptions()
            .placeholder(errorImg)
            .error(errorImg)
            .dontTransform()
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
        Glide.with(context!!).load(imgFile).thumbnail(0.1f).apply(options).into(imgView!!)
    }

    /**
     * Load Bitmap image with glide.
     *
     * @param context  Instance of the startupActivityContext
     * @param bitmap   Local path
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    fun loadImageWithGlide(context: Context?, bitmap: Bitmap?, imgView: ImageView?, errorImg: Int) {
        LogMessage.d(TAG, "loadImageWithGlide#Bitmap")
        val options = RequestOptions()
            .placeholder(errorImg)
            .dontTransform()
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
        Glide.with(context!!).load(bitmap).apply(options).into(imgView!!)
    }

    /**
     * Load Bitmap image with glide with [Drawable] as a placeholder.
     *
     * @param context  Instance of the startupActivityContext
     * @param bitmap   Local path
     * @param imgView  Image view to display the image
     * @param errorImg Display the message is url return null
     */
    fun loadImageWithGlide(context: Context?, bitmap: Bitmap?, imgView: ImageView?, errorImg: Drawable?) {
        LogMessage.d(TAG, "loadImageWithGlide#Bitmap")
        val options = RequestOptions()
            .placeholder(errorImg)
            .dontTransform()
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
        Glide.with(context!!).load(bitmap).override(300,300).apply(options).into(imgView!!)
    }

    /**
     * Load image with glide with [Drawable] as a placeholder.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgUrl   image url
     * @param imgView  Image view to display the image
     * @param errorImg Display the drawable, if url return null
     */
    fun loadImageWithGlide(context: Context, imgUrl: String?, imgView: ImageView, errorImg: Drawable?) {
        LogMessage.d(TAG, "loadImageWithGlide#url#drawablePlaceholder")
        if (imgUrl != null && imgUrl.isNotEmpty()) {
            val placeHolderDrawable = copyDrawable(context, errorImg)
            val options = RequestOptions().frame(1000)
                .placeholder(placeHolderDrawable) //to avoid flickering issue
                .error(errorImg)
                .dontTransform()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
            Glide.with(context).load(imgUrl).thumbnail(0.1f).apply(options).into(imgView)
        } else imgView.setImageDrawable(errorImg)
    }

    /**
     * Load image with glide with [Drawable] as a placeholder.
     *
     * @param context  Instance of the startupActivityContext
     * @param imgUrl   image url
     * @param imgView  Image view to display the image
     * @param base64  Base64 thump image string
     */
    fun loadImageWithGlide(context: Context, imgUrl: String?, imgView: ImageView, base64: String) {
        LogMessage.d(TAG, "loadImageWithGlide#url#drawablePlaceholder")
        val array = Base64.decode(base64, Base64.DEFAULT)
        val mBitmap = BitmapFactory.decodeByteArray(array, 0, array.size)
        val errorImg: Drawable = BitmapDrawable(context.resources, mBitmap)
        if (imgUrl != null && imgUrl.isNotEmpty()) {
            val placeHolderDrawable = copyDrawable(context, errorImg)
            val options = RequestOptions().frame(1000)
                .placeholder(placeHolderDrawable) //to avoid flickering issue
                .error(errorImg)
                .dontTransform()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
            Glide.with(context).load(imgUrl).override(300,300).thumbnail(0.1f).apply(options).into(imgView)
        } else imgView.setImageDrawable(errorImg)
    }

    /**
     * Loads image into an image view without flickering
     *
     * @param context     context
     * @param imageUrl    image url to be loaded
     * @param imageView   target image view
     * @param oldImageUrl old image url
     */
    fun loadImageWithoutFlickering(context: Context?,
                                   imageUrl: String?, imageView: ImageView?, oldImageUrl: String?) {
        val options = RequestOptions()
                .transform(RoundedCorners(20))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
        Glide.with(context!!)
                .load(imageUrl)
                .thumbnail(
                        // this thumbnail request has to have the same RESULT cache key as the outer request,
                        // which usually simply means same size/transformation (e.g.centerCrop)/format(e.g asBitmap)
                        // have to be explicit here to match outer load exactly
                        Glide.with(context).load(oldImageUrl).apply(options)
                )
                .listener(object : RequestListener<Drawable?> {
                    override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable?>,
                                              isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any, target: Target<Drawable?>,
                                                 dataSource: DataSource, isFirstResource: Boolean): Boolean {
                        return if (isFirstResource) {
                            false // thumbnail was not shown, do as usual
                        } else DrawableCrossFadeFactory.Builder()
                                .setCrossFadeEnabled(true)
                                .build().build(dataSource, isFirstResource)
                                .transition(resource, target as Transition.ViewAdapter)
                    }
                })
                .apply(options)
                .into(imageView!!)
    }

    /**
     * This method copyFiles the bitmap from drawable which is got from image view
     * [ImageView.getDrawable] and creates new [BitmapDrawable]
     * and returns it.
     *
     *
     * This BitmapDrawable is used to avoid the bitmap recycled exception while using drawable
     * as a placeholder
     *
     * @param context  context
     * @param drawable drawable from image
     * @return [BitmapDrawable]
     */
    private fun copyDrawable(context: Context, drawable: Drawable?): Drawable? {
        var bitmap: Bitmap? = null
        var tempDrawable = drawable
        if (drawable is TransitionDrawable)
            tempDrawable = drawable.getDrawable(1)
        if (tempDrawable is BitmapDrawable)
            bitmap = tempDrawable.bitmap
        if (bitmap != null) {
            bitmap = bitmap.config?.let { bitmap!!.copy(it, bitmap!!.isMutable) }
            return BitmapDrawable(context.resources, bitmap)
        }
        return null
    }

    /**
     * Start the intent with the photo url path and ask for camera permission
     *
     * @param intent  Instance of the intent with data
     * @param context Instance of the Context
     * @param path    Photo path
     * @return String Path of the image
     */
    private fun startIntentForPhoto(intent: Intent, context: Activity, path: String): String {
        val photo = getImageFile(path)
        val userProfileImg = photo.absolutePath
        val uri = FileProvider.getUriForFile(context, ChatManager.fileProviderAuthority, photo)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        val resInfoList = context.packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        for (resolveInfo in resInfoList) {
            val packageName = resolveInfo.activityInfo.packageName
            context.grantUriPermission(packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                    or Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        return userProfileImg
    }

    /**
     * Returns image file
     *
     * @param path Path of the parent folder
     * @return File New image file
     */
    private fun getImageFile(path: String): File {
        return getFile(path, ".jpg")
    }

    /**
     * Returns image file for the given file path and extension
     *
     * @param path      Path of the parent folder
     * @param extension File extension
     * @return File New image file
     */
    @JvmStatic
    fun getFile(path: String, extension: String): File {
        val todayDate = Calendar.getInstance()
        val dateToday = (todayDate[Calendar.DAY_OF_MONTH].toString() + "-" + (todayDate[Calendar.MONTH] + 1) + "-"
                + todayDate[Calendar.YEAR] + "-" + todayDate[Calendar.HOUR] + "-"
                + todayDate[Calendar.MINUTE] + "-" + todayDate[Calendar.SECOND] + "-" + todayDate[Calendar.MILLISECOND])
        createFolderIfNotExist(path)
        return File(path, dateToday + extension)
    }

    /**
     * Creates folder if not exist
     *
     * @param path Path of the folder
     */
    private fun createFolderIfNotExist(path: String) {
        val folder = File(path)
        if (!folder.exists())
            folder.mkdirs()
    }

    /**
     * Take photo from camera for sending the photo to the receiver.
     *
     * @param context     Application startupActivityContext
     * @param path        Image url
     * @param isCropImage True if the image crop
     * @return String Path of the image
     */
    fun takePhotoFromCamera(context: Activity, path: String, isCropImage: Boolean): String? {
        var userProfileImg: String? = null
        try {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            intent.putExtra("exit", "false")
            intent.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            if (isCropImage)
                startIntentForCropPhoto(intent, context)
            else {
                SharedPreferenceManager.setBoolean(Constants.IMAGE_TAKEN_FROM_CAMERA, true)
                userProfileImg = startIntentForPhoto(intent, context, path)
                context.startActivityForResult(intent, RequestCode.TAKE_PHOTO)
                /* setting isActivityStartedForResult to true to avoid xmpp disconnection */
                ChatManager.isActivityStartedForResult = true
            }
            context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        } catch (e: Exception) {
            LogMessage.e(e)
        }
        return userProfileImg
    }

    /**
     * Start the intent with the temp path to store and crop the image
     *
     * @param intent  Instance of the intent with data
     * @param context Instance of the Context
     */
    private fun startIntentForCropPhoto(intent: Intent, context: Activity) {
        val state = Environment.getExternalStorageState()
        val file: File
        val fileUri: Uri
        if (Environment.MEDIA_MOUNTED == state) {
            file = File(FilePathUtils.getExternalStorage(), Constants.TEMP_PHOTO_FILE_NAME)
            fileUri = FileProvider.getUriForFile(context, ChatManager.fileProviderAuthority, file)
        } else fileUri = Constants.CONTENT_URI
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        context.startActivityForResult(intent, RequestCode.TAKE_PHOTO)
        /* setting isActivityStartedForResult to true to avoid xmpp disconnection */
        ChatManager.isActivityStartedForResult = true
        context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    /**
     * Get image thumb image String.
     *
     * @param imagePath Path of image.
     * @return String, Thumb image Base64.
     */
    fun getImageThumbImage(imagePath: String?): String {
        return if (imagePath != null) {
            try {
                val options = BitmapFactory.Options().apply {
                    inSampleSize = 2 // Sample down to reduce memory usage
                }
                val originalBitmap = BitmapFactory.decodeFile(imagePath, options)

                if (originalBitmap != null) {
                    val thumb = ThumbnailUtils.extractThumbnail(originalBitmap, ThumbSize.THUMB_100, ThumbSize.THUMB_100)
                    originalBitmap.recycle() // Free up the original bitmap memory

                    if (thumb != null) {
                        val byteArray = getCompressedBitmapData(thumb, 2048, 48)
                        thumb.recycle() // Free up the thumbnail bitmap memory

                        if (byteArray != null) {
                            LogMessage.v("getImageThumbImage", "final image thumbnail size: " + byteArray.size)
                            Base64.encodeToString(byteArray, 0)
                        } else {
                            LogMessage.e("getImageThumbImage", "Failed to compress image below size limit")
                            ""
                        }
                    } else {
                        LogMessage.e("getImageThumbImage", "Failed to extract thumbnail")
                        ""
                    }
                } else {
                    LogMessage.e("getImageThumbImage", "Failed to decode image file")
                    ""
                }
            } catch (e: Exception) {
                LogMessage.e("getImageThumbImage", "Exception: ${e.message}")
                ""
            }
        } else ""
    }

    /**
     * Get video thumb image String.
     *
     * @param videoPath Path of video.
     * @return String, Thumb image Base64.
     */
    fun getVideoThumbImage(videoPath: String?): String {
        val videoFile = File(videoPath)
        return if (videoFile.exists()) {
            val thumb = ThumbnailUtils.createVideoThumbnail(videoFile.absolutePath, MediaStore.Video.Thumbnails.MICRO_KIND)
            val byteArray = getCompressedBitmapData(thumb!!, 2048, 48)
            LogMessage.v("getVideoThumbImage", "final video thumbnail size: " + byteArray!!.size)
            thumb.recycle()
            Base64.encodeToString(byteArray, 0)
        } else ""
    }


    private fun getCompressedBitmapData(bitmap: Bitmap, maxFileSize: Int, maxDimensions: Int): ByteArray? {
        // Start with resizing to target dimensions
        var currentBitmap = if (bitmap.width > maxDimensions || bitmap.height > maxDimensions) {
            getResizedBitmap(bitmap, maxDimensions)
        } else {
            bitmap
        }

        // Try progressively lower quality
        for (quality in arrayOf(70, 50, 30, 15, 10, 5)) {
            val bos = ByteArrayOutputStream()
            currentBitmap.compress(Bitmap.CompressFormat.JPEG, quality, bos)
            val byteArray = bos.toByteArray()
            if (byteArray.size <= maxFileSize) {
                return byteArray
            }
        }

        // If quality reduction alone doesn't work, try reducing dimensions further
        var currentMaxDimension = maxDimensions
        while (currentMaxDimension > 24) { // Don't go below 24px
            currentMaxDimension = (currentMaxDimension * 0.7).toInt() // Reduce by 30%
            currentBitmap = getResizedBitmap(bitmap, currentMaxDimension)

            // Try with lowest quality
            val bos = ByteArrayOutputStream()
            currentBitmap.compress(Bitmap.CompressFormat.JPEG, 5, bos)
            val byteArray = bos.toByteArray()

            if (byteArray.size <= maxFileSize) {
                return byteArray
            }
        }

        // If all attempts fail, return the smallest we could get
        val bitmap = getResizedBitmap(bitmap, 24)
        val bos = ByteArrayOutputStream()
        getResizedBitmap(bitmap, 24).compress(Bitmap.CompressFormat.JPEG, 5, bos)
        return bos.toByteArray() // Return whatever we got, might be over the size limit
    }

    private fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap {
        var width = image.width
        var height = image.height
        val bitmapRatio = width.toFloat() / height.toFloat()
        if (bitmapRatio > 1) {
            width = maxSize
            height = (width / bitmapRatio).toInt()
        } else {
            height = maxSize
            width = (height * bitmapRatio).toInt()
        }
        return Bitmap.createScaledBitmap(image, width, height, true)
    }

}