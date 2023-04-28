package com.contusfly.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.mirrorflysdk.flycommons.Constants
import com.contusfly.R
import com.contusfly.adapters.PreviewSendContactAdapter
import com.contusfly.applySrcInColorFilter
import com.contusfly.databinding.ActivityPreviewSendContactBinding
import com.contusfly.models.DeviceContactModel
import com.contusfly.utils.UserInterfaceUtils
import com.contusfly.views.CustomAlertDialog
import com.mirrorflysdk.api.ChatManager
import com.mirrorflysdk.views.CustomToast
import java.util.ArrayList

class PreviewSendContactActivity : BaseActivity() {

    private lateinit var previewSendContactBinding: ActivityPreviewSendContactBinding

    private lateinit var contactsList: List<DeviceContactModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        previewSendContactBinding = ActivityPreviewSendContactBinding.inflate(layoutInflater)
        setContentView(previewSendContactBinding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        contactsList = intent?.getParcelableArrayListExtra(Constants.USERNAME) ?: mutableListOf()

        initViews()
    }

    private fun initViews() {
        setSupportActionBar(previewSendContactBinding.toolBar.toolbar)
        supportActionBar?.title = getString(R.string.label_send_contacts)
        UserInterfaceUtils.setUpToolBar(this, previewSendContactBinding.toolBar.toolbar, supportActionBar, getString(R.string.label_send_contacts))
        previewSendContactBinding.toolBar.toolbar.navigationIcon?.applySrcInColorFilter(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color))

        previewSendContactBinding.viewContactList.apply {
            adapter = PreviewSendContactAdapter(this@PreviewSendContactActivity, contactsList)
        }

        previewSendContactBinding.buttonSendContact.setOnClickListener {
            if (contactsList.any { !it.mobileNumbers.any {  number -> number.isSelected } }) {
                CustomToast.show(this, getString(R.string.error_select_atleast_one_number))
                return@setOnClickListener
            }
            if (!ChatManager.getAvailableFeatures().isContactAttachmentEnabled) {
                CustomAlertDialog().showFeatureRestrictionAlert(this)
                return@setOnClickListener
            }
            val selectedList = mutableListOf<DeviceContactModel>()
            contactsList.forEach {
                if (it.mobileNumbers.any { number -> number.isSelected }) {
                    it.mobileNumbers = it.mobileNumbers.filter { number -> number.isSelected }.toMutableList()
                    selectedList.add(it)
                }
            }
            if (selectedList.size > 0) {
                val intent = Intent()
                intent.putParcelableArrayListExtra(Constants.USERNAME, selectedList as ArrayList<DeviceContactModel>)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}