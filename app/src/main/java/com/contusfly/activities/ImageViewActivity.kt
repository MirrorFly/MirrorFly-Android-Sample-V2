package com.contusfly.activities

import android.Manifest
import android.app.Activity
import android.app.ActivityOptions
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.databinding.ActivityImageViewBinding
import com.contusfly.getDisplayName
import com.contusfly.showToast
import com.contusfly.utils.*
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.CommonUtils
import com.contusfly.utils.CommonUtils.Companion.showBottomSheetView
import com.contusfly.utils.MediaUtils
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.DoProgressDialog
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.*
import com.mirrorflysdk.utils.RequestCode
import com.mirrorflysdk.utils.VideoRecUtils
import com.mirrorflysdk.views.CustomToast
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class ImageViewActivity : BaseActivity(), DialogInterface.OnClickListener, CommonAlertDialog.CommonDialogClosedListener {

    private lateinit var imageViewBinding: ActivityImageViewBinding

    private var storagePath = "/storage/emulated/"

    /**
     * The jabber id of the selected group.
     */
    private var groupId: String? = null

    /**
     * Flag to identify whether the activity is launched as a result of group image update.
     */
    private var isImageUpdate = false

    /**
     * The name of the selected user/group.
     */
    private var groupOrUserName: String? = null

    /**
     * The jabber id of the selected user.
     */
    private var userId: String? = null

    /**
     * The storage url of the selected user/group image.
     */
    private var imageUrl: String? = Constants.EMPTY_STRING

    /**
     * The file to which the group image is associated.
     */
    private var mFileTemp: File? = null

    /**
     * The file to which the group camera image is associated.
     */
    private var mFileCameraTemp: File? = null

    /**
     * The instance of the DoProgressDialog
     */
    private var progressDialog: DoProgressDialog? = null

    /**
     * The s3 bucket url of the updated image obtained after uploading it to the Amazon server.
     */
    private var userImgUrl: String? = null

    /**
     * The ImageView to display an image resource.
     */
    private lateinit var groupImage: ImageView

    private var fromLoginProfile:Boolean = false

    /**
     * The instance of the CommonAlertDialog object.
     */
    private var mDialog: CommonAlertDialog? = null
    var dialogType: CommonAlertDialog.DIALOGTYPE? = null
    var isSuccess = false
    var position = 0

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val galleryPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(readPermissionGranted) {
            PickFileUtils.chooseImageFromGallery(this)
        }
    }

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val cameraPermissionGranted = permissions[Manifest.permission.CAMERA] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.CAMERA)

        if(readPermissionGranted && cameraPermissionGranted) {
            userImgUrl = ImageUtils.takePhotoFromCamera(this,
                VideoRecUtils.getPath(this,
                    getString(R.string.profile_photos_label)
                ), true)
        }
    }

        override fun onGroupProfileUpdated(groupJid: String) {
            super.onGroupProfileUpdated(groupJid)
            if(this.groupId!= null && groupJid == this.groupId) {
                GroupManager.getGroupProfile(groupJid, false) { success, _, data ->
                    if (success) {
                        isImageUpdate = true
                        val profileDetails = data[Constants.SDK_DATA] as ProfileDetails
                        UserInterfaceUtils.setUpToolBar(this, imageViewBinding.appBarLayout.toolbar, supportActionBar, profileDetails.getDisplayName())
                        MediaUtils.loadImageWithGlideSecure(this, profileDetails.image, groupImage, resources.getDrawable(errorImage))
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageViewBinding = ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(imageViewBinding.root)

        mDialog = CommonAlertDialog(this)
        mDialog!!.setOnDialogCloseListener(this)
        isImageUpdate = intent.getBooleanExtra(Constants.GROUP_ICON_EDIT,
                false)
        groupId = intent.getStringExtra(Constants.GROUP_ID)
        userId = intent.getStringExtra(Constants.USER_JID)
        groupOrUserName = intent.getStringExtra(Constants.GROUP_OR_USER_NAME)
        imageUrl = intent.getStringExtra(Constants.MEDIA_URL)
        fromLoginProfile = intent.getBooleanExtra(Constants.FROM_LOGIN_PROFILE,false)
        profileImageUrlUpdate()
        setSupportActionBar(imageViewBinding.appBarLayout.toolbar)
        if (groupOrUserName == null || groupOrUserName!!.isEmpty())
            UserInterfaceUtils.setUpToolBar(this, imageViewBinding.appBarLayout.toolbar, supportActionBar, resources.getString(R.string.sent_media_label))
        else UserInterfaceUtils.setUpToolBar(this, imageViewBinding.appBarLayout.toolbar, supportActionBar, groupOrUserName)

        groupImage = imageViewBinding.touchImageView
        if(fromLoginProfile){
            com.contusfly.utils.MediaUtils.loadImageWithGlideSkipCache(this, imageUrl, groupImage, errorImage)
        }else {
            if (imageUrl!!.startsWith(storagePath)) {
                MediaUtils.loadImageWithGlide(this, imageUrl, groupImage, errorImage)
            } else {
                MediaUtils.loadImageWithGlideSecure(
                    this,
                    imageUrl,
                    groupImage,
                    resources.getDrawable(errorImage)
                )
            }
        }
        ViewCompat.setTransitionName(groupImage, TRANSITION_NAME)

        /*
         * Create the temporary file to keep the image
         */
        val directoryName = FilePathUtils.getExternalStorage().toString() + File.separator + Constants.LOCAL_PATH +
                File.separator + Constants.IMAGE_LOCAL_PATH + File.separator + Constants.MSG_SENT_PATH
        val directory = File(directoryName)
        if (!directory.exists()) directory.mkdir()
        mFileTemp = ImageUtils.getFile(directoryName, ".jpg")

        mFileCameraTemp = File(FilePathUtils.getExternalStorage(), Constants.TEMP_PHOTO_FILE_NAME)
    }

    private fun profileImageUrlUpdate() {
        val profile = if (groupId != null && groupId!!.isNotEmpty()) ProfileDetailsUtils.getProfileDetails(groupId!!)
        else ProfileDetailsUtils.getProfileDetails(userId!!)
        if (profile!!.isAdminBlocked) imageUrl = Constants.EMPTY_STRING
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        updateUserProfile(jid)
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        updateUserProfile(jid)
    }

    private fun updateUserProfile(jid: String) {
        if(userId == jid) {
            val profileDetail = ProfileDetailsUtils.getProfileDetails(jid)
            if (profileDetail?.image!!.startsWith(storagePath))
                com.contusfly.utils.MediaUtils.loadImageWithGlide(this, profileDetail.image!!, groupImage, ContextCompat.getDrawable(this, errorImage))
            else
                com.contusfly.utils.MediaUtils.loadImage(this, profileDetail.image!!, groupImage, ContextCompat.getDrawable(this, errorImage))
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (isImageUpdate) {
            menuInflater.inflate(R.menu.menu_edit, menu)
        } else {
            menuInflater.inflate(R.menu.menu_share, menu)
            val menuItem = menu.findItem(R.id.action_share_image)
            try {
                val uri = URI(imageUrl)
                val isWeb = ("http".equals(uri.scheme, ignoreCase = true)
                        || "https".equals(uri.scheme, ignoreCase = true))
                menuItem.isVisible = isWeb
            } catch (e: URISyntaxException) {
                LogMessage.e(TAG, e)
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_edit -> {
                showBottomSheetView(this, true, this)
                true
            }
            R.id.action_share_image -> {
                MediaShareUtils().shareMediaExternal(this, imageUrl)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(p0: DialogInterface?, which: Int) {
        when (which) {
            R.id.action_take -> {
                isImageUpdate = true
                takePhoto()
            }
            R.id.action_gallery -> {
                isImageUpdate = true
                pickImageFromGallery()
            }
            R.id.action_remove -> {
                if(groupId != null && ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupId!!,SharedPreferenceManager.getCurrentUserJid())) {
                    isImageUpdate = false
                    mDialog!!.showAlertDialog(
                        getString(R.string.msg_are_you_sure_remove_group_photo),
                        getString(R.string.action_remove), getString(R.string.action_cancel),
                        CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
                    )
                }else {
                    CustomToast.show(context, getString(R.string.mgs_not_a_group_member))
                    this.finish()
                }
            }
        }
    }

    /**
     * Open the gallery to pick a new image to modify the group icon.
     */
    private fun pickImageFromGallery() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            if (MediaPermissions.isReadFilePermissionAllowed(this)) {
                PickFileUtils.chooseImageFromGallery(this)
            } else MediaPermissions.requestCameraStoragePermissions(this, permissionAlertDialog, galleryPermissionLauncher)
       } else {
            PickFileUtils.chooseImageFromGallery(this)
       }
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        this.dialogType = dialogType
        this.isSuccess = isSuccess
        if (isSuccess) revokeAccessForProfile()
    }

    override fun listOptionSelected(position: Int) {
        this.position = position
    }

    override fun onDeleteGroup(groupJid: String) {
        super.onDeleteGroup(groupJid)
        if (this.groupId != null && groupJid == this.groupId) {
            setResult(Activity.RESULT_FIRST_USER)
            startDashboardActivity()
            finish()
        }
    }

    private fun startDashboardActivity() {
        val dashboardIntent = Intent(applicationContext, DashboardActivity::class.java)
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(dashboardIntent)
    }

    private fun revokeAccessForProfile() {
        progressDialog = DoProgressDialog(this)
        progressDialog!!.showProgress()
        GroupManager.removeGroupProfileImage(groupId!!, object : ChatActionListener {
            override fun onResponse(isSuccess: Boolean, message: String) {
                progressDialog!!.dismiss()
                if (isSuccess)
                    finish()
                else
                    CustomToast.show(this@ImageViewActivity, message)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /* setting isActivityStartedForResult to false for xmpp disconnection */
        ChatManager.isActivityStartedForResult = false
        if (resultCode == Activity.RESULT_OK) when (requestCode) {
            RequestCode.TAKE_PHOTO -> handleCameraIntent(mFileCameraTemp)
            RequestCode.FROM_GALLERY -> handleGalleryIntent(data)
            RequestCode.CROP_IMAGE ->
                if(groupId != null && ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupId!!,SharedPreferenceManager.getCurrentUserJid()))
                    uploadImage()
                else {
                    CustomToast.show(context, getString(R.string.mgs_not_a_group_member))
                    this.finish()
                }
        } else if (resultCode == Activity.RESULT_CANCELED) isImageUpdate = false
    }

    /**
     * Handle the result of the camera intent and crop the chosen image to update the group icon.
     *
     * @param tempFile An File, which has the result of camera.
     */
    private fun handleCameraIntent(tempFile: File?) {
        if (tempFile != null) {
            try {
                val inputStream = contentResolver.openInputStream(Uri.fromFile(tempFile))
                if (inputStream != null) {
                    val fileOutputStream = FileOutputStream(mFileTemp)
                    ImagePopUpUtils.copyStream(inputStream, fileOutputStream)
                    fileOutputStream.close()
                    inputStream.close()
                    CommonUtils.cropImage(this, mFileTemp!!)
                }
            } catch (e: IOException) {
                LogMessage.e(TAG, e)
            }
        }
    }

    /**
     * Take a photo to update group image.
     */
    private fun takePhoto() {
        /*
         * Check the camera permission to take a new photo.
         */if (MediaPermissions.isPermissionAllowed(context, Manifest.permission.CAMERA) &&
            MediaPermissions.isWriteFilePermissionAllowed(context)) userImgUrl = ImageUtils.takePhotoFromCamera(this,
            VideoRecUtils.getPath(this, getString(R.string.profile_photos_label)),
            true) else activity?.let {
            MediaPermissions.requestCameraStoragePermissions(
                it,
                permissionAlertDialog,
                cameraPermissionLauncher)
        }
    }

    /**
     * Handle the result of the gallery intent and crop the chosen image to update the group icon.
     *
     * @param data An Intent, which return the result data to the caller.
     */
    private fun handleGalleryIntent(data: Intent?) {
        if (data!!.data != null) {
            try {
                val inputStream = contentResolver.openInputStream(data.data!!)
                if (inputStream != null) {
                    val fileOutputStream = FileOutputStream(mFileTemp!!)
                    ImagePopUpUtils.copyStream(inputStream, fileOutputStream)
                    fileOutputStream.close()
                    inputStream.close()
                    CommonUtils.cropImage(this, mFileTemp!!)
                }
            } catch (e: IOException) {
                LogMessage.e(TAG, e)
            }
        }
    }

    /**
     * Upload the updated group image into the Amazon S3 storage.
     */
    private fun uploadImage() {
        try {
            progressDialog = DoProgressDialog(this)
            progressDialog!!.showProgress()

            GroupManager.updateGroupProfileImage(groupId!!, mFileTemp!!, object : ChatActionListener {
                override fun onResponse(isSuccess: Boolean, message: String) {
                    if(isSuccess) {
                        loadNewImage()
                    }else{
                        CustomToast.show(context, getString(R.string.error_occurred_label))
                    }
                    progressDialog!!.dismiss()
                }
            })
        } catch (e: Exception) {
            progressDialog!!.dismiss()
            CustomToast.show(context,getString(R.string.error_occurred_label))
            LogMessage.e(TAG, e)
        }
    }

    private fun loadNewImage(){
        MediaUtils.loadImageWithGlide(this, mFileTemp!!.absolutePath, groupImage, errorImage)
    }

    companion object {

        private const val TRANSITION_NAME = "image_transition"

        /**
         * Starts activity with transition of ImageView
         *
         * @param activity  Starting activity
         * @param imageUrl  Image url
         * @param imageView Image view
         */
        @JvmStatic
        fun startActivity(activity: Activity, imageUrl: String?, imageView: ImageView?) {
            val i = Intent(activity, ImageViewActivity::class.java)
            i.putExtra(Constants.MEDIA_URL, imageUrl)

            /*
         * Transition effect from list of images to image view
         */
            val transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(activity, imageView, TRANSITION_NAME)
            activity.startActivity(i, transitionActivityOptions.toBundle())
        }
    }

    /**
     * Gets the placeholder image based on the type of the image loaded in the view.
     *
     * @return The image drawable for the placeholder.
     */
    private val errorImage: Int
        get() {
            return when {
                isImageUpdate -> {
                    // Placeholder image for the group icon.
                    R.drawable.ic_grp_bg
                }
                groupOrUserName != null -> {
                    // Placeholder image for the user profile icon.
                    R.drawable.ic_user_img
                }
                else -> {
                    // Placeholder image for the image type media messages.
                    R.drawable.ic_image_placeholder
                }
            }
        }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        if (this.groupId != null && jid == this.groupId && status) {
            showToast(getString(R.string.group_block_message_label))
            setResult(Activity.RESULT_FIRST_USER)
            startDashboardActivity()
            finish()
        } else {
            setUserProfileImage(jid, status)
        }
    }

    private fun setUserProfileImage(jid: String, status: Boolean) {
        val profileDetail = ProfileDetailsUtils.getProfileDetails(jid)
        if (profileDetail != null) {
            profileDetail.image = if (status) Constants.EMPTY_STRING else profileDetail.image
            if (profileDetail.image!!.startsWith(storagePath))
                com.contusfly.utils.MediaUtils.loadImageWithGlide(
                    this,
                    profileDetail.image!!,
                    groupImage,
                    ContextCompat.getDrawable(this, errorImage)
                )
            else
                com.contusfly.utils.MediaUtils.loadImage(
                    this,
                    profileDetail.image!!,
                    groupImage,
                    ContextCompat.getDrawable(this, errorImage)
                )
        }
    }
}