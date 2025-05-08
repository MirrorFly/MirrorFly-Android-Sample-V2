package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.adapters.SectionedShareAdapter
import com.contusfly.chat.MessageUtils
import com.contusfly.clearDeletedGroupChatNotification
import com.contusfly.databinding.ActivityForwardMessageBinding
import com.contusfly.getChatType
import com.contusfly.getDisplayName
import com.contusfly.helpers.PaginationScrollListener
import com.contusfly.helpers.UserListType
import com.contusfly.interfaces.RecyclerViewItemClick
import com.contusfly.isValidIndex
import com.contusfly.network.NetworkConnection
import com.contusfly.showToast
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.viewmodels.ForwardMessageViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomRecyclerView
import com.contusfly.views.ShareDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.helpers.ResourceHelper
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ForwardMessageActivity : BaseActivity(), CoroutineScope {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception :  ${exception.printStackTrace()}")
    }

    private lateinit var binding: ActivityForwardMessageBinding

    /**
     * Used for search
     */
    private var searchKey = Constants.EMPTY_STRING

    private var mUserListType = UserListType.USER_LIST

    /**
     * The handler to delay the search
     */
    private lateinit var mHandler: Handler

    /**
     * Adapter for forward user selection List
     */
    private lateinit var mForwardSectionAdapter: SectionedShareAdapter
    private lateinit var mForwardSearchSectionAdapter: SectionedShareAdapter

    private lateinit var shareDialog: ShareDialog

    private lateinit var inputIntent: Intent

    private val forwardMediaMessageIds: ArrayList<String> by lazy { ArrayList() }

    private val viewModel: ForwardMessageViewModel by viewModels()

    private val selectedUsersWithNames = linkedMapOf<String, String>()

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private var commonAlertDialog: CommonAlertDialog? = null

    private var senderJid : String=""

    private var pair = Pair<Boolean,String>(false,Constants.EMPTY_STRING)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityForwardMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        commonAlertDialog = CommonAlertDialog(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        initViews()
        getIntentValues()
        pair=Pair(isPrivateChatOfSender(),senderJid)
        inputIntent = intent
        setClickListeners()
        setObservers()
        observeNetworkListener()

        val selectedMessages = intent.getStringArrayListExtra(Constants.CHAT_MESSAGE)
        selectedMessages?.let {
            forwardMediaMessageIds.addAll(it)
        }

        shareDialog = ShareDialog(this)

        viewModel.loadForwardChatList(null,pair)
    }

    private fun getIntentValues() {
        if(intent.hasExtra(Constants.FROMUSER))
        senderJid = intent.getStringExtra(Constants.FROMUSER)!!
    }

    private fun setClickListeners() {
        binding.next.setOnClickListener {
            if (selectedUsersWithNames.isNotEmpty()) {
                context?.let { LocalBroadcastManager.getInstance(it).sendBroadcast(Intent(Constants.FORWARDED_MESSAGE_ITEM)) }
                shareFiles()
            }
        }
    }

    override fun onGroupProfileUpdated(groupJid: String) {
        super.onGroupProfileUpdated(groupJid)
        LogMessage.d(TAG, "#ForwardMessage  onGroupProfileUpdated $groupJid")
        updateProfileDetails(groupJid)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView

        searchView.setOnSearchClickListener {
            searchView.maxWidth = Int.MAX_VALUE
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(searchString: String): Boolean {
                searchKey = searchString.trim()
                mHandler.removeCallbacksAndMessages(null)
                mHandler.postDelayed({
                    filterList()
                }, 500)
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finishForwardMedia(false)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initViews() {
        mHandler = Handler(Looper.getMainLooper())
        binding.toolBar.setTitle(R.string.share_title)
        setSupportActionBar(binding.toolBar)
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_close)

        binding.emptyData.textEmptyView.text = getString(R.string.msg_no_results)
        binding.emptyData.textEmptyView.setTextColor(ResourceHelper.getColor(R.color.color_text_grey))

        mForwardSectionAdapter = SectionedShareAdapter(context!!, commonAlertDialog!!, onItemClickListener)
        mForwardSearchSectionAdapter = SectionedShareAdapter(context!!, commonAlertDialog!!, onItemClickListener)

        binding.viewListRecent.apply {
            layoutManager = LinearLayoutManager(context)
            setEmptyView(binding.emptyData.root)
            setHasFixedSize(true)
            itemAnimator = null
            setScrollListener(this, layoutManager as LinearLayoutManager)
        }
    }

    private fun setScrollListener(
        recyclerView: CustomRecyclerView,
        layoutManager: LinearLayoutManager
    ) {
        recyclerView.addOnScrollListener(object : PaginationScrollListener(
            layoutManager,
            handler = mHandler) {
            override fun loadMoreItems() {
                if (searchKey.isBlank())
                    viewModel.loadUserList()
                else
                    viewModel.searchUserList(searchKey)
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
    }

    private fun setObservers() {

        viewModel.shareModelListLiveData.observe(this) {
            it?.let {
                mForwardSectionAdapter.setProfileDetails(it)
                binding.viewListRecent.adapter = mForwardSectionAdapter
                mForwardSectionAdapter.notifyDataSetChanged()
            }
        }

        viewModel.updatedProfile.observe(this) {
            if (it.first.isValidIndex())
                mForwardSectionAdapter.addProfileDetails(it.first, it.second)
        }

        viewModel.removeLoader.observe(this) {
            mForwardSectionAdapter.removeLoadingFooter()
        }

        viewModel.userList.observe(this) { userList ->
            userList?.let {
                mForwardSectionAdapter.addProfileList(userList)
            }
        }

        viewModel.addLoader.observe(this) {
            if (it)
                mForwardSectionAdapter.addLoadingFooter()
        }

        viewModel.searchListLiveData.observe(this) {
            it?.let {
                mForwardSearchSectionAdapter.setProfileDetails(it)
                mForwardSearchSectionAdapter.notifyDataSetChanged()
            }
        }

        viewModel.searchUserList.observe(this ) { userList ->
            userList?.let {
                mForwardSearchSectionAdapter.addProfileList(userList)
            }
        }

        viewModel.addSearchLoader.observe(this) {
            if (it)
                mForwardSearchSectionAdapter.addLoadingFooter()
        }

        viewModel.removeSearchLoader.observe(this) {
            if (it)
                mForwardSearchSectionAdapter.removeLoadingFooter()
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
                if (searchKey.isBlank()) {
                    mForwardSectionAdapter.addLoadingFooter()
                    viewModel.loadUserList()
                } else {
                    mForwardSearchSectionAdapter.addLoadingFooter()
                    viewModel.searchUserList(searchKey)
                }
            }
        }
    }

    private fun setAdapterBasedOnSearchType() {
        if (mUserListType == UserListType.USER_LIST && (binding.viewListRecent.adapter as SectionedShareAdapter).getSearchKey().isNotBlank()) {
            binding.viewListRecent.adapter = mForwardSectionAdapter
        } else if (mUserListType == UserListType.SEARCH && (binding.viewListRecent.adapter as SectionedShareAdapter).getSearchKey().isBlank()) {
            binding.viewListRecent.adapter = mForwardSearchSectionAdapter
        }
    }

    /**
     * To handle broadcast of any user's profile changes
     * like Profile pic, Profile msg
     */
    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        updateProfileDetails(jid)
    }

    override fun userBlockedMe(jid: String) {
        super.userBlockedMe(jid)
        updateProfileDetails(jid)
    }

    override fun userUnBlockedMe(jid: String) {
        super.userUnBlockedMe(jid)
        updateProfileDetails(jid)
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        mForwardSectionAdapter.removeProfileDetails(jid)
        mForwardSearchSectionAdapter.removeProfileDetails(jid)
        viewModel.removeProfileDetails(jid)
        viewModel.removeSearchProfileDetails(jid)
        selectedUsersWithNames.remove(jid)
        binding.selectedUsers.text = selectedUserNames
    }


    /**
     * Filter the list from the search key
     */
    fun filterList() {
        mUserListType = if (searchKey.isEmpty()) UserListType.USER_LIST else UserListType.SEARCH
        setAdapterBasedOnSearchType()
        mForwardSearchSectionAdapter.setSearchKey(searchKey)
        if (searchKey.isNotBlank())
            viewModel.searchProfileList(searchKey)
    }

    private fun shareFiles() {
        shareDialog.initializeAndShowShareDialog("", "Forwarding Message")
        sendMediaFilesForSingleUser()
    }

    private fun sendMediaFilesForSingleUser() {
        if (AppUtils.isNetConnected(this)) {
            sendMediaMessages()
        } else {
            shareDialog.dismissShareDialog()
            CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }


    private fun sendMediaMessages() {
        validateRecalledMessage()
        launch(exceptionHandler) {
            ChatManager.forwardMessagesToMultipleUsers(forwardMediaMessageIds, selectedUsersWithNames.keys.toList(), object : ChatActionListener {
                override fun onResponse(isSuccess: Boolean, message: String) {
                    if (!isSuccess)
                        CustomToast.show(context, message)
                    finishForwardMedia(true)
                }
            })
        }
    }

    private fun validateRecalledMessage() {
        val recalledMessagesIds = MessageUtils.filterRecalledMessages(forwardMediaMessageIds)
        if (recalledMessagesIds.isNotEmpty()) {
            val diff = forwardMediaMessageIds.size - recalledMessagesIds.size
            if (diff == 0)
                if (forwardMediaMessageIds.size == 1) {
                    CustomToast.showShortToast(context, getString(R.string.cannot_forward_recalled_message))
                    finish()
                } else
                    CustomToast.showShortToast(context, String.format(getString(R.string.cannot_forward_recalled_messages), recalledMessagesIds.size))
            else
                CustomToast.showShortToast(context, String.format(getString(R.string.cannot_forward_recalled_messages), diff))
            forwardMediaMessageIds.removeAll(recalledMessagesIds.toSet())
        }
    }

    private val onItemClickListener = object : RecyclerViewItemClick {
        override fun onItemClicked(position: Int, profileDetails: ProfileDetails) {
            ContactManager.insertProfile(profileDetails)

            ProfileDetailsUtils.addContact(profileDetails)
            if (isSelected(profileDetails.jid))
                selectedUsersWithNames.remove(profileDetails.jid)
            else {
                if (!maxUserReached())
                    selectedUsersWithNames[profileDetails.jid] = profileDetails.getDisplayName()
            }

            binding.selectedUsers.text = selectedUserNames

            if (selectedUsersWithNames.isNotEmpty())
                binding.next.visibility = View.VISIBLE
            else
                binding.next.visibility = View.INVISIBLE
        }

        override fun isSelected(userId: String): Boolean {
            return selectedUsersWithNames.containsKey(userId)
        }
    }

    fun maxUserReached(): Boolean {
        val maxUserReached = selectedUsersWithNames.size >= Constants.MAX_FORWARD_USER_RESTRICTION
        if (maxUserReached)
            Toast.makeText(context, context!!.getString(R.string.maximum_user_forward_validation), Toast.LENGTH_SHORT).show()
        return maxUserReached
    }

    private val selectedUserNames: String
        get() {
            val stringBuilder = StringBuilder()
            return if (selectedUsersWithNames.isEmpty()) {
                "No user selected"
            } else {
                for (name in selectedUsersWithNames.values) {
                    stringBuilder.append(name)
                    stringBuilder.append(", ")
                }
                val selectedNames = stringBuilder.toString()
                selectedNames.substring(0, selectedNames.length - 2)
            }
        }


    private fun finishForwardMedia(isSuccess: Boolean) {
        shareDialog.dismissShareDialog()
        if (isSuccess && selectedUsersWithNames.size == 1){
            privateChatUserChecking(selectedUsersWithNames.keys.first())
        } else {
            finish()
        }
    }

    private fun isPrivateChatOfSender() : Boolean {
        return if(senderJid.isNotEmpty() && ChatManager.isPrivateChat(senderJid)) {
            true
        } else {
            false
        }
    }

    private fun privateChatUserChecking(toUser:String) {
        if(senderJid.isNotEmpty() && ChatManager.isPrivateChat(senderJid) && ChatManager.isPrivateChat(toUser)){
            launchChatView()
        } else if(ChatManager.isPrivateChat(toUser)) {
            launchAuthenticationActivity()
        } else {
            launchChatView()
        }
    }

    private fun launchChatView() {
        if(selectedUsersWithNames.size>0) {
            val intent = Intent(context, ChatActivity::class.java)
            startActivity(intent.putExtra(LibConstants.JID,  selectedUsersWithNames.keys.first())
                .putExtra(Constants.CHAT_TYPE, ProfileDetailsUtils.getProfileDetails(selectedUsersWithNames.keys.first())?.getChatType())
                .putExtra("externalCall", true)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()
        }
    }

    private fun launchAuthenticationActivity() {
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(activity, BiometricActivity::class.java)
            intent.putExtra(Constants.GO_TO, Constants.PRIVATE_CHAT_LIST)
            activityResultLauncher.launch(intent)
        } else  {
            val intent = Intent(activity, PinActivity::class.java)
            intent.putExtra(Constants.GO_TO, Constants.PRIVATE_CHAT_LIST)
            activityResultLauncher.launch(intent)
        }

    }

    private var activityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                launchChatView()
            }
        }


    override fun onBackPressed() {
        finishForwardMedia(false)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    /*
    * Update Profile Details */
    private fun updateProfileDetails(userJid: String) {
        LogMessage.d(TAG, "#ForwardMessage  updateProfileDetails $userJid")
        val position = viewModel.getPositionOfProfile(userJid)
        if (position >= 0) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(userJid)
            mForwardSectionAdapter.updateProfileDetails(profileDetails)
            mForwardSearchSectionAdapter.updateProfileDetails(profileDetails)
        } else
            viewModel.loadForwardChatList(userJid, pair)
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        LogMessage.d(TAG, "#ForwardMessage  onAdminBlockedOther jid $jid type: $type status:$status")
        updateSelectedUsers(jid, status)
    }

    override fun onSuperAdminDeleteGroup(groupJid: String, groupName: String) {
        super.onSuperAdminDeleteGroup(groupJid, groupName)
        LogMessage.d(TAG, "#ForwardMessage  onDeleteGroupBySuperAdmin groupJid $groupJid groupName ${groupName}")
        updateSelectedUsers(groupJid, true)
        if (groupName.isNotEmpty())
            showToast(getString(R.string.deleted_by_super_admin, groupName))
        clearDeletedGroupChatNotification(groupJid, context)
        if(senderJid == groupJid){
            com.contusfly.startDashboardActivity(this)
            finish()
        }
    }

    private fun updateSelectedUsers(jid: String, status: Boolean){
        if (status && selectedUsersWithNames.containsKey(jid)) {
            selectedUsersWithNames.remove(jid)
        }
        mForwardSectionAdapter.removeProfileDetails(jid)
        mForwardSearchSectionAdapter.removeProfileDetails(jid)
        viewModel.removeProfileDetails(jid)
        viewModel.removeSearchProfileDetails(jid)
        binding.selectedUsers.text = selectedUserNames
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        LogMessage.d(TAG, "#ForwardMessage  onContactSyncComplete isSuccess $isSuccess")
        if (isSuccess)
            viewModel.loadForwardChatList(null, pair)
    }
}