package com.contusfly.fragments

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.activities.SettingsActivity
import com.contusfly.adapters.DataUsageSettingsAdapter
import com.contusfly.databinding.FragmentDataUsageSettingsBinding
import com.contusfly.services.NonStickyService
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.models.MediaAutoDownloadOption

/**
 * This class provides an option to the user for setting up the data usage preferences based on the
 * type of data connection network.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
class DataUsageSettingsFragment : Fragment(), ExpandableListView.OnChildClickListener {
    // to toggle between up and down arrows
    var clickFlag = 0

    var mediaAutoDownloadOption: MediaAutoDownloadOption? = null
        private set

    private lateinit var fragmentDataUsageSettingsBinding: FragmentDataUsageSettingsBinding


    // The Activity to which this fragment is currently associated with.
    private var settingsActivity: SettingsActivity? = null

    // The Intent object to start the non sticky service.
    private var nonStickyServiceIntent: Intent? = null

    // The adapter object used to provide data and child views in an expandable list view.
    private var dataUsageSettingsAdapter: DataUsageSettingsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.data_usage_settings))

        mediaAutoDownloadOption = FlyMessenger.getMediaAutoDownloadOptions()

        // Request to start the non sticky service which helps to identify, when the app is erased
        // from the recent apps screen in order to save the user preferred data usage settings
        // if any, in the app preferences.
        nonStickyServiceIntent =
            Intent(settingsActivity!!.applicationContext, NonStickyService::class.java)
        settingsActivity!!.startService(nonStickyServiceIntent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDataUsageSettingsBinding =
            FragmentDataUsageSettingsBinding.inflate(inflater, container, false)
        return fragmentDataUsageSettingsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentDataUsageSettingsBinding.listDataUsageSettings.setOnChildClickListener(this)
        dataUsageSettingsAdapter = DataUsageSettingsAdapter(this)
        fragmentDataUsageSettingsBinding.listDataUsageSettings.setAdapter(dataUsageSettingsAdapter)
        dataUsageSettingsAdapter?.setCompoundDrawable(R.drawable.ic_down_icon)
        fragmentDataUsageSettingsBinding.listDataUsageSettings.setOnGroupExpandListener { groupPosition: Int ->
            dataUsageSettingsAdapter?.setClickedPosition(groupPosition)
            dataUsageSettingsAdapter?.setCompoundDrawable(R.drawable.ic_up_arrow)
            dataUsageSettingsAdapter?.notifyDataSetChanged()
        }
        fragmentDataUsageSettingsBinding.listDataUsageSettings.setOnGroupCollapseListener { groupPosition: Int ->
            dataUsageSettingsAdapter?.setClickedPosition(groupPosition)
            dataUsageSettingsAdapter?.setCompoundDrawable(R.drawable.ic_down_icon)
            dataUsageSettingsAdapter?.notifyDataSetChanged()
        }
    }

    override fun onPause() {
        super.onPause()
        updateDataSettings()
    }

    private fun updateDataSettings() {
        // Save the user preferred data usage settings in the app preferences for both the type
        // of data connection network.
        mediaAutoDownloadOption?.let {
            FlyMessenger.setMediaAutoDownloadOptions(it)
        }
        // Request to stop the non-sticky service which is started when creating the instance
        // of this fragment object.
        settingsActivity!!.stopService(nonStickyServiceIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        updateDataSettings()
    }

    override fun onChildClick(
        parent: ExpandableListView,
        v: View,
        groupPosition: Int,
        childPosition: Int,
        id: Long
    ): Boolean {
        if (groupPosition == 0) {
            processMobileDataSettings(childPosition)
        } else if (groupPosition == 1) {
            processWifiDataSettings(childPosition)
        }

        // Invokes {@link DataSetObserver#onChanged} on each observer to update the
        // content of child view.
        dataUsageSettingsAdapter?.notifyDataSetChanged()
        return true
    }

    /**
     * Processes the user preferred data usage settings for the data connection network of type
     * [ConnectivityManager.TYPE_MOBILE].
     *
     * @param childPosition The position of the child within the group view.
     */
    private fun processMobileDataSettings(childPosition: Int) {
        if (mediaAutoDownloadOption == null) {
            mediaAutoDownloadOption = MediaAutoDownloadOption()
            mediaAutoDownloadOption!!.autoDownloadEnabled = true
            when (childPosition) {
                0 -> {
                    mediaAutoDownloadOption!!.downloadPhotosOnMobileData = true
                }
                1 -> {
                    mediaAutoDownloadOption!!.downloadVideosOnMobileData = true
                }
                2 -> {
                    mediaAutoDownloadOption!!.downloadAudiosOnMobileData = true
                }
                else -> {
                    mediaAutoDownloadOption!!.downloadDocumentsOnMobileData = true
                }
            }
        } else {
            when (childPosition) {
                0 -> {
                    mediaAutoDownloadOption!!.downloadPhotosOnMobileData =
                        !mediaAutoDownloadOption!!.downloadPhotosOnMobileData
                }
                1 -> {
                    mediaAutoDownloadOption!!.downloadVideosOnMobileData =
                        !mediaAutoDownloadOption!!.downloadVideosOnMobileData
                }
                2 -> {
                    mediaAutoDownloadOption!!.downloadAudiosOnMobileData =
                        !mediaAutoDownloadOption!!.downloadAudiosOnMobileData
                }
                else -> {
                    mediaAutoDownloadOption!!.downloadDocumentsOnMobileData =
                        !mediaAutoDownloadOption!!.downloadDocumentsOnMobileData
                }
            }
        }
        mediaAutoDownloadOption?.let {
            FlyMessenger.setMediaAutoDownloadOptions(it)
        }
    }

    /**
     * Processes the user preferred data usage settings for the data connection network of type
     * [ConnectivityManager.TYPE_WIFI].
     *
     * @param childPosition The position of the child within the group view.
     */
    private fun processWifiDataSettings(childPosition: Int) {
        if (mediaAutoDownloadOption == null) {
            mediaAutoDownloadOption = MediaAutoDownloadOption()
            mediaAutoDownloadOption!!.autoDownloadEnabled = true
            when (childPosition) {
                0 -> {
                    mediaAutoDownloadOption!!.downloadPhotosOnWifiData = true
                }
                1 -> {
                    mediaAutoDownloadOption!!.downloadVideosOnWifiData = true
                }
                2 -> {
                    mediaAutoDownloadOption!!.downloadAudiosOnWifiData = true
                }
                else -> {
                    mediaAutoDownloadOption!!.downloadDocumentsOnWifiData = true
                }
            }
        } else {
            when (childPosition) {
                0 -> {
                    mediaAutoDownloadOption!!.downloadPhotosOnWifiData =
                        !mediaAutoDownloadOption!!.downloadPhotosOnWifiData
                }
                1 -> {
                    mediaAutoDownloadOption!!.downloadVideosOnWifiData =
                        !mediaAutoDownloadOption!!.downloadVideosOnWifiData
                }
                2 -> {
                    mediaAutoDownloadOption!!.downloadAudiosOnWifiData =
                        !mediaAutoDownloadOption!!.downloadAudiosOnWifiData
                }
                else -> {
                    mediaAutoDownloadOption!!.downloadDocumentsOnWifiData =
                        !mediaAutoDownloadOption!!.downloadDocumentsOnWifiData
                }
            }
        }
        mediaAutoDownloadOption?.let {
            FlyMessenger.setMediaAutoDownloadOptions(it)
        }
    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object, with the
         * specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        fun newInstance(): DataUsageSettingsFragment {
            return DataUsageSettingsFragment()
        }
    }
}
