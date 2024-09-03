package com.contusfly.activities

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcelable
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.Features
import com.mirrorflysdk.flycommons.FlyCallback
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.adapters.RecentChatListAdapter
import com.contusfly.adapters.RecentChatSearchAdapter
import com.contusfly.databinding.ActivityArchivedChatsBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.fragments.ProfileDialogFragment
import com.contusfly.interfaces.RecentChatEvent
import com.contusfly.utils.*
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomRecyclerView
import com.contusfly.views.DoProgressDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import java.util.*
import javax.inject.Inject

class ArchivedChatsActivity : BaseActivity(), ActionMode.Callback,
    CommonAlertDialog.CommonDialogClosedListener {

    private lateinit var archivedChatsBinding: ActivityArchivedChatsBinding

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    /**
     * enum constants for List type, used to differentiate the list in the archive chat view
     */
    enum class ArchiveChatListType {
        ARCHIVE,
        SEARCH;
    }

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(DashboardViewModel::class.java) }

    private lateinit var archivedListRecent: CustomRecyclerView

    private lateinit var emptyView: TextView

    private var isAdapterNeedSync = true

    private var isDeleteChat = false

    private val mAdapter by lazy {
        RecentChatListAdapter(this, viewModel.chatAdapter, viewModel.selectedChats, viewModel.typingAndGoneStatus)
    }

    private lateinit var searchKey: String

    private val mArchiveSearchList = ArrayList<com.contusfly.models.RecentSearch>()

    private val mSearchAdapter by lazy { RecentChatSearchAdapter(this, mArchiveSearchList) }

    private var mArchiveChatListType = ArchiveChatListType.ARCHIVE

    private val commonAlertDialog by lazy { CommonAlertDialog(this) }

    private var adminBlockStatus : Boolean = false
    private var userJid:String = Constants.EMPTY_STRING
    private var handler: Handler? = null

    /**
     * Keep track of whether the contextual action bar is open
     */
    private var cabOpen = false
    private var actionMode: ActionMode? = null
    private lateinit var actionModeMenu: Menu
    private var doProgressDialog: DoProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        handler = Handler(Looper.getMainLooper())
        archivedChatsBinding = ActivityArchivedChatsBinding.inflate(layoutInflater)
        setContentView(archivedChatsBinding.root)
        initViews()
    }

    override fun onRestart() {
        super.onRestart()
        setAndFetchData()
    }

    private fun initViews() {
        setSupportActionBar(archivedChatsBinding.toolbar)
        UserInterfaceUtils.setUpToolBar(this, archivedChatsBinding.toolbar, supportActionBar, Constants.EMPTY_STRING)
        archivedListRecent = archivedChatsBinding.viewListChats
        emptyView = archivedChatsBinding.noArchivedMessage

        with(archivedListRecent) {
            layoutManager = LinearLayoutManager(this@ArchivedChatsActivity)
            adapter = mAdapter
        }
        handleProfileImageClick()
        setObservers()
        setAndFetchData()
    }

    private fun handleProfileImageClick() {
        mAdapter.onProfileClickedCallback { itemPosition ->
            val item = viewModel.chatList.value!![itemPosition]
            if (item.isAdminBlocked && ChatType.TYPE_GROUP_CHAT == item.getChatType()) {
                showGroupUserBlockedByAdminPopup()
                return@onProfileClickedCallback
            }
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
    }

    private fun showGroupUserBlockedByAdminPopup() {
        commonAlertDialog.showAlertDialog(getString(R.string.group_block_message_label),
            getString(R.string.action_Ok),
            getString(R.string.action_cancel),
            CommonAlertDialog.DIALOGTYPE.DIALOG_SINGLE, false)
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

    private fun setObservers() {
        viewModel.updateMessageStatus.observe(this, { updateMessageUpdate(it) })
        viewModel.profileUpdatedLiveData.observe(this, {
            LogMessage.i(TAG, "profileUpdatedLiveData observed")
            onProfileUpdated(it)
        })

        viewModel.isContactSyncSuccess.observe(this, { viewModel.getArchivedChats() })

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

        viewModel.chatDiffResult.observe(this, {
            LogMessage.i(TAG, "recentChatDiffResult observed")
            initChatAdapter(it)
        })

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

        viewModel.filterArchivedChatList.observe(this, { observeFilteredArchiveChatList(it) })

        viewModel.searchKeyLiveData.observe(this, { doSearch(it) })

        viewModel.groupUpdatedLiveData.observe(this, { onGroupUpdated() })

        viewModel.groupNewUserAddedLiveData.observe(this, { onGroupUpdated() })

        viewModel.groupUserRemovedLiveData.observe(this, { onGroupUpdated() })

        viewModel.groupAdminChangedLiveData.observe(this, { onGroupUpdated() })
    }

    private fun setAndFetchData() {
        setListeners()
        if (viewModel.chatAdapter.size == 0) {
            archivedChatsBinding.dataLoader.visibility = View.VISIBLE
        }
        viewModel.getArchivedChats()
    }

    private fun setListeners() {
        commonAlertDialog.setOnDialogCloseListener(this)
        val clickSupport = ItemClickSupport(archivedListRecent).addTo()

        clickSupport.setOnItemClickListener { _, position, _ ->
            if (position.isValidIndex())
                handleOnItemClicked(position)
        }

        clickSupport.setOnItemLongClickListener { _, position, _ ->
            handleOnItemLongClicked(position)
            true
        }

        mSearchAdapter.searchItemClickedCallback {
            val recentItem = mArchiveSearchList[it]
            val recentChat = FlyCore.getRecentChatOf(recentItem.jid.returnEmptyIfNull())
            openChatActivity(recentItem.jid.returnEmptyIfNull(), recentItem.chatType, recentChat!!.isAdminBlocked)
        }
    }

    /**
     * Called when get updated user profile.
     */
    override fun userProfileFetched(jid: String, profileDetails: ProfileDetails) {
        super.userProfileFetched(jid, profileDetails)
        viewModel.profileUpdatedLiveData.value = jid
    }

    /**
     * Called when the profile update of the logged in user has been completed successfully.
     */
    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        viewModel.profileUpdatedLiveData.value = jid
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        viewModel.profileUpdatedLiveData.value = jid
    }

    /**
     * Handle the new user added in the group.
     *
     * @param groupJid Group jid
     * @param newMemberJid Jabber id of the User
     * @param addedByMemberJid Jid of user who adds the member
     */
    override fun onNewMemberAddedToGroup(groupJid: String, newMemberJid: String, addedByMemberJid: String) {
        super.onNewMemberAddedToGroup(groupJid, newMemberJid, addedByMemberJid)
        viewModel.groupNewUserAddedLiveData.value = groupJid
    }

    /**
     * Handle the user removed from the group
     *
     * @param groupJid Group id
     * @param removedMemberJid Removed member Jid
     * @param removedByMemberJid Made remove member jid
     */
    override fun onMemberRemovedFromGroup(groupJid: String, removedMemberJid: String, removedByMemberJid: String) {
        super.onMemberRemovedFromGroup(groupJid, removedMemberJid, removedByMemberJid)
        viewModel.groupUserRemovedLiveData.value = groupJid
    }

    /**
     * Called when the group is updated
     *
     * @param groupJid Group jid
     */
    override fun onGroupProfileUpdated(groupJid: String) {
        super.onGroupProfileUpdated(groupJid)
        viewModel.groupUpdatedLiveData.value = groupJid
    }

    /**
     * Called when the group admin changed the affiliation
     *
     * @param groupJid Group jid
     * @param newAdminMemberJid New admin jid
     * @param madeByMemberJid Made new admin jid
     */
    override fun onMemberMadeAsAdmin(groupJid: String, newAdminMemberJid: String, madeByMemberJid: String) {
        super.onMemberMadeAsAdmin(groupJid, newAdminMemberJid, madeByMemberJid)
        viewModel.groupAdminChangedLiveData.value = groupJid
    }

    /**
     * Handle the click operation the recycler view in the recent chats
     *
     * @param position Position of the list view
     */
    private fun handleOnItemClicked(position: Int) {
        if (viewModel.selectedChats.isEmpty())
            setupProfileItemClickEvent(viewModel.chatList.value!![position])
        else {
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_SELECTION, 4)
            val selectedChats = viewModel.chatList.value!![position]
            if (viewModel.selectedChats.any { it.jid == selectedChats.jid }) {
                viewModel.selectedChats.remove(viewModel.selectedChats.first { it.jid == selectedChats.jid })
            } else if (!selectedChats.isGroup && !viewModel.selectedChats[0].isGroup
                || viewModel.selectedChats.isNotEmpty())
                viewModel.selectedChats.add(selectedChats)
            mAdapter.notifyItemChanged(position, bundle)
            recentClick(viewModel.selectedChats, false)
        }
    }

    private fun setupProfileItemClickEvent(item: RecentChat) {
        try {
            NotificationManagerCompat.from(this).cancel(Constants.NOTIFICATION_ID)
            val jid = Utils.returnEmptyStringIfNull(item.jid)
            openChatActivity(jid, item.getChatType(), item.isAdminBlocked)
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    private fun openChatActivity(jid: String?, chatType: String, status: Boolean) {
        if (status && ChatType.TYPE_GROUP_CHAT == chatType) {
            showGroupUserBlockedByAdminPopup()
        } else {
            launchActivity<ChatActivity> {
                putExtra(LibConstants.JID, jid)
                putExtra(Constants.CHAT_TYPE, chatType)
            }
        }
    }

    /**
     * Handle the long click on the recent chat
     *
     * @param position Position of the list view
     */
    private fun handleOnItemLongClicked(position: Int) {
        val selectedChats = viewModel.chatList.value!![position]
        if (!viewModel.selectedChats.contains(selectedChats)) {
            viewModel.selectedChats.add(selectedChats)
            recentClick(viewModel.selectedChats, true)
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_SELECTION, 4)
            mAdapter.notifyItemChanged(position, bundle)
        }
    }

    private fun recentClick(recentList: List<RecentChat>, startActionMode: Boolean) {
        if (recentList.isEmpty()) actionMode?.finish()
        else {
            if (recentList.size == 1 && startActionMode) setActionMode()
            menuValidationForMuteUnMuteIcon(recentList)
            actionModeMenu.findItem(R.id.action_unarchive).isVisible = true
            updateActionMenuIcons(ChatManager.getAvailableFeatures(),recentList)
            menuValidationForReadUnRead(recentList)
            actionMode?.title = recentList.size.toString()
        }
    }

    private fun menuValidationForMuteUnMuteIcon(recentList: List<RecentChat>) {
        val checkListForMuteUnMuteIcon = ArrayList<Boolean>()
        for (i in recentList.indices)
            if (!recentList[i].isBroadCast)
                checkListForMuteUnMuteIcon.add(recentList[i].isMuted)
        if (FlyCore.isArchivedSettingsEnabled()) {
            actionModeMenu.findItem(R.id.action_mute).isVisible = false
            actionModeMenu.findItem(R.id.action_unmute).isVisible = false
            return
        }
        when {
            checkListForMuteUnMuteIcon.contains(false) -> {
                actionModeMenu.findItem(R.id.action_mute).isVisible = true
                actionModeMenu.findItem(R.id.action_unmute).isVisible = false
            }
            checkListForMuteUnMuteIcon.contains(true) -> {
                actionModeMenu.findItem(R.id.action_mute).isVisible = false
                actionModeMenu.findItem(R.id.action_unmute).isVisible = true
            }
            else -> {
                actionModeMenu.findItem(R.id.action_mute).isVisible = false
                actionModeMenu.findItem(R.id.action_unmute).isVisible = false
            }
        }
    }

    private fun menuValidationForDelete(recentList: List<RecentChat>) {
        val groupCheck = ArrayList<Boolean>()
        for (i in recentList.indices)
            if (recentList[i].isGroup)
                groupCheck.add(true)
        actionModeMenu.findItem(R.id.action_delete).isVisible = showDeleteOption(recentList)
        if (FlyCore.isArchivedSettingsEnabled()) actionModeMenu.findItem(R.id.action_unmute).isVisible = false
    }

    private fun showDeleteOption(recentList: List<RecentChat>):Boolean{
        for(item in recentList){
            if((item.getChatType() == ChatType.TYPE_GROUP_CHAT) && ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(item.jid,
                    SharedPreferenceManager.getCurrentUserJid()))
                return false
        }
        return true
    }

    private fun setAdapterBasedOnSearchType() {
        if (mArchiveChatListType == ArchiveChatListType.ARCHIVE && archivedListRecent.adapter is RecentChatSearchAdapter) {
            archivedListRecent.adapter = mAdapter
        } else if (mArchiveChatListType == ArchiveChatListType.SEARCH && archivedListRecent.adapter is RecentChatListAdapter) {
            archivedListRecent.adapter = mSearchAdapter
        }
    }

    private fun menuValidationForReadUnRead(recentList: List<RecentChat>) {
        val list = ArrayList<Boolean>()
        val groupCheck = ArrayList<Boolean>()
        for (i in recentList.indices) {
            list.add(recentList[i].unreadMessageCount > 0)
            if (recentList[i].isGroup)
                groupCheck.add(true)
        }
    }

    private fun updateMessageUpdate(messageId: String) {
        try {
            if (messageId.isEmpty()) return
            val index = viewModel.chatList.value?.indexOfFirst { it.lastMessageId == messageId }?:-1
            if (index.isValidIndex()) {
                getArchiveChatFor(viewModel.chatList.value!![index].jid, RecentChatEvent.MESSAGE_UPDATED)
            }
        } catch (e:Exception) {
            Log.e(TAG, "updateMessageUpdate: $e")
        }
    }

    private fun onProfileUpdated(jid: String) {
        val bundle = Bundle()
        bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 2)
        bundle.putInt(Constants.NOTIFY_MUTE_UNMUTE, 2)
        val index = viewModel.chatList.value?.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == jid } ?: -1

        if (index.isValidIndex()) {
            val recent = FlyCore.getRecentChatOf(jid)
            recent?.let {
                viewModel.chatList.value!![index] = recent
                viewModel.chatAdapter[index] = recent
            }
            mAdapter.notifyItemChanged(index, bundle)
        }
    }

    private fun initChatAdapter(diffUtilResult: DiffUtil.DiffResult?) {
        if (diffUtilResult != null) {
            // Save Current Scroll state to retain scroll position after DiffUtils Applied
            val previousState = archivedListRecent.layoutManager?.onSaveInstanceState() as Parcelable
            diffUtilResult.dispatchUpdatesTo(mAdapter)
            archivedListRecent.layoutManager?.onRestoreInstanceState(previousState)
        }
        archivedChatsBinding.dataLoader.visibility = View.GONE
        mAdapter.notifyDataSetChanged()
        setEmptyView(if (viewModel.chatAdapter.size <= 4) View.VISIBLE else View.GONE)
    }

    private fun observeFilteredArchiveChatList(list: List<RecentChat>) {
        mSearchAdapter.setIsRecentChat(false)
        mSearchAdapter.setRecentChatCount(list.size)

        for (recent in list) {
            val searchItem = com.contusfly.models.RecentSearch(recent.jid, recent.lastMessageId, Constants.TYPE_SEARCH_RECENT, recent.getChatTypeEnum().toString(), true,ProfileDetails())
            mArchiveSearchList.add(searchItem)
        }
        mSearchAdapter.setRecentSearch(mArchiveSearchList, searchKey)
        setAdapterBasedOnSearchType()
        mSearchAdapter.notifyDataSetChanged()
    }

    private fun doSearch(searchKey: String) {
        if (searchKey.isEmpty()) {
            mArchiveChatListType = ArchiveChatListType.ARCHIVE
            setAdapterBasedOnSearchType()
        } else {
            this.searchKey = searchKey
            mArchiveChatListType = ArchiveChatListType.SEARCH
            mArchiveSearchList.clear()
            viewModel.filterArchivedChatList(this.searchKey)
        }
    }

    private fun setActionMode() {
        if (!cabOpen) {
            //Note: Each time startActionMode is called onDestroyActionMode will be called on any existing CAB
            actionMode = archivedChatsBinding.toolbar.startActionMode(this)
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
        inflater.inflate(R.menu.menu_archive, menu)
        actionModeMenu = menu
        with(menu) {
            hideMenu(get(R.id.action_mute), get(R.id.action_unmute), get(R.id.action_delete),
                get(R.id.action_unarchive), get(R.id.action_mark_read), get(R.id.action_mark_unread))
        }
    }

    override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
        p1?.findItem(R.id.action_mute)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        p1?.findItem(R.id.action_unmute)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        p1?.findItem(R.id.action_delete)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        p1?.findItem(R.id.action_unarchive)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        p1?.findItem(R.id.action_mark_read)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        p1?.findItem(R.id.action_mark_unread)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        return true
    }

    override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
        onClickAction(p1!!.itemId)
        return true
    }

    /**
     * On click action on the menu when the recent chat long pressed it.
     *
     * @param itemId The item id
     * @return boolean True if the item has click handled successfully.
     */
    private fun onClickAction(itemId: Int): Boolean {
        when (itemId) {
            R.id.action_delete -> {
                deleteChatAlert()
                return true
            }
            R.id.action_unarchive -> {
                isDeleteChat = false
                unArchiveSelectedChats()
                actionMode?.finish()
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
            else -> return false
        }
    }

    private fun unArchiveSelectedChats() {
        if (!AppUtils.isNetConnected(this)) {
            CustomToast.show(this, getString(R.string.error_check_internet))
            return
        }
        doProgressDialog = DoProgressDialog(this)
        doProgressDialog!!.showProgress()
        val selectedJids: MutableList<String> = mutableListOf()
        var failedCount = 0
        val selectedCount = viewModel.selectedChats.size
        for (recent in viewModel.selectedChats) {
            FlyCore.updateArchiveUnArchiveChat(recent.jid, false, FlyCallback { isSuccess, _, data ->
                if (isSuccess)
                    selectedJids.add(recent.jid)
                else {
                    if (failedCount == 0) CustomToast.showShortToast(
                        context,
                        data.getMessage()
                    )
                    failedCount++
                    dismissProgress()
                }
                isAdapterNeedSync = (selectedJids.size > 0 && selectedCount == (selectedJids.size + failedCount))
                if (isAdapterNeedSync){
                    updateArchiveChatsData(selectedJids, failedCount)
                    setResult(Activity.RESULT_OK)
                    dismissProgress()
                }
            })
        }
    }
    private fun dismissProgress() {
        if (doProgressDialog != null && doProgressDialog!!.isShowing) doProgressDialog!!.dismiss()
    }
    private fun updateArchiveChatsData(selectedJids: MutableList<String>, failedCount: Int) {
        updateArchiveChatsList(selectedJids)
        val chatsSize = selectedJids.size
        if(!isDeleteChat) {
            if (chatsSize == 1)
                CustomToast.showShortToast(
                    context,
                    String.format(context!!.getString(R.string.msg_chat_unarchived), chatsSize)
                )
            else if (chatsSize > 0)
                CustomToast.showShortToast(
                    context,
                    String.format(
                        context!!.getString(R.string.msg_multiple_chats_unarchived),
                        chatsSize
                    )
                )
        }
        LogMessage.e(TAG, "UnArchive Chats failed: $failedCount")
    }

    override fun updateArchiveUnArchiveChats(toUser: String?, archiveStatus: Boolean) {
        super.updateArchiveUnArchiveChats(toUser, archiveStatus)
        if (isAdapterNeedSync) {
            if (!archiveStatus) {
                removeArchiveChatItem(toUser)
            } else {
                viewModel.getArchivedChats()
            }
        }
    }

    private fun removeArchiveChatItem(toUser: String?) {
        try {
            val index = viewModel.chatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == toUser }
            if (index.isValidIndex()) {
                viewModel.chatList.value!!.removeAt(index)
                viewModel.chatAdapter.removeAt(index)
                mAdapter.notifyItemRemoved(index)
                setEmptyView(if (viewModel.chatAdapter.size <= 4) View.VISIBLE else View.GONE)
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    /**
     * Alert dialog while the user wants to delete chats
     */
    private fun deleteChatAlert() {
        // Delete the recent chat list
        val selectedMessages = viewModel.selectedChats
        // Delete the one chat
        val deleteAlertMessage = if (selectedMessages.size == 1) {
            val userNickName = ProfileDetailsUtils.getDisplayName(selectedMessages[0].jid)
            String.format(getString(R.string.msg_delete_chat_single_conversation), userNickName)
        } else String.format(getString(R.string.msg_delete_chat_multiple_conversation), selectedMessages.size)// Delete the multiple chats
        commonAlertDialog.showAlertDialog(deleteAlertMessage, getString(R.string.action_yes), getString(R.string.action_no),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
    }

    private fun getArchiveChatFor(jId: String, @RecentChatEvent event: String) {
        viewModel.getArchiveChatOfUser(jId, event)
    }

    private fun updateChatItem() {
        if (viewModel.selectedChats.isNotEmpty()) {
            for (item in viewModel.selectedChats) {
                val index = viewModel.chatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == item.jid }
                if (index.isValidIndex()) {
                    getArchiveChatFor(viewModel.chatList.value!![index].jid, RecentChatEvent.MUTE_EVENT)
                }
            }
            viewModel.selectedChats.clear()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_archive, menu)
        with(menu) {
            hideMenu(get(R.id.action_mute), get(R.id.action_unmute), get(R.id.action_delete),
                get(R.id.action_unarchive), get(R.id.action_mark_read), get(R.id.action_mark_unread))
        }
        return true
    }

    private fun setEmptyView(visible: Int) {
        emptyView.visibility = visible
        emptyView.text = getString(R.string.no_archived_chats)
    }

    override fun onDestroyActionMode(p0: ActionMode?) {
        cabOpen = false
        clearSelectedMessages()
    }

    private fun clearSelectedMessages() {
        LogMessage.d(TAG, "clearSelectedMessages")
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

    override fun onMessageReceived(message: ChatMessage) {
        if (FlyCore.isArchivedSettingsEnabled()) {
            getArchiveChatFor(message.getChatUserJid(), RecentChatEvent.MESSAGE_RECEIVED)
        } else {
            viewModel.getArchivedChats()
            unSelectCountForRestoredChat(message)
        }
    }

    override fun onMessageStatusUpdated(messageId: String) {
        if (messageId.isEmpty()) return
        viewModel.setMessageStatus(messageId)
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (!isSuccess)
            return
        if (dialogType == CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL) {
            isDeleteChat = true
            unArchiveSelectedChats()
        }
    }

    override fun listOptionSelected(position: Int) {
        LogMessage.d(TAG, position.toString())
    }

    private fun updateAdapter() {
        for (item in viewModel.selectedChats) {
            val index = viewModel.chatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == item.jid }
            if (index.isValidIndex()) {
                viewModel.chatList.value!!.removeAt(index)
                viewModel.chatAdapter.removeAt(index)
                mAdapter.notifyItemRemoved(index)
            }
        }
        viewModel.selectedChats.clear()
    }

    private fun updateArchiveChatsList(selectedJids: MutableList<String>) {
        for (jid in selectedJids) {
            val index = viewModel.chatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == jid }
            if (index.isValidIndex()) {
                viewModel.chatList.value!!.removeAt(index)
                viewModel.chatAdapter.removeAt(index)
                mAdapter.notifyItemRemoved(index)
                setEmptyView(if (viewModel.chatAdapter.size <= 4) View.VISIBLE else View.GONE)
            }
        }
        if (isDeleteChat)
            deleteSelectedRecent(selectedJids)
        viewModel.selectedChats.clear()
    }

    /**
     * Removes the selected chat from the recent chat history.
     *
     * @param selectedJidList the selected recent chat jid list.
     */
    private fun deleteSelectedRecent(selectedJidList: List<String>) {
        ChatManager.deleteRecentChats(selectedJidList, object : ChatActionListener {
            override fun onResponse(isSuccess: Boolean, message: String) {
                /*
                * No Implementation needed
                */
            }
        })
        updateAdapter()
        actionMode?.finish()
    }

    private fun onGroupUpdated() {
        viewModel.getArchivedChats()
    }

    override fun onLeftFromGroup(groupJid: String, leftUserJid: String) {
        super.onLeftFromGroup(groupJid, leftUserJid)
        onGroupUpdated()
    }

    private fun unSelectCountForRestoredChat(message: ChatMessage) {
        if (viewModel.selectedChats.size > 0) {
            val index = viewModel.selectedChats?.indexOfFirst { it.jid == message.senderUserJid }
            if (index.isValidIndex()) {
                viewModel.selectedChats?.removeAt(index)
                recentClick(viewModel.selectedChats, true)
            }
        }
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
        viewModel.getArchivedChats()
    }

    override fun updateFeatureActions(features: Features) {
        updateActionMenuIcons(features, viewModel.selectedChats)
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
}