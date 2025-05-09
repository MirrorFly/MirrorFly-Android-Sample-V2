package com.contusfly.activities

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.graphics.Rect
import android.net.Uri
import android.os.*
import android.text.Editable
import android.text.InputFilter
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.ContentFrameLayout
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.contusfly.*
import com.contusfly.activities.ChatActivity.Companion.addMoreMediaClicked
import com.contusfly.activities.ChatActivity.Companion.unSentMentionedUserIdList
import com.contusfly.activities.parent.ChatParent
import com.contusfly.adapters.GroupTagAdapter
import com.contusfly.adapters.MediaPreviewAdapter
import com.contusfly.adapters.MediaPreviewPagerAdapter
import com.contusfly.chat.*
import com.contusfly.constants.MobileApplication
import com.contusfly.databinding.ActivityMediaPreviewBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.groupmention.MentionEditGroupText
import com.contusfly.groupmention.MentionUser
import com.contusfly.groupmention.MentionUtils
import com.contusfly.groupmention.OnMentionEventListener
import com.contusfly.groupmention.TextUIConfig
import com.contusfly.groupmention.UserMentionConfig
import com.contusfly.interfaces.MessageListener
import com.contusfly.mediapicker.model.Image
import com.contusfly.models.*
import com.contusfly.utils.*
import com.contusfly.viewmodels.MediaPreviewViewModel
import com.contusfly.viewmodels.MentionsViewModel
import com.contusfly.views.CustomAlertDialog
import com.contusfly.views.CustomItemDecoration
import com.contusfly.views.DoProgressDialog
import com.contusfly.views.KeyboardHeightProvider
import com.contusfly.views.PermissionAlertDialog
import com.fxn.pix.Options
import com.fxn.pix.Pix
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycommons.FlyUtils
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.ChatUtils.getUserFromJid
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import io.github.rockerhieu.emojicon.EmojiconGridFragment
import io.github.rockerhieu.emojicon.EmojiconsFragment
import io.github.rockerhieu.emojicon.emoji.Emojicon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.File
import java.util.*
import javax.inject.Inject


class MediaPreviewActivity : BaseActivity(), MediaPreviewAdapter.OnItemClickListener,
    ViewPager.OnPageChangeListener, View.OnClickListener,
    EmojiconsFragment.OnEmojiconBackspaceClickedListener,
    EmojiconGridFragment.OnEmojiconClickedListener, GroupTagAdapter.UserTagClickListener {

    private lateinit var mediaPreviewBinding: ActivityMediaPreviewBinding
    val userMentionConfig: UserMentionConfig = UserMentionConfig.Builder().build()
    var mediaListCaptionAddedStatus=false


    @Inject
    lateinit var mediaPreviewViewModelFactory: AppViewModelFactory
    val viewModel by lazy {
        ViewModelProviders.of(this, mediaPreviewViewModelFactory)
            .get(MediaPreviewViewModel::class.java)
    }

    protected val mentionViewModel by lazy {
        ViewModelProvider(this).get(MentionsViewModel::class.java)
    }
    private val groupTagRecycler by lazy { mediaPreviewBinding.groupTagNameRecycler }
    private val groupTagAdapter: GroupTagAdapter by lazy { GroupTagAdapter(this@MediaPreviewActivity, { onUserTagClicked(it) }) }

    @Inject
    lateinit var messagingClient: MessagingClient

    private var keyboardHeightProvider: KeyboardHeightProvider? = null

    /**
     * Check is from camera or not
     */
    private var isFromCamera = false

    private val parentContent by bindView<ContentFrameLayout>(android.R.id.content)

    private var isResumeFirstTime = true

    /**
     * User jid to send images
     */
    private var toUser: String? = null

    /**
     * Store onclick time to avoid double click
     */
    private var lastClickTime: Long = 0

    /**
     * Share the Key Value
     */
    private var intentKeyShare: String? = null

    /**
     * Instance of the EmojiHandler to access the emoji and text keypad
     */
    private var emojiHandler: EmojiHandler? = null

    private var alreadyOpen = false

    private var showChatKeyboard: Boolean = false

    /**
     * Check is from Chat Screen or not
     */
    private var isFromChatScreen = false

    /**
     * Check is from Quick Share or not
     */
    private var isFromQuickShare = false

    /**
     * Position of the selected message
     */
    private var imagePosition = 0

    /**
     * State of view pager during transition
     */
    private var viewPagerState = 0

    /**
     * Position of view pager
     */
    private var viewPagerPosition = 0

    /**
     * List of selected images
     */
    private var selectedImageList: MutableList<MediaPreviewModel> = mutableListOf()

    private var showingEmojiKeyboard = false

    /**
     * List of selected files from Quick Share
     */
    private var fileObjects: MutableList<FileObject> = mutableListOf()

    /**
     * Adapter for the media list
     */
    lateinit var mediaViewPagerAdapter: MediaPreviewPagerAdapter
    var isSoftKeyboardShown: Boolean = false
    var isResumedNotCalled: Boolean = false

    private lateinit var mediaPreviewAdapter: MediaPreviewAdapter

    /**
     * Selected images from gallery
     */
    private var selectedImages: ArrayList<Image> = arrayListOf()

    /**
     * The progress dialog of the activity When run the background tasks
     */
    private var progressDialog: DoProgressDialog? = null

    /**
     * List of selected files from Quick Share
     */
    private var selectedUsers: List<String>? = null

    /**
     * The Boolean List is contains All image list
     */
    private var isImageList: List<Boolean>? = null

    /**
     * List Contian jid of multiple users
     */
    private var jidList: java.util.ArrayList<String>? = null

    /**
     * The Array List Contains Uri List
     */
    private var uriList: java.util.ArrayList<Uri>? = null

    private var remainingMessagesCount = 0

    private var emojiEditText: MentionEditGroupText? =null

    private var mentionedUsersIds: MutableList<String> = mutableListOf()
    private var sendTextMessageWithMentionFormat: CharSequence? = emptyString()
    private var mentionFilterKey: String = emptyString()
    var mediaListCaption:MediaCaptionMentionList?=null
    private var myApp:MobileApplication?=null

            /**
     * View to the files number
     */
    @Inject
    lateinit var shareMessagesController: ShareMessagesController

    private val permissionAlertDialog : PermissionAlertDialog by lazy { PermissionAlertDialog(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        mediaPreviewBinding = ActivityMediaPreviewBinding.inflate(layoutInflater)
        setContentView(mediaPreviewBinding.root)
        AppLifecycleListener.isFromQuickShareForBioMetric = true
        AppLifecycleListener.isFromQuickShareForPin = true
        keyboardHeightProvider = KeyboardHeightProvider(this)
        keyboardHeightProvider?.addKeyboardListener(getKeyboardListener())
        myApp= application as MobileApplication
        mediaListCaption = myApp?.getMediaCaptionObject()
    }

    private fun addMediaCaptionMentionList(){
        if(emojiEditText!!.mentionedUsers!=null && emojiEditText!!.mentionedUsers.size>0) {
            selectedImageList[mediaPreviewBinding.mediaList.currentItem].caption =
                emojiEditText!!.mentionedTemplate.toString()
            selectedImageList[mediaPreviewBinding.mediaList.currentItem].mentionedUsersIds =
                ChatUtils.setSelectedUserIdForMention(
                    emojiEditText!!.mentionedUsers,
                    mutableListOf()
                )
        }else{
            selectedImageList[viewPagerPosition].caption=emojiEditText?.text.toString()
        }

        selectedImageList.forEach{
            mediaListCaption?.mediaCaptionParameters?.add(MediaCaptionMentionList(path = it.path, caption = it.caption, mentionedUsersIds = it.mentionedUsersIds, isImage = it.isImage))
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        AppLifecycleListener.isFromQuickShareForBioMetric = true
        AppLifecycleListener.isFromQuickShareForPin = true

        isFromCamera = intent.getBooleanExtra(Constants.FROM_CAMERA, false)
        intentKeyShare = intent.getStringExtra(Constants.INTENT_KEY_SHARE)
        toUser = intent.getStringExtra(Constants.USER_JID)
        if (toUser.isNullOrEmpty() || ProfileDetailsUtils.getProfileDetails(toUser!!) == null) {
            LogMessage.i(TAG, "onPostCreate profile details is null for : $toUser")
            finish()
            return
        }
        initViews()
        setObservers()
        initMentionAdapter()
    }

    private fun initViews() {
        toUser?.let {
            viewModel.getProfileDetails(it)
        }

        initializeCaptionListener()
        if (intent.getBooleanExtra(Constants.IS_IMAGE, false)) {
            handlePreviewFromGallery()
        } else if (intentKeyShare != null && intentKeyShare == Constants.SHARE) {
            handleQuickShareInitialOperations()
        } else {
           handlePreviewFromCamera()
        }

        initializeAdapterForViewPager()

        mediaPreviewAdapter = MediaPreviewAdapter(this, selectedImageList, imagePosition, this)
        mediaPreviewBinding.imagesPreviewList.apply {
            adapter = mediaPreviewAdapter
        }

        mediaPreviewBinding.backArrow.setOnClickListener(this)
        mediaPreviewBinding.emoji.setOnClickListener(this)
        mediaPreviewBinding.addMoreMedia.setOnClickListener(this)
        mediaPreviewBinding.deleteMedia.setOnClickListener(this)
        mediaPreviewBinding.sendMedia.setOnClickListener(this)
        mediaPreviewBinding.viewOverlay.setOnClickListener(this)

        emojiHandler = EmojiHandler(this)
        emojiHandler!!.attachKeyboardListeners(emojiEditText!!)
        emojiHandler!!.setIconImageView(mediaPreviewBinding.emoji)
        emojiHandler!!.setIsBlackTheme(true)
        emojiHandler!!.setHandledFrom(TAG)

        setAddMoreVisibility()
        setKeyboardHeightListener()
    }

    private fun setKeyboardHeightListener() {
        parentContent.viewTreeObserver.addOnGlobalLayoutListener {
            val r = Rect()
            parentContent.getWindowVisibleDisplayFrame(r)
            val screenHeight = parentContent.rootView.height
            // r.bottom is the position above soft keypad or device button.
            // if keypad is shown, the r.bottom is smaller than that before.
            val keypadHeight = screenHeight - r.bottom

            if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.
                if (!isSoftKeyboardShown) {
                    isSoftKeyboardShown = true
                    mediaPreviewBinding.imagesPreviewList.gone()
                    Log.d(TAG, " keyboard is opened")
                    if (emojiHandler!!.isEmojiShowing)
                        emojiHandler!!.hideEmoji()
                }
            } else {
                if (isSoftKeyboardShown) {
                    checkAndShowPreviewList()
                    isSoftKeyboardShown = false
                    Log.d(TAG, " keyboard is closed")
                }
            }
        }
    }

    private fun setCaptionLength(length: Int) {
        val remainingCount = Constants.MAX_CAPTION_LENGTH - length
        if (remainingCount < 30) {
            mediaPreviewBinding.captionCount.show()
            mediaPreviewBinding.captionCount.text = remainingCount.toString()
        } else mediaPreviewBinding.captionCount.gone()
    }

    private fun initializeCaptionListener() {
        emojiEditText = mediaPreviewBinding.imageCaption
        emojiEditText!!.setHorizontallyScrolling(false)
        emojiEditText!!.maxLines = 6
        emojiEditText!!.filters =
            arrayOf(InputFilter.LengthFilter(Constants.MAX_CAPTION_LENGTH))

        emojiEditText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                /*No Implementation Needed*/
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    setCaptionLength(it.length)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                /*No Implementation Needed*/
            }
        })

        emojiEditText!!.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                mediaPreviewBinding.groupAddMore.gone()
                mediaPreviewBinding.emoji.show()
                mediaPreviewBinding.viewOverlay.show()
                mediaPreviewBinding.groupToUser.gone()
            } else {
                showChatKeyboard = false
                setAddMoreVisibility()
                mediaPreviewBinding.viewOverlay.gone()
                mediaPreviewBinding.emoji.gone()
                mediaPreviewBinding.captionCount.gone()
                mediaPreviewBinding.groupToUser.show()
            }
        }

        emojiEditText!!.setOnLongClickListener {
            if (emojiHandler!!.isEmojiShowing) {
                emojiHandler!!.hideEmoji()
                emojiEditText!!.requestFocus()
                emojiEditText!!.showSoftKeyboard()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
                checkAndShowPreviewList()
                showChatKeyboard = false
            }
            false
        }
    }

    private fun initializeAdapterForViewPager() {
        val height = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            windowManager.currentWindowMetrics.bounds.height()
        } else {
            resources.displayMetrics.heightPixels
        }
        // Real size of the screen (full screen)
        val realSize = Point()
        val realDisplay = windowManager.defaultDisplay
        realDisplay.getRealSize(realSize)
        val finalHeight =
            if (realSize.y - AndroidUtils.getNavBarHeight(this) == height || realSize.y == height) {
                height - AndroidUtils.getStatusBarHeight(this) - AndroidUtils.getNavBarHeight(this)   // Remove Status bar height and Navbar height
            } else height
        mediaPreviewBinding.bottomLayout.post {
            val toolbarHeight = mediaPreviewBinding.toolbarLayout.height
            val bottomLayoutHeight = mediaPreviewBinding.bottomLayout.height
            val linearLayoutParams =
                mediaPreviewBinding.mediaList.layoutParams as LinearLayout.LayoutParams
            linearLayoutParams.height = finalHeight - bottomLayoutHeight - toolbarHeight
        }

        setAdapterForViewPager()
        mediaPreviewBinding.mediaList.addOnPageChangeListener(this)
        mediaPreviewBinding.mediaList.offscreenPageLimit = 2
        mediaPreviewBinding.mediaList.adapter = mediaViewPagerAdapter
        mediaPreviewBinding.mediaList.currentItem = imagePosition
    }

    private fun checkAndShowPreviewList() {
        if (selectedImageList.size <= 1 || showingEmojiKeyboard) {
            mediaPreviewBinding.imagesPreviewList.gone()
            mediaPreviewBinding.deleteMedia.gone()
        } else {
            mediaPreviewBinding.imagesPreviewList.show()
            mediaPreviewBinding.deleteMedia.show()
        }
    }

    private fun onKeyboardVisibilityChanged(shown: Boolean) {
        if (!shown && emojiEditText!!.hasFocus() && !showingEmojiKeyboard && !isResumedNotCalled) {
            emojiEditText!!.clearFocus()
        }
        Handler(Looper.getMainLooper()).postDelayed({
            isResumedNotCalled = false
        }, 100)
    }

    private fun setUserName(name: String) {
        mediaPreviewBinding.toUserTextView.text = name
    }

    private fun prepareMultipleUserNames() {
        if (jidList?.size!! > 1) {
            val participantsNameList: MutableList<String> = ArrayList()
            selectedUsers!!.forEach {
                if(!it.equals(SharedPreferenceManager.getCurrentUserJid())) {
                    participantsNameList.add(ProfileDetailsUtils.getProfileDetails(it)!!.getDisplayName())
                }
            }
            setUserName(participantsNameList.sorted().joinToString(", "))
        }
    }
    lateinit var chat: Chat
    private fun setObservers() {
        viewModel.profileDetails.observe(this) {
            it?.let {
                if (isFromQuickShare && jidList?.size!! > 1) {
                    mediaPreviewBinding.imageChatPicture.visibility = View.INVISIBLE
                    return@let
                }
                mediaPreviewBinding.imageChatPicture.loadUserProfileImage(this, it)
                setUserName(it.getDisplayName())
                chat = Chat(it.getChatType(), it.jid)
                with(Dispatchers.Main) {
                    initGroupMentionTag()
                    viewModel.getUnsentMessage(it.jid)
                }
            }
        }
        viewModel.unsentMessage.observe(this) {
            it?.let {
                setCaptionEntryFirst(it)
                firstIndexImageMentionUserId()
                setCaptionLength(it.length)
            }
        }

        viewModel.selectedMediaList.observe(this) {
            mediaPreviewBinding.previewProgress.previewProgress.gone()
            if (it.isEmpty())
                finish()
            selectedImageList.addAll(it)
            checkAndShowPreviewList()
            initializeAdapterForViewPager()
            viewModel.unsentMessage.value?.let { message ->
                if (selectedImageList.isNotEmpty())
                    selectedImageList[0].caption = message
                emojiEditText!!.setText(message)
                setCaptionLength(message.length)
            }
            setAddMoreVisibility()
        }
    }

    private fun setCaptionEntryFirst(it:String){
        if (!addMoreMediaClicked) {
            if (selectedImageList.isNotEmpty())
                selectedImageList[0].caption = it
            showUnSentMentionUsersMessage(it)
        } else {
            maintainAddedMentionUser(0)
        }
    }

    private fun firstIndexImageMentionUserId(){
        if(emojiEditText!!.mentionedUsers!=null && emojiEditText!!.mentionedUsers.isNotEmpty()) {
            selectedImageList[0].mentionedUsersIds = (emojiEditText!!.mentionedUsers as? ArrayList<*>)?.filterIsInstance<String>()?.toCollection(ArrayList()) ?: arrayListOf()
        }
    }

    private fun showUnSentMentionUsersMessage(unsentMessage: String) {
        val texts = context!!.getString(R.string.chat_text)
        val textMessage = unsentMessage + texts + texts
        var mentions: String? =null
        if (!addMoreMediaClicked) {
             if(toUser!=null)
              mentions = FlyMessenger.getUnsentMentionedUserId(toUser!!)
        } else {
            if (selectedImageList[0].mentionedUsersIds.isNotEmpty())
                mentions = selectedImageList[0].mentionedUsersIds[0]
        }
        if(mentions!=null && mentions.isNotEmpty()){
            var mentionUsersList=ChatUtils.convertProfileDetailsList(mentions)
            var text= MentionUtils.formatUnSentMentionText(mentionUsersList,textMessage,this,emojiEditText!!)
            emojiEditText?.setText(TextUtils.concat(text.trim(), " "))
        } else{
            emojiEditText?.setText(unsentMessage)
        }

    }

    private fun handlePreviewFromCamera() {
        mentionedUsersIds = ChatUtils.setSelectedUserIdForMention(emojiEditText!!.mentionedUsers,mentionedUsersIds)
        if (intent.getBooleanExtra(Constants.FROM_FRONT_CAMERA, false)) {
            val image = Image(
                0, intent
                    .getStringExtra(Constants.FILE_PATH)!!,
                0, false
            )
            selectedImages.add(image)
            val destinationFile = File.createTempFile("temp", null, context?.externalCacheDir)
            viewModel.checkVideoSize(image, destinationFile)
        } else {
            val mediaPreviewModel = MediaPreviewModel(intent.getStringExtra(Constants.FILE_PATH)!!,
                emojiEditText!!.text.toString().trim { it <= ' ' }, Constants.EMPTY_STRING, false,mentionedUsersIds)
            SharedPreferenceManager.setBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED, true)
            selectedImageList.add(mediaPreviewModel)
            checkAndShowPreviewList()
            imagePosition = 0
            viewPagerPosition = 0
            mediaPreviewBinding.previewProgress.previewProgress.gone()
        }
    }

    private fun handleQuickShareInitialOperations() {
        mentionedUsersIds = ChatUtils.setSelectedUserIdForMention(emojiEditText!!.mentionedUsers,mentionedUsersIds)
        isFromQuickShare = true
        progressDialog = DoProgressDialog(this)
        fileObjects = intent.getParcelableArrayListExtra("FILE_OBJECTS")!!
        selectedUsers = intent.getStringArrayListExtra("USERS")
        jidList = intent.getStringArrayListExtra(Constants.INTENT_KEY_JID_LIST)
        uriList = intent.getParcelableArrayListExtra(Constants.INTENT_KEY_RECEIVED_FILES)
        isImageList = java.util.ArrayList<Boolean>()
        for (uri in uriList!!) createAdapterObject(uri)
        imagePosition = 0
        viewPagerPosition = 0
        remainingMessagesCount = fileObjects.size
        if (fileObjects[0].fileMimeType == FileMimeType.APPLICATION || fileObjects[0].fileMimeType == FileMimeType.AUDIO)
            mediaPreviewBinding.bottomLayout.visibility = View.GONE
        emojiEditText!!.setText(fileObjects[0].caption)
        mediaPreviewBinding.previewProgress.previewProgress.gone()

        jidList?.get(0)?.let { viewModel.getProfileDetails(it) }
        checkAndShowPreviewList()
        prepareMultipleUserNames()
    }

    /*
     * The Multiple Image/video  selection path
     *
     * @param uri object type
     */
    private fun createAdapterObject(uri: Uri) {
        var mimeType = contentResolver.getType(uri)
        val multipleImages: MediaPreviewModel
        mimeType = mimeType ?: intent.type
        val filePathFromUri = RealPathUtil.getRealPath(this@MediaPreviewActivity, uri)

       // filePathFromUri = if (uri.scheme == null) uri.path else RealPathUtil.getRealPath(this@MediaPreviewActivity, uri)
        LogMessage.d(TAG, "file path createAdapterObject = $filePathFromUri")
        LogMessage.d(TAG, "log mime type in createAdapterObject = $mimeType")
        if (mimeType!!.startsWith("image/")) {
            multipleImages = MediaPreviewModel(filePathFromUri!!,
                emojiEditText!!.text.toString().trim { it <= ' ' }, Constants.EMPTY_STRING, true,mentionedUsersIds)
            selectedImageList.add(multipleImages)
        } else if (mimeType.startsWith("video/")) {
            multipleImages = MediaPreviewModel(filePathFromUri!!,
                emojiEditText!!.text.toString().trim { it <= ' ' }, Constants.EMPTY_STRING, false,mentionedUsersIds)
            selectedImageList.add(multipleImages)
        }
    }

    private fun handlePreviewFromGallery() {
        mentionedUsersIds = ChatUtils.setSelectedUserIdForMention(emojiEditText!!.mentionedUsers,mentionedUsersIds)
        if (isFromCamera) {
            val mediaPath = intent.getStringExtra(Constants.FILE_PATH)
            val uri =
                FileProvider.getUriForFile(this, ChatManager.fileProviderAuthority, File(mediaPath))
            revokeUriPermission(
                uri,
                Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
            selectedImages = ArrayList()
            selectedImages.add(Image(0, mediaPath!!, 0, false))
        } else {
            selectedImages = (intent.getSerializableExtra(Constants.SELECTED_IMAGES) as? ArrayList<*>)?.filterIsInstance<Image>()?.toCollection(ArrayList()) ?: arrayListOf()
        }
        mediaPreviewBinding.previewProgress.previewProgress.gone()
        selectedImages.forEach {
            if(mediaListCaption?.mediaCaptionParameters?.isNotEmpty()==true) {
                mediaListCaption?.mediaCaptionParameters?.forEach { media ->
                    if (it.path == media.path) {
                        Log.d("selectedImages", "MediaCaption selectedImages after path:${it.path}")
                        selectedImageList.add(
                            MediaPreviewModel(
                                it.path,
                                media.caption,
                                Constants.EMPTY_STRING,
                                !it.isVideo,
                                media.mentionedUsersIds
                            )
                        )
                        mediaListCaptionAddedStatus=true
                    }
                }

            } else {
                Log.d("selectedImages", "selectedImages after path:${it.path}")
                selectedImageList.add(
                    MediaPreviewModel(
                        it.path,
                        Constants.EMPTY_STRING,
                        Constants.EMPTY_STRING,
                        !it.isVideo,
                        mentionedUsersIds
                    )
                )
            }
            if (!mediaListCaptionAddedStatus && mediaListCaption?.mediaCaptionParameters?.isNotEmpty()==true) {
                selectedImageList.add(
                    MediaPreviewModel(
                        it.path,
                        Constants.EMPTY_STRING,
                        Constants.EMPTY_STRING,
                        !it.isVideo,
                        mentionedUsersIds
                    )
                )
            }
            mediaListCaptionAddedStatus=false
        }
        checkAndShowPreviewList()
        initializeAdapterForViewPager()
        setAddMoreVisibility()
    }

    fun setAdapterForViewPager() {
        if (intentKeyShare != null && intentKeyShare == Constants.SHARE) {
            mediaViewPagerAdapter = MediaPreviewPagerAdapter(supportFragmentManager)
            mediaViewPagerAdapter.setFileObjectList(fileObjects)
        } else {
            /*
             * File path values - comes only recorded video
             * */
            mediaViewPagerAdapter = MediaPreviewPagerAdapter(supportFragmentManager)
            mediaViewPagerAdapter.setImageList(selectedImageList)
        }
    }

    override fun onBackPressed() {
        addMoreMediaClicked=true
        if (mediaListCaption?.mediaCaptionParameters?.isNotEmpty() == true)
            myApp?.clearMediaCaptionObject()
        addMediaCaptionMentionList()
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000) return
        lastClickTime = SystemClock.elapsedRealtime()
        emojiEditText!!.clearFocus()
        when {
            emojiHandler!!.isEmojiShowing -> {
                emojiHandler!!.hideEmoji()
                emojiEditText!!.clearFocus()
            }
            isFromCamera -> backToCamera()
            isFromQuickShare -> finishQuickShare()
            else -> super.onBackPressed()
        }
    }

    private fun finishQuickShare() {
        AppLifecycleListener.isFromQuickShareForBioMetric = false
        AppLifecycleListener.isFromQuickShareForPin = false
        if (Build.VERSION.SDK_INT >= 21) finishAndRemoveTask()
        else finish()
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
            .setAudioPermissionAsked(SharedPreferenceManager.getBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED))
            .setMediaClass(MediaPreviewActivity::class.java)


        Pix.start(this, options)
        finish()
    }

    override fun onItemClick(view: View?, position: Int) {
        if (isFromQuickShare) fileObjects[viewPagerPosition].caption = emojiEditText!!.text.toString().trim { it <= ' ' }
        else {
            if(emojiEditText!!.mentionedUsers!=null && emojiEditText!!.mentionedUsers.size>0){
                val mentionedUsersIdsItemClick: MutableList<String> = mutableListOf()
                selectedImageList[mediaPreviewBinding.mediaList.currentItem].caption=emojiEditText!!.getMentionedTemplate().toString()
                selectedImageList[mediaPreviewBinding.mediaList.currentItem].mentionedUsersIds=ChatUtils.setSelectedUserIdForMention(emojiEditText!!.mentionedUsers,mentionedUsersIdsItemClick)
            }
            else {
                selectedImageList[viewPagerPosition].caption =
                    emojiEditText!!.text.toString().trim { it <= ' ' }
            }
        }
        mediaPreviewBinding.mediaList.currentItem = position
        mediaViewPagerAdapter.notifyDataSetChanged()
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        /* No Implementation Needed */
    }

    override fun onPageSelected(position: Int) {
        hideKeyboard()
        if (emojiHandler!!.isEmojiShowing) emojiHandler!!.hideEmoji()
        emojiEditText!!.clearFocus()
        checkAndShowPreviewList()

        /*
          Check if the current position images contains caption to show
         */
        if (isFromQuickShare) {
            if (fileObjects[position].fileMimeType == FileMimeType.VIDEO || fileObjects[position].fileMimeType == FileMimeType.IMAGE) {
                emojiEditText!!.setText(if (fileObjects[position].caption.isEmpty()) "" else fileObjects[position].caption)
                setCaptionLength(emojiEditText!!.text.toString().length)
                emojiEditText!!.show()
                mediaPreviewBinding.emoji.show()
            } else {
                emojiEditText!!.gone()
                mediaPreviewBinding.emoji.gone()
                mediaPreviewBinding.captionCount.gone()
            }
        } else {
            maintainAddedMentionUser(position)
            setCaptionLength(emojiEditText!!.text.toString().length)
        }
        emojiEditText!!.setSelection(emojiEditText!!.text!!.length)
        /*
         * Update the view pager adapter and horizontal view adapter
         */
        viewPagerPosition = position
        mediaPreviewAdapter.setPosition(position)
        mediaPreviewAdapter.notifyDataSetChanged()
        mediaPreviewBinding.imagesPreviewList.scrollToPosition(position)
    }

    private fun maintainAddedMentionUser(position:Int) {
        try {
            if (selectedImageList.isEmpty()) return
            if (selectedImageList[position].mentionedUsersIds != null && selectedImageList[position].mentionedUsersIds.isNotEmpty() && selectedImageList[position].caption.isNotEmpty()) {
                val texts = context!!.getString(R.string.chat_text)
                val textMessage = selectedImageList[position].caption + texts + texts
                val unSentMentionedUserIdList = ArrayList<ProfileDetails?>()
                val mentionIdList = selectedImageList[position].mentionedUsersIds
                for (mentionUser in mentionIdList) {
                    val jidFormation = FlyUtils.getJid(mentionUser)
                    val profile = FlyCore.getUserProfile(jidFormation)
                    if (profile != null) {
                        unSentMentionedUserIdList.add(profile)
                    }
                }
                var text = MentionUtils.formatUnSentMentionText(
                    unSentMentionedUserIdList,
                    textMessage,
                    this,
                    emojiEditText!!
                )
                emojiEditText!!.setText(TextUtils.concat(text.trim(), " "))
            } else {
                emojiEditText!!.setText(
                    if (Utils.returnEmptyStringIfNull(selectedImageList[position].caption)
                            .isNotEmpty()
                    )
                        selectedImageList[position].caption else ""
                )
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            LogMessage.e(TAG, e.toString())
        } catch (e: Exception) {
            LogMessage.e(TAG, e.toString())
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
        /*
          validate and store the caption while position view pager changes
         */
        if (state == ViewPager.SCROLL_STATE_DRAGGING) {
            if (isFromQuickShare) {
                fileObjects[mediaPreviewBinding.mediaList.currentItem].caption =
                    emojiEditText!!.text.toString().trim { it <= ' ' }
            } else {
                if(emojiEditText!!.mentionedUsers!=null && emojiEditText!!.mentionedUsers.size>0){
                    val mentionedUsersIdsScrollState: MutableList<String> = mutableListOf()
                    selectedImageList[mediaPreviewBinding.mediaList.currentItem].caption=emojiEditText!!.getMentionedTemplate().toString()
                    selectedImageList[mediaPreviewBinding.mediaList.currentItem].mentionedUsersIds= ChatUtils.setSelectedUserIdForMention(emojiEditText!!.mentionedUsers,mentionedUsersIdsScrollState)
                }
                else {
                    selectedImageList[mediaPreviewBinding.mediaList.currentItem].caption =
                        emojiEditText!!.text.toString().trim { it <= ' ' }
                }
            }
        }
        viewPagerState = state
        if (isFromQuickShare) mediaViewPagerAdapter.setFileObjectList(fileObjects)
        else mediaViewPagerAdapter.setImageList(selectedImageList)
        mediaViewPagerAdapter.notifyDataSetChanged()
    }

    fun viewPagerOnClick(v: View?) {
        hideKeyboard()
        if (emojiHandler!!.isEmojiShowing) {
            emojiHandler!!.hideEmoji()
            emojiEditText!!.clearFocus()
            showingEmojiKeyboard = false
        }
    }

    /**
     * Hide the soft input keyboard from the startupActivityContext of the window
     * that is currently accepting input.
     */
    private fun hideKeyboard() {
        val view = currentFocus
        Utils.hideSoftInput(this, view)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.back_arrow -> {
                onBackPressed()
            }
            R.id.emoji -> {
                if (!emojiHandler!!.isEmojiShowing) {
                    showingEmojiKeyboard = true
                    hideKeyboard()
                } else {
                    showingEmojiKeyboard = false
                }
                emojiHandler!!.setKeypad(emojiEditText!!)
                setEmojiKeyBoardListener()
                mediaPreviewBinding.imagesPreviewList.gone()
            }
            R.id.add_more_media -> {
                addMoreMediaClicked=true
                if (mediaListCaption?.mediaCaptionParameters?.isNotEmpty() == true)
                    myApp?.clearMediaCaptionObject()
                addMediaCaptionMentionList()
                val resultIntent = Intent()
                resultIntent.putExtra("remaining_list", selectedImages)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
            R.id.delete_media -> {
                if (isFromQuickShare) removeSelectedFile() else removeSelectedFileFromPicker()
            }
            R.id.send_media -> {
                sendMedia()
            }
            R.id.view_overlay -> {
                hideKeyboard()
                groupTagRecycler.gone()
                if (emojiHandler!!.isEmojiShowing) {
                    emojiHandler!!.hideEmoji()
                    emojiEditText!!.clearFocus()
                    showingEmojiKeyboard = false
                }
            }
        }
    }

    private fun setEmojiKeyBoardListener() {
        emojiHandler!!.setEmojiKeyBoardListener { isOpened ->
            showingEmojiKeyboard = isOpened
            checkAndShowPreviewList()
        }
    }

    private fun sendMedia() {
        hideKeyboard()
        mediaPreviewBinding.sendMedia.isEnabled = false
        mentionedUsersIds = ChatUtils.setSelectedUserIdForMention(emojiEditText!!.mentionedUsers,mentionedUsersIds)
        setTextIncludingMention(mentionedUsersIds)
        if (isFromQuickShare) {
            fileObjects[viewPagerPosition].caption = sendTextMessageWithMentionFormat.toString()
            fileObjects[viewPagerPosition].mentionedUsersIds = mentionedUsersIds
            progressDialog = DoProgressDialog(this)
            progressDialog!!.showProgress()
            var isPermissionAvailable = true
            val features = ChatManager.getAvailableFeatures()
            for (files in  fileObjects) {
                when (files.fileMimeType) {
                    FileMimeType.IMAGE -> isPermissionAvailable = features.isImageAttachmentEnabled
                    FileMimeType.VIDEO -> isPermissionAvailable = features.isVideoAttachmentEnabled
                    FileMimeType.AUDIO -> isPermissionAvailable = features.isAudioAttachmentEnabled
                    FileMimeType.APPLICATION -> isPermissionAvailable = features.isDocumentAttachmentEnabled
                }
                if (!isPermissionAvailable)
                    break
            }
            if (isPermissionAvailable) {
                quickShareMediafileUpload()
            } else {
                CustomAlertDialog().showFeatureRestrictionAlert(this)
                progressDialog!!.dismiss()
                mediaPreviewBinding.sendMedia.isEnabled = true
            }
        } else {
            ChatParent.isComingFromFilePicker = true
            mediaUpload()
        }
    }

    private fun mediaUpload(){
        if(MediaPermissions.runtimeNotificationPermissionEnabledStatus(this)){
            mediafileUpload()
        } else {
            notificationPermissionChecking()
        }
    }

    private fun notificationPermissionChecking(){
        mediaPreviewBinding.sendMedia.isEnabled = true
        MediaPermissions.requestNotificationPermission(
            this,
            permissionAlertDialog,
            notificationPermissionLauncher)
    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { _ ->
        if(ChatUtils.checkNotificationPermission(this, Manifest.permission.POST_NOTIFICATIONS)){
            if(isFromQuickShare){
                progressDialog!!.showProgress()
                startCopyingFilesToMirrorFlyDirectoryAndSend()
            } else {
                mediafileUpload()
            }
        }
    }

    private fun quickShareMediafileUpload(){
        if(MediaPermissions.runtimeNotificationPermissionEnabledStatus(this)){
            startCopyingFilesToMirrorFlyDirectoryAndSend()
        } else {
            progressDialog!!.dismiss()
            notificationPermissionChecking()
        }
    }

    private fun mediafileUpload(){
        selectedImageList[viewPagerPosition].caption = sendTextMessageWithMentionFormat.toString()
        selectedImageList[viewPagerPosition].mentionedUsersIds = mentionedUsersIds
        if (toUser != null) {
            handleCaptionImage(toUser!!)
        }
    }

    private fun startCopyingFilesToMirrorFlyDirectoryAndSend() {
        if (AppUtils.isNetConnected(this)) {
            sendMediaFilesForSingleUser()
        } else {
            progressDialog!!.dismiss()
            CustomToast.show(context, getString(R.string.msg_no_internet))
            mediaPreviewBinding.sendMedia!!.isEnabled = true
        }
    }

    private fun sendMediaFilesForSingleUser() {
        if (AppUtils.isNetConnected(this)) {
            shareMessagesController.sendMediaMessagesForSingleUser(fileObjects, selectedUsers!!) {
                progressDialog!!.dismiss()
                navigateToAppropriateScreen()
                finish()
            }
        } else {
            progressDialog!!.dismiss()
            CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }

    private fun navigateToAppropriateScreen() {
        if (selectedUsers!!.size == 1) {
            val userId = selectedUsers!![0]
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra(Constants.JID, userId)
            intent.putExtra(Constants.IS_FROM_MEDIA_PREVIEW_ACTIVITY,true)
            intent.putExtra(Constants.CHAT_TYPE, ProfileDetailsUtils.getProfileDetails(userId))
            intent.putExtra(Constants.FROM_QUICK_SHARE, true)
            startActivity(intent)
        } else if (selectedUsers!!.size > 1) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    /**
     * handle caption click
     */
    private fun handleCaptionImage(toUser: String) {
        val replyMessageId = ReplyHashMap.getReplyId(toUser)
        if (intent.getBooleanExtra(Constants.IS_IMAGE, false)) {
            sendGalleryAttachments(toUser, replyMessageId)
        } else {
            if (!ChatManager.getAvailableFeatures().isVideoAttachmentEnabled) {
                mediaPreviewBinding.previewProgress.previewProgress.gone()
                CustomAlertDialog().showFeatureRestrictionAlert(this)
                mediaPreviewBinding.sendMedia.isEnabled = true
                return
            }
            setTextIncludingMention(mentionedUsersIds)

            CoroutineScope(Dispatchers.IO).launch {
                val messageObject = messagingClient.composeVideoMessage(toUser, intent.getStringExtra(Constants.FILE_PATH)!!,
                    sendTextMessageWithMentionFormat.toString(), replyMessageId, mentionedUsersIds).third

                messageObject?.let {
                    messagingClient.sendMessage(it, object : MessageListener {
                        override fun onSendMessageSuccess(message: ChatMessage) {
                            mediaPreviewBinding.previewProgress.previewProgress.gone()
                            ReplyHashMap.saveReplyId(toUser, Constants.EMPTY_STRING)
                            SharedPreferenceManager.setString(
                                Constants.REPLY_MESSAGE_USER,
                                Constants.EMPTY_STRING
                            )
                            SharedPreferenceManager.setString(
                                Constants.REPLY_MESSAGE_ID,
                                Constants.EMPTY_STRING
                            )
                            viewModel.setUnSentMessageForAnUser(toUser, Constants.EMPTY_STRING)
                            FlyMessenger.saveUnsentMentionedUserId(toUser,"")
                            unSentMentionedUserIdList.clear()
                            ChatParent.startActivity(
                                this@MediaPreviewActivity,
                                toUser,
                                viewModel.profileDetails.value!!.getChatType(),true
                            )
                        }

                        override fun onSendMessageFailure(message: String) {
                            runOnUiThread {
                                mediaPreviewBinding.sendMedia.isEnabled = true
                                mediaPreviewBinding.previewProgress.previewProgress.gone()
                                if(message.isNotEmpty())
                                CustomToast.show(this@MediaPreviewActivity, message)
                            }
                        }
                    })
                }
            }


        }
        myApp?.clearMediaCaptionObject()
    }

    private fun sendGalleryAttachments(toUser: String, replyMessageId: String) {
        mediaPreviewBinding.previewProgress.previewProgress.show()
        CoroutineScope(Dispatchers.IO).launch {
            val sentMessages = arrayListOf<ChatMessage>()
            var errorMessageList = ArrayList<String>()
            for (item in selectedImageList) {
                var messageObject: MessageObject?
                if (item.isImage) {
                    if (!ChatManager.getAvailableFeatures().isImageAttachmentEnabled) {
                        mediaPreviewBinding.previewProgress.previewProgress.gone()
                        CustomAlertDialog().showFeatureRestrictionAlert(this@MediaPreviewActivity)
                        mediaPreviewBinding.sendMedia.isEnabled = true
                        break
                    }
                    messageObject = messagingClient.composeImageMessage(toUser, item.path, item.caption, replyMessageId,item.mentionedUsersIds)
                } else {
                    if (!ChatManager.getAvailableFeatures().isVideoAttachmentEnabled) {
                        mediaPreviewBinding.previewProgress.previewProgress.gone()
                        CustomAlertDialog().showFeatureRestrictionAlert(this@MediaPreviewActivity)
                        mediaPreviewBinding.sendMedia.isEnabled = true
                        break
                    }
                    messageObject = messagingClient.composeVideoMessage(toUser, item.path, item.caption, replyMessageId,item.mentionedUsersIds).third
                }
                sendGalleryAttachmentFiles(messageObject,sentMessages,toUser,errorMessageList)

            }
            FlyMessenger.saveUnsentMentionedUserId(toUser,"")
            unSentMentionedUserIdList.clear()
        }

    }

    private fun sendGalleryAttachmentFiles(
        messageObject: MessageObject?,
        sentMessages: ArrayList<ChatMessage>,
        toUser: String,
        errorMessageList: ArrayList<String>
    ) {
        messageObject?.let {
            messagingClient.sendMessage(it, object : MessageListener {
                override fun onSendMessageSuccess(message: ChatMessage) {
                    sentMessages.add(message)
                    launchChatPage(sentMessages,toUser,errorMessageList)
                }

                override fun onSendMessageFailure(message: String) {
                    if(message.isNotEmpty()) {
                        errorMessageList.add(message)
                    }
                    sentMessages.add(ChatMessage())
                    launchChatPage(sentMessages,toUser,errorMessageList)
                }
            })
        }

    }

    private fun launchChatPage(
        sentMessages: ArrayList<ChatMessage>,
        toUser: String,
        errorMessageList: ArrayList<String>
    ) {
        if (sentMessages.size == selectedImageList.size) {
            runOnUiThread {
                mediaPreviewBinding.sendMedia.isEnabled = true
                mediaPreviewBinding.previewProgress.previewProgress.gone()
                if(errorMessageList.isNotEmpty()) {
                    CustomToast.show(this@MediaPreviewActivity, errorMessageList[0])
                }
            }
            ReplyHashMap.saveReplyId(toUser, Constants.EMPTY_STRING)
            SharedPreferenceManager.setString(Constants.REPLY_MESSAGE_USER, Constants.EMPTY_STRING)
            SharedPreferenceManager.setString(Constants.REPLY_MESSAGE_ID, Constants.EMPTY_STRING)
            viewModel.setUnSentMessageForAnUser(toUser, Constants.EMPTY_STRING)
            ChatParent.startActivity(this@MediaPreviewActivity, toUser, viewModel.profileDetails.value!!.getChatType(),true)
        }
    }

    private fun removeSelectedFile() {
        if (fileObjects.size == 1) finish() else {
            fileObjects.removeAt(viewPagerPosition)
            setViewPagerAdapter()
        }
    }

    private fun removeSelectedFileFromPicker() {
        if (selectedImageList.size == 1) finish() else {
            selectedImages.removeAt(viewPagerPosition)
            selectedImageList.removeAt(viewPagerPosition)
            setMediaPickerAdapter()
            setAddMoreVisibility()
        }
    }

    private fun setAddMoreVisibility() {
        mediaPreviewBinding.groupAddMore.visibility =
            if (selectedImageList.size < Constants.MAX_MEDIA_SELECTION_RESTRICTION && !isFromCamera) View.VISIBLE else View.GONE
    }

    private fun setMediaPickerAdapter() {
        mediaPreviewAdapter.notifyDataSetChanged()
        setAdapterForViewPager()
        mediaPreviewBinding.mediaList.adapter = mediaViewPagerAdapter
        if (viewPagerPosition == 0
            || viewPagerPosition <= selectedImageList.size - 1
        ) mediaPreviewBinding.mediaList.setCurrentItem(
            viewPagerPosition,
            true
        ) else if (viewPagerPosition == selectedImageList.size) {
            viewPagerPosition -= 1
            mediaPreviewBinding.mediaList.setCurrentItem(viewPagerPosition, true)
        }
        if (selectedImageList.size == 1) viewPagerPosition = 0
        onPageSelected(viewPagerPosition)
    }

    private fun setViewPagerAdapter() {
        mediaViewPagerAdapter = MediaPreviewPagerAdapter(supportFragmentManager)
        mediaViewPagerAdapter.setFileObjectList(fileObjects)
        mediaPreviewBinding.mediaList.adapter = mediaViewPagerAdapter
        if (viewPagerPosition == 0
            || viewPagerPosition <= fileObjects.size - 1
        ) mediaPreviewBinding.mediaList.setCurrentItem(
            viewPagerPosition,
            true
        ) else if (viewPagerPosition == fileObjects.size) {
            viewPagerPosition -= 1
            mediaPreviewBinding.mediaList.setCurrentItem(viewPagerPosition, true)
        }
        if (fileObjects.size == 1) viewPagerPosition = 0
        onPageSelected(viewPagerPosition)
    }

    override fun onResume() {
        super.onResume()
        keyboardHeightProvider?.onResume()
        AppLifecycleListener.isFromQuickShareForBioMetric = true
        AppLifecycleListener.isFromQuickShareForPin = true
        handleCursorAndKeyboardVisibility()
    }

    private fun handleCursorAndKeyboardVisibility() {
        if (showChatKeyboard) {
            emojiEditText!!.requestFocus()
            val imm =
                this@MediaPreviewActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(emojiEditText!!, InputMethodManager.SHOW_IMPLICIT)
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
            showChatKeyboard = false
        } else {
            if (showingEmojiKeyboard)
                emojiEditText!!.requestFocus()
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        }
    }

    override fun onPause() {
        super.onPause()
        if (emojiEditText!!.hasFocus() && !emojiHandler!!.isEmojiShowing) {
            isResumedNotCalled = true
        }
        if (isSoftKeyboardShown) showChatKeyboard = true
    }

    override fun onDestroy() {
        super.onDestroy()
        AppLifecycleListener.isFromQuickShareForBioMetric = false
        AppLifecycleListener.isFromQuickShareForPin = false
    }

    override fun onEmojiconBackspaceClicked(v: View?) {
        EmojiconsFragment.backspace(emojiEditText!!)
    }

    override fun onEmojiconClicked(emojicon: Emojicon) {
        EmojiconsFragment.input(emojiEditText!!, emojicon)
    }

    private fun getKeyboardListener() = KeyboardHeightProvider.KeyboardListener { height ->
            val isShown = height > 0
            if (isShown == alreadyOpen) {
                return@KeyboardListener
            }
            alreadyOpen = isShown
            onKeyboardVisibilityChanged(isShown)
    }


    private fun initMentionAdapter() {
        groupTagRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        groupTagRecycler.addItemDecoration(CustomItemDecoration(this))
        groupTagRecycler.adapter = groupTagAdapter
        groupTagAdapter.submitList(emptyList())
    }

    /**
     * Group mention functionaliity
     */
    private fun initGroupMentionTag() {
        if (chat.isGroupChat()) {
            mentionViewModel.setUserJid(chat.toUser)
            mentionViewModel.getParticipantsHashMap(chat.toUser)
             bindMediaUserMention(userMentionConfig) { text  ->
                if (chat.isGroupChat() && text!=null && emojiEditText?.isFocused == true) {
                    groupTagRecycler.show()
                    mentionFilterKey = text.toString()
                    if(mentionFilterKey.isNotEmpty())
                        groupTagAdapter.filter.filter(mentionFilterKey)
                    else  mentionViewModel.getParticipantsHashMap(chat.toUser)
                } else{
                    groupTagRecycler.gone()
                }
            }
        }

        mentionViewModel.groupUsers.observe(this) {
            groupTagAdapter.submitList(it)
        }
        mentionViewModel.getSelectedRecipient().observe(this) { profile ->
            val name = Utils.returnEmptyStringIfNull(profile.getDisplayName())
            val userId = getUserFromJid(profile.jid)
            val mentionUser  = MentionUser(userId)
            mediaPreviewBinding.imageCaption.replaceText(name,mentionUser)
        }
    }

    override fun onUserTagClicked(profileDetails: ProfileDetails) {
        groupTagRecycler.layoutManager = LinearLayoutManager(this)
        groupTagRecycler.adapter = groupTagAdapter
        groupTagRecycler.itemAnimator = null
        groupTagRecycler.gone()
        mentionViewModel.onSelectionChange(profileDetails)
    }

    fun bindMediaUserMention(mentionConfig: UserMentionConfig, handler: OnMentionEventListener) {
        if (emojiEditText is MentionEditGroupText) {
            (emojiEditText as MentionEditGroupText).bindUserMention(
                mentionConfig,
                TextUIConfig.Builders().setTextColor(ContextCompat.getColor(context!!,R.color.color_blue)).build(),
                handler,
                null,
                groupTagRecycler,
                false
            )
        }
    }

    private fun setTextIncludingMention(mentionedUsersIds:MutableList<String>){
        sendTextMessageWithMentionFormat = if(mentionedUsersIds.isNotEmpty()) {
            emojiEditText?.getMentionedTemplate()
        } else {
            emojiEditText!!.text.toString().trim { it <= ' ' }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: PrivateChatAuthenticationModel?) {
        if(messageEvent!!.isAutheticationShow) {
            launchAuthPinActivity()
        }
    }

    override fun onSuperAdminDeleteGroup(groupJid: String, groupName: String) {
        super.onSuperAdminDeleteGroup(groupJid, groupName)
        clearDeletedGroupChatNotification(groupJid, context)
        if (toUser == groupJid){
            showToast(getString(R.string.deleted_by_super_admin, groupName))
            setResult(Activity.RESULT_FIRST_USER)
            startDashboardActivity()
            finish()
        }
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }

    private fun startDashboardActivity() {
        val dashboardIntent = Intent(applicationContext, DashboardActivity::class.java)
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(dashboardIntent)
    }


}