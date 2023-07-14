package com.contusfly.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.mirrorflysdk.flycommons.Features
import com.contusfly.*
import com.contusfly.activities.parent.DashboardParent
import com.contusfly.adapters.ViewPagerAdapter
import com.contusfly.call.calllog.CallHistoryFragment
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.ActivityDashboardBinding
import com.contusfly.fragments.RecentChatListFragment
import com.contusfly.interfaces.RecentChatEvent
import com.contusfly.utils.*
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.api.models.RecentChat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.flycommons.Result
import dagger.android.AndroidInjection

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class DashboardActivity : DashboardParent(), View.OnClickListener, ActionMode.Callback, CommonAlertDialog.CommonDialogClosedListener{

    private var TAG = DashboardActivity::class.java.simpleName


    private lateinit var chatTitleTextView: TextView
    private lateinit var callTitleTextView: TextView
    private lateinit var unReadChatCountTextView: TextView
    private lateinit var missedCallCountTextView: TextView
    private var isLoadCallLogsOnMainThread: Boolean = false

    private var adminBlockStatus : Boolean = false
    private var userJid:String = Constants.EMPTY_STRING
    private var handler: Handler? = null
    private var menuReference: Menu? = null
    protected val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        checkConditionForPin()
        super.onCreate(savedInstanceState)
        dashboardBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashboardBinding.root)
        handler = Handler(Looper.getMainLooper())
        setSupportActionBar(dashboardBinding.toolbar)
        supportActionBar?.title = Constants.EMPTY_STRING
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        mAdapter = ViewPagerAdapter(this, addFragmentsToViewPagerAdapter(),
                arrayOf(getString(R.string.chats_label), getString(R.string.calls_label)))
        tabLayout = dashboardBinding.tabs
        mViewPager = dashboardBinding.viewPager
        swipeRefreshLayout = dashboardBinding.swipeToRefreshLayout
        dashboardBinding.newChatFab.setOnClickListener(this)
        setListeners()
        setUpViewPager()
        setUpTabLayout()
        setObservers()
        setUpTabColors(0)
        setupTabPosition()
        checkEnableSafeChat()
    }

    private fun checkConditionForPin() {
        val isPinNotValidated = SharedPreferenceManager.getBoolean(Constants.IS_PIN_VALIDATED)
        if (intent.getBooleanExtra(Constants.FROM_SPLASH_SCREEN, false) || intent.getBooleanExtra(Constants.FROM_ADMIN_BLOCK_SCREEN, false)) {
            val shouldShowPinOrNot = intent.getBooleanExtra("shouldShowPinOrNot", false)
            if (AppLifecycleListener.fromOnCreate && AppLifecycleListener.isPinEnabled && !SafeChatUtils.safeChatEnabled) pinForDashBoard()
            else if (AppLifecycleListener.isForeground && shouldShowPinOrNot) checkBioMetricLock()
            else if (AppLifecycleListener.pinActivityShowing ||
                (AppLifecycleListener.isPinEnabled && (AppLifecycleListener.isForeground || isPinNotValidated)))
                pinForDashBoard()
        }
    }

    private fun checkBioMetricLock() {
        SharedPreferenceManager.setString(Constants.APP_SESSION, System.currentTimeMillis().toString())
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(this@DashboardActivity, BiometricActivity::class.java)
            intent.putExtra(Constants.GO_TO, "DASHBOARD")
            startActivity(intent)
        } else pinForDashBoard()
    }

    private fun pinForDashBoard() {
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(this, BiometricActivity::class.java)
            intent.putExtra(Constants.GO_TO, "DASHBOARD")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(intent)
        } else if (AppLifecycleListener.isPinEnabled) {
            val intent = Intent(ChatManager.applicationContext, ChatManager.pinActivity)
            intent.putExtra(Constants.GO_TO, "DASHBOARD")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(intent)
        }
    }

    private fun checkEnableSafeChat() {
        if (intent.getBooleanExtra(Constants.IS_FOR_SAFE_CHAT, false)){
            SafeChatUtils.changeSafeChatStatus(this,null)
        }
        AppShortCuts.dynamicAppShortcuts(this)
    }

    /**
     * When a new notification message is received the recent chat has to be updated and set a view to show the latest message...
     *
     * @param message Instance of the Message
     */
    override fun onGroupNotificationMessage(message: ChatMessage) {
        if((message.messageTextContent.contains("removed you") || message.messageTextContent.contains("added you")) &&
            viewModel.selectedRecentChats.isNotEmpty())
            recentClick(viewModel.selectedRecentChats, false)
        viewModel.getRecentChatOfUser(message.getChatUserJid(), RecentChatEvent.GROUP_EVENT)
        viewModel.unreadChatCountLiveData.value = FlyMessenger.getUnreadMessagesCount()
    }

    private fun addFragmentsToViewPagerAdapter(): ArrayList<Fragment> {
        return if (ChatManager.getAvailableFeatures().isOneToOneCallEnabled || ChatManager.getAvailableFeatures().isGroupCallEnabled) {
            val fragmentsArray = ArrayList<Fragment>()
            recentChatFragment = RecentChatListFragment()
            callHistoryFragment = CallHistoryFragment()
            fragmentsArray.add(recentChatFragment)
            fragmentsArray.add(callHistoryFragment)
            fragmentsArray
        } else {
            val fragmentsArray = ArrayList<Fragment>()
            recentChatFragment = RecentChatListFragment()
            callHistoryFragment = CallHistoryFragment()
            fragmentsArray.add(recentChatFragment)
            fragmentsArray
        }
    }

    private fun setUpTabColors(position: Int) {
        when (position) {
            0 -> {
                chatTitleTextView.setTextColor(ContextCompat.getColor(this, R.color.colorSecondary))
                callTitleTextView.setTextColor(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color))
            }
            1 -> {
                chatTitleTextView.setTextColor(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color))
                callTitleTextView.setTextColor(ContextCompat.getColor(this, R.color.colorSecondary))
            }
        }
    }

    private fun setupTabPosition() {
        if (intent.getBooleanExtra(CallUtils.IS_CALL_NOTIFICATION, false) || CallUtils.isCallsTabToBeShown()) {
            isLoadCallLogsOnMainThread = true
            mViewPager.currentItem = 1
        }
    }

    private fun setUpViewPager() {
        mViewPager.offscreenPageLimit = 2
        mViewPager.adapter = mAdapter
        mViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                isPageChanged = true
                callHistoryFragment.clearSelectedMessages()
                recentChatFragment.clearSelectedMessages()
                invalidateOptionsMenu()
                actionMode?.finish()
                when (position) {
                    0 -> {
                        swipeRefreshLayout.isEnabled = false
                        dashboardBinding.newChatFab.visibility = View.VISIBLE
                    }
                    1 -> {
                        swipeRefreshLayout.isEnabled = false
                        dashboardBinding.newChatFab.visibility = View.GONE
                        //mark missed calls as read
                        CallLogManager.markAllUnreadMissedCallsAsRead()
                        validateMissedCallsCount()
                    }
                }
                setUpTabColors(position)
                searchKey = Constants.EMPTY_STRING
            }
        })
    }

    @SuppressLint("InflateParams")
    private fun setUpTabLayout() {
        tabLayout.show()
        val viewChats = layoutInflater.inflate(R.layout.custom_tabs, null)
        val viewCalls = layoutInflater.inflate(R.layout.custom_tabs, null)
        chatTitleTextView = viewChats.findViewById(R.id.text)
        unReadChatCountTextView = viewChats.findViewById(R.id.text_unseen_count)
        callTitleTextView = viewCalls.findViewById(R.id.text)
        missedCallCountTextView = viewCalls.findViewById(R.id.text_unseen_count)
        TabLayoutMediator(tabLayout, mViewPager) { tab, position ->
            if (position == 0) {
                tab.customView = viewChats
                chatTitleTextView.text = getString(R.string.chats_label)
            } else {
                tab.customView = viewCalls
                callTitleTextView.text = getString(R.string.calls_label)
            }
        }.attach()

        viewModel.updateUnReadChatCount()
        validateMissedCallsCount()
    }

    fun getViewPagerCurrentPosition() = mViewPager.currentItem

    /*
    * Toolbar Menu Settings */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_main, menu)
        val menuItem = menu?.findItem(R.id.action_search)
        menuReference = menu
        updateMenuIcons(ChatManager.getAvailableFeatures())
        callLogMenuShowHide()
        mSearchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        if (mViewPager.currentItem == 0) {
            menuReference?.let {
                hideMenu(it.get(R.id.clear_call_log))
            }
        } else {
            menuReference?.let {
                showMenu(it.get(R.id.clear_call_log))
            }
        }
        /* Check if user searched in recent or contact. */
        if (!mSearchView!!.isIconified)
            dashboardBinding.toolbar.collapseActionView()

        mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(searchString: String): Boolean {
                filterResult(searchString.trim())
                return true
            }
        })

        menuItem?.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                //make toolbar un-collapsible
                val params: AppBarLayout.LayoutParams = dashboardBinding.toolbar.layoutParams as AppBarLayout.LayoutParams
                params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP

                tabLayout.gone()
                mSearchView!!.maxWidth = Integer.MAX_VALUE
                closeOption(menu)
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                //make toolbar collapsible
                val params: AppBarLayout.LayoutParams = dashboardBinding.toolbar.layoutParams as AppBarLayout.LayoutParams
                params.scrollFlags = (AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS)

                tabLayout.show()
                mRecentChatListType = if (searchKey.isEmpty()) RecentChatListType.RECENT else RecentChatListType.SEARCH
                openOption(menu)
                callLogMenuShowHide()
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            R.id.action_group_chat -> {
                startActivity(Intent(this, NewGroupActivity::class.java))
                true
            }
            R.id.action_web_settings -> {
                SharedPreferenceManager.setBoolean(Constants.IS_WEBCHAT_LOGGED_IN, false)
                webConnect()
                true
            }
            R.id.clear_call_log -> {
                 callLogviewModel.setClearAllCallLog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        adminBlockStatus = status
        userJid = jid
        LogMessage.d(TAG, "#onAdminBlockedStatus jid == $userJid status == $adminBlockStatus")
        //To avoid multiple callbacks
        handler?.postDelayed({
            viewModel.setAdminBlockedStatus(userJid, adminBlockStatus)
        }, 500)
    }

    // Action Mode Callbacks
    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        onClickAction(item!!.itemId)
        return true
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        configureActionMode(mode!!, menu!!)
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        cabOpen = false
        when (mViewPager.currentItem) {
            0 -> recentChatFragment.clearSelectedMessages()
            1 -> callHistoryFragment.clearSelectedMessages()
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            dashboardBinding.newChatFab -> {
                if (BuildConfig.CONTACT_SYNC_ENABLED) {
                    if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) {
                        startActivity(Intent(this, NewContactsActivity::class.java))
                    } else
                        MediaPermissions.requestContactsReadPermission(this, permissionAlertDialog, contactPermissionLauncher, null)
                } else {
                    startActivity(Intent(this, UserListActivity::class.java))
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        LogMessage.d("DashboardActivity", "onRestart")

        tabLayout.visibility = if (mRecentChatListType == RecentChatListType.SEARCH) View.GONE else View.VISIBLE
        if (recentChatFragment.isRecentListInitialized()) {
            recentChatFragment.setAdapterBasedOnSearchType()
            if (searchItemClickedPosition.isValidIndex())
                recentChatFragment.updateSearchAdapter(searchItemClickedPosition)
        }
        viewModel.getRestartActivitygetrecentChatList()
        viewModel.getArchivedChatStatus()
        viewModel.updateUnReadChatCount()
        validateMissedCallsCount()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getArchivedChatStatus()
        viewModel.updateUnReadChatCount()
        callLogviewModel.resetPagination()
        if (callLogviewModel.isCallLogScreenInitiated()) {
            callLogviewModel.addLoaderToTheList()
            callLogviewModel.getCallLogsList(isLoadCallLogsOnMainThread)
            CallUtils.setCallsTabToBeShown(false)
        }
        isLoadCallLogsOnMainThread = false
        if (SharedPreferenceManager.getBoolean(Constants.SHOW_LABEL))
            netConditionalCall({ dashboardBinding.dashboardXmppConnectionStatusLayout.gone() }, { dashboardBinding.dashboardXmppConnectionStatusLayout.show() })
        else dashboardBinding.dashboardXmppConnectionStatusLayout.gone()
        if (BuildConfig.CONTACT_SYNC_ENABLED) {
            checkContactPermission()
        }
        if(SafeChatUtils.updateAlert){
            SafeChatUtils.updateAlert = false
            SafeChatUtils.safeChatEnabledPrompt(this) {
                AppShortCuts.dynamicAppShortcuts(this)
                finishAffinity()
            }
        }
        callLogviewModel.uploadUnSyncedCallLogs()
        ChatManager.setOnGoingChatUser("")
        callLogMenuShowHide()
    }

    private fun checkContactPermission() {
        if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)
            && viewModel.mContactCount == 0) {
            checkInternetAndExecute(false) {
                viewModel.checkAndUpdateContacts()
            }
            syncContacts()
        }
    }

    private fun syncContacts() {
        viewModel.contactSyncNeeded.observe(this) { syncNeeded ->
            LogMessage.i(TAG, "[Contact Sync] contactSyncNeeded: $syncNeeded ")
            if (syncNeeded && BuildConfig.CONTACT_SYNC_ENABLED) refreshContacts()
        }
        viewModel.isContactSyncSuccess.observe(this) {
            viewModel.getRecentChats()
        }
        viewModel.checkContactsUpdate()
    }

    private fun refreshContacts() {
        LogMessage.d(TAG, "[Contact Sync] refreshContacts()")
        if (AppUtils.isNetConnected(this)) {
            if (MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) {
                if (FlyCore.contactSyncState.value != Result.InProgress) {
                    FlyCore.syncContacts(!SharedPreferenceManager.getBoolean(Constants.INITIAL_CONTACT_SYNC_DONE)) { success, _, _ ->
                        viewModel.onContactSyncFinished(success)
                        viewModel.isContactSyncSuccess.value = true
                    }
                } else LogMessage.d(TAG, "[Contact Sync] Contact syncing is already in progress")
            }
        } else viewModel.onContactSyncFinished(false)
    }


    fun recentClick(recentList: List<RecentChat>, startActionMode: Boolean) {
        if (recentList.isEmpty()) {
            actionMode?.finish()
        } else {
            if (recentList.size == 1) {
                menuValidationForSingleItem(recentList, startActionMode)
            } else {
                actionModeMenu.findItem(R.id.action_info).isVisible = false
                actionModeMenu.findItem(R.id.action_add_chat_shortcuts).isVisible = false
                menuValidationForPinIcon(recentList)
                menuValidationForMuteUnMuteIcon(recentList)
                menuValidationForMarkReadUnReadIcon(recentList)
                updateActionMenuIcons(ChatManager.getAvailableFeatures(), recentList)
            }
            actionModeMenu.findItem(R.id.action_archive_chat).isVisible = true
            actionMode?.title = recentList.size.toString()
        }
        if(SafeChatUtils.updateAlert){
            SafeChatUtils.updateAlert = false
            SafeChatUtils.safeChatEnabledPrompt(this) {
                finishAffinity()
            }
        }
    }

    fun recentClickOnAdminBlockedUser() {
        commonAlertDialog.showAlertDialog(getString(R.string.group_block_message_label),
            getString(R.string.action_Ok),
            getString(R.string.action_cancel),
            CommonAlertDialog.DIALOGTYPE.DIALOG_SINGLE, false)
    }

    private fun menuValidationForSingleItem(recentList: List<RecentChat>, startActionMode: Boolean) {
        if (startActionMode)
            setActionMode()
        else
            actionModeMenu.findItem(R.id.action_info).isVisible = true

        actionModeMenu.findItem(R.id.action_un_pin).isVisible = recentList[0].isChatPinned
        actionModeMenu.findItem(R.id.action_pin).isVisible = !recentList[0].isChatPinned

        if (ChatType.TYPE_BROADCAST_CHAT != recentList[0].getChatType()) {
            actionModeMenu.findItem(R.id.action_unmute).isVisible = recentList[0].isMuted
            actionModeMenu.findItem(R.id.action_mute).isVisible = !recentList[0].isMuted
            actionModeMenu.findItem(R.id.action_add_chat_shortcuts).isVisible = true
        } else {
            actionModeMenu.findItem(R.id.action_unmute).isVisible = false
            actionModeMenu.findItem(R.id.action_mute).isVisible = false
            actionModeMenu.findItem(R.id.action_add_chat_shortcuts).isVisible = false
        }

        actionModeMenu.findItem(R.id.action_mark_as_read).isVisible = recentList[0].isConversationUnRead
        actionModeMenu.findItem(R.id.action_mark_as_unread).isVisible = !recentList[0].isConversationUnRead

        updateActionMenuIcons(ChatManager.getAvailableFeatures(),recentList)

    }


    private fun menuValidationForPinIcon(recentList: List<RecentChat>) {
        val checkListForPinIcon = ArrayList<Boolean>()
        for (i in recentList.indices)
            checkListForPinIcon.add(recentList[i].isChatPinned)
        if (checkListForPinIcon.contains(false)) {
            actionModeMenu.findItem(R.id.action_pin).isVisible = true
            actionModeMenu.findItem(R.id.action_un_pin).isVisible = false
        } else {
            actionModeMenu.findItem(R.id.action_pin).isVisible = false
            actionModeMenu.findItem(R.id.action_un_pin).isVisible = true
        }
    }

    private fun menuValidationForMarkReadUnReadIcon(recentList: List<RecentChat>) {
        com.mirrorflysdk.flycommons.LogMessage.d(TAG, "MarkUnread - menuValidationForMarkReadUnReadIcon")
        val list = ArrayList<Boolean>()
        for (i in recentList.indices)
            list.add(recentList[i].isConversationUnRead)

        if (!list.contains(true)) {
            actionModeMenu.findItem(R.id.action_mark_as_read).isVisible = false
            actionModeMenu.findItem(R.id.action_mark_as_unread).isVisible = true
        } else {
            actionModeMenu.findItem(R.id.action_mark_as_read).isVisible = true
            actionModeMenu.findItem(R.id.action_mark_as_unread).isVisible = false
        }
    }

    private fun menuValidationForDeleteIcon(
        recentList: List<RecentChat>) {
        actionModeMenu.findItem(R.id.action_delete).isVisible = showDeleteOption(recentList)
    }

    private fun showDeleteOption(recentList: List<RecentChat>):Boolean{
        for(item in recentList){
            if((item.getChatType() == ChatType.TYPE_GROUP_CHAT) && ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(item.jid,SharedPreferenceManager.getCurrentUserJid()))
                return false
        }
        return true
    }

    private fun menuValidationForMuteUnMuteIcon(recentList: List<RecentChat>) {
        val checkListForMuteUnMuteIcon = ArrayList<Boolean>()

        for (i in recentList.indices)
            if (!recentList[i].isBroadCast)
                checkListForMuteUnMuteIcon.add(recentList[i].isMuted)

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

    /**
     * When a new message is received the recent chat has to be updated and set a view to show the latest message...
     *
     * @param message Instance of the Message
     */
    override fun onMessageReceived(message: ChatMessage) {
        viewModel.setReceivedMsg(message)
        if (viewModel.selectedRecentChats.isNotEmpty())
            Handler(Looper.getMainLooper()).postDelayed({
                recentClick(viewModel.selectedRecentChats, false)
            }, 1000)
    }

    override fun onMessageStatusUpdated(messageId: String) {
        viewModel.setMessageStatus(messageId)
        viewModel.updateUnReadChatCount()
        viewModel.getArchivedChatStatus()
    }

    override fun onMessagesClearedOrDeleted(messageIds: ArrayList<String>, jid: String) {
        if (messageIds.isNotEmpty())
            viewModel.updateRecentMessage(messageIds)
        else if (jid.isNotEmpty())
            viewModel.setClearedMessagesView(jid)
        else
            viewModel.refreshFetchedRecentChat()
    }

    override fun onStop() {
        super.onStop()
        viewModel.clearTypingStatusList()
    }

    private fun setObservers() {
        viewModel.unreadChatCountLiveData.observe(this, {
            validateUnreadChatUsers(it)
        })

        viewModel.clearallCallLog.observe(this, {
            callLogMenuShowHide()
        })

    }

    /**
     * Update the recent chat unread users count
     */
    private fun validateUnreadChatUsers(unReadChatCount: Int) {
        // Check the count of an unread message
        if (unReadChatCount > 0) {
            unReadChatCountTextView.show()
            unReadChatCountTextView.text = unReadChatCount.toString()
        } else unReadChatCountTextView.gone()
    }

    private fun setListeners() {
        swipeRefreshLayout.isEnabled = false
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
        }
        commonAlertDialog.setOnDialogCloseListener(this)
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        try{
            if (!isSuccess)
                return
            if (dialogType == CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL && mRecentChatListType == RecentChatListType.RECENT)
                deleteSelectedRecent(getJidFromList(viewModel.selectedRecentChats))
        } catch (e:Exception) {
            LogMessage.e(TAG,e)
        }
    }

    override fun listOptionSelected(position: Int) {
        LogMessage.d(TAG, position.toString())
    }

    /**
     * Keep track of whether the contextual action bar is open
     */
    private var cabOpen = false

    private fun setActionMode() {
        if (!cabOpen) {
            /*
             Note: Each time startActionMode is called onDestroyActionMode will be called on any existing CAB
            */
            actionMode = dashboardBinding.toolbar.startActionMode(this)
            cabOpen = true
        }
    }

    fun startActionModeForCallLogs(count: Int, startActionMode: Boolean) {
        if (count > 0) {
            if (startActionMode)
                setActionMode()
            with(actionModeMenu) {
                hideMenu(get(R.id.action_reply), get(R.id.action_forward),
                    get(R.id.action_favourite), get(R.id.action_unfavourite),
                    get(R.id.action_copy), get(R.id.action_delete),
                    get(R.id.action_info), get(R.id.action_mark_as_read),
                    get(R.id.action_mark_as_unread), get(R.id.action_archive_chat),
                    get(R.id.action_add_chat_shortcuts))
                get(R.id.action_delete).show()
            }
            actionMode?.title = count.toString()
        } else actionMode?.finish()
    }

    fun validateMissedCallsCount() {
        // Check the count of an unread missed calls
        val unreadCount = CallLogManager.getUnreadMissedCallCount()
        if (unreadCount > 0) {
            missedCallCountTextView.show()
            missedCallCountTextView.text = unreadCount.toString()
        } else
            missedCallCountTextView.gone()
    }

    override fun restoreCompleted() {
        viewModel.refreshFetchedRecentChat()
        viewModel.getArchivedChatStatus()
    }

    override fun userDetailsUpdated() {
        super.userDetailsUpdated()
        viewModel.refreshFetchedRecentChat()
        viewModel.getArchivedChatStatus()
    }

    override fun onGroupProfileFetched(groupJid: String) {
        super.onGroupProfileFetched(groupJid)
        viewModel.getRecentChatOfUser(groupJid, RecentChatEvent.GROUP_EVENT)
    }

    override fun updateFeatureActions(features: Features) {
        updateMenuIcons(features)
        updateActionMenuIcons(features, viewModel.selectedRecentChats)
        updateAdapterItems(features)
        callLogviewModel.updateFeatureActions(features)
    }

    override fun onUserBlockedOrUnblockedBySomeone(userJid: String, blockType: Boolean) {
        viewModel.setBlockUnBlockJID(userJid, blockType)
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        callLogviewModel.getCallLogsList(false)
        viewModel.onContactSyncFinished(isSuccess)
        viewModel.isContactSyncSuccess.value = true
    }

    /**
     * Update the recent chat when user left the group
     */
    override fun onLeftFromGroup(groupJid: String, leftUserJid: String) {
        super.onLeftFromGroup(groupJid, leftUserJid)
        recentChatFragment.refreshRecentChatList()
    }

    private fun updateAdapterItems(features: Features) {
        if (mAdapter.fragmentsArray.size == 2) {
            if (!features.isOneToOneCallEnabled && !features.isGroupCallEnabled) {
                mAdapter.fragmentsArray.remove(callHistoryFragment)
                mAdapter.notifyDataSetChanged()
                mViewPager.currentItem = 0
            }
        } else {
            if (features.isOneToOneCallEnabled || features.isGroupCallEnabled) {
                mAdapter.fragmentsArray.add(callHistoryFragment)
                mAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun updateMenuIcons(features: Features) {
        menuReference?.let {
            if (features.isGroupChatEnabled)
                showMenu(it.get(R.id.action_group_chat))
            else hideMenu(it.get(R.id.action_group_chat))
            val menuItem = it.findItem(R.id.action_search)
            if (features.isRecentChatSearchEnabled)
                showMenu(it.get(R.id.action_search))
            else {
                menuItem.collapseActionView()
                hideMenu(it.get(R.id.action_search))
            }
        }
    }

    private fun callLogMenuShowHide(){
        if(mViewPager.currentItem == 0){
            menuReference?.let { hideMenu(it.get(R.id.clear_call_log))}
        } else {
            if(callLogviewModel.callLogAdapterList.isNotEmpty()){
                menuReference?.let { showMenu(it.get(R.id.clear_call_log))}
            } else {
                menuReference?.let { hideMenu(it.get(R.id.clear_call_log))}
            }
        }
    }

    private fun updateActionMenuIcons(features: Features, recentList: List<RecentChat>) {
        try {
            actionModeMenu?.let {
                if (features.isDeleteChatEnabled)
                    menuValidationForDeleteIcon(recentList)
                else hideMenu(it.get(R.id.action_delete))
            }
        } catch(e:Exception) {
            LogMessage.e(TAG,e.toString())
        }
    }

    override fun onConnected() {
        super.onConnected()
        viewModel.chatHistoryMigration()
    }
}