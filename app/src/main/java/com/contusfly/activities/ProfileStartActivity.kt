package com.contusfly.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.webkit.MimeTypeMap
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.FlyCallback
import com.mirrorflysdk.xmpp.chat.models.Profile
import com.contusfly.*
import com.contusfly.databinding.ActivityProfileStartBinding
import com.contusfly.utils.*
import com.contusfly.utils.CommonUtils.Companion.showBottomSheetView
import com.contusfly.views.*
import com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener
import com.contusfly.views.CommonAlertDialog.DIALOGTYPE
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.ChatManager.isActivityStartedForResult
import com.mirrorflysdk.api.ChatManager.setUserProfileName
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ContactManager.updateMyProfile
import com.mirrorflysdk.api.contacts.ContactManager.updateMyProfileImage
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.utils.FilePathUtils
import com.mirrorflysdk.utils.ImagePopUpUtils
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.utils.VideoRecUtils
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.regex.Pattern
import kotlin.coroutines.CoroutineContext

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
open class ProfileStartActivity : BaseActivity(), View.OnClickListener, DialogInterface.OnClickListener, CommonDialogClosedListener, CoroutineScope {

    protected val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception :  ${exception.printStackTrace()}")
    }

    private lateinit var profileStartBinding: ActivityProfileStartBinding

    /**
     * Mobile number of the user
     */
    @JvmField
    protected var mobileNumber: String? = null

    private var profileName: String? = null

    private var name:String?=null

    private var mStatus: String? = null

    private var mFileTemp: File? = null

    private var fromBackground: Boolean = false

    /**
     * The mobile edit text in the profile page.User can edit or enter the mobile.
     */
    @JvmField
    protected var mobileEditText: CustomTextView? = null

    @JvmField
    protected var profilePicture: CircularImageView? = null

    /**
     * The progress dialog of the activity When run the background tasks
     */
    private var progressDialog: DoProgressDialog? = null

    private var isImageSelected: Boolean = false

    private var isFirstUser: Boolean = false

    private var userImgUrl = Constants.EMPTY_STRING

    /**
     * Boolean value to handle user profile remove
     */
    private var isUserProfileRemoved = false

    /**
     * Store onclick time to avoid double click
     */
    private var lastClickTime: Long = 0

    private var saveLastClickTime: Long = 0

    private var setDrawable: SetDrawable? = null

    private var commonAlertDialog: CommonAlertDialog? = null

    private var isProfileStart = false

    private var isProfileUpdated = false

    private var isProfilePending = false

    private var isUpdateClickedOnStart = false

    private lateinit var profileDetails: ProfileDetails

    private var isFromSettingsProfile = true

    private var isProfileChanged: Boolean = false

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val cameraPermissionGranted = permissions[Manifest.permission.CAMERA] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.CAMERA)

        if(readPermissionGranted && cameraPermissionGranted) {
            ImageUtils.takePhotoFromCamera(this, VideoRecUtils.getPath(this, getString(R.string.profile_photos_label)), true)
        }
    }

    private val galleryPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(readPermissionGranted) {
            PickFileUtils.chooseImageFromGallery(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        profileStartBinding = ActivityProfileStartBinding.inflate(layoutInflater)
        setContentView(profileStartBinding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        /*
       * For First time profile login */
        setSupportActionBar(profileStartBinding.toolbar.root)
        getIntentValues()
        if (isFromSettingsProfile) {
            supportActionBar?.title = getString(R.string.profile_label)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            UserInterfaceUtils.initializeCustomToolbar(this, profileStartBinding.toolbar.root)
            profileStartBinding.toolbar.root.navigationIcon?.applySrcInColorFilter(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color))
            checkContusMail()
        } else {
            profileStartBinding.toolbar.toolbarTitle.text = getString(R.string.profile_label)
            supportActionBar?.title = Constants.EMPTY_STRING
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        isProfileChanged = false
        viewInitialization()
        setUserProfileData()
        clickListeners()
        name=profileName

    }

    private fun getIntentValues() {
        if (intent.getBooleanExtra(Constants.IS_FIRST_LOGIN, false) || intent.getBooleanExtra("from_splash", false)) {
            isFromSettingsProfile = false
        }
    }

    private fun viewInitialization() {
        setDrawable = SetDrawable(this)
        progressDialog = DoProgressDialog(this)
        profilePicture = profileStartBinding.imageProfilePicture
        mobileEditText = profileStartBinding.editMobileNumber
        profileStartBinding.editProfileName.isEnabled = true
        profileStartBinding.editProfileName.isCursorVisible = true
        commonAlertDialog = CommonAlertDialog(this)
        commonAlertDialog!!.setOnDialogCloseListener(this)
    }

    private fun clickListeners() {
        profileStartBinding.currentStatusView.setOnClickListener(this)
        profileStartBinding.changeProfileImage.setOnClickListener(this)
        profilePicture!!.setOnClickListener(this)
        profileStartBinding.textSync.setOnClickListener(this)
        profileStartBinding.textEdit.setOnClickListener(this)
        profileStartBinding.editMobileNumber.keyListener = null
        checkNameContentTextWatcher(profileStartBinding.editProfileName)
        hideCursorsAndKeyboard(profileStartBinding.editProfileName)
        if (isFromSettingsProfile) {
            profileStartBinding.textEmail.isEnabled=false
            checkEmailContentTextWatcher(profileStartBinding.textEmail)
            hideCursorsAndKeyboard(profileStartBinding.textEmail)
        }
    }

    private fun checkEmailContentTextWatcher(textEmail: CustomEditText) {
        textEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                handleProfileChanges()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do Nothing
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Do Nothing
            }
        })
    }

    override fun onResume() {
        super.onResume()
        fromBackground = true
        if (profileStartBinding.editProfileName.hasFocus()) {
            profileStartBinding.editProfileName.requestFocus()
            profileStartBinding.editProfileName.showSoftKeyboard()
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
        else if(profileStartBinding.textEmail.hasFocus()){
            profileStartBinding.textEmail.requestFocus()
            profileStartBinding.textEmail.showSoftKeyboard()
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }

    private fun hideCursorsAndKeyboard(editText: AppCompatEditText) {
        val imm: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                editText.clearFocus()
                imm.hideSoftInputFromWindow(editText.windowToken, 0)
                true
            } else {
                false
            }
        }
    }

    private fun checkNameContentTextWatcher(editProfileName: AppCompatEditText) {
        editProfileName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                name=profileStartBinding.editProfileName.text.toString()
                try {
                    if (isFromSettingsProfile) handleProfileChanges()
                    else updateUserName()
                } catch (e: Exception) {
                    LogMessage.e(TAG, "Profile Name issue ==> ${e.message}")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do Nothing
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    val length = profileStartBinding.editProfileName.text.toString().length
                    if (length > 30) {
                        profileStartBinding.editProfileName.setText(name)
                        profileStartBinding.editProfileName.setSelection(start)
                        CustomToast.showShortToast(this@ProfileStartActivity, getString(R.string.max_profile_name_chars))
                    }
                }catch (e:Exception){
                    LogMessage.e(TAG, "Profile Name issue ==> ${e.message}")
                }

            }
        })
    }

    private fun handleProfileChanges() {
        if (isDataChangeValid())
            handleSaveButton(true)
        else
            handleSaveButton(false)
    }

    private fun isDataChangeValid(): Boolean {
        isProfileChanged = true
        if (ChatManager.getUserProfileName() == profileStartBinding.editProfileName.text.toString().trim() &&
                SharedPreferenceManager.getString(Constants.EMAIL) == profileStartBinding.textEmail.text.toString().trim())
            isProfileChanged = false
        return isProfileChanged && profileStartBinding.editProfileName.text.toString().trim().isNotEmpty() && profileStartBinding.textEmail.text.toString().trim().isNotEmpty()
    }

    private fun handleSaveButton(enable: Boolean) {
        profileStartBinding.textSync.isEnabled = enable
    }

    /*
    * Set User Profile Data from SDK */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setUserProfileData() {
        /**
         * Checks whether it is first time login to change the header content
         */
        if (intent.getBooleanExtra(Constants.IS_FIRST_LOGIN, false) || intent.getBooleanExtra("from_splash", false)) {
            profileStartBinding.textSync.text = getString(R.string.save_button)
            profileStartBinding.textSync.visibility = View.VISIBLE
            isFromSettingsProfile = false
            isProfileStart = true
        }
        setProfileImagePath()
        if (isFromSettingsProfile) {
            profileDetails = ProfileDetails()
            profileDetails.name = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME))
            profileDetails.email = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.EMAIL))
            profileDetails.mobileNumber = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_MOBILE_NUMBER))
            profileDetails.image = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE))
            profileDetails.status = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_STATUS))
            setUserProfile()
            handleSaveButton(false)
            return
        }
        getProfileFromServer(false)

    }

    private fun getProfileFromServer(isUpdated: Boolean) {
        checkInternetAndExecute {
            if (progressDialog != null) progressDialog!!.showProgress()
            ContactManager.getUserProfile(SharedPreferenceManager.getString(Constants.SENDER_USER_JID), fetchFromServer = !isUpdated,
                    flyCallback = { success, _, data ->
                        if (success && data.isNotEmpty()) {
                            profileDetails = data["data"] as ProfileDetails
                            isFirstUser = profileDetails.name.isNullOrEmpty()
                            SharedPreferenceManager.setString(Constants.USER_PROFILE_NAME, profileDetails.name)
                            SharedPreferenceManager.setString(Constants.USER_PROFILE_IMAGE, profileDetails.image)
                            SharedPreferenceManager.setString(Constants.EMAIL, profileDetails.email)
                            SharedPreferenceManager.setString(Constants.USER_STATUS, profileDetails.status)
                            ConfigurationUtils.insertDefaultStatusToUser(this, profileDetails.status)
                            isProfileUpdated = false
                            fromBackground = false
                            setUserProfile()
                        } else {
                            if (!isFromSettingsProfile) {
                                profileDetails = ProfileDetails()
                                profileDetails.name = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME))
                                profileDetails.email = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.EMAIL))
                                profileDetails.mobileNumber = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_MOBILE_NUMBER))
                                profileDetails.image = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE))
                                profileDetails.status = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_STATUS))
                                setUserProfile()
                            }
                            else {
                                mobileNumber = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_MOBILE_NUMBER))
                                mobileEditText!!.text = Utils.getFormattedPhoneNumber(mobileNumber)
                                SharedPreferenceManager.setString(Constants.USER_STATUS, getString(R.string.default_status))
                                mStatus = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_STATUS))
                                setStatus(mStatus)
                            }
                        }
                        progressDialog?.dismiss()
                    })
        }
    }

    private fun setUserProfile() {
        if (!isProfileUpdated) {
            isProfileUpdated = true
            val email = Utils.returnEmptyStringIfNull(profileDetails.email)
            profileName = Utils.returnEmptyStringIfNull(profileDetails.name)
            if (!fromBackground) {
                profileStartBinding.textEmail.setText(email)
                profileStartBinding.editProfileName.setText(profileName)
                profileStartBinding.editProfileName.setSelection(profileName!!.length)
            }
            mobileNumber = Utils.returnEmptyStringIfNull(profileDetails.mobileNumber)
            if (mobileNumber.isNullOrEmpty()) mobileNumber = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_MOBILE_NUMBER))
            mobileEditText!!.text = Utils.getFormattedPhoneNumber(mobileNumber)
            userImgUrl = Utils.returnEmptyStringIfNull(profileDetails.image)
            if (userImgUrl.isNotEmpty()) {
                MediaUtils.loadImageWithLoader(this, userImgUrl, profilePicture!!, AppCompatResources.getDrawable(applicationContext, R.drawable.profile_img), progressDialog)
            } else if (profileStartBinding.editProfileName.text.toString().isNotEmpty()) showProfilePicInitials()
            mStatus = Utils.returnEmptyStringIfNull(profileDetails.status)
            if (mStatus.isNullOrEmpty()) {
                SharedPreferenceManager.setString(Constants.USER_STATUS, getString(R.string.default_status))
                mStatus = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_STATUS))
            }
            setStatus(mStatus)
        }
    }

    private fun setStatus(newStatus: String?) {
        try {
            mStatus = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                Html.fromHtml(newStatus, Html.FROM_HTML_MODE_LEGACY).toString()
            else
                Html.fromHtml(newStatus).toString()
            if (mStatus.isNullOrEmpty()) mStatus = getString(R.string.default_status)
            profileStartBinding.textEdit.text = mStatus
            SharedPreferenceManager.setString(Constants.USER_STATUS, mStatus)
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    open fun setProfileImagePath() {
        mFileTemp = File(FilePathUtils.getExternalStorage(), Constants.TEMP_PHOTO_FILE_NAME)
    }

    override fun myProfileUpdated(isSuccess: Boolean) {
        super.myProfileUpdated(isSuccess)
        if(progressDialog != null && progressDialog?.isShowing == true){
            val imageURL = FlyCore.getUserProfile(SharedPreferenceManager.getCurrentUserJid())?.image
            if(imageURL != null) {
                MediaUtils.loadImageWithLoader(this, imageURL, profilePicture!!, profilePicture!!.drawable, progressDialog)
            }
        }
        if (isSuccess && isFromSettingsProfile && !fromBackground) {
            getProfileFromServer(isSuccess)
        }
    }

    override fun onClick(view: View?) {
        try {
            when (view) {
                profileStartBinding.currentStatusView -> {
                    startActivityForResult(Intent(this, ProfileStartStatusActivity::class.java).putExtra(Constants.FROM_SETTINGS_PROFILE, isFromSettingsProfile), RequestCode.STATUS_UPDATE)
                }
                profileStartBinding.textEdit -> {
                    startActivityForResult(Intent(this, ProfileStartStatusActivity::class.java).putExtra(Constants.FROM_SETTINGS_PROFILE, isFromSettingsProfile), RequestCode.STATUS_UPDATE)
                }
                profileStartBinding.changeProfileImage -> {
                    if (SystemClock.elapsedRealtime() - lastClickTime > 1000)
                        if (isImageSelected || userImgUrl.isNotEmpty()) showBottomSheetView(this, true, this)
                        else showBottomSheetView(this, false, this)
                    lastClickTime = SystemClock.elapsedRealtime()
                }
                profileStartBinding.imageProfilePicture -> {
                    profilePicPreview()
                }
                profileStartBinding.textSync -> {
                    if (SystemClock.elapsedRealtime() - saveLastClickTime < 1000) return
                    saveLastClickTime = SystemClock.elapsedRealtime()
                    validateUserMail()
                }
                else -> {
                    handleUserClick(view)
                }
            }
        } catch (msg: Exception) {
            LogMessage.e(TAG, msg.message)
        }
    }

    private fun profilePicPreview() {
        if (isFromSettingsProfile) {
            startActivity(Intent(context, UserProfileImageViewActivity::class.java)
                .putExtra(Constants.GROUP_OR_USER_NAME, profileName).putExtra("PROFILE", userImgUrl))
        } else {
            if (userImgUrl.isNotEmpty()) UserProfileUtils().previewUserImage(this, userImgUrl, SharedPreferenceManager.getCurrentUserJid())
            else {
                if (SystemClock.elapsedRealtime() - lastClickTime > 1000)
                    if (isImageSelected) showBottomSheetView(this, true, this)
                    else showBottomSheetView(this, false, this)
                lastClickTime = SystemClock.elapsedRealtime()
            }
        }
    }

    private fun openGalleryIntent() {
        if (AppUtils.isNetConnected(this)) {
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                if (MediaPermissions.isReadFilePermissionAllowed(this) &&
                    MediaPermissions.isWriteFilePermissionAllowed(this)
                )
                    PickFileUtils.chooseImageFromGallery(this)
                else MediaPermissions.requestStorageAccess(
                    this,
                    permissionAlertDialog,
                    galleryPermissionLauncher
                )
            } else {
                 PickFileUtils.chooseImageFromGallery(this)
               }
            } else CustomToast.show(this, getString(R.string.error_check_internet))
    }

    /*
    * Validate the Profile details and Update the SDK method, open the Dashboard page */
    private fun validateUserMail() {
        isProfilePending = true
        isUpdateClickedOnStart = true
        if (profileStartBinding.editProfileName.text.toString().trim().isEmpty())
            CustomToast.show(this, getString(R.string.error_enter_user_name))
        else if (!profileNameCharValidation(profileStartBinding.editProfileName.text.toString().trim()))
            CustomToast.show(this, getString(R.string.error_username_too_short))
        else if (profileStartBinding.textEmail.text.toString().trim().isEmpty())
            CustomToast.show(this, getString(R.string.msg_enter_mail))
        else if (!Pattern.compile(Constants.EMAIL_PATTERN).matcher(profileStartBinding.textEmail.text.toString()).matches())
            CustomToast.show(this, getString(R.string.msg_enter_valid_mail))
        else if (!isProfileStart && SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME) == profileStartBinding.editProfileName.text.toString()
                && SharedPreferenceManager.getString(Constants.USER_EMAIL) == profileStartBinding.textEmail.text.toString())
            CustomToast.show(this, getString(R.string.msg_no_update))
        else redirectToUpdateProfile()
    }

    private fun redirectToUpdateProfile() {
        if (AppUtils.isNetConnected(this)) {
            updateProfile(false)
        } else {
            CustomToast.show(this, getString(R.string.error_check_internet))
        }
    }

    private fun handleUserClick(v: View?) {
        if (v == profileStartBinding.editMobileNumber) {
            mobileNumber = mobileEditText!!.text.toString()//.replace("[^0-9]".toRegex(), "")
            if (SharedPreferenceManager.getBoolean(Constants.LOGIN_MODE))
                startActivityForResult(Intent(this, OtpActivity::class.java)
                        .putExtra(Constants.MOBILE_NO, mobileNumber), RequestCode.OTP_UPDATE)
        } else if (v == profileStartBinding.textEmail) profileStartBinding.textEmail.isCursorVisible = true
    }

    /**
     * Take photo for profile image
     */
    private fun takePhoto() {
        if (AppUtils.isNetConnected(this)) {
            if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.CAMERA) &&
                MediaPermissions.isWriteFilePermissionAllowed(this))
                ImageUtils.takePhotoFromCamera(this, VideoRecUtils.getPath(this, getString(R.string.profile_photos_label)), true)
            else MediaPermissions.requestCameraStoragePermissions(this, permissionAlertDialog, cameraPermissionLauncher)
        } else CustomToast.show(this, getString(R.string.error_check_internet))
    }

    override fun onDestroy() {
        UserProfileUtils().closeProgress(progressDialog)
        super.onDestroy()
    }

    override fun onClick(p0: DialogInterface?, which: Int) {
        when (which) {
            R.id.action_gallery -> openGalleryIntent()
            R.id.action_take -> takePhoto()
            R.id.action_remove -> commonAlertDialog!!.showAlertDialog(getString(R.string.msg_are_you_sure_you_want_to_remove_photo),
                    getString(R.string.action_remove), getString(R.string.action_cancel), DIALOGTYPE.DIALOG_DUAL, false)
            else -> Log.d(TAG, emptyString())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /* setting isActivityStartedForResult to false for xmpp disconnection */
        isActivityStartedForResult = false
        handleActivityResult(requestCode, resultCode, data)
    }

    /**
     * To get the format of picked image
     * @param uri
     */
    open fun getFileExtension(uri: Uri?): String? {
        val extension: String
        val contentResolver: ContentResolver = contentResolver
        val mimeTypeMap: MimeTypeMap = MimeTypeMap.getSingleton()
        extension = mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri!!)).toString()
        return extension
    }

    /**
     * Handle the profile activity result
     *
     * @param requestCode Activity request code
     * @param intentData  Instance of Intent
     */
    private fun handleActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        try {
            if (resultCode == RESULT_OK) {
                val selectedImageUri: Uri? = intentData?.data
                if (selectedImageUri != null) {
                    val pictureExtension = getFileExtension(selectedImageUri)
                    if (pictureExtension.equals("tiff")) {
                        CustomToast.show(this, getString(R.string.file_format_not_supported))
                        return
                    }
                }
                when (requestCode) {
                    RequestCode.STATUS_UPDATE -> updateUserStatus()
                    RequestCode.NAME_UPDATE -> updateUserName()
                    RequestCode.MAIL_UPDATE -> updateUserMail(intentData)
                    RequestCode.TAKE_PHOTO -> {
                        UserProfileUtils().changeUpdateStatus(intent, profileStartBinding.textSync, this)
                        CommonUtils.cropImage(this, mFileTemp!!)
                    }
                    RequestCode.FROM_GALLERY -> {
                        if (!isFromSettingsProfile) UserProfileUtils().changeUpdateStatus(intent, profileStartBinding.textSync, this)
                        handleImageFromGallery(intentData)
                    }
                    RequestCode.CROP_IMAGE -> {
                        if (!isFromSettingsProfile) UserProfileUtils().changeUpdateStatus(intent, profileStartBinding.textSync, this)

                        uploadImage()
                    }
                    RequestCode.OTP_UPDATE -> {
                        mobileEditText!!.text = intentData!!.getStringExtra(Constants.MOBILE_NO)
                    }
                    else -> { //nothing do
                    }
                }
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun uploadImage() {
        try {
            if (mFileTemp != null) {

                isImageSelected = true
                if (isFromSettingsProfile) {
                    if (AppUtils.isNetConnected(this)) {
                        progressDialog = DoProgressDialog(this)
                        if (progressDialog != null) progressDialog!!.showProgress()
                        updateProfilePic(mFileTemp!!)
                    } else CustomToast.show(this, getString(R.string.msg_no_internet))
                }else{
                    userImgUrl = mFileTemp!!.path
                    val photo = BitmapFactory.decodeFile(mFileTemp!!.path)
                    profilePicture!!.setImageBitmap(photo)
                }
            }
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun updateProfilePic(mFileTemp: File) {
        updateMyProfileImage(mFileTemp, FlyCallback { isSuccess: Boolean, _: Throwable?, data: HashMap<String?, Any?>? ->
            if (isSuccess) {
                val profile = data?.get("data") as Profile
                profilePicUploadSuccess(profile.image)
                isImageSelected = false
            } else {
                profilePicUploadFailure()
            }
        })
    }

    private fun profilePicUploadSuccess(image: String?) {
        SharedPreferenceManager.setString(Constants.USER_PROFILE_IMAGE, image)
        userImgUrl = image!!
        if (userImgUrl.isNotEmpty()) MediaUtils.loadImageWithLoader(this, userImgUrl, profilePicture!!, profilePicture!!.drawable, progressDialog)
        else progressDialog?.dismiss()
    }

    private fun profilePicUploadFailure() {
        if (AppUtils.isNetConnected(this)) CustomToast.show(this, getString(R.string.error_occurred_label))
        else {
            CustomToast.show(this, getString(R.string.msg_no_internet))
            if (userImgUrl.isNotEmpty()) {
                MediaUtils.loadImageWithLoader(this, userImgUrl, profilePicture!!,
                    ContextCompat.getDrawable(this, R.drawable.profile_img), progressDialog)
            }
        }
        progressDialog?.dismiss()
    }

    private fun handleImageFromGallery(intentData: Intent?) {
        val inputStream: InputStream?
        try {
            inputStream = contentResolver.openInputStream(intentData!!.data!!)
            val fileOutputStream = FileOutputStream(mFileTemp)
            ImagePopUpUtils.copyStream(inputStream, fileOutputStream)
            fileOutputStream.close()
            inputStream?.close()
            CommonUtils.cropImage(this, mFileTemp!!)
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun updateUserMail(intentData: Intent?) {
        profileStartBinding.textEmail.setText(intentData!!.getStringExtra(Constants.TITLE))
        if (SharedPreferenceManager.getString(Constants.USER_EMAIL) != profileStartBinding.textEmail.text.toString())
            UserProfileUtils().changeUpdateStatus(intent, profileStartBinding.textSync, this)
        if (!isProfileStart && SharedPreferenceManager.getString(Constants.USER_EMAIL) != profileStartBinding.textEmail.text.toString())
            updateProfile(false)
    }

    private fun updateUserName() {
        profileName = profileStartBinding.editProfileName.text.toString().trim()
        if (Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME)) != profileName) {
            UserProfileUtils().changeUpdateStatus(intent, profileStartBinding.textSync, this)
            showProfilePicInitials()
        } else profileStartBinding.textSync.text = getString(R.string.save_button)
    }

    private fun updateUserStatus() {
        if (SharedPreferenceManager.getString(Constants.USER_STATUS) != mStatus) {
            if (!isFromSettingsProfile) UserProfileUtils().changeUpdateStatus(intent, profileStartBinding.textSync, this)
            setStatus(Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_STATUS)))
        }
    }

    open fun updateProfile() {
        profileStartBinding.editProfileName.clearFocus()
        profileStartBinding.textEmail.clearFocus()
        if (isImageSelected && mFileTemp != null) {
            userImgUrl = mFileTemp!!.absolutePath
        }
        val profile = Profile()
        profile.mobileNumber = mobileNumber
        profile.status = mStatus
        profile.image = userImgUrl
        profile.nickName = profileName
        profile.name = profileName
        profile.email = profileStartBinding.textEmail.text.toString()
        if (AppUtils.isNetConnected(this)) {
            updateMyProfile(profile, FlyCallback { isSuccess: Boolean, throws: Throwable?, _: HashMap<String?, Any?>? ->
                if (isSuccess) {
                    ConfigurationUtils.insertDefaultStatus(this, mStatus)
                    ConfigurationUtils.insertDefaultBusyStatus(this)
                    navigateToDashboard()
                    if(isFromSettingsProfile) {
                        checkContusMail()
                        SharedPreferenceManager.setBoolean(Constants.IS_PROFILE_UPDATED, true)
                    }
                } else {
                    progressDialog?.dismiss()
                    val errorMsg: String = if (throws!!.message!!.contains(getString(R.string.msg_profile_pic_update_failure))) {
                        getString(R.string.msg_profile_pic_update_failure)
                    } else getString(R.string.error_occurred_label)
                    CustomToast.show(this, errorMsg)
                }
            })
        } else CustomToast.show(this, getString(R.string.msg_no_internet))
    }


    /*
    * Response Toast */
    private fun showResponseToast(success: Boolean) {
        if (success) {
            if (isUserProfileRemoved) {
                CustomToast.show(this, getString(R.string.msg_profile_image_removed))
                isUserProfileRemoved = false
            } else if (!FlyCore.getIsProfileBlockedByAdmin())
                CustomToast.show(this, getString(R.string.msg_profile_updated))
        }
    }

    open fun updateProfile(inProgress: Boolean) {
        try {
            if (!AppUtils.isNetConnected(this)) CustomToast.show(this, getString(R.string.error_check_internet)) else {
                if (!inProgress) {
                    progressDialog = DoProgressDialog(this)
                    progressDialog!!.showProgress()
                }
                /**
                 * Validate the user name
                 */
                if (profileStartBinding.editProfileName.text.toString().isNotEmpty() && mobileNumber!!.isNotEmpty() && mStatus!!.isNotEmpty() &&
                        profileStartBinding.textEmail.text.toString().isNotEmpty()) {
                    profileName = profileStartBinding.editProfileName.text.toString().trim()
                    setUserProfileName(profileName!!)
                    updateProfile()
                } else {
                    if (!this.isDestroyed) UserProfileUtils().closeProgress(progressDialog)
                }
            }
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun navigateToDashboard() {
        //Profile Updated. Update the UI
        if (!intent.getBooleanExtra(Constants.IS_FIRST_LOGIN, false))
            profileStartBinding.textSync.visibility = View.GONE
        isProfilePending = false
        profileName?.let { setUserProfileName(it) }
        val profileData: ProfileDetails = ContactManager.getMyProfileData()
        SharedPreferenceManager.setString(Constants.USER_PROFILE_IMAGE, profileData.image)
        SharedPreferenceManager.setString(Constants.USER_PROFILE_NAME, profileName)
        SharedPreferenceManager.setBoolean(Constants.IS_PROFILE_LOGGED, true)
        SharedPreferenceManager.setString(Constants.USER_EMAIL, profileStartBinding.textEmail.text.toString())
        SharedPreferenceManager.setString(Constants.USER_MOBILE_NUMBER, mobileNumber)
        SharedPreferenceManager.setString(Constants.USER_STATUS, mStatus)
        FlyCore.setMyProfileStatus(mStatus!!, FlyCallback { _, _, _ -> })
        showResponseToast(true)
        if (intent.getBooleanExtra(Constants.IS_FIRST_LOGIN, false) && isUpdateClickedOnStart) {
            if (FlyCore.getIsProfileBlockedByAdmin()) return
            updateArchiveChatsSettings()
            if (BuildConfig.CONTACT_SYNC_ENABLED){
                UserProfileUtils().closeProgress(progressDialog)
                navigateToContactSync()
            } else {
                navigateToMainPage()
            }
        } else if (isFromSettingsProfile) updateProfileImageIfUrlEmpty()
    }

    private fun updateArchiveChatsSettings() {
        if (isFirstUser) {
            FlyCore.enableDisableArchivedSettings(true, FlyCallback { _, _, _ ->  })
        }
        FlyCore.getArchivedSettingsStatusFromServer()
        FlyCore.getArchivedChatsFromServer()
    }

    private fun updateProfileImageIfUrlEmpty() {
        progressDialog?.dismiss()
        profileStartBinding.textSync.visibility = View.VISIBLE
        profileStartBinding.textSync.isEnabled = false
        showProfilePicInitials()
    }

    private fun showProfilePicInitials() {
        if (userImgUrl.isEmpty()) {
            profilePicture!!.setImageDrawable(setDrawable!!.setDrawableForProfile(profileName?.trim()))
        }
    }

    private fun navigateToMainPage() {
        if (FlyCore.getIsProfileBlockedByAdmin()) return
        FlyCore.getUsersIBlocked(true) { _, _, _ -> }
        UserProfileUtils().closeProgress(progressDialog)
        startActivity(Intent(this, DashboardActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }

    private fun navigateToContactSync(){
        startActivity(Intent(this, SynchronizeContactActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    override fun onDialogClosed(dialogType: DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            if (progressDialog != null)  progressDialog!!.showProgress()
            revokeAccessForProfileImage()
        }
    }

    private fun revokeAccessForProfileImage() {
        if (!isImageSelected && userImgUrl.isNotEmpty()) {
            if (AppUtils.isNetConnected(this)) {
                ContactManager.removeProfileImage { isSuccess, throwable, _ ->
                    if (isSuccess) {
                        isImageSelected = false
                        isUserProfileRemoved = true
                        userImgUrl = Constants.EMPTY_STRING
                        SharedPreferenceManager.setString(Constants.USER_PROFILE_IMAGE, userImgUrl)
                        MediaUtils.loadImageWithGlideSecure(this, userImgUrl, profilePicture!!, setDrawable!!.setDrawableForProfile(profileName))
                        updateMyProfile()
                    } else {
                        showResponseToast(isSuccess)
                        CustomToast.show(this, throwable!!.message!!)
                        progressDialog?.dismiss()
                    }
                }
            } else {
                CustomToast.show(this, getString(R.string.msg_no_internet))
                progressDialog?.dismiss()
            }
        } else {
            isImageSelected = false
            userImgUrl = Constants.EMPTY_STRING
            SharedPreferenceManager.setString(Constants.USER_PROFILE_IMAGE, userImgUrl)
            MediaUtils.loadImageWithGlideSecure(this, userImgUrl, profilePicture!!, setDrawable!!.setDrawableForProfile(profileName))
            progressDialog?.dismiss()
        }
    }

    override fun listOptionSelected(position: Int) {
        //Do Nothing
    }

    private fun updateMyProfile() {
        val profile = Profile()
        profile.mobileNumber = mobileNumber
        profile.status = mStatus
        profile.image = userImgUrl
        profile.nickName = profileName
        profile.name = profileName
        profile.email = profileStartBinding.textEmail.text.toString()

        updateMyProfile(profile, FlyCallback { isSuccess: Boolean, _: Throwable?, _: HashMap<String?, Any?>? ->
            if (isSuccess) showResponseToast(isSuccess)
            else CustomToast.show(this, getString(R.string.error_occurred_label))
            progressDialog?.dismiss()
        })
    }
    override fun userProfileFetched(jid: String, profileDetails: ProfileDetails) {
        super.userProfileFetched(jid, profileDetails)
        if (this.isFinishing || !isFromSettingsProfile) return
        isProfileUpdated = false
        fromBackground = false
        this.profileDetails = ProfileDetails()
        with(this.profileDetails) {
            name =
                Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_NAME))
            email =
                Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.EMAIL))
            mobileNumber =
                Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_MOBILE_NUMBER))
            image =
                Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_PROFILE_IMAGE))
            status =
                Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_STATUS))
        }
        setUserProfile()
    }

    private fun checkContusMail() {
        val email = Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.EMAIL))
        profileStartBinding.textEmail.isEnabled = ChatUtils.isContusUser(email)
    }

    override fun onConnected() {
        super.onConnected()
        if(!isFromSettingsProfile){
            handleSaveButton(true)
        }
    }

    override fun onDisconnected() {
        super.onDisconnected()
        if(!isFromSettingsProfile){
            handleSaveButton(false)
        }
    }
}