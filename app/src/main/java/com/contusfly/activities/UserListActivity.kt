package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.*
import com.contusfly.activities.parent.BaseContactActivity
import com.contusfly.adapters.UserListAdapter
import com.contusfly.databinding.ActivityUserListBinding
import com.contusfly.helpers.PaginationScrollListener
import com.contusfly.helpers.UserListType
import com.contusfly.interfaces.ContactHelperListener
import com.contusfly.network.NetworkConnection
import com.contusfly.utils.Constants
import com.contusfly.utils.UserInterfaceUtils
import com.contusfly.viewmodels.UserListViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomRecyclerView
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.views.CustomToast

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class UserListActivity : BaseContactActivity() {

    private lateinit var userListBinding: ActivityUserListBinding

    private var screenTitle: String = emptyStringFE()

    private var isMakeCall = false
    private var callType: String? = null
    private var groupId:String? = null
    /**
     * The handler to delay the search
     */
    private lateinit var mHandler: Handler

    /**
     * Used for search
     */
    private var searchKey: String = emptyString()

    private lateinit var mAdapter: UserListAdapter
    private lateinit var mSearchAdapter: UserListAdapter

    private var mUserListType = UserListType.USER_LIST

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private var commonAlertDialog: CommonAlertDialog? = null

    private val viewModel by lazy {
        ViewModelProvider(this).get(UserListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userListBinding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(userListBinding.root)
        handleIntentValues()
        initViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.contact_menu, menu)

        val menuItem = menu?.findItem(R.id.action_search)
        val mSearchView = menu?.findItem(R.id.action_search)?.actionView as SearchView

        setUpActionItems(menu)

        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(searchString: String): Boolean {
                searchKey = searchString.trim()
                mHandler.removeCallbacksAndMessages(null)
                    mSearchAdapter.resetSearch()
                    if (searchKey.isEmpty()) {
                        mUserListType = UserListType.USER_LIST
                    } else {
                        mUserListType = UserListType.SEARCH
                        viewModel.resetSearch()
                        viewModel.addSearchLoaderToTheList()
                        viewModel.searchUserList(searchString, fromGroupInfo, groupId)
                    }

                    setAdapterBasedOnSearchType()
                    mSearchAdapter.setSearchKey(searchKey)
                return true
            }
        })

        menuItem?.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                if (!addParticipants) mSearchView.maxWidth = Integer.MAX_VALUE
                with(menu) {
                    get(R.id.action_settings).hide()
                    if (!addParticipants) get(R.id.action_done).hide()
                }
                setEmptyView(true)
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                with(menu) {
                    get(R.id.action_done).isVisible = addParticipants
                    get(R.id.action_settings).isVisible = !addParticipants && !isMakeCall
                }
                setEmptyView(false)
                return true
            }
        })
        return true
    }

    private fun setUpActionItems(menu: Menu) {
        val actionItem = menu.get(R.id.action_done)
        val settingsItem = menu.get(R.id.action_settings)

        when {
            addParticipants -> {
                if(fromGroupInfo){
                    actionItem.title = getString(R.string.label_next)
                }else{
                    actionItem.title = getString(R.string.label_create)
                }
                settingsItem.show()
            }
            isMakeCall -> {
                actionItem.hide()
                settingsItem.hide()
            }
            else -> {
                actionItem.hide()
            }
        }
    }

    fun setAdapterBasedOnSearchType() {
        if (mUserListType == UserListType.USER_LIST && (userListBinding.viewListContacts.adapter as UserListAdapter).getSearchKey().isNotBlank()) {
            userListBinding.viewListContacts.adapter = mAdapter
        } else if (mUserListType == UserListType.SEARCH && (userListBinding.viewListContacts.adapter as UserListAdapter).getSearchKey().isBlank()) {
            userListBinding.viewListContacts.adapter = mSearchAdapter
        }
    }

    private fun handleIntentValues() {
        screenTitle = if (intent.hasExtra(Constants.TITLE)) intent.getStringExtra(Constants.TITLE)!! else getString(R.string.title_contacts)
        isMakeCall = intent.getBooleanExtra(Constants.IS_MAKE_CALL, false)
        callType = intent.getStringExtra(Constants.CALL_TYPE)
        addParticipants = intent.getBooleanExtra(Constants.ADD_PARTICIAPANTS, false)
        fromGroupInfo = intent.getBooleanExtra(Constants.FROM_GROUP_INFO, false)
        groupId = intent.getStringExtra(Constants.GROUP_ID)
        multiSelection = intent.getBooleanExtra(Constants.MULTI_SELECTION, addParticipants)
    }
    private fun initViews() {
        setUpToolBar()
        setUpViews()
        setObservers()
        observeNetworkListener()
    }

    private fun setUpToolBar() {
        setSupportActionBar(userListBinding.toolbar)
        supportActionBar?.title = screenTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        UserInterfaceUtils.initializeCustomToolbar(this, userListBinding.toolbar)
        userListBinding.toolbar.navigationIcon?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color), BlendModeCompat.SRC_ATOP)
    }

    private fun setUpViews() {

        mHandler = Handler(Looper.getMainLooper())
        commonAlertDialog = CommonAlertDialog(this)

        mAdapter = UserListAdapter(this, commonAlertDialog!!, multiSelection,isMakeCall, contactHelperListener)
        mSearchAdapter = UserListAdapter(this, commonAlertDialog!!, multiSelection,isMakeCall, contactHelperListener)

        userListBinding.viewListContacts.apply {
            layoutManager = LinearLayoutManager(context)
            setItemViewCacheSize(10)
            setHasFixedSize(true)
            setEmptyView(userListBinding.noContactsView.root)
            itemAnimator = null
            adapter = mAdapter
            setScrollListener(this, layoutManager as LinearLayoutManager)
        }

        if (isMakeCall && !callType.isNullOrEmpty()) {
            userListBinding.buttonMakeCall.gone()
            userListBinding.buttonMakeCall.text = String.format(getString(R.string.action_call_now), selectedUsersJid.size)
            if (callType.equals(CallType.VIDEO_CALL)) {
                userListBinding.buttonMakeCall.icon = ContextCompat.getDrawable(this, R.drawable.ic_fab_video_call)
            } else {
                userListBinding.buttonMakeCall.icon = ContextCompat.getDrawable(this, R.drawable.ic_fab_voice_call)
            }
            userListBinding.buttonMakeCall.setOnClickListener(1000) {
                checkInternetAndExecute {
                    val output = Intent().apply {
                        putStringArrayListExtra(Constants.USERS_JID, selectedUsersJid)
                        putExtra(Constants.CALL_TYPE, callType)
                    }
                    setResult(RESULT_OK, output)
                    finish()
                }
            }
        } else {
            userListBinding.buttonMakeCall.gone()
        }
    }

    private val contactHelperListener = object : ContactHelperListener {
        override fun isSelected(jid: String): Boolean {
            return selectedUsersJid.contains(jid)
        }

        override fun onItemClicked(profileClicked: Boolean, profile: ProfileDetails) {
            listItemClicked(profileClicked, profile)
        }
    }

    private fun setScrollListener(
        recyclerView: CustomRecyclerView,
        layoutManager: LinearLayoutManager
    ) {
        recyclerView.addOnScrollListener(object : PaginationScrollListener(
            layoutManager,
            handler = mHandler
        ){
            override fun loadMoreItems() {
                if (searchKey.isBlank())
                    viewModel.loadUserList(fromGroupInfo, groupId)
                else
                    viewModel.searchUserList(searchKey, fromGroupInfo, groupId)
            }

            override fun isLastPage(): Boolean {
                return if (searchKey.isBlank())
                    viewModel.lastPageFetched()
                else
                    viewModel.searchLastPageFetched()
            }

            override fun isFetching(): Boolean {
                return if (searchKey.isBlank())
                    viewModel.getUserListFetching()
                else
                    viewModel.getSearchUserListFetching()
            }
        })
        viewModel.addLoaderToTheList()
        viewModel.loadUserList(fromGroupInfo, groupId)
    }

    private fun setObservers() {
        viewModel.userList.observe(this) { userList ->
            userList?.let {
                mAdapter.addProfileList(userList)
            }
        }

        viewModel.addLoader.observe(this) {
            if (it)
                mAdapter.addLoadingFooter()
        }

        viewModel.removeLoader.observe(this) {
            if (it)
                mAdapter.removeLoadingFooter()
        }

        viewModel.resetSearchResult.observe(this) {
            if (it)
                mSearchAdapter.resetSearch()
        }

        viewModel.searchUserList.observe(this ) { userList ->
            userList?.let {
                mSearchAdapter.addProfileList(userList)
            }
        }

        viewModel.addSearchLoader.observe(this) {
            if (it)
                mSearchAdapter.addLoadingFooter()
        }

        viewModel.removeSearchLoader.observe(this) {
            if (it)
                mSearchAdapter.removeLoadingFooter()
        }

        viewModel.fetchingError.observe(this) {
            if (it)
                CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }

    private fun observeNetworkListener() {
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { connected ->
            if (connected && viewModel.fetchingError.value == true) { //If user list fetch failed then re-fetch user list when internet is reconnected
                if (searchKey.isBlank())
                    viewModel.loadUserList(fromGroupInfo, groupId)
                else
                    viewModel.searchUserList(searchKey, fromGroupInfo, groupId)
            }
        }
    }

    private fun setEmptyView(b: Boolean) {
        searchKey = emptyString()
        if (b) {
            val emptyView: TextView = userListBinding.emptyList.textEmptyView
            emptyView.text = getString(R.string.msg_no_contacts)
            emptyView.setTextColor(ResourcesCompat.getColor(resources, R.color.color_text_no_list, null))
            userListBinding.viewListContacts.setEmptyView(emptyView)
        } else {
            userListBinding.emptyList.textEmptyView.gone()
            userListBinding.viewListContacts.setEmptyView(userListBinding.noContactsView.root)
        }
    }

    override fun updateSelectedUserCallView(jid: String?) {
        if (isMakeCall) {
            userListBinding.buttonMakeCall.show()
            userListBinding.buttonMakeCall.isEnabled = selectedUsersJid.size > 0
            if ((selectedUsersJid.size + 1) > CallManager.getMaxCallUsersCount()) {
                if (jid!!.isNotEmpty()) selectedUsersJid.remove(jid)
                userListBinding.buttonMakeCall.text =
                    String.format(getString(R.string.action_call_now), selectedUsersJid.size)
                userListBinding.buttonMakeCall.isEnabled = false
                val message = String.format(
                    getString(com.contus.call.R.string.info_call_members_limit),
                    CallManager.getMaxCallUsersCount()
                )
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            } else {
                if (selectedUsersJid.size == 0) userListBinding.buttonMakeCall.gone() else userListBinding.buttonMakeCall.show()
                userListBinding.buttonMakeCall.text = String.format(getString(R.string.action_call_now), selectedUsersJid.size)
            }
        } else userListBinding.buttonMakeCall.gone()
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        mAdapter.updateUserProfileInfo(jid)
        mSearchAdapter.updateUserProfileInfo(jid)
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        if (selectedUsersJid.contains(jid)) {
            selectedUsersJid.remove(jid)
            updateSelectedUserCallView()
        }
        mAdapter.removeUserProfile(jid)
        mSearchAdapter.removeUserProfile(jid)
    }

    override fun userBlockedMe(jid: String) {
        super.userBlockedMe(jid)
        mAdapter.updateUserProfileInfo(jid)
        mSearchAdapter.updateUserProfileInfo(jid)
    }

    override fun userUnBlockedMe(jid: String) {
        super.userUnBlockedMe(jid)
        mAdapter.updateUserProfileInfo(jid)
        mSearchAdapter.updateUserProfileInfo(jid)
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        if (jid == groupId && status && fromGroupInfo && type == ChatType.TYPE_GROUP_CHAT) {
            showToast(getString(R.string.group_block_message_label))
            startDashboardActivity()
        } else {
            if (status && selectedUsersJid.contains(jid)) {
                selectedUsersJid.remove(jid)
                updateSelectedUserCallView()
            }
            mAdapter.removeUserProfile(jid)
            mSearchAdapter.removeUserProfile(jid)
        }
    }

    private fun startDashboardActivity() {
        val dashboardIntent = Intent(this, DashboardActivity::class.java)
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(dashboardIntent)
        finish()
    }
}