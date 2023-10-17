package com.contusfly.call

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.contusfly.R
import com.contus.call.CallConstants.CALL_UI
import com.contusfly.TAG
import com.contusfly.call.groupcall.AddParticipantFragment
import com.contusfly.databinding.FragmentOnGngCallParticipantsListBinding
import com.contusfly.utils.SharedPreferenceManager
import com.mirrorflysdk.flycommons.LogMessage
import java.util.ArrayList
import com.mirrorflysdk.flycall.call.utils.GroupCallUtils


class OnGngCallParticipantsList : Fragment() {

    private lateinit var onGngCallParticipantsListBinding: FragmentOnGngCallParticipantsListBinding

    private var callConnectedUserList: ArrayList<String>? = null

    private lateinit var mAdapter: ParticipantsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            callConnectedUserList =
                it.getStringArrayList(AddParticipantFragment.CONNECTED_USER_LIST)
            callConnectedUserList?.let { list ->
                if (list.contains(SharedPreferenceManager.getCurrentUserJid()))
                    list.remove(SharedPreferenceManager.getCurrentUserJid())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        onGngCallParticipantsListBinding =
            FragmentOnGngCallParticipantsListBinding.inflate(inflater, container, false)
        return onGngCallParticipantsListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        mAdapter = ParticipantsListAdapter(requireContext())

        onGngCallParticipantsListBinding.viewParticipantsList.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
            if (GroupCallUtils.isCallLinkBehaviourMeet()) {
                onGngCallParticipantsListBinding.viewParticipantsList.setEmptyView(
                    onGngCallParticipantsListBinding.viewParticipantsListEmptyView.textEmptyView
                )
                onGngCallParticipantsListBinding.viewParticipantsListEmptyView.textEmptyView.text =
                    "No one else is here"
                onGngCallParticipantsListBinding.viewParticipantsListEmptyView.textEmptyView.setTextColor(
                    ResourcesCompat.getColor(resources, R.color.color_text_grey, null)
                )
            }
            mAdapter.setParticipantsProfiles(callConnectedUserList)
            adapter = mAdapter
        }

        mAdapter.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance(callUsersList: ArrayList<String>?) =
            OnGngCallParticipantsList().apply {
                arguments = Bundle().apply {
                    putStringArrayList(AddParticipantFragment.CONNECTED_USER_LIST, callUsersList)
                }
            }
    }

    fun updateUserJoined(userJid: String) {
        callConnectedUserList?.let { list ->
            if (!list.contains(userJid)) {
                LogMessage.e(TAG, "$CALL_UI update user joined::$userJid")
                list.add(userJid)
            }
        }
        callConnectedAndDisconnected(callConnectedUserList)
    }

    fun updateUserLeft(userJid: String) {
        callConnectedUserList?.let { list ->
            if (list.contains(userJid)) {
                LogMessage.e(TAG, "$CALL_UI update user left::$userJid")
                list.remove(userJid)
            }
        }
        callConnectedAndDisconnected(callConnectedUserList)
    }

    fun handleMuteEvents(userJid: String) {
        if (::mAdapter.isInitialized) mAdapter.updateParticipantsDetails(userJid)
    }

    private fun callConnectedAndDisconnected(updatedUserList: ArrayList<String>?) {
        if (::mAdapter.isInitialized) {
            mAdapter.setParticipantsProfiles(updatedUserList)
            mAdapter.notifyDataSetChanged()
        }
    }

    fun refreshUser(jid: String) {
        if (::mAdapter.isInitialized) mAdapter.updateParticipantsDetails(jid)
    }
}