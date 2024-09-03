package com.contusfly.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.activities.CountryListActivity
import com.contusfly.activities.SettingsActivity
import com.contusfly.databinding.FragmentDeleteMyAccountBinding
import com.contusfly.isInternetAvailable
import com.contusfly.utils.Constants
import com.contusfly.utils.CountriesListObject
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.utils.Utils
import com.contusfly.libPhone.PhoneNumberUtil
import java.util.*

class DeleteMyAccountFragment : Fragment(), View.OnClickListener {

    /**
     * The Activity to which this fragment is currently associated with.
     */
    private var settingsActivity: SettingsActivity? = null

    private lateinit var binding: FragmentDeleteMyAccountBinding

    private val commonAlertDialog by lazy { CommonAlertDialog(requireContext()) }

    private var myActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == AppCompatActivity.RESULT_OK && it.data != null) {
                binding.txtCountry.text = it.data!!.getStringExtra(Constants.COUNTRY_NAME)
                binding.countryCodeEditText.setText(
                    Utils.returnEmptyStringIfNull(
                        it.data!!.getStringExtra(
                            Constants.DIAL_CODE
                        )
                    ).replace(getString(R.string.plus_label), Constants.EMPTY_STRING)
                )
            }
        }

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
        binding = FragmentDeleteMyAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        setupCountryCode()
    }

    /*
   * Setup Country code */
    private fun setupCountryCode() {
        val telephonyManager =
            requireActivity().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        var countryCode = telephonyManager.simCountryIso.toUpperCase(Locale.getDefault())
        val countryName =
            CountriesListObject.getCountriesListByCountryCode(requireContext(), countryCode)
        val country: String
        if (countryName.isNotEmpty()) {
            country = countryName
        } else {
            countryCode = Locale.getDefault().country
            country = Locale.getDefault().displayCountry
        }

        val dialCode = PhoneNumberUtil.createInstance(requireActivity().applicationContext)
            .getCountryCodeForRegion(countryCode)

        binding.txtCountry.text = country
        binding.countryCodeEditText.setText(dialCode.toString())
    }

    private fun setClickListeners() {
        binding.txtCountry.setOnClickListener(this)
        binding.buttonContinue.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.txtCountry -> {
                val intent = Intent(requireContext(), CountryListActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                myActivityResultLauncher.launch(intent)
            }
            binding.buttonContinue -> validateAndDeleteAccount()
        }
    }

    private fun validateAndDeleteAccount() {
        hideKeyboard()
        val mobileNumber = binding.mobileNumberEditText.text.toString()
        val profileMobileNumber =
            Utils.returnEmptyStringIfNull(SharedPreferenceManager.getString(Constants.USER_MOBILE_NUMBER))
        val formattedMobileNumber = binding.countryCodeEditText.text.toString() + mobileNumber
        when {
            mobileNumber.isBlank() -> {
                commonAlertDialog.showAlertDialog(getString(R.string.error_enter_mobile_number), getString(R.string.action_Ok),
                    getString(R.string.fly_action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_SINGLE, false)
            }
            formattedMobileNumber != profileMobileNumber -> {
                commonAlertDialog.showAlertDialog(getString(R.string.error_mobile_number_not_matched), getString(R.string.action_Ok),
                    getString(R.string.fly_action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_SINGLE, false)
            }
            !isInternetAvailable(requireContext()) -> {
                commonAlertDialog.showAlertDialog(getString(R.string.msg_no_internet), getString(R.string.action_Ok),
                    getString(R.string.fly_action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_SINGLE, false)
            }
            else -> moveToReasonForDeleteAccount()
        }
    }

    /**
     * Hide the soft input keyboard from the delete my account of the window that is currently accepting
     * input..
     */
    private fun hideKeyboard() {
        val view = requireActivity().currentFocus
        Utils.hideSoftInput(requireContext(), view)
    }

    private fun moveToReasonForDeleteAccount() {
        settingsActivity!!.performFragmentTransaction(FeedbackFragment.newInstance())
    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(): DeleteMyAccountFragment {
            return DeleteMyAccountFragment()
        }
    }
}