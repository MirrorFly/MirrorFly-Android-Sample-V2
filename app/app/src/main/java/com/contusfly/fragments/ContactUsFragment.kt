package com.contusfly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.activities.SettingsActivity
import com.contusfly.checkInternetAndExecute
import com.contusfly.databinding.FragmentContactUsBinding
import com.contusfly.utils.Constants
import com.contusfly.views.DoProgressDialog
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.views.CustomToast

class ContactUsFragment : Fragment(), View.OnClickListener {
    /**
     * The Activity to which this fragment is currently associated with.
     */
    private var settingsActivity: SettingsActivity? = null

    private lateinit var binding: FragmentContactUsBinding

    /**
     * The progress dialog to display the progress bar When the background operations has been
     * doing
     */
    private lateinit var progressDialog: DoProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.contact_us))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentContactUsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = DoProgressDialog(settingsActivity!!)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.sendButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view){
            binding.sendButton -> {
                validateAndSendFeedback()
            }
            else -> {
                  //Not Needed
            }
        }
    }

    private fun validateAndSendFeedback() {
        binding.titleEditText.clearFocus()
        binding.descriptionEditText.clearFocus()
        val title = binding.titleEditText.text.toString()
        val description = binding.descriptionEditText.text.toString()
        if (validateUserInputs(title, description)) {
            requireContext().checkInternetAndExecute(true) {
                progressDialog.showProgress()
                ContactManager.sendContactUsInfo(title, description) { isSuccess, throwable, _ ->
                    progressDialog.dismiss()
                    if (isSuccess) {
                        CustomToast.show(context, getString(R.string.feedback_sent))
                        binding.titleEditText.setText(Constants.EMPTY_STRING)
                        binding.descriptionEditText.setText(Constants.EMPTY_STRING)
                    } else
                        CustomToast.show(context, throwable.toString())
                }
            }
        }
    }

    private fun validateUserInputs(title: String, description: String): Boolean {
        if (title.isBlank()) {
            CustomToast.show(context, getString(R.string.error_empty_title))
            return false
        }
        if (description.isBlank()) {
            CustomToast.show(context, getString(R.string.error_empty_description))
            return false
        }
        return true
    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(): ContactUsFragment {
            return ContactUsFragment()
        }
    }
}