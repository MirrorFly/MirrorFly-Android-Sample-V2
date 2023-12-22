package com.contusfly.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.exception.FlyException
import com.contusfly.R
import com.contusfly.activities.CommonEditorActivity
import com.contusfly.activities.SettingsActivity
import com.contusfly.adapters.StatusAdapter
import com.contusfly.databinding.FragmentUserBusyStatusBinding
import com.contusfly.getMessage
import com.contusfly.utils.StatusDeleteDialog
import com.contusfly.utils.StatusDeleteDialog.UpdateAdapterListener
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener
import com.contusfly.views.CommonAlertDialog.DIALOGTYPE
import com.mirrorflysdk.api.ChatManager.isActivityStartedForResult
import com.mirrorflysdk.api.FlyCore.deleteBusyStatus
import com.mirrorflysdk.api.FlyCore.enableDisableBusyStatus
import com.mirrorflysdk.api.FlyCore.getBusyStatusList
import com.mirrorflysdk.api.FlyCore.getMyBusyStatus
import com.mirrorflysdk.api.FlyCore.setMyBusyStatus
import com.mirrorflysdk.api.models.BusyStatus
import com.contusfly.utils.EmojiUtils
import com.mirrorflysdk.views.CustomToast
import kotlin.collections.ArrayList

/**
 * This class displays the user busy value status if the user enables busy option and the user can
 * provide their busy status
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class UserBusyStatusFragment : Fragment(), View.OnClickListener,
    AdapterView.OnItemClickListener, CommonDialogClosedListener,
    UpdateAdapterListener {
    /**
     * The startupActivityContext of the user activity.
     */
    private var context: Activity? = null


    /**
     * The status list to display the status list in the recycler view in the activity.
     */
    private var statusList: ArrayList<BusyStatus> = ArrayList()

    /**
     * The list adapter used to display the status of the user
     */
    private var listAdapter: StatusAdapter? = null

    /**
     * The store the status of the user to display and can able to change and store here
     */
    private var busyStatus: BusyStatus? = null

    /**
     * The status user selected to delete
     */
    private var statusToDelete: BusyStatus? = null

    /**
     * The common alert dialog to display the alert dialogs in the alert view
     */
    private var commonAlertDialog: CommonAlertDialog? = null

    /**
     * The alert dialog to confirm the user action for deleting the user status.
     */
    private var statusDeleteDialog: StatusDeleteDialog? = null

    private lateinit var fragmentUserBusyStatusBinding:FragmentUserBusyStatusBinding

    /**
     * Instance of the activity
     */
    private var currentActivity: Activity? = null
    override fun onClick(view: View) {
        when (view.id) {
            R.id.text_edit_busy_status -> editUserBusyStatus()
            R.id.text_done -> {
                textDone
                context?.findViewById<View>(R.id.text_done)?.visibility = View.GONE
            }
        }
    }

    /**
     * Redirect to editor to edit user busy status
     */
    private fun editUserBusyStatus() {
        startActivityForResult(
            Intent(context, CommonEditorActivity::class.java)
                .putExtra(Constants.TITLE, getString(R.string.msg_add_busy_status))
                .putExtra(Constants.TEXT_COUNT, Constants.MAX_TEXT_COUNT)
                .putExtra(Constants.TYPE, Constants.TYPE_USER_BUSY_STATUS)
                .putExtra(Constants.MSG_TYPE_TEXT, busyStatus!!.status), Constants.ACTIVITY_REQ_CODE
        )
    }

    /**
     * When the text view done is clicked, this method will be called and executed.
     * Modified the call to onBackPressed to avoid null pointer exception
     */
    private val textDone: Unit
        private get() {
            if (busyStatus != null && !busyStatus!!.status.isEmpty()) enableDisableBusyStatus(true){ _, _, _ -> }
            updateStatus(busyStatus!!.status)
            if (currentActivity != null) requireActivity().onBackPressed()
        }

    /**
     * Update the busy status of the user in the view and they can change their status by enabling
     * busy in settings
     */
    private fun updateStatus(status: String) {
        try {
            setMyBusyStatus(status) { isSuccess, _, data ->
                if (!isSuccess)
                    CustomToast.show(requireContext(), data.getMessage())
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * on activity result
     *
     * @param requestCode requestCode of action
     * @param resultCode  resultcode for activity
     * @param data        intent data
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /* setting isActivityStartedForResult to false for xmpp disconnection */isActivityStartedForResult =
            false
        try {
            context?.findViewById<View>(R.id.text_title)?.visibility = View.VISIBLE
            if (requestCode == Constants.ACTIVITY_REQ_CODE && resultCode == Activity.RESULT_OK && data != null && data.getStringExtra(
                    Constants.TITLE
                ) != busyStatus!!.status
            ) {
                val status = data.getStringExtra(Constants.TITLE)!!
                updateStatusFromEditText(status, data)
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    private fun updateStatusFromEditText(status: String,intentData: Intent) {
        try {
            setMyBusyStatus(status) { isSuccess, _, data ->
                if (!isSuccess)
                    CustomToast.show(requireContext(), data.getMessage())
                else {

                    if(statusList.filter { it.status == intentData.getStringExtra(Constants.TITLE)!! }
                            .isEmpty()){
                        val tempStatusList: ArrayList<BusyStatus> = ArrayList()
                        tempStatusList.addAll(statusList)
                        busyStatus!!.status = intentData.getStringExtra(Constants.TITLE)!!
                        val newElement = BusyStatus( getMyBusyStatus()?.id?.plus(1)?:1, status=intentData.getStringExtra(Constants.TITLE)!!, isCurrentStatus = true)
                        statusList.clear()
                        statusList.add(newElement)
                        tempStatusList.remove(busyStatus)
                        statusList.addAll(tempStatusList)
                    }

                    EmojiUtils.setEmojiText(fragmentUserBusyStatusBinding.textEditBusyStatus, status)
                    listAdapter?.setStatus(statusList, status)
                    listAdapter?.notifyDataSetChanged()
                }
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val settingsActivity = activity as SettingsActivity?
        settingsActivity?.setActionBarTitle(getString(R.string.edit_busy_status_message))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentUserBusyStatusBinding = FragmentUserBusyStatusBinding.inflate(inflater, container, false)
        return fragmentUserBusyStatusBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context = activity
        statusDeleteDialog = StatusDeleteDialog(requireContext())
        statusDeleteDialog!!.setUpdateAdapterListener(this)
        context?.findViewById<View>(R.id.text_done)?.visibility = View.GONE
        initViews(view)
        EmojiUtils.setEmojiText(fragmentUserBusyStatusBinding.textEditBusyStatus, busyStatus!!.status)
        fragmentUserBusyStatusBinding.textEditBusyStatus!!.setOnClickListener(this)
        context?.findViewById<View>(R.id.text_done)?.setOnClickListener(this)
        commonAlertDialog = CommonAlertDialog(context)
        commonAlertDialog!!.setOnDialogCloseListener(this)
    }

    /**
     * Initiates the user busy status saved by user
     */
    private fun initViews(statusView: View) {
        try {
            val listStatus = statusView.findViewById<ListView>(R.id.list_busy_status)
            busyStatus = getMyBusyStatus()
            statusList = getBusyStatusList() as ArrayList<BusyStatus>
            listAdapter = context?.let { StatusAdapter(it) }
            listAdapter?.setStatus(statusList, busyStatus!!.status)
            listStatus.adapter = listAdapter
            listStatus.onItemClickListener = this
            listStatus.onItemLongClickListener =
                AdapterView.OnItemLongClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
                    statusToDelete = statusList[position]
                    if (busyStatus != statusToDelete) commonAlertDialog!!.showListDialog(
                        Constants.EMPTY_STRING,
                        arrayOf(resources.getString(R.string.delete_status))
                    )
                    true
                }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    override fun onResume() {
        super.onResume()
        context?.findViewById<View>(R.id.text_title)?.visibility = View.VISIBLE
    }

    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        /**
         * Apply the changes if the status changes and type is busy status
         */
        if (adapterView.id == R.id.list_busy_status && statusList[i].status != busyStatus!!.status) {
            updateStatusFromItemClick(statusList[i].status,i)
        }
    }

    private fun updateStatusFromItemClick(status: String, position: Int) {
        try {
            setMyBusyStatus(status) { isSuccess, _, data ->
                if (!isSuccess)
                    CustomToast.show(requireContext(), data.getMessage())
                else {
                    busyStatus = statusList[position]
                    EmojiUtils.setEmojiText(
                        fragmentUserBusyStatusBinding.textEditBusyStatus,
                        busyStatus!!.status
                    )
                    listAdapter?.setStatus(statusList, busyStatus!!.status)
                    listAdapter?.notifyDataSetChanged()
                }
            }
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentActivity = activity
    }

    override fun onDetach() {
        super.onDetach()
        currentActivity = null
    }

    /**
     * On dialog closed.
     *
     * @param dialogType the dialog type
     * @param isSuccess  the is success
     */
    override fun onDialogClosed(dialogType: DIALOGTYPE?, isSuccess: Boolean) {
        //Handle of the on dialog closed
    }

    /**
     * List option selected.
     *
     * @param position the position
     */
    override fun listOptionSelected(position: Int) {
        /**
         * Check the status position and assigned status
         */
        if (position == 0 && busyStatus != statusToDelete) {
            statusDeleteDialog!!.showDeleteStatusAlert()
        }
    }

    override fun onNotifyAdapter() {
        try {
            deleteBusyStatus(statusToDelete!!)
        } catch (e: FlyException) {
            e.printStackTrace()
        }
        statusList = getBusyStatusList() as ArrayList<BusyStatus>
        listAdapter?.setStatus(statusList, busyStatus!!.status)
        listAdapter?.notifyDataSetChanged()
    }

    companion object {
        /**
         * Creating the instance of Activity
         *
         * @return Instance of UserBusyStatusFragment
         */
        fun newInstance(): UserBusyStatusFragment {
            return UserBusyStatusFragment()
        }
    }
}
