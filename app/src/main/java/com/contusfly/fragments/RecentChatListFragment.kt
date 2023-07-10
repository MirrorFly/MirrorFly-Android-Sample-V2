package com.contusfly.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.*
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirrorflysdk.flycommons.*
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.activities.ArchivedChatsActivity
import com.contusfly.activities.ChatActivity
import com.contusfly.activities.DashboardActivity
import com.contusfly.activities.parent.DashboardParent
import com.contusfly.adapters.RecentChatListAdapter
import com.contusfly.adapters.RecentChatSearchAdapter
import com.contusfly.chatTag.adapter.RecentChatTagAdapter
import com.contusfly.chatTag.interfaces.ListItemClickListener
import com.contusfly.databinding.FragmentRecentChatBinding
import com.contusfly.interfaces.RecentChatEvent
import com.contusfly.models.ProfileDetailsShareModel
import com.contusfly.utils.*
import com.contusfly.utils.Constants
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.CustomRecyclerView
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.RecentChat
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import com.contusfly.R
import com.contusfly.helpers.RecentChatPaginationScrollListener
import com.mirrorflysdk.flydatabase.model.ChatTagModel

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class RecentChatListFragment : Fragment(), CoroutineScope, View.OnTouchListener {

    private var recentChatClickedPos: RecentChat= RecentChat()
    private lateinit var mContext: Context

    private lateinit var recentChatBinding: FragmentRecentChatBinding

    /**
     * Display the recent list and searched list in the recycler view
     */
    private lateinit var listRecent: CustomRecyclerView

    private lateinit var emptyView: TextView

    private var dialogFragment: ProfileDialogFragment? = null

    private var item: RecentChat? = null

    var chatJidList = ArrayList<String>()

    /**
     * The handler to delay the recent chat list
     */
    private lateinit var mHandler: Handler

    private val mAdapter by lazy {
        RecentChatListAdapter(
            requireContext(),
            viewModel.recentChatAdapter,
            viewModel.selectedRecentChats,
            viewModel.typingAndGoneStatus
        )
    }

    private var mRecentChatListType = DashboardParent.RecentChatListType.RECENT

    private val viewModel: DashboardViewModel by lazy {
        ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
    }

    private val mRecentSearchList = ArrayList<com.contusfly.models.RecentSearch>()

    private var searchKey: String = Constants.EMPTY_STRING

    var contactCount: Int = 0

    /**
     * Store onclick time to avoid double click
     */
    private var lastClickTime: Long = 0

    private val mSearchAdapter by lazy {
        RecentChatSearchAdapter(
            requireContext(),
            mRecentSearchList
        )
    }

    private lateinit var chatTagAdapter: RecentChatTagAdapter

    private var chatTagList = ArrayList<ChatTagModel>()
    private var chatTagselectedposition: Int = 0
    private var isRestartActivity:Boolean=false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        recentChatBinding = FragmentRecentChatBinding.inflate(inflater, container, false)
        mContext = activity!!.baseContext
        initView(recentChatBinding)
        setListeners()
        setObservers()
        return recentChatBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recentChatBinding.itemsSwipeToRefresh.isEnabled=false
        recentChatBinding.itemsSwipeToRefresh.isRefreshing=false
        chatTagAdapterinitialize()
        getChatTagData()
        getRecentChatData()
    }

    fun getChatTagData() {

        viewModel.getChatTagData()
    }

    fun getRecentChatData() {

        viewModel.getInitialChatList()
    }


    private fun isListTypeRecentChat() =
        mRecentChatListType == DashboardParent.RecentChatListType.RECENT

    private fun initView(recentChatBinding: FragmentRecentChatBinding) {
        emptyView = recentChatBinding.emptyList.textEmptyView
        emptyView.text = getString(R.string.msg_no_results)
        emptyView.setTextColor(
            ResourcesCompat.getColor(
                resources,
                R.color.color_text_no_list,
                null
            )
        )
        listRecent = recentChatBinding.viewListContacts
        mAdapter.setHasStableIds(true)
        mHandler = Handler(Looper.getMainLooper())
        setRecentChatAdapter()

        mAdapter.onProfileClickedCallback { itemPosition ->
            item = viewModel.recentChatList.value!![itemPosition]
            if (item!!.isAdminBlocked && ChatType.TYPE_GROUP_CHAT == item!!.getChatType()) {
                (activity as DashboardActivity).recentClickOnAdminBlockedUser()
                return@onProfileClickedCallback
            }
            if (SystemClock.elapsedRealtime() - lastClickTime < 1000)
                return@onProfileClickedCallback
            lastClickTime = SystemClock.elapsedRealtime()
            dialogFragment =
                ProfileDialogFragment.newInstance(ProfileDetailsUtils.getProfileDetails(item!!.jid)!!)
            val ft = childFragmentManager.beginTransaction()
            val prev = childFragmentManager.findFragmentByTag("dialog")
            if (prev != null)
                ft.remove(prev)
            ft.addToBackStack(null)
            dialogFragment!!.show(ft, "dialog")
        }
    }

    private fun setListeners() {
        val clickSupport = ItemClickSupport(listRecent)

        clickSupport.setOnItemClickListener { _, position, _ ->
            if (mRecentChatListType == DashboardParent.RecentChatListType.RECENT && position.isValidIndex())
                if (position > 0 && position < viewModel.recentChatList.value!!.size - 2)
                    handleOnItemClicked(position)
                else
                    startActivity(Intent(context, ArchivedChatsActivity::class.java))
        }

        clickSupport.setOnItemLongClickListener { _, position, _ ->
            if (mRecentChatListType == DashboardParent.RecentChatListType.RECENT && position > 0 && position < viewModel.recentChatList.value!!.size - 1) {
                handleOnItemLongClicked(position)
            }
            true
        }

        mSearchAdapter.searchItemClickedCallback {
            handleOnSearchItemClicked(it)
        }
    }

    private fun setObservers() {
        viewModel.updateMessageStatus.observe(
            viewLifecycleOwner, Observer { updateMessageUpdate(it) })
        viewModel.onTypingStatusGoneUpdate.observe(viewLifecycleOwner, Observer {
            onTypingAndGoneStatusUpdate(it)
        })

        viewModel.groupCreatedLiveData.observe(viewLifecycleOwner, Observer {
            LogMessage.i(TAG, "groupCreatedLiveData observed")
        })

        viewModel.groupUpdatedLiveData.observe(viewLifecycleOwner, Observer {
            LogMessage.i(TAG, "groupUpdatedLiveData observed")
            onGroupUpdated(it)
        })

        viewModel.groupNewUserAddedLiveData.observe(viewLifecycleOwner, Observer {
            LogMessage.i(TAG, "groupNewUserAddedLiveData observed")
            onGroupNewUserAdded(it)
        })

        viewModel.groupUserRemovedLiveData.observe(
            viewLifecycleOwner,
            Observer { onGroupUserRemoved(it) })

        viewModel.groupAdminChangedLiveData.observe(
            viewLifecycleOwner,
            Observer { onGroupAdminChanged(it) })

        viewModel.searchKeyLiveData.observe(viewLifecycleOwner, Observer { doSearch(it) })

        viewModel.refreshTheRecentChatList.observe(
            viewLifecycleOwner,
            { viewModel.refreshFetchedRecentChat() })

        viewModel.profileUpdatedLiveData.observe(viewLifecycleOwner, Observer {
            LogMessage.i(TAG, "profileUpdatedLiveData observed")
            onProfileUpdated(it)
            updateProfileDialog(it)
        })

        viewModel.isContactSyncSuccess.observe(viewLifecycleOwner, { viewModel.refreshFetchedRecentChat() })

        viewModel.isUserBlockedUnblockedMe.observe(viewLifecycleOwner, Observer {
            val index =
                viewModel.recentChatList.value!!.indexOfFirst { recent -> recent.jid ?: Constants.EMPTY_STRING == it.first.trim() }
            if (index.isValidIndex()) {
                mAdapter.mainlist.get(index).isBlockedMe = !mAdapter.mainlist.get(index).isBlockedMe
                val bundle = Bundle()
                bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 2)
                mAdapter.notifyItemChanged(index, bundle)
                mSearchAdapter.notifyItemChanged(index, bundle)

            }
            updateProfileDialog(it.first.trim())
        })

        viewModel.isUserBlockedByAdmin.observe(viewLifecycleOwner, Observer {
            userBlockedByAdmin(it)
        })

        viewModel.recentChatList.observe(viewLifecycleOwner, Observer {
            LogMessage.i(TAG, "updateRecentChatList observed")
        })

        viewModel.recentChatDiffResult.observe(viewLifecycleOwner, Observer {
            LogMessage.i(TAG, "recentChatDiffResult observed")
            initRecentChatAdapter(it)
        })

        viewModel.notifyRecentChatRemoved.observe(viewLifecycleOwner) {
            if (it.isValidIndex())
                mAdapter.notifyItemRemoved(it)
        }

        viewModel.notifyRecentChatInserted.observe(viewLifecycleOwner) {
            mAdapter.notifyItemRangeInserted(it.first, it.second)
        }

        viewModel.recentDeleteChatPosition.observe(viewLifecycleOwner, Observer {
            mAdapter.notifyItemRemoved(it)
        })

        viewModel.recentChat.observe(viewLifecycleOwner, Observer { recentPair ->
            LogMessage.i(TAG, "recentChat observed")
            /**
             * Here we're passing pinned chat count (viewModel.recentPinnedCount) as index value
             * because if new message is received it should placed under pinned chat list
             */
            if (chatTagselectedposition != 0) {
                viewModel.getRecentChatListBasedOnTagData(chatTagList.get(chatTagselectedposition).memberidlist!!)
                return@Observer
            }
            if (recentPair.second.isValidIndex()) {
                val bundle = Bundle()
                when (recentPair.first) {
                    RecentChatEvent.MESSAGE_RECEIVED, RecentChatEvent.MESSAGE_UPDATED, RecentChatEvent.ARCHIVE_EVENT -> {
                        bundle.putInt(Constants.NOTIFY_MESSAGE, 1)
                    }
                    RecentChatEvent.GROUP_EVENT -> {
                        bundle.putInt(Constants.NOTIFY_MESSAGE, 1)
                        bundle.putInt(Constants.NOTIFY_USER_NAME, 1)
                        bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 1)
                    }
                    RecentChatEvent.MUTE_EVENT -> {
                        bundle.putInt(Constants.NOTIFY_MUTE_UNMUTE, 1)
                    }
                    RecentChatEvent.PIN_EVENT -> {
                        bundle.putInt(Constants.NOTIFY_PINNED_ICON, 6)
                        bundle.putInt(Constants.NOTIFY_SELECTION, 4)
                    }
                }
                mAdapter.notifyItemRangeChanged(recentPair.third, recentPair.second + 1, bundle)
            } else initRecentChatAdapter(null)
        })
        viewModel.fetchingError.observe(viewLifecycleOwner) {
            fetchingFailObserver(it)
        }
        viewModel.addSearchLoader.observe(viewLifecycleOwner) {
            mSearchAdapter.addLoadingFooter()
        }
        viewModel.removeSearchLoader.observe(viewLifecycleOwner) {
            mSearchAdapter.removeLoadingFooter()
        }
        viewModel.filterRecentChatList.observe(
            viewLifecycleOwner,
            Observer { observeFilteredRecentChatList(it) })
        viewModel.filterProfileList.observe(
            viewLifecycleOwner,
            Observer { observeFilteredContactsList(it) })
        viewModel.filterContactProfileList.observe(viewLifecycleOwner, Observer {
            observeFilteredDeviceContactsList(it)
        })
        viewModel.messageList.observe(
            viewLifecycleOwner,
            Observer { observeFilteredMessageList(it.first, it.second) })
        viewModel.changedPinPosition.observe(viewLifecycleOwner, Observer {
            getRecentChatFor(viewModel.recentChatAdapter[it].jid, RecentChatEvent.PIN_EVENT)
        })
        viewModel.changedReadUnReadPosition.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_UNREAD_ICON, 0)
            bundle.putInt(Constants.NOTIFY_SELECTION, 4)
            mAdapter.notifyItemChanged(it, bundle)
        })

        viewModel.showMessage.observe(viewLifecycleOwner, Observer { showMessage(it) })

        viewModel.archiveChatStatus.observe(viewLifecycleOwner) {
            LogMessage.i(TAG, "archiveChatStatus observed")
            mAdapter.setArchiveStatus(it)
        }

        viewModel.paginationLoader.observe(viewLifecycleOwner) {
            mAdapter.setLoader(it)
        }

        viewModel.swipeRefreshLoader.observe(viewLifecycleOwner) {
            if(it){
                recentChatBinding.itemsSwipeToRefresh.isEnabled=true
                recentChatBinding.itemsSwipeToRefresh.isRefreshing=true
            } else {
                recentChatBinding.itemsSwipeToRefresh.isEnabled=false
                recentChatBinding.itemsSwipeToRefresh.isRefreshing=false
            }
        }


        viewModel.archiveChatUpdated.observe(viewLifecycleOwner) {
            updateArchiveChatsStatus(it.first, it.second)
        }

        viewModel.selectedArchiveChats.observe(viewLifecycleOwner) {
            updateArchiveChatsList(it)
        }

        viewModel.chatTagList.observe(viewLifecycleOwner, Observer {
            chatTaglistUpdate(it)
        })

        viewModel.restartactivityRecentChatListlivedata.observe(viewLifecycleOwner, Observer {
            isRestartActivity=true
            getChatTagData()
        })
        viewModel.chatTagDataPinUnpinLoad.observe(viewLifecycleOwner) {
            getRecentChatListBasedOnTagData()
        }
    }

    private fun chatTaglistUpdate(it: ArrayList<ChatTagModel>) {
        if(chatTagList.size>it.size){
            chatTagselectedposition=0
        }
        chatTagList = it
        if(chatTagList.size==0) {
            chatTagselectedposition = 0
            recentChatBinding.chatTagRecyclerview.visibility=View.GONE
        }
        else {
            recentChatBinding.chatTagRecyclerview.visibility=View.VISIBLE
        }
        chatTagAdapter.updatelist(chatTagList,chatTagselectedposition)
        if(isRestartActivity){
            isRestartActivity=false
            getRecentChatListBasedOnTagData()
        }
    }

    private fun chatTagAdapterinitialize() {
        var linearlayoutmanager = LinearLayoutManager(mContext)
        linearlayoutmanager.orientation = LinearLayoutManager.HORIZONTAL
        recentChatBinding.chatTagRecyclerview.layoutManager = linearlayoutmanager

        chatTagAdapter = RecentChatTagAdapter(mContext, object : ListItemClickListener {

            override fun itemclicklistener(position: Int) {
                chatTagselectedposition = position
                getRecentChatListBasedOnTagData()
                chatTagAdapter.updateSelectedPosition(position)
                CommonUtils.scrollToCenter(
                    linearlayoutmanager,
                    recentChatBinding.chatTagRecyclerview,
                    position
                )
            }

            override fun itemEditClickListener(position: Int) {
                TODO("Not yet implemented")
            }

        }, chatTagList)

        recentChatBinding.chatTagRecyclerview.adapter = chatTagAdapter
    }

    private fun getRecentChatListBasedOnTagData() {
        if (chatTagselectedposition == 0) {
            viewModel.refreshFetchedRecentChat()
        } else {
            viewModel.getRecentChatListBasedOnTagData(chatTagList.get(chatTagselectedposition).memberidlist!!)
        }
    }


    private fun userBlockedByAdmin(it: Pair<String, Boolean>) {
        try {
            val index =
                viewModel.recentChatList.value!!.indexOfFirst { recent -> recent.jid ?: Constants.EMPTY_STRING == it.first.trim() }
            if (index.isValidIndex()) {
                viewModel.recentChatList.value!![index].isAdminBlocked = it.second
                val bundle = Bundle()
                bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 2)
                mAdapter.notifyItemChanged(index, bundle)
                mSearchAdapter.notifyItemChanged(index, bundle)
            }
            updateProfileDialog(it.first.trim())
        } catch (e: Exception) {
            LogMessage.d(TAG, "#admin blocked status exception: ${e.message}")
        }
    }

    private fun updateProfileDialog(jid: String) {
        if (item != null && dialogFragment != null && dialogFragment!!.context != null && dialogFragment!!.profileDetails.jid == jid) {
            dialogFragment!!.profileDetails = ProfileDetailsUtils.getProfileDetails(jid)!!
            dialogFragment!!.refreshView()
        }
    }

    private fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun handleOnSearchItemClicked(position: Int) {
        (activity as DashboardActivity).searchItemClickedPosition = position
        requireContext().launchActivity<ChatActivity> {
            putExtra(LibConstants.JID, mRecentSearchList[position].jid.returnEmptyIfNull())
            putExtra(Constants.CHAT_TYPE, mRecentSearchList[position].chatType)
        }
    }

    fun updateSearchAdapter(position: Int) {
        mSearchAdapter.notifyItemChanged(position)
    }

    private fun updateSearchAdapter(jid: String) {
        val index =
            viewModel.recentChatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == jid }
        if (index.isValidIndex())
            mAdapter.notifyDataSetChanged()

        val searchIndex = mRecentSearchList.indexOfFirst { it.jid == jid }
        if (searchIndex.isValidIndex() && searchKey.isNotEmpty()) {
            mRecentChatListType = DashboardParent.RecentChatListType.SEARCH
            mRecentSearchList.clear()
            viewModel.filterRecentChatList(this.searchKey)
        }
    }

    private fun updateRecentChatAdapter(jid: String, payloads: Bundle? = null) {
        val index =
            viewModel.recentChatList.value?.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == jid }
        if (index?.isValidIndex() == true && jid.isNotEmpty()) {
            val recent = FlyCore.getRecentChatOf(jid)
            recent?.let {
                viewModel.recentChatList.value!![index] = recent
                viewModel.recentChatAdapter[index] = recent
            }
            mAdapter.notifyItemChanged(index, payloads)
        }
    }


    private fun updateArchiveChatsStatus(jid: String, archiveStatus: Boolean) {
        if (isListTypeRecentChat()) {
            if (archiveStatus) {
                val index =
                    viewModel.recentChatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == jid }
                if (index.isValidIndex()) {
                    viewModel.recentChatList.value!!.removeAt(index)
                    viewModel.recentChatAdapter.removeAt(index)
                    mAdapter.notifyItemRemoved(index)
                }
            } else {
                getRecentChatFor(jid, RecentChatEvent.ARCHIVE_EVENT)
            }
        } else {
            updateSearchAdapter(jid)
            if (archiveStatus) {
                updateRecentChatAdapter(jid)
            } else {
                getRecentChatFor(jid, RecentChatEvent.ARCHIVE_EVENT)
            }
        }
    }

    /**
     * Handle the click operation the recycler view in the recent chats
     *
     * @param position Position of the list view
     */
    private fun handleOnItemClicked(position: Int) {
        recentChatClickedPos= mAdapter.mainlist[position]
        if (viewModel.selectedRecentChats.isEmpty())
            openChatView(position)
        else {
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_SELECTION, 4)

            val selectedChats = viewModel.recentChatList.value!![position]
            if (viewModel.selectedRecentChats.any { it.jid == selectedChats.jid }) {
                viewModel.selectedRecentChats.remove(viewModel.selectedRecentChats.first { it.jid == selectedChats.jid })
                if (viewModel.pinnedListPosition.contains(position))
                    viewModel.pinnedListPosition.remove(position)
            } else if (!selectedChats.isGroupInOfflineMode && (!selectedChats.isGroup && !viewModel.selectedRecentChats[0].isGroup
                        || viewModel.selectedRecentChats.isNotEmpty())
            ) {
                viewModel.selectedRecentChats.add(selectedChats)
                viewModel.pinnedListPosition.add(position)
            }
            mAdapter.notifyItemChanged(position, bundle)
            (activity as DashboardActivity).recentClick(viewModel.selectedRecentChats, false)
        }
    }

    /**
     * Handle the long click on the recent chat
     *
     * @param position Position of the list view
     */
    private fun handleOnItemLongClicked(position: Int) {
        val selectedChats = viewModel.recentChatList.value!![position]
        if (!selectedChats.isGroupInOfflineMode && !viewModel.selectedRecentChats.contains(
                selectedChats
            )
        ) {
            if (!viewModel.pinnedListPosition.contains(position))
                viewModel.pinnedListPosition.add(position)
            viewModel.selectedRecentChats.add(selectedChats)
            (activity as DashboardActivity).recentClick(viewModel.selectedRecentChats, true)
            val bundle = Bundle()
            bundle.putInt(AppConstants.NOTIFY_SELECTION, 4)
            mAdapter.notifyItemChanged(position, bundle)
        }
    }

    private fun getRecentChatFor(jId: String, @RecentChatEvent event: String) {
        viewModel.getRecentChatOfUser(jId, event)
    }

    private fun doSearch(searchKey: String) {
        if ((activity as DashboardActivity).getViewPagerCurrentPosition() != 0)
            return

        if (searchKey.isEmpty()) {
            listRecent.setEmptyView(emptyView)
            viewModel.setSearchUserListFetching(false)
            mHandler.removeCallbacks(filterContactRunnable)
            mRecentChatListType = DashboardParent.RecentChatListType.RECENT
            setAdapterBasedOnSearchType()
        } else {
            this.searchKey = searchKey
            viewModel.setSearchUserListFetching(true)
            mRecentChatListType = DashboardParent.RecentChatListType.SEARCH
            listRecent.setEmptyView(null)
            mRecentSearchList.clear()
            contactCount = 0
            viewModel.filterRecentChatList(this.searchKey)
            val index =
                viewModel.filterRecentChatList.value!!.indexOfFirst { recent -> recent.jid.trim() == searchKey }
            if (index.isValidIndex()) {
                mAdapter.mainlist.get(index).isBlockedMe = !mAdapter.mainlist.get(index).isBlockedMe
                val bundle = Bundle()
                bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 2)
                mAdapter.notifyItemChanged(index, bundle)
            }

        }
    }

    private fun updateMessageUpdate(messageId: String) {
        val index = viewModel.recentChatList.value?.indexOfFirst { it.lastMessageId == messageId }
        if (index?.isValidIndex() == true) {
            getRecentChatFor(
                viewModel.recentChatList.value!![index].jid,
                RecentChatEvent.MESSAGE_UPDATED
            )
        }
    }

    fun onTypingAndGoneStatusUpdate(singleOrGroupJid: String) {
        val bundle = Bundle()
        bundle.putInt(Constants.NOTIFY_MSG_TYPING, 3)
        updateRecentChatAdapter(singleOrGroupJid, bundle)
    }

    private fun onGroupUpdated(groupId: String) =
        if (isListTypeRecentChat())
            getRecentChatFor(groupId, RecentChatEvent.GROUP_EVENT)
        else updateSearchAdapter(groupId)

    private fun onProfileUpdated(groupId: String) =
        if (isListTypeRecentChat()) {
            val bundle = Bundle()
            bundle.putInt(Constants.NOTIFY_PROFILE_ICON, 2)
            updateRecentChatAdapter(groupId, bundle)
        } else {
            updateSearchAdapter(groupId)
            updateRecentChatAdapter(groupId)
        }

    private fun onGroupNewUserAdded(groupId: String) {
        // time msg txt
        if (isListTypeRecentChat())
            getRecentChatFor(groupId, RecentChatEvent.MESSAGE_RECEIVED)
        else updateSearchAdapter(groupId)
    }

    private fun onGroupUserRemoved(groupId: String) {
        // time msg txt
        if (isListTypeRecentChat())
            getRecentChatFor(groupId, RecentChatEvent.MESSAGE_RECEIVED)
        else updateSearchAdapter(groupId)
    }

    private fun onGroupAdminChanged(groupId: String) {
        // time msg txt
        if (isListTypeRecentChat())
            getRecentChatFor(groupId, RecentChatEvent.MESSAGE_RECEIVED)
        else updateSearchAdapter(groupId)
    }

    private fun initRecentChatAdapter(diffUtilResult: DiffUtil.DiffResult?) {
        if (diffUtilResult == null) {
            mAdapter.notifyDataSetChanged()
        } else {
            // Save Current Scroll state to retain scroll position after DiffUtils Applied
            val previousState = listRecent.layoutManager?.onSaveInstanceState() as Parcelable
            diffUtilResult.dispatchUpdatesTo(mAdapter)
            listRecent.layoutManager?.onRestoreInstanceState(previousState)
        }
        /*
        * Hide empty view */
        if (viewModel.recentChatAdapter.isNotEmpty()) {
            if (viewModel.recentChatAdapter.size == 3 &&
                viewModel.recentChatAdapter[0].jid == null && viewModel.recentChatAdapter[2].jid == null
            ) {
                emptyViewVisibleOrGone()
            } else {
                recentChatBinding.noMessageView.root.visibility = View.GONE
            }
        }
        val listPositions = findAndReplaceNewItem(viewModel.recentChatAdapter, viewModel.selectedRecentChats)
        if (listPositions.first.isValidIndex() && listPositions.second.isValidIndex())
            viewModel.selectedRecentChats[listPositions.second] =
                viewModel.recentChatAdapter[listPositions.first]
        else mAdapter.notifyItemChanged(mAdapter.mainlist.indexOf(recentChatClickedPos))

    }

    private fun emptyViewVisibleOrGone() {
        var archiveChats: MutableList<RecentChat>? = null
        FlyCore.getArchivedChatList { _, _, data ->
            archiveChats = (data["data"] as MutableList<RecentChat>)
            recentChatBinding.noMessageView.root.visibility =
                if (archiveChats?.size == 0) View.VISIBLE else View.GONE
        }
    }

    @Synchronized
    private fun findAndReplaceNewItem(
        recyclerList: List<RecentChat>,
        selectedList: List<RecentChat>
    ): Pair<Int, Int> {
        if (selectedList.isNotEmpty()) {
            for (i in recyclerList.indices)
                for (j in selectedList.indices)
                    if (selectedList[j].jid == recyclerList[i].jid)
                        return Pair(i, j)
        }
        return Pair(-1, -1)
    }

    private fun setRecentChatAdapter() {
        listRecent.apply {
            layoutManager = LinearLayoutManager(context)
            setItemViewCacheSize(10)
            setHasFixedSize(false)
            setEmptyView(null)
            itemAnimator = null
            adapter = mAdapter
            if (!BuildConfig.CONTACT_SYNC_ENABLED)
                setScrollListener(this, layoutManager as LinearLayoutManager)
        }
    }

    private fun setScrollListener(
        recyclerView: CustomRecyclerView,
        layoutManager: LinearLayoutManager
    ) {
        recyclerView.addOnScrollListener(object :
            RecentChatPaginationScrollListener(layoutManager) {
            override fun loadMoreItems() {
                if (searchKey.isNotBlank()) {
                    viewModel.filterContactsList(searchKey, chatJidList)
                } else {
                    if(chatTagselectedposition == 0)
                        viewModel.nextSetOfRecentChatList()
                }
            }

            override fun isLastPage(): Boolean {
                return false
            }

            override fun isFetching(): Boolean {
                return if (searchKey.isNotBlank())
                    viewModel.getSearchUserListFetching()
                else
                    return viewModel.getRecentChatListFetching()
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if ((activity as DashboardActivity).mSearchView != null) {
                    (activity as DashboardActivity).mSearchView.let {
                        it!!.hideSoftKeyboard()
                    }
                }

            }
        })
    }

    fun isRecentListInitialized(): Boolean {
        return ::listRecent.isInitialized
    }

    private fun fetchingFailObserver(it: Boolean) {
        if (it)
            CustomToast.show(context, getString(R.string.msg_no_internet))
    }

    fun setAdapterBasedOnSearchType() {
        if (this::listRecent.isInitialized && mRecentChatListType == DashboardParent.RecentChatListType.RECENT
            && (listRecent.adapter is RecentChatSearchAdapter)
        ) {
            listRecent.adapter = mAdapter
            if (viewModel.recentChatAdapter.isNotEmpty()) {
                if (viewModel.recentChatAdapter.size == 3 &&
                    viewModel.recentChatAdapter[0].jid == null && viewModel.recentChatAdapter[2].jid == null
                ) {
                    recentChatBinding.noMessageView.root.visibility = View.VISIBLE
                } else {
                    recentChatBinding.noMessageView.root.visibility = View.GONE
                }
            } else if (viewModel.recentChatAdapter.isNullOrEmpty())
                recentChatBinding.noMessageView.root.visibility = View.VISIBLE
        } else if (this::listRecent.isInitialized && mRecentChatListType == DashboardParent.RecentChatListType.SEARCH
            && (listRecent.adapter is RecentChatListAdapter)
        ) {
            listRecent.adapter = mSearchAdapter
        }
    }

    private fun observeFilteredRecentChatList(list: List<RecentChat>) {
        val jidList = ArrayList<String>()
        removeSearchListItemOfType(Constants.TYPE_SEARCH_RECENT)
        mSearchAdapter.setRecentChatCount(list.size)
        for (recent in list) {
            val recentSearchItem = com.contusfly.models.RecentSearch(
                recent.jid,
                recent.lastMessageId,
                Constants.TYPE_SEARCH_RECENT,
                recent.getChatTypeEnum().toString(),
                true,
                ProfileDetails()
            )
            mRecentSearchList.add(recentSearchItem)
            jidList.add(recent.jid)
        }
        setJidList(jidList)
        viewModel.filterMessageList(searchKey)
        mSearchAdapter.setRecentSearch(mRecentSearchList, searchKey)
        setAdapterBasedOnSearchType()
        setEmptyView(mRecentSearchList)
    }

    private fun setEmptyView(mRecentSearchList: java.util.ArrayList<com.contusfly.models.RecentSearch>) {
        if (mRecentSearchList.isEmpty())
            recentChatBinding.noMessageView.root.visibility = View.GONE
    }

    private fun observeFilteredContactsList(list: List<ProfileDetailsShareModel>) {
        setPaginatedData(list.size)
        for (profile in list) {
            if (!profile.profileDetails.isAdminBlocked) {
                val searchContactItem = com.contusfly.models.RecentSearch(
                    profile.profileDetails.jid,
                    "",
                    Constants.TYPE_SEARCH_CONTACT,
                    profile.profileDetails.getChatTypeEnum().toString(),
                    true,
                    profile.profileDetails
                )
                mRecentSearchList.add(searchContactItem)
            }
        }
        listRecent.setEmptyView(emptyView)
        mSearchAdapter.setRecentSearch(mRecentSearchList, searchKey)
        setAdapterBasedOnSearchType()
        mSearchAdapter.notifyItemRangeInserted(mRecentSearchList.size - list.size, list.size)
    }

    private fun observeFilteredDeviceContactsList(profileDetails: List<ProfileDetails>) {
        removeSearchListItemOfType(Constants.TYPE_SEARCH_CONTACT)
        mSearchAdapter.setRecentContactCount(profileDetails.size, false)
        for (profile in profileDetails) {
            if (!profile.isAdminBlocked) {
                val searchContactItem = com.contusfly.models.RecentSearch(
                    profile.jid,
                    "",
                    Constants.TYPE_SEARCH_CONTACT,
                    profile.getChatTypeEnum().toString(),
                    true,
                    profile
                )
                mRecentSearchList.add(searchContactItem)
            }
        }
        listRecent.setEmptyView(emptyView)
        mSearchAdapter.setRecentSearch(mRecentSearchList, searchKey)
        setAdapterBasedOnSearchType()
        mSearchAdapter.notifyItemRangeInserted(mRecentSearchList.size - profileDetails.size, profileDetails.size)
    }

    private fun observeFilteredMessageList(
        messageCount: Int,
        messageList: List<com.contusfly.models.RecentSearch>
    ) {
        LogMessage.i(TAG, "observeFilteredMessageList")
        //There can be delay by the time messageList is fetched and user starts new search and in the end both
        //search results may get added to list. So remove all of TYPE and added afresh in list.
        removeSearchListItemOfType(Constants.TYPE_SEARCH_MESSAGE)

        mRecentSearchList.addAll(messageList)
        if (BuildConfig.CONTACT_SYNC_ENABLED) {
            viewModel.filterDeviceContactsList(searchKey, chatJidList)
        } else {
            mHandler.removeCallbacks(filterContactRunnable)
            mHandler.postDelayed(filterContactRunnable, 1000)
        }
        mSearchAdapter.setRecentMessageCount(messageCount)
        // update search adapter
        mSearchAdapter.setRecentSearch(mRecentSearchList, searchKey)
        setAdapterBasedOnSearchType()
        mSearchAdapter.notifyDataSetChanged()
    }

    private val filterContactRunnable = Runnable {
        viewModel.resetSearch()
        viewModel.filterContactsList(searchKey, chatJidList)
    }

    private fun setJidList(mJid: ArrayList<String>) {
        this.chatJidList = mJid
    }

    private fun setPaginatedData(listSize: Int) {
        contactCount += listSize
        if (viewModel.getPaginateBoolean()) {
            mSearchAdapter.setRecentContactCount(contactCount, true)
        } else {
            removeSearchListItemOfType(Constants.TYPE_SEARCH_CONTACT)
            mSearchAdapter.setRecentContactCount(listSize, false)
        }
    }

    /**
     * Remove items of a Type of a previous search.
     * @param type : item of type Recent,Contact,Message
     */
    private fun removeSearchListItemOfType(type: String) {
        for (i in mRecentSearchList.indices.reversed()) {
            if (type == mRecentSearchList[i].searchType)
                mRecentSearchList.removeAt(i)
        }
    }

    /**
     * Open chat view for particular roster.
     *
     * @param itemPos the item pos
     */
    private fun openChatView(itemPos: Int) {
        try {
            NotificationManagerCompat.from(requireContext()).cancel(Constants.NOTIFICATION_ID)
            val item = viewModel.recentChatList.value!![itemPos]
            val jid = Utils.returnEmptyStringIfNull(item.jid)
            if (!item.isGroupInOfflineMode) {
                if (item.isAdminBlocked && ChatType.TYPE_GROUP_CHAT == item.getChatType()) {
                    LogMessage.d(TAG, "#onAdminBlockedStatus click status = ${item.isAdminBlocked}")
                    (activity as DashboardActivity).recentClickOnAdminBlockedUser()
                } else {
                    viewModel.clearUnreadCount(item, itemPos)
                    val intent = Intent(context, ChatActivity::class.java)
                    startActivity(
                        intent.putExtra(LibConstants.JID, jid)
                            .putExtra(Constants.CHAT_TYPE, item.getChatType())
                            .putExtra(Constants.POSITION, itemPos.toString()))
                }
            } else {
                GroupManager.createOfflineGroupInOnline(jid, FlyCallback { isSuccess, _, data ->
                    if (!isSuccess)
                        showMessage(data.getMessage())
                })
            }
        } catch (e: Exception) {
            LogMessage.e(TAG, e)
        }
    }

    fun updateAdapter() {
                try {
                    for (item in viewModel.selectedRecentChats) {
                        val index =
                            viewModel.recentChatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == item.jid }
                        if (index.isValidIndex()) {
                            viewModel.recentChatList.value!!.removeAt(index)
                            viewModel.recentChatAdapter.removeAt(index)
                            mAdapter.notifyItemRemoved(index)
                        }
                    }
                    viewModel.selectedRecentChats.clear()
                    viewModel.pinnedListPosition.clear()
                } catch (e:Exception) {
                    LogMessage.e(TAG,e)
                }
    }

    fun updateArchiveChatsList(selectedJids: MutableList<String>) {
        if (activity == null)
            return
        for (jid in selectedJids) {
            val index =
                viewModel.recentChatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == jid }
            if (index.isValidIndex()) {
                viewModel.recentChatList.value!!.removeAt(index)
                viewModel.recentChatAdapter.removeAt(index)
                mAdapter.notifyItemRemoved(index)
            }
        }
        viewModel.selectedRecentChats.clear()
        viewModel.pinnedListPosition.clear()
    }

    fun clearSelectedMessages() {
        LogMessage.d(TAG, "clearSelectedMessages")
        if (isAdded) {
            if (viewModel.selectedRecentChats.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putInt(Constants.NOTIFY_SELECTION, 4)
                for (item in viewModel.selectedRecentChats) {
                    updateListAdapter(bundle, item)
                }
                viewModel.selectedRecentChats.clear()
                viewModel.pinnedListPosition.clear()
            }
        } else {
            LogMessage.e(TAG, "Recent fragment not added yet")
        }
    }

    private fun updateListAdapter(bundle: Bundle, item: RecentChat) {
        if (viewModel.recentChatList.value != null) {
            val index =
                viewModel.recentChatList.value!!.indexOfFirst { it.jid ?: Constants.EMPTY_STRING == item.jid }
            if (index.isValidIndex())
                mAdapter.notifyItemChanged(index, bundle)
        }
    }

    fun refreshRecentChatList() {
        viewModel.getRecentChats()
    }

    fun updateRecentItem(mutedStatus: Boolean) {
        try {
            if (viewModel.selectedRecentChats.isNotEmpty()) {
                for (item in viewModel.selectedRecentChats) {
                    val index = viewModel.recentChatAdapter.indexOfFirst { it.jid == item.jid }
                    if (index.isValidIndex()) {
                        mAdapter.mainlist[index].isMuted = mutedStatus
                        val bundle = Bundle()
                        bundle.putInt(Constants.NOTIFY_MUTE_UNMUTE, 1)
                        mAdapter.notifyItemChanged(index, bundle)
                        mSearchAdapter.notifyItemChanged(index, bundle)
                    }
                }
                viewModel.selectedRecentChats.clear()
                viewModel.pinnedListPosition.clear()
            }
        } catch (e : Exception) {
            LogMessage.e(e)
        }
    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object, with the
         * specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(): RecentChatListFragment {
            return RecentChatListFragment()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return true
    }

}