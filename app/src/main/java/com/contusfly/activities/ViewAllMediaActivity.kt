package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.mirrorflysdk.flycommons.ChatType
import com.contusfly.R
import com.contusfly.adapters.SectionsPagerAdapter
import com.contusfly.clearDeletedGroupChatNotification
import com.contusfly.databinding.ActivityViewAllMediaBinding
import com.contusfly.getDisplayName
import com.contusfly.models.PrivateChatAuthenticationModel
import com.contusfly.showToast
import com.contusfly.utils.Constants
import com.contusfly.utils.UserInterfaceUtils
import com.contusfly.viewmodels.ViewAllMediaViewModel
import com.contusfly.views.CustomToast
import com.mirrorflysdk.api.ChatManager
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class ViewAllMediaActivity : BaseActivity() {

    private lateinit var binding: ActivityViewAllMediaBinding

    val viewModel : ViewAllMediaViewModel by viewModels()

    /**
     * Roster id of the chat user which displaying the media
     */
    private var profileId: String? = null

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewAllMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        mToolbar = binding.toolbar
        setSupportActionBar(mToolbar)
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.color_black))
        UserInterfaceUtils.setUpToolBar(this, mToolbar, supportActionBar, Constants.EMPTY_STRING)

        profileId = intent.getStringExtra(Constants.ROSTER_JID)
        profileId?.let { viewModel.getProfileDetails(it) }
        if(ChatManager.getAvailableFeatures().isViewAllMediaEnabled){
            profileId?.let {
                viewModel.getMediaList(it)
                viewModel.getDocsList(it)
                viewModel.getLinksList(it)
            }
        } else {
            CustomToast.show(this,resources.getString(com.mirrorflysdk.R.string.fly_error_forbidden_exception))
        }

        setObservers()

    }

    private fun setObservers() {
        viewModel.profileDetail.observe(this) {
            it?.let {
                mToolbar.title = it.getDisplayName()
            }
        }
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        if (profileId == jid && status && type == ChatType.TYPE_GROUP_CHAT) {
            showToast(getString(R.string.group_block_message_label))
            startDashboardActivity()
        }
    }

    override fun onSuperAdminDeleteGroup(groupJid: String, groupName: String) {
        super.onSuperAdminDeleteGroup(groupJid, groupName)
        clearDeletedGroupChatNotification(groupJid, context)
        if (profileId == groupJid) {
            showToast(getString(R.string.deleted_by_super_admin, groupName))
            startDashboardActivity()
        }
    }

    private fun startDashboardActivity() {
        val dashboardIntent = Intent(applicationContext, DashboardActivity::class.java)
        dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(dashboardIntent)
        finish()
    }

    override fun onContactSyncComplete(isSuccess: Boolean) {
        super.onContactSyncComplete(isSuccess)
        if (isSuccess) {
            profileId?.let {
                viewModel.getProfileDetails(it)
            }
        }
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