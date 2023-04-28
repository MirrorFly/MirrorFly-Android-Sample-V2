package com.contusfly.fragments

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mirrorflysdk.flycommons.Constants
import com.contusfly.R
import com.contusfly.activities.SettingsActivity
import com.contusfly.checkInternetAndExecute
import com.contusfly.databinding.FragmentAboutUsBinding
import com.contusfly.utils.MediaPermissions.isPermissionAllowed
import com.contusfly.utils.MediaPermissions.requestTelephoneCallPermissions
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.views.CustomToast

/**
 * This fragment used to display the contact list with Contus information and contus website and
 * Contus Email.
 *
 */
class AboutUsFragment : Fragment(),View.OnClickListener,CommonAlertDialog.CommonDialogClosedListener {

    /**
     * The Activity to which this fragment is currently associated with.
     */
    private var settingsActivity: SettingsActivity? = null

    private lateinit var binding: FragmentAboutUsBinding

    /**
     * The first number of the contact.
     */
    private var isFirstNo = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.about_us))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentAboutUsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.textCallOne.setOnClickListener(this)
        binding.textCallTwo.setOnClickListener(this)
        binding.textMail.setOnClickListener(this)
        binding.textLink.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.text_call_one -> {
                isFirstNo = true
                makeCallWithConfirmation()
            }
            R.id.text_call_two -> {
                isFirstNo = false
                makeCallWithConfirmation()
            }
            R.id.text_mail -> showEmail()
            R.id.text_link -> {
                requireContext().checkInternetAndExecute {
                    showWebView()
                }
            }
            else -> {
                //Not Needed
            }
        }
    }

    /**
     * Make call with confirmation.
     */
    private fun makeCallWithConfirmation() {
        val dialog = CommonAlertDialog(context)
        dialog.setOnDialogCloseListener(this)
        dialog.showAlertDialog(
            getString(R.string.message_call_cofirm), getString(R.string.action_yes),
            getString(R.string.action_no), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    /**
     * Show web view of the ContusFly  site
     */
    private fun showWebView() {
        val webView = Intent(Intent.ACTION_VIEW)
        webView.data = Uri.parse(getString(R.string.website_mirrorfly))
        startActivity(webView)
    }

    /**
     * Show email of the ContusFly
     */
    private fun showEmail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.app_email)))
        startActivity(intent)
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            if (checkSimCardStatus(requireContext())) {
                makeCall()
            } else CustomToast.show(context, getString(R.string.error_no_sim))
        }
    }

    override fun listOptionSelected(position: Int) {
        //Not Needed
    }

    /**
     * Make call to marketing team. Here upon clicking the given mobile number the action call
     * intent is called.
     */
    private fun makeCall() {
        if (isPermissionAllowed(context, Manifest.permission.CALL_PHONE)) {
            /*
              Redirect to call intent to make call
             */
            val callIntent = Intent(Intent.ACTION_CALL)
            var contactNo = getString(R.string.title_call_no_two)
            if (isFirstNo) contactNo = getString(R.string.title_call_no_one)
            callIntent.data = Uri.parse("tel:$contactNo")
            startActivity(callIntent)
        } else {
            requestTelephoneCallPermissions(requireActivity(), Constants.CALL_PHONE_PERMISSION_CODE)
        }
    }

    /**
     * Check sim card status.
     *
     * @param context the startupActivityContext
     * @return boolean True if successful
     */
    private fun checkSimCardStatus(context: Context): Boolean {
        val telMgr = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val simState = telMgr.simState
        var status = true
        when (simState) {
            TelephonyManager.SIM_STATE_ABSENT, TelephonyManager.SIM_STATE_NETWORK_LOCKED, TelephonyManager.SIM_STATE_UNKNOWN -> status =
                false
            else -> {
                //Not Needed
            }
        }
        return status
    }


    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(): AboutUsFragment {
            return AboutUsFragment()
        }
    }


}