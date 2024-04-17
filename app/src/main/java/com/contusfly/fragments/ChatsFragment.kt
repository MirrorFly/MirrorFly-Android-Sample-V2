package com.contusfly.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mirrorflysdk.flycommons.*
import com.contusfly.*
import com.contusfly.TAG
import com.contusfly.activities.BackUpActivity
import com.contusfly.activities.SettingsActivity
import com.contusfly.databinding.FragmentChatsBinding
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.MediaPermissions
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.utils.SettingsUtil
import com.mirrorflysdk.views.CustomToast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import com.contusfly.R
import com.mirrorflysdk.api.FlyMessenger
import com.mirrorflysdk.flycall.webrtc.CallLogger


/**
 * This class provides an option to the user for setting up the chat related settings.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
class ChatsFragment : Fragment(), CoroutineScope, View.OnClickListener,
    CommonAlertDialog.CommonDialogClosedListener {

    /**
     * The enumeration object to identify the type of action performed by the user
     * from the available list of chat settings action.
     */
    private var chatSettingsAction: ChatSettingsAction? = null

    private lateinit var fragmentChatsBinding: FragmentChatsBinding

    /**
     * The Activity to which this fragment is currently associated with.
     */
    private var settingsActivity: SettingsActivity? = null

    /**
     * The alert dialog displayed on this screen to get the confirm about user action when
     * clearing the chat conversations from the app storage.
     */
    private var dialog: CommonAlertDialog? = null



    private var lastSeenEnabled = true

    private var settingsUtil: SettingsUtil? = null

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(requireActivity()) }

    private val writePermissionRequestLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val writePermissionGranted = permissions[Manifest.permission.WRITE_EXTERNAL_STORAGE] ?: ChatUtils.checkWritePermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(writePermissionGranted) {
            val mediaAutoDownloadOption = FlyMessenger.getMediaAutoDownloadOptions().apply {
                autoDownloadEnabled = !autoDownloadEnabled
            }
            FlyMessenger.setMediaAutoDownloadOptions(mediaAutoDownloadOption)
            displayAutoDownloadPreference()
        }
    }

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
    }

    /**
     * The CustomTextView display the Only Selected Language
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsActivity = activity as SettingsActivity?
    }

    override fun onResume() {
        super.onResume()
        settingsActivity = activity as SettingsActivity?
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.chats))
        settingsActivity!!.showSearchMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentChatsBinding = FragmentChatsBinding.inflate(inflater, container, false)
        setObservers()
        return fragmentChatsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = CommonAlertDialog(activity)
        dialog!!.setOnDialogCloseListener(this)
        settingsUtil = SettingsUtil()
        setListeners()
        displayArchiveSettingsPreference()
        displayLastSeenPreference()
        displayUserBusyStatusPreference()
        displayAutoDownloadPreference()
        saveMediaToGallery()
        featureActionValidation(ChatManager.getAvailableFeatures())
    }

    /**
     * Displays the user preference in regard to save media files to gallery
     */
    private fun saveMediaToGallery() {
        if (settingsUtil!!.shouldSaveToGallery()) {
               fragmentChatsBinding.imageSaveToGallery.setImageResource(R.drawable.ic_selected_tick)
        } else {
            fragmentChatsBinding.imageSaveToGallery.setImageResource(R.drawable.ic_unselected_tick)
        }
    }

    private fun setObservers() {
        viewModel.archivedSettingsStatus.observe(viewLifecycleOwner, Observer {
            setArchivedSettingsData(it)
        })

        viewModel.busySettingsStatus.observe(viewLifecycleOwner, Observer {
            displayUserBusyStatusPreference()
        })

        viewModel.availableFeatureLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            featureActionValidation(it)
        })
    }

    private fun setArchivedSettingsData(status: Boolean) {
        fragmentChatsBinding.switchArchivedSettings.isChecked = status
    }

    /**
     * Displays the user preference in regard to enable/disable archive settings of the user.
     */
    private fun displayArchiveSettingsPreference() {
        fragmentChatsBinding.switchArchivedSettings.isChecked = FlyCore.isArchivedSettingsEnabled()
        fragmentChatsBinding.switchArchivedSettings.setOnClickListener {
            FlyCore.enableDisableArchivedSettings(!FlyCore.isArchivedSettingsEnabled(), FlyCallback { isSuccess, _, data ->
                fragmentChatsBinding.switchArchivedSettings.isChecked = FlyCore.isArchivedSettingsEnabled()
                if (!isSuccess) CustomToast.show(requireContext(), data.getMessage())
            })
        }
    }

    /**
     * Displays the user preference in regard to hiding the last seen activity of the user.
     */
    private fun displayLastSeenPreference() {
        lastSeenEnabled = FlyCore.isHideLastSeenEnabled()
        if (lastSeenEnabled) {
            fragmentChatsBinding.imageLastSeen.setImageResource(R.drawable.ic_selected_tick)
        } else {
            fragmentChatsBinding.imageLastSeen.setImageResource(R.drawable.ic_unselected_tick)
        }
    }

    private fun setListeners() {
        fragmentChatsBinding.layoutSaveToGallery.setOnClickListener(this)
        fragmentChatsBinding.layoutLastSeen.setOnClickListener(this)
        fragmentChatsBinding.layoutUserBusyStatus.setOnClickListener(this)
        fragmentChatsBinding.layoutAutoDownload.setOnClickListener(this)
        fragmentChatsBinding.layoutDataUsageSettings.setOnClickListener(this)
        fragmentChatsBinding.textClearConversation.setOnClickListener(this)
        fragmentChatsBinding.textDeleteConversation.setOnClickListener(this)
        fragmentChatsBinding.layoutTranslation.setOnClickListener(this)
        fragmentChatsBinding.layoutChatBackup.setOnClickListener(this)
        fragmentChatsBinding.layoutCallLogsExport.setOnClickListener(this)
    }

    /**
     * Displays the user preference in regard to the busy status maintained by the user.
     */
    private fun displayUserBusyStatusPreference() {
        if (FlyCore.isBusyStatusEnabled()) {
            val busystatus = R.string.default_busy_status.toString()
            fragmentChatsBinding.busyStatusHint.text = busystatus
            fragmentChatsBinding.imageUserBusyStatus.setImageResource(R.drawable.ic_selected_tick)
            fragmentChatsBinding.layoutSetBusyStatus.visibility = View.VISIBLE
            val myBusyStatus = FlyCore.getMyBusyStatus()
            myBusyStatus?.let {
                fragmentChatsBinding.busyStatusHint.text = it.status
            }
            fragmentChatsBinding.layoutSetBusyStatus.setOnClickListener(this)
        } else {
            fragmentChatsBinding.imageUserBusyStatus.setImageResource(R.drawable.ic_unselected_tick)
            fragmentChatsBinding.layoutSetBusyStatus.visibility = View.GONE
        }
    }

    /**
     * Displays the user preference in regard to downloading the media type chat messages without
     * waiting for the user confirmation.
     */
    private fun displayAutoDownloadPreference() {
        if (FlyMessenger.getMediaAutoDownloadOptions().autoDownloadEnabled) {
            fragmentChatsBinding.layoutDataUsageSettings.visibility = View.VISIBLE
            fragmentChatsBinding.imageAutoDownload!!.setImageResource(R.drawable.ic_selected_tick)
        } else {
            fragmentChatsBinding.layoutDataUsageSettings!!.visibility = View.GONE
            fragmentChatsBinding.imageAutoDownload!!.setImageResource(R.drawable.ic_unselected_tick)
        }
    }

    /**
     * Displays translated language
     */
    private fun displayTranslateLanguagePreference() {

        if(!ChatManager.getAvailableFeatures().isTranslationEnabled){
            com.contusfly.utils.SharedPreferenceManager.setString(com.contusfly.utils.Constants.GOOGLE_LANGUAGE_NAME, "English")
            fragmentChatsBinding.tvSelectedLanguage.text = "English"
            com.contusfly.utils.SharedPreferenceManager.setString(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE, "en")
            com.contusfly.utils.SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_CHECKED_IN_FIRST_TIME, true)
            fragmentChatsBinding.imageTranslation.setImageResource(R.drawable.ic_unselected_tick)
            fragmentChatsBinding.layoutTranslateLanguage.visibility = View.GONE
            return
        }

        if(!ChatManager.getAvailableFeatures().isTranslationEnabled){
            com.contusfly.utils.SharedPreferenceManager.setString(com.contusfly.utils.Constants.GOOGLE_LANGUAGE_NAME, "English")
            fragmentChatsBinding.tvSelectedLanguage.text = "English"
            com.contusfly.utils.SharedPreferenceManager.setString(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE, "en")
            com.contusfly.utils.SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_CHECKED_IN_FIRST_TIME, true)
            fragmentChatsBinding.imageTranslation.setImageResource(R.drawable.ic_unselected_tick)
            fragmentChatsBinding.layoutTranslateLanguage.visibility = View.GONE
            return
        }

        if (com.contusfly.utils.SharedPreferenceManager.getString(com.contusfly.utils.Constants.GOOGLE_LANGUAGE_NAME).trim { it <= ' ' }.isNotEmpty())
            fragmentChatsBinding.tvSelectedLanguage.text = com.contusfly.utils.SharedPreferenceManager.getString(com.contusfly.utils.Constants.GOOGLE_LANGUAGE_NAME)
        else {
            com.contusfly.utils.SharedPreferenceManager.setString(com.contusfly.utils.Constants.GOOGLE_LANGUAGE_NAME, "English")
            fragmentChatsBinding.tvSelectedLanguage.text = "English"
            com.contusfly.utils.SharedPreferenceManager.setString(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE, "en")
            com.contusfly.utils.SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_CHECKED_IN_FIRST_TIME, true)
        }
        if (com.contusfly.utils.SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_CHECKED)) {
            fragmentChatsBinding.imageTranslation.setImageResource(R.drawable.ic_selected_tick)
            fragmentChatsBinding.layoutTranslateLanguage.visibility = View.VISIBLE
            fragmentChatsBinding.layoutTranslateLanguage.setOnClickListener(this)
        } else {
            fragmentChatsBinding.imageTranslation.setImageResource(R.drawable.ic_unselected_tick)
            fragmentChatsBinding.layoutTranslateLanguage.visibility = View.GONE
        }
    }

    /**
     * Posts the user preference to the XMPP server, whether to show or hide the last activity of
     * the user so that the other registered app users will get notified of the same.
     */
    private fun postLastSeenUserPreference() {
        if (AppUtils.isNetConnected(settingsActivity!!.applicationContext)) {
            FlyCore.enableDisableHideLastSeen(!lastSeenEnabled, FlyCallback  { isSuccess, _, _ ->
                if (isSuccess) {
                    runOnUiThread {
                        displayLastSeenPreference()
                    }
                }
            })
        } else CustomToast.show(settingsActivity!!.applicationContext,
            resources.getString(R.string.msg_no_internet))
    }

    private fun checkWriteExternalPermission(): Boolean {
        val minSdk30 = Build.VERSION.SDK_INT > Build.VERSION_CODES.Q
        val hasWritePermission = ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
        return hasWritePermission || minSdk30
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.layout_last_seen -> postLastSeenUserPreference()
            R.id.layout_user_busy_status -> {
                FlyCore.enableDisableBusyStatus(!FlyCore.isBusyStatusEnabled()) { isSuccess, _, data ->
                    displayUserBusyStatusPreference()
                    if (!isSuccess) CustomToast.show(requireContext(), data.getMessage())
                }

            }
            R.id.layout_auto_download -> {
                if (!checkWriteExternalPermission()) {
                    activity?.let { MediaPermissions.requestStorageAccess(it, permissionAlertDialog, writePermissionRequestLauncher) }
                } else {
                    val mediaAutoDownloadOption = FlyMessenger.getMediaAutoDownloadOptions().apply {
                        autoDownloadEnabled = !autoDownloadEnabled
                    }
                    FlyMessenger.setMediaAutoDownloadOptions(mediaAutoDownloadOption)
                    displayAutoDownloadPreference()
                }
            }
            R.id.layout_data_usage_settings -> settingsActivity!!.performFragmentTransaction(DataUsageSettingsFragment.newInstance())
            R.id.text_clear_conversation -> {
                chatSettingsAction = ChatSettingsAction.CLEAR_CONVERSATION
                dialog!!.showAlertDialog(resources.getString(R.string.clear_conversation_alert),
                    getString(R.string.action_yes), getString(R.string.action_no),
                    CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
            }
            R.id.layout_set_busy_status -> settingsActivity!!.performFragmentTransaction(UserBusyStatusFragment.newInstance())
            R.id.layout_translation -> {
                val isGoogleTranslationChecked = com.contusfly.utils.SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_CHECKED)
                if (AppUtils.isNetConnected(activity) || isGoogleTranslationChecked) {
                    com.contusfly.utils.SharedPreferenceManager.setBoolean(com.contusfly.utils.Constants.GOOGLE_TRANSLATION_CHECKED, !isGoogleTranslationChecked)
                    displayTranslateLanguagePreference()
                } else CustomToast.show(activity, activity?.getString(R.string.msg_no_internet))
            }
            R.id.layout_translate_language ->
                if (AppUtils.isNetConnected(activity)) settingsActivity!!.performFragmentTransaction(TranslatedLanguageListFragment.newInstance())
                else CustomToast.show(activity, activity?.getString(R.string.msg_no_internet))

            R.id.layout_chat_backup ->
                requireActivity().launchActivity<BackUpActivity> { }
            R.id.layout_call_logs_export -> {
                chatSettingsAction = ChatSettingsAction.EXPORT_CALL_LOG
                dialog!!.showAlertDialog(resources.getString(R.string.export_call_log_alert),
                    getString(R.string.export_log_text), getString(R.string.clear_log_text),
                    CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
            }

        }
    }
    /**
     * On DialogClosed
     *
     * @param dialogType the dialog type
     * @param isSuccess  the is success
     */
    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            when (chatSettingsAction) {
                ChatSettingsAction.CLEAR_CONVERSATION -> {
                    if (AppUtils.isNetConnected(settingsActivity!!.applicationContext)) {
                        clearAllConversation()
                    } else {
                        CustomToast.show(settingsActivity!!.applicationContext,
                            resources.getString(R.string.msg_no_internet))
                    }
                }
                ChatSettingsAction.EXPORT_CALL_LOG ->{
                    CallLogger.callLogExportToChosenApp(context)
                }
            }
        }else{
            when(chatSettingsAction){
                ChatSettingsAction.EXPORT_CALL_LOG->{
                    CallLogger.deleteCallLogFile(context)
                }
            }
        }
    }

    private fun clearAllConversation(){
        if(!ChatManager.getAvailableFeatures().isClearChatEnabled){
            CustomToast.show(settingsActivity!!.applicationContext, resources.getString(R.string.fly_error_forbidden_exception))
            return
        }
        ChatManager.clearAllConversation(object : ChatActionListener {
            override fun onResponse(isSuccess: Boolean, message: String) {
                if (isSuccess) {
                    runOnUiThread { CustomToast.show(settingsActivity!!.applicationContext, resources.getString(R.string.clear_conversation_message)) }
                } else {
                    runOnUiThread { CustomToast.show(settingsActivity!!.applicationContext, Constants.ERROR_SERVER) }
                }
            }
        })
    }

    /**
     * Only Selected Jids from User
     *
     * @param position the position
     */
    override fun listOptionSelected(position: Int) {
        // Any functional implementation can be done here.
    }

    /**
     * The enumeration object which defines the different type of chat settings action which can be
     * done in this activity.
     */
    private enum class ChatSettingsAction {
        CLEAR_CONVERSATION, DELETE_CONVERSATION, EXPORT_CALL_LOG
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()


    override fun onDetach() {
        coroutineContext.cancel(CancellationException("$TAG Destroyed"))
        super.onDetach()
    }

    private fun featureActionValidation(availableFeatures: Features) {

        if(availableFeatures.isTranslationEnabled) {
            showViews(fragmentChatsBinding.layoutTranslation)
            showViews(fragmentChatsBinding.translateMessageView)
            displayTranslateLanguagePreference()
        } else {
            makeViewsGone(fragmentChatsBinding.layoutTranslation)
            makeViewsGone(fragmentChatsBinding.translateMessageView)
            makeViewsGone(fragmentChatsBinding.layoutTranslateLanguage)
        }

        if(availableFeatures.isClearChatEnabled) {
            showViews(fragmentChatsBinding.textClearConversation)
            showViews(fragmentChatsBinding.clearAllMessageView)
        } else {
            makeViewsGone(fragmentChatsBinding.textClearConversation)
            makeViewsGone(fragmentChatsBinding.clearAllMessageView)
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
        fun newInstance(): ChatsFragment {
            return ChatsFragment()
        }
    }
}