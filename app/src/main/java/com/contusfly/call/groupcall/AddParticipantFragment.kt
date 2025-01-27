package com.contusfly.call.groupcall

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.TypedValue
import android.view.*
import android.widget.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flynetwork.ApiCalls
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.contusfly.*
import com.contusfly.call.groupcall.listeners.RecyclerViewUserItemClick
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.helpers.PaginationScrollListener
import com.contusfly.helpers.UserListType
import com.contusfly.network.NetworkConnection
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.UIKitContactUtils
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CustomAlertDialog
import com.contusfly.views.CustomRecyclerView
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.activities.FlyBaseActivity
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils
import com.mirrorflysdk.flycall.webrtc.api.CallActionListener
import com.mirrorflysdk.views.CustomToast
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


/**
 * A simple [Fragment] subclass.
 * Use the [AddParticipantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddParticipantFragment : Fragment(), CoroutineScope{

    @Inject
    lateinit var callViewModelFactory: AppViewModelFactory
    private val viewModel: CallViewModel by viewModels {
        callViewModelFactory
    }

    @Inject
    lateinit var apiCalls: ApiCalls

    private lateinit var addParticipantsLayout: RelativeLayout

    private lateinit var addParticipantsTextView: TextView

    /**
     * Display the contact list and searched list in the recycler view
     */
    private lateinit var listContact: CustomRecyclerView

    private lateinit var emptyView: TextView

    private lateinit var onGoingCallLink: String

    private lateinit var callLinkView: LinearLayout

    private lateinit var callLink: AppCompatTextView

    private lateinit var callLinkCopyIcon: ImageView

    private lateinit var groupId: String

    private var callConnectedUserList: ArrayList<String>? = null

    private lateinit var callLinkTitleTextView: AppCompatTextView

    /**
     * The handler to delay the search
     */
    private lateinit var mHandler: Handler

    /**
     * Used for search
     */
    private var searchKey: String = emptyString()

    private var isRefreshing = false

    private var mUserListType = UserListType.USER_LIST

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private val commonAlertDialog: CommonAlertDialog by lazy {
        CommonAlertDialog(requireContext())
    }

    /**
     * Validate if the call is one to one call
     */
    private var isAddUsersToOneToOneCall: Boolean = false

    /**
     * Selected users from the search list.
     */
    var selectedList: ArrayList<String> = ArrayList()

    private val mAdapter by lazy {
        UserSelectionAdapter(requireContext(), true, commonAlertDialog, onItemClickListener)
    }

    private val mSearchAdapter by lazy {
        UserSelectionAdapter(requireContext(), true, commonAlertDialog, onItemClickListener)
    }

    val onItemClickListener = object : RecyclerViewUserItemClick {
        override fun onItemClicked(position: Int, profileDetails: ProfileDetails) {
            UIKitContactUtils.addUIKitContact(profileDetails)
            if (!selectedList.contains(profileDetails.jid)) {
                if (selectedList.size >= (CallManager.getMaxCallUsersCount() - (CallManager.getCallUsersList().size + 1))) {
                    onUserSelectRestriction()
                } else {
                    selectedList.add(profileDetails.jid)
                }
            } else {
                selectedList.remove(profileDetails.jid)
            }
            addParticipantsTextView.text = selectedUserCount
        }

        override fun onSelectBlockedUser(profileDetails: ProfileDetails) {
            //Do Nothing
        }

        override fun isSelected(userId: String): Boolean {
            return selectedList.contains(userId)
        }

    }

    /**
     * Get Selected users count in CallNow button
     */
    private val selectedUserCount: String
        get() {
            return if (selectedList.isEmpty()) {
                addParticipantsLayout.visibility = View.GONE
                addParticipantsLayout.isEnabled = false
                getString(R.string.msg_add_participant)
            } else {
                addParticipantsLayout.visibility = View.VISIBLE
                addParticipantsLayout.isEnabled = true
                String.format(getString(R.string.msg_add_participants), selectedList.size)
            }
        }

    /**
     * call action listener to listen for invite user list call back
     */
    private var callActionListener: CallActionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            groupId = it.getString(Constants.GROUP_ID, "")
            isAddUsersToOneToOneCall = it.getBoolean(ADD_USERS_TO_ONE_TO_ONE_CALL, false)
            callConnectedUserList = it.getStringArrayList(CONNECTED_USER_LIST)
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        CallUtils.setIsAddUsersToTheCall(false)
        FlyBaseActivity.hideSoftKeyboard(requireActivity())
        super.onDetach()
    }

    override fun onResume() {
        CallUtils.setIsAddUsersToTheCall(true)
        isRefreshing = false
        super.onResume()
        if(GroupCallUtils.isCallLinkBehaviourMeet()){
            LogMessage.d("tag","Meet disabled")
            listContact.visibility = View.GONE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isAddUsersToOneToOneCall)
            viewModel.getInviteUserListForGroup(groupId, callConnectedUserList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_participant, container, false)
        initView(view)
        setListeners()
        setObservers()
        observeNetworkListener()
        return view
    }

    private fun setObservers() {
        requireActivity().let {
            viewModel.profileUpdatedLiveData.observe(viewLifecycleOwner) { userJid ->
                mAdapter.updateRoster(userJid)
            }

            viewModel.inviteUserList.observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    val message =
                        if (isAddUsersToOneToOneCall) requireContext().getString(R.string.all_members_already_in_call) else requireContext().getString(
                            R.string.all_members_already_in_group_call
                        )
                    emptyView.text = message
                    emptyView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                }
                mAdapter.setProfileDetails(it)
                mAdapter.notifyDataSetChanged()
            }
            setUserListObservers()
            setSearchObservers()
        }
    }

    private fun setUserListObservers() {
        viewModel.callUserList.observe(viewLifecycleOwner) { userList ->
            userList?.let {
                if (it.isEmpty()) {
                    val message = if (isAddUsersToOneToOneCall) requireContext().getString(R.string.all_members_already_in_call) else requireContext().getString(R.string.all_members_already_in_group_call)
                    emptyView.text = message
                    emptyView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                }
                mAdapter.addProfileList(userList)
            }
        }

        viewModel.addLoadUserLoader.observe(viewLifecycleOwner) {
            if (it)
                mAdapter.addLoadingFooter()
        }

        viewModel.removeLoadUserLoader.observe(viewLifecycleOwner) {
            if (it)
                mAdapter.removeLoadingFooter()
        }

        viewModel.fetchingError.observe(viewLifecycleOwner) {
            if (it)
                CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }

    private fun setSearchObservers() {
        viewModel.resetSearchResult.observe(viewLifecycleOwner) {
            if (it)
                mSearchAdapter.resetSearch()
        }

        viewModel.searchCallUserList.observe(viewLifecycleOwner ) { userList ->
            userList?.let {
                mSearchAdapter.addProfileList(userList)
            }
        }

        viewModel.addUserSearchLoader.observe(viewLifecycleOwner) {
            if (it)
                mSearchAdapter.addLoadingFooter()
        }

        viewModel.removeUserSearchLoader.observe(viewLifecycleOwner) {
            if (it)
                mSearchAdapter.removeLoadingFooter()
        }
    }

    private fun observeNetworkListener() {
        val networkConnection = NetworkConnection(requireContext())
        networkConnection.observe(viewLifecycleOwner) { connected ->
            if (!BuildConfig.CONTACT_SYNC_ENABLED && connected && viewModel.fetchingError.value == true) { //If user list fetch failed then re-fetch user list when internet is reconnected
                if (searchKey.isBlank()) {
                    mAdapter.addLoadingFooter()
                    viewModel.loadUserList(callConnectedUserList)
                } else {
                    mSearchAdapter.addLoadingFooter()
                    viewModel.searchUserList(searchKey, callConnectedUserList)
                }
            }
        }
    }

    private fun initView(view: View) {
        mHandler = Handler(Looper.getMainLooper())
        onGoingCallLink = CallManager.getCallLink()

        callLinkTitleTextView = view.findViewById(R.id.call_link_title_view)
        callLinkView = view.findViewById(R.id.call_link_view)
        callLink = view.findViewById(R.id.call_link)
        callLinkCopyIcon = view.findViewById(R.id.call_link_copy)
        emptyView = view.findViewById(R.id.text_empty_view)
        emptyView.text = getString(R.string.msg_no_contacts)
        emptyView.setTextColor(ResourcesCompat.getColor(resources, R.color.color_text_grey, null))
        listContact = view.findViewById(R.id.view_contact_list)
        setContactAdapter()

        if (onGoingCallLink.isNotEmpty()) {
            callLinkView.visibility = View.VISIBLE
            callLink.text = onGoingCallLink
            callLinkCopyIcon.setOnClickListener {
                val clipboardManager  = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData  = ClipData.newPlainText("text", BuildConfig.WEB_CHAT_LOGIN + onGoingCallLink)
                clipboardManager .setPrimaryClip(clipData )
                CustomToast.show(context, getString(R.string.link_copied_clipboard))
            }
        }

        addParticipantsLayout = view.findViewById(R.id.add_participants_layout)
        addParticipantsTextView = view.findViewById(R.id.add_participants_text_view)
        if(GroupCallUtils.isCallLinkBehaviourMeet()){
            emptyView.text = ""
            listContact.visibility = View.GONE
            callLinkTitleTextView.text = getString(R.string.meet_link)
        }
        addParticipantButtonAdjustOverKeyboard(view)

    }

    /**
     * for below android 10 versions keypad is not adjusted.
     */
    private fun addParticipantButtonAdjustOverKeyboard(view: View) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val rootView = view.findViewById<View>(R.id.root_add_participant)
            rootView.viewTreeObserver.addOnGlobalLayoutListener {
                val rect = Rect()
                rootView.getWindowVisibleDisplayFrame(rect)
                val screenHeight = rootView.rootView.height
                val keypadHeight = screenHeight - rect.bottom

                if (keypadHeight > screenHeight * 0.15) { // If keyboard is displayed
                    // Adjust your layout or button position here
                    addParticipantsLayout.translationY = -keypadHeight.toFloat()
                } else {
                    // Reset the position of the button
                    addParticipantsLayout.translationY = 0f
                }
            }
        }

    }

    private fun setContactAdapter() {
        listContact.apply {
            layoutManager = LinearLayoutManager(context)
            setItemViewCacheSize(0)
            setHasFixedSize(true)
            setEmptyView(emptyView)
            itemAnimator = null
            adapter = mAdapter

            if ( isAddUsersToOneToOneCall){
                if (BuildConfig.CONTACT_SYNC_ENABLED) {
                    viewModel.getInviteUserList(callConnectedUserList)
                } else {
                    setScrollListener(this, layoutManager as LinearLayoutManager)
                }
            }
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
                    viewModel.loadUserList(callConnectedUserList)
                else
                    viewModel.searchUserList(searchKey, callConnectedUserList)
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
        viewModel.loadUserList(callConnectedUserList)
    }

    private fun setListeners() {
        addParticipantsLayout.setOnClickListener {
            if(AppUtils.isNetConnected(requireActivity())){
                checkAndInviteUsersToOngoingCall()
            }else{
                CustomToast.show(context, getString(R.string.msg_no_internet))
                addParticipantsLayout.isEnabled = false
                requireActivity().supportFragmentManager.popBackStackImmediate()
            }
        }
    }

    private fun checkAndInviteUsersToOngoingCall(){
        if (selectedList.isNotEmpty()) {
            if (!ChatManager.getAvailableFeatures().isGroupCallEnabled) {
                CustomAlertDialog().showFeatureRestrictionAlert(requireContext())
            } else {
                addParticipantsLayout.isEnabled = false
                val newSelectedList: ArrayList<String> = arrayListOf()
                newSelectedList.addAll(selectedList)
                CallManager.inviteUsersToOngoingCall(newSelectedList, inputCallActionListener = callActionListener)
                CallUtils.setIsAddUsersToTheCall(false)
                requireActivity().supportFragmentManager.popBackStackImmediate()
            }
        } else {
            CustomToast.show(requireContext(), getString(com.contus.call.R.string.error_select_atleast_one))
        }
    }

    fun onUserSelectRestriction() {
        val availableCount =
            CallManager.getMaxCallUsersCount() - (CallManager.getCallUsersList().size + 1) //plus 1 for own user
        if (availableCount == 1)
            Toast.makeText(
                requireContext(),
                String.format(
                    requireContext().getString(R.string.msg_user_call_limit_one_user),
                    availableCount
                ),
                Toast.LENGTH_SHORT
            ).show()
        else
            Toast.makeText(
                requireContext(),
                String.format(getString(R.string.max_members_in_call), CallManager.getMaxCallUsersCount()),
                Toast.LENGTH_SHORT
            ).show()
    }

    fun refreshUsersList() {
        LogMessage.i(TAG, "${com.contus.call.CallConstants.CALL_UI} refreshUsersList")
        getRefreshedProfilesList()
    }

    fun refreshUser(jid: String) {
        LogMessage.i(TAG, "${com.contus.call.CallConstants.CALL_UI} refreshUser")
        val index = mAdapter.profileDetailsList.indexOfFirst { it.jid == jid }
        if (index.isValidIndex()) {
            updateProfileDetails(jid)
        }
    }

    fun removeUser(jid: String) {
        LogMessage.i(TAG, "${com.contus.call.CallConstants.CALL_UI} removeUser")
        selectedList.remove(jid)
        mAdapter.removeUser(jid)
    }

    fun onAdminBlockedStatus(jid: String, type: String, status: Boolean) {
        LogMessage.i(TAG, "OnAdminBlockedStatus jid = $jid, type = $type, status = $status")
        if (status && selectedList.isNotEmpty()) {
            val isJidSelected = selectedList.any { it == jid }
            val index = selectedList.indexOf(jid)
            if (isJidSelected && index.isValidIndex()) {
                selectedList.removeAt(index)
            }
            removeUser(jid)
            addParticipantsTextView.text = selectedUserCount
        }
        getRefreshedProfilesList()
    }

    private fun getRefreshedProfilesList() {
        lifecycleScope.launchWhenStarted {
            if (isAddUsersToOneToOneCall) {
                if (BuildConfig.CONTACT_SYNC_ENABLED)
                    viewModel.getInviteUserList(callConnectedUserList)
            } else
                viewModel.getInviteUserListForGroup(groupId, callConnectedUserList)
        }
    }

    fun filterResult(searchKey: String) {
        this.searchKey = searchKey.trim()
        if (isAddUsersToOneToOneCall && !BuildConfig.CONTACT_SYNC_ENABLED) {
            mHandler.removeCallbacksAndMessages(null)
            mHandler.postDelayed({
                mSearchAdapter.resetSearch()
                if (searchKey.isEmpty()) {
                    mUserListType = UserListType.USER_LIST
                } else {
                    mUserListType = UserListType.SEARCH
                    viewModel.resetSearch()
                    viewModel.addSearchLoaderToTheList()
                    viewModel.searchUserList(searchKey, callConnectedUserList)
                }
                setAdapterBasedOnSearchType()
                mSearchAdapter.setSearchKey(searchKey)
            }, 500)
        } else {
            if (searchKey.isNotBlank()) {
                mSearchAdapter.resetSearch()
                mSearchAdapter.addProfileList(filterList(mAdapter.profileDetailsList))
            }
            mUserListType = if (searchKey.isEmpty()) {
                UserListType.USER_LIST
            } else {
                UserListType.SEARCH
            }
            setAdapterBasedOnSearchType()
            mSearchAdapter.setSearchKey(searchKey)
        }
    }

    private fun filterList(profileDetailsList: ArrayList<ProfileDetails>): List<ProfileDetails> {
        return profileDetailsList.filter { it.getDisplayName().contains(searchKey, true) }
    }

    private fun setAdapterBasedOnSearchType() {
        if (mUserListType == UserListType.USER_LIST && (listContact.adapter as UserSelectionAdapter).getSearchKey().isNotBlank()) {
            listContact.adapter = mAdapter
        } else if (mUserListType == UserListType.SEARCH && (listContact.adapter as UserSelectionAdapter).getSearchKey().isBlank()) {
            listContact.adapter = mSearchAdapter
        }
    }

    companion object {

        /**
         * key constant for add user for existing call action
         */
        const val ADD_USERS_TO_ONE_TO_ONE_CALL = "add_users_to_one_to_one_call"

        const val CONNECTED_USER_LIST = "connected_user_list"

        /**
         * The constructor used to create and initialize a new instance of this class object, with the
         * specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(
            groupId: String?,
            isOneToOneCall: Boolean,
            callUsersList: ArrayList<String>?,
            callActionListener: CallActionListener?
        ) = AddParticipantFragment().apply {
            arguments = Bundle().apply {
                putString(Constants.GROUP_ID, groupId)
                putBoolean(ADD_USERS_TO_ONE_TO_ONE_CALL, isOneToOneCall)
                putStringArrayList(CONNECTED_USER_LIST, callUsersList)
            }
            this.callActionListener = callActionListener
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + Job()

    /*
    * Update Profile Details */
    private fun updateProfileDetails(userJid: String) {
        val profileDetails = ProfileDetailsUtils.getProfileDetails(userJid)
        mAdapter.updateProfileDetails(profileDetails)
    }

    fun updateMemberRemovedOrAddedInUserList(isUserLeft: Boolean, jid: String, mGroupId: String?) {
        if (groupId == mGroupId) {
            if (isUserLeft) {
                if (selectedList.isNotEmpty()) {
                    val isJidSelected = selectedList.any { it == jid }
                    val index = selectedList.indexOf(jid)
                    if (isJidSelected && index.isValidIndex()) {
                        selectedList.removeAt(index)
                    }
                }
                removeUser(jid)
                addParticipantsTextView.text = selectedUserCount
            } else {
                getRefreshedProfilesList()
            }
        }
    }
}