package com.contusfly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.contusfly.*
import com.contusfly.activities.SettingsActivity
import com.contusfly.databinding.FragmentFeedbackBinding
import com.contusfly.utils.Constants
import com.contusfly.utils.SafeChatUtils
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.utils.UIKitContactUtils
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.DoProgressDialog
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.views.CustomToast


class FeedbackFragment : Fragment(), View.OnClickListener {

    /**
     * The Activity to which this fragment is currently associated with.
     */
    private var settingsActivity: SettingsActivity? = null

    private lateinit var binding: FragmentFeedbackBinding

    /**
     * The progress dialog to display the progress bar When the background operations has been
     * doing
     */
    private lateinit var progressDialog: DoProgressDialog

    private val commonAlertDialog by lazy { CommonAlertDialog(requireContext()) }

    private var selectedPosition = 0
    private var positionUpdated = false

    private val initialReasons = listOf(
        "Select a reason", "I am changing my device",
        "I am changing my phone number", "MirrorFly is missing a feature",
        "MirrorFly is not working", "Other"
    )

    private val reasons = listOf(
        "I am changing my device",
        "I am changing my phone number", "MirrorFly is missing a feature",
        "MirrorFly is not working", "Other"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.delete_my_account))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedbackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = DoProgressDialog(settingsActivity!!)
        setUpSpinnerView()
        setClickListeners()
        updateDeleteMyAccountButton()
    }

    private fun setUpSpinnerView() {
        binding.reasonSpinner.setItems(initialReasons)
        binding.reasonSpinner.setOnItemSelectedListener { _, position, _, _ ->
            selectedPosition = position
            if (!positionUpdated) {
                binding.reasonSpinner.setItems(reasons)
                binding.reasonSpinner.selectedIndex = selectedPosition - 1
            }
            positionUpdated = true
            updateDeleteMyAccountButton()
        }
    }

    private fun updateDeleteMyAccountButton() {
        if (!positionUpdated) {
            binding.buttonDeleteAccount.gone()
            binding.reasonSpinner.text = Constants.EMPTY_STRING
        } else
            binding.buttonDeleteAccount.show()
    }

    fun setClickListeners() {
        binding.buttonDeleteAccount.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.buttonDeleteAccount -> {
                commonAlertDialog.showAlertDialogWithTitle(requireActivity(), getString(R.string.delete_account_popup_title),
                    getString(R.string.delete_account_popup_description),
                    getString(R.string.action_Ok),
                    getString(R.string.fly_action_cancel),
                    CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, object : CommonAlertDialog.CommonDialogClosedListener{
                        override fun onDialogClosed(
                            dialogType: CommonAlertDialog.DIALOGTYPE?,
                            isSuccess: Boolean) {
                            if (isSuccess)
                                deleteMyAccount()
                        }

                        override fun listOptionSelected(position: Int) {
                            //Not Needed
                        }
                    })
            }
        }
    }

    private fun deleteMyAccount() {
        requireContext().checkInternetAndExecute(true) {
            progressDialog.showProgress()
            FlyCore.deleteAccount(
                getReason(),
                binding.descriptionEditText.text.toString()
            ) { isSuccess, _, _ ->
                progressDialog.dismiss()
                if (isSuccess) {
                    SharedPreferenceManager.setBoolean(Constants.SHOW_PIN, false)
                    SharedPreferenceManager.setBoolean(Constants.BIOMETRIC, false)
                    SharedPreferenceManager.setString(Constants.CHANGE_PIN_NEXT, "")
                    SharedPreferenceManager.setString(Constants.MY_PIN, "")
                    SafeChatUtils.silentDisableSafeChat(requireContext())
                    SharedPreferenceManager.clearAllPreference()
                    UIKitContactUtils.clearAllData()
                    CustomToast.show(requireContext(), getString(R.string.delete_account_success))
                } else
                    runOnUiThread { CustomToast.show(requireContext(), Constants.ERROR_SERVER) }

            }
        }
    }

    private fun getReason(): String {
        return try {
            reasons[selectedPosition]
        } catch (e : Exception){
            reasons[0]
        }

    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(): FeedbackFragment {
            return FeedbackFragment()
        }
    }
}