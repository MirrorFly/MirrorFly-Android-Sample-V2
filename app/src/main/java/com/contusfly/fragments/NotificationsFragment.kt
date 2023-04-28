package com.contusfly.fragments

import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.activities.SettingsActivity
import com.contusfly.databinding.FragmentNotificationsBinding
import com.contusfly.utils.NotifyRefererUtils
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager.isActivityStartedForResult
import com.mirrorflysdk.views.CustomToast


/**
 * This class provides an option to the user for setting up the app notification preferences.
 */
class NotificationsFragment : Fragment() {

    /**
     * The Activity to which this fragment is currently associated with.
     */
    private var settingsActivity: SettingsActivity? = null

    private lateinit var binding:  FragmentNotificationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.notifications))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setClickListeners()
    }

    private fun initViews(){
        binding.notificationToneLabel.setText(getRingtoneName(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)))
        if (getRingtoneName(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)) == "") {
            binding.notificationToneLabel.setText(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI))
        }
    }

    private fun setClickListeners() {
        binding.layoutNotificationAlert.setOnClickListener {
            settingsActivity!!.performFragmentTransaction(NotificationAlertsFragment.newInstance())
        }

        binding.layoutNotificationTone.setOnClickListener {
            showCustomTones()
        }

        binding.layoutNotificationPermission.setOnClickListener {
            if (AppUtils.isNetConnected(activity))
                settingsActivity!!.performFragmentTransaction(NotificationInstructionFragment.newInstance())
            else
                CustomToast.show(activity, requireActivity().getString(R.string.msg_no_internet))
        }
    }

    override fun onResume() {
        super.onResume()
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.notifications))
    }
    /**
     * To select alert tone for notication messages
     */
    private fun showCustomTones() {
        val existingCustomTone = Uri.parse(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI))
        val customToneUri = existingCustomTone.toString()
        val intent = Intent(RingtoneManager.ACTION_RINGTONE_PICKER)
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION)
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, resources.getString(R.string.title_notification))
        if (customToneUri != "None")
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, existingCustomTone)
        startActivityForResult(intent, Constants.ACTIVITY_REQ_CODE)
        /* setting isActivityStartedForResult to true to avoid xmpp disconnection */
        isActivityStartedForResult = true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /* setting isActivityStartedForResult to false for xmpp disconnection */
        isActivityStartedForResult = false
        try {
            if (resultCode == Activity.RESULT_OK && requestCode == Constants.ACTIVITY_REQ_CODE){
                setSelectedNotificationTone(data)
            }

            if (data == null) {
                SharedPreferenceManager.setString(com.contusfly.utils.Constants.NOTIFICATION_URI, SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI))
                binding.notificationToneLabel.setText(getRingtoneName(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)))
            }

        } catch (exception: Exception) {
            LogMessage.e(exception)
        }

    }

   private fun setSelectedNotificationTone(data: Intent?) {
       try {
           if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
               if(data?.getParcelableExtra<Parcelable?>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI,Parcelable::class.java) != null){
                   var notificationUri=data.getParcelableExtra<Parcelable>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI,Parcelable::class.java).toString()
                   if(notificationUri != SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)){
                       val notificationManager =
                           context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                       NotifyRefererUtils.deleteNotificationChannels(notificationManager)
                       setNotificationToneChangedStatus()
                   }
                   SharedPreferenceManager.setString(com.contusfly.utils.Constants.NOTIFICATION_URI, data.getParcelableExtra<Parcelable>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI,Parcelable::class.java).toString())
                   binding.notificationToneLabel.setText(getRingtoneName(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)))

               } else {
                   SharedPreferenceManager.setString(com.contusfly.utils.Constants.NOTIFICATION_URI, "None")
                   binding.notificationToneLabel.setText(getRingtoneName(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)))
                   setNotificationToneChangedStatus()
               }
           } else {
               if(data?.getParcelableExtra<Parcelable?>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI) != null){
                   var notificationUri=data.getParcelableExtra<Parcelable>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI).toString()
                   if(notificationUri != SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)){
                       val notificationManager =
                           context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                       NotifyRefererUtils.deleteNotificationChannels(notificationManager)
                       setNotificationToneChangedStatus()
                   }
                   SharedPreferenceManager.setString(com.contusfly.utils.Constants.NOTIFICATION_URI, data.getParcelableExtra<Parcelable>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI).toString())
                   binding.notificationToneLabel.setText(getRingtoneName(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)))
               } else {
                   SharedPreferenceManager.setString(com.contusfly.utils.Constants.NOTIFICATION_URI, "None")
                   binding.notificationToneLabel.setText(getRingtoneName(SharedPreferenceManager.getString(com.contusfly.utils.Constants.NOTIFICATION_URI)))
               }
           }
       } catch(e:Exception) {
           LogMessage.e(e)
       }
   }

    private fun setNotificationToneChangedStatus(){
        SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.KEY_CHANGE_FLAG, true)
    }

    /**
     * This method is to get the currently set ringtone name
     *
     * @param uri uri of the ringtone.
     * @return returns the name of the current ringtone
     */
    private fun getRingtoneName(uri: String): String? {
        val ringtone = RingtoneManager.getRingtone(settingsActivity, Uri.parse(uri))
        return ringtone.getTitle(settingsActivity)
    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object,
         * with the specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(): NotificationsFragment {
            return NotificationsFragment()
        }
    }
}