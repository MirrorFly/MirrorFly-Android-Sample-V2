package com.contusfly.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Rect
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.*
import android.util.Log
import android.util.TypedValue
import android.view.*
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.adapters.HorizontalListViewAdapter
import com.contusfly.chat.FileMimeType
import com.contusfly.chat.RealPathUtil
import com.contusfly.adapters.MediaViewAdapter
import com.contusfly.chat.ShareMessagesController
import com.contusfly.mediapicker.model.Image
import com.contusfly.models.FileObject
import com.contusfly.utils.*
import com.contusfly.views.ShareDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flydatabase.model.Roster
import com.mirrorflysdk.models.MultipleImages
import com.mirrorflysdk.utils.ConstantActions
import com.mirrorflysdk.utils.FilePathUtils
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import com.fxn.pix.Options
import com.fxn.pix.Pix
import dagger.android.AndroidInjection
import io.github.rockerhieu.emojicon.EmojiconGridFragment
import io.github.rockerhieu.emojicon.EmojiconsFragment
import io.github.rockerhieu.emojicon.emoji.Emojicon
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class ImagePreviewActivity : BaseActivity(), View.OnClickListener,
    EmojiconsFragment.OnEmojiconBackspaceClickedListener,
    EmojiconGridFragment.OnEmojiconClickedListener, ViewPager.OnPageChangeListener,
    HorizontalListViewAdapter.OnItemClickListener {
    /**
     * The Images list.
     */
    private var imagesList: RecyclerView? = null

    /**
     * View to the files number
     */
    private var filesCounter: AppCompatTextView? = null

    /**
     * View to the files number
     */
    private var recipientName: AppCompatTextView? = null

    /**
     * View to the files number
     */
    @Inject
    lateinit var shareMessagesController: ShareMessagesController

    var toolbar: Toolbar? = null
    private var captionView: LinearLayout? = null
    private var sendImage: ImageView? = null
    private var remainingMessagesCount = 0

    /**
     * Adapter for the media list
     */
    private var mediaViewAdapter: MediaViewAdapter? = null

    /**
     * Edit text which used to add the caption message for selected image
     */
    private var captionMessageEditText: EditText? = null

    /**
     * Instance of the EmojiHandler to access the emoji and text keypad
     */
    private var emojiHandler: EmojiHandler? = null

    /**
     * Position of the selected message
     */
    private var imagePosition = 0

    /**
     * List of selected images
     */
    private lateinit var selectedImageList: MutableList<MultipleImages>

    /**
     * List of selected files from Quick Share
     */
    private var fileObjects: ArrayList<FileObject>? = null

    /**
     * List of selected files from Quick Share
     */
    private var selectedUsers: List<Roster>? = null

    /**
     * Check is from Quick Share or not
     */
    private var isFromQuickShare = false

    /**
     * Check is from Chat Screen or not
     */
    private var isFromChatScreen = false

    /**
     * State of view pager during transition
     */
    private var viewPagerState = 0

    /**
     * Position of view pager
     */
    private var viewPagerPosition = 0

    /**
     * User jid to send images
     */
    private var toUser: String? = null

    /**
     * Absolute Filepath for the video.
     */
    private var filepath: String? = null

    /**
     * The view pager to show image
     */
    private var viewPager: ViewPager? = null

    /**
     * The Boolean List is contains All image list
     */
    private var isImageList: MutableList<Boolean>? = null

    /**
     * List Contian jid of multiple users
     */
    private var jidList: ArrayList<String>? = null

    /**
     * List Contian  user chat typelist
     */
    private var chatTypeList: ArrayList<String>? = null

    /**
     * The Array List Contains Uri List
     */
    private var uriList: ArrayList<Uri>? = null

    /**
     * Share the Key Value
     */
    private var intentKeyShare: String? = null

    /**
     * Path from Uri
     */
    private val pathFromUri: MutableList<String?> = ArrayList()

    /**
     * Store onclick time to avoid double click
     */
    private var lastClickTime: Long = 0

    /**
     * Horizontal list adapter for selected images
     */
    private var listViewAdapter: HorizontalListViewAdapter? = null
    private var shareDialog: ShareDialog? = null

    /**
     * Check is from camera or not
     */
    private var isFromCamera = false

    /**
     * Selected images from gallery
     */
    private var images: ArrayList<Image>? = null

    /**
     * Video duration limit
     */
    private var videoDurationLimit: Long = 0

    /**
     * Deleted images from preview screen
     */
    private var selectedMediaList: ArrayList<Image>? = null
    private var showingEmojiKeyboard = false

    private lateinit var menuAdd: MenuItem

    /**
     * To listen to network change
     */
    private val mNetworkChangeListener: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            try {
                val action = intent.action
                if (action == ConstantActions.NETWORK_STATE_CHANGE) {
                    handleNetworkStatusChange(
                        intent.getBooleanExtra(
                            ConstantActions.NETWORK_STATE_STATUS,
                            true
                        )
                    )
                }
            } catch (e: Exception) {
                LogMessage.e(e)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        setContentView(R.layout.activity_image_preview)
        AppLifecycleListener.isFromQuickShareForBioMetric = true
        AppLifecycleListener.isFromQuickShareForPin = true
        setToolbar()
        isFromCamera = intent.getBooleanExtra("from_camera", false)
        intentKeyShare = intent.getStringExtra(Constants.INTENT_KEY_SHARE)
        isFromChatScreen = intent.getBooleanExtra("from_gallery", false)
        videoDurationLimit = intent.getLongExtra("video_duration_limit", 0)
        viewPager = findViewById(R.id.media_scroll)

        imagesList = findViewById(R.id.images_list)
        val smiley = findViewById<ImageView>(R.id.image_chat_smiley)
        sendImage = findViewById(R.id.caption_image_send)
        captionView = findViewById(R.id.view_chat)
        filesCounter = findViewById(R.id.filesCount)
        recipientName = findViewById(R.id.recipient_name)
        captionMessageEditText = findViewById(R.id.edit_caption_msg)
        selectedImageList = ArrayList()
        viewPager!!.addOnPageChangeListener(this)
        emojiHandler = EmojiHandler(this)
        emojiHandler!!.attachKeyboardListeners(captionMessageEditText!!)
        emojiHandler!!.setIconImageView(smiley)
        emojiHandler!!.setHandledFrom(TAG)
        sendImage!!.setOnClickListener(this)
        smiley.setOnClickListener(this)


        /*
         * Store the selected images from intent data
         */
        if (intent.getBooleanExtra(Constants.IS_IMAGE, false)) {
            handlePreviewFromGallery()
        } else if (intentKeyShare != null && intentKeyShare == Constants.SHARE) {
            handleQuickShareInitialOperations()
        } else {
            filesCounter!!.visibility = View.GONE
            /*
             * Assign the position of selected media
             */
            val multipleImages = MultipleImages(intent
                .getStringExtra(Constants.FILE_PATH),
                captionMessageEditText!!.text.toString().trim { it <= ' ' },
                false
            )
            selectedImageList.add(multipleImages)
            if (selectedImageList.isNotEmpty()) showThumbnailAndRecipient()
            imagePosition = 0
            viewPagerPosition = 0
            filepath = intent.getStringExtra(Constants.FILE_PATH)
        }
        toUser = intent.getStringExtra(Constants.USER_JID)
        if (toUser != null && toUser!!.isNotEmpty()) {
            val profileDetail = ProfileDetailsUtils.getProfileDetails(toUser!!)
            selectedImageList[0].imageCaption = FlyMessenger.getUnsentMessageOfAJid(toUser!!)
            if (profileDetail != null)
                recipientName!!.text = "To: ${profileDetail.getDisplayName()}"
        }
        setAdapterForViewPager()

        /*
         * Initiate the horizontal list view
         */
        listViewAdapter = HorizontalListViewAdapter(this, selectedImageList, imagePosition)
        listViewAdapter!!.setOnItemClickListener(this)
        imagesList!!.adapter = listViewAdapter

        /*
         * Set the adapter in the view pager for the swiping view
         */
        viewPager!!.adapter = mediaViewAdapter
        /*
         * Set the starting media
         */
        viewPager!!.currentItem = imagePosition
        listenToKeyboardVisibility()
        registerNetworkBroadcast()
    }

    override fun onResume() {
        super.onResume()
        AppLifecycleListener.isFromQuickShareForBioMetric = true
        AppLifecycleListener.isFromQuickShareForPin = true
        currentFocus?.let {
            it.showSoftKeyboard()
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        }
    }

    /**
     * while uploading if internet disconnects, then show appropriate toast msg
     * @param isConnected n/w
     */
    private fun handleNetworkStatusChange(isConnected: Boolean) {
        if (!isConnected && shareDialog?.progressDialog != null && shareDialog?.progressDialog!!.isShowing) {
            shareDialog!!.dismissShareDialog()
            Toast.makeText(this, getString(R.string.msg_no_internet_try_again), Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun listenToKeyboardVisibility() {
        val parentView = (findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0)
        parentView.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            private var alreadyOpen = false
            private val defaultKeyboardHeightDP = 100
            private val estimatedKeyboardDP =
                defaultKeyboardHeightDP + if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) 48 else 0
            private val rect = Rect()
            override fun onGlobalLayout() {
                val estimatedKeyboardHeight = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    estimatedKeyboardDP.toFloat(),
                    parentView.resources.displayMetrics
                ).toInt()
                parentView.getWindowVisibleDisplayFrame(rect)
                val heightDiff = parentView.rootView.height - (rect.bottom - rect.top)
                val isShown = heightDiff >= estimatedKeyboardHeight
                if (isShown == alreadyOpen) {
                    return
                }
                alreadyOpen = isShown
                onKeyboardVisibilityChanged(isShown)
            }
        })
    }

    /**
     * Register broadcast for Internet newtwork connection status change
     */
    private fun registerNetworkBroadcast() {
        LocalBroadcastManager.getInstance(this).registerReceiver(
            mNetworkChangeListener,
            IntentFilter(ConstantActions.NETWORK_STATE_CHANGE)
        )
    }

    private fun onKeyboardVisibilityChanged(isShown: Boolean) {
        if (!isShown && !showingEmojiKeyboard && selectedImageList.isNotEmpty()) showThumbnailAndRecipient() else hideThumbnailAndRecipient()
    }

    private fun handlePreviewFromGallery() {
        filesCounter!!.visibility = View.GONE
        selectedMediaList = ArrayList()
        if (isFromCamera) {
            val mediaPath = intent.getStringExtra(Constants.FILE_PATH)
            val uri =
                FileProvider.getUriForFile(this, ChatManager.fileProviderAuthority, File(mediaPath))
            revokeUriPermission(
                uri,
                Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
            images = ArrayList()
            images!!.add(Image(0, mediaPath!!,0, true))
        } else {
            images = intent.getSerializableExtra(Constants.SELECTED_IMAGES) as ArrayList<Image>
        }
        /*
         * Assign the position of selected media
         */
        for (imageItem in images!!) {
            selectedMediaList!!.add(imageItem)
            val multipleImages = MultipleImages(imageItem.path,
                captionMessageEditText!!.text.toString().trim { it <= ' ' }, !imageItem.isVideo
            )
            selectedImageList.add(multipleImages)
            if (selectedImageList.isNotEmpty()) showThumbnailAndRecipient()
            imagePosition = 0
            viewPagerPosition = 0
        }
    }

    private fun handleQuickShareInitialOperations() {
        isFromQuickShare = true
        sendImage!!.visibility = View.GONE
        recipientName!!.visibility = View.GONE
        shareDialog = ShareDialog(this)
        fileObjects = intent.getParcelableArrayListExtra("FILE_OBJECTS")
        selectedUsers = intent.getParcelableArrayListExtra("USERS")
        jidList = intent.getStringArrayListExtra(Constants.INTENT_KEY_JID_LIST)
        chatTypeList = intent.getStringArrayListExtra(Constants.INTENT_KEY_CHAT_TYPE_LIST)
        uriList = intent.getParcelableArrayListExtra(Constants.INTENT_KEY_RECEIVED_FILES)
        isImageList = ArrayList()
        for (uri in uriList!!)
            createAdapterObject(uri)
        imagePosition = 0
        viewPagerPosition = 0
        if (fileObjects!![0].fileMimeType == FileMimeType.APPLICATION || fileObjects!![0].fileMimeType == FileMimeType.AUDIO) captionView!!.visibility =
            View.GONE
        captionMessageEditText!!.setText(fileObjects!![0].caption)
    }

    /**
     * Adapter for the media list
     */
    private fun setAdapterForViewPager() {
        mediaViewAdapter = if (intentKeyShare != null && intentKeyShare == Constants.SHARE) {
            MediaViewAdapter(supportFragmentManager, fileObjects)
        } else {
            /*
             * File path values - comes only recorded video
             * */
            MediaViewAdapter(supportFragmentManager, selectedImageList, filepath)
        }
    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.selected_media)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        UserInterfaceUtils.initializeCustomToolbar(this, toolbar)
        toolbar!!.setTitleTextColor(ContextCompat.getColor(this, R.color.color_text))
        toolbar?.navigationIcon?.applySrcInColorFilter(
            ContextCompat.getColor(
                this,
                R.color.dashboard_toolbar_text_color
            )
        )
        toolbar!!.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_quick_share, menu)
        val menuCancel = menu.findItem(R.id.action_share_cancel)
        val menuDelete = menu.findItem(R.id.action_share_delete)
        val menuSend = menu.findItem(R.id.action_share_share)
        menuAdd = menu.findItem(R.id.action_add_item)
        when {
            isFromQuickShare -> {
                menuCancel.isVisible = true
                menuDelete.isVisible = true
                menuSend.isVisible = true
            }
            isFromCamera -> {
                menuCancel.isVisible = false
                menuDelete.isVisible = false
                menuSend.isVisible = false
                menuAdd.isVisible = false
            }
            else -> {
                menuCancel.isVisible = false
                menuDelete.isVisible = true
                menuSend.isVisible = false
                menuAdd.isVisible =
                    selectedImageList.size < Constants.MAX_MEDIA_SELECTION_RESTRICTION
            }
        }
        onPageSelected(viewPagerPosition)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000) return false
        lastClickTime = SystemClock.elapsedRealtime()
        when (item.itemId) {
            R.id.action_share_share -> {
                fileObjects!![viewPagerPosition].caption = captionMessageEditText!!.text.toString()
                startCopyingFilesToAppDirectoryAndSend()
                remainingMessagesCount = fileObjects!!.size
                return true
            }
            R.id.action_share_delete -> {
                if (isFromQuickShare) removeSelectedFile() else removeSelectedFileFromPicker()
                return true
            }
            R.id.action_add_item -> {
                if (isFromChatScreen) backToSelectFileFromGallery() else finishQuickShare()
                return true
            }
            R.id.action_share_cancel -> {
                finishQuickShare()
                return true
            }
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (isFromQuickShare) {
                // Need to handle for share screen
                mediaViewAdapter = MediaViewAdapter(supportFragmentManager, fileObjects)
            } else {
                setAdapterForViewPager()
            }
            viewPager!!.adapter = mediaViewAdapter
            viewPager!!.setCurrentItem(viewPagerPosition, true)
        }
    }

    private fun removeSelectedFile() {
        if (fileObjects!!.size == 1) finish() else {
            fileObjects!!.removeAt(viewPagerPosition)
            setViewPagerAdapter()
            val currentSize = viewPagerPosition
            filesCounter!!.text = "${currentSize + 1}/${fileObjects!!.size}"
        }
    }

    private fun removeSelectedFileFromPicker() {
        if (selectedImageList.size == 1) backToSelectFileFromGallery() else {
            selectedMediaList!!.removeAt(viewPagerPosition)
            selectedImageList.removeAt(viewPagerPosition)
            setMediaPickerAdapter()
            menuAdd.isVisible = selectedImageList.size < Constants.MAX_MEDIA_SELECTION_RESTRICTION
        }
    }

    private fun backToSelectFileFromGallery() {
       finish()
    }

    private fun backToCamera() {
        val options: Options? = Options.init()
            .setRequestCode(100)
            .setCount(Constants.MAX_MEDIA_SELECTION_RESTRICTION)
            .setOutputPath(Constants.LOCAL_PATH.toUpperCase(Locale.getDefault()))
            .setFrontfacing(false)
            .setPreSelectedUrls(ArrayList())
            .setExcludeVideos(false)
            .setVideoDurationLimitinSeconds(Constants.VIDEO_DURATION_LIMIT)//Prefs.getString(SharedPreferenceManager.VIDEO_LIMIT).toInt())
            .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
            .setPath(Constants.LOCAL_PATH)
            .setMediaClass(MediaPreviewActivity::class.java)
            .setAudioPermissionAsked(SharedPreferenceManager.getBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED))

        Pix.start(this, options)
        finish()
    }

    private fun setMediaPickerAdapter() {
        listViewAdapter!!.notifyDataSetChanged()
        setAdapterForViewPager()
        viewPager!!.adapter = mediaViewAdapter
        if (viewPagerPosition == 0
            || viewPagerPosition <= selectedImageList.size - 1
        ) viewPager!!.setCurrentItem(
            viewPagerPosition,
            true
        ) else if (viewPagerPosition == selectedImageList.size) {
            viewPagerPosition -= 1
            viewPager!!.setCurrentItem(viewPagerPosition, true)
        }
        if (selectedImageList.size == 1) viewPagerPosition = 0
        onPageSelected(viewPagerPosition)
    }

    private fun setViewPagerAdapter() {
        mediaViewAdapter = MediaViewAdapter(supportFragmentManager, fileObjects)
        viewPager!!.adapter = mediaViewAdapter
        if (viewPagerPosition == 0
            || viewPagerPosition <= fileObjects!!.size - 1
        ) viewPager!!.setCurrentItem(
            viewPagerPosition,
            true
        ) else if (viewPagerPosition == fileObjects!!.size) {
            viewPagerPosition -= 1
            viewPager!!.setCurrentItem(viewPagerPosition, true)
        }
        if (fileObjects!!.size == 1) viewPagerPosition = 0
        onPageSelected(viewPagerPosition)
    }

    /*
     * The Multiple Image/video  selection path
     *
     * @param uri object type
     */
    private fun createAdapterObject(uri: Uri) {
        var mimeType = contentResolver.getType(uri)
        val multipleImages: MultipleImages
        mimeType = mimeType ?: intent.type
        val filePathFromUri = if (uri.scheme == null)
            uri.path
        else
            RealPathUtil.getRealPath(this@ImagePreviewActivity, uri)
        pathFromUri.add(filePathFromUri)
        LogMessage.d(TAG, "file path createAdapterObject = $filePathFromUri")
        LogMessage.d(TAG, "log mime type in createAdapterObject = $mimeType")
        if (mimeType!!.startsWith("image/")) {
            isImageList!!.add(true)
            multipleImages = MultipleImages(
                filePathFromUri,
                captionMessageEditText!!.text.toString().trim { it <= ' ' },
                true
            )
            selectedImageList.add(multipleImages)
        } else if (mimeType.startsWith("video/")) {
            isImageList!!.add(false)
            multipleImages = MultipleImages(
                filePathFromUri,
                captionMessageEditText!!.text.toString().trim { it <= ' ' },
                false
            )
            selectedImageList.add(multipleImages)
        }
    }

    override fun onBackPressed() {
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000) return
        lastClickTime = SystemClock.elapsedRealtime()
        if (emojiHandler!!.isEmojiShowing) {
            emojiHandler!!.hideEmoji()
            showingEmojiKeyboard = false
            if (isFromQuickShare && fileObjects!!.size > 1) showThumbnailAndRecipient() else if (selectedImageList.isNotEmpty()) {
                showThumbnailAndRecipient()
            }
        } else if (isFromQuickShare)
            finishQuickShare()
        else if (isFromCamera)
            backToCamera()
        else
            super.onBackPressed()
    }

    override fun onClick(v: View) {
        LogMessage.d(TAG, "ImagePreviewActivity send clicked")
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000) return
        lastClickTime = SystemClock.elapsedRealtime()
        /*
         * Check if the Emoji keypad in open state
         */
        if (v.id == R.id.image_chat_smiley) {
            if (!emojiHandler!!.isEmojiShowing) {
                showingEmojiKeyboard = true
                hideKeyboard()
                hideThumbnailAndRecipient()
            } else {
                showingEmojiKeyboard = false
                if (selectedImageList.isNotEmpty())
                    showThumbnailAndRecipient()
            }
            emojiHandler!!.setKeypad(captionMessageEditText!!)
        } else if (v.id == R.id.caption_image_send) {
            sendMediaFile()
        }
    }

    private fun sendMediaFile() {
        hideKeyboard()
        /*
         * Send the selected messages
         */
        if (isFromQuickShare) {
            startCopyingFilesToAppDirectoryAndSend()
        } else {
            selectedImageList[viewPagerPosition].imageCaption =
                captionMessageEditText!!.text.toString().trim { it <= ' ' }
            if (toUser != null) {
                handleCaptionImage(toUser!!)
            } else if (intentKeyShare != null && intentKeyShare == "share") {
                startActivity(
                    Intent(this, ChatActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .setType(intent.type)
                        .putExtra(Constants.INTENT_KEY_SHARE, "share")
                        .putStringArrayListExtra(Constants.INTENT_KEY_JID_LIST, jidList)
                        .putStringArrayListExtra(
                            Constants.INTENT_KEY_CHAT_TYPE_LIST,
                            chatTypeList
                        )
                        .putExtra(Constants.INTENT_KEY_RECEIVED_FILES, uriList)
                        .putParcelableArrayListExtra(
                            "captionList",
                            selectedImageList as ArrayList<out Parcelable?>?
                        )
                )
            }
            findViewById<View>(R.id.caption_image_send).isEnabled = false
            finish()
        }
    }

    fun viewPagerOnClick(v: View?) {
        hideKeyboard()
        if (emojiHandler!!.isEmojiShowing) {
            emojiHandler!!.hideEmoji()
            showingEmojiKeyboard = false
        }
    }

    /**
     * handle caption click
     */
    private fun handleCaptionImage(toUser: String) {
        val profileDetail = ProfileDetailsUtils.getProfileDetails(toUser)
        /*
         * Set type of chat to send message
         */
        if (intent.getBooleanExtra(Constants.IS_IMAGE, false)) {
            for (img in selectedImageList) {
                if (img.imagePath.contains(Constants.LOCAL_PATH.toUpperCase(Locale.getDefault()) + "_IMG_")) saveImageToCameraRoll(
                    img
                )
            }
            startActivity(
                Intent(this, ChatActivity::class.java)
                    .putExtra(LibConstants.JID, toUser)
                    .putExtra(Constants.CHAT_TYPE, profileDetail!!.getChatType())
                    .putParcelableArrayListExtra(
                        Constants.SELECTED_IMAGES,
                        selectedImageList as ArrayList<out Parcelable?>?
                    )
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            )
        } else {
            if (intent.getStringExtra(Constants.FILE_PATH)!!
                    .contains(Constants.LOCAL_PATH.toUpperCase(Locale.getDefault()) + "_VID_")
            ) saveVideoToCameraRoll(intent.getStringExtra(Constants.FILE_PATH)!!)
            startActivity(
                Intent(this, ChatActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .putExtra(LibConstants.JID, toUser)
                    .putExtra(Constants.CHAT_TYPE, profileDetail!!.getChatType())
                    .putExtra(Constants.SELECTED_VIDEO, intent.getStringExtra(Constants.FILE_PATH))
                    .putExtra(
                        Constants.SELECTED_VIDEO_CAPTION,
                        captionMessageEditText!!.text.toString().trim { it <= ' ' })
            )
        }
    }

    private fun saveImageToCameraRoll(img: MultipleImages?) {
        val folderPath =
            Constants.LOCAL_PATH + File.separator + Constants.LOCAL_PATH + " Camera Roll"
        val dir = File(FilePathUtils.getExternalStorage(), folderPath)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val sourcePath =
            FilePathUtils.getExternalStorage().absolutePath + "/" + Constants.LOCAL_PATH + "/Image/Sent/" + img!!.imagePath.substring(
                img.imagePath.lastIndexOf('/') + 1
            )
        val source = File(sourcePath)
        val destinationPath =
            FilePathUtils.getExternalStorage().absolutePath + File.separator + folderPath + File.separator + img.imagePath.substring(
                img.imagePath.lastIndexOf('/') + 1
            )
        val destination = File(destinationPath)
        var imageFileInputStream: FileInputStream? = null
        var imageFileOutputStream: FileOutputStream? = null
        try {
            imageFileInputStream = FileInputStream(source)
            imageFileOutputStream = FileOutputStream(destination)
            val inChannel = imageFileInputStream.channel
            val outChannel = imageFileOutputStream.channel
            inChannel.transferTo(0, inChannel.size(), outChannel)
        } catch (e: IOException) {
            LogMessage.e(TAG, e.toString())
        } finally {
            try {
                imageFileInputStream?.close()
            } catch (e: IOException) {
                LogMessage.e(TAG, e.toString())
            }
            try {
                imageFileOutputStream?.close()
            } catch (e: IOException) {
                LogMessage.e(TAG, e.toString())
            }
        }
        MediaScannerConnection.scanFile(
            this, arrayOf(
                destinationPath
            ), null
        ) { path: String, _: Uri? -> Log.i("TAG", "Finished scanning $path") }
    }

    private fun saveVideoToCameraRoll(img: String) {
        val folderPath =
            Constants.LOCAL_PATH + File.separator + Constants.LOCAL_PATH + " Camera Roll"
        val dir = File(FilePathUtils.getExternalStorage(), folderPath)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val sourceVideoPath =
            FilePathUtils.getExternalStorage().absolutePath + File.separator + Constants.LOCAL_PATH +
                    File.separator + "Video/Sent/" + img.substring(img.lastIndexOf('/') + 1)
        val videoSource = File(sourceVideoPath)
        val videoDestinationPath =
            FilePathUtils.getExternalStorage().absolutePath + File.separator + folderPath + File.separator + img.substring(
                img.lastIndexOf('/') + 1
            )
        val videoDestination = File(videoDestinationPath)
        var videoFileInputStream: FileInputStream? = null
        var videoFileOutputStream: FileOutputStream? = null
        try {
            videoFileInputStream = FileInputStream(videoSource)
            videoFileOutputStream = FileOutputStream(videoDestination)
            val inChannel = videoFileInputStream.channel
            val outChannel = videoFileOutputStream.channel
            inChannel.transferTo(0, inChannel.size(), outChannel)
        } catch (e: IOException) {
            LogMessage.e(TAG, e.toString())
        } finally {
            try {
                videoFileInputStream?.close()
            } catch (e: IOException) {
                LogMessage.e(TAG, e.toString())
            }
            try {
                videoFileOutputStream?.close()
            } catch (e: IOException) {
                LogMessage.e(TAG, e.toString())
            }
        }
        MediaScannerConnection.scanFile(
            this, arrayOf(
                videoDestinationPath
            ), null
        ) { path: String, _: Uri? -> Log.i("TAG", "Finished scanning $path") }
    }

    /**
     * Hide the soft input keyboard from the startupActivityContext of the window
     * that is currently accepting input.
     */
    private fun hideKeyboard() {
        val view = currentFocus
        Utils.hideSoftInput(this, view)
    }

    /**
     * Hide thumbnail and recipient details.
     */
    private fun hideThumbnailAndRecipient() {
        recipientName!!.visibility = View.GONE
        imagesList!!.visibility = View.GONE
    }

    /**
     * Show thumbnail and recipient details.
     */
    private fun showThumbnailAndRecipient() {
        if (recipientName!!.text != "")
            recipientName!!.visibility = View.VISIBLE
        imagesList!!.visibility = View.VISIBLE
    }

    override fun onEmojiconClicked(emojicon: Emojicon) {
        EmojiconsFragment.input(captionMessageEditText, emojicon)
    }

    override fun onEmojiconBackspaceClicked(v: View) {
        EmojiconsFragment.backspace(captionMessageEditText)
    }

    @SuppressLint("SetTextI18n")
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        if (isFromQuickShare)
            filesCounter!!.text = "${position + 1}/${fileObjects!!.size}"
    }

    override fun onPageSelected(position: Int) {
        hideKeyboard()
        if (emojiHandler!!.isEmojiShowing) emojiHandler!!.hideEmoji()
        if (selectedImageList.isNotEmpty()) showThumbnailAndRecipient()

        /*
          Check if the current position images contains caption to show
         */if (isFromQuickShare) {
            if (fileObjects!![position].fileMimeType == FileMimeType.VIDEO || fileObjects!![position].fileMimeType == FileMimeType.IMAGE) {
                captionMessageEditText!!.setText(if (fileObjects!![position].caption.isEmpty()) "" else fileObjects!![position].caption)
                captionView!!.visibility = View.VISIBLE
            } else captionView!!.visibility = View.GONE
        } else captionMessageEditText!!.setText(
            if (Utils.returnEmptyStringIfNull(
                    selectedImageList[position]
                        .imageCaption
                ).isNotEmpty()
            ) selectedImageList[position].imageCaption else ""
        )
        captionMessageEditText!!.setSelection(captionMessageEditText!!.text.length)
        /*
         * Update the view pager adapter and horizontal view adapter
         */
        viewPagerPosition = position
        listViewAdapter!!.setPosition(position)
        listViewAdapter!!.notifyDataSetChanged()
        imagesList!!.scrollToPosition(position)
    }

    override fun onPageScrollStateChanged(state: Int) {
        /*
          validate and store the caption while position view pager changes
         */
        if (state == ViewPager.SCROLL_STATE_DRAGGING) {
            if (isFromQuickShare) {
                fileObjects!![viewPager!!.currentItem].caption =
                    captionMessageEditText!!.text.toString().trim { it <= ' ' }
            } else {
                selectedImageList[viewPager!!.currentItem].imageCaption =
                    captionMessageEditText!!.text.toString().trim { it <= ' ' }
            }
        }
        viewPagerState = state
        if (isFromQuickShare) mediaViewAdapter!!.setFileObjectList(fileObjects) else mediaViewAdapter!!.setImageList(
            selectedImageList
        )
        mediaViewAdapter!!.notifyDataSetChanged()
    }

    override fun onItemClick(view: View?, position: Int) {
        /*
         * Update the view pager adapter and horizontal view adapter after selecting in
         * horizontal list view
         */
        selectedImageList[viewPagerPosition].imageCaption =
            captionMessageEditText!!.text.toString().trim { it <= ' ' }
        viewPager!!.currentItem = position
        mediaViewAdapter!!.notifyDataSetChanged()
    }

    private fun sendMediaMessageToRemainingUsers(message: ChatMessage?) {
        val remainingUsers = selectedUsers!!.subList(1, selectedUsers!!.size)
        val userJID = ArrayList<String?>()
        for (user in remainingUsers) {
            userJID.add(user.jid)
        }
        shareMessagesController.sendMediaMessagesToRemainingUsers(message!!, userJID)
        if (remainingMessagesCount == 0) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                shareDialog!!.dismissShareDialog()
                navigateToAppropriateScreen()
                finish()
            }, 1000)
        }
    }

    /**
     * If single user/group, then navigate to it's chat
     * if multiple then navigate to Dashboard screen
     */
    private fun navigateToAppropriateScreen() {
        if (selectedUsers!!.size == 1) {
            val userRoster = selectedUsers!![0]
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra(LibConstants.JID, userRoster.jid)
            intent.putExtra(Constants.CHAT_TYPE, userRoster.rosterType)
            startActivity(intent)
        } else if (selectedUsers!!.size > 1) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    private fun sendMediaFilesForSingleUser() {
        if (AppUtils.isNetConnected(this)) {
            val usersJID = ArrayList<String>()
            for (user in selectedUsers!!) usersJID.add(user.jid)
            shareMessagesController.sendMediaMessagesForSingleUser(fileObjects!!, usersJID)
        } else {
            shareDialog!!.dismissShareDialog()
            CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }

    private fun startCopyingFilesToAppDirectoryAndSend() {
        if (AppUtils.isNetConnected(this)) {
            shareDialog!!.initializeAndShowShareDialog("Quick Share", "Sending messages...")
            /*The below lines of code copies the file once again on the directory once it's compressed/
          / *  for (FileObject mediaFile : fileObjects) {
                String folderName;
                switch (mediaFile.getFileMimeType()) {
                    case VIDEO:
                        folderName = Constants.MSG_TYPE_VIDEO;
                        break;
                    case AUDIO:
                        folderName = Constants.MSG_TYPE_AUDIO;
                        break;
                    case IMAGE:
                        folderName = Constants.MSG_TYPE_IMAGE;
                        break;
                    default:
                        folderName = Constants.MSG_TYPE_FILE;
                        break;
                }
                String originalName = mediaFile.getName();
                String[] splitFile = originalName.split("[.]");

                String name = splitFile[0] + randomNumber.nextInt(10000);
                String ext = splitFile[1];

                File outFile = new File(getSentFolder(folderName) + File.separator + name + "." + ext);
                runOnUiThread(() -> copyFiles(new File(mediaFile.getFilePath()), outFile));
                mediaFile.setFilePath(outFile.getAbsolutePath());
            }
           */sendMediaFilesForSingleUser()
        } else {
            shareDialog!!.dismissShareDialog()
            CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }

    override fun notifyShareUploadStatus(intent: Intent) {
        remainingMessagesCount--
        val message: ChatMessage = intent.getParcelableExtra(Constants.MESSAGE)!!
        val isUploaded = intent.getBooleanExtra(Constants.IS_UPLOAD_SUCCESS, false)
        if (isUploaded) {
            sendMediaMessageToRemainingUsers(message)
        } else {
            shareDialog!!.dismissShareDialog()
            Toast.makeText(this, getString(R.string.msg_no_internet), Toast.LENGTH_SHORT).show()
        }
    }

    fun getSentFolder(folderName: String): String {
        return (FilePathUtils.getExternalStorage().toString() + File.separator
                + Constants.LOCAL_PATH
                + File.separator + folderName + File.separator + "Sent")
    }

    /**
     * Copies file from source to destination
     *
     * @param src Source file
     * @param dst Destination file
     */
    fun copyFiles(src: File?, dst: File?) {
        try {
            FileInputStream(src).use { inStream ->
                var outChannel: FileChannel
                val inChannel = inStream.channel
                FileOutputStream(dst).use { outStream ->
                    outChannel = outStream.channel
                    inChannel.transferTo(0, inChannel.size(), outChannel)
                }
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    private fun finishQuickShare() {
        AppLifecycleListener.isFromQuickShareForBioMetric = false
        AppLifecycleListener.isFromQuickShareForPin = false
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask()
        } else {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        AppLifecycleListener.isFromQuickShareForBioMetric = false
        AppLifecycleListener.isFromQuickShareForPin = false
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mNetworkChangeListener)
    }

    companion object {
        private const val TAG = "ImagePreviewActivity"
    }
}