package com.contusfly.fragments

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycall.webrtc.CallType
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.activities.ChatActivity
import com.contusfly.activities.GroupInfoActivity
import com.contusfly.activities.UserInfoActivity
import com.contusfly.activities.UserProfileImageViewActivity
import com.contusfly.call.CallPermissionUtils
import com.contusfly.call.groupcall.utils.CallUtils
import com.contusfly.databinding.FragmentProfileDialogBinding
import com.contusfly.utils.*
import com.contusfly.views.PermissionAlertDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import kotlinx.coroutines.CoroutineExceptionHandler
import java.io.IOException

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileDialogFragment : DialogFragment() {

    private val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Coroutine Exception :  ${exception.printStackTrace()}")
    }

    private lateinit var profileDialogBinding: FragmentProfileDialogBinding

    // Data
    lateinit var callPermissionUtils: CallPermissionUtils
    lateinit var profileDetails: ProfileDetails
    lateinit var rosterImage: String

    private var lastCallAction = ""

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(requireActivity()) }

    private val requestCallPermissions: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            // Do something if some permissions granted or denied
            if (!permissions.containsValue(false)) {
                if (lastCallAction == CallType.AUDIO_CALL) {
                    callPermissionUtils.audioCall()
                } else {
                    callPermissionUtils.videoCall()
                }
                dismissDialog()
            }
        }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        profileDialogBinding = FragmentProfileDialogBinding.inflate(inflater, container, false)
        dialog?.setCanceledOnTouchOutside(true)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return profileDialogBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        checkUserBlocked()
        setData()
    }

    private fun setListeners() {
        profileDialogBinding.openChatView.setOnClickListener { navigateToChatViewScreen() }
        profileDialogBinding.openUserProfile.setOnClickListener { navigateToProfileInfoScreen() }
        profileDialogBinding.userProfileImageViewer.setOnClickListener { navigateToProfileImageScreen() }
        profileDialogBinding.audioCall.setOnClickListener { makeAudioCall() }
        profileDialogBinding.videoCall.setOnClickListener { makeVideoCall() }
    }

    private fun checkUserBlocked() {
        rosterImage = if (profileDetails.isBlockedMe) "" else profileDetails.image
        profileDialogBinding.userProfileImageViewer.isEnabled = rosterImage.isNotEmpty()
    }

    private fun setData() {
        profileDialogBinding.userProfileImageViewer.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_light_gray))
        profileDialogBinding.userName.text = ProfileDetailsUtils.getProfileDetails(profileDetails.jid)!!.name
        ProfileDetailsUtils.getProfileDetails(profileDetails.jid)?.let {
            profileDialogBinding.userProfileImageViewer.setImageDrawable(null)
            if(it.isGroupProfile){
                val isNewlyCreated = SharedPreferenceManager.getBoolean(Constants.NEWLY_CREATED_GROUP)
                val newlyCreatedJid = SharedPreferenceManager.getString(Constants.NEW_GROUP_JID)
                val imageBitmap = SharedPreferenceManager.getString(Constants.NEW_GROUP_IMAGE)
                if (it.image.isNotEmpty() && newlyCreatedJid.isNotEmpty() && imageBitmap.isNotEmpty() && isNewlyCreated &&
                    it.jid.equals(newlyCreatedJid)){
                    profileDialogBinding.userProfileImageViewer.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_grp_bg
                        )!!
                    )
                    try {
                        val imageAsBytes: ByteArray =
                            android.util.Base64.decode(imageBitmap, android.util.Base64.DEFAULT)
                        val image =
                            BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
                        profileDialogBinding.userProfileImageViewer.setImageBitmap(image)
                        val drawable: Drawable = BitmapDrawable(resources, image)
                        profileDialogBinding.userProfileImageViewer.setImageDrawable(drawable)
                        profileThumbLoad(drawable)
                    } catch (e: IOException) {
                        LogMessage.e("ProfileDialogFragment", e)
                    }
                } else {
                    profileDialogBinding.userProfileImageViewer.loadUserInfoProfileImage(
                        requireContext(),
                        it
                    )
                }
            }
            else {
                profileDialogBinding.userProfileImageViewer.loadUserInfoProfileImage(
                    requireContext(),
                    it
                )
            }
        }
        callPermissionUtils = activity?.let { CallPermissionUtils(it, profileDetails.isBlocked,
            profileDetails.isAdminBlocked, arrayListOf(profileDetails.jid),"",false) }!!

        hideCallIcons()
    }

    private fun profileThumbLoad(drawable: Drawable) {
        if (!profileDetails.thumbImage.isNullOrEmpty()) {
            MediaUtils.loadThumbImage(
                requireContext(),
                profileDetails.image,
                profileDetails.thumbImage,
                profileDialogBinding.userProfileImageViewer,
                drawable
            )

        } else {
            MediaUtils.loadImage(
                requireContext(),
                profileDetails.image,
                profileDialogBinding.userProfileImageViewer,
                drawable
            )
        }
    }

    private fun hideCallIcons() {
        val isAdminBlocked = profileDetails.isAdminBlocked
        if (profileDetails.getChatType() == ChatType.TYPE_GROUP_CHAT
            || profileDetails.isDeletedContact()
            || !ChatManager.getAvailableFeatures().isOneToOneCallEnabled) {
            profileDialogBinding.videoCallLinearlayout.visibility = View.GONE
            profileDialogBinding.audioCallLinearlayout.visibility = View.GONE
            profileDialogBinding.openUserProfile.isEnabled = !isAdminBlocked
        }
    }

    private fun navigateToChatViewScreen() {
        startActivity(
            Intent(context, ChatActivity::class.java)
            .putExtra(LibConstants.JID, profileDetails.jid)
            .putExtra(Constants.CHAT_TYPE, profileDetails.getChatType())
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        dismissDialog()
    }

    private fun navigateToProfileInfoScreen() {
        if (profileDetails.getChatType() == ChatType.TYPE_GROUP_CHAT) {
            startActivity(Intent(context, GroupInfoActivity::class.java)
                .putExtra(AppConstants.PROFILE_DATA, ProfileDetailsUtils.getProfileDetails(profileDetails.jid)))
        } else {
            startActivity(Intent(context, UserInfoActivity::class.java)
                .putExtra(AppConstants.PROFILE_DATA, ProfileDetailsUtils.getProfileDetails(profileDetails.jid)))
        }

        dismissDialog()
    }

    private fun navigateToProfileImageScreen() {
        val profile = ProfileDetailsUtils.getProfileDetails(profileDetails.jid)
        var title: String? = profile!!.name
        if (title == null || title.isEmpty())
            title = resources.getString(R.string.action_delete)

        startActivity(Intent(context, UserProfileImageViewActivity::class.java)
            .putExtra(Constants.GROUP_OR_USER_NAME, title)
            .putExtra("PROFILE", if (!profile.isAdminBlocked) rosterImage else ""))
        dismissDialog()
    }

    private fun makeAudioCall() {
        CallUtils.setIsCallStarted(CallType.AUDIO_CALL)
        if (CallManager.isAudioCallPermissionsGranted(skipBlueToothPermission = false)) {
            callPermissionUtils.audioCall()
            dismissDialog()
        } else {
            lastCallAction = CallType.AUDIO_CALL
            MediaPermissions.requestAudioCallPermissions(
                requireActivity(),
                permissionAlertDialog,
                requestCallPermissions
            )
        }
    }

    private fun makeVideoCall() {
        CallUtils.setIsCallStarted(CallType.VIDEO_CALL)
        if (CallManager.isVideoCallPermissionsGranted(skipBlueToothPermission = false)) {
            callPermissionUtils.videoCall()
            dismissDialog()
        } else {
            lastCallAction = CallType.VIDEO_CALL
            MediaPermissions.requestVideoCallPermissions(
                requireActivity(),
                permissionAlertDialog,
                requestCallPermissions
            )
        }
    }


    private fun dismissDialog() {
        dialog?.dismiss()
    }

    fun refreshView(){
        checkUserBlocked()
        setData()
    }

    companion object {
        fun newInstance(profileDetails: ProfileDetails) = ProfileDialogFragment().apply {
            this.profileDetails = profileDetails
        }
    }
}