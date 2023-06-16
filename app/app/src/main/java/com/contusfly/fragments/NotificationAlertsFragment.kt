package com.contusfly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.contusfly.R
import com.contusfly.activities.SettingsActivity
import com.contusfly.databinding.FragmentNotificationAlertsBinding
import com.contusfly.utils.SafeChatUtils
import com.contusfly.utils.SharedPreferenceManager

/**
 * This class provides an option to the user for setting up the notification alert preferences when
 * receiving new messages.
 *
 */
class NotificationAlertsFragment : Fragment(),View.OnClickListener {

    /**
     * The Activity to which this fragment is currently associated with.
     */
    private var settingsActivity: SettingsActivity? = null

    private lateinit var binding: FragmentNotificationAlertsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.notification_alert))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationAlertsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setClickListeners()
    }

    private fun initView(){
        binding.layoutNotificationPopup.visibility = View.GONE
        displayNotificationSoundPreference()
        displayNotificationPopupPreference()
        displayVibrationPreference()
        displayMuteNotificationPreference()
    }

    private fun setClickListeners() {
        binding.layoutNotificationSound.setOnClickListener(this)
        binding.layoutNotificationPopup.setOnClickListener(this)
        binding.layoutVibration.setOnClickListener(this)
        binding.layoutMuteNotification.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.layout_notification_sound -> {
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.NOTIFICATION_SOUND,
                    !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.NOTIFICATION_SOUND))
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.KEY_CHANGE_FLAG, true)
                checkWhetherMuteEnabled()
                displayNotificationSoundPreference()
            }
            R.id.layout_notification_popup -> {
                checkWhetherMuteEnabled()
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.NOTIFICATION_POPUP,
                    !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.NOTIFICATION_POPUP))
                displayNotificationPopupPreference()
            }
            R.id.layout_vibration -> {
                checkWhetherMuteEnabled()
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.VIBRATION,
                    !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.VIBRATION)
                )
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.KEY_CHANGE_FLAG, true)
                displayVibrationPreference()
            }
            R.id.layout_mute_notification -> {
                if (!SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.MUTE_NOTIFICATION)) {
                    unSetAlerts()
                } else {
                    enableNotification()
                    displayNotificationSoundPreference()
                }
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.MUTE_NOTIFICATION,
                    !SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.MUTE_NOTIFICATION))
                SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.KEY_CHANGE_FLAG, true)
                displayMuteNotificationPreference()
                SafeChatUtils.silentDisableSafeChat(requireContext())
            }
        }
    }

    /**
     * Displays the user preference in regard to playing the notification sound for incoming
     * messages. Vibration Preference is displayed only if the notification sound has been selected
     */
    private fun displayNotificationSoundPreference() {
        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.NOTIFICATION_SOUND)) {
            binding.imageNotificationSound.setImageResource(R.drawable.ic_selected_tick)
        } else {
            binding.imageNotificationSound.setImageResource(R.drawable.ic_unselected_tick)
        }
    }

    /**
     * Displays the user preference in regard to presenting the notification popup for incoming
     * messages.
     */
    private fun displayNotificationPopupPreference() {
        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.NOTIFICATION_POPUP)) {
            binding.imageNotificationPopup.setImageResource(R.drawable.ic_selected_tick)
        } else {
            binding.imageNotificationPopup.setImageResource(R.drawable.ic_unselected_tick)
        }
    }


    /**
     * Displays the user preference in regard to vibrating the device for new messages while the app
     * is in foreground.
     */
    private fun displayVibrationPreference() {
        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.VIBRATION)) {
            binding.imageVibration.setImageResource(R.drawable.ic_selected_tick)
        } else {
            binding.imageVibration.setImageResource(R.drawable.ic_unselected_tick)
        }
    }

    /**
     * Displays the user preference in regard to not showing up the notification for new messages.
     */
    private fun displayMuteNotificationPreference() {
        //If Mute Notification is pressed all the other alert preferences should be disabled
        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.MUTE_NOTIFICATION)) {
            binding.imageMuteNotification.setImageResource(R.drawable.ic_selected_tick)
            binding.imageVibration.setImageResource(R.drawable.ic_unselected_tick)
            binding.imageNotificationPopup.setImageResource(R.drawable.ic_unselected_tick)
            binding.imageNotificationSound.setImageResource(R.drawable.ic_unselected_tick)
        } else {
            binding.imageMuteNotification.setImageResource(R.drawable.ic_unselected_tick)
        }
    }

    /**
     * This method sets the Notification sound,Notification Popup and Vibration to false when mute
     * is selected
     */
    private fun unSetAlerts() {
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.NOTIFICATION_SOUND, false)
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.NOTIFICATION_POPUP, false)
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.VIBRATION, false)
    }

    private fun enableNotification() {
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.NOTIFICATION_SOUND, true)
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.NOTIFICATION_POPUP, true)
        displayNotificationSoundPreference()
        displayNotificationPopupPreference()
    }

    private fun checkWhetherMuteEnabled() {
        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.MUTE_NOTIFICATION)) {
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.NOTIFICATION_SOUND, true)
            SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.MUTE_NOTIFICATION, false)
            displayMuteNotificationPreference()
            displayNotificationSoundPreference()
            SafeChatUtils.silentDisableSafeChat(requireContext())
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
        fun newInstance(): NotificationAlertsFragment {
            return NotificationAlertsFragment()
        }
    }


}