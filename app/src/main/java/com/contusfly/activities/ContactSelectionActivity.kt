package com.contusfly.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.contusfly.R
import com.contusfly.activities.parent.ChatParent
import com.contusfly.adapters.ContactSelectionAdapter
import com.contusfly.adapters.ContactSelectionPreviewAdapter
import com.contusfly.chat.MessagingClient
import com.contusfly.chat.ReplyHashMap
import com.contusfly.databinding.ActivityContactSelectionBinding
import com.contusfly.emptyString
import com.contusfly.models.DeviceContactModel
import com.contusfly.models.PhoneNumber
import com.contusfly.models.PrivateChatAuthenticationModel
import com.contusfly.utils.Constants
import com.contusfly.viewmodels.ContactSelectionViewModel
import com.mirrorflysdk.views.CustomToast
import dagger.android.AndroidInjection
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.ArrayList
import javax.inject.Inject

class ContactSelectionActivity : BaseActivity() {

    private lateinit var contactSelectionBinding: ActivityContactSelectionBinding

    private val contactSelectionViewModel: ContactSelectionViewModel by viewModels()

    lateinit var toUser: String

    lateinit var chatType: String

    @Inject
    lateinit var messagingClient: MessagingClient

    /**
     * Used for search
     */
    private var searchKey: String = emptyString()

    private val contactSectionAdapter: ContactSelectionAdapter by lazy {
        ContactSelectionAdapter(this, contactSelectionViewModel.contactsList, contactSelectionViewModel.selectedContactList)
    }

    private val contactSelectionPreviewAdapter: ContactSelectionPreviewAdapter by lazy {
        ContactSelectionPreviewAdapter(this, contactSelectionViewModel.selectedContactList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        contactSelectionBinding = ActivityContactSelectionBinding.inflate(layoutInflater)
        setContentView(contactSelectionBinding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        initViews()
        getIntentData()
        setObservers()

        contactSelectionViewModel.getLocalContactUserProfiles(this)
    }

    private fun setObservers() {
        contactSelectionViewModel.contactsListLoaded.observe(this, {
            contactSectionAdapter.notifyDataSetChanged()
            contactSelectionBinding.contactsRecyclerView.setEmptyView(contactSelectionBinding.txt.textEmptyView)
        })

        contactSelectionViewModel.contactsSelectionReachedMaximum.observe(this, {
            showMaxRestrictionToast(it)
        })

        contactSelectionViewModel.contactDiffResult.observe(this, { diffUtilResult ->
            // Save Current Scroll state to retain scroll position after DiffUtils Applied
            val previousState = contactSelectionBinding.selectedContactsRecyclerView.layoutManager?.onSaveInstanceState() as Parcelable
            diffUtilResult.dispatchUpdatesTo(contactSelectionPreviewAdapter)
            contactSelectionBinding.selectedContactsRecyclerView.layoutManager?.onRestoreInstanceState(previousState)
            contactSelectionBinding.toolBar.textSelectedContact.text = String.format(getString(R.string.label_contact_selected), contactSelectionViewModel.selectedContactList.size)
            contactSelectionBinding.buttonSendContact.visibility =  if (contactSelectionViewModel.selectedContactList.size > 0)
                View.VISIBLE
            else
                View.GONE

        })

        contactSectionAdapter.onContactItemClicked { item: DeviceContactModel, isSelected: Boolean ->
            contactSelectionViewModel.onContactItemClicked(item)
            if (isSelected)
                contactSelectionBinding.selectedContactsRecyclerView.scrollToPosition(contactSelectionViewModel.selectedContactList.size)
        }

        contactSectionAdapter.onContactMaxLimitReached {
            showMaxRestrictionToast(it)
        }

        contactSelectionPreviewAdapter.onContactRemoved { item ->
            contactSelectionViewModel.onContactItemClicked(item)
            contactSectionAdapter.onContactRemoved(item)
            if (searchKey.isNotBlank())
                contactSectionAdapter.filter.filter(searchKey)
        }
    }

    private fun showMaxRestrictionToast(isShow: Boolean) {
        if (isShow)
            CustomToast.show(this, String.format(getString(R.string.label_max_contact_restriction), Constants.MAX_CONTACT_SELECTION_COUNT))

    }

    private fun initViews() {
        setSupportActionBar(contactSelectionBinding.toolBar.chatToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(com.contusfly.mediapicker.R.drawable.ic_arrow_black)

        contactSelectionBinding.txt.textEmptyView.text = getString(R.string.msg_no_results)

        contactSelectionBinding.selectedContactsRecyclerView.apply {
            adapter = contactSelectionPreviewAdapter
        }

        contactSelectionBinding.contactsRecyclerView.apply {
            adapter = contactSectionAdapter
        }

        contactSelectionBinding.toolBar.textSelectedContact.text = String.format(getString(R.string.label_contact_selected), contactSelectionViewModel.selectedContactList.size)
        contactSelectionBinding.buttonSendContact.setOnClickListener {
            activityPreviewResult.launch(Intent(context, PreviewSendContactActivity::class.java)
                .putParcelableArrayListExtra(Constants.USERNAME, contactSelectionViewModel.selectedContactList as ArrayList<DeviceContactModel>))
        }
    }

    private fun getIntentData() {
        toUser = intent.getStringExtra(Constants.USER_JID) ?: Constants.EMPTY_STRING
        chatType = intent.getStringExtra(Constants.TYPE) ?: Constants.EMPTY_STRING
    }

    private var activityPreviewResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
        if (result.resultCode == Activity.RESULT_OK) {
            val contactsList: List<DeviceContactModel>
            val intent: Intent? = result.data
            contactsList = intent?.getParcelableArrayListExtra(com.mirrorflysdk.flycommons.Constants.USERNAME) ?: mutableListOf()

            val replyMessageId = ReplyHashMap.getReplyId(toUser)

            contactsList.forEach {
                val contactMessage = messagingClient.composeContactMessage(toUser, it.name, getMobileNumbers(it.mobileNumbers), replyMessageId)
                messagingClient.sendMessage(contactMessage, null)
            }
            finish()
            ReplyHashMap.saveReplyId(toUser, Constants.EMPTY_STRING)
            ChatParent.startActivity(this, toUser, chatType)
        }
    }

    private fun getMobileNumbers(mobileNumbers: MutableList<PhoneNumber>): List<String> {
        val phoneNumberList = mutableListOf<String>()
        mobileNumbers.forEach {
            phoneNumberList.add(it.phoneNumber)
        }
        return phoneNumberList
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView

        searchView.setOnSearchClickListener {
            searchView.maxWidth = Int.MAX_VALUE
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(searchString: String): Boolean {
                searchKey = searchString.trim()
                contactSectionAdapter.filter.filter(searchKey)
                return true
            }
        })
        return true
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