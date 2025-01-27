package com.contusfly.privateChat

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcelable
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.contusfly.*
import com.contusfly.activities.*
import com.contusfly.adapters.RecentChatListAdapter
import com.contusfly.databinding.ActivityPrivateChatListBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.fragments.ProfileDialogFragment
import com.contusfly.interfaces.RecentChatEvent
import com.contusfly.models.PrivateChatAuthenticationModel
import com.contusfly.utils.*
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomRecyclerView
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.models.RecentSearch
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import dagger.android.AndroidInjection
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject


class PrivateChatListActivity : BaseActivity(), ActionMode.Callback,
CommonAlertDialog.CommonDialogClosedListener {

    private lateinit var mContext: Context

    private lateinit var privateChatsBinding: ActivityPrivateChatListBinding

    private var goTo:String=""

    private lateinit var privateListRecent: CustomRecyclerView

    private lateinit var emptyListView: TextView

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(DashboardViewModel::class.java) }

    private val commonAlertDialog by lazy { CommonAlertDialog(this) }


    private val mAdapter by lazy {
        RecentChatListAdapter(this, viewModel.chatAdapter, viewModel.selectedChats, viewModel.typingAndGoneStatus)
    }

    private val permissionAlertDialog : PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private var adminBlockStatus : Boolean = false
    private var userJid:String = Constants.EMPTY_STRING

    private var actionMode: ActionMode? = null
    private lateinit var actionModeMenu: Menu
    private var cabOpen = false
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        SharedPreferenceManager.setBoolean(Constants.PRIVATE_CHAT, true)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)
        privateChatsBinding = ActivityPrivateChatListBinding.inflate(layoutInflater)
        setContentView(privateChatsBinding.root)
        init()
    }

    private fun init(){
        mContext = this@PrivateChatListActivity
        handler = Handler(Looper.getMainLooper())
        getIntentValues()
        viewInitialize()
        handleProfileImageClick()
        profileObserver()
        chatObserver()
        groupObserver()
        getPrivateChat()
    }

    private fun getIntentValues(){
        var intent=getIntent()
        val intentKey =Constants.GO_TO
        if (intent.hasExtra(intentKey)) {
            goTo = intent.getStringExtra(intentKey).toString()
        }
    }

    private fun viewInitialize() {
        setSupportActionBar(privateChatsBinding.toolBar.toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = resources.getString(R.string.label_private_chats)
        }
        privateChatsBinding.toolBar.toolbar.background = ContextCompat.getDrawable(this, R.drawable.gradient_top)
        privateChatsBinding.toolBar.toolbar.setNavigationIcon(R.drawable.ic_back)
        if (Build.VERSION.SDK_INT >= 29) {
            BlendModeColorFilter(
                ContextCompat
                    .getColor(this, R.color.color_black), BlendMode.MULTIPLY
            )
        } else {
            PorterDuffColorFilter(
                ContextCompat.getColor(this, R.color.color_black),
                PorterDuff.Mode.MULTIPLY
            )
        }
        privateChatsBinding.toolBar.toolbar.setNavigationOnClickListener { launchDashboardActivity() }

        privateListRecent = privateChatsBinding.viewListChats
        emptyListView = privateChatsBinding.noArchivedMessage

        with(privateListRecent) {
            layoutManager = LinearLayoutManager(mContext)
            adapter = mAdapter
        }
    }

    private fun showPrivateChatGroupUserBlockedByAdminPopup() {
        commonAlertDialog.showAlertDialog(getString(R.string.group_block_message_label),
            getString(R.string.action_Ok),
            getString(R.string.action_cancel),
            CommonAlertDialog.DIALOGTYPE.DIALOG_SINGLE, false)
    }

    private fun profileDialog(item: RecentChat) {
        if (item.isSingleChat()) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(item.jid)
            if (profileDetails != null)
                showProfileDialog(profileDetails)
        } else {
            GroupManager.getGroupProfile(item.jid, false) { success, _, data ->
                if (success) {
                    val profileDetails = data[Constants.SDK_DATA] as ProfileDetails
                    showProfileDialog(profileDetails)
                }
            }
        }
    }

    private fun handleProfileImageClick() {
        mAdapter.onProfileClickedCallback { itemPosition ->
            val item = viewModel.chatList.value!![itemPosition]
            if (item.isAdminBlocked && ChatType.TYPE_GROUP_CHAT == item.getChatType()) {
                showPrivateChatGroupUserBlockedByAdminPopup()
                return@onProfileClickedCallback
            }
            profileDialog(item)
        }
    }


    private fun showProfileDialog(profileDetails: ProfileDetails) {
        val dialogFragment = ProfileDialogFragment.newInstance(profileDetails)
        val manager = supportFragmentManager
        val frag = manager.findFragmentByTag("dialog")
        if (frag != null) {
            manager.beginTransaction().remove(frag).commit()
        }
        dialogFragment.show(manager, "dialog")
    }

    private fun profileObserver() {
        viewModel.isContactSyncSuccess.observe(this, { viewModel.getArchivedChats() })
        viewModel.updateMessageStatus.observe(this, { updateMessage(it) })
        viewModel.profileUpdatedLiveData.observe(this, {
            LogMessage.i(TAG, "profileUpdatedLiveData observed")
            onPrivateChatProfileUpdated(it)
        })

        viewModel.isUserBlockedUnblockedMe.observe(this, {
            val index = viewModel.chatList.value!!.indexOfFirst { recent -> recent.jid ?: Constants.EMPTY_STRING == it.first.trim() }
            if (index.isValidIndex()) {
                viewModel.getArchiveChatOfUser(it.first.trim(), RecentChatEvent.GROUP_EVENT)
            }
        })

        viewModel.isUserBlockedByAdmin.observe(this, {
            val index = viewModel.chatList.value!!.indexOfFirst { recent -> recent.jid ?: Constants.EMPTY_STRING == it.first.trim() }
            if (index.isValidIndex()) {
                viewModel.chatList.value!![index].isAdminBlocked = it.second
                val bundle = Bundle()
                bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 2)
                mAdapter.notifyItemChanged(index, bundle)
            }
        })
    }

    private fun chatObserver(){

        viewModel.chats.observe(this, { recentPair ->
            LogMessage.i(TAG, "recentChat observed")
            if (recentPair.second.isValidIndex()) {
                val bundle = Bundle()
                when (recentPair.first) {
                    RecentChatEvent.MESSAGE_RECEIVED, RecentChatEvent.MESSAGE_UPDATED -> {
                        bundle.putInt(Constants.NOTIFY_MESSAGE, 1)
                        bundle.putInt(Constants.NOTIFY_USER_NAME, 1)
                        bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 1)
                        bundle.putInt(Constants.NOTIFY_MUTE_UNMUTE, 1)
                    }
                    RecentChatEvent.GROUP_EVENT -> {
                        bundle.putInt(Constants.NOTIFY_MESSAGE, 1)
                        bundle.putInt(Constants.NOTIFY_USER_NAME, 1)
                        bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 1)
                    }
                    RecentChatEvent.MUTE_EVENT -> {
                        bundle.putInt(Constants.NOTIFY_MUTE_UNMUTE, 1)
                    }
                }
                mAdapter.notifyItemRangeChanged(recentPair.third, recentPair.second + 1, bundle)
            } else viewModel.getChatDiffResult()
        })

        viewModel.changedReadUnReadPosition.observe(this, {
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_UNREAD_ICON, 0)
            bundle.putInt(Constants.NOTIFY_SELECTION, 4)
            mAdapter.notifyItemChanged(it, bundle)
        })

        viewModel.chatDiffResult.observe(this, {
            LogMessage.i(TAG, "recentChatDiffResult observed")
            initChatAdapter(it)
        })

        viewModel.updateChatMute.observe( this, { pair ->
            try {
                mAdapter.notifyItemChanged(pair.first)
            } catch(e: Exception){
                com.mirrorflysdk.flycommons.LogMessage.e(TAG,"#mute #chat adapter update exception $e")
            }
        })

        viewModel.updateSelectedChat.observe(this) {
            privateChatClick(viewModel.selectedChats, false)
        }

    }

    private fun groupObserver(){

        viewModel.groupUpdatedLiveData.observe(this, { onGroupUpdated() })

        viewModel.groupNewUserAddedLiveData.observe(this, { onGroupUpdated() })

        viewModel.groupUserRemovedLiveData.observe(this, { onGroupUpdated() })

        viewModel.groupAdminChangedLiveData.observe(this, { onGroupUpdated() })
    }

    private fun getPrivateChatFor(jId: String, @RecentChatEvent event: String) {
        viewModel.getPrivateChatOfUser(jId, event)
    }

    private fun updateMessage(messageId: String) {
        try {
            if (messageId.isEmpty()) return
            val index = viewModel.chatList.value?.indexOfFirst { it.lastMessageId == messageId }?:-1
            if (index.isValidIndex()) {
                getPrivateChatFor(viewModel.chatList.value!![index].jid, RecentChatEvent.MESSAGE_UPDATED)
            }
        } catch (e:Exception) {
            Log.e(TAG, "updateMessage: $e")
        }
    }

    private fun onPrivateChatProfileUpdated(jid: String) {
        val bundle = Bundle()
        bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 2)
        bundle.putInt(Constants.NOTIFY_MUTE_UNMUTE, 2)
        val index = viewModel.chatList.value?.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == jid } ?: -1
        profileAdapterChange(index,bundle,jid)

    }

    private fun profileAdapterChange(index: Int, bundle: Bundle, jid: String) {
        if (index.isValidIndex()) {
            val recent = FlyCore.getRecentChatOf(jid)
            recent?.let {
                viewModel.chatList.value!![index] = recent
                viewModel.chatAdapter[index] = recent
            }
            mAdapter.notifyItemChanged(index, bundle)
        }
    }

    private fun onGroupUpdated() {
        viewModel.getPrivateChats()
    }

    private fun initChatAdapter(diffUtilResult: DiffUtil.DiffResult?) {
        if (diffUtilResult != null) {
            // Save Current Scroll state to retain scroll position after DiffUtils Applied
            val previousState = privateListRecent.layoutManager?.onSaveInstanceState() as Parcelable
            diffUtilResult.dispatchUpdatesTo(mAdapter)
            privateListRecent.layoutManager?.onRestoreInstanceState(previousState)
        }
        mAdapter.notifyDataSetChanged()
        setEmptyView(if (viewModel.chatAdapter.size <= 4) View.VISIBLE else View.GONE)
    }

    private fun setEmptyView(visible: Int) {
        emptyListView.visibility = visible
        emptyListView.text = getString(R.string.no_private_chats)
    }

    private fun getPrivateChat() {
        setListeners()
        viewModel.getPrivateChats()
    }

    private fun setListeners() {
        commonAlertDialog.setOnDialogCloseListener(this)
        val itemclickSupport = ItemClickSupport(privateListRecent).addTo()
        clickListener(itemclickSupport)
    }

    private fun clickListener(itemclickSupport: ItemClickSupport) {
        itemclickSupport.setOnItemClickListener { _, position, _ ->
            if (position.isValidIndex())
                handleOnPrivateChatItemClicked(position)
        }

        itemclickSupport.setOnItemLongClickListener { _, position, _ ->
            handlePrivateChatOnItemLongClicked(position)
            true
        }
    }

    private fun handleOnPrivateChatItemClicked(position: Int) {
        if (viewModel.selectedChats.isEmpty())
            setupPrivateChatProfileItemClickEvent(viewModel.chatList.value!![position])
        else {
            itemClick(position)
        }
    }

    private fun itemClick(position: Int) {
        val bundle = Bundle()
        bundle.putInt(Constants.NOTIFY_SELECTION, 4)
        val selectedChats = viewModel.chatList.value!![position]
        if (viewModel.selectedChats.any { it.jid == selectedChats.jid }) {
            viewModel.selectedChats.remove(viewModel.selectedChats.first { it.jid == selectedChats.jid })
        } else if (!selectedChats.isGroup && !viewModel.selectedChats[0].isGroup
            || viewModel.selectedChats.isNotEmpty())
            viewModel.selectedChats.add(selectedChats)
        mAdapter.notifyItemChanged(position, bundle)
        privateChatClick(viewModel.selectedChats, false)
    }

    private fun setupPrivateChatProfileItemClickEvent(item: RecentChat) {
        try {
            NotificationManagerCompat.from(this).cancel(Constants.NOTIFICATION_ID)
            val jid = Utils.returnEmptyStringIfNull(item.jid)
            openPrivateChatActivity(jid, item.getChatType(), item.isAdminBlocked)
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun openPrivateChatActivity(jid: String?, chatType: String, status: Boolean) {
        if (status && ChatType.TYPE_GROUP_CHAT == chatType) {
            showPrivateChatGroupUserBlockedByAdminPopup()
        } else {
            val intent = Intent(activity, ChatActivity::class.java)
            intent.putExtra(LibConstants.JID, jid)
            intent.putExtra(Constants.CHAT_TYPE, chatType)
            myActivityResultLauncher.launch(intent)
        }
    }

    private var myActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                finish()
            }
        }

    /**
     * Handle the long click on the recent chat
     *
     * @param position Position of the list view
     */
    private fun handlePrivateChatOnItemLongClicked(position: Int) {
        val selectedChats = viewModel.chatList.value!![position]
        if (!viewModel.selectedChats.contains(selectedChats)) {
            viewModel.selectedChats.add(selectedChats)
            itemLongClick(position)
        }
    }

    private fun itemLongClick(position: Int) {
        privateChatClick(viewModel.selectedChats, true)
        val bundle = Bundle()
        bundle.putInt(Constants.NOTIFY_SELECTION, 4)
        mAdapter.notifyItemChanged(position, bundle)
    }

    private fun privateChatClick(recentList: List<RecentChat>, startActionMode: Boolean) {
        if (recentList.isEmpty()) actionMode?.finish()
        else {
            privateChatListeItemClick(recentList,startActionMode)
        }
    }

    private fun privateChatListeItemClick(recentList: List<RecentChat>, startActionMode: Boolean) {
        if (recentList.size == 1 && startActionMode) setActionMode()
        privateChatMenuValidationForMuteUnMuteIcon(recentList)
        updateActionMenuIcons(ChatManager.getAvailableFeatures(),recentList)
        privateChatmenuValidationForMarkReadUnReadIcon(recentList)
        actionMode?.title = recentList.size.toString()
    }

    private fun privateChatMenuValidationForMuteUnMuteIcon(recentList: List<RecentChat>) {
        val checkListMuteUnMuteIcon = ArrayList<Boolean>()
        val leftgroupList = ArrayList<String>()
        for (i in recentList.indices) {
            if (!recentList[i].isBroadCast)
                checkListMuteUnMuteIcon.add(recentList[i].isMuted)

            if(recentList[i].isGroup && !GroupManager.isMemberOfGroup(recentList[i].jid,SharedPreferenceManager.getCurrentUserJid())){
                leftgroupList.add(recentList[i].jid)
            }
        }
        when {

            leftgroupList.size > 0 -> {
                hideMuteAndUnMuteVisibility()
            }

            checkListMuteUnMuteIcon.contains(false) -> {
                actionModeMenu.findItem(R.id.action_mute).isVisible = true
                actionModeMenu.findItem(R.id.action_unmute).isVisible = false
            }
            checkListMuteUnMuteIcon.contains(true) -> {
                actionModeMenu.findItem(R.id.action_mute).isVisible = false
                actionModeMenu.findItem(R.id.action_unmute).isVisible = true
            }
            else -> {
                hideMuteAndUnMuteVisibility()
            }
        }
    }

    private fun hideMuteAndUnMuteVisibility() {
        actionModeMenu.findItem(R.id.action_mute).isVisible = false
        actionModeMenu.findItem(R.id.action_unmute).isVisible = false
    }

    private fun updateActionMenuIcons(features: Features, recentList: List<RecentChat>) {
        try {
            actionModeMenu?.let {
                if (features.isDeleteChatEnabled)
                    menuValidationForDelete(recentList)
                else hideMenu(it.get(R.id.action_delete))
            }
        } catch(e:Exception) {
            LogMessage.e(TAG,e.toString())
        }
    }

    private fun menuValidationForDelete(recentList: List<RecentChat>) {
        val groupCheck = ArrayList<Boolean>()
        for (i in recentList.indices)
            if (recentList[i].isGroup)
                groupCheck.add(true)
        actionModeMenu.findItem(R.id.action_delete).isVisible = showDeleteOption(recentList)
    }

    private fun showDeleteOption(recentList: List<RecentChat>):Boolean{
        for(item in recentList){
            if((item.getChatType() == ChatType.TYPE_GROUP_CHAT) && ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(item.jid,
                    SharedPreferenceManager.getCurrentUserJid()))
                return false
        }
        return true
    }

    private fun privateChatmenuValidationForMarkReadUnReadIcon(recentList: List<RecentChat>) {
        LogMessage.d(TAG, "MarkUnread - privateChatmenuValidationForMarkReadUnReadIcon")
        val list = ArrayList<Boolean>()
        for (i in recentList.indices)
            list.add(recentList[i].isConversationUnRead)

        readUnRead(list)
    }

    private fun readUnRead(list: ArrayList<Boolean>) {
        if (!list.contains(true)) {
            actionModeMenu.findItem(R.id.action_mark_read).isVisible = false
            actionModeMenu.findItem(R.id.action_mark_unread).isVisible = true
        } else {
            actionModeMenu.findItem(R.id.action_mark_read).isVisible = true
            actionModeMenu.findItem(R.id.action_mark_unread).isVisible = false
        }
    }

    /**
     * Alert dialog while the user wants to delete chats
     */
    private fun privateChatdeleteChatAlert() {
        val selectedMessages = viewModel.selectedChats
        // Delete the one chat
        val deleteMessage = if (selectedMessages.size == 1) {
            val userNickName = ProfileDetailsUtils.getDisplayName(selectedMessages[0].jid)
            String.format(getString(R.string.msg_delete_chat_single_conversation), userNickName)
        } else String.format(getString(R.string.msg_delete_chat_multiple_conversation), selectedMessages.size)// Delete the multiple chats
        commonAlertDialog.showAlertDialog(deleteMessage, getString(R.string.action_yes), getString(R.string.action_no),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
    }

    private fun setActionMode() {
        if (!cabOpen) {
            //Note: Each time startActionMode is called onDestroyActionMode will be called on any existing CAB
            actionMode = privateChatsBinding.toolBar.toolbar.startActionMode(this)
            cabOpen = true
        }
    }

    override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
        configureActionMode(p0!!, p1!!)
        return true
    }

    /**
     * Set the action menu for the long press menu.
     *
     * @param mode Action mode
     * @param menu Long press menu
     */
    private fun configureActionMode(mode: ActionMode, menu: Menu) {
        val inflater = mode.menuInflater
        inflater.inflate(R.menu.menu_private_chat, menu)
        actionModeMenu = menu
    }

    override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
        p1?.findItem(R.id.action_mute)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        p1?.findItem(R.id.action_unmute)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        p1?.findItem(R.id.action_delete)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        p1?.findItem(R.id.action_mark_read)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)
        p1?.findItem(R.id.action_mark_unread)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)
        return true
    }

    override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
        onClickAction(p1!!.itemId)
        return true
    }


    /**
     * On click action on the menu when the private chat long pressed it.
     *
     * @param itemId The item id
     * @return boolean True if the item has click handled successfully.
     */
    private fun onClickAction(itemId: Int): Boolean {
        when (itemId) {
            R.id.action_delete -> {
                privateChatdeleteChatAlert()
                return true
            }

            R.id.action_mute -> {
                viewModel.updateArchivedMuteNotification(Constants.MUTE_NOTIFY)
                updateChatItem()
                actionMode?.finish()
                return true
            }
            R.id.action_unmute -> {
                viewModel.updateArchivedMuteNotification(Constants.UN_MUTE_NOTIFY)
                updateChatItem()
                actionMode?.finish()
                return true
            }

            R.id.action_mark_unread -> {
                viewModel.markAsUnreadPrivateChats()
                actionMode?.finish()
                return true
            }
            R.id.action_mark_read -> {
                markasRead()
                actionMode?.finish()
                return true
            }
            else -> return false
        }
    }

    private fun updateChatItem() {
        if (viewModel.selectedChats.isNotEmpty()) {
            for (item in viewModel.selectedChats) {
                val index = viewModel.chatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == item.jid }
                if (index.isValidIndex()) {
                    getPrivateChatFor(viewModel.chatList.value!![index].jid, RecentChatEvent.MUTE_EVENT)
                }
            }
            viewModel.selectedChats.clear()
        }
    }

    override fun onDestroyActionMode(p0: ActionMode?) {
        cabOpen = false
        privateChatClearSelectedMessages()
    }

    private fun privateChatClearSelectedMessages() {
        LogMessage.d(TAG, "privatechatclearSelectedMessages")
        if (viewModel.selectedChats.isNotEmpty()) {
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_SELECTION, 4)
            for (item in viewModel.selectedChats) {
                val index = viewModel.chatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == item.jid }
                if (index.isValidIndex())
                    mAdapter.notifyItemChanged(index, bundle)
            }
            viewModel.selectedChats.clear()
        }
    }

    /**
     * Called when get updated user profile.
     */
    override fun userProfileFetched(jid: String, profileDetails: ProfileDetails) {
        super.userProfileFetched(jid, profileDetails)
        viewModel.profileUpdatedLiveData.value = jid
    }


    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        privateChatUserUpdateProfile(jid)
    }

    private fun privateChatUserUpdateProfile(jid: String) {
        viewModel.profileUpdatedLiveData.value = jid
    }


    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        privateChatUserDeletedHisProfile(jid)
    }

    private fun privateChatUserDeletedHisProfile(jid: String) {
        viewModel.profileUpdatedLiveData.value = jid
    }

    override fun onNewMemberAddedToGroup(groupJid: String, newMemberJid: String, addedByMemberJid: String) {
        super.onNewMemberAddedToGroup(groupJid, newMemberJid, addedByMemberJid)
        privateChatNewMemberAddedGroup(groupJid)

    }

    private fun privateChatNewMemberAddedGroup(groupJid: String) {
        viewModel.groupNewUserAddedLiveData.value = groupJid
    }

    override fun onMemberRemovedFromGroup(groupJid: String, removedMemberJid: String, removedByMemberJid: String) {
        super.onMemberRemovedFromGroup(groupJid, removedMemberJid, removedByMemberJid)
        privateChatMemberRemovedFromGroup(groupJid)
    }

    private fun privateChatMemberRemovedFromGroup(groupJid: String) {
        viewModel.groupUserRemovedLiveData.value = groupJid
    }

    override fun onGroupProfileUpdated(groupJid: String) {
        super.onGroupProfileUpdated(groupJid)
        privateChatGroupProfileUpdate(groupJid)
    }

    private fun privateChatGroupProfileUpdate(groupJid: String) {
        viewModel.groupUpdatedLiveData.value = groupJid
    }

    override fun onMemberMadeAsAdmin(groupJid: String, newAdminMemberJid: String, madeByMemberJid: String) {
        super.onMemberMadeAsAdmin(groupJid, newAdminMemberJid, madeByMemberJid)
        privateChatGroupMadeAsAdmin(groupJid)
    }

    private fun privateChatGroupMadeAsAdmin(groupJid: String) {
        viewModel.groupAdminChangedLiveData.value = groupJid
    }

    override fun onMessageReceived(message: ChatMessage) {
        privateChatOnMessageReceived(message)
    }

    private fun privateChatOnMessageReceived(message: ChatMessage){
        getPrivateChatFor(message.getChatUserJid(), RecentChatEvent.MESSAGE_RECEIVED)
    }

    override fun onMessageStatusUpdated(messageId: String) {
        privateChatMessageStatusUpdate(messageId)
    }

    private fun privateChatMessageStatusUpdate(messageId: String) {
        if (messageId.isEmpty()) return
        viewModel.setMessageStatus(messageId)
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (!isSuccess)
            return
        if (dialogType == CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL) {
            deleteSelectedRecent(getJidFromList(viewModel.selectedChats))
        }
    }

    override fun listOptionSelected(position: Int) {
        LogMessage.d(TAG, position.toString())
    }

    override fun onLeftFromGroup(groupJid: String, leftUserJid: String) {
        super.onLeftFromGroup(groupJid, leftUserJid)
        onGroupUpdated()
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        adminBlockStatus = status
        userJid = jid
        //To avoid multiple callbacks
        handler?.postDelayed({
            viewModel.setAdminBlockedStatus(userJid, adminBlockStatus)
        }, 500)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getPrivateChats()
    }

    override fun onRestart() {
        super.onRestart()
        getPrivateChat()
    }

    override fun updateFeatureActions(features: Features) {
        updateActionMenuIcons(features, viewModel.selectedChats)
    }

    /**
     * Removes the selected chat from the recent chat history.
     *
     * @param selectedJids the recent chat jid list.
     */
    open fun deleteSelectedRecent(selectedJids: List<String>) {
        try {
            var feature = ChatManager.getAvailableFeatures()
            if (!feature.isDeleteChatEnabled) {
                context!!.showToast(resources.getString(R.string.fly_error_forbidden_exception))
                return
            }
            ChatManager.deleteRecentChats(selectedJids, object : ChatActionListener {
                override fun onResponse(isSuccess: Boolean, message: String) {
                    /*No Implementation needed*/
                }
            })
            updateAdapter()
            actionMode?.finish()
        } catch (e:Exception) {
            LogMessage.e(TAG,e)
        }
    }

    fun updateAdapter() {
        try {
            for (item in viewModel.selectedChats) {
                val index =
                    viewModel.chatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == item.jid }
                if (index.isValidIndex()) {
                    viewModel.chatList.value!!.removeAt(index)
                    viewModel.chatAdapter.removeAt(index)
                    mAdapter.notifyItemRemoved(index)
                }
            }
            viewModel.selectedChats.clear()
            setEmptyView(if (viewModel.chatAdapter.size <= 4) View.VISIBLE else View.GONE)
        } catch (e:Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(TAG,e)
        }
    }

    private fun getJidFromList(recentObjects: List<Any>): List<String> {
        val jids = ArrayList<String>()
        var i = 0
        val size = recentObjects.size
        while (i < size) {
            when (val recentObject = recentObjects[i]) {
                is RecentChat -> jids.add(recentObject.jid)
                is RecentSearch -> jids.add(recentObject.jid)
                else -> throw ClassCastException("Unsupported object type")
            }
            i++
        }
        return jids
    }

    private fun markasRead(){
        if(MediaPermissions.isNotificationPermissionAllowed(this)){
            netConditionalCall({ viewModel.markAsReadPrivateChats(this) }, { showErrorMessage() })
        } else {
            notificationPermissionChecking()
        }
    }

    private fun showErrorMessage() {
        showToast(if (AppUtils.isNetConnected(this))
            getString(R.string.api_call_error) else getString(R.string.msg_no_internet))
    }

    private fun notificationPermissionChecking(){
        MediaPermissions.requestNotificationPermission(
            this,
            permissionAlertDialog,
            notificationPermissionLauncher)

    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { _ ->
        if(ChatUtils.checkNotificationPermission(this, Manifest.permission.POST_NOTIFICATIONS)){
            markasRead()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: PrivateChatAuthenticationModel?) {
       if(messageEvent!!.isAutheticationShow) {
           launchAuthPinActivity()
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

    override fun onDestroy() {
        super.onDestroy()
        SharedPreferenceManager.setBoolean(Constants.PRIVATE_CHAT, false)
    }

    override fun onBackPressed() {
        launchDashboardActivity()
        super.onBackPressed()
    }

    private fun launchDashboardActivity() {
        if(goTo.isNotEmpty()){
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        } else {
            finish()
        }
    }
    override fun onMuteStatusUpdated(isSuccess: Boolean,message: String,jidList: List<String>) {
        super.onMuteStatusUpdated(isSuccess,message,jidList)
        LogMessage.d("DashboardActivity", "#mute #recentChat update")
        viewModel.archiveANDPrivateChatmuteChatStatusUpdate(jidList)
        if(viewModel.selectedChats.size > 0) {
            viewModel.muteChatStatusUpdateSelectedPrivateAndArchiveChat(jidList)
        }
    }

    override fun onGroupNotificationMessage(message: ChatMessage) {
        if((message.messageTextContent.contains("removed you") || message.messageTextContent.contains("added you") || message.messageTextContent.contains("You left")) &&
            viewModel.selectedChats.isNotEmpty())
            privateChatMenuValidationForMuteUnMuteIcon(viewModel.selectedChats)
        viewModel.getPrivateChatOfUser(message.chatUserJid, RecentChatEvent.GROUP_EVENT)
    }

}