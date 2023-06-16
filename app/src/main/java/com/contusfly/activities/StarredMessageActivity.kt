package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.os.SystemClock
import android.text.TextUtils
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.core.view.MenuItemCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.flycommons.models.MessageType
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.activities.parent.ChatParent
import com.contusfly.databinding.ActivityStarredMessageBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.groupmention.MentionUtils
import com.contusfly.interfaces.OnChatItemClickListener
import com.contusfly.models.Chat
import com.contusfly.starredMessages.StarredMessagesUtils
import com.contusfly.starredMessages.adapter.StarredMessagesAdapter
import com.contusfly.starredMessages.viewmodel.StarredMessageViewModel
import com.contusfly.utils.*
import com.contusfly.utils.FirebaseUtils.Companion.setAnalytics
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener
import com.contusfly.views.CustomRecyclerView
import com.contusfly.views.CustomTextView
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger.cancelMediaUploadOrDownload
import com.mirrorflysdk.api.FlyMessenger.downloadMedia
import com.mirrorflysdk.api.FlyMessenger.uploadMedia
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.ContactChatMessage
import com.mirrorflysdk.utils.*
import com.mirrorflysdk.views.CustomToast
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class StarredMessageActivity : ChatParent(), OnChatItemClickListener,
        CommonDialogClosedListener, ActionMode.Callback  {

    private lateinit var starredMessageBinding: ActivityStarredMessageBinding


    /**
     * The List of chat messages to display in the adapter
     */
    private var selectedStarredMessagesList: MutableList<ChatMessage> = mutableListOf()

    /**
     * The adapter chat data in the to attach in the recycler view list
     */
    private var starredMessageAdapter: StarredMessagesAdapter? = null

    /**
     * Selected messages for the info, delete and forward
     */
    private var clickedStarredMessages: MutableList<String> = mutableListOf()

    /**
     * Menu of the clicked item
     */
    private var menu: Menu? = null

    private var itemPosition = 0

    /**
     * Recycler view object which used to display the chat view
     */
    protected val listStarredMessages by bindView<CustomRecyclerView>(R.id.view_chat_list)


    /**
     * Root layout of the chat view
     */
    private var rootLayout: RelativeLayout? = null

    private val uploadDownloadProgressObserver = PublishSubject.create<String>()


    /**
     * The Txt no msg.
     */
    private val txtNoStarredMsg by bindView<CustomTextView>(R.id.text_no_msg)

    private var emptyView: TextView? = null

    private var searchCleared: Boolean = false

    /**
     * The View chat.
     */
    private val viewStarredMessages by bindView<LinearLayout>(R.id.view_chat)


    /**
     * contact msg for invite
     */
    private var selectedContactMessage: ContactChatMessage? = null

    @Inject
    open lateinit var dashboardViewModelFactory: AppViewModelFactory
    private val dashboardViewModel: DashboardViewModel by viewModels { dashboardViewModelFactory }
    private var mLayoutManager: LinearLayoutManager? = null

    private val viewModelStarredMessage by lazy {
        ViewModelProvider(this).get(StarredMessageViewModel::class.java)
    }
    private val downloadPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        starredMessageBinding = ActivityStarredMessageBinding.inflate(layoutInflater)
        setContentView(starredMessageBinding.root)
        setUpToolbar()
        setAnalytics(FirebaseAnalytics.Event.VIEW_ITEM, "Chat View", "")
        initStarredMessageViews()
        selectedStarredMessagesList = java.util.ArrayList()
        clickedStarredMessages = java.util.ArrayList()
        starredMessageAdapter = StarredMessagesAdapter()
        starredMessageAdapter!!.setAdapterData(this)
        chat = Chat("", "")
        listStarredMessages.adapter=starredMessageAdapter

        emptyView = starredMessageBinding.emptyList.textEmptyView
        emptyView!!.text = getString(R.string.no_message_found)
        listStarredMessages.setEmptyView(emptyView)

        handleStarredItemClick()
        starredMessageAdapter!!.setOnStarredMessageDownloadClickListener(this)
        viewStarredMessages.visibility = View.GONE
        txtNoStarredMsg.visibility = View.GONE
        initObservers()
        updateFeatureRestriction(ChatManager.getAvailableFeatures())
    }

    override fun onGroupProfileUpdated(groupJid: String) {
        super.onGroupProfileUpdated(groupJid)
        viewModelStarredMessage.updateStarredMessageDataByJid(groupJid)
    }

    /**
     * To handle broadcast of any user's profile changes
     * like Profile pic, Profile msg
     */
    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        viewModelStarredMessage.updateStarredMessageDataByJid(jid)
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        viewModelStarredMessage.updateStarredMessageDataByJid(jid)
    }

    private fun setUpToolbar() {
        setSupportActionBar(starredMessageBinding.toolbar)
        supportActionBar?.title = getString(R.string.starred_messages)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        UserInterfaceUtils.initializeCustomToolbar(this, starredMessageBinding.toolbar)
        starredMessageBinding.toolbar.navigationIcon?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color), BlendModeCompat.SRC_ATOP)
    }

    /**
     * Handle the list item click and long click from the recycler view of the chat view.
     */
    private fun handleStarredItemClick() {
        ItemClickSupport(listStarredMessages).addTo().setOnItemLongClickListener { _: RecyclerView?, position: Int, _: View? ->
            onItemLongClick(position)
            true
        }
        ItemClickSupport(listStarredMessages).addTo().setOnItemClickListener { _: RecyclerView?, position: Int, _: View? ->
            hideKeyboard()
            if (clickedStarredMessages.isNotEmpty()) onItemClick(position)
        }
    }

    override fun onResume() {
        super.onResume()
        if (searchEnabled && searchedText.isNotEmpty()) {
            searchStarredMessage(searchedText)
        } else {
            // Save Current Scroll state to retain scroll position after DiffUtils Applied
            val previousState =  listStarredMessages.layoutManager?.onSaveInstanceState() as Parcelable
            listStarredMessages.layoutManager?.onRestoreInstanceState(previousState)
            viewModelStarredMessage.getStarredMessageList()
        }
    }

    override fun onStop() {
        if (menu != null) {
            val menuItem = menu!!.findItem(R.id.action_search)
            if (menuItem != null) menuItem.isVisible = false
        }
        super.onStop()
    }

    private fun initStarredMessageViews() {
        rootLayout = starredMessageBinding.rootView
        listStarredMessages.isNestedScrollingEnabled = false
        listStarredMessages.setHasFixedSize(true)
        listStarredMessages.setItemViewCacheSize(20)
        listStarredMessages.isDrawingCacheEnabled = true
        listStarredMessages.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_LOW
        starredMessageBinding.viewFooter.visibility = View.GONE

        mLayoutManager = LinearLayoutManager(this)
        listStarredMessages.layoutManager = mLayoutManager
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        try {
            menuInflater.inflate(R.menu.menu_search, menu)
            val menuItem = menu.findItem(R.id.action_search)
            val searchView = MenuItemCompat.getActionView(menu.findItem(R.id.action_search)) as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(s: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(searchString: String): Boolean {
                    val searchStr: String = searchString.trim()
                    searchedText = searchStr
                    searchStarredMessage(searchStr)
                    return true
                }
            })
            searchView.setOnCloseListener {
                /**
                 * Handling while back press from search
                 */
                onMessageStatusUpdated("")
                true
            }
            MenuItemCompat.setOnActionExpandListener(menuItem, object : MenuItemCompat.OnActionExpandListener {
                override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                    setEmptyView(true)
                    return true
                }

                override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                    onMessageStatusUpdated("")
                    setEmptyView(false)
                    return true
                }
            })
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
        return true
    }

    private fun setEmptyView(b: Boolean) {
        searchEnabled = b
        searchedText = emptyString()
        emptyView!!.text = if (b) getString(R.string.msg_no_results) else getString(R.string.no_message_found)
        listStarredMessages.setEmptyView(emptyView)
    }

    /**
     * Validate search key for getting message
     *
     * @param filterKey Key to search
     */
    fun searchStarredMessage(filterKey: String?) {
        if (TextUtils.isEmpty(filterKey)) {
            searchCleared=true
            updateAdapter()
            starredMessageAdapter!!.setSearch(searchEnabled, searchedText)
        } else addSearchedMessagesToList(filterKey!!)
    }

    /**
     * Add the message into the search list which are all available from the search key. Search the
     * text in the message list.
     *
     * @param filterKey Key to search
     */
    private fun addSearchedMessagesToList(filterKey: String) {
        viewModelStarredMessage.searchedStarredMessageList.clear()
        for (message in viewModelStarredMessage.starredMessagesList) {
            if (isTextMessageContainsFilterKey(message, filterKey)) {
                viewModelStarredMessage.searchedStarredMessageList.add(message)
            } else if (isImageCaptionContainsFilterKey(message, filterKey))
                viewModelStarredMessage.searchedStarredMessageList.add(message)
            else if (isVideoCaptionContainsFilterKey(message, filterKey))
                viewModelStarredMessage.searchedStarredMessageList.add(message)
            else if (MessageType.DOCUMENT == message.messageType && message.mediaChatMessage.mediaFileName.isNotEmpty()
                && message.mediaChatMessage.mediaFileName.lowercase().contains(filterKey.lowercase()))
                viewModelStarredMessage.searchedStarredMessageList.add(message)
            else if (MessageType.CONTACT == message.messageType && message.contactChatMessage.contactName.isNotEmpty()
                && message.contactChatMessage.contactName.lowercase().contains(filterKey.lowercase()))
                viewModelStarredMessage.searchedStarredMessageList.add(message)
            else if (message.senderUserName.isNotEmpty()
                && message.senderUserName.lowercase().contains(filterKey.lowercase()))
                viewModelStarredMessage.searchedStarredMessageList.add(message)
            else if (message.isMessageSentByMe && "You".lowercase().contains(filterKey.lowercase()))
                viewModelStarredMessage.searchedStarredMessageList.add(message)
            else if(message.isGroupMessage() && ProfileDetailsUtils.getDisplayName(message.chatUserJid)
                    .lowercase().contains(filterKey.lowercase()))
                viewModelStarredMessage.searchedStarredMessageList.add(message)
        }
        starredMessageAdapter!!.setSearch(searchEnabled, searchedText)
        starredMessageAdapter!!.setStarredMessages(viewModelStarredMessage.searchedStarredMessageList)
        starredMessageAdapter!!.notifyDataSetChanged()
    }

    private fun isVideoCaptionContainsFilterKey(message: ChatMessage, filterKey: String): Boolean {
        return MessageType.VIDEO == message.messageType && message.mediaChatMessage.mediaCaptionText.isNotEmpty()
                && isMentionUserIdAvailableInMediaMessage(message, filterKey)
    }

    private fun isImageCaptionContainsFilterKey(message: ChatMessage, filterKey: String): Boolean {
        return MessageType.IMAGE == message.messageType && message.mediaChatMessage.mediaCaptionText.isNotEmpty()
                && isMentionUserIdAvailableInMediaMessage(message, filterKey)
    }

    private fun isTextMessageContainsFilterKey(message: ChatMessage, filterKey: String): Boolean {
        return MessageType.TEXT == message.messageType &&
                isMentionUserIdAvailableInMessage(message, filterKey)
    }

    private fun isMentionUserIdAvailableInMediaMessage(message: ChatMessage, filterKey: String): Boolean {
        return if (message.mentionedUsersIds != null && message.mentionedUsersIds.size > 0) {
            val mentionText = MentionUtils.formatMentionText(this, message, false)
            mentionText.toString().lowercase().contains(filterKey.lowercase())
        } else {
            message.mediaChatMessage.mediaCaptionText.lowercase().contains(filterKey.lowercase())
        }
    }

    private fun isMentionUserIdAvailableInMessage(
        message: ChatMessage,
        filterKey: String
    ): Boolean {
        return if (message.mentionedUsersIds != null && message.mentionedUsersIds.size > 0) {
            val mentionText = MentionUtils.formatMentionText(this, message, false)
            mentionText.toString().lowercase().contains(filterKey.lowercase())
        } else {
            message.messageTextContent.lowercase().contains(filterKey.lowercase())
        }
    }

    override fun onMessageStatusUpdated(messageId: String) {
        super.onMessageStatusUpdated(messageId)
        if (messageId.isNotEmpty())
            viewModelStarredMessage.updateStarredMessageData(messageId)
        else
            viewModelStarredMessage.getStarredMessageList()
    }

    override fun onUpdateUnStarAllMessages() {
        super.onUpdateUnStarAllMessages()
        updateAdapter()
    }

    private fun initObservers() {
        val uploadDownloadProgressDisposable = uploadDownloadProgressObserver.buffer(5)
            .subscribeOn(Schedulers.io()).map {
                val messageIdAndPositionList = ArrayList<Int>()
                for (item in it.distinct()) {
                    messageIdAndPositionList.add(getMessagePosition(item))
                }
                return@map messageIdAndPositionList
            }.observeOn(AndroidSchedulers.mainThread()).subscribe {
                for (item in it) {
                    if (item != -1) {
                        val bundle = Bundle()
                        bundle.putInt(Constants.NOTIFY_MESSAGE_PROGRESS_CHANGED, 1)
                        starredMessageAdapter!!.notifyItemChanged(item, bundle)
                    }
                }
            }
        compositeDisposable.add(uploadDownloadProgressDisposable)
        viewModelStarredMessage.starredMessagesListValues.observe(this) {
            viewModelStarredMessage.fetchStarredMessageData(it as MutableList<ChatMessage>,searchEnabled)
        }
        viewModelStarredMessage.starredMessageDiffResult.observe(this) {
            starredMessageAdapter!!.setStarredMessages(viewModelStarredMessage.starredMessagesList)
            it.dispatchUpdatesTo(starredMessageAdapter!!)
        }
        viewModelStarredMessage.starredMessageFetched.observe(this) {
            starredMessageAdapter!!.setStarredMessages(viewModelStarredMessage.starredMessagesList)
            starredMessageAdapter!!.notifyDataSetChanged()
        }

        viewModelStarredMessage.starredMessageUpdated.observe(this){
            starredMessageAdapter!!.notifyItemChanged(it)
        }
    }


    override fun onUploadDownloadProgressChanged(messageId: String, progressPercentage: Int) {
        super.onUploadDownloadProgressChanged(messageId, progressPercentage)
        getMessageByID(messageId)?.mediaChatMessage?.let {
            it.mediaProgressStatus = progressPercentage.toLong()
        }
        uploadDownloadProgressObserver.onNext(messageId)
    }

    private fun getMessageByID(messageId: String): ChatMessage? {
        val index = viewModelStarredMessage.starredMessagesList.indexOfFirst { it.messageId == messageId }
        return if (index.isValidIndex())
            viewModelStarredMessage.starredMessagesList[index]
        else null
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    override fun onMediaStatusUpdated(message: ChatMessage) {
        super.onMediaStatusUpdated(message)
        viewModelStarredMessage.updateStarredMessageData(message.messageId)
    }

    override fun onMessagesClearedOrDeleted(messageIds: ArrayList<String>, jid: String) {
        super.onMessagesClearedOrDeleted(messageIds, jid)
        viewModelStarredMessage.updateStarredMessageDataByJid(jid)

    }

    override fun clearActionMenu() {
        super.clearActionMenu()
        actionMode!!.finish()
    }

    override fun onDownloadClicked(item: ChatMessage) {
        if (MediaPermissions.isWriteFilePermissionAllowed(this)) {
            if (AppUtils.isNetConnected(this)) {
                downloadMedia(item.messageId)
                viewModelStarredMessage.updateStarredMessageData(item.messageId)
                activity!!.invalidateOptionsMenu()
            } else CustomToast.show(this, getString(R.string.msg_no_internet))
        } else MediaPermissions.requestStorageAccess(this, permissionAlertDialog, downloadPermissionLauncher)
    }

    override fun onCancelDownloadClicked(messageItem: ChatMessage) {
        if (AppUtils.isNetConnected(this)) {
            cancelMediaUploadOrDownload(messageItem.messageId)
            viewModelStarredMessage.updateStarredMessageData(messageItem.messageId)
            activity!!.invalidateOptionsMenu()
        } else CustomToast.show(this, getString(R.string.msg_no_internet))
    }

    override fun onCancelUploadClicked(messageItem: ChatMessage) {
        if (AppUtils.isNetConnected(this)) {
            cancelMediaUploadOrDownload(messageItem.messageId)
            viewModelStarredMessage.updateStarredMessageData(messageItem.messageId)
            activity!!.invalidateOptionsMenu()
        } else CustomToast.show(this, getString(R.string.msg_no_internet))
    }

    override fun onRetryClicked(item: ChatMessage?) {
        if (AppUtils.isNetConnected(this)) uploadMedia(item!!.messageId) else CustomToast.show(this, getString(R.string.msg_no_internet))
    }

    override fun onSenderItemClicked(item: ChatMessage?, position: Int) {
        handleStarredMediaMessageClick(position)
    }

    override fun onReceiverItemClicked(item: ChatMessage?, position: Int) {
        handleStarredMediaMessageClick(position)
    }

    /**
     * Handle media message item click and long press
     *
     * @param position Position of the item in view
     */
    private fun handleStarredMediaMessageClick(position: Int) {
        try {
            if (clickedStarredMessages.isNotEmpty()) onItemClick(position) else if (position != -1) {
                /**
                 * Compare elapsed time and clicked time to avoid double click action
                 */
                if (SystemClock.elapsedRealtime() - lastClickTime > 1000) {
                    itemPosition = position
                    val clickedMessage =
                        if (viewModelStarredMessage.searchedStarredMessageList.isEmpty()) viewModelStarredMessage.starredMessagesList[position] else viewModelStarredMessage.searchedStarredMessageList[position]
                    startActivity(
                        Intent(this, ChatActivity::class.java)
                            .putExtra(LibConstants.JID, clickedMessage.chatUserJid)
                            .putExtra(LibConstants.MESSAGE_ID, clickedMessage.messageId)
                            .putExtra(Constants.CHAT_TYPE, clickedMessage.getChatType())
                            .putExtra(Constants.IS_STARRED_MESSAGE, true)
                    )
                }
                lastClickTime = SystemClock.elapsedRealtime()
            }
        }catch (e:Exception){
            LogMessage.e(TAG,e)
        }
    }

    override fun onSenderItemLongClick(item: ChatMessage?, position: Int) {
        onItemLongClick(position)
    }

    /**
     * Handle On item long click for the options having delete, forward and info. Add into the
     * selected list for the list showing and do the operations
     *
     * @param starredItemPosition Position of the clicked list item
     */
    private fun onItemLongClick(starredItemPosition: Int) {
        try {
            hideKeyboard()
            if (starredItemPosition != -1) {
                val clickedStarredMessage = if (viewModelStarredMessage.searchedStarredMessageList.isEmpty()) viewModelStarredMessage.starredMessagesList[starredItemPosition] else viewModelStarredMessage.searchedStarredMessageList[starredItemPosition]
                /**
                 * Check already selected and choosing media is available locally.
                 */
                if (!clickedStarredMessages.contains(clickedStarredMessage.messageId)) onSelectItem(clickedStarredMessage,starredItemPosition)
            }
        } catch (e: java.lang.Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }
    override fun onReceiverItemLongClick(item: ChatMessage?, position: Int) {
        onItemClick(position)
    }

    /**
     * Handle On item click for the options having delete, forward and info. and remove that from
     * the selected list
     *
     * @param position Position of the item
     */
    private fun onItemClick(position: Int) {
        try {
            hideKeyboard()
            if (position != -1) {
                val clickedMessage = if (viewModelStarredMessage.searchedStarredMessageList.isEmpty()) viewModelStarredMessage.starredMessagesList[position] else viewModelStarredMessage.searchedStarredMessageList[position]
                /**
                 * Remove the selected item if ta the single item.
                 */
                if (clickedStarredMessages.contains(clickedMessage.messageId)) {
                    clickedStarredMessages.remove(clickedMessage.messageId)
                    starredMessageAdapter!!.setStarredMessageMessages(clickedStarredMessages)
                    starredMessageAdapter!!.notifyItemChanged(position)
                    prepareActionMode()
                    selectedStarredMessagesList.remove(clickedMessage)
                } else {
                    /**
                     * Add the additional element to selected list.
                     */
                    onSelectItem(clickedMessage,position)
                }
            }
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun refreshSelectedMessages(position: Int) {
        starredMessageAdapter!!.setStarredMessageMessages(clickedStarredMessages)
        if (clickedStarredMessages.size == 1)
            starredMessageAdapter!!.notifyDataSetChanged()
        else
            starredMessageAdapter!!.notifyItemChanged(position)
    }

    /**
     * Call back for on item selection
     *
     * @param clickedMessage Selected message item
     */
    private fun onSelectItem(clickedMessage: ChatMessage,position: Int) {
        try {
            /**
             * Check already selected and choosing media is available locally.
             */
            if (MessageType.NOTIFICATION != clickedMessage.messageType) {
                if (clickedStarredMessages.isEmpty()) actionMode =  starredMessageBinding.toolbar.startActionMode(this)
                clickedStarredMessages.add(clickedMessage.messageId)
                selectedStarredMessagesList.add(clickedMessage)
                refreshSelectedMessages(position)
                prepareActionMode()
                updateActionMenuIcons(ChatManager.getAvailableFeatures())
            }
        } catch (e: java.lang.Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun updateActionMenuIcons(features: Features) {
        try {
            menu?.let {
                if (features.isDeleteMessageEnabled)
                    showMenu(it.get(R.id.action_delete))
                else hideMenu(it.get(R.id.action_delete))

                if (features.isStarMessageEnabled) {
                    showMenu(it.get(R.id.action_unfavourite))

                } else {
                    hideMenu(it.get(R.id.action_favourite))
                    hideMenu(it.get(R.id.action_unfavourite))
                }
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e.toString())
        }
    }

    override fun onReplyMessageClick(messageId: String) {
        //Do nthg
    }

    override fun onSenderMediaForward(item: ChatMessage, position: Int) {
        //Do nthg
    }

    override fun onContactClick(item: ChatMessage, position: Int, registeredJid: String?) {
        //Do nthg
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        //Do nthg
    }

    override fun listOptionSelected(position: Int) {
        //invite contact
        if (commonAlertDialog.dialogAction === CommonAlertDialog.DialogAction.INVITE && selectedContactMessage != null)
            InviteContactUtils().handleSelectedOptions(position, activity, null, selectedContactMessage!!.getContactPhoneNumbers()[0])
    }

    override fun onCreateActionMode(actionMode: ActionMode, menu: Menu): Boolean {
        configureActionMode(actionMode, menu)
        return true
    }

    override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
        return false
    }

    override fun onActionItemClicked(p0: ActionMode?, menuItem: MenuItem?): Boolean {
        return onClickAction(menuItem!!.itemId)
    }

    /**
     * On click action boolean of the long press menu.
     *
     * @param itemId The menu item id
     * @return boolean True if click completed
     */
    private fun onClickAction(itemId: Int): Boolean {
        val clickDone: Boolean
        when (itemId) {
            R.id.action_delete -> {
                deleteMessageAction()
                clickDone = true
            }
            R.id.action_copy -> {
                if (clickedStarredMessages.size == 1) copyMessagesActionMenuClicked(
                    clickedStarredMessages as java.util.ArrayList<String>
                )
                actionMode!!.finish()
                clickDone = true
            }
            R.id.action_forward -> clickDone = forwardMessageActionMenuClicked(
                clickedStarredMessages as java.util.ArrayList<String>
            )
            R.id.action_share -> {
                if (clickedStarredMessages.size == 1) shareMedia(clickedStarredMessages as java.util.ArrayList<String>)
                actionMode!!.finish()
                clickDone = true
            }
            R.id.action_unfavourite -> {
                for (messages in selectedStarredMessagesList) {
                    ChatManager.updateFavouriteStatus(
                        messages.messageId,
                        messages.chatUserJid,
                        false,
                        object : ChatActionListener {
                            override fun onResponse(isSuccess: Boolean, message: String) {
                                //Not Needed
                            }
                        })
                }
                actionMode!!.finish()
                updateAdapter()
                clickDone = true
            }
            else -> clickDone = false
        }
        return clickDone
    }
    private fun deleteMessageAction() {
        if (clickedStarredMessages.isNotEmpty()) {
            val messageToShow =
                getString(R.string.msg_are_you_sure_delete_message)+" "+ if (clickedStarredMessages.size > 1) getString(
                    R.string.delete_messages
                ) else getString(R.string.delete_message)
            commonAlertDialog.dialogAction = CommonAlertDialog.DialogAction.DELETE_CHAT
            commonAlertDialog.showAlertDialog(messageToShow,
                getString(R.string.action_delete_for_me),
                getString(R.string.action_cancel),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
                false,false,
                object : CommonDialogClosedListener {
                    override fun onDialogClosed(
                        dialogType: CommonAlertDialog.DIALOGTYPE?,
                        isSuccess: Boolean
                    ) {
                        if (isSuccess)
                            deleteMessage()
                    }

                    override fun listOptionSelected(position: Int) {
                        /*No Implement Needed*/
                    }

                })
        }
    }

    private fun deleteMessage() {
        if (!ChatManager.getAvailableFeatures().isDeleteMessageEnabled) {
            context!!.showToast(resources.getString(R.string.fly_error_forbidden_exception))
            return
        }

        val isMediaDelete = SharedPreferenceManager.getBoolean(Constants.DELETE_MEDIA_FROM_PHONE)
        for (message in selectedStarredMessagesList ) {
            ChatManager.deleteMessagesForMe(message.chatUserJid,
                listOf(message.messageId),
                message.getDeleteChatType(),
                isMediaDelete,
                object : ChatActionListener {
                    override fun onResponse(isSuccess: Boolean, message: String) {
                        /*No Implement Needed*/
                    }
                })

        }
        clickedStarredMessages.clear()
        selectedStarredMessagesList.clear()
        updateAdapter()
        actionMode!!.finish()
    }

    /**
     * Set the action menu for the long press menu
     *
     * @param mode Instance of the Alert dialog action mode
     * @param menu Instance of Menu
     */
    private fun configureActionMode(mode: ActionMode, menu: Menu) {
        this.menu = StarredMessagesUtils.configureStarredMenuActionMode(this, mode, menu)
        menu.findItem(R.id.action_reply).isVisible = false
    }

    override fun onDestroyActionMode(p0: ActionMode?) {
        clickedStarredMessages.clear()
        selectedStarredMessagesList.clear()
        starredMessageAdapter!!.notifyDataSetChanged()
    }

    private fun updateAdapter() {
        viewModelStarredMessage.getStarredMessageList()
        if (searchEnabled && searchedText.isNotEmpty()) {
            searchStarredMessage(searchedText)
        }
    }

    private fun prepareActionMode() {
        menu!!.findItem(R.id.action_favourite).isVisible = false

        // Validate and show action menu while user selecting the message

        // Validate and show action menu while user selecting the message
        if (clickedStarredMessages.isEmpty() && actionMode != null)
            actionMode!!.finish()
        else if (clickedStarredMessages.size == 1 &&
            actionMode != null
        ) {
            actionMode!!.title = java.lang.String.valueOf(
                clickedStarredMessages.size
            )
            menu!!.findItem(R.id.action_favourite).isVisible = false
            menu!!.findItem(R.id.action_unfavourite).isVisible = false
            menu!!.findItem(R.id.action_info).isVisible = false
            StarredMessagesUtils.prepareSingleMenuItem(clickedStarredMessages, menu)
            StarredMessagesUtils.validateFavouriteAction(clickedStarredMessages, menu)
            actionMode!!.title = java.lang.String.valueOf(
                clickedStarredMessages.size
            )
        } else if (actionMode != null) {
            actionMode!!.title = java.lang.String.valueOf(clickedStarredMessages.size)
            menu!!.findItem(R.id.action_info).isVisible = false
            menu!!.findItem(R.id.action_copy).isVisible = false
            menu!!.findItem(R.id.action_share).isVisible = false
            menu!!.findItem(R.id.action_favourite).isVisible = false
            StarredMessagesUtils.validateFavouriteAction(clickedStarredMessages, menu)
        }
    }

    override fun onAudioPlayed() {
        //No Implementation needed
    }

    override fun mediaPermissionCheck() {
        //No Implementation needed
    }

    override fun userBlockedMe(jid: String) {
        super.userBlockedMe(jid)
        viewModelStarredMessage.updateStarredMessageDataByJid(jid)

    }

    override fun userUnBlockedMe(jid: String) {
        super.userUnBlockedMe(jid)
        viewModelStarredMessage.updateStarredMessageDataByJid(jid)

    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        viewModelStarredMessage.updateStarredMessageDataByJid(jid)

    }

    override fun updateFeatureActions(features: Features) {
        updateActionMenuIcons(features)
        updateFeatureRestriction(features)
    }

    private fun updateFeatureRestriction(availableFeatures: Features) {
        if(!availableFeatures.isStarMessageEnabled){
            finish()
            dashboardViewModel.updateFeatureRestriction(ChatManager.getAvailableFeatures())
        }
    }
}