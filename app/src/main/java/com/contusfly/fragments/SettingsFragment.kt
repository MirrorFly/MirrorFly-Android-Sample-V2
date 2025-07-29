package com.contusfly.fragments

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.CompoundButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mirrorflysdk.flycommons.Features
import com.contusfly.*
import com.contusfly.activities.*
import com.contusfly.chatTag.activities.ChatTagActivity
import com.contusfly.databinding.FragmentSettingsBinding
import com.contusfly.notification.AppNotificationManager
import com.contusfly.utils.*
import com.contusfly.viewmodels.DashboardViewModel
import com.contusfly.views.CommonAlertDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.views.CustomToast
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0.
 */
class SettingsFragment(val navigateToSafeChat: Boolean?=false) : Fragment(), CommonAlertDialog.CommonDialogClosedListener {

    private lateinit var settingsBinding: FragmentSettingsBinding

    /**
     * The dialog for the common alert dialog.
     */
    private lateinit var mDialog: CommonAlertDialog

    /**
     * The settings activity
     * The Activity to which this fragment is currently associated with.
     */
    var settingsActivity: SettingsActivity? = null
        private set

    /**
     * The context of the user activity.
     */
    private lateinit var context: Activity

    /**
     * Progress dialog for the background process
     */
    private lateinit var progressDialog: ProgressDialog

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        settingsActivity = activity as SettingsActivity?
        context = settingsActivity ?: requireActivity()
        settingsActivity!!.setActionBarTitle(resources.getString(R.string.settings_label))
        // Inflate the layout for this fragment
        settingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)
        return settingsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setListeners()
        if(navigateToSafeChat == true){
            startActivity(Intent(context, PinSetting::class.java).putExtra(Constants.IS_FOR_SAFE_CHAT,true))
        }
    }

    private fun initViews() {
        featureActionValidation(ChatManager.getAvailableFeatures())
        setObserver()
        settingsActivity!!.showSearchMenu(false)
        mDialog = CommonAlertDialog(context)
        mDialog.setOnDialogCloseListener(this)
        progressDialog = ProgressDialog(context, R.style.AppCompatAlertDialogStyle)
        setVersionName()
    }

    private fun setListeners() {
        settingsBinding.layoutLogoutAccount.setOnClickListener {
            mDialog.showAlertDialog(getString(R.string.logout_message_label), getString(R.string.yes_label),
                    getString(R.string.no_label), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, true)
        }
        settingsBinding.layoutMyProfile.setOnClickListener {
            startActivity(Intent(settingsActivity, ProfileStartActivity::class.java).putExtra(Constants.IS_FIRST_LOGIN, false)
                    .putExtra(Constants.FROM_SPLASH, false))
        }

        settingsBinding.layoutChats.setOnClickListener {
            settingsActivity!!.performFragmentTransaction(ChatsFragment.newInstance())
        }

        settingsBinding.layoutAboutHelp.setOnClickListener{
            settingsActivity!!.performFragmentTransaction(AboutHelpFragment.newInstance())
        }

        settingsBinding.layoutAppLock.setOnClickListener{
            startActivity(Intent(context, PinSetting::class.java))
        }

        settingsBinding.layoutBlockedContacts.setOnClickListener{
            var feature=ChatManager.getAvailableFeatures()
            if(feature.isBlockEnabled)
                settingsActivity!!.performFragmentTransaction(BlockedContactsFragment.newInstance())
            else
                context.showToast(resources.getString(com.mirrorflysdk.R.string.fly_error_forbidden_exception))
        }

        settingsBinding.layoutNotifications.setOnClickListener{
            settingsActivity!!.performFragmentTransaction(NotificationsFragment.newInstance())
        }

        settingsBinding.layoutDeleteMyAccount.setOnClickListener{
            settingsActivity!!.performFragmentTransaction(DeleteMyAccountFragment.newInstance())
        }

        settingsBinding.layoutStarredMessages.setOnClickListener{
            var feature=ChatManager.getAvailableFeatures()
            if(feature.isStarMessageEnabled)
            startActivity(Intent(settingsActivity, StarredMessageActivity::class.java))
            else
                context.showToast(resources.getString(com.mirrorflysdk.R.string.fly_error_forbidden_exception))
        }

        settingsBinding.btnSwitchConnection.setOnCheckedChangeListener(onCheckedChanged())

        settingsBinding.layoutChatTagMessages.setOnClickListener {

            startActivity(Intent(settingsActivity, ChatTagActivity::class.java))
        }

    }

    private fun setVersionName() {
        val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
        val stringBuilder = StringBuilder()
            .append("Released On: ")
            .append(dateFormat.format(BuildConfig.BUILD_TIME))
            .append(System.getProperty("line.separator"))
            .append(String.format(getString(R.string.version_name),
                BuildConfig.VERSION_NAME))
        val versiondate = dateFormat.format(BuildConfig.BUILD_TIME)
        val versionname = BuildConfig.VERSION_NAME
        val firstindex = stringBuilder.indexOf(versiondate)
        val secondindex = stringBuilder.indexOf(versionname)
        val spannableString = SpannableString(stringBuilder)
        val bold = StyleSpan(Typeface.BOLD)
        spannableString.setSpan(bold, firstindex, versiondate.length + firstindex, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(Color.BLACK), firstindex, versiondate.length + firstindex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(bold, secondindex, versionname.length + secondindex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(Color.BLACK), secondindex, versionname.length + secondindex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        settingsBinding.textVersionName.setText(spannableString, TextView.BufferType.SPANNABLE)
    }

    private fun onCheckedChanged(): CompoundButton.OnCheckedChangeListener {
        return CompoundButton.OnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean -> if (buttonView.id == R.id.btn_switch_connection) SharedPreferenceManager.setBoolean(Constants.SHOW_LABEL, isChecked) }
    }

    override fun onStart() {
        super.onStart()
        settingsBinding.btnSwitchConnection.isChecked = SharedPreferenceManager.getBoolean(Constants.SHOW_LABEL)
    }

    companion object {
        @JvmStatic
        fun newInstance(navigateToSafeChat: Boolean? = false): SettingsFragment = SettingsFragment(navigateToSafeChat)

    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            if (AppLifecycleListener.isPinEnabled) {
                val intent = Intent(activity, PinActivity::class.java)
                intent.putExtra(Constants.GO_TO, com.mirrorflysdk.flycommons.Constants.LOGOUT_PIN)
                startActivityForResult(intent, com.mirrorflysdk.flycommons.Constants.ACTIVITY_REQ_CODE)
            } else {
                SharedPreferenceManager.setBoolean(Constants.SHOW_PIN, false)
                SharedPreferenceManager.setBoolean(Constants.BIOMETRIC, false)
                SharedPreferenceManager.setString(Constants.CHANGE_PIN_NEXT, "")
                SharedPreferenceManager.setString(Constants.MY_PIN, "")
                SafeChatUtils.silentDisableSafeChat(requireContext())
                logOutAccount()
            }
        }else{
            if (!AppLifecycleListener.isPinEnabled){
                requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) logOutAccount()
    }

    private fun logOutAccount(){
        with(progressDialog) {
            show()
            setMessage(getString(R.string.logging_out_label))
            setCancelable(false)
        }
        if (AppUtils.isNetConnected(settingsActivity)) {
            FlyCore.logoutOfChatSDK() { isSuccess, throwable, _ ->
                if (isSuccess) {
                    SharedPreferenceManager.clearAllPreference(true)
                    AppNotificationManager.cancelNotifications(context)
                    CommonUtils.navigateUserToLoggedOutUI(context)
                } else {
                    settingsActivity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    CustomToast.show(context, Constants.ERROR_SERVER)
                    LogMessage.e("Logout Failure", throwable!!.message)
                }
                progressDialog.dismiss()
            }
        } else {
            progressDialog.dismiss()
            settingsActivity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            CustomToast.show(context, getString(R.string.error_check_internet))
        }
    }

    override fun listOptionSelected(position: Int) {
        /* Called when list options has been selected */
    }

    private fun setObserver(){

        viewModel.availableFeatureLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            featureActionValidation(it)
        })

    }

    private fun featureActionValidation(availableFeatures: Features) {

        if(availableFeatures.isStarMessageEnabled){
            showViews(settingsBinding.layoutStarredMessages)
            showViews(settingsBinding.starMessageLayoutView)
        } else {
            makeViewsGone(settingsBinding.layoutStarredMessages)
            makeViewsGone(settingsBinding.starMessageLayoutView)
        }

        if(availableFeatures.isBlockEnabled) {
            showViews(settingsBinding.layoutBlockedContacts)
            showViews(settingsBinding.blockLayoutView)
        } else {
            makeViewsGone(settingsBinding.layoutBlockedContacts)
            makeViewsGone(settingsBinding.blockLayoutView)
        }
    }

}