package com.contusfly.activities.parent

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ResolveInfo
import android.graphics.BitmapFactory
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.location.LocationManager
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaMetadataRetriever
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.provider.Settings
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.*
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.ContentFrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.view.WindowInsetsCompat
import androidx.emoji.widget.EmojiAppCompatTextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.*
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.models.MessageType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.activities.*
import com.contusfly.adapters.ChatAdapter
import com.contusfly.adapters.ReplySuggestionsAdapter
import com.contusfly.chat.AndroidUtils
import com.contusfly.chat.MessagingClient
import com.contusfly.chat.ReplyHashMap
import com.contusfly.chat.ReplyViewHandler
import com.contusfly.constants.MobileApplication
import com.contusfly.databinding.ActivityChatBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.helpers.MessagePaginationScrollListener
import com.contusfly.interfaces.ChatAttachmentLister
import com.contusfly.interfaces.MessageListener
import com.contusfly.mediapicker.model.Image
import com.contusfly.mediapicker.ui.MediaPickerActivity
import com.contusfly.models.*
import com.contusfly.services.NonStickyService
import com.contusfly.utils.*
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.RequestCode
import com.contusfly.utils.Utils
import com.contusfly.viewmodels.ChatParentViewModel
import com.contusfly.viewmodels.ChatViewModel
import com.contusfly.views.*
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.helpers.LocationUtils
import com.mirrorflysdk.utils.*
import com.fxn.pix.Options
import com.fxn.pix.Pix
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import dagger.android.AndroidInjection
import io.github.rockerhieu.emojicon.EmojiconEditText
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.File
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.concurrent.schedule
import kotlin.coroutines.CoroutineContext


@SuppressLint("Registered")
open class ChatParent : BaseActivity(), CoroutineScope, MessageListener,
    ChatAttachmentLister {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception ${TAG}:  ${exception.printStackTrace()}")
    }

    @Inject
    lateinit var chatViewModelFactory: AppViewModelFactory

    open val viewModel by lazy {
        ViewModelProviders.of(this, chatViewModelFactory).get(ChatViewModel::class.java)
    }

    lateinit var chat: Chat

    protected var leftUserJid = Constants.EMPTY_STRING

    protected lateinit var binding: ActivityChatBinding
    protected val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    protected var isFromForward = false
    protected var dontAllowClick = false
    protected var isReplyTagged = false
    private var isComposing = false
    private var enableEdt = true
    var isFromQuickShare = false

    protected var supportedFormats = listOf(*AppConstants.supportedFormats)

    protected var selectedOptionName: String? = null

    protected var msg: ChatMessage? = null

    /**
     * Store onclick time to avoid double click
     */
    protected var lastClickTime: Long = 0

    /**
     * Media local file path of the audio, video, image in to the sender
     */
    protected var mediaPath: String? = null

    var returnValue = java.util.ArrayList<String>()

    /**
     * The video file of the chat view to send the user
     */
    protected var videoFile: File? = null

    /**
     * Selected message id for reply
     */
    protected var selectedMessageIdForReply: String = Constants.EMPTY_STRING

    lateinit var profileDetails: ProfileDetails

    /**
     * Validate if user block/unblock option pressed
     */
    protected var isBlockUnblockCalled = false

    var isBlocked: Boolean = false

    var isAdminBlocked: Boolean = false

    var isEmailChatClicked: Boolean = false

    protected var suggestionCount = 0

    protected val PROFILE_UPDATE_TIME_OUT: Long = 10000

    /**
     * The Intent object which contains the complete class name of a service implementation to get
     * started to identify when the application is removed via the recent apps screen.
     */
    protected val stickyService: Intent by lazy { Intent(this, NonStickyService::class.java) }

    /**
     * Utils to handle the chat view operations
     */
    @Inject
    protected lateinit var chatViewUtils: ChatViewUtils

    @Inject
    lateinit var sharedPreferenceManager: SharedPreferenceManager


    private var audioCallDrawable: Drawable? = null

    private var videoCallDrawable: Drawable? = null

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    protected val commonAlertDialog: CommonAlertDialog by lazy { CommonAlertDialog(this) }

    @Inject
    protected lateinit var messagingClient: MessagingClient

    private val _messageRefreshFlow = MutableSharedFlow<Pair<String, String>>(1)
    private val messageRefreshFlow = _messageRefreshFlow.asSharedFlow()

    /**
     * Instance of the EmojiHandler to access the emoji and text keypad
     */
    protected val emojiHandler: EmojiHandler by lazy { EmojiHandler(this) }

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    /**
     * Chat utils Which has the chat related common methods
     */
    protected val chatClickUtils: ChatClickUtils by lazy { ChatClickUtils() }

    /**
     * The progress dialog to display the progress bar When the background operations has been doing
     */
    protected var doProgressDialog: DoProgressDialog? = null

    protected val replyViewHandler: ReplyViewHandler by lazy {
        ReplyViewHandler(
            this,
            replyMessageSentView
        )
    }

    var optionMenu: Menu? = null

    var menuReference: Menu? = null

    var actionMenuReference: Menu? = null

    var actionPrev: MenuItem? = null

    lateinit var toUser: String

    lateinit var messageId: String

    var isLoadNextAvailable = false

    lateinit var mobileApplication: MobileApplication

    lateinit var chatAdapter: ChatAdapter

    var lastRefreshTime: Long = 0

    lateinit var replySuggestionAdapter: ReplySuggestionsAdapter

    protected var actionModeMenu: Menu? = null

    protected var actionMode: ActionMode? = null

    private var searchedNxt = emptyString()
    private var searchedPrev = emptyString()
    protected var searchedText = emptyString()
    protected var searchEnabled = false

    protected var isAttachMenuClick = false

    /**
     * Chat type of the chat view
     */
    lateinit var chatType: String
    var isFromStarredMessages = false
    private var isFromSearchIcon = false

    protected var isViewingRecentMessage = true
    protected var canShowReceivedMessage = false

    protected var j = -1

    protected val audioRecordView: AudioRecordView by lazy { AudioRecordView(this) }

    /**
     * Layout manager for chat recyclerView
     */
    protected val mManager: LinearLayoutManager by lazy {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = false
        layoutManager.stackFromEnd = true
        layoutManager
    }

    protected val unreadMessageTypeMessageId: String by lazy { "M${chat.toUser}" }

    protected var isLoadingMessageFromDB = false

    protected val allMessageLoaded = false

    protected val mainList = ArrayList<ChatMessage>()

    private var nextUpdatingTime = 0L

    protected val messagesQueue = ArrayList<MessageObject>()

    protected var clickedMessages = ArrayList<String>()

    private val filteredPosition = ArrayList<Int>()

    protected var typingList:MutableList<String> = ArrayList()

    private val editTextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            if (p0.toString().trim().isNotEmpty()) {
                imgSend.isEnabled = true
                imgSend.show()
                imgSend.setImageResource(R.drawable.ic_send_active)
                suggestionLayout.gone()
            } else {
                imgSend.isEnabled = false
                imgSend.gone()
                imgSend.setImageResource(R.drawable.ic_send_inactive)
                if (isReplyTagged)
                    parentViewModel.addMessage(
                        parentViewModel.getMessageForId(
                            selectedMessageIdForReply
                        ), chat.toUser
                    )
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //To change body of created functions use File | Settings | File Templates.
        }
    }

    companion object {
        val TAG = ChatParent::class.java.simpleName

        /**
         * Starts activity for user/group
         *
         * @param activity  Starting activity
         * @param jid  Chat Jid
         * @param chatType Chat type
         */
        @JvmStatic
        fun startActivity(activity: Activity, jid: String, chatType: String) {
            activity.startActivity(
                Intent(activity, ChatActivity::class.java)
                    .putExtra(LibConstants.JID, jid)
                    .putExtra(Constants.CHAT_TYPE, chatType)
                    .putExtra("externalCall", true)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            )
        }
    }

    protected var firstCompletelyVisibleItemPosition: Int = 0
    protected var lastCompletelyVisibleItemPosition: Int = 0

    /**
     * Unread message count
     */
    protected var unreadMessageCount = 0

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    protected val parentViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ChatParentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        searchKeyObserver()
    }
    private val audioRecordingPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = ChatUtils.checkWritePermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val recordPermissionGranted = permissions[Manifest.permission.RECORD_AUDIO] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.RECORD_AUDIO)

        if(readPermissionGranted && recordPermissionGranted) {
            audioRecordView.startRecordClickListener()
        }
    }

    private val locationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val locationPermissionGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if(locationPermissionGranted) {
            checkLocationPermission()
        }
    }

    private val galleryPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if(readPermissionGranted) {
            selectImagesFromGallery()
        } else if(ChatUtils.checkMediaPermission(this, Manifest.permission.READ_MEDIA_IMAGES) && ChatUtils.checkMediaPermission(this, Manifest.permission.READ_MEDIA_VIDEO)){
            selectImagesFromGallery()
        }
    }

    private val filePermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if(readPermissionGranted) {
            PickFileUtils.pickFile(this)
        } else if(ChatUtils.checkMediaPermission(this, Manifest.permission.POST_NOTIFICATIONS)){
            PickFileUtils.pickFile(this)
        }
    }

    private val emailPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if(readPermissionGranted) {
            exportChatEmail()
        }
    }

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = ChatUtils.checkWritePermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val cameraPermissionGranted = permissions[Manifest.permission.CAMERA] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.CAMERA)

        if(readPermissionGranted && cameraPermissionGranted) {
            hideKeyboard()
            ChatUtils.setCameraPreviewActivity(MediaPreviewActivity::class.java, chat.toUser, chat.chatType)
            val options: Options? = Options.init()
                .setRequestCode(100)
                .setCount(Constants.MAX_MEDIA_SELECTION_RESTRICTION)
                .setOutputPath(Constants.LOCAL_PATH.uppercase(Locale.getDefault()))
                .setFrontfacing(false)
                .setPreSelectedUrls(returnValue)
                .setExcludeVideos(false)
                .setVideoDurationLimitinSeconds(Constants.VIDEO_DURATION_LIMIT)//Prefs.getString(SharedPreferenceManager.VIDEO_LIMIT).toInt())
                .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
                .setPath(Constants.LOCAL_PATH)
                .setAudioPermissionAsked(SharedPreferenceManager.getBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED))
                .setMediaClass(MediaPreviewActivity::class.java)

            options?.preSelectedUrls = returnValue
            Pix.start(this, options)
        }
    }

    private val audioSelectionPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(readPermissionGranted) {
            selectAudioFileFromStorage()
        }
    }

    private val contactPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val contactPermissionGranted = permissions[Manifest.permission.READ_CONTACTS] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_CONTACTS)

        if(contactPermissionGranted) {
            showMobileContacts()
        }
    }

    fun setUserJid() {
        parentViewModel.setUserJid(toUser)
    }

    /**
     * Recycler view object which used to display the chat view
     */
    protected val listChats by bindView<RecyclerView>(R.id.view_chat_list)

    /**
     * Edit text which used to add the message in the chat view to send the user
     */
    val chatMessageEditText by bindView<EmojiconEditText>(R.id.edit_chat_msg)

    private val chatFooter by bindView<ConstraintLayout>(R.id.view_chat_footer)
    private val chatFooterDivider by bindView<View>(R.id.chat_footer_divider)
    private val chatFooterBottomDivider by bindView<View>(R.id.chat_footer_bottom_divider)

    /**
     * Layout used to show the permission details
     */
    protected val suggestionLayout by bindView<LinearLayout>(R.id.suggestion_layout)
    protected val replySuggestionsRecycler by bindView<RecyclerView>(R.id.suggestion_recycler)
    protected val toolbar by bindView<Toolbar>(R.id.chat_toolbar)
    val imgSend by bindView<AppCompatImageView>(R.id.image_chat_send)
    protected val transparentView by bindView<View>(R.id.view_overlay)
    val attachment by bindView<ImageView>(R.id.action_attachment)
    val voiceAttachment by bindView<ImageView>(R.id.image_action_attach_voice)
    val imageViewAudio by bindView<ImageView>(R.id.imageViewAudio)
    val imageAudioRecord by bindView<ImageView>(R.id.image_audio_record)
    val layoutViewAudio by bindView<RelativeLayout>(R.id.layoutViewAudio)
    val imageAudioRecordDelete by bindView<ImageView>(R.id.image_audio_record_delete)
    val viewAudioRecordSpace by bindView<View>(R.id.view_audio_record_space)
    val textAudioRecordTimer by bindView<TextView>(R.id.text_audio_record_timer)
    val textAudioSlideToCancel by bindView<TextView>(R.id.text_audio_slide_to_cancel)
    val textAudioRecordCancel by bindView<TextView>(R.id.text_audio_record_cancel)
    val smiley by bindView<ImageView>(R.id.image_chat_smiley)
    private val layoutRedirectLastMessage by bindView<LinearLayout>(R.id.layout_redirect_message)
    protected val unreadMessageCountView by bindView<TextView>(R.id.unread_count)
    private val txtNoMsg by bindView<TextView>(R.id.text_no_msg)
    private val viewChat by bindView<LinearLayout>(R.id.view_chat)
    protected val back by bindView<LinearLayout>(R.id.view_back)
    private val userNameLayout by bindView<LinearLayout>(R.id.view_info)
    private val searchEdit by bindView<CustomEditText>(R.id.search_edit)
    protected val replyMessageSentView by bindView<View>(R.id.view_text_reply_layout)
    private val toUserImageView by bindView<AppCompatImageView>(R.id.image_user_pic)
    protected val closeReplyMessage by bindView<ImageView>(R.id.close_reply)
    protected val statusTextView by bindView<TextView>(R.id.text_last_seen)
    protected val chatXmppConnectionText by bindView<TextView>(R.id.chat_xmpp_connection_text)
    protected val chatXmppConnectionStatusLayout by bindView<RelativeLayout>(R.id.chat_xmpp_connection_status_layout)

    //Toolbar Views
    private val toolbarTitle by bindView<EmojiAppCompatTextView>(R.id.text_chat_name)

    protected val rosterObservable = PublishSubject.create<ProfileDetails>()

    protected val showHideRedirectToLatest = PublishSubject.create<Boolean>()

    protected val dialog = PublishSubject.create<String>()

    //To verify back action from toolbar
    protected var isBackPressed = false

    private val rootParentLayout by bindView<RelativeLayout>(R.id.root_view)

    private val parentContent by bindView<ContentFrameLayout>(android.R.id.content)

    private val emojiLayout by bindView<FrameLayout>(R.id.emojicons)

    var isSoftKeyboardShown: Boolean = false

    var softKeyboardHeight: Int = 0

    protected var showChatKeyboard: Boolean = false

    private lateinit var clickableSpan: ClickableSpan

    protected val attachmentDialog by lazy {
        ChatAttachmentDialog(this, attachment, chatFooterDivider, chatFooterBottomDivider, transparentView,this)
    }

    private val imm by lazy {
        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    @SuppressLint("ClickableViewAccessibility", "CheckResult")
    protected fun initViews() {
        parentContent.viewTreeObserver.addOnGlobalLayoutListener {
            val r = Rect()
            parentContent.getWindowVisibleDisplayFrame(r)
            val screenHeight = parentContent.rootView.height
            // r.bottom is the position above soft keypad or device button.
            // if keypad is shown, the r.bottom is smaller than that before.
            val keypadHeight = screenHeight - r.bottom
            showHideKeyboard(screenHeight, keypadHeight)
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        if (SharedPreferenceManager.getBoolean(Constants.SHOW_LABEL))
            netConditionalCall(
                { chatXmppConnectionStatusLayout.gone() },
                { chatXmppConnectionStatusLayout.show() })
        showViews(viewChat, imgSend)
        makeViewsGone(txtNoMsg)
        layoutRedirectLastMessage.setOnClickListener {
            if (parentViewModel.isLoadNextAvailable()) {
                messageId = Constants.EMPTY_STRING
                parentViewModel.loadInitialData(messageId)
            } else
                listChats.scrollToPosition(mainList.size - 1)
        }

        initRecyclerView()

        val infoClickDisposable =
            userNameLayout.clicks().throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe {
                hideKeyboard()
                navigateToChatProfilePage()
            }

        searchEdit.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                searchRippleView()
                searchEdit.requestFocus()
                true
            } else {
                false
            }
        }

        val editTextObservable = chatMessageEditText.textChanges()
        val searchEditObservable = searchEdit.textChanges()

        val searchDisposable = searchEditObservable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe {
                searchedText = it.toString().trim()
                if (searchEnabled) setSearch()
            }

        val goneDisposable =
            editTextObservable.debounce(2100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe {
                    sendTypingGone()
                }

        val typingDisposable =
            editTextObservable.throttleFirst(5000, TimeUnit.MILLISECONDS).distinct()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe { text ->
                    if (text.isEmpty()) {
                        sendTypingGone()
                    } else if (isComposing || enableEdt) {
                        ChatManager.sendTypingStatus(chat.toUser, chat.getChatType(), true)
                    }
                }

        val unSentDisposable = editTextObservable.skip(1).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe {
                isComposing = true
            }

        startObservingObservables()
        compositeDisposable.addAll(
            typingDisposable,
            goneDisposable,
            infoClickDisposable,
            unSentDisposable,
            searchDisposable
        )

        observeMessageRefreshListener()
    }

    private fun searchRippleView() {
        if (searchedText.isNotEmpty())
            isFromSearchIcon = true
        actionPrev?.icon = resources.getDrawable(R.drawable.ic_search_prev_ripple_arrow)
        actionPrev?.let {
            onOptionsItemSelected(it)
        }
    }

    private fun navigateToChatProfilePage() {
        if (chat.isSingleChat()) {
            launchActivity<UserInfoActivity> {
                putExtra(
                    AppConstants.PROFILE_DATA,
                    ProfileDetailsUtils.getProfileDetails(chat.toUser)
                )
            }
        } else if (chat.isGroupChat()) {
            launchActivity<GroupInfoActivity> {
                putExtra(
                    AppConstants.PROFILE_DATA,
                    ProfileDetailsUtils.getProfileDetails(chat.toUser)
                )
            }
        }
    }

    private fun showHideKeyboard(screenHeight: Int, keypadHeight: Int) {
        if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.
            if (!isSoftKeyboardShown) {
                isSoftKeyboardShown = true
                Log.d(TAG, " keyboard is opened")
                if(emojiHandler.isEmojiShowing)
                    emojiHandler.hideEmoji()
            }
        } else {
            if (isSoftKeyboardShown) {
                isSoftKeyboardShown = false
                Log.d(TAG, " keyboard is closed")
            }
        }
    }

    private fun observeMessageRefreshListener() {
        launch {
            try{
                messageRefreshFlow.buffer().collect { pair ->
                    flow {
                        emit(viewModel.getMessage(pair.first))
                    }.collect { message ->
                        message?.let {
                            try {
                                val messagePosition = getMessagePosition(message.messageId)
                                if (messagePosition.isValidIndex() && pair.second == Constants.NOTIFY_MESSAGE_STATUS_CHANGED)
                                    updateMessageStatusAndRefreshData(messagePosition, message)
                                else if (messagePosition.isValidIndex()) checkAndUpdateItemPosition(messagePosition, message)
                            } catch (e: Exception) {
                                LogMessage.e(TAG, e.message)
                            }
                        }
                    }
                }
            }catch(e:NullPointerException){
                LogMessage.e(TAG, e.message)
            }

        }
    }

    private fun checkAndUpdateItemPosition(messagePosition: Int, message: ChatMessage) {
        val firstCompletelyVisibleItemPosition = firstCompletelyVisibleItemPosition - 3
        val lastCompletelyVisibleItemPosition = lastCompletelyVisibleItemPosition + 3
        if (messagePosition in firstCompletelyVisibleItemPosition..lastCompletelyVisibleItemPosition)
            runOnUiThread {
                chatAdapter.refreshMessageAtPosition(messagePosition, message)
            }
        else
            runOnUiThread {
                chatAdapter.refreshMessage(messagePosition, message)
            }
    }

    private fun updateMessageStatusAndRefreshData(messagePosition: Int, message: ChatMessage) {
        runOnUiThread {
            chatAdapter.refreshMessage(messagePosition, message)
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_MESSAGE_STATUS_CHANGED, 1)
            chatAdapter.notifyItemChanged(messagePosition, bundle)
        }
    }

    private fun setBlockedSpannableText(): Spannable {
        val userNickName = Utils.returnEmptyStringIfNull(profileDetails.getDisplayName())
        val wordToSpan: Spannable = SpannableString("You have blocked $userNickName. Unblock")
        wordToSpan.setSpan(UnderlineSpan(), wordToSpan.length - 7, wordToSpan.length, 0)
        wordToSpan.setSpan(
            clickableSpan,
            wordToSpan.length - 7,
            wordToSpan.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        wordToSpan.setSpan(
            BackgroundColorSpan(ContextCompat.getColor(this, R.color.color_white)),
            wordToSpan.length - 7, wordToSpan.length, 0
        )
        return wordToSpan
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun initRecyclerView() {
        listChats.apply {
            layoutManager = mManager
            itemAnimator = object : DefaultItemAnimator() {
                override fun canReuseUpdatedViewHolder(viewHolder: RecyclerView.ViewHolder): Boolean {
                    return true
                }
            }
            setItemViewCacheSize(0)
            isDrawingCacheEnabled = true
            drawingCacheQuality = View.DRAWING_CACHE_QUALITY_LOW
            setScrollListener(layoutManager as LinearLayoutManager)
        }
    }

    private fun setScrollListener(
        layoutManager: LinearLayoutManager
    ) {
        listChats.addOnScrollListener(object : MessagePaginationScrollListener(layoutManager) {
            override fun loadNextItems() {
                parentViewModel.loadNextData()
            }

            override fun hasNextItems(): Boolean {
                return parentViewModel.isLoadNextAvailable()
            }
            override fun loadPreviousItems() {
                parentViewModel.loadPreviousData()
            }

            override fun hasPreviousItems(): Boolean {
                return parentViewModel.isLoadPreviousAvailable()
            }

            override fun isFetching(): Boolean {
                return parentViewModel.getFetchingIsInProgress()
            }
        })
    }

    protected fun setCallButtonVisibility() {
        audioCallDrawable = this.drawable(R.drawable.ic_call_log_voice_call)
        videoCallDrawable = this.drawable(R.drawable.ic_call_log_video_call)
        optionMenu?.let {
            when {
                (profileDetails.isBlocked || profileDetails.isAdminBlocked || profileDetails.isDeletedContact()) -> {
                    audioCallDrawable?.mutate()?.applySrcInColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.call_icon_disabled_color
                        )
                    )
                    videoCallDrawable?.mutate()?.applySrcInColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.call_icon_disabled_color
                        )
                    )
                    it.get(R.id.action_audio_call).icon = audioCallDrawable
                    it.get(R.id.action_video_call).icon = videoCallDrawable
                    it.get(R.id.action_audio_call).isEnabled = false
                    it.get(R.id.action_video_call).isEnabled = false
                }
                else -> {
                    it.get(R.id.action_audio_call).icon = audioCallDrawable
                    it.get(R.id.action_video_call).icon = videoCallDrawable
                    it.get(R.id.action_audio_call).isEnabled = true
                    it.get(R.id.action_video_call).isEnabled = true
                }
            }
            if (chatType == ChatType.TYPE_CHAT) {
                it.get(R.id.action_audio_call).isVisible = ChatManager.getAvailableFeatures().isOneToOneCallEnabled
                it.get(R.id.action_video_call).setVisible(ChatManager.getAvailableFeatures().isOneToOneCallEnabled)
            } else {
                it.get(R.id.action_audio_call).isVisible = ChatManager.getAvailableFeatures().isGroupCallEnabled
                it.get(R.id.action_video_call).setVisible(ChatManager.getAvailableFeatures().isGroupCallEnabled)
            }
        }
    }

    private fun setEditTextListener() {
        binding.viewChatFooter.editChatMsg.addTextChangedListener(editTextWatcher)
        binding.viewChatFooter.editChatMsg.setOnTouchListener { _, _ ->
            if (attachmentDialog.isShowing)
                closeControls()
            false
        }
    }

    protected fun sendTypingGone() {
        ChatManager.sendTypingGoneStatus(chat.toUser, chat.getChatType(), true )
    }

    protected fun startStickyService() {
        startService(stickyService)
    }

    fun onAttachMenuClick() {
        // Checks the chat type and validates if user presents in group or users exists in
        // broadcast list if chat type is group or broadcast
        if (ChatType.TYPE_GROUP_CHAT == chat.chatType) {
            if (parentViewModel.isGroupUserExist(
                    chat.toUser,
                    SharedPreferenceManager.getCurrentUserJid()
                )
            )
                handleAttachMenu()
        } else
            handleAttachMenu()
    }

    /**
     * Handles attach menu click. Closes attach controls if opens else closes
     */
    private fun handleAttachMenu() {
        // Check the user busy status while user selecting attach menu option
        if (FlyCore.isBusyStatusEnabled() && ChatType.TYPE_CHAT == chat.chatType){
            isAttachMenuClick = true
            showBusyAlert()
        }
        else if (isBlocked)
            showBlockedAlertAttachment()
        else {
            if (attachmentDialog.isShowing)
                closeControls()
            else {
                openControls()
            }
        }
    }

    fun closeControls() {
        if (isReplyTagged)
            parentViewModel.addMessage(
                parentViewModel.getMessageForId(selectedMessageIdForReply),
                chat.toUser
            )
        else
            addMessagesforSmartReply()
    }

    private fun openControls() {
        val height = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            windowManager.currentWindowMetrics.bounds.height()
        } else {
            resources.displayMetrics.heightPixels
        }
        // Real size of the screen (full screen)
        val realSize = Point()
        val realDisplay = windowManager.defaultDisplay
        realDisplay.getRealSize(realSize)

        val finalHeight = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val view = window.decorView
            val insets = WindowInsetsCompat.toWindowInsetsCompat(view.rootWindowInsets, view).getInsets(WindowInsetsCompat.Type.systemBars())
            if (realSize.y - insets.bottom == height || realSize.y == height) {
                height
            } else
                height + insets.top // Add Status bar height
        } else {
            if (realSize.y - AndroidUtils.getNavBarHeight(this) == height || realSize.y == height) {
                height
            } else
                height + AndroidUtils.getStatusBarHeight(this)  // Add Status bar height
        }

        attachmentDialog.showDialog(isSoftKeyboardShown || emojiHandler.isEmojiShowing,
            finalHeight)
    }

    protected fun setUserProfileAndStatus() {
        toolbarTitle.viewTreeObserver?.addOnGlobalLayoutListener {
            ChatMessageUtils.fixEmojiAfterEllipses(
                toolbarTitle
            )
        }
        profileDetails.let { userRoster ->
            toolbarTitle.text = userRoster.getDisplayName()
            setChatStatus()
        }
    }

    protected fun isProfileObjectInitialized(): Boolean {
        return ::profileDetails.isInitialized
    }

    protected fun setUserProfileImage() {
        if (isProfileObjectInitialized()) {
            if(profileDetails.isGroupProfile) {
            val isNewlyCreated = SharedPreferenceManager.getBoolean(Constants.NEWLY_CREATED_GROUP)
            val newlyCreatedJid = SharedPreferenceManager.getString(Constants.NEW_GROUP_JID)
            val imageBitmap = SharedPreferenceManager.getString(Constants.NEW_GROUP_IMAGE)
            if (profileDetails.image.isNotEmpty() && newlyCreatedJid.isNotEmpty() && imageBitmap.isNotEmpty() && isNewlyCreated && profileDetails.jid.equals(newlyCreatedJid)) {
                toUserImageView.setImageDrawable(
                    context?.let {
                        ContextCompat.getDrawable(
                            it,
                            R.drawable.ic_grp_bg
                        )
                    }!!
                )
                try {
                    val imageAsBytes: ByteArray =
                        android.util.Base64.decode(imageBitmap, android.util.Base64.DEFAULT)
                    val image =
                        BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
                    toUserImageView.setImageBitmap(image)
                    val drawable: Drawable = BitmapDrawable(context!!.resources, image)
                    toUserImageView.setImageDrawable(drawable)
                    MediaUtils.loadImage(
                        context!!,
                        profileDetails.image,
                        toUserImageView,
                        drawable
                    )
                } catch (e: IOException) {
                    LogMessage.e("ProfileDialogFragment", e)
                }
            } else
                this.let { toUserImageView.loadUserProfileImage(it, profileDetails) }
        } else
                this.let { toUserImageView.loadUserProfileImage(it, profileDetails) }
        }
    }

    protected fun setChatStatus() {
        if (chat.isSingleChat()) {
            if (profileDetails.isDeletedContact()) {
                chatViewUtils.setUserPresenceStatus(this, Constants.EMPTY_STRING)
                return
            }
            netConditionalCall({
                launch(exceptionHandler) {
                    ContactManager.getRegisteredUserLastSeenTime(
                        chat.toUser,
                        object : ContactManager.LastSeenListener {
                            override fun onFailure(message: String) {
                                /* No Implementation Needed */
                            }

                            override fun onSuccess(lastSeenTime: String) {
                                setUserPresenceStatus(ChatUtils.getLastSeenTime(this@ChatParent,lastSeenTime))
                            }
                        })
                }
            }, {
                chatViewUtils.setUserPresenceStatus(this, Constants.EMPTY_STRING)
            })
        } else {
            if(typingList.size > 0){
                chatViewUtils.setUserPresenceStatus(this,
                "${Chat(toUser = typingList[typingList.size -1]).getUsername()} ${resources.getString(R.string.msg_typing)}")
                }else {
                    parentViewModel.getParticipantsNameAsCsv(chat.toUser)
                }
        }
    }

    protected fun setUnsentMessageForAnUser(text: String) {
        parentViewModel.setUnSentMessageForAnUser(chat.toUser, text.trim())
    }

    fun isUserCanSendMessage(): Boolean {
        return if (chat.isGroupChat()) {
            parentViewModel.isGroupUserExist(chat.toUser, chat.getMyJid())
        } else {
            true
        }
    }

    /**
     * Called when Xmpp tcp connections successfully initiated.
     */
    override fun connectionSuccess() {
        chatXmppConnectionStatusLayout.gone()
    }

    override fun userCameOnline(jid: String) {
        super.userCameOnline(jid)
        if (chat.toUser == jid || (chat.isSingleChat() && jid.isNullOrBlank()))
            getUserLastActivity()
    }

    override fun userWentOffline(jid: String) {
        super.userWentOffline(jid)
        if (chat.toUser == jid || (chat.isSingleChat() && jid.isNullOrBlank()))
            getUserLastActivity()
    }

    /**
     * Displays the presence status of the chat user in the [android.app.ActionBar]
     * of the current activity. Shows online if the user presence is available,
     * otherwise displays the user's last seen time.
     *
     * @param status   The status of the chat user to be displayed.
     */
    open fun setUserPresenceStatus(status: String) {
        when {
            status.isNotEmpty() -> {
                statusTextView.text = status
                statusTextView.show()
            }
            else -> statusTextView.gone()
        }
        statusTextView.isSelected = true
    }

    /**
     * Show unsent message on editor
     *
     * @param unsentMessage Unsent message
     */
    protected fun showUnsentMessage(unsentMessage: String) {
        if (unsentMessage.isNotEmpty() && unsentMessage != null) {
            enableEdt = false
            binding.viewChatFooter.editChatMsg.setText(unsentMessage)
            imgSend.setImageResource(R.drawable.ic_send_active)
            imgSend.show()
            if (showChatKeyboard)
                showChatKeyboard = false
        } else {
            binding.viewChatFooter.editChatMsg.setText(Constants.EMPTY_STRING)
            imgSend.gone()
            imgSend.setImageResource(R.drawable.ic_send_inactive)
        }
        if (selectedMessageIdForReply.isNotEmpty()) {
            showViews(replyMessageSentView, closeReplyMessage)
            replyViewHandler.showReplyMessageToSend(
                selectedMessageIdForReply, parentViewModel,
                suggestionLayout, chat.toUser
            )
        } else
            resetReplyMessageView()
        setEditTextListener()
    }

    private fun getUserLastActivity() {
        netConditionalCall({
            getUserLastActivityWithDelay()
        }, {
            chatViewUtils.setUserPresenceStatus(this, Constants.EMPTY_STRING)
        })
    }

    /**
     * Last seen time returns as seconds.So try to get getLastActivity as one sec delay if status view not empty
     */
    private fun getUserLastActivityWithDelay() {
        if (statusTextView.text.isEmpty()) {
            if (isProfileObjectInitialized() && profileDetails.isDeletedContact()) {
                chatViewUtils.setUserPresenceStatus(this, Constants.EMPTY_STRING)
                return
            }
            launch(exceptionHandler) {
                ContactManager.getRegisteredUserLastSeenTime(
                    chat.toUser,
                    object : ContactManager.LastSeenListener {
                        override fun onFailure(message: String) {
                            chatViewUtils.setUserPresenceStatus(
                                activity!! as AppCompatActivity,
                                Constants.EMPTY_STRING
                            )
                        }

                        override fun onSuccess(lastSeenTime: String) {
                            setUserPresenceStatus(ChatUtils.getLastSeenTime(this@ChatParent,lastSeenTime))
                        }
                    })
            }
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                launch(exceptionHandler) {
                    ContactManager.getRegisteredUserLastSeenTime(
                        chat.toUser,
                        object : ContactManager.LastSeenListener {
                            override fun onFailure(message: String) {
                                chatViewUtils.setUserPresenceStatus(
                                    activity!! as AppCompatActivity,
                                    Constants.EMPTY_STRING
                                )
                            }

                            override fun onSuccess(lastSeenTime: String) {
                                setUserPresenceStatus(ChatUtils.getLastSeenTime(this@ChatParent,lastSeenTime))
                            }
                        })
                }
            }, 1000)
        }
    }

    /**
     * Dismiss the progress if showing
     */
    protected fun dismissProgress() {
        if (doProgressDialog != null && doProgressDialog!!.isShowing) doProgressDialog!!.dismiss()
    }

    /**
     * Hide the soft keyboard if opened while user interact with chat screen
     */
    protected fun hideKeyboard() {
        val view: View? = currentFocus
        view?.let {
            Utils.hideSoftInput(this, view)
        }
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(chatMessageEditText.windowToken, 0)
    }

    /**
     * Set the action menu for the long press menu
     *
     * @param mode    Instance of the Alert dialog action mode
     * @param menu    Instance of Menu
     * @return Menu Configured action menu
     */
    protected fun configureMenuActionMode(mode: ActionMode, menu: Menu): Menu {
        mode.menuInflater.inflate(R.menu.menu_chat_toolbar_items, menu)
        menu.get(R.id.action_reply).show()
        menu.get(R.id.action_forward).show()
        menu.get(R.id.action_delete).show()
        menu.get(R.id.action_favourite).show()
        menu.get(R.id.action_unfavourite).show()
        menu.get(R.id.action_reply).action(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu.get(R.id.action_delete).action(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu.get(R.id.action_forward).action(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu.get(R.id.action_favourite).action(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu.get(R.id.action_unfavourite).action(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu.get(R.id.action_pin).hide()
        menu.get(R.id.action_un_pin).hide()
        menu.get(R.id.action_mute).hide()
        menu.get(R.id.action_unmute).hide()
        menu.get(R.id.action_mark_as_read).hide()
        menu.get(R.id.action_mark_as_unread).hide()
        menu.get(R.id.action_archive_chat).hide()
        menu.get(R.id.action_pin).action(MenuItem.SHOW_AS_ACTION_NEVER)
        menu.get(R.id.action_un_pin).action(MenuItem.SHOW_AS_ACTION_NEVER)
        actionMenuReference=menu
        return menu
    }

    private fun handleActionMode() {
        actionMode?.let {
            it.title = "${clickedMessages.size}"
            actionModeMenu?.let { menu ->
                var features=ChatManager.getAvailableFeatures()
                val menuHashMap = parentViewModel.handleActionMenuVisibility(clickedMessages)
                val isSingleMessage = clickedMessages.size == 1
                if (menuHashMap[Constants.RECALL]!!) {
                    hideMenu(
                        menu.get(R.id.action_info),
                        menu.get(R.id.action_share),
                        menu.get(R.id.action_forward),
                        menu.get(R.id.action_reply),
                        menu.get(R.id.action_copy),
                        menu.get(R.id.action_favourite),
                        menu.get(R.id.action_unfavourite),
                        menu.get(R.id.action_pin),
                        menu.get(R.id.action_un_pin)
                    )
                    updateMenuIcons(menu,true,features,isSingleMessage,menuHashMap)

                } else {

                    menu.get(R.id.action_delete).isVisible = menuHashMap[Constants.DELETE]!!
                    menu.get(R.id.action_reply).isVisible = menuHashMap[Constants.REPLY]!!
                    menu.get(R.id.action_favourite).isVisible = menuHashMap[Constants.STAR]!!
                    menu.get(R.id.action_unfavourite).isVisible = menuHashMap[Constants.UNSTAR]!!
                    menu.get(R.id.action_share).isVisible = menuHashMap[Constants.SHARE]!!
                    menu.get(R.id.action_forward).isVisible = menuHashMap[Constants.FORWARD]!!
                    menu.get(R.id.action_add_chat_shortcuts).isVisible = false
                    if (isSingleMessage) {
                        menu.get(R.id.action_copy).isVisible = true
                        menu.get(R.id.action_report).isVisible = menuHashMap[Constants.REPORT]!!
                        if (menuHashMap[Constants.INFO]!!)  menu.get(R.id.action_info).isVisible = true
                    } else {
                        menu.get(R.id.action_info).isVisible = false
                        menu.get(R.id.action_copy).isVisible = false
                        menu.get(R.id.action_report).isVisible = false
                    }

                    updateMenuIcons(menu,false,features,isSingleMessage,menuHashMap)
                }

            }

        }
    }

    private fun updateMenuIcons(
        actionModeMenu: Menu,
        isRecall: Boolean,
        features: Features,
        isSingleMessage: Boolean,
        menuHashMap: HashMap<String, Boolean>
    ) {

        actionModeMenu?.let { menu ->

            if (features.isReportEnabled){
                if (isSingleMessage) {
                    menu.get(R.id.action_report).isVisible = menuHashMap[Constants.REPORT]!!
                } else {
                    menu.get(R.id.action_report).isVisible = false
                }
            } else {
                hideMenu(menu.get(R.id.action_report))
            }

            if (features.isDeleteMessageEnabled){
                menu.get(R.id.action_delete).isVisible = menuHashMap[Constants.DELETE]!!
            } else {
                hideMenu(menu.get(R.id.action_delete))
            }

            if(isRecall)
                return

            if (features.isStarMessageEnabled){
                menu.get(R.id.action_favourite).isVisible = menuHashMap[Constants.STAR]!!
                menu.get(R.id.action_unfavourite).isVisible = menuHashMap[Constants.UNSTAR]!!
            } else {
                hideMenu(menu.get(R.id.action_favourite))
                hideMenu(menu.get(R.id.action_unfavourite))
            }

        }
    }

    /**
     * handling the camera result
     */
    protected fun handleTakePhotoFromCameraIntentResult() {
        try {
            val uri =
                FileProvider.getUriForFile(this, ChatManager.fileProviderAuthority, File(mediaPath))
            revokeUriPermission(
                uri,
                Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
            val images = ArrayList<Image>()
            images.add(Image(0, mediaPath, 0, true))
            hideKeyboard()
            launchActivity<MediaPreviewActivity> {
                putExtra(Constants.SELECTED_IMAGES, images)
                putExtra(Constants.USER_JID, chat.toUser)
                putExtra(Constants.IS_IMAGE, true)
                putExtra("from_camera", true)
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    protected fun smartReplyForPreviousMessage() {
        if (mainList.isEmpty())
            parentViewModel.clearSuggestions()
        else
            addMessagesforSmartReply()
    }

    /**
     * Used to show suggestion after clear except starred message
     * suggestion will provide for last starred message
     */
    protected fun showSmartReplyAfterClearExceptStarred() {
        addMessagesforSmartReply()
    }

    /**
     * Alert dialog whether to unblock or cancel to continue sending messages...
     */
    protected fun showBlockedAlert() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.UNBLOCK
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_unblock), getString(R.string.action_unblock),
            getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    /**
     * Dialog action to show whether the busy status to be enabled or disabled...
     */
    protected fun showBusyAlert() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.STATUS_BUSY
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_disable_busy_status), getString(R.string.action_yes),
            getString(R.string.action_no), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    protected fun showForwardBusyAlert() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.FORWARD_STATUS_BUSY
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_disable_busy_status), getString(R.string.action_yes),
            getString(R.string.action_no), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    protected fun showBusyAlertKeyboard() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.STATUS_BUSY_KEYBOARD
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_disable_busy_status), getString(R.string.action_yes),
            getString(R.string.action_no), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    protected fun showBusyAlertEmoji() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.STATUS_BUSY_EMOJI
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_disable_busy_status), getString(R.string.action_yes),
            getString(R.string.action_no), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    open fun showBlockedAlertAttachment() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.UNBLOCK
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_unblockAttachment), getString(R.string.action_unblock),
            getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    open fun showBlockedAlertAudioMessage() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.UNBLOCK
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_unblockAudioMessage), getString(R.string.action_unblock),
            getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    protected fun showSmartReplyBusy() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.SMART_REPLY_BUSY
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_disable_busy_status), getString(R.string.action_yes),
            getString(R.string.action_no), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, true
        )
    }

    protected fun showSmartReplyUnblock() {
        commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.SMART_REPLY_UNBLOCK
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_unblock), getString(R.string.action_unblock),
            getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, true
        )
    }

    protected fun showBlockUserDialog(isBlock: Boolean) {
        if(!ChatManager.getAvailableFeatures().isBlockEnabled){
            context!!.showToast(resources.getString(R.string.fly_error_forbidden_exception))
            isBlockUnblockCalled=false
            return
        }
        if (isBlock) commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.BLOCK
        else commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.UNBLOCK
        netConditionalCall({
            commonAlertDialog.showAlertDialog(
                (if (profileDetails.isBlocked) getString(R.string.action_unblock)
                else getString(R.string.action_block)) + " " + getUserNickname()
                        + " ?",
                if (profileDetails.isBlocked) getString(R.string.action_unblock)
                else getString(R.string.action_block), getString(R.string.action_cancel),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
            )
        }, { showErrorMessage() })
    }

    protected fun getUserNickname(): String {
        return Utils.returnEmptyStringIfNull(profileDetails.getDisplayName())
    }

    private fun showErrorMessage() {
        showToast(
            if (checkInternetConnection()) getString(R.string.something_went_wrong) else getString(
                R.string.msg_no_internet
            )
        )
    }

    private fun checkInternetConnection(): Boolean {
        return (AppUtils.isNetConnected(this))
    }

    /**
     * Show the dialog for wrong audio file extension
     */
    protected fun showAudioFileValidation() {
        commonAlertDialog.showAlertDialog(
            getString(R.string.text_audio_wrong_extension), Constants.EMPTY_STRING,
            getString(R.string.action_Ok), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    /**
     * This method prepage a video to be sent to the user. It has restirctions in seconds...
     *
     * @param filePath - Path of the video to be stored in app directory
     */
    protected fun validateAndPreviewVideo(filePath: String?) {
        try {
            val retriever = MediaMetadataRetriever()
            retriever.setDataSource(filePath)
            videoFile = null
            val duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)!!
                .toLong() / 1000
            val videoDuration =
                Constants.VIDEO_DURATION_LIMIT.toLong()//sharedPreferenceManager.getString(Constants.VIDEO_LIMIT).toLong()
            dismissProgress()
            if (duration == videoDuration)
                Toast.makeText(
                    this,
                    "Max limit for video recording is $videoDuration secs",
                    Toast.LENGTH_LONG
                ).show()
            if (duration <= videoDuration) {
                LogMessage.v("file video path", filePath)
                hideKeyboard()
                launchActivity<MediaPreviewActivity> {
                    putExtra(Constants.FILE_PATH, filePath)
                    putExtra(Constants.USER_JID, toUser)
                    putExtra(Constants.IS_IMAGE, false)
                    putExtra("from_camera", true)
                }
            } else
                showAudioVideoDurationValidationDialog(
                    videoDuration.toString(),
                    Constants.MSG_TYPE_VIDEO
                )
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    protected fun showAudioVideoDurationValidationDialog(duration: String, type: String) {
        val message: String = if (type == Constants.MSG_TYPE_VIDEO)
            String.format(getString(R.string.video_upload), duration)
        else
            String.format(getString(R.string.audio_upload), duration)
        commonAlertDialog.showAlertDialog(
            message, Constants.EMPTY_STRING, getString(R.string.action_Ok),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    /**
     * Show the upload alert message
     *
     * @param maxSize Size of the Media
     */
    protected fun showUploadAlert(maxSize: Int) {
        val message: String = String.format(getString(R.string.media_max_limit_restriction), maxSize)
        commonAlertDialog.showAlertDialog(
            message, Constants.EMPTY_STRING, getString(R.string.action_Ok),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    /**
     * Show the dialog for wrong file extension
     */
    protected fun showFileValidation() {
        commonAlertDialog.showAlertDialog(
            getString(R.string.text_wrong_extension),
            Constants.EMPTY_STRING,
            getString(R.string.action_Ok),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
            false
        )
    }

    /**
     * Show the dialog for drive file cannot Upload without Internet
     */
    protected fun showDriveFileValidation() {
        commonAlertDialog.showAlertDialog(
            getString(R.string.msg_no_internet),
            Constants.EMPTY_STRING,
            getString(R.string.action_Ok),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
            false
        )
    }

    /**
     * Handling of network lowbandwidth while media uploading
     *
     * @param upStreamSpeed speed of data
     * @param sourceSize    source file size
     * @param remainingSize remaining size to upload
     */
    override fun upstreamCheck(upStreamSpeed: Double, sourceSize: Long, remainingSize: Long) {
        if (nextUpdatingTime == 0L || nextUpdatingTime < System.currentTimeMillis()) {
            nextUpdatingTime = System.currentTimeMillis() + 3000
            checkConnectivityStatus(upStreamSpeed, sourceSize, remainingSize)
        }
    }

    /**
     * This method is used to update the UI when internet bandwidth is less than 100kpbs
     *
     * @param upStreamSpeed speed of data
     * @param sourceSize    source file size
     * @param remainingSize remaining size to upload
     */
    open fun checkConnectivityStatus(upStreamSpeed: Double, sourceSize: Long, remainingSize: Long) {
        com.contusfly.utils.LogMessage.d(TAG, "upstream checkConnectivityStatus$upStreamSpeed")
        if (AppUtils.isNetConnected(this) && (SharedPreferenceManager.getBoolean(Constants.SHOW_LABEL))) {
            if (!(sourceSize == remainingSize || remainingSize == 0L) && upStreamSpeed < 100000) {
                /**
                 * 100000 Bytes = 100 Kilobyte
                 */
                chatXmppConnectionStatusLayout.show()
                chatXmppConnectionText.text = getString(R.string.poor_network_connection)
            } else
                chatXmppConnectionStatusLayout.gone()
        } else
            chatXmppConnectionText.text = getString(R.string.msg_no_internet)
    }

    /**
     * Reset the message id for reply
     */
    protected fun resetReplyMessageView(replyTagClose:Boolean = false) {
        isReplyTagged = false
        replyMessageSentView.gone()
        selectedMessageIdForReply = emptyString()
        if(replyTagClose)
            parentViewModel.clearSuggestions()
        else
            selectedMessageIdForReply = Constants.EMPTY_STRING
        addMessagesforSmartReply()
        ReplyHashMap.saveReplyId(chat.toUser, Constants.EMPTY_STRING)
        SharedPreferenceManager.setString(Constants.REPLY_MESSAGE_USER, Constants.EMPTY_STRING)
        SharedPreferenceManager.setString(Constants.REPLY_MESSAGE_ID, Constants.EMPTY_STRING)
    }

    override fun onSendMessageSuccess(message: ChatMessage) {
        if(isLoadNextAvailable) {
            messageId = Constants.EMPTY_STRING
            parentViewModel.loadInitialData(messageId)
        } else {
            if (!parentViewModel.getFetchingIsInProgress())
                parentViewModel.loadNextData()
        }
        handleUnreadMessageSeparator(true)
        Handler(Looper.getMainLooper()).postDelayed({
            resetReplyMessageView()
            addMessagesforSmartReply()
            listChats.scrollToPosition(mainList.size - 1) }, 100)
    }

    /**
     * check the camera permission
     */
    open fun cameraSelection(isFromChatFooter: Boolean) {
        if (isFromChatFooter && attachmentDialog.isShowing) {
            closeControls()
            return
        }

        if (!CallManager.isOnGoingCall()) {
            if (isPermissionsAllowed(Manifest.permission.CAMERA) && MediaPermissions.isWriteFilePermissionAllowed(this)) {
                hideKeyboard()
                ChatUtils.setCameraPreviewActivity(MediaPreviewActivity::class.java, chat.toUser, chat.chatType)
                val options: Options? = Options.init()
                    .setRequestCode(100)
                    .setCount(Constants.MAX_MEDIA_SELECTION_RESTRICTION)
                    .setOutputPath(Constants.LOCAL_PATH.toUpperCase(Locale.getDefault()))
                    .setFrontfacing(false)
                    .setPreSelectedUrls(returnValue)
                    .setExcludeVideos(false)
                    .setVideoDurationLimitinSeconds(Constants.VIDEO_DURATION_LIMIT)//Prefs.getString(SharedPreferenceManager.VIDEO_LIMIT).toInt())
                    .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
                    .setPath(Constants.LOCAL_PATH)
                    .setAudioPermissionAsked(SharedPreferenceManager.getBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED))
                    .setMediaClass(MediaPreviewActivity::class.java)


                options?.preSelectedUrls = returnValue
                Pix.start(this, options)
            } else
                MediaPermissions.requestCameraStoragePermissions(this, permissionAlertDialog, cameraPermissionLauncher)
            closeControls()
        } else
            vibrateWithToast(getString(R.string.warning_camera_restriction_message))
    }

    private fun vibrateWithToast(vibrateMessage: String) {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        // Vibrate for 65 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(60, VibrationEffect.DEFAULT_AMPLITUDE))
            Toast.makeText(this, vibrateMessage, Toast.LENGTH_SHORT).show()
        } else {
            //deprecated in API 26
            vibrator.vibrate(60)
            Toast.makeText(this, vibrateMessage, Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Choose file to upload share
     *
     * @param v View of selected floating button
     */
    protected open fun chooseFileToUpload() {
        hideKeyboard()
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            if (MediaPermissions.isReadFilePermissionAllowed(this)
                && MediaPermissions.isWriteFilePermissionAllowed(this)
            )
                PickFileUtils.pickFile(this)
            else
                MediaPermissions.requestStorageAccess(
                    this,
                    permissionAlertDialog,
                    filePermissionLauncher
                )
            closeControls()
        } else {
            if (ChatUtils.checkMediaPermission(this, Manifest.permission.POST_NOTIFICATIONS)) {
                PickFileUtils.pickFile(this)
            } else {
                MediaPermissions.requestNotificationPermission(
                    this,
                    permissionAlertDialog,
                    filePermissionLauncher)
                closeControls()
            }
        }
    }

    /**
     * check the audio permission
     */
    open fun audioFileSelection() {
        hideKeyboard()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            if (MediaPermissions.isReadFilePermissionAllowed(this)
                && MediaPermissions.isWriteFilePermissionAllowed(this)
            ) {
                selectAudioFileFromStorage()
            } else
                MediaPermissions.requestStorageAccess(
                    this,
                    permissionAlertDialog,
                    audioSelectionPermissionLauncher
                )
            closeControls()
        } else {
            selectAudioFileFromStorage()
        }
    }

    /**
     * contact permission
     */
    open fun contactSelection() {
        hideKeyboard()
        if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS))
            showMobileContacts()
        else
            MediaPermissions.requestContactsReadPermission(this, permissionAlertDialog, contactPermissionLauncher, null)
        closeControls()
    }


    /**
     * Show mobile contacts to pick it and send the contact to the receiver.
     */
    open fun showMobileContacts() {
        startActivity(Intent(applicationContext, ContactSelectionActivity::class.java)
            .putExtra(Constants.USER_JID, chat.toUser)
            .putExtra(Constants.TYPE, chat.chatType))
    }

    private fun selectAudioFileFromStorage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI)
        val audioListIntent = Intent(Intent.ACTION_GET_CONTENT)
        audioListIntent.type = "audio/*"
        val audioPickerApps: List<ResolveInfo> = packageManager.queryIntentActivities(audioListIntent, 0)
        when {
            intent.resolveActivity(this.applicationContext.packageManager) != null -> {
                startActivityForResult(intent, RequestCode.FROM_GALLERY)
                /* setting isActivityStartedForResult to true to avoid xmpp disconnection*/
                ChatManager.isActivityStartedForResult = true
            }
            audioPickerApps.isNotEmpty() -> {
                val audioIntent = Intent(Intent.ACTION_GET_CONTENT)
                audioIntent.setDataAndType(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    "audio/*"
                )
                startActivityForResult(audioIntent, RequestCode.FROM_GALLERY)
            }
            else -> showToast("No suitable app found!")
        }
    }

    open fun gallerySelection() {
        hideKeyboard()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            if (ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                && ChatUtils.checkWritePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            ) {
                selectImagesFromGallery()
            } else
                MediaPermissions.requestStorageAccess(
                    this,
                    permissionAlertDialog,
                    galleryPermissionLauncher
                )
            closeControls()
        } else {
            if (ChatUtils.checkMediaPermission(this, Manifest.permission.READ_MEDIA_IMAGES)
                && ChatUtils.checkWritePermission(this, Manifest.permission.READ_MEDIA_VIDEO)) {
                selectImagesFromGallery()
            } else {
                MediaPermissions.requestMediaFiles(
                    this,
                    permissionAlertDialog,
                    galleryPermissionLauncher)
                closeControls()
            }
        }
    }



    private fun locationSelection() {
        checkInternetAndExecute {
            hideKeyboard()
            if (MediaPermissions.isLocationPermissionAllowed(this)) {
                checkLocationPermission()
            } else
                MediaPermissions.requestLocationPermission(this, permissionAlertDialog, locationPermissionLauncher)
        }
        closeControls()
    }

    /**
     * Check LocationMessage Permission if not available display it to enable in the alert view.
     */
    open fun checkLocationPermission() {
        val locationUtils = LocationUtils()
        val manager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                && manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            if (locationUtils.isGoogleMapsInstalled(this)) {
                startActivityForResult(Intent(this, SelectMapViewActivity::class.java), RequestCode.SELECT_MAP_REQ_CODE)
            } else {
                val mBuilder = AlertDialog.Builder(this)
                mBuilder.setMessage(getString(R.string.msg_map_disabled))
                mBuilder.setPositiveButton(getString(R.string.action_enable)) { dialog: DialogInterface, _: Int ->
                    dialog.dismiss()
                    locationUtils.redirectMapSettings(this)
                }
                mBuilder.setNegativeButton(getString(R.string.action_cancel)) { dialog: DialogInterface, _: Int -> dialog.dismiss() }
                val dialog = mBuilder.create()
                dialog.setCancelable(false)
                dialog.show()
            }
        } else
            showLocationAlert(this)
    }

    private fun showLocationAlert(context: Context) {
        try {
            val mBuilder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
            mBuilder.setMessage(context.getString(R.string.fly_info_msg_location_disabled))
            mBuilder.setPositiveButton(context.getString(R.string.fly_info_action_enable)) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                val myIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                context.startActivity(myIntent)
            }
            mBuilder.setNegativeButton(context.getString(R.string.fly_action_cancel)) { dialog: DialogInterface, _: Int -> dialog.dismiss() }
            val dialog = mBuilder.create()
            dialog.setCancelable(false)
            dialog.show()
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Select the images form gallery for preview and to send
     */
    protected fun selectImagesFromGallery() {
        ChatUtils.setPreviewActivity(MediaPreviewActivity::class.java, chat.toUser, chat.chatType)
        val intent = Intent(this, MediaPickerActivity::class.java)
        intent.putExtra(AppConstants.SEND_TO, chat.getUsername())
        intent.putExtra(AppConstants.IMAGE_CAN_SHOW, ChatManager.getAvailableFeatures().isImageAttachmentEnabled)
        intent.putExtra(AppConstants.VIDEO_CAN_SHOW, ChatManager.getAvailableFeatures().isVideoAttachmentEnabled)
        intent.putExtra(AppConstants.MAX_MEDIA_SELECTION_RESTRICTION, Constants.MAX_MEDIA_SELECTION_RESTRICTION)
        startActivity(intent)
    }

    private fun startObservingObservables() {
        val redirectDisposable = showHideRedirectToLatest.throttleFirst(5, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe { show ->
                Log.d("RXJAVA", "$show")
                if (show) {
                    isViewingRecentMessage = false
                    layoutRedirectLastMessage.show()
                    if (unreadMessageCount > 0) {
                        val layoutManager = listChats.layoutManager as LinearLayoutManager
                        val lastVisiblePosition = layoutManager.findLastCompletelyVisibleItemPosition()
                        unreadMessageCountView.show()
                        unreadMessageCountView.text = unreadMessageCount.toString()
                        if((mainList.size - lastVisiblePosition - 1) < unreadMessageCount) {
                            unreadMessageCountView.text = (mainList.size - lastVisiblePosition - 1).toString()
                            unreadMessageCount =  mainList.size - lastVisiblePosition - 1
                        }
                    }
                } else {
                    isViewingRecentMessage = true
                    layoutRedirectLastMessage.hide()
                    unreadMessageCountView.hide()
                    unreadMessageCount = 0
                }
            }
        compositeDisposable.add(redirectDisposable)
    }

    protected fun getMessagePosition(messageId: String) = mainList.indexOfFirst { it.messageId == messageId }

    protected fun getMessageAndPosition(messageId: String) : Pair<Int, ChatMessage?> {
        val messageIndex = mainList.indexOfFirst { it.messageId == messageId }
        return if (messageIndex.isValidIndex()) {
            val message = parentViewModel.getMessageForId(messageId)
            message?.let {
                mainList[messageIndex] = it
            }
            Pair(messageIndex, message)
        } else Pair(messageIndex, null)
    }

    protected fun getMessageAndPosition(index: Int) : Pair<Int, ChatMessage?> {
        val messageIndex = if (index < mainList.size) index else -1
        return if (messageIndex.isValidIndex()) {
            val messageId = mainList[messageIndex].messageId
            val message = parentViewModel.getMessageForId(messageId)
            message?.let {
                mainList[messageIndex] = it
            }
            Pair(messageIndex, message)
        } else Pair(messageIndex, null)
    }

    protected fun getMessagebyID(messageId: String): ChatMessage? {
        val index = mainList.indexOfFirst { it.messageId == messageId }
        return if (index.isValidIndex())
            mainList[index]
        else null
    }

    protected fun findIndexOfUnreadMessageType(): Triple<Boolean, Int, String> {
        Log.d(TAG, "findIndexOfUnreadMessageType $unreadMessageTypeMessageId")
        val position = getMessagePosition(unreadMessageTypeMessageId)
        var message = Constants.EMPTY_STRING
        var isUnreadSeparatorIsAvailable = false
        try {
            if (position != -1) {
                isUnreadSeparatorIsAvailable = true
                message = mainList[position].messageTextContent
            }
            if (position != -1 && lastCompletelyVisibleItemPosition == 0)
                listChats.scrollToPosition(position + 1)

            if (position == -1 && lastCompletelyVisibleItemPosition == (mainList.size - 2)) {
                listChats.scrollToPosition(mainList.size - 1)
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e.printStackTrace().toString())
            return Triple(false, 0, "")
        }
        return Triple(isUnreadSeparatorIsAvailable, position, message)
    }

    protected fun handleUnreadMessageSeparator(remove: Boolean) {
        val (isUnreadSeparatorIsAvailable, separatorPosition) = findIndexOfUnreadMessageType()
        if (isUnreadSeparatorIsAvailable && !mainList.isNullOrEmpty()) {
            if (remove) {
                removeUnreadMessageSeparator(separatorPosition)
            } else {
                displayUnreadMessageSeparator(separatorPosition)
            }
        }
    }

    private fun removeUnreadMessageSeparator(separatorPosition: Int) {
        parentViewModel.deleteUnreadMessageSeparator(chat.toUser)
        mainList.removeAt(separatorPosition)
        chatAdapter.notifyItemRemoved(separatorPosition)
        if (mainList.size >= (separatorPosition))
            chatAdapter.notifyItemChanged(separatorPosition)
    }

    private fun displayUnreadMessageSeparator(separatorPosition: Int) {
        val noOfItemsAfterUnreadMessageSeparator = mainList.size - separatorPosition - 1
        if (noOfItemsAfterUnreadMessageSeparator != 0) {
            val unreadMessageDetails = mainList[separatorPosition]
            if (mainList[separatorPosition].messageId == unreadMessageTypeMessageId) {
                unreadMessageDetails.messageTextContent = "$noOfItemsAfterUnreadMessageSeparator ${if (noOfItemsAfterUnreadMessageSeparator == 1) "UNREAD MESSAGE" else "UNREAD MESSAGES"}"
                chatAdapter.notifyItemChanged(separatorPosition)
            }
        } else
            handleUnreadMessageSeparator(true)
    }

    /**
     * Here updating the message seen acknowledgment
     */
    private fun sendMessageSeenStatus() {
        ChatManager.markAsRead(chat.toUser)
    }

    protected fun onClearConversationMenuClicked() {
        if (mainList.isEmpty()) {
            showToast(getString(R.string.empty_conversation))
        } else {
            commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.CLEAR_CONVERSATION
            if (parentViewModel.hasUserStarredAnyMessage(chat.toUser)) {
                commonAlertDialog.showClearChatDialog(
                        getString(R.string.msg_are_you_sure_you_want_to_clear),
                        getString(R.string.msg_clear_all),
                        getString(R.string.action_cancel),
                        getString(R.string.msg_except_starred),
                        CommonAlertDialog.DIALOGTYPE.DIALOG_TRIPLE)
            } else {
                commonAlertDialog.showClearChatDialog(
                        getString(R.string.msg_are_you_sure_you_want_to_clear),
                        getString(R.string.msg_clear),
                        getString(R.string.action_cancel), "",
                        CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL)
            }
        }
    }

    protected fun deleteMessageActionMenuClicked() {
        if (clickedMessages.isNotEmpty()) {
            val messageToShow = "Are you sure you want to delete selected ${if (clickedMessages.size > 1) "Messages" else "Message"}?"
            val isRecallAvailable = parentViewModel.isMessagesCanBeRecalled(clickedMessages)
            commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.DELETE_CHAT
            if (isRecallAvailable.first) {
                commonAlertDialog.showAlertDialogWithRecall(messageToShow, getString(R.string.action_delete_for_me),
                        getString(R.string.action_cancel), getString(R.string.action_delete_for_all), CommonAlertDialog.DIALOGTYPE.DIALOG_TRIPLE, isRecallAvailable.second)
            } else {
                commonAlertDialog.showAlertDialog(messageToShow, getString(R.string.action_delete_for_me),
                        getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false, isRecallAvailable.second)
            }
        }
    }

    protected fun messageInfoActionMenuClicked() {
        if (clickedMessages.isNotEmpty()) {
            hideKeyboard()
            if (chat.isSingleChat())
                launchActivity<MessageInfoActivity> {
                    putExtra(Constants.MESSAGE_ID, clickedMessages.first())
                    addOtherExtraForMessageInfo(this)
                }
            else if (chat.isGroupChat())
                launchActivity<GroupMessageInfoActivity> {
                    putExtra(Constants.MESSAGE_ID, clickedMessages.first())
                    putExtra(Constants.CHAT_TYPE, chat.chatType)
                    putExtra(Constants.GROUP_JID,chat.toUser)
                    addOtherExtraForMessageInfo(this)
                }
        }
    }

    private fun addOtherExtraForMessageInfo(intent: Intent) {
        val message = mainList[getMessagePosition(clickedMessages.first())]
        if (message.messageType == MessageType.AUDIO) {
            val seekerPosition = chatAdapter.getMediaController().getPlayedTimeOfTrackInSecs(Utils.returnEmptyStringIfNull(message.mediaChatMessage.getMediaLocalStoragePath()))
            intent.putExtra(Constants.SEEKER_POS, seekerPosition)
        }
    }

    protected fun copyMessagesActionMenuClicked(clickedMessages: ArrayList<String>) {
        if (clickedMessages.isNotEmpty()) {
            ChatUtilsOperations().copyOrShareMsg(clickedMessages, this)
        }
    }

    protected fun starOrUnStarMessageActionMenuClicked(isStar: Boolean) {
        if (clickedMessages.isNotEmpty()) {
            for (msgId in clickedMessages) {
                ChatManager.updateFavouriteStatus(msgId, chat.toUser, isStar, object : ChatActionListener {
                    override fun onResponse(isSuccess: Boolean, message: String) {
                        /*
                        * No Implementation needed
                        */
                    }
                })
                getMessageAndPosition(msgId).let { messageAndPosition ->
                    if (messageAndPosition.first != -1) {
                        messageAndPosition.second?.let {
                            it.isMessageStarred = isStar
                            chatAdapter.refreshMessage(messageAndPosition.first, it)
                        }
                    }
                }
            }
        }
    }

    protected fun replyMessageActionMenuClicked() {
        isReplyTagged = true
        if (clickedMessages.isNotEmpty()) {
            selectedMessageIdForReply = clickedMessages.first()
            SharedPreferenceManager.setString(Constants.REPLY_MESSAGE_ID, selectedMessageIdForReply)
            SharedPreferenceManager.setString(Constants.REPLY_MESSAGE_USER, chat.toUser)
            showViews(replyMessageSentView, closeReplyMessage)
            replyViewHandler.showReplyMessageToSend(clickedMessages.first(), parentViewModel, suggestionLayout, chat.toUser)
        }
    }

    protected fun replyMessageSlideActionClicked(position: Int) {
        selectedMessageIdForReply = mainList[position].messageId
        if (SharedPreferenceManager.getString(Constants.REPLY_MESSAGE_ID).equals(selectedMessageIdForReply, false)) {
            if (chatMessageEditText.requestFocus()) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(chatMessageEditText, InputMethodManager.SHOW_IMPLICIT)
            }
            return
        }
        SharedPreferenceManager.setString(Constants.REPLY_MESSAGE_ID, selectedMessageIdForReply)
        SharedPreferenceManager.setString(Constants.REPLY_MESSAGE_USER, chat.toUser)
        ReplyHashMap.saveReplyId(chat.toUser,  mainList[position].messageId)
        replyViewHandler.showReplyMessageToSend(selectedMessageIdForReply, parentViewModel, suggestionLayout, chat.toUser)
        showViews(replyMessageSentView, closeReplyMessage)
        if (chatMessageEditText.requestFocus()) {
            imm.showSoftInput(chatMessageEditText, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun shareMedia(clickedMessages: ArrayList<String>){
        MediaShareUtils().shareMediaExternal(clickedMessages, this)
    }


    protected fun forwardMessageActionMenuClicked(forwardMessageList: ArrayList<String>): Boolean {
        Log.d(TAG, "on send forwardMessageActionMenuClicked:")
        if(FlyCore.isBusyStatusEnabled() && chat.chatType == ChatType.TYPE_CHAT){
            showForwardBusyAlert()
        }else {
            hideKeyboard()
            launchActivity<ForwardMessageActivity> {
                putStringArrayListExtra(Constants.CHAT_MESSAGE, forwardMessageList)
            }
        }
        return true
    }

    fun handleOnResume() {
        ChatManager.setOnGoingChatUser(chat.toUser)
        selectedMessageIdForReply = ReplyHashMap.getReplyId(chat.toUser)
        showUnsentMessage(parentViewModel.getUnSentMessageForAnUser(chat.toUser))
        sendMessageSeenStatus()
        NotificationManagerCompat.from(context!!).cancel(Constants.NOTIFICATION_ID)
        dismissProgress()
        updateDeliveryAndSeenStatus()
    }

    /**
     * Here enabling the chat edittext
     */
    open fun updateChatEditText() {
        // Checks the chat type and validates if user presents in group or users exists in broadcast list
        // if chat type is group or broadcast enable/disable chat type option
        if (ChatType.TYPE_GROUP_CHAT == chat.chatType) {
            setUpGroupChatEditText()
        } else {
            val isUserBlocked = profileDetails.isBlocked
            val isAdminBlocked = profileDetails.isAdminBlocked
            if (isUserBlocked || isAdminBlocked) {
                showTxtNoMsg(isAdminBlocked)
                makeViewsGone(viewChat, imgSend, voiceAttachment, replyMessageSentView, closeReplyMessage)
                parentViewModel.clearSuggestions()
                suggestionLayout.gone()
                setCallButtonVisibility()
            } else {
                setBottomChatFooterView()
            }
        }
    }

    protected fun setUpBlockedUserView(){
        if (chat.isSingleChat()) {
            clickableSpan = object : ClickableSpan() {
                override fun onClick(textView: View) {
                    if (SystemClock.elapsedRealtime() - lastClickTime > 1000)
                        showBlockUserDialog(false)
                    lastClickTime = SystemClock.elapsedRealtime()
                }
            }
            txtNoMsg.text = setBlockedSpannableText()
            txtNoMsg.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    protected fun setUpGroupChatEditText() {
        if (parentViewModel.isGroupUserExist(chat.toUser, SharedPreferenceManager.getCurrentUserJid())) {
            setBottomChatFooterView()
        } else {
            val view = this.currentFocus
            if (view != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
            makeViewsGone(viewChat, imgSend)
            if (ChatManager.getAvailableFeatures().isGroupChatEnabled)
                txtNoMsg.text = getString(R.string.msg_not_participant)
            else
                txtNoMsg.text = getString(R.string.fly_error_forbidden_exception)
            showViews(txtNoMsg)
        }
    }

    private fun showTxtNoMsg(adminBlocked: Boolean) {
        txtNoMsg.text = if (adminBlocked) getString(R.string.user_block_message_label) else setBlockedSpannableText()
        txtNoMsg.show()
    }
     protected fun handleAttachmentRestriction() {
         val features = ChatManager.getAvailableFeatures()
         attachment.visibility = if (features.isAttachmentEnabled) View.VISIBLE else View.GONE
         voiceAttachment.visibility = if (features.isAudioAttachmentEnabled) View.VISIBLE else View.GONE
    }

    private fun setBottomChatFooterView() {
        if (searchEnabled) {
            makeViewsGone(chatFooter)
            if (emojiHandler.isEmojiShowing) emojiHandler.hideEmoji()
        } else {
            if (chatMessageEditText.text.isNullOrBlank())
                makeViewsGone(txtNoMsg, imgSend)
            else
                makeViewsGone(txtNoMsg)
            if (audioRecordView.mediaState == com.mirrorflysdk.flycommons.Constants.COUNT_ZERO) {
                showViews(viewChat, chatFooter)
                handleAttachmentRestriction()
            } else
                showViews(viewChat, chatFooter)
        }
    }

    protected fun addDateMessagesIfNeedToRemove() {
        Observable.fromIterable(orderClickedMessages(clickedMessages)).blockingSubscribe(object : Observer<Pair<Int, String>> {
            override fun onComplete() {
                removeSelectedMessagesFromList()
            }

            override fun onSubscribe(disposable: Disposable) {
                compositeDisposable.add(disposable)
            }

            override fun onNext(it: Pair<Int, String>) {
                if (it.first != -1 && mainList[it.first].messageId == it.second && isDateHeaderCanRemove(it.first)) {
                    //remove all headers which are above this message which are for senderId, except unread header which will be cleared in other code
                    var past = 1
                    while ((it.first - past) >= 0 && mainList[it.first - past].messageId.equals("M" + mainList[it.first].getSenderJid(), true)) {
                        if (!unreadMessageTypeMessageId.equals("M" + mainList[it.first].getSenderJid(), true))
                            clickedMessages.add(mainList[it.first - past].messageId)
                        past++ //go more up to past messages
                    }
                }
            }

            override fun onError(e: Throwable) {
                LogMessage.e(e)
            }
        })
    }

    protected fun onEmailConversationMenuClicked() {
        if (mainList.isEmpty())
            showToast(getString(R.string.empty_conversation))
        else {
            isEmailChatClicked = true
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                if (MediaPermissions.isReadFilePermissionAllowed(this) &&
                    MediaPermissions.isWriteFilePermissionAllowed(this)) {
                    exportChatEmail()
                } else MediaPermissions.requestStorageAccess(this, permissionAlertDialog, emailPermissionLauncher)
            } else {
                exportChatEmail()
            }

        }
    }

    private fun exportChatEmail(){
        isEmailChatClicked = false
        FlyCore.exportChatConversationToEmail(chat.toUser, emptyList())
    }

    /**
     * Checks the current date header can delete, if no message available in same date
     *
     * @param position Position of the current item
     * @return boolean True if header can remove, else false
     */
    fun isDateHeaderCanRemove(position: Int): Boolean {
        if (position < 1)
            return false
        return if (mainList[position - 1].messageType == MessageType.NOTIFICATION && mainList[position - 1].messageId.contains("M" + mainList[position].getSenderJid())) {
            if (position + 1 < mainList.size) {
                isAllMessagesForDateSelected(position)
            } else
                true
        } else {
            false
        }
    }

    private fun isAllMessagesForDateSelected(position: Int): Boolean {
        return if (position + 1 < mainList.size) {
            return if (clickedMessages.contains(mainList[position + 1].messageId)) {
                isAllMessagesForDateSelected(position + 1)
            } else {
                when {
                    mainList[position + 1].messageType != MessageType.NOTIFICATION -> false
                    position + 2 < mainList.size -> {
                        mainList[position + 1].messageId.contains("M" + mainList[position + 2].getSenderJid())
                    }
                    else -> false
                }
            }
        } else {
            true
        }
    }

    private fun removeSelectedMessagesFromList() {
        Observable.fromIterable(orderClickedMessages(clickedMessages))
            .blockingSubscribe(object : Observer<Pair<Int, String>> {
                override fun onComplete() {
                    clickedMessages.clear()
                    handleUnreadMessageSeparator(false)
                    actionMode?.finish()
                }

                override fun onSubscribe(disposable: Disposable) {
                    compositeDisposable.add(disposable)
                }

                override fun onNext(it: Pair<Int, String>) {
                    if (it.first != -1 && mainList[it.first].messageId == it.second) {
                        clickedMessages.remove(it.second)
                        mainList.removeAt(it.first)
                        chatAdapter.notifyItemRemoved(it.first)
                        chatAdapter.notifyItemRangeChanged(it.first, lastCompletelyVisibleItemPosition - it.first)
                        updateRecallMessageReplyView(it.second)
                    }
                }

                override fun onError(e: Throwable) {
                    LogMessage.e(e)
                }

            })
    }

    private fun orderClickedMessages(clickedMessages: List<String>): List<Pair<Int, String>> {
        val sortedMessage = ArrayList<Pair<Int, String>>()
        Observable.fromIterable(clickedMessages)
            .map { return@map Pair(getMessagePosition(it), it) }
            .blockingSubscribe(object : Observer<Pair<Int, String>> {
                override fun onComplete() {
                    sortedMessage.sortByDescending { it.first }
                    Log.d("Test Sort", sortedMessage.toString())
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onNext(t: Pair<Int, String>) {
                    sortedMessage.add(t)
                }

                override fun onError(e: Throwable) {
                    LogMessage.e(e)
                }

            })
        return sortedMessage
    }

    protected fun getStarredMessages() = mainList.filter { it.isMessageStarred() }

    protected fun getRecalledMessagesForThisUser() {
        val recalledMessageDisposable = Observable.fromIterable(parentViewModel.getRecalledMessageForThisUser(chat.toUser)).map {
            val position = getMessagePosition(it)
            return@map Pair(position, it)
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            if (it.first != -1) {
                refreshMessageAndUpdateAdapter(it.second, Constants.EMPTY_STRING)
                updateRecallMessageReplyView(it.second)
            }
        }
        compositeDisposable.add(recalledMessageDisposable)
    }

    protected fun clearAndUpdateSelectedMessages(isFromRecalled: Boolean) {
        val tempList = ArrayList<String>()
        tempList.addAll(clickedMessages)
        Observable.fromIterable(tempList).map { return@map Pair(getMessagePosition(it), it) }
            .blockingSubscribe(object : Observer<Pair<Int, String>> {
                override fun onComplete() {
                    tempList.clear()
                    actionMode?.finish()
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onNext(it: Pair<Int, String>) {
                    if (it.first != -1) {
                        clickedMessages.remove(it.second)
                        if (isFromRecalled) {
                            refreshMessageAndUpdateAdapter(it.second, Constants.EMPTY_STRING)
                            updateRecallMessageReplyView(it.second)
                        } else
                            chatAdapter.notifyItemChanged(it.first)
                    }

                }

                override fun onError(e: Throwable) {
                    LogMessage.e(TAG, e)
                }
            })
    }

    protected fun refreshMessageAndUpdateAdapter(messageId: String, key: String) {
        launch {
            _messageRefreshFlow.emit(Pair(messageId, key))
        }
    }

    protected fun attachCamera() {
        selectedOptionName = Constants.ATTACHMENT_CAMERA
        cameraSelection(false)
    }

    protected fun attachDocument() {
        selectedOptionName = Constants.ATTACHMENT_DOCUMENT
        chooseFileToUpload()
    }

    private fun attachAudio() {
        selectedOptionName = Constants.ATTACHMENT_AUDIO
        audioFileSelection()
    }

    protected fun attachContact() {
        selectedOptionName = Constants.ATTACHMENT_CONTACT
        contactSelection()
    }

    protected fun attachGallery() {
        selectedOptionName = Constants.ATTACHMENT_GALLERY
        gallerySelection()
    }

    protected fun attachLocation() {
        selectedOptionName = Constants.ATTACHMENT_LOCATION
        locationSelection()
    }


    protected fun updateRecallMessageReplyView(messageId: String) {
        if (messageId == selectedMessageIdForReply)
            replyViewHandler.showReplyMessageToSend(selectedMessageIdForReply, parentViewModel, suggestionLayout, chat.toUser)

        if (mainList.isNotEmpty()) {
            for (message in mainList)
                if (message.replyParentChatMessage != null && message.replyParentChatMessage.messageId == messageId)
                    chatAdapter.notifyItemChanged(getMessagePosition(message.messageId))
        }
    }

    protected fun addMessagesforSmartReply() {
        if ((isProfileObjectInitialized() && !profileDetails.isAdminBlocked) && mainList.isNotEmpty() && !searchEnabled && mainList.last().messageType == MessageType.TEXT ) {
            val list = mainList.filter { !it.isMessageRecalled() && !it.isMessageSentByMe && it.messageType == MessageType.TEXT }
            if(!mainList.last().isMessageSentByMe) {
                if (list.isNotEmpty() && !mainList.last().isMessageRecalled) parentViewModel.addMessage(list.last(), chat.toUser)
                else parentViewModel.clearSuggestions()
            } else parentViewModel.addMessage(mainList.last(), chat.toUser)
        } else parentViewModel.clearSuggestions()
    }

    protected fun updateRecalledMessage(clkdMessages: List<String>) {
        for (mid in clkdMessages)
            chatAdapter.notifyItemChanged(getMessagePosition(mid))
    }

    private fun updateDeliveryAndSeenStatus() {
        if (firstCompletelyVisibleItemPosition in 0 until lastCompletelyVisibleItemPosition) {
            for (index in firstCompletelyVisibleItemPosition until lastCompletelyVisibleItemPosition)
                if (mainList.size > index)
                    refreshMessageAndUpdateAdapter(mainList[index].messageId, Constants.NOTIFY_MESSAGE_STATUS_CHANGED)
        }
    }

    protected fun handleSearchToolbar(showSearch: Boolean, hideKeyboard: Boolean) {
        searchEnabled = showSearch
        activity!!.invalidateOptionsMenu()
        if (showSearch) {
            makeViewsGone(userNameLayout, toUserImageView)
            if (selectedMessageIdForReply != Constants.EMPTY_STRING) makeViewsGone(
                replyMessageSentView,
                closeReplyMessage
            )
            searchEdit.show()
            searchEdit.requestFocus()
            showSoftKeyboard(this)
        } else {
            searchedText = emptyString()
            searchedNxt = emptyString()
            searchedPrev = emptyString()
            searchEdit.setText(searchedText)
            showViews(userNameLayout, toUserImageView)
            if (selectedMessageIdForReply != Constants.EMPTY_STRING) {
                showViews(replyMessageSentView, closeReplyMessage)
                replyViewHandler.showReplyMessageToSend(
                    selectedMessageIdForReply,
                    parentViewModel,
                    suggestionLayout,
                    chat.toUser
                )
            }
            if (hideKeyboard) hideSoftKeyboard(this)
            searchEdit.gone()
        }
        setSearch()
        updateChatEditText()
    }

    @Synchronized
    protected fun setSearch() {
        addMessagesforSmartReply()
        chatAdapter.setSearch(searchEnabled, searchedText)
        chatAdapter.notifyDataSetChanged()
        filteredPosition.clear()
        if (searchedText.isNotEmpty()) {
            for (i in mainList.indices)
                if (mainList[i].messageType == MessageType.TEXT && mainList[i].messageTextContent.startsWithTextInWords(
                        searchedText
                    )
                )
                    filteredPosition.add(i)
                else if (mainList[i].messageType == MessageType.IMAGE && mainList[i].mediaChatMessage.mediaCaptionText.isNotEmpty()
                    && mainList[i].mediaChatMessage.mediaCaptionText.startsWithTextInWords(
                        searchedText
                    )
                )
                    filteredPosition.add(i)
                else if (mainList[i].messageType == MessageType.VIDEO && mainList[i].mediaChatMessage.mediaCaptionText.isNotEmpty()
                    && mainList[i].mediaChatMessage.mediaCaptionText.startsWithTextInWords(
                        searchedText
                    )
                )
                    filteredPosition.add(i)
                else if (mainList[i].messageType == MessageType.DOCUMENT && mainList[i].mediaChatMessage.mediaFileName.isNotEmpty()
                    && mainList[i].mediaChatMessage.mediaFileName.startsWithTextInWords(searchedText))
                    filteredPosition.add(i)
                else if (mainList[i].messageType == MessageType.CONTACT && mainList[i].contactChatMessage.contactName.isNotEmpty()
                    && mainList[i].contactChatMessage.contactName.startsWithTextInWords(searchedText))
                    filteredPosition.add(i)
        }
    }

    @Synchronized
    protected fun handlePrevNextClicked(isPrev: Boolean) {
        val visiblePos = mManager.findLastVisibleItemPosition()
        if (isPrev) {
            if (!searchedPrev.equals(searchedText, ignoreCase = true)) {
                j = getPreviousPosition(visiblePos)
                searchedPrev = searchedText
                searchedNxt = searchedText
            } else if (filteredPosition.isNotEmpty()) j = maxOf(j - 1, -1)
            else {
                j = -1
            }
            if (isFromSearchIcon) {
                isFromSearchIcon = false
                Timer().schedule(100) {
                    runOnUiThread {
                        actionPrev?.icon = resources.getDrawable(R.drawable.ic_search_prev_arrow)
                    }
                }
            }
        } else {
            if (!searchedNxt.equals(searchedText, ignoreCase = true)) {
                j = getNextPosition(visiblePos)
                searchedNxt = searchedText
                searchedPrev = searchedText
            } else if (filteredPosition.isNotEmpty()) j = minOf(j + 1, filteredPosition.size)
            else {
                j = -1
            }
        }

        serachKeywordValueSet(j,isPrev)

    }

    private fun serachKeywordValueSet(j: Int, isPrev: Boolean) {

        if (this.j > -1 && this.j < filteredPosition.size) {
            hideKeyboard()
            highlightGivenMessageId(mainList[filteredPosition[this.j]].messageId)
        } else {
            hideKeyboard()
            searchEdit.requestFocus()
            showSoftKeyboard(this)
            if(isPrev){
                parentViewModel.loadPreviousData(searchedText)
                optionMenu?.get(R.id.action_prev)?.isVisible = false
                optionMenu?.get(R.id.prev_loader)?.isVisible = true
            } else {
                parentViewModel.loadNextData(searchedText)
                optionMenu?.get(R.id.action_next)?.isVisible = false
                optionMenu?.get(R.id.next_loader)?.isVisible = true
            }

        }
    }

    private fun searchKeyObserver(){

        parentViewModel.searchkeydata.observe(this) { keyword ->
            try{
                searchedPrev=""
                searchedNxt=""
                if(keyword.equals(Constants.PREV_LOAD)){
                    setSearch()
                    handlePrevNextClicked(true)
                    optionMenu?.get(R.id.prev_loader)?.isVisible = false
                    optionMenu?.get(R.id.action_prev)?.isVisible = true
                } else if(keyword.equals(Constants.NEXT_LOAD)){
                    setSearch()
                    handlePrevNextClicked(false)
                    optionMenu?.get(R.id.next_loader)?.isVisible = false
                    optionMenu?.get(R.id.action_next)?.isVisible = true
                }else if(keyword.equals(Constants.NO_DATA)){
                    showToast(getString(R.string.message_no_result_found))
                    optionMenu?.get(R.id.next_loader)?.isVisible = false
                    optionMenu?.get(R.id.action_next)?.isVisible = true
                    optionMenu?.get(R.id.prev_loader)?.isVisible = false
                    optionMenu?.get(R.id.action_prev)?.isVisible = true
                }

            }catch(e:NullPointerException){

                LogMessage.e(TAG,e.toString())
            }

        }
    }


    private fun getPreviousPosition(visiblePos: Int): Int {
        for (i in filteredPosition.indices)
            if (visiblePos > filteredPosition.reversed()[i])
                return filteredPosition.indexOf(filteredPosition.reversed()[i])
        return -1
    }

    private fun getNextPosition(visiblePos: Int): Int {
        for (i in filteredPosition.indices)
            if (visiblePos <= filteredPosition[i])
                return i
        return -1
    }

    protected fun highlightGivenMessageId(messageId: String) {
        val replyMessage = parentViewModel.getMessageForReply(messageId)
        if ((replyMessage?.isMessageRecalled() == null || !replyMessage.isMessageRecalled()) && (replyMessage?.isMessageDeleted() == null || !replyMessage.isMessageDeleted())) {
            val position = getMessagePosition(messageId)
             mManager.scrollToPositionWithOffset(position, 1000)
            val highlightTimerDisposable = Observable.timer(100, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread()).subscribe {
                    val newPosition = getMessagePosition(messageId)
                    val bundle = Bundle()
                    bundle.putInt(Constants.NOTIFY_MESSAGE_HIGHLIGHT, 1)
                    chatAdapter.notifyItemChanged(newPosition, bundle)
            }
            val timerDisposable =
                Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        val newPosition = getMessagePosition(messageId)
                        val bundle = Bundle()
                        bundle.putInt(Constants.NOTIFY_MESSAGE_UNHIGHLIGHT, 1)
                        chatAdapter.notifyItemChanged(newPosition, bundle)
                    }
            compositeDisposable.add(highlightTimerDisposable)
            compositeDisposable.add(timerDisposable)
        } else {
            Toast.makeText(this, "This message is no longer available", Toast.LENGTH_SHORT).show()
        }
    }

    protected fun invalidateActionMode() {
        if (clickedMessages.isEmpty())
            actionMode?.finish()
        else
            handleActionMode()
    }


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    /**
     * create chat shortcut for chats
     */
    protected fun createAppChatShortcutForChat() {
        AppChatShortCuts.dynamicAppShortcuts(this, toUser, chatType)
    }

    /**
     * Handling attachment
     */
    fun attachRecordVoice(): Boolean {
        if (attachmentDialog.isShowing)
            closeControls()
        if (!isBlocked)
            chatAdapter.pauseMediaPlayer()
        return if (FlyCore.isBusyStatusEnabled() && ChatType.TYPE_CHAT.equals(chat.chatType, false)) {
            showBusyAlert()
            false
        } else if (isBlocked) {
            showBlockedAlertAudioMessage()
            false
        } else {
            selectedOptionName = Constants.ATTACHMENT_AUDIO
            audioSelection()
        }
    }

    /**
     * check the audio permission
     */
    private fun audioSelection(): Boolean {
        return if (!CallManager.isOnGoingCall())
            if (isPermissionsAllowed(Manifest.permission.RECORD_AUDIO) && MediaPermissions.isWriteFilePermissionAllowed(
                    this
                )
            ) {
                suggestionLayout.gone()
                true
            } else {
                MediaPermissions.requestAudioStoragePermissions(
                    this,
                    permissionAlertDialog,
                    audioRecordingPermissionLauncher
                )
                false
            }
        else {
            vibrateWithToast(getString(R.string.warning_audio_restriction_message))
            false
        }
    }

    fun playForgroundNotificationSound(context:Context) {
        try {
            val audioManager = context.getSystemService(AUDIO_SERVICE) as AudioManager
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
                .setLegacyStreamType(AudioManager.STREAM_RING)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE).build()
            val sessionId: Int = audioManager.generateAudioSessionId()
            val notificationSoundUri = Uri.parse(SharedPreferenceManager.getString(Constants.NOTIFICATION_URI))
            if(notificationSoundUri != null && !(notificationSoundUri.toString().equals("None") || notificationSoundUri.toString().equals("\"None\""))){
                var mediaPlayer = MediaPlayer.create(context, R.raw.forground_notification,audioAttributes,sessionId)
                mediaPlayer?.setOnCompletionListener(OnCompletionListener {
                    mediaPlayer?.release()
                })
                mediaPlayer?.start()
            }
        } catch(e:Exception) {
            LogMessage.e(TAG, e.message)
        }
    }

override fun onAttachDocument() {
        attachDocument()
    }

    override fun onAttachCamera() {
        attachCamera()
    }

    override fun onAttachGallery() {
        attachGallery()
    }

    override fun onAttachAudio() {
        attachAudio()
    }

    override fun onAttachContact() {
        attachContact()
    }

    override fun onAttachLocation() {
        attachLocation()
    }

    override fun onDestroy() {
        super.onDestroy()
        parentViewModel.searchkeydata.removeObservers(this)
    }

}