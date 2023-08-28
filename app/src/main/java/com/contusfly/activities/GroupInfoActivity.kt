package com.contusfly.activities

import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.flycommons.*
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.flycommons.exception.ErrorCode
import com.mirrorflysdk.flycommons.exception.FlyException
import com.contusfly.*
import com.contusfly.R
import com.contusfly.activities.parent.ChatParent
import com.contusfly.adapters.GroupMembersAdapter
import com.contusfly.databinding.ActivityGroupInfoBinding
import com.contusfly.models.PrivateChatAuthenticationModel
import com.contusfly.privateChat.PrivateChatEnableDisableActivity
import com.contusfly.utils.*
import com.contusfly.utils.ChatUtils
import com.contusfly.utils.CommonUtils
import com.contusfly.utils.CommonUtils.Companion.showBottomSheetView
import com.contusfly.utils.Constants.Companion.USERS_JID
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.RequestCode
import com.contusfly.utils.RequestCode.CONTACT_PERMISSION_REQUEST_CODE
import com.contusfly.utils.SharedPreferenceManager
import com.contusfly.views.CommonAlertDialog
import com.contusfly.views.DoProgressDialog
import com.contusfly.views.PermissionAlertDialog
import com.contusfly.views.TimerProgressDialog
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatActionListener
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.GroupManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.utils.ImageUtils
import com.mirrorflysdk.utils.FilePathUtils
import com.mirrorflysdk.utils.ImagePopUpUtils
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.utils.VideoRecUtils
import com.mirrorflysdk.views.CustomToast
import com.google.android.material.appbar.AppBarLayout
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.collections.ArrayList

class GroupInfoActivity : BaseActivity(),CommonAlertDialog.CommonDialogClosedListener ,DialogInterface.OnClickListener{

    private lateinit var binding: ActivityGroupInfoBinding

    private lateinit var mAppBarLayout: AppBarLayout

    private lateinit var mCoordinatorLayout: CoordinatorLayout

    private lateinit var collapsingToolbar: CollapsingToolbarLayout

    private lateinit var groupProfileDetails: ProfileDetails



    /**
     * Current time of the system
     */
    var lastClicktime: Long = 0


    /**
     * Position of the user clicked to handle the operation
     */
    private var lastKnownPosition = 0

    /**
     * The phone number of the unknown participant.
     */
    private var phoneNumber: String? = null

    /**
     * The instance of the CommonAlertDialog
     */
    private var mDialog: CommonAlertDialog? = null

    /**
     * Flag to identify whether the unknown participant has to be added to the existing contact.
     */
    private var isExistingContactInsert = false

    private val myJid: String by lazy { SharedPreferenceManager.getString(Constants.USER_JID) }

    /**
     * Flag to identify whether the unknown participant is selected for the user action.
     */
    private var isUnknownParticipant = false

    /**
     * List of group users
     */
    private lateinit var usersList: MutableList<ProfileDetails>

    /**
     * Instance of the Group user(Logged in user)
     */
    private var isGroupAdmin: Boolean = false

    private var isGroupNotDeleted: Boolean = true

    private var storagePrefix: String = "/storage/emulated/"

    /**
     * The Dialog mode to show
     */
    private var dialogMode: DIALOGMODE? = null

    /**
     * Flag to identify whether the group image is updated.
     */
    private var isImageUpdate = false

    /**
     * File instance of the group image
     */
    private var mFileTemp: File? = null

    /**
     * The file to which the group camera image is associated.
     */
    private var mFileCameraTemp: File? = null

    private var editIcon: MenuItem? = null

    private var userParticipantStatusChange:Boolean = false

    private var commonAlertDialog: CommonAlertDialog? = null

    private val isGroupMember: Boolean
            by lazy {
                ChatManager.getAvailableFeatures().isGroupChatEnabled &&  GroupManager.isMemberOfGroup(
                    groupProfileDetails.jid,
                    SharedPreferenceManager.getString(Constants.USER_JID)
                )
            }

    private val groupMembersList: ArrayList<ProfileDetails> by lazy { ArrayList() }

    private val groupMembersAdapter by lazy {
        GroupMembersAdapter(this, groupMembersList) { position: Int, profile: ProfileDetails ->
            listItemClicked(position, profile)
        }
    }

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val galleryPermissionLauncher =  registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(readPermissionGranted) {
            PickFileUtils.chooseImageFromGallery(this)
        }
    }

    private val contactPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val contactPermissionGranted = permissions[Manifest.permission.READ_CONTACTS] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_CONTACTS)

        if(contactPermissionGranted) {
            checkContactChange()
            onAddParticipantsClick()
        }
    }

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val cameraPermissionGranted = permissions[Manifest.permission.CAMERA] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.CAMERA)

        if(readPermissionGranted && cameraPermissionGranted) {
            groupProfileDetails.image = ImageUtils.takePhotoFromCamera(this,
                VideoRecUtils.getPath(this,
                    getString(R.string.profile_photos_label)
                ), true)
        }
    }

    /**
     * The instance of the DoProgressDialog
     */
    lateinit var progressDialog: DoProgressDialog

    /**
     * Alert dialog action mode to handle when the dialog closed
     */
    private enum class DIALOGMODE {
        REMOVE_GROUP, EXIT_GROUP, DELETE_GROUP, MAKE_ADMIN, REMOVE_ADMIN, REMOVE_PHOTO, REPORT_GROUP, UNARCHIVE
    }


    override fun onDeleteGroup(groupJid: String) {
        super.onDeleteGroup(groupJid)
        if (groupProfileDetails.jid == groupJid && isGroupNotDeleted) {
            isGroupNotDeleted = false
            setResult(Activity.RESULT_FIRST_USER)
            startDashboardActivity()
        }
    }

    /**
     * check weather the collapsed or not
     */
    private var isToolbarCollapsed = false

    private var isOpenUserInfoView:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        groupProfileDetails = intent.getParcelableExtra(AppConstants.PROFILE_DATA)!!
        setToolbar()
        setUserData()
        initViews()
        initListeners()
        loadAdapterData()
        groupFeatureValidation(ChatManager.getAvailableFeatures())
        GroupManager.getGroupMembersList(ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.doesFetchingMembersListFromServedRequired(groupProfileDetails.jid), groupProfileDetails.jid) { isSuccess, throwable, data ->
            if (isSuccess) {
                var groupMembers: MutableList<ProfileDetails> =
                    data.getData() as ArrayList<ProfileDetails>
                val myProfileIndex = groupMembers.indexOfFirst { pd -> pd.jid == myJid }
                if (myProfileIndex.isValidIndex()) {
                    val myProfile = groupMembers[myProfileIndex]
                    groupMembers.removeAt(myProfileIndex)
                    myProfile.nickName = AppConstants.YOU
                    myProfile.name = AppConstants.YOU
                    groupMembers.add(myProfile)
                }
                groupMembersList.clear()
                groupMembers = ProfileDetailsUtils.sortGroupProfileList(groupMembers)
                groupMembersList.addAll(groupMembers)
                groupMembersAdapter.notifyDataSetChanged()
            } else {
                if (!(throwable is FlyException && throwable.errorCode == ErrorCode.FORBIDDEN_ACTION))
                    showToast(getString(R.string.error_fetching_group_members))
            }
        }
    }

    private fun initListeners() {
        mDialog!!.setOnDialogCloseListener(this)
        binding.muteSwitch.setOnCheckedChangeListener { _, isChecked ->
            FlyCore.updateChatMuteStatus(groupProfileDetails.jid, isChecked)
        }
        binding.addParticipant.setOnClickListener {
            if (!BuildConfig.CONTACT_SYNC_ENABLED || MediaPermissions.isPermissionAllowed(this, Manifest.permission.READ_CONTACTS)) {
                onAddParticipantsClick()
            } else
                MediaPermissions.requestContactsReadPermission(this, permissionAlertDialog, contactPermissionLauncher, null)
        }
        binding.editName.setOnClickListener {
            startActivityForResult(Intent(this, CommonEditorActivity::class.java)
            .putExtra(Constants.TITLE, getString(R.string.text_new_group_name))
            .putExtra(Constants.TYPE, Constants.GROUP_NAME_UPDATE)
            .putExtra(Constants.TEXT_COUNT, Constants.MAX_GROUP_NAME_COUNT)
            .putExtra(Constants.USER_JID, groupProfileDetails.jid)
            .putExtra(Constants.MSG_TYPE_TEXT, groupProfileDetails.getDisplayName()), Constants.EDIT_REQ_CODE
        ) }
        binding.profileImage.setOnClickListener { openImageView() }
        binding.leaveGroup.setOnClickListener{ exitOrDeleteGroup() }
        binding.textMedia.setOnClickListener {
            var feature=ChatManager.getAvailableFeatures()
            if(feature.isViewAllMediaEnabled){
                launchActivity<ViewAllMediaActivity> {
                    putExtra(Constants.ROSTER_JID, groupProfileDetails.jid)
                }
            } else {
                showToast(resources.getString(R.string.fly_error_forbidden_exception))
            }
        }
        groupMembersAdapter.onProfileClickedCallback{position,profile->
            listItemClicked(position,profile)
        }
        binding.reportGroup.setOnClickListener { showReportMessagePopup() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initViews() {
        SharedPreferenceManager.setString(com.contusfly.utils.Constants.ON_GOING_CHAT_USER,groupProfileDetails.jid)
        commonAlertDialog = CommonAlertDialog(this)
        commonAlertDialog!!.setOnDialogCloseListener(this)
        checkPrivateChatAvailable()
        onClickFunction()
        groupMembersAdapter.setHasStableIds(true)
        groupMediaValidation()
        binding.membersListView.apply {
            layoutManager = LinearLayoutManager(context)
            setItemViewCacheSize(15)
            setHasFixedSize(true)
            itemAnimator = null
            adapter = groupMembersAdapter
            isNestedScrollingEnabled = false
        }
        mDialog = CommonAlertDialog(this)
        /*
         * Create the temporary file to keep the image
         */

        initFileObjects()
    }

    private fun checkPrivateChatAvailable() {
        try {

            if(ChatManager.getIsRecentChatOfUser(groupProfileDetails.jid)) {
                binding.privateChatView.privateChatLayout.visibility=View.VISIBLE
            } else {
                binding.privateChatView.privateChatLayout.visibility=View.GONE
            }

        } catch(e : Exception){
            com.contusfly.utils.LogMessage.e(TAG,e.toString())
        }

    }

    private fun onClickFunction(){
        binding.privateChatView.privateChatLayout.setOnClickListener {
            if(FlyCore.isArchivedUser(groupProfileDetails.jid)){
                makeUnArchiveAlertShow()
            } else {
                val intent=Intent(this, PrivateChatEnableDisableActivity::class.java)
                intent.putExtra(LibConstants.JID, groupProfileDetails.jid)
                startActivity(intent)
            }

        }
    }

    private fun makeUnArchiveAlertShow(){
        dialogMode = DIALOGMODE.UNARCHIVE
        val archiveLabel = getString(R.string.unarchive_label)
        commonAlertDialog!!.showAlertDialog(Constants.EMPTY_STRING, getString(R.string.archive_chat_lock_title), archiveLabel,
            getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL)
    }

    private fun initFileObjects() {
        val directoryName = (FilePathUtils.getExternalStorage()).toString() + File.separator + getString(R.string.title_app_name)
            .replace(" ", "") +
                File.separator + Constants.IMAGE_LOCAL_PATH + File.separator + Constants.MSG_SENT_PATH
        val directory = File(directoryName)
        if (!directory.exists()) directory.mkdir()
        mFileTemp = ImageUtils.getFile(directoryName, ".jpg")

        mFileCameraTemp = File(FilePathUtils.getExternalStorage(), Constants.TEMP_PHOTO_FILE_NAME)
    }
    /**
     * Checks login user availability in the group and changes the view accordingly.
     *
     *
     * If the login user is available in the group or the chat type is broadcast, add participants will be shown.
     *
     *
     * If the login user available in the group group exit will be shown, if the user not available
     * in group delete group will be shown, if the chat type is broadcast delete broadcast will be shown.
     */
    private fun loadGroupExistence() {
        //   Checks the group information is not null
        if (groupProfileDetails != null) {
            when {
                ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid()) -> {
                    binding.leaveGroup.visibility=View.VISIBLE
                    binding.leaveGroup.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_leave_group, 0, 0, 0)
                    binding.leaveGroup.text = getString(R.string.label_leave_group)
                }
                ChatType.TYPE_GROUP_CHAT == groupProfileDetails.getChatType() -> {
                    if(!ChatManager.getAvailableFeatures().isDeleteChatEnabled){
                        binding.leaveGroup.visibility=View.GONE
                        return
                    }
                    binding.leaveGroup.visibility=View.VISIBLE
                    binding.leaveGroup.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_delete_group, 0, 0, 0)
                    binding.leaveGroup.text = getString(R.string.label_delete_group)
                }
                else -> {
                    binding.leaveGroup.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_delete_group, 0, 0, 0)
                    binding.leaveGroup.text = getString(R.string.label_delete_broadcast)
                }
            }
        }
    }

    /**
     * Called when the user blocked me
     */
    override fun userBlockedMe(jid: String) {
        super.userBlockedMe(jid)
        if (jid.isNotEmpty()) loadAdapterData()
    }

    /**
     * Called when the user unblocked me
     */
    override fun userUnBlockedMe(jid: String) {
        super.userUnBlockedMe(jid)
        if (jid.isNotEmpty()) loadAdapterData()
    }

    override fun onLeftFromGroup(groupJid: String, leftUserJid: String) {
        super.onLeftFromGroup(groupJid, leftUserJid)
        if (groupProfileDetails.jid == groupJid) {
            loadAdapterData()
            loadGroupExistence()
        }
    }

    /**
     * To verify is there any media conversation in group
     *
     */
    private fun groupMediaValidation() {
        binding.textMedia.visibility = View.VISIBLE
    }

    /**
     * Handle the user removed from the group
     *
     * @param groupJid Group id
     * @param removedMemberJid Removed member Jid
     * @param removedByMemberJid Made remove member jid
     */
    override fun onMemberRemovedFromGroup(groupJid: String, removedMemberJid: String, removedByMemberJid: String) {
        super.onMemberRemovedFromGroup(groupJid, removedMemberJid, removedByMemberJid)
        if (groupProfileDetails.jid == groupJid) {
            loadAdapterData()
            loadGroupExistence()
        }
    }

    override fun onGroupNewUserAdded(groupId: String, userJid: String) {
        super.onGroupNewUserAdded(groupId, userJid)
        if (groupProfileDetails.jid == groupId) {
            loadAdapterData()
            loadGroupExistence()
        }
    }



    /**
     * Called when the group updated successfully from the server. Group jid get the response from the server.
     * If the user creating the group first time then that need to add the participants after this method called.
     *
     * @param groupJid Group jid of the Mix group chat
     */
    override fun onGroupProfileUpdated(groupJid: String) {
        super.onGroupProfileUpdated(groupJid)
        if (groupProfileDetails.jid == groupJid) {
            loadGroupNameAndImage()
        }
    }

    /**
     * Called when the group is updated
     *
     * @param groupId Group jid
     */
    override fun onGroupUpdatedResponse(groupId: String) {
        loadGroupNameAndImage()
    }

    /**
     * Handle the new user added in the group.
     *
     * @param groupJid Group jid
     * @param newMemberJid Jabber id of the User
     * @param addedByMemberJid Jid of user who adds the member
     */
    override fun onNewMemberAddedToGroup(groupJid: String, newMemberJid: String, addedByMemberJid: String) {
        super.onNewMemberAddedToGroup(groupJid, newMemberJid, addedByMemberJid)
        if (groupProfileDetails.jid == groupJid) {
            loadAdapterData()
            loadGroupExistence()
        }
    }


    /**
     * Called when the group admin changed the affiliation
     *
     * @param groupJid Group jid
     * @param newAdminMemberJid New admin jid
     * @param madeByMemberJid Made new admin jid
     */
    override fun onMemberMadeAsAdmin(groupJid: String, newAdminMemberJid: String, madeByMemberJid: String) {
        super.onMemberMadeAsAdmin(groupJid, newAdminMemberJid, madeByMemberJid)
        if (groupProfileDetails.jid == groupJid) {
            loadAdapterData()
        }
    }

    override fun onNewGroupCreated(groupJid: String) {
        super.onNewGroupCreated(groupJid)
        if (groupProfileDetails.jid == groupJid) {
            loadAdapterData()
            loadGroupExistence()
        }
    }

    override fun onGroupParticipantsAdded(isError: Boolean, message: String, groupId: String) {
        super.onGroupParticipantsAdded(isError, message, groupId)
        if (groupProfileDetails.jid == groupId) {
            loadAdapterData()
            loadGroupExistence()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        editIcon = menu.get(R.id.action_edit)
        if (ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid())) {
            editIcon!!.setIcon(R.drawable.ic_image_edit)
            editIcon!!.show()
            binding.editName.show()
            if(userParticipantStatusChange) {
                userParticipantStatusChange = false
                loadAdapterData()
                loadGroupExistence()
            }
            if (isToolbarCollapsed) {
                editIcon!!.icon?.applySourceColorFilter(
                    ContextCompat.getColor(
                        context!!,
                        R.color.color_text
                    )
                )
            }
        } else {
            userParticipantStatusChange = true
            binding.editName.hide()
            editIcon!!.hide()
        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun setToolbar() {

        val toolbar = binding.toolbar
        collapsingToolbar = binding.collapsingToolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        mAppBarLayout = binding.appBarLayout
        mCoordinatorLayout = binding.coordinatorLayout
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.navigationIcon!!.applyMultiplyColorFilter(
            ContextCompat.getColor(
                this,
                R.color.color_black
            )
        )
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.title = Constants.EMPTY_STRING
        mAppBarLayout.addOnOffsetChangedListener(AppBarLayout.BaseOnOffsetChangedListener { _: AppBarLayout?, verticalOffset: Int ->
            if (collapsingToolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(
                    collapsingToolbar
                )
            )
                toolbar.navigationIcon!!.applySourceColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.color_black
                    )
                )
            else toolbar.navigationIcon!!.applySourceColorFilter(
                ContextCompat.getColor(
                    this,
                    R.color.color_white
                )
            )
        } as AppBarLayout.BaseOnOffsetChangedListener<*>)

    }

    private fun setEditPrivelages(){
        if(ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid())){
            binding.editName.show()
            editIcon!!.show()
        }else{
            binding.editName.hide()
            editIcon!!.hide()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CONTACT_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults.contains(PackageManager.PERMISSION_GRANTED))
                    listOptionSelected(if (isExistingContactInsert) 1 else 0)
                else CustomToast.show(applicationContext, getString(R.string.contact_permission))
            }
        }
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (isSuccess) {
            when (dialogMode) {
                DIALOGMODE.REMOVE_GROUP ->
                    if(ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid())) {
                        removeUserFromGroup()
                    }
                    else{
                        CustomToast.show(context,getString(R.string.mgs_not_a_group_member))
                    }
                DIALOGMODE.EXIT_GROUP -> exitFromGroup()
                DIALOGMODE.DELETE_GROUP -> onDeleteGroup()
                DIALOGMODE.MAKE_ADMIN ->
                    if(ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid())) {
                        makeAdmin()
                    }
                    else{
                        CustomToast.show(context,getString(R.string.mgs_not_a_group_member))
                    }
                DIALOGMODE.REMOVE_PHOTO -> revokeAccessForProfileImage()
                DIALOGMODE.REPORT_GROUP -> reportGroup()
                DIALOGMODE.UNARCHIVE -> unArchiveUser()
                else -> {
                    /*
                    * No Implementation needed
                    * */
                }
            }
        }
    }

    private fun unArchiveUser(){
        FlyCore.updateArchiveUnArchiveChat(groupProfileDetails.jid, false, FlyCallback { isSuccess, _, _ ->
            if (isSuccess) {
                //No implement
            }
        })
    }

    private fun reportGroup() {
        progressDialog = DoProgressDialog(this)
        progressDialog.showProgress()
        FlyCore.reportUserOrMessages(groupProfileDetails.jid, ChatType.TYPE_GROUP_CHAT) {isSuccess, _, data ->
            if (isSuccess) {
                showToast(getString(R.string.label_report_sent))
            } else {
                showToast(data.getMessage())
            }
            progressDialog.dismiss()
        }
    }

    private fun showReportMessagePopup() {
        dialogMode = DIALOGMODE.REPORT_GROUP
        val reportLabel = getString(R.string.label_report)
        val userName = "$reportLabel this group?"
        mDialog!!.showAlertDialog(userName, getString(R.string.label_group_report_5_message), reportLabel,
            getString(R.string.action_cancel), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_edit) {
                showBottomSheetView(this, groupProfileDetails.image.isNotEmpty(), this)
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Onclick method to handle change image through gallery, camera and remove photo.
     */
    override fun onClick(dialog: DialogInterface, which: Int) {
        when (which) {
            R.id.action_take -> {
                isImageUpdate = true
                takePhoto()
            }
            R.id.action_gallery -> {
                isImageUpdate = true
                handleGalleryAction()
            }
            R.id.action_remove -> {
                isImageUpdate = false
                dialogMode = DIALOGMODE.REMOVE_PHOTO
                mDialog!!.showAlertDialog(
                    getString(R.string.msg_are_you_sure_remove_group_photo),
                    getString(R.string.action_remove),
                    getString(R.string.action_cancel),
                    CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
            }
        }
    }

    /**
     * List option selected.
     *
     * @param position the position
     */
    override fun listOptionSelected(position: Int) {
        var selectedPosition = position
        if (!isUnknownParticipant) {
            /*
             * The position is incremented to properly handle the user action since the action's
             * list do not include the add contacts option for the known participants.
             */
            selectedPosition += 2
        }
        when (selectedPosition) {
//            0 -> {
//                isExistingContactInsert = false
//                if (chatViewUtils!!.isContactPermissionAvailable(this)) chatViewUtils!!.insertContact(this, phoneNumber) else chatViewUtils!!.requestContactPermission(this)
//            }
//            1 -> {
//                isExistingContactInsert = true
//                if (chatViewUtils!!.isContactPermissionAvailable(this)) chatViewUtils!!.contactPickActivity(this) else chatViewUtils!!.requestContactPermission(this)
//            }
            2 -> openChatView()
            3 -> openInfoView()
            4 -> {
                if(ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid())) {
                    dialogMode = DIALOGMODE.REMOVE_GROUP
                    showConfirmDialog(getString(R.string.msg_are_you_sure_remove))
                }
                else{
                    CustomToast.show(context,getString(R.string.mgs_not_a_group_member))
                }
            }
            5 -> doAdminActions()
        }
    }

    /**
     * Show confirm dialog with the name.
     *
     * @param message Warning message
     */
    private fun showConfirmDialog(message: String) {
        val vcard = groupMembersList[lastKnownPosition]
        val messageCpy: String = if(message.contains("remove")){
            message + " " + vcard.getDisplayName()+"?"
        } else{
            message +" " + vcard.getDisplayName() + " the admin?"
        }
        mDialog!!.showAlertDialog(messageCpy,
            getString(R.string.action_yes),
            getString(R.string.action_no),
            CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
    }

    /**
     * Open the chat view of the Group user.
     */
    private fun openChatView() {
        isOpenUserInfoView=false
        if(ChatManager.isPrivateChat(groupMembersList[lastKnownPosition].jid) && !ChatManager.isPrivateChat(groupProfileDetails.jid)){
            launchPinActivity()
        } else {
            launchChatPage()
        }
    }

    private fun launchChatPage(){
        ChatParent.startActivity(this, groupMembersList[lastKnownPosition].jid, ChatType.TYPE_CHAT)
    }

    private fun launchPinActivity() {

        if (SharedPreferenceManager.getBoolean(com.contusfly.utils.Constants.BIOMETRIC)) {
            val intent = Intent(activity, BiometricActivity::class.java)
            intent.putExtra(com.contusfly.utils.Constants.GO_TO, com.contusfly.utils.Constants.PRIVATE_CHAT_LIST)
            myActivityResultLauncher.launch(intent)
        } else  {
            val intent = Intent(activity, PinActivity::class.java)
            intent.putExtra(com.contusfly.utils.Constants.GO_TO, com.contusfly.utils.Constants.PRIVATE_CHAT_LIST)
            myActivityResultLauncher.launch(intent)
        }

    }

    private var myActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                if(isOpenUserInfoView){
                    launchUserInfoPage()
                } else {
                    launchChatPage()
                }
            }
        }



    private fun setToolbarTitle(title: String) {

        collapsingToolbar.title = title
        (collapsingToolbar.parent as AppBarLayout)
            .addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _: AppBarLayout?, i: Int ->
                isToolbarCollapsed = i != 0
                invalidateOptionsMenu()
            })
    }

    /**
     * Take photo for group profile image
     */
    private fun takePhoto() {
        /*
          Check the camera permission to access
         */
        if (MediaPermissions.isPermissionAllowed(context, Manifest.permission.CAMERA)
            && MediaPermissions.isWriteFilePermissionAllowed(context)) groupProfileDetails.image = ImageUtils.takePhotoFromCamera(this,
            VideoRecUtils.getPath(this,
                getString(R.string.profile_photos_label)
            ), true) else activity?.let {
            MediaPermissions.requestCameraStoragePermissions(
                it,
                permissionAlertDialog,
                cameraPermissionLauncher
            )
        }
    }

    /**
     * Handles the gallery action.
     */
    private fun handleGalleryAction() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            if (MediaPermissions.isReadFilePermissionAllowed(context)) {
                PickFileUtils.chooseImageFromGallery(this)
            } else activity?.let {
                MediaPermissions.requestCameraStoragePermissions(
                    it,
                    permissionAlertDialog,
                    galleryPermissionLauncher
                )
            }
        } else {
            PickFileUtils.chooseImageFromGallery(this)
        }
    }


    private fun setProfileImage(image: String) {

        if (image.startsWith(storagePrefix) && File(Utils.returnEmptyStringIfNull(image)).exists()) {
            MediaUtils.loadImageWithGlide(this, image, binding.profileImage, null)
        } else {
            MediaUtils.loadImageWithGlideSecure(
                this,
                if (image.isBlank()) null else image,
                binding.profileImage,
                null
            )
        }
    }

    private fun setMuteNotificationStatus(isMute: Boolean) {
        if (!FlyCore.isUserUnArchived(groupProfileDetails.jid)) {
            binding.muteSwitch.isEnabled = false
            binding.muteSwitch.alpha = 0.5F
        }
        binding.muteSwitch.isChecked = isMute
    }

    private fun setUserData() {
        setToolbarTitle(groupProfileDetails.getDisplayName())
        setProfileImage(groupProfileDetails.image ?: emptyStringFE())
        try {
            binding.subTitle.text = "${GroupManager.getMembersCountOfGroup(groupProfileDetails.jid)} members"
        } catch (e: Exception) {
            binding.subTitle.text = "0 members"
        }
        setMuteNotificationStatus(groupProfileDetails.isMuted)
        if (!isGroupMember) binding.muteSwitch.isEnabled = false
    }

    /**
     * Callback for delete group button click
     */
    private fun onDeleteGroup() {
        if(!ChatManager.getAvailableFeatures().isDeleteChatEnabled){
            loadGroupExistence()
            showToast(resources.getString(R.string.fly_error_forbidden_exception))
            return
        }
        progressDialog = DoProgressDialog(this)
        progressDialog.showProgress()
        if (groupProfileDetails.isGroupProfile) {
            deleteGroup()
        }
    }

    /**
     * Handle the Delete group operation
     */
    private fun deleteGroup() {
        netConditionalCall({
            GroupManager.deleteGroup(groupProfileDetails.jid!!) { isSuccess, _, _ ->
                progressDialog.dismiss()
                if (isSuccess) {
                    if (isGroupNotDeleted) {
                        isGroupNotDeleted = false
                        setResult(Activity.RESULT_FIRST_USER)
                        startDashboardActivity()
                    }
                } else {
                    CustomToast.show(this, getString(R.string.error_occurred_label))
                }
            }
        }, { progressDialog.dismiss()
            showToast(getString(R.string.msg_no_internet)) })
    }

    private fun listItemClicked(position: Int, profile: ProfileDetails) {
        /*
         * Should not show options for currently logged in user
         */
        val now = System.currentTimeMillis()
        if (now - lastClicktime < 300) return
        lastClicktime = now
        if (position != groupMembersList.size - 1 || ChatManager.getAvailableFeatures().isGroupChatEnabled && !GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid())) {
            lastKnownPosition = position
            phoneNumber = profile.mobileNumber
            mDialog!!.showListDialog(
                Constants.EMPTY_STRING,
                getUserClickMenu(profile)
            )
        }
    }


    public override fun onResume() {
        super.onResume()
        loadGroupNameAndImage()
        loadGroupExistence()
        loadAdapterData()
    }

    /**
     * Launches a new Dashboard activity. If the activity being launched is already running in the current task,
     * then instead of launching a new instance of that activity, all of the other activities on top of it will be closed
     * and this Intent will be delivered to the (now on top) old activity as a new Intent.
     */
    private fun startDashboardActivity() {
        val dashboardIntent = Intent(applicationContext, DashboardActivity::class.java)
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(dashboardIntent)
        finish()
    }

    /**
     * Open Chat info view of the Group user.
     */
    private fun openInfoView() {
        isOpenUserInfoView=true
        if(ChatManager.isPrivateChat(groupMembersList[lastKnownPosition].jid) && !ChatManager.isPrivateChat(groupProfileDetails.jid)){
            launchPinActivity()
        } else {
            launchUserInfoPage()
        }

    }

    private fun launchUserInfoPage() {
        launchActivity<UserInfoActivity> {
            putExtra(AppConstants.PROFILE_DATA, groupMembersList[lastKnownPosition])
        }
    }

    /**
     * Callback for add participants on click
     */
    private fun onAddParticipantsClick() {
        val userList: MutableList<String> = java.util.ArrayList()
        var i = 0
        val size = usersList.size
        while (i < size) {
            userList.add(usersList[i].jid)
            i++
        }
        startActivityForResult(Intent(this, if (BuildConfig.CONTACT_SYNC_ENABLED) NewContactsActivity::class.java else UserListActivity::class.java)
            .putExtra(com.contusfly.utils.Constants.ADD_PARTICIAPANTS, true)
            .putExtra(com.contusfly.utils.Constants.FROM_GROUP_INFO, true)
            .putExtra(com.contusfly.utils.Constants.GROUP_ID, groupProfileDetails.jid)
            .putExtra(Constants.TITLE, getString(R.string.add_participants)), Constants.ACTIVITY_REQ_CODE)
    }

    /**
     * This method is created to view the group image in view page
     */
    private fun openImageView() {
        if (groupProfileDetails.image!!.isNotEmpty()) {
            startActivity(
                Intent(this, ImageViewActivity::class.java)
                    .putExtra(com.contusfly.utils.Constants.GROUP_OR_USER_NAME, groupProfileDetails.getDisplayName())
                    .putExtra(com.contusfly.utils.Constants.GROUP_ICON_EDIT, true)
                    .putExtra(Constants.MEDIA_URL, Utils.returnEmptyStringIfNull(groupProfileDetails.image))
                    .putExtra(Constants.GROUP_ID, groupProfileDetails.jid)
            )
        }
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        refreshParticipantData(jid)
    }

    private fun refreshParticipantData(jid: String) {
        val isGroupMember = ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid, jid)
        if (isGroupMember) {
            val index = groupMembersList.indexOfFirst { it.jid == jid }
            if (index.isValidIndex()) {
                groupMembersList[index] = ProfileDetailsUtils.getProfileDetails(jid)!!
                groupMembersList[index].isGroupAdmin=GroupManager.isAdmin(groupProfileDetails.jid,jid)
                groupMembersAdapter.notifyItemChanged(index)
            }
        }
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        refreshParticipantData(jid)
    }

    /**
     * Returns the menu for the user based on the clicked user type and current user admin rights
     *
     * @param profileDetails Clicked group user
     * @return String[] Menu array
     */
    private fun getUserClickMenu(profileDetails: ProfileDetails): Array<String> {
        isUnknownParticipant = false
        val arrayGroupMenu: Array<String> = if ( ChatType.TYPE_BROADCAST_CHAT == groupProfileDetails.getChatType())
                resources.getStringArray(R.array.array_broadcast_user_menu)
            else if (ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isAdmin(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid())) {
            if (profileDetails.isGroupAdmin)
                resources.getStringArray(R.array.array_group_admin_user_menu)
            else
                resources.getStringArray(R.array.array_group_user_menu)
            } else
                resources.getStringArray(R.array.array_group_user_menu_noremove)
        return arrayGroupMenu
    }

    /**
     * Called this method to Remove the user from group.
     */
    private fun removeUserFromGroup() {
        if (AppUtils.isNetConnected(this)) {
            progressDialog = TimerProgressDialog(this)
            progressDialog.showProgress()
            val removingParticipantJid = groupMembersList[lastKnownPosition].jid
            GroupManager.removeMemberFromGroup(groupProfileDetails.jid!!, removingParticipantJid) { isSuccess, _, _ ->
                progressDialog.dismiss()
                if (isSuccess) {
                    loadAdapterData()
                    loadGroupExistence()
                } else {
                    CustomToast.show(this, getString(R.string.error_occurred_label))
                }
            }
        } else CustomToast.show(this, getString(R.string.msg_no_internet))
    }

    /**
     * Show the dialog for remove admin or make admin
     */
    private fun doAdminActions() {
        val clickedUserIsAdmin = ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isAdmin(groupProfileDetails.jid!!, usersList[lastKnownPosition].jid)
        if (clickedUserIsAdmin) {
            // Remove admin
            dialogMode = DIALOGMODE.REMOVE_ADMIN
            showConfirmDialog(getString(R.string.msg_are_you_sure_remove_admin))
        } else {
            // Make admin
            if(ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid())) {
                dialogMode = DIALOGMODE.MAKE_ADMIN
                showConfirmDialog(getString(R.string.msg_are_you_sure_make_admin))
            }
            else{
                CustomToast.show(context,getString(R.string.mgs_not_a_group_member))
            }
        }
    }

    /**
     * Called this method to handle the make admin process
     */
    private fun makeAdmin() {
        try {
            if (AppUtils.isNetConnected(this)) {
                progressDialog = TimerProgressDialog(this)
                progressDialog.showProgress()
                GroupManager.makeAdmin(groupProfileDetails.jid!!, usersList[lastKnownPosition].jid, object :
                    ChatActionListener {
                    override fun onResponse(isSuccess: Boolean, message: String) {
                        progressDialog.dismiss()
                        if (isSuccess)
                            loadAdapterData()
                        else
                            CustomToast.show(context,
                                getString(R.string.error_occurred_label)
                            )
                    }
                })
            } else CustomToast.show(this, getString(R.string.msg_no_internet))
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    private fun revokeAccessForProfileImage() {
        if (AppUtils.isNetConnected(this)) {
            progressDialog = DoProgressDialog(this)
            progressDialog.showProgress()
            GroupManager.removeGroupProfileImage(groupProfileDetails.jid!!, object : ChatActionListener {
                override fun onResponse(isSuccess: Boolean, message: String) {
                    progressDialog.dismiss()
                    if (isSuccess){
                        groupProfileDetails.image = ""
                        MediaUtils.loadImage(this@GroupInfoActivity, null,
                            binding.profileImage, ContextCompat.getDrawable(this@GroupInfoActivity, R.drawable.ic_grp_bg))
                        }
                    else
                        CustomToast.show(this@GroupInfoActivity, message)
                }
            })
        } else {
            CustomToast.show(this, getString(R.string.msg_no_internet))
        }
    }


    /**
     * Validate the participant affiliation and show/hide the option
     */
    private fun validateParticipantOption() {
        isGroupAdmin = ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isAdmin(groupProfileDetails.jid!!, SharedPreferenceManager.getCurrentUserJid())
        if (ChatType.TYPE_BROADCAST_CHAT == groupProfileDetails.getChatType() || isGroupAdmin) {
            binding.addParticipant.text = context!!.resources.getString(R.string.add_participants)
            binding.addParticipant.isEnabled = true
            showOrHideAddParticipant(true)
        } else {
            binding.addParticipant.text = context!!.resources.getString(R.string.label_participants)
            binding.addParticipant.isEnabled = false
            showOrHideAddParticipant(false)
        }
    }

    /**
     * Loads the Group adapter data into the list
     */
    private fun loadAdapterData() {
        groupProfileDetails.let {
            if(editIcon!=null)
                setEditPrivelages()
            GroupManager.getGroupMembersList(false, it.jid) { isSuccess, _, data ->
                usersList = if (isSuccess) {
                    val groupsMembersProfileList = data[Constants.DATA] as ArrayList<ProfileDetails>
                    if (groupsMembersProfileList.isEmpty())
                        ArrayList()
                    else
                        groupsMembersProfileList
                } else {
                    ArrayList()
                }
                usersList = ProfileDetailsUtils.sortGroupProfileList(usersList)

                validateParticipantOption()
                val participantsCountBuilder = StringBuilder().append(usersList.size).append(" ")
                    .append(resources.getString(if (usersList.size > 1) R.string.members else R.string.member))
                binding.subTitle.text = participantsCountBuilder
                groupMembersList.clear()
                groupMembersList.addAll(usersList)
                groupMembersAdapter.notifyDataSetChanged()
                invalidateOptionsMenu()
            }
        }
    }

    private fun showOrHideAddParticipant(isShowing: Boolean) {
        if (isShowing) {
            binding.addParticipant.visibility = View.VISIBLE
            binding.addParticipantsDivider.visibility = View.VISIBLE
        } else {
            binding.addParticipant.visibility = View.GONE
            binding.addParticipantsDivider.visibility = View.GONE
        }
    }

    /**
     * Display the alert dialog based on the request
     */
    private fun exitOrDeleteGroup() {
        try {
            dialogMode = when {
                ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid()) -> {
                    mDialog!!.showAlertDialog(
                        getString(R.string.msg_are_you_sure_exit),
                        getString(R.string.action_leave),
                        getString(R.string.action_cancel),
                        CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
                    DIALOGMODE.EXIT_GROUP
                }
                 groupProfileDetails.isGroupProfile -> {
                     if(!ChatManager.getAvailableFeatures().isDeleteChatEnabled) {
                         binding.leaveGroup.visibility=View.GONE
                         return
                     }
                    mDialog!!.showAlertDialog(
                        getString(R.string.msg_are_you_sure_delete),
                        getString(R.string.action_delete),
                        getString(R.string.action_cancel),
                        CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
                    DIALOGMODE.DELETE_GROUP
                }
                else -> {
                    mDialog!!.showAlertDialog(
                        getString(R.string.msg_are_you_sure_delete_broadcast),
                        getString(R.string.action_delete),
                        getString(R.string.action_cancel),
                        CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false)
                    DIALOGMODE.DELETE_GROUP
                }
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Called this method to handle the logged in user Exit from group.
     */
    private fun exitFromGroup() {
        try {
            if (AppUtils.isNetConnected(this)) {
                progressDialog = TimerProgressDialog(this)
                progressDialog.showProgress()
                GroupManager.leaveFromGroup(groupProfileDetails.jid!!) { isSuccess, _, _ ->
                    progressDialog.dismiss()
                    if (isSuccess) {
                        loadAdapterData()
                        loadGroupExistence()
                    } else
                        CustomToast.show(
                            context,
                            getString(R.string.error_occurred_label)
                        )
                }
            } else CustomToast.show(this, getString(R.string.msg_no_internet))
        } catch (e: Exception) {
            LogMessage.e(e)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        groupProfileDetails = ProfileDetailsUtils.getProfileDetails(groupProfileDetails.jid)!!
        groupProfileDetails.let {
            if (it.isAdminBlocked) navigateToDashboard()
            else {
                /* setting IS_ACTIVITY_STARTED_FOR_RESULT to false for  xmpp disconnection */
                ChatManager.isActivityStartedForResult = false
                if (resultCode == Activity.RESULT_OK)
                    handleOnActivityResult(requestCode, data)
                else if (resultCode == Activity.RESULT_CANCELED)
                    isImageUpdate = false
            }
        }
    }

    /**
     * Handle the activity result if the result code is success
     *
     * @param requestCode Request code from the Activity
     * @param intentData  Instance of the Intent
     */
    private fun handleOnActivityResult(requestCode: Int, intentData: Intent?) {
        when (requestCode) {
            Constants.ACTIVITY_REQ_CODE -> if(AppUtils.isNetConnected(context)) addSelectedUsers(intentData) else CustomToast.show(context,getString(R.string.msg_no_internet))
            Constants.EDIT_REQ_CODE -> handleEditGroupName(intentData)
            RequestCode.TAKE_PHOTO -> handleCameraIntent(mFileCameraTemp)
            RequestCode.FROM_GALLERY -> handleGalleryIntent(intentData)
            RequestCode.CROP_IMAGE -> if(ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid,SharedPreferenceManager.getCurrentUserJid()))
                    uploadImage()
                else
                    CustomToast.show(context,getString(R.string.mgs_not_a_group_member))
        }
    }

    private fun handleEditGroupName(intentData: Intent?) {
        if (intentData!!.getStringExtra(Constants.TITLE) != groupProfileDetails.nickName) {
            if(intentData.getStringExtra(Constants.TITLE).toString().trim().isNotEmpty()) {
                if (ChatManager.getAvailableFeatures().isGroupChatEnabled && GroupManager.isMemberOfGroup(groupProfileDetails.jid, SharedPreferenceManager.getCurrentUserJid()))
                    updateGroupInfo(intentData.getStringExtra(Constants.TITLE), groupProfileDetails.image)
                else CustomToast.show(context, getString(R.string.mgs_not_a_group_member))
            } else CustomToast.show(context, getString(R.string.msg_group_name_cannot_be_empty))
        }
    }

    /**
     * Handle selected participants to add into group/broadcast
     *
     * @param intentData Instance of the Intent
     */
    private fun addSelectedUsers(intentData: Intent?) {
        // Check whether it is group or broadcast
        if ( groupProfileDetails.isGroupProfile)
            intentData!!.getStringArrayListExtra(USERS_JID)?.let { addGroupParticipants(it) }
    }

    /**
     * Adds selected participants to group
     *
     * @param users List of users to add
     */
    private fun addGroupParticipants(users: MutableList<String>) {
        if (Utils.isListExist(users)) {
            progressDialog = DoProgressDialog(this)
            progressDialog.showProgress()
            try {
                GroupManager.addUsersToGroup(groupProfileDetails.jid!!, users) { isSuccess, _, data ->
                    progressDialog.dismiss()
                    users.clear()
                    if (isSuccess) {
                        loadAdapterData()
                        loadGroupExistence()
                    } else
                        CustomToast.show(context, data.getMessage())
                }
            } catch(e:Exception) {
                LogMessage.e(TAG,e.toString())
            }
        }
    }

    /**
     * Update the group info to the server.
     *
     * @param name   Name of the group
     * @param imgUrl Url of the Group image
     */
    private fun updateGroupInfo(name: String?, imgUrl: String?) {

        try {

            if (!::progressDialog.isInitialized || !progressDialog.isShowing) {
                progressDialog = DoProgressDialog(this)
                progressDialog.showProgress()
            }
            if (imgUrl != null && imgUrl.startsWith(storagePrefix)
                && File(Utils.returnEmptyStringIfNull(imgUrl)).exists()) {
                MediaUtils.loadImageWithGlide(this, imgUrl, binding.profileImage,
                    ContextCompat.getDrawable(this, R.drawable.ic_grp_bg)
                )
            } else {
                MediaUtils.loadImage(this, imgUrl,
                    binding.profileImage, ContextCompat.getDrawable(this, R.drawable.ic_grp_bg)
                )
            }
            /*
             * Check if the type is group or broadcast
             */
            if (groupProfileDetails.isGroupProfile) {
                GroupManager.updateGroupName(groupProfileDetails.jid!!, name!!, object : ChatActionListener {
                        override fun onResponse(isSuccess: Boolean, message: String) {
                            progressDialog.dismiss()
                            loadGroupNameAndImage()
                        }
                    })
            }
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Display the group name and image from the Roster instance
     */
    private fun loadGroupNameAndImage() {

        groupProfileDetails = ProfileDetailsUtils.getProfileDetails(groupProfileDetails.jid)!!
        groupProfileDetails.let {
            val groupImage = Utils.returnEmptyStringIfNull(it.image)

            // Checks if chat type is group or broadcast to set the default image
            if (!isImageUpdate) {
                if (groupImage!!.startsWith(storagePrefix) && File(Utils.returnEmptyStringIfNull(groupImage)).exists()) {
                    MediaUtils.loadImageWithGlide(this, groupImage, binding.profileImage,
                        getDefaultDrawable(it.getChatType()))
                } else {
                    MediaUtils.loadImage(this, if (groupImage.isNullOrBlank()) null else groupImage, binding.profileImage,
                        getDefaultDrawable(it.getChatType()))
                }
            }
            // Hide the mute/un mute option for broadcast
            if (!it.isGroupProfile) binding.groupMute.visibility = View.GONE

            validateMuteStatus(it)
        }

        setToolbarTitle(groupProfileDetails.getDisplayName())
    }

    /**
     * Validate group mute status and set in view
     *
     * @param groupInfo ProfileDetails of the group
     */
    private fun validateMuteStatus(groupInfo: ProfileDetails) {
        binding.muteSwitch.isChecked = groupInfo.isMuted
    }

    /**
     * Handle the result of the camera intent and crop the chosen image to update the group icon.
     *
     * @param tempFile An File, which has the result of camera.
     */
    private fun handleCameraIntent(tempFile: File?) {
        if (tempFile != null) {
            try {
                val inputStream = contentResolver.openInputStream(Uri.fromFile(tempFile))
                if (inputStream != null) {
                    val fileOutputStream = FileOutputStream(mFileTemp)
                    ImagePopUpUtils.copyStream(inputStream, fileOutputStream)
                    fileOutputStream.close()
                    inputStream.close()
                    mFileTemp?.let { CommonUtils.cropImage(this, it) }
                }
            } catch (e: IOException) {
                LogMessage.e(Constants.TAG, e)
            }
        }
    }

    /**
     * Handle gallery intent and crop the image
     *
     * @param intentData Instance of the Intent
     */
    private fun handleGalleryIntent(intentData: Intent?) {
        try {
            val inputStream = contentResolver.openInputStream(intentData!!.data!!)
            val fileOutputStream = FileOutputStream(mFileTemp!!)
            ImagePopUpUtils.copyStream(inputStream, fileOutputStream)
            fileOutputStream.close()
            inputStream?.close()
            CommonUtils.cropImage(this, mFileTemp!!)
        } catch (e: Exception) {
            LogMessage.e(Constants.TAG, e)
        }
    }

    /**
     * Upload the image of the group for group image update
     */
    private fun uploadImage() {
        try {
            progressDialog = DoProgressDialog(this)
            progressDialog.showProgress()
            GroupManager.updateGroupProfileImage(groupProfileDetails.jid!!, mFileTemp!!, object : ChatActionListener {
                override fun onResponse(isSuccess: Boolean, message: String) {

                    progressDialog.dismiss()
                    if(!isSuccess) {
                        CustomToast.show(context, getString(R.string.error_occurred_label))
                    }else{
                        context?.let { MediaUtils.loadImageWithGlide(it, mFileTemp!!.absolutePath, binding.profileImage, ContextCompat.getDrawable(it, R.drawable.ic_grp_bg)) }
                    }
                    initFileObjects()
                }

            })
        } catch (e: Exception) {
            MediaUtils.loadImageWithGlide(this, groupProfileDetails.image, binding.profileImage, ContextCompat.getDrawable(this, R.drawable.ic_grp_bg))
            CustomToast.show(this, getString(R.string.error_occurred_label))
            LogMessage.e(Constants.TAG, e)
        }
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        if (groupProfileDetails.jid == jid && status) {
            navigateToDashboard()
        } else loadAdapterData()
    }

    private fun navigateToDashboard() {
        showToast(getString(R.string.group_block_message_label))
        startDashboardActivity()
    }

    override fun updateFeatureActions(features: Features) {
        groupFeatureValidation(features)
    }

    private fun groupFeatureValidation(availableFeatures: Features) {
        if(availableFeatures.isReportEnabled) {
            showViews(binding.reportGroup)
        } else {
            makeViewsGone(binding.reportGroup)
        }

        if(availableFeatures.isViewAllMediaEnabled) {
            showViews(binding.textMedia)
        } else {
            makeViewsGone(binding.textMedia)
        }

        loadGroupExistence()
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: PrivateChatAuthenticationModel?) {
        if(messageEvent!!.isAutheticationShow) {
            launchAuthPinActivity()
        }
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }

}