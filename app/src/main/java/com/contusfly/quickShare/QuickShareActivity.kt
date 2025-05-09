package com.contusfly.quickShare

import android.Manifest
import android.content.ContentResolver
import android.content.Intent
import android.media.MediaMetadataRetriever
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirrorflysdk.xmpp.chat.utils.LibConstants
import com.contusfly.*
import com.contusfly.activities.*
import com.contusfly.adapters.SectionedShareAdapter
import com.contusfly.chat.FileMimeType
import com.contusfly.chat.RealPathUtil
import com.contusfly.chat.ShareMessagesController
import com.contusfly.databinding.ActivityQuickShareBinding
import com.contusfly.helpers.PaginationScrollListener
import com.contusfly.helpers.UserListType
import com.contusfly.interfaces.RecyclerViewItemClick
import com.contusfly.models.ContactShareModel
import com.contusfly.models.FileObject
import com.contusfly.network.NetworkConnection
import com.contusfly.utils.*
import com.contusfly.viewmodels.ForwardMessageViewModel
import com.contusfly.views.*
import com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.api.ChatManager.biometricActivty
import com.mirrorflysdk.api.ChatManager.pinActivity
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.api.contacts.ContactManager
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.flycommons.ChatType
import com.mirrorflysdk.helpers.ResourceHelper
import com.mirrorflysdk.flydatabase.model.ContactMessage
import com.mirrorflysdk.models.Contact
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.text.DecimalFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class QuickShareActivity : BaseActivity(),
    FilesDialogFragment.DialogFragmentInterface,
    CommonDialogClosedListener {

    private lateinit var quickShareBinding: ActivityQuickShareBinding

    private val CONTACT = "text/x-vcard"
    private val TEXT = "text/plain"
    private val USERS = "USERS"

    private var permissionDenied = false

    private var isFileValidationsVerified = true

    private val SUPPORTED_IMAGE_VIDEO_FORMATS = arrayOf("jpg", "jpeg", "png", "webp", "gif", "mp4", "mkv", "mov", "wmv", "avi", "flv")
    private val supportedFormats = arrayOf("pdf", "txt", "rtf", "xls", "ppt", "pptx", "zip", "rar", "xlsx", "doc", "docx", "wav", "mp3", "mp4", "mkv", "aac", "jpg", "jpeg", "png", "webp", "gif", "pptx", "csv")
    private var formats = listOf(*supportedFormats)
    private var videoImageFormats = listOf(*SUPPORTED_IMAGE_VIDEO_FORMATS)

    private var searchKey = Constants.EMPTY_STRING
    private var mUserListType = UserListType.USER_LIST

    private var toUserJid:String=""
    private var isGoToMediaPage:Boolean = false

    private var mediaFileList = ArrayList<FileObject>()
    private var otherFileList = ArrayList<FileObject>()
    private var uriList = java.util.ArrayList<Uri>()
    private var userIdList = java.util.ArrayList<String>()
    private var jidList = java.util.ArrayList<String>()

    /**
     * The handler to delay the search
     */
    private lateinit var mHandler: Handler

    private val selectedUsersWithNames = linkedMapOf<String, String>()

    private var selectedProfileDetails = ArrayList<ProfileDetails>()

    /**
     * List holds the media files
     */
    var fileList: ArrayList<FileObject>? = null
    private var contactShareModels: ArrayList<ContactShareModel>? = null

    /**
     * Dialog to show Invalid media files
     */
    private var dialogFragment: DialogFragment? = null
    var i = 0

    /**
     * Adapter for quick share user selection List
     */
    private lateinit var mQuickShareAdapter: SectionedShareAdapter
    private lateinit var mSearchQuickShareAdapter: SectionedShareAdapter

    private val viewModel: ForwardMessageViewModel by viewModels()

    /**
     * Holds the type of incoming share type
     */
    @ShareType
    private var shareType: String? = null
    private var noOfFiles = 0
    private var isMediaScanSuccess = false

    /**
     * The progress dialog of the activity When run the background tasks
     */
    private var progressDialog: DoProgressDialog? = null

    private var commonAlertDialog: CommonAlertDialog? = null

    private var videoLimit: Int = Constants.MAX_VIDEO_UPLOAD_SIZE
    private var audioLimit: Int = Constants.MAX_AUDIO_SIZE_LIMIT
    private var fileLimit: Int = Constants.MAX_DOCUMENT_UPLOAD_SIZE
    private var imageLimit: Int = Constants.MAX_DOCUMENT_UPLOAD_SIZE

    internal lateinit var intent: Intent

    /**
     * View to the files number
     */
    @Inject
    lateinit var shareMessagesController: ShareMessagesController

    private val permissionAlertDialog: PermissionAlertDialog by lazy { PermissionAlertDialog(this) }

    private val galleryPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val readPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if(readPermissionGranted) {
            handleIntent()
        } else if(ChatUtils.checkMediaPermission(this, Manifest.permission.READ_MEDIA_IMAGES) && ChatUtils.checkMediaPermission(this, Manifest.permission.READ_MEDIA_VIDEO)){
            handleIntent()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        SharedPreferenceManager.setBoolean(Constants.QUICK_SHARE, true)
        checkConditionForPin()
        super.onCreate(savedInstanceState)
        if (!SharedPreferenceManager.getBoolean(Constants.IS_LOGGED_IN)) {
            startActivity(Intent(this, StartActivity::class.java))
            Toast.makeText(context, getString(R.string.need_to_login), Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        quickShareBinding = ActivityQuickShareBinding.inflate(layoutInflater)
        setContentView(quickShareBinding.root)

        progressDialog = DoProgressDialog(this)
        commonAlertDialog = CommonAlertDialog(this)
    }

    override fun userUpdatedHisProfile(jid: String) {
        super.userUpdatedHisProfile(jid)
        updateProfileDetails(jid)
    }

    /**
     * To handle callback of any user's profile deleted
     */
    override fun userDeletedHisProfile(jid: String) {
        super.userDeletedHisProfile(jid)
        mQuickShareAdapter.removeProfileDetails(jid)
        mSearchQuickShareAdapter.removeProfileDetails(jid)
        viewModel.removeProfileDetails(jid)
        viewModel.removeSearchProfileDetails(jid)
        selectedUsersWithNames.remove(jid)
        selectedProfileDetails.removeIf { it.jid == jid }
        quickShareBinding.selectedUsers.text = getSelectedUserNames()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        fileList = ArrayList()
        initViews()
        setUpAlertDialogListeners()
        setObservers()
        observeNetworkListener()
        viewModel.loadForwardChatList(null)
        if (checkPermission()) {
            //handle sharing only when permissions are granted
            handleIntent()
        }

    }

    private fun setObservers() {
        viewModel.shareModelListLiveData.observe(this) {
            it?.let {
                mQuickShareAdapter.setProfileDetails(it)
                quickShareBinding.viewListRecent.adapter = mQuickShareAdapter
                mQuickShareAdapter.notifyDataSetChanged()
            }
        }

        viewModel.updatedProfile.observe(this) {
            if (it.first.isValidIndex())
                mQuickShareAdapter.addProfileDetails(it.first, it.second)
        }

        viewModel.userList.observe(this) { userList ->
            userList?.let {
                mQuickShareAdapter.addProfileList(userList)

            }
        }

        viewModel.addLoader.observe(this) {
            if (it)
                mQuickShareAdapter.addLoadingFooter()
        }

        viewModel.removeLoader.observe(this) {
            if (it)
                mQuickShareAdapter.removeLoadingFooter()
        }

        viewModel.searchListLiveData.observe(this) {
            it?.let {
                mSearchQuickShareAdapter.setProfileDetails(it)
                mSearchQuickShareAdapter.notifyDataSetChanged()
            }
        }

        viewModel.searchUserList.observe(this ) { userList ->
            userList?.let {
                mSearchQuickShareAdapter.addProfileList(userList)
            }
        }

        viewModel.addSearchLoader.observe(this) {
            if (it)
                mSearchQuickShareAdapter.addLoadingFooter()
        }

        viewModel.removeSearchLoader.observe(this) {
            if (it)
                mSearchQuickShareAdapter.removeLoadingFooter()
        }

        viewModel.fetchingError.observe(this) {
            if (it)
                CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }

    private fun observeNetworkListener() {
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { connected ->
            if (connected && viewModel.fetchingError.value == true) { //If user list fetch failed then re-fetch user list when internet is reconnected
                if (searchKey.isBlank()) {
                    mQuickShareAdapter.addLoadingFooter()
                    viewModel.loadUserList()
                } else {
                    mSearchQuickShareAdapter.addLoadingFooter()
                    viewModel.searchUserList(searchKey)
                }
            }
        }
    }

    private fun setAdapterBasedOnSearchType() {
        if (mUserListType == UserListType.USER_LIST && (quickShareBinding.viewListRecent.adapter as SectionedShareAdapter).getSearchKey().isNotBlank()) {
            quickShareBinding.viewListRecent.adapter = mQuickShareAdapter
        } else if (mUserListType == UserListType.SEARCH && (quickShareBinding.viewListRecent.adapter as SectionedShareAdapter).getSearchKey().isBlank()) {
            quickShareBinding.viewListRecent.adapter = mSearchQuickShareAdapter
        }
    }

    private fun setUpAlertDialogListeners() {
        commonAlertDialog?.setOnDialogCloseListener(this)
    }

    private fun initViews() {
        mHandler = Handler(Looper.getMainLooper())
        quickShareBinding.toolBar.setTitle(R.string.quick_share_title)
        setSupportActionBar(quickShareBinding.toolBar)
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_close)

        /**
         * Empty view for the recent chat.
         */
        val mEmptyView = quickShareBinding.emptyData.textEmptyView
        mEmptyView.text = getString(R.string.msg_no_results)
        mEmptyView.setTextColor(ResourceHelper.getColor(R.color.color_text_grey))

        mQuickShareAdapter = SectionedShareAdapter(context!!, commonAlertDialog!!, onItemClickListener)
        mSearchQuickShareAdapter = SectionedShareAdapter(context!!, commonAlertDialog!!, onItemClickListener)

        quickShareBinding.viewListRecent.apply {
            layoutManager = LinearLayoutManager(context)
            setEmptyView(mEmptyView)
            itemAnimator = null
            setScrollListener(this, layoutManager as LinearLayoutManager)
        }
    }

    private fun setScrollListener(
        recyclerView: CustomRecyclerView,
        layoutManager: LinearLayoutManager
    ) {
        recyclerView.addOnScrollListener(object : PaginationScrollListener(
            layoutManager,
            handler = mHandler
        ) {
            override fun loadMoreItems() {
                if (searchKey.isBlank())
                    viewModel.loadUserList()
                else
                    viewModel.searchUserList(searchKey)
            }

            override fun isLastPage(): Boolean {
                return if (searchKey.isBlank())
                    viewModel.lastPageFetched()
                else
                    viewModel.searchLastPageFetched()
            }

            override fun isFetching(): Boolean {
                return if (searchKey.isBlank())
                    viewModel.getUserListFetching()
                else
                    viewModel.getSearchUserListFetching()
            }
        })
    }

    /**
     * Filter the list from the search key
     *
     */
    fun filterList() {
        mUserListType = if (searchKey.isEmpty()) UserListType.USER_LIST else UserListType.SEARCH
        setAdapterBasedOnSearchType()
        mSearchQuickShareAdapter.setSearchKey(searchKey)
        if (searchKey.isNotBlank())
            viewModel.searchProfileList(searchKey)
    }

    /**
     * Intent must be handled only when storage permissions are granted
     */
    private fun handleIntent() {
        /**
         * Handle incoming intent
         */
        intent = getIntent()
        /**
         * holds the type on incoming URI
         */
        val receivedType = intent.type
        when {
            receivedType != null && receivedType.equals(CONTACT, ignoreCase = true) -> {
                shareType = ShareType.CONTACT
                val uri = intent.extras!![Intent.EXTRA_STREAM] as Uri?
                contactShareModels = generateContactShareModel(parseVcard(uri!!))
            }
            receivedType != null && receivedType.equals(TEXT, ignoreCase = true) -> {
                val fileURI = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
                if (fileURI == null)
                    shareType = ShareType.TEXT
                else
                    handleSingleFileShare()
            }
            intent.action != null && intent.action.equals(Intent.ACTION_SEND, ignoreCase = true) -> handleSingleFileShare()
            intent.action != null && intent.action.equals(Intent.ACTION_SEND_MULTIPLE, ignoreCase = true) -> handleMultipleFileShare()
            else -> Toast.makeText(applicationContext, "Unsupported Format", Toast.LENGTH_LONG).show()
        }

        clickListeners()

    }

    private fun checkConditionForPin() {
        if (!AppLifecycleListener.isForeground && AppLifecycleListener.isPinEnabled || (AppLifecycleListener.fromOnCreate && AppLifecycleListener.isPinEnabled)) {
            AppLifecycleListener.isFromQuickShareForBioMetric = true
            AppLifecycleListener.isFromQuickShareForPin = true
            openPinActivity()
        }
    }

    private fun openPinActivity() {
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val pinIntent = Intent(this, biometricActivty)
            pinIntent.putExtra(Constants.GO_TO, Constants.QUICK_SHARE)
            pinIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ChatManager.applicationContext.startActivity(pinIntent)
        } else {
            val pinIntent = Intent(this, pinActivity)
            pinIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            pinIntent.putExtra(Constants.GO_TO, Constants.QUICK_SHARE)
            ChatManager.applicationContext.startActivity(pinIntent)
        }
    }

    private fun handleSingleFileShare() {
        progressDialog!!.showProgress()
        i = 1
        noOfFiles = 1
        shareType = ShareType.MEDIA
        val fileObject = FileObject()
        val fileURI = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
        val extraText = intent.getStringExtra(Intent.EXTRA_TEXT)
        RealPathUtil.setIntentType(getIntent().type!!)
        if (extraText != null) fileObject.caption = extraText
        else fileObject.caption = ""

        convertFileSchemeToUri(fileURI!!, fileObject, i)
    }

    private fun handleMultipleFileShare() {
        progressDialog!!.showProgress()
        shareType = ShareType.MEDIA
        val urlList = intent.getParcelableArrayListExtra<Uri>(Intent.EXTRA_STREAM)
        noOfFiles = urlList!!.size
        i = 0
        if (urlList.size > 10) {
            progressDialog!!.dismiss()
            Toast.makeText(applicationContext, R.string.msg_max_file_share, Toast.LENGTH_LONG).show()
            onBackPressed()
        } else {
            for (uri in urlList) {
                i++
                Log.d("URI_LIST", uri.toString())
                val fileObject = FileObject()
                convertFileSchemeToUri(uri, fileObject, i)
            }
        }
    }

    fun clickListeners() {
        quickShareBinding.next.setOnClickListener {
            val hasSingleChat = selectedProfileDetails.count { it.getChatType() == ChatType.TYPE_CHAT }
            if (FlyCore.isBusyStatusEnabled() && hasSingleChat>0) {
                showBusyAlert()
                return@setOnClickListener
            }
            if (checkPermission()) {
                //handle sharing only when permissions are granted
                handleNextClick()
            }

        }
    }

    private fun handleNextClick() {
        if (selectedUsersWithNames.isEmpty()) {
            Toast.makeText(this, "Select at least one User to Share ", Toast.LENGTH_SHORT).show()
        } else {
            when {
                shareType === ShareType.TEXT -> {
                    progressDialog!!.showProgress()
                    composeTextMessage(intent.getStringExtra(Intent.EXTRA_TEXT))
                }
                shareType === ShareType.CONTACT -> {
                    if (ChatManager.getAvailableFeatures().isContactAttachmentEnabled)
                        goToContactPreview()
                    else {
                        CustomAlertDialog().showFeatureRestrictionAlert(this)
                        return
                    }
                }
                else -> shareFiles()
            }
        }
    }

    private fun shareFiles() {
         jidList = java.util.ArrayList<String>()
        for (key in selectedUsersWithNames.keys) {
            jidList.add(key)
        }
        if (isMediaScanSuccess && isFileValidationsVerified)
            shareFiles(jidList)
        else if (isFileValidationsVerified) Toast.makeText(this, "Media Scan Failed", Toast.LENGTH_SHORT).show()
    }

    private fun shareFiles(jidList: java.util.ArrayList<String>) {
        LogMessage.e(TAG,"SelectedUserList${jidList.size}")
        if (!isFeatureAvailableForFiles(fileList!!)) {
            CustomAlertDialog().showFeatureRestrictionAlert(this)
            return
        }
         mediaFileList = ArrayList<FileObject>()
         otherFileList = ArrayList<FileObject>()
         uriList = java.util.ArrayList<Uri>()
         userIdList= ArrayList<String>()
         userIdList = getSelectedUserIdList()
        for (fileObj in fileList!!) {
            if (videoImageFormats.contains(fileObj.fileExtension.toLowerCase())) {
                if (fileObj.uri != null) uriList.add(fileObj.uri!!)
                mediaFileList.add(fileObj)
            } else otherFileList.add(fileObj)
        }

        when {
            mediaFileList.isNotEmpty() -> {
                if (AppUtils.isNetConnected(this) && otherFileList.isNotEmpty())
                    sendOtherFiles(otherFileList, userIdList, false)
                else mediaFileList.addAll(otherFileList)
                privateChatUserCheckingForMediaPreviewPage()
            }
            otherFileList.isNotEmpty() -> {
                progressDialog = DoProgressDialog(this)
                progressDialog!!.showProgress()
                sendOtherFiles(otherFileList, userIdList, true)
            }
            else -> Toast.makeText(this, "No files selected", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isFeatureAvailableForFiles(fileObjects: java.util.ArrayList<FileObject>): Boolean {
        val features = ChatManager.getAvailableFeatures()
        val featureAvailable = true
        for (fileObject in fileObjects) {
            when (fileObject.fileMimeType) {
                FileMimeType.IMAGE -> if (!features.isImageAttachmentEnabled) return false
                FileMimeType.VIDEO -> if (!features.isVideoAttachmentEnabled) return false
                FileMimeType.AUDIO -> if (!features.isAudioAttachmentEnabled) return false
                FileMimeType.APPLICATION -> if (!features.isDocumentAttachmentEnabled) return false
            }
        }
        return featureAvailable
    }

    private fun sendOtherFiles(otherFileList: java.util.ArrayList<FileObject>, userIdList: java.util.ArrayList<String>, isNavigationEnable: Boolean) {
        if (AppUtils.isNetConnected(this)) {
            shareMessagesController.sendMediaMessagesForSingleUser(otherFileList, userIdList) {
                if (isNavigationEnable) {
                    progressDialog!!.dismiss()
                    navigateToAppropriateScreen(userIdList)
                    finish()
                }
            }
        } else if (isNavigationEnable) {
            progressDialog!!.dismiss()
            CustomToast.show(context, getString(R.string.msg_no_internet))
        }
    }

    private fun navigateToAppropriateScreen(userIdList: java.util.ArrayList<String>) {
        if (userIdList.size == 1) {
            val userId = userIdList[0]
            privateChatUserChecking(userId)
        } else if (userIdList.size > 1) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    /**
     * chat Acttivity to show whether the private chat status to be enabled or disabled...
     */
    private fun privateChatUserCheckingForMediaPreviewPage() {
        isGoToMediaPage=true
        val userIdList = getSelectedUserIdList()
        if(userIdList.size == 1 && ChatManager.isPrivateChat(userIdList.first())) {
            launchQuickSharePinActivity()
        } else {
            launchChatViewPage(Constants.EMPTY_STRING,isGoToMediaPage)
        }
    }

    /**
     * chat Acttivity to show whether the private chat status to be enabled or disabled...
     */
    private fun privateChatUserChecking(toUser: String) {
        toUserJid=toUser
        isGoToMediaPage=false
        if(ChatManager.isPrivateChat(toUser)) {
            launchQuickSharePinActivity()
        } else {
            launchChatViewPage(toUser,isGoToMediaPage)
        }
    }

    private fun launchChatViewPage(userId: String,isGoToMediaPage:Boolean) {
        if(!isGoToMediaPage) {
            startActivity(
                Intent(this, ChatActivity::class.java)
                    .putExtra(LibConstants.JID, userId)
                    .putExtra(Constants.CHAT_TYPE, ProfileDetailsUtils.getProfileDetails(userId)?.getChatType())
                    .putExtra(Constants.FROM_QUICK_SHARE, true))

        } else {
            startActivity(
                Intent(this, MediaPreviewActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .setType(intent.type)
                    .putExtra(Constants.INTENT_KEY_SHARE, "share")
                    .putStringArrayListExtra(Constants.INTENT_KEY_JID_LIST, jidList)
                    .putParcelableArrayListExtra("FILE_OBJECTS", mediaFileList)
                    .putStringArrayListExtra(USERS, userIdList)
                    .putExtra(Constants.INTENT_KEY_RECEIVED_FILES, uriList)
            )
            finish()
        }
    }

    private fun launchQuickSharePinActivity() {
        if (SharedPreferenceManager.getBoolean(Constants.BIOMETRIC)) {
            val intent = Intent(activity, BiometricActivity::class.java)
            intent.putExtra(Constants.GO_TO, Constants.PRIVATE_CHAT_LIST)
            quickShareActivityResultLauncher.launch(intent)
        } else  {
            val intent = Intent(activity, PinActivity::class.java)
            intent.putExtra(Constants.GO_TO, Constants.PRIVATE_CHAT_LIST)
            quickShareActivityResultLauncher.launch(intent)
        }

    }

    private var quickShareActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                launchChatViewPage(toUserJid,isGoToMediaPage)
            }
        }


    /**
     * Dialog action to show whether the busy status to be enabled or disabled...
     */
    private fun showBusyAlert() {
        commonAlertDialog!!.dialogAction = CommonAlertDialog.DialogAction.STATUS_BUSY
        commonAlertDialog!!.showAlertDialog(
            getString(R.string.msg_disable_busy_status), getString(R.string.action_yes),
            getString(R.string.action_no), CommonAlertDialog.DIALOGTYPE.DIALOG_DUAL, false
        )
    }

    private fun getStringSizeLengthFile(size: Long): String {
        val df = DecimalFormat("0.00")
        val sizeKb = 1024.0f
        val sizeMb = sizeKb * sizeKb
        val sizeGb = sizeMb * sizeKb
        val sizeTerra = sizeGb * sizeKb
        return when {
            size < sizeMb -> df.format((size / sizeKb).toDouble()) + " Kb"
            size < sizeGb -> df.format((size / sizeMb).toDouble()) + " Mb"
            size < sizeTerra -> df.format((size / sizeGb).toDouble()) + " Gb"
            else -> ""
        }
    }

    private fun milliSecondsToTimer(milliseconds: Long): String {
        var finalTimerString = ""
        var minuteString = ""
        val secondsString: String

        //Convert total duration into time
        val hours = (milliseconds / (1000 * 60 * 60)).toInt()
        val minutes = (milliseconds % (1000 * 60 * 60)).toInt() / (1000 * 60)
        val seconds = (milliseconds % (1000 * 60 * 60) % (1000 * 60) / 1000).toInt()
        // Add hours if there
        if (hours > 0) finalTimerString = hours.toString() + "h "
        if (minutes > 0) minuteString = minutes.toString() + "m "

        secondsString = seconds.toString() + "s"
        finalTimerString = finalTimerString + minuteString + secondsString

        return finalTimerString
    }

    private fun parseVcard(uri: Uri): ArrayList<ContactMessage> {
        val contactMessages = ArrayList<ContactMessage>()
        val cr = contentResolver
        var stream: InputStream? = null
        try {
            stream = cr.openInputStream(uri)
        } catch (e: FileNotFoundException) {
            LogMessage.e(TAG, e.message)
        }
        val fileContent = StringBuilder()
        var ch: Int
        try {
            while (stream!!.read().also { ch = it } != -1) fileContent.append(ch.toChar())
        } catch (e: IOException) {
            LogMessage.e(TAG, e.message)
        }
        val data = String(fileContent)
        val vcardString = data.split("BEGIN:VCARD".toRegex()).toTypedArray()
        for (vcard in vcardString) {
            val contactMessage = ContactMessage()
            contactMessage.phoneNumber = ArrayList()
            contactMessage.activeStatus = ArrayList()
            Log.d("LINE_VCARD", vcard)
            val lines = vcard.split("\\r?\\n".toRegex()).toTypedArray()
            for (l in lines) {
                if (l.contains("FN:")) contactMessage.name = l.substring(3)
                if (l.contains("TEL;")) {
                    contactMessage.phoneNumber.add(
                        l.replace(" ", "").replace("-", "").substring(l.indexOf(':') + 1)
                    )
                    contactMessage.activeStatus.add("0")
                }
            }
            if (contactMessage.phoneNumber.isNotEmpty()) {
                contactMessages.add(contactMessage)
                Log.d("CONTACT_MESSAGE", Utils.getGSONInstance().toJson(contactMessage))
            }
        }
        return contactMessages
    }

    override fun onResume() {
        super.onResume()
        AppLifecycleListener.isFromQuickShareForBioMetric = true
        AppLifecycleListener.isFromQuickShareForPin = true

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {

            if (ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                && ChatUtils.checkWritePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) && permissionDenied) {
                permissionDenied = false
                handleIntent()
            }

        } else {

            if (ChatUtils.checkMediaPermission(this, Manifest.permission.READ_MEDIA_IMAGES)
                && ChatUtils.checkWritePermission(this, Manifest.permission.READ_MEDIA_VIDEO) && permissionDenied) {
                permissionDenied = false
                handleIntent()
            }
        }

    }

    /**
     * @return if permission not granted return FALSE, else TRUE
     */
    private fun checkPermission(): Boolean {

        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {

            if (ChatUtils.checkMediaPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                && ChatUtils.checkWritePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionDenied = false
                true

        } else {
                permissionDenied = true
                MediaPermissions.requestStorageAccess(
                    this,
                    permissionAlertDialog,
                    galleryPermissionLauncher
                )
                false
            }

        } else {

            if (ChatUtils.checkMediaPermission(this, Manifest.permission.READ_MEDIA_IMAGES)
                && ChatUtils.checkWritePermission(this, Manifest.permission.READ_MEDIA_VIDEO)) {
                permissionDenied = false
                true
            } else {
                permissionDenied = true
                MediaPermissions.requestMediaFiles(
                    this,
                    permissionAlertDialog,
                    galleryPermissionLauncher)
                false
            }
        }

    }

    private fun getSelectedUserNames(): String {
        val stringBuilder = java.lang.StringBuilder()
        return if (selectedUsersWithNames.isEmpty()) {
            "No user selected"
        } else {
            for (name in selectedUsersWithNames.values) {
                stringBuilder.append(name)
                stringBuilder.append(", ")
            }
            val selectedNames = stringBuilder.toString()
            selectedNames.substring(0, selectedNames.length - 2)
        }
    }

    private fun getInvalidFiles(): List<FileObject> {
        val invalidFiles = java.util.ArrayList<FileObject>()
        for (fileObject in fileList!!) {
            for ((_, value) in fileObject.fileValidation!!.entries) {
                if (!value && !invalidFiles.contains(fileObject)) invalidFiles.add(fileObject)
            }
        }
        return invalidFiles
    }

    private fun initializeDialog() {
        val invalidList = getInvalidFiles()
        isFileValidationsVerified = true
        if (invalidList.isNotEmpty()) {
            isFileValidationsVerified = false
            val ft = supportFragmentManager.beginTransaction()
            val prev = supportFragmentManager.findFragmentByTag("dialog")
            if (prev != null) {
                ft.remove(prev)
            }
            ft.addToBackStack(null)
            dialogFragment = FilesDialogFragment.newInstance(invalidList)
            dialogFragment!!.isCancelable = false
            dialogFragment!!.show(ft, "dialog")
            progressDialog!!.dismiss()
        }
    }

    @FileMimeType
    private fun validateMimeType(mimeType: String?): String {
        return if (mimeType == null) {
            FileMimeType.UNSUPPORTED_FORMAT
        } else {
            when (mimeType.split("/".toRegex()).toTypedArray()[0]) {
                "video" -> FileMimeType.VIDEO
                "audio" -> FileMimeType.AUDIO
                "image" -> FileMimeType.IMAGE
                else -> FileMimeType.APPLICATION
            }
        }
    }

    private fun convertFileSchemeToUri(mainURI: Uri, fileObject: FileObject, i: Int) {
        try {
            val file = File(RealPathUtil.getRealPath(this, mainURI)!!)
            val fileAbsolutePath = file.absolutePath
            val fileExtension = fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf('.') + 1)
            fileObject.filePath = fileAbsolutePath
            fileObject.fileExtension = fileExtension
            MediaScannerConnection.scanFile(
                this,
                arrayOf(fileAbsolutePath),
                null
            ) { _: String, uri: Uri? ->
                // Use the FileProvider to get a content URI
                isMediaScanSuccess = true
                if (uri != null) {
                    isMediaScanSuccess = uri != null
                    fileObject.uri = uri!!
                    getFileNameSizeType(file.absolutePath, uri, fileObject, i)
                } else {
                    fileObject.uri = mainURI
                    getFileNameSizeType(file.absolutePath, mainURI, fileObject, i)
                }
            }
        } catch (e:Exception) {
            com.mirrorflysdk.flycommons.LogMessage.e(e)
        }
    }

    private fun convertInMb(fileSize: Long): Long {
        val fileInKb = fileSize / 1024
        return fileInKb / 1024
    }

    private fun getFileNameSizeType(
        absolutePath: String,
        uri: Uri,
        fileObject: FileObject,
        i: Int
    ) {
        val cr = applicationContext.contentResolver
        var fileName = ""
        val mimeType = getMimeTypeFromFilePath(uri)
        var fileSize = 0L
        val projection = arrayOf(
            MediaStore.MediaColumns.DISPLAY_NAME,
            MediaStore.MediaColumns.SIZE
        )
        cr.query(uri, projection, null, null, null)?.use { metaCursor ->
            if (metaCursor.moveToFirst()) {
                fileName = metaCursor.getString(0)
                fileSize = metaCursor.getLong(1)
            }else{
                val file = File(absolutePath)
                fileSize = file.length()
            }
        }

        var name = ""
        if (fileName.isEmpty()) {
            val split: List<String> = fileObject.filePath.split("/")
            name = split[split.size - 1]
            fileObject.name = name
        } else fileObject.name = fileName

        if (mimeType.isEmpty()) {
            val mime = name.substring(name.lastIndexOf('.') + 1)
            fileObject.fileMimeType = validateMimeType(mime)
        } else fileObject.fileMimeType = validateMimeType(mimeType)

        fileObject.size = fileSize

        if (fileObject.fileMimeType == FileMimeType.AUDIO || fileObject.fileMimeType == FileMimeType.VIDEO)
            getMediaDurationFromFilePath(absolutePath, fileObject)

        fileObject.caption = Constants.EMPTY_STRING

        validateFileObject(fileObject, i)
    }

    private fun getMimeTypeFromFilePath(uri: Uri): String {
        return if (ContentResolver.SCHEME_CONTENT == uri.scheme) {
            val cr = context!!.contentResolver
            cr.getType(uri) ?: ""
        } else {
            val fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri.toString())
            MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension.toLowerCase()) ?: ""
        }
    }

    private fun validateFileObject(fileObject: FileObject, i: Int) {
        val fileValidation = HashMap<String, Boolean>()
        fileValidation[FileValidation.TYPE] = true
        fileValidation[FileValidation.SIZE] = true
        fileValidation[FileValidation.DURATION] = true

        if (!formats.contains(fileObject.fileExtension.toLowerCase()) || fileObject.fileMimeType == FileMimeType.UNSUPPORTED_FORMAT)
            fileValidation[FileValidation.TYPE] = false

        validateVideoObject(fileObject, fileValidation)
        validateAudioObject(fileObject, fileValidation)
        validateImageObject(fileObject, fileValidation)
        validateFileObject(fileObject, fileValidation)
        fileObject.fileValidation = fileValidation
        fileObject.readableSize = getStringSizeLengthFile(fileObject.size)
        fileList!!.add(fileObject)

        if (i == noOfFiles) {
            Timer().schedule(1000) {
                progressDialog!!.dismiss()
                if (!AppLifecycleListener.isFromQuickShareForBioMetric || !AppLifecycleListener.isFromQuickShareForPin)
                    initializeDialog()
            }
        }
    }

    private fun validateVideoObject(fileObject: FileObject, fileValidation: HashMap<String, Boolean>) {
        if (fileObject.fileMimeType == FileMimeType.VIDEO) {
            val size: Long = convertInMb(fileObject.size)
            if (size > videoLimit) {
                fileValidation[FileValidation.SIZE] = false
            }
            fileObject.readableDuration = milliSecondsToTimer(fileObject.duration)
        }
    }

    private fun validateAudioObject(fileObject: FileObject, fileValidation: HashMap<String, Boolean>) {
        if (fileObject.fileMimeType == FileMimeType.AUDIO) {
            val size: Long = convertInMb(fileObject.size)
            if (size > audioLimit) {
                fileValidation[FileValidation.SIZE] = false
            }
            fileObject.readableDuration = milliSecondsToTimer(fileObject.duration)
        }
    }


    private fun validateFileObject(fileObject: FileObject, fileValidation: HashMap<String, Boolean>) {
        if (fileObject.fileMimeType == FileMimeType.APPLICATION) {
            val size: Long = convertInMb(fileObject.size)
            if (size > fileLimit) {
                fileValidation[FileValidation.SIZE] = false
            }
        }
    }

    private fun validateImageObject(fileObject: FileObject, fileValidation: HashMap<String, Boolean>) {
        if (fileObject.fileMimeType == FileMimeType.IMAGE) {
            val size: Long =convertInMb(fileObject.size)
            if (size > imageLimit) {
                fileValidation[FileValidation.SIZE] = false
            }
        }
    }

    private fun getMediaDurationFromFilePath(absolutePath: String, fileObject: FileObject) {
        try {
            val retriever = MediaMetadataRetriever()
            retriever.setDataSource(absolutePath)
            val duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            retriever.release()
            fileObject.duration = duration!!.toLong()
        }
        catch (e:RuntimeException){
            Log.e(TAG, "getMediaDurationFromFilePath: $e")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val menuItem = menu!!.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView
        searchView.queryHint = getString(R.string.action_search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(searchString: String): Boolean {
                searchKey = searchString.trim()
                mHandler.removeCallbacksAndMessages(null)
                mHandler.postDelayed({
                    filterList()
                }, 500)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finishQuickShare()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private val onItemClickListener = object : RecyclerViewItemClick {
        override fun onItemClicked(position: Int, profileDetails: ProfileDetails) {
            ContactManager.insertProfile(profileDetails)
            ProfileDetailsUtils.addContact(profileDetails)
            if (isSelected(profileDetails.jid)) {
                selectedUsersWithNames.remove(profileDetails.jid)
                selectedProfileDetails.remove(profileDetails)
            }
            else {
                if (!maxUserReached()) {
                    selectedUsersWithNames[profileDetails.jid] = profileDetails.getDisplayName()
                    selectedProfileDetails.add(profileDetails)
                }
            }

            quickShareBinding.selectedUsers.text = getSelectedUserNames()

            if (selectedUsersWithNames.isNotEmpty())
                quickShareBinding.next.visibility = View.VISIBLE
            else
                quickShareBinding.next.visibility = View.INVISIBLE
        }

        override fun isSelected(userId: String): Boolean {
            return selectedUsersWithNames.containsKey(userId)
        }
    }

    fun maxUserReached(): Boolean {
        val maxUserReached = selectedUsersWithNames.size >= Constants.MAX_FORWARD_USER_RESTRICTION
        if (maxUserReached)
            Toast.makeText(context, context!!.getString(R.string.msg_you_can_share_up_to_five_people), Toast.LENGTH_SHORT).show()
        return maxUserReached
    }

    override fun removeFile(fileObject: FileObject?) {
        fileList!!.remove(fileObject!!)
        if (fileList!!.isEmpty()) finishQuickShare()
    }

    override fun exitShare() {
        finishQuickShare()
    }

    override fun onDialogClosed(dialogType: CommonAlertDialog.DIALOGTYPE?, isSuccess: Boolean) {
        if (commonAlertDialog!!.dialogAction === CommonAlertDialog.DialogAction.STATUS_BUSY && isSuccess) {
            FlyCore.enableDisableBusyStatus(false) { isSuccess, _, data ->
                if (isSuccess) {
                    handleNextClick()
                } else {
                    CustomToast.show(context, data.getMessage())
                }
            }

        }
    }

    /*
    * Update Profile Details */
    private fun updateProfileDetails(userJid: String) {
        val position = viewModel.getPositionOfProfile(userJid)
        if (position >= 0) {
            val profileDetails = ProfileDetailsUtils.getProfileDetails(userJid)
            mQuickShareAdapter.updateProfileDetails(profileDetails)
            mSearchQuickShareAdapter.updateProfileDetails(profileDetails)
        } else
            viewModel.loadForwardChatList(userJid)
    }

    override fun listOptionSelected(position: Int) {
        //do nothing
    }

    private fun composeTextMessage(shareText: String?) {
        val userIdList = getSelectedUserIdList()
        shareMessagesController.sendTextMessage(shareText!!, userIdList)
        progressDialog!!.dismiss()
        navigateToAppropriateScreen(userIdList)
        finish()
    }

    private fun goToContactPreview() {
        startActivity(
            Intent(context, PickContactActivity::class.java)
                .putExtra("QUICK_SHARE", true)
                .putExtra("LIST", true)
                .putParcelableArrayListExtra("CONTACTS", contactShareModels)
                .putStringArrayListExtra(USERS, getSelectedUserIdList())
        )
        finish()
    }

    private fun generateContactShareModel(contactMessages: ArrayList<ContactMessage>): ArrayList<ContactShareModel> {
        val contactShareModelArrayList = java.util.ArrayList<ContactShareModel>()
        for (contactMessage in contactMessages) {
            val contactsList = java.util.ArrayList<Contact>()
            for (no in contactMessage.phoneNumber) {
                val c = Contact()
                c.contactName = contactMessage.name
                c.isSaved = false
                c.contactNos = no
                c.selected = 1
                contactsList.add(c)
            }
            contactShareModelArrayList.add(ContactShareModel(contactMessage.name, contactsList))
        }
        return contactShareModelArrayList
    }

    private fun getSelectedUserIdList(): java.util.ArrayList<String> {
        val userList = java.util.ArrayList<String>()
        for (userId in selectedUsersWithNames.keys) {
            userList.add(userId)
        }
        return userList
    }

    private fun finishQuickShare() {
        AppLifecycleListener.isFromQuickShareForBioMetric = false
        AppLifecycleListener.isFromQuickShareForPin = false
        if (Build.VERSION.SDK_INT >= 21) finishAndRemoveTask()
        else finish()
    }

    override fun onBackPressed() {
        finishQuickShare()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppLifecycleListener.isFromQuickShareForBioMetric = false
        AppLifecycleListener.isFromQuickShareForPin = false
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        updateSelectedUsers(status, jid)
    }


    override fun onSuperAdminDeleteGroup(groupJid: String, groupName: String) {
        super.onSuperAdminDeleteGroup(groupJid, groupName)
        clearDeletedGroupChatNotification(groupJid, context)
        updateSelectedUsers(status = true, groupJid)
        if (groupName.isNotEmpty())
            showToast(getString(R.string.deleted_by_super_admin, groupName))
    }

    private fun updateSelectedUsers(status: Boolean, jid: String) {
        if (status && selectedUsersWithNames.containsKey(jid)) {
            selectedUsersWithNames.remove(jid)
            selectedProfileDetails.removeIf { it.jid == jid }
        }
        mQuickShareAdapter.removeProfileDetails(jid)
        mSearchQuickShareAdapter.removeProfileDetails(jid)
        viewModel.removeProfileDetails(jid)
        viewModel.removeSearchProfileDetails(jid)
        quickShareBinding.selectedUsers.text = getSelectedUserNames()
    }
}