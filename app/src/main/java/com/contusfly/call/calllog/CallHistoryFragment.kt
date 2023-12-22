package com.contusfly.call.calllog

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.activities.BaseActivity
import com.contusfly.activities.BiometricActivity
import com.contusfly.activities.ChatActivity
import com.contusfly.activities.DashboardActivity
import com.contusfly.activities.NewContactsActivity
import com.contusfly.activities.PinActivity
import com.contusfly.activities.UserListActivity
import com.contusfly.call.CallConfiguration
import com.contusfly.call.CallPermissionUtils
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.checkInternetAndExecute
import com.contusfly.databinding.FragmentCallHistoryBinding
import com.contusfly.di.factory.AppViewModelFactory
import com.contusfly.getMessage
import com.contusfly.helpers.PaginationScrollListener
import com.contusfly.isValidIndex
import com.contusfly.runOnUiThread
import com.contusfly.setOnClickListener
import com.contusfly.utils.AppConstants
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.ItemClickSupport
import com.contusfly.utils.MediaPermissions
import com.contusfly.utils.ProfileDetailsUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.PermissionAlertDialog
import com.contusfly.visibilityChanged
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flycall.call.database.model.CallLog
import com.mirrorflysdk.flycall.call.utils.CallConstants
import com.mirrorflysdk.flycall.webrtc.CallMode
import com.mirrorflysdk.flycall.webrtc.CallState
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.Logger
import com.mirrorflysdk.flycall.webrtc.api.CallLogManager
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flynetwork.ApiCalls
import com.mirrorflysdk.flynetwork.model.createmeetlink.MeetLinkDetailsData
import com.mirrorflysdk.views.CustomToast
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CallHistoryFragment : Fragment(), CoroutineScope,
    CommonAlertDialog.CommonDialogClosedListener, CallLogManager.CallLogActionListener {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine Exception ${TAG}:  ${exception.printStackTrace()}")
    }

    private var lastCallAction = ""

    private val mHandler = Handler(Looper.getMainLooper())

    @Inject
    lateinit var apiCalls: ApiCalls

    private lateinit var callHistoryBinding: FragmentCallHistoryBinding

    private var mSearchCallLogs = ArrayList<CallLog>()

    private lateinit var mAdapter: CallHistoryAdapter

    private val mSearchAdapter by lazy {
        CallHistorySearchAdapter(
            requireContext(),
            mSearchCallLogs,
            viewModel.selectedCallLogs,
            listener
        )
    }

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private lateinit var commonAlertDialog: CommonAlertDialog

    private var mCallLogsType = CallLogsType.NORMAL

    private var searchKeyword: String = ""

    /**
     * Boolean to verify whether the entire call log history has to be deleted.
     */
    private var isClearAll: Boolean = false

    private var isDeleteCallLogInitiated: Boolean = false

    private lateinit var callPermissionUtils: CallPermissionUtils

    @Inject
    lateinit var callLogsViewModelFactory: AppViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(
            requireActivity(), callLogsViewModelFactory
        )[CallLogViewModel::class.java]
    }

    private val permissionAlertDialog: PermissionAlertDialog by lazy {
        PermissionAlertDialog(requireActivity())
    }

    private val contactPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val contactPermissionGranted =
            permissions[Manifest.permission.READ_CONTACTS] ?: ChatUtils.checkMediaPermission(
                requireContext(),
                Manifest.permission.READ_CONTACTS
            )

        if (contactPermissionGranted) {
            (requireActivity() as BaseActivity).checkContactChange()
            selectParticipants()
        }
    }

    private val dashBoardViewModel: DashboardViewModel by viewModels(
        { requireActivity() },
        { callLogsViewModelFactory })

    private var listener = object : CallHistoryAdapter.OnItemClickListener {
        override fun onItemClick(view: ImageView, position: Int) {
            if (viewModel.selectedCallLogs.isEmpty())
                openChatView(view, position)
            else selectUnselectPayload(position)
        }
    }

    // Request multiple permissions contract
    private val requestCallPermissions: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            // Do something if some permissions granted or denied
            if (!permissions.containsValue(false)) {
                if (lastCallAction == CallType.AUDIO_CALL) {
                    launchAudioCall()
                } else {
                    launchVideoCall()
                }
            }
        }

    private fun launchAudioCall() {
        if (CallManager.isNotificationPermissionsGranted()) {
            callPermissionUtils.audioCall()
        } else {
            notificationPermissionChecking()
        }
    }

    private fun launchCall(lastCallAction: String) {
        if (lastCallAction == CallType.AUDIO_CALL) {
            launchAudioCall()
        } else {
            launchVideoCall()
        }
    }

    private fun launchVideoCall() {
        if (CallManager.isNotificationPermissionsGranted()) {
            callPermissionUtils.videoCall()
        } else {
            notificationPermissionChecking()
        }
    }

    private fun notificationPermissionChecking() {
        MediaPermissions.requestNotificationPermission(
            requireActivity(),
            permissionAlertDialog,
            notificationPermissionLauncher
        )
    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (!permissions.containsValue(false)) {
            if (lastCallAction == CallType.AUDIO_CALL) {
                launchAudioCall()
            } else {
                launchVideoCall()
            }
        }
    }

    // General activity result contract
    private lateinit var openContactsActivity: ActivityResultLauncher<Intent>

    private val launchIntent = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { _: ActivityResult ->
        callLogListener()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private var toUserJid: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        callHistoryBinding = FragmentCallHistoryBinding.inflate(inflater, container, false)
        return callHistoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        callLogListener()
        setObservers()
        setListeners()
        viewModel.addLoaderToTheList()
        viewModel.getCallLogsList(CallUtils.isCallsTabToBeShown())
        CallUtils.setCallsTabToBeShown(false)
    }

    private fun initView() {
        openContactsActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val selectedCallUsersList =
                        result.data?.getStringArrayListExtra(com.contusfly.utils.Constants.USERS_JID)!!
                    makeCall(
                        lastCallAction, "",
                        isBlocked = false,
                        isAdminBlocked = false,
                        jidList = selectedCallUsersList
                    )
                }
            }

        mAdapter = CallHistoryAdapter(
            requireContext(),
            viewModel.callLogAdapterList,
            viewModel.selectedCallLogs,
            listener
        )
        mAdapter.setHasStableIds(true)
        callHistoryBinding.listCallHistory.adapter = mAdapter

        callHistoryBinding.listCallHistory.apply {
            layoutManager = LinearLayoutManager(context)
            setItemViewCacheSize(20)
            itemAnimator = null
            setHasFixedSize(true)
            setEmptyView(callHistoryBinding.viewNoCallHistory.root)
            setScrollListener(layoutManager as LinearLayoutManager)
        }
        callHistoryBinding.fabAddCall.setOnClickListener {
            if (callHistoryBinding.fabMakeVoiceCall.isVisible) {
                callHistoryBinding.fabMakeVoiceCall.hide()
                callHistoryBinding.fabMakeVideoCall.hide()
            } else {
                callHistoryBinding.fabMakeVoiceCall.show()
                callHistoryBinding.fabMakeVideoCall.show()
            }
        }

        setClickListenerForAudioCall()

        setClickListenerForVideoCall()

        setClickListenerForCreateCallLink()

        callHistoryBinding.viewNoCallHistory.root.visibilityChanged {
            when (it.visibility) {
                View.VISIBLE -> {
                    callHistoryBinding.recentCall.visibility = View.GONE
                }

                View.GONE -> {
                    callHistoryBinding.recentCall.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setClickListenerForAudioCall() {
        callHistoryBinding.fabMakeVoiceCall.setOnClickListener(1000) {
            if (BuildConfig.CONTACT_SYNC_ENABLED) {
                lastCallAction = CallType.AUDIO_CALL
                checkPermissionAndSelectParticipant()
            } else {
                val intent = Intent(context, UserListActivity::class.java).apply {
                    putExtra(
                        com.contusfly.utils.Constants.TITLE,
                        getString(R.string.title_contacts)
                    )
                    putExtra(com.contusfly.utils.Constants.MULTI_SELECTION, true)
                    putExtra(com.contusfly.utils.Constants.IS_MAKE_CALL, true)
                    putExtra(com.contusfly.utils.Constants.CALL_TYPE, CallType.AUDIO_CALL)
                }
                openContactsActivity.launch(intent)
                lastCallAction = CallType.AUDIO_CALL
                callHistoryBinding.fabMakeVoiceCall.hide()
                callHistoryBinding.fabMakeVideoCall.hide()
            }
        }
    }

    private fun setClickListenerForVideoCall() {
        callHistoryBinding.fabMakeVideoCall.setOnClickListener(1000) {
            if (BuildConfig.CONTACT_SYNC_ENABLED) {
                lastCallAction = CallType.VIDEO_CALL
                checkPermissionAndSelectParticipant()
            } else {
                val intent = Intent(context, UserListActivity::class.java).apply {
                    putExtra(
                        com.contusfly.utils.Constants.TITLE,
                        getString(R.string.title_contacts)
                    )
                    putExtra(com.contusfly.utils.Constants.MULTI_SELECTION, true)
                    putExtra(com.contusfly.utils.Constants.IS_MAKE_CALL, true)
                    putExtra(com.contusfly.utils.Constants.CALL_TYPE, CallType.VIDEO_CALL)
                }
                openContactsActivity.launch(intent)
                lastCallAction = CallType.VIDEO_CALL
                callHistoryBinding.fabMakeVoiceCall.hide()
                callHistoryBinding.fabMakeVideoCall.hide()
            }
        }
    }

    private fun setClickListenerForCreateCallLink() {
        callHistoryBinding.viewCreateCallLink.root.setOnClickListener(1000) {
            requireContext().checkInternetAndExecute {
                try {
                    CallManager.createMeetLink { isSuccess, _, createMeetLinkData ->
                        if (isSuccess) {
                            val meetLink = createMeetLinkData["data"] as String
                            LogMessage.d(TAG, "Create Meet Link :$meetLink")
                            showCreateMeetLinkDialog(meetLink = meetLink)
                        } else {

                            val errorMessage = createMeetLinkData.getMessage()
                            runOnUiThread {
                                CustomToast.show(requireContext(), errorMessage)
                            }
                            LogMessage.d(TAG, "Create Meet Link Failed with Message $errorMessage")
                        }
                    }
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }
        }
    }

    private fun checkPermissionAndSelectParticipant() {
        if (MediaPermissions.isPermissionAllowed(
                requireContext(),
                Manifest.permission.READ_CONTACTS
            )
        ) {
            selectParticipants()
        } else MediaPermissions.requestContactsReadPermission(
            requireActivity(),
            permissionAlertDialog,
            contactPermissionLauncher,
            null
        )
    }


    private fun selectParticipants() {
        val intent = Intent(context, NewContactsActivity::class.java).apply {
            putExtra(com.contusfly.utils.Constants.TITLE, getString(R.string.title_contacts))
            putExtra(com.contusfly.utils.Constants.MULTI_SELECTION, true)
            putExtra(com.contusfly.utils.Constants.IS_MAKE_CALL, true)
            putExtra(com.contusfly.utils.Constants.CALL_TYPE, lastCallAction)
        }
        openContactsActivity.launch(intent)
        callHistoryBinding.fabMakeVoiceCall.hide()
        callHistoryBinding.fabMakeVideoCall.hide()
        callHistoryBinding.viewNoCallHistory
    }

    private fun callLogListener() {
        CallLogManager.setCallLogsListener(object : CallLogManager.CallLogsListener {
            override fun onCallLogsDeleted(isClearAll: Boolean, callIdList: ArrayList<String>) {
                if (isDeleteCallLogInitiated) {
                    isDeleteCallLogInitiated = false
                    return
                }
                if (isClearAll) {
                    viewModel.getAllCallLogs()
                } else {
                    mAdapter.deleteCallLogList(callIdList)
                    updateCallLogSearch()
                }
                startActionModeChange(-1, false)
            }

            override fun onCallLogsUpdated() {
                mAdapter.clearCallLogs()
                viewModel.addLoaderToTheList()
                viewModel.getCallLogsList(false)
                Log.d(TAG, "Call Logs Updated")
                (activity as DashboardActivity).validateMissedCallsCount()
            }
        })
    }

    private fun updateCallLogSearch() {
        if (mCallLogsType == CallLogsType.SEARCH) {
            viewModel.filterCallLogsList(searchKeyword)
        }
    }

    private fun setScrollListener(layoutManager: LinearLayoutManager) {
        callHistoryBinding.listCallHistory.addOnScrollListener(object :
            PaginationScrollListener(layoutManager, handler = mHandler) {
            override fun loadMoreItems() {
                viewModel.getCallLogsList(false)
            }

            override fun isLastPage(): Boolean {
                return viewModel.lastPageFetched()
            }

            override fun isFetching(): Boolean {
                return viewModel.getUserListFetching()
            }
        })
    }

    private fun setObservers() {
        setPaginationObservers()
        dashBoardViewModel.isUserBlockedUnblockedMe.observe(viewLifecycleOwner) {
            val bundle = Bundle()
            bundle.putInt(AppConstants.NOTIFY_PROFILE_ICON, 3)
            getIndicesOfUserInCallLog(it.first, false).forEachIndexed { _, callLog ->
                if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter)) {
                    val finalIndex =
                        viewModel.callLogAdapterList.indexOfFirst { cl -> cl.roomId == callLog.roomId }
                    mAdapter.notifyItemChanged(finalIndex, bundle)
                } else if (mCallLogsType == CallLogsType.SEARCH && (callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter)) {
                    val finalIndex =
                        mSearchCallLogs.indexOfFirst { cl -> cl.roomId == callLog.roomId }
                    mSearchAdapter.notifyItemChanged(finalIndex, bundle)
                }
            }
        }
        dashBoardViewModel.isUserBlockedByAdmin.observe(viewLifecycleOwner) {
            try {
                val bundle = Bundle()
                bundle.putInt(AppConstants.NOTIFY_ADMIN_BLOCK, 8)
                getIndicesOfUserInCallLog(it.first, true).forEachIndexed { _, callLog ->
                    if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter)) {
                        val finalIndex =
                            viewModel.callLogAdapterList.indexOfFirst { cl -> cl.roomId == callLog.roomId }
                        mAdapter.notifyItemChanged(finalIndex, bundle)
                    } else if (mCallLogsType == CallLogsType.SEARCH && (callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter)) {
                        val finalIndex =
                            mSearchCallLogs.indexOfFirst { cl -> cl.roomId == callLog.roomId }
                        mSearchAdapter.notifyItemChanged(finalIndex, bundle)
                    }
                }
            } catch (e: Exception) {
                com.contusfly.utils.LogMessage.d(
                    TAG,
                    "#admin blocked status exception: ${e.message}"
                )
            }
        }

        clearCallLogObserver()
        profileUpdateObserver()
    }

    private fun clearCallLogObserver() {
        viewModel.clearAllCallLog.observe(viewLifecycleOwner) { _ ->
            showClearAlertDialog(true)
        }
    }

    private fun setPaginationObservers() {
        viewModel.callList.observe(viewLifecycleOwner) { userList ->
            userList?.let {
                mAdapter.addCallLogList(userList)
            }
            clearCallLogNotify()
        }

        viewModel.addLoader.observe(viewLifecycleOwner) {
            if (it)
                mAdapter.addLoadingFooter()
        }

        viewModel.removeLoader.observe(viewLifecycleOwner) {
            if (it)
                mAdapter.removeLoadingFooter()
        }

        viewModel.fetchingError.observe(viewLifecycleOwner) {
            if (it)
                CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }

    private fun clearCallLogNotify() {
        dashBoardViewModel.updateClearAllCallLogMenu()
    }

    private fun profileUpdateObserver() {
        dashBoardViewModel.profileUpdatedLiveData.observe(viewLifecycleOwner) { userJid ->
            notifyProfileUpdate(userJid)
        }
        dashBoardViewModel.groupUpdatedLiveData.observe(viewLifecycleOwner) { userJid ->
            notifyProfileUpdate(userJid)
        }
        dashBoardViewModel.callsSearchKey.observe(viewLifecycleOwner) { doSearch(it) }
        viewModel.filteredCallLogsList.observe(viewLifecycleOwner) { observeFilteredCallLogs(it) }
        viewModel.updatedFeaturesLiveData.observe(viewLifecycleOwner) {
            if (it.isGroupCallEnabled || it.isOneToOneCallEnabled) {
                if (callHistoryBinding.listCallHistory.adapter == null)
                    callHistoryBinding.listCallHistory.adapter = mAdapter
                else
                    setAdapterBasedOnSearchType()
            }
        }
    }

    private fun notifyProfileUpdate(userJid: String) {
        val bundle = Bundle()
        bundle.putInt(AppConstants.NOTIFY_PROFILE_ICON, 3)
        getIndicesOfUserInCallLog(userJid, true).forEachIndexed { _, callLog ->
            if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter)) {
                val finalIndex =
                    viewModel.callLogAdapterList.indexOfFirst { cl -> cl.roomId == callLog.roomId }
                if (finalIndex.isValidIndex())
                    mAdapter.notifyItemChanged(finalIndex, bundle)
            } else if (mCallLogsType == CallLogsType.SEARCH && (callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter)) {
                mSearchAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun doSearch(searchKey: String) {
        if (!isVisible)
            return
        searchKeyword = searchKey
        mSearchAdapter.setSearchKey(searchKey)
        if (searchKey.isEmpty()) {
            mCallLogsType = CallLogsType.NORMAL
            setAdapterBasedOnSearchType()
        } else {
            if (mCallLogsType == CallLogsType.NORMAL) {
                mCallLogsType = CallLogsType.SEARCH
                setAdapterBasedOnSearchType()
            }
            viewModel.filterCallLogsList(searchKey)
        }
    }

    private fun observeFilteredCallLogs(callLogs: List<CallLog>) {
        mSearchCallLogs.clear()
        mSearchCallLogs.addAll(callLogs)
        callHistoryBinding.listCallHistory.recycledViewPool.clear() // This line is used to clear recycle pool while reloading the data
        mSearchAdapter.notifyDataSetChanged()
    }

    private fun setAdapterBasedOnSearchType() {
        if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter))
            callHistoryBinding.listCallHistory.adapter = mAdapter
        else if (mCallLogsType == CallLogsType.SEARCH && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter))
            callHistoryBinding.listCallHistory.adapter = mSearchAdapter
    }

    private fun getIndicesOfUserInCallLog(jid: String, isFromAdminBlock: Boolean) =
        viewModel.callLogAdapterList.filter { callLog ->
            if (isFromAdminBlock) return@filter true
            val endUserJid = if (callLog.callState == CallState.INCOMING_CALL
                || callLog.callState == CallState.MISSED_CALL
            )
                callLog.fromUser else callLog.toUser
            return@filter endUserJid?.trim() == jid && callLog.callMode == CallMode.ONE_TO_ONE
        }


    private fun setListeners() {
        commonAlertDialog = CommonAlertDialog(context)
        commonAlertDialog.setOnDialogCloseListener(this)

        val clickSupport = ItemClickSupport(callHistoryBinding.listCallHistory).addTo()

        clickSupport.setOnItemClickListener { _, position, v ->
            handleOnItemClicked(v, position)
        }

        clickSupport.setOnItemLongClickListener { _, position, _ ->
            handleOnItemLongClicked(position)
            true
        }
    }

    private fun selectUnselectPayload(position: Int) {
        val bundle = Bundle()
        bundle.putInt(AppConstants.NOTIFY_SELECTION, 4)
        val selectedCallLog: CallLog =
            if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter)) {
                viewModel.callLogAdapterList[position]
            } else {
                mSearchCallLogs[position]
            }
        if (viewModel.selectedCallLogs.contains(selectedCallLog.roomId)) {
            viewModel.selectedCallLogs.remove(selectedCallLog.roomId)
            bundle.putBoolean(AppConstants.NOTIFY_IS_SELECTED, false)
        } else {
            bundle.putBoolean(AppConstants.NOTIFY_IS_SELECTED, true)
            viewModel.selectedCallLogs.add(selectedCallLog.roomId!!)
        }
        if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter))
            mAdapter.notifyItemChanged(position, bundle)
        else if (mCallLogsType == CallLogsType.SEARCH && (callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter))
            mSearchAdapter.notifyItemChanged(position, bundle)

    }

    private fun handleOnItemClicked(view: View?, position: Int) {
        if (viewModel.selectedCallLogs.isEmpty())
            openChatView(view, position)
        else selectUnselectPayload(position)
        startActionModeChange(viewModel.selectedCallLogs.size, false)
    }

    private fun handleOnItemLongClicked(position: Int) {
        val selectedCallLog: CallLog =
            if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter)) {
                viewModel.callLogAdapterList[position]
            } else {
                mSearchCallLogs[position]
            }

        if (!viewModel.selectedCallLogs.contains(selectedCallLog.roomId)) {
            viewModel.selectedCallLogs.add(selectedCallLog.roomId!!)
            val bundle = Bundle()
            bundle.putInt(AppConstants.NOTIFY_SELECTION, 4)
            bundle.putBoolean(AppConstants.NOTIFY_IS_SELECTED, true)
            if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter))
                mAdapter.notifyItemChanged(position, bundle)
            else if (mCallLogsType == CallLogsType.SEARCH && (callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter))
                mSearchAdapter.notifyItemChanged(position, bundle)
            startActionModeChange(viewModel.selectedCallLogs.size, true)
        }
    }

    private fun openChatView(view: View?, position: Int) {
        val callLog: CallLog? =
            if ((callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter))
                mSearchAdapter.getCallLogAtPosition(position)
            else
                mAdapter.getCallLogAtPosition(position)
        if (callLog != null) {
            val toUser = if (callLog.callState == CallState.INCOMING_CALL
                || callLog.callState == CallState.MISSED_CALL
            )
                callLog.fromUser else callLog.toUser

            if (!callLog.groupId.isNullOrEmpty() || (!callLog.userList.isNullOrEmpty() && callLog.userList!!.filter { it != CallManager.getCurrentUserId() }.size > 1)) {
                openGroupChatView(callLog, view)
            } else {
                openDirectChatView(callLog, view, toUser)
            }
        }
    }

    private fun openDirectChatView(callLog: CallLog, view: View?, toUser: String?) {
        val profileDetails = ProfileDetailsUtils.getProfileDetails(toUser!!)
        val mTempUserListWithoutOwnJid = callLog.userList
        mTempUserListWithoutOwnJid?.remove(SharedPreferenceManager.getCurrentUserJid())
        if (!mTempUserListWithoutOwnJid.isNullOrEmpty() && mTempUserListWithoutOwnJid.size >= 2) {
            if (view?.id == R.id.img_call_type) {
                makeJanusCall(callLog.groupId!!, callLog, profileDetails, true)
            } else {
                val intent = Intent(activity, CallHistoryDetailActivity::class.java)
                intent.putExtra(CallConstants.ROOM_ID, callLog.roomId)
                launchIntent.launch(intent)
            }

        } else if (profileDetails != null) {
            if (view?.id == R.id.img_call_type) {
                makeJanusCall(toUser, callLog, profileDetails, false)
            } else {
                privateChatUserChecking(toUser)
            }
        }
    }

    private fun launchChatPage(toUser: String) {
        startActivity(
            Intent(activity, ChatActivity::class.java)
                .putExtra(LibConstants.JID, toUser)
                .putExtra(Constants.CHAT_TYPE, ChatType.TYPE_CHAT)
        )
    }

    private fun privateChatUserChecking(toUser: String) {
        toUserJid = toUser
        if (ChatManager.isPrivateChat(toUser)) {
            launchPinActivity(true)
        } else {
            launchChatPage(toUser)
        }
    }

    private fun launchPinActivity(isChatPage: Boolean) {
        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.BIOMETRIC)) {
            val intent = Intent(activity, BiometricActivity::class.java)
            intent.putExtra(
                com.contusfly.utils.Constants.GO_TO,
                com.contusfly.utils.Constants.PRIVATE_CHAT_LIST
            )
            if (isChatPage) {
                myActivityResultLauncher.launch(intent)
            } else {
                callActivityResultLauncher.launch(intent)
            }

        } else {
            val intent = Intent(activity, PinActivity::class.java)
            intent.putExtra(
                com.contusfly.utils.Constants.GO_TO,
                com.contusfly.utils.Constants.PRIVATE_CHAT_LIST
            )
            if (isChatPage) {
                myActivityResultLauncher.launch(intent)
            } else {
                callActivityResultLauncher.launch(intent)
            }
        }

    }

    private var myActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                launchChatPage(toUserJid)
            }
        }

    private var callActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                launchCall(lastCallAction)
            }
        }


    private fun makeJanusCall(
        jid: String,
        callLog: CallLog,
        profileDetails: ProfileDetails?,
        isGroupCall: Boolean
    ) {
        if (isGroupCall) {
            val recentItem = FlyCore.getRecentChatOf(jid)
            if (recentItem != null && recentItem.isAdminBlocked) {
                LogMessage.d(TAG, getString(R.string.group_block_message_label))
                return
            }
            makeCall(
                callLog.callType!!,
                callLog.groupId,
                profileDetails!!.isBlocked,
                profileDetails.isAdminBlocked,
                arrayListOf(profileDetails.jid)
            )
        } else {
            val userProfile = ProfileDetailsUtils.getProfileDetails(jid)
            if (userProfile != null && userProfile.isAdminBlocked) {
                LogMessage.d(TAG, getString(R.string.user_block_message_label))
                return
            }
            makeCall(
                callLog.callType!!,
                callLog.groupId,
                profileDetails!!.isBlocked,
                profileDetails.isAdminBlocked,
                arrayListOf(profileDetails.jid)
            )
        }
    }

    private fun openGroupChatView(callLog: CallLog, view: View?) {
        if (view?.id == R.id.img_call_type) {
            if (isAdminBlocked(callLog)) {
                LogMessage.d(TAG, getString(R.string.group_block_message_label))
                return
            }

            if (CallConfiguration.isGroupCallEnabled()) {
                makeCall(
                    callLog.callType!!,
                    callLog.groupId,
                    isBlocked = false, isAdminBlocked = false,
                    jidList = CallUtils.getCallLogUserJidList(
                        callLog.fromUser,
                        callLog.userList,
                        false
                    ) as java.util.ArrayList<String>
                )
            } else {
                Toast.makeText(
                    activity,
                    getString(R.string.info_group_call_not_allowed),
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            val intent = Intent(activity, CallHistoryDetailActivity::class.java)
            intent.putExtra(CallConstants.ROOM_ID, callLog.roomId)
            launchIntent.launch(intent)
        }

    }

    private fun isAdminBlocked(callLog: CallLog): Boolean {
        return if (callLog.callMode == CallMode.ONE_TO_ONE && (callLog.userList == null || callLog.userList!!.size < 2)) {
            ProfileDetailsUtils.getProfileDetails(if (callLog.callState == CallState.OUTGOING_CALL) callLog.toUser!! else callLog.fromUser!!)!!.isAdminBlocked
        } else if (callLog.groupId!!.isNotEmpty()) {
            ProfileDetailsUtils.getProfileDetails(callLog.groupId!!)!!.isAdminBlocked
        } else false
    }

    /**
     * Starts the call activity based on the call icon click action.
     *
     * @param callType the call type object in the adapter data set.
     */
    private fun makeCall(
        callType: String,
        groupId: String?,
        isBlocked: Boolean,
        isAdminBlocked: Boolean,
        jidList: java.util.ArrayList<String>
    ) {
        lastCallAction = callType
        if (callType == CallType.AUDIO_CALL) {
            CallUtils.setIsCallStarted(CallType.AUDIO_CALL)
            callPermissionUtils = CallPermissionUtils(
                requireActivity(), isBlocked, isAdminBlocked, jidList, groupId
                    ?: "", false
            )
            if (CallManager.isAudioCallPermissionsGranted(skipBlueToothPermission = false)) {
                launchCall(lastCallAction)
            } else {
                MediaPermissions.requestAudioCallPermissions(
                    requireActivity(),
                    permissionAlertDialog,
                    requestCallPermissions
                )
            }
        } else if (callType == CallType.VIDEO_CALL) {
            CallUtils.setIsCallStarted(CallType.VIDEO_CALL)
            callPermissionUtils = CallPermissionUtils(
                requireActivity(), isBlocked, isAdminBlocked, jidList, groupId
                    ?: "", false
            )
            if (CallManager.isVideoCallPermissionsGranted(skipBlueToothPermission = false)) {
                launchCall(lastCallAction)
            } else {
                MediaPermissions.requestVideoCallPermissions(
                    requireActivity(),
                    permissionAlertDialog,
                    requestCallPermissions
                )
            }
        }
        //if it is not a blocked contact , clear the value. so that we can avoid unknown calls
        //happening due to onBlockListCallBack() callback from CfBaseActivity.
        if (!isBlocked)
            CallUtils.setIsCallStarted(null)
    }


    /**
     * Displays an alert dialog to get the confirmation from the user to clear
     * either the selected entry or the entire call log history.
     *
     * @param isClearAll true if the entire call log history has to be deleted.
     */
    fun showClearAlertDialog(isClearAll: Boolean) {
        this.isClearAll = isClearAll
        if (isClearAll && viewModel.callLogAdapterList.isNotEmpty()) {
            commonAlertDialog.showAlertDialog(
                resources.getString(R.string.action_clear_call_log_message),
                resources.getString(R.string.action_Ok),
                resources.getString(R.string.action_cancel),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
                false
            )
        } else if (viewModel.selectedCallLogs.isNotEmpty()) {
            commonAlertDialog.showAlertDialog(
                resources.getQuantityString(
                    R.plurals.action_delete_call_log_message,
                    viewModel.selectedCallLogs.size
                ),
                resources.getString(R.string.action_Ok),
                resources.getString(R.string.action_cancel),
                CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL,
                false
            )
        } else CustomToast.show(activity, "No Call Log  ")
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            isDeleteCallLogInitiated = true
            launch(exceptionHandler) {
                ChatManager.deleteCallLog(isClearAll, viewModel.selectedCallLogs, object :
                    ChatActionListener {
                    override fun onResponse(isSuccess: Boolean, message: String) {
                        /*
                        * No Implementation needed
                        */
                    }
                })
                CoroutineScope(Dispatchers.Main).launch {
                    onActionSuccess()
                }
            }

        }
    }

    override fun listOptionSelected(position: Int) {
        Logger.d(position.toString())
    }

    override fun onActionSuccess() {
        var readCount =
            SharedPreferenceManager.getInt(com.contusfly.utils.Constants.MISSED_CALL_COUNT)
        if (isClearAll) {
            isClearAll = false
            readCount = 0
            viewModel.callLogAdapterList.clear()
            mSearchCallLogs.clear()
            mAdapter.notifyDataSetChanged()
            mSearchAdapter.notifyDataSetChanged()
            callHistoryBinding.listCallHistory.setEmptyView(callHistoryBinding.viewNoCallHistory.root)
            viewModel.selectedCallLogs.clear()
            clearCallLogNotify()
        } else {
            readCount -= 0
            notifyAdapterOfDeletedCallLog()
        }
        startActionModeChange(-1, false)
        (activity as DashboardActivity).validateMissedCallsCount()
        SharedPreferenceManager.setInt(com.contusfly.utils.Constants.MISSED_CALL_COUNT, readCount)
    }

    private fun startActionModeChange(size: Int, status: Boolean) {
        (activity as DashboardActivity).startActionModeForCallLogs(size, status)
    }

    private fun notifyAdapterOfDeletedCallLog() {
        for (item in viewModel.selectedCallLogs) {
            val index = viewModel.callLogAdapterList.indexOfFirst { it.roomId == item }
            viewModel.callLogAdapterList.removeAt(index)
            mAdapter.notifyItemRemoved(index)
            if (mCallLogsType == CallLogsType.SEARCH && (callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter)) {
                val searchIndex = mSearchCallLogs.indexOfFirst { it.roomId == item }
                if (searchIndex >= 0) {
                    mSearchCallLogs.removeAt(searchIndex)
                    mSearchAdapter.notifyItemRemoved(searchIndex)
                }
            }
        }
        viewModel.selectedCallLogs.clear()
    }

    fun clearSelectedMessages() {
        lifecycleScope.launchWhenCreated {
            if (viewModel.selectedCallLogs.isNotEmpty())
                unSelectCallLogs()
            viewModel.selectedCallLogs.clear()
        }
    }

    private fun unSelectCallLogs() {
        val bundle = Bundle()
        bundle.putInt(AppConstants.NOTIFY_SELECTION, 4)
        bundle.putBoolean(AppConstants.NOTIFY_IS_SELECTED, false)
        for (item in viewModel.selectedCallLogs) {
            if (mCallLogsType == CallLogsType.NORMAL && (callHistoryBinding.listCallHistory.adapter is CallHistoryAdapter)) {
                val index = viewModel.callLogAdapterList.indexOfFirst { it.roomId == item }
                mAdapter.notifyItemChanged(index, bundle)
            } else if (mCallLogsType == CallLogsType.SEARCH && (callHistoryBinding.listCallHistory.adapter is CallHistorySearchAdapter)) {
                val index = mSearchCallLogs.indexOfFirst { it.roomId == item }
                mSearchAdapter.notifyItemChanged(index, bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        CallLogManager.setCallLogsListener(null)
        viewModel.callList.removeObservers(viewLifecycleOwner)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    private fun showCreateMeetLinkDialog(meetLink: String) {

        commonAlertDialog.generateMeetLink(
            meetLink,
            requireActivity(),
            dialogType = CommonAlertDialog.DIALOGTYPE.DIALOG_TRIPLE,
            object : CommonAlertDialog.CommonTripleDialogClosedListener {
                override fun onTripleOptionDialogClosed(
                    dialogType: CommonAlertDialog.DIALOGTYPE?,
                    position: Int
                ) {
                    when (position) {
                        1 -> {
                            Log.d(TAG, "onTripleOptionDialogClosed: position: $1")
                        }

                        2 -> {
                            Log.d(TAG, "onTripleOptionDialogClosed: position: $2")
                        }

                        3 -> {
                            Log.d(TAG, "onTripleOptionDialogClosed: position: $3")
                        }
                    }
                }
            })
    }

}