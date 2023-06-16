package com.contusfly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.activities.SettingsActivity
import com.contusfly.databinding.FragmentTermsAndConditionsBinding
import com.contusfly.utils.FirebaseUtils.Companion.setAnalytics


/**
 * This class displays the Terms and Conditions for using MirrorFly
 *
 */
class TermsAndConditionsFragment : Fragment() {

    /*
    * The Activity to which this fragment is currently associated with.
    */
    private var settingsActivity: SettingsActivity? = null

    private lateinit var binding: FragmentTermsAndConditionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.terms_and_privacy_policy))
        setAnalytics("View", "Terms and condition", "")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentTermsAndConditionsBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(): TermsAndConditionsFragment {
            return TermsAndConditionsFragment()
        }
    }
}