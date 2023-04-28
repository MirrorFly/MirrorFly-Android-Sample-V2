package com.contusfly.call

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.contusfly.call.groupcall.AddParticipantFragment
import com.contusfly.databinding.FragmentOnGngCallParticipantsListBinding
import com.contusfly.utils.SharedPreferenceManager
import java.util.ArrayList


class OnGngCallParticipantsList : Fragment() {

    private lateinit var onGngCallParticipantsListBinding: FragmentOnGngCallParticipantsListBinding

    private var callConnectedUserList: ArrayList<String>? = null

    private lateinit var mAdapter: ParticipantsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            callConnectedUserList = it.getStringArrayList(AddParticipantFragment.CONNECTED_USER_LIST)
            callConnectedUserList?.let { list ->
                if (list.contains(SharedPreferenceManager.getCurrentUserJid()))
                    list.remove(SharedPreferenceManager.getCurrentUserJid())
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        onGngCallParticipantsListBinding = FragmentOnGngCallParticipantsListBinding.inflate(inflater, container, false)
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
            adapter = mAdapter
        }
        mAdapter.setParticipantsProfiles(callConnectedUserList)
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
            if (!list.contains(userJid))
                list.add(userJid)
        }
        callConnectedAndDisconnected(callConnectedUserList)
    }

    fun updateUserLeft(userJid: String) {
        callConnectedUserList?.let { list ->
            if (list.contains(userJid))
                list.remove(userJid)
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