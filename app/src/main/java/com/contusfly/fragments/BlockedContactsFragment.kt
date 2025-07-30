package com.contusfly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.Features
import com.contusfly.*
import com.contusfly.activities.SettingsActivity
import com.contusfly.adapters.BlockedContactsAdapter
import com.contusfly.databinding.FragmentBlockedContactsBinding
import com.contusfly.utils.Constants
import com.contusfly.utils.ProfileDetailsUtils.sortProfileList
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.DoProgressDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.views.CustomToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.*
import kotlin.coroutines.CoroutineContext


class BlockedContactsFragment : Fragment(), CoroutineScope, CommonAlertDialog.CommonDialogClosedListener {

    private lateinit var blockedContactsBinding: FragmentBlockedContactsBinding

    /**
     * Intance of the SettingsActivity
     */
    private var settingsActivity: SettingsActivity? = null

    /**
     * The progress dialog to display the progress bar When the background operations has been
     * doing
     */
    private lateinit var progressDialog: DoProgressDialog

    private lateinit var mAdapter: BlockedContactsAdapter

    /**
     * The store selected Jid
     */
    private var selectedUserJid: String = Constants.EMPTY_STRING

    /**
     * The store selected Profile Name
     */
    private var selectedUserName: String = Constants.EMPTY_STRING

    /**
     * The dialog for the common alert dialog.
     */
    private lateinit var mDialog: CommonAlertDialog

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
    }

    private var isBlockClicked:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity?.setActionBarTitle(resources.getString(R.string.blocked_contacts_label))

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        blockedContactsBinding = FragmentBlockedContactsBinding.inflate(inflater, container, false)
        setObservers()
        return blockedContactsBinding.root
    }

    private fun setObservers() {
        viewModel.blockedProfilesLiveData.observe(viewLifecycleOwner) {
            refreshAdapter(false)
        }

        viewModel.availableFeatureLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            featureActionValidation(it)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        featureActionValidation(ChatManager.getAvailableFeatures())
        initViews()
    }

    private fun initViews() {
        mDialog = CommonAlertDialog(context)
        mDialog.setOnDialogCloseListener(this)

        progressDialog = DoProgressDialog(settingsActivity!!)

        mAdapter = BlockedContactsAdapter(requireContext()) { profile: ProfileDetails ->
            if (selectedUserJid.isNotBlank()) {
                return@BlockedContactsAdapter
            }
            selectedUserJid = profile.jid
            selectedUserName = profile.getDisplayName()
            isBlockClicked=true
            mDialog.showAlertDialog(String.format(getString(R.string.unblock_message_label), selectedUserName), getString(R.string.yes_label),
                    getString(R.string.no_label), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, true)

        }
        blockedContactsBinding.statusView.textEmptyView.text = getString(R.string.message_no_block_contact)

        blockedContactsBinding.viewListContacts.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
            adapter = mAdapter
        }
        refreshAdapter(false)
    }

    /**
     * Refresh adapter once the changes has been made in the recent chats.
     */
    private fun refreshAdapter(serverCall: Boolean) {
        FlyCore.getUsersIBlocked(serverCall) { isSuccess: Boolean, _: Throwable?, data: HashMap<String, Any> ->
            if (isSuccess) {
                val profilesList = data.getData() as ArrayList<ProfileDetails>
                mAdapter.setBlockedProfiles(ArrayList<ProfileDetails>(sortProfileList(profilesList)))
                mAdapter.notifyDataSetChanged()
            }
            if (progressDialog.isShowing) progressDialog.dismiss()
            blockedContactsBinding.viewListContacts.setEmptyView(blockedContactsBinding.statusView.root)

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlockedContactsFragment()
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        isBlockClicked=false
        if(!ChatManager.getAvailableFeatures().isBlockEnabled){
            context!!.showToast(resources.getString(com.mirrorflysdk.R.string.fly_error_forbidden_exception))
            settingsActivity!!.onBackPressed()
            return
        }
        if (isSuccess)
            if (AppUtils.isNetConnected(settingsActivity?.applicationContext)) {
                progressDialog = DoProgressDialog(settingsActivity!!)
                progressDialog.showProgress()
                FlyCore.unblockUser(selectedUserJid) { success: Boolean, _: Throwable?, _: HashMap<String, Any> ->
                    if (success) {
                        runOnUiThread {
                            CustomToast.show(settingsActivity, String.format(getString(R.string.unblocked_message_label), selectedUserName))
                            refreshAdapter(false)
                            selectedUserName = Constants.EMPTY_STRING
                        }
                    } else {
                        selectedUserName = Constants.EMPTY_STRING
                        CustomToast.show(settingsActivity, Constants.ERROR_SERVER)
                    }
                    selectedUserJid = Constants.EMPTY_STRING
                    if (progressDialog.isShowing) progressDialog.dismiss()
                }
            } else {
                CustomToast.show(settingsActivity, getString(R.string.msg_no_internet))
                selectedUserJid = Constants.EMPTY_STRING
                selectedUserName = Constants.EMPTY_STRING
            }
        else {
            selectedUserJid = Constants.EMPTY_STRING
            selectedUserName = Constants.EMPTY_STRING
        }
    }

    override fun listOptionSelected(position: Int) {
        /* Called when list options has been selected */
    }

    private fun featureActionValidation(availableFeatures: Features) {
        if(isBlockClicked)
            return

        if(!availableFeatures.isBlockEnabled){
            settingsActivity!!.onBackPressed()
        }

    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()
}