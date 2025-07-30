package com.contusfly.activities.parent

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.*
import android.text.*
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.ContentFrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.contusfly.*
import com.contusfly.activities.*
import com.contusfly.adapters.ChatAdapter
import com.contusfly.adapters.GroupTagAdapter
import com.contusfly.chat.MessagingClient
import com.contusfly.databinding.ActivityEditMessageBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.groupmention.*
import com.contusfly.interfaces.MessageListener
import com.contusfly.models.*
import com.contusfly.utils.*
import com.contusfly.utils.Utils
import com.contusfly.viewmodels.ChatViewModel
import com.contusfly.viewmodels.MentionsViewModel
import com.contusfly.views.*
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.*
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@SuppressLint("Registered")
@SuppressWarnings("kotlin:S1874")
open class EditChatParent : BaseActivity(), CoroutineScope, MessageListener{

    @Inject
    lateinit var chatViewModelFactory: AppViewModelFactory

    open val viewModel by lazy {
        ViewModelProviders.of(this, chatViewModelFactory).get(ChatViewModel::class.java)
    }

    protected val mentionViewModelEditMessage by lazy {
        ViewModelProvider(this).get(MentionsViewModel::class.java)
    }

    lateinit var chat: Chat


    protected lateinit var binding: ActivityEditMessageBinding
    protected val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    var isFromQuickShare = false

    protected var msg: ChatMessage? = null

    /**
     * Store onclick time to avoid double click
     */
    protected var lastClickTime: Long = 0

    lateinit var profileDetails: ProfileDetails

    var isBlocked: Boolean = false

    var isAdminBlocked: Boolean = false

    var originalMessage = Constants.EMPTY_STRING


    /**
     * Utils to handle the chat view operations
     */
    @Inject
    lateinit var chatViewUtils: ChatViewUtils

    @Inject
    lateinit var sharedPreferenceManager: SharedPreferenceManager

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    protected val commonAlertDialog: CommonAlertDialog by lazy { CommonAlertDialog(this) }

    @Inject
    lateinit var messagingClient: MessagingClient
    /**
     * Instance of the EmojiHandler to access the emoji and text keypad
     */
    protected val emojiHandler: EmojiHandler by lazy { EmojiHandler(this) }

    lateinit var toUser: String

    lateinit var messageId: String

    lateinit var chatAdapter: ChatAdapter

    lateinit var groupTagAdapter: GroupTagAdapter

    protected var searchEnabled = false

    /**
     * Chat type of the chat view
     */
    lateinit var chatType: String
    /**
     * Layout manager for chat recyclerView
     */
    protected val mManager: LinearLayoutManager by lazy {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = false
        layoutManager.stackFromEnd = true
        layoutManager
    }


    protected val mainList = ArrayList<ChatMessage>()


    val userMentionConfig: UserMentionConfig = UserMentionConfig.Builder().build()

    /**
     * Used to store boolean value indicating that audio recording is paused due to activity going to background.
     */

    private val editTextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            if (p0.toString().trim().isNotEmpty() && originalMessage != p0.toString().trim()) {
                imgSend.isEnabled = true
                imgSend.show()
                imgSend.setImageResource(R.drawable.ic_send_active)
            } else {
                hideSendView(true)
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            LogMessage.v(TAG,"beforeTextChanged")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            LogMessage.v(TAG,"onTextChanged")
        }
    }

    companion object {
        val TAG = EditChatParent::class.java.simpleName
    }

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        profileDetails = ProfileDetails()
    }

    /**
     * Recycler view object which used to display the chat view
     */
    protected val listChats by bindView<RecyclerView>(R.id.view_chat_list)

    val chatFooterDivider by bindView<View>(R.id.chat_footer_divider)



    /**
     * Edit text which used to add the message in the chat view to send the user
     */
    val chatMessageEditText by bindView<MentionEditGroupText>(R.id.edit_chat_msg)

    protected val toolbar by bindView<Toolbar>(R.id.chat_toolbar)
    val imgSend by bindView<AppCompatImageView>(R.id.image_chat_send)
    val smiley by bindView<ImageView>(R.id.image_chat_smiley)
    val viewChat by bindView<LinearLayout>(R.id.view_edit_message)
    protected val back by bindView<ImageView>(R.id.back)
    protected val replyMessageSentView by bindView<View>(R.id.view_text_reply_layout)

    //To verify back action from toolbar
    protected var isBackPressed = false

    val parentContent by bindView<ContentFrameLayout>(android.R.id.content)

    protected val groupTagRecycler by bindView<RecyclerView>(R.id.group_tag_name_recycler)
    protected val groupUserTagLayout by bindView<LinearLayout>(R.id.group_user_tag_layout)
    protected val viewChildLayout by bindView<LinearLayout>(R.id.view_child_footer)
    protected val swipeRefreshLayout by bindView<SwipeRefreshLayout>(R.id.items_swipe_to_refresh)


    var isSoftKeyboardShown: Boolean = false

    var isGroupMemberListShowing: Boolean = false

    var isMentionTriggered = false

    var softKeyboardHeight: Int = 0

    protected var showChatKeyboard: Boolean = false

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
        showViews(viewChat, imgSend)
        swipeRefreshLayout.isEnabled = false
        initRecyclerView()
        setEditTextListener()
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
        }
    }


     private fun setEditTextListener() {
        try {
            chatMessageEditText.addTextChangedListener(editTextWatcher)
            chatMessageEditText.setOnTouchListener { _, _ ->
                false
            }
        } catch(e:Exception) {
            LogMessage.e(e)
        }
    }


    /**
     * Hide the soft keyboard if opened while user interact with chat screen
     */
    fun hideKeyboard() {
        val view: View? = currentFocus
        view?.let {
            Utils.hideSoftInput(this, view)
        }
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(chatMessageEditText.windowToken, 0)
    }
    override fun onSendMessageSuccess(message: ChatMessage) {
        TODO("Not yet implemented")
    }

    override fun onSendMessageFailure(message: String) {
        TODO("Not yet implemented")
    }

    private fun hideSendView(isTextWatcher:Boolean) {
        LogMessage.d(TAG, "#record hideSendView isTextWatcher:$isTextWatcher")
        CoroutineScope(Dispatchers.Main).launch {
                if(isTextWatcher){
                    imgSend.isEnabled = false
                    sendImageViewGone(true)
                    imgSend.setImageResource(R.drawable.ic_send_inactive)
                } else {
                    sendImageViewGone(false)
                }
        }
    }

    private fun sendImageViewGone(isTextWatcher:Boolean) {
        if(isTextWatcher){
            imgSend.gone()
        }
    }


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()
    override fun onDestroy() {
        super.onDestroy()
    }

    open fun bindUserMention(mentionConfig: UserMentionConfig, handler: OnMentionEventListener) {
        if (chatMessageEditText is MentionEditGroupText) {
            chatMessageEditText.bindUserMention(
                mentionConfig,
                TextUIConfig.Builders().setTextColor(ContextCompat.getColor(context!!,R.color.color_blue)).build(),
                handler,
                groupUserTagLayout,
                null,
                true
            )
        }
    }

}